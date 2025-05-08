package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u000e\u001a\u00020\u0006*\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R/\u00100\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R1\u00109\u001a\u0002032\u0006\u0010)\u001a\u0002038@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b4\u0010+\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010:\u001a\u0002038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010=R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010E\u001a\u00020B8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bC\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "root", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", BuildConfig.FLAVOR, "doInvalidate", "()V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "draw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FLandroidx/compose/ui/graphics/ColorFilter;)V", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "name", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "isDirty", "Z", "Landroidx/compose/ui/graphics/vector/DrawCache;", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "Lkotlin/Function0;", "invalidateCallback", "Lkotlin/jvm/functions/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter", "tintFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/geometry/Size;", "viewportSize$delegate", "getViewportSize-NH-jbRc$ui_release", "()J", "setViewportSize-uvyYCjk$ui_release", "(J)V", "viewportSize", "previousDrawSize", "J", "rootScaleX", "F", "rootScaleY", "Lkotlin/Function1;", "drawVectorBlock", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getCacheBitmapConfig-_sVssgQ$ui_release", "()I", "cacheBitmapConfig", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorComponent extends VNode {
    private final DrawCache cacheDrawScope;
    private final Function1<DrawScope, Unit> drawVectorBlock;

    /* renamed from: intrinsicColorFilter$delegate, reason: from kotlin metadata */
    private final MutableState intrinsicColorFilter;
    private Function0<Unit> invalidateCallback;
    private boolean isDirty;
    private String name;
    private long previousDrawSize;
    private final GroupComponent root;
    private float rootScaleX;
    private float rootScaleY;
    private ColorFilter tintFilter;

    /* renamed from: viewportSize$delegate, reason: from kotlin metadata */
    private final MutableState viewportSize;

    public VectorComponent(GroupComponent groupComponent) {
        super(null);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.root = groupComponent;
        groupComponent.setInvalidateListener$ui_release(new Function1<VNode, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VNode vNode) {
                invoke2(vNode);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VNode vNode) {
                VectorComponent.this.doInvalidate();
            }
        });
        this.name = BuildConfig.FLAVOR;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.intrinsicColorFilter = mutableStateOf$default;
        Size.Companion companion = Size.INSTANCE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1370boximpl(companion.m1384getZeroNHjbRc()), null, 2, null);
        this.viewportSize = mutableStateOf$default2;
        this.previousDrawSize = companion.m1383getUnspecifiedNHjbRc();
        this.rootScaleX = 1.0f;
        this.rootScaleY = 1.0f;
        this.drawVectorBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                float f5;
                float f6;
                GroupComponent root = VectorComponent.this.getRoot();
                VectorComponent vectorComponent = VectorComponent.this;
                f5 = vectorComponent.rootScaleX;
                f6 = vectorComponent.rootScaleY;
                long m1349getZeroF1C5BW0 = Offset.INSTANCE.m1349getZeroF1C5BW0();
                DrawContext drawContext = drawScope.getDrawContext();
                long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo1688scale0AR0LA0(f5, f6, m1349getZeroF1C5BW0);
                    root.draw(drawScope);
                } finally {
                    drawContext.getCanvas().restore();
                    drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final void draw(DrawScope drawScope, float f5, ColorFilter colorFilter) {
        int m1539getArgb8888_sVssgQ;
        if (this.root.getIsTintable() && this.root.getTintColor() != 16 && VectorKt.tintableWithAlphaMask(getIntrinsicColorFilter$ui_release()) && VectorKt.tintableWithAlphaMask(colorFilter)) {
            m1539getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m1538getAlpha8_sVssgQ();
        } else {
            m1539getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
        }
        int i5 = m1539getArgb8888_sVssgQ;
        if (this.isDirty || !Size.m1374equalsimpl0(this.previousDrawSize, drawScope.mo1703getSizeNHjbRc()) || !ImageBitmapConfig.m1534equalsimpl0(i5, m1762getCacheBitmapConfig_sVssgQ$ui_release())) {
            this.tintFilter = ImageBitmapConfig.m1534equalsimpl0(i5, ImageBitmapConfig.INSTANCE.m1538getAlpha8_sVssgQ()) ? ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, this.root.getTintColor(), 0, 2, null) : null;
            this.rootScaleX = Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc()) / Size.m1377getWidthimpl(m1763getViewportSizeNHjbRc$ui_release());
            this.rootScaleY = Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()) / Size.m1375getHeightimpl(m1763getViewportSizeNHjbRc$ui_release());
            this.cacheDrawScope.m1750drawCachedImageFqjB98A(i5, IntSizeKt.IntSize((int) Math.ceil(Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc())), (int) Math.ceil(Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo1703getSizeNHjbRc();
        }
        if (colorFilter == null) {
            if (getIntrinsicColorFilter$ui_release() != null) {
                colorFilter = getIntrinsicColorFilter$ui_release();
            } else {
                colorFilter = this.tintFilter;
            }
        }
        this.cacheDrawScope.drawInto(drawScope, f5, colorFilter);
    }

    /* renamed from: getCacheBitmapConfig-_sVssgQ$ui_release, reason: not valid java name */
    public final int m1762getCacheBitmapConfig_sVssgQ$ui_release() {
        ImageBitmap mCachedImage = this.cacheDrawScope.getMCachedImage();
        return mCachedImage != null ? mCachedImage.mo1398getConfig_sVssgQ() : ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter.getValue();
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getViewportSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m1763getViewportSizeNHjbRc$ui_release() {
        return ((Size) this.viewportSize.getValue()).getPackedValue();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.intrinsicColorFilter.setValue(colorFilter);
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> function0) {
        this.invalidateCallback = function0;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1764setViewportSizeuvyYCjk$ui_release(long j5) {
        this.viewportSize.setValue(Size.m1370boximpl(j5));
    }

    public String toString() {
        String str = "Params: \tname: " + this.name + "\n\tviewportWidth: " + Size.m1377getWidthimpl(m1763getViewportSizeNHjbRc$ui_release()) + "\n\tviewportHeight: " + Size.m1375getHeightimpl(m1763getViewportSizeNHjbRc$ui_release()) + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        draw(drawScope, 1.0f, null);
    }
}
