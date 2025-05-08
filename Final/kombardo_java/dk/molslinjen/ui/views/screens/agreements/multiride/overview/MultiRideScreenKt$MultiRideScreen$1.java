package dk.molslinjen.ui.views.screens.agreements.multiride.overview;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideScreenKt$MultiRideScreen$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function0<Unit> $navigateToAddExistingMultiRide;
    final /* synthetic */ Function1<String, Unit> $navigateToDetails;
    final /* synthetic */ Function1<MultiRideCard, Unit> $navigateToOrderTicket;
    final /* synthetic */ Function0<Unit> $navigateToPurchaseMultiRide;
    final /* synthetic */ Function1<String, Unit> $navigateToRefillMultiRide;
    final /* synthetic */ MultiRideOverviewViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiRideScreenKt$MultiRideScreen$1(LazyListState lazyListState, MultiRideOverviewViewModel.ViewState viewState, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1, Function1<? super MultiRideCard, Unit> function12, Function1<? super String, Unit> function13) {
        this.$lazyListState = lazyListState;
        this.$viewState = viewState;
        this.$navigateToPurchaseMultiRide = function0;
        this.$navigateToAddExistingMultiRide = function02;
        this.$navigateToDetails = function1;
        this.$navigateToOrderTicket = function12;
        this.$navigateToRefillMultiRide = function13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(MultiRideOverviewViewModel.ViewState viewState, final Function0 function0, final Function0 function02, final Function1 function1, final Function1 function12, final Function1 function13, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<MultiRideCard> multiRideCards = viewState.getMultiRideCards();
        boolean isEmpty = multiRideCards.isEmpty();
        if (!isEmpty) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(325293380, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$1$1$1
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
                        ComposerKt.traceEventStart(325293380, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiRideScreen.kt:71)");
                    }
                    OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, StringResources_androidKt.stringResource(R.string.agreements_purchaseMultiRide, composer, 6), R.drawable.icon_plus_circled, AppColor.INSTANCE.m3269getGrey60d7_KjU(), 0L, 0L, function0, composer, 3456, 49);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(213886335, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$1$1$2
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
                    ComposerKt.traceEventStart(213886335, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiRideScreen.kt:81)");
                }
                OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, StringResources_androidKt.stringResource(R.string.agreements_addExisting_multiRide, composer, 6), R.drawable.icon_plus_circled, AppColor.INSTANCE.m3269getGrey60d7_KjU(), 0L, 0L, function02, composer, 3456, 49);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        if (isEmpty) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-776134204, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$1$1$4
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
                        ComposerKt.traceEventStart(-776134204, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiRideScreen.kt:101)");
                    }
                    MultiRideScreenKt.EmptyStateCard(function0, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        } else {
            final MultiRideScreenKt$MultiRideScreen$1$invoke$lambda$2$lambda$1$$inlined$items$default$1 multiRideScreenKt$MultiRideScreen$1$invoke$lambda$2$lambda$1$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$invoke$lambda$2$lambda$1$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(MultiRideCard multiRideCard) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((MultiRideCard) obj);
                }
            };
            LazyColumn.items(multiRideCards.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$invoke$lambda$2$lambda$1$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(multiRideCards.get(i5));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt$MultiRideScreen$1$invoke$lambda$2$lambda$1$$inlined$items$default$4
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
                    MultiRideCard multiRideCard = (MultiRideCard) multiRideCards.get(i5);
                    composer.startReplaceGroup(1274793558);
                    MultiRideOverviewCardKt.MultiRideOverviewCard(multiRideCard, function1, function12, function13, composer, 0);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
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
            ComposerKt.traceEventStart(-2014423917, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreen.<anonymous> (MultiRideScreen.kt:59)");
        }
        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
        PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, Dp.m2599constructorimpl(20), 0.0f, Dp.m2599constructorimpl(32), 5, null);
        Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16));
        LazyListState lazyListState = this.$lazyListState;
        composer.startReplaceGroup(-1098993273);
        boolean changedInstance = composer.changedInstance(this.$viewState) | composer.changed(this.$navigateToPurchaseMultiRide) | composer.changed(this.$navigateToAddExistingMultiRide) | composer.changed(this.$navigateToDetails) | composer.changed(this.$navigateToOrderTicket) | composer.changed(this.$navigateToRefillMultiRide);
        final MultiRideOverviewViewModel.ViewState viewState = this.$viewState;
        final Function0<Unit> function0 = this.$navigateToPurchaseMultiRide;
        final Function0<Unit> function02 = this.$navigateToAddExistingMultiRide;
        final Function1<String, Unit> function1 = this.$navigateToDetails;
        final Function1<MultiRideCard, Unit> function12 = this.$navigateToOrderTicket;
        final Function1<String, Unit> function13 = this.$navigateToRefillMultiRide;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.overview.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = MultiRideScreenKt$MultiRideScreen$1.invoke$lambda$2$lambda$1(MultiRideOverviewViewModel.ViewState.this, function0, function02, function1, function12, function13, (LazyListScope) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        LazyDslKt.LazyColumn(fillMaxHeight$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue, composer, 24966, 232);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
