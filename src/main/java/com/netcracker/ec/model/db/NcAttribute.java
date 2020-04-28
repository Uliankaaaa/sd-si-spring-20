package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcAttribute extends NcEntity {
    private NcAttrTypeDef attrTypeDef;

    public NcAttribute(NcAttrTypeDef attrTypeDef) {
        this.attrTypeDef = attrTypeDef;
    }

    public NcAttribute(Integer id, String name, NcAttrTypeDef attrTypeDef) {
        super(id, name);
        this.attrTypeDef = attrTypeDef;
    }

    public NcAttrTypeDef getAttrTypeDef() {
        return attrTypeDef;
    }
}
