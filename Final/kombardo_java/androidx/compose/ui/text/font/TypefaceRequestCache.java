package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/font/TypefaceRequest;", "typefaceRequest", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult;", BuildConfig.FLAVOR, "resolveTypeface", "Landroidx/compose/runtime/State;", "runCached", "(Landroidx/compose/ui/text/font/TypefaceRequest;Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "Landroidx/compose/ui/text/caches/LruCache;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypefaceRequestCache {
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    private final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    /* renamed from: getLock$ui_text_release, reason: from getter */
    public final SynchronizedObject getLock() {
        return this.lock;
    }

    public final State<Object> runCached(final TypefaceRequest typefaceRequest, Function1<? super Function1<? super TypefaceResult, Unit>, ? extends TypefaceResult> resolveTypeface) {
        synchronized (this.lock) {
            TypefaceResult typefaceResult = this.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
                this.resultCache.remove(typefaceRequest);
            }
            try {
                TypefaceResult invoke = resolveTypeface.invoke(new Function1<TypefaceResult, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult typefaceResult2) {
                        invoke2(typefaceResult2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceResult typefaceResult2) {
                        LruCache lruCache;
                        LruCache lruCache2;
                        SynchronizedObject lock = TypefaceRequestCache.this.getLock();
                        TypefaceRequestCache typefaceRequestCache = TypefaceRequestCache.this;
                        TypefaceRequest typefaceRequest2 = typefaceRequest;
                        synchronized (lock) {
                            try {
                                if (typefaceResult2.getCacheable()) {
                                    lruCache2 = typefaceRequestCache.resultCache;
                                    lruCache2.put(typefaceRequest2, typefaceResult2);
                                } else {
                                    lruCache = typefaceRequestCache.resultCache;
                                    lruCache.remove(typefaceRequest2);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                synchronized (this.lock) {
                    try {
                        if (this.resultCache.get(typefaceRequest) == null && invoke.getCacheable()) {
                            this.resultCache.put(typefaceRequest, invoke);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return invoke;
            } catch (Exception e5) {
                throw new IllegalStateException("Could not load font", e5);
            }
        }
    }
}
