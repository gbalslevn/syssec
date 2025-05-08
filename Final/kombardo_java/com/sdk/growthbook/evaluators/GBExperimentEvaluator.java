package com.sdk.growthbook.evaluators;

import com.sdk.growthbook.model.GBContext;
import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.model.GBFeatureSource;
import com.sdk.growthbook.utils.ExtensionsKt;
import com.sdk.growthbook.utils.GBParentConditionInterface;
import com.sdk.growthbook.utils.GBStickyAssignmentsDocument;
import com.sdk.growthbook.utils.GBUtils;
import com.sdk.growthbook.utils.GBVariationMeta;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJg\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0002¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/sdk/growthbook/evaluators/GBExperimentEvaluator;", BuildConfig.FLAVOR, "()V", "evaluateExperiment", "Lcom/sdk/growthbook/model/GBExperimentResult;", "context", "Lcom/sdk/growthbook/model/GBContext;", "experiment", "Lcom/sdk/growthbook/model/GBExperiment;", "attributeOverrides", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "featureId", "getExperimentResult", "gbContext", "variationIndex", BuildConfig.FLAVOR, "hashUsed", BuildConfig.FLAVOR, "bucket", BuildConfig.FLAVOR, "stickyBucketUsed", "(Lcom/sdk/growthbook/model/GBContext;Lcom/sdk/growthbook/model/GBExperiment;IZLjava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/sdk/growthbook/model/GBExperimentResult;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBExperimentEvaluator {
    public static /* synthetic */ GBExperimentResult evaluateExperiment$default(GBExperimentEvaluator gBExperimentEvaluator, GBContext gBContext, GBExperiment gBExperiment, Map map, String str, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            str = null;
        }
        return gBExperimentEvaluator.evaluateExperiment(gBContext, gBExperiment, map, str);
    }

    private final GBExperimentResult getExperimentResult(GBContext gbContext, GBExperiment experiment, int variationIndex, boolean hashUsed, String featureId, Float bucket, Boolean stickyBucketUsed, Map<String, ? extends Object> attributeOverrides) {
        boolean z5;
        int i5;
        GBContext gBContext;
        Map<String, ? extends Object> map;
        String str;
        String valueOf;
        if (variationIndex < 0 || variationIndex >= experiment.getVariations().size()) {
            z5 = false;
            i5 = 0;
        } else {
            i5 = variationIndex;
            z5 = true;
        }
        GBUtils.Companion companion = GBUtils.INSTANCE;
        String hashAttribute = experiment.getHashAttribute();
        if (gbContext.getStickyBucketService() == null || Intrinsics.areEqual(experiment.getDisableStickyBucketing(), Boolean.TRUE)) {
            gBContext = gbContext;
            map = attributeOverrides;
            str = null;
        } else {
            str = experiment.getFallBackAttribute();
            gBContext = gbContext;
            map = attributeOverrides;
        }
        Pair<String, String> hashAttribute2 = companion.getHashAttribute(gBContext, hashAttribute, str, map);
        String component1 = hashAttribute2.component1();
        String component2 = hashAttribute2.component2();
        List meta = experiment.getMeta();
        if (meta == null) {
            meta = CollectionsKt.emptyList();
        }
        GBVariationMeta gBVariationMeta = meta.size() > i5 ? (GBVariationMeta) meta.get(i5) : null;
        JsonElement jsonElement = experiment.getVariations().size() > i5 ? experiment.getVariations().get(i5) : ExtensionsKt.toJsonElement((Map<?, ?>) MapsKt.mapOf(TuplesKt.to(null, null)));
        if (gBVariationMeta == null || (valueOf = gBVariationMeta.getKey()) == null) {
            valueOf = String.valueOf(i5);
        }
        return new GBExperimentResult(z5, i5, jsonElement, component1, component2, valueOf, gBVariationMeta != null ? gBVariationMeta.getName() : null, bucket, gBVariationMeta != null ? gBVariationMeta.getPassthrough() : null, Boolean.valueOf(hashUsed), featureId, Boolean.valueOf(stickyBucketUsed != null ? stickyBucketUsed.booleanValue() : false));
    }

    static /* synthetic */ GBExperimentResult getExperimentResult$default(GBExperimentEvaluator gBExperimentEvaluator, GBContext gBContext, GBExperiment gBExperiment, int i5, boolean z5, String str, Float f5, Boolean bool, Map map, int i6, Object obj) {
        return gBExperimentEvaluator.getExperimentResult(gBContext, gBExperiment, (i6 & 4) != 0 ? 0 : i5, z5, (i6 & 16) != 0 ? null : str, (i6 & 32) != 0 ? null : f5, (i6 & 64) != 0 ? null : bool, map);
    }

    public final GBExperimentResult evaluateExperiment(GBContext context, GBExperiment experiment, Map<String, ? extends Object> attributeOverrides, String featureId) {
        int i5;
        boolean z5;
        boolean z6;
        int i6;
        Triple<String, Float, Float> gBNameSpace;
        Map emptyMap;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(experiment, "experiment");
        Intrinsics.checkNotNullParameter(attributeOverrides, "attributeOverrides");
        if (experiment.getVariations().size() < 2 || !context.getEnabled()) {
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        Object obj = context.getForcedVariations().get(experiment.getKey());
        if (obj != null) {
            return getExperimentResult$default(this, context, experiment, Integer.parseInt(obj.toString()), false, featureId, null, null, attributeOverrides, 96, null);
        }
        if (Intrinsics.areEqual(experiment.getActive(), Boolean.FALSE)) {
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        GBUtils.Companion companion = GBUtils.INSTANCE;
        Pair<String, String> hashAttribute = companion.getHashAttribute(context, experiment.getHashAttribute(), (context.getStickyBucketService() == null || Intrinsics.areEqual(experiment.getDisableStickyBucketing(), Boolean.TRUE)) ? null : experiment.getFallBackAttribute(), attributeOverrides);
        String component1 = hashAttribute.component1();
        String component2 = hashAttribute.component2();
        if (component2.length() == 0 || Intrinsics.areEqual(component2, "null")) {
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        if (context.getStickyBucketService() == null || Intrinsics.areEqual(experiment.getDisableStickyBucketing(), Boolean.TRUE)) {
            i5 = -1;
            z5 = false;
            z6 = false;
        } else {
            String key = experiment.getKey();
            Integer bucketVersion = experiment.getBucketVersion();
            int intValue = bucketVersion != null ? bucketVersion.intValue() : 0;
            Integer minBucketVersion = experiment.getMinBucketVersion();
            int intValue2 = minBucketVersion != null ? minBucketVersion.intValue() : 0;
            List<GBVariationMeta> meta = experiment.getMeta();
            if (meta == null) {
                meta = CollectionsKt.emptyList();
            }
            Pair<Integer, Boolean> stickyBucketVariation = companion.getStickyBucketVariation(context, key, intValue, intValue2, meta, experiment.getFallBackAttribute(), experiment.getHashAttribute(), attributeOverrides);
            int intValue3 = stickyBucketVariation.component1().intValue();
            Boolean component22 = stickyBucketVariation.component2();
            boolean z7 = intValue3 >= 0;
            z5 = component22 != null ? component22.booleanValue() : false;
            i5 = intValue3;
            z6 = z7;
        }
        if (!z6) {
            if (experiment.getFilters() != null) {
                if (companion.isFilteredOut(experiment.getFilters(), context.getAttributes$GrowthBook_release(), context)) {
                    if (context.getEnableLogging()) {
                        System.out.println((Object) "Skip because of filters");
                    }
                    return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
                }
            } else if (experiment.getNamespace() != null && (gBNameSpace = companion.getGBNameSpace(experiment.getNamespace())) != null && !companion.inNamespace(component2, gBNameSpace)) {
                return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
            }
            if (experiment.getCondition() != null) {
                JsonElement jsonElement3 = ExtensionsKt.toJsonElement(context.getAttributes$GrowthBook_release());
                GBConditionEvaluator gBConditionEvaluator = new GBConditionEvaluator();
                JsonElement condition = experiment.getCondition();
                Intrinsics.checkNotNull(condition);
                Map<String, Object> savedGroups = context.getSavedGroups();
                if (!gBConditionEvaluator.evalCondition(jsonElement3, condition, (savedGroups == null || (jsonElement2 = ExtensionsKt.toJsonElement(savedGroups)) == null) ? null : JsonElementKt.getJsonObject(jsonElement2))) {
                    return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
                }
            }
            if (experiment.getParentConditions() != null) {
                Iterator<GBParentConditionInterface> it = experiment.getParentConditions().iterator();
                while (it.hasNext()) {
                    GBParentConditionInterface next = it.next();
                    GBFeatureResult evaluateFeature$default = GBFeatureEvaluator.evaluateFeature$default(new GBFeatureEvaluator(), context, next.getId(), MapsKt.toMap(JsonElementKt.getJsonObject(next.getCondition())), null, null, 24, null);
                    if (evaluateFeature$default.getSource() == GBFeatureSource.cyclicPrerequisite) {
                        return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
                    }
                    JsonElement value = evaluateFeature$default.getValue();
                    if (value == null || (emptyMap = MapsKt.mapOf(TuplesKt.to("value", GBUtils.INSTANCE.convertToPrimitiveIfPossible(value)))) == null) {
                        emptyMap = MapsKt.emptyMap();
                    }
                    GBConditionEvaluator gBConditionEvaluator2 = new GBConditionEvaluator();
                    JsonElement jsonElement4 = ExtensionsKt.toJsonElement((Map<?, ?>) emptyMap);
                    JsonElement condition2 = next.getCondition();
                    Map<String, Object> savedGroups2 = context.getSavedGroups();
                    if (!gBConditionEvaluator2.evalCondition(jsonElement4, condition2, (savedGroups2 == null || (jsonElement = ExtensionsKt.toJsonElement(savedGroups2)) == null) ? null : JsonElementKt.getJsonObject(jsonElement))) {
                        if (context.getEnableLogging()) {
                            System.out.println((Object) "Feature blocked by prerequisite");
                        }
                        return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
                    }
                }
            }
        }
        GBUtils.Companion companion2 = GBUtils.INSTANCE;
        Integer hashVersion = experiment.getHashVersion();
        Integer valueOf = Integer.valueOf(hashVersion != null ? hashVersion.intValue() : 1);
        String seed = experiment.getSeed();
        if (seed == null) {
            seed = experiment.getKey();
        }
        Float hash = companion2.hash(component2, valueOf, seed);
        if (hash == null) {
            if (context.getEnableLogging()) {
                System.out.println((Object) "Skip because of invalid hash version");
            }
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        if (z6) {
            i6 = i5;
        } else {
            List<Pair<Float, Float>> ranges = experiment.getRanges();
            if (ranges == null) {
                int size = experiment.getVariations().size();
                Float coverage = experiment.getCoverage();
                float floatValue = coverage != null ? coverage.floatValue() : 1.0f;
                List<Float> weights = experiment.getWeights();
                if (weights == null) {
                    weights = CollectionsKt.emptyList();
                }
                ranges = companion2.getBucketRanges(size, floatValue, weights);
            }
            i6 = companion2.chooseVariation(hash.floatValue(), ranges);
        }
        if (z5) {
            if (context.getEnableLogging()) {
                System.out.println((Object) "Skip because sticky bucket version is blocked");
            }
            return getExperimentResult(context, experiment, -1, false, featureId, null, Boolean.TRUE, attributeOverrides);
        }
        if (i6 < 0) {
            if (context.getEnableLogging()) {
                System.out.println((Object) "Skip because of coverage");
            }
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        Integer force = experiment.getForce();
        if (force != null) {
            return getExperimentResult$default(this, context, experiment, force.intValue(), false, featureId, null, null, attributeOverrides, 96, null);
        }
        if (context.getQaMode()) {
            return getExperimentResult$default(this, context, experiment, -1, false, featureId, null, null, attributeOverrides, 96, null);
        }
        GBExperimentResult experimentResult = getExperimentResult(context, experiment, i6, true, featureId, hash, Boolean.valueOf(z6), attributeOverrides);
        if (context.getEnableLogging()) {
            System.out.println((Object) ("ExperimentResult: " + experimentResult));
        }
        if (context.getStickyBucketService() != null && !Intrinsics.areEqual(experiment.getDisableStickyBucketing(), Boolean.TRUE)) {
            String key2 = experiment.getKey();
            Integer bucketVersion2 = experiment.getBucketVersion();
            Triple<String, GBStickyAssignmentsDocument, Boolean> generateStickyBucketAssignmentDoc = companion2.generateStickyBucketAssignmentDoc(context, component1, component2, MapsKt.mapOf(TuplesKt.to(companion2.getStickyBucketExperimentKey(key2, bucketVersion2 != null ? bucketVersion2.intValue() : 0), experimentResult.getKey())));
            String component12 = generateStickyBucketAssignmentDoc.component1();
            GBStickyAssignmentsDocument component23 = generateStickyBucketAssignmentDoc.component2();
            if (generateStickyBucketAssignmentDoc.component3().booleanValue()) {
                Map<String, GBStickyAssignmentsDocument> stickyBucketAssignmentDocs = context.getStickyBucketAssignmentDocs();
                if (stickyBucketAssignmentDocs == null) {
                    stickyBucketAssignmentDocs = MapsKt.emptyMap();
                }
                Map<String, GBStickyAssignmentsDocument> mutableMap = MapsKt.toMutableMap(stickyBucketAssignmentDocs);
                mutableMap.put(component12, component23);
                context.setStickyBucketAssignmentDocs(mutableMap);
                context.getStickyBucketService().saveAssignments(component23);
            }
        }
        if (!context.getExperimentHelper().isTracked(experiment, experimentResult)) {
            context.getTrackingCallback().invoke(experiment, experimentResult);
        }
        return experimentResult;
    }
}
