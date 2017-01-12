package org.carteiralivre.carteiralivre.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Long id;
    private String name;
    private String description;

    /* meta-data */
    private Date insertiondDate;
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInsertiondDate() {
        return insertiondDate;
    }

    public void setInsertiondDate(Date insertiondDate) {
        this.insertiondDate = insertiondDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
