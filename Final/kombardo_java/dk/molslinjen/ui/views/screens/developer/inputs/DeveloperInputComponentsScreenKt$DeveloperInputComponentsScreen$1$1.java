package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.material3.ChipKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1 implements Function3<FlowRowScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<InputType> $typeToShow$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1(MutableState<InputType> mutableState) {
        this.$typeToShow$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        mutableState.setValue(InputType.Buttons);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState mutableState) {
        mutableState.setValue(InputType.TextField);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(MutableState mutableState) {
        mutableState.setValue(InputType.TickersAndCheckboxes);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(MutableState mutableState) {
        mutableState.setValue(InputType.PhoneNumbers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8(MutableState mutableState) {
        mutableState.setValue(InputType.Others);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
        invoke(flowRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FlowRowScope FlowRow, Composer composer, int i5) {
        InputType DeveloperInputComponentsScreen$lambda$1;
        InputType DeveloperInputComponentsScreen$lambda$12;
        InputType DeveloperInputComponentsScreen$lambda$13;
        InputType DeveloperInputComponentsScreen$lambda$14;
        InputType DeveloperInputComponentsScreen$lambda$15;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885332767, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsScreen.<anonymous>.<anonymous> (DeveloperInputComponentsScreen.kt:44)");
        }
        DeveloperInputComponentsScreen$lambda$1 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$1(this.$typeToShow$delegate);
        boolean z5 = DeveloperInputComponentsScreen$lambda$1 == InputType.Buttons;
        composer.startReplaceGroup(-543344642);
        final MutableState<InputType> mutableState = this.$typeToShow$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ComposableSingletons$DeveloperInputComponentsScreenKt composableSingletons$DeveloperInputComponentsScreenKt = ComposableSingletons$DeveloperInputComponentsScreenKt.INSTANCE;
        ChipKt.InputChip(z5, (Function0) rememberedValue, composableSingletons$DeveloperInputComponentsScreenKt.m3494getLambda1$app_kombardoProd(), null, false, null, null, null, null, null, null, null, null, composer, 432, 0, 8184);
        DeveloperInputComponentsScreen$lambda$12 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$1(this.$typeToShow$delegate);
        boolean z6 = DeveloperInputComponentsScreen$lambda$12 == InputType.TextField;
        composer.startReplaceGroup(-543338080);
        final MutableState<InputType> mutableState2 = this.$typeToShow$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.A
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1.invoke$lambda$3$lambda$2(MutableState.this);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        ChipKt.InputChip(z6, (Function0) rememberedValue2, composableSingletons$DeveloperInputComponentsScreenKt.m3495getLambda2$app_kombardoProd(), null, false, null, null, null, null, null, null, null, null, composer, 432, 0, 8184);
        DeveloperInputComponentsScreen$lambda$13 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$1(this.$typeToShow$delegate);
        boolean z7 = DeveloperInputComponentsScreen$lambda$13 == InputType.TickersAndCheckboxes;
        composer.startReplaceGroup(-543331029);
        final MutableState<InputType> mutableState3 = this.$typeToShow$delegate;
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.B
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1.invoke$lambda$5$lambda$4(MutableState.this);
                    return invoke$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        ChipKt.InputChip(z7, (Function0) rememberedValue3, composableSingletons$DeveloperInputComponentsScreenKt.m3496getLambda3$app_kombardoProd(), null, false, null, null, null, null, null, null, null, null, composer, 432, 0, 8184);
        DeveloperInputComponentsScreen$lambda$14 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$1(this.$typeToShow$delegate);
        boolean z8 = DeveloperInputComponentsScreen$lambda$14 == InputType.PhoneNumbers;
        composer.startReplaceGroup(-543323613);
        final MutableState<InputType> mutableState4 = this.$typeToShow$delegate;
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.C
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6;
                    invoke$lambda$7$lambda$6 = DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1.invoke$lambda$7$lambda$6(MutableState.this);
                    return invoke$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        ChipKt.InputChip(z8, (Function0) rememberedValue4, composableSingletons$DeveloperInputComponentsScreenKt.m3497getLambda4$app_kombardoProd(), null, false, null, null, null, null, null, null, null, null, composer, 432, 0, 8184);
        DeveloperInputComponentsScreen$lambda$15 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$1(this.$typeToShow$delegate);
        boolean z9 = DeveloperInputComponentsScreen$lambda$15 == InputType.Others;
        composer.startReplaceGroup(-543317059);
        final MutableState<InputType> mutableState5 = this.$typeToShow$delegate;
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.D
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8;
                    invoke$lambda$9$lambda$8 = DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1.invoke$lambda$9$lambda$8(MutableState.this);
                    return invoke$lambda$9$lambda$8;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        ChipKt.InputChip(z9, (Function0) rememberedValue5, composableSingletons$DeveloperInputComponentsScreenKt.m3498getLambda5$app_kombardoProd(), null, false, null, null, null, null, null, null, null, null, composer, 432, 0, 8184);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
