package com.in28minutes.rest.webservices.restful_web_services.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Concert 类是一个 JPA 实体，JPA 会将这个类映射到数据库中的表
// Spring Data JPA 可以管理这个类的实例，并将其与数据库中的记录相关联
@Entity 
@Table(name = "image")  
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "description")
    private String description; // 图像的描述

    @Column(name = "type") // 图像的类型，如 "news" 或 "ticket"
    private String type;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
