package kotlin.reflect.jvm.internal;

/* loaded from: classes3.dex */
abstract class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
