package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/RustBufferByReference;", "Lcom/sun/jna/ptr/ByReference;", "()V", "getValue", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "setValue", BuildConfig.FLAVOR, "value", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RustBufferByReference extends ByReference {
    public RustBufferByReference() {
        super(16);
    }

    public final RustBuffer.ByValue getValue() {
        Pointer pointer = getPointer();
        RustBuffer.ByValue byValue = new RustBuffer.ByValue();
        byValue.writeField("capacity", Long.valueOf(pointer.getLong(0L)));
        byValue.writeField("len", Long.valueOf(pointer.getLong(8L)));
        byValue.writeField("data", Long.valueOf(pointer.getLong(16L)));
        return byValue;
    }

    public final void setValue(RustBuffer.ByValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Pointer pointer = getPointer();
        pointer.setLong(0L, value.capacity);
        pointer.setLong(8L, value.len);
        pointer.setPointer(16L, value.data);
    }
}
