package uniffi.molslinjen_shared;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006+"}, d2 = {"Luniffi/molslinjen_shared/FerrySeat;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/FerrySeatId;", "name", BuildConfig.FLAVOR, "seatType", "Luniffi/molslinjen_shared/FerrySeatType;", "section", "price", "Luniffi/molslinjen_shared/Amount;", "(Luniffi/molslinjen_shared/FerrySeatId;Ljava/lang/String;Luniffi/molslinjen_shared/FerrySeatType;Ljava/lang/String;Luniffi/molslinjen_shared/Amount;)V", "getId", "()Luniffi/molslinjen_shared/FerrySeatId;", "setId", "(Luniffi/molslinjen_shared/FerrySeatId;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPrice", "()Luniffi/molslinjen_shared/Amount;", "setPrice", "(Luniffi/molslinjen_shared/Amount;)V", "getSeatType", "()Luniffi/molslinjen_shared/FerrySeatType;", "setSeatType", "(Luniffi/molslinjen_shared/FerrySeatType;)V", "getSection", "setSection", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FerrySeat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FerrySeatId id;
    private String name;
    private Amount price;
    private FerrySeatType seatType;
    private String section;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/FerrySeat$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FerrySeat(FerrySeatId id, String name, FerrySeatType seatType, String section, Amount amount) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(seatType, "seatType");
        Intrinsics.checkNotNullParameter(section, "section");
        this.id = id;
        this.name = name;
        this.seatType = seatType;
        this.section = section;
        this.price = amount;
    }

    public static /* synthetic */ FerrySeat copy$default(FerrySeat ferrySeat, FerrySeatId ferrySeatId, String str, FerrySeatType ferrySeatType, String str2, Amount amount, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            ferrySeatId = ferrySeat.id;
        }
        if ((i5 & 2) != 0) {
            str = ferrySeat.name;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            ferrySeatType = ferrySeat.seatType;
        }
        FerrySeatType ferrySeatType2 = ferrySeatType;
        if ((i5 & 8) != 0) {
            str2 = ferrySeat.section;
        }
        String str4 = str2;
        if ((i5 & 16) != 0) {
            amount = ferrySeat.price;
        }
        return ferrySeat.copy(ferrySeatId, str3, ferrySeatType2, str4, amount);
    }

    /* renamed from: component1, reason: from getter */
    public final FerrySeatId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final FerrySeatType getSeatType() {
        return this.seatType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSection() {
        return this.section;
    }

    /* renamed from: component5, reason: from getter */
    public final Amount getPrice() {
        return this.price;
    }

    public final FerrySeat copy(FerrySeatId id, String name, FerrySeatType seatType, String section, Amount price) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(seatType, "seatType");
        Intrinsics.checkNotNullParameter(section, "section");
        return new FerrySeat(id, name, seatType, section, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerrySeat)) {
            return false;
        }
        FerrySeat ferrySeat = (FerrySeat) other;
        return Intrinsics.areEqual(this.id, ferrySeat.id) && Intrinsics.areEqual(this.name, ferrySeat.name) && this.seatType == ferrySeat.seatType && Intrinsics.areEqual(this.section, ferrySeat.section) && Intrinsics.areEqual(this.price, ferrySeat.price);
    }

    public final FerrySeatId getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Amount getPrice() {
        return this.price;
    }

    public final FerrySeatType getSeatType() {
        return this.seatType;
    }

    public final String getSection() {
        return this.section;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.seatType.hashCode()) * 31) + this.section.hashCode()) * 31;
        Amount amount = this.price;
        return hashCode + (amount == null ? 0 : amount.hashCode());
    }

    public final void setId(FerrySeatId ferrySeatId) {
        Intrinsics.checkNotNullParameter(ferrySeatId, "<set-?>");
        this.id = ferrySeatId;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPrice(Amount amount) {
        this.price = amount;
    }

    public final void setSeatType(FerrySeatType ferrySeatType) {
        Intrinsics.checkNotNullParameter(ferrySeatType, "<set-?>");
        this.seatType = ferrySeatType;
    }

    public final void setSection(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.section = str;
    }

    public String toString() {
        return "FerrySeat(id=" + this.id + ", name=" + this.name + ", seatType=" + this.seatType + ", section=" + this.section + ", price=" + this.price + ")";
    }
}
