package t;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i5, Layout.Alignment alignment, float f5, float f6, BoringLayout.Metrics metrics, boolean z5, TextUtils.TruncateAt truncateAt, int i6, boolean z6) {
        return new BoringLayout(charSequence, textPaint, i5, alignment, f5, f6, metrics, z5, truncateAt, i6, z6);
    }
}
