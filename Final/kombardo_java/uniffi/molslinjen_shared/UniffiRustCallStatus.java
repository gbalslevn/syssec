package uniffi.molslinjen_shared;

import com.sun.jna.Structure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0011\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Luniffi/molslinjen_shared/UniffiRustCallStatus;", "Lcom/sun/jna/Structure;", "()V", "code", BuildConfig.FLAVOR, "error_buf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "isError", BuildConfig.FLAVOR, "isPanic", "isSuccess", "ByValue", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"code", "error_buf"})
/* loaded from: classes3.dex */
public class UniffiRustCallStatus extends Structure {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public byte code;
    public RustBuffer.ByValue error_buf = new RustBuffer.ByValue();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "Lcom/sun/jna/Structure$ByValue;", "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ByValue extends UniffiRustCallStatus implements Structure.ByValue {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Luniffi/molslinjen_shared/UniffiRustCallStatus$Companion;", BuildConfig.FLAVOR, "()V", "create", "Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "code", BuildConfig.FLAVOR, "errorBuf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ByValue create(byte code, RustBuffer.ByValue errorBuf) {
            Intrinsics.checkNotNullParameter(errorBuf, "errorBuf");
            ByValue byValue = new ByValue();
            byValue.code = code;
            byValue.error_buf = errorBuf;
            return byValue;
        }

        private Companion() {
        }
    }

    public final boolean isError() {
        return this.code == 1;
    }

    public final boolean isPanic() {
        return this.code == 2;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }
}
