package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcAttribute extends NcEntityWithType{
    private NcAttrTypeDef attrTypeDef;

    public NcAttribute(NcAttrTypeDef attrTypeDef) {
        this.attrTypeDef = attrTypeDef;
    }

    public NcAttribute(Integer id, String name, Integer type, NcAttrTypeDef attrTypeDef) {
        super(id, name, type);
        this.attrTypeDef = attrTypeDef;
    }
}
