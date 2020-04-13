package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcAttrObjectTypes {
    private NcAttribute attribute;
    private NcObjectType objectType;

    private NcAttrObjectTypes() {
    }

    public NcAttrObjectTypes(NcAttribute attribute, NcObjectType objectType) {
        this.attribute = attribute;
        this.objectType = objectType;
    }
}
