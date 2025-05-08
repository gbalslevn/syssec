package com.sdk.growthbook;

import com.sdk.growthbook.model.GBContext;
import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.network.NetworkDispatcher;
import com.sdk.growthbook.sandbox.CachingImpl;
import com.sdk.growthbook.stickybucket.GBStickyBucketService;
import com.sdk.growthbook.stickybucket.GBStickyBucketServiceImp;
import com.sdk.growthbook.utils.GBError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0019\u001a\u00020\u00002\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J+\u0010%\u001a\u00020\u00002\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`#¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R2\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bj\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010)R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010*R0\u0010$\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010)¨\u0006+"}, d2 = {"Lcom/sdk/growthbook/GBSDKBuilder;", "Lcom/sdk/growthbook/SDKBuilder;", org.conscrypt.BuildConfig.FLAVOR, "apiKey", "hostURL", "Lcom/sdk/growthbook/network/NetworkDispatcher;", "networkDispatcher", org.conscrypt.BuildConfig.FLAVOR, org.conscrypt.BuildConfig.FLAVOR, "attributes", "encryptionKey", "Lkotlin/Function2;", "Lcom/sdk/growthbook/model/GBExperiment;", "Lcom/sdk/growthbook/model/GBExperimentResult;", org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/GBTrackingCallback;", "trackingCallback", org.conscrypt.BuildConfig.FLAVOR, "remoteEval", "enableLogging", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sdk/growthbook/network/NetworkDispatcher;Ljava/util/Map;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZ)V", "Lcom/sdk/growthbook/utils/GBError;", "Lcom/sdk/growthbook/utils/GBCacheRefreshHandler;", "refreshHandler", "setRefreshHandler", "(Lkotlin/jvm/functions/Function2;)Lcom/sdk/growthbook/GBSDKBuilder;", "Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", "stickyBucketService", "setStickyBucketService", "(Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;)Lcom/sdk/growthbook/GBSDKBuilder;", "prefix", "setPrefixForStickyBucketCachedDirectory", "(Ljava/lang/String;)Lcom/sdk/growthbook/GBSDKBuilder;", "Lcom/sdk/growthbook/model/GBFeatureResult;", "Lcom/sdk/growthbook/GBFeatureUsageCallback;", "featureUsageCallback", "setFeatureUsageCallback", "Lcom/sdk/growthbook/GrowthBookSDK;", "initialize", "()Lcom/sdk/growthbook/GrowthBookSDK;", "Lkotlin/jvm/functions/Function2;", "Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBSDKBuilder extends SDKBuilder {
    private Function2<? super String, ? super GBFeatureResult, Unit> featureUsageCallback;
    private Function2<? super Boolean, ? super GBError, Unit> refreshHandler;
    private GBStickyBucketService stickyBucketService;

    public /* synthetic */ GBSDKBuilder(String str, String str2, NetworkDispatcher networkDispatcher, Map map, String str3, Function2 function2, boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, networkDispatcher, map, (i5 & 16) != 0 ? null : str3, function2, (i5 & 64) != 0 ? false : z5, (i5 & 128) != 0 ? false : z6);
    }

    public static /* synthetic */ GBSDKBuilder setPrefixForStickyBucketCachedDirectory$default(GBSDKBuilder gBSDKBuilder, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = "gbStickyBuckets__";
        }
        return gBSDKBuilder.setPrefixForStickyBucketCachedDirectory(str);
    }

    public static /* synthetic */ GBSDKBuilder setStickyBucketService$default(GBSDKBuilder gBSDKBuilder, GBStickyBucketService gBStickyBucketService, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gBStickyBucketService = new GBStickyBucketServiceImp(null, CachingImpl.INSTANCE.getLayer(), 1, null);
        }
        return gBSDKBuilder.setStickyBucketService(gBStickyBucketService);
    }

    @Override // com.sdk.growthbook.SDKBuilder
    public GrowthBookSDK initialize() {
        String apiKey = getApiKey();
        boolean enabled = getEnabled();
        Map<String, Object> attributes = getAttributes();
        String hostURL = getHostURL();
        boolean qaMode = getQaMode();
        Map<String, Integer> forcedVariations$GrowthBook_release = getForcedVariations$GrowthBook_release();
        Function2<GBExperiment, GBExperimentResult, Unit> trackingCallback = getTrackingCallback();
        Function2<? super String, ? super GBFeatureResult, Unit> function2 = this.featureUsageCallback;
        return new GrowthBookSDK(new GBContext(apiKey, hostURL, enabled, getEncryptionKey(), attributes, forcedVariations$GrowthBook_release, null, null, this.stickyBucketService, qaMode, trackingCallback, function2, getRemoteEval(), getEnableLogging(), null, 16576, null), this.refreshHandler, getNetworkDispatcher(), null, null, 24, null);
    }

    public final GBSDKBuilder setFeatureUsageCallback(Function2<? super String, ? super GBFeatureResult, Unit> featureUsageCallback) {
        Intrinsics.checkNotNullParameter(featureUsageCallback, "featureUsageCallback");
        this.featureUsageCallback = featureUsageCallback;
        return this;
    }

    public final GBSDKBuilder setPrefixForStickyBucketCachedDirectory(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.stickyBucketService = new GBStickyBucketServiceImp(prefix, CachingImpl.INSTANCE.getLayer());
        return this;
    }

    public final GBSDKBuilder setRefreshHandler(Function2<? super Boolean, ? super GBError, Unit> refreshHandler) {
        Intrinsics.checkNotNullParameter(refreshHandler, "refreshHandler");
        this.refreshHandler = refreshHandler;
        return this;
    }

    public final GBSDKBuilder setStickyBucketService(GBStickyBucketService stickyBucketService) {
        Intrinsics.checkNotNullParameter(stickyBucketService, "stickyBucketService");
        this.stickyBucketService = stickyBucketService;
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GBSDKBuilder(String apiKey, String hostURL, NetworkDispatcher networkDispatcher, Map<String, ? extends Object> attributes, String str, Function2<? super GBExperiment, ? super GBExperimentResult, Unit> trackingCallback, boolean z5, boolean z6) {
        super(apiKey, hostURL, attributes, trackingCallback, str, networkDispatcher, z5, z6);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(hostURL, "hostURL");
        Intrinsics.checkNotNullParameter(networkDispatcher, "networkDispatcher");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(trackingCallback, "trackingCallback");
    }
}
