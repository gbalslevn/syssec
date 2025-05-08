package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \n2\u00020\u0001:\u0001\nB#\b\u0004\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R,\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0001\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/layout/AlignmentLine;", BuildConfig.FLAVOR, "Lkotlin/Function2;", BuildConfig.FLAVOR, "merger", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getMerger$ui_release", "()Lkotlin/jvm/functions/Function2;", "Companion", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AlignmentLine {
    private final Function2<Integer, Integer, Integer> merger;

    public /* synthetic */ AlignmentLine(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    public final Function2<Integer, Integer, Integer> getMerger$ui_release() {
        return this.merger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlignmentLine(Function2<? super Integer, ? super Integer, Integer> function2) {
        this.merger = function2;
    }
}
