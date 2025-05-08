package uniffi.molslinjen_shared;

import com.sun.jna.Structure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiRustCallStatus;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFutureStructRustBuffer;", "Lcom/sun/jna/Structure;", "returnValue", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "callStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "(Luniffi/molslinjen_shared/RustBuffer$ByValue;Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;)V", "uniffiSetValue", BuildConfig.FLAVOR, "other", "uniffiSetValue$shared_release", "UniffiByValue", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"returnValue", "callStatus"})
/* loaded from: classes3.dex */
public class UniffiForeignFutureStructRustBuffer extends Structure {
    public UniffiRustCallStatus.ByValue callStatus;
    public RustBuffer.ByValue returnValue;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFutureStructRustBuffer$UniffiByValue;", "Luniffi/molslinjen_shared/UniffiForeignFutureStructRustBuffer;", "Lcom/sun/jna/Structure$ByValue;", "returnValue", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "callStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "(Luniffi/molslinjen_shared/RustBuffer$ByValue;Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UniffiByValue extends UniffiForeignFutureStructRustBuffer implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public UniffiByValue() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ UniffiByValue(RustBuffer.ByValue byValue, UniffiRustCallStatus.ByValue byValue2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new RustBuffer.ByValue() : byValue, (i5 & 2) != 0 ? new UniffiRustCallStatus.ByValue() : byValue2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UniffiByValue(RustBuffer.ByValue returnValue, UniffiRustCallStatus.ByValue callStatus) {
            super(returnValue, callStatus);
            Intrinsics.checkNotNullParameter(returnValue, "returnValue");
            Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UniffiForeignFutureStructRustBuffer() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void uniffiSetValue$shared_release(UniffiForeignFutureStructRustBuffer other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.returnValue = other.returnValue;
        this.callStatus = other.callStatus;
    }

    public /* synthetic */ UniffiForeignFutureStructRustBuffer(RustBuffer.ByValue byValue, UniffiRustCallStatus.ByValue byValue2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new RustBuffer.ByValue() : byValue, (i5 & 2) != 0 ? new UniffiRustCallStatus.ByValue() : byValue2);
    }

    public UniffiForeignFutureStructRustBuffer(RustBuffer.ByValue returnValue, UniffiRustCallStatus.ByValue callStatus) {
        Intrinsics.checkNotNullParameter(returnValue, "returnValue");
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        this.returnValue = returnValue;
        this.callStatus = callStatus;
    }
}
