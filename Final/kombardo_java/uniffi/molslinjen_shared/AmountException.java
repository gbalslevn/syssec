package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00060\u0001j\u0002`\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/AmountException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "ErrorHandler", "NonMatchingCurrencyTypes", "Luniffi/molslinjen_shared/AmountException$NonMatchingCurrencyTypes;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AmountException extends Exception {

    /* renamed from: ErrorHandler, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/AmountException$ErrorHandler;", "Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;", "Luniffi/molslinjen_shared/AmountException;", "()V", "lift", "error_buf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: uniffi.molslinjen_shared.AmountException$ErrorHandler, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion implements UniffiRustCallStatusErrorHandler<AmountException> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // uniffi.molslinjen_shared.UniffiRustCallStatusErrorHandler
        public AmountException lift(RustBuffer.ByValue error_buf) {
            Intrinsics.checkNotNullParameter(error_buf, "error_buf");
            return (AmountException) FfiConverterTypeAmountError.INSTANCE.lift2(error_buf);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/AmountException$NonMatchingCurrencyTypes;", "Luniffi/molslinjen_shared/AmountException;", "()V", "message", BuildConfig.FLAVOR, "getMessage", "()Ljava/lang/String;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NonMatchingCurrencyTypes extends AmountException {
        public NonMatchingCurrencyTypes() {
            super(null);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return BuildConfig.FLAVOR;
        }
    }

    public /* synthetic */ AmountException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AmountException() {
    }
}
