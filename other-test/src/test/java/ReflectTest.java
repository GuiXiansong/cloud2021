import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(inputStream);

        String person = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class personClass = Class.forName(person);
        Object o = personClass.newInstance();
//            Method method = personClass.getMethod(methodName);
        Method method = personClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
}
