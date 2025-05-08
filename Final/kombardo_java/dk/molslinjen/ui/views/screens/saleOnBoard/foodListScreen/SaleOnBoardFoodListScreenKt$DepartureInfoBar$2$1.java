package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardFoodListScreenKt$DepartureInfoBar$2$1 implements Function3<FlowRowScope, Composer, Integer, Unit> {
    final /* synthetic */ IDepartureInfo $departure;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardFoodListScreenKt$DepartureInfoBar$2$1(IDepartureInfo iDepartureInfo) {
        this.$departure = iDepartureInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
        invoke(flowRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FlowRowScope FlowRow, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(786799292, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.DepartureInfoBar.<anonymous>.<anonymous> (SaleOnBoardFoodListScreen.kt:245)");
        }
        String str = this.$departure.getDepartureHarborName() + "-" + this.$departure.getArrivalHarborName();
        TextStyle sub = TypographyKt.getSub();
        AppColor appColor = AppColor.INSTANCE;
        TextKt.m940Text4IGK_g(str, null, appColor.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer, 384, 1572864, 65530);
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(-258828667);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SaleOnBoardFoodListScreenKt$DepartureInfoBar$2$1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g("|", SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue), appColor.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 390, 1572864, 65528);
        TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatWithFullMonthWithoutYear(this.$departure.getDate()), null, appColor.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65530);
        composer.startReplaceGroup(-258816923);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = SaleOnBoardFoodListScreenKt$DepartureInfoBar$2$1.invoke$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g("|", SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue2), appColor.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 390, 1572864, 65528);
        TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(this.$departure.getDepartureTime()) + " - " + LocalDateTimeExtensionsKt.toFormatTime(this.$departure.getArrivalTime()), null, appColor.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65530);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
