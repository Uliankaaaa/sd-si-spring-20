package com.netcracker.ec.model.db;

import lombok.*;

@Getter
@Setter
public class NcEntity {
    private Integer id;
    private String name;

    public NcEntity() {
    }

    public NcEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}