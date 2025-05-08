package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.compose.LocalOnBackPressedDispatcherOwner;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseData;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SignupScreenKt$SignupScreen$1 implements Function4<Function0<? extends Unit>, MutableState<BottomSheetCloseData>, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetCustomDismissHandler $bottomSheetCustomDismissHandler;
    final /* synthetic */ ResultRecipient<NationalitySelectionScreenDestination, Locale> $nationalityResultRecipient;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> $phoneNumberCodeResultRecipient;
    final /* synthetic */ ResultBackNavigator<Boolean> $resultNavigator;
    final /* synthetic */ SignupViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignupScreenKt$SignupScreen$1(ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient, SignupViewModel signupViewModel, ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient2, ResultBackNavigator<Boolean> resultBackNavigator, BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
        this.$phoneNumberCodeResultRecipient = resultRecipient;
        this.$viewModel = signupViewModel;
        this.$nationalityResultRecipient = resultRecipient2;
        this.$resultNavigator = resultBackNavigator;
        this.$bottomSheetCustomDismissHandler = bottomSheetCustomDismissHandler;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SignupViewModel signupViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        signupViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$11(SignupViewModel.ViewState viewState, FocusManager focusManager, SignupScreenPage signupScreenPage, Function0 function0, CoroutineScope coroutineScope, PagerState pagerState) {
        if (viewState.getUiUploadState() == UIUploadState.Idle) {
            focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1281getExitdhqQ8s());
            FocusManager.clearFocus$default(focusManager, false, 1, null);
            if (signupScreenPage.isFirstPage()) {
                function0.invoke();
            } else {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SignupScreenKt$SignupScreen$1$backAction$1$1$1(pagerState, signupScreenPage, null), 3, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$13(Function0 function0, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$16$lambda$15(ResultBackNavigator resultBackNavigator, Function0 function0, boolean z5) {
        if (z5) {
            resultBackNavigator.navigateBack(Boolean.TRUE);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$18(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet$default(bottomSheetCustomDismissHandler, destinationsNavigator, NationalitySelectionScreenDestination.INSTANCE, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$21$lambda$20(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(SignupViewModel signupViewModel, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        signupViewModel.updateNationality(it);
        signupViewModel.updatePhoneNumberCodeFromNationality(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(ResultBackNavigator resultBackNavigator) {
        resultBackNavigator.navigateBack(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final BottomSheetCloseData invoke$lambda$6(MutableState<BottomSheetCloseData> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$9$lambda$8() {
        return SignupScreenPage.values().length;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, MutableState<BottomSheetCloseData> mutableState, Composer composer, Integer num) {
        invoke((Function0<Unit>) function0, mutableState, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final Function0<Unit> tryDismiss, MutableState<BottomSheetCloseData> bottomSheetCloseData, Composer composer, int i5) {
        int i6;
        SignupScreenPage signupScreenPage;
        Intrinsics.checkNotNullParameter(tryDismiss, "tryDismiss");
        Intrinsics.checkNotNullParameter(bottomSheetCloseData, "bottomSheetCloseData");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changedInstance(tryDismiss) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composer.changed(bottomSheetCloseData) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2046522789, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupScreen.<anonymous> (SignupScreen.kt:89)");
        }
        ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient = this.$phoneNumberCodeResultRecipient;
        composer.startReplaceGroup(963608765);
        boolean changedInstance = composer.changedInstance(this.$viewModel);
        final SignupViewModel signupViewModel = this.$viewModel;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SignupScreenKt$SignupScreen$1.invoke$lambda$1$lambda$0(SignupViewModel.this, (String) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue, composer, 0, 1);
        ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient2 = this.$nationalityResultRecipient;
        composer.startReplaceGroup(963612152);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel);
        final SignupViewModel signupViewModel2 = this.$viewModel;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = SignupScreenKt$SignupScreen$1.invoke$lambda$3$lambda$2(SignupViewModel.this, (Locale) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        OpenResultRecipientKt.onResult(resultRecipient2, null, (Function1) rememberedValue2, composer, 0, 1);
        final SignupViewModel.ViewState viewState = (SignupViewModel.ViewState) SnapshotStateKt.collectAsState(this.$viewModel.getViewState(), null, composer, 0, 1).getValue();
        boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(this.$viewModel.getHasChanges(), null, composer, 0, 1).getValue()).booleanValue();
        Object rememberedValue3 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue3 == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue3 = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
        String stringResource = StringResources_androidKt.stringResource(R.string.signup_dismiss_title, composer, 6);
        String stringResource2 = StringResources_androidKt.stringResource(R.string.signup_dismiss_button, composer, 6);
        composer.startReplaceGroup(963628895);
        boolean changed = composer.changed(booleanValue);
        final ResultBackNavigator<Boolean> resultBackNavigator = this.$resultNavigator;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new BottomSheetCloseData(booleanValue, stringResource, stringResource2, new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = SignupScreenKt$SignupScreen$1.invoke$lambda$5$lambda$4(ResultBackNavigator.this);
                    return invoke$lambda$5$lambda$4;
                }
            }), null, 2, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        bottomSheetCloseData.setValue(invoke$lambda$6((MutableState) rememberedValue4));
        composer.startReplaceGroup(963644999);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = SignupScreenKt.getIndexMappedValidators(coroutineScope);
            composer.updateRememberedValue(rememberedValue5);
        }
        Map map = (Map) rememberedValue5;
        composer.endReplaceGroup();
        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
            rememberedValue6 = compositionScopedCoroutineScopeCanceller2;
        }
        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
        composer.startReplaceGroup(963652356);
        Object rememberedValue7 = composer.rememberedValue();
        if (rememberedValue7 == companion.getEmpty()) {
            rememberedValue7 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int invoke$lambda$9$lambda$8;
                    invoke$lambda$9$lambda$8 = SignupScreenKt$SignupScreen$1.invoke$lambda$9$lambda$8();
                    return Integer.valueOf(invoke$lambda$9$lambda$8);
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceGroup();
        final PagerState rememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) rememberedValue7, composer, 384, 3);
        final SignupScreenPage from = SignupScreenPage.INSTANCE.from(rememberPagerState.getCurrentPage());
        composer.startReplaceGroup(963656996);
        boolean changed2 = composer.changed(rememberScrollState);
        Object rememberedValue8 = composer.rememberedValue();
        if (changed2 || rememberedValue8 == companion.getEmpty()) {
            rememberedValue8 = new SignupScreenKt$SignupScreen$1$3$1(rememberScrollState, null);
            composer.updateRememberedValue(rememberedValue8);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(from, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue8, composer, 0);
        final FocusManager focusManager = (FocusManager) composer.consume(CompositionLocalsKt.getLocalFocusManager());
        composer.startReplaceGroup(963661591);
        boolean changed3 = composer.changed(from);
        Object rememberedValue9 = composer.rememberedValue();
        if (changed3 || rememberedValue9 == companion.getEmpty()) {
            signupScreenPage = from;
            Object obj = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$12$lambda$11;
                    invoke$lambda$12$lambda$11 = SignupScreenKt$SignupScreen$1.invoke$lambda$12$lambda$11(SignupViewModel.ViewState.this, focusManager, from, tryDismiss, coroutineScope2, rememberPagerState);
                    return invoke$lambda$12$lambda$11;
                }
            };
            composer.updateRememberedValue(obj);
            rememberedValue9 = obj;
        } else {
            signupScreenPage = from;
        }
        final Function0 function0 = (Function0) rememberedValue9;
        composer.endReplaceGroup();
        OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composer, LocalOnBackPressedDispatcherOwner.$stable);
        OnBackPressedDispatcher onBackPressedDispatcher = current != null ? current.getOnBackPressedDispatcher() : null;
        composer.startReplaceGroup(963682527);
        if (onBackPressedDispatcher != null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            composer.startReplaceGroup(963684046);
            boolean changed4 = composer.changed(function0);
            Object rememberedValue10 = composer.rememberedValue();
            if (changed4 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invoke$lambda$14$lambda$13;
                        invoke$lambda$14$lambda$13 = SignupScreenKt$SignupScreen$1.invoke$lambda$14$lambda$13(Function0.this, (OnBackPressedCallback) obj2);
                        return invoke$lambda$14$lambda$13;
                    }
                };
                composer.updateRememberedValue(rememberedValue10);
            }
            composer.endReplaceGroup();
            OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, lifecycleOwner, false, (Function1) rememberedValue10, 2, null);
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(963693534);
        boolean changed5 = composer.changed(this.$resultNavigator) | ((i7 & 14) == 4);
        final ResultBackNavigator<Boolean> resultBackNavigator2 = this.$resultNavigator;
        Object rememberedValue11 = composer.rememberedValue();
        if (changed5 || rememberedValue11 == companion.getEmpty()) {
            rememberedValue11 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invoke$lambda$16$lambda$15;
                    invoke$lambda$16$lambda$15 = SignupScreenKt$SignupScreen$1.invoke$lambda$16$lambda$15(ResultBackNavigator.this, tryDismiss, ((Boolean) obj2).booleanValue());
                    return invoke$lambda$16$lambda$15;
                }
            };
            composer.updateRememberedValue(rememberedValue11);
        }
        Function1 function1 = (Function1) rememberedValue11;
        composer.endReplaceGroup();
        SignupViewModel signupViewModel3 = this.$viewModel;
        composer.startReplaceGroup(963705000);
        boolean changedInstance3 = composer.changedInstance(signupViewModel3);
        Object rememberedValue12 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue12 == companion.getEmpty()) {
            rememberedValue12 = new SignupScreenKt$SignupScreen$1$6$1(signupViewModel3);
            composer.updateRememberedValue(rememberedValue12);
        }
        composer.endReplaceGroup();
        Function1 function12 = (Function1) ((KFunction) rememberedValue12);
        composer.startReplaceGroup(963707844);
        boolean changedInstance4 = composer.changedInstance(this.$bottomSheetCustomDismissHandler) | composer.changed(this.$navigator);
        final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler = this.$bottomSheetCustomDismissHandler;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue13 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue13 == companion.getEmpty()) {
            rememberedValue13 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$19$lambda$18;
                    invoke$lambda$19$lambda$18 = SignupScreenKt$SignupScreen$1.invoke$lambda$19$lambda$18(BottomSheetCustomDismissHandler.this, destinationsNavigator);
                    return invoke$lambda$19$lambda$18;
                }
            };
            composer.updateRememberedValue(rememberedValue13);
        }
        Function0 function02 = (Function0) rememberedValue13;
        composer.endReplaceGroup();
        composer.startReplaceGroup(963714563);
        boolean changed6 = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue14 = composer.rememberedValue();
        if (changed6 || rememberedValue14 == companion.getEmpty()) {
            rememberedValue14 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$21$lambda$20;
                    invoke$lambda$21$lambda$20 = SignupScreenKt$SignupScreen$1.invoke$lambda$21$lambda$20(DestinationsNavigator.this);
                    return invoke$lambda$21$lambda$20;
                }
            };
            composer.updateRememberedValue(rememberedValue14);
        }
        Function0 function03 = (Function0) rememberedValue14;
        composer.endReplaceGroup();
        Object obj2 = this.$viewModel;
        composer.startReplaceGroup(963717399);
        boolean changedInstance5 = composer.changedInstance(obj2);
        Object rememberedValue15 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue15 == companion.getEmpty()) {
            rememberedValue15 = new SignupScreenKt$SignupScreen$1$9$1(obj2);
            composer.updateRememberedValue(rememberedValue15);
        }
        composer.endReplaceGroup();
        SignupScreenKt.SignupContainer(rememberScrollState, coroutineScope2, rememberPagerState, signupScreenPage, function0, function1, map, viewState, signupViewModel3, function12, function02, function03, (Function0) ((KFunction) rememberedValue15), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
