package dk.molslinjen.core.snackbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarAction;", BuildConfig.FLAVOR, "actionText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;Lkotlin/jvm/functions/Function1;)V", "getActionText", "()Ldk/molslinjen/core/snackbar/SnackbarText;", "getAction", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SnackbarAction {
    private final Function1<Continuation<? super Unit>, Object> action;
    private final SnackbarText actionText;

    /* JADX WARN: Multi-variable type inference failed */
    public SnackbarAction(SnackbarText actionText, Function1<? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(action, "action");
        this.actionText = actionText;
        this.action = action;
    }

    public final Function1<Continuation<? super Unit>, Object> getAction() {
        return this.action;
    }

    public final SnackbarText getActionText() {
        return this.actionText;
    }
}
