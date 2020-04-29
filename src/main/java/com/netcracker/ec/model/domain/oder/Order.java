package com.netcracker.ec.model.domain.oder;

import com.netcracker.ec.model.db.NcAttribute;
import com.netcracker.ec.model.db.NcObject;
import com.netcracker.ec.model.db.NcObjectType;
import java.util.HashMap;
import java.util.Map;

public class Order extends NcObject {
    Map<NcAttribute, String> parameters;

    public Order(NcObjectType objectType) {
        super(objectType);
        this.parameters = new HashMap<>();
    }

    public Order(Integer id, String name, NcObjectType objectType) {
        super(id, name, objectType);
        this.parameters = new HashMap<>();
    }

    public Map<NcAttribute, String> getParameters() {
        return parameters;
    }
}
