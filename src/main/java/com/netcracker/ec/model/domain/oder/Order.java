package com.netcracker.ec.model.domain.oder;

import com.netcracker.ec.model.db.NcAttribute;
import com.netcracker.ec.model.db.NcObject;
import com.netcracker.ec.model.db.NcObjectType;

import java.util.Set;

public class Order extends NcObject {
    private Set<NcAttribute> attributes;

    public Order(NcObjectType objectType){
        super(objectType);
    }

    public Order(Integer id, String name, NcObjectType objectType, String description) {
        super(id, name, objectType, description);
    }
}
