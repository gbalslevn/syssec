package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8);
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public State<Dp> elevation(InteractionSource interactionSource, Composer composer, int i5) {
        composer.startReplaceGroup(-478475335);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-478475335, i5, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:271)");
        }
        int i6 = i5 & 14;
        int i7 = i6 ^ 6;
        boolean z5 = (i7 > 4 && composer.changed(interactionSource)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
            composer.updateRememberedValue(rememberedValue);
        }
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) rememberedValue;
        boolean changedInstance = composer.changedInstance(floatingActionButtonElevationAnimatable) | ((((i5 & 112) ^ 48) > 32 && composer.changed(this)) || (i5 & 48) == 32);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new DefaultFloatingActionButtonElevation$elevation$1$1(floatingActionButtonElevationAnimatable, this, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.LaunchedEffect(this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, (i5 >> 3) & 14);
        boolean changedInstance2 = composer.changedInstance(floatingActionButtonElevationAnimatable) | ((i7 > 4 && composer.changed(interactionSource)) || (i5 & 6) == 4);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new DefaultFloatingActionButtonElevation$elevation$2$1(interactionSource, floatingActionButtonElevationAnimatable, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer, i6);
        State<Dp> asState = floatingActionButtonElevationAnimatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return asState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultFloatingActionButtonElevation)) {
            return false;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) other;
        if (Dp.m2601equalsimpl0(this.defaultElevation, defaultFloatingActionButtonElevation.defaultElevation) && Dp.m2601equalsimpl0(this.pressedElevation, defaultFloatingActionButtonElevation.pressedElevation) && Dp.m2601equalsimpl0(this.hoveredElevation, defaultFloatingActionButtonElevation.hoveredElevation)) {
            return Dp.m2601equalsimpl0(this.focusedElevation, defaultFloatingActionButtonElevation.focusedElevation);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m2602hashCodeimpl(this.defaultElevation) * 31) + Dp.m2602hashCodeimpl(this.pressedElevation)) * 31) + Dp.m2602hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m2602hashCodeimpl(this.focusedElevation);
    }

    private DefaultFloatingActionButtonElevation(float f5, float f6, float f7, float f8) {
        this.defaultElevation = f5;
        this.pressedElevation = f6;
        this.hoveredElevation = f7;
        this.focusedElevation = f8;
    }
}
