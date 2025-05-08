package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public abstract class JavaDefaultQualifiersKt {
    private static final List<AnnotationQualifierApplicabilityType> APPLICABILITY_OF_JAVAX_DEFAULTS;
    private static final List<AnnotationQualifierApplicabilityType> APPLICABILITY_OF_JSPECIFY_DEFAULTS;
    private static final Map<FqName, JavaDefaultQualifiers> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    private static final Map<FqName, JavaDefaultQualifiers> JAVAX_DEFAULT_ANNOTATIONS;
    private static final Map<FqName, JavaDefaultQualifiers> JSPECIFY_DEFAULT_ANNOTATIONS;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType3 = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> listOf = CollectionsKt.listOf((Object[]) new AnnotationQualifierApplicabilityType[]{annotationQualifierApplicabilityType, annotationQualifierApplicabilityType2, annotationQualifierApplicabilityType3, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
        APPLICABILITY_OF_JSPECIFY_DEFAULTS = listOf;
        List<AnnotationQualifierApplicabilityType> listOf2 = CollectionsKt.listOf(annotationQualifierApplicabilityType3);
        APPLICABILITY_OF_JAVAX_DEFAULTS = listOf2;
        FqName jspecify_old_null_marked_annotation_fq_name = JvmAnnotationNamesKt.getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<FqName, JavaDefaultQualifiers> mapOf = MapsKt.mapOf(TuplesKt.to(jspecify_old_null_marked_annotation_fq_name, new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), listOf, false)), TuplesKt.to(JvmAnnotationNamesKt.getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), listOf, false)), TuplesKt.to(JvmAnnotationNamesKt.getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null), listOf, false, 4, null)));
        JSPECIFY_DEFAULT_ANNOTATIONS = mapOf;
        Map<FqName, JavaDefaultQualifiers> mapOf2 = MapsKt.mapOf(TuplesKt.to(JvmAnnotationNamesKt.getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), listOf2, false, 4, null)), TuplesKt.to(JvmAnnotationNamesKt.getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null), listOf2, false, 4, null)));
        JAVAX_DEFAULT_ANNOTATIONS = mapOf2;
        BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = MapsKt.plus(mapOf, mapOf2);
    }

    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return JSPECIFY_DEFAULT_ANNOTATIONS;
    }
}
