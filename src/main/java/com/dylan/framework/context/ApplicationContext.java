package com.dylan.framework.context;

import com.dylan.framework.core.BeanFactory;

/**
 * @Author: Dylan.c
 * @Date: 2018/5/24 上午12:58
 */
public class ApplicationContext implements BeanFactory {

    private String[] configLocations;

    public ApplicationContext(String ... locations){
        configLocations = locations;
        refresh();
    }

    public void refresh(){

    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
