package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 K2\u00020\u0001:\u0002KLJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0007J/\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J?\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001bJ!\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!H&¢\u0006\u0004\b&\u0010$J!\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010\"\u001a\u00020!H&¢\u0006\u0004\b)\u0010*J$\u00100\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00002\b\b\u0002\u0010-\u001a\u00020,H&ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u00020\u0005H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0005H&¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u00102J\u001a\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H&ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u00020\u001fH&¢\u0006\u0004\b8\u00109J*\u0010A\u001a\u00020>2\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<H&ø\u0001\u0000¢\u0006\u0004\b?\u0010@R\"\u0010G\u001a\u00020B8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020>8&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020>8&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010Iø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006MÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Path;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "x", "y", BuildConfig.FLAVOR, "moveTo", "(FF)V", "dx", "dy", "relativeMoveTo", "lineTo", "relativeLineTo", "x1", "y1", "x2", "y2", "quadraticTo", "(FFFF)V", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "x3", "y3", "cubicTo", "(FFFFFF)V", "dx3", "dy3", "relativeCubicTo", "Landroidx/compose/ui/geometry/Rect;", "rect", "Landroidx/compose/ui/graphics/Path$Direction;", "direction", "addRect", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Path$Direction;)V", "oval", "addOval", "Landroidx/compose/ui/geometry/RoundRect;", "roundRect", "addRoundRect", "(Landroidx/compose/ui/geometry/RoundRect;Landroidx/compose/ui/graphics/Path$Direction;)V", "path", "Landroidx/compose/ui/geometry/Offset;", "offset", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addPath", "close", "()V", "reset", "rewind", "translate-k-4lQ0M", "(J)V", "translate", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "path1", "path2", "Landroidx/compose/ui/graphics/PathOperation;", "operation", BuildConfig.FLAVOR, "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "op", "Landroidx/compose/ui/graphics/PathFillType;", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "fillType", "isConvex", "()Z", "isEmpty", "Companion", "Direction", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Path {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/Path$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/graphics/Path$Direction;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum Direction {
        CounterClockwise,
        Clockwise
    }

    static /* synthetic */ void addOval$default(Path path, Rect rect, Direction direction, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }
        if ((i5 & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addOval(rect, direction);
    }

    /* renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m1574addPathUv8p0NA$default(Path path, Path path2, long j5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i5 & 2) != 0) {
            j5 = Offset.INSTANCE.m1349getZeroF1C5BW0();
        }
        path.mo1420addPathUv8p0NA(path2, j5);
    }

    static /* synthetic */ void addRect$default(Path path, Rect rect, Direction direction, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i5 & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRect(rect, direction);
    }

    static /* synthetic */ void addRoundRect$default(Path path, RoundRect roundRect, Direction direction, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i5 & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRoundRect(roundRect, direction);
    }

    void addOval(Rect oval, Direction direction);

    /* renamed from: addPath-Uv8p0NA */
    void mo1420addPathUv8p0NA(Path path, long offset);

    void addRect(Rect rect, Direction direction);

    void addRoundRect(RoundRect roundRect, Direction direction);

    void close();

    void cubicTo(float x12, float y12, float x22, float y22, float x32, float y32);

    Rect getBounds();

    /* renamed from: getFillType-Rg-k1Os */
    int mo1421getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float x5, float y5);

    void moveTo(float x5, float y5);

    /* renamed from: op-N5in7k0 */
    boolean mo1422opN5in7k0(Path path1, Path path2, int operation);

    void quadraticTo(float x12, float y12, float x22, float y22);

    void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3);

    void relativeLineTo(float dx, float dy);

    void relativeMoveTo(float dx, float dy);

    void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2);

    void reset();

    void rewind();

    /* renamed from: setFillType-oQ8Xj4U */
    void mo1423setFillTypeoQ8Xj4U(int i5);

    /* renamed from: translate-k-4lQ0M */
    void mo1424translatek4lQ0M(long offset);
}
