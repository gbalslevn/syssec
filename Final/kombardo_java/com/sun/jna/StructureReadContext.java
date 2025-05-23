package com.sun.jna;

import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class StructureReadContext extends FromNativeContext {
    private Field field;
    private Structure structure;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructureReadContext(Structure structure, Field field) {
        super(field.getType());
        this.structure = structure;
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    public Structure getStructure() {
        return this.structure;
    }
}
