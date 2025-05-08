package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketSection;", "getTitle", "(Ldk/molslinjen/domain/model/booking/TicketSection;)I", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSectionExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketSection.values().length];
            try {
                iArr[TicketSection.Passenger.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketSection.Addons.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketSection.Food.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketSection.Summary.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getTitle(TicketSection ticketSection) {
        Intrinsics.checkNotNullParameter(ticketSection, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ticketSection.ordinal()];
        if (i5 == 1) {
            return R.string.passengers_headline;
        }
        if (i5 == 2) {
            return R.string.addons_title;
        }
        if (i5 == 3) {
            return R.string.food_title;
        }
        if (i5 == 4) {
            return R.string.bookingSummary_title;
        }
        throw new NoWhenBranchMatchedException();
    }
}
