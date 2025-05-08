package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/ButtonElevation;", BuildConfig.FLAVOR, "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", BuildConfig.FLAVOR, "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", BuildConfig.FLAVOR, "shadowElevation", "shadowElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ ButtonElevation(float f5, float f6, float f7, float f8, float f9, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, f9);
    }

    private final State<Dp> animateElevation(boolean z5, InteractionSource interactionSource, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1312510462, i5, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:938)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(rememberedValue);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        boolean z6 = true;
        boolean z7 = (((i5 & 112) ^ 48) > 32 && composer.changed(interactionSource)) || (i5 & 48) == 32;
        Object rememberedValue2 = composer.rememberedValue();
        if (z7 || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new ButtonElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, (i5 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f5 = !z5 ? this.disabledElevation : interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction$Enter ? this.hoveredElevation : interaction instanceof FocusInteraction$Focus ? this.focusedElevation : this.defaultElevation;
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Animatable(Dp.m2597boximpl(f5), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        Animatable animatable = (Animatable) rememberedValue3;
        Dp m2597boximpl = Dp.m2597boximpl(f5);
        boolean changedInstance = composer.changedInstance(animatable) | composer.changed(f5) | ((((i5 & 14) ^ 6) > 4 && composer.changed(z5)) || (i5 & 6) == 4);
        if ((((i5 & 896) ^ 384) <= 256 || !composer.changed(this)) && (i5 & 384) != 256) {
            z6 = false;
        }
        boolean changedInstance2 = changedInstance | z6 | composer.changedInstance(interaction);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
            Object buttonElevation$animateElevation$2$1 = new ButtonElevation$animateElevation$2$1(animatable, f5, z5, this, interaction, null);
            composer.updateRememberedValue(buttonElevation$animateElevation$2$1);
            rememberedValue4 = buttonElevation$animateElevation$2$1;
        }
        EffectsKt.LaunchedEffect(m2597boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, composer, 0);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) other;
        return Dp.m2601equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && Dp.m2601equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && Dp.m2601equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && Dp.m2601equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && Dp.m2601equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m2602hashCodeimpl(this.defaultElevation) * 31) + Dp.m2602hashCodeimpl(this.pressedElevation)) * 31) + Dp.m2602hashCodeimpl(this.focusedElevation)) * 31) + Dp.m2602hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m2602hashCodeimpl(this.disabledElevation);
    }

    public final State<Dp> shadowElevation$material3_release(boolean z5, InteractionSource interactionSource, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045116089, i5, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:930)");
        }
        State<Dp> animateElevation = animateElevation(z5, interactionSource, composer, i5 & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateElevation;
    }

    private ButtonElevation(float f5, float f6, float f7, float f8, float f9) {
        this.defaultElevation = f5;
        this.pressedElevation = f6;
        this.focusedElevation = f7;
        this.hoveredElevation = f8;
        this.disabledElevation = f9;
    }
}
