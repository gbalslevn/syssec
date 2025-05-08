package coil.content;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcoil/util/Logger;", BuildConfig.FLAVOR, "tag", BuildConfig.FLAVOR, "throwable", BuildConfig.FLAVOR, "log", "(Lcoil/util/Logger;Ljava/lang/String;Ljava/lang/Throwable;)V", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Logs, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Logs {
    public static final void log(Logger logger, String str, Throwable th) {
        if (logger.getLevel() <= 6) {
            logger.log(str, 6, null, th);
        }
    }
}
