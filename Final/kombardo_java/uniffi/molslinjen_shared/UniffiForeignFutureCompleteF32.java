package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.UniffiForeignFutureStructF32;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFutureCompleteF32;", "Lcom/sun/jna/Callback;", Callback.METHOD_NAME, BuildConfig.FLAVOR, "callbackData", BuildConfig.FLAVOR, "result", "Luniffi/molslinjen_shared/UniffiForeignFutureStructF32$UniffiByValue;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiForeignFutureCompleteF32 extends Callback {
    void callback(long callbackData, UniffiForeignFutureStructF32.UniffiByValue result);
}
