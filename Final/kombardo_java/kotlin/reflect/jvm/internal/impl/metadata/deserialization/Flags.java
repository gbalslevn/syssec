package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* loaded from: classes3.dex */
public abstract class Flags {
    public static final FlagField<ProtoBuf$Class.Kind> CLASS_KIND;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE;
    public static final BooleanFlagField HAS_ANNOTATIONS;
    public static final BooleanFlagField HAS_CONSTANT;
    public static final BooleanFlagField HAS_ENUM_ENTRIES;
    public static final BooleanFlagField HAS_GETTER;
    public static final BooleanFlagField HAS_SETTER;
    public static final BooleanFlagField IS_CONST;
    public static final BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_CROSSINLINE;
    public static final BooleanFlagField IS_DATA;
    public static final BooleanFlagField IS_DELEGATED;
    public static final BooleanFlagField IS_EXPECT_CLASS;
    public static final BooleanFlagField IS_EXPECT_FUNCTION;
    public static final BooleanFlagField IS_EXPECT_PROPERTY;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR;
    public static final BooleanFlagField IS_EXTERNAL_CLASS;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY;
    public static final BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_FUN_INTERFACE;
    public static final BooleanFlagField IS_INFIX;
    public static final BooleanFlagField IS_INLINE;
    public static final BooleanFlagField IS_INLINE_ACCESSOR;
    public static final BooleanFlagField IS_INNER;
    public static final BooleanFlagField IS_LATEINIT;
    public static final BooleanFlagField IS_NEGATED;
    public static final BooleanFlagField IS_NOINLINE;
    public static final BooleanFlagField IS_NOT_DEFAULT;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE;
    public static final BooleanFlagField IS_OPERATOR;
    public static final BooleanFlagField IS_SECONDARY;
    public static final BooleanFlagField IS_SUSPEND;
    public static final BooleanFlagField IS_TAILREC;
    public static final BooleanFlagField IS_UNSIGNED;
    public static final BooleanFlagField IS_VALUE_CLASS;
    public static final BooleanFlagField IS_VAR;
    public static final FlagField<ProtoBuf$MemberKind> MEMBER_KIND;
    public static final FlagField<ProtoBuf$Modality> MODALITY;
    public static final BooleanFlagField SUSPEND_TYPE;
    public static final FlagField<ProtoBuf$Visibility> VISIBILITY;

    /* loaded from: classes3.dex */
    public static class BooleanFlagField extends FlagField<Boolean> {
        public BooleanFlagField(int i5) {
            super(i5, 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int i5) {
            return Boolean.valueOf((i5 & (1 << this.offset)) != 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.offset;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public EnumLiteFlagField(int i5, E[] eArr) {
            super(i5, bitWidth(eArr));
            this.values = eArr;
        }

        private static <E> int bitWidth(E[] eArr) {
            if (eArr == null) {
                $$$reportNull$$$0(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i5 = 31; i5 >= 0; i5--) {
                if (((1 << i5) & length) != 0) {
                    return i5 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int i5) {
            int i6 = (1 << this.bitWidth) - 1;
            int i7 = this.offset;
            int i8 = (i5 & (i6 << i7)) >> i7;
            for (E e5 : this.values) {
                if (e5.getNumber() == i8) {
                    return e5;
                }
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public int toFlags(E e5) {
            return e5.getNumber() << this.offset;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField flagField, Internal.EnumLite[] enumLiteArr) {
            return new EnumLiteFlagField(flagField.offset + flagField.bitWidth, enumLiteArr);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> flagField) {
            return new BooleanFlagField(flagField.offset + flagField.bitWidth);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public abstract E get(int i5);

        public abstract int toFlags(E e5);

        private FlagField(int i5, int i6) {
            this.offset = i5;
            this.bitWidth = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        Object[] objArr = new Object[3];
        if (i5 != 1) {
            if (i5 == 2) {
                objArr[0] = "kind";
            } else if (i5 != 5) {
                if (i5 != 6) {
                    if (i5 != 8) {
                        if (i5 != 9) {
                            if (i5 != 11) {
                                objArr[0] = "visibility";
                            }
                        }
                    }
                }
                objArr[0] = "memberKind";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
            switch (i5) {
                case 3:
                    objArr[2] = "getConstructorFlags";
                    break;
                case 4:
                case 5:
                case 6:
                    objArr[2] = "getFunctionFlags";
                    break;
                case 7:
                case 8:
                case 9:
                    objArr[2] = "getPropertyFlags";
                    break;
                case 10:
                case 11:
                    objArr[2] = "getAccessorFlags";
                    break;
                default:
                    objArr[2] = "getClassFlags";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "modality";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i5) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        BooleanFlagField booleanFirst = FlagField.booleanFirst();
        SUSPEND_TYPE = booleanFirst;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(booleanFirst);
        BooleanFlagField booleanFirst2 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = booleanFirst2;
        FlagField<ProtoBuf$Visibility> after = FlagField.after(booleanFirst2, ProtoBuf$Visibility.values());
        VISIBILITY = after;
        FlagField<ProtoBuf$Modality> after2 = FlagField.after(after, ProtoBuf$Modality.values());
        MODALITY = after2;
        FlagField<ProtoBuf$Class.Kind> after3 = FlagField.after(after2, ProtoBuf$Class.Kind.values());
        CLASS_KIND = after3;
        BooleanFlagField booleanAfter = FlagField.booleanAfter(after3);
        IS_INNER = booleanAfter;
        BooleanFlagField booleanAfter2 = FlagField.booleanAfter(booleanAfter);
        IS_DATA = booleanAfter2;
        BooleanFlagField booleanAfter3 = FlagField.booleanAfter(booleanAfter2);
        IS_EXTERNAL_CLASS = booleanAfter3;
        BooleanFlagField booleanAfter4 = FlagField.booleanAfter(booleanAfter3);
        IS_EXPECT_CLASS = booleanAfter4;
        BooleanFlagField booleanAfter5 = FlagField.booleanAfter(booleanAfter4);
        IS_VALUE_CLASS = booleanAfter5;
        BooleanFlagField booleanAfter6 = FlagField.booleanAfter(booleanAfter5);
        IS_FUN_INTERFACE = booleanAfter6;
        HAS_ENUM_ENTRIES = FlagField.booleanAfter(booleanAfter6);
        BooleanFlagField booleanAfter7 = FlagField.booleanAfter(after);
        IS_SECONDARY = booleanAfter7;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(booleanAfter7);
        FlagField<ProtoBuf$MemberKind> after4 = FlagField.after(after2, ProtoBuf$MemberKind.values());
        MEMBER_KIND = after4;
        BooleanFlagField booleanAfter8 = FlagField.booleanAfter(after4);
        IS_OPERATOR = booleanAfter8;
        BooleanFlagField booleanAfter9 = FlagField.booleanAfter(booleanAfter8);
        IS_INFIX = booleanAfter9;
        BooleanFlagField booleanAfter10 = FlagField.booleanAfter(booleanAfter9);
        IS_INLINE = booleanAfter10;
        BooleanFlagField booleanAfter11 = FlagField.booleanAfter(booleanAfter10);
        IS_TAILREC = booleanAfter11;
        BooleanFlagField booleanAfter12 = FlagField.booleanAfter(booleanAfter11);
        IS_EXTERNAL_FUNCTION = booleanAfter12;
        BooleanFlagField booleanAfter13 = FlagField.booleanAfter(booleanAfter12);
        IS_SUSPEND = booleanAfter13;
        BooleanFlagField booleanAfter14 = FlagField.booleanAfter(booleanAfter13);
        IS_EXPECT_FUNCTION = booleanAfter14;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(booleanAfter14);
        BooleanFlagField booleanAfter15 = FlagField.booleanAfter(after4);
        IS_VAR = booleanAfter15;
        BooleanFlagField booleanAfter16 = FlagField.booleanAfter(booleanAfter15);
        HAS_GETTER = booleanAfter16;
        BooleanFlagField booleanAfter17 = FlagField.booleanAfter(booleanAfter16);
        HAS_SETTER = booleanAfter17;
        BooleanFlagField booleanAfter18 = FlagField.booleanAfter(booleanAfter17);
        IS_CONST = booleanAfter18;
        BooleanFlagField booleanAfter19 = FlagField.booleanAfter(booleanAfter18);
        IS_LATEINIT = booleanAfter19;
        BooleanFlagField booleanAfter20 = FlagField.booleanAfter(booleanAfter19);
        HAS_CONSTANT = booleanAfter20;
        BooleanFlagField booleanAfter21 = FlagField.booleanAfter(booleanAfter20);
        IS_EXTERNAL_PROPERTY = booleanAfter21;
        BooleanFlagField booleanAfter22 = FlagField.booleanAfter(booleanAfter21);
        IS_DELEGATED = booleanAfter22;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(booleanAfter22);
        BooleanFlagField booleanAfter23 = FlagField.booleanAfter(booleanFirst2);
        DECLARES_DEFAULT_VALUE = booleanAfter23;
        BooleanFlagField booleanAfter24 = FlagField.booleanAfter(booleanAfter23);
        IS_CROSSINLINE = booleanAfter24;
        IS_NOINLINE = FlagField.booleanAfter(booleanAfter24);
        BooleanFlagField booleanAfter25 = FlagField.booleanAfter(after2);
        IS_NOT_DEFAULT = booleanAfter25;
        BooleanFlagField booleanAfter26 = FlagField.booleanAfter(booleanAfter25);
        IS_EXTERNAL_ACCESSOR = booleanAfter26;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(booleanAfter26);
        BooleanFlagField booleanFirst3 = FlagField.booleanFirst();
        IS_NEGATED = booleanFirst3;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(booleanFirst3);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean z5, ProtoBuf$Visibility protoBuf$Visibility, ProtoBuf$Modality protoBuf$Modality, boolean z6, boolean z7, boolean z8) {
        if (protoBuf$Visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (protoBuf$Modality == null) {
            $$$reportNull$$$0(11);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z5)) | MODALITY.toFlags(protoBuf$Modality) | VISIBILITY.toFlags(protoBuf$Visibility) | IS_NOT_DEFAULT.toFlags(Boolean.valueOf(z6)) | IS_EXTERNAL_ACCESSOR.toFlags(Boolean.valueOf(z7)) | IS_INLINE_ACCESSOR.toFlags(Boolean.valueOf(z8));
    }
}
