package dk.molslinjen.domain.model.settings;

import dk.molslinjen.api.services.forceUpdate.response.ForceUpdateDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/model/settings/ForceUpdate;", BuildConfig.FLAVOR, "minimumVersionCode", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/forceUpdate/response/ForceUpdateDTO;", "(Ldk/molslinjen/api/services/forceUpdate/response/ForceUpdateDTO;)V", "getMinimumVersionCode", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ForceUpdate {
    private final String minimumVersionCode;

    public ForceUpdate(String minimumVersionCode) {
        Intrinsics.checkNotNullParameter(minimumVersionCode, "minimumVersionCode");
        this.minimumVersionCode = minimumVersionCode;
    }

    public static /* synthetic */ ForceUpdate copy$default(ForceUpdate forceUpdate, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = forceUpdate.minimumVersionCode;
        }
        return forceUpdate.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMinimumVersionCode() {
        return this.minimumVersionCode;
    }

    public final ForceUpdate copy(String minimumVersionCode) {
        Intrinsics.checkNotNullParameter(minimumVersionCode, "minimumVersionCode");
        return new ForceUpdate(minimumVersionCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ForceUpdate) && Intrinsics.areEqual(this.minimumVersionCode, ((ForceUpdate) other).minimumVersionCode);
    }

    public final String getMinimumVersionCode() {
        return this.minimumVersionCode;
    }

    public int hashCode() {
        return this.minimumVersionCode.hashCode();
    }

    public String toString() {
        return "ForceUpdate(minimumVersionCode=" + this.minimumVersionCode + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForceUpdate(ForceUpdateDTO dto) {
        this(dto.getMinimumVersionCode());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
