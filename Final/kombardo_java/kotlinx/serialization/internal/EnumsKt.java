package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0005\u001a;\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001aq\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00040\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "T", BuildConfig.FLAVOR, "serialName", BuildConfig.FLAVOR, "values", "Lkotlinx/serialization/KSerializer;", "createSimpleEnumSerializer", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "names", BuildConfig.FLAVOR, "entryAnnotations", "classAnnotations", "createAnnotatedEnumSerializer", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class EnumsKt {
    public static final <T extends Enum<T>> KSerializer<T> createAnnotatedEnumSerializer(String serialName, T[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(entryAnnotations, "entryAnnotations");
        EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                enumDescriptor.pushClassAnnotation(annotation);
            }
        }
        int length = values.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            T t5 = values[i5];
            int i7 = i6 + 1;
            String str = (String) ArraysKt.getOrNull(names, i6);
            if (str == null) {
                str = t5.name();
            }
            PluginGeneratedSerialDescriptor.addElement$default(enumDescriptor, str, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) ArraysKt.getOrNull(entryAnnotations, i6);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    enumDescriptor.pushAnnotation(annotation2);
                }
            }
            i5++;
            i6 = i7;
        }
        return new EnumSerializer(serialName, values, enumDescriptor);
    }

    public static final <T extends Enum<T>> KSerializer<T> createSimpleEnumSerializer(String serialName, T[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(serialName, values);
    }
}
