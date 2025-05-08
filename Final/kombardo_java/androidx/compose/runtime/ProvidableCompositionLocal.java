package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H ¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0004\b\u000f\u0010\rJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0004\b\u0010\u0010\rJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "Lkotlin/Function0;", "defaultFactory", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/runtime/ProvidedValue;", "value", "Landroidx/compose/runtime/ValueHolder;", "valueHolderOf", "(Landroidx/compose/runtime/ProvidedValue;)Landroidx/compose/runtime/ValueHolder;", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "defaultProvidedValue", "provides", "providesDefault", "previous", "updatedStateOf$runtime_release", "(Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/ValueHolder;)Landroidx/compose/runtime/ValueHolder;", "updatedStateOf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public ProvidableCompositionLocal(Function0<? extends T> function0) {
        super(function0, null);
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> value) {
        if (!value.getIsDynamic()) {
            return value.getCompute$runtime_release() != null ? new ComputedValueHolder(value.getCompute$runtime_release()) : value.getState$runtime_release() != null ? new DynamicValueHolder(value.getState$runtime_release()) : new StaticValueHolder(value.getEffectiveValue$runtime_release());
        }
        MutableState<T> state$runtime_release = value.getState$runtime_release();
        if (state$runtime_release == null) {
            T value2 = value.getValue();
            SnapshotMutationPolicy<T> mutationPolicy$runtime_release = value.getMutationPolicy$runtime_release();
            if (mutationPolicy$runtime_release == null) {
                mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
            }
            state$runtime_release = SnapshotStateKt.mutableStateOf(value2, mutationPolicy$runtime_release);
        }
        return new DynamicValueHolder(state$runtime_release);
    }

    public abstract ProvidedValue<T> defaultProvidedValue$runtime_release(T value);

    public final ProvidedValue<T> provides(T value) {
        return defaultProvidedValue$runtime_release(value);
    }

    public final ProvidedValue<T> providesDefault(T value) {
        return defaultProvidedValue$runtime_release(value).ifNotAlreadyProvided$runtime_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r0 == r2) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.CompositionLocal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ValueHolder<T> updatedStateOf$runtime_release(ProvidedValue<T> value, ValueHolder<T> previous) {
        DynamicValueHolder dynamicValueHolder;
        DynamicValueHolder dynamicValueHolder2 = null;
        if (previous instanceof DynamicValueHolder) {
            if (value.getIsDynamic()) {
                dynamicValueHolder2 = (DynamicValueHolder) previous;
                dynamicValueHolder2.getState().setValue(value.getEffectiveValue$runtime_release());
            }
        } else if (previous instanceof StaticValueHolder) {
            if (value.isStatic$runtime_release()) {
                StaticValueHolder staticValueHolder = (StaticValueHolder) previous;
                boolean areEqual = Intrinsics.areEqual(value.getEffectiveValue$runtime_release(), staticValueHolder.getValue());
                dynamicValueHolder = staticValueHolder;
            }
        } else if (previous instanceof ComputedValueHolder) {
            Function1<CompositionLocalAccessorScope, T> compute$runtime_release = value.getCompute$runtime_release();
            ComputedValueHolder computedValueHolder = (ComputedValueHolder) previous;
            Function1<CompositionLocalAccessorScope, T> compute = computedValueHolder.getCompute();
            dynamicValueHolder = computedValueHolder;
        }
        return dynamicValueHolder2 == null ? valueHolderOf(value) : dynamicValueHolder2;
    }
}
