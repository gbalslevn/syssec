package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0013\u0010\b\u001a\u00060\u0002j\u0002`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R.\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010$\u001a\u00020#2\u0006\u0010$\u001a\u00020#8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010-\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00101\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020.8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u00104\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R*\u00108\u001a\u0002052\u0006\u0010\u0016\u001a\u0002058V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R*\u0010<\u001a\u0002092\u0006\u0010\u0016\u001a\u0002098V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R$\u0010?\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R*\u0010C\u001a\u00020@2\u0006\u0010\u0016\u001a\u00020@8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bA\u0010*\"\u0004\bB\u0010,R4\u0010H\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u000e\u0010\u0016\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010M\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "Landroid/graphics/Paint;", "internalPaint", "<init>", "(Landroid/graphics/Paint;)V", "()V", "Landroidx/compose/ui/graphics/NativePaint;", "asFrameworkPaint", "()Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/BlendMode;", "_blendMode", "I", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/ColorFilter;", "internalColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/PathEffect;", "value", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", BuildConfig.FLAVOR, "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "Landroidx/compose/ui/graphics/Color;", "color", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "blendMode", "Landroidx/compose/ui/graphics/PaintingStyle;", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "style", "getStrokeWidth", "setStrokeWidth", "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "strokeCap", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeJoin", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeMiterLimit", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "filterQuality", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "shader", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPaint implements Paint {
    private int _blendMode;
    private ColorFilter internalColorFilter;
    private android.graphics.Paint internalPaint;
    private Shader internalShader;
    private PathEffect pathEffect;

    public AndroidPaint(android.graphics.Paint paint) {
        this.internalPaint = paint;
        this._blendMode = BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: asFrameworkPaint, reason: from getter */
    public android.graphics.Paint getInternalPaint() {
        return this.internalPaint;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public int get_blendMode() {
        return this._blendMode;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo1404getColor0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getColorFilter, reason: from getter */
    public ColorFilter getInternalColorFilter() {
        return this.internalColorFilter;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getFilterQuality-f-v9h1I, reason: not valid java name */
    public int mo1405getFilterQualityfv9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getShader, reason: from getter */
    public Shader getInternalShader() {
        return this.internalShader;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    public int mo1406getStrokeCapKaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    public int mo1407getStrokeJoinLxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setAlpha(float f5) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, f5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public void mo1408setBlendModes9anfk8(int i5) {
        if (BlendMode.m1429equalsimpl0(this._blendMode, i5)) {
            return;
        }
        this._blendMode = i5;
        AndroidPaint_androidKt.m1414setNativeBlendModeGB0RdKg(this.internalPaint, i5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public void mo1409setColor8_81llA(long j5) {
        AndroidPaint_androidKt.m1415setNativeColor4WTKRHQ(this.internalPaint, j5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setColorFilter(ColorFilter colorFilter) {
        this.internalColorFilter = colorFilter;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, colorFilter);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    public void mo1410setFilterQualityvDHp3xo(int i5) {
        AndroidPaint_androidKt.m1416setNativeFilterQuality50PEsBU(this.internalPaint, i5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setPathEffect(PathEffect pathEffect) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, pathEffect);
        this.pathEffect = pathEffect;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setShader(Shader shader) {
        this.internalShader = shader;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, shader);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    public void mo1411setStrokeCapBeK7IIE(int i5) {
        AndroidPaint_androidKt.m1417setNativeStrokeCapCSYIeUk(this.internalPaint, i5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    public void mo1412setStrokeJoinWw9F2mQ(int i5) {
        AndroidPaint_androidKt.m1418setNativeStrokeJoinkLtJ_vA(this.internalPaint, i5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeMiterLimit(float f5) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, f5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeWidth(float f5) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, f5);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setStyle-k9PVt8s, reason: not valid java name */
    public void mo1413setStylek9PVt8s(int i5) {
        AndroidPaint_androidKt.m1419setNativeStyle5YerkU(this.internalPaint, i5);
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.makeNativePaint());
    }
}
