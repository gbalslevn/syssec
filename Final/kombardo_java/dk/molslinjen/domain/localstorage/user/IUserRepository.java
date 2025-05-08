package dk.molslinjen.domain.localstorage.user;

import dk.molslinjen.domain.model.account.user.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0004¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/localstorage/user/IUserRepository;", BuildConfig.FLAVOR, "getUser", "Ldk/molslinjen/domain/model/account/user/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "user", "(Ldk/molslinjen/domain/model/account/user/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserRepository {
    Object clear(Continuation<? super Boolean> continuation);

    Object getUser(Continuation<? super User> continuation);

    Object save(User user, Continuation<? super Unit> continuation);
}
