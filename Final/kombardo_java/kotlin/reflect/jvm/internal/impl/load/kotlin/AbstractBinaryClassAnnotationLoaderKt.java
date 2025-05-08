package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationLoaderKt {
    public static final MemberSignature getPropertySignature(ProtoBuf$Property proto, NameResolver nameResolver, TypeTable typeTable, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z5) {
            JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(proto, nameResolver, typeTable, z7);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z6 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        }
        MemberSignature.Companion companion = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
        Intrinsics.checkNotNullExpressionValue(syntheticMethod, "getSyntheticMethod(...)");
        return companion.fromMethod(nameResolver, syntheticMethod);
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        boolean z8 = (i5 & 8) != 0 ? false : z5;
        boolean z9 = (i5 & 16) != 0 ? false : z6;
        if ((i5 & 32) != 0) {
            z7 = true;
        }
        return getPropertySignature(protoBuf$Property, nameResolver, typeTable, z8, z9, z7);
    }
}
