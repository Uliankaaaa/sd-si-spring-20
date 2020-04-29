package com.netcracker.ec.model.db;

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
