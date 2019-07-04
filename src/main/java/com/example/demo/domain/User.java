package com.example.demo.domain;


import javax.persistence.*;

/**
 * @author zfd
 */

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Integer DriverInfoId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDriverInfoId() {
        return DriverInfoId;
    }

    public void setDriverInfoId(Integer driverInfoId) {
        DriverInfoId = driverInfoId;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DriverInfoId=" + DriverInfoId +
                '}';
    }
}
