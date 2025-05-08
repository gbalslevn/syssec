package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b*\f\b\u0002\u0010\u000b\"\u00020\u00012\u00020\u0001¨\u0006\f"}, d2 = {BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "CONDITION_FALSE", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "()V", "Node", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        if (removed != null && (lockFreeLinkedListNode = removed.ref) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) obj;
    }
}
