package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;

/* loaded from: classes3.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    /* loaded from: classes3.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsBoolean._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType booleanType = kotlinBuiltIns.getBooleanType();
            Intrinsics.checkNotNullExpressionValue(booleanType, "getBooleanType(...)");
            return booleanType;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsInt._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType intType = kotlinBuiltIns.getIntType();
            Intrinsics.checkNotNullExpressionValue(intType, "getIntType(...)");
            return intType;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType _init_$lambda$0;
                    _init_$lambda$0 = ReturnsCheck.ReturnsUnit._init_$lambda$0((KotlinBuiltIns) obj);
                    return _init_$lambda$0;
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType unitType = kotlinBuiltIns.getUnitType();
            Intrinsics.checkNotNullExpressionValue(unitType, "getUnitType(...)");
            return unitType;
        }
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + str;
    }
}
