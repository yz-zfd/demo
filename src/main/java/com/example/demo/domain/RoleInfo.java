package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author zff
 *
 */
@Entity
@Table(name="role")
public class RoleInfo {
    /**
     * @id 角色id值
     * @role 角色
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
