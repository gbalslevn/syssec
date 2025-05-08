package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.managers.user.IUserManager;
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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$createAccount$2", f = "UserManager.kt", l = {214}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserManager$createAccount$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $firstName;
    final /* synthetic */ String $lastName;
    int label;
    final /* synthetic */ UserManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserManager$createAccount$2(UserManager userManager, String str, String str2, String str3, Continuation<? super UserManager$createAccount$2> continuation) {
        super(2, continuation);
        this.this$0 = userManager;
        this.$firstName = str;
        this.$lastName = str2;
        this.$email = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserManager$createAccount$2(this.this$0, this.$firstName, this.$lastName, this.$email, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            ISettings iSettings = this.this$0.settings;
            SettingsProperty.User.PendingAccountActivation pendingAccountActivation = SettingsProperty.User.PendingAccountActivation.INSTANCE;
            IUserManager.ActivationInfo activationInfo = new IUserManager.ActivationInfo(this.$firstName, this.$lastName, this.$email);
            this.label = 1;
            if (iSettings.update(pendingAccountActivation, activationInfo, this) == coroutine_suspended) {
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
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((UserManager$createAccount$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
