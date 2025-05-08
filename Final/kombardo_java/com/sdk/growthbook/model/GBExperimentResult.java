package com.sdk.growthbook.model;

import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMB\u008d\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016B\u008d\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0096\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\nHÖ\u0001J&\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JHÁ\u0001¢\u0006\u0002\bKR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b*\u0010!\"\u0004\b+\u0010,R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b-\u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006N"}, d2 = {"Lcom/sdk/growthbook/model/GBExperimentResult;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "inExperiment", BuildConfig.FLAVOR, "variationId", "value", "Lkotlinx/serialization/json/JsonElement;", "hashAttribute", BuildConfig.FLAVOR, "hashValue", "key", "name", "bucket", BuildConfig.FLAVOR, "passthrough", "hashUsed", "featureId", "stickyBucketUsed", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZILkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBucket", "()Ljava/lang/Float;", "setBucket", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFeatureId", "()Ljava/lang/String;", "getHashAttribute", "getHashUsed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHashValue", "getInExperiment", "()Z", "getKey", "getName", "setName", "(Ljava/lang/String;)V", "getPassthrough", "setPassthrough", "(Ljava/lang/Boolean;)V", "getStickyBucketUsed", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "getVariationId", "()I", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZILkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sdk/growthbook/model/GBExperimentResult;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBExperimentResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Float bucket;
    private final String featureId;
    private final String hashAttribute;
    private final Boolean hashUsed;
    private final String hashValue;
    private final boolean inExperiment;
    private final String key;
    private String name;
    private Boolean passthrough;
    private final Boolean stickyBucketUsed;
    private final JsonElement value;
    private final int variationId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/model/GBExperimentResult$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/model/GBExperimentResult;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBExperimentResult> serializer() {
            return GBExperimentResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public GBExperimentResult() {
        this(false, 0, (JsonElement) null, (String) null, (String) null, (String) null, (String) null, (Float) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, 4095, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBExperimentResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.inExperiment) {
            output.encodeBooleanElement(serialDesc, 0, self.inExperiment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.variationId != 0) {
            output.encodeIntElement(serialDesc, 1, self.variationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.value, new JsonObject(new HashMap()))) {
            output.encodeSerializableElement(serialDesc, 2, JsonElementSerializer.INSTANCE, self.value);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hashAttribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.hashAttribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.hashValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.hashValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.key, BuildConfig.FLAVOR)) {
            output.encodeStringElement(serialDesc, 5, self.key);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.bucket != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, FloatSerializer.INSTANCE, self.bucket);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.passthrough != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.passthrough);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.hashUsed != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.hashUsed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.featureId != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.featureId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.stickyBucketUsed == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.stickyBucketUsed);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getInExperiment() {
        return this.inExperiment;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getHashUsed() {
        return this.hashUsed;
    }

    /* renamed from: component11, reason: from getter */
    public final String getFeatureId() {
        return this.featureId;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getStickyBucketUsed() {
        return this.stickyBucketUsed;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVariationId() {
        return this.variationId;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonElement getValue() {
        return this.value;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    /* renamed from: component5, reason: from getter */
    public final String getHashValue() {
        return this.hashValue;
    }

    /* renamed from: component6, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component8, reason: from getter */
    public final Float getBucket() {
        return this.bucket;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getPassthrough() {
        return this.passthrough;
    }

    public final GBExperimentResult copy(boolean inExperiment, int variationId, JsonElement value, String hashAttribute, String hashValue, String key, String name, Float bucket, Boolean passthrough, Boolean hashUsed, String featureId, Boolean stickyBucketUsed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        return new GBExperimentResult(inExperiment, variationId, value, hashAttribute, hashValue, key, name, bucket, passthrough, hashUsed, featureId, stickyBucketUsed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBExperimentResult)) {
            return false;
        }
        GBExperimentResult gBExperimentResult = (GBExperimentResult) other;
        return this.inExperiment == gBExperimentResult.inExperiment && this.variationId == gBExperimentResult.variationId && Intrinsics.areEqual(this.value, gBExperimentResult.value) && Intrinsics.areEqual(this.hashAttribute, gBExperimentResult.hashAttribute) && Intrinsics.areEqual(this.hashValue, gBExperimentResult.hashValue) && Intrinsics.areEqual(this.key, gBExperimentResult.key) && Intrinsics.areEqual(this.name, gBExperimentResult.name) && Intrinsics.areEqual((Object) this.bucket, (Object) gBExperimentResult.bucket) && Intrinsics.areEqual(this.passthrough, gBExperimentResult.passthrough) && Intrinsics.areEqual(this.hashUsed, gBExperimentResult.hashUsed) && Intrinsics.areEqual(this.featureId, gBExperimentResult.featureId) && Intrinsics.areEqual(this.stickyBucketUsed, gBExperimentResult.stickyBucketUsed);
    }

    public final Float getBucket() {
        return this.bucket;
    }

    public final String getFeatureId() {
        return this.featureId;
    }

    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    public final Boolean getHashUsed() {
        return this.hashUsed;
    }

    public final String getHashValue() {
        return this.hashValue;
    }

    public final boolean getInExperiment() {
        return this.inExperiment;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getPassthrough() {
        return this.passthrough;
    }

    public final Boolean getStickyBucketUsed() {
        return this.stickyBucketUsed;
    }

    public final JsonElement getValue() {
        return this.value;
    }

    public final int getVariationId() {
        return this.variationId;
    }

    public int hashCode() {
        int hashCode = ((((Boolean.hashCode(this.inExperiment) * 31) + Integer.hashCode(this.variationId)) * 31) + this.value.hashCode()) * 31;
        String str = this.hashAttribute;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.hashValue;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.key.hashCode()) * 31;
        String str3 = this.name;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f5 = this.bucket;
        int hashCode5 = (hashCode4 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Boolean bool = this.passthrough;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.hashUsed;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str4 = this.featureId;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.stickyBucketUsed;
        return hashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final void setBucket(Float f5) {
        this.bucket = f5;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPassthrough(Boolean bool) {
        this.passthrough = bool;
    }

    public String toString() {
        return "GBExperimentResult(inExperiment=" + this.inExperiment + ", variationId=" + this.variationId + ", value=" + this.value + ", hashAttribute=" + this.hashAttribute + ", hashValue=" + this.hashValue + ", key=" + this.key + ", name=" + this.name + ", bucket=" + this.bucket + ", passthrough=" + this.passthrough + ", hashUsed=" + this.hashUsed + ", featureId=" + this.featureId + ", stickyBucketUsed=" + this.stickyBucketUsed + ')';
    }

    @Deprecated
    public /* synthetic */ GBExperimentResult(int i5, boolean z5, int i6, JsonElement jsonElement, String str, String str2, String str3, String str4, Float f5, Boolean bool, Boolean bool2, String str5, Boolean bool3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.inExperiment = false;
        } else {
            this.inExperiment = z5;
        }
        if ((i5 & 2) == 0) {
            this.variationId = 0;
        } else {
            this.variationId = i6;
        }
        if ((i5 & 4) == 0) {
            this.value = new JsonObject(new HashMap());
        } else {
            this.value = jsonElement;
        }
        if ((i5 & 8) == 0) {
            this.hashAttribute = null;
        } else {
            this.hashAttribute = str;
        }
        if ((i5 & 16) == 0) {
            this.hashValue = null;
        } else {
            this.hashValue = str2;
        }
        if ((i5 & 32) == 0) {
            this.key = BuildConfig.FLAVOR;
        } else {
            this.key = str3;
        }
        if ((i5 & 64) == 0) {
            this.name = null;
        } else {
            this.name = str4;
        }
        if ((i5 & 128) == 0) {
            this.bucket = null;
        } else {
            this.bucket = f5;
        }
        if ((i5 & 256) == 0) {
            this.passthrough = null;
        } else {
            this.passthrough = bool;
        }
        if ((i5 & 512) == 0) {
            this.hashUsed = null;
        } else {
            this.hashUsed = bool2;
        }
        if ((i5 & 1024) == 0) {
            this.featureId = null;
        } else {
            this.featureId = str5;
        }
        if ((i5 & 2048) == 0) {
            this.stickyBucketUsed = null;
        } else {
            this.stickyBucketUsed = bool3;
        }
    }

    public GBExperimentResult(boolean z5, int i5, JsonElement value, String str, String str2, String key, String str3, Float f5, Boolean bool, Boolean bool2, String str4, Boolean bool3) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inExperiment = z5;
        this.variationId = i5;
        this.value = value;
        this.hashAttribute = str;
        this.hashValue = str2;
        this.key = key;
        this.name = str3;
        this.bucket = f5;
        this.passthrough = bool;
        this.hashUsed = bool2;
        this.featureId = str4;
        this.stickyBucketUsed = bool3;
    }

    public /* synthetic */ GBExperimentResult(boolean z5, int i5, JsonElement jsonElement, String str, String str2, String str3, String str4, Float f5, Boolean bool, Boolean bool2, String str5, Boolean bool3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) == 0 ? i5 : 0, (i6 & 4) != 0 ? new JsonObject(new HashMap()) : jsonElement, (i6 & 8) != 0 ? null : str, (i6 & 16) != 0 ? null : str2, (i6 & 32) != 0 ? BuildConfig.FLAVOR : str3, (i6 & 64) != 0 ? null : str4, (i6 & 128) != 0 ? null : f5, (i6 & 256) != 0 ? null : bool, (i6 & 512) != 0 ? null : bool2, (i6 & 1024) != 0 ? null : str5, (i6 & 2048) == 0 ? bool3 : null);
    }
}
