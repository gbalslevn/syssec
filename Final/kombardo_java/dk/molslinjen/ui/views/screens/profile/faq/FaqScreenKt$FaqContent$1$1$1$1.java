package dk.molslinjen.ui.views.screens.profile.faq;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.SiteInfoExtensionsKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPickerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqScreenKt$FaqContent$1$1$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ Function1<SiteInfo, Unit> $onSiteChange;
    final /* synthetic */ SiteInfo $selectedSite;
    final /* synthetic */ List<SiteInfo> $sites;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FaqScreenKt$FaqContent$1$1$1$1(SiteInfo siteInfo, List<SiteInfo> list, Function1<? super SiteInfo, Unit> function1) {
        this.$selectedSite = siteInfo;
        this.$sites = list;
        this.$onSiteChange = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(Function1 function1, DropdownItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1755167145, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FaqScreen.kt:114)");
        }
        DropdownItem<SiteInfo> dropdownItem = SiteInfoExtensionsKt.toDropdownItem(this.$selectedSite);
        List<SiteInfo> list = this.$sites;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(SiteInfoExtensionsKt.toDropdownItem((SiteInfo) it.next()));
        }
        composer.startReplaceGroup(324034223);
        boolean changed = composer.changed(this.$onSiteChange);
        final Function1<SiteInfo, Unit> function1 = this.$onSiteChange;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.faq.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = FaqScreenKt$FaqContent$1$1$1$1.invoke$lambda$2$lambda$1(Function1.this, (DropdownItem) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        DropdownPickerKt.DropdownPicker(dropdownItem, arrayList, (Function1) rememberedValue, null, composer, 0, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
