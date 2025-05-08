package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H¦\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CancelHandlerBase;", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "<init>", "()V", "cause", "invoke", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CancelHandlerBase implements Function1<Throwable, Unit> {
    public abstract void invoke(Throwable cause);
}
