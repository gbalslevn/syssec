package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* loaded from: classes3.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(rigidTypeMarker) && !typeSystemContext.isIntegerLiteralType(rigidTypeMarker2)) {
            return null;
        }
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker) && checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, rigidTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (typeSystemContext.isIntegerLiteralType(rigidTypeMarker)) {
            if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (typeSystemContext.isIntegerLiteralType(rigidTypeMarker2) && (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, rigidTypeMarker) || checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, rigidTypeMarker2, rigidTypeMarker, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        KotlinTypeMarker type;
        RigidTypeMarker upperBoundIfFlexible;
        return (rigidTypeMarker instanceof CapturedTypeMarker) && (type = typeSystemContext.getType(typeSystemContext.projection(typeSystemContext.typeConstructor((CapturedTypeMarker) rigidTypeMarker)))) != null && (upperBoundIfFlexible = typeSystemContext.upperBoundIfFlexible(type)) != null && typeSystemContext.isIntegerLiteralType(upperBoundIfFlexible);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker);
        if (typeConstructor instanceof IntersectionTypeConstructorMarker) {
            Collection<KotlinTypeMarker> supertypes = typeSystemContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    RigidTypeMarker asRigidType = typeSystemContext.asRigidType((KotlinTypeMarker) it.next());
                    if (asRigidType != null && typeSystemContext.isIntegerLiteralType(asRigidType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        return typeSystemContext.isIntegerLiteralType(rigidTypeMarker) || checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(typeSystemContext, rigidTypeMarker);
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext typeSystemContext, TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2, boolean z5) {
        Collection<KotlinTypeMarker> possibleIntegerTypes = typeSystemContext.possibleIntegerTypes(rigidTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && possibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
            if (Intrinsics.areEqual(typeSystemContext.typeConstructor(kotlinTypeMarker), typeSystemContext.typeConstructor(rigidTypeMarker2)) || (z5 && isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker2, kotlinTypeMarker, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isError(rigidTypeMarker) || typeSystemContext.isError(rigidTypeMarker2)) {
            return typeCheckerState.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!typeSystemContext.isMarkedNullable(rigidTypeMarker) || typeSystemContext.isMarkedNullable(rigidTypeMarker2)) ? Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(typeSystemContext, typeSystemContext.withNullability(rigidTypeMarker, false), typeSystemContext.withNullability(rigidTypeMarker2, false))) : Boolean.FALSE;
        }
        if (typeSystemContext.isStubTypeForBuilderInference(rigidTypeMarker) && typeSystemContext.isStubTypeForBuilderInference(rigidTypeMarker2)) {
            return Boolean.valueOf(INSTANCE.isStubTypeSubtypeOfAnother(typeSystemContext, rigidTypeMarker, rigidTypeMarker2) || typeCheckerState.isStubTypeEqualsToAnything());
        }
        if (typeSystemContext.isStubType(rigidTypeMarker) || typeSystemContext.isStubType(rigidTypeMarker2)) {
            return Boolean.valueOf(typeCheckerState.isStubTypeEqualsToAnything());
        }
        CapturedTypeMarker asCapturedTypeUnwrappingDnn = typeSystemContext.asCapturedTypeUnwrappingDnn(rigidTypeMarker2);
        KotlinTypeMarker lowerType = asCapturedTypeUnwrappingDnn != null ? typeSystemContext.lowerType(asCapturedTypeUnwrappingDnn) : null;
        if (asCapturedTypeUnwrappingDnn != null && lowerType != null) {
            if (typeSystemContext.isMarkedNullable(rigidTypeMarker2)) {
                lowerType = typeSystemContext.withNullability(lowerType, true);
            } else if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2)) {
                lowerType = typeSystemContext.makeDefinitelyNotNullOrNotNull(lowerType);
            }
            KotlinTypeMarker kotlinTypeMarker = lowerType;
            int i5 = WhenMappings.$EnumSwitchMapping$1[typeCheckerState.getLowerCapturedTypePolicy(rigidTypeMarker, asCapturedTypeUnwrappingDnn).ordinal()];
            if (i5 == 1) {
                return Boolean.valueOf(isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker, kotlinTypeMarker, false, 8, null));
            }
            if (i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker, kotlinTypeMarker, false, 8, null)) {
                return Boolean.TRUE;
            }
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker2);
        if (typeSystemContext.isIntersection(typeConstructor)) {
            typeSystemContext.isMarkedNullable(rigidTypeMarker2);
            Collection<KotlinTypeMarker> supertypes = typeSystemContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    if (!isSubtypeOf$default(INSTANCE, typeCheckerState, rigidTypeMarker, (KotlinTypeMarker) it.next(), false, 8, null)) {
                        break;
                    }
                }
            }
            r10 = true;
            return Boolean.valueOf(r10);
        }
        TypeConstructorMarker typeConstructor2 = typeSystemContext.typeConstructor(rigidTypeMarker);
        if (!(rigidTypeMarker instanceof CapturedTypeMarker)) {
            if (typeSystemContext.isIntersection(typeConstructor2)) {
                Collection<KotlinTypeMarker> supertypes2 = typeSystemContext.supertypes(typeConstructor2);
                if (!(supertypes2 instanceof Collection) || !supertypes2.isEmpty()) {
                    Iterator<T> it2 = supertypes2.iterator();
                    while (it2.hasNext()) {
                        if (!(((KotlinTypeMarker) it2.next()) instanceof CapturedTypeMarker)) {
                            break;
                        }
                    }
                }
            }
            return null;
        }
        TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(typeCheckerState.getTypeSystemContext(), rigidTypeMarker2, rigidTypeMarker);
        if (typeParameterForArgumentInBaseIfItEqualToTarget != null && typeSystemContext.hasRecursiveBounds(typeParameterForArgumentInBaseIfItEqualToTarget, typeSystemContext.typeConstructor(rigidTypeMarker2))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private final List<RigidTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(rigidTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker) && typeSystemContext.isClassType(rigidTypeMarker)) {
            return CollectionsKt.emptyList();
        }
        if (typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructorMarker)) {
                return CollectionsKt.emptyList();
            }
            RigidTypeMarker captureFromArguments = typeSystemContext.captureFromArguments(rigidTypeMarker, CaptureStatus.FOR_SUBTYPING);
            if (captureFromArguments != null) {
                rigidTypeMarker = captureFromArguments;
            }
            return CollectionsKt.listOf(rigidTypeMarker);
        }
        SmartList smartList = new SmartList();
        typeCheckerState.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker pop = supertypesDeque.pop();
            Intrinsics.checkNotNull(pop);
            if (supertypesSet.add(pop)) {
                RigidTypeMarker captureFromArguments2 = typeSystemContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                if (captureFromArguments2 == null) {
                    captureFromArguments2 = pop;
                }
                if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                    smartList.add(captureFromArguments2);
                    substitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    substitutionSupertypePolicy = typeSystemContext.argumentsCount(captureFromArguments2) == 0 ? TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE : typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(captureFromArguments2);
                }
                if (Intrinsics.areEqual(substitutionSupertypePolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    substitutionSupertypePolicy = null;
                }
                if (substitutionSupertypePolicy != null) {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(substitutionSupertypePolicy.mo3722transformType(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.clear();
        return smartList;
    }

    private final List<RigidTypeMarker> collectAndFilter(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeCheckerState, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, rigidTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z5) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForSpecialCases = abstractTypeChecker.checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        if (checkSubtypeForSpecialCases == null) {
            Boolean addSubtypeConstraint = typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z5);
            return addSubtypeConstraint != null ? addSubtypeConstraint.booleanValue() : abstractTypeChecker.isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        }
        boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
        typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z5);
        return booleanValue;
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        KotlinTypeMarker type;
        int argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        int i5 = 0;
        while (true) {
            if (i5 >= argumentsCount) {
                return null;
            }
            TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i5);
            TypeArgumentMarker typeArgumentMarker = typeSystemContext.isStarProjection(argument) ? null : argument;
            if (typeArgumentMarker != null && (type = typeSystemContext.getType(typeArgumentMarker)) != null) {
                boolean z5 = typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) && typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2));
                if (Intrinsics.areEqual(type, kotlinTypeMarker2) || (z5 && Intrinsics.areEqual(typeSystemContext.typeConstructor(type), typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                    break;
                }
                TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                    return typeParameterForArgumentInBaseIfItEqualToTarget;
                }
            }
            i5++;
        }
        return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i5);
    }

    private final boolean hasNothingSupertype(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(rigidTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<RigidTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(rigidTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker pop = supertypesDeque.pop();
            Intrinsics.checkNotNull(pop);
            if (supertypesSet.add(pop)) {
                TypeCheckerState.SupertypesPolicy supertypesPolicy = typeSystemContext.isClassType(pop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if (Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy == null) {
                    continue;
                } else {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop)).iterator();
                    while (it.hasNext()) {
                        RigidTypeMarker mo3722transformType = supertypesPolicy.mo3722transformType(typeCheckerState, it.next());
                        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(mo3722transformType))) {
                            typeCheckerState.clear();
                            return true;
                        }
                        supertypesDeque.add(mo3722transformType);
                    }
                }
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return (!typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) || typeSystemContext.isDynamic(kotlinTypeMarker) || typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) || typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) || typeSystemContext.isFlexibleWithDifferentTypeConstructors(kotlinTypeMarker)) ? false : true;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        if (typeSystemContext.typeConstructor(rigidTypeMarker) != typeSystemContext.typeConstructor(rigidTypeMarker2)) {
            return false;
        }
        if (typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker) || !typeSystemContext.isDefinitelyNotNullType(rigidTypeMarker2)) {
            return !typeSystemContext.isMarkedNullable(rigidTypeMarker) || typeSystemContext.isMarkedNullable(rigidTypeMarker2);
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z5, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSubtypeOfForSingleClassifierType(TypeCheckerState typeCheckerState, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        Collection<RigidTypeMarker> arrayList;
        int size;
        KotlinTypeMarker type;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(rigidTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(rigidTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(rigidTypeMarker2);
            }
        }
        boolean z5 = false;
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState, rigidTypeMarker, rigidTypeMarker2)) {
            return false;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForIntegerLiteralType = abstractTypeChecker.checkSubtypeForIntegerLiteralType(typeCheckerState, rigidTypeMarker, rigidTypeMarker2);
        if (checkSubtypeForIntegerLiteralType != null) {
            boolean booleanValue = checkSubtypeForIntegerLiteralType.booleanValue();
            TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, rigidTypeMarker, rigidTypeMarker2, false, 4, null);
            return booleanValue;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(rigidTypeMarker2);
        boolean z6 = true;
        if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(rigidTypeMarker), typeConstructor) && typeSystemContext.parametersCount(typeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(rigidTypeMarker2))) {
            return true;
        }
        List<RigidTypeMarker> findCorrespondingSupertypes = abstractTypeChecker.findCorrespondingSupertypes(typeCheckerState, rigidTypeMarker, typeConstructor);
        int i5 = 10;
        if (findCorrespondingSupertypes.size() > 1) {
            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
            TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext = typeSystemContext2 instanceof TypeSystemInferenceExtensionContext ? (TypeSystemInferenceExtensionContext) typeSystemContext2 : null;
            if (typeSystemInferenceExtensionContext != null && typeSystemInferenceExtensionContext.isK2()) {
                arrayList = new LinkedHashSet();
                for (RigidTypeMarker rigidTypeMarker3 : findCorrespondingSupertypes) {
                    RigidTypeMarker asRigidType = typeSystemContext.asRigidType(typeCheckerState.prepareType(rigidTypeMarker3));
                    if (asRigidType != null) {
                        rigidTypeMarker3 = asRigidType;
                    }
                    arrayList.add(rigidTypeMarker3);
                }
                size = arrayList.size();
                if (size != 0) {
                    return INSTANCE.hasNothingSupertype(typeCheckerState, rigidTypeMarker);
                }
                if (size == 1) {
                    return INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList((RigidTypeMarker) CollectionsKt.first(arrayList)), rigidTypeMarker2);
                }
                ArgumentList argumentList = new ArgumentList(typeSystemContext.parametersCount(typeConstructor));
                int parametersCount = typeSystemContext.parametersCount(typeConstructor);
                int i6 = 0;
                boolean z7 = false;
                while (i6 < parametersCount) {
                    z7 = (z7 || typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i6)) != TypeVariance.OUT) ? z6 : z5;
                    if (!z7) {
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, i5));
                        for (RigidTypeMarker rigidTypeMarker4 : arrayList) {
                            TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(rigidTypeMarker4, i6);
                            if (argumentOrNull != null) {
                                if (typeSystemContext.getVariance(argumentOrNull) != TypeVariance.INV) {
                                    argumentOrNull = null;
                                }
                                if (argumentOrNull != null && (type = typeSystemContext.getType(argumentOrNull)) != null) {
                                    arrayList2.add(type);
                                }
                            }
                            throw new IllegalStateException(("Incorrect type: " + rigidTypeMarker4 + ", subType: " + rigidTypeMarker + ", superType: " + rigidTypeMarker2).toString());
                        }
                        argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes(arrayList2)));
                    }
                    i6++;
                    z5 = false;
                    z6 = true;
                    i5 = 10;
                }
                if (z7 || !INSTANCE.isSubtypeForSameConstructor(typeCheckerState, argumentList, rigidTypeMarker2)) {
                    return typeCheckerState.runForkingPoint(new Function1(arrayList, typeCheckerState, typeSystemContext, rigidTypeMarker2) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$0
                        private final Collection arg$0;
                        private final TypeCheckerState arg$1;
                        private final TypeSystemContext arg$2;
                        private final RigidTypeMarker arg$3;

                        {
                            this.arg$0 = arrayList;
                            this.arg$1 = typeCheckerState;
                            this.arg$2 = typeSystemContext;
                            this.arg$3 = rigidTypeMarker2;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public Object invoke(Object obj) {
                            Unit isSubtypeOfForSingleClassifierType$lambda$21$lambda$20;
                            isSubtypeOfForSingleClassifierType$lambda$21$lambda$20 = AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (TypeCheckerState.ForkPointContext) obj);
                            return isSubtypeOfForSingleClassifierType$lambda$21$lambda$20;
                        }
                    });
                }
                return true;
            }
        }
        List<RigidTypeMarker> list = findCorrespondingSupertypes;
        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RigidTypeMarker rigidTypeMarker5 : list) {
            RigidTypeMarker asRigidType2 = typeSystemContext.asRigidType(typeCheckerState.prepareType(rigidTypeMarker5));
            if (asRigidType2 != null) {
                rigidTypeMarker5 = asRigidType2;
            }
            arrayList.add(rigidTypeMarker5);
        }
        size = arrayList.size();
        if (size != 0) {
        }
    }

    public static final Unit isSubtypeOfForSingleClassifierType$lambda$21$lambda$20(Collection collection, TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, TypeCheckerState.ForkPointContext runForkingPoint) {
        Intrinsics.checkNotNullParameter(runForkingPoint, "$this$runForkingPoint");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            runForkingPoint.fork(new Function0(typeCheckerState, typeSystemContext, (RigidTypeMarker) it.next(), rigidTypeMarker) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$$Lambda$1
                private final TypeCheckerState arg$0;
                private final TypeSystemContext arg$1;
                private final RigidTypeMarker arg$2;
                private final RigidTypeMarker arg$3;

                {
                    this.arg$0 = typeCheckerState;
                    this.arg$1 = typeSystemContext;
                    this.arg$2 = r3;
                    this.arg$3 = rigidTypeMarker;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    boolean isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19;
                    isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19 = AbstractTypeChecker.isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(this.arg$0, this.arg$1, this.arg$2, this.arg$3);
                    return Boolean.valueOf(isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static final boolean isSubtypeOfForSingleClassifierType$lambda$21$lambda$20$lambda$19(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        return INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList(rigidTypeMarker), rigidTypeMarker2);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        RigidTypeMarker asRigidType = typeSystemContext.asRigidType(kotlinTypeMarker);
        if (asRigidType instanceof CapturedTypeMarker) {
            CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asRigidType;
            if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
                return false;
            }
            typeSystemContext.typeConstructor(kotlinTypeMarker2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<RigidTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState typeCheckerState, List<? extends RigidTypeMarker> list) {
        int i5;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            TypeArgumentListMarker asArgumentList = typeSystemContext.asArgumentList((RigidTypeMarker) obj);
            int size = typeSystemContext.size(asArgumentList);
            while (true) {
                if (i5 >= size) {
                    arrayList.add(obj);
                    break;
                }
                KotlinTypeMarker type = typeSystemContext.getType(typeSystemContext.get(asArgumentList, i5));
                i5 = (type != null ? typeSystemContext.asFlexibleType(type) : null) == null ? i5 + 1 : 0;
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    public final TypeVariance effectiveVariance(TypeVariance declared, TypeVariance useSite) {
        Intrinsics.checkNotNullParameter(declared, "declared");
        Intrinsics.checkNotNullParameter(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean equalTypes(TypeCheckerState state, KotlinTypeMarker a5, KotlinTypeMarker b5) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (a5 == b5) {
            return true;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, a5) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, b5)) {
            KotlinTypeMarker prepareType = state.prepareType(state.refineType(a5));
            KotlinTypeMarker prepareType2 = state.prepareType(state.refineType(b5));
            RigidTypeMarker lowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(prepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(prepareType), typeSystemContext.typeConstructor(prepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                return typeSystemContext.hasFlexibleNullability(prepareType) || typeSystemContext.hasFlexibleNullability(prepareType2) || typeSystemContext.isMarkedNullable(lowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(prepareType2));
            }
        }
        return isSubtypeOf$default(abstractTypeChecker, state, a5, b5, false, 8, null) && isSubtypeOf$default(abstractTypeChecker, state, b5, a5, false, 8, null);
    }

    public final List<RigidTypeMarker> findCorrespondingSupertypes(TypeCheckerState state, RigidTypeMarker subType, TypeConstructorMarker superConstructor) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
        TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (typeSystemContext.isClassType(subType)) {
            return INSTANCE.collectAndFilter(state, subType, superConstructor);
        }
        if (!typeSystemContext.isClassTypeConstructor(superConstructor) && !typeSystemContext.isIntegerLiteralTypeConstructor(superConstructor)) {
            return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(state, subType, superConstructor);
        }
        SmartList<RigidTypeMarker> smartList = new SmartList();
        state.initialize();
        ArrayDeque<RigidTypeMarker> supertypesDeque = state.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<RigidTypeMarker> supertypesSet = state.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(subType);
        while (!supertypesDeque.isEmpty()) {
            RigidTypeMarker pop = supertypesDeque.pop();
            Intrinsics.checkNotNull(pop);
            if (supertypesSet.add(pop)) {
                if (typeSystemContext.isClassType(pop)) {
                    smartList.add(pop);
                    supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                } else {
                    supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                if (Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy != null) {
                    TypeSystemContext typeSystemContext2 = state.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(supertypesPolicy.mo3722transformType(state, it.next()));
                    }
                }
            }
        }
        state.clear();
        ArrayList arrayList = new ArrayList();
        for (RigidTypeMarker rigidTypeMarker : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNull(rigidTypeMarker);
            CollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(state, rigidTypeMarker, superConstructor));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState typeCheckerState, TypeArgumentListMarker capturedSubArguments, RigidTypeMarker superType) {
        int i5;
        int i6;
        boolean equalTypes;
        int i7;
        Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        Intrinsics.checkNotNullParameter(capturedSubArguments, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(superType, "superType");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(superType);
        int size = typeSystemContext.size(capturedSubArguments);
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        if (size != parametersCount || size != typeSystemContext.argumentsCount(superType)) {
            return false;
        }
        for (int i8 = 0; i8 < parametersCount; i8++) {
            TypeArgumentMarker argument = typeSystemContext.getArgument(superType, i8);
            KotlinTypeMarker type = typeSystemContext.getType(argument);
            if (type != null) {
                TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(capturedSubArguments, i8);
                typeSystemContext.getVariance(typeArgumentMarker);
                TypeVariance typeVariance = TypeVariance.INV;
                KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                Intrinsics.checkNotNull(type2);
                AbstractTypeChecker abstractTypeChecker = INSTANCE;
                TypeVariance effectiveVariance = abstractTypeChecker.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i8)), typeSystemContext.getVariance(argument));
                if (effectiveVariance == null) {
                    return typeCheckerState.isErrorTypeEqualsToAnything();
                }
                if (effectiveVariance != typeVariance || (!abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructor) && !abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructor))) {
                    i5 = typeCheckerState.argumentsDepth;
                    if (i5 > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                    }
                    i6 = typeCheckerState.argumentsDepth;
                    typeCheckerState.argumentsDepth = i6 + 1;
                    int i9 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                    if (i9 == 1) {
                        equalTypes = abstractTypeChecker.equalTypes(typeCheckerState, type2, type);
                    } else if (i9 == 2) {
                        equalTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type2, type, false, 8, null);
                    } else {
                        if (i9 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        equalTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type, type2, false, 8, null);
                    }
                    i7 = typeCheckerState.argumentsDepth;
                    typeCheckerState.argumentsDepth = i7 - 1;
                    if (!equalTypes) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean isSubtypeOf(TypeCheckerState state, KotlinTypeMarker subType, KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return isSubtypeOf$default(this, state, subType, superType, false, 8, null);
    }

    public final boolean isSubtypeOf(TypeCheckerState state, KotlinTypeMarker subType, KotlinTypeMarker superType, boolean z5) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.customIsSubtypeOf(subType, superType)) {
            return completeIsSubTypeOf(state, subType, superType, z5);
        }
        return false;
    }
}
