package com.spring;

public class GuiBeandefinition {
    private Class clazz;
    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public GuiBeandefinition() {
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public GuiBeandefinition(Class clazz, String scope) {
        this.clazz = clazz;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "GuiBeandefinition{" +
                "clazz=" + clazz +
                ", scope='" + scope + '\'' +
                '}';
    }
}
