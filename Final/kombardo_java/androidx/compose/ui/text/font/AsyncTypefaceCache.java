package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u001e\u0010\u0014\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/font/Font;", "font", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformFontLoader", "result", BuildConfig.FLAVOR, "forever", BuildConfig.FLAVOR, "put", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;Ljava/lang/Object;Z)V", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "get-1ASDuI8", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;)Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "get", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "runCached", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PermanentFailure", "Ljava/lang/Object;", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/caches/SimpleArrayMap;", "permanentCache", "Landroidx/compose/ui/text/caches/SimpleArrayMap;", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "AsyncTypefaceResult", "Key", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncTypefaceCache {
    private final Object PermanentFailure = AsyncTypefaceResult.m2316constructorimpl(null);
    private final LruCache<Key, AsyncTypefaceResult> resultCache = new LruCache<>(16);
    private final SimpleArrayMap<Key, AsyncTypefaceResult> permanentCache = new SimpleArrayMap<>(0, 1, null);
    private final SynchronizedObject cacheLock = Synchronization_jvmKt.createSynchronizedObject();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0002\u0092\u0001\u0004\u0018\u00010\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", BuildConfig.FLAVOR, "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "isPermanentFailure", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AsyncTypefaceResult {
        private final Object result;

        private /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.result = obj;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m2315boximpl(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static Object m2316constructorimpl(Object obj) {
            return obj;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m2317equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceResult) obj2).getResult());
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2318hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* renamed from: isPermanentFailure-impl, reason: not valid java name */
        public static final boolean m2319isPermanentFailureimpl(Object obj) {
            return obj == null;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2320toStringimpl(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return m2317equalsimpl(this.result, obj);
        }

        public int hashCode() {
            return m2318hashCodeimpl(this.result);
        }

        public String toString() {
            return m2320toStringimpl(this.result);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ Object getResult() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/font/Font;", "font", "loaderKey", "<init>", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/text/font/Font;", "getFont", "()Landroidx/compose/ui/text/font/Font;", "Ljava/lang/Object;", "getLoaderKey", "()Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class Key {
        private final Font font;
        private final Object loaderKey;

        public Key(Font font, Object obj) {
            this.font = font;
            this.loaderKey = obj;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return Intrinsics.areEqual(this.font, key.font) && Intrinsics.areEqual(this.loaderKey, key.loaderKey);
        }

        public int hashCode() {
            int hashCode = this.font.hashCode() * 31;
            Object obj = this.loaderKey;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z5, int i5, Object obj2) {
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        asyncTypefaceCache.put(font, platformFontLoader, obj, z5);
    }

    /* renamed from: get-1ASDuI8, reason: not valid java name */
    public final AsyncTypefaceResult m2314get1ASDuI8(Font font, PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            asyncTypefaceResult = this.resultCache.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = this.permanentCache.get(key);
            }
        }
        return asyncTypefaceResult;
    }

    public final void put(Font font, PlatformFontLoader platformFontLoader, Object result, boolean forever) {
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            try {
                if (result == null) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m2315boximpl(this.PermanentFailure));
                } else if (forever) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m2315boximpl(AsyncTypefaceResult.m2316constructorimpl(result)));
                } else {
                    this.resultCache.put(key, AsyncTypefaceResult.m2315boximpl(AsyncTypefaceResult.m2316constructorimpl(result)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runCached(Font font, PlatformFontLoader platformFontLoader, boolean z5, Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<Object> continuation) {
        AsyncTypefaceCache$runCached$1 asyncTypefaceCache$runCached$1;
        int i5;
        AsyncTypefaceCache asyncTypefaceCache;
        Key key;
        if (continuation instanceof AsyncTypefaceCache$runCached$1) {
            asyncTypefaceCache$runCached$1 = (AsyncTypefaceCache$runCached$1) continuation;
            int i6 = asyncTypefaceCache$runCached$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                asyncTypefaceCache$runCached$1.label = i6 - Integer.MIN_VALUE;
                Object obj = asyncTypefaceCache$runCached$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = asyncTypefaceCache$runCached$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Key key2 = new Key(font, platformFontLoader.getCacheKey());
                    synchronized (this.cacheLock) {
                        try {
                            AsyncTypefaceResult asyncTypefaceResult = this.resultCache.get(key2);
                            if (asyncTypefaceResult == null) {
                                asyncTypefaceResult = this.permanentCache.get(key2);
                            }
                            if (asyncTypefaceResult != null) {
                                return asyncTypefaceResult.getResult();
                            }
                            Unit unit = Unit.INSTANCE;
                            asyncTypefaceCache$runCached$1.L$0 = this;
                            asyncTypefaceCache$runCached$1.L$1 = key2;
                            asyncTypefaceCache$runCached$1.Z$0 = z5;
                            asyncTypefaceCache$runCached$1.label = 1;
                            Object invoke = function1.invoke(asyncTypefaceCache$runCached$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            asyncTypefaceCache = this;
                            obj = invoke;
                            key = key2;
                        } finally {
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z5 = asyncTypefaceCache$runCached$1.Z$0;
                    key = (Key) asyncTypefaceCache$runCached$1.L$1;
                    asyncTypefaceCache = (AsyncTypefaceCache) asyncTypefaceCache$runCached$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        if (obj == null) {
                            asyncTypefaceCache.permanentCache.put(key, AsyncTypefaceResult.m2315boximpl(asyncTypefaceCache.PermanentFailure));
                        } else if (z5) {
                            asyncTypefaceCache.permanentCache.put(key, AsyncTypefaceResult.m2315boximpl(AsyncTypefaceResult.m2316constructorimpl(obj)));
                        } else {
                            asyncTypefaceCache.resultCache.put(key, AsyncTypefaceResult.m2315boximpl(AsyncTypefaceResult.m2316constructorimpl(obj)));
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                    }
                }
                return obj;
            }
        }
        asyncTypefaceCache$runCached$1 = new AsyncTypefaceCache$runCached$1(this, continuation);
        Object obj2 = asyncTypefaceCache$runCached$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = asyncTypefaceCache$runCached$1.label;
        if (i5 != 0) {
        }
        synchronized (asyncTypefaceCache.cacheLock) {
        }
    }
}
