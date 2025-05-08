package dk.molslinjen.ui.views.reusable.modifiers;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¨\u0006\u000e"}, d2 = {"clickableWithScaleAnimation", "Landroidx/compose/ui/Modifier;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scale", "Landroidx/compose/animation/core/Animatable;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector1D;", "animationDuration", BuildConfig.FLAVOR, "scaleDownTo", "onClick", "Lkotlin/Function0;", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AnimatedClickableKt {
    public static final Modifier clickableWithScaleAnimation(Modifier modifier, final CoroutineScope coroutineScope, final Animatable<Float, AnimationVector1D> scale, final int i5, final float f5, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ClickableKt.m122clickableXHw0xAI$default(ScaleKt.scale(modifier, scale.getValue().floatValue()), false, null, null, new Function0() { // from class: j2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit clickableWithScaleAnimation$lambda$0;
                clickableWithScaleAnimation$lambda$0 = AnimatedClickableKt.clickableWithScaleAnimation$lambda$0(CoroutineScope.this, scale, f5, i5, onClick);
                return clickableWithScaleAnimation$lambda$0;
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickableWithScaleAnimation$lambda$0(CoroutineScope coroutineScope, Animatable animatable, float f5, int i5, Function0 function0) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnimatedClickableKt$clickableWithScaleAnimation$1$1(animatable, f5, i5, function0, null), 3, null);
        return Unit.INSTANCE;
    }
}
