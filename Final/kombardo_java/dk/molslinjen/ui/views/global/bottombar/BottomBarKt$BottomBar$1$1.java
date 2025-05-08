package dk.molslinjen.ui.views.global.bottombar;

import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class BottomBarKt$BottomBar$1$1 extends FunctionReferenceImpl implements Function1<TypedDestinationSpec<?>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BottomBarKt$BottomBar$1$1(Object obj) {
        super(1, obj, BottomBarViewModel.class, "trackTabChange", "trackTabChange(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec) {
        invoke2(typedDestinationSpec);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TypedDestinationSpec<?> p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((BottomBarViewModel) this.receiver).trackTabChange(p02);
    }
}
