package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import h.AbstractC0422h;
import h.AbstractC0423i;
import h.AbstractC0424j;
import h.AbstractC0426l;
import h.AbstractC0427m;
import h.AbstractC0428n;
import h.AbstractC0429o;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", BuildConfig.FLAVOR, "()V", "setHandwritingGestures", BuildConfig.FLAVOR, "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class EditorInfoApi34 {
    public static final EditorInfoApi34 INSTANCE = new EditorInfoApi34();

    private EditorInfoApi34() {
    }

    public final void setHandwritingGestures(EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(CollectionsKt.listOf((Object[]) new Class[]{AbstractC0422h.a(), AbstractC0426l.a(), AbstractC0423i.a(), AbstractC0424j.a(), AbstractC0427m.a(), AbstractC0428n.a(), AbstractC0429o.a()}));
        editorInfo.setSupportedHandwritingGesturePreviews(SetsKt.setOf((Object[]) new Class[]{AbstractC0422h.a(), AbstractC0426l.a(), AbstractC0423i.a(), AbstractC0424j.a()}));
    }
}
