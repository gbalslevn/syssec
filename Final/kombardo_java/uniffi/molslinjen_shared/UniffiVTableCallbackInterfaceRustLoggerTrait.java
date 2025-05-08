package uniffi.molslinjen_shared;

import com.sun.jna.Structure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001:\u0001\u000bB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\nR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait;", "Lcom/sun/jna/Structure;", "log", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;", "uniffiFree", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;", "(Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;)V", "uniffiSetValue", BuildConfig.FLAVOR, "other", "uniffiSetValue$shared_release", "UniffiByValue", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"log", "uniffiFree"})
/* loaded from: classes3.dex */
public class UniffiVTableCallbackInterfaceRustLoggerTrait extends Structure {
    public UniffiCallbackInterfaceRustLoggerTraitMethod0 log;
    public UniffiCallbackInterfaceFree uniffiFree;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait$UniffiByValue;", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait;", "Lcom/sun/jna/Structure$ByValue;", "log", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;", "uniffiFree", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;", "(Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UniffiByValue extends UniffiVTableCallbackInterfaceRustLoggerTrait implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public UniffiByValue() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ UniffiByValue(UniffiCallbackInterfaceRustLoggerTraitMethod0 uniffiCallbackInterfaceRustLoggerTraitMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : uniffiCallbackInterfaceRustLoggerTraitMethod0, (i5 & 2) != 0 ? null : uniffiCallbackInterfaceFree);
        }

        public UniffiByValue(UniffiCallbackInterfaceRustLoggerTraitMethod0 uniffiCallbackInterfaceRustLoggerTraitMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
            super(uniffiCallbackInterfaceRustLoggerTraitMethod0, uniffiCallbackInterfaceFree);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UniffiVTableCallbackInterfaceRustLoggerTrait() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void uniffiSetValue$shared_release(UniffiVTableCallbackInterfaceRustLoggerTrait other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.log = other.log;
        this.uniffiFree = other.uniffiFree;
    }

    public /* synthetic */ UniffiVTableCallbackInterfaceRustLoggerTrait(UniffiCallbackInterfaceRustLoggerTraitMethod0 uniffiCallbackInterfaceRustLoggerTraitMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : uniffiCallbackInterfaceRustLoggerTraitMethod0, (i5 & 2) != 0 ? null : uniffiCallbackInterfaceFree);
    }

    public UniffiVTableCallbackInterfaceRustLoggerTrait(UniffiCallbackInterfaceRustLoggerTraitMethod0 uniffiCallbackInterfaceRustLoggerTraitMethod0, UniffiCallbackInterfaceFree uniffiCallbackInterfaceFree) {
        this.log = uniffiCallbackInterfaceRustLoggerTraitMethod0;
        this.uniffiFree = uniffiCallbackInterfaceFree;
    }
}
