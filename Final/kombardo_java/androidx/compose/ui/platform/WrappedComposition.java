package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", BuildConfig.FLAVOR, "Landroidx/compose/ui/platform/AndroidComposeView;", "owner", "original", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "dispose", "()V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroidx/compose/runtime/Composition;", "getOriginal", "()Landroidx/compose/runtime/Composition;", BuildConfig.FLAVOR, "disposed", "Z", "Landroidx/lifecycle/Lifecycle;", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "lastContent", "Lkotlin/jvm/functions/Function2;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WrappedComposition implements Composition, LifecycleEventObserver {
    private Lifecycle addedToLifecycle;
    private boolean disposed;
    private Function2<? super Composer, ? super Integer, Unit> lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m2122getLambda1$ui_release();
    private final Composition original;
    private final AndroidComposeView owner;

    public WrappedComposition(AndroidComposeView androidComposeView, Composition composition) {
        this.owner = androidComposeView;
        this.original = composition;
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R$id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    public final Composition getOriginal() {
        return this.original;
    }

    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(final Function2<? super Composer, ? super Integer, Unit> content) {
        this.owner.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.ViewTreeOwners, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                invoke2(viewTreeOwners);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                boolean z5;
                Lifecycle lifecycle;
                z5 = WrappedComposition.this.disposed;
                if (z5) {
                    return;
                }
                Lifecycle lifecycle2 = viewTreeOwners.getLifecycleOwner().getLifecycle();
                WrappedComposition.this.lastContent = content;
                lifecycle = WrappedComposition.this.addedToLifecycle;
                if (lifecycle == null) {
                    WrappedComposition.this.addedToLifecycle = lifecycle2;
                    lifecycle2.addObserver(WrappedComposition.this);
                } else if (lifecycle2.getState().isAtLeast(Lifecycle.State.CREATED)) {
                    Composition original = WrappedComposition.this.getOriginal();
                    final WrappedComposition wrappedComposition = WrappedComposition.this;
                    final Function2<Composer, Integer, Unit> function2 = content;
                    original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i5) {
                            if ((i5 & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2000640158, i5, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            AndroidComposeView owner = WrappedComposition.this.getOwner();
                            int i6 = R$id.inspection_slot_table_set;
                            Object tag = owner.getTag(i6);
                            Set<CompositionData> set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = WrappedComposition.this.getOwner().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(i6) : null;
                                set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.getCompositionData());
                                composer.collectParameterInformation();
                            }
                            AndroidComposeView owner2 = WrappedComposition.this.getOwner();
                            boolean changedInstance = composer.changedInstance(WrappedComposition.this);
                            WrappedComposition wrappedComposition2 = WrappedComposition.this;
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new WrappedComposition$setContent$1$1$1$1(wrappedComposition2, null);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            EffectsKt.LaunchedEffect(owner2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer, 0);
                            AndroidComposeView owner3 = WrappedComposition.this.getOwner();
                            boolean changedInstance2 = composer.changedInstance(WrappedComposition.this);
                            WrappedComposition wrappedComposition3 = WrappedComposition.this;
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition3, null);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            EffectsKt.LaunchedEffect(owner3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 0);
                            ProvidedValue<Set<CompositionData>> provides = InspectionTablesKt.getLocalInspectionTables().provides(set);
                            final WrappedComposition wrappedComposition4 = WrappedComposition.this;
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1193460702, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.3
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

                                public final void invoke(Composer composer2, int i7) {
                                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1193460702, i7, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:154)");
                                    }
                                    AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(WrappedComposition.this.getOwner(), function22, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer, 54), composer, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }
        });
    }
}
