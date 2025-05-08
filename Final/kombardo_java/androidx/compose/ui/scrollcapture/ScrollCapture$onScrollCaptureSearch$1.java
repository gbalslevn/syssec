package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class ScrollCapture$onScrollCaptureSearch$1 extends AdaptedFunctionReference implements Function1<ScrollCaptureCandidate, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollCapture$onScrollCaptureSearch$1(Object obj) {
        super(1, obj, MutableVector.class, "add", "add(Ljava/lang/Object;)Z", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
        invoke2(scrollCaptureCandidate);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ScrollCaptureCandidate scrollCaptureCandidate) {
        ((MutableVector) this.receiver).add(scrollCaptureCandidate);
    }
}
