package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* loaded from: classes3.dex */
public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();

    private StrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(UnwrappedType a5, UnwrappedType b5) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, a5, b5);
    }
}
