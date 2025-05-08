package dk.molslinjen.ui.views.screens.profile.contact;

import dk.molslinjen.domain.model.site.SiteInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ContactScreenKt$ContactScreen$3$1$1$1 extends FunctionReferenceImpl implements Function1<SiteInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ContactScreenKt$ContactScreen$3$1$1$1(Object obj) {
        super(1, obj, ContactScreenViewModel.class, "onSiteSelected", "onSiteSelected(Ldk/molslinjen/domain/model/site/SiteInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SiteInfo siteInfo) {
        invoke2(siteInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SiteInfo p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ContactScreenViewModel) this.receiver).onSiteSelected(p02);
    }
}
