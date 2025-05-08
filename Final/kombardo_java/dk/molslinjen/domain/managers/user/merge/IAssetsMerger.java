package dk.molslinjen.domain.managers.user.merge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", BuildConfig.FLAVOR, "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLocalAssets", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAssetsMerger {
    Object removeLocalAssets(Continuation<? super Unit> continuation);

    Object reportLocalAssets(Continuation<? super AssetsMergeType<?>> continuation);
}
