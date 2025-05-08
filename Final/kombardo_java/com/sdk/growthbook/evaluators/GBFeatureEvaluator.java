package com.sdk.growthbook.evaluators;

import com.sdk.growthbook.model.FeatureEvalContext;
import com.sdk.growthbook.model.GBContext;
import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.model.GBFeatureRule;
import com.sdk.growthbook.model.GBFeatureSource;
import com.sdk.growthbook.utils.Constants;
import com.sdk.growthbook.utils.ExtensionsKt;
import com.sdk.growthbook.utils.GBParentConditionInterface;
import com.sdk.growthbook.utils.GBTrackData;
import com.sdk.growthbook.utils.GBUtils;
import com.sdk.growthbook.utils.OptionalProperty;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\nJ0\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0002J2\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¨\u0006\u0018"}, d2 = {"Lcom/sdk/growthbook/evaluators/GBFeatureEvaluator;", BuildConfig.FLAVOR, "()V", "evaluateFeature", "Lcom/sdk/growthbook/model/GBFeatureResult;", "context", "Lcom/sdk/growthbook/model/GBContext;", "featureKey", BuildConfig.FLAVOR, "attributeOverrides", BuildConfig.FLAVOR, "evalContext", "Lcom/sdk/growthbook/model/FeatureEvalContext;", "forcedFeature", "Lkotlinx/serialization/json/JsonElement;", "getAttributes", "prepareResult", "value", "source", "Lcom/sdk/growthbook/model/GBFeatureSource;", "experiment", "Lcom/sdk/growthbook/model/GBExperiment;", "experimentResult", "Lcom/sdk/growthbook/model/GBExperimentResult;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBFeatureEvaluator {
    public static /* synthetic */ GBFeatureResult evaluateFeature$default(GBFeatureEvaluator gBFeatureEvaluator, GBContext gBContext, String str, Map map, FeatureEvalContext featureEvalContext, Map map2, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            featureEvalContext = new FeatureEvalContext(str, new LinkedHashSet());
        }
        FeatureEvalContext featureEvalContext2 = featureEvalContext;
        if ((i5 & 16) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return gBFeatureEvaluator.evaluateFeature(gBContext, str, map, featureEvalContext2, map2);
    }

    private final Map<String, Object> getAttributes(GBContext context, Map<String, ? extends Object> attributeOverrides) {
        MapsKt.toMutableMap(context.getAttributes$GrowthBook_release()).putAll(attributeOverrides);
        return context.getAttributes$GrowthBook_release();
    }

    private final GBFeatureResult prepareResult(JsonElement value, GBFeatureSource source, GBExperiment experiment, GBExperimentResult experimentResult) {
        boolean z5 = value == null || Intrinsics.areEqual(value.toString(), "false") || value.toString().length() == 0 || Intrinsics.areEqual(value.toString(), "0");
        return new GBFeatureResult(value, !z5, z5, source, experiment, experimentResult);
    }

    static /* synthetic */ GBFeatureResult prepareResult$default(GBFeatureEvaluator gBFeatureEvaluator, JsonElement jsonElement, GBFeatureSource gBFeatureSource, GBExperiment gBExperiment, GBExperimentResult gBExperimentResult, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            gBExperiment = null;
        }
        if ((i5 & 8) != 0) {
            gBExperimentResult = null;
        }
        return gBFeatureEvaluator.prepareResult(jsonElement, gBFeatureSource, gBExperiment, gBExperimentResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03ac  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.sdk.growthbook.model.GBExperimentResult] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17, types: [com.sdk.growthbook.utils.GBParentConditionInterface] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.sdk.growthbook.evaluators.GBExperimentEvaluator] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.sdk.growthbook.evaluators.GBExperimentHelper] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.sdk.growthbook.utils.GBUtils$Companion] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GBFeatureResult evaluateFeature(GBContext context, String featureKey, Map<String, ? extends Object> attributeOverrides, FeatureEvalContext evalContext, Map<String, ? extends JsonElement> forcedFeature) {
        ?? r7;
        GBParentConditionInterface gBParentConditionInterface;
        GBExperimentResult experimentResult;
        JsonElement jsonElement;
        Map emptyMap;
        JsonElement jsonElement2;
        GBContext context2 = context;
        String featureKey2 = featureKey;
        Map<String, ? extends Object> attributeOverrides2 = attributeOverrides;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(featureKey2, "featureKey");
        Intrinsics.checkNotNullParameter(attributeOverrides2, "attributeOverrides");
        Intrinsics.checkNotNullParameter(evalContext, "evalContext");
        Intrinsics.checkNotNullParameter(forcedFeature, "forcedFeature");
        Function2<String, GBFeatureResult, Unit> onFeatureUsage = context.getOnFeatureUsage();
        try {
            if (forcedFeature.containsKey(featureKey2)) {
                if (context.getEnableLogging()) {
                    System.out.println((Object) ("Global override for forced feature with key: " + featureKey2 + " and value " + forcedFeature.get(featureKey2)));
                }
                return prepareResult$default(this, forcedFeature.get(featureKey2), GBFeatureSource.override, null, null, 12, null);
            }
            if (context.getEnableLogging()) {
                System.out.println((Object) "evaluateFeature: circular dependency detected:");
            }
            if (evalContext.getEvaluatedFeatures().contains(featureKey2)) {
                GBFeatureResult prepareResult$default = prepareResult$default(this, null, GBFeatureSource.cyclicPrerequisite, null, null, 12, null);
                if (onFeatureUsage != null) {
                    onFeatureUsage.invoke(featureKey2, prepareResult$default);
                }
                return prepareResult$default;
            }
            evalContext.getEvaluatedFeatures().add(featureKey2);
            GBFeature gBFeature = (GBFeature) MapsKt.getValue(context.getFeatures$GrowthBook_release(), featureKey2);
            List<GBFeatureRule> rules = gBFeature.getRules();
            List<GBFeatureRule> list = rules;
            if (list != null && !list.isEmpty()) {
                for (GBFeatureRule gBFeatureRule : rules) {
                    if (gBFeatureRule.getParentConditions() != null) {
                        Iterator<GBParentConditionInterface> it = gBFeatureRule.getParentConditions().iterator();
                        while (it.hasNext()) {
                            gBParentConditionInterface = it.next();
                            r7 = 0;
                            r7 = 0;
                            GBFeatureResult evaluateFeature$default = evaluateFeature$default(this, context, gBParentConditionInterface.getId(), attributeOverrides, evalContext, null, 16, null);
                            GBFeatureSource source = evaluateFeature$default.getSource();
                            GBFeatureSource gBFeatureSource = GBFeatureSource.cyclicPrerequisite;
                            if (source == gBFeatureSource) {
                                GBFeatureResult prepareResult$default2 = prepareResult$default(this, null, gBFeatureSource, null, null, 12, null);
                                if (onFeatureUsage != null) {
                                    onFeatureUsage.invoke(featureKey2, prepareResult$default2);
                                }
                                return prepareResult$default2;
                            }
                            JsonElement value = evaluateFeature$default.getValue();
                            if (value == null || (emptyMap = MapsKt.mapOf(TuplesKt.to("value", value))) == null) {
                                emptyMap = MapsKt.emptyMap();
                            }
                            GBConditionEvaluator gBConditionEvaluator = new GBConditionEvaluator();
                            JsonElement jsonElement3 = ExtensionsKt.toJsonElement((Map<?, ?>) emptyMap);
                            JsonElement condition = gBParentConditionInterface.getCondition();
                            Map<String, Object> savedGroups = context.getSavedGroups();
                            if (!gBConditionEvaluator.evalCondition(jsonElement3, condition, (savedGroups == null || (jsonElement2 = ExtensionsKt.toJsonElement(savedGroups)) == null) ? null : JsonElementKt.getJsonObject(jsonElement2))) {
                                if (!Intrinsics.areEqual(gBParentConditionInterface.getGate(), Boolean.FALSE)) {
                                    if (context.getEnableLogging()) {
                                        System.out.println((Object) "Feature blocked by prerequisite");
                                    }
                                    GBFeatureResult prepareResult$default3 = prepareResult$default(this, null, GBFeatureSource.prerequisite, null, null, 12, null);
                                    if (onFeatureUsage != null) {
                                        onFeatureUsage.invoke(featureKey2, prepareResult$default3);
                                    }
                                    return prepareResult$default3;
                                }
                            }
                        }
                    }
                    if (gBFeatureRule.getFilters() == null || !GBUtils.INSTANCE.isFilteredOut(gBFeatureRule.getFilters(), context.getAttributes$GrowthBook_release(), context2)) {
                        if (gBFeatureRule.getForce() instanceof OptionalProperty.Present) {
                            if (gBFeatureRule.getCondition() != null) {
                                GBConditionEvaluator gBConditionEvaluator2 = new GBConditionEvaluator();
                                JsonElement jsonElement4 = ExtensionsKt.toJsonElement(getAttributes(context2, attributeOverrides2));
                                JsonElement condition2 = gBFeatureRule.getCondition();
                                Map<String, Object> savedGroups2 = context.getSavedGroups();
                                if (!gBConditionEvaluator2.evalCondition(jsonElement4, condition2, (savedGroups2 == null || (jsonElement = ExtensionsKt.toJsonElement(savedGroups2)) == null) ? null : JsonElementKt.getJsonObject(jsonElement))) {
                                }
                            }
                            boolean z5 = false;
                            boolean z6 = context.getStickyBucketService() != null;
                            boolean areEqual = Intrinsics.areEqual(gBFeatureRule.getDisableStickyBucketing(), Boolean.TRUE);
                            if (z6 && !areEqual) {
                                z5 = true;
                            }
                            ?? r9 = GBUtils.INSTANCE;
                            String seed = gBFeatureRule.getSeed();
                            if (seed == null) {
                                seed = featureKey2;
                            }
                            String hashAttribute = gBFeatureRule.getHashAttribute();
                            ?? r10 = attributeOverrides;
                            r7 = onFeatureUsage;
                            String str = seed;
                            Map<String, ? extends Object> map = attributeOverrides2;
                            String fallbackAttribute = z5 ? gBFeatureRule.getFallbackAttribute() : null;
                            String str2 = featureKey2;
                            GBContext gBContext = context2;
                            try {
                                boolean isIncludedInRollout = r9.isIncludedInRollout(r10, str, hashAttribute, fallbackAttribute, gBFeatureRule.getRange(), gBFeatureRule.getCoverage(), gBFeatureRule.getHashVersion(), context);
                                gBParentConditionInterface = r10;
                                if (isIncludedInRollout) {
                                    if (gBFeatureRule.getTracks() != null) {
                                        for (GBTrackData gBTrackData : gBFeatureRule.getTracks()) {
                                            ?? gBExperimentHelper = new GBExperimentHelper();
                                            GBExperiment experiment = gBTrackData.getExperiment();
                                            r10 = gBTrackData.getResult().getExperimentResult();
                                            if (!gBExperimentHelper.isTracked(experiment, r10) && (experimentResult = gBTrackData.getResult().getExperimentResult()) != null) {
                                                context.getTrackingCallback().invoke(gBTrackData.getExperiment(), experimentResult);
                                            }
                                        }
                                    }
                                    if (gBFeatureRule.getRange() == null && gBFeatureRule.getCoverage() != null) {
                                        String hashAttribute2 = gBFeatureRule.getHashAttribute();
                                        if (hashAttribute2 == null) {
                                            hashAttribute2 = Constants.ID_ATTRIBUTE_KEY;
                                        }
                                        Object obj = context.getAttributes$GrowthBook_release().get(hashAttribute2);
                                        String obj2 = obj != null ? obj.toString() : null;
                                        gBParentConditionInterface = r10;
                                        if (obj2 != null) {
                                            if (obj2.length() == 0) {
                                                gBParentConditionInterface = r10;
                                            } else {
                                                Float hash = GBUtils.INSTANCE.hash(obj2, 1, str2);
                                                if ((hash != null ? hash.floatValue() : 0.0f) > gBFeatureRule.getCoverage().floatValue()) {
                                                    gBParentConditionInterface = r10;
                                                }
                                            }
                                        }
                                    }
                                    GBFeatureResult prepareResult$default4 = prepareResult$default(this, (JsonElement) ((OptionalProperty.Present) gBFeatureRule.getForce()).getValue(), GBFeatureSource.force, null, null, 12, null);
                                    if (r7 != 0) {
                                        r7.invoke(str2, prepareResult$default4);
                                    }
                                    return prepareResult$default4;
                                }
                                attributeOverrides2 = map;
                                context2 = gBContext;
                                featureKey2 = str2;
                                onFeatureUsage = r7;
                            } catch (Exception unused) {
                                gBParentConditionInterface = str2;
                                GBFeatureResult prepareResult$default5 = prepareResult$default(this, null, GBFeatureSource.unknownFeature, null, null, 12, null);
                                if (r7 != 0) {
                                }
                                return prepareResult$default5;
                            }
                        } else {
                            try {
                                r7 = onFeatureUsage;
                                Map<String, ? extends Object> map2 = attributeOverrides2;
                                gBParentConditionInterface = featureKey2;
                                GBContext gBContext2 = context2;
                                List<JsonElement> variations = gBFeatureRule.getVariations();
                                if (variations != null) {
                                    String key = gBFeatureRule.getKey();
                                    String str3 = key == null ? gBParentConditionInterface : key;
                                    Float coverage = gBFeatureRule.getCoverage();
                                    List<Float> weights = gBFeatureRule.getWeights();
                                    GBExperiment gBExperiment = new GBExperiment(str3, variations, gBFeatureRule.getNamespace(), gBFeatureRule.getHashAttribute(), weights, (Boolean) null, coverage, gBFeatureRule.getCondition(), gBFeatureRule.getParentConditions(), (Integer) null, gBFeatureRule.getHashVersion(), gBFeatureRule.getRanges(), gBFeatureRule.getMeta(), gBFeatureRule.getFilters(), gBFeatureRule.getSeed(), gBFeatureRule.getName(), gBFeatureRule.getPhase(), gBFeatureRule.getFallbackAttribute(), gBFeatureRule.getDisableStickyBucketing(), gBFeatureRule.getBucketVersion(), gBFeatureRule.getMinBucketVersion(), 544, (DefaultConstructorMarker) null);
                                    GBExperimentResult evaluateExperiment = new GBExperimentEvaluator().evaluateExperiment(gBContext2, gBExperiment, map2, gBParentConditionInterface);
                                    if (evaluateExperiment.getInExperiment() && !Intrinsics.areEqual(evaluateExperiment.getPassthrough(), Boolean.TRUE)) {
                                        GBFeatureResult prepareResult = prepareResult(evaluateExperiment.getValue(), GBFeatureSource.experiment, gBExperiment, evaluateExperiment);
                                        if (r7 != 0) {
                                            r7.invoke(gBParentConditionInterface, prepareResult);
                                        }
                                        return prepareResult;
                                    }
                                }
                                attributeOverrides2 = map2;
                                context2 = gBContext2;
                                onFeatureUsage = r7;
                                featureKey2 = gBParentConditionInterface;
                            } catch (Exception unused2) {
                                GBFeatureResult prepareResult$default52 = prepareResult$default(this, null, GBFeatureSource.unknownFeature, null, null, 12, null);
                                if (r7 != 0) {
                                    r7.invoke(gBParentConditionInterface, prepareResult$default52);
                                }
                                return prepareResult$default52;
                            }
                        }
                    }
                }
            }
            Function2<String, GBFeatureResult, Unit> function2 = onFeatureUsage;
            String str4 = featureKey2;
            GBFeatureResult prepareResult$default6 = prepareResult$default(this, gBFeature.getDefaultValue(), GBFeatureSource.defaultValue, null, null, 12, null);
            if (function2 != null) {
                function2.invoke(str4, prepareResult$default6);
            }
            return prepareResult$default6;
        } catch (Exception unused3) {
            r7 = onFeatureUsage;
            gBParentConditionInterface = featureKey2;
        }
    }
}
