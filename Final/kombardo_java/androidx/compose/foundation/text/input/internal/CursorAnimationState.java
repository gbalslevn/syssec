package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR+\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "snapToVisibleAndAnimate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", BuildConfig.FLAVOR, "<set-?>", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnimationState {
    private AtomicReference<Job> animationJob = new AtomicReference<>(null);

    /* renamed from: cursorAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState cursorAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCursorAlpha(float f5) {
        this.cursorAlpha.setFloatValue(f5);
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha.getFloatValue();
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CursorAnimationState$snapToVisibleAndAnimate$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
