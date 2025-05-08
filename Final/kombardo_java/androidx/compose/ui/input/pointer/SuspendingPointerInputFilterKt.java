package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\b\u0010\u000b\u001a1\u0010\u000e\u001a\u00020\r2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "key1", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "pointerInput", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "pointerInputHandler", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "SuspendingPointerInputModifierNode", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", BuildConfig.FLAVOR, "PointerInputModifierNoParamError", "Ljava/lang/String;", "getPointerInputModifierNoParamError$annotations", "()V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "EmptyPointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SuspendingPointerInputFilterKt {
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(CollectionsKt.emptyList());
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";

    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, null, function2);
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return modifier.then(new SuspendPointerInputElement(obj, null, null, function2, 6, null));
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, Object obj2, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return modifier.then(new SuspendPointerInputElement(obj, obj2, null, function2, 4, null));
    }
}
