package dk.molslinjen.ui.views.screens.profile;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.company.ChangeAccountViewKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileScreenKt$ProfileScreenContent$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ AccountCardData.ActivationPending $accountCardData;
    final /* synthetic */ List<DropdownItem<String>> $accounts;
    final /* synthetic */ List<ApiEnvironment> $availableApis;
    final /* synthetic */ Function0<Unit> $ignorePendingActivation;
    final /* synthetic */ boolean $isAuthenticated;
    final /* synthetic */ Function0<Unit> $navigateToAppPermissions;
    final /* synthetic */ Function0<Unit> $navigateToBrobizz;
    final /* synthetic */ Function0<Unit> $navigateToContact;
    final /* synthetic */ Function0<Unit> $navigateToCreditCards;
    final /* synthetic */ Function0<Unit> $navigateToCurrencies;
    final /* synthetic */ Function0<Unit> $navigateToEditUser;
    final /* synthetic */ Function0<Unit> $navigateToFaq;
    final /* synthetic */ Function0<Unit> $navigateToLogin;
    final /* synthetic */ Function0<Unit> $navigateToNewsLetters;
    final /* synthetic */ Function0<Unit> $navigateToPassenger;
    final /* synthetic */ Function0<Unit> $navigateToSignup;
    final /* synthetic */ Function0<Unit> $navigateToVehicles;
    final /* synthetic */ Function1<DropdownItem<String>, Unit> $onAccountSelected;
    final /* synthetic */ ScrollState $sectionScrollState;
    final /* synthetic */ DropdownItem<String> $selectedAccount;
    final /* synthetic */ ApiEnvironment $selectedApi;
    final /* synthetic */ boolean $shouldShowDeveloperMenu;
    final /* synthetic */ boolean $shouldShowDeveloperSection;
    final /* synthetic */ boolean $showApiSwitcher;
    final /* synthetic */ Function1<ApiEnvironment, Unit> $switchApiEnvironment;
    final /* synthetic */ Function1<Boolean, Unit> $toggleDeveloperMenu;
    final /* synthetic */ Function0<Unit> $triggerLogoutFlow;
    final /* synthetic */ User $user;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileScreenKt$ProfileScreenContent$2(ScrollState scrollState, User user, Function0<Unit> function0, AccountCardData.ActivationPending activationPending, boolean z5, Function0<Unit> function02, Function0<Unit> function03, List<DropdownItem<String>> list, DropdownItem<String> dropdownItem, Function1<? super DropdownItem<String>, Unit> function1, Function0<Unit> function04, Function0<Unit> function05, Function0<Unit> function06, Function0<Unit> function07, Function0<Unit> function08, Function0<Unit> function09, Function0<Unit> function010, Function0<Unit> function011, Function0<Unit> function012, Function0<Unit> function013, boolean z6, ApiEnvironment apiEnvironment, List<? extends ApiEnvironment> list2, Function1<? super ApiEnvironment, Unit> function12, boolean z7, boolean z8, Function1<? super Boolean, Unit> function13, Function0<Unit> function014) {
        this.$sectionScrollState = scrollState;
        this.$user = user;
        this.$navigateToEditUser = function0;
        this.$accountCardData = activationPending;
        this.$isAuthenticated = z5;
        this.$navigateToLogin = function02;
        this.$navigateToSignup = function03;
        this.$accounts = list;
        this.$selectedAccount = dropdownItem;
        this.$onAccountSelected = function1;
        this.$ignorePendingActivation = function04;
        this.$navigateToVehicles = function05;
        this.$navigateToPassenger = function06;
        this.$navigateToCreditCards = function07;
        this.$navigateToBrobizz = function08;
        this.$navigateToFaq = function09;
        this.$navigateToContact = function010;
        this.$navigateToAppPermissions = function011;
        this.$navigateToNewsLetters = function012;
        this.$navigateToCurrencies = function013;
        this.$showApiSwitcher = z6;
        this.$selectedApi = apiEnvironment;
        this.$availableApis = list2;
        this.$switchApiEnvironment = function12;
        this.$shouldShowDeveloperSection = z7;
        this.$shouldShowDeveloperMenu = z8;
        this.$toggleDeveloperMenu = function13;
        this.$triggerLogoutFlow = function014;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1(Function1 function1, boolean z5) {
        function1.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        DropdownItem<String> dropdownItem;
        List<DropdownItem<String>> list;
        Function0<Unit> function0;
        boolean z5;
        Function0<Unit> function02;
        Function0<Unit> function03;
        ApiEnvironment apiEnvironment;
        List<ApiEnvironment> list2;
        Function1<ApiEnvironment, Unit> function1;
        Function1<Boolean, Unit> function12;
        Function0<Unit> function04;
        Function0<Unit> function05;
        ColumnScopeInstance columnScopeInstance;
        Function0<Unit> function06;
        Function1<DropdownItem<String>, Unit> function13;
        Function0<Unit> function07;
        Function0<Unit> function08;
        Function0<Unit> function09;
        boolean z6;
        int i6;
        Function0<Unit> function010;
        Function0<Unit> function011;
        Function0<Unit> function012;
        Function0<Unit> function013;
        int i7;
        int i8;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1029433364, i5, -1, "dk.molslinjen.ui.views.screens.profile.ProfileScreenContent.<anonymous> (ProfileScreen.kt:196)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        AppColor appColor = AppColor.INSTANCE;
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight$default(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, 1, null), this.$sectionScrollState, false, null, false, 14, null);
        User user = this.$user;
        Function0<Unit> function014 = this.$navigateToEditUser;
        AccountCardData.ActivationPending activationPending = this.$accountCardData;
        boolean z7 = this.$isAuthenticated;
        Function0<Unit> function015 = this.$navigateToLogin;
        Function0<Unit> function016 = this.$navigateToSignup;
        List<DropdownItem<String>> list3 = this.$accounts;
        DropdownItem<String> dropdownItem2 = this.$selectedAccount;
        Function1<DropdownItem<String>, Unit> function14 = this.$onAccountSelected;
        Function0<Unit> function017 = this.$ignorePendingActivation;
        Function0<Unit> function018 = this.$navigateToVehicles;
        Function0<Unit> function019 = this.$navigateToPassenger;
        Function0<Unit> function020 = this.$navigateToCreditCards;
        Function0<Unit> function021 = this.$navigateToBrobizz;
        Function0<Unit> function022 = this.$navigateToFaq;
        Function0<Unit> function023 = this.$navigateToContact;
        Function0<Unit> function024 = this.$navigateToAppPermissions;
        Function0<Unit> function025 = this.$navigateToNewsLetters;
        Function0<Unit> function026 = this.$navigateToCurrencies;
        boolean z8 = this.$showApiSwitcher;
        ApiEnvironment apiEnvironment2 = this.$selectedApi;
        List<ApiEnvironment> list4 = this.$availableApis;
        Function1<ApiEnvironment, Unit> function15 = this.$switchApiEnvironment;
        boolean z9 = this.$shouldShowDeveloperSection;
        boolean z10 = this.$shouldShowDeveloperMenu;
        Function1<Boolean, Unit> function16 = this.$toggleDeveloperMenu;
        Function0<Unit> function027 = this.$triggerLogoutFlow;
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(-649980430);
        UserInfo details = user.getDetails();
        if (details == null || details.getIsEmpty()) {
            dropdownItem = dropdownItem2;
            list = list3;
            function0 = function015;
            z5 = z7;
            function02 = function022;
            function03 = function023;
            apiEnvironment = apiEnvironment2;
            list2 = list4;
            function1 = function15;
            function12 = function16;
            function04 = function027;
            function05 = function026;
            columnScopeInstance = columnScopeInstance2;
            function06 = function016;
        } else {
            dropdownItem = dropdownItem2;
            list = list3;
            ProfileUserViewKt.ProfileUserView(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), user, function014, composer, 6, 0);
            if (Feature.Account.isEnabled()) {
                function0 = function015;
                z5 = z7;
                function02 = function022;
                function03 = function023;
                apiEnvironment = apiEnvironment2;
                list2 = list4;
                function1 = function15;
                function12 = function16;
                function04 = function027;
                function05 = function026;
                columnScopeInstance = columnScopeInstance2;
                function06 = function016;
                function13 = function14;
                function07 = function018;
                function08 = function019;
                function09 = function025;
                z6 = z8;
                i6 = 0;
                function010 = function021;
                function011 = function024;
                function012 = function017;
                function013 = function020;
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                composer.startReplaceGroup(-649967918);
                if (Feature.Account.isEnabled()) {
                    if (activationPending != null) {
                        composer.startReplaceGroup(1325922598);
                        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3281getWhite0d7_KjU(), null, 2, null);
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, i6);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, i6);
                        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor2);
                        } else {
                            composer.useNode();
                        }
                        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer);
                        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier2, companion3.getSetModifier());
                        AccountActivationPendingCardKt.AccountActivationPendingCard(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(16), 0.0f, 2, null), activationPending, function012, composer, 6, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer, 6);
                        composer.endNode();
                        composer.endReplaceGroup();
                    } else if (!z5) {
                        composer.startReplaceGroup(1326540211);
                        ProfileLoginHeaderKt.ProfileLoginHeader(function0, function06, composer, i6);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1326776214);
                        composer.endReplaceGroup();
                    }
                }
                composer.endReplaceGroup();
                composer.startReplaceGroup(-649936242);
                if (list != null || dropdownItem == null) {
                    i7 = 2;
                    i8 = 24;
                } else {
                    i7 = 2;
                    i8 = 24;
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                    ChangeAccountViewKt.ChangeAccountView(dropdownItem, list, function13, composer, i6);
                }
                composer.endReplaceGroup();
                float f5 = i8;
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, i7, null);
                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, i6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, i6);
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (!composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy3, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion3.getSetModifier());
                float f6 = 8;
                ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f6), 4, null), R.string.profile_section_myMolslinjen, composer, 54, i6);
                ProfileScreenKt.MyMolslinjenSection(z5, function07, function08, function013, function010, composer, 0);
                ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f6), 4, null), R.string.profile_section_helpAndSupport, composer, 54, i6);
                ProfileScreenKt.HelpAndSupportSection(function02, function03, composer, i6);
                ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f6), 4, null), R.string.profile_section_settings, composer, 54, i6);
                ProfileScreenKt.Permissions(z5, function011, function09, function05, composer, 0);
                composer.startReplaceGroup(635082394);
                if (z5) {
                    final Function0<Unit> function028 = function04;
                    ProfileScreenKt.SectionWrapper(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), ComposableLambdaKt.rememberComposableLambda(-1285540777, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.ProfileScreenKt$ProfileScreenContent$2$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1285540777, i9, -1, "dk.molslinjen.ui.views.screens.profile.ProfileScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:279)");
                            }
                            ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_logout, R.string.profile_logoutTitle, function028, false, composer2, 54, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 54, i6);
                }
                composer.endReplaceGroup();
                ColumnScopeInstance columnScopeInstance3 = columnScopeInstance;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_about_title, composer, 6), columnScopeInstance3.align(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), companion2.getCenterHorizontally()), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 384, 1572864, 65528);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_about_address_info, composer, 6) + "\n" + ProfileScreenKt.appVersion(), columnScopeInstance3.align(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(64), 5, null), companion2.getCenterHorizontally()), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65016);
                composer.startReplaceGroup(635120664);
                if (z6) {
                    ProfileScreenKt.ApiSwitcher(apiEnvironment, list2, function1, composer, 0);
                }
                composer.endReplaceGroup();
                composer.startReplaceGroup(635129833);
                if (z9) {
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                    composer.startReplaceGroup(635137286);
                    final Function1<Boolean, Unit> function17 = function12;
                    boolean changed = composer.changed(function17);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1;
                                invoke$lambda$4$lambda$3$lambda$2$lambda$1 = ProfileScreenKt$ProfileScreenContent$2.invoke$lambda$4$lambda$3$lambda$2$lambda$1(Function1.this, ((Boolean) obj).booleanValue());
                                return invoke$lambda$4$lambda$3$lambda$2$lambda$1;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    ProfileDeveloperMenuRowKt.ProfileDeveloperMenuRow(m315paddingqDBjuR0$default, z10, (Function1) rememberedValue, composer, 6, 0);
                }
                composer.endReplaceGroup();
                composer.endNode();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    return;
                }
                ComposerKt.traceEventEnd();
                return;
            }
            function0 = function015;
            z5 = z7;
            function02 = function022;
            function03 = function023;
            apiEnvironment = apiEnvironment2;
            list2 = list4;
            function1 = function15;
            function12 = function16;
            function04 = function027;
            function05 = function026;
            columnScopeInstance = columnScopeInstance2;
            function06 = function016;
        }
        function13 = function14;
        function07 = function018;
        function08 = function019;
        function09 = function025;
        z6 = z8;
        i6 = 0;
        function010 = function021;
        function011 = function024;
        function012 = function017;
        function013 = function020;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-649967918);
        if (Feature.Account.isEnabled()) {
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-649936242);
        if (list != null) {
        }
        i7 = 2;
        i8 = 24;
        composer.endReplaceGroup();
        float f52 = i8;
        Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f52), 0.0f, i7, null);
        MeasurePolicy columnMeasurePolicy32 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, i6);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, i6);
        CompositionLocalMap currentCompositionLocalMap32 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default2);
        Function0<ComposeUiNode> constructor32 = companion3.getConstructor();
        if (composer.getApplier() == null) {
        }
        composer.startReusableNode();
        if (!composer.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy32, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion3.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion3.getSetModifier());
        float f62 = 8;
        ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f62), Dp.m2599constructorimpl(f52), 0.0f, Dp.m2599constructorimpl(f62), 4, null), R.string.profile_section_myMolslinjen, composer, 54, i6);
        ProfileScreenKt.MyMolslinjenSection(z5, function07, function08, function013, function010, composer, 0);
        ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f62), Dp.m2599constructorimpl(f52), 0.0f, Dp.m2599constructorimpl(f62), 4, null), R.string.profile_section_helpAndSupport, composer, 54, i6);
        ProfileScreenKt.HelpAndSupportSection(function02, function03, composer, i6);
        ProfileScreenKt.SectionTitle(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f62), Dp.m2599constructorimpl(f52), 0.0f, Dp.m2599constructorimpl(f62), 4, null), R.string.profile_section_settings, composer, 54, i6);
        ProfileScreenKt.Permissions(z5, function011, function09, function05, composer, 0);
        composer.startReplaceGroup(635082394);
        if (z5) {
        }
        composer.endReplaceGroup();
        ColumnScopeInstance columnScopeInstance32 = columnScopeInstance;
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_about_title, composer, 6), columnScopeInstance32.align(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null), companion2.getCenterHorizontally()), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 384, 1572864, 65528);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_about_address_info, composer, 6) + "\n" + ProfileScreenKt.appVersion(), columnScopeInstance32.align(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f62), 0.0f, Dp.m2599constructorimpl(64), 5, null), companion2.getCenterHorizontally()), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65016);
        composer.startReplaceGroup(635120664);
        if (z6) {
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(635129833);
        if (z9) {
        }
        composer.endReplaceGroup();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
    }
}
