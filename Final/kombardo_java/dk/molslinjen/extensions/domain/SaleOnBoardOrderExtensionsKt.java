package dk.molslinjen.extensions.domain;

import android.content.Context;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000f\u0010\u0007\u001a\u00020\b*\u00020\u0002¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\f"}, d2 = {"timeFormatted", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "getStatusMediumTitle", "context", "Landroid/content/Context;", "getStatusLongTitle", "getStatusColor", "Landroidx/compose/ui/graphics/Color;", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)J", "getShortTitle", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardOrderExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SaleOnBoardOrder.OrderStatus.values().length];
            try {
                iArr[SaleOnBoardOrder.OrderStatus.Received.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SaleOnBoardOrder.OrderStatus.Processing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SaleOnBoardOrder.OrderStatus.Printed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SaleOnBoardOrder.OrderStatus.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getShortTitle(SaleOnBoardOrder.OrderStatus orderStatus, Context context) {
        Intrinsics.checkNotNullParameter(orderStatus, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i5 = WhenMappings.$EnumSwitchMapping$0[orderStatus.ordinal()];
        String string = i5 != 1 ? (i5 == 2 || i5 == 3) ? context.getString(R.string.saleOnBoard_orderStatus_processing_short) : i5 != 4 ? BuildConfig.FLAVOR : context.getString(R.string.saleOnBoard_orderStatus_done_short) : context.getString(R.string.saleOnBoard_orderStatus_received_short);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final long getStatusColor(SaleOnBoardOrder saleOnBoardOrder) {
        Intrinsics.checkNotNullParameter(saleOnBoardOrder, "<this>");
        return saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Cancelled ? AppColor.INSTANCE.m3278getTagRed0d7_KjU() : !saleOnBoardOrder.isActive() ? AppColor.INSTANCE.m3264getGrey10d7_KjU() : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Received ? AppColor.INSTANCE.m3274getTagBlue0d7_KjU() : (saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Processing || saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Printed) ? AppColor.INSTANCE.m3274getTagBlue0d7_KjU() : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Done ? AppColor.INSTANCE.m3262getContrastGreen10d7_KjU() : AppColor.INSTANCE.m3274getTagBlue0d7_KjU();
    }

    public static final String getStatusLongTitle(SaleOnBoardOrder saleOnBoardOrder, Context context) {
        Intrinsics.checkNotNullParameter(saleOnBoardOrder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Cancelled ? context.getString(R.string.saleOnBoard_orderStatus_cancelled_long) : !saleOnBoardOrder.isActive() ? context.getString(R.string.saleOnBoard_orderStatus_expired_long) : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Received ? context.getString(R.string.saleOnBoard_orderStatus_received_long) : (saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Processing || saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Printed) ? context.getString(R.string.saleOnBoard_orderStatus_processing_long) : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Done ? context.getString(R.string.saleOnBoard_orderStatus_done_long) : BuildConfig.FLAVOR;
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String getStatusMediumTitle(SaleOnBoardOrder saleOnBoardOrder, Context context) {
        Intrinsics.checkNotNullParameter(saleOnBoardOrder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Cancelled ? context.getString(R.string.saleOnBoard_orderStatus_cancelled_medium) : !saleOnBoardOrder.isActive() ? context.getString(R.string.saleOnBoard_orderStatus_expired_medium) : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Received ? context.getString(R.string.saleOnBoard_orderStatus_received_medium) : (saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Processing || saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Printed) ? context.getString(R.string.saleOnBoard_orderStatus_processing_medium) : saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Done ? context.getString(R.string.saleOnBoard_orderStatus_done_medium) : BuildConfig.FLAVOR;
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String timeFormatted(SaleOnBoardOrder saleOnBoardOrder) {
        Intrinsics.checkNotNullParameter(saleOnBoardOrder, "<this>");
        LocalTime localTime = saleOnBoardOrder.getStartDateTime().toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        String formatTime = LocalDateTimeExtensionsKt.toFormatTime(localTime);
        LocalTime localTime2 = saleOnBoardOrder.getEndDateTime().toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime2, "toLocalTime(...)");
        return formatTime + " - " + LocalDateTimeExtensionsKt.toFormatTime(localTime2);
    }
}
