package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiVTableCallbackInterfaceRustLoggerTrait;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRustLoggerTrait;", BuildConfig.FLAVOR, "()V", "vtable", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait$UniffiByValue;", "getVtable$shared_release", "()Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait$UniffiByValue;", "setVtable$shared_release", "(Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait$UniffiByValue;)V", "register", BuildConfig.FLAVOR, "lib", "Luniffi/molslinjen_shared/UniffiLib;", "register$shared_release", "log", "uniffiFree", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class uniffiCallbackInterfaceRustLoggerTrait {
    public static final uniffiCallbackInterfaceRustLoggerTrait INSTANCE = new uniffiCallbackInterfaceRustLoggerTrait();
    private static UniffiVTableCallbackInterfaceRustLoggerTrait.UniffiByValue vtable = new UniffiVTableCallbackInterfaceRustLoggerTrait.UniffiByValue(log.INSTANCE, uniffiFree.INSTANCE);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRustLoggerTrait$log;", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceRustLoggerTraitMethod0;", "()V", Callback.METHOD_NAME, BuildConfig.FLAVOR, "uniffiHandle", BuildConfig.FLAVOR, "level", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "message", "path", "file", "line", "uniffiOutReturn", "Lcom/sun/jna/Pointer;", "uniffiCallStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class log implements UniffiCallbackInterfaceRustLoggerTraitMethod0 {
        public static final log INSTANCE = new log();

        private log() {
        }

        @Override // uniffi.molslinjen_shared.UniffiCallbackInterfaceRustLoggerTraitMethod0
        public void callback(long uniffiHandle, final RustBuffer.ByValue level, final RustBuffer.ByValue message, final RustBuffer.ByValue path, final RustBuffer.ByValue file, final RustBuffer.ByValue line, Pointer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(line, "line");
            Intrinsics.checkNotNullParameter(uniffiOutReturn, "uniffiOutReturn");
            Intrinsics.checkNotNullParameter(uniffiCallStatus, "uniffiCallStatus");
            final RustLoggerTrait rustLoggerTrait = FfiConverterTypeRustLoggerTrait.INSTANCE.getHandleMap$shared_release().get(uniffiHandle);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: uniffi.molslinjen_shared.uniffiCallbackInterfaceRustLoggerTrait$log$callback$makeCall$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RustLoggerTrait rustLoggerTrait2 = RustLoggerTrait.this;
                    RustLoggerLevel rustLoggerLevel = (RustLoggerLevel) FfiConverterTypeRustLoggerLevel.INSTANCE.lift2(level);
                    String lift2 = FfiConverterString.INSTANCE.lift2(message);
                    FfiConverterOptionalString ffiConverterOptionalString = FfiConverterOptionalString.INSTANCE;
                    rustLoggerTrait2.mo3194logH3638Bo(rustLoggerLevel, lift2, (String) ffiConverterOptionalString.lift2(path), (String) ffiConverterOptionalString.lift2(file), (UInt) FfiConverterOptionalUInt.INSTANCE.lift2(line));
                }
            };
            try {
                new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.uniffiCallbackInterfaceRustLoggerTrait$log$callback$writeReturn$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Unit unit) {
                        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                        invoke2(unit);
                        return Unit.INSTANCE;
                    }
                }.invoke((uniffiCallbackInterfaceRustLoggerTrait$log$callback$writeReturn$1) function0.invoke());
            } catch (Exception e5) {
                uniffiCallStatus.code = (byte) 2;
                uniffiCallStatus.error_buf = FfiConverterString.INSTANCE.lower2(e5.toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRustLoggerTrait$uniffiFree;", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;", "()V", Callback.METHOD_NAME, BuildConfig.FLAVOR, "handle", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class uniffiFree implements UniffiCallbackInterfaceFree {
        public static final uniffiFree INSTANCE = new uniffiFree();

        private uniffiFree() {
        }

        @Override // uniffi.molslinjen_shared.UniffiCallbackInterfaceFree
        public void callback(long handle) {
            FfiConverterTypeRustLoggerTrait.INSTANCE.getHandleMap$shared_release().remove(handle);
        }
    }

    private uniffiCallbackInterfaceRustLoggerTrait() {
    }

    public final UniffiVTableCallbackInterfaceRustLoggerTrait.UniffiByValue getVtable$shared_release() {
        return vtable;
    }

    public final void register$shared_release(UniffiLib lib) {
        Intrinsics.checkNotNullParameter(lib, "lib");
        lib.uniffi_molslinjen_shared_fn_init_callback_vtable_rustloggertrait(vtable);
    }

    public final void setVtable$shared_release(UniffiVTableCallbackInterfaceRustLoggerTrait.UniffiByValue uniffiByValue) {
        Intrinsics.checkNotNullParameter(uniffiByValue, "<set-?>");
        vtable = uniffiByValue;
    }
}
