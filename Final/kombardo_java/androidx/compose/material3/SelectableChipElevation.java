package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b!\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$²\u0006\u0010\u0010#\u001a\u0004\u0018\u00010\"8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material3/SelectableChipElevation;", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Dp;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "<init>", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/runtime/State;", "animateElevation", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "shadowElevation$material3_release", "shadowElevation", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "F", "getElevation-D9Ej5fM", "()F", "getPressedElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getDraggedElevation-D9Ej5fM", "getDisabledElevation-D9Ej5fM", "Landroidx/compose/foundation/interaction/Interaction;", "lastInteraction", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableChipElevation {
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ SelectableChipElevation(float f5, float f6, float f7, float f8, float f9, float f10, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, f9, f10);
    }

    private final State<Dp> animateElevation(boolean z5, InteractionSource interactionSource, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(664514136, i5, -1, "androidx.compose.material3.SelectableChipElevation.animateElevation (Chip.kt:2318)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(rememberedValue);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableState mutableState = (MutableState) rememberedValue2;
        boolean z6 = true;
        boolean z7 = (((i5 & 112) ^ 48) > 32 && composer.changed(interactionSource)) || (i5 & 48) == 32;
        Object rememberedValue3 = composer.rememberedValue();
        if (z7 || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new SelectableChipElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, composer, (i5 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        float f5 = !z5 ? this.disabledElevation : interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction$Enter ? this.hoveredElevation : interaction instanceof FocusInteraction$Focus ? this.focusedElevation : interaction instanceof DragInteraction$Start ? this.draggedElevation : this.elevation;
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Animatable(Dp.m2597boximpl(f5), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        Animatable animatable = (Animatable) rememberedValue4;
        Dp m2597boximpl = Dp.m2597boximpl(f5);
        boolean changedInstance = composer.changedInstance(animatable) | composer.changed(f5);
        if ((((i5 & 14) ^ 6) <= 4 || !composer.changed(z5)) && (i5 & 6) != 4) {
            z6 = false;
        }
        boolean changedInstance2 = changedInstance | z6 | composer.changedInstance(interaction);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
            Object selectableChipElevation$animateElevation$2$1 = new SelectableChipElevation$animateElevation$2$1(animatable, f5, z5, interaction, mutableState, null);
            composer.updateRememberedValue(selectableChipElevation$animateElevation$2$1);
            rememberedValue5 = selectableChipElevation$animateElevation$2$1;
        }
        EffectsKt.LaunchedEffect(m2597boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, composer, 0);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Interaction animateElevation$lambda$2(MutableState<Interaction> mutableState) {
        return mutableState.getValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SelectableChipElevation)) {
            return false;
        }
        SelectableChipElevation selectableChipElevation = (SelectableChipElevation) other;
        return Dp.m2601equalsimpl0(this.elevation, selectableChipElevation.elevation) && Dp.m2601equalsimpl0(this.pressedElevation, selectableChipElevation.pressedElevation) && Dp.m2601equalsimpl0(this.focusedElevation, selectableChipElevation.focusedElevation) && Dp.m2601equalsimpl0(this.hoveredElevation, selectableChipElevation.hoveredElevation) && Dp.m2601equalsimpl0(this.disabledElevation, selectableChipElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m2602hashCodeimpl(this.elevation) * 31) + Dp.m2602hashCodeimpl(this.pressedElevation)) * 31) + Dp.m2602hashCodeimpl(this.focusedElevation)) * 31) + Dp.m2602hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m2602hashCodeimpl(this.disabledElevation);
    }

    public final State<Dp> shadowElevation$material3_release(boolean z5, InteractionSource interactionSource, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1888175651, i5, -1, "androidx.compose.material3.SelectableChipElevation.shadowElevation (Chip.kt:2310)");
        }
        State<Dp> animateElevation = animateElevation(z5, interactionSource, composer, i5 & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateElevation;
    }

    private SelectableChipElevation(float f5, float f6, float f7, float f8, float f9, float f10) {
        this.elevation = f5;
        this.pressedElevation = f6;
        this.focusedElevation = f7;
        this.hoveredElevation = f8;
        this.draggedElevation = f9;
        this.disabledElevation = f10;
    }
}
