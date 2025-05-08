package uniffi.molslinjen_shared;

import com.sun.jna.internal.Cleaner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/UniffiJnaCleanable;", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Lcom/sun/jna/internal/Cleaner$Cleanable;", "(Lcom/sun/jna/internal/Cleaner$Cleanable;)V", "clean", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class UniffiJnaCleanable implements UniffiCleaner.Cleanable {
    private final Cleaner.Cleanable cleanable;

    public UniffiJnaCleanable(Cleaner.Cleanable cleanable) {
        Intrinsics.checkNotNullParameter(cleanable, "cleanable");
        this.cleanable = cleanable;
    }

    @Override // uniffi.molslinjen_shared.UniffiCleaner.Cleanable
    public void clean() {
        this.cleanable.clean();
    }
}
