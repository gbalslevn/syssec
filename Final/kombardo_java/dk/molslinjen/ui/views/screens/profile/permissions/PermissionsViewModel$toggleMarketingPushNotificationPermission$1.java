package dk.molslinjen.ui.views.screens.profile.permissions;

import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel$toggleMarketingPushNotificationPermission$1", f = "PermissionsViewModel.kt", l = {55, 57}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PermissionsViewModel$toggleMarketingPushNotificationPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    int label;
    final /* synthetic */ PermissionsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionsViewModel$toggleMarketingPushNotificationPermission$1(boolean z5, PermissionsViewModel permissionsViewModel, Continuation<? super PermissionsViewModel$toggleMarketingPushNotificationPermission$1> continuation) {
        super(2, continuation);
        this.$enabled = z5;
        this.this$0 = permissionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermissionsViewModel$toggleMarketingPushNotificationPermission$1(this.$enabled, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IMarketingNotificationManager iMarketingNotificationManager;
        IMarketingNotificationManager iMarketingNotificationManager2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$enabled) {
                iMarketingNotificationManager2 = this.this$0.marketingNotificationManager;
                this.label = 1;
                if (iMarketingNotificationManager2.register(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                iMarketingNotificationManager = this.this$0.marketingNotificationManager;
                this.label = 2;
                if (iMarketingNotificationManager.withdrawConsent(this) == coroutine_suspended) {
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
        return ((PermissionsViewModel$toggleMarketingPushNotificationPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
