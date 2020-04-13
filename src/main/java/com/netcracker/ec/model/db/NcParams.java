package com.netcracker.ec.model.db;

public class NcParams extends NcObjectAndAttr {
    private NcListValue listValue;
    private String value;

    public NcParams(NcListValue listValue, String value) {
        this.listValue = listValue;
        this.value = value;
    }

    public NcParams(NcObject object, NcAttribute attribute, NcListValue listValue, String value) {
        super(object, attribute);
        this.listValue = listValue;
        this.value = value;
    }
}
