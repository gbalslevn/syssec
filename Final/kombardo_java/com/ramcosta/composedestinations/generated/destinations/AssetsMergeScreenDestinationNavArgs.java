package com.ramcosta.composedestinations.generated.destinations;

import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeFlowType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/AssetsMergeScreenDestinationNavArgs;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;", "flowType", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;)V", "component1", "()Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;", "getFlowType", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AssetsMergeScreenDestinationNavArgs {
    private final AssetsMergeFlowType flowType;

    public AssetsMergeScreenDestinationNavArgs(AssetsMergeFlowType flowType) {
        Intrinsics.checkNotNullParameter(flowType, "flowType");
        this.flowType = flowType;
    }

    /* renamed from: component1, reason: from getter */
    public final AssetsMergeFlowType getFlowType() {
        return this.flowType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AssetsMergeScreenDestinationNavArgs) && this.flowType == ((AssetsMergeScreenDestinationNavArgs) other).flowType;
    }

    public final AssetsMergeFlowType getFlowType() {
        return this.flowType;
    }

    public int hashCode() {
        return this.flowType.hashCode();
    }

    public String toString() {
        return "AssetsMergeScreenDestinationNavArgs(flowType=" + this.flowType + ")";
    }
}
