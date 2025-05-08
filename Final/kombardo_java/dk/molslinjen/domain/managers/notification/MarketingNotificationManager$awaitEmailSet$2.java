package dk.molslinjen.domain.managers.notification;

import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/user/IUserManager$UserState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.notification.MarketingNotificationManager$awaitEmailSet$2", f = "MarketingNotificationManager.kt", l = {50}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MarketingNotificationManager$awaitEmailSet$2 extends SuspendLambda implements Function2<IUserManager.UserState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MarketingNotificationManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketingNotificationManager$awaitEmailSet$2(MarketingNotificationManager marketingNotificationManager, Continuation<? super MarketingNotificationManager$awaitEmailSet$2> continuation) {
        super(2, continuation);
        this.this$0 = marketingNotificationManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MarketingNotificationManager$awaitEmailSet$2 marketingNotificationManager$awaitEmailSet$2 = new MarketingNotificationManager$awaitEmailSet$2(this.this$0, continuation);
        marketingNotificationManager$awaitEmailSet$2.L$0 = obj;
        return marketingNotificationManager$awaitEmailSet$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(IUserManager.UserState userState, Continuation<? super Unit> continuation) {
        return ((MarketingNotificationManager$awaitEmailSet$2) create(userState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISettings iSettings;
        UserContactDetails contactDetails;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            IUserManager.UserState userState = (IUserManager.UserState) this.L$0;
            iSettings = this.this$0.settings;
            if (((Boolean) iSettings.latestValueFor(SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE)).booleanValue()) {
                UserInfo details = userState.getUser().getDetails();
                if (((details == null || (contactDetails = details.getContactDetails()) == null) ? null : contactDetails.getEmail()) != null) {
                    MarketingNotificationManager marketingNotificationManager = this.this$0;
                    this.label = 1;
                    if (marketingNotificationManager.register(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
