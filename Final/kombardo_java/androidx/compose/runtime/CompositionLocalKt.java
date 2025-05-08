package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\r\u0010\u000e\u001a9\u0010\u0014\u001a\u00020\u00122\u001a\u0010\u0011\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f\"\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0014\u001a\u00020\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0017¨\u0006\u0018"}, d2 = {"T", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "policy", "Lkotlin/Function0;", "defaultFactory", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "compositionLocalOf", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "staticCompositionLocalOf", "(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "defaultComputation", "compositionLocalWithComputedDefaultOf", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/ProvidableCompositionLocal;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ProvidedValue;", "values", BuildConfig.FLAVOR, "content", "CompositionLocalProvider", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "value", "(Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CompositionLocalKt {
    public static final void CompositionLocalProvider(final ProvidedValue<?>[] providedValueArr, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-1390796515);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1390796515, i5, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:377)");
        }
        startRestartGroup.startProviders(providedValueArr);
        function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
        startRestartGroup.endProviders();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ProvidedValue<?>[] providedValueArr2 = providedValueArr;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) Arrays.copyOf(providedValueArr2, providedValueArr2.length), function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, Function0<? extends T> function0) {
        return new DynamicProvidableCompositionLocal(snapshotMutationPolicy, function0);
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return compositionLocalOf(snapshotMutationPolicy, function0);
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalWithComputedDefaultOf(Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        return new ComputedProvidableCompositionLocal(function1);
    }

    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(Function0<? extends T> function0) {
        return new StaticProvidableCompositionLocal(function0);
    }

    public static final void CompositionLocalProvider(final ProvidedValue<?> providedValue, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-1350970552);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1350970552, i5, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:398)");
        }
        startRestartGroup.startProvider(providedValue);
        function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
        startRestartGroup.endProvider();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    CompositionLocalKt.CompositionLocalProvider(providedValue, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }
}
