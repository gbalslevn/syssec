package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SignupScreenKt$SignupContent$3 implements Function4<PagerScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ String $firstName;
    final /* synthetic */ String $lastName;
    final /* synthetic */ Function0<Unit> $navigateToNationalitySelection;
    final /* synthetic */ Function0<Unit> $navigateToPhoneNumberCodeSelection;
    final /* synthetic */ Function1<Boolean, Unit> $onTermsAndLicenseAcceptChange;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ UserInfoInput $userInfoInput;
    final /* synthetic */ IUserInfoInputHandler $userInfoInputHandler;
    final /* synthetic */ Map<SignupScreenPage, IFormValidator> $validators;
    final /* synthetic */ SignupViewModel.ViewState $viewState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignupScreenPage.values().length];
            try {
                iArr[SignupScreenPage.Name.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignupScreenPage.AdditionalInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignupScreenPage.Contact.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SignupScreenPage.PasswordAndTerms.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SignupScreenKt$SignupContent$3(Map<SignupScreenPage, ? extends IFormValidator> map, IUserInfoInputHandler iUserInfoInputHandler, String str, String str2, UserInfoInput userInfoInput, Function0<Unit> function0, PagerState pagerState, Function0<Unit> function02, SignupViewModel.ViewState viewState, Function1<? super Boolean, Unit> function1) {
        this.$validators = map;
        this.$userInfoInputHandler = iUserInfoInputHandler;
        this.$firstName = str;
        this.$lastName = str2;
        this.$userInfoInput = userInfoInput;
        this.$navigateToNationalitySelection = function0;
        this.$pagerState = pagerState;
        this.$navigateToPhoneNumberCodeSelection = function02;
        this.$viewState = viewState;
        this.$onTermsAndLicenseAcceptChange = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$9(PagerState pagerState, IUserInfoInputHandler iUserInfoInputHandler, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (pagerState.getCurrentPage() == SignupScreenPage.Contact.getIndex()) {
            iUserInfoInputHandler.updateEmail(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(IUserInfoInputHandler iUserInfoInputHandler) {
        iUserInfoInputHandler.updateNationality(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7(PagerState pagerState, IUserInfoInputHandler iUserInfoInputHandler, PhoneNumber it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (pagerState.getCurrentPage() == SignupScreenPage.Contact.getIndex()) {
            iUserInfoInputHandler.updatePhoneNumber(it);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
        invoke(pagerScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PagerScope HorizontalPager, int i5, Composer composer, int i6) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(419996751, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContent.<anonymous> (SignupScreen.kt:341)");
        }
        SignupScreenPage from = SignupScreenPage.INSTANCE.from(i5);
        IFormValidator iFormValidator = this.$validators.get(from);
        int i7 = WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
        if (i7 == 1) {
            composer.startReplaceGroup(761418425);
            if (iFormValidator == null) {
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            UserInfoFormField userInfoFormField = UserInfoFormField.FirstName;
            UserInfoFormField userInfoFormField2 = UserInfoFormField.LastName;
            IUserInfoInputHandler iUserInfoInputHandler = this.$userInfoInputHandler;
            composer.startReplaceGroup(440214822);
            boolean changedInstance = composer.changedInstance(iUserInfoInputHandler);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SignupScreenKt$SignupContent$3$1$1(iUserInfoInputHandler);
                composer.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            composer.endReplaceGroup();
            IUserInfoInputHandler iUserInfoInputHandler2 = this.$userInfoInputHandler;
            composer.startReplaceGroup(440217317);
            boolean changedInstance2 = composer.changedInstance(iUserInfoInputHandler2);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new SignupScreenKt$SignupContent$3$2$1(iUserInfoInputHandler2);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            SignupNameInputKt.SignupNameInput(userInfoFormField, userInfoFormField2, iFormValidator, this.$firstName, this.$lastName, (Function1) kFunction, (Function1) ((KFunction) rememberedValue2), composer, 54);
            composer.endReplaceGroup();
        } else if (i7 == 2) {
            composer.startReplaceGroup(761962506);
            Gender gender = this.$userInfoInput.getGender();
            LocalDate birthdate = this.$userInfoInput.getBirthdate();
            Locale nationality = this.$userInfoInput.getNationality();
            String postalCode = this.$userInfoInput.getPostalCode();
            String str = postalCode == null ? BuildConfig.FLAVOR : postalCode;
            IUserInfoInputHandler iUserInfoInputHandler3 = this.$userInfoInputHandler;
            composer.startReplaceGroup(440231651);
            boolean changedInstance3 = composer.changedInstance(iUserInfoInputHandler3);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new SignupScreenKt$SignupContent$3$3$1(iUserInfoInputHandler3);
                composer.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction2 = (KFunction) rememberedValue3;
            composer.endReplaceGroup();
            IUserInfoInputHandler iUserInfoInputHandler4 = this.$userInfoInputHandler;
            composer.startReplaceGroup(440234086);
            boolean changedInstance4 = composer.changedInstance(iUserInfoInputHandler4);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new SignupScreenKt$SignupContent$3$4$1(iUserInfoInputHandler4);
                composer.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction3 = (KFunction) rememberedValue4;
            composer.endReplaceGroup();
            IUserInfoInputHandler iUserInfoInputHandler5 = this.$userInfoInputHandler;
            composer.startReplaceGroup(440242215);
            boolean changedInstance5 = composer.changedInstance(iUserInfoInputHandler5);
            Object rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new SignupScreenKt$SignupContent$3$5$1(iUserInfoInputHandler5);
                composer.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction4 = (KFunction) rememberedValue5;
            composer.endReplaceGroup();
            String str2 = this.$firstName;
            Function1 function1 = (Function1) kFunction2;
            Function1 function12 = (Function1) kFunction3;
            composer.startReplaceGroup(440236593);
            boolean changedInstance6 = composer.changedInstance(this.$userInfoInputHandler);
            final IUserInfoInputHandler iUserInfoInputHandler6 = this.$userInfoInputHandler;
            Object rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$5;
                        invoke$lambda$6$lambda$5 = SignupScreenKt$SignupContent$3.invoke$lambda$6$lambda$5(IUserInfoInputHandler.this);
                        return invoke$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceGroup();
            SignupAdditionalInfoInputKt.SignupAdditionalInfoInput(str2, gender, birthdate, nationality, str, function1, function12, (Function0) rememberedValue6, (Function1) kFunction4, this.$navigateToNationalitySelection, composer, 0);
            composer.endReplaceGroup();
        } else if (i7 == 3) {
            composer.startReplaceGroup(762750402);
            PhoneNumber phoneNumber = this.$userInfoInput.getPhoneNumber();
            String email = this.$userInfoInput.getEmail();
            if (email == null) {
                email = BuildConfig.FLAVOR;
            }
            composer.startReplaceGroup(440252709);
            boolean changed = composer.changed(this.$pagerState) | composer.changedInstance(this.$userInfoInputHandler);
            final PagerState pagerState = this.$pagerState;
            final IUserInfoInputHandler iUserInfoInputHandler7 = this.$userInfoInputHandler;
            Object rememberedValue7 = composer.rememberedValue();
            if (changed || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$8$lambda$7;
                        invoke$lambda$8$lambda$7 = SignupScreenKt$SignupContent$3.invoke$lambda$8$lambda$7(PagerState.this, iUserInfoInputHandler7, (PhoneNumber) obj);
                        return invoke$lambda$8$lambda$7;
                    }
                };
                composer.updateRememberedValue(rememberedValue7);
            }
            Function1 function13 = (Function1) rememberedValue7;
            composer.endReplaceGroup();
            Function0<Unit> function0 = this.$navigateToPhoneNumberCodeSelection;
            composer.startReplaceGroup(440268319);
            boolean changed2 = composer.changed(this.$pagerState) | composer.changedInstance(this.$userInfoInputHandler);
            final PagerState pagerState2 = this.$pagerState;
            final IUserInfoInputHandler iUserInfoInputHandler8 = this.$userInfoInputHandler;
            Object rememberedValue8 = composer.rememberedValue();
            if (changed2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$10$lambda$9;
                        invoke$lambda$10$lambda$9 = SignupScreenKt$SignupContent$3.invoke$lambda$10$lambda$9(PagerState.this, iUserInfoInputHandler8, (String) obj);
                        return invoke$lambda$10$lambda$9;
                    }
                };
                composer.updateRememberedValue(rememberedValue8);
            }
            Function1 function14 = (Function1) rememberedValue8;
            composer.endReplaceGroup();
            UserInfoFormField userInfoFormField3 = UserInfoFormField.CountryCode;
            UserInfoFormField userInfoFormField4 = UserInfoFormField.NationalNumber;
            UserInfoFormField userInfoFormField5 = UserInfoFormField.Email;
            if (iFormValidator == null) {
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            SignupContactInfoInputKt.SignupContactInfoInput(phoneNumber, email, function13, function0, function14, userInfoFormField3, userInfoFormField4, userInfoFormField5, iFormValidator, composer, 14352384);
            composer.endReplaceGroup();
        } else if (i7 == 4) {
            composer.startReplaceGroup(764179533);
            String password = this.$userInfoInput.getPassword();
            if (password == null) {
                password = BuildConfig.FLAVOR;
            }
            SiteSupportInfo signupSiteSupportInfo = this.$viewState.getSignupSiteSupportInfo();
            boolean termsAndLicenseAccepted = this.$viewState.getTermsAndLicenseAccepted();
            IUserInfoInputHandler iUserInfoInputHandler9 = this.$userInfoInputHandler;
            composer.startReplaceGroup(440302341);
            boolean changedInstance7 = composer.changedInstance(iUserInfoInputHandler9);
            Object rememberedValue9 = composer.rememberedValue();
            if (changedInstance7 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new SignupScreenKt$SignupContent$3$9$1(iUserInfoInputHandler9);
                composer.updateRememberedValue(rememberedValue9);
            }
            composer.endReplaceGroup();
            Function1 function15 = (Function1) ((KFunction) rememberedValue9);
            Function1<Boolean, Unit> function16 = this.$onTermsAndLicenseAcceptChange;
            if (iFormValidator == null) {
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            SignupPasswordAndTermsInputKt.SignupPasswordAndTermsInput(password, signupSiteSupportInfo, termsAndLicenseAccepted, function15, function16, iFormValidator, UserInfoFormField.Password, UserInfoFormField.TermsAndLicense, composer, 14155776);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(440205202);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
