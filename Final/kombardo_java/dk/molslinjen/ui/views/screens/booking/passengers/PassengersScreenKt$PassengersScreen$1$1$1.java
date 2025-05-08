package dk.molslinjen.ui.views.screens.booking.passengers;

import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.Direction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class PassengersScreenKt$PassengersScreen$1$1$1 extends AdaptedFunctionReference implements Function1<Direction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PassengersScreenKt$PassengersScreen$1$1$1(Object obj) {
        super(1, obj, DestinationsNavigator.class, "navigate", "navigate(Lcom/ramcosta/composedestinations/spec/Direction;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Direction direction) {
        invoke2(direction);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Direction p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        DestinationsNavigator.DefaultImpls.navigate$default((DestinationsNavigator) this.receiver, p02, null, null, 6, null);
    }
}
