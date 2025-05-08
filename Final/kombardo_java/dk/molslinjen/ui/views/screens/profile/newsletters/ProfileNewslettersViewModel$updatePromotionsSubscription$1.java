package dk.molslinjen.ui.views.screens.profile.newsletters;

import androidx.appcompat.R$styleable;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.newsletters.INewslettersManager;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$updatePromotionsSubscription$1", f = "ProfileNewslettersViewModel.kt", l = {104, R$styleable.AppCompatTheme_windowActionBar}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileNewslettersViewModel$updatePromotionsSubscription$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SiteInfo $siteInfo;
    final /* synthetic */ boolean $subscribe;
    int label;
    final /* synthetic */ ProfileNewslettersViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileNewslettersViewModel$updatePromotionsSubscription$1(ProfileNewslettersViewModel profileNewslettersViewModel, SiteInfo siteInfo, boolean z5, Continuation<? super ProfileNewslettersViewModel$updatePromotionsSubscription$1> continuation) {
        super(2, continuation);
        this.this$0 = profileNewslettersViewModel;
        this.$siteInfo = siteInfo;
        this.$subscribe = z5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileNewslettersViewModel$updatePromotionsSubscription$1(this.this$0, this.$siteInfo, this.$subscribe, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object showSnackbar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.this$0.userEmail;
            if (str == null) {
                return Unit.INSTANCE;
            }
            INewslettersManager iNewslettersManager = this.this$0.newslettersManager;
            Site site = this.$siteInfo.getSite();
            Boolean boxBoolean = Boxing.boxBoolean(this.$subscribe);
            this.label = 1;
            obj = iNewslettersManager.updateSubscription(str, site, null, boxBoolean, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        int i6 = this.$subscribe ? R.string.profile_newsletter_promotionsSubscribed : R.string.profile_newsletter_promotionsUnsubscribed;
        ProfileNewslettersViewModel profileNewslettersViewModel = this.this$0;
        SnackbarText.ResourceTextWithResourcePlaceholders resourceTextWithResourcePlaceholders = new SnackbarText.ResourceTextWithResourcePlaceholders(i6, CollectionsKt.listOf(this.$siteInfo.getSiteName()));
        boolean z5 = this.$subscribe;
        this.label = 2;
        showSnackbar = profileNewslettersViewModel.showSnackbar(managerResult, resourceTextWithResourcePlaceholders, z5, this);
        if (showSnackbar == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileNewslettersViewModel$updatePromotionsSubscription$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
