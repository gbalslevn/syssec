package uniffi.molslinjen_shared;

import com.sun.jna.Structure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.UniffiRustCallStatus;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFutureStructVoid;", "Lcom/sun/jna/Structure;", "callStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "(Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;)V", "uniffiSetValue", BuildConfig.FLAVOR, "other", "uniffiSetValue$shared_release", "UniffiByValue", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"callStatus"})
/* loaded from: classes3.dex */
public class UniffiForeignFutureStructVoid extends Structure {
    public UniffiRustCallStatus.ByValue callStatus;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFutureStructVoid$UniffiByValue;", "Luniffi/molslinjen_shared/UniffiForeignFutureStructVoid;", "Lcom/sun/jna/Structure$ByValue;", "callStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;", "(Luniffi/molslinjen_shared/UniffiRustCallStatus$ByValue;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UniffiByValue extends UniffiForeignFutureStructVoid implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public UniffiByValue() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ UniffiByValue(UniffiRustCallStatus.ByValue byValue, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UniffiByValue(UniffiRustCallStatus.ByValue callStatus) {
            super(callStatus);
            Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UniffiForeignFutureStructVoid() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void uniffiSetValue$shared_release(UniffiForeignFutureStructVoid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.callStatus = other.callStatus;
    }

    public /* synthetic */ UniffiForeignFutureStructVoid(UniffiRustCallStatus.ByValue byValue, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new UniffiRustCallStatus.ByValue() : byValue);
    }

    public UniffiForeignFutureStructVoid(UniffiRustCallStatus.ByValue callStatus) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        this.callStatus = callStatus;
    }
}
