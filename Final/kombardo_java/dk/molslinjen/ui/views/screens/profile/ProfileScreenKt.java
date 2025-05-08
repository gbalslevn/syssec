package dk.molslinjen.ui.views.screens.profile;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.ContactScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CurrenciesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FaqScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.LoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PermissionsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileBrobizzScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileCreditCardsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileNewslettersScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengersScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehiclesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.LoadingDialogKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.ProfileScreenKt;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a»\u0003\u0010/\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0018\u00010\t2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u001a\u001a\u00020\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0013H\u0003¢\u0006\u0004\b/\u00100\u001a9\u00101\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0013H\u0003¢\u0006\u0004\b1\u00102\u001a\r\u00103\u001a\u00020\u000b¢\u0006\u0004\b3\u00104\u001a'\u00108\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u0002052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0003¢\u0006\u0004\b8\u00109\u001a#\u0010<\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u0002052\b\b\u0001\u0010;\u001a\u00020:H\u0003¢\u0006\u0004\b<\u0010=\u001aO\u0010>\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0003¢\u0006\u0004\b>\u0010?\u001a+\u0010@\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0003¢\u0006\u0004\b@\u0010A\u001aA\u0010B\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0003¢\u0006\u0004\bB\u0010C\u001a;\u0010H\u001a\u00020\u00042\b\b\u0001\u0010D\u001a\u00020:2\b\b\u0001\u0010E\u001a\u00020:2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\b\b\u0002\u0010G\u001a\u00020\u000eH\u0003¢\u0006\u0004\bH\u0010I¨\u0006J"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileScreen", "(Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/account/user/User;", "user", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", BuildConfig.FLAVOR, "accounts", "selectedAccount", BuildConfig.FLAVOR, "isAuthenticated", "showLogoutDialog", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "accountCardData", "Lkotlin/Function1;", "onAccountSelected", "shouldShowDeveloperSection", "shouldShowDeveloperMenu", "showApiSwitcher", "Ldk/molslinjen/core/ApiEnvironment;", "availableApis", "selectedApi", "toggleDeveloperMenu", "Lkotlin/Function0;", "navigateToEditUser", "navigateToLogin", "navigateToSignup", "navigateToVehicles", "navigateToPassenger", "navigateToCreditCards", "navigateToBrobizz", "navigateToContact", "navigateToNewsLetters", "navigateToCurrencies", "navigateToAppPermissions", "navigateToFaq", "ignorePendingActivation", "dismiss", "triggerLogoutFlow", "cancelLogoutFlow", "logout", "switchApiEnvironment", "ProfileScreenContent", "(Ldk/molslinjen/domain/model/account/user/User;Ljava/util/List;Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;ZZLdk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;Lkotlin/jvm/functions/Function1;ZZZLjava/util/List;Ldk/molslinjen/core/ApiEnvironment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;IIII)V", "ApiSwitcher", "(Ldk/molslinjen/core/ApiEnvironment;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "appVersion", "()Ljava/lang/String;", "Landroidx/compose/ui/Modifier;", "modifier", "content", "SectionWrapper", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "titleRes", "SectionTitle", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "MyMolslinjenSection", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HelpAndSupportSection", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Permissions", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "icon", Constants.IntentExtra.PushTitle, "onClick", "showChevron", "ProfileSectionRow", "(IILkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    public static final void ApiSwitcher(final ApiEnvironment apiEnvironment, final List<? extends ApiEnvironment> list, final Function1<? super ApiEnvironment, Unit> function1, Composer composer, final int i5) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1578770226);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(apiEnvironment) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578770226, i7, -1, "dk.molslinjen.ui.views.screens.profile.ApiSwitcher (ProfileScreen.kt:324)");
            }
            TextKt.m940Text4IGK_g("Change API", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 6, 1572864, 65534);
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8));
            Composer composer3 = startRestartGroup;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), Alignment.INSTANCE.getTop(), composer3, 6);
            ?? r14 = 0;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m311padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (composer3.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer3.startReplaceGroup(-1228466779);
            for (final ApiEnvironment apiEnvironment2 : list) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                composer3.startReplaceGroup(202936502);
                Object rememberedValue = composer3.rememberedValue();
                Composer.Companion companion3 = Composer.INSTANCE;
                if (rememberedValue == companion3.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(rememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                composer3.endReplaceGroup();
                composer3.startReplaceGroup(202938764);
                int i8 = i7 & 896;
                boolean changed = (i8 == 256 ? true : r14) | composer3.changed(apiEnvironment2);
                Object rememberedValue2 = composer3.rememberedValue();
                if (changed || rememberedValue2 == companion3.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: v3.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ApiSwitcher$lambda$45$lambda$44$lambda$40$lambda$39;
                            ApiSwitcher$lambda$45$lambda$44$lambda$40$lambda$39 = ProfileScreenKt.ApiSwitcher$lambda$45$lambda$44$lambda$40$lambda$39(Function1.this, apiEnvironment2);
                            return ApiSwitcher$lambda$45$lambda$44$lambda$40$lambda$39;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue2);
                }
                composer3.endReplaceGroup();
                Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(companion2, mutableInteractionSource, null, false, null, null, (Function0) rememberedValue2, 28, null);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(4)), Alignment.INSTANCE.getCenterVertically(), composer3, 54);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, r14);
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m120clickableO2vRcR0$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                boolean z5 = apiEnvironment2 == apiEnvironment;
                composer3.startReplaceGroup(1108878583);
                boolean changed2 = (i8 == 256) | composer3.changed(apiEnvironment2);
                Object rememberedValue3 = composer3.rememberedValue();
                if (changed2 || rememberedValue3 == companion3.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: v3.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ApiSwitcher$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41;
                            ApiSwitcher$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41 = ProfileScreenKt.ApiSwitcher$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41(Function1.this, apiEnvironment2, ((Boolean) obj).booleanValue());
                            return ApiSwitcher$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue3);
                }
                composer3.endReplaceGroup();
                Composer composer4 = composer3;
                SelectionControlKt.SelectionControl(null, z5, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.RadioButton, false, composer3, 1572864, 185);
                TextKt.m940Text4IGK_g(apiEnvironment2.name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer4, 0, 1572864, 65534);
                composer4.endNode();
                r14 = 0;
                composer3 = composer4;
            }
            composer2 = composer3;
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ApiSwitcher$lambda$46;
                    ApiSwitcher$lambda$46 = ProfileScreenKt.ApiSwitcher$lambda$46(ApiEnvironment.this, list, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ApiSwitcher$lambda$46;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ApiSwitcher$lambda$45$lambda$44$lambda$40$lambda$39(Function1 function1, ApiEnvironment apiEnvironment) {
        function1.invoke(apiEnvironment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ApiSwitcher$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41(Function1 function1, ApiEnvironment apiEnvironment, boolean z5) {
        function1.invoke(apiEnvironment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ApiSwitcher$lambda$46(ApiEnvironment apiEnvironment, List list, Function1 function1, int i5, Composer composer, int i6) {
        ApiSwitcher(apiEnvironment, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HelpAndSupportSection(final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1036935707);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1036935707, i6, -1, "dk.molslinjen.ui.views.screens.profile.HelpAndSupportSection (ProfileScreen.kt:403)");
            }
            SectionWrapper(null, ComposableLambdaKt.rememberComposableLambda(-1897314847, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.ProfileScreenKt$HelpAndSupportSection$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1897314847, i7, -1, "dk.molslinjen.ui.views.screens.profile.HelpAndSupportSection.<anonymous> (ProfileScreen.kt:405)");
                    }
                    ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_faq, R.string.profile_faqTitle, function0, false, composer2, 54, 8);
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                    ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_contact, R.string.profile_contactTitle, function02, false, composer2, 54, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.C
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HelpAndSupportSection$lambda$52;
                    HelpAndSupportSection$lambda$52 = ProfileScreenKt.HelpAndSupportSection$lambda$52(Function0.this, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HelpAndSupportSection$lambda$52;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HelpAndSupportSection$lambda$52(Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        HelpAndSupportSection(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MyMolslinjenSection(final boolean z5, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-2082373477);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2082373477, i6, -1, "dk.molslinjen.ui.views.screens.profile.MyMolslinjenSection (ProfileScreen.kt:386)");
            }
            SectionWrapper(null, ComposableLambdaKt.rememberComposableLambda(-1751980649, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.ProfileScreenKt$MyMolslinjenSection$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1751980649, i7, -1, "dk.molslinjen.ui.views.screens.profile.MyMolslinjenSection.<anonymous> (ProfileScreen.kt:388)");
                    }
                    composer2.startReplaceGroup(-1592524767);
                    Feature feature = Feature.OnlyWalkingPassengers;
                    if (!feature.isEnabled()) {
                        ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_vehicles, R.string.profile_vehiclesTitle, function0, false, composer2, 54, 8);
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                    }
                    composer2.endReplaceGroup();
                    ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_passengers, R.string.profile_passengersTitle, function02, false, composer2, 54, 8);
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                    ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_credit_cards, R.string.profile_creditCardsTitle, function03, false, composer2, 54, 8);
                    if (z5 && !feature.isEnabled()) {
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                        ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_brobizz, R.string.profile_brobizzTitle, function04, false, composer2, 54, 8);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.A
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MyMolslinjenSection$lambda$51;
                    MyMolslinjenSection$lambda$51 = ProfileScreenKt.MyMolslinjenSection$lambda$51(z5, function0, function02, function03, function04, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MyMolslinjenSection$lambda$51;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyMolslinjenSection$lambda$51(boolean z5, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i5, Composer composer, int i6) {
        MyMolslinjenSection(z5, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Permissions(final boolean z5, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1670927931);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1670927931, i6, -1, "dk.molslinjen.ui.views.screens.profile.Permissions (ProfileScreen.kt:417)");
            }
            SectionWrapper(null, ComposableLambdaKt.rememberComposableLambda(1508218305, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.ProfileScreenKt$Permissions$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1508218305, i7, -1, "dk.molslinjen.ui.views.screens.profile.Permissions.<anonymous> (ProfileScreen.kt:419)");
                    }
                    ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_app_permissions, R.string.profile_appPermissionsTitle, function0, false, composer2, 54, 8);
                    composer2.startReplaceGroup(-1925803303);
                    if (Feature.MultipleCurrencies.isEnabled()) {
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                        ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_currencies, R.string.profile_currenciesTitle, function03, false, composer2, 54, 8);
                    }
                    composer2.endReplaceGroup();
                    if (z5) {
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                        ProfileScreenKt.ProfileSectionRow(R.drawable.icon_profile_newsletters, R.string.profile_newslettersTitle, function02, false, composer2, 54, 8);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Permissions$lambda$53;
                    Permissions$lambda$53 = ProfileScreenKt.Permissions$lambda$53(z5, function0, function02, function03, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Permissions$lambda$53;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Permissions$lambda$53(boolean z5, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        Permissions(z5, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileScreen(final ProfileViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1292617485);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1292617485, i6, -1, "dk.molslinjen.ui.views.screens.profile.ProfileScreen (ProfileScreen.kt:85)");
            }
            boolean showDeveloperSection = viewModel.getShowDeveloperSection();
            boolean showApiSwitcher = viewModel.getShowApiSwitcher();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(viewModel.getShowDeveloperMenu(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            ProfileViewModel.ViewState viewState = (ProfileViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-2126794896);
            if (viewState.getIsChangingAccount()) {
                LoadingDialogKt.LoadingDialog(StringResources_androidKt.stringResource(R.string.profile_company_changingProfile, startRestartGroup, 6), startRestartGroup, 0, 0);
            }
            startRestartGroup.endReplaceGroup();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            User user = viewState.getUser();
            List<DropdownItem<String>> accounts = viewState.getAccounts();
            DropdownItem<String> selectedAccount = viewState.getSelectedAccount();
            boolean isAuthenticated = viewState.getIsAuthenticated();
            boolean showLogoutDialog = viewState.getShowLogoutDialog();
            AccountCardData.ActivationPending accountCardData = viewState.getAccountCardData();
            List<ApiEnvironment> availableApis = viewState.getAvailableApis();
            ApiEnvironment selectedApi = viewState.getSelectedApi();
            startRestartGroup.startReplaceGroup(-2126770617);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ProfileScreenKt$ProfileScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126736563);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ProfileScreenKt$ProfileScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126734846);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfileScreenKt$ProfileScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126733147);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfileScreenKt$ProfileScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction2 = (KFunction) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126731386);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new ProfileScreenKt$ProfileScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction3 = (KFunction) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126729924);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new ProfileScreenKt$ProfileScreen$6$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction4 = (KFunction) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) kFunction;
            startRestartGroup.startReplaceGroup(-2126768688);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: v3.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileScreen$lambda$7$lambda$6;
                        ProfileScreen$lambda$7$lambda$6 = ProfileScreenKt.ProfileScreen$lambda$7$lambda$6(ProfileViewModel.this, ((Boolean) obj).booleanValue());
                        return ProfileScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function1 function12 = (Function1) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126766497);
            boolean z6 = i7 == 32;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: v3.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$9$lambda$8;
                        ProfileScreen$lambda$9$lambda$8 = ProfileScreenKt.ProfileScreen$lambda$9$lambda$8(DestinationsNavigator.this);
                        return ProfileScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function0 function03 = (Function0) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126763943);
            boolean z7 = i7 == 32;
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new Function0() { // from class: v3.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$11$lambda$10;
                        ProfileScreen$lambda$11$lambda$10 = ProfileScreenKt.ProfileScreen$lambda$11$lambda$10(DestinationsNavigator.this);
                        return ProfileScreen$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            Function0 function04 = (Function0) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126761542);
            boolean z8 = i7 == 32;
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: v3.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$13$lambda$12;
                        ProfileScreen$lambda$13$lambda$12 = ProfileScreenKt.ProfileScreen$lambda$13$lambda$12(DestinationsNavigator.this);
                        return ProfileScreen$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            Function0 function05 = (Function0) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126759037);
            boolean z9 = i7 == 32;
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: v3.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$15$lambda$14;
                        ProfileScreen$lambda$15$lambda$14 = ProfileScreenKt.ProfileScreen$lambda$15$lambda$14(DestinationsNavigator.this);
                        return ProfileScreen$lambda$15$lambda$14;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            Function0 function06 = (Function0) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126756219);
            boolean z10 = i7 == 32;
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: v3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$17$lambda$16;
                        ProfileScreen$lambda$17$lambda$16 = ProfileScreenKt.ProfileScreen$lambda$17$lambda$16(DestinationsNavigator.this);
                        return ProfileScreen$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            Function0 function07 = (Function0) rememberedValue12;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126753274);
            boolean z11 = i7 == 32;
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = new Function0() { // from class: v3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$19$lambda$18;
                        ProfileScreen$lambda$19$lambda$18 = ProfileScreenKt.ProfileScreen$lambda$19$lambda$18(DestinationsNavigator.this);
                        return ProfileScreen$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            Function0 function08 = (Function0) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126750430);
            boolean z12 = i7 == 32;
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = new Function0() { // from class: v3.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$21$lambda$20;
                        ProfileScreen$lambda$21$lambda$20 = ProfileScreenKt.ProfileScreen$lambda$21$lambda$20(DestinationsNavigator.this);
                        return ProfileScreen$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            Function0 function09 = (Function0) rememberedValue14;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126747704);
            boolean z13 = i7 == 32;
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                rememberedValue15 = new Function0() { // from class: v3.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$23$lambda$22;
                        ProfileScreen$lambda$23$lambda$22 = ProfileScreenKt.ProfileScreen$lambda$23$lambda$22(DestinationsNavigator.this);
                        return ProfileScreen$lambda$23$lambda$22;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            Function0 function010 = (Function0) rememberedValue15;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126744666);
            boolean z14 = i7 == 32;
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (z14 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                rememberedValue16 = new Function0() { // from class: v3.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$25$lambda$24;
                        ProfileScreen$lambda$25$lambda$24 = ProfileScreenKt.ProfileScreen$lambda$25$lambda$24(DestinationsNavigator.this);
                        return ProfileScreen$lambda$25$lambda$24;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            Function0 function011 = (Function0) rememberedValue16;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126725730);
            boolean z15 = i7 == 32;
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (z15 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                rememberedValue17 = new Function0() { // from class: v3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$27$lambda$26;
                        ProfileScreen$lambda$27$lambda$26 = ProfileScreenKt.ProfileScreen$lambda$27$lambda$26(DestinationsNavigator.this);
                        return ProfileScreen$lambda$27$lambda$26;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            Function0 function012 = (Function0) rememberedValue17;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126741601);
            boolean z16 = i7 == 32;
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (z16 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: v3.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$29$lambda$28;
                        ProfileScreen$lambda$29$lambda$28 = ProfileScreenKt.ProfileScreen$lambda$29$lambda$28(DestinationsNavigator.this);
                        return ProfileScreen$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            Function0 function013 = (Function0) rememberedValue18;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2126739113);
            boolean z17 = i7 == 32;
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (z17 || rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                rememberedValue19 = new Function0() { // from class: v3.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileScreen$lambda$31$lambda$30;
                        ProfileScreen$lambda$31$lambda$30 = ProfileScreenKt.ProfileScreen$lambda$31$lambda$30(DestinationsNavigator.this);
                        return ProfileScreen$lambda$31$lambda$30;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            Function0 function014 = (Function0) rememberedValue19;
            startRestartGroup.endReplaceGroup();
            Function0 function015 = (Function0) kFunction2;
            Function0 function016 = (Function0) kFunction3;
            Function0 function017 = (Function0) kFunction4;
            startRestartGroup.startReplaceGroup(-2126728294);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue20 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                rememberedValue20 = new Function1() { // from class: v3.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileScreen$lambda$33$lambda$32;
                        ProfileScreen$lambda$33$lambda$32 = ProfileScreenKt.ProfileScreen$lambda$33$lambda$32(ProfileViewModel.this, context, (ApiEnvironment) obj);
                        return ProfileScreen$lambda$33$lambda$32;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ProfileScreenContent(user, accounts, selectedAccount, isAuthenticated, showLogoutDialog, accountCardData, function1, showDeveloperSection, booleanValue, showApiSwitcher, availableApis, selectedApi, function12, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function0, function02, function015, function016, function017, (Function1) rememberedValue20, composer2, 0, 0, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileScreen$lambda$34;
                    ProfileScreen$lambda$34 = ProfileScreenKt.ProfileScreen$lambda$34(ProfileViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileScreen$lambda$34;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$11$lambda$10(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, LoginScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$13$lambda$12(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SignupScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$15$lambda$14(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileVehiclesScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$17$lambda$16(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfilePassengersScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$19$lambda$18(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileCreditCardsScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$21$lambda$20(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileBrobizzScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$23$lambda$22(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ContactScreenDestination.INSTANCE.invoke((Site) null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$25$lambda$24(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileNewslettersScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$27$lambda$26(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CurrenciesScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$29$lambda$28(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PermissionsScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$31$lambda$30(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FaqScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$33$lambda$32(ProfileViewModel profileViewModel, Context context, ApiEnvironment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        profileViewModel.switchApiEnvironment(it, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$34(ProfileViewModel profileViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileScreen(profileViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$7$lambda$6(ProfileViewModel profileViewModel, boolean z5) {
        profileViewModel.toggleDeveloperMenu(z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$9$lambda$8(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileEditScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void ProfileScreenContent(final User user, final List<DropdownItem<String>> list, final DropdownItem<String> dropdownItem, final boolean z5, final boolean z6, final AccountCardData.ActivationPending activationPending, final Function1<? super DropdownItem<String>, Unit> function1, final boolean z7, final boolean z8, final boolean z9, final List<? extends ApiEnvironment> list2, final ApiEnvironment apiEnvironment, final Function1<? super Boolean, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, final Function0<Unit> function06, final Function0<Unit> function07, final Function0<Unit> function08, final Function0<Unit> function09, final Function0<Unit> function010, final Function0<Unit> function011, final Function0<Unit> function012, final Function0<Unit> function013, final Function0<Unit> function014, final Function0<Unit> function015, final Function0<Unit> function016, final Function0<Unit> function017, final Function1<? super ApiEnvironment, Unit> function13, Composer composer, final int i5, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        String stringResource;
        Composer startRestartGroup = composer.startRestartGroup(-678846527);
        if ((i5 & 6) == 0) {
            i9 = (startRestartGroup.changedInstance(user) ? 4 : 2) | i5;
        } else {
            i9 = i5;
        }
        if ((i5 & 48) == 0) {
            i9 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i9 |= startRestartGroup.changed(dropdownItem) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i9 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i9 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i9 |= startRestartGroup.changed(activationPending) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i9 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i9 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i9 |= startRestartGroup.changed(z8) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i9 |= startRestartGroup.changed(z9) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i10 = i6 | (startRestartGroup.changedInstance(list2) ? 4 : 2);
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= startRestartGroup.changed(apiEnvironment) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i10 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i10 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i10 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i10 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i10 |= startRestartGroup.changedInstance(function05) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i10 |= startRestartGroup.changedInstance(function06) ? 67108864 : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i10 |= startRestartGroup.changedInstance(function07) ? 536870912 : 268435456;
        }
        int i13 = i10;
        if ((i7 & 6) == 0) {
            i11 = i7 | (startRestartGroup.changedInstance(function08) ? 4 : 2);
        } else {
            i11 = i7;
        }
        if ((i7 & 48) == 0) {
            i11 |= startRestartGroup.changedInstance(function09) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i11 |= startRestartGroup.changedInstance(function010) ? 256 : 128;
        }
        if ((i7 & 3072) == 0) {
            i11 |= startRestartGroup.changedInstance(function011) ? 2048 : 1024;
        }
        if ((i7 & 24576) == 0) {
            i11 |= startRestartGroup.changedInstance(function012) ? 16384 : 8192;
        }
        if ((i7 & 196608) == 0) {
            i11 |= startRestartGroup.changedInstance(function013) ? 131072 : 65536;
        }
        if ((i7 & 1572864) == 0) {
            i11 |= startRestartGroup.changedInstance(function014) ? 1048576 : 524288;
        }
        if ((i7 & 12582912) == 0) {
            i11 |= startRestartGroup.changedInstance(function015) ? 8388608 : 4194304;
        }
        if ((i7 & 100663296) == 0) {
            i11 |= startRestartGroup.changedInstance(function016) ? 67108864 : 33554432;
        }
        if ((i7 & 805306368) == 0) {
            i11 |= startRestartGroup.changedInstance(function017) ? 536870912 : 268435456;
        }
        int i14 = i11;
        if ((i8 & 6) == 0) {
            i12 = i8 | (startRestartGroup.changedInstance(function13) ? 4 : 2);
        } else {
            i12 = i8;
        }
        if ((i9 & 306783379) == 306783378 && (306783379 & i13) == 306783378 && (i14 & 306783379) == 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-678846527, i9, i13, "dk.molslinjen.ui.views.screens.profile.ProfileScreenContent (ProfileScreen.kt:166)");
            }
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(1398514435);
            if (z6) {
                String stringResource2 = StringResources_androidKt.stringResource(R.string.logout_dialog_title, startRestartGroup, 6);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_logoutTitle, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(1398522431);
                boolean changedInstance = ((i14 & 1879048192) == 536870912) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberScrollState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: v3.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileScreenContent$lambda$36$lambda$35;
                            ProfileScreenContent$lambda$36$lambda$35 = ProfileScreenKt.ProfileScreenContent$lambda$36$lambda$35(Function0.this, coroutineScope, rememberScrollState);
                            return ProfileScreenContent$lambda$36$lambda$35;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                DeleteDialogKt.DeleteDialog(stringResource2, null, stringResource3, null, false, (Function0) rememberedValue2, function016, startRestartGroup, ((i14 >> 6) & 3670016) | 24576, 10);
            }
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (Feature.Account.isEnabled()) {
                startRestartGroup.startReplaceGroup(404846353);
                stringResource = StringResources_androidKt.stringResource(R.string.profile_title, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(404919048);
                stringResource = StringResources_androidKt.stringResource(R.string.profile_title_kombardo, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, function014, rememberScrollState, null, ComposableLambdaKt.rememberComposableLambda(1029433364, true, new ProfileScreenKt$ProfileScreenContent$2(rememberScrollState, user, function0, activationPending, z5, function02, function03, list, dropdownItem, function1, function013, function04, function05, function06, function07, function012, function08, function011, function09, function010, z9, apiEnvironment, list2, function13, z7, z8, function12, function015), startRestartGroup, 54), startRestartGroup, (i14 & 3670016) | 805306374, 314);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileScreenContent$lambda$37;
                    ProfileScreenContent$lambda$37 = ProfileScreenKt.ProfileScreenContent$lambda$37(User.this, list, dropdownItem, z5, z6, activationPending, function1, z7, z8, z9, list2, apiEnvironment, function12, function0, function02, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, function016, function017, function13, i5, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileScreenContent$lambda$37;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreenContent$lambda$36$lambda$35(Function0 function0, CoroutineScope coroutineScope, ScrollState scrollState) {
        function0.invoke();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ProfileScreenKt$ProfileScreenContent$1$1$1(scrollState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileScreenContent$lambda$37(User user, List list, DropdownItem dropdownItem, boolean z5, boolean z6, AccountCardData.ActivationPending activationPending, Function1 function1, boolean z7, boolean z8, boolean z9, List list2, ApiEnvironment apiEnvironment, Function1 function12, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, Function0 function010, Function0 function011, Function0 function012, Function0 function013, Function0 function014, Function0 function015, Function0 function016, Function0 function017, Function1 function13, int i5, int i6, int i7, int i8, Composer composer, int i9) {
        ProfileScreenContent(user, list, dropdownItem, z5, z6, activationPending, function1, z7, z8, z9, list2, apiEnvironment, function12, function0, function02, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, function016, function017, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7), RecomposeScopeImplKt.updateChangedFlags(i8));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileSectionRow(final int i5, final int i6, final Function0<Unit> function0, boolean z5, Composer composer, final int i7, final int i8) {
        int i9;
        boolean z6;
        int i10;
        boolean z7;
        boolean z8;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(277967277);
        if ((i8 & 1) != 0) {
            i9 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i9 = (startRestartGroup.changed(i5) ? 4 : 2) | i7;
        } else {
            i9 = i7;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i7 & 48) == 0) {
            i9 |= startRestartGroup.changed(i6) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            i9 |= 384;
        } else if ((i7 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i11 = i8 & 8;
        if (i11 != 0) {
            i9 |= 3072;
        } else if ((i7 & 3072) == 0) {
            z6 = z5;
            i9 |= startRestartGroup.changed(z6) ? 2048 : 1024;
            i10 = i9;
            if ((i10 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                z7 = i11 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(277967277, i10, -1, "dk.molslinjen.ui.views.screens.profile.ProfileSectionRow (ProfileScreen.kt:437)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(companion, Dp.m2599constructorimpl(64), 0.0f, 2, null);
                startRestartGroup.startReplaceGroup(-185346463);
                z8 = (i10 & 896) == 256;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: v3.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileSectionRow$lambda$55$lambda$54;
                            ProfileSectionRow$lambda$55$lambda$54 = ProfileScreenKt.ProfileSectionRow$lambda$55$lambda$54(Function0.this);
                            return ProfileSectionRow$lambda$55$lambda$54;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                float f5 = 16;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m327heightInVpY3zN4$default, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5));
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Painter painterResource = PainterResources_androidKt.painterResource(i5, startRestartGroup, i10 & 14);
                Accessibility accessibility = Accessibility.INSTANCE;
                ImageKt.Image(painterResource, accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i6, startRestartGroup, (i10 >> 3) & 14), PaddingKt.m313paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65532);
                startRestartGroup.startReplaceGroup(-376109277);
                if (z7) {
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_right, startRestartGroup, 6), accessibility.getSkip(), (Modifier) null, AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), startRestartGroup, 3072, 4);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final boolean z9 = z6;
                endRestartGroup.updateScope(new Function2() { // from class: v3.v
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ProfileSectionRow$lambda$57;
                        ProfileSectionRow$lambda$57 = ProfileScreenKt.ProfileSectionRow$lambda$57(i5, i6, function0, z9, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                        return ProfileSectionRow$lambda$57;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        i10 = i9;
        if ((i10 & 1171) == 1170) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier m327heightInVpY3zN4$default2 = SizeKt.m327heightInVpY3zN4$default(companion3, Dp.m2599constructorimpl(64), 0.0f, 2, null);
        startRestartGroup.startReplaceGroup(-185346463);
        if ((i10 & 896) == 256) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z8) {
        }
        rememberedValue = new Function0() { // from class: v3.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ProfileSectionRow$lambda$55$lambda$54;
                ProfileSectionRow$lambda$55$lambda$54 = ProfileScreenKt.ProfileSectionRow$lambda$55$lambda$54(Function0.this);
                return ProfileSectionRow$lambda$55$lambda$54;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        float f52 = 16;
        Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m327heightInVpY3zN4$default2, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f52));
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        Painter painterResource2 = PainterResources_androidKt.painterResource(i5, startRestartGroup, i10 & 14);
        Accessibility accessibility2 = Accessibility.INSTANCE;
        ImageKt.Image(painterResource2, accessibility2.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i6, startRestartGroup, (i10 >> 3) & 14), PaddingKt.m313paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance2, companion3, 1.0f, false, 2, null), Dp.m2599constructorimpl(f52), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65532);
        startRestartGroup.startReplaceGroup(-376109277);
        if (z7) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z7;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileSectionRow$lambda$55$lambda$54(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileSectionRow$lambda$57(int i5, int i6, Function0 function0, boolean z5, int i7, int i8, Composer composer, int i9) {
        ProfileSectionRow(i5, i6, function0, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionTitle(Modifier modifier, final int i5, Composer composer, final int i6, final int i7) {
        final Modifier modifier2;
        int i8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1426873940);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        int i10 = i8;
        if ((i10 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            Modifier modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426873940, i10, -1, "dk.molslinjen.ui.views.screens.profile.SectionTitle (ProfileScreen.kt:370)");
            }
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, startRestartGroup, (i10 >> 3) & 14), modifier3, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, ((i10 << 3) & 112) | 384, 1572864, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SectionTitle$lambda$50;
                    SectionTitle$lambda$50 = ProfileScreenKt.SectionTitle$lambda$50(Modifier.this, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return SectionTitle$lambda$50;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionTitle$lambda$50(Modifier modifier, int i5, int i6, int i7, Composer composer, int i8) {
        SectionTitle(modifier, i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionWrapper(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(991684525);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((2 & i6) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(991684525, i7, -1, "dk.molslinjen.ui.views.screens.profile.SectionWrapper (ProfileScreen.kt:358)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i9 = MaterialTheme.$stable;
            Modifier clip = ClipKt.clip(modifier, materialTheme.getShapes(startRestartGroup, i9).getMedium());
            AppColor appColor = AppColor.INSTANCE;
            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(BackgroundKt.m104backgroundbw27NRU$default(clip, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), materialTheme.getShapes(startRestartGroup, i9).getMedium());
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf((i7 >> 3) & 14));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.B
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SectionWrapper$lambda$49;
                    SectionWrapper$lambda$49 = ProfileScreenKt.SectionWrapper$lambda$49(Modifier.this, function2, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SectionWrapper$lambda$49;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionWrapper$lambda$49(Modifier modifier, Function2 function2, int i5, int i6, Composer composer, int i7) {
        SectionWrapper(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001d, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String appVersion() {
        String str;
        String description = Environment.INSTANCE.current().description();
        if (description != null) {
            str = description + " ";
        }
        str = BuildConfig.FLAVOR;
        return str + "2.14.1 (100000362)";
    }
}
