package dk.molslinjen.ui.views.screens.booking.departures;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DeparturesScreenSharedKt$DeparturesScreenShared$13$1 extends FunctionReferenceImpl implements Function2<String, Context, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesScreenSharedKt$DeparturesScreenShared$13$1(Object obj) {
        super(2, obj, DeparturesViewModel.class, "showDirections", "showDirections(Ljava/lang/String;Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Context context) {
        invoke2(str, context);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p02, Context p12) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        ((DeparturesViewModel) this.receiver).showDirections(p02, p12);
    }
}
