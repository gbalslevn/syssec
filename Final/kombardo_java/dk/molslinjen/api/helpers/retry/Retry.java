package dk.molslinjen.api.helpers.retry;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001e\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\bR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\tR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/api/helpers/retry/Retry;", BuildConfig.FLAVOR, "max", BuildConfig.FLAVOR, "delay", BuildConfig.FLAVOR, "useExponentialBackoff", BuildConfig.FLAVOR, "()I", "()J", "()Z", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface Retry {
    long delay() default 2000;

    int max() default 3;

    boolean useExponentialBackoff() default true;
}
