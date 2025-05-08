package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes2.dex */
abstract class ObjectsPool {
    private static final Rect RECT = new Rect();
    private static final RectF RECT_F = new RectF();
    private static final Paint PAINT = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Paint paint() {
        return PAINT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect rect() {
        return RECT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF rectF() {
        return RECT_F;
    }
}
