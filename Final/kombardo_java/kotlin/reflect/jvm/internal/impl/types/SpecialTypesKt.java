package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* loaded from: classes3.dex */
public abstract class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            return (AbbreviatedType) unwrap;
        }
        return null;
    }

    public static final SimpleType getAbbreviation(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType, boolean z5) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, unwrappedType, z5, false, 4, null);
        if (makeDefinitelyNotNull$default != null) {
            return makeDefinitelyNotNull$default;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull != null ? makeIntersectionTypeDefinitelyNotNullOrNotNull : unwrappedType.makeNullableAsSpecified(false);
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z5);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return makeDefinitelyNotNullOrNotNull.createType();
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType, boolean z5) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, simpleType, z5, false, 4, null);
        if (makeDefinitelyNotNull$default != null) {
            return makeDefinitelyNotNull$default;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? simpleType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType simpleType, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, z5);
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType abbreviatedType) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(abbreviatedType, "abbreviatedType");
        return KotlinTypeKt.isError(simpleType) ? simpleType : new AbbreviatedType(simpleType, abbreviatedType);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType newCapturedType) {
        Intrinsics.checkNotNullParameter(newCapturedType, "<this>");
        return new NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAttributes(), newCapturedType.isMarkedNullable(), true);
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor intersectionTypeConstructor) {
        KotlinType kotlinType;
        Collection<KotlinType> mo3719getSupertypes = intersectionTypeConstructor.mo3719getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo3719getSupertypes, 10));
        Iterator<T> it = mo3719getSupertypes.iterator();
        boolean z5 = false;
        while (true) {
            kotlinType = null;
            if (!it.hasNext()) {
                break;
            }
            KotlinType kotlinType2 = (KotlinType) it.next();
            if (TypeUtils.isNullableType(kotlinType2)) {
                kotlinType2 = makeDefinitelyNotNullOrNotNull$default(kotlinType2.unwrap(), false, 1, null);
                z5 = true;
            }
            arrayList.add(kotlinType2);
        }
        if (!z5) {
            return null;
        }
        KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
        if (alternativeType != null) {
            if (TypeUtils.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
            }
            kotlinType = alternativeType;
        }
        return new IntersectionTypeConstructor(arrayList).setAlternative(kotlinType);
    }
}
