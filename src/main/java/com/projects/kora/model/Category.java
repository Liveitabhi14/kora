package com.projects.kora.model;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bitmapId;

    @Column (name = "cat_name",nullable = false)
    private String catName;

    public int getBitmapId() {
        return bitmapId;
    }

    public void setBitmapId(int bitmapId) {
        this.bitmapId = bitmapId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
