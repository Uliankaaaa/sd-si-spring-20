package com.netcracker.ec.model.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NcEntityWithType extends NcEntity {
    private Integer type;

    public NcEntityWithType() {
    }

    public NcEntityWithType(Integer id, String name, Integer type) {
        super(id, name);
        this.type = type;
    }
}
