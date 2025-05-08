package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class MotionEventCompat {
    public static boolean isFromSource(MotionEvent motionEvent, int i5) {
        return (motionEvent.getSource() & i5) == i5;
    }
}
