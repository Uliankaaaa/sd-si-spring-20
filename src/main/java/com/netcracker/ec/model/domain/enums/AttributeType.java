package com.netcracker.ec.model.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum AttributeType {
    TEXT(0, "Text"),
    NUMBER(2, "Number"),
    DECIMAL(3, "Decimal"),
    DATE(4, "Date"),
    LIST(6, "List"),
    REFERENCE(9, "Reference");

    private Integer id;
    private String type;

    AttributeType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return id + " - " + type;
    }

    public static AttributeType getAttributeById(Integer id) {
        for (AttributeType value : values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }
        return null;
    }
}
