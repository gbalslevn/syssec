package dk.molslinjen.ui.views.screens.profile.edit;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.ChangePasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.Environment;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseData;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreenKt$ProfileEditScreen$1;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileEditScreenKt$ProfileEditScreen$1 implements Function4<Function0<? extends Unit>, MutableState<BottomSheetCloseData>, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetCustomDismissHandler $bottomSheetCustomDismissHandler;
    final /* synthetic */ ResultRecipient<NationalitySelectionScreenDestination, Locale> $nationalityResultRecipient;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> $phoneNumberCodeResultRecipient;
    final /* synthetic */ ProfileEditViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreenKt$ProfileEditScreen$1$6, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass6 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ FormValidator $formValidator;
        final /* synthetic */ boolean $hasChanges;
        final /* synthetic */ boolean $isLoading;
        final /* synthetic */ DestinationsNavigator $navigator;
        final /* synthetic */ ProfileEditViewModel $viewModel;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreenKt$ProfileEditScreen$1$6$3, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass3 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
            final /* synthetic */ FormValidator $formValidator;
            final /* synthetic */ boolean $isLoading;
            final /* synthetic */ DestinationsNavigator $navigator;
            final /* synthetic */ ProfileEditViewModel $viewModel;

            AnonymousClass3(boolean z5, FormValidator formValidator, ProfileEditViewModel profileEditViewModel, DestinationsNavigator destinationsNavigator) {
                this.$isLoading = z5;
                this.$formValidator = formValidator;
                this.$viewModel = profileEditViewModel;
                this.$navigator = destinationsNavigator;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invoke$lambda$2$lambda$1(ProfileEditViewModel profileEditViewModel, DestinationsNavigator destinationsNavigator) {
                profileEditViewModel.confirmChanges(new ProfileEditScreenKt$ProfileEditScreen$1$6$3$2$1$1(destinationsNavigator));
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
            
                if (((java.lang.Boolean) androidx.compose.runtime.SnapshotStateKt.collectAsState(r12.$formValidator.isFormValid(), null, r14, 0, 1).getValue()).booleanValue() != false) goto L11;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
                boolean z5;
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1896821758, i5, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreen.<anonymous>.<anonymous>.<anonymous> (ProfileEditScreen.kt:162)");
                }
                String stringResource = StringResources_androidKt.stringResource(R.string.button_saveChanges, composer, 6);
                composer.startReplaceGroup(943802208);
                if (!this.$isLoading) {
                    z5 = true;
                }
                z5 = false;
                composer.endReplaceGroup();
                FormValidator formValidator = this.$formValidator;
                composer.startReplaceGroup(943809920);
                boolean changedInstance = composer.changedInstance(formValidator);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new ProfileEditScreenKt$ProfileEditScreen$1$6$3$1$1(formValidator);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                boolean z6 = this.$isLoading;
                Function0 function0 = (Function0) ((KFunction) rememberedValue);
                composer.startReplaceGroup(943806839);
                boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
                final ProfileEditViewModel profileEditViewModel = this.$viewModel;
                final DestinationsNavigator destinationsNavigator = this.$navigator;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$2$lambda$1;
                            invoke$lambda$2$lambda$1 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass6.AnonymousClass3.invoke$lambda$2$lambda$1(ProfileEditViewModel.this, destinationsNavigator);
                            return invoke$lambda$2$lambda$1;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, z6, false, 0L, function0, (Function0) rememberedValue2, composer, 0, 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        AnonymousClass6(boolean z5, boolean z6, FormValidator formValidator, ProfileEditViewModel profileEditViewModel, DestinationsNavigator destinationsNavigator) {
            this.$hasChanges = z5;
            this.$isLoading = z6;
            this.$formValidator = formValidator;
            this.$viewModel = profileEditViewModel;
            this.$navigator = destinationsNavigator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invoke$lambda$1$lambda$0(int i5) {
            return i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invoke$lambda$3$lambda$2(int i5) {
            return i5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i5) {
            if ((i5 & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1803574746, i5, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreen.<anonymous>.<anonymous> (ProfileEditScreen.kt:157)");
            }
            boolean z5 = this.$hasChanges;
            composer.startReplaceGroup(-474713015);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.edit.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass6.invoke$lambda$1$lambda$0(((Integer) obj).intValue());
                        return Integer.valueOf(invoke$lambda$1$lambda$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue, 1, null);
            composer.startReplaceGroup(-474711287);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.edit.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int invoke$lambda$3$lambda$2;
                        invoke$lambda$3$lambda$2 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass6.invoke$lambda$3$lambda$2(((Integer) obj).intValue());
                        return Integer.valueOf(invoke$lambda$3$lambda$2);
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(z5, null, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue2, 1, null), null, ComposableLambdaKt.rememberComposableLambda(-1896821758, true, new AnonymousClass3(this.$isLoading, this.$formValidator, this.$viewModel, this.$navigator), composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreenKt$ProfileEditScreen$1$7, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass7 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ BottomSheetCustomDismissHandler $bottomSheetCustomDismissHandler;
        final /* synthetic */ FormValidator $formValidator;
        final /* synthetic */ DestinationsNavigator $navigator;
        final /* synthetic */ ScrollState $scrollState;
        final /* synthetic */ ProfileEditViewModel $viewModel;
        final /* synthetic */ ProfileEditViewModel.ViewState $viewState;

        AnonymousClass7(ScrollState scrollState, ProfileEditViewModel.ViewState viewState, ProfileEditViewModel profileEditViewModel, FormValidator formValidator, BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
            this.$scrollState = scrollState;
            this.$viewState = viewState;
            this.$viewModel = profileEditViewModel;
            this.$formValidator = formValidator;
            this.$bottomSheetCustomDismissHandler = bottomSheetCustomDismissHandler;
            this.$navigator = destinationsNavigator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
            BottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet$default(bottomSheetCustomDismissHandler, destinationsNavigator, ChangePasswordScreenDestination.INSTANCE, null, 4, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$4$lambda$3(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
            BottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet$default(bottomSheetCustomDismissHandler, destinationsNavigator, NationalitySelectionScreenDestination.INSTANCE, null, 4, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$6$lambda$5(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
            BottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet$default(bottomSheetCustomDismissHandler, destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, 4, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$8$lambda$7(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator) {
            BottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet$default(bottomSheetCustomDismissHandler, destinationsNavigator, SignupScreenDestination.INSTANCE, null, 4, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1105268183, i5, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreen.<anonymous>.<anonymous> (ProfileEditScreen.kt:172)");
            }
            ScrollState scrollState = this.$scrollState;
            ProfileEditViewModel.ViewState viewState = this.$viewState;
            ProfileEditViewModel profileEditViewModel = this.$viewModel;
            FormValidator formValidator = this.$formValidator;
            composer.startReplaceGroup(-474686617);
            boolean changedInstance = composer.changedInstance(this.$bottomSheetCustomDismissHandler) | composer.changed(this.$navigator);
            final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler = this.$bottomSheetCustomDismissHandler;
            final DestinationsNavigator destinationsNavigator = this.$navigator;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass7.invoke$lambda$1$lambda$0(BottomSheetCustomDismissHandler.this, destinationsNavigator);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            composer.endReplaceGroup();
            ProfileEditViewModel profileEditViewModel2 = this.$viewModel;
            composer.startReplaceGroup(-474680190);
            boolean changedInstance2 = composer.changedInstance(profileEditViewModel2);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ProfileEditScreenKt$ProfileEditScreen$1$7$2$1(profileEditViewModel2);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            Function0 function02 = (Function0) ((KFunction) rememberedValue2);
            composer.startReplaceGroup(-474677427);
            boolean changedInstance3 = composer.changedInstance(this.$bottomSheetCustomDismissHandler) | composer.changed(this.$navigator);
            final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler2 = this.$bottomSheetCustomDismissHandler;
            final DestinationsNavigator destinationsNavigator2 = this.$navigator;
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$4$lambda$3;
                        invoke$lambda$4$lambda$3 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass7.invoke$lambda$4$lambda$3(BottomSheetCustomDismissHandler.this, destinationsNavigator2);
                        return invoke$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            Function0 function03 = (Function0) rememberedValue3;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-474670377);
            boolean changedInstance4 = composer.changedInstance(this.$bottomSheetCustomDismissHandler) | composer.changed(this.$navigator);
            final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler3 = this.$bottomSheetCustomDismissHandler;
            final DestinationsNavigator destinationsNavigator3 = this.$navigator;
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$5;
                        invoke$lambda$6$lambda$5 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass7.invoke$lambda$6$lambda$5(BottomSheetCustomDismissHandler.this, destinationsNavigator3);
                        return invoke$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            Function0 function04 = (Function0) rememberedValue4;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-474661729);
            boolean changedInstance5 = composer.changedInstance(this.$bottomSheetCustomDismissHandler) | composer.changed(this.$navigator);
            final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler4 = this.$bottomSheetCustomDismissHandler;
            final DestinationsNavigator destinationsNavigator4 = this.$navigator;
            Object rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$8$lambda$7;
                        invoke$lambda$8$lambda$7 = ProfileEditScreenKt$ProfileEditScreen$1.AnonymousClass7.invoke$lambda$8$lambda$7(BottomSheetCustomDismissHandler.this, destinationsNavigator4);
                        return invoke$lambda$8$lambda$7;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceGroup();
            ProfileEditScreenKt.ProfileEditContent(scrollState, viewState, profileEditViewModel, formValidator, function0, function02, function03, function04, (Function0) rememberedValue5, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProfileEditViewModel.EditMode.values().length];
            try {
                iArr[ProfileEditViewModel.EditMode.CreateLocal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileEditViewModel.EditMode.EditLocal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileEditViewModel.EditMode.EditAuthenticated.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileEditScreenKt$ProfileEditScreen$1(ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient, ProfileEditViewModel profileEditViewModel, ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient2, DestinationsNavigator destinationsNavigator, BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler) {
        this.$nationalityResultRecipient = resultRecipient;
        this.$viewModel = profileEditViewModel;
        this.$phoneNumberCodeResultRecipient = resultRecipient2;
        this.$navigator = destinationsNavigator;
        this.$bottomSheetCustomDismissHandler = bottomSheetCustomDismissHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ProfileEditViewModel profileEditViewModel, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        profileEditViewModel.updateNationality(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(ProfileEditViewModel profileEditViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        profileEditViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    private static final BottomSheetCloseData invoke$lambda$5(MutableState<BottomSheetCloseData> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7(ProfileEditViewModel profileEditViewModel, DestinationsNavigator destinationsNavigator) {
        profileEditViewModel.onDeleteAccount(new ProfileEditScreenKt$ProfileEditScreen$1$3$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, MutableState<BottomSheetCloseData> mutableState, Composer composer, Integer num) {
        invoke((Function0<Unit>) function0, mutableState, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function0<Unit> tryDismiss, MutableState<BottomSheetCloseData> bottomSheetCloseData, Composer composer, int i5) {
        int i6;
        Integer num;
        Map validatorsMap;
        FormValidator formValidator;
        int i7;
        Composer composer2;
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
        int i8 = i6;
        if ((i8 & 147) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-695062244, i8, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreen.<anonymous> (ProfileEditScreen.kt:88)");
        }
        ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient = this.$nationalityResultRecipient;
        composer.startReplaceGroup(1944671323);
        boolean changedInstance = composer.changedInstance(this.$viewModel);
        final ProfileEditViewModel profileEditViewModel = this.$viewModel;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.edit.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProfileEditScreenKt$ProfileEditScreen$1.invoke$lambda$1$lambda$0(ProfileEditViewModel.this, (Locale) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue, composer, 0, 1);
        ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient2 = this.$phoneNumberCodeResultRecipient;
        composer.startReplaceGroup(1944674655);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel);
        final ProfileEditViewModel profileEditViewModel2 = this.$viewModel;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.edit.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ProfileEditScreenKt$ProfileEditScreen$1.invoke$lambda$3$lambda$2(ProfileEditViewModel.this, (String) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        OpenResultRecipientKt.onResult(resultRecipient2, null, (Function1) rememberedValue2, composer, 0, 1);
        ProfileEditViewModel.ViewState viewState = (ProfileEditViewModel.ViewState) SnapshotStateKt.collectAsState(this.$viewModel.getViewState(), null, composer, 0, 1).getValue();
        boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(this.$viewModel.getHasChanges(), null, composer, 0, 1).getValue()).booleanValue();
        String stringResource = StringResources_androidKt.stringResource(R.string.profile_edit_dismiss_title, composer, 6);
        String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_edit_dismiss_button, composer, 6);
        composer.startReplaceGroup(1944688293);
        boolean changed = composer.changed(booleanValue);
        DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new BottomSheetCloseData(booleanValue, stringResource, stringResource2, new ProfileEditScreenKt$ProfileEditScreen$1$localBottomSheetCloseData$2$1(destinationsNavigator)), null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        bottomSheetCloseData.setValue(invoke$lambda$5((MutableState) rememberedValue3));
        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
        ProfileEditViewModel.EditMode editMode = viewState.getEditMode();
        int i9 = editMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[editMode.ordinal()];
        if (i9 == -1) {
            num = null;
        } else if (i9 == 1) {
            num = Integer.valueOf(R.string.profile_addInfo);
        } else {
            if (i9 != 2 && i9 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            num = Integer.valueOf(R.string.profile_editInfo);
        }
        boolean showDeleteDialog = viewState.getShowDeleteDialog();
        boolean isDeleteLoading = viewState.getIsDeleteLoading();
        boolean isLoading = viewState.getIsLoading();
        boolean booleanValue2 = ((Boolean) SnapshotStateKt.collectAsState(this.$viewModel.getHasChanges(), null, composer, 0, 1).getValue()).booleanValue();
        Object rememberedValue4 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue4 == companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue4 = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope();
        validatorsMap = ProfileEditScreenKt.validatorsMap();
        FormValidator formValidator2 = new FormValidator(validatorsMap, coroutineScope);
        composer.startReplaceGroup(1944725721);
        if (showDeleteDialog) {
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_edit_delete_dialogTitle, composer, 6);
            String stringResource4 = StringResources_androidKt.stringResource(Environment.INSTANCE.isKombardo() ? R.string.profile_edit_delete_description_kombardo : R.string.profile_edit_delete_description, composer, 0);
            String stringResource5 = StringResources_androidKt.stringResource(R.string.button_deleteProfile, composer, 6);
            composer.startReplaceGroup(1944744634);
            boolean changed2 = composer.changed(this.$navigator) | composer.changedInstance(this.$viewModel);
            final ProfileEditViewModel profileEditViewModel3 = this.$viewModel;
            final DestinationsNavigator destinationsNavigator2 = this.$navigator;
            Object rememberedValue5 = composer.rememberedValue();
            if (changed2 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$8$lambda$7;
                        invoke$lambda$8$lambda$7 = ProfileEditScreenKt$ProfileEditScreen$1.invoke$lambda$8$lambda$7(ProfileEditViewModel.this, destinationsNavigator2);
                        return invoke$lambda$8$lambda$7;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            Function0 function0 = (Function0) rememberedValue5;
            composer.endReplaceGroup();
            ProfileEditViewModel profileEditViewModel4 = this.$viewModel;
            composer.startReplaceGroup(1944747490);
            boolean changedInstance3 = composer.changedInstance(profileEditViewModel4);
            Object rememberedValue6 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new ProfileEditScreenKt$ProfileEditScreen$1$4$1(profileEditViewModel4);
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceGroup();
            formValidator = formValidator2;
            i7 = i8;
            composer2 = composer;
            DeleteDialogKt.DeleteDialog(stringResource3, stringResource4, stringResource5, null, isDeleteLoading, function0, (Function0) ((KFunction) rememberedValue6), composer, 0, 8);
        } else {
            formValidator = formValidator2;
            i7 = i8;
            composer2 = composer;
        }
        composer.endReplaceGroup();
        Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) composer2.consume(CompositionLocalsKt.getLocalFocusManager()));
        composer2.startReplaceGroup(1944753987);
        String stringResource6 = num == null ? null : StringResources_androidKt.stringResource(num.intValue(), composer2, 0);
        composer.endReplaceGroup();
        BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource6, null, 0L, null, tryDismiss, rememberScrollState, ComposableLambdaKt.rememberComposableLambda(1803574746, true, new AnonymousClass6(booleanValue2, isLoading, formValidator, this.$viewModel, this.$navigator), composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1105268183, true, new AnonymousClass7(rememberScrollState, viewState, this.$viewModel, formValidator, this.$bottomSheetCustomDismissHandler, this.$navigator), composer2, 54), composer, ((i7 << 18) & 3670016) | 905969664, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
