package com.pojo;

import org.springframework.beans.factory.FactoryBean;

public class FactoryUserBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
