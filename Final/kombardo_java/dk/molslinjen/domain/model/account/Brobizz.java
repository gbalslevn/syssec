package dk.molslinjen.domain.model.account;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzDTO;
import dk.molslinjen.domain.extensions.StringBuilderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/account/Brobizz;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "number", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzDTO;", "(Ldk/molslinjen/api/services/account/brobizz/response/BrobizzDTO;)V", "getId", "()Ljava/lang/String;", "getNumber", "spacedBrobizzNumber", "getSpacedBrobizzNumber", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Brobizz {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Brobizz mock = new Brobizz("123", "1234567890123456");
    private final String id;
    private final String number;
    private final String spacedBrobizzNumber;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/account/Brobizz$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/Brobizz;", "getMock", "()Ldk/molslinjen/domain/model/account/Brobizz;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Brobizz getMock() {
            return Brobizz.mock;
        }

        private Companion() {
        }
    }

    public Brobizz(String id, String number) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(number, "number");
        this.id = id;
        this.number = number;
        this.spacedBrobizzNumber = StringBuilderKt.spacedString(new StringBuilder(), number, 4);
    }

    public static /* synthetic */ Brobizz copy$default(Brobizz brobizz, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = brobizz.id;
        }
        if ((i5 & 2) != 0) {
            str2 = brobizz.number;
        }
        return brobizz.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    public final Brobizz copy(String id, String number) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(number, "number");
        return new Brobizz(id, number);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Brobizz)) {
            return false;
        }
        Brobizz brobizz = (Brobizz) other;
        return Intrinsics.areEqual(this.id, brobizz.id) && Intrinsics.areEqual(this.number, brobizz.number);
    }

    public final String getId() {
        return this.id;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getSpacedBrobizzNumber() {
        return this.spacedBrobizzNumber;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.number.hashCode();
    }

    public String toString() {
        return "Brobizz(id=" + this.id + ", number=" + this.number + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Brobizz(BrobizzDTO dto) {
        this(dto.getBrobizzId(), dto.getBrobizzNumber());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
