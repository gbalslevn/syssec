package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class TypeCapabilitiesKt {
    public static final CustomTypeParameter getCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Object unwrap = kotlinType.unwrap();
        CustomTypeParameter customTypeParameter = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (customTypeParameter == null || !customTypeParameter.isTypeParameter()) {
            return null;
        }
        return customTypeParameter;
    }

    public static final boolean isCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Object unwrap = kotlinType.unwrap();
        CustomTypeParameter customTypeParameter = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (customTypeParameter != null) {
            return customTypeParameter.isTypeParameter();
        }
        return false;
    }
}
