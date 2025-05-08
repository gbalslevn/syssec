package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = new Companion(null);
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        JAVA_APPLICABILITY_TYPES = linkedHashMap;
    }

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> set) {
        return set.contains(AnnotationQualifierApplicabilityType.TYPE_USE) ? SetsKt.plus(SetsKt.minus((Set<? extends AnnotationQualifierApplicabilityType>) ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), (Iterable) set) : set;
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation tannotation) {
        NullabilityQualifierWithMigrationStatus extractNullability;
        JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation = resolveQualifierBuiltInDefaultAnnotation(tannotation);
        if (resolveQualifierBuiltInDefaultAnnotation != null) {
            return resolveQualifierBuiltInDefaultAnnotation;
        }
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation = resolveTypeQualifierDefaultAnnotation(tannotation);
        if (resolveTypeQualifierDefaultAnnotation == null) {
            return null;
        }
        TAnnotation component1 = resolveTypeQualifierDefaultAnnotation.component1();
        Set<AnnotationQualifierApplicabilityType> component2 = resolveTypeQualifierDefaultAnnotation.component2();
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (resolveJsr305CustomState == null) {
            resolveJsr305CustomState = resolveJsr305AnnotationState(component1);
        }
        if (resolveJsr305CustomState.isIgnore() || (extractNullability = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) component1, (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean extractDefaultQualifiers$lambda$16;
                extractDefaultQualifiers$lambda$16 = AbstractAnnotationTypeQualifierResolver.extractDefaultQualifiers$lambda$16(obj);
                return Boolean.valueOf(extractDefaultQualifiers$lambda$16);
            }
        })) == null) {
            return null;
        }
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(extractNullability, null, resolveJsr305CustomState.isWarning(), 1, null), component2, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractDefaultQualifiers$lambda$16(Object extractNullability) {
        Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return false;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        NullabilityQualifierWithMigrationStatus knownNullability;
        NullabilityQualifierWithMigrationStatus knownNullability2 = knownNullability(tannotation, function1.invoke(tannotation).booleanValue());
        if (knownNullability2 != null) {
            return knownNullability2;
        }
        TAnnotation resolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(tannotation);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = resolveJsr305AnnotationState(tannotation);
        if (resolveJsr305AnnotationState.isIgnore() || (knownNullability = knownNullability(resolveTypeQualifierAnnotation, function1.invoke(resolveTypeQualifierAnnotation).booleanValue())) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(knownNullability, null, resolveJsr305AnnotationState.isWarning(), 1, null);
    }

    private final TAnnotation findAnnotation(TAnnotation tannotation, FqName fqName) {
        for (TAnnotation tannotation2 : getMetaAnnotations(tannotation)) {
            if (Intrinsics.areEqual(getFqName(tannotation2), fqName)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean hasAnnotation(TAnnotation tannotation, FqName fqName) {
        Iterable<TAnnotation> metaAnnotations = getMetaAnnotations(tannotation);
        if ((metaAnnotations instanceof Collection) && ((Collection) metaAnnotations).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = metaAnnotations.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(getFqName(it.next()), fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        if (r6.equals("NEVER") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
    
        r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        if (r6.equals("MAYBE") == false) goto L36;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x005d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation tannotation, boolean z5) {
        NullabilityQualifier nullabilityQualifier;
        FqName fqName = getFqName(tannotation);
        if (fqName == null) {
            return null;
        }
        ReportLevel invoke = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
        if (invoke.isIgnore()) {
            return null;
        }
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        } else if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        } else if (JvmAnnotationNamesKt.getFORCE_FLEXIBILITY_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
        } else {
            if (!Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION_FQ_NAME())) {
                return null;
            }
            String str = (String) CollectionsKt.firstOrNull(enumArguments(tannotation, false));
            if (str != null) {
                switch (str.hashCode()) {
                    case 73135176:
                        break;
                    case 74175084:
                        break;
                    case 433141802:
                        if (str.equals("UNKNOWN")) {
                            nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
                            break;
                        }
                        return null;
                    case 1933739535:
                        break;
                    default:
                        return null;
                }
            }
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        }
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, invoke.isWarning() || z5);
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation tannotation) {
        FqName fqName = getFqName(tannotation);
        return (fqName == null || !JavaDefaultQualifiersKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(fqName)) ? resolveJsr305AnnotationState(tannotation) : this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation tannotation) {
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        return resolveJsr305CustomState != null ? resolveJsr305CustomState : this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation tannotation) {
        Iterable<String> enumArguments;
        String str;
        ReportLevel reportLevel = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        TAnnotation findAnnotation = findAnnotation(tannotation, JvmAnnotationNamesKt.getUNDER_MIGRATION_ANNOTATION_FQ_NAME());
        if (findAnnotation == null || (enumArguments = enumArguments(findAnnotation, false)) == null || (str = (String) CollectionsKt.firstOrNull(enumArguments)) == null) {
            return null;
        }
        ReportLevel migrationLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (migrationLevel != null) {
            return migrationLevel;
        }
        int hashCode = str.hashCode();
        if (hashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return ReportLevel.IGNORE;
            }
            return null;
        }
        if (hashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return ReportLevel.STRICT;
            }
            return null;
        }
        if (hashCode == 2656902 && str.equals("WARN")) {
            return ReportLevel.WARN;
        }
        return null;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation tannotation) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = JavaDefaultQualifiersKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(tannotation))) == null) {
            return null;
        }
        ReportLevel resolveDefaultAnnotationState = resolveDefaultAnnotationState(tannotation);
        if (resolveDefaultAnnotationState == ReportLevel.IGNORE) {
            resolveDefaultAnnotationState = null;
        }
        if (resolveDefaultAnnotationState == null) {
            return null;
        }
        return JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), null, resolveDefaultAnnotationState.isWarning(), 1, null), null, false, 6, null);
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation tannotation) {
        TAnnotation findAnnotation;
        TAnnotation tannotation2;
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() || (findAnnotation = findAnnotation(tannotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = getMetaAnnotations(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = it.next();
            if (resolveTypeQualifierAnnotation(tannotation2) != null) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = enumArguments.iterator();
        while (it2.hasNext()) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = JAVA_APPLICABILITY_TYPES.get(it2.next());
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new Pair<>(tannotation2, allIfTypeUse(linkedHashSet));
    }

    protected abstract Iterable<String> enumArguments(TAnnotation tannotation, boolean z5);

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, Iterable<? extends TAnnotation> annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return javaTypeQualifiersByElementType;
        }
        ArrayList<JavaDefaultQualifiers> arrayList = new ArrayList();
        Iterator<? extends TAnnotation> it = annotations.iterator();
        while (it.hasNext()) {
            JavaDefaultQualifiers extractDefaultQualifiers = extractDefaultQualifiers(it.next());
            if (extractDefaultQualifiers != null) {
                arrayList.add(extractDefaultQualifiers);
            }
        }
        if (arrayList.isEmpty()) {
            return javaTypeQualifiersByElementType;
        }
        EnumMap enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        for (JavaDefaultQualifiers javaDefaultQualifiers : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : javaDefaultQualifiers.getQualifierApplicabilityTypes()) {
                if (enumMap.containsKey(annotationQualifierApplicabilityType) && isK2()) {
                    JavaDefaultQualifiers javaDefaultQualifiers2 = (JavaDefaultQualifiers) enumMap.get(annotationQualifierApplicabilityType);
                    if (javaDefaultQualifiers2 != null) {
                        NullabilityQualifierWithMigrationStatus nullabilityQualifier = javaDefaultQualifiers2.getNullabilityQualifier();
                        NullabilityQualifierWithMigrationStatus nullabilityQualifier2 = javaDefaultQualifiers.getNullabilityQualifier();
                        if (!Intrinsics.areEqual(nullabilityQualifier2, nullabilityQualifier) && (!nullabilityQualifier2.isForWarningOnly() || nullabilityQualifier.isForWarningOnly())) {
                            javaDefaultQualifiers2 = (nullabilityQualifier2.isForWarningOnly() || !nullabilityQualifier.isForWarningOnly()) ? null : javaDefaultQualifiers;
                        }
                        enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) javaDefaultQualifiers2);
                    }
                } else {
                    enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) javaDefaultQualifiers);
                }
            }
        }
        EnumMap enumMap2 = (javaTypeQualifiersByElementType == null || (defaultQualifiers = javaTypeQualifiersByElementType.getDefaultQualifiers()) == null) ? new EnumMap(AnnotationQualifierApplicabilityType.class) : new EnumMap((EnumMap) defaultQualifiers);
        boolean z5 = false;
        for (Map.Entry entry : enumMap.entrySet()) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = (AnnotationQualifierApplicabilityType) entry.getKey();
            JavaDefaultQualifiers javaDefaultQualifiers3 = (JavaDefaultQualifiers) entry.getValue();
            if (javaDefaultQualifiers3 != null) {
                enumMap2.put((EnumMap) annotationQualifierApplicabilityType2, (AnnotationQualifierApplicabilityType) javaDefaultQualifiers3);
                z5 = true;
            }
        }
        return !z5 ? javaTypeQualifiersByElementType : new JavaTypeQualifiersByElementType(enumMap2);
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> annotations) {
        MutabilityQualifier mutabilityQualifier;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        MutabilityQualifier mutabilityQualifier2 = null;
        while (it.hasNext()) {
            FqName fqName = getFqName(it.next());
            if (CollectionsKt.contains(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (CollectionsKt.contains(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }

    protected abstract FqName getFqName(TAnnotation tannotation);

    protected abstract Object getKey(TAnnotation tannotation);

    protected abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation tannotation);

    public abstract boolean isK2();

    public final boolean isTypeUseAnnotation(TAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        TAnnotation findAnnotation = findAnnotation(annotation, StandardNames.FqNames.target);
        if (findAnnotation == null) {
            return false;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, false);
        if ((enumArguments instanceof Collection) && ((Collection) enumArguments).isEmpty()) {
            return false;
        }
        Iterator<String> it = enumArguments.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), "TYPE")) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation annotation) {
        TAnnotation tannotation;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            return null;
        }
        if (CollectionsKt.contains(JvmAnnotationNamesKt.getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS(), getFqName(annotation)) || hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME())) {
            return annotation;
        }
        if (!hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.resolvedNicknames;
        Object key = getKey(annotation);
        TAnnotation tannotation2 = concurrentHashMap.get(key);
        if (tannotation2 != null) {
            return tannotation2;
        }
        Iterator<TAnnotation> it = getMetaAnnotations(annotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation = null;
                break;
            }
            tannotation = resolveTypeQualifierAnnotation(it.next());
            if (tannotation != null) {
                break;
            }
        }
        if (tannotation == null) {
            return null;
        }
        TAnnotation putIfAbsent = concurrentHashMap.putIfAbsent(key, tannotation);
        return putIfAbsent == null ? tannotation : putIfAbsent;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> annotations, Function1<? super TAnnotation, Boolean> forceWarning) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(forceWarning, "forceWarning");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        while (it.hasNext()) {
            NullabilityQualifierWithMigrationStatus extractNullability = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) it.next(), (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) forceWarning);
            if (nullabilityQualifierWithMigrationStatus != null) {
                if (extractNullability != null && !Intrinsics.areEqual(extractNullability, nullabilityQualifierWithMigrationStatus) && (!extractNullability.isForWarningOnly() || nullabilityQualifierWithMigrationStatus.isForWarningOnly())) {
                    if (extractNullability.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus.isForWarningOnly()) {
                        return null;
                    }
                }
            }
            nullabilityQualifierWithMigrationStatus = extractNullability;
        }
        return nullabilityQualifierWithMigrationStatus;
    }
}
