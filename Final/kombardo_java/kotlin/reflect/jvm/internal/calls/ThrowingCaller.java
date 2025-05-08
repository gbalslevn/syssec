package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", BuildConfig.FLAVOR, "<init>", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", BuildConfig.FLAVOR, "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", BuildConfig.FLAVOR, "args", BuildConfig.FLAVOR, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThrowingCaller implements Caller {
    public static final ThrowingCaller INSTANCE = new ThrowingCaller();

    private ThrowingCaller() {
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        Class TYPE = Void.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        return TYPE;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return Caller.DefaultImpls.isBoundInstanceCallWithValueClasses(this);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo3682getMember() {
        return (Member) getMember();
    }
}
