package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/semantics/ScrollAxisRange;", BuildConfig.FLAVOR, "value", "Lkotlin/Function0;", BuildConfig.FLAVOR, "maxValue", "reverseScrolling", BuildConfig.FLAVOR, "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "getMaxValue", "()Lkotlin/jvm/functions/Function0;", "getReverseScrolling", "()Z", "getValue", "toString", BuildConfig.FLAVOR, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollAxisRange {
    private final Function0<Float> maxValue;
    private final boolean reverseScrolling;
    private final Function0<Float> value;

    public ScrollAxisRange(Function0<Float> function0, Function0<Float> function02, boolean z5) {
        this.value = function0;
        this.maxValue = function02;
        this.reverseScrolling = z5;
    }

    public final Function0<Float> getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final Function0<Float> getValue() {
        return this.value;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + this.value.invoke().floatValue() + ", maxValue=" + this.maxValue.invoke().floatValue() + ", reverseScrolling=" + this.reverseScrolling + ')';
    }
}
