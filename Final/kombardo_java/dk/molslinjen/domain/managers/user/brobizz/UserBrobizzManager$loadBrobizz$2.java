package dk.molslinjen.domain.managers.user.brobizz;

import dk.molslinjen.api.services.account.brobizz.response.BrobizzDTO;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzResponseDTO;
import dk.molslinjen.domain.model.account.Brobizz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.brobizz.UserBrobizzManager$loadBrobizz$2", f = "UserBrobizzManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserBrobizzManager$loadBrobizz$2 extends SuspendLambda implements Function2<BrobizzResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserBrobizzManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBrobizzManager$loadBrobizz$2(UserBrobizzManager userBrobizzManager, Continuation<? super UserBrobizzManager$loadBrobizz$2> continuation) {
        super(2, continuation);
        this.this$0 = userBrobizzManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserBrobizzManager$loadBrobizz$2 userBrobizzManager$loadBrobizz$2 = new UserBrobizzManager$loadBrobizz$2(this.this$0, continuation);
        userBrobizzManager$loadBrobizz$2.L$0 = obj;
        return userBrobizzManager$loadBrobizz$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BrobizzResponseDTO brobizzResponseDTO, Continuation<? super Unit> continuation) {
        return ((UserBrobizzManager$loadBrobizz$2) create(brobizzResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserBrobizzState value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<BrobizzDTO> brobizz = ((BrobizzResponseDTO) this.L$0).getBrobizz();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(brobizz, 10));
        Iterator<T> it = brobizz.iterator();
        while (it.hasNext()) {
            arrayList.add(new Brobizz((BrobizzDTO) it.next()));
        }
        MutableStateFlow<UserBrobizzState> brobizzState = this.this$0.getBrobizzState();
        do {
            value = brobizzState.getValue();
        } while (!brobizzState.compareAndSet(value, value.copy(arrayList)));
        return Unit.INSTANCE;
    }
}
