package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;", "Lcom/sun/jna/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "uniffiHandle", BuildConfig.FLAVOR, "level", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "message", "path", "file", "line", "uniffiOutReturn", "Lcom/sun/jna/Pointer;", "uniffiCallStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiCallbackInterfaceRustLoggerTraitMethod0 extends Callback {
    void callback(long uniffiHandle, RustBuffer.ByValue level, RustBuffer.ByValue message, RustBuffer.ByValue path, RustBuffer.ByValue file, RustBuffer.ByValue line, Pointer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus);
}
