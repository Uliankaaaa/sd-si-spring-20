package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcObjectType extends NcEntityWithDescription {
    private Integer parentId;

    public NcObjectType() {
    }

    public NcObjectType(Integer id, String name, String description, Integer parentId) {
        super(id, name, description);
        this.parentId = parentId;
    }
}
