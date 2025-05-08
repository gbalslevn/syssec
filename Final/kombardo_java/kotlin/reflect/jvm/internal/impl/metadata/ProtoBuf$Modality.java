package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* loaded from: classes3.dex */
public enum ProtoBuf$Modality implements Internal.EnumLite {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);

    private static Internal.EnumLiteMap<ProtoBuf$Modality> internalValueMap = new Internal.EnumLiteMap<ProtoBuf$Modality>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
        public ProtoBuf$Modality findValueByNumber(int i5) {
            return ProtoBuf$Modality.valueOf(i5);
        }
    };
    private final int value;

    ProtoBuf$Modality(int i5, int i6) {
        this.value = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int i5) {
        if (i5 == 0) {
            return FINAL;
        }
        if (i5 == 1) {
            return OPEN;
        }
        if (i5 == 2) {
            return ABSTRACT;
        }
        if (i5 != 3) {
            return null;
        }
        return SEALED;
    }
}
