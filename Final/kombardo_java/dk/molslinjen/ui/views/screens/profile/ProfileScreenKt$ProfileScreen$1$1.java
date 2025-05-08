package dk.molslinjen.ui.views.screens.profile;

import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileScreenKt$ProfileScreen$1$1 extends FunctionReferenceImpl implements Function1<DropdownItem<String>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileScreenKt$ProfileScreen$1$1(Object obj) {
        super(1, obj, ProfileViewModel.class, "onAccountSelected", "onAccountSelected(Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DropdownItem<String> dropdownItem) {
        invoke2(dropdownItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DropdownItem<String> p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileViewModel) this.receiver).onAccountSelected(p02);
    }
}
