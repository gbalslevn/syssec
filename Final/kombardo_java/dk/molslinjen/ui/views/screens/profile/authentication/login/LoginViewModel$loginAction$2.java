package dk.molslinjen.ui.views.screens.profile.authentication.login;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.ui.views.global.navigation.ScreenTrackingKeyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/user/LoginResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel$loginAction$2", f = "LoginViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class LoginViewModel$loginAction$2 extends SuspendLambda implements Function2<LoginResult, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$loginAction$2(LoginViewModel loginViewModel, Continuation<? super LoginViewModel$loginAction$2> continuation) {
        super(2, continuation);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginViewModel$loginAction$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginResult loginResult, Continuation<? super Unit> continuation) {
        return ((LoginViewModel$loginAction$2) create(loginResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IAnalyticsTracker iAnalyticsTracker;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String trackingScreen = this.this$0.getViewState().getValue().getTrackingScreen();
        if (trackingScreen != null) {
            iAnalyticsTracker = this.this$0.analyticsTracker;
            iAnalyticsTracker.trackEvent(new AnalyticsEvent.Login(ScreenTrackingKeyKt.trackingKey(trackingScreen)));
        }
        return Unit.INSTANCE;
    }
}
