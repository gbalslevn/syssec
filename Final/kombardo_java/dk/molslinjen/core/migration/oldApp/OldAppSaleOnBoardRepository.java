package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileObjectRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardRepository;", "Ldk/molslinjen/domain/localstorage/base/FileObjectRepository;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getOrders", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldAppSaleOnBoardRepository extends FileObjectRepository<OldAppSaleOnBoardOrder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppSaleOnBoardRepository(Context context) {
        super(context, "cateringorders.json", OldAppSaleOnBoardOrder.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Object getOrders(Continuation<? super List<OldAppSaleOnBoardOrder>> continuation) {
        return get(continuation);
    }
}
