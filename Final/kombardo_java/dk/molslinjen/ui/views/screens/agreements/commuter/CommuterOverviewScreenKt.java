package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.BornholmCommuterCardViewKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundCommuterCardViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ao\u0010\f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "navigateToAddCommuterAgreement", "Lkotlin/Function1;", BuildConfig.FLAVOR, "navigateToBornholmCommuterDetails", "navigateToOeresundCommuterDetails", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "navigateToOrderTicket", "navigateToLogin", "CommuterOverviewScreen", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommuterOverviewScreenKt {
    public static final void CommuterOverviewScreen(final CommuterOverviewViewModel viewModel, final Function0<Unit> navigateToAddCommuterAgreement, final Function1<? super String, Unit> navigateToBornholmCommuterDetails, final Function1<? super String, Unit> navigateToOeresundCommuterDetails, final Function1<? super BornholmCommuterAgreement, Unit> navigateToOrderTicket, final Function0<Unit> navigateToLogin, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigateToAddCommuterAgreement, "navigateToAddCommuterAgreement");
        Intrinsics.checkNotNullParameter(navigateToBornholmCommuterDetails, "navigateToBornholmCommuterDetails");
        Intrinsics.checkNotNullParameter(navigateToOeresundCommuterDetails, "navigateToOeresundCommuterDetails");
        Intrinsics.checkNotNullParameter(navigateToOrderTicket, "navigateToOrderTicket");
        Intrinsics.checkNotNullParameter(navigateToLogin, "navigateToLogin");
        Composer startRestartGroup = composer.startRestartGroup(-1770660600);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToAddCommuterAgreement) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToBornholmCommuterDetails) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOeresundCommuterDetails) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOrderTicket) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToLogin) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1770660600, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreen (CommuterOverviewScreen.kt:42)");
            }
            final CommuterOverviewViewModel.ViewState viewState = (CommuterOverviewViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, Dp.m2599constructorimpl(20), 0.0f, Dp.m2599constructorimpl(32), 5, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(24));
            startRestartGroup.startReplaceGroup(-148353282);
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32) | ((458752 & i6) == 131072) | ((i6 & 7168) == 2048) | ((i6 & 896) == 256) | ((i6 & 57344) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: p2.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CommuterOverviewScreen$lambda$3$lambda$2;
                        CommuterOverviewScreen$lambda$3$lambda$2 = CommuterOverviewScreenKt.CommuterOverviewScreen$lambda$3$lambda$2(CommuterOverviewViewModel.ViewState.this, viewModel, navigateToAddCommuterAgreement, navigateToLogin, navigateToOeresundCommuterDetails, navigateToBornholmCommuterDetails, navigateToOrderTicket, (LazyListScope) obj);
                        return CommuterOverviewScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue = function1;
            }
            Function1 function12 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(fillMaxHeight$default, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, function12, composer2, 24966, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommuterOverviewScreen$lambda$4;
                    CommuterOverviewScreen$lambda$4 = CommuterOverviewScreenKt.CommuterOverviewScreen$lambda$4(CommuterOverviewViewModel.this, navigateToAddCommuterAgreement, navigateToBornholmCommuterDetails, navigateToOeresundCommuterDetails, navigateToOrderTicket, navigateToLogin, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CommuterOverviewScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterOverviewScreen$lambda$3$lambda$2(CommuterOverviewViewModel.ViewState viewState, final CommuterOverviewViewModel commuterOverviewViewModel, final Function0 function0, final Function0 function02, final Function1 function1, final Function1 function12, final Function1 function13, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (!viewState.getIsBornholmLoading() || !viewState.getIsOeresundLoading()) {
            if (viewState.getHasOeresundError()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1775722094, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$1$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer, int i5) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((i5 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1775722094, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreen.<anonymous>.<anonymous>.<anonymous> (CommuterOverviewScreen.kt:53)");
                        }
                        String stringResource = StringResources_androidKt.stringResource(R.string.commuter_load_error_oeresund, composer, 6);
                        CommuterOverviewViewModel commuterOverviewViewModel2 = CommuterOverviewViewModel.this;
                        composer.startReplaceGroup(984432083);
                        boolean changedInstance = composer.changedInstance(commuterOverviewViewModel2);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new CommuterOverviewScreenKt$CommuterOverviewScreen$1$1$1$1$1(commuterOverviewViewModel2);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        CommuterOverviewErrorViewKt.CommuterOverviewErrorView(stringResource, (Function0) ((KFunction) rememberedValue), composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }
            if (viewState.getHasBornholmError()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1440349385, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer, int i5) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((i5 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1440349385, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreen.<anonymous>.<anonymous>.<anonymous> (CommuterOverviewScreen.kt:62)");
                        }
                        String stringResource = StringResources_androidKt.stringResource(R.string.commuter_load_error_bornholm, composer, 6);
                        CommuterOverviewViewModel commuterOverviewViewModel2 = CommuterOverviewViewModel.this;
                        composer.startReplaceGroup(984442739);
                        boolean changedInstance = composer.changedInstance(commuterOverviewViewModel2);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new CommuterOverviewScreenKt$CommuterOverviewScreen$1$1$2$1$1(commuterOverviewViewModel2);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        CommuterOverviewErrorViewKt.CommuterOverviewErrorView(stringResource, (Function0) ((KFunction) rememberedValue), composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-822547337, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$1$1$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    CreationExtras creationExtras;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-822547337, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreen.<anonymous>.<anonymous>.<anonymous> (CommuterOverviewScreen.kt:70)");
                    }
                    composer.startReplaceableGroup(1890788296);
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                    if (current != null) {
                        ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                        composer.startReplaceableGroup(1729797275);
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            creationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CommuterAddAgreementsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        CommuterAddAgreementsContainerKt.CommuterAddAgreementsContainer((CommuterAddAgreementsViewModel) viewModel, function0, function02, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }), 3, null);
            final List<OeresundCommuterAgreement> oeresundAgreements = viewState.getOeresundAgreements();
            final CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$1 commuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(OeresundCommuterAgreement oeresundCommuterAgreement) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((OeresundCommuterAgreement) obj);
                }
            };
            LazyColumn.items(oeresundAgreements.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(oeresundAgreements.get(i5));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$4
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
                    OeresundCommuterAgreement oeresundCommuterAgreement = (OeresundCommuterAgreement) oeresundAgreements.get(i5);
                    composer.startReplaceGroup(453410842);
                    OeresundCommuterCardViewKt.OeresundCommuterCardView(oeresundCommuterAgreement, function1, composer, 0);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            final List<BornholmCommuterAgreement> bornholmAgreements = viewState.getBornholmAgreements();
            final CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$5 commuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$5 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$5
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(BornholmCommuterAgreement bornholmCommuterAgreement) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((BornholmCommuterAgreement) obj);
                }
            };
            LazyColumn.items(bornholmAgreements.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(bornholmAgreements.get(i5));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt$CommuterOverviewScreen$lambda$3$lambda$2$$inlined$items$default$8
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
                    BornholmCommuterAgreement bornholmCommuterAgreement = (BornholmCommuterAgreement) bornholmAgreements.get(i5);
                    composer.startReplaceGroup(453622231);
                    BornholmCommuterCardViewKt.BornholmCommuterCardView(bornholmCommuterAgreement, function12, function13, composer, 0);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        if (viewState.getIsBornholmLoading() || viewState.getIsOeresundLoading()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CommuterOverviewScreenKt.INSTANCE.m3429getLambda1$app_kombardoProd(), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CommuterOverviewScreenKt.INSTANCE.m3430getLambda2$app_kombardoProd(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterOverviewScreen$lambda$4(CommuterOverviewViewModel commuterOverviewViewModel, Function0 function0, Function1 function1, Function1 function12, Function1 function13, Function0 function02, int i5, Composer composer, int i6) {
        CommuterOverviewScreen(commuterOverviewViewModel, function0, function1, function12, function13, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
