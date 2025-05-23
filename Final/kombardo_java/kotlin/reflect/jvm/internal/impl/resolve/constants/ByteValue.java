package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes3.dex */
public final class ByteValue extends IntegerValueConstant<Byte> {
    public ByteValue(byte b5) {
        super(Byte.valueOf(b5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().intValue() + ".toByte()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType byteType = module.getBuiltIns().getByteType();
        Intrinsics.checkNotNullExpressionValue(byteType, "getByteType(...)");
        return byteType;
    }
}
