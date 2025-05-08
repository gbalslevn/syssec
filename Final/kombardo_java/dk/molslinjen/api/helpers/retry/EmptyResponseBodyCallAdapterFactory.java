package dk.molslinjen.api.helpers.retry;

import com.sun.jna.Callback;
import java.io.EOFException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import org.conscrypt.BuildConfig;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "<init>", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getAnnotation", "Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyAsSuccess;", "([Ljava/lang/annotation/Annotation;)Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyAsSuccess;", "Companion", "EmptyResponseBodyCall", "EmptyResponseBodyCallAdapter", "EmptyResponseBodyCallback", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptyResponseBodyCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "create", "Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EmptyResponseBodyCallAdapterFactory create() {
            return new EmptyResponseBodyCallAdapterFactory();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory$EmptyResponseBodyCall;", "R", "Lretrofit2/Call;", "call", "<init>", "(Lretrofit2/Call;)V", "Lretrofit2/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "enqueue", "(Lretrofit2/Callback;)V", "cancel", "()V", "clone", "()Lretrofit2/Call;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", BuildConfig.FLAVOR, "isCanceled", "()Z", "Lretrofit2/Call;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EmptyResponseBodyCall<R> implements Call<R> {
        private final Call<R> call;

        public EmptyResponseBodyCall(Call<R> call) {
            Intrinsics.checkNotNullParameter(call, "call");
            this.call = call;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.call.cancel();
        }

        @Override // retrofit2.Call
        public void enqueue(retrofit2.Callback<R> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.call.enqueue(new EmptyResponseBodyCallback(callback));
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
            return new EmptyResponseBodyCall(clone);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001b\u0010\u000b\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory$EmptyResponseBodyCallAdapter;", "R", "T", "Lretrofit2/CallAdapter;", "delegated", "enabled", BuildConfig.FLAVOR, "<init>", "(Lretrofit2/CallAdapter;Z)V", "responseType", "Ljava/lang/reflect/Type;", "adapt", "call", "Lretrofit2/Call;", "(Lretrofit2/Call;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EmptyResponseBodyCallAdapter<R, T> implements CallAdapter<R, T> {
        private final CallAdapter<R, T> delegated;
        private final boolean enabled;

        public EmptyResponseBodyCallAdapter(CallAdapter<R, T> delegated, boolean z5) {
            Intrinsics.checkNotNullParameter(delegated, "delegated");
            this.delegated = delegated;
            this.enabled = z5;
        }

        @Override // retrofit2.CallAdapter
        public T adapt(Call<R> call) {
            Intrinsics.checkNotNullParameter(call, "call");
            if (this.enabled) {
                call = new EmptyResponseBodyCall(call);
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u001e\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyCallAdapterFactory$EmptyResponseBodyCallback;", "T", "Lretrofit2/Callback;", Callback.METHOD_NAME, "<init>", "(Lretrofit2/Callback;)V", "onResponse", BuildConfig.FLAVOR, "call", "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EmptyResponseBodyCallback<T> implements retrofit2.Callback<T> {
        private final retrofit2.Callback<T> callback;

        public EmptyResponseBodyCallback(retrofit2.Callback<T> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable t5) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t5, "t");
            if (t5 instanceof EOFException) {
                this.callback.onResponse(call, Response.success(204, (Object) null));
            } else {
                this.callback.onFailure(call, t5);
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            this.callback.onResponse(call, response);
        }
    }

    private final EmptyResponseBodyAsSuccess getAnnotation(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof EmptyResponseBodyAsSuccess) {
                return (EmptyResponseBodyAsSuccess) annotation;
            }
        }
        return null;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        EmptyResponseBodyAsSuccess annotation = getAnnotation(annotations);
        CallAdapter<?, ?> nextCallAdapter = retrofit.nextCallAdapter(this, returnType, annotations);
        Intrinsics.checkNotNullExpressionValue(nextCallAdapter, "nextCallAdapter(...)");
        return new EmptyResponseBodyCallAdapter(nextCallAdapter, annotation != null);
    }
}
