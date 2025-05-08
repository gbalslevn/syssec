package coil.compose;

import android.os.SystemClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020 H\u0014J\u0012\u0010+\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J%\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0018\u00101\u001a\u00020\u0016H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0018J\u001e\u00103\u001a\u000204*\u0002052\b\u00106\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020 H\u0002J\f\u00107\u001a\u000204*\u000205H\u0014R/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Lcoil/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "durationMillis", BuildConfig.FLAVOR, "fadeStart", BuildConfig.FLAVOR, "preferExactIntrinsicSize", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;IZZ)V", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "isDone", BuildConfig.FLAVOR, "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "startTimeMillis", BuildConfig.FLAVOR, "applyAlpha", "alpha", "applyColorFilter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "painter", "onDraw", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossfadePainter extends Painter {

    /* renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter;
    private final ContentScale contentScale;
    private final int durationMillis;
    private final Painter end;
    private final boolean fadeStart;

    /* renamed from: invalidateTick$delegate, reason: from kotlin metadata */
    private final MutableState invalidateTick;
    private boolean isDone;

    /* renamed from: maxAlpha$delegate, reason: from kotlin metadata */
    private final MutableState maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private long startTimeMillis;

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, int i5, boolean z5, boolean z6) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale;
        this.durationMillis = i5;
        this.fadeStart = z5;
        this.preferExactIntrinsicSize = z6;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.invalidateTick = mutableStateOf$default;
        this.startTimeMillis = -1L;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.maxAlpha = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.colorFilter = mutableStateOf$default3;
    }

    /* renamed from: computeDrawSize-x8L_9b0, reason: not valid java name */
    private final long m2739computeDrawSizex8L_9b0(long srcSize, long dstSize) {
        Size.Companion companion = Size.INSTANCE;
        return (srcSize == companion.m1383getUnspecifiedNHjbRc() || Size.m1379isEmptyimpl(srcSize) || dstSize == companion.m1383getUnspecifiedNHjbRc() || Size.m1379isEmptyimpl(dstSize)) ? dstSize : ScaleFactorKt.m1983timesUQTWf7w(srcSize, this.contentScale.mo1937computeScaleFactorH7hwNQA(srcSize, dstSize));
    }

    /* renamed from: computeIntrinsicSize-NH-jbRc, reason: not valid java name */
    private final long m2740computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long mo1744getIntrinsicSizeNHjbRc = painter != null ? painter.mo1744getIntrinsicSizeNHjbRc() : Size.INSTANCE.m1384getZeroNHjbRc();
        Painter painter2 = this.end;
        long mo1744getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo1744getIntrinsicSizeNHjbRc() : Size.INSTANCE.m1384getZeroNHjbRc();
        Size.Companion companion = Size.INSTANCE;
        boolean z5 = mo1744getIntrinsicSizeNHjbRc != companion.m1383getUnspecifiedNHjbRc();
        boolean z6 = mo1744getIntrinsicSizeNHjbRc2 != companion.m1383getUnspecifiedNHjbRc();
        if (z5 && z6) {
            return SizeKt.Size(Math.max(Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc), Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc2)), Math.max(Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc), Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc2)));
        }
        if (this.preferExactIntrinsicSize) {
            if (z5) {
                return mo1744getIntrinsicSizeNHjbRc;
            }
            if (z6) {
                return mo1744getIntrinsicSizeNHjbRc2;
            }
        }
        return companion.m1383getUnspecifiedNHjbRc();
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f5) {
        if (painter == null || f5 <= 0.0f) {
            return;
        }
        long mo1703getSizeNHjbRc = drawScope.mo1703getSizeNHjbRc();
        long m2739computeDrawSizex8L_9b0 = m2739computeDrawSizex8L_9b0(painter.mo1744getIntrinsicSizeNHjbRc(), mo1703getSizeNHjbRc);
        if (mo1703getSizeNHjbRc == Size.INSTANCE.m1383getUnspecifiedNHjbRc() || Size.m1379isEmptyimpl(mo1703getSizeNHjbRc)) {
            painter.m1749drawx_KDEd0(drawScope, m2739computeDrawSizex8L_9b0, f5, getColorFilter());
            return;
        }
        float f6 = 2;
        float m1377getWidthimpl = (Size.m1377getWidthimpl(mo1703getSizeNHjbRc) - Size.m1377getWidthimpl(m2739computeDrawSizex8L_9b0)) / f6;
        float m1375getHeightimpl = (Size.m1375getHeightimpl(mo1703getSizeNHjbRc) - Size.m1375getHeightimpl(m2739computeDrawSizex8L_9b0)) / f6;
        drawScope.getDrawContext().getTransform().inset(m1377getWidthimpl, m1375getHeightimpl, m1377getWidthimpl, m1375getHeightimpl);
        painter.m1749drawx_KDEd0(drawScope, m2739computeDrawSizex8L_9b0, f5, getColorFilter());
        float f7 = -m1377getWidthimpl;
        float f8 = -m1375getHeightimpl;
        drawScope.getDrawContext().getTransform().inset(f7, f8, f7, f8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getInvalidateTick() {
        return ((Number) this.invalidateTick.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float getMaxAlpha() {
        return ((Number) this.maxAlpha.getValue()).floatValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter.setValue(colorFilter);
    }

    private final void setInvalidateTick(int i5) {
        this.invalidateTick.setValue(Integer.valueOf(i5));
    }

    private final void setMaxAlpha(float f5) {
        this.maxAlpha.setValue(Float.valueOf(f5));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        setMaxAlpha(alpha);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1744getIntrinsicSizeNHjbRc() {
        return m2740computeIntrinsicSizeNHjbRc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        if (this.isDone) {
            drawPainter(drawScope, this.end, getMaxAlpha());
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = uptimeMillis;
        }
        float f5 = ((float) (uptimeMillis - this.startTimeMillis)) / this.durationMillis;
        float coerceIn = RangesKt.coerceIn(f5, 0.0f, 1.0f) * getMaxAlpha();
        float maxAlpha = this.fadeStart ? getMaxAlpha() - coerceIn : getMaxAlpha();
        this.isDone = f5 >= 1.0f;
        drawPainter(drawScope, this.start, maxAlpha);
        drawPainter(drawScope, this.end, coerceIn);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }
}
