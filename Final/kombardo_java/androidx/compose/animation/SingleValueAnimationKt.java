package androidx.compose.animation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aR\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "targetValue", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", BuildConfig.FLAVOR, "label", "Lkotlin/Function1;", BuildConfig.FLAVOR, "finishedListener", "Landroidx/compose/runtime/State;", "animateColorAsState-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColorAsState", "Landroidx/compose/animation/core/SpringSpec;", "colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SingleValueAnimationKt {
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);

    /* renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final State<Color> m54animateColorAsStateeuL9pac(long j5, AnimationSpec<Color> animationSpec, String str, Function1<? super Color, Unit> function1, Composer composer, int i5, int i6) {
        AnimationSpec<Color> animationSpec2 = (i6 & 2) != 0 ? colorDefaultSpring : animationSpec;
        String str2 = (i6 & 4) != 0 ? "ColorAnimation" : str;
        Function1<? super Color, Unit> function12 = (i6 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451899108, i5, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:61)");
        }
        boolean changed = composer.changed(Color.m1490getColorSpaceimpl(j5));
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m1490getColorSpaceimpl(j5));
            composer.updateRememberedValue(rememberedValue);
        }
        int i7 = i5 << 6;
        State<Color> animateValueAsState = AnimateAsStateKt.animateValueAsState(Color.m1481boximpl(j5), (TwoWayConverter) rememberedValue, animationSpec2, null, str2, function12, composer, (i5 & 14) | ((i5 << 3) & 896) | (57344 & i7) | (i7 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateValueAsState;
    }
}
