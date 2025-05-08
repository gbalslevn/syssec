package dk.molslinjen.ui.views.screens.config.regular.checkout.helpers;

import androidx.compose.runtime.MutableState;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1", f = "CheckoutExpirationDialogHandler.kt", l = {34}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExpirableCheckout $expirableDepartures;
    final /* synthetic */ MutableState<Boolean> $showExpirationDialog;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1(MutableState<Boolean> mutableState, IExpirableCheckout iExpirableCheckout, Continuation<? super CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1> continuation) {
        super(2, continuation);
        this.$showExpirationDialog = mutableState;
        this.$expirableDepartures = iExpirableCheckout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1 checkoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1 = new CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1(this.$showExpirationDialog, this.$expirableDepartures, continuation);
        checkoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1.L$0 = obj;
        return checkoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003d -> B:5:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.$showExpirationDialog.setValue(Boxing.boxBoolean(this.$expirableDepartures.isExpired()));
            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                Duration.Companion companion = Duration.INSTANCE;
                long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.m3760delayVtjQ1oo(duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.$showExpirationDialog.setValue(Boxing.boxBoolean(this.$expirableDepartures.isExpired()));
                if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
