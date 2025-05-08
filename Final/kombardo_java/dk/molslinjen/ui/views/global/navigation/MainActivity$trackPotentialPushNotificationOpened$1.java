package dk.molslinjen.ui.views.global.navigation;

import android.content.Intent;
import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.push.PushMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AgillicReportId;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.MainActivity$trackPotentialPushNotificationOpened$1", f = "MainActivity.kt", l = {244}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MainActivity$trackPotentialPushNotificationOpened$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ int $reportId;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$trackPotentialPushNotificationOpened$1(Intent intent, MainActivity mainActivity, int i5, Continuation<? super MainActivity$trackPotentialPushNotificationOpened$1> continuation) {
        super(2, continuation);
        this.$intent = intent;
        this.this$0 = mainActivity;
        this.$reportId = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$trackPotentialPushNotificationOpened$1(this.$intent, this.this$0, this.$reportId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            String stringExtra = this.$intent.getStringExtra(Constants.IntentExtra.PushTitle);
            String stringExtra2 = this.$intent.getStringExtra(Constants.IntentExtra.PushBody);
            if (stringExtra != null && stringExtra2 != null) {
                this.this$0.getNotificationManager().addPushMessageToShowInDialog(new PushMessage(stringExtra, stringExtra2));
            }
            int i7 = this.$reportId;
            i5 = this.this$0.pushReportIdDefaultValue;
            if (i7 != i5) {
                IMarketingNotificationManager marketingNotificationManager = this.this$0.getMarketingNotificationManager();
                AgillicReportId agillicReportId = new AgillicReportId(this.$reportId);
                this.label = 1;
                if (marketingNotificationManager.trackOpenedNotification(agillicReportId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.getPushHandler().openedNotification(this.$intent);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.AgillicReportId);
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.ReportId);
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.PushTitle);
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.PushBody);
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.PushTagKey);
        this.this$0.getIntent().removeExtra(Constants.IntentExtra.PushTagValue);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$trackPotentialPushNotificationOpened$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
