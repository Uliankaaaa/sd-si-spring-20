package com.netcracker.ec.model.db;

public class NcObjectType extends NcEntity {
    private Integer parentId;

    public NcObjectType() {
    }

    public NcObjectType(Integer id, String name, Integer parentId) {
        super(id, name);
        this.parentId = parentId;
    }
}
