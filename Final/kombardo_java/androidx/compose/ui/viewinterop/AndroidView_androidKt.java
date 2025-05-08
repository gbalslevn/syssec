package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aM\u0010\t\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a{\u0010\t\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00022\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\t\u0010\r\u001a3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a^\u0010!\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010$\"#\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroid/view/View;", "T", "Lkotlin/Function1;", "Landroid/content/Context;", "factory", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "update", "AndroidView", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "onReset", "onRelease", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "createAndroidViewNodeFactory", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "Landroidx/compose/runtime/Updater;", BuildConfig.FLAVOR, "compositeKeyHash", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "updateViewHolderParams", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "requireViewFactoryHolder", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "NoOpUpdate", "Lkotlin/jvm/functions/Function1;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }
    };

    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1783766393);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i9 != 0) {
                function12 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i7, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:107)");
            }
            AndroidView(function1, modifier, null, NoOpUpdate, function12, startRestartGroup, (i7 & 14) | 3072 | (i7 & 112) | ((i7 << 6) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final Function1<? super T, Unit> function13 = function12;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
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

                public final void invoke(Composer composer2, int i10) {
                    AndroidView_androidKt.AndroidView(function1, modifier2, function13, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(final Function1<? super Context, ? extends T> function1, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i5, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:266)");
        }
        final int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        final CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        final View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean changedInstance = composer.changedInstance(context) | ((((i5 & 14) ^ 6) > 4 && composer.changed(function1)) || (i5 & 6) == 4) | composer.changedInstance(rememberCompositionContext) | composer.changedInstance(saveableStateRegistry) | composer.changed(currentCompositeKeyHash) | composer.changedInstance(view);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    Context context2 = context;
                    Function1<Context, T> function12 = function1;
                    CompositionContext compositionContext = rememberCompositionContext;
                    SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    int i6 = currentCompositeKeyHash;
                    KeyEvent.Callback callback = view;
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                    return new ViewFactoryHolder(context2, function12, compositionContext, saveableStateRegistry2, i6, (Owner) callback).getLayoutNode();
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0<LayoutNode> function0 = (Function0) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return function0;
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder = layoutNode.getInteropViewFactoryHolder();
        if (interopViewFactoryHolder != null) {
            return (ViewFactoryHolder) interopViewFactoryHolder;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    /* renamed from: updateViewHolderParams-6NefGtU, reason: not valid java name */
    private static final <T extends View> void m2710updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i5, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Updater.m1227setimpl(composer, compositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m1227setimpl(composer, modifier, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier2) {
                invoke2(layoutNode, modifier2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Modifier modifier2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setModifier(modifier2);
            }
        });
        Updater.m1227setimpl(composer, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density2) {
                invoke2(layoutNode, density2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Density density2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setDensity(density2);
            }
        });
        Updater.m1227setimpl(composer, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                invoke2(layoutNode, lifecycleOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setLifecycleOwner(lifecycleOwner2);
            }
        });
        Updater.m1227setimpl(composer, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                invoke2(layoutNode, savedStateRegistryOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setSavedStateRegistryOwner(savedStateRegistryOwner2);
            }
        });
        Updater.m1227setimpl(composer, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                invoke2(layoutNode, layoutDirection2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                int i6 = WhenMappings.$EnumSwitchMapping$0[layoutDirection2.ordinal()];
                int i7 = 1;
                if (i6 == 1) {
                    i7 = 0;
                } else if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                requireViewFactoryHolder.setLayoutDirection(i7);
            }
        });
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i5))) {
            composer.updateRememberedValue(Integer.valueOf(i5));
            composer.apply(Integer.valueOf(i5), setCompositeKeyHash);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Function1<? super T, Unit> function13, Function1<? super T, Unit> function14, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Function1<? super T, Unit> function15;
        int i9;
        Function1<? super T, Unit> function16;
        int i10;
        Function1<? super T, Unit> function17;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-180024211);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function15 = function12;
                i7 |= startRestartGroup.changedInstance(function15) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function16 = function13;
                    i7 |= startRestartGroup.changedInstance(function16) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        function17 = function14;
                        i7 |= startRestartGroup.changedInstance(function17) ? 16384 : 8192;
                        if ((i7 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                        } else {
                            modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i8 != 0) {
                                function15 = null;
                            }
                            if (i9 != 0) {
                                function16 = NoOpUpdate;
                            }
                            if (i10 != 0) {
                                function17 = NoOpUpdate;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-180024211, i7, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:211)");
                            }
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier3));
                            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            LifecycleOwner lifecycleOwner = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                            SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                            if (function15 != null) {
                                startRestartGroup.startReplaceGroup(607871394);
                                Function0<LayoutNode> createAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, startRestartGroup, i7 & 14);
                                if (!(startRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(createAndroidViewNodeFactory);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                m2710updateViewHolderParams6NefGtU(m1226constructorimpl, materializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m1227setimpl(m1226constructorimpl, function15, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setResetBlock(function18);
                                    }
                                });
                                Updater.m1227setimpl(m1226constructorimpl, function17, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setUpdateBlock(function18);
                                    }
                                });
                                Updater.m1227setimpl(m1226constructorimpl, function16, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setReleaseBlock(function18);
                                    }
                                });
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(608726777);
                                Function0<LayoutNode> createAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, startRestartGroup, i7 & 14);
                                if (!(startRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(createAndroidViewNodeFactory2);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                m2710updateViewHolderParams6NefGtU(m1226constructorimpl2, materializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m1227setimpl(m1226constructorimpl2, function17, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setUpdateBlock(function18);
                                    }
                                });
                                Updater.m1227setimpl(m1226constructorimpl2, function16, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setReleaseBlock(function18);
                                    }
                                });
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        final Function1<? super T, Unit> function18 = function15;
                        final Function1<? super T, Unit> function19 = function17;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            final Function1<? super T, Unit> function110 = function16;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
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

                                public final void invoke(Composer composer2, int i12) {
                                    AndroidView_androidKt.AndroidView(function1, modifier4, function18, function110, function19, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function17 = function14;
                    if ((i7 & 9363) != 9362) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier3));
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    LifecycleOwner lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    SavedStateRegistryOwner savedStateRegistryOwner2 = (SavedStateRegistryOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                    if (function15 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function1<? super T, Unit> function182 = function15;
                    final Function1<? super T, Unit> function192 = function17;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function16 = function13;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                function17 = function14;
                if ((i7 & 9363) != 9362) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int currentCompositeKeyHash22 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier3));
                Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                LifecycleOwner lifecycleOwner22 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                SavedStateRegistryOwner savedStateRegistryOwner22 = (SavedStateRegistryOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
                if (function15 != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function1<? super T, Unit> function1822 = function15;
                final Function1<? super T, Unit> function1922 = function17;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function15 = function12;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function16 = function13;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            function17 = function14;
            if ((i7 & 9363) != 9362) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int currentCompositeKeyHash222 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier3));
            Density density222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            LifecycleOwner lifecycleOwner222 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            SavedStateRegistryOwner savedStateRegistryOwner222 = (SavedStateRegistryOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
            if (function15 != null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function1<? super T, Unit> function18222 = function15;
            final Function1<? super T, Unit> function19222 = function17;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function15 = function12;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function16 = function13;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        function17 = function14;
        if ((i7 & 9363) != 9362) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int currentCompositeKeyHash2222 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier3));
        Density density2222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        LifecycleOwner lifecycleOwner2222 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        SavedStateRegistryOwner savedStateRegistryOwner2222 = (SavedStateRegistryOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner());
        if (function15 != null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function1<? super T, Unit> function182222 = function15;
        final Function1<? super T, Unit> function192222 = function17;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
