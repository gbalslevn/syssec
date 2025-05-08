package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.DrawableUtils;
import coil.content.Logger;
import coil.content.Utils;
import coil.decode.DataSource;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.FileImageSource;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.size.Scale;
import coil.size.Size;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 52\u00020\u0001:\u000256B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJC\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J3\u0010.\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0081@ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010/R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00100R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/request/RequestService;", "requestService", "Lcoil/util/Logger;", "logger", "<init>", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "Lcoil/request/ImageRequest;", "request", BuildConfig.FLAVOR, "mappedData", "Lcoil/request/Options;", "_options", "Lcoil/EventListener;", "eventListener", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "execute", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/ComponentRegistry;", "components", "options", "Lcoil/fetch/FetchResult;", "fetch", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/fetch/SourceResult;", "fetchResult", "decode", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "drawable", BuildConfig.FLAVOR, "transformations", "Landroid/graphics/Bitmap;", "convertDrawableToBitmap", "(Landroid/graphics/drawable/Drawable;Lcoil/request/Options;Ljava/util/List;)Landroid/graphics/Bitmap;", "Lcoil/intercept/Interceptor$Chain;", "chain", "Lcoil/request/ImageResult;", "intercept", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "Lcoil/ImageLoader;", "Lcoil/request/RequestService;", "Lcoil/util/Logger;", "Lcoil/memory/MemoryCacheService;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", BuildConfig.FLAVOR, "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", BuildConfig.FLAVOR, "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", BuildConfig.FLAVOR, "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z5, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z5;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z5, DataSource dataSource, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i5 & 2) != 0) {
                z5 = executeResult.isSampled;
            }
            if ((i5 & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i5 & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z5, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<Object> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + '.', null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ac -> B:10:0x00b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceResult sourceResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$decode$1 engineInterceptor$decode$1;
        EngineInterceptor engineInterceptor;
        int i5;
        ImageRequest imageRequest2;
        Object obj2;
        Options options2;
        EventListener eventListener2;
        int i6;
        EngineInterceptor$decode$1 engineInterceptor$decode$12;
        EngineInterceptor engineInterceptor2;
        SourceResult sourceResult2;
        ComponentRegistry componentRegistry2;
        Pair<Decoder, Integer> newDecoder;
        if (continuation instanceof EngineInterceptor$decode$1) {
            engineInterceptor$decode$1 = (EngineInterceptor$decode$1) continuation;
            int i7 = engineInterceptor$decode$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                engineInterceptor$decode$1.label = i7 - Integer.MIN_VALUE;
                engineInterceptor = this;
                Object obj3 = engineInterceptor$decode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = engineInterceptor$decode$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    imageRequest2 = imageRequest;
                    obj2 = obj;
                    options2 = options;
                    eventListener2 = eventListener;
                    i6 = 0;
                    engineInterceptor$decode$12 = engineInterceptor$decode$1;
                    engineInterceptor2 = engineInterceptor;
                    sourceResult2 = sourceResult;
                    componentRegistry2 = componentRegistry;
                    newDecoder = componentRegistry2.newDecoder(sourceResult2, options2, engineInterceptor2.imageLoader, i6);
                    if (newDecoder != null) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i8 = engineInterceptor$decode$1.I$0;
                    Decoder decoder = (Decoder) engineInterceptor$decode$1.L$7;
                    EventListener eventListener3 = (EventListener) engineInterceptor$decode$1.L$6;
                    Options options3 = (Options) engineInterceptor$decode$1.L$5;
                    Object obj4 = engineInterceptor$decode$1.L$4;
                    ImageRequest imageRequest3 = (ImageRequest) engineInterceptor$decode$1.L$3;
                    ComponentRegistry componentRegistry3 = (ComponentRegistry) engineInterceptor$decode$1.L$2;
                    SourceResult sourceResult3 = (SourceResult) engineInterceptor$decode$1.L$1;
                    engineInterceptor2 = (EngineInterceptor) engineInterceptor$decode$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    EngineInterceptor$decode$1 engineInterceptor$decode$13 = engineInterceptor$decode$1;
                    componentRegistry2 = componentRegistry3;
                    int i9 = i8;
                    imageRequest2 = imageRequest3;
                    eventListener2 = eventListener3;
                    options2 = options3;
                    DecodeResult decodeResult = (DecodeResult) obj3;
                    eventListener2.decodeEnd(imageRequest2, decoder, options2, decodeResult);
                    if (decodeResult == null) {
                        Drawable drawable = decodeResult.getDrawable();
                        boolean isSampled = decodeResult.getIsSampled();
                        DataSource dataSource = sourceResult3.getDataSource();
                        ImageSource source = sourceResult3.getSource();
                        FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                        return new ExecuteResult(drawable, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey() : null);
                    }
                    obj2 = obj4;
                    i6 = i9;
                    engineInterceptor$decode$12 = engineInterceptor$decode$13;
                    sourceResult2 = sourceResult3;
                    newDecoder = componentRegistry2.newDecoder(sourceResult2, options2, engineInterceptor2.imageLoader, i6);
                    if (newDecoder != null) {
                        throw new IllegalStateException(("Unable to create a decoder that supports: " + obj2).toString());
                    }
                    Decoder first = newDecoder.getFirst();
                    int intValue = newDecoder.getSecond().intValue() + 1;
                    eventListener2.decodeStart(imageRequest2, first, options2);
                    engineInterceptor$decode$12.L$0 = engineInterceptor2;
                    engineInterceptor$decode$12.L$1 = sourceResult2;
                    engineInterceptor$decode$12.L$2 = componentRegistry2;
                    engineInterceptor$decode$12.L$3 = imageRequest2;
                    engineInterceptor$decode$12.L$4 = obj2;
                    engineInterceptor$decode$12.L$5 = options2;
                    engineInterceptor$decode$12.L$6 = eventListener2;
                    engineInterceptor$decode$12.L$7 = first;
                    engineInterceptor$decode$12.I$0 = intValue;
                    engineInterceptor$decode$12.label = 1;
                    Object decode = first.decode(engineInterceptor$decode$12);
                    if (decode == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sourceResult3 = sourceResult2;
                    obj3 = decode;
                    obj4 = obj2;
                    decoder = first;
                    engineInterceptor$decode$13 = engineInterceptor$decode$12;
                    i9 = intValue;
                    DecodeResult decodeResult2 = (DecodeResult) obj3;
                    eventListener2.decodeEnd(imageRequest2, decoder, options2, decodeResult2);
                    if (decodeResult2 == null) {
                    }
                }
            }
        }
        engineInterceptor = this;
        engineInterceptor$decode$1 = new EngineInterceptor$decode$1(engineInterceptor, continuation);
        Object obj32 = engineInterceptor$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = engineInterceptor$decode$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0162 A[Catch: all -> 0x00e1, TRY_LEAVE, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x0157, B:56:0x0162, B:60:0x01a2, B:62:0x01a6, B:64:0x0212, B:65:0x0217, B:71:0x00a6, B:73:0x00b2, B:74:0x00e5, B:76:0x00eb, B:78:0x011a, B:82:0x00f1, B:84:0x0100, B:85:0x0107, B:87:0x010d, B:88:0x0114), top: B:70:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a2 A[Catch: all -> 0x00e1, TRY_ENTER, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x0157, B:56:0x0162, B:60:0x01a2, B:62:0x01a6, B:64:0x0212, B:65:0x0217, B:71:0x00a6, B:73:0x00b2, B:74:0x00e5, B:76:0x00eb, B:78:0x011a, B:82:0x00f1, B:84:0x0100, B:85:0x0107, B:87:0x010d, B:88:0x0114), top: B:70:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, coil.ComponentRegistry] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$execute$1 engineInterceptor$execute$1;
        int i5;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Object obj2;
        EventListener eventListener2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$ObjectRef ref$ObjectRef5;
        ImageRequest imageRequest2;
        EngineInterceptor engineInterceptor;
        ?? copy;
        T t5;
        FetchResult fetchResult;
        Ref$ObjectRef ref$ObjectRef6;
        ImageRequest imageRequest3;
        ExecuteResult executeResult;
        EngineInterceptor engineInterceptor2;
        EventListener eventListener3;
        ImageRequest imageRequest4;
        EngineInterceptor engineInterceptor3;
        SourceResult sourceResult;
        ImageSource source;
        SourceResult sourceResult2;
        Object transform$coil_base_release;
        ImageSource source2;
        Object obj3;
        Object obj4;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        if (continuation instanceof EngineInterceptor$execute$1) {
            engineInterceptor$execute$1 = (EngineInterceptor$execute$1) continuation;
            int i6 = engineInterceptor$execute$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                engineInterceptor$execute$1.label = i6 - Integer.MIN_VALUE;
                EngineInterceptor$execute$1 engineInterceptor$execute$12 = engineInterceptor$execute$1;
                Object obj5 = engineInterceptor$execute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = engineInterceptor$execute$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj5);
                    Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
                    ref$ObjectRef7.element = options;
                    Ref$ObjectRef ref$ObjectRef8 = new Ref$ObjectRef();
                    ref$ObjectRef8.element = this.imageLoader.getComponents();
                    ref$ObjectRef = new Ref$ObjectRef();
                    try {
                        if (!this.requestService.allowHardwareWorkerThread((Options) ref$ObjectRef7.element)) {
                            copy = r16.copy((r32 & 1) != 0 ? r16.context : null, (r32 & 2) != 0 ? r16.config : Bitmap.Config.ARGB_8888, (r32 & 4) != 0 ? r16.colorSpace : null, (r32 & 8) != 0 ? r16.size : null, (r32 & 16) != 0 ? r16.scale : null, (r32 & 32) != 0 ? r16.allowInexactSize : false, (r32 & 64) != 0 ? r16.allowRgb565 : false, (r32 & 128) != 0 ? r16.premultipliedAlpha : false, (r32 & 256) != 0 ? r16.diskCacheKey : null, (r32 & 512) != 0 ? r16.headers : null, (r32 & 1024) != 0 ? r16.tags : null, (r32 & 2048) != 0 ? r16.parameters : null, (r32 & 4096) != 0 ? r16.memoryCachePolicy : null, (r32 & 8192) != 0 ? r16.diskCachePolicy : null, (r32 & 16384) != 0 ? ((Options) ref$ObjectRef7.element).networkCachePolicy : null);
                            ref$ObjectRef7.element = copy;
                        }
                        if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                            ComponentRegistry.Builder newBuilder = ((ComponentRegistry) ref$ObjectRef8.element).newBuilder();
                            Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = imageRequest.getFetcherFactory();
                            if (fetcherFactory != null) {
                                newBuilder.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                            }
                            Decoder.Factory decoderFactory = imageRequest.getDecoderFactory();
                            if (decoderFactory != null) {
                                newBuilder.getDecoderFactories$coil_base_release().add(0, decoderFactory);
                            }
                            ref$ObjectRef8.element = newBuilder.build();
                        }
                        ComponentRegistry componentRegistry = (ComponentRegistry) ref$ObjectRef8.element;
                        Options options2 = (Options) ref$ObjectRef7.element;
                        engineInterceptor$execute$12.L$0 = this;
                        engineInterceptor$execute$12.L$1 = imageRequest;
                        engineInterceptor$execute$12.L$2 = obj;
                        engineInterceptor$execute$12.L$3 = eventListener;
                        engineInterceptor$execute$12.L$4 = ref$ObjectRef7;
                        engineInterceptor$execute$12.L$5 = ref$ObjectRef8;
                        engineInterceptor$execute$12.L$6 = ref$ObjectRef;
                        engineInterceptor$execute$12.L$7 = ref$ObjectRef;
                        engineInterceptor$execute$12.label = 1;
                        Object fetch = fetch(componentRegistry, imageRequest, obj, options2, eventListener, engineInterceptor$execute$12);
                        if (fetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        eventListener2 = eventListener;
                        ref$ObjectRef3 = ref$ObjectRef7;
                        ref$ObjectRef4 = ref$ObjectRef8;
                        ref$ObjectRef5 = ref$ObjectRef;
                        imageRequest2 = imageRequest;
                        engineInterceptor = this;
                        t5 = fetch;
                    } catch (Throwable th) {
                        th = th;
                        ref$ObjectRef2 = ref$ObjectRef;
                        T t6 = ref$ObjectRef2.element;
                        sourceResult = t6 instanceof SourceResult ? (SourceResult) t6 : null;
                        if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                            Utils.closeQuietly(source);
                        }
                        throw th;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj5);
                            obj4 = obj5;
                            ExecuteResult executeResult2 = (ExecuteResult) obj4;
                            Drawable drawable = executeResult2.getDrawable();
                            bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                                bitmap.prepareToDraw();
                            }
                            return executeResult2;
                        }
                        ref$ObjectRef2 = (Ref$ObjectRef) engineInterceptor$execute$12.L$4;
                        ref$ObjectRef3 = (Ref$ObjectRef) engineInterceptor$execute$12.L$3;
                        eventListener3 = (EventListener) engineInterceptor$execute$12.L$2;
                        imageRequest4 = (ImageRequest) engineInterceptor$execute$12.L$1;
                        engineInterceptor3 = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj5);
                            obj3 = obj5;
                            ref$ObjectRef = ref$ObjectRef2;
                            engineInterceptor2 = engineInterceptor3;
                            eventListener2 = eventListener3;
                            imageRequest3 = imageRequest4;
                            Ref$ObjectRef ref$ObjectRef9 = ref$ObjectRef3;
                            executeResult = (ExecuteResult) obj3;
                            ref$ObjectRef6 = ref$ObjectRef9;
                            T t7 = ref$ObjectRef.element;
                            sourceResult2 = t7 instanceof SourceResult ? (SourceResult) t7 : null;
                            if (sourceResult2 != null && (source2 = sourceResult2.getSource()) != null) {
                                Utils.closeQuietly(source2);
                            }
                            Options options3 = (Options) ref$ObjectRef6.element;
                            engineInterceptor$execute$12.L$0 = null;
                            engineInterceptor$execute$12.L$1 = null;
                            engineInterceptor$execute$12.L$2 = null;
                            engineInterceptor$execute$12.L$3 = null;
                            engineInterceptor$execute$12.L$4 = null;
                            engineInterceptor$execute$12.L$5 = null;
                            engineInterceptor$execute$12.L$6 = null;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 3;
                            transform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, imageRequest3, options3, eventListener2, engineInterceptor$execute$12);
                            obj4 = transform$coil_base_release;
                            if (transform$coil_base_release == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ExecuteResult executeResult22 = (ExecuteResult) obj4;
                            Drawable drawable2 = executeResult22.getDrawable();
                            if (drawable2 instanceof BitmapDrawable) {
                            }
                            if (bitmapDrawable != null) {
                                bitmap.prepareToDraw();
                            }
                            return executeResult22;
                        } catch (Throwable th2) {
                            th = th2;
                            T t62 = ref$ObjectRef2.element;
                            if (t62 instanceof SourceResult) {
                            }
                            if (sourceResult != null) {
                            }
                            throw th;
                        }
                    }
                    ref$ObjectRef5 = (Ref$ObjectRef) engineInterceptor$execute$12.L$7;
                    Ref$ObjectRef ref$ObjectRef10 = (Ref$ObjectRef) engineInterceptor$execute$12.L$6;
                    Ref$ObjectRef ref$ObjectRef11 = (Ref$ObjectRef) engineInterceptor$execute$12.L$5;
                    Ref$ObjectRef ref$ObjectRef12 = (Ref$ObjectRef) engineInterceptor$execute$12.L$4;
                    eventListener2 = (EventListener) engineInterceptor$execute$12.L$3;
                    Object obj6 = engineInterceptor$execute$12.L$2;
                    imageRequest2 = (ImageRequest) engineInterceptor$execute$12.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj5);
                        ref$ObjectRef = ref$ObjectRef10;
                        ref$ObjectRef4 = ref$ObjectRef11;
                        ref$ObjectRef3 = ref$ObjectRef12;
                        obj2 = obj6;
                        t5 = obj5;
                    } catch (Throwable th3) {
                        th = th3;
                        ref$ObjectRef2 = ref$ObjectRef10;
                        T t622 = ref$ObjectRef2.element;
                        if (t622 instanceof SourceResult) {
                        }
                        if (sourceResult != null) {
                            Utils.closeQuietly(source);
                        }
                        throw th;
                    }
                }
                ref$ObjectRef5.element = t5;
                T t8 = ref$ObjectRef.element;
                fetchResult = (FetchResult) t8;
                if (fetchResult instanceof SourceResult) {
                    if (!(fetchResult instanceof DrawableResult)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ExecuteResult executeResult3 = new ExecuteResult(((DrawableResult) t8).getDrawable(), ((DrawableResult) ref$ObjectRef.element).getIsSampled(), ((DrawableResult) ref$ObjectRef.element).getDataSource(), null);
                    ref$ObjectRef6 = ref$ObjectRef3;
                    imageRequest3 = imageRequest2;
                    executeResult = executeResult3;
                    engineInterceptor2 = engineInterceptor;
                    T t72 = ref$ObjectRef.element;
                    if (t72 instanceof SourceResult) {
                    }
                    if (sourceResult2 != null) {
                    }
                    Options options32 = (Options) ref$ObjectRef6.element;
                    engineInterceptor$execute$12.L$0 = null;
                    engineInterceptor$execute$12.L$1 = null;
                    engineInterceptor$execute$12.L$2 = null;
                    engineInterceptor$execute$12.L$3 = null;
                    engineInterceptor$execute$12.L$4 = null;
                    engineInterceptor$execute$12.L$5 = null;
                    engineInterceptor$execute$12.L$6 = null;
                    engineInterceptor$execute$12.L$7 = null;
                    engineInterceptor$execute$12.label = 3;
                    transform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, imageRequest3, options32, eventListener2, engineInterceptor$execute$12);
                    obj4 = transform$coil_base_release;
                    if (transform$coil_base_release == coroutine_suspended) {
                    }
                    ExecuteResult executeResult222 = (ExecuteResult) obj4;
                    Drawable drawable22 = executeResult222.getDrawable();
                    if (drawable22 instanceof BitmapDrawable) {
                    }
                    if (bitmapDrawable != null) {
                    }
                    return executeResult222;
                }
                CoroutineDispatcher decoderDispatcher = imageRequest2.getDecoderDispatcher();
                EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, ref$ObjectRef, ref$ObjectRef4, imageRequest2, obj2, ref$ObjectRef3, eventListener2, null);
                engineInterceptor$execute$12.L$0 = engineInterceptor;
                engineInterceptor$execute$12.L$1 = imageRequest2;
                engineInterceptor$execute$12.L$2 = eventListener2;
                engineInterceptor$execute$12.L$3 = ref$ObjectRef3;
                engineInterceptor$execute$12.L$4 = ref$ObjectRef;
                engineInterceptor$execute$12.L$5 = null;
                engineInterceptor$execute$12.L$6 = null;
                engineInterceptor$execute$12.L$7 = null;
                engineInterceptor$execute$12.label = 2;
                Object withContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, engineInterceptor$execute$12);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eventListener3 = eventListener2;
                imageRequest4 = imageRequest2;
                engineInterceptor3 = engineInterceptor;
                ref$ObjectRef2 = ref$ObjectRef;
                obj3 = withContext;
                ref$ObjectRef = ref$ObjectRef2;
                engineInterceptor2 = engineInterceptor3;
                eventListener2 = eventListener3;
                imageRequest3 = imageRequest4;
                Ref$ObjectRef ref$ObjectRef92 = ref$ObjectRef3;
                executeResult = (ExecuteResult) obj3;
                ref$ObjectRef6 = ref$ObjectRef92;
                T t722 = ref$ObjectRef.element;
                if (t722 instanceof SourceResult) {
                }
                if (sourceResult2 != null) {
                    Utils.closeQuietly(source2);
                }
                Options options322 = (Options) ref$ObjectRef6.element;
                engineInterceptor$execute$12.L$0 = null;
                engineInterceptor$execute$12.L$1 = null;
                engineInterceptor$execute$12.L$2 = null;
                engineInterceptor$execute$12.L$3 = null;
                engineInterceptor$execute$12.L$4 = null;
                engineInterceptor$execute$12.L$5 = null;
                engineInterceptor$execute$12.L$6 = null;
                engineInterceptor$execute$12.L$7 = null;
                engineInterceptor$execute$12.label = 3;
                transform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, imageRequest3, options322, eventListener2, engineInterceptor$execute$12);
                obj4 = transform$coil_base_release;
                if (transform$coil_base_release == coroutine_suspended) {
                }
                ExecuteResult executeResult2222 = (ExecuteResult) obj4;
                Drawable drawable222 = executeResult2222.getDrawable();
                if (drawable222 instanceof BitmapDrawable) {
                }
                if (bitmapDrawable != null) {
                }
                return executeResult2222;
            }
        }
        engineInterceptor$execute$1 = new EngineInterceptor$execute$1(this, continuation);
        EngineInterceptor$execute$1 engineInterceptor$execute$122 = engineInterceptor$execute$1;
        Object obj52 = engineInterceptor$execute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = engineInterceptor$execute$122.label;
        if (i5 != 0) {
        }
        ref$ObjectRef5.element = t5;
        T t82 = ref$ObjectRef.element;
        fetchResult = (FetchResult) t82;
        if (fetchResult instanceof SourceResult) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:10:0x0095). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        EngineInterceptor$fetch$1 engineInterceptor$fetch$1;
        int i5;
        int i6;
        EngineInterceptor engineInterceptor;
        Pair<Fetcher, Integer> newFetcher;
        ImageSource source;
        if (continuation instanceof EngineInterceptor$fetch$1) {
            engineInterceptor$fetch$1 = (EngineInterceptor$fetch$1) continuation;
            int i7 = engineInterceptor$fetch$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                engineInterceptor$fetch$1.label = i7 - Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = engineInterceptor$fetch$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i6 = 0;
                    engineInterceptor = this;
                    newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i6);
                    if (newFetcher != null) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i8 = engineInterceptor$fetch$1.I$0;
                    Fetcher fetcher = (Fetcher) engineInterceptor$fetch$1.L$6;
                    EventListener eventListener2 = (EventListener) engineInterceptor$fetch$1.L$5;
                    options = (Options) engineInterceptor$fetch$1.L$4;
                    Object obj3 = engineInterceptor$fetch$1.L$3;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$fetch$1.L$2;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$fetch$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$12 = engineInterceptor$fetch$1;
                    int i9 = i8;
                    componentRegistry = componentRegistry2;
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$13 = engineInterceptor$fetch$12;
                    Fetcher first = fetcher;
                    imageRequest = imageRequest2;
                    eventListener = eventListener2;
                    obj = obj3;
                    FetchResult fetchResult = (FetchResult) obj2;
                    try {
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult);
                        if (fetchResult == null) {
                            return fetchResult;
                        }
                        i6 = i9;
                        engineInterceptor$fetch$1 = engineInterceptor$fetch$13;
                        newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i6);
                        if (newFetcher != null) {
                            throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                        }
                        first = newFetcher.getFirst();
                        int intValue = newFetcher.getSecond().intValue() + 1;
                        eventListener.fetchStart(imageRequest, first, options);
                        engineInterceptor$fetch$1.L$0 = engineInterceptor;
                        engineInterceptor$fetch$1.L$1 = componentRegistry;
                        engineInterceptor$fetch$1.L$2 = imageRequest;
                        engineInterceptor$fetch$1.L$3 = obj;
                        engineInterceptor$fetch$1.L$4 = options;
                        engineInterceptor$fetch$1.L$5 = eventListener;
                        engineInterceptor$fetch$1.L$6 = first;
                        engineInterceptor$fetch$1.I$0 = intValue;
                        engineInterceptor$fetch$1.label = 1;
                        Object fetch = first.fetch(engineInterceptor$fetch$1);
                        if (fetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        EngineInterceptor$fetch$1 engineInterceptor$fetch$14 = engineInterceptor$fetch$1;
                        i9 = intValue;
                        obj2 = fetch;
                        engineInterceptor$fetch$13 = engineInterceptor$fetch$14;
                        FetchResult fetchResult2 = (FetchResult) obj2;
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult2);
                        if (fetchResult2 == null) {
                        }
                    } catch (Throwable th) {
                        SourceResult sourceResult = fetchResult2 instanceof SourceResult ? (SourceResult) fetchResult2 : null;
                        if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                            Utils.closeQuietly(source);
                        }
                        throw th;
                    }
                }
            }
        }
        engineInterceptor$fetch$1 = new EngineInterceptor$fetch$1(this, continuation);
        Object obj22 = engineInterceptor$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = engineInterceptor$fetch$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        EngineInterceptor$intercept$1 engineInterceptor$intercept$1;
        int i5;
        EngineInterceptor engineInterceptor;
        if (continuation instanceof EngineInterceptor$intercept$1) {
            engineInterceptor$intercept$1 = (EngineInterceptor$intercept$1) continuation;
            int i6 = engineInterceptor$intercept$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                engineInterceptor$intercept$1.label = i6 - Integer.MIN_VALUE;
                Object obj = engineInterceptor$intercept$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = engineInterceptor$intercept$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ImageRequest request = chain.getRequest();
                        Object data = request.getData();
                        Size size = chain.getSize();
                        EventListener eventListener = Utils.getEventListener(chain);
                        Options options = this.requestService.options(request, size);
                        Scale scale = options.getScale();
                        eventListener.mapStart(request, data);
                        Object map = this.imageLoader.getComponents().map(data, options);
                        eventListener.mapEnd(request, map);
                        MemoryCache.Key newCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                        MemoryCache.Value cacheValue = newCacheKey != null ? this.memoryCacheService.getCacheValue(request, newCacheKey, size, scale) : null;
                        if (cacheValue != null) {
                            return this.memoryCacheService.newResult(chain, request, newCacheKey, cacheValue);
                        }
                        CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
                        EngineInterceptor$intercept$2 engineInterceptor$intercept$2 = new EngineInterceptor$intercept$2(this, request, map, options, eventListener, newCacheKey, chain, null);
                        engineInterceptor$intercept$1.L$0 = this;
                        engineInterceptor$intercept$1.L$1 = chain;
                        engineInterceptor$intercept$1.label = 1;
                        obj = BuildersKt.withContext(fetcherDispatcher, engineInterceptor$intercept$2, engineInterceptor$intercept$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        th = th;
                        engineInterceptor = this;
                        if (th instanceof CancellationException) {
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    chain = (Interceptor.Chain) engineInterceptor$intercept$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$intercept$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        if (th instanceof CancellationException) {
                            return engineInterceptor.requestService.errorResult(chain.getRequest(), th);
                        }
                        throw th;
                    }
                }
                return obj;
            }
        }
        engineInterceptor$intercept$1 = new EngineInterceptor$intercept$1(this, continuation);
        Object obj2 = engineInterceptor$intercept$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = engineInterceptor$intercept$1.label;
        if (i5 != 0) {
        }
        return obj2;
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Object> transformations = imageRequest.getTransformations();
        if (transformations.isEmpty()) {
            return executeResult;
        }
        if ((executeResult.getDrawable() instanceof BitmapDrawable) || imageRequest.getAllowConversionToBitmap()) {
            return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
        }
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', null);
        }
        return executeResult;
    }
}
