package androidx.compose.ui.text.android;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/android/HorizontalPositionCache;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/android/TextLayout;", "layout", "<init>", "(Landroidx/compose/ui/text/android/TextLayout;)V", BuildConfig.FLAVOR, "offset", BuildConfig.FLAVOR, "upstream", "cache", "primary", BuildConfig.FLAVOR, "get", "(IZZZ)F", "getPrimaryDownstream", "(I)F", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", "Landroidx/compose/ui/text/android/TextLayout;", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "cachedKey", "I", "cachedValue", "F", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class HorizontalPositionCache {
    private int cachedKey = -1;
    private float cachedValue;
    private final TextLayout layout;

    public HorizontalPositionCache(TextLayout textLayout) {
        this.layout = textLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float get(int offset, boolean upstream, boolean cache, boolean primary) {
        boolean z5;
        int i5;
        int i6 = 1;
        if (upstream) {
            int lineForOffset = LayoutCompat_androidKt.getLineForOffset(this.layout.getLayout(), offset, upstream);
            int lineStart = this.layout.getLineStart(lineForOffset);
            int lineEnd = this.layout.getLineEnd(lineForOffset);
            if (offset == lineStart || offset == lineEnd) {
                z5 = true;
                int i7 = offset * 4;
                if (primary) {
                    i6 = z5 ? 2 : 3;
                } else if (z5) {
                    i6 = 0;
                }
                i5 = i7 + i6;
                if (this.cachedKey != i5) {
                    return this.cachedValue;
                }
                float primaryHorizontal = primary ? this.layout.getPrimaryHorizontal(offset, upstream) : this.layout.getSecondaryHorizontal(offset, upstream);
                if (cache) {
                    this.cachedKey = i5;
                    this.cachedValue = primaryHorizontal;
                }
                return primaryHorizontal;
            }
        }
        z5 = false;
        int i72 = offset * 4;
        if (primary) {
        }
        i5 = i72 + i6;
        if (this.cachedKey != i5) {
        }
    }

    public final float getPrimaryDownstream(int offset) {
        return get(offset, false, false, true);
    }

    public final float getPrimaryUpstream(int offset) {
        return get(offset, true, true, true);
    }

    public final float getSecondaryDownstream(int offset) {
        return get(offset, false, false, false);
    }

    public final float getSecondaryUpstream(int offset) {
        return get(offset, true, true, false);
    }
}
