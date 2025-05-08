package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import coil.EventListener;
import coil.content.ImageLoaderOptions;
import coil.content.Lifecycles;
import coil.content.Logger;
import coil.content.SystemCallbacks;
import coil.content.Utils;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.request.NullRequestDataException;
import coil.request.OneShotDisposable;
import coil.request.RequestDelegate;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 d2\u00020\u0001:\u0001dBg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0083@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J)\u0010(\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020'2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020\u0017H\u0016¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u00020$2\u0006\u00102\u001a\u00020\u0019H\u0000¢\u0006\u0004\b3\u00104R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u00108R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b:\u0010;R\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010<\u001a\u0004\b=\u0010>R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\b?\u0010>R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010<\u001a\u0004\b@\u0010>R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010G\u001a\u0004\bH\u0010IR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010D\u001a\u0004\bW\u0010FR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001d\u0010c\u001a\u0004\u0018\u00010\u00078VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b_\u0010`*\u0004\ba\u0010b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "Landroid/content/Context;", "context", "Lcoil/request/DefaultRequestOptions;", "defaults", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "memoryCacheLazy", "Lcoil/disk/DiskCache;", "diskCacheLazy", "Lokhttp3/Call$Factory;", "callFactoryLazy", "Lcoil/EventListener$Factory;", "eventListenerFactory", "Lcoil/ComponentRegistry;", "componentRegistry", "Lcoil/util/ImageLoaderOptions;", "options", "Lcoil/util/Logger;", "logger", "<init>", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "Lcoil/request/ImageRequest;", "initialRequest", BuildConfig.FLAVOR, "type", "Lcoil/request/ImageResult;", "executeMain", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/request/SuccessResult;", "result", "Lcoil/target/Target;", "target", "Lcoil/EventListener;", "eventListener", BuildConfig.FLAVOR, "onSuccess", "(Lcoil/request/SuccessResult;Lcoil/target/Target;Lcoil/EventListener;)V", "Lcoil/request/ErrorResult;", "onError", "(Lcoil/request/ErrorResult;Lcoil/target/Target;Lcoil/EventListener;)V", "request", "onCancel", "(Lcoil/request/ImageRequest;Lcoil/EventListener;)V", "Lcoil/request/Disposable;", "enqueue", "(Lcoil/request/ImageRequest;)Lcoil/request/Disposable;", "execute", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "level", "onTrimMemory$coil_base_release", "(I)V", "onTrimMemory", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "Lkotlin/Lazy;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getCallFactoryLazy", "Lcoil/EventListener$Factory;", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "Lcoil/ComponentRegistry;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "Lcoil/util/ImageLoaderOptions;", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "Lcoil/util/Logger;", "getLogger", "()Lcoil/util/Logger;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lcoil/util/SystemCallbacks;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "Lcoil/request/RequestService;", "requestService", "Lcoil/request/RequestService;", "components", "getComponents", BuildConfig.FLAVOR, "Lcoil/intercept/Interceptor;", "interceptors", "Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "memoryCache", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealImageLoader implements ImageLoader {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Logger logger;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry;
        this.options = imageLoaderOptions;
        this.logger = logger;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this, context, imageLoaderOptions.getNetworkObserverEnabled());
        this.systemCallbacks = systemCallbacks;
        RequestService requestService = new RequestService(this, systemCallbacks, logger);
        this.requestService = requestService;
        this.components = componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(imageLoaderOptions.getBitmapFactoryMaxParallelism(), imageLoaderOptions.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().getInterceptors(), new EngineInterceptor(this, requestService, logger));
        this.shutdown = new AtomicBoolean(false);
        systemCallbacks.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0190 A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:13:0x0046, B:14:0x018a, B:16:0x0190, B:20:0x019b, B:22:0x019f), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x019b A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:13:0x0046, B:14:0x018a, B:16:0x0190, B:20:0x019b, B:22:0x019f), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b7 A[Catch: all -> 0x01c8, TRY_LEAVE, TryCatch #3 {all -> 0x01c8, blocks: (B:25:0x01b3, B:27:0x01b7, B:30:0x01ca, B:31:0x01cd), top: B:24:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01ca A[Catch: all -> 0x01c8, TRY_ENTER, TryCatch #3 {all -> 0x01c8, blocks: (B:25:0x01b3, B:27:0x01b7, B:30:0x01ca, B:31:0x01cd), top: B:24:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:53:0x00f2, B:55:0x00f8, B:57:0x00fe, B:59:0x010b, B:61:0x0113, B:62:0x0125, B:64:0x012b, B:65:0x012e, B:67:0x0137, B:68:0x013a, B:73:0x0121), top: B:52:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0113 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:53:0x00f2, B:55:0x00f8, B:57:0x00fe, B:59:0x010b, B:61:0x0113, B:62:0x0125, B:64:0x012b, B:65:0x012e, B:67:0x0137, B:68:0x013a, B:73:0x0121), top: B:52:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:53:0x00f2, B:55:0x00f8, B:57:0x00fe, B:59:0x010b, B:61:0x0113, B:62:0x0125, B:64:0x012b, B:65:0x012e, B:67:0x0137, B:68:0x013a, B:73:0x0121), top: B:52:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0137 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:53:0x00f2, B:55:0x00f8, B:57:0x00fe, B:59:0x010b, B:61:0x0113, B:62:0x0125, B:64:0x012b, B:65:0x012e, B:67:0x0137, B:68:0x013a, B:73:0x0121), top: B:52:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0121 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:53:0x00f2, B:55:0x00f8, B:57:0x00fe, B:59:0x010b, B:61:0x0113, B:62:0x0125, B:64:0x012b, B:65:0x012e, B:67:0x0137, B:68:0x013a, B:73:0x0121), top: B:52:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeMain(ImageRequest imageRequest, int i5, Continuation<? super ImageResult> continuation) {
        RealImageLoader$executeMain$1 realImageLoader$executeMain$1;
        Object coroutine_suspended;
        int i6;
        RequestDelegate requestDelegate;
        ImageRequest build;
        RealImageLoader realImageLoader;
        RequestDelegate requestDelegate2;
        EventListener eventListener;
        RealImageLoader realImageLoader2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        RequestDelegate requestDelegate3;
        MemoryCache memoryCache;
        Bitmap bitmap;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        Bitmap bitmap2;
        RealImageLoader realImageLoader3;
        RequestDelegate requestDelegate4;
        Object obj;
        ImageRequest imageRequest3;
        Object withContext;
        Object obj2;
        ImageResult imageResult;
        try {
            if (continuation instanceof RealImageLoader$executeMain$1) {
                realImageLoader$executeMain$1 = (RealImageLoader$executeMain$1) continuation;
                int i7 = realImageLoader$executeMain$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    realImageLoader$executeMain$1.label = i7 - Integer.MIN_VALUE;
                    Object obj3 = realImageLoader$executeMain$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i6 = realImageLoader$executeMain$1.label;
                    if (i6 != 0) {
                        ResultKt.throwOnFailure(obj3);
                        requestDelegate = this.requestService.requestDelegate(imageRequest, JobKt.getJob(realImageLoader$executeMain$1.getContext()));
                        requestDelegate.assertActive();
                        build = ImageRequest.newBuilder$default(imageRequest, null, 1, null).defaults(getDefaults()).build();
                        EventListener create = this.eventListenerFactory.create(build);
                        try {
                            if (build.getData() == NullRequestData.INSTANCE) {
                                throw new NullRequestDataException();
                            }
                            requestDelegate.start();
                            if (i5 == 0) {
                                Lifecycle lifecycle = build.getLifecycle();
                                realImageLoader$executeMain$1.L$0 = this;
                                realImageLoader$executeMain$1.L$1 = requestDelegate;
                                realImageLoader$executeMain$1.L$2 = build;
                                realImageLoader$executeMain$1.L$3 = create;
                                realImageLoader$executeMain$1.label = 1;
                                if (Lifecycles.awaitStarted(lifecycle, realImageLoader$executeMain$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                realImageLoader2 = this;
                                imageRequest2 = build;
                                eventListener2 = create;
                                requestDelegate3 = requestDelegate;
                            } else {
                                realImageLoader2 = this;
                                imageRequest2 = build;
                                eventListener2 = create;
                                memoryCache = realImageLoader2.getMemoryCache();
                                if (memoryCache != null) {
                                    MemoryCache.Key placeholderMemoryCacheKey = imageRequest2.getPlaceholderMemoryCacheKey();
                                    MemoryCache.Value value = placeholderMemoryCacheKey != null ? memoryCache.get(placeholderMemoryCacheKey) : null;
                                    if (value != null) {
                                        bitmap = value.getBitmap();
                                        Drawable bitmapDrawable = bitmap == null ? new BitmapDrawable(imageRequest2.getContext().getResources(), bitmap) : imageRequest2.getPlaceholder();
                                        target = imageRequest2.getTarget();
                                        if (target != null) {
                                            target.onStart(bitmapDrawable);
                                        }
                                        eventListener2.onStart(imageRequest2);
                                        listener = imageRequest2.getListener();
                                        if (listener != null) {
                                            listener.onStart(imageRequest2);
                                        }
                                        eventListener2.resolveSizeStart(imageRequest2);
                                        SizeResolver sizeResolver = imageRequest2.getSizeResolver();
                                        realImageLoader$executeMain$1.L$0 = realImageLoader2;
                                        realImageLoader$executeMain$1.L$1 = requestDelegate;
                                        realImageLoader$executeMain$1.L$2 = imageRequest2;
                                        realImageLoader$executeMain$1.L$3 = eventListener2;
                                        realImageLoader$executeMain$1.L$4 = bitmap;
                                        realImageLoader$executeMain$1.label = 2;
                                        size = sizeResolver.size(realImageLoader$executeMain$1);
                                        if (size != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        bitmap2 = bitmap;
                                        realImageLoader3 = realImageLoader2;
                                        ImageRequest imageRequest4 = imageRequest2;
                                        requestDelegate4 = requestDelegate;
                                        obj = size;
                                        imageRequest3 = imageRequest4;
                                        Size size2 = (Size) obj;
                                        eventListener2.resolveSizeEnd(imageRequest3, size2);
                                        CoroutineDispatcher interceptorDispatcher = imageRequest3.getInterceptorDispatcher();
                                        RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size2, eventListener2, bitmap2, null);
                                        realImageLoader$executeMain$1.L$0 = realImageLoader3;
                                        realImageLoader$executeMain$1.L$1 = requestDelegate4;
                                        realImageLoader$executeMain$1.L$2 = imageRequest3;
                                        realImageLoader$executeMain$1.L$3 = eventListener2;
                                        realImageLoader$executeMain$1.L$4 = null;
                                        realImageLoader$executeMain$1.label = 3;
                                        withContext = BuildersKt.withContext(interceptorDispatcher, realImageLoader$executeMain$result$1, realImageLoader$executeMain$1);
                                        if (withContext != coroutine_suspended) {
                                        }
                                    }
                                }
                                bitmap = null;
                                if (bitmap == null) {
                                }
                                target = imageRequest2.getTarget();
                                if (target != null) {
                                }
                                eventListener2.onStart(imageRequest2);
                                listener = imageRequest2.getListener();
                                if (listener != null) {
                                }
                                eventListener2.resolveSizeStart(imageRequest2);
                                SizeResolver sizeResolver2 = imageRequest2.getSizeResolver();
                                realImageLoader$executeMain$1.L$0 = realImageLoader2;
                                realImageLoader$executeMain$1.L$1 = requestDelegate;
                                realImageLoader$executeMain$1.L$2 = imageRequest2;
                                realImageLoader$executeMain$1.L$3 = eventListener2;
                                realImageLoader$executeMain$1.L$4 = bitmap;
                                realImageLoader$executeMain$1.label = 2;
                                size = sizeResolver2.size(realImageLoader$executeMain$1);
                                if (size != coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            realImageLoader = this;
                            requestDelegate2 = requestDelegate;
                            eventListener = create;
                            if (th instanceof CancellationException) {
                            }
                        }
                    } else if (i6 == 1) {
                        eventListener2 = (EventListener) realImageLoader$executeMain$1.L$3;
                        imageRequest2 = (ImageRequest) realImageLoader$executeMain$1.L$2;
                        requestDelegate3 = (RequestDelegate) realImageLoader$executeMain$1.L$1;
                        realImageLoader2 = (RealImageLoader) realImageLoader$executeMain$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                        } catch (Throwable th2) {
                            th = th2;
                            eventListener = eventListener2;
                            build = imageRequest2;
                            requestDelegate2 = requestDelegate3;
                            realImageLoader = realImageLoader2;
                            if (th instanceof CancellationException) {
                                realImageLoader.onCancel(build, eventListener);
                                throw th;
                            }
                            ErrorResult errorResult = realImageLoader.requestService.errorResult(build, th);
                            realImageLoader.onError(errorResult, build.getTarget(), eventListener);
                            return errorResult;
                        }
                    } else if (i6 == 2) {
                        Bitmap bitmap3 = (Bitmap) realImageLoader$executeMain$1.L$4;
                        eventListener2 = (EventListener) realImageLoader$executeMain$1.L$3;
                        imageRequest3 = (ImageRequest) realImageLoader$executeMain$1.L$2;
                        requestDelegate4 = (RequestDelegate) realImageLoader$executeMain$1.L$1;
                        realImageLoader3 = (RealImageLoader) realImageLoader$executeMain$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            bitmap2 = bitmap3;
                            obj = obj3;
                            Size size22 = (Size) obj;
                            eventListener2.resolveSizeEnd(imageRequest3, size22);
                            CoroutineDispatcher interceptorDispatcher2 = imageRequest3.getInterceptorDispatcher();
                            RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$12 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size22, eventListener2, bitmap2, null);
                            realImageLoader$executeMain$1.L$0 = realImageLoader3;
                            realImageLoader$executeMain$1.L$1 = requestDelegate4;
                            realImageLoader$executeMain$1.L$2 = imageRequest3;
                            realImageLoader$executeMain$1.L$3 = eventListener2;
                            realImageLoader$executeMain$1.L$4 = null;
                            realImageLoader$executeMain$1.label = 3;
                            withContext = BuildersKt.withContext(interceptorDispatcher2, realImageLoader$executeMain$result$12, realImageLoader$executeMain$1);
                            if (withContext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            eventListener = eventListener2;
                            build = imageRequest3;
                            requestDelegate2 = requestDelegate4;
                            realImageLoader = realImageLoader3;
                            obj2 = withContext;
                            imageResult = (ImageResult) obj2;
                            if (!(imageResult instanceof SuccessResult)) {
                            }
                            return imageResult;
                        } catch (Throwable th3) {
                            th = th3;
                            eventListener = eventListener2;
                            build = imageRequest3;
                            requestDelegate2 = requestDelegate4;
                            realImageLoader = realImageLoader3;
                            if (th instanceof CancellationException) {
                            }
                        }
                    } else {
                        if (i6 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        eventListener = (EventListener) realImageLoader$executeMain$1.L$3;
                        build = (ImageRequest) realImageLoader$executeMain$1.L$2;
                        requestDelegate2 = (RequestDelegate) realImageLoader$executeMain$1.L$1;
                        realImageLoader = (RealImageLoader) realImageLoader$executeMain$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            obj2 = obj3;
                            imageResult = (ImageResult) obj2;
                            if (!(imageResult instanceof SuccessResult)) {
                                realImageLoader.onSuccess((SuccessResult) imageResult, build.getTarget(), eventListener);
                            } else if (imageResult instanceof ErrorResult) {
                                realImageLoader.onError((ErrorResult) imageResult, build.getTarget(), eventListener);
                            }
                            return imageResult;
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                if (th instanceof CancellationException) {
                                }
                            } finally {
                                requestDelegate2.complete();
                            }
                        }
                    }
                    requestDelegate = requestDelegate3;
                    memoryCache = realImageLoader2.getMemoryCache();
                    if (memoryCache != null) {
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    target = imageRequest2.getTarget();
                    if (target != null) {
                    }
                    eventListener2.onStart(imageRequest2);
                    listener = imageRequest2.getListener();
                    if (listener != null) {
                    }
                    eventListener2.resolveSizeStart(imageRequest2);
                    SizeResolver sizeResolver22 = imageRequest2.getSizeResolver();
                    realImageLoader$executeMain$1.L$0 = realImageLoader2;
                    realImageLoader$executeMain$1.L$1 = requestDelegate;
                    realImageLoader$executeMain$1.L$2 = imageRequest2;
                    realImageLoader$executeMain$1.L$3 = eventListener2;
                    realImageLoader$executeMain$1.L$4 = bitmap;
                    realImageLoader$executeMain$1.label = 2;
                    size = sizeResolver22.size(realImageLoader$executeMain$1);
                    if (size != coroutine_suspended) {
                    }
                }
            }
            memoryCache = realImageLoader2.getMemoryCache();
            if (memoryCache != null) {
            }
            bitmap = null;
            if (bitmap == null) {
            }
            target = imageRequest2.getTarget();
            if (target != null) {
            }
            eventListener2.onStart(imageRequest2);
            listener = imageRequest2.getListener();
            if (listener != null) {
            }
            eventListener2.resolveSizeStart(imageRequest2);
            SizeResolver sizeResolver222 = imageRequest2.getSizeResolver();
            realImageLoader$executeMain$1.L$0 = realImageLoader2;
            realImageLoader$executeMain$1.L$1 = requestDelegate;
            realImageLoader$executeMain$1.L$2 = imageRequest2;
            realImageLoader$executeMain$1.L$3 = eventListener2;
            realImageLoader$executeMain$1.L$4 = bitmap;
            realImageLoader$executeMain$1.label = 2;
            size = sizeResolver222.size(realImageLoader$executeMain$1);
            if (size != coroutine_suspended) {
            }
        } catch (Throwable th5) {
            th = th5;
            requestDelegate2 = requestDelegate;
            eventListener = eventListener2;
            build = imageRequest2;
            realImageLoader = realImageLoader2;
            if (th instanceof CancellationException) {
            }
        }
        realImageLoader$executeMain$1 = new RealImageLoader$executeMain$1(this, continuation);
        Object obj32 = realImageLoader$executeMain$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = realImageLoader$executeMain$1.label;
        if (i6 != 0) {
        }
        requestDelegate = requestDelegate3;
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "🏗  Cancelled - " + request.getData(), null);
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onError(ErrorResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "🚨 Failed - " + request.getData() + " - " + result.getThrowable(), null);
        }
        if (target instanceof TransitionTarget) {
            Transition create = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(result.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(result.getRequest(), create);
            }
            target.onError(result.getDrawable());
        }
        eventListener.onError(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, result);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0045, code lost:
    
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onSuccess(SuccessResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        DataSource dataSource = result.getDataSource();
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, Utils.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
        }
        if (target instanceof TransitionTarget) {
            Transition create = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(result.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(result.getRequest(), create);
            }
            target.onSuccess(result.getDrawable());
        }
        eventListener.onSuccess(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, result);
        }
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        request.getTarget();
        return new OneShotDisposable(async$default);
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, null), continuation);
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    public final void onTrimMemory$coil_base_release(int level) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }
}
