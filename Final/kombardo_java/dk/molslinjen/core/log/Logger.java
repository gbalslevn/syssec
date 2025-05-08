package dk.molslinjen.core.log;

import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/core/log/Logger;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "priority", BuildConfig.FLAVOR, "tag", "message", BuildConfig.FLAVOR, "logToLogcat", "(ILjava/lang/String;Ljava/lang/String;)V", "log", "(Ljava/lang/String;Ljava/lang/String;I)V", "Ldk/molslinjen/core/log/CriticalLog;", "criticalLog", "logCritical", "(Ldk/molslinjen/core/log/CriticalLog;)V", BuildConfig.FLAVOR, "exception", "logError", "(Ljava/lang/Throwable;)V", "logCriticalThenFatalError", "logErrorThenFatalError", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Logger {
    public static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    public static /* synthetic */ void log$default(Logger logger, String str, String str2, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = "Logger";
        }
        if ((i6 & 4) != 0) {
            i5 = 3;
        }
        logger.log(str, str2, i5);
    }

    private final void logToLogcat(int priority, String tag, String message) {
        switch (priority) {
            case 2:
                Log.v(tag, message);
                return;
            case 3:
                Log.d(tag, message);
                return;
            case 4:
                Log.i(tag, message);
                return;
            case 5:
                Log.w(tag, message);
                return;
            case 6:
                Log.e(tag, message);
                return;
            case 7:
                Log.wtf(tag, message);
                return;
            default:
                return;
        }
    }

    public final void log(String message, String tag, int priority) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Environment.Dev.isCurrent()) {
            logToLogcat(priority, tag, message);
        } else if (Environment.Prod.isCurrent()) {
            FirebaseCrashlytics.getInstance().log(message);
        } else {
            FirebaseCrashlytics.getInstance().log(message);
            logToLogcat(priority, tag, message);
        }
    }

    public final void logCritical(CriticalLog criticalLog) {
        Intrinsics.checkNotNullParameter(criticalLog, "criticalLog");
        logError(criticalLog);
    }

    public final void logCriticalThenFatalError(CriticalLog criticalLog) {
        Intrinsics.checkNotNullParameter(criticalLog, "criticalLog");
        logErrorThenFatalError(criticalLog);
    }

    public final void logError(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        FirebaseCrashlytics.getInstance().recordException(exception);
        exception.printStackTrace();
        log$default(this, "Error: " + exception, null, 0, 6, null);
    }

    public final void logErrorThenFatalError(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        FirebaseCrashlytics.getInstance().recordException(exception);
        if (Environment.Dev.isCurrent()) {
            throw exception;
        }
        if (Environment.Test.isCurrent()) {
            throw exception;
        }
        if (Environment.ProdTest.isCurrent()) {
            throw exception;
        }
    }
}
