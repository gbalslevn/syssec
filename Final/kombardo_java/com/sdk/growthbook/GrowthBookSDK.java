package com.sdk.growthbook;

import com.sdk.growthbook.evaluators.GBExperimentEvaluator;
import com.sdk.growthbook.evaluators.GBFeatureEvaluator;
import com.sdk.growthbook.features.FeaturesDataModel;
import com.sdk.growthbook.features.FeaturesDataSource;
import com.sdk.growthbook.features.FeaturesFlowDelegate;
import com.sdk.growthbook.features.FeaturesViewModel;
import com.sdk.growthbook.model.GBContext;
import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.network.NetworkDispatcher;
import com.sdk.growthbook.utils.Constants;
import com.sdk.growthbook.utils.Crypto;
import com.sdk.growthbook.utils.CryptoKt;
import com.sdk.growthbook.utils.ExtensionsKt;
import com.sdk.growthbook.utils.GBError;
import com.sdk.growthbook.utils.GBRemoteEvalParams;
import com.sdk.growthbook.utils.GBUtils;
import com.sdk.growthbook.utils.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 N2\u00020\u0001:\u0001NBq\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u0010\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r¢\u0006\u0002\u0010\u0013B\u0005¢\u0006\u0002\u0010\u0014J&\u0010\"\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u00100$0#J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000eJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0006H\u0016J(\u0010.\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00102\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0019H\u0002J\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rJ\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010J\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120505J\u0006\u00106\u001a\u00020\u0003J\u000e\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000eJ\u0006\u00109\u001a\u00020\bJ\b\u0010:\u001a\u00020\bH\u0002J\u0014\u0010;\u001a\u00020\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010*H\u0002J\u000e\u0010=\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0018J\u0018\u0010>\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0018\u0010?\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020@2\u0006\u0010-\u001a\u00020\u0006H\u0016J\u001a\u0010A\u001a\u00020\b2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rJ\u001a\u0010C\u001a\u00020\b2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rJ \u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000e2\b\u0010H\u001a\u0004\u0018\u00010IJ\u001a\u0010J\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\rJ\u001a\u0010K\u001a\u00020\b2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rJ\u001a\u0010M\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rR&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0005j\u0002`!0 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/sdk/growthbook/GrowthBookSDK;", "Lcom/sdk/growthbook/features/FeaturesFlowDelegate;", "context", "Lcom/sdk/growthbook/model/GBContext;", "refreshHandler", "Lkotlin/Function2;", org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBError;", org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBCacheRefreshHandler;", "networkDispatcher", "Lcom/sdk/growthbook/network/NetworkDispatcher;", "features", org.conscrypt.BuildConfig.FLAVOR, org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "savedGroups", org.conscrypt.BuildConfig.FLAVOR, "(Lcom/sdk/growthbook/model/GBContext;Lkotlin/jvm/functions/Function2;Lcom/sdk/growthbook/network/NetworkDispatcher;Ljava/util/Map;Ljava/util/Map;)V", "()V", "assigned", org.conscrypt.BuildConfig.FLAVOR, "Lkotlin/Pair;", "Lcom/sdk/growthbook/model/GBExperiment;", "Lcom/sdk/growthbook/model/GBExperimentResult;", "attributeOverrides", "featuresViewModel", "Lcom/sdk/growthbook/features/FeaturesViewModel;", "forcedFeatures", "Lkotlinx/serialization/json/JsonElement;", "subscriptions", org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/GBExperimentRunCallback;", "autoRefreshFeatures", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sdk/growthbook/utils/Resource;", "feature", "Lcom/sdk/growthbook/model/GBFeatureResult;", Constants.ID_ATTRIBUTE_KEY, "featuresAPIModelSuccessfully", "model", "Lcom/sdk/growthbook/features/FeaturesDataModel;", "featuresFetchFailed", "error", "isRemote", "featuresFetchedSuccessfully", "fireSubscriptions", "experiment", "experimentResult", "getAttributeOverrides", "getFeatures", "getForcedFeatures", org.conscrypt.BuildConfig.FLAVOR, "getGBContext", "isOn", "featureId", "refreshCache", "refreshForRemoteEval", "refreshStickyBucketService", "dataModel", "run", "savedGroupsFetchFailed", "savedGroupsFetchedSuccessfully", "Lkotlinx/serialization/json/JsonObject;", "setAttributeOverrides", "overrides", "setAttributes", "attributes", "setEncryptedFeatures", "encryptedString", "encryptionKey", "subtleCrypto", "Lcom/sdk/growthbook/utils/Crypto;", "setForcedFeatures", "setForcedVariations", "forcedVariations", "setSavedGroups", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GrowthBookSDK implements FeaturesFlowDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static GBContext gbContext;
    private Map<String, Pair<GBExperiment, GBExperimentResult>> assigned;
    private Map<String, ? extends Object> attributeOverrides;
    private FeaturesViewModel featuresViewModel;
    private Map<String, ? extends JsonElement> forcedFeatures;
    private NetworkDispatcher networkDispatcher;
    private Function2<? super Boolean, ? super GBError, Unit> refreshHandler;
    private Map<String, ? extends Object> savedGroups;
    private List<Function2<GBExperiment, GBExperimentResult, Unit>> subscriptions;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sdk/growthbook/GrowthBookSDK$Companion;", org.conscrypt.BuildConfig.FLAVOR, "()V", "gbContext", "Lcom/sdk/growthbook/model/GBContext;", "getGbContext$GrowthBook_release", "()Lcom/sdk/growthbook/model/GBContext;", "setGbContext$GrowthBook_release", "(Lcom/sdk/growthbook/model/GBContext;)V", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GBContext getGbContext$GrowthBook_release() {
            GBContext gBContext = GrowthBookSDK.gbContext;
            if (gBContext != null) {
                return gBContext;
            }
            Intrinsics.throwUninitializedPropertyAccessException("gbContext");
            return null;
        }

        public final void setGbContext$GrowthBook_release(GBContext gBContext) {
            Intrinsics.checkNotNullParameter(gBContext, "<set-?>");
            GrowthBookSDK.gbContext = gBContext;
        }

        private Companion() {
        }
    }

    public GrowthBookSDK() {
        this.attributeOverrides = MapsKt.emptyMap();
        this.forcedFeatures = MapsKt.emptyMap();
        this.savedGroups = MapsKt.emptyMap();
        this.assigned = new LinkedHashMap();
        this.subscriptions = new ArrayList();
    }

    private final void fireSubscriptions(GBExperiment experiment, GBExperimentResult experimentResult) {
        String key = experiment.getKey();
        Pair<GBExperiment, GBExperimentResult> pair = this.assigned.get(key);
        if (pair == null || pair.getSecond().getInExperiment() != experimentResult.getInExperiment() || pair.getSecond().getVariationId() != experimentResult.getVariationId()) {
            this.assigned.put(key, TuplesKt.to(experiment, experimentResult));
        }
        Iterator<Function2<GBExperiment, GBExperimentResult, Unit>> it = this.subscriptions.iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(experiment, experimentResult);
            } catch (Exception e5) {
                if (INSTANCE.getGbContext$GrowthBook_release().getEnableLogging()) {
                    System.out.println((Object) ("Error while run subscriptions: " + e5.getMessage()));
                }
            }
        }
    }

    private final void refreshForRemoteEval() {
        Companion companion = INSTANCE;
        if (companion.getGbContext$GrowthBook_release().getRemoteEval()) {
            GBRemoteEvalParams gBRemoteEvalParams = new GBRemoteEvalParams(companion.getGbContext$GrowthBook_release().getAttributes$GrowthBook_release(), getForcedFeatures(), companion.getGbContext$GrowthBook_release().getForcedVariations());
            FeaturesViewModel featuresViewModel = this.featuresViewModel;
            if (featuresViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featuresViewModel");
                featuresViewModel = null;
            }
            featuresViewModel.fetchFeatures(companion.getGbContext$GrowthBook_release().getRemoteEval(), gBRemoteEvalParams);
        }
    }

    private final void refreshStickyBucketService(FeaturesDataModel dataModel) {
        Companion companion = INSTANCE;
        if (companion.getGbContext$GrowthBook_release().getStickyBucketService() != null) {
            GBUtils.INSTANCE.refreshStickyBuckets(companion.getGbContext$GrowthBook_release(), dataModel, this.attributeOverrides);
        }
    }

    static /* synthetic */ void refreshStickyBucketService$default(GrowthBookSDK growthBookSDK, FeaturesDataModel featuresDataModel, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            featuresDataModel = null;
        }
        growthBookSDK.refreshStickyBucketService(featuresDataModel);
    }

    public final Flow<Resource<Map<String, GBFeature>>> autoRefreshFeatures() {
        FeaturesViewModel featuresViewModel = this.featuresViewModel;
        if (featuresViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featuresViewModel");
            featuresViewModel = null;
        }
        return featuresViewModel.autoRefreshFeatures();
    }

    public final GBFeatureResult feature(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return GBFeatureEvaluator.evaluateFeature$default(new GBFeatureEvaluator(), INSTANCE.getGbContext$GrowthBook_release(), id, this.attributeOverrides, null, this.forcedFeatures, 8, null);
    }

    @Override // com.sdk.growthbook.features.FeaturesFlowDelegate
    public void featuresAPIModelSuccessfully(FeaturesDataModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        refreshStickyBucketService(model);
    }

    @Override // com.sdk.growthbook.features.FeaturesFlowDelegate
    public void featuresFetchFailed(GBError error, boolean isRemote) {
        Function2<? super Boolean, ? super GBError, Unit> function2;
        Intrinsics.checkNotNullParameter(error, "error");
        if (!isRemote || (function2 = this.refreshHandler) == null) {
            return;
        }
        function2.invoke(Boolean.FALSE, error);
    }

    @Override // com.sdk.growthbook.features.FeaturesFlowDelegate
    public void featuresFetchedSuccessfully(Map<String, GBFeature> features, boolean isRemote) {
        Function2<? super Boolean, ? super GBError, Unit> function2;
        Intrinsics.checkNotNullParameter(features, "features");
        INSTANCE.getGbContext$GrowthBook_release().setFeatures$GrowthBook_release(features);
        if (!isRemote || (function2 = this.refreshHandler) == null) {
            return;
        }
        function2.invoke(Boolean.TRUE, null);
    }

    public final Map<String, Object> getAttributeOverrides() {
        return this.attributeOverrides;
    }

    public final Map<String, GBFeature> getFeatures() {
        return INSTANCE.getGbContext$GrowthBook_release().getFeatures$GrowthBook_release();
    }

    public final List<List<Object>> getForcedFeatures() {
        Map<String, ? extends JsonElement> map = this.forcedFeatures;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ? extends JsonElement> entry : map.entrySet()) {
            arrayList.add(CollectionsKt.listOf(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public final GBContext getGBContext() {
        return INSTANCE.getGbContext$GrowthBook_release();
    }

    public final boolean isOn(String featureId) {
        Intrinsics.checkNotNullParameter(featureId, "featureId");
        return feature(featureId).getOn();
    }

    public final void refreshCache() {
        if (INSTANCE.getGbContext$GrowthBook_release().getRemoteEval()) {
            refreshForRemoteEval();
            return;
        }
        FeaturesViewModel featuresViewModel = this.featuresViewModel;
        if (featuresViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featuresViewModel");
            featuresViewModel = null;
        }
        FeaturesViewModel.fetchFeatures$default(featuresViewModel, false, null, 3, null);
    }

    public final GBExperimentResult run(GBExperiment experiment) {
        Intrinsics.checkNotNullParameter(experiment, "experiment");
        GBExperimentResult evaluateExperiment$default = GBExperimentEvaluator.evaluateExperiment$default(new GBExperimentEvaluator(), INSTANCE.getGbContext$GrowthBook_release(), experiment, this.attributeOverrides, null, 8, null);
        fireSubscriptions(experiment, evaluateExperiment$default);
        return evaluateExperiment$default;
    }

    @Override // com.sdk.growthbook.features.FeaturesFlowDelegate
    public void savedGroupsFetchFailed(GBError error, boolean isRemote) {
        Function2<? super Boolean, ? super GBError, Unit> function2;
        Intrinsics.checkNotNullParameter(error, "error");
        if (!isRemote || (function2 = this.refreshHandler) == null) {
            return;
        }
        function2.invoke(Boolean.FALSE, error);
    }

    @Override // com.sdk.growthbook.features.FeaturesFlowDelegate
    public void savedGroupsFetchedSuccessfully(JsonObject savedGroups, boolean isRemote) {
        Function2<? super Boolean, ? super GBError, Unit> function2;
        Intrinsics.checkNotNullParameter(savedGroups, "savedGroups");
        INSTANCE.getGbContext$GrowthBook_release().setSavedGroups(ExtensionsKt.toHashMap(savedGroups));
        if (!isRemote || (function2 = this.refreshHandler) == null) {
            return;
        }
        function2.invoke(Boolean.TRUE, null);
    }

    public final void setAttributeOverrides(Map<String, ? extends Object> overrides) {
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.attributeOverrides = overrides;
        if (INSTANCE.getGbContext$GrowthBook_release().getStickyBucketService() != null) {
            refreshStickyBucketService$default(this, null, 1, null);
        }
        refreshForRemoteEval();
    }

    public final void setAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        INSTANCE.getGbContext$GrowthBook_release().setAttributes$GrowthBook_release(attributes);
        refreshStickyBucketService$default(this, null, 1, null);
    }

    public final void setEncryptedFeatures(String encryptedString, String encryptionKey, Crypto subtleCrypto) {
        Intrinsics.checkNotNullParameter(encryptedString, "encryptedString");
        Intrinsics.checkNotNullParameter(encryptionKey, "encryptionKey");
        Map<String, GBFeature> featuresFromEncryptedFeatures = CryptoKt.getFeaturesFromEncryptedFeatures(encryptedString, encryptionKey, subtleCrypto);
        GBContext gbContext$GrowthBook_release = INSTANCE.getGbContext$GrowthBook_release();
        if (featuresFromEncryptedFeatures == null) {
            return;
        }
        gbContext$GrowthBook_release.setFeatures$GrowthBook_release(featuresFromEncryptedFeatures);
    }

    public final void setForcedFeatures(Map<String, ? extends JsonElement> forcedFeatures) {
        Intrinsics.checkNotNullParameter(forcedFeatures, "forcedFeatures");
        this.forcedFeatures = forcedFeatures;
    }

    public final void setForcedVariations(Map<String, ? extends Object> forcedVariations) {
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        INSTANCE.getGbContext$GrowthBook_release().setForcedVariations(forcedVariations);
        refreshForRemoteEval();
    }

    public final void setSavedGroups(Map<String, ? extends Object> savedGroups) {
        Intrinsics.checkNotNullParameter(savedGroups, "savedGroups");
        INSTANCE.getGbContext$GrowthBook_release().setSavedGroups(savedGroups);
    }

    public /* synthetic */ GrowthBookSDK(GBContext gBContext, Function2 function2, NetworkDispatcher networkDispatcher, Map map, Map map2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(gBContext, function2, networkDispatcher, (i5 & 8) != 0 ? null : map, (i5 & 16) != 0 ? null : map2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GrowthBookSDK(GBContext context, Function2<? super Boolean, ? super GBError, Unit> function2, NetworkDispatcher networkDispatcher, Map<String, GBFeature> map, Map<String, ? extends Object> map2) {
        this();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkDispatcher, "networkDispatcher");
        Companion companion = INSTANCE;
        companion.setGbContext$GrowthBook_release(context);
        this.refreshHandler = function2;
        this.networkDispatcher = networkDispatcher;
        this.featuresViewModel = new FeaturesViewModel(this, new FeaturesDataSource(networkDispatcher, context.getEnableLogging()), companion.getGbContext$GrowthBook_release().getEncryptionKey());
        if (map != null) {
            companion.getGbContext$GrowthBook_release().setFeatures$GrowthBook_release(map);
        } else {
            refreshCache();
        }
        this.savedGroups = map2;
        refreshStickyBucketService$default(this, null, 1, null);
    }
}
