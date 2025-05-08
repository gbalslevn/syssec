package com.sdk.growthbook.utils;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\bJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0006HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003JK\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/sdk/growthbook/utils/GBRemoteEvalParams;", BuildConfig.FLAVOR, "attributes", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "forcedFeatures", BuildConfig.FLAVOR, "forcedVariations", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;)V", "getAttributes", "()Ljava/util/Map;", "getForcedFeatures", "()Ljava/util/List;", "getForcedVariations", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GBRemoteEvalParams {
    private final Map<String, Object> attributes;
    private final List<List<Object>> forcedFeatures;
    private final Map<String, Object> forcedVariations;

    /* JADX WARN: Multi-variable type inference failed */
    public GBRemoteEvalParams(Map<String, ? extends Object> attributes, List<? extends List<? extends Object>> forcedFeatures, Map<String, ? extends Object> forcedVariations) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(forcedFeatures, "forcedFeatures");
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        this.attributes = attributes;
        this.forcedFeatures = forcedFeatures;
        this.forcedVariations = forcedVariations;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GBRemoteEvalParams copy$default(GBRemoteEvalParams gBRemoteEvalParams, Map map, List list, Map map2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            map = gBRemoteEvalParams.attributes;
        }
        if ((i5 & 2) != 0) {
            list = gBRemoteEvalParams.forcedFeatures;
        }
        if ((i5 & 4) != 0) {
            map2 = gBRemoteEvalParams.forcedVariations;
        }
        return gBRemoteEvalParams.copy(map, list, map2);
    }

    public final Map<String, Object> component1() {
        return this.attributes;
    }

    public final List<List<Object>> component2() {
        return this.forcedFeatures;
    }

    public final Map<String, Object> component3() {
        return this.forcedVariations;
    }

    public final GBRemoteEvalParams copy(Map<String, ? extends Object> attributes, List<? extends List<? extends Object>> forcedFeatures, Map<String, ? extends Object> forcedVariations) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(forcedFeatures, "forcedFeatures");
        Intrinsics.checkNotNullParameter(forcedVariations, "forcedVariations");
        return new GBRemoteEvalParams(attributes, forcedFeatures, forcedVariations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBRemoteEvalParams)) {
            return false;
        }
        GBRemoteEvalParams gBRemoteEvalParams = (GBRemoteEvalParams) other;
        return Intrinsics.areEqual(this.attributes, gBRemoteEvalParams.attributes) && Intrinsics.areEqual(this.forcedFeatures, gBRemoteEvalParams.forcedFeatures) && Intrinsics.areEqual(this.forcedVariations, gBRemoteEvalParams.forcedVariations);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final List<List<Object>> getForcedFeatures() {
        return this.forcedFeatures;
    }

    public final Map<String, Object> getForcedVariations() {
        return this.forcedVariations;
    }

    public int hashCode() {
        return (((this.attributes.hashCode() * 31) + this.forcedFeatures.hashCode()) * 31) + this.forcedVariations.hashCode();
    }

    public String toString() {
        return "GBRemoteEvalParams(attributes=" + this.attributes + ", forcedFeatures=" + this.forcedFeatures + ", forcedVariations=" + this.forcedVariations + ')';
    }
}
