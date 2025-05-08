package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<DefaultBuiltIns> Instance$delegate = LazyKt.lazy(new Function0() { // from class: kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns$$Lambda$0
        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            DefaultBuiltIns Instance_delegate$lambda$0;
            Instance_delegate$lambda$0 = DefaultBuiltIns.Instance_delegate$lambda$0();
            return Instance_delegate$lambda$0;
        }
    });

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DefaultBuiltIns getInstance() {
            return (DefaultBuiltIns) DefaultBuiltIns.Instance$delegate.getValue();
        }

        private Companion() {
        }
    }

    public DefaultBuiltIns(boolean z5) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z5) {
            createBuiltInsModule(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultBuiltIns Instance_delegate$lambda$0() {
        return new DefaultBuiltIns(false, 1, null);
    }

    public /* synthetic */ DefaultBuiltIns(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z5);
    }
}
