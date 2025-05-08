package dk.molslinjen.api.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/api/helpers/NoRetriesLeftException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "maxRetries", BuildConfig.FLAVOR, "throwable", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;)V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NoRetriesLeftException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoRetriesLeftException(int i5, Throwable throwable, String url) {
        super("No retries left after " + i5 + " attempts. " + url, throwable);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
