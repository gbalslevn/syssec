package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a_\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {BuildConfig.FLAVOR, "header", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "agreementId", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "tickets", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategory", "Lkotlin/Function2;", BuildConfig.FLAVOR, "showTicketDetails", "AgreementTicketHistoryContent", "(IZLjava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AgreementTicketHistoryContentKt {
    public static final void AgreementTicketHistoryContent(final int i5, final boolean z5, final String str, final List<? extends IAgreementDeparture> list, final TicketCategoryType ticketCategoryType, final Function2<? super String, ? super String, Unit> showTicketDetails, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(showTicketDetails, "showTicketDetails");
        Composer startRestartGroup = composer.startRestartGroup(-799146931);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changed(ticketCategoryType) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(showTicketDetails) ? 131072 : 65536;
        }
        int i8 = i7;
        if ((74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-799146931, i8, -1, "dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContent (AgreementTicketHistoryContent.kt:32)");
            }
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(146480025, true, new AgreementTicketHistoryContentKt$AgreementTicketHistoryContent$1(i5, str, list, ticketCategoryType, showTicketDetails), startRestartGroup, 54), startRestartGroup, ((i8 << 3) & 896) | 1572864, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AgreementTicketHistoryContent$lambda$0;
                    AgreementTicketHistoryContent$lambda$0 = AgreementTicketHistoryContentKt.AgreementTicketHistoryContent$lambda$0(i5, z5, str, list, ticketCategoryType, showTicketDetails, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return AgreementTicketHistoryContent$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementTicketHistoryContent$lambda$0(int i5, boolean z5, String str, List list, TicketCategoryType ticketCategoryType, Function2 function2, int i6, Composer composer, int i7) {
        AgreementTicketHistoryContent(i5, z5, str, list, ticketCategoryType, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
