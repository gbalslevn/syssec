package dk.molslinjen.domain.model.shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/shared/HexColor;", BuildConfig.FLAVOR, "hex", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getHex", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HexColor {
    private final String hex;

    public HexColor(String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        this.hex = hex;
    }

    public static /* synthetic */ HexColor copy$default(HexColor hexColor, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = hexColor.hex;
        }
        return hexColor.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHex() {
        return this.hex;
    }

    public final HexColor copy(String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        return new HexColor(hex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HexColor) && Intrinsics.areEqual(this.hex, ((HexColor) other).hex);
    }

    public final String getHex() {
        return this.hex;
    }

    public int hashCode() {
        return this.hex.hashCode();
    }

    public String toString() {
        return "HexColor(hex=" + this.hex + ")";
    }
}
