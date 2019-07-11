package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author zff
 *
 */
@Entity
@Table(name="url_role")
public class UrlRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String url;
    @Column
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UrlRole{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
