package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import androidx.appcompat.R$styleable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {R$styleable.AppCompatTheme_windowActionBar, 123}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Channel<Unit> $channel;
    final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
        this.$channel = channel;
        this.$applicationContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:9:0x0048, B:14:0x0058, B:16:0x0060, B:25:0x002d, B:27:0x0042), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007f -> B:8:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        ChannelIterator<Unit> it;
        FlowCollector flowCollector2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                this.$resolver.registerContentObserver(this.$animationScaleUri, false, this.$contentObserver);
                it = this.$channel.iterator();
                this.L$0 = flowCollector;
                this.L$1 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            } else if (i5 == 1) {
                it = (ChannelIterator) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                this.L$0 = flowCollector;
                this.L$1 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector2 = flowCollector;
                obj = hasNext;
                if (((Boolean) obj).booleanValue()) {
                    this.$resolver.unregisterContentObserver(this.$contentObserver);
                    return Unit.INSTANCE;
                }
                it.next();
                Float boxFloat = Boxing.boxFloat(Settings.Global.getFloat(this.$applicationContext.getContentResolver(), "animator_duration_scale", 1.0f));
                this.L$0 = flowCollector2;
                this.L$1 = it;
                this.label = 2;
                if (flowCollector2.emit(boxFloat, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
                this.L$0 = flowCollector;
                this.L$1 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            }
        } catch (Throwable th) {
            this.$resolver.unregisterContentObserver(this.$contentObserver);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
