package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\"\u0010!\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R4\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000b0'8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0004\b)\u0010*\u0012\u0004\b/\u0010\u0003\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R4\u00100\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000b0'8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0004\b0\u0010*\u0012\u0004\b3\u0010\u0003\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.¨\u00064"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "()V", BuildConfig.FLAVOR, "canFocus", "Z", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "Landroidx/compose/ui/focus/FocusRequester;", "next", "Landroidx/compose/ui/focus/FocusRequester;", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", "down", "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "Lkotlin/jvm/functions/Function1;", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "getEnter$annotations", "exit", "getExit", "setExit", "getExit$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusPropertiesImpl implements FocusProperties {
    private boolean canFocus = true;
    private FocusRequester down;
    private FocusRequester end;
    private Function1<? super FocusDirection, FocusRequester> enter;
    private Function1<? super FocusDirection, FocusRequester> exit;
    private FocusRequester left;
    private FocusRequester next;
    private FocusRequester previous;
    private FocusRequester right;
    private FocusRequester start;
    private FocusRequester up;

    public FocusPropertiesImpl() {
        FocusRequester.Companion companion = FocusRequester.INSTANCE;
        this.next = companion.getDefault();
        this.previous = companion.getDefault();
        this.up = companion.getDefault();
        this.down = companion.getDefault();
        this.left = companion.getDefault();
        this.right = companion.getDefault();
        this.start = companion.getDefault();
        this.end = companion.getDefault();
        this.enter = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1300invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1300invoke3ESFkO8(int i5) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
        this.exit = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1301invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1301invoke3ESFkO8(int i5) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getDown() {
        return this.down;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getEnd() {
        return this.end;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1<FocusDirection, FocusRequester> getEnter() {
        return this.enter;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1<FocusDirection, FocusRequester> getExit() {
        return this.exit;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getNext() {
        return this.next;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getPrevious() {
        return this.previous;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getUp() {
        return this.up;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean z5) {
        this.canFocus = z5;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setEnter(Function1<? super FocusDirection, FocusRequester> function1) {
        this.enter = function1;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setExit(Function1<? super FocusDirection, FocusRequester> function1) {
        this.exit = function1;
    }
}
