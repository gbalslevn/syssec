package dk.molslinjen.api.services.booking.request;

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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;", BuildConfig.FLAVOR, "bookings", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$BookingRequestParameters;", "<init>", "(Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBookings", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "BookingRequestParameters", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookingsRequestParameters {
    private final List<BookingRequestParameters> bookings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(BookingsRequestParameters$BookingRequestParameters$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$BookingRequestParameters;", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReservationNumber$annotations", "()V", "getReservationNumber", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookingRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String phone;
        private final String reservationNumber;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$BookingRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$BookingRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingRequestParameters> serializer() {
                return BookingsRequestParameters$BookingRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BookingRequestParameters(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingsRequestParameters$BookingRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.reservationNumber = str;
            this.phone = str2;
        }

        public static /* synthetic */ BookingRequestParameters copy$default(BookingRequestParameters bookingRequestParameters, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = bookingRequestParameters.reservationNumber;
            }
            if ((i5 & 2) != 0) {
                str2 = bookingRequestParameters.phone;
            }
            return bookingRequestParameters.copy(str, str2);
        }

        public static /* synthetic */ void getReservationNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookingRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.reservationNumber);
            output.encodeStringElement(serialDesc, 1, self.phone);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        public final BookingRequestParameters copy(String reservationNumber, String phone) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            return new BookingRequestParameters(reservationNumber, phone);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookingRequestParameters)) {
                return false;
            }
            BookingRequestParameters bookingRequestParameters = (BookingRequestParameters) other;
            return Intrinsics.areEqual(this.reservationNumber, bookingRequestParameters.reservationNumber) && Intrinsics.areEqual(this.phone, bookingRequestParameters.phone);
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public int hashCode() {
            return (this.reservationNumber.hashCode() * 31) + this.phone.hashCode();
        }

        public String toString() {
            return "BookingRequestParameters(reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ")";
        }

        public BookingRequestParameters(String reservationNumber, String phone) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.reservationNumber = reservationNumber;
            this.phone = phone;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BookingsRequestParameters> serializer() {
            return BookingsRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ BookingsRequestParameters(int i5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, BookingsRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.bookings = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookingsRequestParameters copy$default(BookingsRequestParameters bookingsRequestParameters, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = bookingsRequestParameters.bookings;
        }
        return bookingsRequestParameters.copy(list);
    }

    public final List<BookingRequestParameters> component1() {
        return this.bookings;
    }

    public final BookingsRequestParameters copy(List<BookingRequestParameters> bookings) {
        Intrinsics.checkNotNullParameter(bookings, "bookings");
        return new BookingsRequestParameters(bookings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BookingsRequestParameters) && Intrinsics.areEqual(this.bookings, ((BookingsRequestParameters) other).bookings);
    }

    public final List<BookingRequestParameters> getBookings() {
        return this.bookings;
    }

    public int hashCode() {
        return this.bookings.hashCode();
    }

    public String toString() {
        return "BookingsRequestParameters(bookings=" + this.bookings + ")";
    }

    public BookingsRequestParameters(List<BookingRequestParameters> bookings) {
        Intrinsics.checkNotNullParameter(bookings, "bookings");
        this.bookings = bookings;
    }
}
