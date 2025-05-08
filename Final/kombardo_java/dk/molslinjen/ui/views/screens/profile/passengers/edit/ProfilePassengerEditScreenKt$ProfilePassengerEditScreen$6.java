package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ ProfilePassengerEditViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6(ProfilePassengerEditViewModel profilePassengerEditViewModel, boolean z5, DestinationsNavigator destinationsNavigator, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$viewModel = profilePassengerEditViewModel;
        this.$isLoading = z5;
        this.$navigator = destinationsNavigator;
        this.$submitFieldsTrigger$delegate = mutableState;
        this.$isFormValid$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(MutableState mutableState, boolean z5) {
        ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$7(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, NationalitySelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        int i6;
        boolean ProfilePassengerEditScreen$lambda$9;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(BottomSheetContainer) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233922787, i6, -1, "dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditScreen.<anonymous> (ProfilePassengerEditScreen.kt:79)");
        }
        ProfilePassengerEditViewModel profilePassengerEditViewModel = this.$viewModel;
        boolean z5 = this.$isLoading;
        ProfilePassengerEditScreen$lambda$9 = ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$9(this.$submitFieldsTrigger$delegate);
        ProfilePassengerEditViewModel profilePassengerEditViewModel2 = this.$viewModel;
        composer.startReplaceGroup(-1235414535);
        boolean changedInstance = composer.changedInstance(profilePassengerEditViewModel2);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6$1$1(profilePassengerEditViewModel2);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Function0 function0 = (Function0) ((KFunction) rememberedValue);
        composer.startReplaceGroup(-1235412461);
        final MutableState<Boolean> mutableState = this.$isFormValid$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.edit.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6.invoke$lambda$2$lambda$1(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function1 function1 = (Function1) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1235410276);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.edit.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6.invoke$lambda$4$lambda$3(DestinationsNavigator.this);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        PassengerEditViewKt.PassengerEditView(BottomSheetContainer, profilePassengerEditViewModel, R.string.profile_passengers_delete, z5, ProfilePassengerEditScreen$lambda$9, function0, function1, (Function0) rememberedValue3, composer, 1573248 | (i6 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
