package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$getAuthenticationFromSettings$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserManager$getAuthenticationFromSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserManager$getAuthenticationFromSettings$1(UserManager userManager, Continuation<? super UserManager$getAuthenticationFromSettings$1> continuation) {
        super(2, continuation);
        this.this$0 = userManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserManager$getAuthenticationFromSettings$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.this$0.settings.latestValueFor(SettingsProperty.AuthToken.INSTANCE);
        String m3210constructorimpl = str != null ? AuthToken.m3210constructorimpl(str) : null;
        MutableStateFlow mutableStateFlow = this.this$0.authToken;
        do {
            value = mutableStateFlow.getValue();
            AuthToken authToken = (AuthToken) value;
            if (authToken != null) {
                authToken.m3216unboximpl();
            }
        } while (!mutableStateFlow.compareAndSet(value, m3210constructorimpl != null ? AuthToken.m3209boximpl(m3210constructorimpl) : null));
        String str2 = (String) this.this$0.settings.latestValueFor(SettingsProperty.ActiveCompanyId.INSTANCE);
        MutableStateFlow mutableStateFlow2 = this.this$0.activeCompanyId;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, str2));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserManager$getAuthenticationFromSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
