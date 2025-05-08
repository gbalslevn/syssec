package dk.molslinjen.domain.localstorage.passengers;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0012¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/localstorage/passengers/PassengerRepository;", "Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/account/UserPassenger;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getPassengers", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "passengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", BuildConfig.FLAVOR, "updatedPassenger", "(Ldk/molslinjen/domain/model/account/UserPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "passenger", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerRepository extends FileCollectionRepository<UserPassenger> implements IPassengerRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengerRepository(Context appContext) {
        super(appContext, "passengers_v2.json", UserPassenger.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.passengers.IPassengerRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deletePassenger(String str, Continuation<? super List<UserPassenger>> continuation) {
        PassengerRepository$deletePassenger$1 passengerRepository$deletePassenger$1;
        int i5;
        PassengerRepository passengerRepository;
        if (continuation instanceof PassengerRepository$deletePassenger$1) {
            passengerRepository$deletePassenger$1 = (PassengerRepository$deletePassenger$1) continuation;
            int i6 = passengerRepository$deletePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                passengerRepository$deletePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = passengerRepository$deletePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = passengerRepository$deletePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    passengerRepository$deletePassenger$1.L$0 = this;
                    passengerRepository$deletePassenger$1.L$1 = str;
                    passengerRepository$deletePassenger$1.label = 1;
                    obj = get(passengerRepository$deletePassenger$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    passengerRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List list = (List) passengerRepository$deletePassenger$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    str = (String) passengerRepository$deletePassenger$1.L$1;
                    passengerRepository = (PassengerRepository) passengerRepository$deletePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (!Intrinsics.areEqual(((UserPassenger) obj2).getLocalId(), str)) {
                        arrayList.add(obj2);
                    }
                }
                passengerRepository$deletePassenger$1.L$0 = arrayList;
                passengerRepository$deletePassenger$1.L$1 = null;
                passengerRepository$deletePassenger$1.label = 2;
                return passengerRepository.save(arrayList, passengerRepository$deletePassenger$1) != coroutine_suspended ? coroutine_suspended : arrayList;
            }
        }
        passengerRepository$deletePassenger$1 = new PassengerRepository$deletePassenger$1(this, continuation);
        Object obj3 = passengerRepository$deletePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = passengerRepository$deletePassenger$1.label;
        if (i5 != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r9.hasNext()) {
        }
        passengerRepository$deletePassenger$1.L$0 = arrayList2;
        passengerRepository$deletePassenger$1.L$1 = null;
        passengerRepository$deletePassenger$1.label = 2;
        if (passengerRepository.save(arrayList2, passengerRepository$deletePassenger$1) != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.passengers.IPassengerRepository
    public Object getPassengers(Continuation<? super List<UserPassenger>> continuation) {
        return get(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[PHI: r7
      0x0066: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0063, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.passengers.IPassengerRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object save(UserPassenger userPassenger, Continuation<? super Boolean> continuation) {
        PassengerRepository$save$1 passengerRepository$save$1;
        int i5;
        UserPassenger userPassenger2;
        PassengerRepository passengerRepository;
        if (continuation instanceof PassengerRepository$save$1) {
            passengerRepository$save$1 = (PassengerRepository$save$1) continuation;
            int i6 = passengerRepository$save$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                passengerRepository$save$1.label = i6 - Integer.MIN_VALUE;
                Object obj = passengerRepository$save$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = passengerRepository$save$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    passengerRepository$save$1.L$0 = userPassenger;
                    passengerRepository$save$1.L$1 = this;
                    passengerRepository$save$1.label = 1;
                    obj = getPassengers(passengerRepository$save$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userPassenger2 = userPassenger;
                    passengerRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    passengerRepository = (PassengerRepository) passengerRepository$save$1.L$1;
                    userPassenger2 = (UserPassenger) passengerRepository$save$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List plus = CollectionsKt.plus((Collection<? extends UserPassenger>) obj, userPassenger2);
                passengerRepository$save$1.L$0 = null;
                passengerRepository$save$1.L$1 = null;
                passengerRepository$save$1.label = 2;
                obj = passengerRepository.save(plus, passengerRepository$save$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        passengerRepository$save$1 = new PassengerRepository$save$1(this, continuation);
        Object obj2 = passengerRepository$save$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = passengerRepository$save$1.label;
        if (i5 != 0) {
        }
        List plus2 = CollectionsKt.plus((Collection<? extends UserPassenger>) obj2, userPassenger2);
        passengerRepository$save$1.L$0 = null;
        passengerRepository$save$1.L$1 = null;
        passengerRepository$save$1.label = 2;
        obj2 = passengerRepository.save(plus2, passengerRepository$save$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008f A[PHI: r10
      0x008f: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:27:0x008c, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.passengers.IPassengerRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updatePassenger(UserPassenger userPassenger, Continuation<? super Boolean> continuation) {
        PassengerRepository$updatePassenger$1 passengerRepository$updatePassenger$1;
        int i5;
        PassengerRepository passengerRepository;
        if (continuation instanceof PassengerRepository$updatePassenger$1) {
            passengerRepository$updatePassenger$1 = (PassengerRepository$updatePassenger$1) continuation;
            int i6 = passengerRepository$updatePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                passengerRepository$updatePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = passengerRepository$updatePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = passengerRepository$updatePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    passengerRepository$updatePassenger$1.L$0 = this;
                    passengerRepository$updatePassenger$1.L$1 = userPassenger;
                    passengerRepository$updatePassenger$1.label = 1;
                    obj = get(passengerRepository$updatePassenger$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    passengerRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    userPassenger = (UserPassenger) passengerRepository$updatePassenger$1.L$1;
                    passengerRepository = (PassengerRepository) passengerRepository$updatePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Iterable<UserPassenger> iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (UserPassenger userPassenger2 : iterable) {
                    if (Intrinsics.areEqual(userPassenger2.getLocalId(), userPassenger.getLocalId())) {
                        userPassenger2 = userPassenger;
                    }
                    arrayList.add(userPassenger2);
                }
                passengerRepository$updatePassenger$1.L$0 = null;
                passengerRepository$updatePassenger$1.L$1 = null;
                passengerRepository$updatePassenger$1.label = 2;
                obj = passengerRepository.save(arrayList, passengerRepository$updatePassenger$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        passengerRepository$updatePassenger$1 = new PassengerRepository$updatePassenger$1(this, continuation);
        Object obj2 = passengerRepository$updatePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = passengerRepository$updatePassenger$1.label;
        if (i5 != 0) {
        }
        Iterable<UserPassenger> iterable2 = (Iterable) obj2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        while (r10.hasNext()) {
        }
        passengerRepository$updatePassenger$1.L$0 = null;
        passengerRepository$updatePassenger$1.L$1 = null;
        passengerRepository$updatePassenger$1.label = 2;
        obj2 = passengerRepository.save(arrayList2, passengerRepository$updatePassenger$1);
        if (obj2 != coroutine_suspended2) {
        }
    }
}
