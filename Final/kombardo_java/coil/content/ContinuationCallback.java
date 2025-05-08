package coil.content;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/util/ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "Lokhttp3/Call;", "call", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "continuation", "<init>", "(Lokhttp3/Call;Lkotlinx/coroutines/CancellableContinuation;)V", "response", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "Ljava/io/IOException;", "e", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lokhttp3/Call;", "Lkotlinx/coroutines/CancellableContinuation;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {
    private final Call call;
    private final CancellableContinuation<Response> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationCallback(Call call, CancellableContinuation<? super Response> cancellableContinuation) {
        this.call = call;
        this.continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e5) {
        if (call.getCanceled()) {
            return;
        }
        CancellableContinuation<Response> cancellableContinuation = this.continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(e5)));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.continuation.resumeWith(Result.m3567constructorimpl(response));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable cause) {
        try {
            this.call.cancel();
        } catch (Throwable unused) {
        }
    }
}
