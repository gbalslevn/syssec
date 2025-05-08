package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\t\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Luniffi/molslinjen_shared/Consent;", BuildConfig.FLAVOR, "validUntil", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "(Lorg/threeten/bp/LocalDateTime;)V", "getValidUntil", "()Lorg/threeten/bp/LocalDateTime;", "setValidUntil", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Consent {
    private LocalDateTime validUntil;

    public Consent(LocalDateTime validUntil) {
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        this.validUntil = validUntil;
    }

    public static /* synthetic */ Consent copy$default(Consent consent, LocalDateTime localDateTime, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            localDateTime = consent.validUntil;
        }
        return consent.copy(localDateTime);
    }

    /* renamed from: component1, reason: from getter */
    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    public final Consent copy(LocalDateTime validUntil) {
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        return new Consent(validUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Consent) && Intrinsics.areEqual(this.validUntil, ((Consent) other).validUntil);
    }

    public final LocalDateTime getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        return this.validUntil.hashCode();
    }

    public final void setValidUntil(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<set-?>");
        this.validUntil = localDateTime;
    }

    public String toString() {
        return "Consent(validUntil=" + this.validUntil + ")";
    }
}
