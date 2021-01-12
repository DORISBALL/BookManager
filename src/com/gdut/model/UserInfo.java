package com.gdut.model;

import lombok.Data;

/**
 * @author <a href="mailto:yozyyyqls@163.com">Shelley-Qiu</a>
 * @description 用户信息
 * @create 2021-01-13
 */
@Data
public class UserInfo {
    private String userId;
    private String username;
    private String sex;
    private int age;
    private float account;
}
