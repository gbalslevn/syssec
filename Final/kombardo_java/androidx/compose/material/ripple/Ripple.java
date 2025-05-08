package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014JF\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007H'ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "bounded", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Ripple implements Indication {
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;

    public /* synthetic */ Ripple(boolean z5, float f5, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z5, f5, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) other;
        return this.bounded == ripple.bounded && Dp.m2601equalsimpl0(this.radius, ripple.radius) && Intrinsics.areEqual(this.color, ripple.color);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.bounded) * 31) + Dp.m2602hashCodeimpl(this.radius)) * 31) + this.color.hashCode();
    }

    @Override // androidx.compose.foundation.Indication
    @Deprecated
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer, int i5) {
        long mo751defaultColorWaAFU9c;
        composer.startReplaceGroup(988743187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(988743187, i5, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.getLocalRippleTheme());
        if (this.color.getValue().getValue() != 16) {
            composer.startReplaceGroup(-303571590);
            composer.endReplaceGroup();
            mo751defaultColorWaAFU9c = this.color.getValue().getValue();
        } else {
            composer.startReplaceGroup(-303521246);
            mo751defaultColorWaAFU9c = rippleTheme.mo751defaultColorWaAFU9c(composer, 0);
            composer.endReplaceGroup();
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(mo751defaultColorWaAFU9c), composer, 0);
        State<RippleAlpha> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(rippleTheme.rippleAlpha(composer, 0), composer, 0);
        int i6 = i5 & 14;
        RippleIndicationInstance mo752rememberUpdatedRippleInstance942rkJo = mo752rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, rememberUpdatedState, rememberUpdatedState2, composer, i6 | ((i5 << 12) & 458752));
        boolean changedInstance = composer.changedInstance(mo752rememberUpdatedRippleInstance942rkJo) | (((i6 ^ 6) > 4 && composer.changed(interactionSource)) || (i5 & 6) == 4);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Ripple$rememberUpdatedInstance$1$1(interactionSource, mo752rememberUpdatedRippleInstance942rkJo, null);
            composer.updateRememberedValue(rememberedValue);
        }
        EffectsKt.LaunchedEffect(mo752rememberUpdatedRippleInstance942rkJo, interactionSource, (Function2) rememberedValue, composer, (i5 << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mo752rememberUpdatedRippleInstance942rkJo;
    }

    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo752rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z5, float f5, State<Color> state, State<RippleAlpha> state2, Composer composer, int i5);

    private Ripple(boolean z5, float f5, State<Color> state) {
        this.bounded = z5;
        this.radius = f5;
        this.color = state;
    }
}
