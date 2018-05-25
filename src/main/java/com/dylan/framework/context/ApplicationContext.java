package com.dylan.framework.context;

import com.dylan.framework.beans.BeanDefinition;
import com.dylan.framework.context.support.BeanDefinitionReader;
import com.dylan.framework.core.BeanFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Dylan.c
 * @Date: 2018/5/24 上午12:58
 */
public class ApplicationContext implements BeanFactory {

    private String[] configLocations;
    private BeanDefinitionReader reader;

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public ApplicationContext(String ... locations){
        configLocations = locations;
        refresh();
    }

    public void refresh(){
        // locate
        reader = new BeanDefinitionReader(configLocations);

        // loading
        List<String> beanDefitions = reader.loadBeanDefinitions();

        // register
        doRegistry(beanDefitions);

        // dependency inject


    }

    private void doRegistry(List<String> beanDefitions) {

    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
