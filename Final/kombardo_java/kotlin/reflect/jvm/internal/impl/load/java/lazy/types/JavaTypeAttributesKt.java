package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* loaded from: classes3.dex */
public abstract class JavaTypeAttributesKt {
    public static final JavaTypeAttributes toAttributes(TypeUsage typeUsage, boolean z5, boolean z6, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "<this>");
        return new JavaTypeAttributes(typeUsage, null, z6, z5, typeParameterDescriptor != null ? SetsKt.setOf(typeParameterDescriptor) : null, null, 34, null);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z5, boolean z6, TypeParameterDescriptor typeParameterDescriptor, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        if ((i5 & 4) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z5, z6, typeParameterDescriptor);
    }
}
