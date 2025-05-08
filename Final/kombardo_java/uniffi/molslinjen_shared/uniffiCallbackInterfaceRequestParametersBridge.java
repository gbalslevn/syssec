package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.UniffiVTableCallbackInterfaceRequestParametersBridge;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRequestParametersBridge;", BuildConfig.FLAVOR, "()V", "vtable", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRequestParametersBridge$UniffiByValue;", "getVtable$shared_release", "()Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRequestParametersBridge$UniffiByValue;", "setVtable$shared_release", "(Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRequestParametersBridge$UniffiByValue;)V", "register", BuildConfig.FLAVOR, "lib", "Luniffi/molslinjen_shared/UniffiLib;", "register$shared_release", "language", "uniffiFree", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class uniffiCallbackInterfaceRequestParametersBridge {
    public static final uniffiCallbackInterfaceRequestParametersBridge INSTANCE = new uniffiCallbackInterfaceRequestParametersBridge();
    private static UniffiVTableCallbackInterfaceRequestParametersBridge.UniffiByValue vtable = new UniffiVTableCallbackInterfaceRequestParametersBridge.UniffiByValue(language.INSTANCE, uniffiFree.INSTANCE);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRequestParametersBridge$language;", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceRequestParametersBridgeMethod0;", "()V", Callback.METHOD_NAME, BuildConfig.FLAVOR, "uniffiHandle", BuildConfig.FLAVOR, "uniffiOutReturn", "Luniffi/molslinjen_shared/RustBuffer;", "uniffiCallStatus", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class language implements UniffiCallbackInterfaceRequestParametersBridgeMethod0 {
        public static final language INSTANCE = new language();

        private language() {
        }

        @Override // uniffi.molslinjen_shared.UniffiCallbackInterfaceRequestParametersBridgeMethod0
        public void callback(long uniffiHandle, final RustBuffer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus) {
            Intrinsics.checkNotNullParameter(uniffiOutReturn, "uniffiOutReturn");
            Intrinsics.checkNotNullParameter(uniffiCallStatus, "uniffiCallStatus");
            final RequestParametersBridge requestParametersBridge = FfiConverterTypeRequestParametersBridge.INSTANCE.getHandleMap$shared_release().get(uniffiHandle);
            Function0<String> function0 = new Function0<String>() { // from class: uniffi.molslinjen_shared.uniffiCallbackInterfaceRequestParametersBridge$language$callback$makeCall$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RequestParametersBridge.this.language();
                }
            };
            try {
                new Function1<String, Unit>() { // from class: uniffi.molslinjen_shared.uniffiCallbackInterfaceRequestParametersBridge$language$callback$writeReturn$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        RustBuffer.this.setValue$shared_release(FfiConverterOptionalString.INSTANCE.lower2((Object) str));
                    }
                }.invoke(function0.invoke());
            } catch (Exception e5) {
                uniffiCallStatus.code = (byte) 2;
                uniffiCallStatus.error_buf = FfiConverterString.INSTANCE.lower2(e5.toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/uniffiCallbackInterfaceRequestParametersBridge$uniffiFree;", "Luniffi/molslinjen_shared/UniffiCallbackInterfaceFree;", "()V", Callback.METHOD_NAME, BuildConfig.FLAVOR, "handle", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class uniffiFree implements UniffiCallbackInterfaceFree {
        public static final uniffiFree INSTANCE = new uniffiFree();

        private uniffiFree() {
        }

        @Override // uniffi.molslinjen_shared.UniffiCallbackInterfaceFree
        public void callback(long handle) {
            FfiConverterTypeRequestParametersBridge.INSTANCE.getHandleMap$shared_release().remove(handle);
        }
    }

    private uniffiCallbackInterfaceRequestParametersBridge() {
    }

    public final UniffiVTableCallbackInterfaceRequestParametersBridge.UniffiByValue getVtable$shared_release() {
        return vtable;
    }

    public final void register$shared_release(UniffiLib lib) {
        Intrinsics.checkNotNullParameter(lib, "lib");
        lib.uniffi_molslinjen_shared_fn_init_callback_vtable_requestparametersbridge(vtable);
    }

    public final void setVtable$shared_release(UniffiVTableCallbackInterfaceRequestParametersBridge.UniffiByValue uniffiByValue) {
        Intrinsics.checkNotNullParameter(uniffiByValue, "<set-?>");
        vtable = uniffiByValue;
    }
}
