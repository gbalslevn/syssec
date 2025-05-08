package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\tR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/io/PrintStream;", "err", BuildConfig.FLAVOR, "printStackTrace", "(Ljava/io/PrintStream;)V", "Ljava/io/PrintWriter;", "(Ljava/io/PrintWriter;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "innerThrowables", "Ljava/util/List;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AggregateException extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> innerThrowables;

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream err) {
        Intrinsics.checkNotNullParameter(err, "err");
        super.printStackTrace(err);
        int i5 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i5++;
            err.append((CharSequence) String.valueOf(i5));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter err) {
        Intrinsics.checkNotNullParameter(err, "err");
        super.printStackTrace(err);
        int i5 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i5++;
            err.append((CharSequence) String.valueOf(i5));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }
}
