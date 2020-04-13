package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcReference extends NcObjectAndAttr{
    private Integer refefence;

    public NcReference(){
    }

    public NcReference(NcObject object, NcAttribute attribute, Integer refefence) {
        super(object, attribute);
        this.refefence = refefence;
    }
}
