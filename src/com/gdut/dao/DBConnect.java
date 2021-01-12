package com.gdut.dao;

/**
 * @author <a href="mailto:yozyyyqls@163.com">Shelley-Qiu</a>
 * @description Using to connect to data base
 * @create 2021-01-11
 */
public class DBConnect {
    public static final String SCHEMA_NAME = "normalinfo";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3307/" + SCHEMA_NAME + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123";
}
