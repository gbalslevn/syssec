package dk.molslinjen.ui.views.screens.booking.addons.seating.seat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/seat/SeatOrientation;", BuildConfig.FLAVOR, "rotation", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;IF)V", "getRotation", "()F", "Up", "Down", "Left", "Right", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SeatOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SeatOrientation[] $VALUES;
    private final float rotation;
    public static final SeatOrientation Up = new SeatOrientation("Up", 0, 180.0f);
    public static final SeatOrientation Down = new SeatOrientation("Down", 1, 0.0f);
    public static final SeatOrientation Left = new SeatOrientation("Left", 2, 90.0f);
    public static final SeatOrientation Right = new SeatOrientation("Right", 3, 270.0f);

    private static final /* synthetic */ SeatOrientation[] $values() {
        return new SeatOrientation[]{Up, Down, Left, Right};
    }

    static {
        SeatOrientation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SeatOrientation(String str, int i5, float f5) {
        this.rotation = f5;
    }

    public static SeatOrientation valueOf(String str) {
        return (SeatOrientation) Enum.valueOf(SeatOrientation.class, str);
    }

    public static SeatOrientation[] values() {
        return (SeatOrientation[]) $VALUES.clone();
    }

    public final float getRotation() {
        return this.rotation;
    }
}
