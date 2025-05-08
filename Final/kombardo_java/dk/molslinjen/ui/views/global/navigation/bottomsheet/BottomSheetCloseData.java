package dk.molslinjen.ui.views.global.navigation.bottomsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "promptForClose", BuildConfig.FLAVOR, "dialogText", "dialogButtonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "customDismiss", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseData;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPromptForClose", "()Z", "Ljava/lang/String;", "getDialogText", "getDialogButtonText", "Lkotlin/jvm/functions/Function0;", "getCustomDismiss", "()Lkotlin/jvm/functions/Function0;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BottomSheetCloseData {
    private final Function0<Unit> customDismiss;
    private final String dialogButtonText;
    private final String dialogText;
    private final boolean promptForClose;

    public BottomSheetCloseData(boolean z5, String dialogText, String dialogButtonText, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(dialogText, "dialogText");
        Intrinsics.checkNotNullParameter(dialogButtonText, "dialogButtonText");
        this.promptForClose = z5;
        this.dialogText = dialogText;
        this.dialogButtonText = dialogButtonText;
        this.customDismiss = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BottomSheetCloseData copy$default(BottomSheetCloseData bottomSheetCloseData, boolean z5, String str, String str2, Function0 function0, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = bottomSheetCloseData.promptForClose;
        }
        if ((i5 & 2) != 0) {
            str = bottomSheetCloseData.dialogText;
        }
        if ((i5 & 4) != 0) {
            str2 = bottomSheetCloseData.dialogButtonText;
        }
        if ((i5 & 8) != 0) {
            function0 = bottomSheetCloseData.customDismiss;
        }
        return bottomSheetCloseData.copy(z5, str, str2, function0);
    }

    public final BottomSheetCloseData copy(boolean promptForClose, String dialogText, String dialogButtonText, Function0<Unit> customDismiss) {
        Intrinsics.checkNotNullParameter(dialogText, "dialogText");
        Intrinsics.checkNotNullParameter(dialogButtonText, "dialogButtonText");
        return new BottomSheetCloseData(promptForClose, dialogText, dialogButtonText, customDismiss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomSheetCloseData)) {
            return false;
        }
        BottomSheetCloseData bottomSheetCloseData = (BottomSheetCloseData) other;
        return this.promptForClose == bottomSheetCloseData.promptForClose && Intrinsics.areEqual(this.dialogText, bottomSheetCloseData.dialogText) && Intrinsics.areEqual(this.dialogButtonText, bottomSheetCloseData.dialogButtonText) && Intrinsics.areEqual(this.customDismiss, bottomSheetCloseData.customDismiss);
    }

    public final Function0<Unit> getCustomDismiss() {
        return this.customDismiss;
    }

    public final String getDialogButtonText() {
        return this.dialogButtonText;
    }

    public final String getDialogText() {
        return this.dialogText;
    }

    public final boolean getPromptForClose() {
        return this.promptForClose;
    }

    public int hashCode() {
        int hashCode = ((((Boolean.hashCode(this.promptForClose) * 31) + this.dialogText.hashCode()) * 31) + this.dialogButtonText.hashCode()) * 31;
        Function0<Unit> function0 = this.customDismiss;
        return hashCode + (function0 == null ? 0 : function0.hashCode());
    }

    public String toString() {
        return "BottomSheetCloseData(promptForClose=" + this.promptForClose + ", dialogText=" + this.dialogText + ", dialogButtonText=" + this.dialogButtonText + ", customDismiss=" + this.customDismiss + ")";
    }
}
