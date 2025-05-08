package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileObjectRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppUserRepository;", "Ldk/molslinjen/domain/localstorage/base/FileObjectRepository;", "Ldk/molslinjen/core/migration/oldApp/OldAppUser;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldAppUserRepository extends FileObjectRepository<OldAppUser> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppUserRepository(Context context) {
        super(context, "user.json", OldAppUser.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Object getUser(Continuation<? super OldAppUser> continuation) {
        return getItem(continuation);
    }
}
