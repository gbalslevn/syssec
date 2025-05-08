package dk.molslinjen.api;

import dk.molslinjen.api.NetworkManager;
import dk.molslinjen.api.helpers.ErrorHandlingAdapterFactory;
import dk.molslinjen.api.helpers.retry.EmptyResponseBodyCallAdapterFactory;
import dk.molslinjen.api.helpers.retry.RetryCallAdapterFactory;
import dk.molslinjen.api.helpers.retry.RetryInfinityCallAdapterFactory;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.providers.IApiInfoProvider;
import dk.molslinjen.core.version.AppVersionProvider;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.conscrypt.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.kotlinx.serialization.KotlinSerializationConverterFactory;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0006234567B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0018*\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!J3\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010!J3\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010!J3\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R \u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b.\u0010/\u0012\u0004\b0\u00101¨\u00068"}, d2 = {"Ldk/molslinjen/api/NetworkManager;", "Ldk/molslinjen/api/INetworkManager;", "Ldk/molslinjen/core/providers/IApiInfoProvider;", "apiProvider", "Ldk/molslinjen/core/version/AppVersionProvider;", "appInfoProvider", "<init>", "(Ldk/molslinjen/core/providers/IApiInfoProvider;Ldk/molslinjen/core/version/AppVersionProvider;)V", "Ldk/molslinjen/core/ApiEnvironment;", "currentApiEnvironment", "()Ldk/molslinjen/core/ApiEnvironment;", BuildConfig.FLAVOR, "baseUrl", "Lretrofit2/Retrofit;", "createDefaultRetrofit", "(Ljava/lang/String;)Lretrofit2/Retrofit;", BuildConfig.FLAVOR, "timeoutInSeconds", "Lokhttp3/OkHttpClient;", "createApiOkHttpClient", "(I)Lokhttp3/OkHttpClient;", "createNotificationServiceOkHttpClient", "createRetailItsOkHttpClient", "createPaymentServiceOkHttpClient", "Lokhttp3/OkHttpClient$Builder;", "createDefaultOkHttpClientBuilder", "(I)Lokhttp3/OkHttpClient$Builder;", "addCommonInterceptors", "(Lokhttp3/OkHttpClient$Builder;)Lokhttp3/OkHttpClient$Builder;", "T", "Ljava/lang/Class;", "serviceType", "createApiService", "(Ljava/lang/Class;Ljava/lang/String;I)Ljava/lang/Object;", "createNotificationService", "createRetailItsService", "createPaymentService", "Ldk/molslinjen/core/providers/IApiInfoProvider;", "Ldk/molslinjen/core/version/AppVersionProvider;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", BuildConfig.FLAVOR, "onUnauthorized", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getOnUnauthorized", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/serialization/json/Json;", "jsonSerializationConfiguration", "Lkotlinx/serialization/json/Json;", "getJsonSerializationConfiguration$annotations", "()V", "ApiOverrideInterceptor", "UserAgentInterceptor", "BasicAuthCredentialsInterceptor", "HeaderInterceptor", "ExceptionInterceptor", "UnauthorizedInterceptor", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkManager implements INetworkManager {
    private final IApiInfoProvider apiProvider;
    private final AppVersionProvider appInfoProvider;
    private final Json jsonSerializationConfiguration;
    private final MutableSharedFlow<Unit> onUnauthorized;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/NetworkManager$ApiOverrideInterceptor;", "Lokhttp3/Interceptor;", "originalBaseUrl", BuildConfig.FLAVOR, "overrideBaseUrlCallback", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ApiOverrideInterceptor implements Interceptor {
        private final String originalBaseUrl;
        private final Function0<String> overrideBaseUrlCallback;

        public ApiOverrideInterceptor(String originalBaseUrl, Function0<String> overrideBaseUrlCallback) {
            Intrinsics.checkNotNullParameter(originalBaseUrl, "originalBaseUrl");
            Intrinsics.checkNotNullParameter(overrideBaseUrlCallback, "overrideBaseUrlCallback");
            this.originalBaseUrl = originalBaseUrl;
            this.overrideBaseUrlCallback = overrideBaseUrlCallback;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Request build;
            Intrinsics.checkNotNullParameter(chain, "chain");
            Request request = chain.request();
            String invoke = this.overrideBaseUrlCallback.invoke();
            HttpUrl httpUrl = null;
            HttpUrl parse = invoke != null ? HttpUrl.INSTANCE.parse(invoke) : null;
            if (parse == null || !StringsKt.startsWith$default(request.getUrl().getUrl(), this.originalBaseUrl, false, 2, (Object) null)) {
                return chain.proceed(request);
            }
            try {
                HttpUrl.Builder scheme = request.getUrl().newBuilder().scheme(parse.getScheme());
                String host = parse.url().toURI().getHost();
                Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                httpUrl = scheme.host(host).build();
            } catch (Exception e5) {
                Logger.INSTANCE.logError(e5);
            }
            if (httpUrl != null && (build = request.newBuilder().url(httpUrl).build()) != null) {
                request = build;
            }
            return chain.proceed(request);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/NetworkManager$BasicAuthCredentialsInterceptor;", "Lokhttp3/Interceptor;", "user", BuildConfig.FLAVOR, "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "credentials", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class BasicAuthCredentialsInterceptor implements Interceptor {
        private String credentials;

        public BasicAuthCredentialsInterceptor(String user, String password) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(password, "password");
            this.credentials = Credentials.basic$default(user, password, null, 4, null);
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            return chain.proceed(chain.request().newBuilder().header("Authorization", this.credentials).build());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/NetworkManager$ExceptionInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ExceptionInterceptor implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            try {
                return chain.proceed(chain.request());
            } catch (Exception e5) {
                if (!(e5 instanceof IOException)) {
                    Logger.INSTANCE.logError(e5);
                }
                Response.Builder code = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(0);
                String message = e5.getMessage();
                if (message == null) {
                    message = BuildConfig.FLAVOR;
                }
                return code.message(message).body(ResponseBody.Companion.create$default(ResponseBody.INSTANCE, "{" + e5 + "}", (MediaType) null, 1, (Object) null)).build();
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/NetworkManager$HeaderInterceptor;", "Lokhttp3/Interceptor;", "headerName", BuildConfig.FLAVOR, "headerValue", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class HeaderInterceptor implements Interceptor {
        private final String headerName;
        private final Function0<String> headerValue;

        public HeaderInterceptor(String headerName, Function0<String> headerValue) {
            Intrinsics.checkNotNullParameter(headerName, "headerName");
            Intrinsics.checkNotNullParameter(headerValue, "headerValue");
            this.headerName = headerName;
            this.headerValue = headerValue;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            return chain.proceed(chain.request().newBuilder().header(this.headerName, this.headerValue.invoke()).build());
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R&\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/api/NetworkManager$UnauthorizedInterceptor;", "Lokhttp3/Interceptor;", "onUnauthorized", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class UnauthorizedInterceptor implements Interceptor {
        private final Function1<Continuation<? super Unit>, Object> onUnauthorized;

        /* JADX WARN: Multi-variable type inference failed */
        public UnauthorizedInterceptor(Function1<? super Continuation<? super Unit>, ? extends Object> onUnauthorized) {
            Intrinsics.checkNotNullParameter(onUnauthorized, "onUnauthorized");
            this.onUnauthorized = onUnauthorized;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            Response proceed = chain.proceed(chain.request());
            if (proceed.getCode() == 401) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new NetworkManager$UnauthorizedInterceptor$intercept$1(this, null), 3, null);
            }
            return proceed;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/api/NetworkManager$UserAgentInterceptor;", "Lokhttp3/Interceptor;", "appInfoProvider", "Ldk/molslinjen/core/version/AppVersionProvider;", "<init>", "(Ldk/molslinjen/core/version/AppVersionProvider;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class UserAgentInterceptor implements Interceptor {
        private final AppVersionProvider appInfoProvider;

        public UserAgentInterceptor(AppVersionProvider appInfoProvider) {
            Intrinsics.checkNotNullParameter(appInfoProvider, "appInfoProvider");
            this.appInfoProvider = appInfoProvider;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            String str;
            Intrinsics.checkNotNullParameter(chain, "chain");
            Request.Builder header = chain.request().newBuilder().header("User-Agent", "Android/" + this.appInfoProvider.getAndroidVersion());
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            Request.Builder header2 = header.header("Language", LocaleExtensionsKt.defaultLanguageString(locale)).header("Source", "app");
            String androidVersion = this.appInfoProvider.getAndroidVersion();
            String versionName = this.appInfoProvider.getVersionName();
            int versionCode = this.appInfoProvider.getVersionCode();
            String description = Environment.INSTANCE.current().description();
            if (description != null) {
                str = " " + description;
            } else {
                str = null;
            }
            return chain.proceed(header2.header("AppSource", "Android " + androidVersion + " v. " + versionName + " (" + versionCode + ")" + str).build());
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.Dev.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.Test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Environment.ProdTest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Environment.Prod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NetworkManager(IApiInfoProvider apiProvider, AppVersionProvider appInfoProvider) {
        Intrinsics.checkNotNullParameter(apiProvider, "apiProvider");
        Intrinsics.checkNotNullParameter(appInfoProvider, "appInfoProvider");
        this.apiProvider = apiProvider;
        this.appInfoProvider = appInfoProvider;
        this.onUnauthorized = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.jsonSerializationConfiguration = JsonKt.Json$default(null, new Function1() { // from class: o1.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit jsonSerializationConfiguration$lambda$0;
                jsonSerializationConfiguration$lambda$0 = NetworkManager.jsonSerializationConfiguration$lambda$0((JsonBuilder) obj);
                return jsonSerializationConfiguration$lambda$0;
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final OkHttpClient.Builder addCommonInterceptors(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        int i5 = WhenMappings.$EnumSwitchMapping$0[Environment.INSTANCE.current().ordinal()];
        if (i5 == 1) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            if (i5 != 2 && i5 != 3 && i5 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            level = HttpLoggingInterceptor.Level.NONE;
        }
        httpLoggingInterceptor.setLevel(level);
        return builder.addNetworkInterceptor(new UserAgentInterceptor(this.appInfoProvider)).addInterceptor(httpLoggingInterceptor).addInterceptor(new ExceptionInterceptor());
    }

    private final OkHttpClient createApiOkHttpClient(int timeoutInSeconds) {
        return addCommonInterceptors(createDefaultOkHttpClientBuilder(timeoutInSeconds).addInterceptor(new UnauthorizedInterceptor(new NetworkManager$createApiOkHttpClient$1(this, null))).addInterceptor(new ApiOverrideInterceptor(ApiEnvironmentExtensionsKt.getVerticaApiUrl(this.apiProvider.getOriginalApi()), new Function0() { // from class: o1.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String createApiOkHttpClient$lambda$1;
                createApiOkHttpClient$lambda$1 = NetworkManager.createApiOkHttpClient$lambda$1(NetworkManager.this);
                return createApiOkHttpClient$lambda$1;
            }
        }))).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createApiOkHttpClient$lambda$1(NetworkManager networkManager) {
        ApiEnvironment overrideApi = networkManager.apiProvider.getOverrideApi();
        if (overrideApi != null) {
            return ApiEnvironmentExtensionsKt.getVerticaApiUrl(overrideApi);
        }
        return null;
    }

    private final OkHttpClient.Builder createDefaultOkHttpClientBuilder(int timeoutInSeconds) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j5 = timeoutInSeconds;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(j5, timeUnit).readTimeout(j5, timeUnit).writeTimeout(j5, timeUnit);
    }

    private final Retrofit createDefaultRetrofit(String baseUrl) {
        Retrofit build = new Retrofit.Builder().baseUrl(baseUrl + "/").addCallAdapterFactory(EmptyResponseBodyCallAdapterFactory.INSTANCE.create()).addCallAdapterFactory(RetryInfinityCallAdapterFactory.INSTANCE.create()).addCallAdapterFactory(RetryCallAdapterFactory.INSTANCE.create()).addCallAdapterFactory(ErrorHandlingAdapterFactory.INSTANCE.create()).addConverterFactory(KotlinSerializationConverterFactory.create(this.jsonSerializationConfiguration, MediaType.INSTANCE.get("application/json"))).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final OkHttpClient createNotificationServiceOkHttpClient(int timeoutInSeconds) {
        return addCommonInterceptors(createDefaultOkHttpClientBuilder(timeoutInSeconds).addNetworkInterceptor(new HeaderInterceptor("apikey", new Function0() { // from class: o1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String createNotificationServiceOkHttpClient$lambda$2;
                createNotificationServiceOkHttpClient$lambda$2 = NetworkManager.createNotificationServiceOkHttpClient$lambda$2(NetworkManager.this);
                return createNotificationServiceOkHttpClient$lambda$2;
            }
        }))).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createNotificationServiceOkHttpClient$lambda$2(NetworkManager networkManager) {
        return ApiEnvironmentExtensionsKt.getNotificationServiceApiKey(networkManager.currentApiEnvironment());
    }

    private final OkHttpClient createPaymentServiceOkHttpClient(int timeoutInSeconds) {
        return addCommonInterceptors(createDefaultOkHttpClientBuilder(timeoutInSeconds).addNetworkInterceptor(new HeaderInterceptor("apikey", new Function0() { // from class: o1.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String createPaymentServiceOkHttpClient$lambda$3;
                createPaymentServiceOkHttpClient$lambda$3 = NetworkManager.createPaymentServiceOkHttpClient$lambda$3();
                return createPaymentServiceOkHttpClient$lambda$3;
            }
        }))).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createPaymentServiceOkHttpClient$lambda$3() {
        return ApiConstants$Payment.INSTANCE.getPaymentServiceApiKey();
    }

    private final OkHttpClient createRetailItsOkHttpClient(int timeoutInSeconds) {
        ApiEnvironment currentApiEnvironment = currentApiEnvironment();
        return addCommonInterceptors(createDefaultOkHttpClientBuilder(timeoutInSeconds).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).addNetworkInterceptor(new BasicAuthCredentialsInterceptor(ApiEnvironmentExtensionsKt.getRetailItsApiUser(currentApiEnvironment), ApiEnvironmentExtensionsKt.getRetailItsApiKey(currentApiEnvironment)))).build();
    }

    private final ApiEnvironment currentApiEnvironment() {
        ApiEnvironment overrideApi = this.apiProvider.getOverrideApi();
        return overrideApi == null ? this.apiProvider.getOriginalApi() : overrideApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonSerializationConfiguration$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setExplicitNulls(false);
        Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.api.INetworkManager
    public <T> T createApiService(Class<T> serviceType, String baseUrl, int timeoutInSeconds) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return (T) createDefaultRetrofit(baseUrl).newBuilder().client(createApiOkHttpClient(timeoutInSeconds)).build().create(serviceType);
    }

    @Override // dk.molslinjen.api.INetworkManager
    public <T> T createNotificationService(Class<T> serviceType, String baseUrl, int timeoutInSeconds) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return (T) createDefaultRetrofit(baseUrl).newBuilder().client(createNotificationServiceOkHttpClient(timeoutInSeconds)).build().create(serviceType);
    }

    @Override // dk.molslinjen.api.INetworkManager
    public <T> T createPaymentService(Class<T> serviceType, String baseUrl, int timeoutInSeconds) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return (T) createDefaultRetrofit(baseUrl).newBuilder().client(createPaymentServiceOkHttpClient(timeoutInSeconds)).build().create(serviceType);
    }

    @Override // dk.molslinjen.api.INetworkManager
    public <T> T createRetailItsService(Class<T> serviceType, String baseUrl, int timeoutInSeconds) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return (T) createDefaultRetrofit(baseUrl).newBuilder().client(createRetailItsOkHttpClient(timeoutInSeconds)).build().create(serviceType);
    }

    @Override // dk.molslinjen.api.INetworkManager
    public MutableSharedFlow<Unit> getOnUnauthorized() {
        return this.onUnauthorized;
    }
}
