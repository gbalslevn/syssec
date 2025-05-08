package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CallbackWrapper {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Executor mExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWrapper(FontsContractCompat.FontRequestCallback fontRequestCallback, Executor executor) {
        this.mCallback = fontRequestCallback;
        this.mExecutor = executor;
    }

    private void onTypefaceRequestFailed(final int i5) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i5);
            }
        });
    }

    private void onTypefaceRetrieved(final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
