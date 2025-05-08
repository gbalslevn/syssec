package dk.molslinjen.domain.managers.user.brobizz;

import dk.molslinjen.domain.model.account.Brobizz;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/Brobizz;", "brobizz", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBrobizz", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserBrobizzState {
    private final List<Brobizz> brobizz;

    public UserBrobizzState(List<Brobizz> brobizz) {
        Intrinsics.checkNotNullParameter(brobizz, "brobizz");
        this.brobizz = brobizz;
    }

    public final UserBrobizzState copy(List<Brobizz> brobizz) {
        Intrinsics.checkNotNullParameter(brobizz, "brobizz");
        return new UserBrobizzState(brobizz);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UserBrobizzState) && Intrinsics.areEqual(this.brobizz, ((UserBrobizzState) other).brobizz);
    }

    public final List<Brobizz> getBrobizz() {
        return this.brobizz;
    }

    public int hashCode() {
        return this.brobizz.hashCode();
    }

    public String toString() {
        return "UserBrobizzState(brobizz=" + this.brobizz + ")";
    }

    public /* synthetic */ UserBrobizzState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
