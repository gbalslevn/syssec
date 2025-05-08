package dk.molslinjen.api.helpers.retry;

import com.sun.jna.Callback;
import dk.molslinjen.api.helpers.retry.RetryInfinityCallAdapterFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import org.conscrypt.BuildConfig;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0097\u0002¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "<init>", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getRetry", "Ldk/molslinjen/api/helpers/retry/RetryInfinity;", "([Ljava/lang/annotation/Annotation;)Ldk/molslinjen/api/helpers/retry/RetryInfinity;", "Companion", "RetryingCall", "RetryCallAdapter", "RetryCallback", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RetryInfinityCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "create", "Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RetryInfinityCallAdapterFactory create() {
            return new RetryInfinityCallAdapterFactory();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001b\u0010\r\u001a\u00028\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory$RetryCallAdapter;", "R", "T", "Lretrofit2/CallAdapter;", "delegated", "itShouldRetry", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "<init>", "(Lretrofit2/CallAdapter;ZJ)V", "responseType", "Ljava/lang/reflect/Type;", "adapt", "call", "Lretrofit2/Call;", "(Lretrofit2/Call;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryCallAdapter<R, T> implements CallAdapter<R, T> {
        private final long delay;
        private final CallAdapter<R, T> delegated;
        private final boolean itShouldRetry;

        public RetryCallAdapter(CallAdapter<R, T> delegated, boolean z5, long j5) {
            Intrinsics.checkNotNullParameter(delegated, "delegated");
            this.delegated = delegated;
            this.itShouldRetry = z5;
            this.delay = j5;
        }

        @Override // retrofit2.CallAdapter
        public T adapt(Call<R> call) {
            Intrinsics.checkNotNullParameter(call, "call");
            if (this.itShouldRetry) {
                call = new RetryingCall(call, this.delay);
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

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory$RetryCallback;", "T", "Lretrofit2/Callback;", "call", "Lretrofit2/Call;", Callback.METHOD_NAME, "delay", BuildConfig.FLAVOR, "<init>", "(Lretrofit2/Call;Lretrofit2/Callback;J)V", "onResponse", BuildConfig.FLAVOR, "response", "Lretrofit2/Response;", "onFailure", "t", BuildConfig.FLAVOR, "retryCall", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryCallback<T> implements retrofit2.Callback<T> {
        private final Call<T> call;
        private final retrofit2.Callback<T> callback;
        private final long delay;

        public RetryCallback(Call<T> call, retrofit2.Callback<T> callback, long j5) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.call = call;
            this.callback = callback;
            this.delay = j5;
        }

        private final void retryCall() {
            new Timer().schedule(new TimerTask() { // from class: dk.molslinjen.api.helpers.retry.RetryInfinityCallAdapterFactory$RetryCallback$retryCall$$inlined$timerTask$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Call call;
                    call = RetryInfinityCallAdapterFactory.RetryCallback.this.call;
                    call.clone().enqueue(RetryInfinityCallAdapterFactory.RetryCallback.this);
                }
            }, this.delay);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable t5) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t5, "t");
            t5.printStackTrace();
            retryCall();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful() || response.code() == 404) {
                this.callback.onResponse(call, response);
            } else {
                retryCall();
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/api/helpers/retry/RetryInfinityCallAdapterFactory$RetryingCall;", "R", "Lretrofit2/Call;", "call", BuildConfig.FLAVOR, "delay", "<init>", "(Lretrofit2/Call;J)V", "Lretrofit2/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "enqueue", "(Lretrofit2/Callback;)V", "cancel", "()V", "clone", "()Lretrofit2/Call;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", BuildConfig.FLAVOR, "isCanceled", "()Z", "Lretrofit2/Call;", "J", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RetryingCall<R> implements Call<R> {
        private final Call<R> call;
        private final long delay;

        public RetryingCall(Call<R> call, long j5) {
            Intrinsics.checkNotNullParameter(call, "call");
            this.call = call;
            this.delay = j5;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.call.cancel();
        }

        @Override // retrofit2.Call
        public void enqueue(retrofit2.Callback<R> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Call<R> call = this.call;
            call.enqueue(new RetryCallback(call, callback, this.delay));
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
            return new RetryingCall(clone, this.delay);
        }
    }

    private final RetryInfinity getRetry(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof RetryInfinity) {
                return (RetryInfinity) annotation;
            }
        }
        return null;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        boolean z5;
        long j5;
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        RetryInfinity retry = getRetry(annotations);
        if (retry != null) {
            j5 = retry.delay();
            z5 = true;
        } else {
            z5 = false;
            j5 = 0;
        }
        CallAdapter<?, ?> nextCallAdapter = retrofit.nextCallAdapter(this, returnType, annotations);
        Intrinsics.checkNotNullExpressionValue(nextCallAdapter, "nextCallAdapter(...)");
        return new RetryCallAdapter(nextCallAdapter, z5, j5);
    }
}
