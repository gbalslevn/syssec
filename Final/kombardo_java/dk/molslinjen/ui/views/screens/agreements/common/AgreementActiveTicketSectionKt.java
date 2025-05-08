package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\u0012\u001a\u00020\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "T", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "sectionTitle", "emptyStateDescription", BuildConfig.FLAVOR, "isLoadingTickets", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategory", BuildConfig.FLAVOR, "tickets", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showDetails", "Lkotlin/Function0;", "onShowHistory", "agreementActiveTicketsSection", "(Landroidx/compose/foundation/lazy/LazyListScope;IIZLdk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AgreementActiveTicketSectionKt {
    public static final <T extends IAgreementDeparture> void agreementActiveTicketsSection(LazyListScope lazyListScope, final int i5, final int i6, boolean z5, final TicketCategoryType ticketCategory, final List<? extends T> list, final Function2<? super String, ? super String, Unit> showDetails, final Function0<Unit> onShowHistory) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(ticketCategory, "ticketCategory");
        Intrinsics.checkNotNullParameter(showDetails, "showDetails");
        Intrinsics.checkNotNullParameter(onShowHistory, "onShowHistory");
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-117405969, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt$agreementActiveTicketsSection$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i7) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i7 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-117405969, i7, -1, "dk.molslinjen.ui.views.screens.agreements.common.agreementActiveTicketsSection.<anonymous> (AgreementActiveTicketSection.kt:33)");
                }
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, composer, 0), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(32), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer, 48, 1572864, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        if (!z5 && list != null) {
            if (list.isEmpty()) {
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(218028270, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt$agreementActiveTicketsSection$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer, int i7) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((i7 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(218028270, i7, -1, "dk.molslinjen.ui.views.screens.agreements.common.agreementActiveTicketsSection.<anonymous> (AgreementActiveTicketSection.kt:46)");
                        }
                        AgreementDetailsEmptyStateCardKt.AgreementDetailsEmptyStateCard(R.drawable.icon_tickets_empty, StringResources_androidKt.stringResource(i6, composer, 0), composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            } else {
                lazyListScope.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt$agreementActiveTicketsSection$$inlined$itemsIndexed$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i7) {
                        list.get(i7);
                        return null;
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt$agreementActiveTicketsSection$$inlined$itemsIndexed$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope lazyItemScope, int i7, Composer composer, int i8) {
                        int i9;
                        if ((i8 & 6) == 0) {
                            i9 = (composer.changed(lazyItemScope) ? 4 : 2) | i8;
                        } else {
                            i9 = i8;
                        }
                        if ((i8 & 48) == 0) {
                            i9 |= composer.changed(i7) ? 32 : 16;
                        }
                        if ((i9 & 147) == 146 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1091073711, i9, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                        }
                        IAgreementDeparture iAgreementDeparture = (IAgreementDeparture) list.get(i7);
                        composer.startReplaceGroup(481013217);
                        composer.startReplaceGroup(-1369957014);
                        if (i7 > 0) {
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                        }
                        composer.endReplaceGroup();
                        AgreementDepartureRowViewKt.AgreementDepartureRowView(iAgreementDeparture, ticketCategory, showDetails, false, composer, 3072);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-991675560, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt$agreementActiveTicketsSection$4
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i7) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i7 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-991675560, i7, -1, "dk.molslinjen.ui.views.screens.agreements.common.agreementActiveTicketsSection.<anonymous> (AgreementActiveTicketSection.kt:67)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                Function0<Unit> function0 = onShowHistory;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.button_showTravelHistory, composer, 6), PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, function0, 7, null), Dp.m2599constructorimpl(50), Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 384, 1572864, 65528);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
