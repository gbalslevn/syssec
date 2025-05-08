package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/UniffiNullRustCallStatusErrorHandler;", "Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;", "Luniffi/molslinjen_shared/InternalException;", "()V", "lift", "error_buf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UniffiNullRustCallStatusErrorHandler implements UniffiRustCallStatusErrorHandler<InternalException> {
    public static final UniffiNullRustCallStatusErrorHandler INSTANCE = new UniffiNullRustCallStatusErrorHandler();

    private UniffiNullRustCallStatusErrorHandler() {
    }

    @Override // uniffi.molslinjen_shared.UniffiRustCallStatusErrorHandler
    public InternalException lift(RustBuffer.ByValue error_buf) {
        Intrinsics.checkNotNullParameter(error_buf, "error_buf");
        RustBuffer.INSTANCE.free$shared_release(error_buf);
        return new InternalException("Unexpected CALL_ERROR");
    }
}
