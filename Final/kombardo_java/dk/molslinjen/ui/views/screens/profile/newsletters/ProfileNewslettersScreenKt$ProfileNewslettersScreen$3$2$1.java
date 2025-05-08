package dk.molslinjen.ui.views.screens.profile.newsletters;

import dk.molslinjen.domain.model.site.SiteInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$2$1 extends FunctionReferenceImpl implements Function2<SiteInfo, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$2$1(Object obj) {
        super(2, obj, ProfileNewslettersViewModel.class, "updatePromotionsSubscription", "updatePromotionsSubscription(Ldk/molslinjen/domain/model/site/SiteInfo;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SiteInfo siteInfo, Boolean bool) {
        invoke(siteInfo, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SiteInfo p02, boolean z5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileNewslettersViewModel) this.receiver).updatePromotionsSubscription(p02, z5);
    }
}
