package com.sun.jna;

import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class StructureWriteContext extends ToNativeContext {
    private Field field;
    private Structure struct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructureWriteContext(Structure structure, Field field) {
        this.struct = structure;
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    public Structure getStructure() {
        return this.struct;
    }
}
