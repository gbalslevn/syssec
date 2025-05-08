package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b+\u0010*R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u001a\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\t\u0010-R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00101R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00102R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00103R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00104R\u0014\u00105\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0017\u00106\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010\u001b\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00028\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b\u001a\u0010*R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010(R\u0018\u0010?\u001a\u00020\u0002*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", BuildConfig.FLAVOR, "index", "size", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Placeable;", "placeables", "Landroidx/compose/ui/unit/IntOffset;", "visualOffset", BuildConfig.FLAVOR, "key", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", BuildConfig.FLAVOR, "reverseLayout", "<init>", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOffset-Bjo55l4", "(I)J", "getOffset", "offset", "layoutWidth", "layoutHeight", BuildConfig.FLAVOR, "position", "(III)V", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "delta", "applyScrollDelta", "(I)V", "I", "getIndex", "()I", "getSize", "Ljava/util/List;", "J", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/compose/ui/unit/LayoutDirection;", "Z", "isVertical", "crossAxisSize", "getCrossAxisSize", BuildConfig.FLAVOR, "placeableOffsets", "[I", "<set-?>", "mainAxisLayoutSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "mainAxisSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MeasuredPage implements PageInfo {
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i5, int i6, List list, long j5, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, i6, list, j5, obj, orientation, horizontal, vertical, layoutDirection, z5);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m437getOffsetBjo55l4(int index) {
        int[] iArr = this.placeableOffsets;
        int i5 = index * 2;
        return IntOffsetKt.IntOffset(iArr[i5], iArr[i5 + 1]);
    }

    public final void applyScrollDelta(int delta) {
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i5 = 0; i5 < length; i5++) {
            boolean z5 = this.isVertical;
            if ((z5 && i5 % 2 == 1) || (!z5 && i5 % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i5] = iArr[i5] + delta;
            }
        }
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final int getSize() {
        return this.size;
    }

    public final void place(Placeable.PlacementScope scope) {
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int size = this.placeables.size();
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = this.placeables.get(i5);
            long m437getOffsetBjo55l4 = m437getOffsetBjo55l4(i5);
            if (this.reverseLayout) {
                m437getOffsetBjo55l4 = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m2640getXimpl(m437getOffsetBjo55l4) : (this.mainAxisLayoutSize - IntOffset.m2640getXimpl(m437getOffsetBjo55l4)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m2641getYimpl(m437getOffsetBjo55l4)) - getMainAxisSize(placeable) : IntOffset.m2641getYimpl(m437getOffsetBjo55l4));
            }
            long m2644plusqkQi6aY = IntOffset.m2644plusqkQi6aY(m437getOffsetBjo55l4, this.visualOffset);
            if (this.isVertical) {
                Placeable.PlacementScope.m1972placeWithLayeraW9wM$default(scope, placeable, m2644plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            } else {
                Placeable.PlacementScope.m1970placeRelativeWithLayeraW9wM$default(scope, placeable, m2644plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    public final void position(int offset, int layoutWidth, int layoutHeight) {
        int width;
        this.offset = offset;
        this.mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = list.get(i5);
            int i6 = i5 * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment");
                }
                iArr[i6] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                this.placeableOffsets[i6 + 1] = offset;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i6] = offset;
                int i7 = i6 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment");
                }
                iArr2[i7] = vertical.align(placeable.getHeight(), layoutHeight);
                width = placeable.getWidth();
            }
            offset += width;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MeasuredPage(int i5, int i6, List<? extends Placeable> list, long j5, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z5) {
        this.index = i5;
        this.size = i6;
        this.placeables = list;
        this.visualOffset = j5;
        this.key = obj;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z5;
        this.isVertical = orientation == Orientation.Vertical;
        int size = list.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Placeable placeable = (Placeable) list.get(i8);
            i7 = Math.max(i7, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.crossAxisSize = i7;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }
}
