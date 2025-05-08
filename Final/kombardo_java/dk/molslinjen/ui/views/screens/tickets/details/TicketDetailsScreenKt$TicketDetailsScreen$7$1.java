package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class TicketDetailsScreenKt$TicketDetailsScreen$7$1 extends FunctionReferenceImpl implements Function1<Context, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TicketDetailsScreenKt$TicketDetailsScreen$7$1(Object obj) {
        super(1, obj, TicketDetailsViewModel.class, "shareReceipt", "shareReceipt(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Context context) {
        invoke2(context);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((TicketDetailsViewModel) this.receiver).shareReceipt(p02);
    }
}
