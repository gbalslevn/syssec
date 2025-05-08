package com.sdk.growthbook.utils;

import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperiment$$serializer;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.model.GBFeatureResult$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/sdk/growthbook/utils/GBTrackData;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "experiment", "Lcom/sdk/growthbook/model/GBExperiment;", "result", "Lcom/sdk/growthbook/model/GBFeatureResult;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sdk/growthbook/model/GBExperiment;Lcom/sdk/growthbook/model/GBFeatureResult;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sdk/growthbook/model/GBExperiment;Lcom/sdk/growthbook/model/GBFeatureResult;)V", "getExperiment", "()Lcom/sdk/growthbook/model/GBExperiment;", "setExperiment", "(Lcom/sdk/growthbook/model/GBExperiment;)V", "getResult", "()Lcom/sdk/growthbook/model/GBFeatureResult;", "setResult", "(Lcom/sdk/growthbook/model/GBFeatureResult;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBTrackData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GBExperiment experiment;
    private GBFeatureResult result;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/GBTrackData$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/utils/GBTrackData;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBTrackData> serializer() {
            return GBTrackData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ GBTrackData(int i5, GBExperiment gBExperiment, GBFeatureResult gBFeatureResult, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, GBTrackData$$serializer.INSTANCE.getDescriptor());
        }
        this.experiment = gBExperiment;
        this.result = gBFeatureResult;
    }

    public static /* synthetic */ GBTrackData copy$default(GBTrackData gBTrackData, GBExperiment gBExperiment, GBFeatureResult gBFeatureResult, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gBExperiment = gBTrackData.experiment;
        }
        if ((i5 & 2) != 0) {
            gBFeatureResult = gBTrackData.result;
        }
        return gBTrackData.copy(gBExperiment, gBFeatureResult);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBTrackData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, GBExperiment$$serializer.INSTANCE, self.experiment);
        output.encodeSerializableElement(serialDesc, 1, GBFeatureResult$$serializer.INSTANCE, self.result);
    }

    /* renamed from: component1, reason: from getter */
    public final GBExperiment getExperiment() {
        return this.experiment;
    }

    /* renamed from: component2, reason: from getter */
    public final GBFeatureResult getResult() {
        return this.result;
    }

    public final GBTrackData copy(GBExperiment experiment, GBFeatureResult result) {
        Intrinsics.checkNotNullParameter(experiment, "experiment");
        Intrinsics.checkNotNullParameter(result, "result");
        return new GBTrackData(experiment, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBTrackData)) {
            return false;
        }
        GBTrackData gBTrackData = (GBTrackData) other;
        return Intrinsics.areEqual(this.experiment, gBTrackData.experiment) && Intrinsics.areEqual(this.result, gBTrackData.result);
    }

    public final GBExperiment getExperiment() {
        return this.experiment;
    }

    public final GBFeatureResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return (this.experiment.hashCode() * 31) + this.result.hashCode();
    }

    public final void setExperiment(GBExperiment gBExperiment) {
        Intrinsics.checkNotNullParameter(gBExperiment, "<set-?>");
        this.experiment = gBExperiment;
    }

    public final void setResult(GBFeatureResult gBFeatureResult) {
        Intrinsics.checkNotNullParameter(gBFeatureResult, "<set-?>");
        this.result = gBFeatureResult;
    }

    public String toString() {
        return "GBTrackData(experiment=" + this.experiment + ", result=" + this.result + ')';
    }

    public GBTrackData(GBExperiment experiment, GBFeatureResult result) {
        Intrinsics.checkNotNullParameter(experiment, "experiment");
        Intrinsics.checkNotNullParameter(result, "result");
        this.experiment = experiment;
        this.result = result;
    }
}
