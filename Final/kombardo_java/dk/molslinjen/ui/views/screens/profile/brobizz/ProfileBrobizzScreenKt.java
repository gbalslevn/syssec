package dk.molslinjen.ui.views.screens.profile.brobizz;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
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
import com.ramcosta.composedestinations.generated.destinations.ProfileBrobizzRegisterScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.Brobizz;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreenKt;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000e\u001a\u00020\u0004*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileBrobizzScreen", "(Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/Brobizz;", "brobizzList", "Lkotlin/Function1;", BuildConfig.FLAVOR, "triggerRemoveFlow", "profileBrobizzContent", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "brobizz", "ProfileBrobizzRow", "(Ldk/molslinjen/domain/model/account/Brobizz;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileBrobizzScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileBrobizzRow(final Brobizz brobizz, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1048941165);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(brobizz) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(-1048941165, i7, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzRow (ProfileBrobizzScreen.kt:89)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(20));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_profile_brobizz, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5)), null, null, 0.0f, null, startRestartGroup, 384, 120);
            float f6 = 16;
            TextKt.m940Text4IGK_g(brobizz.getSpacedBrobizzNumber(), PaddingKt.m313paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65532);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null);
            float m2599constructorimpl = Dp.m2599constructorimpl(f6);
            long m3266getGrey30d7_KjU = AppColor.INSTANCE.m3266getGrey30d7_KjU();
            startRestartGroup.startReplaceGroup(-234589525);
            boolean changedInstance = startRestartGroup.changedInstance(brobizz) | ((i7 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: D3.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileBrobizzRow$lambda$15$lambda$14$lambda$13;
                        ProfileBrobizzRow$lambda$15$lambda$14$lambda$13 = ProfileBrobizzScreenKt.ProfileBrobizzRow$lambda$15$lambda$14$lambda$13(Function1.this, brobizz);
                        return ProfileBrobizzRow$lambda$15$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(m315paddingqDBjuR0$default, R.drawable.icon_delete, (Function0) rememberedValue, 0.0f, m2599constructorimpl, 0L, m3266getGrey30d7_KjU, 0L, null, composer2, 1597494, 424);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileBrobizzRow$lambda$16;
                    ProfileBrobizzRow$lambda$16 = ProfileBrobizzScreenKt.ProfileBrobizzRow$lambda$16(Brobizz.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileBrobizzRow$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzRow$lambda$15$lambda$14$lambda$13(Function1 function1, Brobizz brobizz) {
        function1.invoke(brobizz.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzRow$lambda$16(Brobizz brobizz, Function1 function1, int i5, Composer composer, int i6) {
        ProfileBrobizzRow(brobizz, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileBrobizzScreen(final ProfileBrobizzViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z5;
        boolean z6;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-2110275631);
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
                ComposerKt.traceEventStart(-2110275631, i9, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreen (ProfileBrobizzScreen.kt:35)");
            }
            ProfileBrobizzViewModel.ViewState viewState = (ProfileBrobizzViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final String brobizzToRemove = viewState.getBrobizzToRemove();
            startRestartGroup.startReplaceGroup(-1514295017);
            if (brobizzToRemove != null) {
                boolean isDeleteLoading = viewState.getIsDeleteLoading();
                String stringResource = StringResources_androidKt.stringResource(R.string.profile_brobizz_deleteDialog_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_brobizz_deleteDialog_cta, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1514283897);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changed(brobizzToRemove);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: D3.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileBrobizzScreen$lambda$1$lambda$0;
                            ProfileBrobizzScreen$lambda$1$lambda$0 = ProfileBrobizzScreenKt.ProfileBrobizzScreen$lambda$1$lambda$0(ProfileBrobizzViewModel.this, brobizzToRemove);
                            return ProfileBrobizzScreen$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1514281486);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new ProfileBrobizzScreenKt$ProfileBrobizzScreen$2$1(viewModel);
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
            final List<Brobizz> brobizz = viewState.getBrobizzState().getBrobizz();
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_brobizzTitle, startRestartGroup, i7);
            boolean isEmpty = brobizz.isEmpty();
            startRestartGroup.startReplaceGroup(-1514270702);
            int i10 = i8 & 112;
            boolean z7 = i10 == 32 ? z5 : z6;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfileBrobizzScreenKt$ProfileBrobizzScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1514269230);
            boolean z8 = i10 == 32 ? z5 : z6;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfileBrobizzScreenKt$ProfileBrobizzScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            String stringResource4 = StringResources_androidKt.stringResource(R.string.profile_brobizz_emptyDescription, startRestartGroup, i7);
            String stringResource5 = StringResources_androidKt.stringResource(R.string.profile_brobizz_register, startRestartGroup, i7);
            startRestartGroup.startReplaceGroup(-1514260038);
            boolean z9 = i10 == 32 ? z5 : z6;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: D3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileBrobizzScreen$lambda$7$lambda$6;
                        ProfileBrobizzScreen$lambda$7$lambda$6 = ProfileBrobizzScreenKt.ProfileBrobizzScreen$lambda$7$lambda$6(DestinationsNavigator.this);
                        return ProfileBrobizzScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function04 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1514257701);
            boolean changedInstance3 = startRestartGroup.changedInstance(brobizz) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: D3.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileBrobizzScreen$lambda$9$lambda$8;
                        ProfileBrobizzScreen$lambda$9$lambda$8 = ProfileBrobizzScreenKt.ProfileBrobizzScreen$lambda$9$lambda$8(brobizz, viewModel, (LazyListScope) obj);
                        return ProfileBrobizzScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ProfileAssetsContainerKt.ProfileAssetsListContainer(stringResource3, null, isLoading, isEmpty, function02, function03, R.drawable.icon_profile_brobizz, stringResource4, null, stringResource5, function04, null, (Function1) rememberedValue6, composer2, 1572864, 0, 2306);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileBrobizzScreen$lambda$10;
                    ProfileBrobizzScreen$lambda$10 = ProfileBrobizzScreenKt.ProfileBrobizzScreen$lambda$10(ProfileBrobizzViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileBrobizzScreen$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzScreen$lambda$1$lambda$0(ProfileBrobizzViewModel profileBrobizzViewModel, String str) {
        profileBrobizzViewModel.removeBrobizz(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzScreen$lambda$10(ProfileBrobizzViewModel profileBrobizzViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileBrobizzScreen(profileBrobizzViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzScreen$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileBrobizzRegisterScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzScreen$lambda$9$lambda$8(List list, ProfileBrobizzViewModel profileBrobizzViewModel, LazyListScope ProfileAssetsListContainer) {
        Intrinsics.checkNotNullParameter(ProfileAssetsListContainer, "$this$ProfileAssetsListContainer");
        profileBrobizzContent(ProfileAssetsListContainer, list, new ProfileBrobizzScreenKt$ProfileBrobizzScreen$6$1$1(profileBrobizzViewModel));
        return Unit.INSTANCE;
    }

    private static final void profileBrobizzContent(LazyListScope lazyListScope, final List<Brobizz> list, final Function1<? super String, Unit> function1) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$ProfileBrobizzScreenKt.INSTANCE.m3503getLambda1$app_kombardoProd(), 3, null);
        final Function1 function12 = new Function1() { // from class: D3.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object profileBrobizzContent$lambda$11;
                profileBrobizzContent$lambda$11 = ProfileBrobizzScreenKt.profileBrobizzContent$lambda$11((Brobizz) obj);
                return profileBrobizzContent$lambda$11;
            }
        };
        final ProfileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$1 profileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Brobizz brobizz) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Brobizz) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$2
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
        }, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzScreenKt$profileBrobizzContent$$inlined$items$default$4
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
                Brobizz brobizz = (Brobizz) list.get(i5);
                composer.startReplaceGroup(-1763406671);
                ProfileBrobizzScreenKt.ProfileBrobizzRow(brobizz, function1, composer, 0);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object profileBrobizzContent$lambda$11(Brobizz it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }
}
