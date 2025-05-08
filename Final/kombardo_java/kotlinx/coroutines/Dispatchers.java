package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR \u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "Unconfined", "getUnconfined", "getUnconfined$annotations", "IO", "getIO", "getIO$annotations", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();
    private static final CoroutineDispatcher Default = DefaultScheduler.INSTANCE;
    private static final CoroutineDispatcher Unconfined = Unconfined.INSTANCE;
    private static final CoroutineDispatcher IO = DefaultIoScheduler.INSTANCE;

    private Dispatchers() {
    }

    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    public static final CoroutineDispatcher getIO() {
        return IO;
    }

    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }
}
