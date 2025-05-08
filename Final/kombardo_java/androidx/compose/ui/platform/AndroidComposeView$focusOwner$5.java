package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class AndroidComposeView$focusOwner$5 extends FunctionReferenceImpl implements Function0<Rect> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$focusOwner$5(Object obj) {
        super(0, obj, AndroidComposeView.class, "onFetchFocusRect", "onFetchFocusRect()Landroidx/compose/ui/geometry/Rect;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Rect invoke() {
        Rect onFetchFocusRect;
        onFetchFocusRect = ((AndroidComposeView) this.receiver).onFetchFocusRect();
        return onFetchFocusRect;
    }
}
