package okhttp3.internal.concurrent;

import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "log", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Ljava/lang/String;)V", BuildConfig.FLAVOR, "ns", "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TaskLoggerKt {
    public static final String formatDuration(long j5) {
        String str;
        if (j5 <= -999500000) {
            str = ((j5 - 500000000) / 1000000000) + " s ";
        } else if (j5 <= -999500) {
            str = ((j5 - 500000) / 1000000) + " ms";
        } else if (j5 <= 0) {
            str = ((j5 - 500) / Constants.ONE_SECOND) + " µs";
        } else if (j5 < 999500) {
            str = ((j5 + 500) / Constants.ONE_SECOND) + " µs";
        } else if (j5 < 999500000) {
            str = ((j5 + 500000) / 1000000) + " ms";
        } else {
            str = ((j5 + 500000000) / 1000000000) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.INSTANCE.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }
}
