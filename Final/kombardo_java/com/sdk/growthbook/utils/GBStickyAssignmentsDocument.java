package com.sdk.growthbook.utils;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&BM\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0004\u0018\u0001`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001a\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\nHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R%\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "attributeName", BuildConfig.FLAVOR, "attributeValue", "assignments", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBStickyExperimentKey;", "Lcom/sdk/growthbook/utils/GBStickyAssignments;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAssignments", "()Ljava/util/Map;", "getAttributeName", "()Ljava/lang/String;", "getAttributeValue", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBStickyAssignmentsDocument {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> assignments;
    private final String attributeName;
    private final String attributeValue;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBStickyAssignmentsDocument> serializer() {
            return GBStickyAssignmentsDocument$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
    }

    @Deprecated
    public /* synthetic */ GBStickyAssignmentsDocument(int i5, String str, String str2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, GBStickyAssignmentsDocument$$serializer.INSTANCE.getDescriptor());
        }
        this.attributeName = str;
        this.attributeValue = str2;
        this.assignments = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GBStickyAssignmentsDocument copy$default(GBStickyAssignmentsDocument gBStickyAssignmentsDocument, String str, String str2, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = gBStickyAssignmentsDocument.attributeName;
        }
        if ((i5 & 2) != 0) {
            str2 = gBStickyAssignmentsDocument.attributeValue;
        }
        if ((i5 & 4) != 0) {
            map = gBStickyAssignmentsDocument.assignments;
        }
        return gBStickyAssignmentsDocument.copy(str, str2, map);
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBStickyAssignmentsDocument self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.attributeName);
        output.encodeStringElement(serialDesc, 1, self.attributeValue);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.assignments);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAttributeName() {
        return this.attributeName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAttributeValue() {
        return this.attributeValue;
    }

    public final Map<String, String> component3() {
        return this.assignments;
    }

    public final GBStickyAssignmentsDocument copy(String attributeName, String attributeValue, Map<String, String> assignments) {
        Intrinsics.checkNotNullParameter(attributeName, "attributeName");
        Intrinsics.checkNotNullParameter(attributeValue, "attributeValue");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        return new GBStickyAssignmentsDocument(attributeName, attributeValue, assignments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBStickyAssignmentsDocument)) {
            return false;
        }
        GBStickyAssignmentsDocument gBStickyAssignmentsDocument = (GBStickyAssignmentsDocument) other;
        return Intrinsics.areEqual(this.attributeName, gBStickyAssignmentsDocument.attributeName) && Intrinsics.areEqual(this.attributeValue, gBStickyAssignmentsDocument.attributeValue) && Intrinsics.areEqual(this.assignments, gBStickyAssignmentsDocument.assignments);
    }

    public final Map<String, String> getAssignments() {
        return this.assignments;
    }

    public final String getAttributeName() {
        return this.attributeName;
    }

    public final String getAttributeValue() {
        return this.attributeValue;
    }

    public int hashCode() {
        return (((this.attributeName.hashCode() * 31) + this.attributeValue.hashCode()) * 31) + this.assignments.hashCode();
    }

    public String toString() {
        return "GBStickyAssignmentsDocument(attributeName=" + this.attributeName + ", attributeValue=" + this.attributeValue + ", assignments=" + this.assignments + ')';
    }

    public GBStickyAssignmentsDocument(String attributeName, String attributeValue, Map<String, String> assignments) {
        Intrinsics.checkNotNullParameter(attributeName, "attributeName");
        Intrinsics.checkNotNullParameter(attributeValue, "attributeValue");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.assignments = assignments;
    }
}
