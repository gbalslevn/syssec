package dk.molslinjen.domain.localstorage.vehicle;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.account.UserVehicle;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0012¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/localstorage/vehicle/VehicleRepository;", "Ldk/molslinjen/domain/localstorage/vehicle/IVehicleRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getVehicles", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", "vehicleId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", BuildConfig.FLAVOR, "updatedVehicle", "(Ldk/molslinjen/domain/model/account/UserVehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "vehicle", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VehicleRepository extends FileCollectionRepository<UserVehicle> implements IVehicleRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VehicleRepository(Context appContext) {
        super(appContext, "vehicles_v2.json", UserVehicle.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.vehicle.IVehicleRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteVehicle(String str, Continuation<? super List<UserVehicle>> continuation) {
        VehicleRepository$deleteVehicle$1 vehicleRepository$deleteVehicle$1;
        int i5;
        VehicleRepository vehicleRepository;
        if (continuation instanceof VehicleRepository$deleteVehicle$1) {
            vehicleRepository$deleteVehicle$1 = (VehicleRepository$deleteVehicle$1) continuation;
            int i6 = vehicleRepository$deleteVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                vehicleRepository$deleteVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = vehicleRepository$deleteVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = vehicleRepository$deleteVehicle$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    vehicleRepository$deleteVehicle$1.L$0 = this;
                    vehicleRepository$deleteVehicle$1.L$1 = str;
                    vehicleRepository$deleteVehicle$1.label = 1;
                    obj = get(vehicleRepository$deleteVehicle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vehicleRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List list = (List) vehicleRepository$deleteVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    str = (String) vehicleRepository$deleteVehicle$1.L$1;
                    vehicleRepository = (VehicleRepository) vehicleRepository$deleteVehicle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (!Intrinsics.areEqual(((UserVehicle) obj2).getId(), str)) {
                        arrayList.add(obj2);
                    }
                }
                vehicleRepository$deleteVehicle$1.L$0 = arrayList;
                vehicleRepository$deleteVehicle$1.L$1 = null;
                vehicleRepository$deleteVehicle$1.label = 2;
                return vehicleRepository.save(arrayList, vehicleRepository$deleteVehicle$1) != coroutine_suspended ? coroutine_suspended : arrayList;
            }
        }
        vehicleRepository$deleteVehicle$1 = new VehicleRepository$deleteVehicle$1(this, continuation);
        Object obj3 = vehicleRepository$deleteVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = vehicleRepository$deleteVehicle$1.label;
        if (i5 != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r9.hasNext()) {
        }
        vehicleRepository$deleteVehicle$1.L$0 = arrayList2;
        vehicleRepository$deleteVehicle$1.L$1 = null;
        vehicleRepository$deleteVehicle$1.label = 2;
        if (vehicleRepository.save(arrayList2, vehicleRepository$deleteVehicle$1) != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.vehicle.IVehicleRepository
    public Object getVehicles(Continuation<? super List<UserVehicle>> continuation) {
        return get(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[PHI: r7
      0x0066: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0063, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.vehicle.IVehicleRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object save(UserVehicle userVehicle, Continuation<? super Boolean> continuation) {
        VehicleRepository$save$1 vehicleRepository$save$1;
        int i5;
        UserVehicle userVehicle2;
        VehicleRepository vehicleRepository;
        if (continuation instanceof VehicleRepository$save$1) {
            vehicleRepository$save$1 = (VehicleRepository$save$1) continuation;
            int i6 = vehicleRepository$save$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                vehicleRepository$save$1.label = i6 - Integer.MIN_VALUE;
                Object obj = vehicleRepository$save$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = vehicleRepository$save$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    vehicleRepository$save$1.L$0 = userVehicle;
                    vehicleRepository$save$1.L$1 = this;
                    vehicleRepository$save$1.label = 1;
                    obj = getVehicles(vehicleRepository$save$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userVehicle2 = userVehicle;
                    vehicleRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    vehicleRepository = (VehicleRepository) vehicleRepository$save$1.L$1;
                    userVehicle2 = (UserVehicle) vehicleRepository$save$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List plus = CollectionsKt.plus((Collection<? extends UserVehicle>) obj, userVehicle2);
                vehicleRepository$save$1.L$0 = null;
                vehicleRepository$save$1.L$1 = null;
                vehicleRepository$save$1.label = 2;
                obj = vehicleRepository.save(plus, vehicleRepository$save$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        vehicleRepository$save$1 = new VehicleRepository$save$1(this, continuation);
        Object obj2 = vehicleRepository$save$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = vehicleRepository$save$1.label;
        if (i5 != 0) {
        }
        List plus2 = CollectionsKt.plus((Collection<? extends UserVehicle>) obj2, userVehicle2);
        vehicleRepository$save$1.L$0 = null;
        vehicleRepository$save$1.L$1 = null;
        vehicleRepository$save$1.label = 2;
        obj2 = vehicleRepository.save(plus2, vehicleRepository$save$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008f A[PHI: r10
      0x008f: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:27:0x008c, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.vehicle.IVehicleRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateVehicle(UserVehicle userVehicle, Continuation<? super Boolean> continuation) {
        VehicleRepository$updateVehicle$1 vehicleRepository$updateVehicle$1;
        int i5;
        VehicleRepository vehicleRepository;
        if (continuation instanceof VehicleRepository$updateVehicle$1) {
            vehicleRepository$updateVehicle$1 = (VehicleRepository$updateVehicle$1) continuation;
            int i6 = vehicleRepository$updateVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                vehicleRepository$updateVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = vehicleRepository$updateVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = vehicleRepository$updateVehicle$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    vehicleRepository$updateVehicle$1.L$0 = this;
                    vehicleRepository$updateVehicle$1.L$1 = userVehicle;
                    vehicleRepository$updateVehicle$1.label = 1;
                    obj = get(vehicleRepository$updateVehicle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vehicleRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    userVehicle = (UserVehicle) vehicleRepository$updateVehicle$1.L$1;
                    vehicleRepository = (VehicleRepository) vehicleRepository$updateVehicle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Iterable<UserVehicle> iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (UserVehicle userVehicle2 : iterable) {
                    if (Intrinsics.areEqual(userVehicle2.getId(), userVehicle.getId())) {
                        userVehicle2 = userVehicle;
                    }
                    arrayList.add(userVehicle2);
                }
                vehicleRepository$updateVehicle$1.L$0 = null;
                vehicleRepository$updateVehicle$1.L$1 = null;
                vehicleRepository$updateVehicle$1.label = 2;
                obj = vehicleRepository.save(arrayList, vehicleRepository$updateVehicle$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        vehicleRepository$updateVehicle$1 = new VehicleRepository$updateVehicle$1(this, continuation);
        Object obj2 = vehicleRepository$updateVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = vehicleRepository$updateVehicle$1.label;
        if (i5 != 0) {
        }
        Iterable<UserVehicle> iterable2 = (Iterable) obj2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        while (r10.hasNext()) {
        }
        vehicleRepository$updateVehicle$1.L$0 = null;
        vehicleRepository$updateVehicle$1.L$1 = null;
        vehicleRepository$updateVehicle$1.label = 2;
        obj2 = vehicleRepository.save(arrayList2, vehicleRepository$updateVehicle$1);
        if (obj2 != coroutine_suspended2) {
        }
    }
}
