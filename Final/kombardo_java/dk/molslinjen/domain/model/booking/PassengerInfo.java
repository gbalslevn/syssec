package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/booking/PassengerInfo;", BuildConfig.FLAVOR, "adultCount", BuildConfig.FLAVOR, "childCount", "infantCount", "<init>", "(III)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdultCount", "()I", "getChildCount", "getInfantCount", "totalPassengerCount", "getTotalPassengerCount", "count", "ageGroup", "Ldk/molslinjen/domain/model/booking/AgeGroup;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PassengerInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PassengerInfo mock = new PassengerInfo(3, 1, 1);
    private final int adultCount;
    private final int childCount;
    private final int infantCount;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/PassengerInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PassengerInfo getMock() {
            return PassengerInfo.mock;
        }

        public final KSerializer<PassengerInfo> serializer() {
            return PassengerInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgeGroup.values().length];
            try {
                iArr[AgeGroup.Adult.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgeGroup.Child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgeGroup.Infant.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ PassengerInfo(int i5, int i6, int i7, int i8, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, PassengerInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.adultCount = i6;
        this.childCount = i7;
        this.infantCount = i8;
    }

    public static /* synthetic */ PassengerInfo copy$default(PassengerInfo passengerInfo, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i5 = passengerInfo.adultCount;
        }
        if ((i8 & 2) != 0) {
            i6 = passengerInfo.childCount;
        }
        if ((i8 & 4) != 0) {
            i7 = passengerInfo.infantCount;
        }
        return passengerInfo.copy(i5, i6, i7);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(PassengerInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.adultCount);
        output.encodeIntElement(serialDesc, 1, self.childCount);
        output.encodeIntElement(serialDesc, 2, self.infantCount);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdultCount() {
        return this.adultCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getChildCount() {
        return this.childCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getInfantCount() {
        return this.infantCount;
    }

    public final PassengerInfo copy(int adultCount, int childCount, int infantCount) {
        return new PassengerInfo(adultCount, childCount, infantCount);
    }

    public final int count(AgeGroup ageGroup) {
        Intrinsics.checkNotNullParameter(ageGroup, "ageGroup");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ageGroup.ordinal()];
        if (i5 == 1) {
            return this.adultCount;
        }
        if (i5 == 2) {
            return this.childCount;
        }
        if (i5 == 3) {
            return this.infantCount;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PassengerInfo)) {
            return false;
        }
        PassengerInfo passengerInfo = (PassengerInfo) other;
        return this.adultCount == passengerInfo.adultCount && this.childCount == passengerInfo.childCount && this.infantCount == passengerInfo.infantCount;
    }

    public final int getAdultCount() {
        return this.adultCount;
    }

    public final int getChildCount() {
        return this.childCount;
    }

    public final int getInfantCount() {
        return this.infantCount;
    }

    public final int getTotalPassengerCount() {
        return this.adultCount + this.childCount + this.infantCount;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.adultCount) * 31) + Integer.hashCode(this.childCount)) * 31) + Integer.hashCode(this.infantCount);
    }

    public String toString() {
        return "PassengerInfo(adultCount=" + this.adultCount + ", childCount=" + this.childCount + ", infantCount=" + this.infantCount + ")";
    }

    public PassengerInfo(int i5, int i6, int i7) {
        this.adultCount = i5;
        this.childCount = i6;
        this.infantCount = i7;
    }
}
