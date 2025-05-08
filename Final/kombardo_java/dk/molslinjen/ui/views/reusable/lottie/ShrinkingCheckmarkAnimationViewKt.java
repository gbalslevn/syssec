package dk.molslinjen.ui.views.reusable.lottie;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.adjust.sdk.Constants;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimatableKt;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00050\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006#²\u0006\u000e\u0010\u0011\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0016\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00198\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u00158\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001d\u001a\u00020\u001c8\nX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\f\u0010 \u001a\u00020\u001c8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\"\u001a\u0004\u0018\u00010!8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "backgroundColor", BuildConfig.FLAVOR, "alignToTop", "Lkotlin/Function0;", BuildConfig.FLAVOR, "closeAction", "content", "ShrinkingCheckmarkAnimationView-euL9pac", "(JZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShrinkingCheckmarkAnimationView", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "marker", "Lkotlin/Function1;", "onCompletion", "LottieView", "(Lcom/airbnb/lottie/compose/LottieClipSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "showTextContent", "enableScroll", "Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "currentMarker", BuildConfig.FLAVOR, "rootHeight", "contentInitialYPx", "contentHeight", "Landroidx/compose/ui/geometry/Offset;", "animatedViewInitialPosition", "animatedViewHeight", "Landroidx/compose/ui/unit/Dp;", "animationViewOffsetPx", BuildConfig.FLAVOR, "animatedAlpha", "animatedContentOffset", "Lcom/airbnb/lottie/LottieComposition;", "composition", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ShrinkingCheckmarkAnimationViewKt {
    private static final void LottieView(LottieClipSpec lottieClipSpec, final Function1<? super LottieClipSpec, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Continuation continuation;
        final LottieClipSpec lottieClipSpec2 = lottieClipSpec;
        Composer startRestartGroup = composer.startRestartGroup(1897310592);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(lottieClipSpec2) : startRestartGroup.changedInstance(lottieClipSpec2) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i7;
        if ((i9 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                lottieClipSpec2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897310592, i9, -1, "dk.molslinjen.ui.views.reusable.lottie.LottieView (ShrinkingCheckmarkAnimationView.kt:219)");
            }
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_login_check_pop_shrink)), null, null, null, null, null, startRestartGroup, 6, 62);
            final LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(startRestartGroup, 0);
            LottieComposition LottieView$lambda$47 = LottieView$lambda$47(rememberLottieComposition);
            startRestartGroup.startReplaceGroup(1074713428);
            int i10 = i9 & 14;
            boolean changed = startRestartGroup.changed(rememberLottieAnimatable) | startRestartGroup.changed(rememberLottieComposition) | (i10 == 4 || ((i9 & 8) != 0 && startRestartGroup.changedInstance(lottieClipSpec2)));
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                continuation = null;
                rememberedValue = new ShrinkingCheckmarkAnimationViewKt$LottieView$1$1(rememberLottieAnimatable, lottieClipSpec2, rememberLottieComposition, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                continuation = null;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lottieClipSpec2, LottieView$lambda$47, (Function2) rememberedValue, startRestartGroup, LottieClipSpec.$stable | i10);
            Boolean valueOf = Boolean.valueOf(rememberLottieAnimatable.isAtEnd());
            Float valueOf2 = Float.valueOf(rememberLottieAnimatable.getProgress());
            startRestartGroup.startReplaceGroup(1074721119);
            boolean changed2 = ((i9 & 112) == 32) | startRestartGroup.changed(rememberLottieAnimatable) | (i10 == 4 || ((i9 & 8) != 0 && startRestartGroup.changedInstance(lottieClipSpec2)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ShrinkingCheckmarkAnimationViewKt$LottieView$2$1(rememberLottieAnimatable, function1, lottieClipSpec2, continuation);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) rememberedValue2, startRestartGroup, 0);
            LottieComposition LottieView$lambda$472 = LottieView$lambda$47(rememberLottieComposition);
            startRestartGroup.startReplaceGroup(1074727397);
            boolean changed3 = startRestartGroup.changed(rememberLottieAnimatable);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: i2.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float progress;
                        progress = LottieAnimatable.this.getProgress();
                        return Float.valueOf(progress);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(LottieView$lambda$472, (Function0) rememberedValue3, null, Accessibility.INSTANCE.getSkip(), startRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LottieView$lambda$52;
                    LottieView$lambda$52 = ShrinkingCheckmarkAnimationViewKt.LottieView$lambda$52(LottieClipSpec.this, function1, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return LottieView$lambda$52;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieComposition LottieView$lambda$47(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LottieView$lambda$52(LottieClipSpec lottieClipSpec, Function1 function1, int i5, int i6, Composer composer, int i7) {
        LottieView(lottieClipSpec, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03a6  */
    /* renamed from: ShrinkingCheckmarkAnimationView-euL9pac, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3423ShrinkingCheckmarkAnimationVieweuL9pac(long j5, boolean z5, Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        long j6;
        int i7;
        boolean z6;
        int i8;
        Function0<Unit> function02;
        int i9;
        boolean z7;
        Function0<Unit> function03;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        final LottieClipSpec.Markers markers;
        Object rememberedValue5;
        final MutableState mutableState2;
        Object rememberedValue6;
        Object rememberedValue7;
        Object rememberedValue8;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Object rememberedValue9;
        final MutableState mutableState3;
        Object rememberedValue10;
        final MutableState mutableState4;
        MutableState mutableState5;
        MutableState mutableState6;
        LottieClipSpec.Markers markers2;
        MutableState mutableState7;
        int i10;
        float m2599constructorimpl;
        boolean changedInstance;
        Object rememberedValue11;
        int i11;
        float f5;
        Object rememberedValue12;
        Object rememberedValue13;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Function0<Unit> function04;
        Modifier.Companion companion2;
        Object rememberedValue14;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        boolean changedInstance2;
        Object rememberedValue15;
        final MutableState mutableState8;
        int currentCompositeKeyHash4;
        Composer m1226constructorimpl4;
        boolean changedInstance3;
        Object rememberedValue16;
        final Function0<Unit> function05;
        final long j7;
        Integer num;
        int i12;
        Dp m2597boximpl;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-470132236);
        int i13 = i6 & 1;
        if (i13 != 0) {
            i7 = i5 | 6;
            j6 = j5;
        } else if ((i5 & 6) == 0) {
            j6 = j5;
            i7 = (startRestartGroup.changed(j6) ? 4 : 2) | i5;
        } else {
            j6 = j5;
            i7 = i5;
        }
        int i14 = i6 & 2;
        if (i14 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function02 = function0;
                i7 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
                if ((i6 & 8) != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
                }
                i9 = i7;
                if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    long m3281getWhite0d7_KjU = i13 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j6;
                    z7 = i14 != 0 ? false : z6;
                    function03 = i8 != 0 ? null : function02;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-470132236, i9, -1, "dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationView (ShrinkingCheckmarkAnimationView.kt:61)");
                    }
                    startRestartGroup.startReplaceGroup(1324301637);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    mutableState = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324303525);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    MutableState mutableState9 = (MutableState) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324305521);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new LottieClipSpec.Markers("Pop", "Shrink", false, 4, null);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    LottieClipSpec.Markers markers3 = (LottieClipSpec.Markers) rememberedValue3;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324309809);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new LottieClipSpec.Markers("Shrink", "End", false, 4, null);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    markers = (LottieClipSpec.Markers) rememberedValue4;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324314125);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(markers3, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    mutableState2 = (MutableState) rememberedValue5;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324316225);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    MutableState mutableState10 = (MutableState) rememberedValue6;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324318145);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    final MutableState mutableState11 = (MutableState) rememberedValue7;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324319937);
                    rememberedValue8 = startRestartGroup.rememberedValue();
                    if (rememberedValue8 == companion.getEmpty()) {
                        snapshotMutationPolicy = null;
                        rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    } else {
                        snapshotMutationPolicy = null;
                    }
                    MutableState mutableState12 = (MutableState) rememberedValue8;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324322500);
                    rememberedValue9 = startRestartGroup.rememberedValue();
                    if (rememberedValue9 == companion.getEmpty()) {
                        rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                    }
                    mutableState3 = (MutableState) rememberedValue9;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1324324545);
                    rememberedValue10 = startRestartGroup.rememberedValue();
                    if (rememberedValue10 == companion.getEmpty()) {
                        rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                    }
                    mutableState4 = (MutableState) rememberedValue10;
                    startRestartGroup.endReplaceGroup();
                    float m2599constructorimpl2 = Dp.m2599constructorimpl(76);
                    startRestartGroup.startReplaceGroup(1324332661);
                    if (Intrinsics.areEqual(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState2), markers)) {
                        Offset ShrinkingCheckmarkAnimationView_euL9pac$lambda$21 = ShrinkingCheckmarkAnimationView_euL9pac$lambda$21(mutableState3);
                        if (ShrinkingCheckmarkAnimationView_euL9pac$lambda$21 != null) {
                            num = Integer.valueOf((int) Offset.m1338getYimpl(ShrinkingCheckmarkAnimationView_euL9pac$lambda$21.getPackedValue()));
                            mutableState5 = mutableState12;
                        } else {
                            mutableState5 = mutableState12;
                            num = null;
                        }
                        startRestartGroup.startReplaceGroup(1324347275);
                        if (num == null) {
                            m2597boximpl = null;
                            i12 = 0;
                        } else {
                            int intValue = num.intValue();
                            i12 = 0;
                            m2597boximpl = Dp.m2597boximpl(ComposeExtensionsKt.pxToDp(intValue, startRestartGroup, 0));
                        }
                        startRestartGroup.endReplaceGroup();
                        mutableState6 = mutableState10;
                        markers2 = markers3;
                        mutableState7 = mutableState9;
                        float f6 = 2;
                        m2599constructorimpl = Dp.m2599constructorimpl(Dp.m2599constructorimpl(Dp.m2599constructorimpl(ComposeExtensionsKt.pxToDp(ShrinkingCheckmarkAnimationView_euL9pac$lambda$15(mutableState11), startRestartGroup, i12) - (m2597boximpl != null ? m2597boximpl.getValue() : Dp.m2599constructorimpl(i12))) - Dp.m2599constructorimpl(ComposeExtensionsKt.pxToDp(ShrinkingCheckmarkAnimationView_euL9pac$lambda$24(mutableState4), startRestartGroup, i12) / f6)) + Dp.m2599constructorimpl(m2599constructorimpl2 / f6));
                        i10 = 0;
                    } else {
                        mutableState5 = mutableState12;
                        mutableState6 = mutableState10;
                        markers2 = markers3;
                        mutableState7 = mutableState9;
                        i10 = 0;
                        m2599constructorimpl = Dp.m2599constructorimpl(0);
                    }
                    startRestartGroup.endReplaceGroup();
                    TweenSpec tween$default = AnimationSpecKt.tween$default(Constants.MINIMAL_ERROR_STATUS_CODE, i10, EasingKt.getFastOutSlowInEasing(), 2, null);
                    startRestartGroup.startReplaceGroup(1324364746);
                    changedInstance = startRestartGroup.changedInstance(markers);
                    rememberedValue11 = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue11 == companion.getEmpty()) {
                        rememberedValue11 = new Function1() { // from class: i2.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26(LottieClipSpec.Markers.this, mutableState2, mutableState, (Dp) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue11);
                    }
                    Function1 function1 = (Function1) rememberedValue11;
                    startRestartGroup.endReplaceGroup();
                    final MutableState mutableState13 = mutableState5;
                    final MutableState mutableState14 = mutableState6;
                    final LottieClipSpec.Markers markers4 = markers2;
                    final MutableState mutableState15 = mutableState7;
                    State<Dp> m56animateDpAsStateAjpBEmI = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl, tween$default, "animationOffset", function1, startRestartGroup, 384, 0);
                    State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, null), 0.0f, "alpha", null, startRestartGroup, 3072, 20);
                    if (ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState)) {
                        i11 = 0;
                        f5 = 0;
                    } else {
                        i11 = 0;
                        f5 = -12;
                    }
                    float m2599constructorimpl3 = Dp.m2599constructorimpl(f5);
                    TweenSpec tween$default2 = AnimationSpecKt.tween$default(200, i11, EasingKt.getLinearOutSlowInEasing(), 2, null);
                    startRestartGroup.startReplaceGroup(1324388334);
                    rememberedValue12 = startRestartGroup.rememberedValue();
                    if (rememberedValue12 == companion.getEmpty()) {
                        rememberedValue12 = new Function1() { // from class: i2.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$31$lambda$30;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$31$lambda$30 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$31$lambda$30(MutableState.this, (Dp) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$31$lambda$30;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue12);
                    }
                    startRestartGroup.endReplaceGroup();
                    State<Dp> m56animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl3, tween$default2, "contentOffset", (Function1) rememberedValue12, startRestartGroup, 3456, 0);
                    ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), m3281getWhite0d7_KjU, null, 2, null);
                    startRestartGroup.startReplaceGroup(1324395870);
                    rememberedValue13 = startRestartGroup.rememberedValue();
                    if (rememberedValue13 == companion.getEmpty()) {
                        rememberedValue13 = new Function1() { // from class: i2.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$34$lambda$33;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$34$lambda$33 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$34$lambda$33(MutableState.this, (LayoutCoordinates) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$34$lambda$33;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue13);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier clip = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(m104backgroundbw27NRU$default, (Function1) rememberedValue13), RectangleShapeKt.getRectangleShape());
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clip);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion5.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), rememberScrollState, ShrinkingCheckmarkAnimationView_euL9pac$lambda$4(mutableState15), null, false, 12, null);
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
                    Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
                    startRestartGroup.startReplaceGroup(260601200);
                    if (function03 == null) {
                        function04 = function03;
                        companion2 = companion3;
                    } else {
                        float f7 = 24;
                        Function0<Unit> function06 = function03;
                        function04 = function03;
                        companion2 = companion3;
                        NavigationButtonKt.NavigationButton(NavigationButtonType.Close, boxScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), 0.0f, 9, null), companion4.getTopEnd()), function06, startRestartGroup, (i9 & 896) | 6, 0);
                        Unit unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier align = boxScopeInstance.align(companion2, z7 ? companion4.getTopCenter() : companion4.getCenter());
                    startRestartGroup.startReplaceGroup(260624728);
                    rememberedValue14 = startRestartGroup.rememberedValue();
                    if (rememberedValue14 == companion.getEmpty()) {
                        rememberedValue14 = new Function1() { // from class: i2.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$39$lambda$37$lambda$36;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$39$lambda$37$lambda$36 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$39$lambda$37$lambda$36(MutableState.this, mutableState13, (LayoutCoordinates) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$39$lambda$37$lambda$36;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue14);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier alpha = AlphaKt.alpha(OffsetKt.m295offsetVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(align, (Function1) rememberedValue14), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$32(m56animateDpAsStateAjpBEmI2), 1, null), ShrinkingCheckmarkAnimationView_euL9pac$lambda$29(animateFloatAsState));
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha);
                    Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                    if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, m2599constructorimpl2), startRestartGroup, 6);
                    content.invoke(startRestartGroup, Integer.valueOf((i9 >> 9) & 14));
                    startRestartGroup.endNode();
                    startRestartGroup.endNode();
                    Modifier align2 = boxScopeInstance.align(OffsetKt.m295offsetVpY3zN4$default(OffsetKt.m295offsetVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(-ComposeExtensionsKt.pxToDp(rememberScrollState.getValue(), startRestartGroup, 0)), 1, null), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$28(m56animateDpAsStateAjpBEmI), 1, null), companion4.getCenter());
                    startRestartGroup.startReplaceGroup(604044546);
                    changedInstance2 = startRestartGroup.changedInstance(markers);
                    rememberedValue15 = startRestartGroup.rememberedValue();
                    if (!changedInstance2 || rememberedValue15 == companion.getEmpty()) {
                        mutableState8 = mutableState2;
                        rememberedValue15 = new Function1() { // from class: i2.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40(LottieClipSpec.Markers.this, mutableState3, mutableState8, mutableState4, (LayoutCoordinates) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue15);
                    } else {
                        mutableState8 = mutableState2;
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(align2, (Function1) rememberedValue15);
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                    Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor4);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion5.getSetCompositeKeyHash();
                    if (!m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion5.getSetModifier());
                    LottieClipSpec.Markers ShrinkingCheckmarkAnimationView_euL9pac$lambda$9 = ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState8);
                    startRestartGroup.startReplaceGroup(260666414);
                    changedInstance3 = startRestartGroup.changedInstance(markers4) | startRestartGroup.changedInstance(markers);
                    rememberedValue16 = startRestartGroup.rememberedValue();
                    if (!changedInstance3 || rememberedValue16 == companion.getEmpty()) {
                        rememberedValue16 = new Function1() { // from class: i2.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
                                ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42(LottieClipSpec.Markers.this, markers, mutableState8, (LottieClipSpec) obj);
                                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue16);
                    }
                    startRestartGroup.endReplaceGroup();
                    LottieView(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9, (Function1) rememberedValue16, startRestartGroup, LottieClipSpec.Markers.$stable, 0);
                    startRestartGroup.endNode();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function05 = function04;
                    j7 = m3281getWhite0d7_KjU;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j7 = j6;
                    z7 = z6;
                    function05 = function02;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final boolean z8 = z7;
                    endRestartGroup.updateScope(new Function2() { // from class: i2.l
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$46;
                            ShrinkingCheckmarkAnimationView_euL9pac$lambda$46 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$46(j7, z8, function05, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return ShrinkingCheckmarkAnimationView_euL9pac$lambda$46;
                        }
                    });
                    return;
                }
                return;
            }
            function02 = function0;
            if ((i6 & 8) != 0) {
            }
            i9 = i7;
            if ((i9 & 1171) == 1170) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(1324301637);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324303525);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            MutableState mutableState92 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324305521);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            LottieClipSpec.Markers markers32 = (LottieClipSpec.Markers) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324309809);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            markers = (LottieClipSpec.Markers) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324314125);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
            }
            mutableState2 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324316225);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
            }
            MutableState mutableState102 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324318145);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
            }
            final MutableState mutableState112 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324319937);
            rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
            }
            MutableState mutableState122 = (MutableState) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324322500);
            rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion.getEmpty()) {
            }
            mutableState3 = (MutableState) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1324324545);
            rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == companion.getEmpty()) {
            }
            mutableState4 = (MutableState) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            float m2599constructorimpl22 = Dp.m2599constructorimpl(76);
            startRestartGroup.startReplaceGroup(1324332661);
            if (Intrinsics.areEqual(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState2), markers)) {
            }
            startRestartGroup.endReplaceGroup();
            TweenSpec tween$default3 = AnimationSpecKt.tween$default(Constants.MINIMAL_ERROR_STATUS_CODE, i10, EasingKt.getFastOutSlowInEasing(), 2, null);
            startRestartGroup.startReplaceGroup(1324364746);
            changedInstance = startRestartGroup.changedInstance(markers);
            rememberedValue11 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue11 = new Function1() { // from class: i2.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
                    ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26(LottieClipSpec.Markers.this, mutableState2, mutableState, (Dp) obj);
                    return ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue11);
            Function1 function12 = (Function1) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState132 = mutableState5;
            final MutableState mutableState142 = mutableState6;
            final LottieClipSpec.Markers markers42 = markers2;
            final MutableState mutableState152 = mutableState7;
            State<Dp> m56animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl, tween$default3, "animationOffset", function12, startRestartGroup, 384, 0);
            State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, null), 0.0f, "alpha", null, startRestartGroup, 3072, 20);
            if (ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState)) {
            }
            float m2599constructorimpl32 = Dp.m2599constructorimpl(f5);
            TweenSpec tween$default22 = AnimationSpecKt.tween$default(200, i11, EasingKt.getLinearOutSlowInEasing(), 2, null);
            startRestartGroup.startReplaceGroup(1324388334);
            rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            State<Dp> m56animateDpAsStateAjpBEmI22 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl32, tween$default22, "contentOffset", (Function1) rememberedValue12, startRestartGroup, 3456, 0);
            ScrollState rememberScrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Modifier.Companion companion32 = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion32, 0.0f, 1, null), m3281getWhite0d7_KjU, null, 2, null);
            startRestartGroup.startReplaceGroup(1324395870);
            rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier clip2 = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(m104backgroundbw27NRU$default2, (Function1) rememberedValue13), RectangleShapeKt.getRectangleShape());
            Alignment.Companion companion42 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, clip2);
            ComposeUiNode.Companion companion52 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor5 = companion52.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy4, companion52.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap5, companion52.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion52.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier5, companion52.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier verticalScroll$default2 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion32, 0.0f, 1, null), rememberScrollState2, ShrinkingCheckmarkAnimationView_euL9pac$lambda$4(mutableState152), null, false, 12, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getTopStart(), false);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default2);
            Function0<ComposeUiNode> constructor22 = companion52.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy22, companion52.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion52.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion52.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion52.getSetModifier());
            startRestartGroup.startReplaceGroup(260601200);
            if (function03 == null) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier align3 = boxScopeInstance2.align(companion2, z7 ? companion42.getTopCenter() : companion42.getCenter());
            startRestartGroup.startReplaceGroup(260624728);
            rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier alpha2 = AlphaKt.alpha(OffsetKt.m295offsetVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(align3, (Function1) rememberedValue14), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$32(m56animateDpAsStateAjpBEmI22), 1, null), ShrinkingCheckmarkAnimationView_euL9pac$lambda$29(animateFloatAsState2));
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion42.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha2);
            Function0<ComposeUiNode> constructor32 = companion52.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion52.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion52.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion52.getSetCompositeKeyHash();
            if (!m1226constructorimpl3.getInserting()) {
            }
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion52.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, m2599constructorimpl22), startRestartGroup, 6);
            content.invoke(startRestartGroup, Integer.valueOf((i9 >> 9) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            Modifier align22 = boxScopeInstance2.align(OffsetKt.m295offsetVpY3zN4$default(OffsetKt.m295offsetVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(-ComposeExtensionsKt.pxToDp(rememberScrollState2.getValue(), startRestartGroup, 0)), 1, null), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$28(m56animateDpAsStateAjpBEmI3), 1, null), companion42.getCenter());
            startRestartGroup.startReplaceGroup(604044546);
            changedInstance2 = startRestartGroup.changedInstance(markers);
            rememberedValue15 = startRestartGroup.rememberedValue();
            if (changedInstance2) {
            }
            mutableState8 = mutableState2;
            rememberedValue15 = new Function1() { // from class: i2.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
                    ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40(LottieClipSpec.Markers.this, mutableState3, mutableState8, mutableState4, (LayoutCoordinates) obj);
                    return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue15);
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(align22, (Function1) rememberedValue15);
            MeasurePolicy maybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getTopStart(), false);
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
            Function0<ComposeUiNode> constructor42 = companion52.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy32, companion52.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap42, companion52.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion52.getSetCompositeKeyHash();
            if (!m1226constructorimpl4.getInserting()) {
            }
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier42, companion52.getSetModifier());
            LottieClipSpec.Markers ShrinkingCheckmarkAnimationView_euL9pac$lambda$92 = ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState8);
            startRestartGroup.startReplaceGroup(260666414);
            changedInstance3 = startRestartGroup.changedInstance(markers42) | startRestartGroup.changedInstance(markers);
            rememberedValue16 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
            }
            rememberedValue16 = new Function1() { // from class: i2.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
                    ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42(LottieClipSpec.Markers.this, markers, mutableState8, (LottieClipSpec) obj);
                    return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue16);
            startRestartGroup.endReplaceGroup();
            LottieView(ShrinkingCheckmarkAnimationView_euL9pac$lambda$92, (Function1) rememberedValue16, startRestartGroup, LottieClipSpec.Markers.$stable, 0);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function05 = function04;
            j7 = m3281getWhite0d7_KjU;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z6 = z5;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i6 & 8) != 0) {
        }
        i9 = i7;
        if ((i9 & 1171) == 1170) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(1324301637);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324303525);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        MutableState mutableState922 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324305521);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        LottieClipSpec.Markers markers322 = (LottieClipSpec.Markers) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324309809);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        markers = (LottieClipSpec.Markers) rememberedValue4;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324314125);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
        }
        mutableState2 = (MutableState) rememberedValue5;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324316225);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
        }
        MutableState mutableState1022 = (MutableState) rememberedValue6;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324318145);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == companion.getEmpty()) {
        }
        final MutableState mutableState1122 = (MutableState) rememberedValue7;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324319937);
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (rememberedValue8 == companion.getEmpty()) {
        }
        MutableState mutableState1222 = (MutableState) rememberedValue8;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324322500);
        rememberedValue9 = startRestartGroup.rememberedValue();
        if (rememberedValue9 == companion.getEmpty()) {
        }
        mutableState3 = (MutableState) rememberedValue9;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1324324545);
        rememberedValue10 = startRestartGroup.rememberedValue();
        if (rememberedValue10 == companion.getEmpty()) {
        }
        mutableState4 = (MutableState) rememberedValue10;
        startRestartGroup.endReplaceGroup();
        float m2599constructorimpl222 = Dp.m2599constructorimpl(76);
        startRestartGroup.startReplaceGroup(1324332661);
        if (Intrinsics.areEqual(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState2), markers)) {
        }
        startRestartGroup.endReplaceGroup();
        TweenSpec tween$default32 = AnimationSpecKt.tween$default(Constants.MINIMAL_ERROR_STATUS_CODE, i10, EasingKt.getFastOutSlowInEasing(), 2, null);
        startRestartGroup.startReplaceGroup(1324364746);
        changedInstance = startRestartGroup.changedInstance(markers);
        rememberedValue11 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue11 = new Function1() { // from class: i2.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
                ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26(LottieClipSpec.Markers.this, mutableState2, mutableState, (Dp) obj);
                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue11);
        Function1 function122 = (Function1) rememberedValue11;
        startRestartGroup.endReplaceGroup();
        final MutableState mutableState1322 = mutableState5;
        final MutableState mutableState1422 = mutableState6;
        final LottieClipSpec.Markers markers422 = markers2;
        final MutableState mutableState1522 = mutableState7;
        State<Dp> m56animateDpAsStateAjpBEmI32 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl, tween$default32, "animationOffset", function122, startRestartGroup, 384, 0);
        State<Float> animateFloatAsState22 = AnimateAsStateKt.animateFloatAsState(ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, null), 0.0f, "alpha", null, startRestartGroup, 3072, 20);
        if (ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(mutableState)) {
        }
        float m2599constructorimpl322 = Dp.m2599constructorimpl(f5);
        TweenSpec tween$default222 = AnimationSpecKt.tween$default(200, i11, EasingKt.getLinearOutSlowInEasing(), 2, null);
        startRestartGroup.startReplaceGroup(1324388334);
        rememberedValue12 = startRestartGroup.rememberedValue();
        if (rememberedValue12 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        State<Dp> m56animateDpAsStateAjpBEmI222 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(m2599constructorimpl322, tween$default222, "contentOffset", (Function1) rememberedValue12, startRestartGroup, 3456, 0);
        ScrollState rememberScrollState22 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
        Modifier.Companion companion322 = Modifier.INSTANCE;
        Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion322, 0.0f, 1, null), m3281getWhite0d7_KjU, null, 2, null);
        startRestartGroup.startReplaceGroup(1324395870);
        rememberedValue13 = startRestartGroup.rememberedValue();
        if (rememberedValue13 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier clip22 = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(m104backgroundbw27NRU$default22, (Function1) rememberedValue13), RectangleShapeKt.getRectangleShape());
        Alignment.Companion companion422 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy42 = BoxKt.maybeCachedBoxMeasurePolicy(companion422.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier52 = ComposedModifierKt.materializeModifier(startRestartGroup, clip22);
        ComposeUiNode.Companion companion522 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor52 = companion522.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy42, companion522.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap52, companion522.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash52 = companion522.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier52, companion522.getSetModifier());
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        Modifier verticalScroll$default22 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion322, 0.0f, 1, null), rememberScrollState22, ShrinkingCheckmarkAnimationView_euL9pac$lambda$4(mutableState1522), null, false, 12, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(companion422.getTopStart(), false);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default22);
        Function0<ComposeUiNode> constructor222 = companion522.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy222, companion522.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion522.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion522.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion522.getSetModifier());
        startRestartGroup.startReplaceGroup(260601200);
        if (function03 == null) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier align32 = boxScopeInstance22.align(companion2, z7 ? companion422.getTopCenter() : companion422.getCenter());
        startRestartGroup.startReplaceGroup(260624728);
        rememberedValue14 = startRestartGroup.rememberedValue();
        if (rememberedValue14 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier alpha22 = AlphaKt.alpha(OffsetKt.m295offsetVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(align32, (Function1) rememberedValue14), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$32(m56animateDpAsStateAjpBEmI222), 1, null), ShrinkingCheckmarkAnimationView_euL9pac$lambda$29(animateFloatAsState22));
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion422.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha22);
        Function0<ComposeUiNode> constructor322 = companion522.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy22, companion522.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap322, companion522.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion522.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier322, companion522.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, m2599constructorimpl222), startRestartGroup, 6);
        content.invoke(startRestartGroup, Integer.valueOf((i9 >> 9) & 14));
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        Modifier align222 = boxScopeInstance22.align(OffsetKt.m295offsetVpY3zN4$default(OffsetKt.m295offsetVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(-ComposeExtensionsKt.pxToDp(rememberScrollState22.getValue(), startRestartGroup, 0)), 1, null), 0.0f, ShrinkingCheckmarkAnimationView_euL9pac$lambda$28(m56animateDpAsStateAjpBEmI32), 1, null), companion422.getCenter());
        startRestartGroup.startReplaceGroup(604044546);
        changedInstance2 = startRestartGroup.changedInstance(markers);
        rememberedValue15 = startRestartGroup.rememberedValue();
        if (changedInstance2) {
        }
        mutableState8 = mutableState2;
        rememberedValue15 = new Function1() { // from class: i2.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
                ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40(LottieClipSpec.Markers.this, mutableState3, mutableState8, mutableState4, (LayoutCoordinates) obj);
                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue15);
        startRestartGroup.endReplaceGroup();
        Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(align222, (Function1) rememberedValue15);
        MeasurePolicy maybeCachedBoxMeasurePolicy322 = BoxKt.maybeCachedBoxMeasurePolicy(companion422.getTopStart(), false);
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned22);
        Function0<ComposeUiNode> constructor422 = companion522.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy322, companion522.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap422, companion522.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = companion522.getSetCompositeKeyHash();
        if (!m1226constructorimpl4.getInserting()) {
        }
        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash422);
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier422, companion522.getSetModifier());
        LottieClipSpec.Markers ShrinkingCheckmarkAnimationView_euL9pac$lambda$922 = ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState8);
        startRestartGroup.startReplaceGroup(260666414);
        changedInstance3 = startRestartGroup.changedInstance(markers422) | startRestartGroup.changedInstance(markers);
        rememberedValue16 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue16 = new Function1() { // from class: i2.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
                ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42 = ShrinkingCheckmarkAnimationViewKt.ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42(LottieClipSpec.Markers.this, markers, mutableState8, (LottieClipSpec) obj);
                return ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue16);
        startRestartGroup.endReplaceGroup();
        LottieView(ShrinkingCheckmarkAnimationView_euL9pac$lambda$922, (Function1) rememberedValue16, startRestartGroup, LottieClipSpec.Markers.$stable, 0);
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function05 = function04;
        j7 = m3281getWhite0d7_KjU;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final boolean ShrinkingCheckmarkAnimationView_euL9pac$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$13(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    private static final int ShrinkingCheckmarkAnimationView_euL9pac$lambda$15(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$16(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$19(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    private static final Offset ShrinkingCheckmarkAnimationView_euL9pac$lambda$21(MutableState<Offset> mutableState) {
        return mutableState.getValue();
    }

    private static final int ShrinkingCheckmarkAnimationView_euL9pac$lambda$24(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$25(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$27$lambda$26(LottieClipSpec.Markers markers, MutableState mutableState, MutableState mutableState2, Dp dp) {
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$2(mutableState2, Intrinsics.areEqual(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState), markers));
        return Unit.INSTANCE;
    }

    private static final float ShrinkingCheckmarkAnimationView_euL9pac$lambda$28(State<Dp> state) {
        return state.getValue().getValue();
    }

    private static final float ShrinkingCheckmarkAnimationView_euL9pac$lambda$29(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$31$lambda$30(MutableState mutableState, Dp dp) {
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$5(mutableState, true);
        return Unit.INSTANCE;
    }

    private static final float ShrinkingCheckmarkAnimationView_euL9pac$lambda$32(State<Dp> state) {
        return state.getValue().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$34$lambda$33(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$13(mutableState, IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    private static final boolean ShrinkingCheckmarkAnimationView_euL9pac$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$39$lambda$37$lambda$36(MutableState mutableState, MutableState mutableState2, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$16(mutableState, (int) Offset.m1338getYimpl(LayoutCoordinatesKt.positionInParent(it)));
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$19(mutableState2, IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$41$lambda$40(LottieClipSpec.Markers markers, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (ShrinkingCheckmarkAnimationView_euL9pac$lambda$21(mutableState) == null || !Intrinsics.areEqual(ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(mutableState2), markers)) {
            mutableState.setValue(Offset.m1328boximpl(LayoutCoordinatesKt.positionInParent(it)));
        }
        ShrinkingCheckmarkAnimationView_euL9pac$lambda$25(mutableState3, IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$45$lambda$44$lambda$43$lambda$42(LottieClipSpec.Markers markers, LottieClipSpec.Markers markers2, MutableState mutableState, LottieClipSpec lottieClipSpec) {
        if (Intrinsics.areEqual(lottieClipSpec, markers)) {
            mutableState.setValue(markers2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShrinkingCheckmarkAnimationView_euL9pac$lambda$46(long j5, boolean z5, Function0 function0, Function2 function2, int i5, int i6, Composer composer, int i7) {
        m3423ShrinkingCheckmarkAnimationVieweuL9pac(j5, z5, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void ShrinkingCheckmarkAnimationView_euL9pac$lambda$5(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    private static final LottieClipSpec.Markers ShrinkingCheckmarkAnimationView_euL9pac$lambda$9(MutableState<LottieClipSpec.Markers> mutableState) {
        return mutableState.getValue();
    }
}
