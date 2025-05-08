package dk.molslinjen.domain.model.booking;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b¢\u0006\u0004\b\b\u0010\fBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\b\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006."}, d2 = {"Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", BuildConfig.FLAVOR, "totalWeight", BuildConfig.FLAVOR, "note1", BuildConfig.FLAVOR, "note2", "note3", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "notes", BuildConfig.FLAVOR, "(Ljava/lang/Double;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTotalWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getNote1", "()Ljava/lang/String;", "getNote2", "getNote3", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TransportationCargoInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TransportationCargoInfo mock = new TransportationCargoInfo(Double.valueOf(1000.0d), "Note about the transportation", "More notes about the transportation", "Even more notes about the transportation");
    private final String note1;
    private final String note2;
    private final String note3;
    private final Double totalWeight;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/TransportationCargoInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransportationCargoInfo getMock() {
            return TransportationCargoInfo.mock;
        }

        public final KSerializer<TransportationCargoInfo> serializer() {
            return TransportationCargoInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public TransportationCargoInfo() {
        this((Double) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TransportationCargoInfo copy$default(TransportationCargoInfo transportationCargoInfo, Double d5, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            d5 = transportationCargoInfo.totalWeight;
        }
        if ((i5 & 2) != 0) {
            str = transportationCargoInfo.note1;
        }
        if ((i5 & 4) != 0) {
            str2 = transportationCargoInfo.note2;
        }
        if ((i5 & 8) != 0) {
            str3 = transportationCargoInfo.note3;
        }
        return transportationCargoInfo.copy(d5, str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(TransportationCargoInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.totalWeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.totalWeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.note1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.note1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.note2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.note2);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.note3 == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.note3);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNote1() {
        return this.note1;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNote2() {
        return this.note2;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNote3() {
        return this.note3;
    }

    public final TransportationCargoInfo copy(Double totalWeight, String note1, String note2, String note3) {
        return new TransportationCargoInfo(totalWeight, note1, note2, note3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportationCargoInfo)) {
            return false;
        }
        TransportationCargoInfo transportationCargoInfo = (TransportationCargoInfo) other;
        return Intrinsics.areEqual(this.totalWeight, transportationCargoInfo.totalWeight) && Intrinsics.areEqual(this.note1, transportationCargoInfo.note1) && Intrinsics.areEqual(this.note2, transportationCargoInfo.note2) && Intrinsics.areEqual(this.note3, transportationCargoInfo.note3);
    }

    public final String getNote1() {
        return this.note1;
    }

    public final String getNote2() {
        return this.note2;
    }

    public final String getNote3() {
        return this.note3;
    }

    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    public int hashCode() {
        Double d5 = this.totalWeight;
        int hashCode = (d5 == null ? 0 : d5.hashCode()) * 31;
        String str = this.note1;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.note2;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.note3;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TransportationCargoInfo(totalWeight=" + this.totalWeight + ", note1=" + this.note1 + ", note2=" + this.note2 + ", note3=" + this.note3 + ")";
    }

    public /* synthetic */ TransportationCargoInfo(int i5, Double d5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.totalWeight = null;
        } else {
            this.totalWeight = d5;
        }
        if ((i5 & 2) == 0) {
            this.note1 = null;
        } else {
            this.note1 = str;
        }
        if ((i5 & 4) == 0) {
            this.note2 = null;
        } else {
            this.note2 = str2;
        }
        if ((i5 & 8) == 0) {
            this.note3 = null;
        } else {
            this.note3 = str3;
        }
    }

    public TransportationCargoInfo(Double d5, String str, String str2, String str3) {
        this.totalWeight = d5;
        this.note1 = str;
        this.note2 = str2;
        this.note3 = str3;
    }

    public /* synthetic */ TransportationCargoInfo(Double d5, String str, String str2, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : d5, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : str2, (i5 & 8) != 0 ? null : str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransportationCargoInfo(Double d5, List<String> notes) {
        this(d5, (String) CollectionsKt.getOrNull(notes, 0), (String) CollectionsKt.getOrNull(notes, 1), (String) CollectionsKt.getOrNull(notes, 2));
        Intrinsics.checkNotNullParameter(notes, "notes");
    }
}
