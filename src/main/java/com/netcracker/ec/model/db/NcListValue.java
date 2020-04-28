package com.netcracker.ec.model.db;

public class NcListValue extends NcEntity {
    private NcAttrTypeDef attrTypeDef;

    public NcListValue(NcAttrTypeDef attrTypeDef) {
        this.attrTypeDef = attrTypeDef;
    }

    public NcListValue(Integer id, String name, NcAttrTypeDef attrTypeDef) {
        super(id, name);
        this.attrTypeDef = attrTypeDef;
    }
}
