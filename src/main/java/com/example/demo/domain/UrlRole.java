package com.example.demo.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

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
    private Integer role_id;
    @Column
    private Integer url_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getUrl_id() {
        return url_id;
    }

    public void setUrl_id(Integer url_id) {
        this.url_id = url_id;
    }

    @Override
    public String toString() {
        return "UrlRole{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", url_id=" + url_id +
                '}';
    }
}
