package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    /* loaded from: classes3.dex */
    public static final class AtLeast extends ValueParameterCountCheck {

        /* renamed from: n, reason: collision with root package name */
        private final int f6175n;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AtLeast(int i5) {
            super(r0.toString(), null);
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i5);
            sb.append(" value parameter");
            sb.append(i5 > 1 ? "s" : BuildConfig.FLAVOR);
            this.f6175n = i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.f6175n;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Equals extends ValueParameterCountCheck {

        /* renamed from: n, reason: collision with root package name */
        private final int f6176n;

        public Equals(int i5) {
            super("must have exactly " + i5 + " value parameters", null);
            this.f6176n = i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.f6176n;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        private NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* loaded from: classes3.dex */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        private SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    public /* synthetic */ ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    private ValueParameterCountCheck(String str) {
        this.description = str;
    }
}
