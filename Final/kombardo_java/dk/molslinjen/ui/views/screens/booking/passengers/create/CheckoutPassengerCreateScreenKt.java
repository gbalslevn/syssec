package dk.molslinjen.ui.views.screens.booking.passengers.create;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n\u001a[\u0010\u000b\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"CheckoutPassengerCreateScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/CheckoutPassengerCreateViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "nationalityResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "(Ldk/molslinjen/ui/views/screens/booking/passengers/create/CheckoutPassengerCreateViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "PassengerCreate", "updateNationality", "Lkotlin/Function1;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/PassengerCreateViewState;", "registerPassenger", "Lkotlin/Function0;", "inputHandler", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "(Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/screens/booking/passengers/create/PassengerCreateViewState;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd", "isFormValid", BuildConfig.FLAVOR, "submitFieldsTrigger"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerCreateScreenKt {
    public static final void CheckoutPassengerCreateScreen(final CheckoutPassengerCreateViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(1091943963);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091943963, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateScreen (CheckoutPassengerCreateScreen.kt:42)");
            }
            PassengerCreateViewState passengerCreateViewState = (PassengerCreateViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(103858785);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new CheckoutPassengerCreateScreenKt$CheckoutPassengerCreateScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(103861661);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: W2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CheckoutPassengerCreateScreen$lambda$2$lambda$1;
                        CheckoutPassengerCreateScreen$lambda$2$lambda$1 = CheckoutPassengerCreateScreenKt.CheckoutPassengerCreateScreen$lambda$2$lambda$1(CheckoutPassengerCreateViewModel.this, navigator);
                        return CheckoutPassengerCreateScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = (i6 >> 6) & 14;
            int i8 = i6 << 12;
            PassengerCreate(nationalityResultRecipient, function1, passengerCreateViewState, (Function0) rememberedValue2, viewModel, navigator, startRestartGroup, i7 | (57344 & i8) | (i8 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutPassengerCreateScreen$lambda$3;
                    CheckoutPassengerCreateScreen$lambda$3 = CheckoutPassengerCreateScreenKt.CheckoutPassengerCreateScreen$lambda$3(CheckoutPassengerCreateViewModel.this, navigator, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutPassengerCreateScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerCreateScreen$lambda$2$lambda$1(CheckoutPassengerCreateViewModel checkoutPassengerCreateViewModel, DestinationsNavigator destinationsNavigator) {
        checkoutPassengerCreateViewModel.registerPassenger(new CheckoutPassengerCreateScreenKt$CheckoutPassengerCreateScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerCreateScreen$lambda$3(CheckoutPassengerCreateViewModel checkoutPassengerCreateViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        CheckoutPassengerCreateScreen(checkoutPassengerCreateViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PassengerCreate(final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final Function1<? super Locale, Unit> updateNationality, final PassengerCreateViewState viewState, final Function0<Unit> registerPassenger, final IPassengerInputHandler inputHandler, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(updateNationality, "updateNationality");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(registerPassenger, "registerPassenger");
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1138137941);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(nationalityResultRecipient) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(updateNationality) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(viewState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(registerPassenger) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= (32768 & i5) == 0 ? startRestartGroup.changed(inputHandler) : startRestartGroup.changedInstance(inputHandler) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1138137941, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.create.PassengerCreate (CheckoutPassengerCreateScreen.kt:62)");
            }
            startRestartGroup.startReplaceGroup(1970950884);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: W2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerCreate$lambda$5$lambda$4;
                        PassengerCreate$lambda$5$lambda$4 = CheckoutPassengerCreateScreenKt.PassengerCreate$lambda$5$lambda$4(Function1.this, (Locale) obj);
                        return PassengerCreate$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(nationalityResultRecipient, null, (Function1) rememberedValue, startRestartGroup, i7 & 14, 1);
            startRestartGroup.startReplaceGroup(1970952865);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1970954977);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(R.string.passengers_create_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1970959990);
            boolean z6 = (i7 & 458752) == 131072;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new CheckoutPassengerCreateScreenKt$PassengerCreate$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(-2003740073, true, new CheckoutPassengerCreateScreenKt$PassengerCreate$3(viewState, registerPassenger, mutableState, mutableState2), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1461610008, true, new CheckoutPassengerCreateScreenKt$PassengerCreate$4(inputHandler, viewState, navigator, mutableState2, mutableState), startRestartGroup, 54), composer2, 905969664, 187);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerCreate$lambda$14;
                    PassengerCreate$lambda$14 = CheckoutPassengerCreateScreenKt.PassengerCreate$lambda$14(ResultRecipient.this, updateNationality, viewState, registerPassenger, inputHandler, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerCreate$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PassengerCreate$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerCreate$lambda$11(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCreate$lambda$14(ResultRecipient resultRecipient, Function1 function1, PassengerCreateViewState passengerCreateViewState, Function0 function0, IPassengerInputHandler iPassengerInputHandler, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        PassengerCreate(resultRecipient, function1, passengerCreateViewState, function0, iPassengerInputHandler, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCreate$lambda$5$lambda$4(Function1 function1, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PassengerCreate$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerCreate$lambda$8(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }
}
