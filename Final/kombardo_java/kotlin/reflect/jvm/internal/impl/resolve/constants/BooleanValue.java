package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes3.dex */
public final class BooleanValue extends ConstantValue<Boolean> {
    public BooleanValue(boolean z5) {
        super(Boolean.valueOf(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType booleanType = module.getBuiltIns().getBooleanType();
        Intrinsics.checkNotNullExpressionValue(booleanType, "getBooleanType(...)");
        return booleanType;
    }
}
