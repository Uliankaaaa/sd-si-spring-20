package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcAttrTypeDef {
    private Integer id;
    private NcObjectType objectType;
    private Integer type;

    public NcAttrTypeDef(Integer id, NcObjectType objectType, Integer type) {
        this.id = id;
        this.objectType = objectType;
        this.type = type;
    }

    public NcObjectType getObjectType() {
        return objectType;
    }

    public Integer getType() {
        return type;
    }
}
