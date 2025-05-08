package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H ¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0014\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010!\u001a\u00020\u001eH\u0010¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010#\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010%\u001a\u00020\u0007H\u0010¢\u0006\u0004\b$\u0010\u0003J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H ¢\u0006\u0004\b(\u0010)J\u0019\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010'\u001a\u00020&H\u0010¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b/\u0010\rR\u0014\u00104\u001a\u0002018 X \u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058 X \u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u0002058 X \u0004¢\u0006\u0006\u001a\u0004\b9\u00107R\u0014\u0010<\u001a\u0002058 X \u0004¢\u0006\u0006\u001a\u0004\b;\u00107R\u0016\u0010@\u001a\u0004\u0018\u00010=8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Landroidx/compose/runtime/CompositionContext;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitial", "invalidate$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;)V", "invalidate", BuildConfig.FLAVOR, "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime_release", "(Ljava/util/Set;)V", "recordInspectionTable", "Landroidx/compose/runtime/Composer;", "composer", "registerComposer$runtime_release", "(Landroidx/compose/runtime/Composer;)V", "registerComposer", "unregisterComposer$runtime_release", "unregisterComposer", "unregisterComposition$runtime_release", "unregisterComposition", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope$runtime_release", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope", "startComposing$runtime_release", "startComposing", "doneComposing$runtime_release", "doneComposing", "Landroidx/compose/runtime/MovableContentStateReference;", "reference", "insertMovableContent$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "reportRemovedComposition$runtime_release", "reportRemovedComposition", BuildConfig.FLAVOR, "getCompoundHashKey$runtime_release", "()I", "compoundHashKey", BuildConfig.FLAVOR, "getCollectingParameterInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingSourceInformation$runtime_release", "collectingSourceInformation", "getCollectingCallByInformation$runtime_release", "collectingCallByInformation", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectCoroutineContext", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CompositionContext {
    public abstract void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content);

    public void doneComposing$runtime_release() {
    }

    public abstract boolean getCollectingCallByInformation$runtime_release();

    public abstract boolean getCollectingParameterInformation$runtime_release();

    public abstract boolean getCollectingSourceInformation$runtime_release();

    public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.access$getEmptyPersistentCompositionLocalMap$p();
    }

    public abstract int getCompoundHashKey$runtime_release();

    public abstract CoroutineContext getEffectCoroutineContext();

    public CompositionObserverHolder getObserverHolder$runtime_release() {
        return null;
    }

    public abstract void insertMovableContent$runtime_release(MovableContentStateReference reference);

    public abstract void invalidate$runtime_release(ControlledComposition composition);

    public abstract MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference);

    public abstract void recordInspectionTable$runtime_release(Set<CompositionData> table);

    public void registerComposer$runtime_release(Composer composer) {
    }

    public abstract void reportRemovedComposition$runtime_release(ControlledComposition composition);

    public void startComposing$runtime_release() {
    }

    public void unregisterComposer$runtime_release(Composer composer) {
    }

    public abstract void unregisterComposition$runtime_release(ControlledComposition composition);
}
