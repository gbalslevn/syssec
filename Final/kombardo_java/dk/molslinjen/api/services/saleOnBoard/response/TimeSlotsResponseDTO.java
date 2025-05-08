package dk.molslinjen.api.services.saleOnBoard.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeRetailItsSerializer;
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
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0004\u001e\u001f !B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;", BuildConfig.FLAVOR, "stores", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO;", "<init>", "(Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStores", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "StoreTimeSlotsResponseDTO", "TimeSlotResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TimeSlotsResponseDTO {
    private final List<StoreTimeSlotsResponseDTO> stores;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TimeSlotsResponseDTO> serializer() {
            return TimeSlotsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "storeNumber", "timeSlots", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getStoreNumber$annotations", "()V", "getStoreNumber", "getTimeSlots", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class StoreTimeSlotsResponseDTO {
        private final String id;
        private final String storeNumber;
        private final List<TimeSlotResponseDTO> timeSlots;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<StoreTimeSlotsResponseDTO> serializer() {
                return TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ StoreTimeSlotsResponseDTO(int i5, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.storeNumber = str2;
            this.timeSlots = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreTimeSlotsResponseDTO copy$default(StoreTimeSlotsResponseDTO storeTimeSlotsResponseDTO, String str, String str2, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = storeTimeSlotsResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = storeTimeSlotsResponseDTO.storeNumber;
            }
            if ((i5 & 4) != 0) {
                list = storeTimeSlotsResponseDTO.timeSlots;
            }
            return storeTimeSlotsResponseDTO.copy(str, str2, list);
        }

        public static /* synthetic */ void getStoreNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(StoreTimeSlotsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.storeNumber);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.timeSlots);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getStoreNumber() {
            return this.storeNumber;
        }

        public final List<TimeSlotResponseDTO> component3() {
            return this.timeSlots;
        }

        public final StoreTimeSlotsResponseDTO copy(String id, String storeNumber, List<TimeSlotResponseDTO> timeSlots) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            return new StoreTimeSlotsResponseDTO(id, storeNumber, timeSlots);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreTimeSlotsResponseDTO)) {
                return false;
            }
            StoreTimeSlotsResponseDTO storeTimeSlotsResponseDTO = (StoreTimeSlotsResponseDTO) other;
            return Intrinsics.areEqual(this.id, storeTimeSlotsResponseDTO.id) && Intrinsics.areEqual(this.storeNumber, storeTimeSlotsResponseDTO.storeNumber) && Intrinsics.areEqual(this.timeSlots, storeTimeSlotsResponseDTO.timeSlots);
        }

        public final String getId() {
            return this.id;
        }

        public final String getStoreNumber() {
            return this.storeNumber;
        }

        public final List<TimeSlotResponseDTO> getTimeSlots() {
            return this.timeSlots;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.storeNumber.hashCode()) * 31) + this.timeSlots.hashCode();
        }

        public String toString() {
            return "StoreTimeSlotsResponseDTO(id=" + this.id + ", storeNumber=" + this.storeNumber + ", timeSlots=" + this.timeSlots + ")";
        }

        public StoreTimeSlotsResponseDTO(String id, String storeNumber, List<TimeSlotResponseDTO> timeSlots) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            this.id = id;
            this.storeNumber = storeNumber;
            this.timeSlots = timeSlots;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015¨\u00060"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "endDateTime", "Lorg/threeten/bp/LocalDateTime;", "fullyBooked", BuildConfig.FLAVOR, "occupancyRate", "startDateTime", "<init>", "(ILorg/threeten/bp/LocalDateTime;ZILorg/threeten/bp/LocalDateTime;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILorg/threeten/bp/LocalDateTime;ZILorg/threeten/bp/LocalDateTime;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getEndDateTime$annotations", "()V", "getEndDateTime", "()Lorg/threeten/bp/LocalDateTime;", "getFullyBooked", "()Z", "getOccupancyRate", "getStartDateTime$annotations", "getStartDateTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TimeSlotResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LocalDateTime endDateTime;
        private final boolean fullyBooked;
        private final int id;
        private final int occupancyRate;
        private final LocalDateTime startDateTime;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TimeSlotResponseDTO> serializer() {
                return TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TimeSlotResponseDTO(int i5, int i6, LocalDateTime localDateTime, boolean z5, int i7, LocalDateTime localDateTime2, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = i6;
            this.endDateTime = localDateTime;
            this.fullyBooked = z5;
            this.occupancyRate = i7;
            this.startDateTime = localDateTime2;
        }

        public static /* synthetic */ TimeSlotResponseDTO copy$default(TimeSlotResponseDTO timeSlotResponseDTO, int i5, LocalDateTime localDateTime, boolean z5, int i6, LocalDateTime localDateTime2, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i5 = timeSlotResponseDTO.id;
            }
            if ((i7 & 2) != 0) {
                localDateTime = timeSlotResponseDTO.endDateTime;
            }
            LocalDateTime localDateTime3 = localDateTime;
            if ((i7 & 4) != 0) {
                z5 = timeSlotResponseDTO.fullyBooked;
            }
            boolean z6 = z5;
            if ((i7 & 8) != 0) {
                i6 = timeSlotResponseDTO.occupancyRate;
            }
            int i8 = i6;
            if ((i7 & 16) != 0) {
                localDateTime2 = timeSlotResponseDTO.startDateTime;
            }
            return timeSlotResponseDTO.copy(i5, localDateTime3, z6, i8, localDateTime2);
        }

        @Serializable(with = LocalDateTimeRetailItsSerializer.class)
        public static /* synthetic */ void getEndDateTime$annotations() {
        }

        @Serializable(with = LocalDateTimeRetailItsSerializer.class)
        public static /* synthetic */ void getStartDateTime$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TimeSlotResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.id);
            LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, localDateTimeRetailItsSerializer, self.endDateTime);
            output.encodeBooleanElement(serialDesc, 2, self.fullyBooked);
            output.encodeIntElement(serialDesc, 3, self.occupancyRate);
            output.encodeSerializableElement(serialDesc, 4, localDateTimeRetailItsSerializer, self.startDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalDateTime getEndDateTime() {
            return this.endDateTime;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getFullyBooked() {
            return this.fullyBooked;
        }

        /* renamed from: component4, reason: from getter */
        public final int getOccupancyRate() {
            return this.occupancyRate;
        }

        /* renamed from: component5, reason: from getter */
        public final LocalDateTime getStartDateTime() {
            return this.startDateTime;
        }

        public final TimeSlotResponseDTO copy(int id, LocalDateTime endDateTime, boolean fullyBooked, int occupancyRate, LocalDateTime startDateTime) {
            Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
            Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
            return new TimeSlotResponseDTO(id, endDateTime, fullyBooked, occupancyRate, startDateTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimeSlotResponseDTO)) {
                return false;
            }
            TimeSlotResponseDTO timeSlotResponseDTO = (TimeSlotResponseDTO) other;
            return this.id == timeSlotResponseDTO.id && Intrinsics.areEqual(this.endDateTime, timeSlotResponseDTO.endDateTime) && this.fullyBooked == timeSlotResponseDTO.fullyBooked && this.occupancyRate == timeSlotResponseDTO.occupancyRate && Intrinsics.areEqual(this.startDateTime, timeSlotResponseDTO.startDateTime);
        }

        public final LocalDateTime getEndDateTime() {
            return this.endDateTime;
        }

        public final boolean getFullyBooked() {
            return this.fullyBooked;
        }

        public final int getId() {
            return this.id;
        }

        public final int getOccupancyRate() {
            return this.occupancyRate;
        }

        public final LocalDateTime getStartDateTime() {
            return this.startDateTime;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.id) * 31) + this.endDateTime.hashCode()) * 31) + Boolean.hashCode(this.fullyBooked)) * 31) + Integer.hashCode(this.occupancyRate)) * 31) + this.startDateTime.hashCode();
        }

        public String toString() {
            return "TimeSlotResponseDTO(id=" + this.id + ", endDateTime=" + this.endDateTime + ", fullyBooked=" + this.fullyBooked + ", occupancyRate=" + this.occupancyRate + ", startDateTime=" + this.startDateTime + ")";
        }

        public TimeSlotResponseDTO(int i5, LocalDateTime endDateTime, boolean z5, int i6, LocalDateTime startDateTime) {
            Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
            Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
            this.id = i5;
            this.endDateTime = endDateTime;
            this.fullyBooked = z5;
            this.occupancyRate = i6;
            this.startDateTime = startDateTime;
        }
    }

    public /* synthetic */ TimeSlotsResponseDTO(int i5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, TimeSlotsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.stores = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeSlotsResponseDTO copy$default(TimeSlotsResponseDTO timeSlotsResponseDTO, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = timeSlotsResponseDTO.stores;
        }
        return timeSlotsResponseDTO.copy(list);
    }

    public final List<StoreTimeSlotsResponseDTO> component1() {
        return this.stores;
    }

    public final TimeSlotsResponseDTO copy(List<StoreTimeSlotsResponseDTO> stores) {
        Intrinsics.checkNotNullParameter(stores, "stores");
        return new TimeSlotsResponseDTO(stores);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TimeSlotsResponseDTO) && Intrinsics.areEqual(this.stores, ((TimeSlotsResponseDTO) other).stores);
    }

    public final List<StoreTimeSlotsResponseDTO> getStores() {
        return this.stores;
    }

    public int hashCode() {
        return this.stores.hashCode();
    }

    public String toString() {
        return "TimeSlotsResponseDTO(stores=" + this.stores + ")";
    }

    public TimeSlotsResponseDTO(List<StoreTimeSlotsResponseDTO> stores) {
        Intrinsics.checkNotNullParameter(stores, "stores");
        this.stores = stores;
    }
}
