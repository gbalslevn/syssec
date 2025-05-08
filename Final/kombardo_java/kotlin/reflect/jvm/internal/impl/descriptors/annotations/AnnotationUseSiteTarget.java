package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class AnnotationUseSiteTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES;
    private final String renderName;
    public static final AnnotationUseSiteTarget FIELD = new AnnotationUseSiteTarget("FIELD", 0, null, 1, null);
    public static final AnnotationUseSiteTarget FILE = new AnnotationUseSiteTarget("FILE", 1, null, 1, null);
    public static final AnnotationUseSiteTarget PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 2, null, 1, null);
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, "get");
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
    public static final AnnotationUseSiteTarget RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 5, null, 1, null);
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, "param");
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    static {
        AnnotationUseSiteTarget[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AnnotationUseSiteTarget(String str, int i5, String str2) {
        this.renderName = str2 == null ? CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name()) : str2;
    }

    public static AnnotationUseSiteTarget valueOf(String str) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, str);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i5, String str2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i5, (i6 & 1) != 0 ? null : str2);
    }
}
