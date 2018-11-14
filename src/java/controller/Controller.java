/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Shado
 */
public class Controller extends SimpleTagSupport {

    private String className;
    private String methodName;
    private String params;
    private String returnedAttribute;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            try {
                if (params == null || params.trim().isEmpty()) {
                    Class<?> c = Class.forName(className);
                    Method method = c.getDeclaredMethod(methodName, (Class<?>[]) null);

                    if (returnedAttribute == null || returnedAttribute.trim().isEmpty()) {
                        method.invoke(c.newInstance(), (Object[]) null);
                    } else {
                        Object resultReturned = method.invoke(c.newInstance(), (Object[]) null);
                        getJspContext().setAttribute(this.returnedAttribute, resultReturned, 1);
                    }
                } else {
                    String[] parameters = params.split(",");
                    for (int i = 0, size = parameters.length; i < size; i++) {
                        parameters[i] = parameters[i].trim();
                    }

                    if (parameters.length == 1) {
                        Class<?> c = Class.forName(className);
                        Class[] argTypes = new Class[]{String.class};
                        Method method = c.getDeclaredMethod(methodName, argTypes);
                        if (returnedAttribute == null || returnedAttribute.trim().isEmpty()) {
                            method.invoke(c.newInstance(), parameters[0]);
                        } else {
                            Object resultReturned = method.invoke(c.newInstance(), parameters[0]);
                            getJspContext().setAttribute(this.returnedAttribute, resultReturned, 1);
                        }
                    } else {
                        Class<?> c = Class.forName(className);
                        Class[] argTypes = new Class[]{String[].class};
                        Method method = c.getDeclaredMethod(methodName, argTypes);
                        if (returnedAttribute == null || returnedAttribute.trim().isEmpty()) {
                            method.invoke(c.newInstance(), (Object[]) parameters);
                        } else {
                            Object resultReturned = method.invoke(c.newInstance(), (Object[]) parameters);
                            getJspContext().setAttribute(this.returnedAttribute, resultReturned, 1);
                        }
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | 
                    InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                System.err.println(e);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Controller tag", ex);
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setReturnedAttribute(String returnedAttribute) {
        this.returnedAttribute = returnedAttribute;
    }

}