package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/booking/AuthenticationInfo;", BuildConfig.FLAVOR, "commuteAgreementId", BuildConfig.FLAVOR, "multiRideInfo", "Ldk/molslinjen/domain/model/booking/MultiRideInfo;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/MultiRideInfo;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;", "dtoMultiRide", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;)V", "getCommuteAgreementId", "()Ljava/lang/String;", "getMultiRideInfo", "()Ldk/molslinjen/domain/model/booking/MultiRideInfo;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AuthenticationInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AuthenticationInfo mock = new AuthenticationInfo((String) null, (MultiRideInfo) null);
    private final String commuteAgreementId;
    private final MultiRideInfo multiRideInfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/AuthenticationInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/AuthenticationInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/AuthenticationInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationInfo getMock() {
            return AuthenticationInfo.mock;
        }

        private Companion() {
        }
    }

    public AuthenticationInfo(String str, MultiRideInfo multiRideInfo) {
        this.commuteAgreementId = str;
        this.multiRideInfo = multiRideInfo;
    }

    public static /* synthetic */ AuthenticationInfo copy$default(AuthenticationInfo authenticationInfo, String str, MultiRideInfo multiRideInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = authenticationInfo.commuteAgreementId;
        }
        if ((i5 & 2) != 0) {
            multiRideInfo = authenticationInfo.multiRideInfo;
        }
        return authenticationInfo.copy(str, multiRideInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    /* renamed from: component2, reason: from getter */
    public final MultiRideInfo getMultiRideInfo() {
        return this.multiRideInfo;
    }

    public final AuthenticationInfo copy(String commuteAgreementId, MultiRideInfo multiRideInfo) {
        return new AuthenticationInfo(commuteAgreementId, multiRideInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationInfo)) {
            return false;
        }
        AuthenticationInfo authenticationInfo = (AuthenticationInfo) other;
        return Intrinsics.areEqual(this.commuteAgreementId, authenticationInfo.commuteAgreementId) && Intrinsics.areEqual(this.multiRideInfo, authenticationInfo.multiRideInfo);
    }

    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    public final MultiRideInfo getMultiRideInfo() {
        return this.multiRideInfo;
    }

    public int hashCode() {
        String str = this.commuteAgreementId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        MultiRideInfo multiRideInfo = this.multiRideInfo;
        return hashCode + (multiRideInfo != null ? multiRideInfo.hashCode() : 0);
    }

    public String toString() {
        return "AuthenticationInfo(commuteAgreementId=" + this.commuteAgreementId + ", multiRideInfo=" + this.multiRideInfo + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationInfo(BookingResponseDTO.AuthenticationInfoResponseDTO dto, BookingResponseDTO.MultiRideInfoResponseDTO multiRideInfoResponseDTO) {
        this(StringExtensionsKt.nullIfEmpty(dto.getCommuteAgreement().getAgreementId()), multiRideInfoResponseDTO != null ? new MultiRideInfo(multiRideInfoResponseDTO) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
