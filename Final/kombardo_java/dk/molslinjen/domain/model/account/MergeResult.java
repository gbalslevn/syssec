package dk.molslinjen.domain.model.account;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/account/MergeResult;", BuildConfig.FLAVOR, "hasError", BuildConfig.FLAVOR, "<init>", "(Z)V", "getHasError", "()Z", "component1", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MergeResult {
    private final boolean hasError;

    public MergeResult(boolean z5) {
        this.hasError = z5;
    }

    public static /* synthetic */ MergeResult copy$default(MergeResult mergeResult, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = mergeResult.hasError;
        }
        return mergeResult.copy(z5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasError() {
        return this.hasError;
    }

    public final MergeResult copy(boolean hasError) {
        return new MergeResult(hasError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MergeResult) && this.hasError == ((MergeResult) other).hasError;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hasError);
    }

    public String toString() {
        return "MergeResult(hasError=" + this.hasError + ")";
    }
}
