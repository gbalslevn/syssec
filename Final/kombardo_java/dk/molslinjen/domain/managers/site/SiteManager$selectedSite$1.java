package dk.molslinjen.domain.managers.site;

import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/site/SiteInfo;", "selectedSite", "Ldk/molslinjen/domain/model/config/Site;", "availableSites", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.site.SiteManager$selectedSite$1", f = "SiteManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class SiteManager$selectedSite$1 extends SuspendLambda implements Function3<Site, List<? extends SiteInfo>, Continuation<? super SiteInfo>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SiteManager$selectedSite$1(Continuation<? super SiteManager$selectedSite$1> continuation) {
        super(3, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Site site, List<SiteInfo> list, Continuation<? super SiteInfo> continuation) {
        SiteManager$selectedSite$1 siteManager$selectedSite$1 = new SiteManager$selectedSite$1(continuation);
        siteManager$selectedSite$1.L$0 = site;
        siteManager$selectedSite$1.L$1 = list;
        return siteManager$selectedSite$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Site site = (Site) this.L$0;
        List list = (List) this.L$1;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SiteInfo) next).getSite() == site) {
                obj2 = next;
                break;
            }
        }
        return (SiteInfo) obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Site site, List<? extends SiteInfo> list, Continuation<? super SiteInfo> continuation) {
        return invoke2(site, (List<SiteInfo>) list, continuation);
    }
}
