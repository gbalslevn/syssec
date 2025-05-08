package com.sdk.growthbook.utils;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÁ\u0001¢\u0006\u0002\b(R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/sdk/growthbook/utils/GBVariationMeta;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "name", "passthrough", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getName", "setName", "getPassthrough", "()Ljava/lang/Boolean;", "setPassthrough", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sdk/growthbook/utils/GBVariationMeta;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBVariationMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String key;
    private String name;
    private Boolean passthrough;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/GBVariationMeta$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/utils/GBVariationMeta;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBVariationMeta> serializer() {
            return GBVariationMeta$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public GBVariationMeta() {
        this((String) null, (String) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GBVariationMeta copy$default(GBVariationMeta gBVariationMeta, String str, String str2, Boolean bool, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = gBVariationMeta.key;
        }
        if ((i5 & 2) != 0) {
            str2 = gBVariationMeta.name;
        }
        if ((i5 & 4) != 0) {
            bool = gBVariationMeta.passthrough;
        }
        return gBVariationMeta.copy(str, str2, bool);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBVariationMeta self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.key != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.key);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.passthrough == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.passthrough);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getPassthrough() {
        return this.passthrough;
    }

    public final GBVariationMeta copy(String key, String name, Boolean passthrough) {
        return new GBVariationMeta(key, name, passthrough);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBVariationMeta)) {
            return false;
        }
        GBVariationMeta gBVariationMeta = (GBVariationMeta) other;
        return Intrinsics.areEqual(this.key, gBVariationMeta.key) && Intrinsics.areEqual(this.name, gBVariationMeta.name) && Intrinsics.areEqual(this.passthrough, gBVariationMeta.passthrough);
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

    public int hashCode() {
        String str = this.key;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.passthrough;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPassthrough(Boolean bool) {
        this.passthrough = bool;
    }

    public String toString() {
        return "GBVariationMeta(key=" + this.key + ", name=" + this.name + ", passthrough=" + this.passthrough + ')';
    }

    @Deprecated
    public /* synthetic */ GBVariationMeta(int i5, String str, String str2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.key = null;
        } else {
            this.key = str;
        }
        if ((i5 & 2) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i5 & 4) == 0) {
            this.passthrough = null;
        } else {
            this.passthrough = bool;
        }
    }

    public GBVariationMeta(String str, String str2, Boolean bool) {
        this.key = str;
        this.name = str2;
        this.passthrough = bool;
    }

    public /* synthetic */ GBVariationMeta(String str, String str2, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : bool);
    }
}
