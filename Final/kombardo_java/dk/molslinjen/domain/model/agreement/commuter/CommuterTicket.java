package dk.molslinjen.domain.model.agreement.commuter;

import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterTicketResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket;", BuildConfig.FLAVOR, "arrivalHarborName", BuildConfig.FLAVOR, "departureHarborName", "departureDate", "Lorg/threeten/bp/LocalDate;", "departureTime", "Lorg/threeten/bp/LocalTime;", "arrivalTime", "travelTime", "Lorg/threeten/bp/Duration;", "ferryName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/Duration;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", "(Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;)V", "getArrivalHarborName", "()Ljava/lang/String;", "getDepartureHarborName", "getDepartureDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureTime", "()Lorg/threeten/bp/LocalTime;", "getArrivalTime", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getFerryName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CommuterTicket {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CommuterTicket mock;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate departureDate;
    private final String departureHarborName;
    private final LocalTime departureTime;
    private final String ferryName;
    private final Duration travelTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket;", "getMock", "()Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommuterTicket getMock() {
            return CommuterTicket.mock;
        }

        private Companion() {
        }
    }

    static {
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        LocalTime now2 = LocalTime.now();
        Intrinsics.checkNotNullExpressionValue(now2, "now(...)");
        LocalTime plusHours = LocalTime.now().plusHours(1L);
        Intrinsics.checkNotNullExpressionValue(plusHours, "plusHours(...)");
        Duration ofHours = Duration.ofHours(1L);
        Intrinsics.checkNotNullExpressionValue(ofHours, "ofHours(...)");
        mock = new CommuterTicket("Odden", "Aarhus", now, now2, plusHours, ofHours, "MF Borno");
    }

    public CommuterTicket(String arrivalHarborName, String departureHarborName, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, Duration travelTime, String ferryName) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        this.arrivalHarborName = arrivalHarborName;
        this.departureHarborName = departureHarborName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelTime = travelTime;
        this.ferryName = ferryName;
    }

    public static /* synthetic */ CommuterTicket copy$default(CommuterTicket commuterTicket, String str, String str2, LocalDate localDate, LocalTime localTime, LocalTime localTime2, Duration duration, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = commuterTicket.arrivalHarborName;
        }
        if ((i5 & 2) != 0) {
            str2 = commuterTicket.departureHarborName;
        }
        String str4 = str2;
        if ((i5 & 4) != 0) {
            localDate = commuterTicket.departureDate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 8) != 0) {
            localTime = commuterTicket.departureTime;
        }
        LocalTime localTime3 = localTime;
        if ((i5 & 16) != 0) {
            localTime2 = commuterTicket.arrivalTime;
        }
        LocalTime localTime4 = localTime2;
        if ((i5 & 32) != 0) {
            duration = commuterTicket.travelTime;
        }
        Duration duration2 = duration;
        if ((i5 & 64) != 0) {
            str3 = commuterTicket.ferryName;
        }
        return commuterTicket.copy(str, str4, localDate2, localTime3, localTime4, duration2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDate getDepartureDate() {
        return this.departureDate;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component6, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFerryName() {
        return this.ferryName;
    }

    public final CommuterTicket copy(String arrivalHarborName, String departureHarborName, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, Duration travelTime, String ferryName) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureDate, "departureDate");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        return new CommuterTicket(arrivalHarborName, departureHarborName, departureDate, departureTime, arrivalTime, travelTime, ferryName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommuterTicket)) {
            return false;
        }
        CommuterTicket commuterTicket = (CommuterTicket) other;
        return Intrinsics.areEqual(this.arrivalHarborName, commuterTicket.arrivalHarborName) && Intrinsics.areEqual(this.departureHarborName, commuterTicket.departureHarborName) && Intrinsics.areEqual(this.departureDate, commuterTicket.departureDate) && Intrinsics.areEqual(this.departureTime, commuterTicket.departureTime) && Intrinsics.areEqual(this.arrivalTime, commuterTicket.arrivalTime) && Intrinsics.areEqual(this.travelTime, commuterTicket.travelTime) && Intrinsics.areEqual(this.ferryName, commuterTicket.ferryName);
    }

    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public final String getFerryName() {
        return this.ferryName;
    }

    public final Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        return (((((((((((this.arrivalHarborName.hashCode() * 31) + this.departureHarborName.hashCode()) * 31) + this.departureDate.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.travelTime.hashCode()) * 31) + this.ferryName.hashCode();
    }

    public String toString() {
        return "CommuterTicket(arrivalHarborName=" + this.arrivalHarborName + ", departureHarborName=" + this.departureHarborName + ", departureDate=" + this.departureDate + ", departureTime=" + this.departureTime + ", arrivalTime=" + this.arrivalTime + ", travelTime=" + this.travelTime + ", ferryName=" + this.ferryName + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommuterTicket(BornholmCommuterTicketResponseDTO dto) {
        this(StringsKt.substringAfter$default(dto.getRoute(), " - ", (String) null, 2, (Object) null), StringsKt.substringBefore$default(dto.getRoute(), " - ", (String) null, 2, (Object) null), dto.getDate(), dto.getTime(), dto.getArrivalTime(), dto.getCrossingTime(), dto.getFerryName());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
