package androidx.compose.ui.platform;

import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class AndroidComposeView$dragAndDropModifierOnDragListener$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$dragAndDropModifierOnDragListener$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(DragAndDropTransferData dragAndDropTransferData, Size size, Function1<? super DrawScope, ? extends Unit> function1) {
        android.support.v4.media.session.a.a(dragAndDropTransferData);
        return m2107invoke12SF9DM(null, size.getPackedValue(), function1);
    }

    /* renamed from: invoke-12SF9DM, reason: not valid java name */
    public final Boolean m2107invoke12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j5, Function1<? super DrawScope, Unit> function1) {
        boolean m2104startDrag12SF9DM;
        m2104startDrag12SF9DM = ((AndroidComposeView) this.receiver).m2104startDrag12SF9DM(dragAndDropTransferData, j5, function1);
        return Boolean.valueOf(m2104startDrag12SF9DM);
    }
}
