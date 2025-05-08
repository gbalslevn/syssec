package androidx.compose.ui.text.android;

import android.text.Layout;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"getLineForOffset", BuildConfig.FLAVOR, "Landroid/text/Layout;", "offset", "upstream", BuildConfig.FLAVOR, "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LayoutCompat_androidKt {
    public static final int getLineForOffset(Layout layout, int i5, boolean z5) {
        if (i5 <= 0) {
            return 0;
        }
        if (i5 >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i5);
        int lineStart = layout.getLineStart(lineForOffset);
        return (lineStart == i5 || layout.getLineEnd(lineForOffset) == i5) ? lineStart == i5 ? z5 ? lineForOffset - 1 : lineForOffset : z5 ? lineForOffset : lineForOffset + 1 : lineForOffset;
    }
}
