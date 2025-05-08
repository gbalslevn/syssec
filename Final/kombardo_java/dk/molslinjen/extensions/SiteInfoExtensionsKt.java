package dk.molslinjen.extensions;

import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toDropdownItem", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "Ldk/molslinjen/domain/model/site/SiteInfo;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SiteInfoExtensionsKt {
    public static final DropdownItem<SiteInfo> toDropdownItem(SiteInfo siteInfo) {
        Intrinsics.checkNotNullParameter(siteInfo, "<this>");
        return new DropdownItem<>(siteInfo.getSiteName(), siteInfo);
    }
}
