package com.sun.jna.ptr;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/* loaded from: classes2.dex */
public abstract class ByReference extends PointerType {
    /* JADX INFO: Access modifiers changed from: protected */
    public ByReference(int i5) {
        setPointer(new Memory(i5));
    }

    @Override // com.sun.jna.PointerType
    public String toString() {
        try {
            Object invoke = getClass().getMethod("getValue", null).invoke(this, null);
            return invoke == null ? String.format("null@0x%x", Long.valueOf(Pointer.nativeValue(getPointer()))) : String.format("%s@0x%x=%s", invoke.getClass().getSimpleName(), Long.valueOf(Pointer.nativeValue(getPointer())), invoke);
        } catch (Exception e5) {
            return String.format("ByReference Contract violated - %s#getValue raised exception: %s", getClass().getName(), e5.getMessage());
        }
    }
}
