package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.ui.theme.TypographyKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $agreementId;
    final /* synthetic */ int $header;
    final /* synthetic */ Function2<String, String, Unit> $showTicketDetails;
    final /* synthetic */ TicketCategoryType $ticketCategory;
    final /* synthetic */ List<IAgreementDeparture> $tickets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1(int i5, String str, List<? extends IAgreementDeparture> list, TicketCategoryType ticketCategoryType, Function2<? super String, ? super String, Unit> function2) {
        this.$header = i5;
        this.$agreementId = str;
        this.$tickets = list;
        this.$ticketCategory = ticketCategoryType;
        this.$showTicketDetails = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(final List list, final int i5, final String str, final TicketCategoryType ticketCategoryType, final Function2 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1462900869, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1$1$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i6 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1462900869, i6, -1, "dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AgreementTicketHistoryContent.kt:38)");
                }
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), composer, 0, 1572864, 65534);
                TextKt.m940Text4IGK_g("#" + str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 0, 1572864, 65534);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl((float) 26)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        if (list == null || !list.isEmpty()) {
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i6) {
                    list.get(i6);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1$invoke$lambda$2$lambda$1$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i6, Composer composer, int i7) {
                    int i8;
                    if ((i7 & 6) == 0) {
                        i8 = (composer.changed(lazyItemScope) ? 4 : 2) | i7;
                    } else {
                        i8 = i7;
                    }
                    if ((i7 & 48) == 0) {
                        i8 |= composer.changed(i6) ? 32 : 16;
                    }
                    if ((i8 & 147) == 146 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1091073711, i8, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                    }
                    IAgreementDeparture iAgreementDeparture = (IAgreementDeparture) list.get(i6);
                    composer.startReplaceGroup(554441010);
                    composer.startReplaceGroup(-813399076);
                    if (i6 > 0) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                    }
                    composer.endReplaceGroup();
                    AgreementDepartureRowViewKt.AgreementDepartureRowView(iAgreementDeparture, ticketCategoryType, function2, true, composer, 3072);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        } else {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AgreementTicketHistoryContentKt.INSTANCE.m3428getLambda1$app_kombardoProd(), 3, null);
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
            ComposerKt.traceEventStart(146480025, i5, -1, "dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContent.<anonymous> (AgreementTicketHistoryContent.kt:34)");
        }
        float f5 = 16;
        PaddingValues m307PaddingValuesYgX7TsA = PaddingKt.m307PaddingValuesYgX7TsA(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5));
        composer.startReplaceGroup(-172820013);
        boolean changed = composer.changed(this.$header) | composer.changed(this.$agreementId) | composer.changedInstance(this.$tickets) | composer.changed(this.$ticketCategory) | composer.changed(this.$showTicketDetails);
        final List<IAgreementDeparture> list = this.$tickets;
        final int i6 = this.$header;
        final String str = this.$agreementId;
        final TicketCategoryType ticketCategoryType = this.$ticketCategory;
        final Function2<String, String, Unit> function2 = this.$showTicketDetails;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.common.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1.invoke$lambda$2$lambda$1(list, i6, str, ticketCategoryType, function2, (LazyListScope) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        LazyDslKt.LazyColumn(null, null, m307PaddingValuesYgX7TsA, false, null, null, null, false, (Function1) rememberedValue, composer, 384, 251);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
