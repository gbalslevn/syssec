package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Luniffi/molslinjen_shared/UniffiCallbackInterfaceRequestParametersBridgeMethod0;", "Lcom/sun/jna/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "uniffiHandle", BuildConfig.FLAVOR, "uniffiOutReturn", "Luniffi/molslinjen_shared/RustBuffer;", "uniffiCallStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiCallbackInterfaceRequestParametersBridgeMethod0 extends Callback {
    void callback(long uniffiHandle, RustBuffer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus);
}
