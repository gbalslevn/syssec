package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", f = "Clickable.kt", l = {1139, 1141, 1148, 1149, 1158}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope pressGestureScope, long j5, MutableInteractionSource mutableInteractionSource, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$offset = j5;
        this.$interactionSource = mutableInteractionSource;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, continuation);
        abstractClickableNode$handlePressInteraction$2$1.L$0 = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        Object tryAwaitRelease;
        PressInteraction.Press press;
        boolean z5;
        PressInteraction.Release release;
        MutableInteractionSource mutableInteractionSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
            PressGestureScope pressGestureScope = this.$this_handlePressInteraction;
            this.L$0 = launch$default;
            this.label = 1;
            tryAwaitRelease = pressGestureScope.tryAwaitRelease(this);
            if (tryAwaitRelease == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4 && i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.pressInteraction = null;
                        return Unit.INSTANCE;
                    }
                    release = (PressInteraction.Release) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableInteractionSource = this.$interactionSource;
                    this.L$0 = null;
                    this.label = 4;
                    if (mutableInteractionSource.emit(release, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.pressInteraction = null;
                    return Unit.INSTANCE;
                }
                z5 = this.Z$0;
                ResultKt.throwOnFailure(obj);
                if (z5) {
                    PressInteraction.Press press2 = new PressInteraction.Press(this.$offset, null);
                    PressInteraction.Release release2 = new PressInteraction.Release(press2);
                    MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                    this.L$0 = release2;
                    this.label = 3;
                    if (mutableInteractionSource2.emit(press2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    release = release2;
                    mutableInteractionSource = this.$interactionSource;
                    this.L$0 = null;
                    this.label = 4;
                    if (mutableInteractionSource.emit(release, this) == coroutine_suspended) {
                    }
                }
                this.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            }
            launch$default = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            tryAwaitRelease = obj;
        }
        boolean booleanValue = ((Boolean) tryAwaitRelease).booleanValue();
        if (launch$default.isActive()) {
            this.L$0 = null;
            this.Z$0 = booleanValue;
            this.label = 2;
            if (JobKt.cancelAndJoin(launch$default, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            z5 = booleanValue;
            if (z5) {
            }
            this.this$0.pressInteraction = null;
            return Unit.INSTANCE;
        }
        press = this.this$0.pressInteraction;
        if (press != null) {
            MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
            Interaction release3 = booleanValue ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press);
            this.L$0 = null;
            this.label = 5;
            if (mutableInteractionSource3.emit(release3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.pressInteraction = null;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
