package dk.molslinjen.ui.views.screens.profile.newsletters;

import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$3$1 extends FunctionReferenceImpl implements Function1<NewsletterSubscription, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$3$1(Object obj) {
        super(1, obj, ProfileNewslettersViewModel.class, "onSiteChange", "onSiteChange(Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NewsletterSubscription newsletterSubscription) {
        invoke2(newsletterSubscription);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NewsletterSubscription p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileNewslettersViewModel) this.receiver).onSiteChange(p02);
    }
}
