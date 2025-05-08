package dk.molslinjen.ui.views.screens.profile.creditcards;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.extensions.domain.CreditCardTypeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsScreenKt;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\r\u001a\u00020\u0004*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileCreditCardsScreen", "(Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCard;", "creditCards", "Lkotlin/Function1;", "triggerDeleteFlow", "profileCreditCardsContent", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "creditCard", "ProfileCreditCardRow", "(Ldk/molslinjen/domain/model/account/CreditCard;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileCreditCardsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileCreditCardRow(final CreditCard creditCard, final Function1<? super CreditCard, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-589004483);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(creditCard) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-589004483, i7, -1, "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardRow (ProfileCreditCardsScreen.kt:104)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            float f6 = 16;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(CreditCardTypeExtensionsKt.getIcon(creditCard.getCardType()), startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), SizeKt.m336width3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null), Dp.m2599constructorimpl(f5)), null, null, 0.0f, null, startRestartGroup, 384, 120);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(CreditCardTypeExtensionsKt.getTitle(creditCard.getCardType()), startRestartGroup, 0), null, creditCard.isExpired() ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65530);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(creditCard.getAdjustedMaskedNumber(), null, creditCard.isExpired() ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65530);
            composer2.startReplaceGroup(172493025);
            if (creditCard.isExpired()) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_creditCard_expired, composer2, 6), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 432, 1572864, 65528);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null);
            float m2599constructorimpl = Dp.m2599constructorimpl(f6);
            long m3266getGrey30d7_KjU = AppColor.INSTANCE.m3266getGrey30d7_KjU();
            composer2.startReplaceGroup(-1108386730);
            boolean changedInstance = composer2.changedInstance(creditCard) | ((i7 & 112) == 32);
            Object rememberedValue = composer2.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: I3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileCreditCardRow$lambda$14$lambda$13$lambda$12;
                        ProfileCreditCardRow$lambda$14$lambda$13$lambda$12 = ProfileCreditCardsScreenKt.ProfileCreditCardRow$lambda$14$lambda$13$lambda$12(Function1.this, creditCard);
                        return ProfileCreditCardRow$lambda$14$lambda$13$lambda$12;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(m315paddingqDBjuR0$default, R.drawable.icon_delete, (Function0) rememberedValue, 0.0f, m2599constructorimpl, 0L, m3266getGrey30d7_KjU, 0L, null, composer2, 1597494, 424);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileCreditCardRow$lambda$15;
                    ProfileCreditCardRow$lambda$15 = ProfileCreditCardsScreenKt.ProfileCreditCardRow$lambda$15(CreditCard.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileCreditCardRow$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileCreditCardRow$lambda$14$lambda$13$lambda$12(Function1 function1, CreditCard creditCard) {
        function1.invoke(creditCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileCreditCardRow$lambda$15(CreditCard creditCard, Function1 function1, int i5, Composer composer, int i6) {
        ProfileCreditCardRow(creditCard, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileCreditCardsScreen(final ProfileCreditCardsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z5;
        boolean z6;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(735920425);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i9 = i6;
        if ((i9 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735920425, i9, -1, "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsScreen (ProfileCreditCardsScreen.kt:39)");
            }
            ProfileCreditCardsViewModel.ViewState viewState = (ProfileCreditCardsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final CreditCard cardToDelete = viewState.getCardToDelete();
            startRestartGroup.startReplaceGroup(-514103129);
            if (cardToDelete != null) {
                boolean isDeleteLoading = viewState.getIsDeleteLoading();
                String stringResource = StringResources_androidKt.stringResource(R.string.profile_creditCard_deleteDialog_title, new Object[]{StringResources_androidKt.stringResource(CreditCardTypeExtensionsKt.getTitle(cardToDelete.getCardType()), startRestartGroup, 0), cardToDelete.getAdjustedMaskedNumber()}, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_creditCard_deleteDialog_cta, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-514085596);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(cardToDelete);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: I3.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileCreditCardsScreen$lambda$1$lambda$0;
                            ProfileCreditCardsScreen$lambda$1$lambda$0 = ProfileCreditCardsScreenKt.ProfileCreditCardsScreen$lambda$1$lambda$0(ProfileCreditCardsViewModel.this, cardToDelete);
                            return ProfileCreditCardsScreen$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-514082282);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$2$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                i7 = 6;
                z5 = true;
                z6 = false;
                i8 = i9;
                DeleteDialogKt.DeleteDialog(stringResource, null, stringResource2, null, isDeleteLoading, function0, (Function0) ((KFunction) rememberedValue2), startRestartGroup, 0, 10);
            } else {
                i7 = 6;
                z5 = true;
                z6 = false;
                i8 = i9;
            }
            startRestartGroup.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            final List<CreditCard> creditCards = viewState.getUserCreditCardsState().getCreditCards();
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_creditCardsTitle, startRestartGroup, i7);
            boolean isEmpty = creditCards.isEmpty();
            startRestartGroup.startReplaceGroup(-514070862);
            int i10 = i8 & 112;
            boolean z7 = i10 == 32 ? z5 : z6;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-514069390);
            boolean z8 = i10 == 32 ? z5 : z6;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            String stringResource4 = StringResources_androidKt.stringResource(R.string.profile_creditCard_emptyDescription, startRestartGroup, i7);
            String stringResource5 = StringResources_androidKt.stringResource(R.string.profile_creditCard_emptySubDescription, startRestartGroup, i7);
            startRestartGroup.startReplaceGroup(-514060237);
            boolean changedInstance3 = startRestartGroup.changedInstance(creditCards) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: I3.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileCreditCardsScreen$lambda$7$lambda$6;
                        ProfileCreditCardsScreen$lambda$7$lambda$6 = ProfileCreditCardsScreenKt.ProfileCreditCardsScreen$lambda$7$lambda$6(creditCards, viewModel, (LazyListScope) obj);
                        return ProfileCreditCardsScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ProfileAssetsContainerKt.ProfileAssetsListContainer(stringResource3, null, isLoading, isEmpty, function02, function03, R.drawable.icon_profile_credit_cards, stringResource4, stringResource5, null, null, null, (Function1) rememberedValue5, composer2, 1572864, 0, 3586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileCreditCardsScreen$lambda$8;
                    ProfileCreditCardsScreen$lambda$8 = ProfileCreditCardsScreenKt.ProfileCreditCardsScreen$lambda$8(ProfileCreditCardsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileCreditCardsScreen$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileCreditCardsScreen$lambda$1$lambda$0(ProfileCreditCardsViewModel profileCreditCardsViewModel, CreditCard creditCard) {
        profileCreditCardsViewModel.deleteCard(creditCard.getCardId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileCreditCardsScreen$lambda$7$lambda$6(List list, ProfileCreditCardsViewModel profileCreditCardsViewModel, LazyListScope ProfileAssetsListContainer) {
        Intrinsics.checkNotNullParameter(ProfileAssetsListContainer, "$this$ProfileAssetsListContainer");
        profileCreditCardsContent(ProfileAssetsListContainer, list, new ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$5$1$1(profileCreditCardsViewModel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileCreditCardsScreen$lambda$8(ProfileCreditCardsViewModel profileCreditCardsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileCreditCardsScreen(profileCreditCardsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void profileCreditCardsContent(LazyListScope lazyListScope, final List<CreditCard> list, final Function1<? super CreditCard, Unit> function1) {
        ComposableSingletons$ProfileCreditCardsScreenKt composableSingletons$ProfileCreditCardsScreenKt = ComposableSingletons$ProfileCreditCardsScreenKt.INSTANCE;
        LazyListScope.item$default(lazyListScope, "description", null, composableSingletons$ProfileCreditCardsScreenKt.m3504getLambda1$app_kombardoProd(), 2, null);
        LazyListScope.item$default(lazyListScope, null, null, composableSingletons$ProfileCreditCardsScreenKt.m3505getLambda2$app_kombardoProd(), 3, null);
        final ProfileCreditCardsScreenKt$profileCreditCardsContent$$inlined$items$default$1 profileCreditCardsScreenKt$profileCreditCardsContent$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsScreenKt$profileCreditCardsContent$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CreditCard creditCard) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CreditCard) obj);
            }
        };
        lazyListScope.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsScreenKt$profileCreditCardsContent$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(list.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsScreenKt$profileCreditCardsContent$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                CreditCard creditCard = (CreditCard) list.get(i5);
                composer.startReplaceGroup(1816518448);
                ProfileCreditCardsScreenKt.ProfileCreditCardRow(creditCard, function1, composer, 0);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
