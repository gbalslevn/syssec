package dk.molslinjen.domain.managers.agreement.commuter.bornholm;

import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.domain.extensions.domain.CommuterBookingExtensionsKt;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
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
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "it", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.commuter.bornholm.BornholmCommuterManager$getAgreementHistory$2", f = "BornholmCommuterManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BornholmCommuterManager$getAgreementHistory$2 extends SuspendLambda implements Function2<List<? extends BornholmCommuterBookingResponseDTO>, Continuation<? super List<? extends BornholmCommuterBooking>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BornholmCommuterManager$getAgreementHistory$2(Continuation<? super BornholmCommuterManager$getAgreementHistory$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BornholmCommuterManager$getAgreementHistory$2 bornholmCommuterManager$getAgreementHistory$2 = new BornholmCommuterManager$getAgreementHistory$2(continuation);
        bornholmCommuterManager$getAgreementHistory$2.L$0 = obj;
        return bornholmCommuterManager$getAgreementHistory$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends BornholmCommuterBookingResponseDTO> list, Continuation<? super List<? extends BornholmCommuterBooking>> continuation) {
        return invoke2((List<BornholmCommuterBookingResponseDTO>) list, (Continuation<? super List<BornholmCommuterBooking>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new BornholmCommuterBooking((BornholmCommuterBookingResponseDTO) it.next()));
        }
        return CommuterBookingExtensionsKt.sortedForDisplay(arrayList);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<BornholmCommuterBookingResponseDTO> list, Continuation<? super List<BornholmCommuterBooking>> continuation) {
        return ((BornholmCommuterManager$getAgreementHistory$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
