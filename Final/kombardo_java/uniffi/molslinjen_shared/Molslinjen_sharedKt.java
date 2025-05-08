package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000þ\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"\u001a\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0002\u001a\"\u0010%\u001a\u0002H&\"\n\b\u0000\u0010&\u0018\u0001*\u00020'2\u0006\u0010$\u001a\u00020\u0013H\u0082\b¢\u0006\u0002\u0010(\u001a\u0006\u0010)\u001a\u00020*\u001a\u0006\u0010+\u001a\u00020,\u001a\u0006\u0010-\u001a\u00020.\u001a\u0016\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203\u001a\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u000206H\u0002\u001a,\u00107\u001a\u00020\u0011\"\f\b\u0000\u00108*\u000609j\u0002`:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H80<2\u0006\u0010=\u001a\u00020>H\u0002\u001a\u0010\u0010?\u001a\u00020\u00112\u0006\u00105\u001a\u000206H\u0002\u001a\u0006\u0010@\u001a\u00020\u0011\u001a(\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002HB0DH\u0082\b¢\u0006\u0002\u0010E\u001a£\u0001\u0010F\u001a\u0002HG\"\u0004\b\u0000\u0010G\"\u0004\b\u0001\u0010H\"\f\b\u0002\u00108*\u000609j\u0002`:2\u0006\u0010I\u001a\u00020J2\u001e\u0010K\u001a\u001a\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00110L2\u0018\u0010N\u001a\u0014\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002HH0O2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00110D2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HH\u0012\u0004\u0012\u0002HG0D2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H80<H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010R\u001aD\u0010S\u001a\u0002HB\"\u0004\b\u0000\u0010B\"\f\b\u0001\u00108*\u000609j\u0002`:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H80<2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002HB0DH\u0082\b¢\u0006\u0002\u0010T\u001a<\u0010U\u001a\u00020\u0011\"\u0004\b\u0000\u0010G2\u0006\u0010V\u001a\u00020>2\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HG0X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u00020\u00110DH\u0080\bø\u0001\u0001\u001a\\\u0010Z\u001a\u00020\u0011\"\u0004\b\u0000\u0010G\"\n\b\u0001\u00108\u0018\u0001*\u00020[2\u0006\u0010V\u001a\u00020>2\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HG0X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u00020\u00110D2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020]0DH\u0080\bø\u0001\u0001\u001a\f\u0010^\u001a\u00020_*\u00020`H\u0002\u001a;\u0010a\u001a\u0002Hb\"\n\b\u0000\u0010G*\u0004\u0018\u00010c\"\u0004\b\u0001\u0010b*\u0002HG2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002Hb0DH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\" \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f*\n\u0010f\"\u00020g2\u00020g*\n\u0010h\"\u00020i2\u00020i*\n\u0010j\"\u00020k2\u00020k*\n\u0010l\"\u00020m2\u00020m\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006n"}, d2 = {"IDX_CALLBACK_FREE", BuildConfig.FLAVOR, "UNIFFI_CALLBACK_ERROR", "UNIFFI_CALLBACK_SUCCESS", "UNIFFI_CALLBACK_UNEXPECTED_ERROR", "UNIFFI_CALL_ERROR", BuildConfig.FLAVOR, "UNIFFI_CALL_SUCCESS", "UNIFFI_CALL_UNEXPECTED_ERROR", "UNIFFI_RUST_FUTURE_POLL_MAYBE_READY", "UNIFFI_RUST_FUTURE_POLL_READY", "uniffiContinuationHandleMap", "Luniffi/molslinjen_shared/UniffiHandleMap;", "Lkotlinx/coroutines/CancellableContinuation;", "getUniffiContinuationHandleMap", "()Luniffi/molslinjen_shared/UniffiHandleMap;", "constantsApiSetAgillicBaseUrl", BuildConfig.FLAVOR, "newUrl", BuildConfig.FLAVOR, "constantsApiSetMolslinjenBaseUrl", "ffiConfigurationManager", "Luniffi/molslinjen_shared/ConfigurationManager;", "ffiInitializeApiAuthenticationBridge", "apiAuthenticationBridge", "Luniffi/molslinjen_shared/ApiAuthenticationBridge;", "ffiInitializeConfiguration", "config", "Luniffi/molslinjen_shared/BuildConfiguration;", "ffiInitializeRequestParametersBridge", "requestParametersBridge", "Luniffi/molslinjen_shared/RequestParametersBridge;", "ffiSetGlobalProxyUsage", "useProxy", BuildConfig.FLAVOR, "findLibraryName", "componentName", "loadIndirect", "Lib", "Lcom/sun/jna/Library;", "(Ljava/lang/String;)Lcom/sun/jna/Library;", "mockAmount", "Luniffi/molslinjen_shared/Amount;", "mockFerrySeat", "Luniffi/molslinjen_shared/FerrySeat;", "mockFerrySeatingSection", "Luniffi/molslinjen_shared/FerrySeatingSection;", "setRustLogger", "logger", "Luniffi/molslinjen_shared/RustLoggerTrait;", "maxLevel", "Luniffi/molslinjen_shared/RustLoggerLevel;", "uniffiCheckApiChecksums", "lib", "Luniffi/molslinjen_shared/IntegrityCheckingUniffiLib;", "uniffiCheckCallStatus", "E", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorHandler", "Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;", "status", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "uniffiCheckContractApiVersion", "uniffiEnsureInitialized", "uniffiRustCall", "U", Callback.METHOD_NAME, "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "uniffiRustCallAsync", "T", "F", "rustFuture", BuildConfig.FLAVOR, "pollFunc", "Lkotlin/Function3;", "Luniffi/molslinjen_shared/UniffiRustFutureContinuationCallback;", "completeFunc", "Lkotlin/Function2;", "freeFunc", "liftFunc", "(JLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uniffiRustCallWithError", "(Luniffi/molslinjen_shared/UniffiRustCallStatusErrorHandler;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "uniffiTraitInterfaceCall", "callStatus", "makeCall", "Lkotlin/Function0;", "writeReturn", "uniffiTraitInterfaceCallWithError", BuildConfig.FLAVOR, "lowerError", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "create", "Luniffi/molslinjen_shared/UniffiCleaner;", "Luniffi/molslinjen_shared/UniffiCleaner$Companion;", "use", "R", "Luniffi/molslinjen_shared/Disposable;", "block", "(Luniffi/molslinjen_shared/Disposable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Decimal", "Ljava/math/BigDecimal;", "Url", "Ljava/net/URL;", "UtcDateTime", "Lorg/threeten/bp/LocalDateTime;", "Uuid", "Ljava/util/UUID;", "shared_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Molslinjen_sharedKt {
    public static final int IDX_CALLBACK_FREE = 0;
    public static final int UNIFFI_CALLBACK_ERROR = 1;
    public static final int UNIFFI_CALLBACK_SUCCESS = 0;
    public static final int UNIFFI_CALLBACK_UNEXPECTED_ERROR = 2;
    public static final byte UNIFFI_CALL_ERROR = 1;
    public static final byte UNIFFI_CALL_SUCCESS = 0;
    public static final byte UNIFFI_CALL_UNEXPECTED_ERROR = 2;
    public static final byte UNIFFI_RUST_FUTURE_POLL_MAYBE_READY = 1;
    public static final byte UNIFFI_RUST_FUTURE_POLL_READY = 0;
    private static final UniffiHandleMap<CancellableContinuation<Byte>> uniffiContinuationHandleMap = new UniffiHandleMap<>();

    public static final void constantsApiSetAgillicBaseUrl(String newUrl) {
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_constants_api_set_agillic_base_url(FfiConverterString.INSTANCE.lower2(newUrl), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final void constantsApiSetMolslinjenBaseUrl(String newUrl) {
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_constants_api_set_molslinjen_base_url(FfiConverterString.INSTANCE.lower2(newUrl), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final UniffiCleaner create(UniffiCleaner.Companion companion) {
        try {
            Class.forName("java.lang.ref.Cleaner");
            return new JavaLangRefCleaner();
        } catch (ClassNotFoundException unused) {
            return new UniffiJnaCleaner();
        }
    }

    public static final ConfigurationManager ffiConfigurationManager() {
        FfiConverterTypeConfigurationManager ffiConverterTypeConfigurationManager = FfiConverterTypeConfigurationManager.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_ffi_configuration_manager = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_ffi_configuration_manager(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (ConfigurationManager) ffiConverterTypeConfigurationManager.lift2(uniffi_molslinjen_shared_fn_func_ffi_configuration_manager);
    }

    public static final void ffiInitializeApiAuthenticationBridge(ApiAuthenticationBridge apiAuthenticationBridge) {
        Intrinsics.checkNotNullParameter(apiAuthenticationBridge, "apiAuthenticationBridge");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_ffi_initialize_api_authentication_bridge(FfiConverterTypeApiAuthenticationBridge.INSTANCE.lower2(apiAuthenticationBridge), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final void ffiInitializeConfiguration(BuildConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_ffi_initialize_configuration(FfiConverterTypeBuildConfiguration.INSTANCE.lower2((Object) config), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final void ffiInitializeRequestParametersBridge(RequestParametersBridge requestParametersBridge) {
        Intrinsics.checkNotNullParameter(requestParametersBridge, "requestParametersBridge");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_ffi_initialize_request_parameters_bridge(FfiConverterTypeRequestParametersBridge.INSTANCE.lower2(requestParametersBridge), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final void ffiSetGlobalProxyUsage(boolean z5) {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_ffi_set_global_proxy_usage(FfiConverterBoolean.INSTANCE.lower(z5).byteValue(), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final synchronized String findLibraryName(String str) {
        synchronized (Molslinjen_sharedKt.class) {
            String property = System.getProperty("uniffi.component." + str + ".libraryOverride");
            return property != null ? property : "molslinjen_shared";
        }
    }

    public static final UniffiHandleMap<CancellableContinuation<Byte>> getUniffiContinuationHandleMap() {
        return uniffiContinuationHandleMap;
    }

    private static final /* synthetic */ <Lib extends Library> Lib loadIndirect(String str) {
        String findLibraryName = findLibraryName(str);
        Intrinsics.reifiedOperationMarker(4, "Lib");
        Lib lib = (Lib) Native.load(findLibraryName, Library.class);
        Intrinsics.checkNotNullExpressionValue(lib, "load(...)");
        return lib;
    }

    public static final Amount mockAmount() {
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_amount = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_mock_amount(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_func_mock_amount);
    }

    public static final FerrySeat mockFerrySeat() {
        FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat = FfiConverterTypeFerrySeat.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_ferry_seat = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_mock_ferry_seat(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeat) ffiConverterTypeFerrySeat.lift2(uniffi_molslinjen_shared_fn_func_mock_ferry_seat);
    }

    public static final FerrySeatingSection mockFerrySeatingSection() {
        FfiConverterTypeFerrySeatingSection ffiConverterTypeFerrySeatingSection = FfiConverterTypeFerrySeatingSection.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_ferry_seating_section = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_mock_ferry_seating_section(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeatingSection) ffiConverterTypeFerrySeatingSection.lift2(uniffi_molslinjen_shared_fn_func_mock_ferry_seating_section);
    }

    public static final void setRustLogger(RustLoggerTrait logger, RustLoggerLevel maxLevel) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(maxLevel, "maxLevel");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_func_set_rust_logger(FfiConverterTypeRustLoggerTrait.INSTANCE.lower2(logger), FfiConverterTypeRustLoggerLevel.INSTANCE.lower2((Object) maxLevel), uniffiRustCallStatus);
        Unit unit = Unit.INSTANCE;
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }

    public static final void uniffiCheckApiChecksums(IntegrityCheckingUniffiLib integrityCheckingUniffiLib) {
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_constants_api_set_agillic_base_url() != -20103) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_constants_api_set_molslinjen_base_url() != 21485) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_ffi_configuration_manager() != 25885) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_ffi_initialize_api_authentication_bridge() != 2636) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_ffi_initialize_configuration() != -2176) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_ffi_initialize_request_parameters_bridge() != -10447) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_ffi_set_global_proxy_usage() != 27859) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_mock_amount() != -21798) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_mock_ferry_seat() != -24847) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_mock_ferry_seating_section() != 19022) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_func_set_rust_logger() != -20677) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_agillichandler_feedback() != 5632) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_agillichandler_give_consent() != -13272) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_agillichandler_register() != 17876) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_agillichandler_unregister() != 17521) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_agillichandler_withdraw_consent() != 23426) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_add_charge() != 26442) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_adding() != -4404) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_charge_count() != -4768) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_currency() != 25097) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_ensure_above() != -7693) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_monetary_amount() != -7218) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_multiplied_by() != -19536) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_negation() != 24768) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_amountwrapper_remove_charges() != 25950) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_apiauthenticationbridge_current_agillic_authentication() != -1849) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_departurelowpricehandler_get_lowest_prices() != -14683) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_requestparametersbridge_language() != -6527) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_rustloggertrait_log() != 20301) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghandler_get_floor_plan() != -19966) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghandler_reserve_seats() != 22861) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghandler_un_reserve_seats() != -21155) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghandler_update_reserved_seats() != -18698) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat() != -31943) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat_group() != 12112) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_section() != -23887) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_details() != 22204) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_overview() != 5298) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_constructor_agillichandler_new() != 31251) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_constructor_amountwrapper_new() != -10647) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_constructor_departurelowpricehandler_new() != -11179) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_constructor_selectseatinghandler_new() != 7532) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_molslinjen_shared_checksum_constructor_selectseatinghelper_new() != 22931) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
    }

    public static final <E extends Exception> void uniffiCheckCallStatus(UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler, UniffiRustCallStatus uniffiRustCallStatus) {
        if (uniffiRustCallStatus.isSuccess()) {
            return;
        }
        if (uniffiRustCallStatus.isError()) {
            throw uniffiRustCallStatusErrorHandler.lift(uniffiRustCallStatus.error_buf);
        }
        if (uniffiRustCallStatus.isPanic()) {
            if (uniffiRustCallStatus.error_buf.len <= 0) {
                throw new InternalException("Rust panic");
            }
            throw new InternalException(FfiConverterString.INSTANCE.lift2(uniffiRustCallStatus.error_buf));
        }
        throw new InternalException("Unknown rust call status: " + uniffiRustCallStatus + ".code");
    }

    public static final void uniffiCheckContractApiVersion(IntegrityCheckingUniffiLib integrityCheckingUniffiLib) {
        if (29 != integrityCheckingUniffiLib.ffi_molslinjen_shared_uniffi_contract_version()) {
            throw new RuntimeException("UniFFI contract version mismatch: try cleaning and rebuilding your project");
        }
    }

    public static final void uniffiEnsureInitialized() {
        UniffiLib.INSTANCE.getINSTANCE$shared_release();
    }

    private static final <U> U uniffiRustCall(Function1<? super UniffiRustCallStatus, ? extends U> function1) {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        U invoke = function1.invoke(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return invoke;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b2 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:14:0x00aa, B:16:0x00b2, B:22:0x0064, B:24:0x009d), top: B:13:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:14:0x00aa, B:16:0x00b2, B:22:0x0064, B:24:0x009d), top: B:13:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a7 -> B:13:0x00aa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, F, E extends Exception> Object uniffiRustCallAsync(long j5, Function3<? super Long, ? super UniffiRustFutureContinuationCallback, ? super Long, Unit> function3, Function2<? super Long, ? super UniffiRustCallStatus, ? extends F> function2, Function1<? super Long, Unit> function1, Function1<? super F, ? extends T> function12, UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler, Continuation<? super T> continuation) {
        Molslinjen_sharedKt$uniffiRustCallAsync$1 molslinjen_sharedKt$uniffiRustCallAsync$1;
        int i5;
        long j6;
        Function3<? super Long, ? super UniffiRustFutureContinuationCallback, ? super Long, Unit> function32;
        Function1<? super Long, Unit> function13;
        Function1<? super F, ? extends T> function14;
        UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler2;
        Molslinjen_sharedKt$uniffiRustCallAsync$1 molslinjen_sharedKt$uniffiRustCallAsync$12;
        Function2<? super Long, ? super UniffiRustCallStatus, ? extends F> function22;
        Throwable th;
        Object result;
        if (continuation instanceof Molslinjen_sharedKt$uniffiRustCallAsync$1) {
            molslinjen_sharedKt$uniffiRustCallAsync$1 = (Molslinjen_sharedKt$uniffiRustCallAsync$1) continuation;
            int i6 = molslinjen_sharedKt$uniffiRustCallAsync$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                molslinjen_sharedKt$uniffiRustCallAsync$1.label = i6 - Integer.MIN_VALUE;
                Object obj = molslinjen_sharedKt$uniffiRustCallAsync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = molslinjen_sharedKt$uniffiRustCallAsync$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    j6 = j5;
                    function32 = function3;
                    function13 = function1;
                    function14 = function12;
                    uniffiRustCallStatusErrorHandler2 = uniffiRustCallStatusErrorHandler;
                    molslinjen_sharedKt$uniffiRustCallAsync$12 = molslinjen_sharedKt$uniffiRustCallAsync$1;
                    function22 = function2;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.L$0 = function32;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.L$1 = function22;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.L$2 = function13;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.L$3 = function14;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.L$4 = uniffiRustCallStatusErrorHandler2;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.J$0 = j6;
                    molslinjen_sharedKt$uniffiRustCallAsync$12.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(molslinjen_sharedKt$uniffiRustCallAsync$12), 1);
                    cancellableContinuationImpl.initCancellability();
                    function32.invoke(Boxing.boxLong(j6), uniffiRustFutureContinuationCallbackImpl.INSTANCE, Boxing.boxLong(getUniffiContinuationHandleMap().insert(cancellableContinuationImpl)));
                    result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (result != coroutine_suspended) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j6 = molslinjen_sharedKt$uniffiRustCallAsync$1.J$0;
                    UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler3 = (UniffiRustCallStatusErrorHandler) molslinjen_sharedKt$uniffiRustCallAsync$1.L$4;
                    function14 = (Function1) molslinjen_sharedKt$uniffiRustCallAsync$1.L$3;
                    Function1<? super Long, Unit> function15 = (Function1) molslinjen_sharedKt$uniffiRustCallAsync$1.L$2;
                    Function2<? super Long, ? super UniffiRustCallStatus, ? extends F> function23 = (Function2) molslinjen_sharedKt$uniffiRustCallAsync$1.L$1;
                    Function3<? super Long, ? super UniffiRustFutureContinuationCallback, ? super Long, Unit> function33 = (Function3) molslinjen_sharedKt$uniffiRustCallAsync$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        molslinjen_sharedKt$uniffiRustCallAsync$12 = molslinjen_sharedKt$uniffiRustCallAsync$1;
                        function22 = function23;
                        uniffiRustCallStatusErrorHandler2 = uniffiRustCallStatusErrorHandler3;
                        function13 = function15;
                        try {
                            if (((Number) obj).byteValue() != 0) {
                                UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
                                F invoke = function22.invoke(Boxing.boxLong(j6), uniffiRustCallStatus);
                                uniffiCheckCallStatus(uniffiRustCallStatusErrorHandler2, uniffiRustCallStatus);
                                T invoke2 = function14.invoke(invoke);
                                function13.invoke(Boxing.boxLong(j6));
                                return invoke2;
                            }
                            function32 = function33;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.L$0 = function32;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.L$1 = function22;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.L$2 = function13;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.L$3 = function14;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.L$4 = uniffiRustCallStatusErrorHandler2;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.J$0 = j6;
                            molslinjen_sharedKt$uniffiRustCallAsync$12.label = 1;
                            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(molslinjen_sharedKt$uniffiRustCallAsync$12), 1);
                            cancellableContinuationImpl2.initCancellability();
                            function32.invoke(Boxing.boxLong(j6), uniffiRustFutureContinuationCallbackImpl.INSTANCE, Boxing.boxLong(getUniffiContinuationHandleMap().insert(cancellableContinuationImpl2)));
                            result = cancellableContinuationImpl2.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(molslinjen_sharedKt$uniffiRustCallAsync$12);
                            }
                            if (result != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function33 = function32;
                            obj = result;
                            if (((Number) obj).byteValue() != 0) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            function15 = function13;
                            function15.invoke(Boxing.boxLong(j6));
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        function15.invoke(Boxing.boxLong(j6));
                        throw th;
                    }
                }
            }
        }
        molslinjen_sharedKt$uniffiRustCallAsync$1 = new Molslinjen_sharedKt$uniffiRustCallAsync$1(continuation);
        Object obj2 = molslinjen_sharedKt$uniffiRustCallAsync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = molslinjen_sharedKt$uniffiRustCallAsync$1.label;
        if (i5 != 0) {
        }
    }

    private static final <U, E extends Exception> U uniffiRustCallWithError(UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler, Function1<? super UniffiRustCallStatus, ? extends U> function1) {
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        U invoke = function1.invoke(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiRustCallStatusErrorHandler, uniffiRustCallStatus);
        return invoke;
    }

    public static final <T> void uniffiTraitInterfaceCall(UniffiRustCallStatus callStatus, Function0<? extends T> makeCall, Function1<? super T, Unit> writeReturn) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        Intrinsics.checkNotNullParameter(makeCall, "makeCall");
        Intrinsics.checkNotNullParameter(writeReturn, "writeReturn");
        try {
            writeReturn.invoke(makeCall.invoke());
        } catch (Exception e5) {
            callStatus.code = (byte) 2;
            callStatus.error_buf = FfiConverterString.INSTANCE.lower2(e5.toString());
        }
    }

    public static final /* synthetic */ <T, E extends Throwable> void uniffiTraitInterfaceCallWithError(UniffiRustCallStatus callStatus, Function0<? extends T> makeCall, Function1<? super T, Unit> writeReturn, Function1<? super E, RustBuffer.ByValue> lowerError) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        Intrinsics.checkNotNullParameter(makeCall, "makeCall");
        Intrinsics.checkNotNullParameter(writeReturn, "writeReturn");
        Intrinsics.checkNotNullParameter(lowerError, "lowerError");
        try {
            writeReturn.invoke(makeCall.invoke());
        } catch (Exception e5) {
            Intrinsics.reifiedOperationMarker(3, "E");
            callStatus.code = (byte) 1;
            callStatus.error_buf = lowerError.invoke(e5);
        }
    }

    public static final <T extends Disposable, R> R use(T t5, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(t5);
        } finally {
            InlineMarker.finallyStart(1);
            if (t5 != null) {
                try {
                    t5.destroy();
                } catch (Throwable unused) {
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }
}
