package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"useClassValue", BuildConfig.FLAVOR, "createCache", "Lkotlin/reflect/jvm/internal/CacheByClass;", "V", BuildConfig.FLAVOR, "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CacheByClassKt {
    private static final boolean useClassValue = false;

    static {
        Object m3567constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3567constructorimpl = Result.m3567constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3573isSuccessimpl(m3567constructorimpl)) {
            m3567constructorimpl = Boolean.TRUE;
        }
        Object m3567constructorimpl2 = Result.m3567constructorimpl(m3567constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m3572isFailureimpl(m3567constructorimpl2)) {
            m3567constructorimpl2 = bool;
        }
        ((Boolean) m3567constructorimpl2).booleanValue();
    }

    public static final <V> CacheByClass<V> createCache(Function1<? super Class<?>, ? extends V> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        return new ConcurrentHashMapCache(compute);
    }
}
