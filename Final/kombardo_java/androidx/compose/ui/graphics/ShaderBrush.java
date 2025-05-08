package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", BuildConfig.FLAVOR, "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", BuildConfig.FLAVOR, "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.INSTANCE.m1383getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo1463applyToPq9zytI(long size, Paint p5, float alpha) {
        Shader shader = this.internalShader;
        if (shader == null || !Size.m1374equalsimpl0(this.createdSize, size)) {
            if (Size.m1379isEmptyimpl(size)) {
                shader = null;
                this.internalShader = null;
                this.createdSize = Size.INSTANCE.m1383getUnspecifiedNHjbRc();
            } else {
                shader = mo1472createShaderuvyYCjk(size);
                this.internalShader = shader;
                this.createdSize = size;
            }
        }
        long mo1404getColor0d7_KjU = p5.mo1404getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m1487equalsimpl0(mo1404getColor0d7_KjU, companion.m1496getBlack0d7_KjU())) {
            p5.mo1409setColor8_81llA(companion.m1496getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(p5.getShader(), shader)) {
            p5.setShader(shader);
        }
        if (p5.getAlpha() == alpha) {
            return;
        }
        p5.setAlpha(alpha);
    }

    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo1472createShaderuvyYCjk(long size);
}
