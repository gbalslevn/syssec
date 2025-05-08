package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.booking.FerryType;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"icon", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/FerryType;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerryTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FerryType.values().length];
            try {
                iArr[FerryType.Standard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FerryType.Electric.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int icon(FerryType ferryType) {
        Intrinsics.checkNotNullParameter(ferryType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ferryType.ordinal()];
        if (i5 == 1) {
            return R.drawable.icon_ferry;
        }
        if (i5 == 2) {
            return R.drawable.icon_electric_ferry;
        }
        throw new NoWhenBranchMatchedException();
    }
}
