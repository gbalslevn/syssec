package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class UnsignedType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        ClassId.Companion companion = ClassId.Companion;
        UBYTE = new UnsignedType("UBYTE", 0, ClassId.Companion.fromString$default(companion, "kotlin/UByte", false, 2, null));
        USHORT = new UnsignedType("USHORT", 1, ClassId.Companion.fromString$default(companion, "kotlin/UShort", false, 2, null));
        UINT = new UnsignedType("UINT", 2, ClassId.Companion.fromString$default(companion, "kotlin/UInt", false, 2, null));
        ULONG = new UnsignedType("ULONG", 3, ClassId.Companion.fromString$default(companion, "kotlin/ULong", false, 2, null));
        UnsignedType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private UnsignedType(String str, int i5, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        this.typeName = shortClassName;
        FqName packageFqName = classId.getPackageFqName();
        Name identifier = Name.identifier(shortClassName.asString() + "Array");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        this.arrayClassId = new ClassId(packageFqName, identifier);
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
