package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\t\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0015\u001a\u00020\u00068\u0002X\u0082D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", BuildConfig.FLAVOR, "factories", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "(Lkotlinx/coroutines/internal/MainDispatcherFactory;Ljava/util/List;)Lkotlinx/coroutines/MainCoroutineDispatcher;", BuildConfig.FLAVOR, "isMissing", "(Lkotlinx/coroutines/MainCoroutineDispatcher;)Z", BuildConfig.FLAVOR, "cause", BuildConfig.FLAVOR, "errorHint", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "createMissingDispatcher", "(Ljava/lang/Throwable;Ljava/lang/String;)Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", BuildConfig.FLAVOR, "throwMissingMainDispatcherException", "()Ljava/lang/Void;", "FAST_SERVICE_LOADER_PROPERTY_NAME", "Ljava/lang/String;", "SUPPORT_MISSING", "Z", "getSUPPORT_MISSING$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MainDispatchersKt {
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = false;

    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable th, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            th = null;
        }
        if ((i5 & 2) != 0) {
            str = null;
        }
        return createMissingDispatcher(th, str);
    }

    public static final boolean isMissing(MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher.getImmediate() instanceof MissingMainCoroutineDispatcher;
    }

    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final MainCoroutineDispatcher tryCreateDispatcher(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return createMissingDispatcher(th, mainDispatcherFactory.hintOnError());
        }
    }
}
