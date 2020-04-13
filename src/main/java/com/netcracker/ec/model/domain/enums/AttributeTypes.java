package com.netcracker.ec.model.domain.enums;

import com.netcracker.ec.model.db.NcAttribute;

public enum AttributeTypes {
    TEXT(0, "Text"),
    NUMBER(2, "Number"),
    DECIMAL(3, "Decimal"),
    DATE(4, "Date"),
    LIST(6, "List"),
    REFERENCE(9, "Reference");

    private Integer id;
    private String type;

    AttributeTypes(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
