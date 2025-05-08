package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.LayerManager;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import kotlin.Metadata;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 %2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "Landroid/view/ViewGroup;", "ownerView", "<init>", "(Landroid/view/ViewGroup;)V", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "obtainViewLayerContainer", "(Landroid/view/ViewGroup;)Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "getUniqueDrawingId", "(Landroid/view/View;)J", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "createGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", BuildConfig.FLAVOR, "releaseGraphicsLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/view/ViewGroup;", BuildConfig.FLAVOR, "lock", "Ljava/lang/Object;", "Landroidx/compose/ui/graphics/layer/LayerManager;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", BuildConfig.FLAVOR, "componentCallbackRegistered", "Z", "predrawListenerRegistered", "Landroid/content/ComponentCallbacks2;", "componentCallback", "Landroid/content/ComponentCallbacks2;", "Companion", "UniqueDrawingIdApi29", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidGraphicsContext implements GraphicsContext {
    private static boolean isRenderNodeCompatible = true;
    private boolean componentCallbackRegistered;
    private final LayerManager layerManager;
    private final ViewGroup ownerView;
    private boolean predrawListenerRegistered;
    private DrawChildContainer viewLayerContainer;
    private final Object lock = new Object();
    private final ComponentCallbacks2 componentCallback = null;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", BuildConfig.FLAVOR, "()V", "getUniqueDrawingId", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        public static final long getUniqueDrawingId(View view) {
            long uniqueDrawingId;
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    public AndroidGraphicsContext(ViewGroup viewGroup) {
        this.ownerView = viewGroup;
    }

    private final long getUniqueDrawingId(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(view);
        }
        return -1L;
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup ownerView) {
        DrawChildContainer drawChildContainer = this.viewLayerContainer;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        ViewLayerContainer viewLayerContainer = new ViewLayerContainer(ownerView.getContext());
        ownerView.addView(viewLayerContainer);
        this.viewLayerContainer = viewLayerContainer;
        return viewLayerContainer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        GraphicsLayerImpl graphicsViewLayer;
        GraphicsLayer graphicsLayer;
        synchronized (this.lock) {
            try {
                long uniqueDrawingId = getUniqueDrawingId(this.ownerView);
                if (Build.VERSION.SDK_INT >= 29) {
                    graphicsViewLayer = new GraphicsLayerV29(uniqueDrawingId, null, null, 6, null);
                } else if (isRenderNodeCompatible) {
                    try {
                        graphicsViewLayer = new GraphicsLayerV23(this.ownerView, uniqueDrawingId, null, null, 12, null);
                    } catch (Throwable unused) {
                        isRenderNodeCompatible = false;
                        graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), uniqueDrawingId, null, null, 12, null);
                    }
                } else {
                    graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), uniqueDrawingId, null, null, 12, null);
                }
                graphicsLayer = new GraphicsLayer(graphicsViewLayer, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer layer) {
        synchronized (this.lock) {
            layer.release$ui_graphics_release();
            Unit unit = Unit.INSTANCE;
        }
    }
}
