package uniffi.molslinjen_shared;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;", "E", BuildConfig.FLAVOR, "lift", "error_buf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "(Luniffi/molslinjen_shared/RustBuffer$ByValue;)Ljava/lang/Object;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiRustCallStatusErrorHandler<E> {
    E lift(RustBuffer.ByValue error_buf);
}
