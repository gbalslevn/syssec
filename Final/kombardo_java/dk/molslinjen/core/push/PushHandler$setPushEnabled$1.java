package dk.molslinjen.core.push;

import android.os.Build;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.push.PushHandler$setPushEnabled$1", f = "PushHandler.kt", l = {88, 90}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PushHandler$setPushEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowNotifications;
    int label;
    final /* synthetic */ PushHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushHandler$setPushEnabled$1(PushHandler pushHandler, boolean z5, Continuation<? super PushHandler$setPushEnabled$1> continuation) {
        super(2, continuation);
        this.this$0 = pushHandler;
        this.$allowNotifications = z5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushHandler$setPushEnabled$1(this.this$0, this.$allowNotifications, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISettings iSettings;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT >= 33) {
                PushHandler pushHandler = this.this$0;
                this.label = 1;
                if (pushHandler.updatePushSubscriptions(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                iSettings = this.this$0.settings;
                SettingsProperty.Notifications.AllowedPushNotifications allowedPushNotifications = SettingsProperty.Notifications.AllowedPushNotifications.INSTANCE;
                Boolean boxBoolean = Boxing.boxBoolean(this.$allowNotifications);
                this.label = 2;
                if (iSettings.update(allowedPushNotifications, boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1 && i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushHandler$setPushEnabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
