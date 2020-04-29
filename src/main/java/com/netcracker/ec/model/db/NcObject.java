package com.netcracker.ec.model.db;

public class NcObject extends NcEntity {
    private NcObjectType objectType;

    public NcObject(NcObjectType objectType) {
        this.objectType = objectType;
    }

    public NcObject(Integer id, String name, NcObjectType objectType) {
        super(id, name);
        this.objectType = objectType;
    }

    public NcObjectType getObjectType() {
        return objectType;
    }
}
