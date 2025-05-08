package dk.molslinjen.extensions.domain;

import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatType;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"drawableRes", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatType;", "getDrawableRes", "(Luniffi/molslinjen_shared/FerrySeatType;)I", "displayName", "getDisplayName", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySeatTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FerrySeatType.values().length];
            try {
                iArr[FerrySeatType.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FerrySeatType.NOT_AVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getDisplayName(FerrySeatType ferrySeatType) {
        Intrinsics.checkNotNullParameter(ferrySeatType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ferrySeatType.ordinal()];
        if (i5 == 1) {
            return R.string.selectSeat_seat_available;
        }
        if (i5 == 2) {
            return R.string.selectSeat_seat_occupied;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getDrawableRes(FerrySeatType ferrySeatType) {
        Intrinsics.checkNotNullParameter(ferrySeatType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ferrySeatType.ordinal()];
        if (i5 == 1) {
            return R.drawable.seat_available;
        }
        if (i5 == 2) {
            return R.drawable.seat_not_available;
        }
        throw new NoWhenBranchMatchedException();
    }
}
