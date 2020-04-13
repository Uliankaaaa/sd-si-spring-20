package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcEntityWithDescription extends NcEntity{
    private String description;

    public NcEntityWithDescription() {
    }

    public NcEntityWithDescription(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }
}
