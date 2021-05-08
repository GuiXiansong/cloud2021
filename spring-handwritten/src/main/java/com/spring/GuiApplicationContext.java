package com.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuiApplicationContext {
    private Class configClass;
    private ConcurrentHashMap<String, Object> singletonsObjects = new ConcurrentHashMap<>();//单列池
    private ConcurrentHashMap<String, GuiBeandefinition> map = new ConcurrentHashMap<>();
    private List<GuiBeanPostProcessor> guiBeanPostProcessors=new ArrayList<>();

    public GuiApplicationContext(Class configClass) {
        this.configClass = configClass;
        scan(configClass);

        System.out.println("scan=================================");
        singletonsObjects.forEach((string, object) -> {
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + "------------------");
            System.out.println(string + "----------------------" + object.toString());
        });

        map.forEach((string, beandefitition) -> {
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
            System.out.println(string + "---------------" + beandefitition.toString());
        });


        for (Map.Entry<String, GuiBeandefinition> entry : map.entrySet()) {
            String beanName = entry.getKey();
            GuiBeandefinition g = entry.getValue();
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() +
                    "beanName:::::" + beanName +
                    "g:::::::::" + g.toString());
            if (g.getScope().equals("singleton")) {
                Object bean = createBean(beanName,g);//单例bean对象
                System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
                singletonsObjects.put(beanName, bean);
                System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
                singletonsObjects.forEach((string, object) -> {
                    System.out.println(string + "-----" + object);
                });
            }
        }
    }

    public Object createBean(String beanName,GuiBeandefinition guiBeandefinition) {
        Class clazz = guiBeandefinition.getClazz();
        try {
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + "---");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + "---" + clazz.getDeclaredFields().length);

            //依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(GuiAutowired.class)) {
                    System.out.println(declaredField.getName());
                    Object bean = getBean(declaredField.getName());
                    System.out.println(bean);
                    declaredField.setAccessible(true);
                    declaredField.set(instance, bean);
                }
            }

            //Aware回调
            if (instance instanceof GuiBeanNameAware){
                ((GuiBeanNameAware) instance).setBeanName(beanName);
            }

            for (GuiBeanPostProcessor guiBeanPostProcessor : guiBeanPostProcessors) {
                instance = guiBeanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            //初始化
            if (instance instanceof GuiInitializingBean){
                ((GuiInitializingBean) instance).afterPropertiesSet();
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 扫描GuiComponentScan注解----》获取类的路径--》将bean放入GuiBeandefinition--->放入map中
     *
     * @param configClass
     */
    private void scan(Class configClass) {
        //解析配置类
        GuiComponentScan guiComponentScan = (GuiComponentScan) configClass.getDeclaredAnnotation(GuiComponentScan.class);
        String path = guiComponentScan.value();//扫描路径com.gui.service
        System.out.println(path);

        //扫描
        //Bootstrap--------->jre/lib
        //Ext---------------->jre/ext/lib
        //App---------------->classpath------>项目对应的路径
        ClassLoader classLoader = GuiApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource("com/gui/service");
        System.out.println(resource);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println(f);
                String absolutePath = f.getAbsolutePath();
                System.out.println(absolutePath);
                //判断该文件是不是  .class 文件
                if (absolutePath.endsWith(".class")) {
                    //获取可以 类加载  的路径
                    String fileUrl = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    System.out.println(fileUrl);

                    String fileUrlLoad = fileUrl.replace("\\", ".");
                    System.out.println(fileUrlLoad);

                    try {
                        Class<?> aClass = classLoader.loadClass(fileUrlLoad);
                        if (aClass.isAnnotationPresent(GuiComponent.class)) {
                            System.out.println("该类上有GuiComponent注解");
                            if (GuiBeanPostProcessor.class.isAssignableFrom(aClass)) {
                                GuiBeanPostProcessor instance = (GuiBeanPostProcessor) aClass.getDeclaredConstructor().newInstance();
                                guiBeanPostProcessors.add(instance);
                            }

                            //表明当前类是一个bean
                            //解析类，判断当前类是单例bean，还是prototype的bean
                            GuiComponent guiComponent = aClass.getDeclaredAnnotation(GuiComponent.class);
                            String beanName = guiComponent.value();

                            GuiBeandefinition guiBeandefinition = new GuiBeandefinition();
                            guiBeandefinition.setClazz(aClass);
                            if (aClass.isAnnotationPresent(GuiScope.class)) {
                                GuiScope guiScope = aClass.getDeclaredAnnotation(GuiScope.class);
                                String gValue = guiScope.value();
                                System.out.println("gValue======================" + gValue);
                                guiBeandefinition.setScope(gValue);
                            } else {
                                guiBeandefinition.setScope("singleton");
                            }
                            map.put(beanName, guiBeandefinition);
                        }

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        //判断map中是否有该名称的bean
        if (map.containsKey(beanName)) {
            GuiBeandefinition guiBeandefinition = map.get(beanName);
            String scope = guiBeandefinition.getScope();
            if (scope.equals("singleton")) {
                return singletonsObjects.get(beanName);
            } else {
                //创建bean对象
                Object bean = createBean(beanName,guiBeandefinition);
                return bean;
            }
        } else {
            throw new NullPointerException();
        }
    }
}
