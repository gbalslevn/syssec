package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/UniffiRustFutureContinuationCallback;", "Lcom/sun/jna/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "pollResult", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiRustFutureContinuationCallback extends Callback {
    void callback(long data, byte pollResult);
}
