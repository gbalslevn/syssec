package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/ui/graphics/vector/VectorGroup$iterator$1", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/vector/VectorNode;", BuildConfig.FLAVOR, "hasNext", "()Z", "next", "()Landroidx/compose/ui/graphics/vector/VectorNode;", "it", "Ljava/util/Iterator;", "getIt", "()Ljava/util/Iterator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorGroup$iterator$1 implements Iterator<VectorNode>, KMappedMarker {
    private final Iterator<VectorNode> it;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VectorGroup$iterator$1(VectorGroup vectorGroup) {
        List list;
        list = vectorGroup.children;
        this.it = list.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.it.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public VectorNode next() {
        return this.it.next();
    }
}
