package dk.molslinjen.domain.managers.infoAlerts;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.info.IInfoService;
import dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository;
import dk.molslinjen.domain.model.info.InfoAlert;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager;", "Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", "infoAlertsRepository", "Ldk/molslinjen/domain/localstorage/infoAlerts/IInfoAlertRepository;", "infoService", "Ldk/molslinjen/api/services/info/IInfoService;", "<init>", "(Ldk/molslinjen/domain/localstorage/infoAlerts/IInfoAlertRepository;Ldk/molslinjen/api/services/info/IInfoService;)V", "infoAlertsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager$InfoAlertsState;", "getInfoAlertsState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateInfoAlerts", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAsShown", "infoAlert", "Ldk/molslinjen/domain/model/info/InfoAlert;", "(Ldk/molslinjen/domain/model/info/InfoAlert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InfoAlertsState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InfoAlertManager implements IInfoAlertManager {
    private final CoroutineScope coroutineScope;
    private final IInfoAlertRepository infoAlertsRepository;
    private final MutableStateFlow<InfoAlertsState> infoAlertsState;
    private final IInfoService infoService;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$1", f = "InfoAlertManager.kt", l = {25}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x004b -> B:5:0x004e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r6.L$3
                dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r1 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.InfoAlertsState) r1
                java.lang.Object r3 = r6.L$2
                java.lang.Object r4 = r6.L$1
                dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r4 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager) r4
                java.lang.Object r5 = r6.L$0
                kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4e
            L1d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L25:
                kotlin.ResultKt.throwOnFailure(r7)
                dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r7 = dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.this
                kotlinx.coroutines.flow.MutableStateFlow r7 = r7.getInfoAlertsState()
                dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r1 = dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.this
                r5 = r7
                r4 = r1
            L32:
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
                if (r7 != r0) goto L4e
                return r0
            L4e:
                java.util.List r7 = (java.util.List) r7
                dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r7 = r1.copy(r7)
                boolean r7 = r5.compareAndSet(r3, r7)
                if (r7 == 0) goto L32
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$2", f = "InfoAlertManager.kt", l = {30}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                InfoAlertManager infoAlertManager = InfoAlertManager.this;
                this.label = 1;
                if (infoAlertManager.updateInfoAlerts(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InfoAlertManager(IInfoAlertRepository infoAlertsRepository, IInfoService infoService) {
        Intrinsics.checkNotNullParameter(infoAlertsRepository, "infoAlertsRepository");
        Intrinsics.checkNotNullParameter(infoService, "infoService");
        this.infoAlertsRepository = infoAlertsRepository;
        this.infoService = infoService;
        this.infoAlertsState = StateFlowKt.MutableStateFlow(new InfoAlertsState(null, 1, 0 == true ? 1 : 0));
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass2(null), 3, null);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0078 -> B:11:0x007b). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object setAsShown(dk.molslinjen.domain.model.info.InfoAlert r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$setAsShown$1
            if (r0 == 0) goto L13
            r0 = r8
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$setAsShown$1 r0 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$setAsShown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$setAsShown$1 r0 = new dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$setAsShown$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r7 = r0.L$3
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r7 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.InfoAlertsState) r7
            java.lang.Object r2 = r0.L$2
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.MutableStateFlow r4 = (kotlinx.coroutines.flow.MutableStateFlow) r4
            java.lang.Object r5 = r0.L$0
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r5 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            java.lang.Object r7 = r0.L$0
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager r7 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5b
        L4a:
            kotlin.ResultKt.throwOnFailure(r8)
            dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository r8 = r6.infoAlertsRepository
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r8.setAsShown(r7, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r7 = r6
        L5b:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r7.getInfoAlertsState()
            r5 = r7
            r4 = r8
        L61:
            java.lang.Object r2 = r4.getValue()
            r7 = r2
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r7 = (dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.InfoAlertsState) r7
            dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository r8 = r5.infoAlertsRepository
            r0.L$0 = r5
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getAllNotShown(r0)
            if (r8 != r1) goto L7b
            return r1
        L7b:
            java.util.List r8 = (java.util.List) r8
            dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager$InfoAlertsState r7 = r7.copy(r8)
            boolean r7 = r4.compareAndSet(r2, r7)
            if (r7 == 0) goto L61
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager.setAsShown(dk.molslinjen.domain.model.info.InfoAlert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateInfoAlerts(Continuation<? super Unit> continuation) {
        InfoAlertManager$updateInfoAlerts$1 infoAlertManager$updateInfoAlerts$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        InfoAlertManager infoAlertManager;
        InfoAlertManager$updateInfoAlerts$2 infoAlertManager$updateInfoAlerts$2;
        if (continuation instanceof InfoAlertManager$updateInfoAlerts$1) {
            infoAlertManager$updateInfoAlerts$1 = (InfoAlertManager$updateInfoAlerts$1) continuation;
            int i6 = infoAlertManager$updateInfoAlerts$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                infoAlertManager$updateInfoAlerts$1.label = i6 - Integer.MIN_VALUE;
                obj = infoAlertManager$updateInfoAlerts$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = infoAlertManager$updateInfoAlerts$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IInfoService iInfoService = this.infoService;
                    infoAlertManager$updateInfoAlerts$1.L$0 = this;
                    infoAlertManager$updateInfoAlerts$1.label = 1;
                    obj = iInfoService.getInformationAlerts(infoAlertManager$updateInfoAlerts$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    infoAlertManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    infoAlertManager = (InfoAlertManager) infoAlertManager$updateInfoAlerts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                infoAlertManager$updateInfoAlerts$2 = new InfoAlertManager$updateInfoAlerts$2(infoAlertManager, null);
                infoAlertManager$updateInfoAlerts$1.L$0 = null;
                infoAlertManager$updateInfoAlerts$1.label = 2;
                if (ApiResultExtensionsKt.onSuccess((ApiResult) obj, infoAlertManager$updateInfoAlerts$2, infoAlertManager$updateInfoAlerts$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        infoAlertManager$updateInfoAlerts$1 = new InfoAlertManager$updateInfoAlerts$1(this, continuation);
        obj = infoAlertManager$updateInfoAlerts$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = infoAlertManager$updateInfoAlerts$1.label;
        if (i5 != 0) {
        }
        infoAlertManager$updateInfoAlerts$2 = new InfoAlertManager$updateInfoAlerts$2(infoAlertManager, null);
        infoAlertManager$updateInfoAlerts$1.L$0 = null;
        infoAlertManager$updateInfoAlerts$1.label = 2;
        if (ApiResultExtensionsKt.onSuccess((ApiResult) obj, infoAlertManager$updateInfoAlerts$2, infoAlertManager$updateInfoAlerts$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager$InfoAlertsState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/info/InfoAlert;", "infoAlerts", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager$InfoAlertsState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInfoAlerts", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class InfoAlertsState {
        private final List<InfoAlert> infoAlerts;

        public InfoAlertsState(List<InfoAlert> infoAlerts) {
            Intrinsics.checkNotNullParameter(infoAlerts, "infoAlerts");
            this.infoAlerts = infoAlerts;
        }

        public final InfoAlertsState copy(List<InfoAlert> infoAlerts) {
            Intrinsics.checkNotNullParameter(infoAlerts, "infoAlerts");
            return new InfoAlertsState(infoAlerts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InfoAlertsState) && Intrinsics.areEqual(this.infoAlerts, ((InfoAlertsState) other).infoAlerts);
        }

        public final List<InfoAlert> getInfoAlerts() {
            return this.infoAlerts;
        }

        public int hashCode() {
            return this.infoAlerts.hashCode();
        }

        public String toString() {
            return "InfoAlertsState(infoAlerts=" + this.infoAlerts + ")";
        }

        public /* synthetic */ InfoAlertsState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Override // dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager
    public MutableStateFlow<InfoAlertsState> getInfoAlertsState() {
        return this.infoAlertsState;
    }
}
