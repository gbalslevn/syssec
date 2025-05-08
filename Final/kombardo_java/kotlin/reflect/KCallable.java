package kotlin.reflect;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0005\u001a\u00028\u00002\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KCallable;", "R", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "name", BuildConfig.FLAVOR, "isSuspend", "()Z", "isSuspend$annotations", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KCallable<R> {
    R call(Object... args);

    String getName();

    boolean isSuspend();
}
