package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes3.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    private final ReceiverValue original;
    protected final KotlinType receiverType;

    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str = (i5 == 1 || i5 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 1 || i5 == 2) ? 2 : 3];
        if (i5 == 1 || i5 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i5 == 1) {
            objArr[1] = "getType";
        } else if (i5 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i5 != 1 && i5 != 2) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public AbstractReceiverValue(KotlinType kotlinType, ReceiverValue receiverValue) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        this.receiverType = kotlinType;
        this.original = receiverValue == null ? this : receiverValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public KotlinType getType() {
        KotlinType kotlinType = this.receiverType;
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return kotlinType;
    }
}
