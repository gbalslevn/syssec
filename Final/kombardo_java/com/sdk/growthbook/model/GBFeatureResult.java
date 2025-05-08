package com.sdk.growthbook.model;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BC\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003JK\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J&\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200HÁ\u0001¢\u0006\u0002\b1R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/sdk/growthbook/model/GBFeatureResult;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "value", "Lkotlinx/serialization/json/JsonElement;", "on", BuildConfig.FLAVOR, "off", "source", "Lcom/sdk/growthbook/model/GBFeatureSource;", "experiment", "Lcom/sdk/growthbook/model/GBExperiment;", "experimentResult", "Lcom/sdk/growthbook/model/GBExperimentResult;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonElement;ZZLcom/sdk/growthbook/model/GBFeatureSource;Lcom/sdk/growthbook/model/GBExperiment;Lcom/sdk/growthbook/model/GBExperimentResult;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lkotlinx/serialization/json/JsonElement;ZZLcom/sdk/growthbook/model/GBFeatureSource;Lcom/sdk/growthbook/model/GBExperiment;Lcom/sdk/growthbook/model/GBExperimentResult;)V", "getExperiment", "()Lcom/sdk/growthbook/model/GBExperiment;", "getExperimentResult", "()Lcom/sdk/growthbook/model/GBExperimentResult;", "getOff", "()Z", "getOn", "getSource", "()Lcom/sdk/growthbook/model/GBFeatureSource;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBFeatureResult {
    private final GBExperiment experiment;
    private final GBExperimentResult experimentResult;
    private final boolean off;
    private final boolean on;
    private final GBFeatureSource source;
    private final JsonElement value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new EnumSerializer("com.sdk.growthbook.model.GBFeatureSource", GBFeatureSource.values()), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/model/GBFeatureResult$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/model/GBFeatureResult;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBFeatureResult> serializer() {
            return GBFeatureResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ GBFeatureResult(int i5, JsonElement jsonElement, boolean z5, boolean z6, GBFeatureSource gBFeatureSource, GBExperiment gBExperiment, GBExperimentResult gBExperimentResult, SerializationConstructorMarker serializationConstructorMarker) {
        if (9 != (i5 & 9)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 9, GBFeatureResult$$serializer.INSTANCE.getDescriptor());
        }
        this.value = jsonElement;
        if ((i5 & 2) == 0) {
            this.on = false;
        } else {
            this.on = z5;
        }
        if ((i5 & 4) == 0) {
            this.off = !this.on;
        } else {
            this.off = z6;
        }
        this.source = gBFeatureSource;
        if ((i5 & 16) == 0) {
            this.experiment = null;
        } else {
            this.experiment = gBExperiment;
        }
        if ((i5 & 32) == 0) {
            this.experimentResult = null;
        } else {
            this.experimentResult = gBExperimentResult;
        }
    }

    public static /* synthetic */ GBFeatureResult copy$default(GBFeatureResult gBFeatureResult, JsonElement jsonElement, boolean z5, boolean z6, GBFeatureSource gBFeatureSource, GBExperiment gBExperiment, GBExperimentResult gBExperimentResult, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            jsonElement = gBFeatureResult.value;
        }
        if ((i5 & 2) != 0) {
            z5 = gBFeatureResult.on;
        }
        boolean z7 = z5;
        if ((i5 & 4) != 0) {
            z6 = gBFeatureResult.off;
        }
        boolean z8 = z6;
        if ((i5 & 8) != 0) {
            gBFeatureSource = gBFeatureResult.source;
        }
        GBFeatureSource gBFeatureSource2 = gBFeatureSource;
        if ((i5 & 16) != 0) {
            gBExperiment = gBFeatureResult.experiment;
        }
        GBExperiment gBExperiment2 = gBExperiment;
        if ((i5 & 32) != 0) {
            gBExperimentResult = gBFeatureResult.experimentResult;
        }
        return gBFeatureResult.copy(jsonElement, z7, z8, gBFeatureSource2, gBExperiment2, gBExperimentResult);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBFeatureResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, JsonElementSerializer.INSTANCE, self.value);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.on) {
            output.encodeBooleanElement(serialDesc, 1, self.on);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.off != (true ^ self.on)) {
            output.encodeBooleanElement(serialDesc, 2, self.off);
        }
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.source);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.experiment != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, GBExperiment$$serializer.INSTANCE, self.experiment);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.experimentResult == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, GBExperimentResult$$serializer.INSTANCE, self.experimentResult);
    }

    /* renamed from: component1, reason: from getter */
    public final JsonElement getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getOn() {
        return this.on;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getOff() {
        return this.off;
    }

    /* renamed from: component4, reason: from getter */
    public final GBFeatureSource getSource() {
        return this.source;
    }

    /* renamed from: component5, reason: from getter */
    public final GBExperiment getExperiment() {
        return this.experiment;
    }

    /* renamed from: component6, reason: from getter */
    public final GBExperimentResult getExperimentResult() {
        return this.experimentResult;
    }

    public final GBFeatureResult copy(JsonElement value, boolean on, boolean off, GBFeatureSource source, GBExperiment experiment, GBExperimentResult experimentResult) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new GBFeatureResult(value, on, off, source, experiment, experimentResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBFeatureResult)) {
            return false;
        }
        GBFeatureResult gBFeatureResult = (GBFeatureResult) other;
        return Intrinsics.areEqual(this.value, gBFeatureResult.value) && this.on == gBFeatureResult.on && this.off == gBFeatureResult.off && this.source == gBFeatureResult.source && Intrinsics.areEqual(this.experiment, gBFeatureResult.experiment) && Intrinsics.areEqual(this.experimentResult, gBFeatureResult.experimentResult);
    }

    public final GBExperiment getExperiment() {
        return this.experiment;
    }

    public final GBExperimentResult getExperimentResult() {
        return this.experimentResult;
    }

    public final boolean getOff() {
        return this.off;
    }

    public final boolean getOn() {
        return this.on;
    }

    public final GBFeatureSource getSource() {
        return this.source;
    }

    public final JsonElement getValue() {
        return this.value;
    }

    public int hashCode() {
        JsonElement jsonElement = this.value;
        int hashCode = (((((((jsonElement == null ? 0 : jsonElement.hashCode()) * 31) + Boolean.hashCode(this.on)) * 31) + Boolean.hashCode(this.off)) * 31) + this.source.hashCode()) * 31;
        GBExperiment gBExperiment = this.experiment;
        int hashCode2 = (hashCode + (gBExperiment == null ? 0 : gBExperiment.hashCode())) * 31;
        GBExperimentResult gBExperimentResult = this.experimentResult;
        return hashCode2 + (gBExperimentResult != null ? gBExperimentResult.hashCode() : 0);
    }

    public String toString() {
        return "GBFeatureResult(value=" + this.value + ", on=" + this.on + ", off=" + this.off + ", source=" + this.source + ", experiment=" + this.experiment + ", experimentResult=" + this.experimentResult + ')';
    }

    public GBFeatureResult(JsonElement jsonElement, boolean z5, boolean z6, GBFeatureSource source, GBExperiment gBExperiment, GBExperimentResult gBExperimentResult) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.value = jsonElement;
        this.on = z5;
        this.off = z6;
        this.source = source;
        this.experiment = gBExperiment;
        this.experimentResult = gBExperimentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GBFeatureResult(JsonElement jsonElement, boolean z5, boolean z6, GBFeatureSource gBFeatureSource, GBExperiment gBExperiment, GBExperimentResult gBExperimentResult, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonElement, r2, (i5 & 4) != 0 ? !r2 : z6, gBFeatureSource, (i5 & 16) != 0 ? null : gBExperiment, (i5 & 32) != 0 ? null : gBExperimentResult);
        boolean z7 = (i5 & 2) != 0 ? false : z5;
    }
}
