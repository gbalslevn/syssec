package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0004\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\b2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0014H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014H\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R/\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "wrappedRegistry", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "parentRegistry", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "restoredValues", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;)V", "value", BuildConfig.FLAVOR, "canBeSaved", "(Ljava/lang/Object;)Z", "key", "consumeRestored", "(Ljava/lang/String;)Ljava/lang/Object;", "Lkotlin/Function0;", "valueProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "registerProvider", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "performSave", "()Ljava/util/Map;", BuildConfig.FLAVOR, "content", "SaveableStateProvider", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "(Ljava/lang/Object;)V", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "<set-?>", "wrappedHolder$delegate", "Landroidx/compose/runtime/MutableState;", "getWrappedHolder", "()Landroidx/compose/runtime/saveable/SaveableStateHolder;", "setWrappedHolder", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "wrappedHolder", BuildConfig.FLAVOR, "previouslyComposedKeys", "Ljava/util/Set;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<Object> previouslyComposedKeys;

    /* renamed from: wrappedHolder$delegate, reason: from kotlin metadata */
    private final MutableState wrappedHolder;
    private final SaveableStateRegistry wrappedRegistry;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u00060\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", BuildConfig.FLAVOR, "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver<LazySaveableStateHolder, Map<String, List<Object>>> saver(final SaveableStateRegistry parentRegistry) {
            return SaverKt.Saver(new Function2<SaverScope, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                public final Map<String, List<Object>> invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder) {
                    Map<String, List<Object>> performSave = lazySaveableStateHolder.performSave();
                    if (performSave.isEmpty()) {
                        return null;
                    }
                    return performSave;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
                    return new LazySaveableStateHolder(SaveableStateRegistry.this, map);
                }
            });
        }

        private Companion() {
        }
    }

    public LazySaveableStateHolder(SaveableStateRegistry saveableStateRegistry) {
        MutableState mutableStateOf$default;
        this.wrappedRegistry = saveableStateRegistry;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.wrappedHolder = mutableStateOf$default;
        this.previouslyComposedKeys = new LinkedHashSet();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void SaveableStateProvider(final Object obj, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-697180401);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(obj) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-697180401, i6, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)");
            }
            SaveableStateHolder wrappedHolder = getWrappedHolder();
            if (wrappedHolder == null) {
                throw new IllegalArgumentException("null wrappedHolder");
            }
            int i7 = i6 & 14;
            wrappedHolder.SaveableStateProvider(obj, function2, startRestartGroup, i6 & 126);
            boolean changedInstance = startRestartGroup.changedInstance(this) | startRestartGroup.changedInstance(obj);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        Set set;
                        set = LazySaveableStateHolder.this.previouslyComposedKeys;
                        set.remove(obj);
                        final LazySaveableStateHolder lazySaveableStateHolder = LazySaveableStateHolder.this;
                        final Object obj2 = obj;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                Set set2;
                                set2 = LazySaveableStateHolder.this.previouslyComposedKeys;
                                set2.add(obj2);
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            EffectsKt.DisposableEffect(obj, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, i7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$3
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

                public final void invoke(Composer composer2, int i8) {
                    LazySaveableStateHolder.this.SaveableStateProvider(obj, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        return this.wrappedRegistry.canBeSaved(value);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        return this.wrappedRegistry.consumeRestored(key);
    }

    public final SaveableStateHolder getWrappedHolder() {
        return (SaveableStateHolder) this.wrappedHolder.getValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder != null) {
            Iterator<T> it = this.previouslyComposedKeys.iterator();
            while (it.hasNext()) {
                wrappedHolder.removeState(it.next());
            }
        }
        return this.wrappedRegistry.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(String key, Function0<? extends Object> valueProvider) {
        return this.wrappedRegistry.registerProvider(key, valueProvider);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void removeState(Object key) {
        SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder == null) {
            throw new IllegalArgumentException("null wrappedHolder");
        }
        wrappedHolder.removeState(key);
    }

    public final void setWrappedHolder(SaveableStateHolder saveableStateHolder) {
        this.wrappedHolder.setValue(saveableStateHolder);
    }

    public LazySaveableStateHolder(final SaveableStateRegistry saveableStateRegistry, Map<String, ? extends List<? extends Object>> map) {
        this(SaveableStateRegistryKt.SaveableStateRegistry(map, new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                SaveableStateRegistry saveableStateRegistry2 = SaveableStateRegistry.this;
                return Boolean.valueOf(saveableStateRegistry2 != null ? saveableStateRegistry2.canBeSaved(obj) : true);
            }
        }));
    }
}
