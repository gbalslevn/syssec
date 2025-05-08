package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002\u0013\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/Brush;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Paint;", "p", BuildConfig.FLAVOR, "alpha", BuildConfig.FLAVOR, "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "applyTo", "intrinsicSize", "J", "getIntrinsicSize-NH-jbRc", "()J", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Brush {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long intrinsicSize;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0011\u001a\u00020\u000e2*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J>\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0014J\\\u0010\u0019\u001a\u00020\u000e2*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J>\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\\\u0010\u001e\u001a\u00020\u000e2*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "colorStops", "Landroidx/compose/ui/geometry/Offset;", "start", "end", "Landroidx/compose/ui/graphics/TileMode;", "tileMode", "Landroidx/compose/ui/graphics/Brush;", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "linearGradient", BuildConfig.FLAVOR, "colors", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "startX", "endX", "horizontalGradient-8A-3gB4", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "horizontalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1464horizontalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f5, float f6, int i5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f5 = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f6 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i5 = TileMode.INSTANCE.m1621getClamp3opZhB0();
            }
            return companion.m1467horizontalGradient8A3gB4(pairArr, f5, f6, i5);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1465verticalGradient8A3gB4$default(Companion companion, List list, float f5, float f6, int i5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f5 = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f6 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i5 = TileMode.INSTANCE.m1621getClamp3opZhB0();
            }
            return companion.m1470verticalGradient8A3gB4((List<Color>) list, f5, f6, i5);
        }

        /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1467horizontalGradient8A3gB4(Pair<Float, Color>[] colorStops, float startX, float endX, int tileMode) {
            return m1469linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(startX, 0.0f), OffsetKt.Offset(endX, 0.0f), tileMode);
        }

        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m1469linearGradientmHitzGk(Pair<Float, Color>[] colorStops, long start, long end, int tileMode) {
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m1481boximpl(pair.getSecond().getValue()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList2.add(Float.valueOf(pair2.getFirst().floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, start, end, tileMode, null);
        }

        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1470verticalGradient8A3gB4(List<Color> colors, float startY, float endY, int tileMode) {
            return m1468linearGradientmHitzGk(colors, OffsetKt.Offset(0.0f, startY), OffsetKt.Offset(0.0f, endY), tileMode);
        }

        private Companion() {
        }

        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1471verticalGradient8A3gB4(Pair<Float, Color>[] colorStops, float startY, float endY, int tileMode) {
            return m1469linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(0.0f, startY), OffsetKt.Offset(0.0f, endY), tileMode);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1466verticalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f5, float f6, int i5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f5 = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f6 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i5 = TileMode.INSTANCE.m1621getClamp3opZhB0();
            }
            return companion.m1471verticalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f5, f6, i5);
        }

        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m1468linearGradientmHitzGk(List<Color> colors, long start, long end, int tileMode) {
            return new LinearGradient(colors, null, start, end, tileMode, null);
        }
    }

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo1463applyToPq9zytI(long size, Paint p5, float alpha);

    private Brush() {
        this.intrinsicSize = Size.INSTANCE.m1383getUnspecifiedNHjbRc();
    }
}
