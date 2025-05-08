package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0016J%\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J%\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u001a\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u001a\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u001a\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u001a\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\"R\u001a\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\t\u0010\"R\u001a\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\n\u0010\"R\u001a\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u001a\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\"R\u001a\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\r\u0010\"R\u001a\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u001a\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "<init>", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "enabled", "selected", "containerColor-WaAFU9c$material3_release", "(ZZ)J", "labelColor-WaAFU9c$material3_release", "leadingIconContentColor-WaAFU9c$material3_release", "leadingIconContentColor", "trailingIconContentColor-WaAFU9c$material3_release", "trailingIconContentColor", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableChipColors {
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17);
    }

    /* renamed from: containerColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m890containerColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? selected ? this.disabledSelectedContainerColor : this.disabledContainerColor : !selected ? this.containerColor : this.selectedContainerColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SelectableChipColors)) {
            return false;
        }
        SelectableChipColors selectableChipColors = (SelectableChipColors) other;
        return Color.m1487equalsimpl0(this.containerColor, selectableChipColors.containerColor) && Color.m1487equalsimpl0(this.labelColor, selectableChipColors.labelColor) && Color.m1487equalsimpl0(this.leadingIconColor, selectableChipColors.leadingIconColor) && Color.m1487equalsimpl0(this.trailingIconColor, selectableChipColors.trailingIconColor) && Color.m1487equalsimpl0(this.disabledContainerColor, selectableChipColors.disabledContainerColor) && Color.m1487equalsimpl0(this.disabledLabelColor, selectableChipColors.disabledLabelColor) && Color.m1487equalsimpl0(this.disabledLeadingIconColor, selectableChipColors.disabledLeadingIconColor) && Color.m1487equalsimpl0(this.disabledTrailingIconColor, selectableChipColors.disabledTrailingIconColor) && Color.m1487equalsimpl0(this.selectedContainerColor, selectableChipColors.selectedContainerColor) && Color.m1487equalsimpl0(this.disabledSelectedContainerColor, selectableChipColors.disabledSelectedContainerColor) && Color.m1487equalsimpl0(this.selectedLabelColor, selectableChipColors.selectedLabelColor) && Color.m1487equalsimpl0(this.selectedLeadingIconColor, selectableChipColors.selectedLeadingIconColor) && Color.m1487equalsimpl0(this.selectedTrailingIconColor, selectableChipColors.selectedTrailingIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.m1493hashCodeimpl(this.containerColor) * 31) + Color.m1493hashCodeimpl(this.labelColor)) * 31) + Color.m1493hashCodeimpl(this.leadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.trailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m1493hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m1493hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m1493hashCodeimpl(this.disabledSelectedContainerColor)) * 31) + Color.m1493hashCodeimpl(this.selectedLabelColor)) * 31) + Color.m1493hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.selectedTrailingIconColor);
    }

    /* renamed from: labelColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m891labelColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledLabelColor : !selected ? this.labelColor : this.selectedLabelColor;
    }

    /* renamed from: leadingIconContentColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m892leadingIconContentColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledLeadingIconColor : !selected ? this.leadingIconColor : this.selectedLeadingIconColor;
    }

    /* renamed from: trailingIconContentColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m893trailingIconContentColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledTrailingIconColor : !selected ? this.trailingIconColor : this.selectedTrailingIconColor;
    }

    private SelectableChipColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
        this.containerColor = j5;
        this.labelColor = j6;
        this.leadingIconColor = j7;
        this.trailingIconColor = j8;
        this.disabledContainerColor = j9;
        this.disabledLabelColor = j10;
        this.disabledLeadingIconColor = j11;
        this.disabledTrailingIconColor = j12;
        this.selectedContainerColor = j13;
        this.disabledSelectedContainerColor = j14;
        this.selectedLabelColor = j15;
        this.selectedLeadingIconColor = j16;
        this.selectedTrailingIconColor = j17;
    }
}
