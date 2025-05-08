package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.booking.FerryType;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"icon", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/RouteType;", "ferryType", "Ldk/molslinjen/domain/model/booking/FerryType;", "supplementaryDescription", "(Ldk/molslinjen/domain/model/booking/RouteType;)Ljava/lang/Integer;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RouteType.values().length];
            try {
                iArr[RouteType.Ferry.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RouteType.BusBus.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RouteType.Bridge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RouteType.BusOnly.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RouteType.Shuttle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int icon(RouteType routeType, FerryType ferryType) {
        Intrinsics.checkNotNullParameter(routeType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[routeType.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return ferryType != null ? FerryTypeExtensionsKt.icon(ferryType) : R.drawable.icon_ferry;
        }
        if (i5 == 3) {
            return R.drawable.icon_bridge;
        }
        if (i5 == 4 || i5 == 5) {
            return R.drawable.icon_bus;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Integer supplementaryDescription(RouteType routeType) {
        Intrinsics.checkNotNullParameter(routeType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[routeType.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return Integer.valueOf(R.string.departure_withFerry);
        }
        if (i5 == 3) {
            return Integer.valueOf(R.string.departure_overBridge);
        }
        if (i5 == 4) {
            return null;
        }
        if (i5 == 5) {
            return Integer.valueOf(R.string.departure_withShuttle);
        }
        throw new NoWhenBranchMatchedException();
    }
}
