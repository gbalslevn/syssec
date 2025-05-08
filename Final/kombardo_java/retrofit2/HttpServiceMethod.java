package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected ReturnT adapt(Call<ResponseT> call, Object[] objArr) {
            return this.callAdapter.adapt(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;
        private final boolean isUnit;

        SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter, boolean z5, boolean z6) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
            this.isNullable = z5;
            this.isUnit = z6;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> adapt = this.callAdapter.adapt(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.isUnit ? KotlinExtensions.awaitUnit(adapt, continuation) : this.isNullable ? KotlinExtensions.awaitNullable(adapt, continuation) : KotlinExtensions.await(adapt, continuation);
            } catch (LinkageError e5) {
                throw e5;
            } catch (ThreadDeath e6) {
                throw e6;
            } catch (VirtualMachineError e7) {
                throw e7;
            } catch (Throwable th) {
                return KotlinExtensions.suspendAndThrow(th, continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> adapt = this.callAdapter.adapt(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(adapt, continuation);
            } catch (Exception e5) {
                return KotlinExtensions.suspendAndThrow(e5, continuation);
            }
        }
    }

    HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e5) {
            throw Utils.methodError(method, e5, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e5) {
            throw Utils.methodError(method, e5, "Unable to create converter for %s", type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        Type genericReturnType;
        boolean z5;
        boolean z6;
        boolean isUnit;
        boolean z7 = requestFactory.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z7) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) == Response.class && (parameterLowerBound instanceof ParameterizedType)) {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z5 = true;
                isUnit = false;
            } else {
                if (Utils.getRawType(parameterLowerBound) == Call.class) {
                    throw Utils.methodError(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound));
                }
                isUnit = Utils.isUnit(parameterLowerBound);
                z5 = false;
            }
            genericReturnType = new Utils.ParameterizedTypeImpl(null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
            z6 = isUnit;
        } else {
            genericReturnType = method.getGenericReturnType();
            z5 = false;
            z6 = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, genericReturnType, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == okhttp3.Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (responseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (requestFactory.httpMethod.equals("HEAD") && !Void.class.equals(responseType) && !Utils.isUnit(responseType)) {
            throw Utils.methodError(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
        Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
        Call.Factory factory = retrofit.callFactory;
        return !z7 ? new CallAdapted(requestFactory, factory, createResponseConverter, createCallAdapter) : z5 ? new SuspendForResponse(requestFactory, factory, createResponseConverter, createCallAdapter) : new SuspendForBody(requestFactory, factory, createResponseConverter, createCallAdapter, false, z6);
    }

    protected abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.ServiceMethod
    public final ReturnT invoke(Object obj, Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, obj, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
