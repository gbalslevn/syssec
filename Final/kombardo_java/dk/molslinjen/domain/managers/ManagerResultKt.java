package dk.molslinjen.domain.managers;

import android.content.Context;
import dk.molslinjen.api.helpers.NetworkStatus;
import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002¨\u0006\b"}, d2 = {"errorMessage", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "context", "Landroid/content/Context;", "isNetworkError", BuildConfig.FLAVOR, "isNotFound", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ManagerResultKt {
    public static final String errorMessage(ManagerResult.Error error, Context context) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (error instanceof ManagerResult.Error.ErrorString) {
            return ((ManagerResult.Error.ErrorString) error).getMessage();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isNetworkError(ManagerResult.Error error) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        return error.getNetworkStatus() == NetworkStatus.NoNetwork;
    }

    public static final boolean isNotFound(ManagerResult.Error error) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        return error.getNetworkStatus() == NetworkStatus.NotFound;
    }
}
