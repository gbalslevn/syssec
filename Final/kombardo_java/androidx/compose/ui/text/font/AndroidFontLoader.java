package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", BuildConfig.FLAVOR, "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super Typeface> continuation) {
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$1;
        int i5;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof AndroidFontLoader$awaitLoad$1) {
            androidFontLoader$awaitLoad$1 = (AndroidFontLoader$awaitLoad$1) continuation;
            int i6 = androidFontLoader$awaitLoad$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                androidFontLoader$awaitLoad$1.label = i6 - Integer.MIN_VALUE;
                Object obj = androidFontLoader$awaitLoad$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = androidFontLoader$awaitLoad$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(font instanceof ResourceFont)) {
                        throw new IllegalArgumentException("Unknown font type: " + font);
                    }
                    Context context = this.context;
                    androidFontLoader$awaitLoad$1.L$0 = this;
                    androidFontLoader$awaitLoad$1.L$1 = font;
                    androidFontLoader$awaitLoad$1.label = 2;
                    obj = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context, androidFontLoader$awaitLoad$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidFontLoader = this;
                } else {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    font = (Font) androidFontLoader$awaitLoad$1.L$1;
                    androidFontLoader = (AndroidFontLoader) androidFontLoader$awaitLoad$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) obj, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
            }
        }
        androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
        Object obj2 = androidFontLoader$awaitLoad$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidFontLoader$awaitLoad$1.label;
        if (i5 != 0) {
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) obj2, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object m3567constructorimpl;
        Typeface typeface;
        Typeface load;
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.INSTANCE;
        if (FontLoadingStrategy.m2329equalsimpl0(loadingStrategy, companion.m2333getBlockingPKNRLFQ())) {
            typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else {
            if (!FontLoadingStrategy.m2329equalsimpl0(loadingStrategy, companion.m2334getOptionalLocalPKNRLFQ())) {
                if (FontLoadingStrategy.m2329equalsimpl0(loadingStrategy, companion.m2332getAsyncPKNRLFQ())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m2331toStringimpl(font.getLoadingStrategy())));
            }
            try {
                Result.Companion companion2 = Result.INSTANCE;
                load = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
                m3567constructorimpl = Result.m3567constructorimpl(load);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
            }
            typeface = (Typeface) (Result.m3572isFailureimpl(m3567constructorimpl) ? null : m3567constructorimpl);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, ((ResourceFont) font).getVariationSettings(), this.context);
    }
}
