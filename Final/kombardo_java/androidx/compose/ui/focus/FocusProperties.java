package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR$\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR$\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rRB\u0010,\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0$2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0$8W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)RB\u00100\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0$2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0$8W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b/\u0010+\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocus", "Landroidx/compose/ui/focus/FocusRequester;", "<anonymous parameter 0>", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "next", "getPrevious", "setPrevious", "previous", "getUp", "setUp", "up", "getDown", "setDown", "down", "getLeft", "setLeft", "left", "getRight", "setRight", "right", "getStart", "setStart", "start", "getEnd", "setEnd", "end", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "getEnter$annotations", "()V", "enter", "getExit", "setExit", "getExit$annotations", "exit", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusProperties {
    boolean getCanFocus();

    default FocusRequester getDown() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default Function1<FocusDirection, FocusRequester> getEnter() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1298invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1298invoke3ESFkO8(int i5) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    default Function1<FocusDirection, FocusRequester> getExit() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1299invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1299invoke3ESFkO8(int i5) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    default FocusRequester getLeft() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getNext() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getPrevious() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.INSTANCE.getDefault();
    }

    void setCanFocus(boolean z5);

    default void setEnter(Function1<? super FocusDirection, FocusRequester> function1) {
    }

    default void setExit(Function1<? super FocusDirection, FocusRequester> function1) {
    }
}
