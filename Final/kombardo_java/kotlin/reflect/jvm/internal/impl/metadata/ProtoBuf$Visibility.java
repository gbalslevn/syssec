package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* loaded from: classes3.dex */
public enum ProtoBuf$Visibility implements Internal.EnumLite {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);

    private static Internal.EnumLiteMap<ProtoBuf$Visibility> internalValueMap = new Internal.EnumLiteMap<ProtoBuf$Visibility>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
        public ProtoBuf$Visibility findValueByNumber(int i5) {
            return ProtoBuf$Visibility.valueOf(i5);
        }
    };
    private final int value;

    ProtoBuf$Visibility(int i5, int i6) {
        this.value = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int i5) {
        if (i5 == 0) {
            return INTERNAL;
        }
        if (i5 == 1) {
            return PRIVATE;
        }
        if (i5 == 2) {
            return PROTECTED;
        }
        if (i5 == 3) {
            return PUBLIC;
        }
        if (i5 == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i5 != 5) {
            return null;
        }
        return LOCAL;
    }
}
