package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NcObject extends NcEntityWithDescription {
    private NcObjectType objectType;

    public NcObject(NcObjectType objectType) {
        this.objectType = objectType;
    }

    public NcObject(Integer id, String name, String description, NcObjectType objectType) {
        super(id, name, description);
        this.objectType = objectType;
    }
}
