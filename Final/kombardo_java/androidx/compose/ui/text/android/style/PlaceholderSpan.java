package androidx.compose.ui.text.android.style;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-J;\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJY\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t8\u0006@BX\u0086.¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068F@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010 R$\u0010(\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068F@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010 R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I", "Landroid/graphics/Canvas;", "canvas", BuildConfig.FLAVOR, "x", "top", "y", "bottom", BuildConfig.FLAVOR, "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "width", "F", "widthUnit", "I", "height", "heightUnit", "pxPerSp", "verticalAlign", "getVerticalAlign", "()I", "<set-?>", "fontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "widthPx", "getWidthPx", "heightPx", "getHeightPx", BuildConfig.FLAVOR, "isLaidOut", "Z", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlaceholderSpan extends ReplacementSpan {
    private Paint.FontMetricsInt fontMetrics;
    private final float height;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final float pxPerSp;
    private final int verticalAlign;
    private final float width;
    private int widthPx;
    private final int widthUnit;
    public static final int $stable = 8;

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x5, int top, int y5, int bottom, Paint paint) {
    }

    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    public final int getHeightPx() {
        if (this.isLaidOut) {
            return this.heightPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }

    @Override // android.text.style.ReplacementSpan
    @SuppressLint({"DocumentExceptions"})
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        float f5;
        int ceilToInt;
        this.isLaidOut = true;
        float textSize = paint.getTextSize();
        this.fontMetrics = paint.getFontMetricsInt();
        if (getFontMetrics().descent <= getFontMetrics().ascent) {
            throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
        }
        int i5 = this.widthUnit;
        if (i5 == 0) {
            f5 = this.width * this.pxPerSp;
        } else {
            if (i5 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            f5 = this.width * textSize;
        }
        this.widthPx = PlaceholderSpan_androidKt.ceilToInt(f5);
        int i6 = this.heightUnit;
        if (i6 == 0) {
            ceilToInt = PlaceholderSpan_androidKt.ceilToInt(this.height * this.pxPerSp);
        } else {
            if (i6 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            ceilToInt = PlaceholderSpan_androidKt.ceilToInt(this.height * textSize);
        }
        this.heightPx = ceilToInt;
        if (fm != null) {
            fm.ascent = getFontMetrics().ascent;
            fm.descent = getFontMetrics().descent;
            fm.leading = getFontMetrics().leading;
            switch (this.verticalAlign) {
                case 0:
                    if (fm.ascent > (-getHeightPx())) {
                        fm.ascent = -getHeightPx();
                        break;
                    }
                    break;
                case 1:
                case 4:
                    if (fm.ascent + getHeightPx() > fm.descent) {
                        fm.descent = fm.ascent + getHeightPx();
                        break;
                    }
                    break;
                case 2:
                case 5:
                    if (fm.ascent > fm.descent - getHeightPx()) {
                        fm.ascent = fm.descent - getHeightPx();
                        break;
                    }
                    break;
                case 3:
                case 6:
                    if (fm.descent - fm.ascent < getHeightPx()) {
                        int heightPx = fm.ascent - ((getHeightPx() - (fm.descent - fm.ascent)) / 2);
                        fm.ascent = heightPx;
                        fm.descent = heightPx + getHeightPx();
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown verticalAlign.");
            }
            fm.top = Math.min(getFontMetrics().top, fm.ascent);
            fm.bottom = Math.max(getFontMetrics().bottom, fm.descent);
        }
        return getWidthPx();
    }

    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    public final int getWidthPx() {
        if (this.isLaidOut) {
            return this.widthPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }
}
