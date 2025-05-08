package dk.molslinjen.api.services.newsletters;

import androidx.appcompat.R$styleable;
import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.request.NewsletterUpdateSubscriptionRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.newsletters.NewslettersService$updateSubscription$2", f = "NewslettersService.kt", l = {R$styleable.Toolbar_titleMarginEnd}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class NewslettersService$updateSubscription$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends Unit>>, Object> {
    final /* synthetic */ Boolean $allowMarketingPromotions;
    final /* synthetic */ Boolean $allowNewsletter;
    final /* synthetic */ String $email;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ NewslettersService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewslettersService$updateSubscription$2(NewslettersService newslettersService, SiteDTO siteDTO, String str, Boolean bool, Boolean bool2, Continuation<? super NewslettersService$updateSubscription$2> continuation) {
        super(2, continuation);
        this.this$0 = newslettersService;
        this.$site = siteDTO;
        this.$email = str;
        this.$allowNewsletter = bool;
        this.$allowMarketingPromotions = bool2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewslettersService$updateSubscription$2(this.this$0, this.$site, this.$email, this.$allowNewsletter, this.$allowMarketingPromotions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NewslettersApi newslettersApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            newslettersApi = this.this$0.api;
            SiteDTO siteDTO = this.$site;
            NewsletterUpdateSubscriptionRequest newsletterUpdateSubscriptionRequest = new NewsletterUpdateSubscriptionRequest(this.$email, this.$allowNewsletter, this.$allowMarketingPromotions, (String) null, 8, (DefaultConstructorMarker) null);
            this.label = 1;
            obj = newslettersApi.updateSubscription(siteDTO, newsletterUpdateSubscriptionRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ResponseExtensionsKt.response((Response) obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<Unit>> continuation) {
        return ((NewslettersService$updateSubscription$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
