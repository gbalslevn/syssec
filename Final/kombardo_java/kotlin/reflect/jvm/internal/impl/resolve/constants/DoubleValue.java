package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes3.dex */
public final class DoubleValue extends ConstantValue<Double> {
    public DoubleValue(double d5) {
        super(Double.valueOf(d5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().doubleValue() + ".toDouble()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType doubleType = module.getBuiltIns().getDoubleType();
        Intrinsics.checkNotNullExpressionValue(doubleType, "getDoubleType(...)");
        return doubleType;
    }
}
