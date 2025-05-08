package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "startDateTime", "Lorg/threeten/bp/LocalDateTime;", "endDateTime", "fullyBooked", BuildConfig.FLAVOR, "occupancyRate", "<init>", "(ILorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;ZI)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;", "(Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;)V", "getId", "()I", "getStartDateTime", "()Lorg/threeten/bp/LocalDateTime;", "getEndDateTime", "getFullyBooked", "()Z", "getOccupancyRate", "toString", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardTimeSlot {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardTimeSlot mock1;
    private static final SaleOnBoardTimeSlot mock2;
    private static final SaleOnBoardTimeSlot mock3;
    private final LocalDateTime endDateTime;
    private final boolean fullyBooked;
    private final int id;
    private final int occupancyRate;
    private final LocalDateTime startDateTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "mock2", "getMock2", "mock3", "getMock3", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardTimeSlot getMock1() {
            return SaleOnBoardTimeSlot.mock1;
        }

        public final SaleOnBoardTimeSlot getMock2() {
            return SaleOnBoardTimeSlot.mock2;
        }

        public final SaleOnBoardTimeSlot getMock3() {
            return SaleOnBoardTimeSlot.mock3;
        }

        private Companion() {
        }
    }

    static {
        LocalDateTime of = LocalDateTime.of(2021, 1, 1, 10, 0);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDateTime of2 = LocalDateTime.of(2021, 1, 1, 10, 10);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        mock1 = new SaleOnBoardTimeSlot(1, of, of2, false, 0);
        LocalDateTime of3 = LocalDateTime.of(2021, 1, 1, 10, 10);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        LocalDateTime of4 = LocalDateTime.of(2021, 1, 1, 10, 20);
        Intrinsics.checkNotNullExpressionValue(of4, "of(...)");
        mock2 = new SaleOnBoardTimeSlot(1, of3, of4, false, 0);
        LocalDateTime of5 = LocalDateTime.of(2021, 1, 1, 10, 20);
        Intrinsics.checkNotNullExpressionValue(of5, "of(...)");
        LocalDateTime of6 = LocalDateTime.of(2021, 1, 1, 10, 30);
        Intrinsics.checkNotNullExpressionValue(of6, "of(...)");
        mock3 = new SaleOnBoardTimeSlot(1, of5, of6, false, 0);
    }

    public SaleOnBoardTimeSlot(int i5, LocalDateTime startDateTime, LocalDateTime endDateTime, boolean z5, int i6) {
        Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
        Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
        this.id = i5;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.fullyBooked = z5;
        this.occupancyRate = i6;
    }

    public static /* synthetic */ SaleOnBoardTimeSlot copy$default(SaleOnBoardTimeSlot saleOnBoardTimeSlot, int i5, LocalDateTime localDateTime, LocalDateTime localDateTime2, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = saleOnBoardTimeSlot.id;
        }
        if ((i7 & 2) != 0) {
            localDateTime = saleOnBoardTimeSlot.startDateTime;
        }
        LocalDateTime localDateTime3 = localDateTime;
        if ((i7 & 4) != 0) {
            localDateTime2 = saleOnBoardTimeSlot.endDateTime;
        }
        LocalDateTime localDateTime4 = localDateTime2;
        if ((i7 & 8) != 0) {
            z5 = saleOnBoardTimeSlot.fullyBooked;
        }
        boolean z6 = z5;
        if ((i7 & 16) != 0) {
            i6 = saleOnBoardTimeSlot.occupancyRate;
        }
        return saleOnBoardTimeSlot.copy(i5, localDateTime3, localDateTime4, z6, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFullyBooked() {
        return this.fullyBooked;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOccupancyRate() {
        return this.occupancyRate;
    }

    public final SaleOnBoardTimeSlot copy(int id, LocalDateTime startDateTime, LocalDateTime endDateTime, boolean fullyBooked, int occupancyRate) {
        Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
        Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
        return new SaleOnBoardTimeSlot(id, startDateTime, endDateTime, fullyBooked, occupancyRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardTimeSlot)) {
            return false;
        }
        SaleOnBoardTimeSlot saleOnBoardTimeSlot = (SaleOnBoardTimeSlot) other;
        return this.id == saleOnBoardTimeSlot.id && Intrinsics.areEqual(this.startDateTime, saleOnBoardTimeSlot.startDateTime) && Intrinsics.areEqual(this.endDateTime, saleOnBoardTimeSlot.endDateTime) && this.fullyBooked == saleOnBoardTimeSlot.fullyBooked && this.occupancyRate == saleOnBoardTimeSlot.occupancyRate;
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
        return (((((((Integer.hashCode(this.id) * 31) + this.startDateTime.hashCode()) * 31) + this.endDateTime.hashCode()) * 31) + Boolean.hashCode(this.fullyBooked)) * 31) + Integer.hashCode(this.occupancyRate);
    }

    public String toString() {
        LocalTime localTime = this.startDateTime.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        String formatTime = LocalDateTimeExtensionsKt.toFormatTime(localTime);
        LocalTime localTime2 = this.endDateTime.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime2, "toLocalTime(...)");
        return formatTime + " - " + LocalDateTimeExtensionsKt.toFormatTime(localTime2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardTimeSlot(TimeSlotsResponseDTO.TimeSlotResponseDTO dto) {
        this(dto.getId(), dto.getStartDateTime(), dto.getEndDateTime(), dto.getFullyBooked(), dto.getOccupancyRate());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
