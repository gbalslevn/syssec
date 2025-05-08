package coil;

import android.content.Context;
import coil.EventListener;
import coil.ImageLoader;
import coil.content.ImageLoaderOptions;
import coil.content.Logger;
import coil.content.Requests;
import coil.content.SingletonDiskCache;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lcoil/ImageLoader;", BuildConfig.FLAVOR, "Lcoil/request/ImageRequest;", "request", "Lcoil/request/Disposable;", "enqueue", "(Lcoil/request/ImageRequest;)Lcoil/request/Disposable;", "Lcoil/request/ImageResult;", "execute", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "defaults", "Lcoil/ComponentRegistry;", "getComponents", "()Lcoil/ComponentRegistry;", "components", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "memoryCache", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ImageLoader {

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00002\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010%R \u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010%R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00102¨\u00063"}, d2 = {"Lcoil/ImageLoader$Builder;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcoil/ComponentRegistry;", "components", "(Lcoil/ComponentRegistry;)Lcoil/ImageLoader$Builder;", "Lkotlin/Function0;", "Lcoil/memory/MemoryCache;", "initializer", "memoryCache", "(Lkotlin/jvm/functions/Function0;)Lcoil/ImageLoader$Builder;", BuildConfig.FLAVOR, "enable", "crossfade", "(Z)Lcoil/ImageLoader$Builder;", BuildConfig.FLAVOR, "durationMillis", "(I)Lcoil/ImageLoader$Builder;", "Lcoil/transition/Transition$Factory;", "factory", "transitionFactory", "(Lcoil/transition/Transition$Factory;)Lcoil/ImageLoader$Builder;", "Lcoil/util/Logger;", "logger", "(Lcoil/util/Logger;)Lcoil/ImageLoader$Builder;", "Lcoil/ImageLoader;", "build", "()Lcoil/ImageLoader;", "applicationContext", "Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "Lcoil/disk/DiskCache;", "diskCache", "Lokhttp3/Call$Factory;", "callFactory", "Lcoil/EventListener$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "Lcoil/util/ImageLoaderOptions;", "options", "Lcoil/util/ImageLoaderOptions;", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Context applicationContext;
        private DefaultRequestOptions defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
        private Lazy<? extends MemoryCache> memoryCache = null;
        private Lazy<? extends DiskCache> diskCache = null;
        private Lazy<? extends Call.Factory> callFactory = null;
        private EventListener.Factory eventListenerFactory = null;
        private ComponentRegistry componentRegistry = null;
        private ImageLoaderOptions options = new ImageLoaderOptions(false, false, false, 0, null, 31, null);
        private Logger logger = null;

        public Builder(Context context) {
            this.applicationContext = context.getApplicationContext();
        }

        public final ImageLoader build() {
            Context context = this.applicationContext;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Lazy<? extends MemoryCache> lazy = this.memoryCache;
            if (lazy == null) {
                lazy = LazyKt.lazy(new Function0<MemoryCache>() { // from class: coil.ImageLoader$Builder$build$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MemoryCache invoke() {
                        Context context2;
                        context2 = ImageLoader.Builder.this.applicationContext;
                        return new MemoryCache.Builder(context2).build();
                    }
                });
            }
            Lazy<? extends MemoryCache> lazy2 = lazy;
            Lazy<? extends DiskCache> lazy3 = this.diskCache;
            if (lazy3 == null) {
                lazy3 = LazyKt.lazy(new Function0<DiskCache>() { // from class: coil.ImageLoader$Builder$build$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiskCache invoke() {
                        Context context2;
                        SingletonDiskCache singletonDiskCache = SingletonDiskCache.INSTANCE;
                        context2 = ImageLoader.Builder.this.applicationContext;
                        return singletonDiskCache.get(context2);
                    }
                });
            }
            Lazy<? extends DiskCache> lazy4 = lazy3;
            Lazy<? extends Call.Factory> lazy5 = this.callFactory;
            if (lazy5 == null) {
                lazy5 = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: coil.ImageLoader$Builder$build$3
                    @Override // kotlin.jvm.functions.Function0
                    public final OkHttpClient invoke() {
                        return new OkHttpClient();
                    }
                });
            }
            Lazy<? extends Call.Factory> lazy6 = lazy5;
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            EventListener.Factory factory2 = factory;
            ComponentRegistry componentRegistry = this.componentRegistry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, lazy2, lazy4, lazy6, factory2, componentRegistry, this.options, this.logger);
        }

        public final Builder components(ComponentRegistry components) {
            this.componentRegistry = components;
            return this;
        }

        public final Builder crossfade(boolean enable) {
            return crossfade(enable ? 100 : 0);
        }

        public final Builder logger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public final Builder memoryCache(Function0<? extends MemoryCache> initializer) {
            this.memoryCache = LazyKt.lazy(initializer);
            return this;
        }

        public final Builder transitionFactory(Transition.Factory factory) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, factory, null, null, false, false, null, null, null, null, null, null, 32751, null);
            return this;
        }

        public final Builder crossfade(int durationMillis) {
            Transition.Factory factory;
            if (durationMillis > 0) {
                factory = new CrossfadeTransition.Factory(durationMillis, false, 2, null);
            } else {
                factory = Transition.Factory.NONE;
            }
            transitionFactory(factory);
            return this;
        }
    }

    Disposable enqueue(ImageRequest request);

    Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation);

    ComponentRegistry getComponents();

    DefaultRequestOptions getDefaults();

    MemoryCache getMemoryCache();
}
