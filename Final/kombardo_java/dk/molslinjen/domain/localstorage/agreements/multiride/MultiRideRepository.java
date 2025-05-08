package dk.molslinjen.domain.localstorage.agreements.multiride;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/localstorage/agreements/multiride/MultiRideRepository;", "Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMultiRides", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "multiRide", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAll", "multiRides", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideRepository extends FileCollectionRepository<MultiRideCard> implements IMultiRideRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideRepository(Context appContext) {
        super(appContext, "multi_ride_v2.json", MultiRideCard.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    @Override // dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository
    public Object getMultiRides(Continuation<? super List<MultiRideCard>> continuation) {
        return get(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[PHI: r9
      0x0091: PHI (r9v10 java.lang.Object) = (r9v9 java.lang.Object), (r9v1 java.lang.Object) binds: [B:28:0x008e, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object save(MultiRideCard multiRideCard, Continuation<? super Boolean> continuation) {
        MultiRideRepository$save$1 multiRideRepository$save$1;
        int i5;
        MultiRideCard multiRideCard2;
        MultiRideRepository multiRideRepository;
        if (continuation instanceof MultiRideRepository$save$1) {
            multiRideRepository$save$1 = (MultiRideRepository$save$1) continuation;
            int i6 = multiRideRepository$save$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideRepository$save$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideRepository$save$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideRepository$save$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    multiRideRepository$save$1.L$0 = multiRideCard;
                    multiRideRepository$save$1.L$1 = this;
                    multiRideRepository$save$1.label = 1;
                    obj = getMultiRides(multiRideRepository$save$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideCard2 = multiRideCard;
                    multiRideRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    multiRideRepository = (MultiRideRepository) multiRideRepository$save$1.L$1;
                    multiRideCard2 = (MultiRideCard) multiRideRepository$save$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List plus = CollectionsKt.plus((Collection<? extends MultiRideCard>) obj, multiRideCard2);
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : plus) {
                    if (hashSet.add(((MultiRideCard) obj2).getId())) {
                        arrayList.add(obj2);
                    }
                }
                multiRideRepository$save$1.L$0 = null;
                multiRideRepository$save$1.L$1 = null;
                multiRideRepository$save$1.label = 2;
                obj = multiRideRepository.save(arrayList, multiRideRepository$save$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideRepository$save$1 = new MultiRideRepository$save$1(this, continuation);
        Object obj3 = multiRideRepository$save$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideRepository$save$1.label;
        if (i5 != 0) {
        }
        List plus2 = CollectionsKt.plus((Collection<? extends MultiRideCard>) obj3, multiRideCard2);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        while (r9.hasNext()) {
        }
        multiRideRepository$save$1.L$0 = null;
        multiRideRepository$save$1.L$1 = null;
        multiRideRepository$save$1.label = 2;
        obj3 = multiRideRepository.save(arrayList2, multiRideRepository$save$1);
        if (obj3 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository
    public Object saveAll(List<MultiRideCard> list, Continuation<? super Boolean> continuation) {
        return save(list, continuation);
    }
}
