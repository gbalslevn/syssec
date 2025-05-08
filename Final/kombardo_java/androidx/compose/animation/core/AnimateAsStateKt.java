package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aY\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aR\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0001\u001a\u00020\r2\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u007f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0013*\u00020\u00122\u0006\u0010\u0001\u001a\u00028\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00142\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a\"\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001a\"\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001a\"\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001a\"\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001a\"\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*²\u0006*\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0013*\u00020\u00128\nX\u008a\u0084\u0002²\u0006\"\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0013*\u00020\u00128\nX\u008a\u0084\u0002"}, d2 = {BuildConfig.FLAVOR, "targetValue", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "visibilityThreshold", BuildConfig.FLAVOR, "label", "Lkotlin/Function1;", BuildConfig.FLAVOR, "finishedListener", "Landroidx/compose/runtime/State;", "animateFloatAsState", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "animateValueAsState", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/SpringSpec;", "defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "dpDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "rectDefaultSpring", BuildConfig.FLAVOR, "intDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "intSizeDefaultSpring", "listener", "animSpec", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m2597boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m1370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m1328boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m2632boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 3, null);

    /* renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State<Dp> m56animateDpAsStateAjpBEmI(float f5, AnimationSpec<Dp> animationSpec, String str, Function1<? super Dp, Unit> function1, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i6 & 4) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        if ((i6 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Dp, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, i5, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:113)");
        }
        int i7 = i5 << 6;
        State<Dp> animateValueAsState = animateValueAsState(Dp.m2597boximpl(f5), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec2, null, str2, function12, composer, (i5 & 14) | ((i5 << 3) & 896) | (57344 & i7) | (i7 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateValueAsState;
    }

    public static final State<Float> animateFloatAsState(float f5, AnimationSpec<Float> animationSpec, float f6, String str, Function1<? super Float, Unit> function1, Composer composer, int i5, int i6) {
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3 = (i6 & 2) != 0 ? defaultAnimation : animationSpec;
        float f7 = (i6 & 4) != 0 ? 0.01f : f6;
        String str2 = (i6 & 8) != 0 ? "FloatAnimation" : str;
        Function1<? super Float, Unit> function12 = (i6 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, i5, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:68)");
        }
        if (animationSpec3 == defaultAnimation) {
            composer.startReplaceGroup(1125598679);
            boolean z5 = (((i5 & 896) ^ 384) > 256 && composer.changed(f7)) || (i5 & 384) == 256;
            Object rememberedValue = composer.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(f7), 3, null);
                composer.updateRememberedValue(rememberedValue);
            }
            animationSpec2 = (SpringSpec) rememberedValue;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1125708605);
            composer.endReplaceGroup();
            animationSpec2 = animationSpec3;
        }
        int i7 = i5 << 3;
        State<Float> animateValueAsState = animateValueAsState(Float.valueOf(f5), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec2, Float.valueOf(f7), str2, function12, composer, (i5 & 14) | (i7 & 7168) | (57344 & i7) | (i7 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T t5, TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec, T t6, String str, Function1<? super T, Unit> function1, Composer composer, int i5, int i6) {
        AnimationSpec<T> animationSpec2;
        if ((i6 & 4) != 0) {
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                composer.updateRememberedValue(rememberedValue);
            }
            animationSpec2 = (SpringSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        T t7 = (i6 & 8) != 0 ? null : t6;
        String str2 = (i6 & 16) != 0 ? "ValueAnimation" : str;
        Function1<? super T, Unit> function12 = (i6 & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, i5, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:397)");
        }
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableState mutableState = (MutableState) rememberedValue2;
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Animatable(t5, twoWayConverter, t7, str2);
            composer.updateRememberedValue(rememberedValue3);
        }
        Animatable animatable = (Animatable) rememberedValue3;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer, (i5 >> 15) & 14);
        if (t7 != null && (animationSpec2 instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) animationSpec2;
            if (!Intrinsics.areEqual(springSpec.getVisibilityThreshold(), t7)) {
                animationSpec2 = AnimationSpecKt.spring(springSpec.getDampingRatio(), springSpec.getStiffness(), t7);
            }
        }
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(animationSpec2, composer, 0);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        final Channel channel = (Channel) rememberedValue4;
        boolean changedInstance = ((((i5 & 14) ^ 6) > 4 && composer.changedInstance(t5)) || (i5 & 6) == 4) | composer.changedInstance(channel);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance || rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    channel.mo3767trySendJP2dKIU(t5);
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        EffectsKt.SideEffect((Function0) rememberedValue5, composer, 0);
        boolean changedInstance2 = composer.changedInstance(channel) | composer.changedInstance(animatable) | composer.changed(rememberUpdatedState2) | composer.changed(rememberUpdatedState);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new AnimateAsStateKt$animateValueAsState$3$1(channel, animatable, rememberUpdatedState2, rememberUpdatedState, null);
            composer.updateRememberedValue(rememberedValue6);
        }
        EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, composer, 0);
        State<T> state = (State) mutableState.getValue();
        if (state == null) {
            state = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> state) {
        return state.getValue();
    }
}
