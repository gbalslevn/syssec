package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/compose/foundation/interaction/DragInteraction$Cancel", BuildConfig.FLAVOR, "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "start", "<init>", "(Landroidx/compose/foundation/interaction/DragInteraction$Start;)V", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getStart", "()Landroidx/compose/foundation/interaction/DragInteraction$Start;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragInteraction$Cancel implements Interaction {
    private final DragInteraction$Start start;

    public DragInteraction$Cancel(DragInteraction$Start dragInteraction$Start) {
        this.start = dragInteraction$Start;
    }

    public final DragInteraction$Start getStart() {
        return this.start;
    }
}
