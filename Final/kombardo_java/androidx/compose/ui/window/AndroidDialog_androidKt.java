package androidx.compose.ui.window;

import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r²\u0006\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismissRequest", "Landroidx/compose/ui/window/DialogProperties;", "properties", "content", "Dialog", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "DialogLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "currentContent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Dialog(final Function0<Unit> function0, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        DialogProperties dialogProperties2;
        boolean changed;
        int i8;
        DialogProperties dialogProperties3;
        int i9;
        Object obj;
        Composer composer2;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        final DialogProperties dialogProperties4;
        final DialogProperties dialogProperties5;
        Composer composer3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2032877254);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            dialogProperties2 = dialogProperties;
            i7 |= startRestartGroup.changed(dialogProperties2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                if (i10 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2032877254, i7, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
                }
                View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                final LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 6) & 14);
                UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1
                    @Override // kotlin.jvm.functions.Function0
                    public final UUID invoke() {
                        return UUID.randomUUID();
                    }
                }, startRestartGroup, 3072, 6);
                changed = startRestartGroup.changed(view) | startRestartGroup.changed(density);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    i8 = i7;
                    dialogProperties3 = dialogProperties2;
                    i9 = 4;
                    Composer composer4 = startRestartGroup;
                    DialogWrapper dialogWrapper = new DialogWrapper(function0, dialogProperties2, view, layoutDirection, density, uuid);
                    dialogWrapper.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i11) {
                            if ((i11 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(488261145, i11, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                            }
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
                                }
                            }, 1, null);
                            final State<Function2<Composer, Integer, Unit>> state = rememberUpdatedState;
                            AndroidDialog_androidKt.DialogLayout(semantics$default, ComposableLambdaKt.rememberComposableLambda(-533674951, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer6, int i12) {
                                    Function2 Dialog$lambda$0;
                                    if ((i12 & 3) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-533674951, i12, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                    }
                                    Dialog$lambda$0 = AndroidDialog_androidKt.Dialog$lambda$0(state);
                                    Dialog$lambda$0.invoke(composer6, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer5, 54), composer5, 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    composer4.updateRememberedValue(dialogWrapper);
                    composer2 = composer4;
                    obj = dialogWrapper;
                } else {
                    i8 = i7;
                    dialogProperties3 = dialogProperties2;
                    i9 = 4;
                    composer2 = startRestartGroup;
                    obj = rememberedValue3;
                }
                final DialogWrapper dialogWrapper2 = (DialogWrapper) obj;
                changedInstance = composer2.changedInstance(dialogWrapper2);
                rememberedValue = composer2.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            DialogWrapper.this.show();
                            final DialogWrapper dialogWrapper3 = DialogWrapper.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    DialogWrapper.this.dismiss();
                                    DialogWrapper.this.disposeComposition();
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                EffectsKt.DisposableEffect(dialogWrapper2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, composer2, 0);
                changedInstance2 = composer2.changedInstance(dialogWrapper2) | ((i8 & 14) != i9) | ((i8 & 112) == 32) | composer2.changed(layoutDirection);
                rememberedValue2 = composer2.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    dialogProperties4 = dialogProperties3;
                    rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            DialogWrapper.this.updateParameters(function0, dialogProperties4, layoutDirection);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                } else {
                    dialogProperties4 = dialogProperties3;
                }
                EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties5 = dialogProperties4;
                composer3 = composer2;
            } else {
                startRestartGroup.skipToGroupEnd();
                dialogProperties5 = dialogProperties2;
                composer3 = startRestartGroup;
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                        invoke(composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i11) {
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties5, function2, composer5, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        dialogProperties2 = dialogProperties;
        if ((i6 & 4) == 0) {
        }
        if ((i7 & 147) == 146) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        View view2 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        final LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        CompositionContext rememberCompositionContext2 = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
        final State<? extends Function2<? super Composer, ? super Integer, Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 6) & 14);
        UUID uuid2 = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1
            @Override // kotlin.jvm.functions.Function0
            public final UUID invoke() {
                return UUID.randomUUID();
            }
        }, startRestartGroup, 3072, 6);
        changed = startRestartGroup.changed(view2) | startRestartGroup.changed(density2);
        Object rememberedValue32 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        i8 = i7;
        dialogProperties3 = dialogProperties2;
        i9 = 4;
        Composer composer42 = startRestartGroup;
        DialogWrapper dialogWrapper3 = new DialogWrapper(function0, dialogProperties2, view2, layoutDirection2, density2, uuid2);
        dialogWrapper3.setContent(rememberCompositionContext2, ComposableLambdaKt.composableLambdaInstance(488261145, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                invoke(composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer5, int i11) {
                if ((i11 & 3) == 2 && composer5.getSkipping()) {
                    composer5.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(488261145, i11, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                }
                Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
                    }
                }, 1, null);
                final State<? extends Function2<? super Composer, ? super Integer, Unit>> state = rememberUpdatedState2;
                AndroidDialog_androidKt.DialogLayout(semantics$default, ComposableLambdaKt.rememberComposableLambda(-533674951, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                        invoke(composer6, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer6, int i12) {
                        Function2 Dialog$lambda$0;
                        if ((i12 & 3) == 2 && composer6.getSkipping()) {
                            composer6.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-533674951, i12, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                        }
                        Dialog$lambda$0 = AndroidDialog_androidKt.Dialog$lambda$0(state);
                        Dialog$lambda$0.invoke(composer6, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer5, 54), composer5, 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        composer42.updateRememberedValue(dialogWrapper3);
        composer2 = composer42;
        obj = dialogWrapper3;
        final DialogWrapper dialogWrapper22 = (DialogWrapper) obj;
        changedInstance = composer2.changedInstance(dialogWrapper22);
        rememberedValue = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DialogWrapper.this.show();
                final DialogWrapper dialogWrapper32 = DialogWrapper.this;
                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        DialogWrapper.this.dismiss();
                        DialogWrapper.this.disposeComposition();
                    }
                };
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        EffectsKt.DisposableEffect(dialogWrapper22, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, composer2, 0);
        changedInstance2 = composer2.changedInstance(dialogWrapper22) | ((i8 & 14) != i9) | ((i8 & 112) == 32) | composer2.changed(layoutDirection2);
        rememberedValue2 = composer2.rememberedValue();
        if (changedInstance2) {
        }
        dialogProperties4 = dialogProperties3;
        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DialogWrapper.this.updateParameters(function0, dialogProperties4, layoutDirection2);
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        dialogProperties5 = dialogProperties4;
        composer3 = composer2;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1177876616);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177876616, i7, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
            }
            AndroidDialog_androidKt$DialogLayout$1 androidDialog_androidKt$DialogLayout$1 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r13v14, types: [java.lang.Object] */
                /* JADX WARN: Type inference failed for: r13v15 */
                /* JADX WARN: Type inference failed for: r13v17 */
                /* JADX WARN: Type inference failed for: r13v18 */
                /* JADX WARN: Type inference failed for: r13v23 */
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    Object obj;
                    final ArrayList arrayList = new ArrayList(list.size());
                    int size = list.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        arrayList.add(list.get(i9).mo1946measureBRTryo0(j5));
                    }
                    Placeable placeable = null;
                    int i10 = 1;
                    if (arrayList.isEmpty()) {
                        obj = null;
                    } else {
                        obj = arrayList.get(0);
                        int width = ((Placeable) obj).getWidth();
                        int lastIndex = CollectionsKt.getLastIndex(arrayList);
                        if (1 <= lastIndex) {
                            int i11 = 1;
                            while (true) {
                                Object obj2 = arrayList.get(i11);
                                int width2 = ((Placeable) obj2).getWidth();
                                if (width < width2) {
                                    obj = obj2;
                                    width = width2;
                                }
                                if (i11 == lastIndex) {
                                    break;
                                }
                                i11++;
                            }
                        }
                    }
                    Placeable placeable2 = (Placeable) obj;
                    int width3 = placeable2 != null ? placeable2.getWidth() : Constraints.m2580getMinWidthimpl(j5);
                    if (!arrayList.isEmpty()) {
                        ?? r13 = arrayList.get(0);
                        int height = ((Placeable) r13).getHeight();
                        int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
                        boolean z5 = r13;
                        if (1 <= lastIndex2) {
                            while (true) {
                                Object obj3 = arrayList.get(i10);
                                int height2 = ((Placeable) obj3).getHeight();
                                r13 = z5;
                                if (height < height2) {
                                    r13 = obj3;
                                    height = height2;
                                }
                                if (i10 == lastIndex2) {
                                    break;
                                }
                                i10++;
                                z5 = r13;
                            }
                        }
                        placeable = r13;
                    }
                    Placeable placeable3 = placeable;
                    return MeasureScope.layout$default(measureScope, width3, placeable3 != null ? placeable3.getHeight() : Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                            List<Placeable> list2 = arrayList;
                            int size2 = list2.size();
                            for (int i12 = 0; i12 < size2; i12++) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i12), 0, 0, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            int i9 = ((i7 >> 3) & 14) | 384 | ((i7 << 3) & 112);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            int i10 = ((i9 << 6) & 896) | 6;
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, androidDialog_androidKt$DialogLayout$1, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 6) & 14));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2
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

                public final void invoke(Composer composer2, int i11) {
                    AndroidDialog_androidKt.DialogLayout(Modifier.this, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }
}
