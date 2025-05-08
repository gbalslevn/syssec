package coil.content;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005J3\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcoil/util/DebugLogger;", "Lcoil/util/Logger;", BuildConfig.FLAVOR, "level", "<init>", "(I)V", "value", BuildConfig.FLAVOR, "assertValidLevel", BuildConfig.FLAVOR, "tag", "priority", "message", BuildConfig.FLAVOR, "throwable", "log", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "I", "getLevel", "()I", "setLevel", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DebugLogger implements Logger {
    private int level;

    public DebugLogger(int i5) {
        this.level = i5;
        assertValidLevel(i5);
    }

    private final void assertValidLevel(int value) {
        if (2 > value || value >= 8) {
            throw new IllegalArgumentException(("Invalid log level: " + value).toString());
        }
    }

    @Override // coil.content.Logger
    public int getLevel() {
        return this.level;
    }

    @Override // coil.content.Logger
    public void log(String tag, int priority, String message, Throwable throwable) {
        if (message != null) {
            Log.println(priority, tag, message);
        }
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            Log.println(priority, tag, stringWriter.toString());
        }
    }

    public /* synthetic */ DebugLogger(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 3 : i5);
    }
}
