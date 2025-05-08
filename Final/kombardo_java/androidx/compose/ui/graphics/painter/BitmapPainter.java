package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u001a\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010%R(\u0010'\u001a\u00020&8\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010 \"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00068\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u001a\u00102\u001a\u00020/8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "validateSize-N5eqBDc", "(JJ)J", "validateSize", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "alpha", BuildConfig.FLAVOR, "applyAlpha", "(F)Z", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/ImageBitmap;", "J", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "I", "getFilterQuality-f-v9h1I$ui_graphics_release", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "size", "F", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j5, j6);
    }

    /* renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m1743validateSizeN5eqBDc(long srcOffset, long srcSize) {
        if (IntOffset.m2640getXimpl(srcOffset) < 0 || IntOffset.m2641getYimpl(srcOffset) < 0 || IntSize.m2661getWidthimpl(srcSize) < 0 || IntSize.m2660getHeightimpl(srcSize) < 0 || IntSize.m2661getWidthimpl(srcSize) > this.image.getWidth() || IntSize.m2660getHeightimpl(srcSize) > this.image.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return srcSize;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) other;
        return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m2639equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m2659equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m1517equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo1744getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m2668toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m2642hashCodeimpl(this.srcOffset)) * 31) + IntSize.m2662hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m1518hashCodeimpl(this.filterQuality);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        DrawScope.m1691drawImageAZ2fEMs$default(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(Math.round(Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc())), Math.round(Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()))), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m1745setFilterQualityvDHp3xo$ui_graphics_release(int i5) {
        this.filterQuality = i5;
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m2645toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m2663toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m1519toStringimpl(this.filterQuality)) + ')';
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j5, long j6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i5 & 2) != 0 ? IntOffset.INSTANCE.m2648getZeronOccac() : j5, (i5 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j6, null);
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j5, long j6) {
        this.image = imageBitmap;
        this.srcOffset = j5;
        this.srcSize = j6;
        this.filterQuality = FilterQuality.INSTANCE.m1520getLowfv9h1I();
        this.size = m1743validateSizeN5eqBDc(j5, j6);
        this.alpha = 1.0f;
    }
}
