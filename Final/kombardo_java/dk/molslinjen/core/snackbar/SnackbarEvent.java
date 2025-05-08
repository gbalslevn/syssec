package dk.molslinjen.core.snackbar;

import androidx.compose.material3.SnackbarDuration;
import dk.molslinjen.core.snackbar.SnackbarStyle;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0018\u0019\u001a\u001b\u001c\u001dB9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0006\u001e\u001f !\"#¨\u0006$"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent;", BuildConfig.FLAVOR, "message", "Ldk/molslinjen/core/snackbar/SnackbarText;", "style", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "duration", "Landroidx/compose/material3/SnackbarDuration;", "actionData", "Ldk/molslinjen/core/snackbar/SnackbarAction;", "showDismiss", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;Ldk/molslinjen/core/snackbar/SnackbarStyle;Landroidx/compose/material3/SnackbarDuration;Ldk/molslinjen/core/snackbar/SnackbarAction;Z)V", "getMessage", "()Ldk/molslinjen/core/snackbar/SnackbarText;", "getStyle", "()Ldk/molslinjen/core/snackbar/SnackbarStyle;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getActionData", "()Ldk/molslinjen/core/snackbar/SnackbarAction;", "getShowDismiss", "()Z", "Default", "Information", "CompleteUpdate", "UpdateDownloadInProgress", "NetworkError", "Error", "Ldk/molslinjen/core/snackbar/SnackbarEvent$CompleteUpdate;", "Ldk/molslinjen/core/snackbar/SnackbarEvent$Default;", "Ldk/molslinjen/core/snackbar/SnackbarEvent$Error;", "Ldk/molslinjen/core/snackbar/SnackbarEvent$Information;", "Ldk/molslinjen/core/snackbar/SnackbarEvent$NetworkError;", "Ldk/molslinjen/core/snackbar/SnackbarEvent$UpdateDownloadInProgress;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SnackbarEvent {
    private final SnackbarAction actionData;
    private final SnackbarDuration duration;
    private final SnackbarText message;
    private final boolean showDismiss;
    private final SnackbarStyle style;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$CompleteUpdate;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "Ldk/molslinjen/core/snackbar/SnackbarAction;", "actionData", "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarAction;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/core/snackbar/SnackbarAction;", "getActionData", "()Ldk/molslinjen/core/snackbar/SnackbarAction;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CompleteUpdate extends SnackbarEvent {
        private final SnackbarAction actionData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompleteUpdate(SnackbarAction actionData) {
            super(new SnackbarText.ResourceText(R.string.forceUpdate_updateDownloaded), new SnackbarStyle.Default(null, 1, null), SnackbarDuration.Indefinite, null, false, 24, null);
            Intrinsics.checkNotNullParameter(actionData, "actionData");
            this.actionData = actionData;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CompleteUpdate) && Intrinsics.areEqual(this.actionData, ((CompleteUpdate) other).actionData);
        }

        @Override // dk.molslinjen.core.snackbar.SnackbarEvent
        public SnackbarAction getActionData() {
            return this.actionData;
        }

        public int hashCode() {
            return this.actionData.hashCode();
        }

        public String toString() {
            return "CompleteUpdate(actionData=" + this.actionData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$Default;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "messageText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "actionData", "Ldk/molslinjen/core/snackbar/SnackbarAction;", "showDismiss", BuildConfig.FLAVOR, "duration", "Landroidx/compose/material3/SnackbarDuration;", "leftIcon", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;Ldk/molslinjen/core/snackbar/SnackbarAction;ZLandroidx/compose/material3/SnackbarDuration;Ljava/lang/Integer;)V", "getActionData", "()Ldk/molslinjen/core/snackbar/SnackbarAction;", "getShowDismiss", "()Z", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "Ljava/lang/Integer;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Default extends SnackbarEvent {
        private final SnackbarAction actionData;
        private final SnackbarDuration duration;
        private final Integer leftIcon;
        private final boolean showDismiss;

        public /* synthetic */ Default(SnackbarText snackbarText, SnackbarAction snackbarAction, boolean z5, SnackbarDuration snackbarDuration, Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(snackbarText, (i5 & 2) != 0 ? null : snackbarAction, (i5 & 4) != 0 ? true : z5, snackbarDuration, (i5 & 16) != 0 ? null : num);
        }

        @Override // dk.molslinjen.core.snackbar.SnackbarEvent
        public SnackbarAction getActionData() {
            return this.actionData;
        }

        @Override // dk.molslinjen.core.snackbar.SnackbarEvent
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // dk.molslinjen.core.snackbar.SnackbarEvent
        public boolean getShowDismiss() {
            return this.showDismiss;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Default(SnackbarText messageText, SnackbarAction snackbarAction, boolean z5, SnackbarDuration duration, Integer num) {
            super(messageText, new SnackbarStyle.Default(num), null, null, false, 28, null);
            Intrinsics.checkNotNullParameter(messageText, "messageText");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.actionData = snackbarAction;
            this.showDismiss = z5;
            this.duration = duration;
            this.leftIcon = num;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$Error;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "messageText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Error extends SnackbarEvent {
        public /* synthetic */ Error(SnackbarText snackbarText, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : snackbarText);
        }

        public Error(SnackbarText snackbarText) {
            super(snackbarText == null ? new SnackbarText.ResourceText(R.string.error_general) : snackbarText, SnackbarStyle.Error.INSTANCE, null, null, false, 28, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$Information;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "messageText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "actionData", "Ldk/molslinjen/core/snackbar/SnackbarAction;", "autoDismiss", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;Ldk/molslinjen/core/snackbar/SnackbarAction;Z)V", "getActionData", "()Ldk/molslinjen/core/snackbar/SnackbarAction;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Information extends SnackbarEvent {
        private final SnackbarAction actionData;

        public /* synthetic */ Information(SnackbarText snackbarText, SnackbarAction snackbarAction, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(snackbarText, (i5 & 2) != 0 ? null : snackbarAction, (i5 & 4) != 0 ? true : z5);
        }

        @Override // dk.molslinjen.core.snackbar.SnackbarEvent
        public SnackbarAction getActionData() {
            return this.actionData;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Information(SnackbarText messageText, SnackbarAction snackbarAction, boolean z5) {
            super(messageText, SnackbarStyle.Information.INSTANCE, z5 ? SnackbarDuration.Short : SnackbarDuration.Indefinite, null, false, 24, null);
            Intrinsics.checkNotNullParameter(messageText, "messageText");
            this.actionData = snackbarAction;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$NetworkError;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "messageText", "Ldk/molslinjen/core/snackbar/SnackbarText;", "<init>", "(Ldk/molslinjen/core/snackbar/SnackbarText;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NetworkError extends SnackbarEvent {
        public NetworkError(SnackbarText snackbarText) {
            super(snackbarText == null ? new SnackbarText.ResourceText(R.string.error_noNetwork) : snackbarText, SnackbarStyle.Error.INSTANCE, null, null, false, 28, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarEvent$UpdateDownloadInProgress;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class UpdateDownloadInProgress extends SnackbarEvent {
        public static final UpdateDownloadInProgress INSTANCE = new UpdateDownloadInProgress();

        private UpdateDownloadInProgress() {
            super(new SnackbarText.ResourceText(R.string.forceUpdate_downloadInProgress), new SnackbarStyle.Default(null, 1, null), null, null, false, 28, null);
        }
    }

    public /* synthetic */ SnackbarEvent(SnackbarText snackbarText, SnackbarStyle snackbarStyle, SnackbarDuration snackbarDuration, SnackbarAction snackbarAction, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(snackbarText, snackbarStyle, snackbarDuration, snackbarAction, z5);
    }

    public SnackbarAction getActionData() {
        return this.actionData;
    }

    public SnackbarDuration getDuration() {
        return this.duration;
    }

    public final SnackbarText getMessage() {
        return this.message;
    }

    public boolean getShowDismiss() {
        return this.showDismiss;
    }

    public final SnackbarStyle getStyle() {
        return this.style;
    }

    private SnackbarEvent(SnackbarText snackbarText, SnackbarStyle snackbarStyle, SnackbarDuration snackbarDuration, SnackbarAction snackbarAction, boolean z5) {
        this.message = snackbarText;
        this.style = snackbarStyle;
        this.duration = snackbarDuration;
        this.actionData = snackbarAction;
        this.showDismiss = z5;
    }

    public /* synthetic */ SnackbarEvent(SnackbarText snackbarText, SnackbarStyle snackbarStyle, SnackbarDuration snackbarDuration, SnackbarAction snackbarAction, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(snackbarText, snackbarStyle, (i5 & 4) != 0 ? SnackbarDuration.Short : snackbarDuration, (i5 & 8) != 0 ? null : snackbarAction, (i5 & 16) != 0 ? true : z5, null);
    }
}
