package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideAssociatedVehicleRowStyle;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "First", "Middle", "Last", "SingleItem", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideAssociatedVehicleRowStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MultiRideAssociatedVehicleRowStyle[] $VALUES;
    public static final MultiRideAssociatedVehicleRowStyle First = new MultiRideAssociatedVehicleRowStyle("First", 0);
    public static final MultiRideAssociatedVehicleRowStyle Middle = new MultiRideAssociatedVehicleRowStyle("Middle", 1);
    public static final MultiRideAssociatedVehicleRowStyle Last = new MultiRideAssociatedVehicleRowStyle("Last", 2);
    public static final MultiRideAssociatedVehicleRowStyle SingleItem = new MultiRideAssociatedVehicleRowStyle("SingleItem", 3);

    private static final /* synthetic */ MultiRideAssociatedVehicleRowStyle[] $values() {
        return new MultiRideAssociatedVehicleRowStyle[]{First, Middle, Last, SingleItem};
    }

    static {
        MultiRideAssociatedVehicleRowStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private MultiRideAssociatedVehicleRowStyle(String str, int i5) {
    }

    public static MultiRideAssociatedVehicleRowStyle valueOf(String str) {
        return (MultiRideAssociatedVehicleRowStyle) Enum.valueOf(MultiRideAssociatedVehicleRowStyle.class, str);
    }

    public static MultiRideAssociatedVehicleRowStyle[] values() {
        return (MultiRideAssociatedVehicleRowStyle[]) $VALUES.clone();
    }
}
