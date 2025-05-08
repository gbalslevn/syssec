package com.sdk.growthbook.evaluators;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sdk/growthbook/evaluators/GBAttributeType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "GbString", "GbNumber", "GbBoolean", "GbArray", "GbObject", "GbNull", "GbUnknown", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class GBAttributeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GBAttributeType[] $VALUES;
    public static final GBAttributeType GbString = new GBAttributeType("GbString", 0) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbString
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "string";
        }
    };
    public static final GBAttributeType GbNumber = new GBAttributeType("GbNumber", 1) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbNumber
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "number";
        }
    };
    public static final GBAttributeType GbBoolean = new GBAttributeType("GbBoolean", 2) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbBoolean
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "boolean";
        }
    };
    public static final GBAttributeType GbArray = new GBAttributeType("GbArray", 3) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbArray
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "array";
        }
    };
    public static final GBAttributeType GbObject = new GBAttributeType("GbObject", 4) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbObject
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "object";
        }
    };
    public static final GBAttributeType GbNull = new GBAttributeType("GbNull", 5) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbNull
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "null";
        }
    };
    public static final GBAttributeType GbUnknown = new GBAttributeType("GbUnknown", 6) { // from class: com.sdk.growthbook.evaluators.GBAttributeType.GbUnknown
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "unknown";
        }
    };

    private static final /* synthetic */ GBAttributeType[] $values() {
        return new GBAttributeType[]{GbString, GbNumber, GbBoolean, GbArray, GbObject, GbNull, GbUnknown};
    }

    static {
        GBAttributeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public /* synthetic */ GBAttributeType(String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i5);
    }

    public static EnumEntries<GBAttributeType> getEntries() {
        return $ENTRIES;
    }

    public static GBAttributeType valueOf(String str) {
        return (GBAttributeType) Enum.valueOf(GBAttributeType.class, str);
    }

    public static GBAttributeType[] values() {
        return (GBAttributeType[]) $VALUES.clone();
    }

    private GBAttributeType(String str, int i5) {
    }
}
