package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", f = "PlatformTextInputModifierNode.kt", l = {194, 196}, m = "interceptedTextInputSession")
/* loaded from: classes.dex */
public final class PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformTextInputModifierNodeKt$interceptedTextInputSession$1(Continuation<? super PlatformTextInputModifierNodeKt$interceptedTextInputSession$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object interceptedTextInputSession;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        interceptedTextInputSession = PlatformTextInputModifierNodeKt.interceptedTextInputSession(null, null, null, this);
        return interceptedTextInputSession;
    }
}
