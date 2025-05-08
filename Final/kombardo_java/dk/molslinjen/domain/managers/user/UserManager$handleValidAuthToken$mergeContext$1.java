package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.MergeResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class UserManager$handleValidAuthToken$mergeContext$1 extends FunctionReferenceImpl implements Function3<List<? extends AssetsMergeType<?>>, AuthToken, Continuation<? super ManagerResult<? extends MergeResult>>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UserManager$handleValidAuthToken$mergeContext$1(Object obj) {
        super(3, obj, UserManager.class, "uploadMergeAssets", "uploadMergeAssets-hlWoXfE(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends AssetsMergeType<?>> list, AuthToken authToken, Continuation<? super ManagerResult<? extends MergeResult>> continuation) {
        return m3207invokehlWoXfE(list, authToken.m3216unboximpl(), continuation);
    }

    /* renamed from: invoke-hlWoXfE, reason: not valid java name */
    public final Object m3207invokehlWoXfE(List<? extends AssetsMergeType<?>> list, String str, Continuation<? super ManagerResult<MergeResult>> continuation) {
        Object m3204uploadMergeAssetshlWoXfE;
        m3204uploadMergeAssetshlWoXfE = ((UserManager) this.receiver).m3204uploadMergeAssetshlWoXfE(list, str, continuation);
        return m3204uploadMergeAssetshlWoXfE;
    }
}
