package androidx.compose.ui.draw;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/draw/ScopedGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "()V", "allocatedGraphicsLayers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "value", "graphicsContext", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "setGraphicsContext", "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "createGraphicsLayer", "releaseGraphicsLayer", BuildConfig.FLAVOR, "layer", "releaseGraphicsLayers", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScopedGraphicsContext implements GraphicsContext {
    private MutableObjectList<GraphicsLayer> allocatedGraphicsLayers;
    private GraphicsContext graphicsContext;

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        GraphicsContext graphicsContext = this.graphicsContext;
        if (!(graphicsContext != null)) {
            InlineClassHelperKt.throwIllegalStateException("GraphicsContext not provided");
        }
        GraphicsLayer createGraphicsLayer = graphicsContext.createGraphicsLayer();
        MutableObjectList<GraphicsLayer> mutableObjectList = this.allocatedGraphicsLayers;
        if (mutableObjectList == null) {
            this.allocatedGraphicsLayers = ObjectListKt.mutableObjectListOf(createGraphicsLayer);
        } else {
            mutableObjectList.add(createGraphicsLayer);
        }
        return createGraphicsLayer;
    }

    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer layer) {
        GraphicsContext graphicsContext = this.graphicsContext;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(layer);
        }
    }

    public final void releaseGraphicsLayers() {
        MutableObjectList<GraphicsLayer> mutableObjectList = this.allocatedGraphicsLayers;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.content;
            int i5 = mutableObjectList._size;
            for (int i6 = 0; i6 < i5; i6++) {
                releaseGraphicsLayer((GraphicsLayer) objArr[i6]);
            }
            mutableObjectList.clear();
        }
    }

    public final void setGraphicsContext(GraphicsContext graphicsContext) {
        releaseGraphicsLayers();
        this.graphicsContext = graphicsContext;
    }
}
