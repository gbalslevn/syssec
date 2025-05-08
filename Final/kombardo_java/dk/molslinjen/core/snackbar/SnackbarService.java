package dk.molslinjen.core.snackbar;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarService;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "publishGenericError", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishEvent", "event", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "(Ldk/molslinjen/core/snackbar/SnackbarEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SnackbarService implements ISnackbarService {
    private final MutableSharedFlow<SnackbarMessageEvent> _events;
    private final Context context;
    private final SharedFlow<SnackbarMessageEvent> events;

    public SnackbarService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        MutableSharedFlow<SnackbarMessageEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._events = MutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    @Override // dk.molslinjen.core.snackbar.ISnackbarService
    public SharedFlow<SnackbarMessageEvent> getEvents() {
        return this.events;
    }

    @Override // dk.molslinjen.core.snackbar.ISnackbarService
    public Object publishEvent(SnackbarEvent snackbarEvent, Continuation<? super Unit> continuation) {
        SnackbarText actionText;
        String string = snackbarEvent.getMessage().getString(this.context);
        SnackbarAction actionData = snackbarEvent.getActionData();
        String string2 = (actionData == null || (actionText = actionData.getActionText()) == null) ? null : actionText.getString(this.context);
        if (!(snackbarEvent instanceof SnackbarEvent.NetworkError)) {
            Logger.log$default(Logger.INSTANCE, string, null, 0, 6, null);
        }
        MutableSharedFlow<SnackbarMessageEvent> mutableSharedFlow = this._events;
        SnackbarDuration duration = snackbarEvent.getDuration();
        boolean showDismiss = snackbarEvent.getShowDismiss();
        SnackbarAction actionData2 = snackbarEvent.getActionData();
        Object emit = mutableSharedFlow.emit(new SnackbarMessageEvent(string, duration, showDismiss, snackbarEvent.getStyle(), string2, actionData2 != null ? actionData2.getAction() : null), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.core.snackbar.ISnackbarService
    public Object publishGenericError(Continuation<? super Unit> continuation) {
        Object publishEvent = publishEvent(new SnackbarEvent.Error(null, 1, null), continuation);
        return publishEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? publishEvent : Unit.INSTANCE;
    }
}
