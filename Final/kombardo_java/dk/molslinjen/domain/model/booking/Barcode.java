package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/booking/Barcode;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "type", "Ldk/molslinjen/domain/model/booking/BarcodeType;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/BarcodeType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO;)V", "getId", "()Ljava/lang/String;", "getType", "()Ldk/molslinjen/domain/model/booking/BarcodeType;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Barcode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Barcode mock = new Barcode("123456789", BarcodeType.Catering);
    private final String id;
    private final BarcodeType type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/Barcode$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Barcode;", "getMock", "()Ldk/molslinjen/domain/model/booking/Barcode;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Barcode getMock() {
            return Barcode.mock;
        }

        private Companion() {
        }
    }

    public Barcode(String id, BarcodeType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
    }

    public static /* synthetic */ Barcode copy$default(Barcode barcode, String str, BarcodeType barcodeType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = barcode.id;
        }
        if ((i5 & 2) != 0) {
            barcodeType = barcode.type;
        }
        return barcode.copy(str, barcodeType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final BarcodeType getType() {
        return this.type;
    }

    public final Barcode copy(String id, BarcodeType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Barcode(id, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Barcode)) {
            return false;
        }
        Barcode barcode = (Barcode) other;
        return Intrinsics.areEqual(this.id, barcode.id) && this.type == barcode.type;
    }

    public final String getId() {
        return this.id;
    }

    public final BarcodeType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Barcode(id=" + this.id + ", type=" + this.type + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Barcode(BookingResponseDTO.BarcodeResponseDTO dto) {
        this(dto.getId(), BarcodeType.INSTANCE.invoke(dto.getType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
