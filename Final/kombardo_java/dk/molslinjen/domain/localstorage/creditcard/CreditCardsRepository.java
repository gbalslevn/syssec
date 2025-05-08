package dk.molslinjen.domain.localstorage.creditcard;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.account.CreditCard;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/localstorage/creditcard/CreditCardsRepository;", "Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/account/CreditCard;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getCards", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "card", "(Ldk/molslinjen/domain/model/account/CreditCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreditCardsRepository extends FileCollectionRepository<CreditCard> implements ICreditCardsRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreditCardsRepository(Context appContext) {
        super(appContext, "credit_cards_v2.json", CreditCard.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.creditcard.ICreditCardsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteCard(String str, Continuation<? super List<CreditCard>> continuation) {
        CreditCardsRepository$deleteCard$1 creditCardsRepository$deleteCard$1;
        int i5;
        CreditCardsRepository creditCardsRepository;
        if (continuation instanceof CreditCardsRepository$deleteCard$1) {
            creditCardsRepository$deleteCard$1 = (CreditCardsRepository$deleteCard$1) continuation;
            int i6 = creditCardsRepository$deleteCard$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                creditCardsRepository$deleteCard$1.label = i6 - Integer.MIN_VALUE;
                Object obj = creditCardsRepository$deleteCard$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = creditCardsRepository$deleteCard$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    creditCardsRepository$deleteCard$1.L$0 = this;
                    creditCardsRepository$deleteCard$1.L$1 = str;
                    creditCardsRepository$deleteCard$1.label = 1;
                    obj = get(creditCardsRepository$deleteCard$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    creditCardsRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List list = (List) creditCardsRepository$deleteCard$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    str = (String) creditCardsRepository$deleteCard$1.L$1;
                    creditCardsRepository = (CreditCardsRepository) creditCardsRepository$deleteCard$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (!Intrinsics.areEqual(((CreditCard) obj2).getCardId(), str)) {
                        arrayList.add(obj2);
                    }
                }
                creditCardsRepository$deleteCard$1.L$0 = arrayList;
                creditCardsRepository$deleteCard$1.L$1 = null;
                creditCardsRepository$deleteCard$1.label = 2;
                return creditCardsRepository.save(arrayList, creditCardsRepository$deleteCard$1) != coroutine_suspended ? coroutine_suspended : arrayList;
            }
        }
        creditCardsRepository$deleteCard$1 = new CreditCardsRepository$deleteCard$1(this, continuation);
        Object obj3 = creditCardsRepository$deleteCard$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = creditCardsRepository$deleteCard$1.label;
        if (i5 != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r9.hasNext()) {
        }
        creditCardsRepository$deleteCard$1.L$0 = arrayList2;
        creditCardsRepository$deleteCard$1.L$1 = null;
        creditCardsRepository$deleteCard$1.label = 2;
        if (creditCardsRepository.save(arrayList2, creditCardsRepository$deleteCard$1) != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.creditcard.ICreditCardsRepository
    public Object getCards(Continuation<? super List<CreditCard>> continuation) {
        return get(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[PHI: r9
      0x0091: PHI (r9v10 java.lang.Object) = (r9v9 java.lang.Object), (r9v1 java.lang.Object) binds: [B:28:0x008e, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.creditcard.ICreditCardsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object save(CreditCard creditCard, Continuation<? super Boolean> continuation) {
        CreditCardsRepository$save$1 creditCardsRepository$save$1;
        int i5;
        CreditCard creditCard2;
        CreditCardsRepository creditCardsRepository;
        if (continuation instanceof CreditCardsRepository$save$1) {
            creditCardsRepository$save$1 = (CreditCardsRepository$save$1) continuation;
            int i6 = creditCardsRepository$save$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                creditCardsRepository$save$1.label = i6 - Integer.MIN_VALUE;
                Object obj = creditCardsRepository$save$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = creditCardsRepository$save$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    creditCardsRepository$save$1.L$0 = creditCard;
                    creditCardsRepository$save$1.L$1 = this;
                    creditCardsRepository$save$1.label = 1;
                    obj = getCards(creditCardsRepository$save$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    creditCard2 = creditCard;
                    creditCardsRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    creditCardsRepository = (CreditCardsRepository) creditCardsRepository$save$1.L$1;
                    creditCard2 = (CreditCard) creditCardsRepository$save$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List plus = CollectionsKt.plus((Collection<? extends CreditCard>) obj, creditCard2);
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : plus) {
                    if (hashSet.add(((CreditCard) obj2).getCreditCardToken())) {
                        arrayList.add(obj2);
                    }
                }
                creditCardsRepository$save$1.L$0 = null;
                creditCardsRepository$save$1.L$1 = null;
                creditCardsRepository$save$1.label = 2;
                obj = creditCardsRepository.save(arrayList, creditCardsRepository$save$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        creditCardsRepository$save$1 = new CreditCardsRepository$save$1(this, continuation);
        Object obj3 = creditCardsRepository$save$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = creditCardsRepository$save$1.label;
        if (i5 != 0) {
        }
        List plus2 = CollectionsKt.plus((Collection<? extends CreditCard>) obj3, creditCard2);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        while (r9.hasNext()) {
        }
        creditCardsRepository$save$1.L$0 = null;
        creditCardsRepository$save$1.L$1 = null;
        creditCardsRepository$save$1.label = 2;
        obj3 = creditCardsRepository.save(arrayList2, creditCardsRepository$save$1);
        if (obj3 != coroutine_suspended2) {
        }
    }
}
