package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.model.account.AuthToken;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "authToken", "Ldk/molslinjen/domain/model/account/AuthToken;", "activeCompanyId", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$authenticationType$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class UserManager$authenticationType$1 extends SuspendLambda implements Function3<AuthToken, String, Continuation<? super AuthenticationType>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserManager$authenticationType$1(Continuation<? super UserManager$authenticationType$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(AuthToken authToken, String str, Continuation<? super AuthenticationType> continuation) {
        AuthToken authToken2 = authToken;
        return m3206invoke9nAhzxs(authToken2 != null ? authToken2.m3216unboximpl() : null, str, continuation);
    }

    /* renamed from: invoke-9nAhzxs, reason: not valid java name */
    public final Object m3206invoke9nAhzxs(String str, String str2, Continuation<? super AuthenticationType> continuation) {
        UserManager$authenticationType$1 userManager$authenticationType$1 = new UserManager$authenticationType$1(continuation);
        userManager$authenticationType$1.L$0 = str != null ? AuthToken.m3209boximpl(str) : null;
        userManager$authenticationType$1.L$1 = str2;
        return userManager$authenticationType$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AuthToken authToken = (AuthToken) this.L$0;
        String m3216unboximpl = authToken != null ? authToken.m3216unboximpl() : null;
        String str = (String) this.L$1;
        return (m3216unboximpl == null || str == null) ? m3216unboximpl != null ? AuthenticationType.User.INSTANCE : AuthenticationType.None.INSTANCE : new AuthenticationType.Company(str);
    }
}
