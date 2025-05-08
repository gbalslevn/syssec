package androidx.compose.ui.draganddrop;

import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "positionInRoot", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragAndDrop_androidKt {
    public static final long getPositionInRoot(DragAndDropEvent dragAndDropEvent) {
        return OffsetKt.Offset(dragAndDropEvent.getDragEvent().getX(), dragAndDropEvent.getDragEvent().getY());
    }
}
