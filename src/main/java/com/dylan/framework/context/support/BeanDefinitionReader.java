package com.dylan.framework.context.support;

import com.dylan.framework.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: Dylan.c
 * @Date: 2018/5/24 上午1:11
 */
public class BeanDefinitionReader {

    private final String SCAN_PKG = "scanPackage";

    private Properties config = new Properties();

    private List<String> registryBeanClasses = new ArrayList<String>();

    public BeanDefinitionReader(String... locations) {
        // search and locate file by a Reader Object in Spring

        InputStream ins = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));

        try {
            config.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        doScanner(config.getProperty(SCAN_PKG));
    }

    public List<String> loadBeanDefinitions() {
        return registryBeanClasses;
    }

    public BeanDefinition registryBean(String className) {
        if (registryBeanClasses.contains(className)) {
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(lowerCaseFirst(className.substring(className.indexOf(".") + 1)));
        }

        return null;
    }

    private void doScanner(String pkgName) {
        URL url = this.getClass().getClassLoader().getResource("/" + pkgName.replaceAll("\\.", "/"));

        if (url != null) {
            File classDir = new File(url.getFile());

            for (File file : classDir.listFiles()) {
                if (file.isDirectory()) {
                    doScanner(pkgName + "." + file.getName());
                } else {
                    registryBeanClasses.add(pkgName + "." + file.getName().replace(".class", ""));
                }
            }
        } else {
            throw new IllegalArgumentException(pkgName + "package name can't be null");
        }

    }

    public Properties getConfig() {
        return config;
    }

    private String lowerCaseFirst(String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        char[] chars = str.toCharArray();
        if (chars[0] < 'a') {
            chars[0] += 32;
        }
        return String.valueOf(chars);
    }
}
