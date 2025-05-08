package dk.molslinjen.domain.localstorage.infoAlerts;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.info.InfoAlert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/localstorage/infoAlerts/InfoAlertRepository;", "Ldk/molslinjen/domain/localstorage/infoAlerts/IInfoAlertRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/info/InfoAlert;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "update", BuildConfig.FLAVOR, "infoAlerts", BuildConfig.FLAVOR, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAsShown", "infoAlert", "(Ldk/molslinjen/domain/model/info/InfoAlert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotShown", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InfoAlertRepository extends FileCollectionRepository<InfoAlert> implements IInfoAlertRepository {
    private Mutex mutex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoAlertRepository(Context appContext) {
        super(appContext, "info_alerts_v2.json", InfoAlert.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAllNotShown(Continuation<? super List<InfoAlert>> continuation) {
        InfoAlertRepository$getAllNotShown$1 infoAlertRepository$getAllNotShown$1;
        int i5;
        if (continuation instanceof InfoAlertRepository$getAllNotShown$1) {
            infoAlertRepository$getAllNotShown$1 = (InfoAlertRepository$getAllNotShown$1) continuation;
            int i6 = infoAlertRepository$getAllNotShown$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                infoAlertRepository$getAllNotShown$1.label = i6 - Integer.MIN_VALUE;
                Object obj = infoAlertRepository$getAllNotShown$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = infoAlertRepository$getAllNotShown$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    infoAlertRepository$getAllNotShown$1.label = 1;
                    obj = get(infoAlertRepository$getAllNotShown$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (!((InfoAlert) obj2).getShown()) {
                        arrayList.add(obj2);
                    }
                }
                return arrayList;
            }
        }
        infoAlertRepository$getAllNotShown$1 = new InfoAlertRepository$getAllNotShown$1(this, continuation);
        Object obj3 = infoAlertRepository$getAllNotShown$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = infoAlertRepository$getAllNotShown$1.label;
        if (i5 != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r5.hasNext()) {
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00c7, B:22:0x004c, B:23:0x008b, B:24:0x0094, B:26:0x009a, B:30:0x00b1, B:32:0x00b5, B:33:0x00b8), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00c7, B:22:0x004c, B:23:0x008b, B:24:0x0094, B:26:0x009a, B:30:0x00b1, B:32:0x00b5, B:33:0x00b8), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r13v0, types: [dk.molslinjen.domain.model.info.InfoAlert, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setAsShown(InfoAlert infoAlert, Continuation<? super Unit> continuation) {
        InfoAlertRepository$setAsShown$1 infoAlertRepository$setAsShown$1;
        Object coroutine_suspended;
        int i5;
        Mutex mutex;
        InfoAlertRepository infoAlertRepository;
        InfoAlert infoAlert2;
        Object obj;
        InfoAlertRepository infoAlertRepository2;
        InfoAlert infoAlert3;
        Mutex mutex2;
        Iterator it;
        Object obj2;
        InfoAlert infoAlert4;
        try {
            try {
                if (continuation instanceof InfoAlertRepository$setAsShown$1) {
                    infoAlertRepository$setAsShown$1 = (InfoAlertRepository$setAsShown$1) continuation;
                    int i6 = infoAlertRepository$setAsShown$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        infoAlertRepository$setAsShown$1.label = i6 - Integer.MIN_VALUE;
                        Object obj3 = infoAlertRepository$setAsShown$1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = infoAlertRepository$setAsShown$1.label;
                        if (i5 != 0) {
                            ResultKt.throwOnFailure(obj3);
                            mutex = this.mutex;
                            infoAlertRepository$setAsShown$1.L$0 = this;
                            infoAlertRepository$setAsShown$1.L$1 = infoAlert;
                            infoAlertRepository$setAsShown$1.L$2 = mutex;
                            infoAlertRepository$setAsShown$1.label = 1;
                            if (mutex.lock(null, infoAlertRepository$setAsShown$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            infoAlertRepository = this;
                            infoAlert2 = infoAlert;
                        } else {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    Mutex mutex3 = (Mutex) infoAlertRepository$setAsShown$1.L$0;
                                    ResultKt.throwOnFailure(obj3);
                                    infoAlert = mutex3;
                                    ((Boolean) obj3).booleanValue();
                                    infoAlert.unlock(null);
                                    return Unit.INSTANCE;
                                }
                                Mutex mutex4 = (Mutex) infoAlertRepository$setAsShown$1.L$2;
                                infoAlert3 = (InfoAlert) infoAlertRepository$setAsShown$1.L$1;
                                infoAlertRepository2 = (InfoAlertRepository) infoAlertRepository$setAsShown$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                mutex2 = mutex4;
                                List list = (List) obj3;
                                it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = it.next();
                                    if (Intrinsics.areEqual(((InfoAlert) obj2).getId(), infoAlert3.getId())) {
                                        break;
                                    }
                                }
                                infoAlert4 = (InfoAlert) obj2;
                                if (infoAlert4 != null) {
                                    infoAlert4.setShown(true);
                                }
                                infoAlertRepository$setAsShown$1.L$0 = mutex2;
                                infoAlertRepository$setAsShown$1.L$1 = null;
                                infoAlertRepository$setAsShown$1.L$2 = null;
                                infoAlertRepository$setAsShown$1.label = 3;
                                obj3 = infoAlertRepository2.save(list, infoAlertRepository$setAsShown$1);
                                infoAlert = mutex2;
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ((Boolean) obj3).booleanValue();
                                infoAlert.unlock(null);
                                return Unit.INSTANCE;
                            }
                            Mutex mutex5 = (Mutex) infoAlertRepository$setAsShown$1.L$2;
                            InfoAlert infoAlert5 = (InfoAlert) infoAlertRepository$setAsShown$1.L$1;
                            infoAlertRepository = (InfoAlertRepository) infoAlertRepository$setAsShown$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            mutex = mutex5;
                            infoAlert2 = infoAlert5;
                        }
                        infoAlertRepository$setAsShown$1.L$0 = infoAlertRepository;
                        infoAlertRepository$setAsShown$1.L$1 = infoAlert2;
                        infoAlertRepository$setAsShown$1.L$2 = mutex;
                        infoAlertRepository$setAsShown$1.label = 2;
                        obj = infoAlertRepository.get(infoAlertRepository$setAsShown$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        infoAlertRepository2 = infoAlertRepository;
                        infoAlert3 = infoAlert2;
                        mutex2 = mutex;
                        obj3 = obj;
                        List list2 = (List) obj3;
                        it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                            }
                        }
                        infoAlert4 = (InfoAlert) obj2;
                        if (infoAlert4 != null) {
                        }
                        infoAlertRepository$setAsShown$1.L$0 = mutex2;
                        infoAlertRepository$setAsShown$1.L$1 = null;
                        infoAlertRepository$setAsShown$1.L$2 = null;
                        infoAlertRepository$setAsShown$1.label = 3;
                        obj3 = infoAlertRepository2.save(list2, infoAlertRepository$setAsShown$1);
                        infoAlert = mutex2;
                        if (obj3 == coroutine_suspended) {
                        }
                        ((Boolean) obj3).booleanValue();
                        infoAlert.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                infoAlertRepository$setAsShown$1.L$0 = infoAlertRepository;
                infoAlertRepository$setAsShown$1.L$1 = infoAlert2;
                infoAlertRepository$setAsShown$1.L$2 = mutex;
                infoAlertRepository$setAsShown$1.label = 2;
                obj = infoAlertRepository.get(infoAlertRepository$setAsShown$1);
                if (obj != coroutine_suspended) {
                }
            } catch (Throwable th) {
                Mutex mutex6 = mutex;
                th = th;
                infoAlert = mutex6;
                infoAlert.unlock(null);
                throw th;
            }
            if (i5 != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        infoAlertRepository$setAsShown$1 = new InfoAlertRepository$setAsShown$1(this, continuation);
        Object obj32 = infoAlertRepository$setAsShown$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = infoAlertRepository$setAsShown$1.label;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(4:(2:3|(7:5|6|7|(1:(1:(1:(5:12|13|14|15|16)(2:19|20))(13:21|22|23|(2:26|24)|27|28|(4:31|(3:33|34|35)(1:37)|36|29)|38|39|(1:41)|14|15|16))(1:42))(2:53|(1:55)(1:56))|43|44|(1:46)(12:47|23|(1:24)|27|28|(1:29)|38|39|(0)|14|15|16)))|43|44|(0)(0))|58|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0035, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac A[Catch: all -> 0x0035, LOOP:0: B:24:0x00a6->B:26:0x00ac, LOOP_END, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00ee, B:22:0x004c, B:23:0x008b, B:24:0x00a6, B:26:0x00ac, B:28:0x00bb, B:29:0x00bf, B:31:0x00c5, B:34:0x00d7, B:39:0x00df), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00ee, B:22:0x004c, B:23:0x008b, B:24:0x00a6, B:26:0x00ac, B:28:0x00bb, B:29:0x00bf, B:31:0x00c5, B:34:0x00d7, B:39:0x00df), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List<dk.molslinjen.domain.model.info.InfoAlert>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // dk.molslinjen.domain.localstorage.infoAlerts.IInfoAlertRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object update(List<InfoAlert> list, Continuation<? super Unit> continuation) {
        InfoAlertRepository$update$1 infoAlertRepository$update$1;
        Object coroutine_suspended;
        int i5;
        Mutex mutex;
        InfoAlertRepository infoAlertRepository;
        List list2;
        Object obj;
        InfoAlertRepository infoAlertRepository2;
        List<InfoAlert> list3;
        Mutex mutex2;
        try {
            if (continuation instanceof InfoAlertRepository$update$1) {
                infoAlertRepository$update$1 = (InfoAlertRepository$update$1) continuation;
                int i6 = infoAlertRepository$update$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    infoAlertRepository$update$1.label = i6 - Integer.MIN_VALUE;
                    Object obj2 = infoAlertRepository$update$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = infoAlertRepository$update$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        mutex = this.mutex;
                        infoAlertRepository$update$1.L$0 = this;
                        infoAlertRepository$update$1.L$1 = list;
                        infoAlertRepository$update$1.L$2 = mutex;
                        infoAlertRepository$update$1.label = 1;
                        if (mutex.lock(null, infoAlertRepository$update$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        infoAlertRepository = this;
                        list2 = list;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Mutex mutex3 = (Mutex) infoAlertRepository$update$1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                list = mutex3;
                                ((Boolean) obj2).booleanValue();
                                list.unlock(null);
                                return Unit.INSTANCE;
                            }
                            Mutex mutex4 = (Mutex) infoAlertRepository$update$1.L$2;
                            list3 = (List) infoAlertRepository$update$1.L$1;
                            infoAlertRepository2 = (InfoAlertRepository) infoAlertRepository$update$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            mutex2 = mutex4;
                            Iterable iterable = (Iterable) obj2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
                            for (Object obj3 : iterable) {
                                linkedHashMap.put(((InfoAlert) obj3).getId(), obj3);
                            }
                            for (InfoAlert infoAlert : list3) {
                                InfoAlert infoAlert2 = (InfoAlert) linkedHashMap.get(infoAlert.getId());
                                if (infoAlert2 != null) {
                                    infoAlert.setShown(infoAlert2.getShown());
                                }
                            }
                            infoAlertRepository$update$1.L$0 = mutex2;
                            infoAlertRepository$update$1.L$1 = null;
                            infoAlertRepository$update$1.L$2 = null;
                            infoAlertRepository$update$1.label = 3;
                            obj2 = infoAlertRepository2.save(list3, infoAlertRepository$update$1);
                            list = mutex2;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ((Boolean) obj2).booleanValue();
                            list.unlock(null);
                            return Unit.INSTANCE;
                        }
                        Mutex mutex5 = (Mutex) infoAlertRepository$update$1.L$2;
                        List list4 = (List) infoAlertRepository$update$1.L$1;
                        infoAlertRepository = (InfoAlertRepository) infoAlertRepository$update$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        mutex = mutex5;
                        list2 = list4;
                    }
                    infoAlertRepository$update$1.L$0 = infoAlertRepository;
                    infoAlertRepository$update$1.L$1 = list2;
                    infoAlertRepository$update$1.L$2 = mutex;
                    infoAlertRepository$update$1.label = 2;
                    obj = infoAlertRepository.get(infoAlertRepository$update$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    infoAlertRepository2 = infoAlertRepository;
                    list3 = list2;
                    mutex2 = mutex;
                    obj2 = obj;
                    Iterable iterable2 = (Iterable) obj2;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable2, 10)), 16));
                    while (r12.hasNext()) {
                    }
                    while (r12.hasNext()) {
                    }
                    infoAlertRepository$update$1.L$0 = mutex2;
                    infoAlertRepository$update$1.L$1 = null;
                    infoAlertRepository$update$1.L$2 = null;
                    infoAlertRepository$update$1.label = 3;
                    obj2 = infoAlertRepository2.save(list3, infoAlertRepository$update$1);
                    list = mutex2;
                    if (obj2 == coroutine_suspended) {
                    }
                    ((Boolean) obj2).booleanValue();
                    list.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            infoAlertRepository$update$1.L$0 = infoAlertRepository;
            infoAlertRepository$update$1.L$1 = list2;
            infoAlertRepository$update$1.L$2 = mutex;
            infoAlertRepository$update$1.label = 2;
            obj = infoAlertRepository.get(infoAlertRepository$update$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th) {
            Mutex mutex6 = mutex;
            th = th;
            list = mutex6;
            list.unlock(null);
            throw th;
        }
        infoAlertRepository$update$1 = new InfoAlertRepository$update$1(this, continuation);
        Object obj22 = infoAlertRepository$update$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = infoAlertRepository$update$1.label;
        if (i5 != 0) {
        }
    }
}
