package dk.molslinjen.domain.managers.site;

import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/managers/site/ISiteManager;", BuildConfig.FLAVOR, "selectedSite", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSelectedSite", "()Lkotlinx/coroutines/flow/StateFlow;", "availableSites", BuildConfig.FLAVOR, "getAvailableSites", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISiteManager {
    StateFlow<List<SiteInfo>> getAvailableSites();

    StateFlow<SiteInfo> getSelectedSite();
}
