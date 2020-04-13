package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcObjectAndAttr {
    private NcObject object;
    private NcAttribute attribute;

    public NcObjectAndAttr(){
    }

    public NcObjectAndAttr(NcObject object, NcAttribute attribute) {
        this.object = object;
        this.attribute = attribute;
    }
}
