package dk.molslinjen.api.services.account.request;

import dk.molslinjen.api.services.account.creditcard.request.RegisterCreditCardRequestParameter;
import dk.molslinjen.api.services.account.creditcard.request.RegisterCreditCardRequestParameter$$serializer;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter$$serializer;
import dk.molslinjen.api.services.account.vehicle.request.RegisterVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.request.RegisterVehicleRequestParameter$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0010HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u00061"}, d2 = {"Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", BuildConfig.FLAVOR, "multiRides", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "vehicles", "Ldk/molslinjen/api/services/account/vehicle/request/RegisterVehicleRequestParameter;", "passengers", "Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", "creditCards", "Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;", "reservations", "Ldk/molslinjen/api/services/account/request/MergeTicketsRequestParameter;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMultiRides", "()Ljava/util/List;", "getVehicles", "getPassengers$annotations", "()V", "getPassengers", "getCreditCards", "getReservations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MergeAccountAssetsRequestParameters {
    private final List<RegisterCreditCardRequestParameter> creditCards;
    private final List<String> multiRides;
    private final List<RegisterPassengerRequestParameter> passengers;
    private final List<MergeTicketsRequestParameter> reservations;
    private final List<RegisterVehicleRequestParameter> vehicles;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(RegisterVehicleRequestParameter$$serializer.INSTANCE), new ArrayListSerializer(RegisterPassengerRequestParameter$$serializer.INSTANCE), new ArrayListSerializer(RegisterCreditCardRequestParameter$$serializer.INSTANCE), new ArrayListSerializer(MergeTicketsRequestParameter$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MergeAccountAssetsRequestParameters> serializer() {
            return MergeAccountAssetsRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MergeAccountAssetsRequestParameters(int i5, List list, List list2, List list3, List list4, List list5, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, MergeAccountAssetsRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.multiRides = list;
        this.vehicles = list2;
        this.passengers = list3;
        this.creditCards = list4;
        this.reservations = list5;
    }

    public static /* synthetic */ MergeAccountAssetsRequestParameters copy$default(MergeAccountAssetsRequestParameters mergeAccountAssetsRequestParameters, List list, List list2, List list3, List list4, List list5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = mergeAccountAssetsRequestParameters.multiRides;
        }
        if ((i5 & 2) != 0) {
            list2 = mergeAccountAssetsRequestParameters.vehicles;
        }
        List list6 = list2;
        if ((i5 & 4) != 0) {
            list3 = mergeAccountAssetsRequestParameters.passengers;
        }
        List list7 = list3;
        if ((i5 & 8) != 0) {
            list4 = mergeAccountAssetsRequestParameters.creditCards;
        }
        List list8 = list4;
        if ((i5 & 16) != 0) {
            list5 = mergeAccountAssetsRequestParameters.reservations;
        }
        return mergeAccountAssetsRequestParameters.copy(list, list6, list7, list8, list5);
    }

    public static /* synthetic */ void getPassengers$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MergeAccountAssetsRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.multiRides);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.vehicles);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.passengers);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.creditCards);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.reservations);
    }

    public final List<String> component1() {
        return this.multiRides;
    }

    public final List<RegisterVehicleRequestParameter> component2() {
        return this.vehicles;
    }

    public final List<RegisterPassengerRequestParameter> component3() {
        return this.passengers;
    }

    public final List<RegisterCreditCardRequestParameter> component4() {
        return this.creditCards;
    }

    public final List<MergeTicketsRequestParameter> component5() {
        return this.reservations;
    }

    public final MergeAccountAssetsRequestParameters copy(List<String> multiRides, List<RegisterVehicleRequestParameter> vehicles, List<? extends RegisterPassengerRequestParameter> passengers, List<RegisterCreditCardRequestParameter> creditCards, List<MergeTicketsRequestParameter> reservations) {
        Intrinsics.checkNotNullParameter(multiRides, "multiRides");
        Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        Intrinsics.checkNotNullParameter(passengers, "passengers");
        Intrinsics.checkNotNullParameter(creditCards, "creditCards");
        Intrinsics.checkNotNullParameter(reservations, "reservations");
        return new MergeAccountAssetsRequestParameters(multiRides, vehicles, passengers, creditCards, reservations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeAccountAssetsRequestParameters)) {
            return false;
        }
        MergeAccountAssetsRequestParameters mergeAccountAssetsRequestParameters = (MergeAccountAssetsRequestParameters) other;
        return Intrinsics.areEqual(this.multiRides, mergeAccountAssetsRequestParameters.multiRides) && Intrinsics.areEqual(this.vehicles, mergeAccountAssetsRequestParameters.vehicles) && Intrinsics.areEqual(this.passengers, mergeAccountAssetsRequestParameters.passengers) && Intrinsics.areEqual(this.creditCards, mergeAccountAssetsRequestParameters.creditCards) && Intrinsics.areEqual(this.reservations, mergeAccountAssetsRequestParameters.reservations);
    }

    public final List<RegisterCreditCardRequestParameter> getCreditCards() {
        return this.creditCards;
    }

    public final List<String> getMultiRides() {
        return this.multiRides;
    }

    public final List<RegisterPassengerRequestParameter> getPassengers() {
        return this.passengers;
    }

    public final List<MergeTicketsRequestParameter> getReservations() {
        return this.reservations;
    }

    public final List<RegisterVehicleRequestParameter> getVehicles() {
        return this.vehicles;
    }

    public int hashCode() {
        return (((((((this.multiRides.hashCode() * 31) + this.vehicles.hashCode()) * 31) + this.passengers.hashCode()) * 31) + this.creditCards.hashCode()) * 31) + this.reservations.hashCode();
    }

    public String toString() {
        return "MergeAccountAssetsRequestParameters(multiRides=" + this.multiRides + ", vehicles=" + this.vehicles + ", passengers=" + this.passengers + ", creditCards=" + this.creditCards + ", reservations=" + this.reservations + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MergeAccountAssetsRequestParameters(List<String> multiRides, List<RegisterVehicleRequestParameter> vehicles, List<? extends RegisterPassengerRequestParameter> passengers, List<RegisterCreditCardRequestParameter> creditCards, List<MergeTicketsRequestParameter> reservations) {
        Intrinsics.checkNotNullParameter(multiRides, "multiRides");
        Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        Intrinsics.checkNotNullParameter(passengers, "passengers");
        Intrinsics.checkNotNullParameter(creditCards, "creditCards");
        Intrinsics.checkNotNullParameter(reservations, "reservations");
        this.multiRides = multiRides;
        this.vehicles = vehicles;
        this.passengers = passengers;
        this.creditCards = creditCards;
        this.reservations = reservations;
    }
}
