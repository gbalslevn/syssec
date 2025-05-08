package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001ar\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022*\b\u0002\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aI\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a9\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010#\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&\u001a5\u0010'\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a1\u0010+\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,\u001a!\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u00101\u001a\u0017\u00102\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b2\u00103\u001a\u0013\u00104\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b4\u00103\"\u0014\u00105\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "spec", BuildConfig.FLAVOR, "imageAssetsFolder", "fontAssetsFolder", "fontFileExtension", "cacheKey", "Lkotlin/Function3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onRetry", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "rememberLottieComposition", "(Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieCompositionResult;", "Landroid/content/Context;", "context", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWarmingCache", "Lcom/airbnb/lottie/LottieTask;", "lottieTask", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Z)Lcom/airbnb/lottie/LottieTask;", "T", "await", "(Lcom/airbnb/lottie/LottieTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composition", BuildConfig.FLAVOR, "loadImagesFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/airbnb/lottie/LottieImageAsset;", "asset", "maybeLoadImageFromAsset", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieImageAsset;Ljava/lang/String;)V", "maybeDecodeBase64Image", "(Lcom/airbnb/lottie/LottieImageAsset;)V", "loadFontsFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/airbnb/lottie/model/Font;", "font", "maybeLoadTypefaceFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/model/Font;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/graphics/Typeface;", "typeface", "style", "typefaceForStyle", "(Landroid/graphics/Typeface;Ljava/lang/String;)Landroid/graphics/Typeface;", "ensureTrailingSlash", "(Ljava/lang/String;)Ljava/lang/String;", "ensureLeadingPeriod", "DefaultCacheKey", "Ljava/lang/String;", "lottie-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RememberLottieCompositionKt {
    private static final String DefaultCacheKey = "__LottieInternalDefaultCacheKey__";

    private static final <T> Object await(LottieTask<T> lottieTask, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        lottieTask.addListener(new LottieListener() { // from class: com.airbnb.lottie.compose.RememberLottieCompositionKt$await$2$1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(T t5) {
                if (cancellableContinuationImpl.isCompleted()) {
                    return;
                }
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(t5));
            }
        }).addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.compose.RememberLottieCompositionKt$await$2$2
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Throwable e5) {
                if (cancellableContinuationImpl.isCompleted()) {
                    return;
                }
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(e5, "e");
                cancellableContinuation.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(e5)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ensureLeadingPeriod(String str) {
        return (StringsKt.isBlank(str) || StringsKt.startsWith$default(str, ".", false, 2, (Object) null)) ? str : Intrinsics.stringPlus(".", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ensureTrailingSlash(String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return StringsKt.endsWith$default((CharSequence) str, '/', false, 2, (Object) null) ? str : Intrinsics.stringPlus(str, "/");
    }

    private static final Object loadFontsFromAssets(Context context, LottieComposition lottieComposition, String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext;
        return (!lottieComposition.getFonts().isEmpty() && (withContext = BuildersKt.withContext(Dispatchers.getIO(), new RememberLottieCompositionKt$loadFontsFromAssets$2(lottieComposition, context, str, str2, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? withContext : Unit.INSTANCE;
    }

    private static final Object loadImagesFromAssets(Context context, LottieComposition lottieComposition, String str, Continuation<? super Unit> continuation) {
        Object withContext;
        return (lottieComposition.hasImages() && (withContext = BuildersKt.withContext(Dispatchers.getIO(), new RememberLottieCompositionKt$loadImagesFromAssets$2(lottieComposition, context, str, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object lottieComposition(Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, Continuation<? super LottieComposition> continuation) {
        RememberLottieCompositionKt$lottieComposition$1 rememberLottieCompositionKt$lottieComposition$1;
        Object coroutine_suspended;
        int i5;
        LottieComposition lottieComposition;
        String str5;
        String str6;
        Context context2;
        LottieComposition lottieComposition2;
        if (continuation instanceof RememberLottieCompositionKt$lottieComposition$1) {
            rememberLottieCompositionKt$lottieComposition$1 = (RememberLottieCompositionKt$lottieComposition$1) continuation;
            int i6 = rememberLottieCompositionKt$lottieComposition$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                rememberLottieCompositionKt$lottieComposition$1.label = i6 - Integer.MIN_VALUE;
                Object obj = rememberLottieCompositionKt$lottieComposition$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = rememberLottieCompositionKt$lottieComposition$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    LottieTask<LottieComposition> lottieTask = lottieTask(context, lottieCompositionSpec, str4, false);
                    if (lottieTask == null) {
                        throw new IllegalArgumentException(("Unable to create parsing task for " + lottieCompositionSpec + '.').toString());
                    }
                    rememberLottieCompositionKt$lottieComposition$1.L$0 = context;
                    rememberLottieCompositionKt$lottieComposition$1.L$1 = str;
                    rememberLottieCompositionKt$lottieComposition$1.L$2 = str2;
                    rememberLottieCompositionKt$lottieComposition$1.L$3 = str3;
                    rememberLottieCompositionKt$lottieComposition$1.label = 1;
                    obj = await(lottieTask, rememberLottieCompositionKt$lottieComposition$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LottieComposition lottieComposition3 = (LottieComposition) rememberLottieCompositionKt$lottieComposition$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return lottieComposition3;
                        }
                        lottieComposition2 = (LottieComposition) rememberLottieCompositionKt$lottieComposition$1.L$3;
                        str6 = (String) rememberLottieCompositionKt$lottieComposition$1.L$2;
                        str5 = (String) rememberLottieCompositionKt$lottieComposition$1.L$1;
                        context2 = (Context) rememberLottieCompositionKt$lottieComposition$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        rememberLottieCompositionKt$lottieComposition$1.L$0 = lottieComposition2;
                        rememberLottieCompositionKt$lottieComposition$1.L$1 = null;
                        rememberLottieCompositionKt$lottieComposition$1.L$2 = null;
                        rememberLottieCompositionKt$lottieComposition$1.L$3 = null;
                        rememberLottieCompositionKt$lottieComposition$1.label = 3;
                        return loadFontsFromAssets(context2, lottieComposition2, str5, str6, rememberLottieCompositionKt$lottieComposition$1) != coroutine_suspended ? coroutine_suspended : lottieComposition2;
                    }
                    str3 = (String) rememberLottieCompositionKt$lottieComposition$1.L$3;
                    str2 = (String) rememberLottieCompositionKt$lottieComposition$1.L$2;
                    str = (String) rememberLottieCompositionKt$lottieComposition$1.L$1;
                    context = (Context) rememberLottieCompositionKt$lottieComposition$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                lottieComposition = (LottieComposition) obj;
                rememberLottieCompositionKt$lottieComposition$1.L$0 = context;
                rememberLottieCompositionKt$lottieComposition$1.L$1 = str2;
                rememberLottieCompositionKt$lottieComposition$1.L$2 = str3;
                rememberLottieCompositionKt$lottieComposition$1.L$3 = lottieComposition;
                rememberLottieCompositionKt$lottieComposition$1.label = 2;
                if (loadImagesFromAssets(context, lottieComposition, str, rememberLottieCompositionKt$lottieComposition$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = str2;
                str6 = str3;
                context2 = context;
                lottieComposition2 = lottieComposition;
                rememberLottieCompositionKt$lottieComposition$1.L$0 = lottieComposition2;
                rememberLottieCompositionKt$lottieComposition$1.L$1 = null;
                rememberLottieCompositionKt$lottieComposition$1.L$2 = null;
                rememberLottieCompositionKt$lottieComposition$1.L$3 = null;
                rememberLottieCompositionKt$lottieComposition$1.label = 3;
                if (loadFontsFromAssets(context2, lottieComposition2, str5, str6, rememberLottieCompositionKt$lottieComposition$1) != coroutine_suspended) {
                }
            }
        }
        rememberLottieCompositionKt$lottieComposition$1 = new RememberLottieCompositionKt$lottieComposition$1(continuation);
        Object obj2 = rememberLottieCompositionKt$lottieComposition$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = rememberLottieCompositionKt$lottieComposition$1.label;
        if (i5 != 0) {
        }
        lottieComposition = (LottieComposition) obj2;
        rememberLottieCompositionKt$lottieComposition$1.L$0 = context;
        rememberLottieCompositionKt$lottieComposition$1.L$1 = str2;
        rememberLottieCompositionKt$lottieComposition$1.L$2 = str3;
        rememberLottieCompositionKt$lottieComposition$1.L$3 = lottieComposition;
        rememberLottieCompositionKt$lottieComposition$1.label = 2;
        if (loadImagesFromAssets(context, lottieComposition, str, rememberLottieCompositionKt$lottieComposition$1) != coroutine_suspended) {
        }
    }

    private static final LottieTask<LottieComposition> lottieTask(Context context, LottieCompositionSpec lottieCompositionSpec, String str, boolean z5) {
        if (lottieCompositionSpec instanceof LottieCompositionSpec.RawRes) {
            return Intrinsics.areEqual(str, DefaultCacheKey) ? LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).getResId()) : LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).getResId(), str);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeDecodeBase64Image(LottieImageAsset lottieImageAsset) {
        if (lottieImageAsset.getBitmap() != null) {
            return;
        }
        String filename = lottieImageAsset.getFileName();
        Intrinsics.checkNotNullExpressionValue(filename, "filename");
        if (!StringsKt.startsWith$default(filename, "data:", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) filename, "base64,", 0, false, 6, (Object) null) <= 0) {
            return;
        }
        try {
            String substring = filename.substring(StringsKt.indexOf$default((CharSequence) filename, ',', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            byte[] decode = Base64.decode(substring, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            lottieImageAsset.setBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
        } catch (IllegalArgumentException e5) {
            Logger.warning("data URL did not have correct base64 format.", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeLoadImageFromAsset(Context context, LottieImageAsset lottieImageAsset, String str) {
        if (lottieImageAsset.getBitmap() != null || str == null) {
            return;
        }
        try {
            InputStream open = context.getAssets().open(Intrinsics.stringPlus(str, lottieImageAsset.getFileName()));
            Intrinsics.checkNotNullExpressionValue(open, "try {\n        context.as…, e)\n        return\n    }");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                lottieImageAsset.setBitmap(Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(open, null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
            } catch (IllegalArgumentException e5) {
                Logger.warning("Unable to decode image.", e5);
            }
        } catch (IOException e6) {
            Logger.warning("Unable to open asset.", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeLoadTypefaceFromAssets(Context context, Font font, String str, String str2) {
        String str3 = ((Object) str) + ((Object) font.getFamily()) + str2;
        try {
            Typeface typefaceWithDefaultStyle = Typeface.createFromAsset(context.getAssets(), str3);
            try {
                Intrinsics.checkNotNullExpressionValue(typefaceWithDefaultStyle, "typefaceWithDefaultStyle");
                String style = font.getStyle();
                Intrinsics.checkNotNullExpressionValue(style, "font.style");
                font.setTypeface(typefaceForStyle(typefaceWithDefaultStyle, style));
            } catch (Exception e5) {
                Logger.error("Failed to create " + ((Object) font.getFamily()) + " typeface with style=" + ((Object) font.getStyle()) + '!', e5);
            }
        } catch (Exception e6) {
            Logger.error("Failed to find typeface in assets with path " + str3 + '.', e6);
        }
    }

    public static final LottieCompositionResult rememberLottieComposition(LottieCompositionSpec spec, String str, String str2, String str3, String str4, Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Composer composer, int i5, int i6) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        composer.startReplaceableGroup(1388713460);
        String str5 = (i6 & 2) != 0 ? null : str;
        String str6 = (i6 & 4) != 0 ? "fonts/" : str2;
        String str7 = (i6 & 8) != 0 ? ".ttf" : str3;
        String str8 = (i6 & 16) != 0 ? DefaultCacheKey : str4;
        Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> rememberLottieCompositionKt$rememberLottieComposition$1 = (i6 & 32) != 0 ? new RememberLottieCompositionKt$rememberLottieComposition$1(null) : function3;
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        int i7 = i5 & 14;
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(spec);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LottieCompositionResultImpl(), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        int i8 = i7 | ((i5 >> 9) & 112);
        composer.startReplaceableGroup(-3686552);
        boolean changed2 = composer.changed(spec) | composer.changed(str8);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(lottieTask(context, spec, str8, true));
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(spec, str8, new RememberLottieCompositionKt$rememberLottieComposition$3(rememberLottieCompositionKt$rememberLottieComposition$1, context, spec, str5, str6, str7, str8, mutableState, null), composer, i8);
        LottieCompositionResultImpl m2768rememberLottieComposition$lambda1 = m2768rememberLottieComposition$lambda1(mutableState);
        composer.endReplaceableGroup();
        return m2768rememberLottieComposition$lambda1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rememberLottieComposition$lambda-1, reason: not valid java name */
    public static final LottieCompositionResultImpl m2768rememberLottieComposition$lambda1(MutableState<LottieCompositionResultImpl> mutableState) {
        return mutableState.getValue();
    }

    private static final Typeface typefaceForStyle(Typeface typeface, String str) {
        int i5 = 0;
        boolean contains$default = StringsKt.contains$default((CharSequence) str, (CharSequence) "Italic", false, 2, (Object) null);
        boolean contains$default2 = StringsKt.contains$default((CharSequence) str, (CharSequence) "Bold", false, 2, (Object) null);
        if (contains$default && contains$default2) {
            i5 = 3;
        } else if (contains$default) {
            i5 = 2;
        } else if (contains$default2) {
            i5 = 1;
        }
        return typeface.getStyle() == i5 ? typeface : Typeface.create(typeface, i5);
    }
}
