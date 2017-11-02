package com.saltedfish.web.conf;

import com.sun.deploy.model.Resource;
import org.springframework.beans.factory.annotation.Value;


/**
 * Created by Administrator on 2017/10/31.
 */

public class SpringEl {

    @Value("xiongjun")
    private String name;

    @Value("25")
    private String age;

    @Value("http://www.baidu.com")
    private Resource email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Resource getEmail() {
        return email;
    }

    public void setEmail(Resource email) {
        this.email = email;
    }


}
