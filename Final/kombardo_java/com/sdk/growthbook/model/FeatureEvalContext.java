package com.sdk.growthbook.model;

import com.sdk.growthbook.utils.Constants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/sdk/growthbook/model/FeatureEvalContext;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "evaluatedFeatures", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/util/Set;)V", "getEvaluatedFeatures", "()Ljava/util/Set;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FeatureEvalContext {
    private final Set<String> evaluatedFeatures;
    private final String id;

    public FeatureEvalContext(String str, Set<String> evaluatedFeatures) {
        Intrinsics.checkNotNullParameter(evaluatedFeatures, "evaluatedFeatures");
        this.id = str;
        this.evaluatedFeatures = evaluatedFeatures;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureEvalContext copy$default(FeatureEvalContext featureEvalContext, String str, Set set, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = featureEvalContext.id;
        }
        if ((i5 & 2) != 0) {
            set = featureEvalContext.evaluatedFeatures;
        }
        return featureEvalContext.copy(str, set);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final Set<String> component2() {
        return this.evaluatedFeatures;
    }

    public final FeatureEvalContext copy(String id, Set<String> evaluatedFeatures) {
        Intrinsics.checkNotNullParameter(evaluatedFeatures, "evaluatedFeatures");
        return new FeatureEvalContext(id, evaluatedFeatures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureEvalContext)) {
            return false;
        }
        FeatureEvalContext featureEvalContext = (FeatureEvalContext) other;
        return Intrinsics.areEqual(this.id, featureEvalContext.id) && Intrinsics.areEqual(this.evaluatedFeatures, featureEvalContext.evaluatedFeatures);
    }

    public final Set<String> getEvaluatedFeatures() {
        return this.evaluatedFeatures;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.evaluatedFeatures.hashCode();
    }

    public String toString() {
        return "FeatureEvalContext(id=" + this.id + ", evaluatedFeatures=" + this.evaluatedFeatures + ')';
    }
}
