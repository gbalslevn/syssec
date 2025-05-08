package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH&ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH&ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\fH&¢\u0006\u0004\b+\u0010,J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020-H&¢\u0006\u0004\b+\u0010.J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020/H&¢\u0006\u0004\b+\u00100R\u0014\u00104\u001a\u0002018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006=À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/focus/FocusManager;", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", BuildConfig.FLAVOR, "requestFocusForOwner-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "requestFocusForOwner", "focusedRect", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "focusSearch", BuildConfig.FLAVOR, "releaseFocus", "()V", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "clearFocus", "getFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "Lkotlin/Function0;", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchKeyEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchInterceptedSoftKeyboardEvent", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "event", "dispatchRotaryEvent", "(Landroidx/compose/ui/input/rotary/RotaryScrollEvent;)Z", "node", "scheduleInvalidation", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "(Landroidx/compose/ui/focus/FocusEventModifierNode;)V", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)V", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "rootState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusOwner extends FocusManager {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: dispatchKeyEvent-YhN2O0w$default */
    static /* synthetic */ boolean m1289dispatchKeyEventYhN2O0w$default(FocusOwner focusOwner, KeyEvent keyEvent, Function0 function0, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i5 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.mo1292dispatchKeyEventYhN2O0w(keyEvent, function0);
    }

    /* renamed from: clearFocus-I7lrPNg */
    boolean mo1290clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection);

    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    boolean mo1291dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent);

    /* renamed from: dispatchKeyEvent-YhN2O0w */
    boolean mo1292dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem);

    boolean dispatchRotaryEvent(RotaryScrollEvent event);

    /* renamed from: focusSearch-ULY8qGw */
    Boolean mo1293focusSearchULY8qGw(int focusDirection, Rect focusedRect, Function1<? super FocusTargetNode, Boolean> onFound);

    Rect getFocusRect();

    FocusTransactionManager getFocusTransactionManager();

    Modifier getModifier();

    FocusState getRootState();

    void releaseFocus();

    /* renamed from: requestFocusForOwner-7o62pno */
    boolean mo1294requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect);

    void scheduleInvalidation(FocusEventModifierNode node);

    void scheduleInvalidation(FocusPropertiesModifierNode node);

    void scheduleInvalidation(FocusTargetNode node);
}
