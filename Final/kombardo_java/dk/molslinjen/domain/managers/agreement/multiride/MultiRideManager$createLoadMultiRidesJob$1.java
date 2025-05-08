package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.IAccountMultiRideService;
import dk.molslinjen.api.services.multiRide.IMultiRideService;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRideResponseDTO;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRidesResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideCardResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidesResponseDTO;
import dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1", f = "MultiRideManager.kt", l = {97, 104, 105, 108}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideManager$createLoadMultiRidesJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManagerResult<? extends Unit>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MultiRideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRidesResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$2", f = "MultiRideManager.kt", l = {106}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<AccountMultiRidesResponseDTO, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MultiRideManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MultiRideManager multiRideManager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = multiRideManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AccountMultiRidesResponseDTO accountMultiRidesResponseDTO, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(accountMultiRidesResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object updatedMultiRides;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                AccountMultiRidesResponseDTO accountMultiRidesResponseDTO = (AccountMultiRidesResponseDTO) this.L$0;
                MultiRideManager multiRideManager = this.this$0;
                List<AccountMultiRideResponseDTO> multiRides = accountMultiRidesResponseDTO.getMultiRides();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(multiRides, 10));
                Iterator<T> it = multiRides.iterator();
                while (it.hasNext()) {
                    arrayList.add(new MultiRideCard((AccountMultiRideResponseDTO) it.next()));
                }
                this.label = 1;
                updatedMultiRides = multiRideManager.setUpdatedMultiRides(arrayList, this);
                if (updatedMultiRides == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$3", f = "MultiRideManager.kt", l = {112, 113}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MultiRideCard> $repoResult;
        int label;
        final /* synthetic */ MultiRideManager this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRidesResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$3$2", f = "MultiRideManager.kt", l = {114}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$createLoadMultiRidesJob$1$3$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<MultiRidesResponseDTO, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MultiRideManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MultiRideManager multiRideManager, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = multiRideManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MultiRidesResponseDTO multiRidesResponseDTO, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(multiRidesResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object updatedMultiRides;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    MultiRidesResponseDTO multiRidesResponseDTO = (MultiRidesResponseDTO) this.L$0;
                    MultiRideManager multiRideManager = this.this$0;
                    List<MultiRideCardResponseDTO> multiRideTickets = multiRidesResponseDTO.getMultiRideTickets();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(multiRideTickets, 10));
                    Iterator<T> it = multiRideTickets.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new MultiRideCard((MultiRideCardResponseDTO) it.next()));
                    }
                    this.label = 1;
                    updatedMultiRides = multiRideManager.setUpdatedMultiRides(arrayList, this);
                    if (updatedMultiRides == coroutine_suspended) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MultiRideManager multiRideManager, List<MultiRideCard> list, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = multiRideManager;
            this.$repoResult = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$repoResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IMultiRideService iMultiRideService;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iMultiRideService = this.this$0.multiRideService;
                List<MultiRideCard> list = this.$repoResult;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MultiRideCard) it.next()).getId());
                }
                SiteDTO dto = MultiRideManager.INSTANCE.getForceMolsSite().toDTO();
                this.label = 1;
                obj = iMultiRideService.getMultiRides(arrayList, dto, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
            this.label = 2;
            if (ApiResultExtensionsKt.onSuccess((ApiResult) obj, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideManager$createLoadMultiRidesJob$1(MultiRideManager multiRideManager, Continuation<? super MultiRideManager$createLoadMultiRidesJob$1> continuation) {
        super(2, continuation);
        this.this$0 = multiRideManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideManager$createLoadMultiRidesJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ManagerResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ManagerResult<Unit>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IMultiRideRepository iMultiRideRepository;
        IMultiRideManager.MultiRideManagerState value;
        boolean isAuthenticated;
        IAccountMultiRideService iAccountMultiRideService;
        ApiResult apiResult;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iMultiRideRepository = this.this$0.multiRideRepo;
            this.label = 1;
            obj = iMultiRideRepository.getMultiRides(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    anonymousClass2 = new AnonymousClass2(this.this$0, null);
                    this.L$0 = apiResult;
                    this.label = 3;
                    if (ApiResultExtensionsKt.onSuccess(apiResult, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = null;
                    this.label = 4;
                    obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult, this);
                    if (obj == coroutine_suspended) {
                    }
                    return (ManagerResult) obj;
                }
                if (i5 != 3) {
                    if (i5 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return (ManagerResult) obj;
                }
                apiResult = (ApiResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 4;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (ManagerResult) obj;
            }
            ResultKt.throwOnFailure(obj);
        }
        List<MultiRideCard> list = (List) obj;
        MutableStateFlow<IMultiRideManager.MultiRideManagerState> state = this.this$0.getState();
        do {
            value = state.getValue();
        } while (!state.compareAndSet(value, value.copy(list, Boxing.boxBoolean(!list.isEmpty()))));
        isAuthenticated = this.this$0.isAuthenticated();
        if (!isAuthenticated) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass3(this.this$0, list, null), 3, null);
            return new ManagerResult.Success(Unit.INSTANCE);
        }
        String mo3198getAuthTokenOEbVFrA = this.this$0.userManager.mo3198getAuthTokenOEbVFrA();
        if (mo3198getAuthTokenOEbVFrA == null) {
            return ManagerResult.Error.INSTANCE.noMessage();
        }
        iAccountMultiRideService = this.this$0.accountMultiRideService;
        SiteDTO dto = MultiRideManager.INSTANCE.getForceMolsSite().toDTO();
        AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
        this.label = 2;
        obj = iAccountMultiRideService.getMultiRides(dto, m3214toDTOimpl, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        apiResult = (ApiResult) obj;
        anonymousClass2 = new AnonymousClass2(this.this$0, null);
        this.L$0 = apiResult;
        this.label = 3;
        if (ApiResultExtensionsKt.onSuccess(apiResult, anonymousClass2, this) == coroutine_suspended) {
        }
        this.L$0 = null;
        this.label = 4;
        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult, this);
        if (obj == coroutine_suspended) {
        }
        return (ManagerResult) obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ManagerResult<Unit>> continuation) {
        return ((MultiRideManager$createLoadMultiRidesJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
