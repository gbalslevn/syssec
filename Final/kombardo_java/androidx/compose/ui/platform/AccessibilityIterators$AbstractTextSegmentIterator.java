package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0004¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u00020\u00048\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"androidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "<init>", "()V", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "initialize", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "start", "end", BuildConfig.FLAVOR, "getRange", "(II)[I", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "segment", "[I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AccessibilityIterators$AbstractTextSegmentIterator implements AccessibilityIterators$TextSegmentIterator {
    private final int[] segment = new int[2];
    protected String text;

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getRange(int start, int end) {
        if (start < 0 || end < 0 || start == end) {
            return null;
        }
        int[] iArr = this.segment;
        iArr[0] = start;
        iArr[1] = end;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("text");
        return null;
    }

    public void initialize(String text) {
        setText(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setText(String str) {
        this.text = str;
    }
}
