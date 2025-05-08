package androidx.compose.animation;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\u000f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a6\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a6\u0010\u001d\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aI\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b#\u0010$\u001aI\u0010'\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b'\u0010(\u001aI\u0010,\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010\u001f\u001a\u00020)2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b,\u0010-\u001aI\u00100\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010\u001f\u001a\u00020.2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b0\u00101\u001aI\u00103\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010%\u001a\u00020)2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b3\u00104\u001aI\u00106\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010%\u001a\u00020.2\b\b\u0002\u0010!\u001a\u00020 2\u0014\b\u0002\u00105\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b6\u00107\u001a5\u00109\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b9\u0010\u0010\u001a5\u0010;\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b;\u0010\u0010\u001a5\u0010=\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b=\u0010\u0013\u001a5\u0010?\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0\fH\u0007¢\u0006\u0004\b?\u0010\u0013\u001a\u0013\u0010@\u001a\u00020\u001e*\u00020)H\u0002¢\u0006\u0004\b@\u0010A\u001a\u0013\u0010@\u001a\u00020\u001e*\u00020.H\u0002¢\u0006\u0004\b@\u0010B\u001aA\u0010L\u001a\u00020K*\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\b2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020 0G2\u0006\u0010J\u001a\u00020IH\u0001¢\u0006\u0004\bL\u0010M\u001a!\u0010N\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010E\u001a\u00020\u0004H\u0001¢\u0006\u0004\bN\u0010O\u001a!\u0010P\u001a\u00020\b*\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010F\u001a\u00020\bH\u0001¢\u0006\u0004\bP\u0010Q\u001a1\u0010S\u001a\u00020R*\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\b2\u0006\u0010J\u001a\u00020IH\u0003¢\u0006\u0004\bS\u0010T\" \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X\"\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00010Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[\"\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010[\"\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\r0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010[\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006`²\u0006\u000e\u0010^\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010_\u001a\u00020\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/core/FiniteAnimationSpec;", BuildConfig.FLAVOR, "animationSpec", "initialAlpha", "Landroidx/compose/animation/EnterTransition;", "fadeIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/EnterTransition;", "targetAlpha", "Landroidx/compose/animation/ExitTransition;", "fadeOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "initialOffset", "slideIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "targetOffset", "slideOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "initialScale", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleIn", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "scaleOut", "Landroidx/compose/ui/Alignment;", "expandFrom", BuildConfig.FLAVOR, "clip", "initialSize", "expandIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "shrinkTowards", "targetSize", "shrinkOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/Alignment$Horizontal;", BuildConfig.FLAVOR, "initialWidth", "expandHorizontally", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Horizontal;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "expandVertically", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Vertical;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "targetWidth", "shrinkHorizontally", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Horizontal;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "targetHeight", "shrinkVertically", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Vertical;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "initialOffsetX", "slideInHorizontally", "initialOffsetY", "slideInVertically", "targetOffsetX", "slideOutHorizontally", "targetOffsetY", "slideOutVertically", "toAlignment", "(Landroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/ui/Alignment;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "Lkotlin/Function0;", "isEnabled", BuildConfig.FLAVOR, "label", "Landroidx/compose/ui/Modifier;", "createModifier", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createGraphicsLayerBlock", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/SpringSpec;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "activeEnter", "activeExit", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m32invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m32invoke__ExYCQ(long j5) {
            return new AnimationVector2D(TransformOrigin.m1630getPivotFractionXimpl(j5), TransformOrigin.m1631getPivotFractionYimpl(j5));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m1626boximpl(m33invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m33invokeLIALnN8(AnimationVector2D animationVector2D) {
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m2632boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0119, code lost:
    
        if (r24.changed(r21) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0134, code lost:
    
        if (r24.changed(r22) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0153, code lost:
    
        if (r24.changed(r20) == false) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(final Transition<EnterExitState> transition, final EnterTransition enterTransition, final ExitTransition exitTransition, String str, Composer composer, int i5) {
        final Transition.DeferredAnimation deferredAnimation;
        final Transition.DeferredAnimation deferredAnimation2;
        boolean z5;
        boolean z6;
        boolean changedInstance;
        Object rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642253525, i5, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:958)");
        }
        boolean z7 = true;
        boolean z8 = (enterTransition.getData().getFade() == null && exitTransition.getData().getFade() == null) ? false : true;
        boolean z9 = (enterTransition.getData().getScale() == null && exitTransition.getData().getScale() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimation3 = null;
        if (z8) {
            composer.startReplaceGroup(-675389204);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = str + " alpha";
                composer.updateRememberedValue(rememberedValue2);
            }
            Transition.DeferredAnimation createDeferredAnimation = TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue2, composer, (i5 & 14) | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        } else {
            composer.startReplaceGroup(-675252433);
            composer.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z9) {
            composer.startReplaceGroup(-675193780);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = str + " scale";
                composer.updateRememberedValue(rememberedValue3);
            }
            Transition.DeferredAnimation createDeferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue3, composer, (i5 & 14) | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-675057009);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z9) {
            composer.startReplaceGroup(-674987940);
            deferredAnimation3 = TransitionKt.createDeferredAnimation(transition, TransformOriginVectorConverter, "TransformOriginInterruptionHandling", composer, (i5 & 14) | 384, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-674835793);
            composer.endReplaceGroup();
        }
        boolean changedInstance2 = composer.changedInstance(deferredAnimation);
        if (((i5 & 112) ^ 48) <= 32) {
        }
        if ((i5 & 48) != 32) {
            z5 = false;
            boolean z10 = changedInstance2 | z5;
            if (((i5 & 896) ^ 384) <= 256) {
            }
            if ((i5 & 384) != 256) {
                z6 = false;
                boolean changedInstance3 = z10 | z6 | composer.changedInstance(deferredAnimation2);
                if (((i5 & 14) ^ 6) <= 4) {
                }
                if ((i5 & 6) != 4) {
                    z7 = false;
                }
                changedInstance = changedInstance3 | z7 | composer.changedInstance(deferredAnimation3);
                rememberedValue = composer.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Transition.DeferredAnimation deferredAnimation4 = deferredAnimation3;
                    rememberedValue = new GraphicsLayerBlockForEnterExit() { // from class: d.a
                        @Override // androidx.compose.animation.GraphicsLayerBlockForEnterExit
                        public final Function1 init() {
                            Function1 createGraphicsLayerBlock$lambda$13$lambda$12;
                            createGraphicsLayerBlock$lambda$13$lambda$12 = EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation.this, deferredAnimation2, transition, enterTransition, exitTransition, deferredAnimation4);
                            return createGraphicsLayerBlock$lambda$13$lambda$12;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit = (GraphicsLayerBlockForEnterExit) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return graphicsLayerBlockForEnterExit;
            }
            z6 = true;
            boolean changedInstance32 = z10 | z6 | composer.changedInstance(deferredAnimation2);
            if (((i5 & 14) ^ 6) <= 4) {
            }
            if ((i5 & 6) != 4) {
            }
            changedInstance = changedInstance32 | z7 | composer.changedInstance(deferredAnimation3);
            rememberedValue = composer.rememberedValue();
            if (!changedInstance) {
            }
            final Transition.DeferredAnimation deferredAnimation42 = deferredAnimation3;
            rememberedValue = new GraphicsLayerBlockForEnterExit() { // from class: d.a
                @Override // androidx.compose.animation.GraphicsLayerBlockForEnterExit
                public final Function1 init() {
                    Function1 createGraphicsLayerBlock$lambda$13$lambda$12;
                    createGraphicsLayerBlock$lambda$13$lambda$12 = EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation.this, deferredAnimation2, transition, enterTransition, exitTransition, deferredAnimation42);
                    return createGraphicsLayerBlock$lambda$13$lambda$12;
                }
            };
            composer.updateRememberedValue(rememberedValue);
            GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit2 = (GraphicsLayerBlockForEnterExit) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return graphicsLayerBlockForEnterExit2;
        }
        z5 = true;
        boolean z102 = changedInstance2 | z5;
        if (((i5 & 896) ^ 384) <= 256) {
        }
        if ((i5 & 384) != 256) {
        }
        z6 = true;
        boolean changedInstance322 = z102 | z6 | composer.changedInstance(deferredAnimation2);
        if (((i5 & 14) ^ 6) <= 4) {
        }
        if ((i5 & 6) != 4) {
        }
        changedInstance = changedInstance322 | z7 | composer.changedInstance(deferredAnimation3);
        rememberedValue = composer.rememberedValue();
        if (!changedInstance) {
        }
        final Transition.DeferredAnimation deferredAnimation422 = deferredAnimation3;
        rememberedValue = new GraphicsLayerBlockForEnterExit() { // from class: d.a
            @Override // androidx.compose.animation.GraphicsLayerBlockForEnterExit
            public final Function1 init() {
                Function1 createGraphicsLayerBlock$lambda$13$lambda$12;
                createGraphicsLayerBlock$lambda$13$lambda$12 = EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation.this, deferredAnimation2, transition, enterTransition, exitTransition, deferredAnimation422);
                return createGraphicsLayerBlock$lambda$13$lambda$12;
            }
        };
        composer.updateRememberedValue(rememberedValue);
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit22 = (GraphicsLayerBlockForEnterExit) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return graphicsLayerBlockForEnterExit22;
    }

    public static final Function1 createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition transition, final EnterTransition enterTransition, final ExitTransition exitTransition, Transition.DeferredAnimation deferredAnimation3) {
        final TransformOrigin m1626boximpl;
        final State animate = deferredAnimation != null ? deferredAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                    Fade fade = EnterTransition.this.getData().getFade();
                    if (fade != null && (animationSpec2 = fade.getAnimationSpec()) != null) {
                        return animationSpec2;
                    }
                    springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec3;
                }
                if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    Fade fade2 = exitTransition.getData().getFade();
                    if (fade2 != null && (animationSpec = fade2.getAnimationSpec()) != null) {
                        return animationSpec;
                    }
                    springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec2;
                }
                springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                return springSpec;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f5 = 1.0f;
                if (i5 != 1) {
                    if (i5 == 2) {
                        Fade fade = EnterTransition.this.getData().getFade();
                        if (fade != null) {
                            f5 = fade.getAlpha();
                        }
                    } else {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Fade fade2 = exitTransition.getData().getFade();
                        if (fade2 != null) {
                            f5 = fade2.getAlpha();
                        }
                    }
                }
                return Float.valueOf(f5);
            }
        }) : null;
        final State animate2 = deferredAnimation2 != null ? deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                    Scale scale = EnterTransition.this.getData().getScale();
                    if (scale != null && (animationSpec2 = scale.getAnimationSpec()) != null) {
                        return animationSpec2;
                    }
                    springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec3;
                }
                if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    Scale scale2 = exitTransition.getData().getScale();
                    if (scale2 != null && (animationSpec = scale2.getAnimationSpec()) != null) {
                        return animationSpec;
                    }
                    springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec2;
                }
                springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                return springSpec;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f5 = 1.0f;
                if (i5 != 1) {
                    if (i5 == 2) {
                        Scale scale = EnterTransition.this.getData().getScale();
                        if (scale != null) {
                            f5 = scale.getScale();
                        }
                    } else {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Scale scale2 = exitTransition.getData().getScale();
                        if (scale2 != null) {
                            f5 = scale2.getScale();
                        }
                    }
                }
                return Float.valueOf(f5);
            }
        }) : null;
        if (transition.getCurrentState() == EnterExitState.PreEnter) {
            Scale scale = enterTransition.getData().getScale();
            if (scale != null || (scale = exitTransition.getData().getScale()) != null) {
                m1626boximpl = TransformOrigin.m1626boximpl(scale.getTransformOrigin());
            }
            m1626boximpl = null;
        } else {
            Scale scale2 = exitTransition.getData().getScale();
            if (scale2 != null || (scale2 = enterTransition.getData().getScale()) != null) {
                m1626boximpl = TransformOrigin.m1626boximpl(scale2.getTransformOrigin());
            }
            m1626boximpl = null;
        }
        final State animate3 = deferredAnimation3 != null ? deferredAnimation3.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment) {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        }, new Function1<EnterExitState, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TransformOrigin invoke(EnterExitState enterExitState) {
                return TransformOrigin.m1626boximpl(m34invokeLIALnN8(enterExitState));
            }

            /* renamed from: invoke-LIALnN8, reason: not valid java name */
            public final long m34invokeLIALnN8(EnterExitState enterExitState) {
                TransformOrigin transformOrigin;
                int i5 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                if (i5 != 1) {
                    transformOrigin = null;
                    if (i5 == 2) {
                        Scale scale3 = enterTransition.getData().getScale();
                        if (scale3 != null || (scale3 = exitTransition.getData().getScale()) != null) {
                            transformOrigin = TransformOrigin.m1626boximpl(scale3.getTransformOrigin());
                        }
                    } else {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Scale scale4 = exitTransition.getData().getScale();
                        if (scale4 != null || (scale4 = enterTransition.getData().getScale()) != null) {
                            transformOrigin = TransformOrigin.m1626boximpl(scale4.getTransformOrigin());
                        }
                    }
                } else {
                    transformOrigin = TransformOrigin.this;
                }
                return transformOrigin != null ? transformOrigin.getPackedValue() : TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
            }
        }) : null;
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                State<Float> state = animate;
                graphicsLayerScope.setAlpha(state != null ? state.getValue().floatValue() : 1.0f);
                State<Float> state2 = animate2;
                graphicsLayerScope.setScaleX(state2 != null ? state2.getValue().floatValue() : 1.0f);
                State<Float> state3 = animate2;
                graphicsLayerScope.setScaleY(state3 != null ? state3.getValue().floatValue() : 1.0f);
                State<TransformOrigin> state4 = animate3;
                graphicsLayerScope.mo1530setTransformOrigin__ExYCQ(state4 != null ? state4.getValue().getPackedValue() : TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ());
            }
        };
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, String str, Composer composer, int i5, int i6) {
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        ChangeSize changeSize;
        final Function0<Boolean> function02 = (i6 & 4) != 0 ? new Function0<Boolean>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        } : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(28261782, i5, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:869)");
        }
        int i7 = i5 & 14;
        EnterTransition trackActiveEnter = trackActiveEnter(transition, enterTransition, composer, i5 & 126);
        int i8 = i5 >> 3;
        ExitTransition trackActiveExit = trackActiveExit(transition, exitTransition, composer, (i8 & 112) | i7);
        boolean z5 = true;
        boolean z6 = (trackActiveEnter.getData().getSlide() == null && trackActiveExit.getData().getSlide() == null) ? false : true;
        boolean z7 = (trackActiveEnter.getData().getChangeSize() == null && trackActiveExit.getData().getChangeSize() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimation3 = null;
        if (z6) {
            composer.startReplaceGroup(-821375963);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = str + " slide";
                composer.updateRememberedValue(rememberedValue);
            }
            Transition.DeferredAnimation createDeferredAnimation = TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue, composer, i7 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        } else {
            composer.startReplaceGroup(-821278096);
            composer.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z7) {
            composer.startReplaceGroup(-821202177);
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = str + " shrink/expand";
                composer.updateRememberedValue(rememberedValue2);
            }
            Transition.DeferredAnimation createDeferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer, i7 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-821099041);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z7) {
            composer.startReplaceGroup(-821034002);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = str + " InterruptionHandlingOffset";
                composer.updateRememberedValue(rememberedValue3);
            }
            Transition.DeferredAnimation createDeferredAnimation3 = TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) rememberedValue3, composer, i7 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation3 = createDeferredAnimation3;
        } else {
            composer.startReplaceGroup(-820883777);
            composer.endReplaceGroup();
        }
        ChangeSize changeSize2 = trackActiveEnter.getData().getChangeSize();
        final boolean z8 = ((changeSize2 == null || changeSize2.getClip()) && ((changeSize = trackActiveExit.getData().getChangeSize()) == null || changeSize.getClip()) && z7) ? false : true;
        GraphicsLayerBlockForEnterExit createGraphicsLayerBlock = createGraphicsLayerBlock(transition, trackActiveEnter, trackActiveExit, str, composer, i7 | (i8 & 7168));
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean changed = composer.changed(z8);
        if ((((i5 & 7168) ^ 3072) <= 2048 || !composer.changed(function02)) && (i5 & 3072) != 2048) {
            z5 = false;
        }
        boolean z9 = changed | z5;
        Object rememberedValue4 = composer.rememberedValue();
        if (z9 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.setClip(!z8 && function02.invoke().booleanValue());
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        Modifier then = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, trackActiveEnter, trackActiveExit, function02, createGraphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return then;
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z5, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z5, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m2656boximpl(m35invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m35invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(function1.invoke(Integer.valueOf(IntSize.m2661getWidthimpl(j5))).intValue(), IntSize.m2660getHeightimpl(j5));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z5, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z5, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z5), null, false, null, 59, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m2656boximpl(m36invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m36invokemzRDjE0(long j5) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z5, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z5, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z5, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m2656boximpl(m37invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m37invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(IntSize.m2661getWidthimpl(j5), function1.invoke(Integer.valueOf(IntSize.m2660getHeightimpl(j5))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z5, function1);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f5) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f5, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i5 & 2) != 0) {
            f5 = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f5);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f5) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f5, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i5 & 2) != 0) {
            f5 = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f5);
    }

    /* renamed from: scaleIn-L8ZKh-E */
    public static final EnterTransition m28scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f5, long j5) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f5, j5, finiteAnimationSpec, null), false, null, 55, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default */
    public static /* synthetic */ EnterTransition m29scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f5, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i5 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            j5 = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        }
        return m28scaleInL8ZKhE(finiteAnimationSpec, f5, j5);
    }

    /* renamed from: scaleOut-L8ZKh-E */
    public static final ExitTransition m30scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f5, long j5) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f5, j5, finiteAnimationSpec, null), false, null, 55, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default */
    public static /* synthetic */ ExitTransition m31scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f5, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i5 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            j5 = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        }
        return m30scaleOutL8ZKhE(finiteAnimationSpec, f5, j5);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z5, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z5, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m2656boximpl(m38invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m38invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(function1.invoke(Integer.valueOf(IntSize.m2661getWidthimpl(j5))).intValue(), IntSize.m2660getHeightimpl(j5));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z5, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z5, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z5), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m2656boximpl(m39invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m39invokemzRDjE0(long j5) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z5, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z5, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z5, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m2656boximpl(m40invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m40invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(IntSize.m2661getWidthimpl(j5), function1.invoke(Integer.valueOf(IntSize.m2660getHeightimpl(j5))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z5, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2632boximpl(m41invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m41invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m2661getWidthimpl(j5))).intValue(), 0);
            }
        });
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2632boximpl(m42invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m42invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(0, function1.invoke(Integer.valueOf(IntSize.m2660getHeightimpl(j5))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m2632boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2632boximpl(m43invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m43invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m2661getWidthimpl(j5))).intValue(), 0);
            }
        });
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2632boximpl(m44invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m44invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(0, function1.invoke(Integer.valueOf(IntSize.m2660getHeightimpl(j5))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m2632boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i5 & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return Intrinsics.areEqual(horizontal, companion.getStart()) ? companion.getCenterStart() : Intrinsics.areEqual(horizontal, companion.getEnd()) ? companion.getCenterEnd() : companion.getCenter();
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i5, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:910)");
        }
        boolean z5 = (((i5 & 14) ^ 6) > 4 && composer.changed(transition)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(enterTransition);
            } else {
                mutableState.setValue(EnterTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            mutableState.setValue(trackActiveEnter$lambda$5(mutableState).plus(enterTransition));
        }
        EnterTransition trackActiveEnter$lambda$5 = trackActiveEnter$lambda$5(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return trackActiveEnter$lambda$5;
    }

    private static final EnterTransition trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState) {
        return mutableState.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i5, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:930)");
        }
        boolean z5 = (((i5 & 14) ^ 6) > 4 && composer.changed(transition)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(exitTransition);
            } else {
                mutableState.setValue(ExitTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            mutableState.setValue(trackActiveExit$lambda$8(mutableState).plus(exitTransition));
        }
        ExitTransition trackActiveExit$lambda$8 = trackActiveExit$lambda$8(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return trackActiveExit$lambda$8;
    }

    private static final ExitTransition trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState) {
        return mutableState.getValue();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return Intrinsics.areEqual(vertical, companion.getTop()) ? companion.getTopCenter() : Intrinsics.areEqual(vertical, companion.getBottom()) ? companion.getBottomCenter() : companion.getCenter();
    }
}
