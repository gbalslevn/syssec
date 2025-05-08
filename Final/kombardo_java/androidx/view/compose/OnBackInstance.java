package androidx.view.compose;

import androidx.view.BackEventCompat;
import androidx.view.OnBackPressedCallback;
import com.sun.jna.Callback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012(\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0010\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/activity/compose/OnBackInstance;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;", "scope", BuildConfig.FLAVOR, "isPredictiveBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "onBack", "Landroidx/activity/OnBackPressedCallback;", Callback.METHOD_NAME, "<init>", "(Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/activity/OnBackPressedCallback;)V", "backEvent", "Lkotlinx/coroutines/channels/ChannelResult;", "send-JP2dKIU", "(Landroidx/activity/BackEventCompat;)Ljava/lang/Object;", "send", "close", "()Z", "cancel", "()V", "Z", "setPredictiveBack", "(Z)V", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class OnBackInstance {
    private final Channel<BackEventCompat> channel = ChannelKt.Channel$default(-2, BufferOverflow.SUSPEND, null, 4, null);
    private boolean isPredictiveBack;
    private final Job job;

    public OnBackInstance(CoroutineScope coroutineScope, boolean z5, Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2, OnBackPressedCallback onBackPressedCallback) {
        Job launch$default;
        this.isPredictiveBack = z5;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnBackInstance$job$1(onBackPressedCallback, function2, this, null), 3, null);
        this.job = launch$default;
    }

    public final void cancel() {
        this.channel.cancel(new CancellationException("onBack cancelled"));
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
    }

    public final boolean close() {
        return SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    public final Channel<BackEventCompat> getChannel() {
        return this.channel;
    }

    /* renamed from: isPredictiveBack, reason: from getter */
    public final boolean getIsPredictiveBack() {
        return this.isPredictiveBack;
    }

    /* renamed from: send-JP2dKIU, reason: not valid java name */
    public final Object m3sendJP2dKIU(BackEventCompat backEvent) {
        return this.channel.mo3767trySendJP2dKIU(backEvent);
    }

    public final void setPredictiveBack(boolean z5) {
        this.isPredictiveBack = z5;
    }
}
