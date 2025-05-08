package com.sdk.growthbook.features;

import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.model.GBFeature$$serializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BS\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBG\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/sdk/growthbook/features/FeaturesDataModel;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "features", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "encryptedFeatures", "savedGroups", "Lkotlinx/serialization/json/JsonObject;", "encryptedSavedGroups", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "getEncryptedFeatures", "()Ljava/lang/String;", "getEncryptedSavedGroups", "getFeatures", "()Ljava/util/Map;", "getSavedGroups", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class FeaturesDataModel {
    private final String encryptedFeatures;
    private final String encryptedSavedGroups;
    private final Map<String, GBFeature> features;
    private final JsonObject savedGroups;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.INSTANCE, GBFeature$$serializer.INSTANCE), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/features/FeaturesDataModel$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/features/FeaturesDataModel;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FeaturesDataModel> serializer() {
            return FeaturesDataModel$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public FeaturesDataModel() {
        this((Map) null, (String) null, (JsonObject) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeaturesDataModel copy$default(FeaturesDataModel featuresDataModel, Map map, String str, JsonObject jsonObject, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            map = featuresDataModel.features;
        }
        if ((i5 & 2) != 0) {
            str = featuresDataModel.encryptedFeatures;
        }
        if ((i5 & 4) != 0) {
            jsonObject = featuresDataModel.savedGroups;
        }
        if ((i5 & 8) != 0) {
            str2 = featuresDataModel.encryptedSavedGroups;
        }
        return featuresDataModel.copy(map, str, jsonObject, str2);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(FeaturesDataModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.features != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.features);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.encryptedFeatures != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.encryptedFeatures);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.savedGroups != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, JsonObjectSerializer.INSTANCE, self.savedGroups);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.encryptedSavedGroups == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.encryptedSavedGroups);
    }

    public final Map<String, GBFeature> component1() {
        return this.features;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEncryptedFeatures() {
        return this.encryptedFeatures;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getSavedGroups() {
        return this.savedGroups;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEncryptedSavedGroups() {
        return this.encryptedSavedGroups;
    }

    public final FeaturesDataModel copy(Map<String, GBFeature> features, String encryptedFeatures, JsonObject savedGroups, String encryptedSavedGroups) {
        return new FeaturesDataModel(features, encryptedFeatures, savedGroups, encryptedSavedGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeaturesDataModel)) {
            return false;
        }
        FeaturesDataModel featuresDataModel = (FeaturesDataModel) other;
        return Intrinsics.areEqual(this.features, featuresDataModel.features) && Intrinsics.areEqual(this.encryptedFeatures, featuresDataModel.encryptedFeatures) && Intrinsics.areEqual(this.savedGroups, featuresDataModel.savedGroups) && Intrinsics.areEqual(this.encryptedSavedGroups, featuresDataModel.encryptedSavedGroups);
    }

    public final String getEncryptedFeatures() {
        return this.encryptedFeatures;
    }

    public final String getEncryptedSavedGroups() {
        return this.encryptedSavedGroups;
    }

    public final Map<String, GBFeature> getFeatures() {
        return this.features;
    }

    public final JsonObject getSavedGroups() {
        return this.savedGroups;
    }

    public int hashCode() {
        Map<String, GBFeature> map = this.features;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        String str = this.encryptedFeatures;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonObject jsonObject = this.savedGroups;
        int hashCode3 = (hashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str2 = this.encryptedSavedGroups;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FeaturesDataModel(features=" + this.features + ", encryptedFeatures=" + this.encryptedFeatures + ", savedGroups=" + this.savedGroups + ", encryptedSavedGroups=" + this.encryptedSavedGroups + ')';
    }

    @Deprecated
    public /* synthetic */ FeaturesDataModel(int i5, Map map, String str, JsonObject jsonObject, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.features = null;
        } else {
            this.features = map;
        }
        if ((i5 & 2) == 0) {
            this.encryptedFeatures = null;
        } else {
            this.encryptedFeatures = str;
        }
        if ((i5 & 4) == 0) {
            this.savedGroups = null;
        } else {
            this.savedGroups = jsonObject;
        }
        if ((i5 & 8) == 0) {
            this.encryptedSavedGroups = null;
        } else {
            this.encryptedSavedGroups = str2;
        }
    }

    public FeaturesDataModel(Map<String, GBFeature> map, String str, JsonObject jsonObject, String str2) {
        this.features = map;
        this.encryptedFeatures = str;
        this.savedGroups = jsonObject;
        this.encryptedSavedGroups = str2;
    }

    public /* synthetic */ FeaturesDataModel(Map map, String str, JsonObject jsonObject, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : map, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : jsonObject, (i5 & 8) != 0 ? null : str2);
    }
}
