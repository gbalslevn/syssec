package com.ramcosta.composedestinations.navargs.primitives;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a-\u0010\u0005\u001a\u00028\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {BuildConfig.FLAVOR, "E", "Ljava/lang/Class;", BuildConfig.FLAVOR, "enumValueName", "valueOfIgnoreCase", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommonConstantsKt {
    public static final <E extends Enum<?>> E valueOfIgnoreCase(Class<E> cls, String enumValueName) {
        E e5;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(enumValueName, "enumValueName");
        E[] enumConstants = cls.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "getEnumConstants(...)");
        int length = enumConstants.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                e5 = null;
                break;
            }
            e5 = enumConstants[i5];
            if (StringsKt.equals(e5.name(), enumValueName, true)) {
                break;
            }
            i5++;
        }
        E e6 = e5;
        if (e6 != null) {
            return e6;
        }
        throw new IllegalArgumentException("Enum value " + enumValueName + " not found for type " + cls.getName() + '.');
    }
}
