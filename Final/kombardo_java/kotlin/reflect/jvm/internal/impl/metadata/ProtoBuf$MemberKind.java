package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* loaded from: classes3.dex */
public enum ProtoBuf$MemberKind implements Internal.EnumLite {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);

    private static Internal.EnumLiteMap<ProtoBuf$MemberKind> internalValueMap = new Internal.EnumLiteMap<ProtoBuf$MemberKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
        public ProtoBuf$MemberKind findValueByNumber(int i5) {
            return ProtoBuf$MemberKind.valueOf(i5);
        }
    };
    private final int value;

    ProtoBuf$MemberKind(int i5, int i6) {
        this.value = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$MemberKind valueOf(int i5) {
        if (i5 == 0) {
            return DECLARATION;
        }
        if (i5 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i5 == 2) {
            return DELEGATION;
        }
        if (i5 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }
}
