package com.google.accompanist.placeholder;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class PlaceholderKt$placeholder$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ long $color;
    final /* synthetic */ Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> $contentFadeTransitionSpec;
    final /* synthetic */ PlaceholderHighlight $highlight;
    final /* synthetic */ Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> $placeholderFadeTransitionSpec;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PlaceholderKt$placeholder$4(Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function32, PlaceholderHighlight placeholderHighlight, boolean z5, long j5, Shape shape) {
        super(3);
        this.$placeholderFadeTransitionSpec = function3;
        this.$contentFadeTransitionSpec = function32;
        this.$highlight = placeholderHighlight;
        this.$visible = z5;
        this.$color = j5;
        this.$shape = shape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$4(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    private static final void invoke$lambda$5(MutableState<Float> mutableState, float f5) {
        mutableState.setValue(Float.valueOf(f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i5) {
        MutableState mutableState;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceableGroup(-1214629560);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1214629560, i5, -1, "com.google.accompanist.placeholder.placeholder.<anonymous> (Placeholder.kt:137)");
        }
        composer.startReplaceableGroup(804161266);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Ref();
            composer.updateRememberedValue(rememberedValue);
        }
        final Ref ref = (Ref) rememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804161321);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Ref();
            composer.updateRememberedValue(rememberedValue2);
        }
        final Ref ref2 = (Ref) rememberedValue2;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804161379);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Ref();
            composer.updateRememberedValue(rememberedValue3);
        }
        final Ref ref3 = (Ref) rememberedValue3;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804161492);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        MutableState mutableState2 = (MutableState) rememberedValue4;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804161591);
        boolean z5 = this.$visible;
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new MutableTransitionState(Boolean.valueOf(z5));
            composer.updateRememberedValue(rememberedValue5);
        }
        MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue5;
        composer.endReplaceableGroup();
        mutableTransitionState.setTargetState(Boolean.valueOf(this.$visible));
        Transition updateTransition = TransitionKt.updateTransition(mutableTransitionState, "placeholder_crossfade", composer, MutableTransitionState.$stable | 48, 0);
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = this.$placeholderFadeTransitionSpec;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
        boolean booleanValue = ((Boolean) updateTransition.getCurrentState()).booleanValue();
        composer.startReplaceableGroup(-2085173843);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2085173843, 0, -1, "com.google.accompanist.placeholder.placeholder.<anonymous>.<anonymous> (Placeholder.kt:153)");
        }
        float f5 = booleanValue ? 1.0f : 0.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        Float valueOf = Float.valueOf(f5);
        boolean booleanValue2 = ((Boolean) updateTransition.getTargetState()).booleanValue();
        composer.startReplaceableGroup(-2085173843);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2085173843, 0, -1, "com.google.accompanist.placeholder.placeholder.<anonymous>.<anonymous> (Placeholder.kt:153)");
        }
        float f6 = booleanValue2 ? 1.0f : 0.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        final State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f6), function3.invoke(updateTransition.getSegment(), composer, 0), vectorConverter, "placeholder_fade", composer, 196608);
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = this.$contentFadeTransitionSpec;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
        boolean booleanValue3 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
        composer.startReplaceableGroup(992792551);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(992792551, 0, -1, "com.google.accompanist.placeholder.placeholder.<anonymous>.<anonymous> (Placeholder.kt:158)");
        }
        float f7 = booleanValue3 ? 0.0f : 1.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        Float valueOf2 = Float.valueOf(f7);
        boolean booleanValue4 = ((Boolean) updateTransition.getTargetState()).booleanValue();
        composer.startReplaceableGroup(992792551);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(992792551, 0, -1, "com.google.accompanist.placeholder.placeholder.<anonymous>.<anonymous> (Placeholder.kt:158)");
        }
        float f8 = booleanValue4 ? 0.0f : 1.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f8), function32.invoke(updateTransition.getSegment(), composer, 0), vectorConverter2, "content_fade", composer, 196608);
        PlaceholderHighlight placeholderHighlight = this.$highlight;
        InfiniteRepeatableSpec<Float> animationSpec = placeholderHighlight != null ? placeholderHighlight.getAnimationSpec() : null;
        composer.startReplaceableGroup(804162378);
        if (animationSpec == null || (!this.$visible && invoke$lambda$9(createTransitionAnimation) < 0.01f)) {
            mutableState = mutableState2;
        } else {
            mutableState = mutableState2;
            invoke$lambda$5(mutableState, InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composer, 0, 1), 0.0f, 1.0f, animationSpec, null, composer, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8).getValue().floatValue());
        }
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804162715);
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = AndroidPaint_androidKt.Paint();
            composer.updateRememberedValue(rememberedValue6);
        }
        final Paint paint = (Paint) rememberedValue6;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(804162740);
        boolean changed = composer.changed(this.$color) | composer.changed(this.$shape) | composer.changed(this.$highlight);
        final Shape shape = this.$shape;
        final long j5 = this.$color;
        final PlaceholderHighlight placeholderHighlight2 = this.$highlight;
        Object rememberedValue7 = composer.rememberedValue();
        if (changed || rememberedValue7 == companion.getEmpty()) {
            final MutableState mutableState3 = mutableState;
            rememberedValue7 = DrawModifierKt.drawWithContent(composed, new Function1<ContentDrawScope, Unit>() { // from class: com.google.accompanist.placeholder.PlaceholderKt$placeholder$4$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope drawWithContent) {
                    float invoke$lambda$11;
                    float invoke$lambda$112;
                    float invoke$lambda$9;
                    float invoke$lambda$92;
                    float invoke$lambda$4;
                    float invoke$lambda$93;
                    float invoke$lambda$42;
                    float invoke$lambda$113;
                    Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                    invoke$lambda$11 = PlaceholderKt$placeholder$4.invoke$lambda$11(createTransitionAnimation2);
                    if (0.01f <= invoke$lambda$11 && invoke$lambda$11 <= 0.99f) {
                        Paint paint2 = Paint.this;
                        invoke$lambda$113 = PlaceholderKt$placeholder$4.invoke$lambda$11(createTransitionAnimation2);
                        paint2.setAlpha(invoke$lambda$113);
                        Paint paint3 = Paint.this;
                        Canvas canvas = drawWithContent.getDrawContext().getCanvas();
                        canvas.saveLayer(SizeKt.m1386toRectuvyYCjk(drawWithContent.mo1703getSizeNHjbRc()), paint3);
                        drawWithContent.drawContent();
                        canvas.restore();
                    } else {
                        invoke$lambda$112 = PlaceholderKt$placeholder$4.invoke$lambda$11(createTransitionAnimation2);
                        if (invoke$lambda$112 >= 0.99f) {
                            drawWithContent.drawContent();
                        }
                    }
                    invoke$lambda$9 = PlaceholderKt$placeholder$4.invoke$lambda$9(createTransitionAnimation);
                    if (0.01f <= invoke$lambda$9 && invoke$lambda$9 <= 0.99f) {
                        Paint paint4 = Paint.this;
                        invoke$lambda$93 = PlaceholderKt$placeholder$4.invoke$lambda$9(createTransitionAnimation);
                        paint4.setAlpha(invoke$lambda$93);
                        Paint paint5 = Paint.this;
                        Ref<Outline> ref4 = ref3;
                        Shape shape2 = shape;
                        long j6 = j5;
                        PlaceholderHighlight placeholderHighlight3 = placeholderHighlight2;
                        Ref<LayoutDirection> ref5 = ref2;
                        Ref<Size> ref6 = ref;
                        MutableState<Float> mutableState4 = mutableState3;
                        Canvas canvas2 = drawWithContent.getDrawContext().getCanvas();
                        canvas2.saveLayer(SizeKt.m1386toRectuvyYCjk(drawWithContent.mo1703getSizeNHjbRc()), paint5);
                        invoke$lambda$42 = PlaceholderKt$placeholder$4.invoke$lambda$4(mutableState4);
                        ref4.setValue(PlaceholderKt.m2909access$drawPlaceholderhpmOzss(drawWithContent, shape2, j6, placeholderHighlight3, invoke$lambda$42, ref4.getValue(), ref5.getValue(), ref6.getValue()));
                        canvas2.restore();
                    } else {
                        invoke$lambda$92 = PlaceholderKt$placeholder$4.invoke$lambda$9(createTransitionAnimation);
                        if (invoke$lambda$92 >= 0.99f) {
                            Ref<Outline> ref7 = ref3;
                            Shape shape3 = shape;
                            long j7 = j5;
                            PlaceholderHighlight placeholderHighlight4 = placeholderHighlight2;
                            invoke$lambda$4 = PlaceholderKt$placeholder$4.invoke$lambda$4(mutableState3);
                            ref7.setValue(PlaceholderKt.m2909access$drawPlaceholderhpmOzss(drawWithContent, shape3, j7, placeholderHighlight4, invoke$lambda$4, ref3.getValue(), ref2.getValue(), ref.getValue()));
                        }
                    }
                    ref.setValue(Size.m1370boximpl(drawWithContent.mo1703getSizeNHjbRc()));
                    ref2.setValue(drawWithContent.getLayoutDirection());
                }
            });
            composer.updateRememberedValue(rememberedValue7);
        }
        Modifier modifier = (Modifier) rememberedValue7;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier;
    }
}
