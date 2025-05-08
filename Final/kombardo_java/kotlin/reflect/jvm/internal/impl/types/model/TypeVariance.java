package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TypeVariance {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeVariance[] $VALUES;
    private final String presentation;
    public static final TypeVariance IN = new TypeVariance("IN", 0, "in");
    public static final TypeVariance OUT = new TypeVariance("OUT", 1, "out");
    public static final TypeVariance INV = new TypeVariance("INV", 2, BuildConfig.FLAVOR);

    private static final /* synthetic */ TypeVariance[] $values() {
        return new TypeVariance[]{IN, OUT, INV};
    }

    static {
        TypeVariance[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private TypeVariance(String str, int i5, String str2) {
        this.presentation = str2;
    }

    public static TypeVariance valueOf(String str) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, str);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
