package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0005J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0005J\"\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0014H&¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00020%8&X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010.\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u00060À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Offset;", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "screenToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "relativeToLocal", "localToWindow-MK-Hz9U", "localToWindow", "localToRoot-MK-Hz9U", "localToRoot", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", BuildConfig.FLAVOR, "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "clipBounds", "Landroidx/compose/ui/geometry/Rect;", "localBoundingBoxOf", "(Landroidx/compose/ui/layout/LayoutCoordinates;Z)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Matrix;", "matrix", BuildConfig.FLAVOR, "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "transformToScreen-58bKbWc", "([F)V", "transformToScreen", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "size", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentCoordinates", "parentCoordinates", "isAttached", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LayoutCoordinates {
    static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z5);
    }

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo1948getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds);

    /* renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo1949localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource);

    /* renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
    long mo1950localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference);

    /* renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo1951localToRootMKHz9U(long relativeToLocal);

    /* renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo1952localToWindowMKHz9U(long relativeToLocal);

    /* renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo1953screenToLocalMKHz9U(long relativeToScreen);

    /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo1954transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix);

    /* renamed from: transformToScreen-58bKbWc, reason: not valid java name */
    void mo1955transformToScreen58bKbWc(float[] matrix);

    /* renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo1956windowToLocalMKHz9U(long relativeToWindow);
}
