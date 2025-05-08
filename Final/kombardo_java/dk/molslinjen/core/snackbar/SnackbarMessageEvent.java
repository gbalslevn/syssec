package dk.molslinjen.core.snackbar;

import androidx.compose.material3.SnackbarDuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012 \b\u0002\u0010\u000e\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b$\u0010\u0012R/\u0010\u000e\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "message", "Landroidx/compose/material3/SnackbarDuration;", "duration", BuildConfig.FLAVOR, "showDismiss", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "style", "actionLabel", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "action", "<init>", "(Ljava/lang/String;Landroidx/compose/material3/SnackbarDuration;ZLdk/molslinjen/core/snackbar/SnackbarStyle;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "Landroidx/compose/material3/SnackbarDuration;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "Z", "getShowDismiss", "()Z", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "getStyle", "()Ldk/molslinjen/core/snackbar/SnackbarStyle;", "getActionLabel", "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SnackbarMessageEvent {
    private final Function1<Continuation<? super Unit>, Object> action;
    private final String actionLabel;
    private final SnackbarDuration duration;
    private final String message;
    private final boolean showDismiss;
    private final SnackbarStyle style;

    /* JADX WARN: Multi-variable type inference failed */
    public SnackbarMessageEvent(String message, SnackbarDuration duration, boolean z5, SnackbarStyle style, String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(style, "style");
        this.message = message;
        this.duration = duration;
        this.showDismiss = z5;
        this.style = style;
        this.actionLabel = str;
        this.action = function1;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnackbarMessageEvent)) {
            return false;
        }
        SnackbarMessageEvent snackbarMessageEvent = (SnackbarMessageEvent) other;
        return Intrinsics.areEqual(this.message, snackbarMessageEvent.message) && this.duration == snackbarMessageEvent.duration && this.showDismiss == snackbarMessageEvent.showDismiss && Intrinsics.areEqual(this.style, snackbarMessageEvent.style) && Intrinsics.areEqual(this.actionLabel, snackbarMessageEvent.actionLabel) && Intrinsics.areEqual(this.action, snackbarMessageEvent.action);
    }

    public final Function1<Continuation<? super Unit>, Object> getAction() {
        return this.action;
    }

    public final String getActionLabel() {
        return this.actionLabel;
    }

    public final SnackbarDuration getDuration() {
        return this.duration;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getShowDismiss() {
        return this.showDismiss;
    }

    public final SnackbarStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        int hashCode = ((((((this.message.hashCode() * 31) + this.duration.hashCode()) * 31) + Boolean.hashCode(this.showDismiss)) * 31) + this.style.hashCode()) * 31;
        String str = this.actionLabel;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Function1<Continuation<? super Unit>, Object> function1 = this.action;
        return hashCode2 + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "SnackbarMessageEvent(message=" + this.message + ", duration=" + this.duration + ", showDismiss=" + this.showDismiss + ", style=" + this.style + ", actionLabel=" + this.actionLabel + ", action=" + this.action + ")";
    }
}
