package dk.molslinjen.domain.managers.user.brobizz;

import dk.molslinjen.domain.model.account.Brobizz;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.brobizz.UserBrobizzManager$removeBrobizz$2", f = "UserBrobizzManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserBrobizzManager$removeBrobizz$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $brobizzId;
    int label;
    final /* synthetic */ UserBrobizzManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBrobizzManager$removeBrobizz$2(UserBrobizzManager userBrobizzManager, String str, Continuation<? super UserBrobizzManager$removeBrobizz$2> continuation) {
        super(2, continuation);
        this.this$0 = userBrobizzManager;
        this.$brobizzId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$3$lambda$2$lambda$0(String str, Brobizz brobizz) {
        return Intrinsics.areEqual(brobizz.getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$3$lambda$2$lambda$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserBrobizzManager$removeBrobizz$2(this.this$0, this.$brobizzId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserBrobizzState value;
        UserBrobizzState userBrobizzState;
        List<Brobizz> mutableList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableStateFlow<UserBrobizzState> brobizzState = this.this$0.getBrobizzState();
        final String str = this.$brobizzId;
        do {
            value = brobizzState.getValue();
            userBrobizzState = value;
            mutableList = CollectionsKt.toMutableList((Collection) userBrobizzState.getBrobizz());
            final Function1 function1 = new Function1() { // from class: dk.molslinjen.domain.managers.user.brobizz.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean invokeSuspend$lambda$3$lambda$2$lambda$0;
                    invokeSuspend$lambda$3$lambda$2$lambda$0 = UserBrobizzManager$removeBrobizz$2.invokeSuspend$lambda$3$lambda$2$lambda$0(str, (Brobizz) obj2);
                    return Boolean.valueOf(invokeSuspend$lambda$3$lambda$2$lambda$0);
                }
            };
            mutableList.removeIf(new Predicate() { // from class: dk.molslinjen.domain.managers.user.brobizz.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    boolean invokeSuspend$lambda$3$lambda$2$lambda$1;
                    invokeSuspend$lambda$3$lambda$2$lambda$1 = UserBrobizzManager$removeBrobizz$2.invokeSuspend$lambda$3$lambda$2$lambda$1(Function1.this, obj2);
                    return invokeSuspend$lambda$3$lambda$2$lambda$1;
                }
            });
        } while (!brobizzState.compareAndSet(value, userBrobizzState.copy(mutableList)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((UserBrobizzManager$removeBrobizz$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
