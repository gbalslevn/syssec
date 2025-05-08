package dk.molslinjen.domain.managers.infoAlerts;

import dk.molslinjen.api.services.info.response.InfoAlertsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "response", "Ldk/molslinjen/api/services/info/response/InfoAlertsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$updateInfoAlerts$2", f = "InfoAlertManager.kt", l = {37, 40}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InfoAlertManager$updateInfoAlerts$2 extends SuspendLambda implements Function2<InfoAlertsResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InfoAlertManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoAlertManager$updateInfoAlerts$2(InfoAlertManager infoAlertManager, Continuation<? super InfoAlertManager$updateInfoAlerts$2> continuation) {
        super(2, continuation);
        this.this$0 = infoAlertManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InfoAlertManager$updateInfoAlerts$2 infoAlertManager$updateInfoAlerts$2 = new InfoAlertManager$updateInfoAlerts$2(this.this$0, continuation);
        infoAlertManager$updateInfoAlerts$2.L$0 = obj;
        return infoAlertManager$updateInfoAlerts$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(InfoAlertsResponseDTO infoAlertsResponseDTO, Continuation<? super Unit> continuation) {
        return ((InfoAlertManager$updateInfoAlerts$2) create(infoAlertsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0090 -> B:6:0x0093). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L29
            if (r1 != r2) goto L21
            java.lang.Object r1 = r6.L$3
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r1 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.InfoAlertsState) r1
            java.lang.Object r3 = r6.L$2
            java.lang.Object r4 = r6.L$1
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r4 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager) r4
            java.lang.Object r5 = r6.L$0
            kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L93
        L21:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L29:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6d
        L2d:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            dk.molslinjen.api.services.info.response.InfoAlertsResponseDTO r7 = (dk.molslinjen.api.services.info.response.InfoAlertsResponseDTO) r7
            java.util.List r7 = r7.getInfoAlerts()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r4)
            r1.<init>(r4)
            java.util.Iterator r7 = r7.iterator()
        L49:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r7.next()
            dk.molslinjen.api.services.info.response.InfoAlertResponseDTO r4 = (dk.molslinjen.api.services.info.response.InfoAlertResponseDTO) r4
            dk.molslinjen.domain.model.info.InfoAlert r5 = new dk.molslinjen.domain.model.info.InfoAlert
            r5.<init>(r4)
            r1.add(r5)
            goto L49
        L5e:
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r7 = r6.this$0
            dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository r7 = dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.access$getInfoAlertsRepository$p(r7)
            r6.label = r3
            java.lang.Object r7 = r7.update(r1, r6)
            if (r7 != r0) goto L6d
            return r0
        L6d:
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r7 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r7 = r7.getInfoAlertsState()
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r1 = r6.this$0
            r5 = r7
            r4 = r1
        L77:
            java.lang.Object r3 = r5.getValue()
            r1 = r3
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r1 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.InfoAlertsState) r1
            dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository r7 = dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.access$getInfoAlertsRepository$p(r4)
            r6.L$0 = r5
            r6.L$1 = r4
            r6.L$2 = r3
            r6.L$3 = r1
            r6.label = r2
            java.lang.Object r7 = r7.getAllNotShown(r6)
            if (r7 != r0) goto L93
            return r0
        L93:
            java.util.List r7 = (java.util.List) r7
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r7 = r1.copy(r7)
            boolean r7 = r5.compareAndSet(r3, r7)
            if (r7 == 0) goto L77
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$updateInfoAlerts$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
