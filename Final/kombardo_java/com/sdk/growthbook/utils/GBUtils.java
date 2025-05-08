package com.sdk.growthbook.utils;

import com.ionspin.kotlin.bignum.integer.BigInteger;
import com.sdk.growthbook.features.FeaturesDataModel;
import com.sdk.growthbook.model.GBContext;
import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.model.GBFeatureRule;
import com.sdk.growthbook.stickybucket.GBStickyBucketService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonPrimitive;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/sdk/growthbook/utils/GBUtils;", BuildConfig.FLAVOR, "()V", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\n0\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0001J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002JD\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aJ<\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\n0\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u001c\u001a\u00020\u0004J(\u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0004\u0018\u0001`!2\u0006\u0010\"\u001a\u00020#JD\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001aJD\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u000e2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001aH\u0002J:\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001aH\u0002J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u0004Jt\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00160\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002020\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000e2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001aJ)\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u00107J\u001a\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u00109\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0002J,\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u000e2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0014j\u0002`!J3\u0010<\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001a\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0002\u0010>J4\u0010?\u001a\u00020\u00162\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\b2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010Ju\u0010B\u001a\u00020\u00162\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001a2\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u0010C\u001a\u0004\u0018\u00010\u000e2\b\u0010D\u001a\u0004\u0018\u00010\u000e2\u001a\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eJ,\u0010H\u001a\u00020I2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u001aJ\u0014\u0010J\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u0004H\u0002¨\u0006L"}, d2 = {"Lcom/sdk/growthbook/utils/GBUtils$Companion;", BuildConfig.FLAVOR, "()V", "chooseVariation", BuildConfig.FLAVOR, "n", BuildConfig.FLAVOR, "ranges", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Lcom/sdk/growthbook/utils/GBBucketRange;", "convertToPrimitiveIfPossible", "jsonElement", "deriveStickyBucketIdentifierAttributes", BuildConfig.FLAVOR, "context", "Lcom/sdk/growthbook/model/GBContext;", "data", "Lcom/sdk/growthbook/features/FeaturesDataModel;", "generateStickyBucketAssignmentDoc", "Lkotlin/Triple;", "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", BuildConfig.FLAVOR, "attributeName", "attributeValue", "assignments", BuildConfig.FLAVOR, "getBucketRanges", "numVariations", "coverage", "weights", "getEqualWeights", "getGBNameSpace", "Lcom/sdk/growthbook/utils/GBNameSpace;", "namespace", "Lkotlinx/serialization/json/JsonArray;", "getHashAttribute", "attr", "fallback", "attributeOverrides", "getStickyBucketAssignments", "expHashAttribute", "expFallBackAttribute", "getStickyBucketAttributes", "getStickyBucketExperimentKey", "experimentKey", "experimentBucketVersion", "getStickyBucketVariation", "minExperimentBucketVersion", "meta", "Lcom/sdk/growthbook/utils/GBVariationMeta;", "hash", "stringValue", "hashVersion", "seed", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/Float;", "hashV1", "hashV2", "inNamespace", "userId", "inRange", "range", "(Ljava/lang/Float;Lkotlin/Pair;)Z", "isFilteredOut", "filters", "Lcom/sdk/growthbook/utils/GBFilter;", "isIncludedInRollout", "hashAttribute", "fallbackAttribute", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/Float;Ljava/lang/Integer;Lcom/sdk/growthbook/model/GBContext;)Z", "paddedVersionString", "input", "refreshStickyBuckets", BuildConfig.FLAVOR, "roundTo", "numFractionDigits", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> deriveStickyBucketIdentifierAttributes(GBContext context, FeaturesDataModel data) {
            Map<String, GBFeature> features$GrowthBook_release;
            List<GBFeatureRule> rules;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (data == null || (features$GrowthBook_release = data.getFeatures()) == null) {
                features$GrowthBook_release = context.getFeatures$GrowthBook_release();
            }
            Iterator<T> it = features$GrowthBook_release.keySet().iterator();
            while (it.hasNext()) {
                GBFeature gBFeature = features$GrowthBook_release.get((String) it.next());
                if (gBFeature != null && (rules = gBFeature.getRules()) != null) {
                    for (GBFeatureRule gBFeatureRule : rules) {
                        if (gBFeatureRule.getVariations() != null) {
                            String hashAttribute = gBFeatureRule.getHashAttribute();
                            if (hashAttribute == null) {
                                hashAttribute = Constants.ID_ATTRIBUTE_KEY;
                            }
                            linkedHashSet.add(hashAttribute);
                            String fallbackAttribute = gBFeatureRule.getFallbackAttribute();
                            if (fallbackAttribute != null) {
                                linkedHashSet.add(fallbackAttribute);
                            }
                        }
                    }
                }
            }
            return CollectionsKt.toList(linkedHashSet);
        }

        public static /* synthetic */ Pair getHashAttribute$default(Companion companion, GBContext gBContext, String str, String str2, Map map, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                str2 = null;
            }
            return companion.getHashAttribute(gBContext, str, str2, map);
        }

        private final Map<String, String> getStickyBucketAssignments(GBContext context, String expHashAttribute, String expFallBackAttribute, Map<String, ? extends Object> attributeOverrides) {
            String str;
            GBStickyAssignmentsDocument gBStickyAssignmentsDocument;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, GBStickyAssignmentsDocument> stickyBucketAssignmentDocs = context.getStickyBucketAssignmentDocs();
            if (stickyBucketAssignmentDocs == null) {
                return linkedHashMap;
            }
            Pair<String, String> hashAttribute = getHashAttribute(context, expHashAttribute, null, attributeOverrides);
            String str2 = hashAttribute.component1() + "||" + hashAttribute.component2();
            Pair<String, String> hashAttribute2 = getHashAttribute(context, null, expFallBackAttribute, attributeOverrides);
            String component1 = hashAttribute2.component1();
            String component2 = hashAttribute2.component2();
            if (component2.length() == 0) {
                str = null;
            } else {
                str = component1 + "||" + component2;
            }
            GBStickyAssignmentsDocument gBStickyAssignmentsDocument2 = stickyBucketAssignmentDocs.get(expFallBackAttribute + "||" + attributeOverrides.get(expFallBackAttribute));
            if (!Intrinsics.areEqual(gBStickyAssignmentsDocument2 != null ? gBStickyAssignmentsDocument2.getAttributeValue() : null, attributeOverrides.get(expFallBackAttribute))) {
                context.setStickyBucketAssignmentDocs(MapsKt.emptyMap());
            }
            if (str != null && (gBStickyAssignmentsDocument = stickyBucketAssignmentDocs.get(str)) != null) {
                linkedHashMap.putAll(gBStickyAssignmentsDocument.getAssignments());
            }
            GBStickyAssignmentsDocument gBStickyAssignmentsDocument3 = stickyBucketAssignmentDocs.get(str2);
            if (gBStickyAssignmentsDocument3 != null) {
                linkedHashMap.putAll(gBStickyAssignmentsDocument3.getAssignments());
            }
            return linkedHashMap;
        }

        private final Map<String, String> getStickyBucketAttributes(GBContext context, FeaturesDataModel data, Map<String, ? extends Object> attributeOverrides) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<String> stickyBucketIdentifierAttributes = context.getStickyBucketIdentifierAttributes();
            if (stickyBucketIdentifierAttributes == null) {
                stickyBucketIdentifierAttributes = deriveStickyBucketIdentifierAttributes(context, data);
            }
            context.setStickyBucketIdentifierAttributes(stickyBucketIdentifierAttributes);
            List<String> stickyBucketIdentifierAttributes2 = context.getStickyBucketIdentifierAttributes();
            if (stickyBucketIdentifierAttributes2 != null) {
                for (String str : stickyBucketIdentifierAttributes2) {
                    linkedHashMap.put(str, getHashAttribute$default(GBUtils.INSTANCE, context, str, null, attributeOverrides, 4, null).getSecond());
                }
            }
            return linkedHashMap;
        }

        public static /* synthetic */ String getStickyBucketExperimentKey$default(Companion companion, String str, int i5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i5 = 0;
            }
            return companion.getStickyBucketExperimentKey(str, i5);
        }

        private final float hashV1(String stringValue, String seed) {
            return Float.parseFloat(new FNV().fnv1a32(stringValue + seed).remainder(new BigInteger(com.adjust.sdk.Constants.ONE_SECOND)).toString()) / 1000.0f;
        }

        private final float hashV2(String stringValue, String seed) {
            return Float.parseFloat(new FNV().fnv1a32(new FNV().fnv1a32(seed + stringValue).toString()).remainder(new BigInteger(10000)).toString()) / 10000.0f;
        }

        private final boolean inRange(Float n5, Pair<Float, Float> range) {
            return n5 != null && range != null && n5.floatValue() >= range.getFirst().floatValue() && n5.floatValue() < range.getSecond().floatValue();
        }

        private final float roundTo(float f5, int i5) {
            return MathKt.roundToInt(f5 * r6) / ((float) Math.pow(10.0f, i5));
        }

        public final int chooseVariation(float n5, List<Pair<Float, Float>> ranges) {
            Intrinsics.checkNotNullParameter(ranges, "ranges");
            Iterator<Pair<Float, Float>> it = ranges.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                int i6 = i5 + 1;
                if (inRange(Float.valueOf(n5), it.next())) {
                    return i5;
                }
                i5 = i6;
            }
            return -1;
        }

        public final Object convertToPrimitiveIfPossible(Object jsonElement) {
            if (!(jsonElement instanceof JsonPrimitive)) {
                return jsonElement;
            }
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            Object intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
            if (intOrNull != null || (intOrNull = JsonElementKt.getLongOrNull(jsonPrimitive)) != null || (intOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive)) != null || (intOrNull = JsonElementKt.getFloatOrNull(jsonPrimitive)) != null || (intOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive)) != null) {
                return intOrNull;
            }
            String contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive);
            return contentOrNull == null ? jsonElement : contentOrNull;
        }

        public final Triple<String, GBStickyAssignmentsDocument, Boolean> generateStickyBucketAssignmentDoc(GBContext context, String attributeName, String attributeValue, Map<String, String> assignments) {
            Map<String, String> emptyMap;
            GBStickyAssignmentsDocument gBStickyAssignmentsDocument;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeName, "attributeName");
            Intrinsics.checkNotNullParameter(attributeValue, "attributeValue");
            Intrinsics.checkNotNullParameter(assignments, "assignments");
            String str = attributeName + "||" + attributeValue;
            Map<String, GBStickyAssignmentsDocument> stickyBucketAssignmentDocs = context.getStickyBucketAssignmentDocs();
            if (stickyBucketAssignmentDocs == null || (gBStickyAssignmentsDocument = stickyBucketAssignmentDocs.get(str)) == null || (emptyMap = gBStickyAssignmentsDocument.getAssignments()) == null) {
                emptyMap = MapsKt.emptyMap();
            }
            Map mutableMap = MapsKt.toMutableMap(emptyMap);
            mutableMap.putAll(assignments);
            return new Triple<>(str, new GBStickyAssignmentsDocument(attributeName, attributeValue, mutableMap), Boolean.valueOf(!Intrinsics.areEqual(emptyMap, mutableMap)));
        }

        public final List<Pair<Float, Float>> getBucketRanges(int numVariations, float coverage, List<Float> weights) {
            float f5 = 0.0f;
            float f6 = coverage < 0.0f ? 0.0f : coverage;
            if (coverage > 1.0f) {
                f6 = 1.0f;
            }
            List<Float> equalWeights = getEqualWeights(numVariations);
            if (weights == null) {
                weights = equalWeights;
            }
            if (weights.size() == numVariations) {
                equalWeights = weights;
            }
            Iterator<T> it = equalWeights.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = Float.valueOf(((Number) next).floatValue() + ((Number) it.next()).floatValue());
            }
            double floatValue = ((Number) next).floatValue();
            if (floatValue < 0.99d || floatValue > 1.01d) {
                equalWeights = getEqualWeights(numVariations);
            }
            List<Float> list = equalWeights;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                float floatValue2 = ((Number) it2.next()).floatValue();
                Companion companion = GBUtils.INSTANCE;
                arrayList.add(new Pair(Float.valueOf(companion.roundTo(f5, 4)), Float.valueOf(companion.roundTo(f5 + (floatValue2 * f6), 4))));
                f5 += floatValue2;
            }
            return arrayList;
        }

        public final List<Float> getEqualWeights(int numVariations) {
            if (numVariations <= 0) {
                return CollectionsKt.emptyList();
            }
            float f5 = 1.0f / numVariations;
            ArrayList arrayList = new ArrayList(numVariations);
            for (int i5 = 0; i5 < numVariations; i5++) {
                arrayList.add(Float.valueOf(f5));
            }
            return arrayList;
        }

        public final Triple<String, Float, Float> getGBNameSpace(JsonArray namespace) {
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            if (namespace.size() < 3) {
                return null;
            }
            String contentOrNull = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(namespace.get(0)));
            Float floatOrNull = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(namespace.get(1)));
            Float floatOrNull2 = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(namespace.get(2)));
            if (contentOrNull == null || floatOrNull == null || floatOrNull2 == null) {
                return null;
            }
            return new Triple<>(contentOrNull, floatOrNull, floatOrNull2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0067, code lost:
        
            if (r0.length() > 0) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Pair<String, String> getHashAttribute(GBContext context, String attr, String fallback, Map<String, ? extends Object> attributeOverrides) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeOverrides, "attributeOverrides");
            if (attr == null) {
                attr = Constants.ID_ATTRIBUTE_KEY;
            }
            String valueOf = attributeOverrides.get(attr) != null ? String.valueOf(attributeOverrides.get(attr)) : context.getAttributes$GrowthBook_release().get(attr) != null ? String.valueOf(context.getAttributes$GrowthBook_release().get(attr)) : BuildConfig.FLAVOR;
            if (valueOf.length() == 0 && fallback != null) {
                if (attributeOverrides.get(fallback) != null) {
                    valueOf = String.valueOf(attributeOverrides.get(fallback));
                } else if (context.getAttributes$GrowthBook_release().get(fallback) != null) {
                    valueOf = String.valueOf(context.getAttributes$GrowthBook_release().get(fallback));
                }
            }
            fallback = attr;
            return new Pair<>(fallback, valueOf);
        }

        public final String getStickyBucketExperimentKey(String experimentKey, int experimentBucketVersion) {
            Intrinsics.checkNotNullParameter(experimentKey, "experimentKey");
            return experimentKey + "__" + experimentBucketVersion;
        }

        public final Pair<Integer, Boolean> getStickyBucketVariation(GBContext context, String experimentKey, int experimentBucketVersion, int minExperimentBucketVersion, List<GBVariationMeta> meta, String expFallBackAttribute, String expHashAttribute, Map<String, ? extends Object> attributeOverrides) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(experimentKey, "experimentKey");
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(attributeOverrides, "attributeOverrides");
            String stickyBucketExperimentKey = getStickyBucketExperimentKey(experimentKey, experimentBucketVersion);
            Map<String, String> stickyBucketAssignments = getStickyBucketAssignments(context, expHashAttribute, expFallBackAttribute, attributeOverrides);
            int i5 = 0;
            int i6 = -1;
            if (minExperimentBucketVersion > 0 && minExperimentBucketVersion >= 0) {
                for (int i7 = 0; !stickyBucketAssignments.containsKey(getStickyBucketExperimentKey(experimentKey, i7)); i7++) {
                    if (i7 != minExperimentBucketVersion) {
                    }
                }
                return new Pair<>(-1, Boolean.TRUE);
            }
            String str = stickyBucketAssignments.get(stickyBucketExperimentKey);
            if (str == null) {
                return new Pair<>(-1, null);
            }
            Iterator<GBVariationMeta> it = meta.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it.next().getKey(), str)) {
                    i6 = i5;
                    break;
                }
                i5++;
            }
            return i6 >= 0 ? new Pair<>(Integer.valueOf(i6), null) : new Pair<>(-1, null);
        }

        public final Float hash(String stringValue, Integer hashVersion, String seed) {
            Intrinsics.checkNotNullParameter(stringValue, "stringValue");
            if (hashVersion == null) {
                return null;
            }
            int intValue = hashVersion.intValue();
            if (intValue == 1) {
                return Float.valueOf(hashV1(stringValue, seed));
            }
            if (intValue != 2) {
                return null;
            }
            return Float.valueOf(hashV2(stringValue, seed));
        }

        public final boolean inNamespace(String userId, Triple<String, Float, Float> namespace) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(namespace, "namespace");
            Float hash = hash(userId + "__", 1, namespace.getFirst());
            if (hash != null) {
                return inRange(hash, new Pair<>(namespace.getSecond(), namespace.getThird()));
            }
            return false;
        }

        public final boolean isFilteredOut(List<GBFilter> filters, Map<String, ? extends Object> attributeOverrides, GBContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (filters == null || attributeOverrides == null) {
                return false;
            }
            List<GBFilter> list = filters;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (GBFilter gBFilter : list) {
                String attribute = gBFilter.getAttribute();
                if (attribute == null) {
                    attribute = Constants.ID_ATTRIBUTE_KEY;
                }
                JsonElement jsonElement = (JsonElement) MapsKt.getValue(JsonElementKt.getJsonObject(ExtensionsKt.toJsonElement(context.getAttributes$GrowthBook_release())), attribute);
                if (!(jsonElement instanceof JsonNull) && (jsonElement instanceof JsonPrimitive)) {
                    String jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement).toString();
                    if (jsonPrimitive.length() != 0) {
                        Integer hashVersion = gBFilter.getHashVersion();
                        Float hash = GBUtils.INSTANCE.hash(jsonPrimitive, Integer.valueOf(hashVersion != null ? hashVersion.intValue() : 2), gBFilter.getSeed());
                        if (hash != null) {
                            List<Pair<Float, Float>> ranges = gBFilter.getRanges();
                            if (!(ranges instanceof Collection) || !ranges.isEmpty()) {
                                Iterator<T> it = ranges.iterator();
                                while (it.hasNext()) {
                                    if (GBUtils.INSTANCE.inRange(hash, (Pair) it.next())) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }

        public final boolean isIncludedInRollout(Map<String, ? extends Object> attributeOverrides, String seed, String hashAttribute, String fallbackAttribute, Pair<Float, Float> range, Float coverage, Integer hashVersion, GBContext context) {
            Intrinsics.checkNotNullParameter(attributeOverrides, "attributeOverrides");
            Intrinsics.checkNotNullParameter(context, "context");
            if (range == null && coverage == null) {
                return true;
            }
            Float hash = hash(getHashAttribute(context, hashAttribute, fallbackAttribute, attributeOverrides).component2(), Integer.valueOf(hashVersion != null ? hashVersion.intValue() : 1), seed);
            if (hash != null) {
                return range != null ? inRange(hash, range) : coverage == null || hash.floatValue() <= coverage.floatValue();
            }
            return false;
        }

        public final String paddedVersionString(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            List<String> split = new Regex("[-.]").split(new Regex("^v|\\+.*$").replace(input, BuildConfig.FLAVOR), 0);
            if (split.size() == 3) {
                ArrayList arrayList = new ArrayList(split);
                arrayList.add("~");
                split = arrayList;
            }
            return CollectionsKt.joinToString$default(split, "-", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.sdk.growthbook.utils.GBUtils$Companion$paddedVersionString$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Regex("^\\d+$").matches(it) ? StringsKt.padStart(it, 5, ' ') : it;
                }
            }, 30, null);
        }

        public final void refreshStickyBuckets(GBContext context, FeaturesDataModel data, Map<String, ? extends Object> attributeOverrides) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeOverrides, "attributeOverrides");
            GBStickyBucketService stickyBucketService = context.getStickyBucketService();
            if (stickyBucketService == null) {
                return;
            }
            context.setStickyBucketAssignmentDocs(stickyBucketService.getAllAssignments(getStickyBucketAttributes(context, data, attributeOverrides)));
        }

        private Companion() {
        }
    }
}
