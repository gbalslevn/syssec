package uniffi.molslinjen_shared;

import com.sun.jna.Structure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001:\u0001\u000bB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\nR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFuture;", "Lcom/sun/jna/Structure;", "handle", BuildConfig.FLAVOR, "free", "Luniffi/molslinjen_shared/UniffiForeignFutureFree;", "(JLuniffi/molslinjen_shared/UniffiForeignFutureFree;)V", "uniffiSetValue", BuildConfig.FLAVOR, "other", "uniffiSetValue$shared_release", "UniffiByValue", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"handle", "free"})
/* loaded from: classes3.dex */
public class UniffiForeignFuture extends Structure {
    public UniffiForeignFutureFree free;
    public long handle;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/UniffiForeignFuture$UniffiByValue;", "Luniffi/molslinjen_shared/UniffiForeignFuture;", "Lcom/sun/jna/Structure$ByValue;", "handle", BuildConfig.FLAVOR, "free", "Luniffi/molslinjen_shared/UniffiForeignFutureFree;", "(JLuniffi/molslinjen_shared/UniffiForeignFutureFree;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UniffiByValue extends UniffiForeignFuture implements Structure.ByValue {
        public UniffiByValue() {
            this(0L, null, 3, null);
        }

        public /* synthetic */ UniffiByValue(long j5, UniffiForeignFutureFree uniffiForeignFutureFree, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0L : j5, (i5 & 2) != 0 ? null : uniffiForeignFutureFree);
        }

        public UniffiByValue(long j5, UniffiForeignFutureFree uniffiForeignFutureFree) {
            super(j5, uniffiForeignFutureFree);
        }
    }

    public UniffiForeignFuture() {
        this(0L, null, 3, null);
    }

    public final void uniffiSetValue$shared_release(UniffiForeignFuture other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.handle = other.handle;
        this.free = other.free;
    }

    public /* synthetic */ UniffiForeignFuture(long j5, UniffiForeignFutureFree uniffiForeignFutureFree, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0L : j5, (i5 & 2) != 0 ? null : uniffiForeignFutureFree);
    }

    public UniffiForeignFuture(long j5, UniffiForeignFutureFree uniffiForeignFutureFree) {
        this.handle = j5;
        this.free = uniffiForeignFutureFree;
    }
}
