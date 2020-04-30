package org.websparrow;

import org.springframework.beans.factory.InitializingBean;

public class MyTestBean implements InitializingBean {

    public String toUpperCase(String s){
        return s.toUpperCase();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(MyTestBean.class.getSimpleName() +  " afterPropertiesSet");
    }
}
