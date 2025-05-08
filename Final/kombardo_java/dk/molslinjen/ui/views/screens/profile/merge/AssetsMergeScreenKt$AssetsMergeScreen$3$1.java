package dk.molslinjen.ui.views.screens.profile.merge;

import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AssetsMergeScreenKt$AssetsMergeScreen$3$1 extends AdaptedFunctionReference implements Function1<AssetsMergeMethod, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetsMergeScreenKt$AssetsMergeScreen$3$1(Object obj) {
        super(1, obj, AssetsMergeViewModel.class, "merge", "merge(Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;)Lkotlinx/coroutines/Job;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AssetsMergeMethod assetsMergeMethod) {
        invoke2(assetsMergeMethod);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AssetsMergeMethod p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((AssetsMergeViewModel) this.receiver).merge(p02);
    }
}
