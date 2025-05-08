package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {
    private WeakReference<Object> mMediaControllerImpl;

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i5, Bundle bundle) {
        a.a(this.mMediaControllerImpl.get());
    }
}
