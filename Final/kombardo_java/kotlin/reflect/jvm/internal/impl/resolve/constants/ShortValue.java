package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes3.dex */
public final class ShortValue extends IntegerValueConstant<Short> {
    public ShortValue(short s5) {
        super(Short.valueOf(s5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().intValue() + ".toShort()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType shortType = module.getBuiltIns().getShortType();
        Intrinsics.checkNotNullExpressionValue(shortType, "getShortType(...)");
        return shortType;
    }
}
