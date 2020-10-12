package com.bitmascot.webportal.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Users")
public class Users {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String user_name;
    @Column(name="phone")
    private  String phone;
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", phone='" + phone + '\'' +
                ", mailid='" + mailid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Column(name="mailid")
    private String mailid;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return mailid;
    }

    public void setEmail(String mailid) {
        this.mailid = mailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="password")
    private  String password;







}
