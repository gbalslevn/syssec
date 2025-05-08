package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fBA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010 J!\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020)H\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b,\u0010-J7\u00104\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00152\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020/H\u0014¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010-J\u000f\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0004\b7\u0010-J\u000f\u00108\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u0010-J\"\u0010=\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001f\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>2\u0006\u0010:\u001a\u00020\u0015H\u0016¢\u0006\u0004\b@\u0010AJ9\u0010B\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¢\u0006\u0004\bB\u0010CJ\u001a\u0010H\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020DH\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001a\u0010J\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020DH\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u000f\u0010K\u001a\u00020\u000bH\u0002¢\u0006\u0004\bK\u0010-J\u000f\u0010L\u001a\u00020\u000bH\u0002¢\u0006\u0004\bL\u0010-R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010P\u001a\u0004\bQ\u0010RR,\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010SR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R*\u0010^\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010Y\u001a\u0004\b^\u0010\u0017\"\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010YR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00010e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001c\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010YR\u001a\u0010m\u001a\u00020l8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bm\u0010j\u001a\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020l8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010oR$\u0010y\u001a\u00020t2\u0006\u0010]\u001a\u00020t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010}\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Landroidx/compose/ui/platform/DrawChildContainer;", "container", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", BuildConfig.FLAVOR, "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "scope", "updateLayerProperties", "(Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;)V", BuildConfig.FLAVOR, "hasOverlappingRendering", "()Z", "Landroidx/compose/ui/geometry/Offset;", "position", "isInLayer-k-4lQ0M", "(J)Z", "isInLayer", "Landroidx/compose/ui/unit/IntSize;", "size", "resize-ozmzZPI", "(J)V", "resize", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "move", "canvas", "parentLayer", "drawLayer", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/graphics/Canvas;", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "invalidate", "()V", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "onLayout", "(ZIIII)V", "destroy", "updateDisplayList", "forceLayout", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapOffset", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "mapBounds", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "reuseLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transform-58bKbWc", "([F)V", "transform", "inverseTransform-58bKbWc", "inverseTransform", "updateOutlineResolver", "resetClipBounds", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroidx/compose/ui/platform/DrawChildContainer;", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/platform/OutlineResolver;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "clipToBounds", "Z", "Landroid/graphics/Rect;", "clipBoundsCache", "Landroid/graphics/Rect;", "value", "isInvalidated", "setInvalidated", "(Z)V", "drawnWithZ", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/platform/LayerMatrixCache;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/graphics/TransformOrigin;", "mTransformOrigin", "J", "mHasOverlappingRendering", BuildConfig.FLAVOR, "layerId", "getLayerId", "()J", "mutatedFields", "I", "getOwnerViewId", "ownerViewId", BuildConfig.FLAVOR, "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "cameraDistancePx", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "manualClipPath", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer {
    private static boolean hasRetrievedMethod;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;
    private final LayerMatrixCache<View> matrixCache;
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Function2<View, Matrix, Unit> getMatrix = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Matrix matrix) {
            invoke2(view, matrix);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }
    };
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            OutlineResolver outlineResolver;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            outlineResolver = ((ViewLayer) view).outlineResolver;
            Outline androidOutline = outlineResolver.getAndroidOutline();
            Intrinsics.checkNotNull(androidOutline);
            outline.set(androidOutline);
        }
    };

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "updateDisplayList", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "<set-?>", "hasRetrievedMethod", "Z", "getHasRetrievedMethod", "()Z", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "Lkotlin/Function2;", "Landroid/graphics/Matrix;", "getMatrix", "Lkotlin/jvm/functions/Function2;", "Ljava/lang/reflect/Field;", "recreateDisplayList", "Ljava/lang/reflect/Field;", "Ljava/lang/reflect/Method;", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z5) {
            ViewLayer.shouldUseDispatchDraw = z5;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void updateDisplayList(View view) {
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", null);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, null);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", BuildConfig.FLAVOR, "()V", "getUniqueDrawingId", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        public static final long getUniqueDrawingId(View view) {
            long uniqueDrawingId;
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver();
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void setInvalidated(boolean z5) {
        if (z5 != this.isInvalidated) {
            this.isInvalidated = z5;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z5);
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getAndroidOutline() != null ? OutlineProvider : null);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        boolean z5;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z5 = false;
        } else {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z5 = true;
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(androidCanvas, null);
        }
        if (z5) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        boolean z5 = getElevation() > 0.0f;
        this.drawnWithZ = z5;
        if (z5) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public long getLayerId() {
        return this.layerId;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo2076inverseTransform58bKbWc(float[] matrix) {
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this);
        if (m2139calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m1558timesAssign58bKbWc(matrix, m2139calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo2077isInLayerk4lQ0M(long position) {
        float m1337getXimpl = Offset.m1337getXimpl(position);
        float m1338getYimpl = Offset.m1338getYimpl(position);
        if (this.clipToBounds) {
            return 0.0f <= m1337getXimpl && m1337getXimpl < ((float) getWidth()) && 0.0f <= m1338getYimpl && m1338getYimpl < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.m2149isInOutlinek4lQ0M(position);
        }
        return true;
    }

    /* renamed from: isInvalidated, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        if (!inverse) {
            androidx.compose.ui.graphics.Matrix.m1551mapimpl(this.matrixCache.m2140calculateMatrixGrdbGEg(this), rect);
            return;
        }
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this);
        if (m2139calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m1551mapimpl(m2139calculateInverseMatrixbWbORWo, rect);
        } else {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo2078mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return androidx.compose.ui.graphics.Matrix.m1550mapMKHz9U(this.matrixCache.m2140calculateMatrixGrdbGEg(this), point);
        }
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this);
        return m2139calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m1550mapMKHz9U(m2139calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m1347getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo2079movegyyYBs(long position) {
        int m2640getXimpl = IntOffset.m2640getXimpl(position);
        if (m2640getXimpl != getLeft()) {
            offsetLeftAndRight(m2640getXimpl - getLeft());
            this.matrixCache.invalidate();
        }
        int m2641getYimpl = IntOffset.m2641getYimpl(position);
        if (m2641getYimpl != getTop()) {
            offsetTopAndBottom(m2641getYimpl - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l5, int t5, int r5, int b5) {
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo2080resizeozmzZPI(long size) {
        int m2661getWidthimpl = IntSize.m2661getWidthimpl(size);
        int m2660getHeightimpl = IntSize.m2660getHeightimpl(size);
        if (m2661getWidthimpl == getWidth() && m2660getHeightimpl == getHeight()) {
            return;
        }
        setPivotX(TransformOrigin.m1630getPivotFractionXimpl(this.mTransformOrigin) * m2661getWidthimpl);
        setPivotY(TransformOrigin.m1631getPivotFractionYimpl(this.mTransformOrigin) * m2660getHeightimpl);
        updateOutlineResolver();
        layout(getLeft(), getTop(), getLeft() + m2661getWidthimpl, getTop() + m2660getHeightimpl);
        resetClipBounds();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    public final void setCameraDistancePx(float f5) {
        setCameraDistance(f5 * getResources().getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo2081transform58bKbWc(float[] matrix) {
        androidx.compose.ui.graphics.Matrix.m1558timesAssign58bKbWc(matrix, this.matrixCache.m2140calculateMatrixGrdbGEg(this));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (!this.isInvalidated || shouldUseDispatchDraw) {
            return;
        }
        INSTANCE.updateDisplayList(this);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        if ((mutatedFields & 4096) != 0) {
            long transformOrigin = scope.getTransformOrigin();
            this.mTransformOrigin = transformOrigin;
            setPivotX(TransformOrigin.m1630getPivotFractionXimpl(transformOrigin) * getWidth());
            setPivotY(TransformOrigin.m1631getPivotFractionYimpl(this.mTransformOrigin) * getHeight());
        }
        if ((mutatedFields & 1) != 0) {
            setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            setElevation(scope.getShadowElevation());
        }
        if ((mutatedFields & 1024) != 0) {
            setRotation(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            setCameraDistancePx(scope.getCameraDistance());
        }
        boolean z5 = false;
        boolean z6 = getManualClipPath() != null;
        boolean z7 = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields & 24576) != 0) {
            this.clipToBounds = scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape();
            resetClipBounds();
            setClipToOutline(z7);
        }
        boolean m2150updateS_szKao = this.outlineResolver.m2150updateS_szKao(scope.getOutline(), scope.getAlpha(), z7, scope.getShadowElevation(), scope.getSize());
        if (this.outlineResolver.getCacheIsDirty()) {
            updateOutlineResolver();
        }
        boolean z8 = getManualClipPath() != null;
        if (z6 != z8 || (z8 && m2150updateS_szKao)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields & 7963) != 0) {
            this.matrixCache.invalidate();
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            if ((mutatedFields & 64) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this, ColorKt.m1508toArgb8_81llA(scope.getAmbientShadowColor()));
            }
            if ((mutatedFields & 128) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this, ColorKt.m1508toArgb8_81llA(scope.getSpotShadowColor()));
            }
        }
        if (i5 >= 31 && (131072 & mutatedFields) != 0) {
            ViewLayerVerificationHelper31 viewLayerVerificationHelper31 = ViewLayerVerificationHelper31.INSTANCE;
            scope.getRenderEffect();
            viewLayerVerificationHelper31.setRenderEffect(this, null);
        }
        if ((mutatedFields & 32768) != 0) {
            int compositingStrategy = scope.getCompositingStrategy();
            CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
            if (CompositingStrategy.m1510equalsimpl0(compositingStrategy, companion.m1515getOffscreenNrFUSI())) {
                setLayerType(2, null);
            } else if (CompositingStrategy.m1510equalsimpl0(compositingStrategy, companion.m1514getModulateAlphaNrFUSI())) {
                setLayerType(0, null);
                this.mHasOverlappingRendering = z5;
            } else {
                setLayerType(0, null);
            }
            z5 = true;
            this.mHasOverlappingRendering = z5;
        }
        this.mutatedFields = scope.getMutatedFields();
    }
}
