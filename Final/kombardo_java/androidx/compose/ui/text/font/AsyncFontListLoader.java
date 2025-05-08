package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0002*\u00020\u0004H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR+\u0010$\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroidx/compose/ui/text/font/Font;", "fontList", "initialType", "Landroidx/compose/ui/text/font/TypefaceRequest;", "typefaceRequest", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "asyncTypefaceCache", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", BuildConfig.FLAVOR, "onCompletion", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformFontLoader", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "Ljava/util/List;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value", BuildConfig.FLAVOR, "cacheable", "Z", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncFontListLoader implements State<Object> {
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader) {
        MutableState mutableStateOf$default;
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value = mutableStateOf$default;
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        this.value.setValue(obj);
    }

    /* renamed from: getCacheable$ui_text_release, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be A[Catch: all -> 0x00f2, TRY_LEAVE, TryCatch #0 {all -> 0x00f2, blocks: (B:20:0x0075, B:22:0x008c, B:27:0x00be, B:31:0x00f5), top: B:19:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5 A[Catch: all -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f2, blocks: (B:20:0x0075, B:22:0x008c, B:27:0x00be, B:31:0x00f5), top: B:19:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0108 -> B:13:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x010d -> B:14:0x010f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        AsyncFontListLoader$load$1 asyncFontListLoader$load$1;
        int i5;
        AsyncFontListLoader asyncFontListLoader;
        List<Font> list;
        int size;
        AsyncFontListLoader asyncFontListLoader2;
        int i6;
        Font font;
        List<Font> list2;
        int i7;
        if (continuation instanceof AsyncFontListLoader$load$1) {
            asyncFontListLoader$load$1 = (AsyncFontListLoader$load$1) continuation;
            int i8 = asyncFontListLoader$load$1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$load$1.label = i8 - Integer.MIN_VALUE;
                Object obj = asyncFontListLoader$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = asyncFontListLoader$load$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        list = this.fontList;
                        size = list.size();
                        asyncFontListLoader2 = this;
                        i6 = 0;
                        if (i6 >= size) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        asyncFontListLoader = this;
                    }
                } else if (i5 == 1) {
                    size = asyncFontListLoader$load$1.I$1;
                    i7 = asyncFontListLoader$load$1.I$0;
                    Font font2 = (Font) asyncFontListLoader$load$1.L$2;
                    List<Font> list3 = (List) asyncFontListLoader$load$1.L$1;
                    AsyncFontListLoader asyncFontListLoader3 = (AsyncFontListLoader) asyncFontListLoader$load$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        asyncFontListLoader2 = asyncFontListLoader3;
                        font = font2;
                        list2 = list3;
                        if (obj == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        asyncFontListLoader = asyncFontListLoader3;
                    }
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    size = asyncFontListLoader$load$1.I$1;
                    i7 = asyncFontListLoader$load$1.I$0;
                    list2 = (List) asyncFontListLoader$load$1.L$1;
                    asyncFontListLoader = (AsyncFontListLoader) asyncFontListLoader$load$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i6 = i7;
                        list = list2;
                        asyncFontListLoader2 = asyncFontListLoader;
                        i6++;
                        if (i6 >= size) {
                            try {
                                Font font3 = list.get(i6);
                                if (FontLoadingStrategy.m2329equalsimpl0(font3.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m2332getAsyncPKNRLFQ())) {
                                    AsyncTypefaceCache asyncTypefaceCache = asyncFontListLoader2.asyncTypefaceCache;
                                    PlatformFontLoader platformFontLoader = asyncFontListLoader2.platformFontLoader;
                                    AsyncFontListLoader$load$2$typeface$1 asyncFontListLoader$load$2$typeface$1 = new AsyncFontListLoader$load$2$typeface$1(asyncFontListLoader2, font3, null);
                                    asyncFontListLoader$load$1.L$0 = asyncFontListLoader2;
                                    asyncFontListLoader$load$1.L$1 = list;
                                    asyncFontListLoader$load$1.L$2 = font3;
                                    asyncFontListLoader$load$1.I$0 = i6;
                                    asyncFontListLoader$load$1.I$1 = size;
                                    asyncFontListLoader$load$1.label = 1;
                                    int i9 = i6;
                                    Object runCached = asyncTypefaceCache.runCached(font3, platformFontLoader, false, asyncFontListLoader$load$2$typeface$1, asyncFontListLoader$load$1);
                                    if (runCached == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    list2 = list;
                                    obj = runCached;
                                    font = font3;
                                    i7 = i9;
                                    if (obj == null) {
                                        asyncFontListLoader2.setValue(FontSynthesis_androidKt.m2358synthesizeTypefaceFxwP2eA(asyncFontListLoader2.typefaceRequest.getFontSynthesis(), obj, font, asyncFontListLoader2.typefaceRequest.getFontWeight(), asyncFontListLoader2.typefaceRequest.getFontStyle()));
                                        Unit unit = Unit.INSTANCE;
                                        boolean isActive = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                                        asyncFontListLoader2.cacheable = false;
                                        asyncFontListLoader2.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader2.getValue(), isActive));
                                        return unit;
                                    }
                                    asyncFontListLoader$load$1.L$0 = asyncFontListLoader2;
                                    asyncFontListLoader$load$1.L$1 = list2;
                                    asyncFontListLoader$load$1.L$2 = null;
                                    asyncFontListLoader$load$1.I$0 = i7;
                                    asyncFontListLoader$load$1.I$1 = size;
                                    asyncFontListLoader$load$1.label = 2;
                                    if (YieldKt.yield(asyncFontListLoader$load$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    asyncFontListLoader = asyncFontListLoader2;
                                    i6 = i7;
                                    list = list2;
                                    asyncFontListLoader2 = asyncFontListLoader;
                                    i6++;
                                    if (i6 >= size) {
                                        boolean isActive2 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                                        asyncFontListLoader2.cacheable = false;
                                        asyncFontListLoader2.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader2.getValue(), isActive2));
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    i6++;
                                    if (i6 >= size) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                asyncFontListLoader = asyncFontListLoader2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                boolean isActive3 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                asyncFontListLoader.cacheable = false;
                asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive3));
                throw th;
            }
        }
        asyncFontListLoader$load$1 = new AsyncFontListLoader$load$1(this, continuation);
        Object obj2 = asyncFontListLoader$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = asyncFontListLoader$load$1.label;
        if (i5 != 0) {
        }
        boolean isActive32 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
        asyncFontListLoader.cacheable = false;
        asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive32));
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text_release(Font font, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        int i5;
        Object obj;
        try {
            if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
                int i6 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    asyncFontListLoader$loadWithTimeoutOrNull$1.label = i6 - Integer.MIN_VALUE;
                    Object obj2 = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
                    obj = null;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, font, null);
                        asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = font;
                        asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
                        obj2 = TimeoutKt.withTimeoutOrNull(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        font = (Font) asyncFontListLoader$loadWithTimeoutOrNull$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    obj = obj2;
                    return obj;
                }
            }
            if (i5 != 0) {
            }
            obj = obj2;
            return obj;
        } catch (CancellationException e5) {
            if (JobKt.isActive(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext())) {
                return obj;
            }
            throw e5;
        } catch (Exception e6) {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) asyncFontListLoader$loadWithTimeoutOrNull$1.getContext().get(CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler == null) {
                return obj;
            }
            coroutineExceptionHandler.handleException(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext(), new IllegalStateException("Unable to load font " + font, e6));
            return obj;
        }
        asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
        Object obj22 = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
        obj = null;
    }
}
