package dk.molslinjen.core.snackbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/core/snackbar/ISnackbarService;", BuildConfig.FLAVOR, "events", "Lkotlinx/coroutines/flow/SharedFlow;", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "publishGenericError", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishEvent", "event", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "(Ldk/molslinjen/core/snackbar/SnackbarEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISnackbarService {
    SharedFlow<SnackbarMessageEvent> getEvents();

    Object publishEvent(SnackbarEvent snackbarEvent, Continuation<? super Unit> continuation);

    Object publishGenericError(Continuation<? super Unit> continuation);
}
