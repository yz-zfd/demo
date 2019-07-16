package com.example.demo.domain;


import javax.persistence.*;

/**
 * @author zfd
 */

@Entity
@Table(name="user")
public class User {
    /**
     * @id 用户id
     * @username 用户名称
     * @password 用户密码
     * @driverInfoId 驾驶员信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Integer driverInfoId;

    @Column
    private String role;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
        return driverInfoId;
    }
    public void setDriverInfoId(Integer driverInfoId) {
        this.driverInfoId = driverInfoId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverInfoId=" + driverInfoId +
                ", role='" + role + '\'' +
                '}';
    }
}
