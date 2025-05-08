package com.ramcosta.composedestinations.result;

import android.annotation.SuppressLint;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.result.ResultBackNavigatorImpl;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u00030\u0007j\u0002`\b0\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\r\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ramcosta/composedestinations/result/ResultBackNavigatorImpl;", "R", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "navController", "Landroidx/navigation/NavController;", "resultOriginType", "Lkotlin/reflect/KClass;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "resultNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "<init>", "(Landroidx/navigation/NavController;Lkotlin/reflect/KClass;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;)V", "resultKey", BuildConfig.FLAVOR, "canceledKey", "navigateBack", BuildConfig.FLAVOR, "result", "(Ljava/lang/Object;)V", "setResult", "handleCanceled", "(Landroidx/compose/runtime/Composer;I)V", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResultBackNavigatorImpl<R> implements ResultBackNavigator<R> {
    private final String canceledKey;
    private final NavController navController;
    private final String resultKey;
    private final DestinationsNavType<? super R> resultNavType;

    public ResultBackNavigatorImpl(NavController navController, KClass<? extends TypedDestinationSpec<?>> resultOriginType, DestinationsNavType<? super R> resultNavType) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        this.navController = navController;
        this.resultNavType = resultNavType;
        this.resultKey = ResultCommonsKt.resultKey(resultOriginType, resultNavType);
        this.canceledKey = ResultCommonsKt.canceledKey(resultOriginType, resultNavType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleCanceled$lambda$2(ResultBackNavigatorImpl resultBackNavigatorImpl, int i5, Composer composer, int i6) {
        resultBackNavigatorImpl.handleCanceled(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.ramcosta.composedestinations.result.ResultBackNavigatorImpl$handleCanceled$1$1$observer$1, androidx.lifecycle.LifecycleObserver] */
    public static final DisposableEffectResult handleCanceled$lambda$5$lambda$4(final NavBackStackEntry navBackStackEntry, final ResultBackNavigatorImpl resultBackNavigatorImpl, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final ?? r32 = new LifecycleEventObserver(resultBackNavigatorImpl) { // from class: com.ramcosta.composedestinations.result.ResultBackNavigatorImpl$handleCanceled$1$1$observer$1
            final /* synthetic */ ResultBackNavigatorImpl<R> this$0;

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = resultBackNavigatorImpl;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                NavController navController;
                SavedStateHandle savedStateHandle;
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 1) {
                    navController = ((ResultBackNavigatorImpl) this.this$0).navController;
                    NavBackStackEntry previousBackStackEntry = navController.getPreviousBackStackEntry();
                    if (previousBackStackEntry == null || (savedStateHandle = previousBackStackEntry.getSavedStateHandle()) == null) {
                        return;
                    }
                    str = ((ResultBackNavigatorImpl) this.this$0).canceledKey;
                    if (savedStateHandle.contains(str)) {
                        return;
                    }
                    str2 = ((ResultBackNavigatorImpl) this.this$0).canceledKey;
                    savedStateHandle.set(str2, Boolean.TRUE);
                    navBackStackEntry.getLifecycle().removeObserver(this);
                }
            }
        };
        navBackStackEntry.getLifecycle().addObserver(r32);
        return new DisposableEffectResult() { // from class: com.ramcosta.composedestinations.result.ResultBackNavigatorImpl$handleCanceled$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavBackStackEntry.this.getLifecycle().removeObserver(r32);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleCanceled$lambda$6(ResultBackNavigatorImpl resultBackNavigatorImpl, int i5, Composer composer, int i6) {
        resultBackNavigatorImpl.handleCanceled(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    @SuppressLint({"ComposableNaming"})
    public final void handleCanceled(Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(17126424);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(this) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(17126424, i6, -1, "com.ramcosta.composedestinations.result.ResultBackNavigatorImpl.handleCanceled (ResultBackNavigatorImpl.kt:41)");
            }
            startRestartGroup.startReplaceGroup(852389723);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = this.navController.getCurrentBackStackEntry();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (navBackStackEntry == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: h1.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit handleCanceled$lambda$2;
                            handleCanceled$lambda$2 = ResultBackNavigatorImpl.handleCanceled$lambda$2(ResultBackNavigatorImpl.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return handleCanceled$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(852393985);
            boolean changedInstance = ((i6 & 14) == 4) | startRestartGroup.changedInstance(navBackStackEntry);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h1.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult handleCanceled$lambda$5$lambda$4;
                        handleCanceled$lambda$5$lambda$4 = ResultBackNavigatorImpl.handleCanceled$lambda$5$lambda$4(NavBackStackEntry.this, this, (DisposableEffectScope) obj);
                        return handleCanceled$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: h1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit handleCanceled$lambda$6;
                    handleCanceled$lambda$6 = ResultBackNavigatorImpl.handleCanceled$lambda$6(ResultBackNavigatorImpl.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return handleCanceled$lambda$6;
                }
            });
        }
    }

    @Override // com.ramcosta.composedestinations.result.ResultBackNavigator
    public void navigateBack(R result) {
        setResult(result);
        navigateBack();
    }

    public void setResult(R result) {
        SavedStateHandle savedStateHandle;
        NavBackStackEntry previousBackStackEntry = this.navController.getPreviousBackStackEntry();
        if (previousBackStackEntry == null || (savedStateHandle = previousBackStackEntry.getSavedStateHandle()) == null) {
            return;
        }
        savedStateHandle.set(this.canceledKey, Boolean.FALSE);
        this.resultNavType.put(savedStateHandle, this.resultKey, (String) result);
    }

    @Override // com.ramcosta.composedestinations.result.ResultBackNavigator
    public void navigateBack() {
        this.navController.navigateUp();
    }
}
