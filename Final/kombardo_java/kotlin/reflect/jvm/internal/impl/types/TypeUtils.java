package kotlin.reflect.jvm.internal.impl.types;

import androidx.appcompat.R$styleable;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes3.dex */
public abstract class TypeUtils {
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    /* loaded from: classes3.dex */
    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String format;
            String str = (i5 == 1 || i5 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i5 == 1 || i5 == 4) ? 2 : 3];
            if (i5 != 1) {
                if (i5 == 2) {
                    objArr[0] = "delegate";
                } else if (i5 == 3) {
                    objArr[0] = "kotlinTypeRefiner";
                } else if (i5 != 4) {
                    objArr[0] = "newAttributes";
                }
                if (i5 != 1) {
                    objArr[1] = "toString";
                } else if (i5 != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                } else {
                    objArr[1] = "refine";
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        objArr[2] = "replaceDelegate";
                    } else if (i5 == 3) {
                        objArr[2] = "refine";
                    } else if (i5 != 4) {
                        objArr[2] = "replaceAttributes";
                    }
                }
                format = String.format(str, objArr);
                if (i5 == 1 && i5 != 4) {
                    throw new IllegalArgumentException(format);
                }
                throw new IllegalStateException(format);
            }
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            if (i5 != 1) {
            }
            if (i5 != 1) {
            }
            format = String.format(str, objArr);
            if (i5 == 1) {
            }
            throw new IllegalStateException(format);
        }

        public SpecialType(String str) {
            this.name = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        protected SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public SpecialType refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
            if (simpleType == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType makeNullableAsSpecified(boolean z5) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
            if (typeAttributes == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str;
        int i6;
        if (i5 != 4 && i5 != 9 && i5 != 11 && i5 != 15 && i5 != 17 && i5 != 19 && i5 != 26 && i5 != 35 && i5 != 48 && i5 != 53 && i5 != 6 && i5 != 7) {
            switch (i5) {
                case 56:
                case 57:
                case 58:
                case 59:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i5 != 4 && i5 != 9 && i5 != 11 && i5 != 15 && i5 != 17 && i5 != 19 && i5 != 26 && i5 != 35 && i5 != 48 && i5 != 53 && i5 != 6 && i5 != 7) {
                switch (i5) {
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        break;
                    default:
                        i6 = 3;
                        break;
                }
                Object[] objArr = new Object[i6];
                switch (i5) {
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 48:
                    case 53:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                    case 5:
                    case 8:
                    case 10:
                    case 18:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case 25:
                    case 27:
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 30:
                    case 38:
                    case 40:
                    default:
                        objArr[0] = "type";
                        break;
                    case 12:
                        objArr[0] = "typeConstructor";
                        break;
                    case 13:
                        objArr[0] = "unsubstitutedMemberScope";
                        break;
                    case 14:
                        objArr[0] = "refinedTypeFactory";
                        break;
                    case 16:
                        objArr[0] = "parameters";
                        break;
                    case 20:
                        objArr[0] = "subType";
                        break;
                    case 21:
                        objArr[0] = "superType";
                        break;
                    case 22:
                        objArr[0] = "substitutor";
                        break;
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        objArr[0] = "result";
                        break;
                    case 31:
                    case 33:
                        objArr[0] = "clazz";
                        break;
                    case 32:
                        objArr[0] = "typeArguments";
                        break;
                    case 34:
                        objArr[0] = "projections";
                        break;
                    case 36:
                        objArr[0] = "a";
                        break;
                    case 37:
                        objArr[0] = "b";
                        break;
                    case 39:
                        objArr[0] = "typeParameters";
                        break;
                    case 41:
                        objArr[0] = "typeParameterConstructors";
                        break;
                    case 42:
                        objArr[0] = "specialType";
                        break;
                    case 43:
                    case 44:
                        objArr[0] = "isSpecialType";
                        break;
                    case 45:
                    case 46:
                        objArr[0] = "parameterDescriptor";
                        break;
                    case 47:
                    case 51:
                        objArr[0] = "numberValueTypeConstructor";
                        break;
                    case 49:
                    case 50:
                        objArr[0] = "supertypes";
                        break;
                    case 52:
                    case 55:
                        objArr[0] = "expectedType";
                        break;
                    case 54:
                        objArr[0] = "literalTypeConstructor";
                        break;
                }
                if (i5 == 4) {
                    if (i5 != 9) {
                        if (i5 == 11 || i5 == 15) {
                            objArr[1] = "makeUnsubstitutedType";
                        } else if (i5 == 17) {
                            objArr[1] = "getDefaultTypeProjections";
                        } else if (i5 == 19) {
                            objArr[1] = "getImmediateSupertypes";
                        } else if (i5 == 26) {
                            objArr[1] = "getAllSupertypes";
                        } else if (i5 == 35) {
                            objArr[1] = "substituteProjectionsForParameters";
                        } else if (i5 != 48) {
                            if (i5 != 53) {
                                if (i5 != 6 && i5 != 7) {
                                    switch (i5) {
                                        case 56:
                                        case 57:
                                        case 58:
                                        case 59:
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                                            break;
                                    }
                                }
                            }
                            objArr[1] = "getPrimitiveNumberType";
                        } else {
                            objArr[1] = "getDefaultPrimitiveNumberType";
                        }
                    }
                    objArr[1] = "makeNullableIfNeeded";
                } else {
                    objArr[1] = "makeNullableAsSpecified";
                }
                switch (i5) {
                    case 1:
                        objArr[2] = "makeNullable";
                        break;
                    case 2:
                        objArr[2] = "makeNotNullable";
                        break;
                    case 3:
                        objArr[2] = "makeNullableAsSpecified";
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 48:
                    case 53:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        break;
                    case 5:
                    case 8:
                        objArr[2] = "makeNullableIfNeeded";
                        break;
                    case 10:
                        objArr[2] = "canHaveSubtypes";
                        break;
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "makeUnsubstitutedType";
                        break;
                    case 16:
                        objArr[2] = "getDefaultTypeProjections";
                        break;
                    case 18:
                        objArr[2] = "getImmediateSupertypes";
                        break;
                    case 20:
                    case 21:
                    case 22:
                        objArr[2] = "createSubstitutedSupertype";
                        break;
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        objArr[2] = "collectAllSupertypes";
                        break;
                    case 25:
                        objArr[2] = "getAllSupertypes";
                        break;
                    case 27:
                        objArr[2] = "isNullableType";
                        break;
                    case 28:
                        objArr[2] = "acceptsNullable";
                        break;
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                        objArr[2] = "hasNullableSuperType";
                        break;
                    case 30:
                        objArr[2] = "getClassDescriptor";
                        break;
                    case 31:
                    case 32:
                        objArr[2] = "substituteParameters";
                        break;
                    case 33:
                    case 34:
                        objArr[2] = "substituteProjectionsForParameters";
                        break;
                    case 36:
                    case 37:
                        objArr[2] = "equalTypes";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "dependsOnTypeParameters";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "dependsOnTypeConstructors";
                        break;
                    case 42:
                    case 43:
                    case 44:
                        objArr[2] = "contains";
                        break;
                    case 45:
                    case 46:
                        objArr[2] = "makeStarProjection";
                        break;
                    case 47:
                    case 49:
                        objArr[2] = "getDefaultPrimitiveNumberType";
                        break;
                    case 50:
                        objArr[2] = "findByFqName";
                        break;
                    case 51:
                    case 52:
                    case 54:
                    case 55:
                        objArr[2] = "getPrimitiveNumberType";
                        break;
                    case 60:
                        objArr[2] = "isTypeParameter";
                        break;
                    case 61:
                        objArr[2] = "isReifiedTypeParameter";
                        break;
                    case 62:
                        objArr[2] = "isNonReifiedTypeParameter";
                        break;
                    case Function.ALT_CONVENTION /* 63 */:
                        objArr[2] = "getTypeParameterDescriptorOrNull";
                        break;
                    default:
                        objArr[2] = "noExpectedType";
                        break;
                }
                String format = String.format(str, objArr);
                if (i5 != 4 && i5 != 9 && i5 != 11 && i5 != 15 && i5 != 17 && i5 != 19 && i5 != 26 && i5 != 35 && i5 != 48 && i5 != 53 && i5 != 6 && i5 != 7) {
                    switch (i5) {
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i6 = 2;
            Object[] objArr2 = new Object[i6];
            switch (i5) {
            }
            if (i5 == 4) {
            }
            switch (i5) {
            }
            String format2 = String.format(str, objArr2);
            if (i5 != 4) {
                switch (i5) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i5 != 4) {
            switch (i5) {
            }
            Object[] objArr22 = new Object[i6];
            switch (i5) {
            }
            if (i5 == 4) {
            }
            switch (i5) {
            }
            String format22 = String.format(str, objArr22);
            if (i5 != 4) {
            }
            throw new IllegalStateException(format22);
        }
        i6 = 2;
        Object[] objArr222 = new Object[i6];
        switch (i5) {
        }
        if (i5 == 4) {
        }
        switch (i5) {
        }
        String format222 = String.format(str, objArr222);
        if (i5 != 4) {
        }
        throw new IllegalStateException(format222);
    }

    public static boolean acceptsNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        return FlexibleTypesKt.isFlexible(kotlinType) && acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound());
    }

    public static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(43);
        }
        return contains(kotlinType, function1, null);
    }

    public static KotlinType createSubstitutedSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(20);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(21);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
        if (substitute != null) {
            return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo3718getDeclarationDescriptor;
        }
        return null;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> list) {
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TypeProjectionImpl(it.next().getDefaultType()));
        }
        List<TypeProjection> list2 = CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(17);
        }
        return list2;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(18);
        }
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
        Collection<KotlinType> mo3719getSupertypes = kotlinType.getConstructor().mo3719getSupertypes();
        ArrayList arrayList = new ArrayList(mo3719getSupertypes.size());
        Iterator<KotlinType> it = mo3719getSupertypes.iterator();
        while (it.hasNext()) {
            KotlinType createSubstitutedSupertype = createSubstitutedSupertype(kotlinType, it.next(), create);
            if (createSubstitutedSupertype != null) {
                arrayList.add(createSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(63);
        }
        if (kotlinType.getConstructor().mo3718getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean hasNullableSuperType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(29);
        }
        if (kotlinType.getConstructor().mo3718getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        Iterator<KotlinType> it = getImmediateSupertypes(kotlinType).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDontCarePlaceholder(KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    public static boolean isNullableType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            return false;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = constructor.mo3719getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTypeParameter(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(60);
        }
        if (getTypeParameterDescriptorOrNull(kotlinType) != null) {
            return true;
        }
        kotlinType.getConstructor();
        return false;
    }

    public static KotlinType makeNotNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    public static KotlinType makeNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType kotlinType, boolean z5) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z5);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType simpleType, boolean z5) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
        }
        if (!z5) {
            if (simpleType == null) {
                $$$reportNull$$$0(7);
            }
            return simpleType;
        }
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(6);
        }
        return makeNullableAsSpecified;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, classifierDescriptor.toString());
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
        return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
    }

    public static boolean noExpectedType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
    }

    private static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1, SmartSet<KotlinType> smartSet) {
        if (function1 == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType == null) {
            return false;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (noExpectedType(kotlinType)) {
            return function1.invoke(unwrap).booleanValue();
        }
        if (smartSet != null && smartSet.contains(kotlinType)) {
            return false;
        }
        if (function1.invoke(unwrap).booleanValue()) {
            return true;
        }
        if (smartSet == null) {
            smartSet = SmartSet.create();
        }
        smartSet.add(kotlinType);
        FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        if (flexibleType != null && (contains(flexibleType.getLowerBound(), function1, smartSet) || contains(flexibleType.getUpperBound(), function1, smartSet))) {
            return true;
        }
        if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).getOriginal(), function1, smartSet)) {
            return true;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = ((IntersectionTypeConstructor) constructor).mo3719getSupertypes().iterator();
            while (it.hasNext()) {
                if (contains(it.next(), function1, smartSet)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection typeProjection : kotlinType.getArguments()) {
            if (!typeProjection.isStarProjection() && contains(typeProjection.getType(), function1, smartSet)) {
                return true;
            }
        }
        return false;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(46);
        }
        if (erasureTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static KotlinType makeNullableIfNeeded(KotlinType kotlinType, boolean z5) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z5) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }
}
