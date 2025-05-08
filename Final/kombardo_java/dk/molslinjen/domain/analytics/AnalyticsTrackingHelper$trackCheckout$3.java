package dk.molslinjen.domain.analytics;

import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.analytics.AnalyticsTrackingHelper$trackCheckout$3", f = "AnalyticsTrackingHelper.kt", l = {336}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AnalyticsTrackingHelper$trackCheckout$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<PriceTotal> $priceTotal;
    final /* synthetic */ int $priceTotalIncludingAddons;
    int label;
    final /* synthetic */ AnalyticsTrackingHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTrackingHelper$trackCheckout$3(AnalyticsTrackingHelper analyticsTrackingHelper, int i5, Ref$ObjectRef<PriceTotal> ref$ObjectRef, Continuation<? super AnalyticsTrackingHelper$trackCheckout$3> continuation) {
        super(2, continuation);
        this.this$0 = analyticsTrackingHelper;
        this.$priceTotalIncludingAddons = i5;
        this.$priceTotal = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsTrackingHelper$trackCheckout$3(this.this$0, this.$priceTotalIncludingAddons, this.$priceTotal, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IAdjustTracker iAdjustTracker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iAdjustTracker = this.this$0.adjustTracker;
            int i6 = this.$priceTotalIncludingAddons;
            String analyticsCurrency = AnalyticsExtensionsKt.toAnalyticsCurrency(this.$priceTotal.element);
            this.label = 1;
            if (iAdjustTracker.purchase(i6, analyticsCurrency, this) == coroutine_suspended) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsTrackingHelper$trackCheckout$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
