package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    /* loaded from: classes.dex */
    private static class Api23Impl {
        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    /* loaded from: classes.dex */
    private static class Api29Impl {
        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j5) {
            return contentCaptureSession.newAutofillId(autofillId, j5);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j5) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j5);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    /* loaded from: classes.dex */
    private static class Api34Impl {
        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public AutofillId newAutofillId(long j5) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession a5 = a.a(this.mWrappedObj);
        AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        return Api29Impl.newAutofillId(a5, autofillId.toAutofillId(), j5);
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j5) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure(a.a(this.mWrappedObj), autofillId, j5));
        }
        return null;
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged(a.a(this.mWrappedObj), autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(List<ViewStructure> list) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            Api34Impl.notifyViewsAppeared(a.a(this.mWrappedObj), list);
            return;
        }
        if (i5 >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(a.a(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared(a.a(this.mWrappedObj), newViewStructure);
            for (int i6 = 0; i6 < list.size(); i6++) {
                Api29Impl.notifyViewAppeared(a.a(this.mWrappedObj), list.get(i6));
            }
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(a.a(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared(a.a(this.mWrappedObj), newViewStructure2);
        }
    }

    public void notifyViewsDisappeared(long[] jArr) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            ContentCaptureSession a5 = a.a(this.mWrappedObj);
            AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            Api29Impl.notifyViewsDisappeared(a5, autofillId.toAutofillId(), jArr);
            return;
        }
        if (i5 >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(a.a(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared(a.a(this.mWrappedObj), newViewStructure);
            ContentCaptureSession a6 = a.a(this.mWrappedObj);
            AutofillIdCompat autofillId2 = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId2);
            Api29Impl.notifyViewsDisappeared(a6, autofillId2.toAutofillId(), jArr);
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(a.a(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared(a.a(this.mWrappedObj), newViewStructure2);
        }
    }
}
