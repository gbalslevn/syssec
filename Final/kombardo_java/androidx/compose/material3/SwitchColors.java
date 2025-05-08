package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J%\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J%\u0010 \u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001a\u0010\"\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b*\u0010)R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b+\u0010)R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b,\u0010)R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b-\u0010)R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b.\u0010)R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b/\u0010)R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b0\u0010)R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b1\u0010)R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b2\u0010)R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b3\u0010)R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b4\u0010)R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b5\u0010)R\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b6\u0010)R\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b7\u0010)R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b8\u0010)\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/material3/SwitchColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "checkedThumbColor", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "<init>", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "enabled", "checked", "thumbColor-WaAFU9c$material3_release", "(ZZ)J", "thumbColor", "trackColor-WaAFU9c$material3_release", "trackColor", "borderColor-WaAFU9c$material3_release", "borderColor", "iconColor-WaAFU9c$material3_release", "iconColor", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "J", "getCheckedThumbColor-0d7_KjU", "()J", "getCheckedTrackColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getCheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchColors {
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20);
    }

    /* renamed from: borderColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m908borderColorWaAFU9c$material3_release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedBorderColor : this.uncheckedBorderColor : checked ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) other;
        return Color.m1487equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m1487equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m1487equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m1487equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m1487equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m1487equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m1487equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m1487equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m1487equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m1487equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m1487equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m1487equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m1487equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m1487equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m1487equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m1487equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m1493hashCodeimpl(this.checkedThumbColor) * 31) + Color.m1493hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m1493hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m1493hashCodeimpl(this.checkedIconColor)) * 31) + Color.m1493hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m1493hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m1493hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m1493hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m1493hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m1493hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m1493hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m1493hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m1493hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m1493hashCodeimpl(this.disabledUncheckedIconColor);
    }

    /* renamed from: iconColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m909iconColorWaAFU9c$material3_release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedIconColor : this.uncheckedIconColor : checked ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    /* renamed from: thumbColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m910thumbColorWaAFU9c$material3_release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedThumbColor : this.uncheckedThumbColor : checked ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    /* renamed from: trackColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m911trackColorWaAFU9c$material3_release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedTrackColor : this.uncheckedTrackColor : checked ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }

    private SwitchColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        this.checkedThumbColor = j5;
        this.checkedTrackColor = j6;
        this.checkedBorderColor = j7;
        this.checkedIconColor = j8;
        this.uncheckedThumbColor = j9;
        this.uncheckedTrackColor = j10;
        this.uncheckedBorderColor = j11;
        this.uncheckedIconColor = j12;
        this.disabledCheckedThumbColor = j13;
        this.disabledCheckedTrackColor = j14;
        this.disabledCheckedBorderColor = j15;
        this.disabledCheckedIconColor = j16;
        this.disabledUncheckedThumbColor = j17;
        this.disabledUncheckedTrackColor = j18;
        this.disabledUncheckedBorderColor = j19;
        this.disabledUncheckedIconColor = j20;
    }
}
