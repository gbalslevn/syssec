package com.ramcosta.composedestinations.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.result.NavResult;
import com.ramcosta.composedestinations.result.ResultRecipientImpl;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0004\b\u0001\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0005B-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00120\u0014H\u0017¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a²\u0006\"\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0015\u0012\u0004\u0012\u00020\u00120\u0014\"\u0004\b\u0000\u0010\u0004X\u008a\u0084\u0002"}, d2 = {"Lcom/ramcosta/composedestinations/result/ResultRecipientImpl;", "D", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "R", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "resultOriginType", "Lkotlin/reflect/KClass;", "resultNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "<init>", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/reflect/KClass;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;)V", "resultKey", BuildConfig.FLAVOR, "canceledKey", "onNavResult", BuildConfig.FLAVOR, "listener", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/result/NavResult;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "handleResultIfPresent", "hasAnyResult", BuildConfig.FLAVOR, "compose-destinations_release", "currentListener"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResultRecipientImpl<D extends TypedDestinationSpec<?>, R> implements ResultRecipient<D, R> {
    private final String canceledKey;
    private final NavBackStackEntry navBackStackEntry;
    private final String resultKey;
    private final DestinationsNavType<? super R> resultNavType;

    public ResultRecipientImpl(NavBackStackEntry navBackStackEntry, KClass<D> resultOriginType, DestinationsNavType<? super R> resultNavType) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        this.navBackStackEntry = navBackStackEntry;
        this.resultNavType = resultNavType;
        this.resultKey = ResultCommonsKt.resultKey(resultOriginType, resultNavType);
        this.canceledKey = ResultCommonsKt.canceledKey(resultOriginType, resultNavType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResultIfPresent(Function1<? super NavResult<? extends R>, Unit> listener) {
        if (hasAnyResult()) {
            if (Intrinsics.areEqual((Boolean) this.navBackStackEntry.getSavedStateHandle().remove(this.canceledKey), Boolean.TRUE)) {
                listener.invoke(NavResult.Canceled.INSTANCE);
            } else if (this.navBackStackEntry.getSavedStateHandle().contains(this.resultKey)) {
                R r5 = this.resultNavType.get(this.navBackStackEntry.getSavedStateHandle(), this.resultKey);
                this.navBackStackEntry.getSavedStateHandle().remove(this.resultKey);
                listener.invoke(new NavResult.Value(r5));
            }
        }
    }

    private final boolean hasAnyResult() {
        return this.navBackStackEntry.getSavedStateHandle().contains(this.canceledKey) || this.navBackStackEntry.getSavedStateHandle().contains(this.resultKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Function1<NavResult<? extends R>, Unit> onNavResult$lambda$0(State<? extends Function1<? super NavResult<? extends R>, Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.LifecycleObserver, com.ramcosta.composedestinations.result.ResultRecipientImpl$onNavResult$1$1$observer$1] */
    public static final DisposableEffectResult onNavResult$lambda$3$lambda$2(final ResultRecipientImpl resultRecipientImpl, final State state, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final ?? r32 = new LifecycleEventObserver(resultRecipientImpl) { // from class: com.ramcosta.composedestinations.result.ResultRecipientImpl$onNavResult$1$1$observer$1
            final /* synthetic */ ResultRecipientImpl<D, R> this$0;

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.this$0 = resultRecipientImpl;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Function1 onNavResult$lambda$0;
                NavBackStackEntry navBackStackEntry;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i5 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i5 == 1 || i5 == 2) {
                    ResultRecipientImpl<D, R> resultRecipientImpl2 = this.this$0;
                    onNavResult$lambda$0 = ResultRecipientImpl.onNavResult$lambda$0(state);
                    resultRecipientImpl2.handleResultIfPresent(onNavResult$lambda$0);
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    navBackStackEntry = ((ResultRecipientImpl) this.this$0).navBackStackEntry;
                    navBackStackEntry.getLifecycle().removeObserver(this);
                }
            }
        };
        resultRecipientImpl.navBackStackEntry.getLifecycle().addObserver(r32);
        return new DisposableEffectResult() { // from class: com.ramcosta.composedestinations.result.ResultRecipientImpl$onNavResult$lambda$3$lambda$2$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavBackStackEntry navBackStackEntry;
                navBackStackEntry = ResultRecipientImpl.this.navBackStackEntry;
                navBackStackEntry.getLifecycle().removeObserver(r32);
            }
        };
    }

    @Override // com.ramcosta.composedestinations.result.OpenResultRecipient
    public void onNavResult(Function1<? super NavResult<? extends R>, Unit> listener, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        composer.startReplaceGroup(-1758693843);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1758693843, i5, -1, "com.ramcosta.composedestinations.result.ResultRecipientImpl.onNavResult (ResultRecipientImpl.kt:28)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(listener, composer, i5 & 14);
        NavBackStackEntry navBackStackEntry = this.navBackStackEntry;
        composer.startReplaceGroup(703650838);
        boolean changed = ((((i5 & 112) ^ 48) > 32 && composer.changed(this)) || (i5 & 48) == 32) | composer.changed(rememberUpdatedState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: h1.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult onNavResult$lambda$3$lambda$2;
                    onNavResult$lambda$3$lambda$2 = ResultRecipientImpl.onNavResult$lambda$3$lambda$2(ResultRecipientImpl.this, rememberUpdatedState, (DisposableEffectScope) obj);
                    return onNavResult$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(navBackStackEntry, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
