package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcAttrTypeDef extends NcEntityWithType{
    private NcObjectType objectType;

    public NcAttrTypeDef(NcObjectType objectType) {
        this.objectType = objectType;
    }

    public NcAttrTypeDef(Integer id, String name, Integer type, NcObjectType objectType) {
        super(id, name, type);
        this.objectType = objectType;
    }
}
