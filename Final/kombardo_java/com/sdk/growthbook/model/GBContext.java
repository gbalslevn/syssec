package com.sdk.growthbook.model;

import com.sdk.growthbook.evaluators.GBExperimentHelper;
import com.sdk.growthbook.stickybucket.GBStickyBucketService;
import com.sdk.growthbook.utils.GBStickyAssignmentsDocument;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0014j\u0002`\u0018\u0012\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\u0010\u001eJ\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\u001f\u0010F\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0014j\u0002`\u0018HÆ\u0003J\u001d\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\u0017\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001a\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tHÀ\u0003¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003J\u001b\u0010Q\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u008d\u0002\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0014j\u0002`\u00182\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0001J\u0013\u0010U\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020XHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R*\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020.0\tj\u0002`/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R%\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R,\u0010\u000b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR'\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0014j\u0002`\u0018¢\u0006\b\n\u0000\u001a\u0004\bC\u00106¨\u0006Z"}, d2 = {"Lcom/sdk/growthbook/model/GBContext;", BuildConfig.FLAVOR, "apiKey", BuildConfig.FLAVOR, "hostURL", "enabled", BuildConfig.FLAVOR, "encryptionKey", "attributes", BuildConfig.FLAVOR, "forcedVariations", "stickyBucketAssignmentDocs", "Lcom/sdk/growthbook/utils/GBStickyAttributeKey;", "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", "stickyBucketIdentifierAttributes", BuildConfig.FLAVOR, "stickyBucketService", "Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", "qaMode", "trackingCallback", "Lkotlin/Function2;", "Lcom/sdk/growthbook/model/GBExperiment;", "Lcom/sdk/growthbook/model/GBExperimentResult;", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/GBTrackingCallback;", "onFeatureUsage", "Lcom/sdk/growthbook/model/GBFeatureResult;", "remoteEval", "enableLogging", "savedGroups", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZLjava/util/Map;)V", "getApiKey", "()Ljava/lang/String;", "getAttributes$GrowthBook_release", "()Ljava/util/Map;", "setAttributes$GrowthBook_release", "(Ljava/util/Map;)V", "getEnableLogging", "()Z", "getEnabled", "getEncryptionKey", "experimentHelper", "Lcom/sdk/growthbook/evaluators/GBExperimentHelper;", "getExperimentHelper$GrowthBook_release", "()Lcom/sdk/growthbook/evaluators/GBExperimentHelper;", "features", "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "getFeatures$GrowthBook_release", "setFeatures$GrowthBook_release", "getForcedVariations", "setForcedVariations", "getHostURL", "getOnFeatureUsage", "()Lkotlin/jvm/functions/Function2;", "getQaMode", "getRemoteEval", "getSavedGroups", "setSavedGroups", "getStickyBucketAssignmentDocs", "setStickyBucketAssignmentDocs", "getStickyBucketIdentifierAttributes", "()Ljava/util/List;", "setStickyBucketIdentifierAttributes", "(Ljava/util/List;)V", "getStickyBucketService", "()Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", "getTrackingCallback", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component5$GrowthBook_release", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GBContext {
    private final String apiKey;
    private Map<String, ? extends Object> attributes;
    private final boolean enableLogging;
    private final boolean enabled;
    private final String encryptionKey;
    private final GBExperimentHelper experimentHelper;
    private Map<String, GBFeature> features;
    private Map<String, ? extends Object> forcedVariations;
    private final String hostURL;
    private final Function2<String, GBFeatureResult, Unit> onFeatureUsage;
    private final boolean qaMode;
    private final boolean remoteEval;
    private Map<String, ? extends Object> savedGroups;
    private Map<String, GBStickyAssignmentsDocument> stickyBucketAssignmentDocs;
    private List<String> stickyBucketIdentifierAttributes;
    private final GBStickyBucketService stickyBucketService;
    private final Function2<GBExperiment, GBExperimentResult, Unit> trackingCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public GBContext(String apiKey, String hostURL, boolean z5, String str, Map<String, ? extends Object> attributes, Map<String, ? extends Object> forcedVariations, Map<String, GBStickyAssignmentsDocument> map, List<String> list, GBStickyBucketService gBStickyBucketService, boolean z6, Function2<? super GBExperiment, ? super GBExperimentResult, Unit> trackingCallback, Function2<? super String, ? super GBFeatureResult, Unit> function2, boolean z7, boolean z8, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(hostURL, "hostURL");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        Intrinsics.checkNotNullParameter(trackingCallback, "trackingCallback");
        this.apiKey = apiKey;
        this.hostURL = hostURL;
        this.enabled = z5;
        this.encryptionKey = str;
        this.attributes = attributes;
        this.forcedVariations = forcedVariations;
        this.stickyBucketAssignmentDocs = map;
        this.stickyBucketIdentifierAttributes = list;
        this.stickyBucketService = gBStickyBucketService;
        this.qaMode = z6;
        this.trackingCallback = trackingCallback;
        this.onFeatureUsage = function2;
        this.remoteEval = z7;
        this.enableLogging = z8;
        this.savedGroups = map2;
        this.features = new HashMap();
        this.experimentHelper = new GBExperimentHelper();
    }

    /* renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getQaMode() {
        return this.qaMode;
    }

    public final Function2<GBExperiment, GBExperimentResult, Unit> component11() {
        return this.trackingCallback;
    }

    public final Function2<String, GBFeatureResult, Unit> component12() {
        return this.onFeatureUsage;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getRemoteEval() {
        return this.remoteEval;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getEnableLogging() {
        return this.enableLogging;
    }

    public final Map<String, Object> component15() {
        return this.savedGroups;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHostURL() {
        return this.hostURL;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEncryptionKey() {
        return this.encryptionKey;
    }

    public final Map<String, Object> component5$GrowthBook_release() {
        return this.attributes;
    }

    public final Map<String, Object> component6() {
        return this.forcedVariations;
    }

    public final Map<String, GBStickyAssignmentsDocument> component7() {
        return this.stickyBucketAssignmentDocs;
    }

    public final List<String> component8() {
        return this.stickyBucketIdentifierAttributes;
    }

    /* renamed from: component9, reason: from getter */
    public final GBStickyBucketService getStickyBucketService() {
        return this.stickyBucketService;
    }

    public final GBContext copy(String apiKey, String hostURL, boolean enabled, String encryptionKey, Map<String, ? extends Object> attributes, Map<String, ? extends Object> forcedVariations, Map<String, GBStickyAssignmentsDocument> stickyBucketAssignmentDocs, List<String> stickyBucketIdentifierAttributes, GBStickyBucketService stickyBucketService, boolean qaMode, Function2<? super GBExperiment, ? super GBExperimentResult, Unit> trackingCallback, Function2<? super String, ? super GBFeatureResult, Unit> onFeatureUsage, boolean remoteEval, boolean enableLogging, Map<String, ? extends Object> savedGroups) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(hostURL, "hostURL");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        Intrinsics.checkNotNullParameter(trackingCallback, "trackingCallback");
        return new GBContext(apiKey, hostURL, enabled, encryptionKey, attributes, forcedVariations, stickyBucketAssignmentDocs, stickyBucketIdentifierAttributes, stickyBucketService, qaMode, trackingCallback, onFeatureUsage, remoteEval, enableLogging, savedGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBContext)) {
            return false;
        }
        GBContext gBContext = (GBContext) other;
        return Intrinsics.areEqual(this.apiKey, gBContext.apiKey) && Intrinsics.areEqual(this.hostURL, gBContext.hostURL) && this.enabled == gBContext.enabled && Intrinsics.areEqual(this.encryptionKey, gBContext.encryptionKey) && Intrinsics.areEqual(this.attributes, gBContext.attributes) && Intrinsics.areEqual(this.forcedVariations, gBContext.forcedVariations) && Intrinsics.areEqual(this.stickyBucketAssignmentDocs, gBContext.stickyBucketAssignmentDocs) && Intrinsics.areEqual(this.stickyBucketIdentifierAttributes, gBContext.stickyBucketIdentifierAttributes) && Intrinsics.areEqual(this.stickyBucketService, gBContext.stickyBucketService) && this.qaMode == gBContext.qaMode && Intrinsics.areEqual(this.trackingCallback, gBContext.trackingCallback) && Intrinsics.areEqual(this.onFeatureUsage, gBContext.onFeatureUsage) && this.remoteEval == gBContext.remoteEval && this.enableLogging == gBContext.enableLogging && Intrinsics.areEqual(this.savedGroups, gBContext.savedGroups);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final Map<String, Object> getAttributes$GrowthBook_release() {
        return this.attributes;
    }

    public final boolean getEnableLogging() {
        return this.enableLogging;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getEncryptionKey() {
        return this.encryptionKey;
    }

    /* renamed from: getExperimentHelper$GrowthBook_release, reason: from getter */
    public final GBExperimentHelper getExperimentHelper() {
        return this.experimentHelper;
    }

    public final Map<String, GBFeature> getFeatures$GrowthBook_release() {
        return this.features;
    }

    public final Map<String, Object> getForcedVariations() {
        return this.forcedVariations;
    }

    public final String getHostURL() {
        return this.hostURL;
    }

    public final Function2<String, GBFeatureResult, Unit> getOnFeatureUsage() {
        return this.onFeatureUsage;
    }

    public final boolean getQaMode() {
        return this.qaMode;
    }

    public final boolean getRemoteEval() {
        return this.remoteEval;
    }

    public final Map<String, Object> getSavedGroups() {
        return this.savedGroups;
    }

    public final Map<String, GBStickyAssignmentsDocument> getStickyBucketAssignmentDocs() {
        return this.stickyBucketAssignmentDocs;
    }

    public final List<String> getStickyBucketIdentifierAttributes() {
        return this.stickyBucketIdentifierAttributes;
    }

    public final GBStickyBucketService getStickyBucketService() {
        return this.stickyBucketService;
    }

    public final Function2<GBExperiment, GBExperimentResult, Unit> getTrackingCallback() {
        return this.trackingCallback;
    }

    public int hashCode() {
        int hashCode = ((((this.apiKey.hashCode() * 31) + this.hostURL.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31;
        String str = this.encryptionKey;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.attributes.hashCode()) * 31) + this.forcedVariations.hashCode()) * 31;
        Map<String, GBStickyAssignmentsDocument> map = this.stickyBucketAssignmentDocs;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        List<String> list = this.stickyBucketIdentifierAttributes;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        GBStickyBucketService gBStickyBucketService = this.stickyBucketService;
        int hashCode5 = (((((hashCode4 + (gBStickyBucketService == null ? 0 : gBStickyBucketService.hashCode())) * 31) + Boolean.hashCode(this.qaMode)) * 31) + this.trackingCallback.hashCode()) * 31;
        Function2<String, GBFeatureResult, Unit> function2 = this.onFeatureUsage;
        int hashCode6 = (((((hashCode5 + (function2 == null ? 0 : function2.hashCode())) * 31) + Boolean.hashCode(this.remoteEval)) * 31) + Boolean.hashCode(this.enableLogging)) * 31;
        Map<String, ? extends Object> map2 = this.savedGroups;
        return hashCode6 + (map2 != null ? map2.hashCode() : 0);
    }

    public final void setAttributes$GrowthBook_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.attributes = map;
    }

    public final void setFeatures$GrowthBook_release(Map<String, GBFeature> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.features = map;
    }

    public final void setForcedVariations(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.forcedVariations = map;
    }

    public final void setSavedGroups(Map<String, ? extends Object> map) {
        this.savedGroups = map;
    }

    public final void setStickyBucketAssignmentDocs(Map<String, GBStickyAssignmentsDocument> map) {
        this.stickyBucketAssignmentDocs = map;
    }

    public final void setStickyBucketIdentifierAttributes(List<String> list) {
        this.stickyBucketIdentifierAttributes = list;
    }

    public String toString() {
        return "GBContext(apiKey=" + this.apiKey + ", hostURL=" + this.hostURL + ", enabled=" + this.enabled + ", encryptionKey=" + this.encryptionKey + ", attributes=" + this.attributes + ", forcedVariations=" + this.forcedVariations + ", stickyBucketAssignmentDocs=" + this.stickyBucketAssignmentDocs + ", stickyBucketIdentifierAttributes=" + this.stickyBucketIdentifierAttributes + ", stickyBucketService=" + this.stickyBucketService + ", qaMode=" + this.qaMode + ", trackingCallback=" + this.trackingCallback + ", onFeatureUsage=" + this.onFeatureUsage + ", remoteEval=" + this.remoteEval + ", enableLogging=" + this.enableLogging + ", savedGroups=" + this.savedGroups + ')';
    }

    public /* synthetic */ GBContext(String str, String str2, boolean z5, String str3, Map map, Map map2, Map map3, List list, GBStickyBucketService gBStickyBucketService, boolean z6, Function2 function2, Function2 function22, boolean z7, boolean z8, Map map4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z5, str3, map, map2, (i5 & 64) != 0 ? null : map3, (i5 & 128) != 0 ? null : list, (i5 & 256) != 0 ? null : gBStickyBucketService, z6, function2, (i5 & 2048) != 0 ? null : function22, (i5 & 4096) != 0 ? false : z7, (i5 & 8192) != 0 ? false : z8, (i5 & 16384) != 0 ? null : map4);
    }
}
