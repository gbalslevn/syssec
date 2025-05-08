package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00028\u0000H\u0010¢\u0006\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/ComputedProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "defaultComputation", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "value", "Landroidx/compose/runtime/ProvidedValue;", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "defaultProvidedValue", "Landroidx/compose/runtime/ComputedValueHolder;", "defaultValueHolder", "Landroidx/compose/runtime/ComputedValueHolder;", "getDefaultValueHolder$runtime_release", "()Landroidx/compose/runtime/ComputedValueHolder;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComputedProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    private final ComputedValueHolder<T> defaultValueHolder;

    public ComputedProvidableCompositionLocal(Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        super(new Function0<T>() { // from class: androidx.compose.runtime.ComputedProvidableCompositionLocal.1
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                ComposerKt.composeRuntimeError("Unexpected call to default provider");
                throw new KotlinNothingValueException();
            }
        });
        this.defaultValueHolder = new ComputedValueHolder<>(function1);
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public ProvidedValue<T> defaultProvidedValue$runtime_release(T value) {
        return new ProvidedValue<>(this, value, value == null, null, null, null, true);
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public ComputedValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }
}
