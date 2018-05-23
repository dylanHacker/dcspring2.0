package com.dylan.framework.webmvc.servlet;

import com.dylan.framework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Dylan.c
 * @Date: 2018/5/24 上午12:52
 */
public class DispatcherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private Map<String, Object> beanDefinitionMap = new ConcurrentHashMap<String, Object>();

    private List<String> classNames = new ArrayList<String>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ApplicationContext();
    }
}
