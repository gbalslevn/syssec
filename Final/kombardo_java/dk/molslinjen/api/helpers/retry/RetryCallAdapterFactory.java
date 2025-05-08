package dk.molslinjen.api.helpers.retry;

import com.adjust.sdk.Constants;
import com.sun.jna.Callback;
import dk.molslinjen.api.helpers.NoRetriesLeftException;
import dk.molslinjen.api.helpers.retry.RetryCallAdapterFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import okhttp3.Request;
import org.conscrypt.BuildConfig;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "<init>", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getRetry", "Ldk/molslinjen/api/helpers/retry/Retry;", "([Ljava/lang/annotation/Annotation;)Ldk/molslinjen/api/helpers/retry/Retry;", "Companion", "RetryingCall", "RetryCallAdapter", "RetryCallback", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RetryCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "create", "Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RetryCallAdapterFactory create() {
            return new RetryCallAdapterFactory();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001b\u0010\u000f\u001a\u00028\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory$RetryCallAdapter;", "R", "T", "Lretrofit2/CallAdapter;", "delegated", "maxRetries", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "useExponentialBackoff", BuildConfig.FLAVOR, "<init>", "(Lretrofit2/CallAdapter;IJZ)V", "responseType", "Ljava/lang/reflect/Type;", "adapt", "call", "Lretrofit2/Call;", "(Lretrofit2/Call;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryCallAdapter<R, T> implements CallAdapter<R, T> {
        private final long delay;
        private final CallAdapter<R, T> delegated;
        private final int maxRetries;
        private final boolean useExponentialBackoff;

        public RetryCallAdapter(CallAdapter<R, T> delegated, int i5, long j5, boolean z5) {
            Intrinsics.checkNotNullParameter(delegated, "delegated");
            this.delegated = delegated;
            this.maxRetries = i5;
            this.delay = j5;
            this.useExponentialBackoff = z5;
        }

        @Override // retrofit2.CallAdapter
        public T adapt(Call<R> call) {
            Intrinsics.checkNotNullParameter(call, "call");
            int i5 = this.maxRetries;
            if (i5 > 0) {
                call = new RetryingCall(call, i5, this.delay, this.useExponentialBackoff);
            }
            return this.delegated.adapt(call);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            Type responseType = this.delegated.responseType();
            Intrinsics.checkNotNullExpressionValue(responseType, "responseType(...)");
            return responseType;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0013\u001a\u00020\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory$RetryCallback;", "T", "Lretrofit2/Callback;", "call", "Lretrofit2/Call;", Callback.METHOD_NAME, "maxRetries", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "useExponentialBackoff", BuildConfig.FLAVOR, "<init>", "(Lretrofit2/Call;Lretrofit2/Callback;IJZ)V", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicLong;", "nonRetryHttpCodes", BuildConfig.FLAVOR, "onResponse", BuildConfig.FLAVOR, "response", "Lretrofit2/Response;", "onFailure", "t", BuildConfig.FLAVOR, "retryCall", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryCallback<T> implements retrofit2.Callback<T> {
        private final Call<T> call;
        private final retrofit2.Callback<T> callback;
        private final AtomicLong delay;
        private final int maxRetries;
        private final List<Integer> nonRetryHttpCodes;
        private final AtomicInteger retryCount;
        private final boolean useExponentialBackoff;

        public RetryCallback(Call<T> call, retrofit2.Callback<T> callback, int i5, long j5, boolean z5) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.call = call;
            this.callback = callback;
            this.maxRetries = i5;
            this.useExponentialBackoff = z5;
            this.retryCount = new AtomicInteger(0);
            this.delay = new AtomicLong(j5);
            this.nonRetryHttpCodes = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Constants.MINIMAL_ERROR_STATUS_CODE), 401, 403, 404});
        }

        private final void retryCall() {
            if (this.useExponentialBackoff) {
                AtomicLong atomicLong = this.delay;
                atomicLong.set(atomicLong.get() * 2);
            }
            new Timer().schedule(new TimerTask() { // from class: dk.molslinjen.api.helpers.retry.RetryCallAdapterFactory$RetryCallback$retryCall$$inlined$timerTask$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Call call;
                    call = RetryCallAdapterFactory.RetryCallback.this.call;
                    call.clone().enqueue(RetryCallAdapterFactory.RetryCallback.this);
                }
            }, this.delay.get());
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable t5) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t5, "t");
            if (t5 instanceof SerializationException) {
                t5.printStackTrace();
                this.callback.onFailure(call, t5);
                return;
            }
            int incrementAndGet = this.retryCount.incrementAndGet();
            int i5 = this.maxRetries;
            if (incrementAndGet <= i5) {
                t5.printStackTrace();
                retryCall();
            } else if (i5 > 0) {
                this.callback.onFailure(call, new NoRetriesLeftException(this.maxRetries, t5, call.request().getUrl().getUrl()));
            } else {
                this.callback.onFailure(call, t5);
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful() || this.nonRetryHttpCodes.contains(Integer.valueOf(response.code())) || this.retryCount.incrementAndGet() > this.maxRetries) {
                this.callback.onResponse(call, response);
            } else {
                retryCall();
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryCallAdapterFactory$RetryingCall;", "R", "Lretrofit2/Call;", "call", BuildConfig.FLAVOR, "maxRetries", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "useExponentialBackoff", "<init>", "(Lretrofit2/Call;IJZ)V", "Lretrofit2/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "enqueue", "(Lretrofit2/Callback;)V", "cancel", "()V", "clone", "()Lretrofit2/Call;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "isCanceled", "()Z", "Lretrofit2/Call;", "I", "J", "Z", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryingCall<R> implements Call<R> {
        private final Call<R> call;
        private final long delay;
        private final int maxRetries;
        private final boolean useExponentialBackoff;

        public RetryingCall(Call<R> call, int i5, long j5, boolean z5) {
            Intrinsics.checkNotNullParameter(call, "call");
            this.call = call;
            this.maxRetries = i5;
            this.delay = j5;
            this.useExponentialBackoff = z5;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.call.cancel();
        }

        @Override // retrofit2.Call
        public void enqueue(retrofit2.Callback<R> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Call<R> call = this.call;
            call.enqueue(new RetryCallback(call, callback, this.maxRetries, this.delay, this.useExponentialBackoff));
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.call.isCanceled();
        }

        @Override // retrofit2.Call
        public Request request() {
            Request request = this.call.request();
            Intrinsics.checkNotNullExpressionValue(request, "request(...)");
            return request;
        }

        @Override // retrofit2.Call
        public Call<R> clone() {
            Call<R> clone = this.call.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "clone(...)");
            return new RetryingCall(clone, this.maxRetries, this.delay, this.useExponentialBackoff);
        }
    }

    private final Retry getRetry(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof Retry) {
                return (Retry) annotation;
            }
        }
        return null;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        long j5;
        int i5;
        boolean z5;
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Retry retry = getRetry(annotations);
        if (retry != null) {
            int max = retry.max();
            j5 = retry.delay();
            z5 = retry.useExponentialBackoff();
            i5 = max;
        } else {
            j5 = 0;
            i5 = 0;
            z5 = false;
        }
        long j6 = j5;
        CallAdapter<?, ?> nextCallAdapter = retrofit.nextCallAdapter(this, returnType, annotations);
        Intrinsics.checkNotNullExpressionValue(nextCallAdapter, "nextCallAdapter(...)");
        return new RetryCallAdapter(nextCallAdapter, i5, j6, z5);
    }
}
