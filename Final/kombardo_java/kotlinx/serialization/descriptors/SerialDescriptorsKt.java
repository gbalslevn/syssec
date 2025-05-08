package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitivesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\r\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001aI\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000f2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {BuildConfig.FLAVOR, "serialName", BuildConfig.FLAVOR, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameters", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", BuildConfig.FLAVOR, "builderAction", "buildClassSerialDescriptor", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "kind", "PrimitiveSerialDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "buildSerialDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SerialDescriptorsKt {
    public static final SerialDescriptor PrimitiveSerialDescriptor(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return PrimitivesKt.PrimitiveDescriptorSafe(serialName, kind);
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String serialName, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builderAction.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, StructureKind.CLASS.INSTANCE, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), classSerialDescriptorBuilder);
    }

    public static final SerialDescriptor buildSerialDescriptor(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builder.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, kind, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), classSerialDescriptorBuilder);
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            function1 = new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    invoke2(classSerialDescriptorBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, function1);
    }
}
