package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;", BuildConfig.FLAVOR, "adultCount", BuildConfig.FLAVOR, "childCount", "infantCount", "passengerData", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "<init>", "(IIILjava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;)V", "getAdultCount", "()I", "getChildCount", "getInfantCount", "getPassengerData", "()Ljava/util/List;", "totalPassengerCount", "getTotalPassengerCount", "toPassengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingPassengerInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BookingPassengerInfo mock;
    private final int adultCount;
    private final int childCount;
    private final int infantCount;
    private final List<BookingPassenger> passengerData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassengerInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingPassengerInfo getMock() {
            return BookingPassengerInfo.mock;
        }

        private Companion() {
        }
    }

    static {
        BookingPassenger.Companion companion = BookingPassenger.INSTANCE;
        mock = new BookingPassengerInfo(3, 1, 1, CollectionsKt.listOf((Object[]) new BookingPassenger[]{companion.getMockMale(), companion.getMockFemale(), companion.getMockOther(), companion.getMockChild(), companion.getMockInfant()}));
    }

    public BookingPassengerInfo(int i5, int i6, int i7, List<BookingPassenger> passengerData) {
        Intrinsics.checkNotNullParameter(passengerData, "passengerData");
        this.adultCount = i5;
        this.childCount = i6;
        this.infantCount = i7;
        this.passengerData = passengerData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookingPassengerInfo copy$default(BookingPassengerInfo bookingPassengerInfo, int i5, int i6, int i7, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i5 = bookingPassengerInfo.adultCount;
        }
        if ((i8 & 2) != 0) {
            i6 = bookingPassengerInfo.childCount;
        }
        if ((i8 & 4) != 0) {
            i7 = bookingPassengerInfo.infantCount;
        }
        if ((i8 & 8) != 0) {
            list = bookingPassengerInfo.passengerData;
        }
        return bookingPassengerInfo.copy(i5, i6, i7, list);
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

    public final List<BookingPassenger> component4() {
        return this.passengerData;
    }

    public final BookingPassengerInfo copy(int adultCount, int childCount, int infantCount, List<BookingPassenger> passengerData) {
        Intrinsics.checkNotNullParameter(passengerData, "passengerData");
        return new BookingPassengerInfo(adultCount, childCount, infantCount, passengerData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingPassengerInfo)) {
            return false;
        }
        BookingPassengerInfo bookingPassengerInfo = (BookingPassengerInfo) other;
        return this.adultCount == bookingPassengerInfo.adultCount && this.childCount == bookingPassengerInfo.childCount && this.infantCount == bookingPassengerInfo.infantCount && Intrinsics.areEqual(this.passengerData, bookingPassengerInfo.passengerData);
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

    public final List<BookingPassenger> getPassengerData() {
        return this.passengerData;
    }

    public final int getTotalPassengerCount() {
        return this.adultCount + this.childCount + this.infantCount;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.adultCount) * 31) + Integer.hashCode(this.childCount)) * 31) + Integer.hashCode(this.infantCount)) * 31) + this.passengerData.hashCode();
    }

    public final PassengerInfo toPassengerInfo() {
        return new PassengerInfo(this.adultCount, this.childCount, this.infantCount);
    }

    public String toString() {
        return "BookingPassengerInfo(adultCount=" + this.adultCount + ", childCount=" + this.childCount + ", infantCount=" + this.infantCount + ", passengerData=" + this.passengerData + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingPassengerInfo(BookingResponseDTO.PassengerInfoResponseDTO dto) {
        this(r0, r1, r2, r3);
        Intrinsics.checkNotNullParameter(dto, "dto");
        int adultCount = dto.getAdultCount();
        int childCount = dto.getChildCount();
        int infantCount = dto.getInfantCount();
        List<BookingResponseDTO.BookingPassengerResponseDTO> passengerData = dto.getPassengerData();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengerData, 10));
        Iterator<T> it = passengerData.iterator();
        while (it.hasNext()) {
            arrayList.add(new BookingPassenger((BookingResponseDTO.BookingPassengerResponseDTO) it.next()));
        }
    }
}
