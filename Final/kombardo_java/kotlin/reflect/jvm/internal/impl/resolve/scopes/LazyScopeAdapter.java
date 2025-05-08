package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes3.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(Function0<? extends MemberScope> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(getScope, "getScope");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberScope lazyScope$lambda$1(Function0 function0) {
        MemberScope memberScope = (MemberScope) function0.invoke();
        return memberScope instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) memberScope).getActualScope() : memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? LockBasedStorageManager.NO_LOCKS : storageManager, function0);
    }

    public LazyScopeAdapter(StorageManager storageManager, final Function0<? extends MemberScope> getScope) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(getScope, "getScope");
        this.lazyScope = storageManager.createLazyValue(new Function0(getScope) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter$$Lambda$0
            private final Function0 arg$0;

            {
                this.arg$0 = getScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                MemberScope lazyScope$lambda$1;
                lazyScope$lambda$1 = LazyScopeAdapter.lazyScope$lambda$1(this.arg$0);
                return lazyScope$lambda$1;
            }
        });
    }
}
