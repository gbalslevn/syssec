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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\r\u0010\u0017\u001a\u00060\u0007j\u0002`\bHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u0015\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/sdk/growthbook/utils/GBParentConditionInterface;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "condition", "Lkotlinx/serialization/json/JsonElement;", "Lcom/sdk/growthbook/utils/GBCondition;", "gate", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Boolean;)V", "getCondition", "()Lkotlinx/serialization/json/JsonElement;", "getGate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/Boolean;)Lcom/sdk/growthbook/utils/GBParentConditionInterface;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBParentConditionInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JsonElement condition;
    private final Boolean gate;
    private final String id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/GBParentConditionInterface$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/utils/GBParentConditionInterface;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBParentConditionInterface> serializer() {
            return GBParentConditionInterface$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ GBParentConditionInterface(int i5, String str, JsonElement jsonElement, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, GBParentConditionInterface$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.condition = jsonElement;
        if ((i5 & 4) == 0) {
            this.gate = null;
        } else {
            this.gate = bool;
        }
    }

    public static /* synthetic */ GBParentConditionInterface copy$default(GBParentConditionInterface gBParentConditionInterface, String str, JsonElement jsonElement, Boolean bool, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = gBParentConditionInterface.id;
        }
        if ((i5 & 2) != 0) {
            jsonElement = gBParentConditionInterface.condition;
        }
        if ((i5 & 4) != 0) {
            bool = gBParentConditionInterface.gate;
        }
        return gBParentConditionInterface.copy(str, jsonElement, bool);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBParentConditionInterface self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.condition);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.gate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.gate);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getCondition() {
        return this.condition;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getGate() {
        return this.gate;
    }

    public final GBParentConditionInterface copy(String id, JsonElement condition, Boolean gate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(condition, "condition");
        return new GBParentConditionInterface(id, condition, gate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBParentConditionInterface)) {
            return false;
        }
        GBParentConditionInterface gBParentConditionInterface = (GBParentConditionInterface) other;
        return Intrinsics.areEqual(this.id, gBParentConditionInterface.id) && Intrinsics.areEqual(this.condition, gBParentConditionInterface.condition) && Intrinsics.areEqual(this.gate, gBParentConditionInterface.gate);
    }

    public final JsonElement getCondition() {
        return this.condition;
    }

    public final Boolean getGate() {
        return this.gate;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.condition.hashCode()) * 31;
        Boolean bool = this.gate;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "GBParentConditionInterface(id=" + this.id + ", condition=" + this.condition + ", gate=" + this.gate + ')';
    }

    public GBParentConditionInterface(String id, JsonElement condition, Boolean bool) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.id = id;
        this.condition = condition;
        this.gate = bool;
    }

    public /* synthetic */ GBParentConditionInterface(String str, JsonElement jsonElement, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonElement, (i5 & 4) != 0 ? null : bool);
    }
}
