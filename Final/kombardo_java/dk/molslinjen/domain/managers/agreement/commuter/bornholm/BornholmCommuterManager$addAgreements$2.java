package dk.molslinjen.domain.managers.agreement.commuter.bornholm;

import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterLoginResponseDTO;
import dk.molslinjen.domain.localstorage.agreements.commuter.bornholm.IBornholmCommuterRepository;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterLoginResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.commuter.bornholm.BornholmCommuterManager$addAgreements$2", f = "BornholmCommuterManager.kt", l = {42}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BornholmCommuterManager$addAgreements$2 extends SuspendLambda implements Function2<BornholmCommuterLoginResponseDTO, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Transportation> $configurationTransports;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BornholmCommuterManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterManager$addAgreements$2(BornholmCommuterManager bornholmCommuterManager, List<Transportation> list, Continuation<? super BornholmCommuterManager$addAgreements$2> continuation) {
        super(2, continuation);
        this.this$0 = bornholmCommuterManager;
        this.$configurationTransports = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BornholmCommuterManager$addAgreements$2 bornholmCommuterManager$addAgreements$2 = new BornholmCommuterManager$addAgreements$2(this.this$0, this.$configurationTransports, continuation);
        bornholmCommuterManager$addAgreements$2.L$0 = obj;
        return bornholmCommuterManager$addAgreements$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BornholmCommuterLoginResponseDTO bornholmCommuterLoginResponseDTO, Continuation<? super Unit> continuation) {
        return ((BornholmCommuterManager$addAgreements$2) create(bornholmCommuterLoginResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IBornholmCommuterRepository iBornholmCommuterRepository;
        BornholmCommuterLoginResponseDTO bornholmCommuterLoginResponseDTO;
        List<BornholmCommuterAgreement> mapAgreements;
        IBornholmCommuterManager.State value;
        IBornholmCommuterManager.State state;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            BornholmCommuterLoginResponseDTO bornholmCommuterLoginResponseDTO2 = (BornholmCommuterLoginResponseDTO) this.L$0;
            iBornholmCommuterRepository = this.this$0.repo;
            String commuterId = bornholmCommuterLoginResponseDTO2.getCommuterId();
            this.L$0 = bornholmCommuterLoginResponseDTO2;
            this.label = 1;
            if (iBornholmCommuterRepository.addCommuterId(commuterId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bornholmCommuterLoginResponseDTO = bornholmCommuterLoginResponseDTO2;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bornholmCommuterLoginResponseDTO = (BornholmCommuterLoginResponseDTO) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mapAgreements = this.this$0.mapAgreements(bornholmCommuterLoginResponseDTO.getCommuterId(), bornholmCommuterLoginResponseDTO.getAgreements(), this.$configurationTransports);
        MutableStateFlow<IBornholmCommuterManager.State> state2 = this.this$0.getState();
        BornholmCommuterManager bornholmCommuterManager = this.this$0;
        do {
            value = state2.getValue();
            state = value;
        } while (!state2.compareAndSet(value, state.copy(bornholmCommuterManager.plus(state.getAgreementsState(), mapAgreements), Boxing.boxBoolean(true))));
        return Unit.INSTANCE;
    }
}
