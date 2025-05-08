package dk.molslinjen.domain.localstorage.agreements.commuter.bornholm;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/localstorage/agreements/commuter/bornholm/BornholmCommuterRepository;", "Ldk/molslinjen/domain/localstorage/agreements/commuter/bornholm/IBornholmCommuterRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", BuildConfig.FLAVOR, "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getCommuterIds", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCommuterId", BuildConfig.FLAVOR, "commuterId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterRepository extends FileCollectionRepository<String> implements IBornholmCommuterRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterRepository(Context appContext) {
        super(appContext, "commuteragreements-v2.json", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c A[PHI: r7
      0x006c: PHI (r7v9 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0069, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.agreements.commuter.bornholm.IBornholmCommuterRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addCommuterId(String str, Continuation<? super Boolean> continuation) {
        BornholmCommuterRepository$addCommuterId$1 bornholmCommuterRepository$addCommuterId$1;
        int i5;
        String str2;
        BornholmCommuterRepository bornholmCommuterRepository;
        if (continuation instanceof BornholmCommuterRepository$addCommuterId$1) {
            bornholmCommuterRepository$addCommuterId$1 = (BornholmCommuterRepository$addCommuterId$1) continuation;
            int i6 = bornholmCommuterRepository$addCommuterId$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bornholmCommuterRepository$addCommuterId$1.label = i6 - Integer.MIN_VALUE;
                Object obj = bornholmCommuterRepository$addCommuterId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bornholmCommuterRepository$addCommuterId$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bornholmCommuterRepository$addCommuterId$1.L$0 = str;
                    bornholmCommuterRepository$addCommuterId$1.L$1 = this;
                    bornholmCommuterRepository$addCommuterId$1.label = 1;
                    obj = getCommuterIds(bornholmCommuterRepository$addCommuterId$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                    bornholmCommuterRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bornholmCommuterRepository = (BornholmCommuterRepository) bornholmCommuterRepository$addCommuterId$1.L$1;
                    str2 = (String) bornholmCommuterRepository$addCommuterId$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List distinct = CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends String>) obj, str2));
                bornholmCommuterRepository$addCommuterId$1.L$0 = null;
                bornholmCommuterRepository$addCommuterId$1.L$1 = null;
                bornholmCommuterRepository$addCommuterId$1.label = 2;
                obj = bornholmCommuterRepository.save(distinct, bornholmCommuterRepository$addCommuterId$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        bornholmCommuterRepository$addCommuterId$1 = new BornholmCommuterRepository$addCommuterId$1(this, continuation);
        Object obj2 = bornholmCommuterRepository$addCommuterId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bornholmCommuterRepository$addCommuterId$1.label;
        if (i5 != 0) {
        }
        List distinct2 = CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends String>) obj2, str2));
        bornholmCommuterRepository$addCommuterId$1.L$0 = null;
        bornholmCommuterRepository$addCommuterId$1.L$1 = null;
        bornholmCommuterRepository$addCommuterId$1.label = 2;
        obj2 = bornholmCommuterRepository.save(distinct2, bornholmCommuterRepository$addCommuterId$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.agreements.commuter.bornholm.IBornholmCommuterRepository
    public Object getCommuterIds(Continuation<? super List<String>> continuation) {
        return get(continuation);
    }
}
