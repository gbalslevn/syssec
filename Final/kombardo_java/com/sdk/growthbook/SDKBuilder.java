package com.sdk.growthbook;

import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.network.NetworkDispatcher;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J\b\u0010-\u001a\u00020.H&J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0011J\u001a\u00101\u001a\u00020\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u0006J\u000e\u00102\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/sdk/growthbook/SDKBuilder;", org.conscrypt.BuildConfig.FLAVOR, "apiKey", org.conscrypt.BuildConfig.FLAVOR, "hostURL", "attributes", org.conscrypt.BuildConfig.FLAVOR, "trackingCallback", "Lkotlin/Function2;", "Lcom/sdk/growthbook/model/GBExperiment;", "Lcom/sdk/growthbook/model/GBExperimentResult;", org.conscrypt.BuildConfig.FLAVOR, "Lcom/sdk/growthbook/GBTrackingCallback;", "encryptionKey", "networkDispatcher", "Lcom/sdk/growthbook/network/NetworkDispatcher;", "remoteEval", org.conscrypt.BuildConfig.FLAVOR, "enableLogging", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lcom/sdk/growthbook/network/NetworkDispatcher;ZZ)V", "getApiKey", "()Ljava/lang/String;", "getAttributes", "()Ljava/util/Map;", "getEnableLogging", "()Z", "enabled", "getEnabled$GrowthBook_release", "setEnabled$GrowthBook_release", "(Z)V", "getEncryptionKey", "forcedVariations", org.conscrypt.BuildConfig.FLAVOR, "getForcedVariations$GrowthBook_release", "setForcedVariations$GrowthBook_release", "(Ljava/util/Map;)V", "getHostURL", "getNetworkDispatcher", "()Lcom/sdk/growthbook/network/NetworkDispatcher;", "qaMode", "getQaMode$GrowthBook_release", "setQaMode$GrowthBook_release", "getRemoteEval", "getTrackingCallback", "()Lkotlin/jvm/functions/Function2;", "initialize", "Lcom/sdk/growthbook/GrowthBookSDK;", "setEnabled", "isEnabled", "setForcedVariations", "setQAMode", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SDKBuilder {
    private final String apiKey;
    private final Map<String, Object> attributes;
    private final boolean enableLogging;
    private boolean enabled;
    private final String encryptionKey;
    private Map<String, Integer> forcedVariations;
    private final String hostURL;
    private final NetworkDispatcher networkDispatcher;
    private boolean qaMode;
    private final boolean remoteEval;
    private final Function2<GBExperiment, GBExperimentResult, Unit> trackingCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public SDKBuilder(String apiKey, String hostURL, Map<String, ? extends Object> attributes, Function2<? super GBExperiment, ? super GBExperimentResult, Unit> trackingCallback, String str, NetworkDispatcher networkDispatcher, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(hostURL, "hostURL");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(trackingCallback, "trackingCallback");
        Intrinsics.checkNotNullParameter(networkDispatcher, "networkDispatcher");
        this.apiKey = apiKey;
        this.hostURL = hostURL;
        this.attributes = attributes;
        this.trackingCallback = trackingCallback;
        this.encryptionKey = str;
        this.networkDispatcher = networkDispatcher;
        this.remoteEval = z5;
        this.enableLogging = z6;
        this.forcedVariations = new HashMap();
        this.enabled = true;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final boolean getEnableLogging() {
        return this.enableLogging;
    }

    /* renamed from: getEnabled$GrowthBook_release, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getEncryptionKey() {
        return this.encryptionKey;
    }

    public final Map<String, Integer> getForcedVariations$GrowthBook_release() {
        return this.forcedVariations;
    }

    public final String getHostURL() {
        return this.hostURL;
    }

    public final NetworkDispatcher getNetworkDispatcher() {
        return this.networkDispatcher;
    }

    /* renamed from: getQaMode$GrowthBook_release, reason: from getter */
    public final boolean getQaMode() {
        return this.qaMode;
    }

    public final boolean getRemoteEval() {
        return this.remoteEval;
    }

    public final Function2<GBExperiment, GBExperimentResult, Unit> getTrackingCallback() {
        return this.trackingCallback;
    }

    public abstract GrowthBookSDK initialize();

    public final SDKBuilder setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
        return this;
    }

    public final void setEnabled$GrowthBook_release(boolean z5) {
        this.enabled = z5;
    }

    public final SDKBuilder setForcedVariations(Map<String, Integer> forcedVariations) {
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        this.forcedVariations = forcedVariations;
        return this;
    }

    public final void setForcedVariations$GrowthBook_release(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.forcedVariations = map;
    }

    public final SDKBuilder setQAMode(boolean isEnabled) {
        this.qaMode = isEnabled;
        return this;
    }

    public final void setQaMode$GrowthBook_release(boolean z5) {
        this.qaMode = z5;
    }
}
