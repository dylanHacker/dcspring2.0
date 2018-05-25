package com.dylan.framework.beans;

/**
 * @Author: Dylan.c
 * @Date: 2018/5/24 上午1:14
 */
// to store the information in config file into RAM
public class BeanDefinition {

    private String beanClassName;

    private String factoryBeanName;

    private boolean lazyInit;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
