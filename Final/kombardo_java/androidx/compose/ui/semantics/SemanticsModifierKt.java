package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a/\u0010\n\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {BuildConfig.FLAVOR, "generateSemanticsId", "()I", "Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "mergeDescendants", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", BuildConfig.FLAVOR, "properties", "semantics", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "clearAndSetSemantics", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SemanticsModifierKt {
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);

    public static final Modifier clearAndSetSemantics(Modifier modifier, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        return modifier.then(new ClearAndSetSemanticsElement(function1));
    }

    public static final int generateSemanticsId() {
        return lastIdentifier.addAndGet(1);
    }

    public static final Modifier semantics(Modifier modifier, boolean z5, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        return modifier.then(new AppendedSemanticsElement(z5, function1));
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return semantics(modifier, z5, function1);
    }
}
