package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/model/booking/EditInfo;", BuildConfig.FLAVOR, "canChange", BuildConfig.FLAVOR, "canChangeFrom", "Lorg/threeten/bp/LocalDate;", "canChangeUntil", "<init>", "(ZLorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;)V", "getCanChange", "()Z", "getCanChangeFrom", "()Lorg/threeten/bp/LocalDate;", "getCanChangeUntil", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EditInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EditInfo mock;
    private final boolean canChange;
    private final LocalDate canChangeFrom;
    private final LocalDate canChangeUntil;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/EditInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/EditInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/EditInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EditInfo getMock() {
            return EditInfo.mock;
        }

        private Companion() {
        }
    }

    static {
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        LocalDate plusMonths = LocalDate.now().plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        mock = new EditInfo(true, now, plusMonths);
    }

    public EditInfo(boolean z5, LocalDate canChangeFrom, LocalDate canChangeUntil) {
        Intrinsics.checkNotNullParameter(canChangeFrom, "canChangeFrom");
        Intrinsics.checkNotNullParameter(canChangeUntil, "canChangeUntil");
        this.canChange = z5;
        this.canChangeFrom = canChangeFrom;
        this.canChangeUntil = canChangeUntil;
    }

    public static /* synthetic */ EditInfo copy$default(EditInfo editInfo, boolean z5, LocalDate localDate, LocalDate localDate2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = editInfo.canChange;
        }
        if ((i5 & 2) != 0) {
            localDate = editInfo.canChangeFrom;
        }
        if ((i5 & 4) != 0) {
            localDate2 = editInfo.canChangeUntil;
        }
        return editInfo.copy(z5, localDate, localDate2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanChange() {
        return this.canChange;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getCanChangeFrom() {
        return this.canChangeFrom;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDate getCanChangeUntil() {
        return this.canChangeUntil;
    }

    public final EditInfo copy(boolean canChange, LocalDate canChangeFrom, LocalDate canChangeUntil) {
        Intrinsics.checkNotNullParameter(canChangeFrom, "canChangeFrom");
        Intrinsics.checkNotNullParameter(canChangeUntil, "canChangeUntil");
        return new EditInfo(canChange, canChangeFrom, canChangeUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditInfo)) {
            return false;
        }
        EditInfo editInfo = (EditInfo) other;
        return this.canChange == editInfo.canChange && Intrinsics.areEqual(this.canChangeFrom, editInfo.canChangeFrom) && Intrinsics.areEqual(this.canChangeUntil, editInfo.canChangeUntil);
    }

    public final boolean getCanChange() {
        return this.canChange;
    }

    public final LocalDate getCanChangeFrom() {
        return this.canChangeFrom;
    }

    public final LocalDate getCanChangeUntil() {
        return this.canChangeUntil;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.canChange) * 31) + this.canChangeFrom.hashCode()) * 31) + this.canChangeUntil.hashCode();
    }

    public String toString() {
        return "EditInfo(canChange=" + this.canChange + ", canChangeFrom=" + this.canChangeFrom + ", canChangeUntil=" + this.canChangeUntil + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditInfo(BookingResponseDTO.EditInfoResponseDTO dto) {
        this(dto.getCanChange(), dto.getCanChangeFrom(), dto.getCanChangeUntil());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
