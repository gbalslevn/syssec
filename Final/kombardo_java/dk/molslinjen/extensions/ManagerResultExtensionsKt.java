package dk.molslinjen.extensions;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ManagerResultKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"handlePotentialError", "Ldk/molslinjen/domain/managers/ManagerResult;", "Value", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "(Ldk/molslinjen/domain/managers/ManagerResult;Ldk/molslinjen/core/snackbar/ISnackbarService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSnackbarText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "handleError", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/managers/ManagerResult$Error;Ldk/molslinjen/core/snackbar/ISnackbarService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ManagerResultExtensionsKt {
    public static final Object handleError(ManagerResult.Error error, ISnackbarService iSnackbarService, Continuation<? super Unit> continuation) {
        SnackbarText snackbarText = toSnackbarText(error);
        Object publishEvent = iSnackbarService.publishEvent(ManagerResultKt.isNetworkError(error) ? new SnackbarEvent.NetworkError(snackbarText) : new SnackbarEvent.Error(snackbarText), continuation);
        return publishEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? publishEvent : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <Value> Object handlePotentialError(ManagerResult<? extends Value> managerResult, ISnackbarService iSnackbarService, Continuation<? super ManagerResult<? extends Value>> continuation) {
        ManagerResultExtensionsKt$handlePotentialError$1 managerResultExtensionsKt$handlePotentialError$1;
        int i5;
        if (continuation instanceof ManagerResultExtensionsKt$handlePotentialError$1) {
            managerResultExtensionsKt$handlePotentialError$1 = (ManagerResultExtensionsKt$handlePotentialError$1) continuation;
            int i6 = managerResultExtensionsKt$handlePotentialError$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                managerResultExtensionsKt$handlePotentialError$1.label = i6 - Integer.MIN_VALUE;
                Object obj = managerResultExtensionsKt$handlePotentialError$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = managerResultExtensionsKt$handlePotentialError$1.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ManagerResult managerResult2 = (ManagerResult) managerResultExtensionsKt$handlePotentialError$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return managerResult2;
                }
                ResultKt.throwOnFailure(obj);
                ManagerResult.Error error = managerResult instanceof ManagerResult.Error ? (ManagerResult.Error) managerResult : null;
                if (error == null) {
                    return managerResult;
                }
                managerResultExtensionsKt$handlePotentialError$1.L$0 = managerResult;
                managerResultExtensionsKt$handlePotentialError$1.label = 1;
                return handleError(error, iSnackbarService, managerResultExtensionsKt$handlePotentialError$1) == coroutine_suspended ? coroutine_suspended : managerResult;
            }
        }
        managerResultExtensionsKt$handlePotentialError$1 = new ManagerResultExtensionsKt$handlePotentialError$1(continuation);
        Object obj2 = managerResultExtensionsKt$handlePotentialError$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = managerResultExtensionsKt$handlePotentialError$1.label;
        if (i5 == 0) {
        }
    }

    private static final SnackbarText toSnackbarText(ManagerResult.Error error) {
        ManagerResult.Error.ErrorString errorString;
        String message;
        String message2;
        if (!(error instanceof ManagerResult.Error.ErrorString) || (message = (errorString = (ManagerResult.Error.ErrorString) error).getMessage()) == null || StringsKt.contains$default((CharSequence) message, (CharSequence) "Unexpected JSON token", false, 2, (Object) null) || (message2 = errorString.getMessage()) == null) {
            return null;
        }
        return new SnackbarText.StringText(message2);
    }
}
