package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/selection/TextSelectionColors;", BuildConfig.FLAVOR, "handleColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getHandleColor-0d7_KjU", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.text.selection.TextSelectionColors, reason: from toString */
/* loaded from: classes.dex */
public final class SelectionColors {

    /* renamed from: backgroundColor, reason: from kotlin metadata and from toString */
    private final long selectionBackgroundColor;

    /* renamed from: handleColor, reason: from kotlin metadata and from toString */
    private final long selectionHandleColor;

    public /* synthetic */ SelectionColors(long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectionColors)) {
            return false;
        }
        SelectionColors selectionColors = (SelectionColors) other;
        return Color.m1487equalsimpl0(this.selectionHandleColor, selectionColors.selectionHandleColor) && Color.m1487equalsimpl0(this.selectionBackgroundColor, selectionColors.selectionBackgroundColor);
    }

    /* renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectionBackgroundColor() {
        return this.selectionBackgroundColor;
    }

    /* renamed from: getHandleColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectionHandleColor() {
        return this.selectionHandleColor;
    }

    public int hashCode() {
        return (Color.m1493hashCodeimpl(this.selectionHandleColor) * 31) + Color.m1493hashCodeimpl(this.selectionBackgroundColor);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m1494toStringimpl(this.selectionHandleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m1494toStringimpl(this.selectionBackgroundColor)) + ')';
    }

    private SelectionColors(long j5, long j6) {
        this.selectionHandleColor = j5;
        this.selectionBackgroundColor = j6;
    }
}
