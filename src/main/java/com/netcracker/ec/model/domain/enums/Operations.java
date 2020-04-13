package com.netcracker.ec.model.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operations {
    CREATE("1", "Create Order"),
    SHOW_ORDERS("2", "Show Orders");

    private String id;
    private String name;

    Operations(String id, String name) {
        this.id = id;
        this.name = name;
    }
}