package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\t*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000bJ\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/TextLayoutResult;", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "innerTextFieldCoordinates", "decorationBoxCoordinates", "<init>", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/ui/geometry/Offset;", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "(J)J", "coercedInVisibleBoundsOfInputText", "position", BuildConfig.FLAVOR, "coerceInVisibleBounds", BuildConfig.FLAVOR, "getOffsetForPosition-3MmeM6k", "(JZ)I", "getOffsetForPosition", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "isPositionOnText", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "translateDecorationToInnerCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "translateInnerToDecorationCoordinates", "Landroidx/compose/ui/text/TextLayoutResult;", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getInnerTextFieldCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setInnerTextFieldCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "setDecorationBoxCoordinates", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLayoutResultProxy {
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        this.value = textLayoutResult;
        this.innerTextFieldCoordinates = layoutCoordinates;
        this.decorationBoxCoordinates = layoutCoordinates2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (r2 == null) goto L25;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long m550coercedInVisibleBoundsOfInputTextMKHz9U(long j5) {
        Rect zero;
        long m557coerceIn3MmeM6k;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        if (layoutCoordinates != null) {
            if (layoutCoordinates.isAttached()) {
                LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
                zero = null;
                if (layoutCoordinates2 != null) {
                    zero = LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinates2, layoutCoordinates, false, 2, null);
                }
            } else {
                zero = Rect.INSTANCE.getZero();
            }
        }
        zero = Rect.INSTANCE.getZero();
        m557coerceIn3MmeM6k = TextLayoutResultProxyKt.m557coerceIn3MmeM6k(j5, zero);
        return m557coerceIn3MmeM6k;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default */
    public static /* synthetic */ int m551getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j5, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return textLayoutResultProxy.m552getOffsetForPosition3MmeM6k(j5, z5);
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k */
    public final int m552getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        if (coerceInVisibleBounds) {
            position = m550coercedInVisibleBoundsOfInputTextMKHz9U(position);
        }
        return this.value.m2270getOffsetForPositionk4lQ0M(m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release(position));
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* renamed from: isPositionOnText-k-4lQ0M */
    public final boolean m553isPositionOnTextk4lQ0M(long offset) {
        long m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release = m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m550coercedInVisibleBoundsOfInputTextMKHz9U(offset));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m1338getYimpl(m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release));
        return Offset.m1337getXimpl(m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release) >= this.value.getLineLeft(lineForVerticalPosition) && Offset.m1337getXimpl(m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release) <= this.value.getLineRight(lineForVerticalPosition);
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    /* renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release */
    public final long m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return offset;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return offset;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? offset : layoutCoordinates2.mo1949localPositionOfR5De75A(layoutCoordinates3, offset);
    }

    /* renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release */
    public final long m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return offset;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return offset;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? offset : layoutCoordinates3.mo1949localPositionOfR5De75A(layoutCoordinates2, offset);
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i5 & 2) != 0 ? null : layoutCoordinates, (i5 & 4) != 0 ? null : layoutCoordinates2);
    }
}
