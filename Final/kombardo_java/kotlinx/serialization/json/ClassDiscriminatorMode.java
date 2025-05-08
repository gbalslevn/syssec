package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/ClassDiscriminatorMode;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "NONE", "ALL_JSON_OBJECTS", "POLYMORPHIC", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClassDiscriminatorMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassDiscriminatorMode[] $VALUES;
    public static final ClassDiscriminatorMode NONE = new ClassDiscriminatorMode("NONE", 0);
    public static final ClassDiscriminatorMode ALL_JSON_OBJECTS = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
    public static final ClassDiscriminatorMode POLYMORPHIC = new ClassDiscriminatorMode("POLYMORPHIC", 2);

    private static final /* synthetic */ ClassDiscriminatorMode[] $values() {
        return new ClassDiscriminatorMode[]{NONE, ALL_JSON_OBJECTS, POLYMORPHIC};
    }

    static {
        ClassDiscriminatorMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ClassDiscriminatorMode(String str, int i5) {
    }

    public static ClassDiscriminatorMode valueOf(String str) {
        return (ClassDiscriminatorMode) Enum.valueOf(ClassDiscriminatorMode.class, str);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) $VALUES.clone();
    }
}
