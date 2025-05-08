package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* loaded from: classes.dex */
public abstract class ViewCompatShims {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }
    }

    /* loaded from: classes.dex */
    private static class Api29Impl {
        static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* loaded from: classes.dex */
    private static class Api30Impl {
        static void setImportantForContentCapture(View view, int i5) {
            view.setImportantForContentCapture(i5);
        }
    }

    public static AutofillIdCompat getAutofillId(View view) {
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(view));
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View view) {
        ContentCaptureSession contentCaptureSession;
        if (Build.VERSION.SDK_INT < 29 || (contentCaptureSession = Api29Impl.getContentCaptureSession(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public static void setImportantForContentCapture(View view, int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setImportantForContentCapture(view, i5);
        }
    }
}
