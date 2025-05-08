package dk.molslinjen.api.helpers.retry;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ldk/molslinjen/api/helpers/retry/EmptyResponseBodyAsSuccess;", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface EmptyResponseBodyAsSuccess {
}
