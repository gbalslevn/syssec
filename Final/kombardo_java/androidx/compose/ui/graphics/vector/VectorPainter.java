package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R1\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u00105\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020.8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R(\u0010A\u001a\u0004\u0018\u00010\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u000f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010D\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00138@@@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010\u001aR$\u0010J\u001a\u00020E2\u0006\u0010<\u001a\u00020E8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010L\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bK\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "root", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "alpha", BuildConfig.FLAVOR, "applyAlpha", "(F)Z", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "size$delegate", "Landroidx/compose/runtime/MutableState;", "getSize-NH-jbRc$ui_release", "()J", "setSize-uvyYCjk$ui_release", "(J)V", "size", "autoMirror$delegate", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/runtime/Composition;", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui_release", "()Landroidx/compose/runtime/Composition;", "setComposition$ui_release", "(Landroidx/compose/runtime/Composition;)V", BuildConfig.FLAVOR, "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "getInvalidateCount", "()I", "setInvalidateCount", "(I)V", "invalidateCount", "currentAlpha", "F", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawCount", "I", "value", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "viewportSize", BuildConfig.FLAVOR, "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", "name", "getIntrinsicSize-NH-jbRc", "intrinsicSize", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    /* renamed from: autoMirror$delegate, reason: from kotlin metadata */
    private final MutableState autoMirror;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private int drawCount;

    /* renamed from: invalidateCount$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateCount;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size;
    private final VectorComponent vector;

    public VectorPainter(GroupComponent groupComponent) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1370boximpl(Size.INSTANCE.m1384getZeroNHjbRc()), null, 2, null);
        this.size = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.autoMirror = mutableStateOf$default2;
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.setInvalidateCallback$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i5;
                int invalidateCount;
                int invalidateCount2;
                i5 = VectorPainter.this.drawCount;
                invalidateCount = VectorPainter.this.getInvalidateCount();
                if (i5 == invalidateCount) {
                    VectorPainter vectorPainter = VectorPainter.this;
                    invalidateCount2 = vectorPainter.getInvalidateCount();
                    vectorPainter.setInvalidateCount(invalidateCount2 + 1);
                }
            }
        });
        this.vector = vectorComponent;
        this.invalidateCount = SnapshotIntStateKt.mutableIntStateOf(0);
        this.currentAlpha = 1.0f;
        this.drawCount = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInvalidateCount() {
        return this.invalidateCount.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateCount(int i5) {
        this.invalidateCount.setIntValue(i5);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror.getValue()).booleanValue();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1744getIntrinsicSizeNHjbRc() {
        return m1766getSizeNHjbRc$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m1766getSizeNHjbRc$ui_release() {
        return ((Size) this.size.getValue()).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        VectorComponent vectorComponent = this.vector;
        ColorFilter colorFilter = this.currentColorFilter;
        if (colorFilter == null) {
            colorFilter = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (getAutoMirror$ui_release() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long mo1702getCenterF1C5BW0 = drawScope.mo1702getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo1688scale0AR0LA0(-1.0f, 1.0f, mo1702getCenterF1C5BW0);
                vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            }
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        }
        this.drawCount = getInvalidateCount();
    }

    public final void setAutoMirror$ui_release(boolean z5) {
        this.autoMirror.setValue(Boolean.valueOf(z5));
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    public final void setName$ui_release(String str) {
        this.vector.setName(str);
    }

    /* renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1767setSizeuvyYCjk$ui_release(long j5) {
        this.size.setValue(Size.m1370boximpl(j5));
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1768setViewportSizeuvyYCjk$ui_release(long j5) {
        this.vector.m1764setViewportSizeuvyYCjk$ui_release(j5);
    }
}
