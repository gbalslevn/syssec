package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"color", "Landroidx/compose/ui/graphics/Color;", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "getColor", "(Ldk/molslinjen/domain/model/booking/TicketCategory;)J", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "(Ldk/molslinjen/domain/model/booking/TicketCategoryType;)J", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketCategoryExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketCategoryType.values().length];
            try {
                iArr[TicketCategoryType.LowPrice.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketCategoryType.Flex.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketCategoryType.Standard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketCategoryType.BlueClass.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketCategoryType.Commuter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketCategoryType.Unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long getColor(TicketCategory ticketCategory) {
        Intrinsics.checkNotNullParameter(ticketCategory, "<this>");
        return getColor(ticketCategory.getType());
    }

    public static final long getColor(TicketCategoryType ticketCategoryType) {
        Intrinsics.checkNotNullParameter(ticketCategoryType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[ticketCategoryType.ordinal()]) {
            case 1:
                return AppColor.INSTANCE.m3271getSignalOrange0d7_KjU();
            case 2:
                return AppColor.INSTANCE.m3262getContrastGreen10d7_KjU();
            case 3:
                return AppColor.INSTANCE.m3261getContrastBlue10d7_KjU();
            case 4:
                return AppColor.INSTANCE.m3255getBrandBlue10d7_KjU();
            case 5:
                return AppColor.INSTANCE.m3267getGrey40d7_KjU();
            case 6:
                return AppColor.INSTANCE.m3267getGrey40d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
