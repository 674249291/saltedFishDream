package com.saltedfish.entity;

import com.saltedfish.annotation.MapperClass;
import com.saltedfish.mapper.UserMapper;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

/**
 * Created by xiongjun on 2017/8/19.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name="t_user")
@MapperClass(UserMapper.class)
public class User extends BaseEntity {

    @Column
    private String username;

    @Column
    private String pwd;

    @Column
    private Integer age;

    @Column
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
