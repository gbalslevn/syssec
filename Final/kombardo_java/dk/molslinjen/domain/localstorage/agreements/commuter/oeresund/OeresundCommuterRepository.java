package dk.molslinjen.domain.localstorage.agreements.commuter.oeresund;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/localstorage/agreements/commuter/oeresund/OeresundCommuterRepository;", "Ldk/molslinjen/domain/localstorage/agreements/commuter/oeresund/IOeresundCommuterRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAgreements", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAll", BuildConfig.FLAVOR, "agreements", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterRepository extends FileCollectionRepository<OeresundCommuterAgreement> implements IOeresundCommuterRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OeresundCommuterRepository(Context appContext) {
        super(appContext, "oeresundcommuteragreements.json", OeresundCommuterAgreement.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    @Override // dk.molslinjen.domain.localstorage.agreements.commuter.oeresund.IOeresundCommuterRepository
    public Object getAgreements(Continuation<? super List<OeresundCommuterAgreement>> continuation) {
        return get(continuation);
    }

    @Override // dk.molslinjen.domain.localstorage.agreements.commuter.oeresund.IOeresundCommuterRepository
    public Object saveAll(List<OeresundCommuterAgreement> list, Continuation<? super Boolean> continuation) {
        return save(list, continuation);
    }
}
