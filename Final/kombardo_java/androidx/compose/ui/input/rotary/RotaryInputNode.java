package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputNode;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", BuildConfig.FLAVOR, "onEvent", "onPreEvent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "event", "onRotaryScrollEvent", "(Landroidx/compose/ui/input/rotary/RotaryScrollEvent;)Z", "onPreRotaryScrollEvent", "Lkotlin/jvm/functions/Function1;", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "setOnEvent", "(Lkotlin/jvm/functions/Function1;)V", "getOnPreEvent", "setOnPreEvent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class RotaryInputNode extends Modifier.Node implements RotaryInputModifierNode {
    private Function1<? super RotaryScrollEvent, Boolean> onEvent;
    private Function1<? super RotaryScrollEvent, Boolean> onPreEvent;

    public RotaryInputNode(Function1<? super RotaryScrollEvent, Boolean> function1, Function1<? super RotaryScrollEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public boolean onPreRotaryScrollEvent(RotaryScrollEvent event) {
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(event).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public boolean onRotaryScrollEvent(RotaryScrollEvent event) {
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return function1.invoke(event).booleanValue();
        }
        return false;
    }

    public final void setOnEvent(Function1<? super RotaryScrollEvent, Boolean> function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(Function1<? super RotaryScrollEvent, Boolean> function1) {
        this.onPreEvent = function1;
    }
}
