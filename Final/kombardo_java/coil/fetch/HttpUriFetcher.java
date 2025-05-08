package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.content.Calls;
import coil.content.Utils;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0016H\u0002J\f\u0010-\u001a\u00020.*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", BuildConfig.FLAVOR, "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", BuildConfig.FLAVOR, "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "response", "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", BuildConfig.FLAVOR, "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z5) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z5;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), Constants.SCHEME);
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z5) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeNetworkRequest(Request request, Continuation<? super Response> continuation) {
        HttpUriFetcher$executeNetworkRequest$1 httpUriFetcher$executeNetworkRequest$1;
        int i5;
        Response execute;
        if (continuation instanceof HttpUriFetcher$executeNetworkRequest$1) {
            httpUriFetcher$executeNetworkRequest$1 = (HttpUriFetcher$executeNetworkRequest$1) continuation;
            int i6 = httpUriFetcher$executeNetworkRequest$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                httpUriFetcher$executeNetworkRequest$1.label = i6 - Integer.MIN_VALUE;
                Object obj = httpUriFetcher$executeNetworkRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = httpUriFetcher$executeNetworkRequest$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Utils.isMainThread()) {
                        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
                            throw new NetworkOnMainThreadException();
                        }
                        execute = this.callFactory.getValue().newCall(request).execute();
                        if (!execute.isSuccessful() || execute.getCode() == 304) {
                            return execute;
                        }
                        ResponseBody body = execute.getBody();
                        if (body != null) {
                            Utils.closeQuietly(body);
                        }
                        throw new HttpException(execute);
                    }
                    Call newCall = this.callFactory.getValue().newCall(request);
                    httpUriFetcher$executeNetworkRequest$1.label = 1;
                    obj = Calls.await(newCall, httpUriFetcher$executeNetworkRequest$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                execute = (Response) obj;
                if (execute.isSuccessful()) {
                }
                return execute;
            }
        }
        httpUriFetcher$executeNetworkRequest$1 = new HttpUriFetcher$executeNetworkRequest$1(this, continuation);
        Object obj2 = httpUriFetcher$executeNetworkRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = httpUriFetcher$executeNetworkRequest$1.label;
        if (i5 != 0) {
        }
        execute = (Response) obj2;
        if (execute.isSuccessful()) {
        }
        return execute;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    private final boolean isCacheable(Request request, Response response) {
        return this.options.getDiskCachePolicy().getWriteEnabled() && (!this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response));
    }

    private final Request newRequest() {
        Request.Builder headers = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            headers.tag(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            headers.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                headers.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            headers.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            headers.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return headers.build();
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            BufferedSource buffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(buffer);
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                cacheResponse = null;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException unused) {
            return null;
        }
    }

    private final DataSource toDataSource(Response response) {
        return response.getNetworkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor openEditor;
        Throwable th;
        Unit unit;
        Long l5;
        Unit unit2;
        Throwable th2 = null;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            openEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache value = this.diskCache.getValue();
            openEditor = value != null ? value.openEditor(getDiskCacheKey()) : null;
        }
        try {
            if (openEditor == null) {
                return null;
            }
            try {
                if (response.getCode() != 304 || cacheResponse == null) {
                    BufferedSink buffer = Okio.buffer(getFileSystem().sink(openEditor.getMetadata(), false));
                    try {
                        new CacheResponse(response).writeTo(buffer);
                        unit = Unit.INSTANCE;
                        if (buffer != null) {
                            try {
                                buffer.close();
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        th = null;
                    } catch (Throwable th4) {
                        if (buffer != null) {
                            try {
                                buffer.close();
                            } catch (Throwable th5) {
                                ExceptionsKt.addSuppressed(th4, th5);
                            }
                        }
                        th = th4;
                        unit = null;
                    }
                    if (th != null) {
                        throw th;
                    }
                    Intrinsics.checkNotNull(unit);
                    BufferedSink buffer2 = Okio.buffer(getFileSystem().sink(openEditor.getData(), false));
                    try {
                        ResponseBody body = response.getBody();
                        Intrinsics.checkNotNull(body);
                        l5 = Long.valueOf(body.getSource().readAll(buffer2));
                        if (buffer2 != null) {
                            try {
                                buffer2.close();
                            } catch (Throwable th6) {
                                th2 = th6;
                            }
                        }
                    } catch (Throwable th7) {
                        if (buffer2 != null) {
                            try {
                                buffer2.close();
                            } catch (Throwable th8) {
                                ExceptionsKt.addSuppressed(th7, th8);
                            }
                        }
                        th2 = th7;
                        l5 = null;
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                    Intrinsics.checkNotNull(l5);
                } else {
                    Response build = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.getHeaders())).build();
                    BufferedSink buffer3 = Okio.buffer(getFileSystem().sink(openEditor.getMetadata(), false));
                    try {
                        new CacheResponse(build).writeTo(buffer3);
                        unit2 = Unit.INSTANCE;
                        if (buffer3 != null) {
                            try {
                                buffer3.close();
                            } catch (Throwable th9) {
                                th2 = th9;
                            }
                        }
                    } catch (Throwable th10) {
                        if (buffer3 != null) {
                            try {
                                buffer3.close();
                            } catch (Throwable th11) {
                                ExceptionsKt.addSuppressed(th10, th11);
                            }
                        }
                        th2 = th10;
                        unit2 = null;
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                    Intrinsics.checkNotNull(unit2);
                }
                DiskCache.Snapshot commitAndOpenSnapshot = openEditor.commitAndOpenSnapshot();
                Utils.closeQuietly(response);
                return commitAndOpenSnapshot;
            } catch (Exception e5) {
                Utils.abortQuietly(openEditor);
                throw e5;
            }
        } catch (Throwable th12) {
            Utils.closeQuietly(response);
            throw th12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012c A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:14:0x0188, B:36:0x011e, B:38:0x012c, B:40:0x013a, B:41:0x0143, B:43:0x014d, B:45:0x0155, B:47:0x016d), top: B:35:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014d A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:14:0x0188, B:36:0x011e, B:38:0x012c, B:40:0x013a, B:41:0x0143, B:43:0x014d, B:45:0x0155, B:47:0x016d), top: B:35:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(Continuation<? super FetchResult> continuation) {
        HttpUriFetcher$fetch$1 httpUriFetcher$fetch$1;
        int i5;
        DiskCache.Snapshot snapshot;
        Exception e5;
        CacheStrategy compute;
        HttpUriFetcher httpUriFetcher;
        DiskCache.Snapshot snapshot2;
        CacheStrategy cacheStrategy;
        Response response;
        Response response2;
        Exception e6;
        HttpUriFetcher httpUriFetcher2;
        try {
            try {
                if (continuation instanceof HttpUriFetcher$fetch$1) {
                    httpUriFetcher$fetch$1 = (HttpUriFetcher$fetch$1) continuation;
                    int i6 = httpUriFetcher$fetch$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        httpUriFetcher$fetch$1.label = i6 - Integer.MIN_VALUE;
                        Object obj = httpUriFetcher$fetch$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = httpUriFetcher$fetch$1.label;
                        if (i5 != 0) {
                            ResultKt.throwOnFailure(obj);
                            DiskCache.Snapshot readFromDiskCache = readFromDiskCache();
                            try {
                                if (readFromDiskCache != null) {
                                    Long size = getFileSystem().metadata(readFromDiskCache.getMetadata()).getSize();
                                    if (size != null && size.longValue() == 0) {
                                        return new SourceResult(toImageSource(readFromDiskCache), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
                                    }
                                    if (!this.respectCacheHeaders) {
                                        ImageSource imageSource = toImageSource(readFromDiskCache);
                                        String str = this.url;
                                        CacheResponse cacheResponse = toCacheResponse(readFromDiskCache);
                                        return new SourceResult(imageSource, getMimeType$coil_base_release(str, cacheResponse != null ? cacheResponse.getContentType() : null), DataSource.DISK);
                                    }
                                    compute = new CacheStrategy.Factory(newRequest(), toCacheResponse(readFromDiskCache)).compute();
                                    if (compute.getNetworkRequest() == null && compute.getCacheResponse() != null) {
                                        return new SourceResult(toImageSource(readFromDiskCache), getMimeType$coil_base_release(this.url, compute.getCacheResponse().getContentType()), DataSource.DISK);
                                    }
                                } else {
                                    compute = new CacheStrategy.Factory(newRequest(), null).compute();
                                }
                                Request networkRequest = compute.getNetworkRequest();
                                Intrinsics.checkNotNull(networkRequest);
                                httpUriFetcher$fetch$1.L$0 = this;
                                httpUriFetcher$fetch$1.L$1 = readFromDiskCache;
                                httpUriFetcher$fetch$1.L$2 = compute;
                                httpUriFetcher$fetch$1.label = 1;
                                Object executeNetworkRequest = executeNetworkRequest(networkRequest, httpUriFetcher$fetch$1);
                                if (executeNetworkRequest == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpUriFetcher = this;
                                CacheStrategy cacheStrategy2 = compute;
                                snapshot2 = readFromDiskCache;
                                obj = executeNetworkRequest;
                                cacheStrategy = cacheStrategy2;
                            } catch (Exception e7) {
                                snapshot = readFromDiskCache;
                                e5 = e7;
                                if (snapshot != null) {
                                }
                                throw e5;
                            }
                        } else {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                response2 = (Response) httpUriFetcher$fetch$1.L$2;
                                snapshot2 = (DiskCache.Snapshot) httpUriFetcher$fetch$1.L$1;
                                httpUriFetcher2 = (HttpUriFetcher) httpUriFetcher$fetch$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Response response3 = (Response) obj;
                                    ResponseBody requireBody = Utils.requireBody(response3);
                                    return new SourceResult(httpUriFetcher2.toImageSource(requireBody), httpUriFetcher2.getMimeType$coil_base_release(httpUriFetcher2.url, requireBody.get$contentType()), httpUriFetcher2.toDataSource(response3));
                                } catch (Exception e8) {
                                    e6 = e8;
                                    Utils.closeQuietly(response2);
                                    throw e6;
                                }
                            }
                            CacheStrategy cacheStrategy3 = (CacheStrategy) httpUriFetcher$fetch$1.L$2;
                            snapshot = (DiskCache.Snapshot) httpUriFetcher$fetch$1.L$1;
                            httpUriFetcher = (HttpUriFetcher) httpUriFetcher$fetch$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                cacheStrategy = cacheStrategy3;
                                snapshot2 = snapshot;
                            } catch (Exception e9) {
                                e5 = e9;
                                if (snapshot != null) {
                                    Utils.closeQuietly(snapshot);
                                }
                                throw e5;
                            }
                        }
                        response = (Response) obj;
                        ResponseBody requireBody2 = Utils.requireBody(response);
                        snapshot2 = httpUriFetcher.writeToDiskCache(snapshot2, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                        if (snapshot2 == null) {
                            ImageSource imageSource2 = httpUriFetcher.toImageSource(snapshot2);
                            String str2 = httpUriFetcher.url;
                            CacheResponse cacheResponse2 = httpUriFetcher.toCacheResponse(snapshot2);
                            return new SourceResult(imageSource2, httpUriFetcher.getMimeType$coil_base_release(str2, cacheResponse2 != null ? cacheResponse2.getContentType() : null), DataSource.NETWORK);
                        }
                        if (requireBody2.getContentLength() > 0) {
                            return new SourceResult(httpUriFetcher.toImageSource(requireBody2), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, requireBody2.get$contentType()), httpUriFetcher.toDataSource(response));
                        }
                        Utils.closeQuietly(response);
                        Request newRequest = httpUriFetcher.newRequest();
                        httpUriFetcher$fetch$1.L$0 = httpUriFetcher;
                        httpUriFetcher$fetch$1.L$1 = snapshot2;
                        httpUriFetcher$fetch$1.L$2 = response;
                        httpUriFetcher$fetch$1.label = 2;
                        Object executeNetworkRequest2 = httpUriFetcher.executeNetworkRequest(newRequest, httpUriFetcher$fetch$1);
                        if (executeNetworkRequest2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        response2 = response;
                        obj = executeNetworkRequest2;
                        httpUriFetcher2 = httpUriFetcher;
                        Response response32 = (Response) obj;
                        ResponseBody requireBody3 = Utils.requireBody(response32);
                        return new SourceResult(httpUriFetcher2.toImageSource(requireBody3), httpUriFetcher2.getMimeType$coil_base_release(httpUriFetcher2.url, requireBody3.get$contentType()), httpUriFetcher2.toDataSource(response32));
                    }
                }
                snapshot2 = httpUriFetcher.writeToDiskCache(snapshot2, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                if (snapshot2 == null) {
                }
            } catch (Exception e10) {
                response2 = response;
                e6 = e10;
                Utils.closeQuietly(response2);
                throw e6;
            }
            response = (Response) obj;
            ResponseBody requireBody22 = Utils.requireBody(response);
        } catch (Exception e11) {
            e5 = e11;
            snapshot = snapshot2;
            if (snapshot != null) {
            }
            throw e5;
        }
        httpUriFetcher$fetch$1 = new HttpUriFetcher$fetch$1(this, continuation);
        Object obj2 = httpUriFetcher$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = httpUriFetcher$fetch$1.label;
        if (i5 != 0) {
        }
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || StringsKt.startsWith$default(mediaType, MIME_TYPE_TEXT_PLAIN, false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getSource(), this.options.getContext());
    }
}
