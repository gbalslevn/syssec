package dk.molslinjen.ui.views.screens.profile.edit;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyNameValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonNullCustomValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.register.UserInfoFormField;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreenKt;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountSignupCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoAdditionalInputKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoContactInputKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoNameInputKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\nH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001au\u0010\"\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0003¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$H\u0002¢\u0006\u0004\b'\u0010(¨\u0006+²\u0006\f\u0010*\u001a\u00020)8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCustomDismissHandler;", "bottomSheetCustomDismissHandler", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "phoneNumberCodeResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", BuildConfig.FLAVOR, "ProfileEditScreen", "(Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCustomDismissHandler;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", "userInfoInputHandler", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "formValidator", "Lkotlin/Function0;", "onChangePassword", "triggerDeleteAccount", "navigateToNationalitySelection", "showPhoneNumberCodeSelector", "onSignup", "ProfileEditContent", "(Landroidx/compose/foundation/ScrollState;Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "validatorsMap", "()Ljava/util/Map;", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseData;", "localBottomSheetCloseData", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileEditScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x050b, code lost:
    
        if (r4.changedInstance(r3) != false) goto L191;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileEditContent(final ScrollState scrollState, final ProfileEditViewModel.ViewState viewState, final IUserInfoInputHandler iUserInfoInputHandler, final IFormValidator iFormValidator, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        Modifier.Companion companion2;
        Object obj;
        boolean z7;
        Object rememberedValue;
        boolean z8;
        Object rememberedValue2;
        boolean changedInstance;
        Object rememberedValue3;
        Composer composer2;
        final IUserInfoInputHandler iUserInfoInputHandler2;
        boolean z9;
        Object rememberedValue4;
        boolean z10;
        Object rememberedValue5;
        boolean z11;
        Object rememberedValue6;
        Object rememberedValue7;
        boolean changedInstance2;
        Object rememberedValue8;
        Modifier.Companion companion3;
        float f5;
        Composer startRestartGroup = composer.startRestartGroup(1043618468);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(scrollState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(iUserInfoInputHandler) : startRestartGroup.changedInstance(iUserInfoInputHandler) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= (i5 & 4096) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i6 |= startRestartGroup.changedInstance(function05) ? 67108864 : 33554432;
        }
        if ((i6 & 38347923) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1043618468, i6, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditContent (ProfileEditScreen.kt:209)");
            }
            UserInfoInput userInfoInput = (UserInfoInput) SnapshotStateKt.collectAsState(iUserInfoInputHandler.getUserInfoInput(), null, startRestartGroup, 0, 1).getValue();
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion4 = Modifier.INSTANCE;
            float f6 = 24;
            int i10 = i6;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(ScrollKt.verticalScroll$default(companion4, scrollState, false, null, false, 14, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(64), 5, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            AccountCardData accountCardData = viewState.getAccountCardData();
            startRestartGroup.startReplaceGroup(788107976);
            Feature feature = Feature.Account;
            if (!feature.isEnabled() || accountCardData == null) {
                companion = companion4;
                i7 = i10;
                i8 = 256;
                z5 = false;
            } else {
                if (accountCardData instanceof AccountCardData.ActivationPending) {
                    startRestartGroup.startReplaceGroup(788112595);
                    f5 = f6;
                    z5 = false;
                    companion3 = companion4;
                    AccountActivationPendingCardKt.AccountActivationPendingCard(null, (AccountCardData.ActivationPending) accountCardData, null, startRestartGroup, 0, 5);
                    startRestartGroup.endReplaceGroup();
                    i8 = 256;
                    i7 = i10;
                } else {
                    companion3 = companion4;
                    f5 = f6;
                    z5 = false;
                    if (!(accountCardData instanceof AccountCardData.Signup)) {
                        startRestartGroup.startReplaceGroup(788110206);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(788115741);
                    AccountCardData.Signup signup = (AccountCardData.Signup) accountCardData;
                    i7 = i10;
                    i8 = 256;
                    AccountSignupCardKt.AccountSignupCard(null, signup, function05, startRestartGroup, (i7 >> 18) & 896, 1);
                    startRestartGroup.endReplaceGroup();
                }
                companion = companion3;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_edit_contactTitle, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            float f7 = 16;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            PhoneNumber phoneNumber = userInfoInput.getPhoneNumber();
            String email = userInfoInput.getEmail();
            if (email == null) {
                email = BuildConfig.FLAVOR;
            }
            startRestartGroup.startReplaceGroup(788131398);
            int i11 = i7 & 896;
            boolean z12 = (i11 == i8 || ((i7 & 512) != 0 && startRestartGroup.changedInstance(iUserInfoInputHandler))) ? true : z5;
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new ProfileEditScreenKt$ProfileEditContent$1$1$1(iUserInfoInputHandler);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue9);
            startRestartGroup.startReplaceGroup(788133600);
            if (i11 == 256 || ((i7 & 512) != 0 && startRestartGroup.changedInstance(iUserInfoInputHandler))) {
                i9 = i11;
                z6 = true;
            } else {
                i9 = i11;
                z6 = z5;
            }
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new ProfileEditScreenKt$ProfileEditContent$1$2$1(iUserInfoInputHandler);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function12 = (Function1) ((KFunction) rememberedValue10);
            UserInfoFormField userInfoFormField = UserInfoFormField.CountryCode;
            UserInfoFormField userInfoFormField2 = UserInfoFormField.NationalNumber;
            UserInfoFormField userInfoFormField3 = UserInfoFormField.Email;
            ImeAction.Companion companion6 = ImeAction.INSTANCE;
            int m2385getNexteUduSuo = companion6.m2385getNexteUduSuo();
            startRestartGroup.startReplaceGroup(788147178);
            boolean changedInstance3 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: K3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileEditContent$lambda$16$lambda$4$lambda$3;
                        ProfileEditContent$lambda$16$lambda$4$lambda$3 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$4$lambda$3(FocusManager.this);
                        return ProfileEditContent$lambda$16$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            int i12 = i9;
            Modifier.Companion companion7 = companion;
            UserInfoContactInputKt.m3516UserInfoContactInputk7ZECbw(phoneNumber, email, function1, function12, function04, userInfoFormField, userInfoFormField2, userInfoFormField3, iFormValidator, m2385getNexteUduSuo, (Function0) rememberedValue11, !viewState.getIsLoading(), startRestartGroup, ((i7 >> 9) & 57344) | 819658752 | ((i7 << 15) & 234881024), 0, 0);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion7, 0.0f, Dp.m2599constructorimpl(32), 1, null), 0L, 0.0f, null, startRestartGroup, 6, 14);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_edit_personalInfoTitle, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion7, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            UserInfoFormField userInfoFormField4 = UserInfoFormField.FirstName;
            UserInfoFormField userInfoFormField5 = UserInfoFormField.LastName;
            String firstName = userInfoInput.getFirstName();
            String lastName = userInfoInput.getLastName();
            startRestartGroup.startReplaceGroup(788170116);
            if (i12 != 256) {
                companion2 = companion7;
                obj = iUserInfoInputHandler;
                if ((i7 & 512) == 0 || !startRestartGroup.changedInstance(obj)) {
                    z7 = z5;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new ProfileEditScreenKt$ProfileEditContent$1$4$1(obj);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Function1 function13 = (Function1) ((KFunction) rememberedValue);
                    startRestartGroup.startReplaceGroup(788172355);
                    z8 = (i12 != 256 || ((i7 & 512) != 0 && startRestartGroup.changedInstance(obj))) ? true : z5;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z8 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new ProfileEditScreenKt$ProfileEditContent$1$5$1(obj);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Function1 function14 = (Function1) ((KFunction) rememberedValue2);
                    int m2385getNexteUduSuo2 = companion6.m2385getNexteUduSuo();
                    startRestartGroup.startReplaceGroup(788175978);
                    changedInstance = startRestartGroup.changedInstance(focusManager);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: K3.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProfileEditContent$lambda$16$lambda$8$lambda$7;
                                ProfileEditContent$lambda$16$lambda$8$lambda$7 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$8$lambda$7(FocusManager.this);
                                return ProfileEditContent$lambda$16$lambda$8$lambda$7;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier.Companion companion8 = companion2;
                    UserInfoNameInputKt.m3517UserInfoNameInputdAaJhyQ(userInfoFormField4, userInfoFormField5, iFormValidator, firstName, lastName, function13, function14, m2385getNexteUduSuo2, (Function0) rememberedValue3, !viewState.getIsLoading(), startRestartGroup, ((i7 >> 3) & 896) | 12582966, 0);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion8, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
                    Gender gender = userInfoInput.getGender();
                    LocalDate birthdate = userInfoInput.getBirthdate();
                    Locale nationality = userInfoInput.getNationality();
                    String postalCode = userInfoInput.getPostalCode();
                    String str = postalCode != null ? BuildConfig.FLAVOR : postalCode;
                    startRestartGroup.startReplaceGroup(788190177);
                    if (i12 == 256) {
                        if ((i7 & 512) != 0) {
                            composer2 = startRestartGroup;
                            iUserInfoInputHandler2 = iUserInfoInputHandler;
                        } else {
                            composer2 = startRestartGroup;
                            iUserInfoInputHandler2 = iUserInfoInputHandler;
                        }
                        z9 = z5;
                        rememberedValue4 = composer2.rememberedValue();
                        if (!z9 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new ProfileEditScreenKt$ProfileEditContent$1$7$1(iUserInfoInputHandler2);
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceGroup();
                        Function1 function15 = (Function1) ((KFunction) rememberedValue4);
                        composer2.startReplaceGroup(788192356);
                        z10 = (i12 != 256 || ((i7 & 512) != 0 && composer2.changedInstance(iUserInfoInputHandler2))) ? true : z5;
                        rememberedValue5 = composer2.rememberedValue();
                        if (!z10 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = new ProfileEditScreenKt$ProfileEditContent$1$8$1(iUserInfoInputHandler2);
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        composer2.endReplaceGroup();
                        Function1 function16 = (Function1) ((KFunction) rememberedValue5);
                        composer2.startReplaceGroup(788194661);
                        z11 = (i12 != 256 || ((i7 & 512) != 0 && composer2.changedInstance(iUserInfoInputHandler2))) ? true : z5;
                        rememberedValue6 = composer2.rememberedValue();
                        if (!z11 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = new ProfileEditScreenKt$ProfileEditContent$1$9$1(iUserInfoInputHandler2);
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        composer2.endReplaceGroup();
                        Function1 function17 = (Function1) ((KFunction) rememberedValue6);
                        composer2.startReplaceGroup(788196943);
                        if (i12 != 256 || ((i7 & 512) != 0 && composer2.changedInstance(iUserInfoInputHandler2))) {
                            z5 = true;
                        }
                        rememberedValue7 = composer2.rememberedValue();
                        if (!z5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue7 = new Function0() { // from class: K3.g
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit ProfileEditContent$lambda$16$lambda$13$lambda$12;
                                    ProfileEditContent$lambda$16$lambda$13$lambda$12 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$13$lambda$12(IUserInfoInputHandler.this);
                                    return ProfileEditContent$lambda$16$lambda$13$lambda$12;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue7);
                        }
                        Function0 function06 = (Function0) rememberedValue7;
                        composer2.endReplaceGroup();
                        int m2383getDoneeUduSuo = companion6.m2383getDoneeUduSuo();
                        composer2.startReplaceGroup(788203384);
                        changedInstance2 = composer2.changedInstance(focusManager);
                        rememberedValue8 = composer2.rememberedValue();
                        if (!changedInstance2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue8 = new Function0() { // from class: K3.h
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit ProfileEditContent$lambda$16$lambda$15$lambda$14;
                                    ProfileEditContent$lambda$16$lambda$15$lambda$14 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$15$lambda$14(FocusManager.this);
                                    return ProfileEditContent$lambda$16$lambda$15$lambda$14;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue8);
                        }
                        composer2.endReplaceGroup();
                        UserInfoAdditionalInputKt.m3515UserInfoAdditionalInputk7ZECbw(gender, birthdate, nationality, str, function15, function16, function17, function06, function03, m2383getDoneeUduSuo, (Function0) rememberedValue8, !viewState.getIsLoading(), composer2, ((i7 << 6) & 234881024) | 805306368, 0, 0);
                        composer2.startReplaceGroup(788207807);
                        if (!feature.isEnabled() && viewState.getEditMode() == ProfileEditViewModel.EditMode.EditAuthenticated) {
                            float f8 = 40;
                            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion8, 0.0f, Dp.m2599constructorimpl(f8), 1, null), 0L, 0.0f, null, composer2, 6, 14);
                            int i13 = i7 >> 12;
                            ProfileEditPasswordSectionKt.ProfileEditPasswordSection(function0, !viewState.getIsLoading(), composer2, i13 & 14);
                            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion8, 0.0f, Dp.m2599constructorimpl(f8), 1, null), 0L, 0.0f, null, composer2, 6, 14);
                            String userId = viewState.getUserId();
                            if (userId == null) {
                                userId = BuildConfig.FLAVOR;
                            }
                            ProfileEditDeleteSectionKt.ProfileEditDeleteSection(userId, function02, !viewState.getIsLoading(), composer2, i13 & 112);
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composer2 = startRestartGroup;
                        iUserInfoInputHandler2 = iUserInfoInputHandler;
                    }
                    z9 = true;
                    rememberedValue4 = composer2.rememberedValue();
                    if (!z9) {
                    }
                    rememberedValue4 = new ProfileEditScreenKt$ProfileEditContent$1$7$1(iUserInfoInputHandler2);
                    composer2.updateRememberedValue(rememberedValue4);
                    composer2.endReplaceGroup();
                    Function1 function152 = (Function1) ((KFunction) rememberedValue4);
                    composer2.startReplaceGroup(788192356);
                    if (i12 != 256) {
                    }
                    rememberedValue5 = composer2.rememberedValue();
                    if (!z10) {
                    }
                    rememberedValue5 = new ProfileEditScreenKt$ProfileEditContent$1$8$1(iUserInfoInputHandler2);
                    composer2.updateRememberedValue(rememberedValue5);
                    composer2.endReplaceGroup();
                    Function1 function162 = (Function1) ((KFunction) rememberedValue5);
                    composer2.startReplaceGroup(788194661);
                    if (i12 != 256) {
                    }
                    rememberedValue6 = composer2.rememberedValue();
                    if (!z11) {
                    }
                    rememberedValue6 = new ProfileEditScreenKt$ProfileEditContent$1$9$1(iUserInfoInputHandler2);
                    composer2.updateRememberedValue(rememberedValue6);
                    composer2.endReplaceGroup();
                    Function1 function172 = (Function1) ((KFunction) rememberedValue6);
                    composer2.startReplaceGroup(788196943);
                    if (i12 != 256) {
                    }
                    z5 = true;
                    rememberedValue7 = composer2.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue7 = new Function0() { // from class: K3.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileEditContent$lambda$16$lambda$13$lambda$12;
                            ProfileEditContent$lambda$16$lambda$13$lambda$12 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$13$lambda$12(IUserInfoInputHandler.this);
                            return ProfileEditContent$lambda$16$lambda$13$lambda$12;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                    Function0 function062 = (Function0) rememberedValue7;
                    composer2.endReplaceGroup();
                    int m2383getDoneeUduSuo2 = companion6.m2383getDoneeUduSuo();
                    composer2.startReplaceGroup(788203384);
                    changedInstance2 = composer2.changedInstance(focusManager);
                    rememberedValue8 = composer2.rememberedValue();
                    if (!changedInstance2) {
                    }
                    rememberedValue8 = new Function0() { // from class: K3.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileEditContent$lambda$16$lambda$15$lambda$14;
                            ProfileEditContent$lambda$16$lambda$15$lambda$14 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$15$lambda$14(FocusManager.this);
                            return ProfileEditContent$lambda$16$lambda$15$lambda$14;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                    composer2.endReplaceGroup();
                    UserInfoAdditionalInputKt.m3515UserInfoAdditionalInputk7ZECbw(gender, birthdate, nationality, str, function152, function162, function172, function062, function03, m2383getDoneeUduSuo2, (Function0) rememberedValue8, !viewState.getIsLoading(), composer2, ((i7 << 6) & 234881024) | 805306368, 0, 0);
                    composer2.startReplaceGroup(788207807);
                    if (!feature.isEnabled()) {
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                companion2 = companion7;
                obj = iUserInfoInputHandler;
            }
            z7 = true;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue = new ProfileEditScreenKt$ProfileEditContent$1$4$1(obj);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Function1 function132 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(788172355);
            if (i12 != 256) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue2 = new ProfileEditScreenKt$ProfileEditContent$1$5$1(obj);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            Function1 function142 = (Function1) ((KFunction) rememberedValue2);
            int m2385getNexteUduSuo22 = companion6.m2385getNexteUduSuo();
            startRestartGroup.startReplaceGroup(788175978);
            changedInstance = startRestartGroup.changedInstance(focusManager);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue3 = new Function0() { // from class: K3.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ProfileEditContent$lambda$16$lambda$8$lambda$7;
                    ProfileEditContent$lambda$16$lambda$8$lambda$7 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$8$lambda$7(FocusManager.this);
                    return ProfileEditContent$lambda$16$lambda$8$lambda$7;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion82 = companion2;
            UserInfoNameInputKt.m3517UserInfoNameInputdAaJhyQ(userInfoFormField4, userInfoFormField5, iFormValidator, firstName, lastName, function132, function142, m2385getNexteUduSuo22, (Function0) rememberedValue3, !viewState.getIsLoading(), startRestartGroup, ((i7 >> 3) & 896) | 12582966, 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion82, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            Gender gender2 = userInfoInput.getGender();
            LocalDate birthdate2 = userInfoInput.getBirthdate();
            Locale nationality2 = userInfoInput.getNationality();
            String postalCode2 = userInfoInput.getPostalCode();
            if (postalCode2 != null) {
            }
            startRestartGroup.startReplaceGroup(788190177);
            if (i12 == 256) {
            }
            z9 = true;
            rememberedValue4 = composer2.rememberedValue();
            if (!z9) {
            }
            rememberedValue4 = new ProfileEditScreenKt$ProfileEditContent$1$7$1(iUserInfoInputHandler2);
            composer2.updateRememberedValue(rememberedValue4);
            composer2.endReplaceGroup();
            Function1 function1522 = (Function1) ((KFunction) rememberedValue4);
            composer2.startReplaceGroup(788192356);
            if (i12 != 256) {
            }
            rememberedValue5 = composer2.rememberedValue();
            if (!z10) {
            }
            rememberedValue5 = new ProfileEditScreenKt$ProfileEditContent$1$8$1(iUserInfoInputHandler2);
            composer2.updateRememberedValue(rememberedValue5);
            composer2.endReplaceGroup();
            Function1 function1622 = (Function1) ((KFunction) rememberedValue5);
            composer2.startReplaceGroup(788194661);
            if (i12 != 256) {
            }
            rememberedValue6 = composer2.rememberedValue();
            if (!z11) {
            }
            rememberedValue6 = new ProfileEditScreenKt$ProfileEditContent$1$9$1(iUserInfoInputHandler2);
            composer2.updateRememberedValue(rememberedValue6);
            composer2.endReplaceGroup();
            Function1 function1722 = (Function1) ((KFunction) rememberedValue6);
            composer2.startReplaceGroup(788196943);
            if (i12 != 256) {
            }
            z5 = true;
            rememberedValue7 = composer2.rememberedValue();
            if (!z5) {
            }
            rememberedValue7 = new Function0() { // from class: K3.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ProfileEditContent$lambda$16$lambda$13$lambda$12;
                    ProfileEditContent$lambda$16$lambda$13$lambda$12 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$13$lambda$12(IUserInfoInputHandler.this);
                    return ProfileEditContent$lambda$16$lambda$13$lambda$12;
                }
            };
            composer2.updateRememberedValue(rememberedValue7);
            Function0 function0622 = (Function0) rememberedValue7;
            composer2.endReplaceGroup();
            int m2383getDoneeUduSuo22 = companion6.m2383getDoneeUduSuo();
            composer2.startReplaceGroup(788203384);
            changedInstance2 = composer2.changedInstance(focusManager);
            rememberedValue8 = composer2.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue8 = new Function0() { // from class: K3.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ProfileEditContent$lambda$16$lambda$15$lambda$14;
                    ProfileEditContent$lambda$16$lambda$15$lambda$14 = ProfileEditScreenKt.ProfileEditContent$lambda$16$lambda$15$lambda$14(FocusManager.this);
                    return ProfileEditContent$lambda$16$lambda$15$lambda$14;
                }
            };
            composer2.updateRememberedValue(rememberedValue8);
            composer2.endReplaceGroup();
            UserInfoAdditionalInputKt.m3515UserInfoAdditionalInputk7ZECbw(gender2, birthdate2, nationality2, str, function1522, function1622, function1722, function0622, function03, m2383getDoneeUduSuo22, (Function0) rememberedValue8, !viewState.getIsLoading(), composer2, ((i7 << 6) & 234881024) | 805306368, 0, 0);
            composer2.startReplaceGroup(788207807);
            if (!feature.isEnabled()) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ProfileEditContent$lambda$17;
                    ProfileEditContent$lambda$17 = ProfileEditScreenKt.ProfileEditContent$lambda$17(ScrollState.this, viewState, iUserInfoInputHandler, iFormValidator, function0, function02, function03, function04, function05, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProfileEditContent$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditContent$lambda$16$lambda$13$lambda$12(IUserInfoInputHandler iUserInfoInputHandler) {
        iUserInfoInputHandler.updateNationality(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditContent$lambda$16$lambda$15$lambda$14(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditContent$lambda$16$lambda$4$lambda$3(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditContent$lambda$16$lambda$8$lambda$7(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditContent$lambda$17(ScrollState scrollState, ProfileEditViewModel.ViewState viewState, IUserInfoInputHandler iUserInfoInputHandler, IFormValidator iFormValidator, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i5, Composer composer, int i6) {
        ProfileEditContent(scrollState, viewState, iUserInfoInputHandler, iFormValidator, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileEditScreen(final ProfileEditViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> phoneNumberCodeResultRecipient, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetCustomDismissHandler, "bottomSheetCustomDismissHandler");
        Intrinsics.checkNotNullParameter(phoneNumberCodeResultRecipient, "phoneNumberCodeResultRecipient");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(-1982820599);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetCustomDismissHandler) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(phoneNumberCodeResultRecipient) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1982820599, i7, -1, "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditScreen (ProfileEditScreen.kt:81)");
            }
            composer2 = startRestartGroup;
            bottomSheetCustomDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, ComposableLambdaKt.rememberComposableLambda(-695062244, true, new ProfileEditScreenKt$ProfileEditScreen$1(nationalityResultRecipient, viewModel, phoneNumberCodeResultRecipient, navigator, bottomSheetCustomDismissHandler), startRestartGroup, 54), composer2, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K3.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileEditScreen$lambda$0;
                    ProfileEditScreen$lambda$0 = ProfileEditScreenKt.ProfileEditScreen$lambda$0(ProfileEditViewModel.this, navigator, navController, navBackStackEntry, bottomSheetCustomDismissHandler, phoneNumberCodeResultRecipient, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileEditScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileEditScreen$lambda$0(ProfileEditViewModel profileEditViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, int i5, Composer composer, int i6) {
        ProfileEditScreen(profileEditViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetCustomDismissHandler, resultRecipient, resultRecipient2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<IFormValidator.ValidationKey, IInputValidator> validatorsMap() {
        UserInfoFormField userInfoFormField = UserInfoFormField.FirstName;
        NonEmptyNameValidator nonEmptyNameValidator = NonEmptyNameValidator.INSTANCE;
        return MapsKt.mapOf(TuplesKt.to(userInfoFormField, nonEmptyNameValidator), TuplesKt.to(UserInfoFormField.LastName, nonEmptyNameValidator), TuplesKt.to(UserInfoFormField.Gender, NonNullCustomValidator.Gender.INSTANCE), TuplesKt.to(UserInfoFormField.Birthdate, NonNullCustomValidator.Birthdate.INSTANCE), TuplesKt.to(UserInfoFormField.PostalCode, NonEmptyStringValidator.INSTANCE), TuplesKt.to(UserInfoFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(UserInfoFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(UserInfoFormField.Email, EmailInputValidator.INSTANCE));
    }
}
