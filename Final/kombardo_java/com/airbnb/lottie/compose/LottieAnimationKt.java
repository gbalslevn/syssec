package com.airbnb.lottie.compose;

import android.graphics.Matrix;
import android.graphics.Typeface;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.utils.Utils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¥\u0001\u0010\u001a\u001a\u00020\u00192\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001aÕ\u0001\u0010\u001a\u001a\u00020\u00192\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001a\u0010$\u001a\"\u0010+\u001a\u00020(*\u00020%2\u0006\u0010'\u001a\u00020&H\u0082\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Lcom/airbnb/lottie/LottieComposition;", "composition", "Lkotlin/Function0;", BuildConfig.FLAVOR, "progress", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "outlineMasksAndMattes", "applyOpacityToLayers", "enableMergePaths", "Lcom/airbnb/lottie/RenderMode;", "renderMode", "maintainOriginalImageBounds", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "dynamicProperties", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "clipToCompositionBounds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroid/graphics/Typeface;", "fontMap", BuildConfig.FLAVOR, "LottieAnimation", "(Lcom/airbnb/lottie/LottieComposition;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZLjava/util/Map;Landroidx/compose/runtime/Composer;III)V", "isPlaying", "restartOnPlay", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "speed", BuildConfig.FLAVOR, "iterations", "reverseOnRepeat", "(Lcom/airbnb/lottie/LottieComposition;Landroidx/compose/ui/Modifier;ZZLcom/airbnb/lottie/compose/LottieClipSpec;FIZZZLcom/airbnb/lottie/RenderMode;ZZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZLjava/util/Map;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/layout/ScaleFactor;", "scale", "Landroidx/compose/ui/unit/IntSize;", "times-UQTWf7w", "(JJ)J", "times", "lottie-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LottieAnimationKt {
    public static final void LottieAnimation(final LottieComposition lottieComposition, final Function0<Float> progress, Modifier modifier, boolean z5, boolean z6, boolean z7, RenderMode renderMode, boolean z8, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z9, Map<String, ? extends Typeface> map, Composer composer, final int i5, final int i6, final int i7) {
        Modifier modifier2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer startRestartGroup = composer.startRestartGroup(185150686);
        Modifier modifier3 = (i7 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z10 = (i7 & 8) != 0 ? false : z5;
        final boolean z11 = (i7 & 16) != 0 ? false : z6;
        final boolean z12 = (i7 & 32) != 0 ? false : z7;
        final RenderMode renderMode2 = (i7 & 64) != 0 ? RenderMode.AUTOMATIC : renderMode;
        final boolean z13 = (i7 & 128) != 0 ? false : z8;
        final LottieDynamicProperties lottieDynamicProperties2 = (i7 & 256) != 0 ? null : lottieDynamicProperties;
        final Alignment center = (i7 & 512) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final ContentScale fit = (i7 & 1024) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final boolean z14 = (i7 & 2048) != 0 ? true : z9;
        Map<String, ? extends Typeface> map2 = (i7 & 4096) != 0 ? null : map;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new LottieDrawable();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final LottieDrawable lottieDrawable = (LottieDrawable) rememberedValue;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Matrix();
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final Matrix matrix = (Matrix) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(185151463);
        if (lottieComposition != null && lottieComposition.getDuration() != 0.0f) {
            startRestartGroup.endReplaceableGroup();
            float dpScale = Utils.dpScale();
            final ContentScale contentScale2 = fit;
            final Alignment alignment2 = center;
            final boolean z15 = z12;
            final RenderMode renderMode3 = renderMode2;
            final Map<String, ? extends Typeface> map3 = map2;
            final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
            final boolean z16 = z10;
            final boolean z17 = z11;
            final boolean z18 = z13;
            final boolean z19 = z14;
            CanvasKt.Canvas(SizeKt.m333sizeVpY3zN4(modifier3, Dp.m2599constructorimpl(lottieComposition.getBounds().width() / dpScale), Dp.m2599constructorimpl(lottieComposition.getBounds().height() / dpScale)), new Function1<DrawScope, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    long m2760timesUQTWf7w;
                    LottieDynamicProperties m2753LottieAnimation$lambda3;
                    LottieDynamicProperties m2753LottieAnimation$lambda32;
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    LottieComposition lottieComposition2 = LottieComposition.this;
                    ContentScale contentScale3 = contentScale2;
                    Alignment alignment3 = alignment2;
                    Matrix matrix2 = matrix;
                    LottieDrawable lottieDrawable2 = lottieDrawable;
                    boolean z20 = z15;
                    RenderMode renderMode4 = renderMode3;
                    Map<String, Typeface> map4 = map3;
                    LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties3;
                    boolean z21 = z16;
                    boolean z22 = z17;
                    boolean z23 = z18;
                    boolean z24 = z19;
                    Function0<Float> function0 = progress;
                    MutableState<LottieDynamicProperties> mutableState2 = mutableState;
                    Canvas canvas = Canvas.getDrawContext().getCanvas();
                    long Size = androidx.compose.ui.geometry.SizeKt.Size(lottieComposition2.getBounds().width(), lottieComposition2.getBounds().height());
                    long IntSize = IntSizeKt.IntSize(MathKt.roundToInt(Size.m1377getWidthimpl(Canvas.mo1703getSizeNHjbRc())), MathKt.roundToInt(Size.m1375getHeightimpl(Canvas.mo1703getSizeNHjbRc())));
                    long mo1937computeScaleFactorH7hwNQA = contentScale3.mo1937computeScaleFactorH7hwNQA(Size, Canvas.mo1703getSizeNHjbRc());
                    m2760timesUQTWf7w = LottieAnimationKt.m2760timesUQTWf7w(Size, mo1937computeScaleFactorH7hwNQA);
                    long mo1251alignKFBX0sM = alignment3.mo1251alignKFBX0sM(m2760timesUQTWf7w, IntSize, Canvas.getLayoutDirection());
                    matrix2.reset();
                    matrix2.preTranslate(IntOffset.m2640getXimpl(mo1251alignKFBX0sM), IntOffset.m2641getYimpl(mo1251alignKFBX0sM));
                    matrix2.preScale(ScaleFactor.m1981getScaleXimpl(mo1937computeScaleFactorH7hwNQA), ScaleFactor.m1982getScaleYimpl(mo1937computeScaleFactorH7hwNQA));
                    lottieDrawable2.enableMergePathsForKitKatAndAbove(z20);
                    lottieDrawable2.setRenderMode(renderMode4);
                    lottieDrawable2.setComposition(lottieComposition2);
                    lottieDrawable2.setFontMap(map4);
                    m2753LottieAnimation$lambda3 = LottieAnimationKt.m2753LottieAnimation$lambda3(mutableState2);
                    if (lottieDynamicProperties4 != m2753LottieAnimation$lambda3) {
                        m2753LottieAnimation$lambda32 = LottieAnimationKt.m2753LottieAnimation$lambda3(mutableState2);
                        if (m2753LottieAnimation$lambda32 != null) {
                            m2753LottieAnimation$lambda32.removeFrom$lottie_compose_release(lottieDrawable2);
                        }
                        if (lottieDynamicProperties4 != null) {
                            lottieDynamicProperties4.addTo$lottie_compose_release(lottieDrawable2);
                        }
                        mutableState2.setValue(lottieDynamicProperties4);
                    }
                    lottieDrawable2.setOutlineMasksAndMattes(z21);
                    lottieDrawable2.setApplyingOpacityToLayersEnabled(z22);
                    lottieDrawable2.setMaintainOriginalImageBounds(z23);
                    lottieDrawable2.setClipToCompositionBounds(z24);
                    lottieDrawable2.setProgress(function0.invoke().floatValue());
                    lottieDrawable2.setBounds(0, 0, lottieComposition2.getBounds().width(), lottieComposition2.getBounds().height());
                    lottieDrawable2.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas), matrix2);
                }
            }, startRestartGroup, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final Map<String, ? extends Typeface> map4 = map2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    LottieAnimationKt.LottieAnimation(LottieComposition.this, progress, modifier4, z10, z11, z12, renderMode2, z13, lottieDynamicProperties2, center, fit, z14, map4, composer3, i5 | 1, i6, i7);
                }
            });
            return;
        }
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            modifier2 = modifier3;
            composer2 = startRestartGroup;
        } else {
            final Modifier modifier5 = modifier3;
            modifier2 = modifier3;
            final Map<String, ? extends Typeface> map5 = map2;
            composer2 = startRestartGroup;
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    LottieAnimationKt.LottieAnimation(LottieComposition.this, progress, modifier5, z10, z11, z12, renderMode2, z13, lottieDynamicProperties2, center, fit, z14, map5, composer3, i5 | 1, i6, i7);
                }
            });
        }
        BoxKt.Box(modifier2, composer2, (i5 >> 6) & 14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LottieAnimation$lambda-3, reason: not valid java name */
    public static final LottieDynamicProperties m2753LottieAnimation$lambda3(MutableState<LottieDynamicProperties> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LottieAnimation$lambda-6, reason: not valid java name */
    public static final float m2755LottieAnimation$lambda6(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m2760timesUQTWf7w(long j5, long j6) {
        return IntSizeKt.IntSize((int) (Size.m1377getWidthimpl(j5) * ScaleFactor.m1981getScaleXimpl(j6)), (int) (Size.m1375getHeightimpl(j5) * ScaleFactor.m1982getScaleYimpl(j6)));
    }

    public static final void LottieAnimation(final LottieComposition lottieComposition, Modifier modifier, boolean z5, boolean z6, LottieClipSpec lottieClipSpec, float f5, int i5, boolean z7, boolean z8, boolean z9, RenderMode renderMode, boolean z10, boolean z11, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z12, Map<String, ? extends Typeface> map, Composer composer, final int i6, final int i7, final int i8) {
        Composer startRestartGroup = composer.startRestartGroup(185154698);
        final Modifier modifier2 = (i8 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z13 = (i8 & 4) != 0 ? true : z5;
        boolean z14 = (i8 & 8) != 0 ? true : z6;
        LottieClipSpec lottieClipSpec2 = (i8 & 16) != 0 ? null : lottieClipSpec;
        float f6 = (i8 & 32) != 0 ? 1.0f : f5;
        int i9 = (i8 & 64) != 0 ? 1 : i5;
        boolean z15 = (i8 & 128) != 0 ? false : z7;
        boolean z16 = (i8 & 256) != 0 ? false : z8;
        boolean z17 = (i8 & 512) != 0 ? false : z9;
        RenderMode renderMode2 = (i8 & 1024) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z18 = (i8 & 2048) != 0 ? false : z10;
        boolean z19 = (i8 & 4096) != 0 ? false : z11;
        LottieDynamicProperties lottieDynamicProperties2 = (i8 & 8192) != 0 ? null : lottieDynamicProperties;
        Alignment center = (i8 & 16384) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (32768 & i8) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        boolean z20 = (65536 & i8) != 0 ? true : z12;
        Map<String, ? extends Typeface> map2 = (131072 & i8) != 0 ? null : map;
        int i10 = i6 >> 3;
        final LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieComposition, z13, z14, z18, lottieClipSpec2, f6, i9, null, false, false, startRestartGroup, (i10 & 896) | (i10 & 112) | 8 | ((i7 << 6) & 7168) | (i6 & 57344) | (i6 & 458752) | (i6 & 3670016), 896);
        startRestartGroup.startReplaceableGroup(-3686930);
        boolean changed = startRestartGroup.changed(animateLottieCompositionAsState);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    float m2755LottieAnimation$lambda6;
                    m2755LottieAnimation$lambda6 = LottieAnimationKt.m2755LottieAnimation$lambda6(LottieAnimationState.this);
                    return Float.valueOf(m2755LottieAnimation$lambda6);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Function0 function0 = (Function0) rememberedValue;
        int i11 = i6 >> 12;
        int i12 = i7 << 15;
        int i13 = i7 >> 15;
        Modifier modifier3 = modifier2;
        boolean z21 = z15;
        boolean z22 = z16;
        boolean z23 = z17;
        RenderMode renderMode3 = renderMode2;
        boolean z24 = z19;
        LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
        Alignment alignment2 = center;
        ContentScale contentScale2 = fit;
        boolean z25 = z20;
        Map<String, ? extends Typeface> map3 = map2;
        LottieAnimation(lottieComposition, function0, modifier3, z21, z22, z23, renderMode3, z24, lottieDynamicProperties3, alignment2, contentScale2, z25, map3, startRestartGroup, ((i6 << 3) & 896) | 134217736 | (i11 & 7168) | (57344 & i11) | (458752 & i11) | ((i7 << 18) & 3670016) | (29360128 & i12) | (i12 & 1879048192), (i13 & 112) | (i13 & 14) | 512, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final boolean z26 = z13;
        final boolean z27 = z14;
        final LottieClipSpec lottieClipSpec3 = lottieClipSpec2;
        final float f7 = f6;
        final int i14 = i9;
        final boolean z28 = z15;
        final boolean z29 = z16;
        final boolean z30 = z17;
        final RenderMode renderMode4 = renderMode2;
        final boolean z31 = z18;
        final boolean z32 = z19;
        final LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties2;
        final Alignment alignment3 = center;
        final ContentScale contentScale3 = fit;
        final boolean z33 = z20;
        final Map<String, ? extends Typeface> map4 = map2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                LottieAnimationKt.LottieAnimation(LottieComposition.this, modifier2, z26, z27, lottieClipSpec3, f7, i14, z28, z29, z30, renderMode4, z31, z32, lottieDynamicProperties4, alignment3, contentScale3, z33, map4, composer2, i6 | 1, i7, i8);
            }
        });
    }
}
