package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewRequesterKt", "androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewResponderKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final Modifier bringIntoViewRequester(Modifier modifier, BringIntoViewRequester bringIntoViewRequester) {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester(modifier, bringIntoViewRequester);
    }

    public static final BringIntoViewParent findBringIntoViewParent(DelegatableNode delegatableNode) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.findBringIntoViewParent(delegatableNode);
    }
}
