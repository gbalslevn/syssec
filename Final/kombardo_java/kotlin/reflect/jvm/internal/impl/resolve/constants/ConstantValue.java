package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes3.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public ConstantValue(T t5) {
        this.value = t5;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T value = getValue();
            ConstantValue constantValue = obj instanceof ConstantValue ? (ConstantValue) obj : null;
            if (!Intrinsics.areEqual(value, constantValue != null ? constantValue.getValue() : null)) {
                return false;
            }
        }
        return true;
    }

    public abstract KotlinType getType(ModuleDescriptor moduleDescriptor);

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T value = getValue();
        if (value != null) {
            return value.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
