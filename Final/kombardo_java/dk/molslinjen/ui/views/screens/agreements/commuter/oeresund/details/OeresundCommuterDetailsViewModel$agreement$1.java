package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details;

import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "managerState", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel$agreement$1", f = "OeresundCommuterDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OeresundCommuterDetailsViewModel$agreement$1 extends SuspendLambda implements Function2<CommuterDataState<? extends OeresundCommuterAgreement>, Continuation<? super OeresundCommuterAgreement>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OeresundCommuterDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OeresundCommuterDetailsViewModel$agreement$1(OeresundCommuterDetailsViewModel oeresundCommuterDetailsViewModel, Continuation<? super OeresundCommuterDetailsViewModel$agreement$1> continuation) {
        super(2, continuation);
        this.this$0 = oeresundCommuterDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OeresundCommuterDetailsViewModel$agreement$1 oeresundCommuterDetailsViewModel$agreement$1 = new OeresundCommuterDetailsViewModel$agreement$1(this.this$0, continuation);
        oeresundCommuterDetailsViewModel$agreement$1.L$0 = obj;
        return oeresundCommuterDetailsViewModel$agreement$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CommuterDataState<OeresundCommuterAgreement> commuterDataState, Continuation<? super OeresundCommuterAgreement> continuation) {
        return ((OeresundCommuterDetailsViewModel$agreement$1) create(commuterDataState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OeresundCommuterDetailsScreenNavArgs oeresundCommuterDetailsScreenNavArgs;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List agreements = CommuterDataStateExtensionsKt.getAgreements((CommuterDataState) this.L$0);
        OeresundCommuterDetailsViewModel oeresundCommuterDetailsViewModel = this.this$0;
        for (Object obj2 : agreements) {
            String agreementId = ((OeresundCommuterAgreement) obj2).getAgreementId();
            oeresundCommuterDetailsScreenNavArgs = oeresundCommuterDetailsViewModel.navArgs;
            if (Intrinsics.areEqual(agreementId, oeresundCommuterDetailsScreenNavArgs.getCommuterAgreementId())) {
                return obj2;
            }
        }
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CommuterDataState<? extends OeresundCommuterAgreement> commuterDataState, Continuation<? super OeresundCommuterAgreement> continuation) {
        return invoke2((CommuterDataState<OeresundCommuterAgreement>) commuterDataState, continuation);
    }
}
