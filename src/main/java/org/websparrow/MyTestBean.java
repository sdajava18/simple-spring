package org.websparrow;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyTestBean implements IMyTestBean, InitializingBean, DisposableBean {

    @Override
    public String toUpperCase(String text){
        return text.toUpperCase();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("This is destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("This is after initialization method");
    }
}
