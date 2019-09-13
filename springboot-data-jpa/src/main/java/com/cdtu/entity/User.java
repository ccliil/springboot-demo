package com.cdtu.entity;


import javax.persistence.*;

@Entity  //告诉JPA这是一个实体类
@Table(name = "tab_user")//与数据库中的表进行对应，没有表会能帮我们创建，如果没有name则默认为uesr
public class User {
    @Id//标识主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//让主键自增
    private Integer id;
    @Column(name = "name", length = 15)//标识并映射数据库中的属性，name为空默认为name
    private String name;
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
