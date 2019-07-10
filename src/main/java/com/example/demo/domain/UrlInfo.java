package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author zff
 *
 */
@Entity
@Table(name="url")
public class UrlInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String url;

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

    @Override
    public String toString() {
        return "UrlInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
