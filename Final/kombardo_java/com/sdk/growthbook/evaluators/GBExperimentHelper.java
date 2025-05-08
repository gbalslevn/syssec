package com.sdk.growthbook.evaluators;

import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sdk/growthbook/evaluators/GBExperimentHelper;", BuildConfig.FLAVOR, "()V", "trackedExperiments", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isTracked", BuildConfig.FLAVOR, "experiment", "Lcom/sdk/growthbook/model/GBExperiment;", "result", "Lcom/sdk/growthbook/model/GBExperimentResult;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBExperimentHelper {
    private Set<String> trackedExperiments = new LinkedHashSet();

    public final boolean isTracked(GBExperiment experiment, GBExperimentResult result) {
        String str;
        String hashValue;
        Intrinsics.checkNotNullParameter(experiment, "experiment");
        String key = experiment.getKey();
        StringBuilder sb = new StringBuilder();
        String str2 = BuildConfig.FLAVOR;
        if (result == null || (str = result.getHashAttribute()) == null) {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        if (result != null && (hashValue = result.getHashValue()) != null) {
            str2 = hashValue;
        }
        sb.append(str2);
        sb.append(key);
        sb.append(result != null ? Integer.valueOf(result.getVariationId()) : null);
        String sb2 = sb.toString();
        if (this.trackedExperiments.contains(sb2)) {
            return true;
        }
        this.trackedExperiments.add(sb2);
        return false;
    }
}
