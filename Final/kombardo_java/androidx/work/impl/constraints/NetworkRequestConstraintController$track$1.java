package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/work/impl/constraints/ConstraintsState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", l = {182}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class NetworkRequestConstraintController$track$1 extends SuspendLambda implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, Continuation<? super NetworkRequestConstraintController$track$1> continuation) {
        super(2, continuation);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, continuation);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$networkCallback$1, android.net.ConnectivityManager$NetworkCallback] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Job launch$default;
        String str;
        ConnectivityManager connectivityManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest == null) {
                SendChannel.DefaultImpls.close$default(producerScope.getChannel(), null, 1, null);
                return Unit.INSTANCE;
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new NetworkRequestConstraintController$track$1$job$1(this.this$0, producerScope, null), 3, null);
            final ?? r42 = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$networkCallback$1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                    String str2;
                    Intrinsics.checkNotNullParameter(network, "network");
                    Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                    Job.DefaultImpls.cancel$default(Job.this, null, 1, null);
                    Logger logger = Logger.get();
                    str2 = WorkConstraintsTrackerKt.TAG;
                    logger.debug(str2, "NetworkRequestConstraintController onCapabilitiesChanged callback");
                    producerScope.mo3767trySendJP2dKIU(ConstraintsState.ConstraintsMet.INSTANCE);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    String str2;
                    Intrinsics.checkNotNullParameter(network, "network");
                    Job.DefaultImpls.cancel$default(Job.this, null, 1, null);
                    Logger logger = Logger.get();
                    str2 = WorkConstraintsTrackerKt.TAG;
                    logger.debug(str2, "NetworkRequestConstraintController onLost callback");
                    producerScope.mo3767trySendJP2dKIU(new ConstraintsState.ConstraintsNotMet(7));
                }
            };
            Logger logger = Logger.get();
            str = WorkConstraintsTrackerKt.TAG;
            logger.debug(str, "NetworkRequestConstraintController register callback");
            connectivityManager = this.this$0.connManager;
            connectivityManager.registerNetworkCallback(requiredNetworkRequest, (ConnectivityManager.NetworkCallback) r42);
            final NetworkRequestConstraintController networkRequestConstraintController = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str2;
                    ConnectivityManager connectivityManager2;
                    Logger logger2 = Logger.get();
                    str2 = WorkConstraintsTrackerKt.TAG;
                    logger2.debug(str2, "NetworkRequestConstraintController unregister callback");
                    connectivityManager2 = NetworkRequestConstraintController.this.connManager;
                    connectivityManager2.unregisterNetworkCallback(r42);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ConstraintsState> producerScope, Continuation<? super Unit> continuation) {
        return ((NetworkRequestConstraintController$track$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
