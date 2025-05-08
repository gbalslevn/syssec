package dk.molslinjen.extensions.domain;

import androidx.compose.ui.graphics.Color;
import dk.molslinjen.domain.model.booking.CheapestTicketPriceIndicator;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"highlightColor", "Landroidx/compose/ui/graphics/Color;", "Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;", "getHighlightColor", "(Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;)Landroidx/compose/ui/graphics/Color;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheapestTicketPriceIndicatorExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CheapestTicketPriceIndicator.values().length];
            try {
                iArr[CheapestTicketPriceIndicator.Regular.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CheapestTicketPriceIndicator.Highlighted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Color getHighlightColor(CheapestTicketPriceIndicator cheapestTicketPriceIndicator) {
        Intrinsics.checkNotNullParameter(cheapestTicketPriceIndicator, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[cheapestTicketPriceIndicator.ordinal()];
        if (i5 == 1) {
            return null;
        }
        if (i5 == 2) {
            return Color.m1481boximpl(AppColor.INSTANCE.m3279getTagYellow0d7_KjU());
        }
        throw new NoWhenBranchMatchedException();
    }
}
