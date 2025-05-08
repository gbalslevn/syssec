package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryTypeDTO;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.config.Harbor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002>?BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010Ba\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010\u0015J\u0006\u0010#\u001a\u00020\u0003J\u0016\u0010\u001e\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&J\u0016\u0010\u001f\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&J\"\u0010'\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0002J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0012HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006@"}, d2 = {"Ldk/molslinjen/domain/model/booking/Ferry;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "arrivalTime", "Lorg/threeten/bp/LocalTime;", "departureTime", "departureHarbor", "arrivalHarbor", "name", "type", "Ldk/molslinjen/domain/model/booking/FerryType;", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/FerryType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/FerryType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDepartureTime$annotations", "getDepartureTime", "getDepartureHarbor", "getArrivalHarbor", "getName", "getType", "()Ldk/molslinjen/domain/model/booking/FerryType;", "timeFormatted", "Ldk/molslinjen/domain/model/config/Harbor;", "harbors", BuildConfig.FLAVOR, "getHarbor", "harborName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class Ferry {
    private final String arrivalHarbor;
    private final LocalTime arrivalTime;
    private final String departureHarbor;
    private final LocalTime departureTime;
    private final String id;
    private final String name;
    private final FerryType type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.FerryType", FerryType.values())};
    private static final Ferry mock = new Ferry("123", LocalTime.of(12, 0), LocalTime.of(10, 0), "Odden", "Aarhus", "Express 4", FerryType.Standard);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/Ferry$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Ferry;", "getMock", "()Ldk/molslinjen/domain/model/booking/Ferry;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Ferry getMock() {
            return Ferry.mock;
        }

        public final KSerializer<Ferry> serializer() {
            return Ferry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Ferry(int i5, String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryType ferryType, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, Ferry$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.arrivalTime = localTime;
        this.departureTime = localTime2;
        this.departureHarbor = str2;
        this.arrivalHarbor = str3;
        if ((i5 & 32) == 0) {
            this.name = null;
        } else {
            this.name = str4;
        }
        if ((i5 & 64) == 0) {
            this.type = null;
        } else {
            this.type = ferryType;
        }
    }

    public static /* synthetic */ Ferry copy$default(Ferry ferry, String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryType ferryType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ferry.id;
        }
        if ((i5 & 2) != 0) {
            localTime = ferry.arrivalTime;
        }
        LocalTime localTime3 = localTime;
        if ((i5 & 4) != 0) {
            localTime2 = ferry.departureTime;
        }
        LocalTime localTime4 = localTime2;
        if ((i5 & 8) != 0) {
            str2 = ferry.departureHarbor;
        }
        String str5 = str2;
        if ((i5 & 16) != 0) {
            str3 = ferry.arrivalHarbor;
        }
        String str6 = str3;
        if ((i5 & 32) != 0) {
            str4 = ferry.name;
        }
        String str7 = str4;
        if ((i5 & 64) != 0) {
            ferryType = ferry.type;
        }
        return ferry.copy(str, localTime3, localTime4, str5, str6, str7, ferryType);
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getDepartureTime$annotations() {
    }

    private final Harbor getHarbor(String harborName, List<Harbor> harbors) {
        Object obj;
        Iterator<T> it = harbors.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Harbor) obj).getName(), harborName)) {
                break;
            }
        }
        Harbor harbor = (Harbor) obj;
        if (harbor != null) {
            return harbor;
        }
        Logger.INSTANCE.logCritical(new CriticalLog("Ferry " + this.name + " harbor name \"" + harborName + "\" was not found in harbors list with " + harbors.size() + " harbors."));
        return null;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(Ferry self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.id);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, localTimeSerializer, self.arrivalTime);
        output.encodeNullableSerializableElement(serialDesc, 2, localTimeSerializer, self.departureTime);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.departureHarbor);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.arrivalHarbor);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.type == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.type);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component7, reason: from getter */
    public final FerryType getType() {
        return this.type;
    }

    public final Ferry copy(String id, LocalTime arrivalTime, LocalTime departureTime, String departureHarbor, String arrivalHarbor, String name, FerryType type) {
        return new Ferry(id, arrivalTime, departureTime, departureHarbor, arrivalHarbor, name, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ferry)) {
            return false;
        }
        Ferry ferry = (Ferry) other;
        return Intrinsics.areEqual(this.id, ferry.id) && Intrinsics.areEqual(this.arrivalTime, ferry.arrivalTime) && Intrinsics.areEqual(this.departureTime, ferry.departureTime) && Intrinsics.areEqual(this.departureHarbor, ferry.departureHarbor) && Intrinsics.areEqual(this.arrivalHarbor, ferry.arrivalHarbor) && Intrinsics.areEqual(this.name, ferry.name) && this.type == ferry.type;
    }

    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final FerryType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        LocalTime localTime = this.arrivalTime;
        int hashCode2 = (hashCode + (localTime == null ? 0 : localTime.hashCode())) * 31;
        LocalTime localTime2 = this.departureTime;
        int hashCode3 = (hashCode2 + (localTime2 == null ? 0 : localTime2.hashCode())) * 31;
        String str2 = this.departureHarbor;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.arrivalHarbor;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        FerryType ferryType = this.type;
        return hashCode6 + (ferryType != null ? ferryType.hashCode() : 0);
    }

    public final String timeFormatted() {
        LocalTime localTime;
        if (this.arrivalTime == null || (localTime = this.departureTime) == null) {
            return BuildConfig.FLAVOR;
        }
        return LocalDateTimeExtensionsKt.toFormatTime(localTime) + " - " + LocalDateTimeExtensionsKt.toFormatTime(this.arrivalTime);
    }

    public String toString() {
        return "Ferry(id=" + this.id + ", arrivalTime=" + this.arrivalTime + ", departureTime=" + this.departureTime + ", departureHarbor=" + this.departureHarbor + ", arrivalHarbor=" + this.arrivalHarbor + ", name=" + this.name + ", type=" + this.type + ")";
    }

    public Ferry(String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryType ferryType) {
        this.id = str;
        this.arrivalTime = localTime;
        this.departureTime = localTime2;
        this.departureHarbor = str2;
        this.arrivalHarbor = str3;
        this.name = str4;
        this.type = ferryType;
    }

    public final Harbor getArrivalHarbor(List<Harbor> harbors) {
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        return getHarbor(this.arrivalHarbor, harbors);
    }

    public final Harbor getDepartureHarbor(List<Harbor> harbors) {
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        return getHarbor(this.departureHarbor, harbors);
    }

    public /* synthetic */ Ferry(String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryType ferryType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, localTime, localTime2, str2, str3, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? null : ferryType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Ferry(FerryResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r10 != null ? FerryType.INSTANCE.invoke(r10) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        LocalTime arrivalTime = dto.getArrivalTime();
        LocalTime departureTime = dto.getDepartureTime();
        String departureHarbor = dto.getDepartureHarbor();
        String arrivalHarbor = dto.getArrivalHarbor();
        String ferryName = dto.getFerryName();
        String ferryId = dto.getFerryId();
        FerryTypeDTO ferryType = dto.getFerryType();
    }
}
