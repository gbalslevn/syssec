package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt$lambda-6$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1 INSTANCE = new ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1();

    ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Departure it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Departure copy;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1419835280, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt.lambda-6.<anonymous> (DeveloperComponentsScreen.kt:57)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        float f5 = 16;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
        copy = r12.copy((r40 & 1) != 0 ? r12.arrivalHarborName : null, (r40 & 2) != 0 ? r12.arrivalTime : null, (r40 & 4) != 0 ? r12.cancelled : false, (r40 & 8) != 0 ? r12.customRouteTypeText : "Shuttle - gå på og af færgen", (r40 & 16) != 0 ? r12.date : null, (r40 & 32) != 0 ? r12.departureHarborName : null, (r40 & 64) != 0 ? r12.departureTime : null, (r40 & 128) != 0 ? r12.ferry : null, (r40 & 256) != 0 ? r12.id : null, (r40 & 512) != 0 ? r12.timeTableId : null, (r40 & 1024) != 0 ? r12.information : null, (r40 & 2048) != 0 ? r12.fromPrice : null, (r40 & 4096) != 0 ? r12.cheapestTicketType : null, (r40 & 8192) != 0 ? r12.mainRouteId : null, (r40 & 16384) != 0 ? r12.routeId : null, (r40 & 32768) != 0 ? r12.routeType : RouteType.Shuttle, (r40 & 65536) != 0 ? r12.soldOut : false, (r40 & 131072) != 0 ? r12.transportSwitchDescription : null, (r40 & 262144) != 0 ? r12.tickets : null, (r40 & 524288) != 0 ? r12.travelTime : null, (r40 & 1048576) != 0 ? r12.limitedAvailability : false, (r40 & 2097152) != 0 ? Departure.INSTANCE.getMock().availableProductTypes : null);
        composer.startReplaceGroup(-1196276560);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.developer.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1.invoke$lambda$1$lambda$0((Departure) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        DepartureRowViewKt.DepartureRowView(m313paddingVpY3zN4$default, copy, false, false, (Function1) rememberedValue, false, composer, 24582, 44);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
