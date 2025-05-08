package com.sdk.growthbook.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/sdk/growthbook/model/GBFeature;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "defaultValue", "Lkotlinx/serialization/json/JsonElement;", "rules", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeatureRule;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonElement;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lkotlinx/serialization/json/JsonElement;Ljava/util/List;)V", "getDefaultValue", "()Lkotlinx/serialization/json/JsonElement;", "getRules", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBFeature {
    private final JsonElement defaultValue;
    private final List<GBFeatureRule> rules;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(GBFeatureRule$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/model/GBFeature$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/model/GBFeature;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBFeature> serializer() {
            return GBFeature$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GBFeature() {
        this((JsonElement) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GBFeature copy$default(GBFeature gBFeature, JsonElement jsonElement, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            jsonElement = gBFeature.defaultValue;
        }
        if ((i5 & 2) != 0) {
            list = gBFeature.rules;
        }
        return gBFeature.copy(jsonElement, list);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBFeature self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.defaultValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, JsonElementSerializer.INSTANCE, self.defaultValue);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.rules == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.rules);
    }

    /* renamed from: component1, reason: from getter */
    public final JsonElement getDefaultValue() {
        return this.defaultValue;
    }

    public final List<GBFeatureRule> component2() {
        return this.rules;
    }

    public final GBFeature copy(JsonElement defaultValue, List<GBFeatureRule> rules) {
        return new GBFeature(defaultValue, rules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBFeature)) {
            return false;
        }
        GBFeature gBFeature = (GBFeature) other;
        return Intrinsics.areEqual(this.defaultValue, gBFeature.defaultValue) && Intrinsics.areEqual(this.rules, gBFeature.rules);
    }

    public final JsonElement getDefaultValue() {
        return this.defaultValue;
    }

    public final List<GBFeatureRule> getRules() {
        return this.rules;
    }

    public int hashCode() {
        JsonElement jsonElement = this.defaultValue;
        int hashCode = (jsonElement == null ? 0 : jsonElement.hashCode()) * 31;
        List<GBFeatureRule> list = this.rules;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GBFeature(defaultValue=" + this.defaultValue + ", rules=" + this.rules + ')';
    }

    @Deprecated
    public /* synthetic */ GBFeature(int i5, JsonElement jsonElement, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.defaultValue = null;
        } else {
            this.defaultValue = jsonElement;
        }
        if ((i5 & 2) == 0) {
            this.rules = null;
        } else {
            this.rules = list;
        }
    }

    public GBFeature(JsonElement jsonElement, List<GBFeatureRule> list) {
        this.defaultValue = jsonElement;
        this.rules = list;
    }

    public /* synthetic */ GBFeature(JsonElement jsonElement, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : jsonElement, (i5 & 2) != 0 ? null : list);
    }
}
