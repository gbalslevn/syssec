package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aD\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\t*\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u001a\u001a\u00020\u0019*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0001¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/selection/OffsetProvider;", "offsetProvider", BuildConfig.FLAVOR, "isStartHandle", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "direction", "handlesCrossed", "Landroidx/compose/ui/unit/DpSize;", "minTouchTargetSize", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "SelectionHandle-pzduO1o", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandle", "Lkotlin/Function0;", "iconVisible", "isLeft", "SelectionHandleIcon", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "drawSelectionHandle", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Z)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/draw/CacheDrawScope;", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/graphics/ImageBitmap;", "createHandleImage", "(Landroidx/compose/ui/draw/CacheDrawScope;F)Landroidx/compose/ui/graphics/ImageBitmap;", "positionProvider", "Landroidx/compose/ui/Alignment;", "handleReferencePoint", "content", "HandlePopup", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidSelectionHandles_androidKt {
    public static final void HandlePopup(final OffsetProvider offsetProvider, final Alignment alignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(476043083);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(offsetProvider) : startRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(alignment) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476043083, i6, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:247)");
            }
            boolean z5 = false;
            boolean z6 = (i6 & 112) == 32;
            if ((i6 & 14) == 4 || ((i6 & 8) != 0 && startRestartGroup.changed(offsetProvider))) {
                z5 = true;
            }
            boolean z7 = z6 | z5;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, null, new PopupProperties(false, false, false, null, true, false, 15, null), function2, startRestartGroup, ((i6 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
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

                public final void invoke(Composer composer2, int i7) {
                    AndroidSelectionHandles_androidKt.HandlePopup(OffsetProvider.this, alignment, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if ((r27 & 16) != 0) goto L79;
     */
    /* renamed from: SelectionHandle-pzduO1o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m621SelectionHandlepzduO1o(final OffsetProvider offsetProvider, final boolean z5, final ResolvedTextDirection resolvedTextDirection, final boolean z6, long j5, final Modifier modifier, Composer composer, final int i5, final int i6) {
        int i7;
        final long j6;
        Composer startRestartGroup = composer.startRestartGroup(-843755800);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(offsetProvider) : startRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(resolvedTextDirection) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            j6 = j5;
            i7 |= ((i6 & 16) == 0 && startRestartGroup.changed(j6)) ? 16384 : 8192;
        } else {
            j6 = j5;
        }
        if ((i6 & 32) != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i6 & 16) != 0) {
                    j6 = DpSize.INSTANCE.m2630getUnspecifiedMYxV2XQ();
                    i7 &= -57345;
                }
                final long j7 = j6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-843755800, i7, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:64)");
                }
                final boolean isLeftSelectionHandle = SelectionHandlesKt.isLeftSelectionHandle(z5, resolvedTextDirection, z6);
                AbsoluteAlignment absoluteAlignment = AbsoluteAlignment.INSTANCE;
                Alignment topRight = isLeftSelectionHandle ? absoluteAlignment.getTopRight() : absoluteAlignment.getTopLeft();
                int i8 = i7 & 14;
                boolean changed = ((i7 & 112) == 32) | (i8 == 4 || ((i7 & 8) != 0 && startRestartGroup.changedInstance(offsetProvider))) | startRestartGroup.changed(isLeftSelectionHandle);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            long mo474provideF1C5BW0 = OffsetProvider.this.mo474provideF1C5BW0();
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(z5 ? Handle.SelectionStart : Handle.SelectionEnd, mo474provideF1C5BW0, isLeftSelectionHandle ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m1351isSpecifiedk4lQ0M(mo474provideF1C5BW0), null));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, null);
                final ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                HandlePopup(offsetProvider, topRight, ComposableLambdaKt.rememberComposableLambda(280174801, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(280174801, i9, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:82)");
                        }
                        ProvidedValue<ViewConfiguration> provides = CompositionLocalsKt.getLocalViewConfiguration().provides(ViewConfiguration.this);
                        final long j8 = j7;
                        final boolean z7 = isLeftSelectionHandle;
                        final Modifier modifier2 = semantics$default;
                        final OffsetProvider offsetProvider2 = offsetProvider;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1426434671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i10) {
                                Arrangement.Horizontal left;
                                if ((i10 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1426434671, i10, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:83)");
                                }
                                if (j8 != 9205357640488583168L) {
                                    composer3.startReplaceGroup(-837727128);
                                    if (z7) {
                                        left = Arrangement.Absolute.INSTANCE.getRight();
                                    } else {
                                        left = Arrangement.Absolute.INSTANCE.getLeft();
                                    }
                                    Modifier m330requiredSizeInqDBjuR0$default = SizeKt.m330requiredSizeInqDBjuR0$default(modifier2, DpSize.m2626getWidthD9Ej5fM(j8), DpSize.m2625getHeightD9Ej5fM(j8), 0.0f, 0.0f, 12, null);
                                    final OffsetProvider offsetProvider3 = offsetProvider2;
                                    boolean z8 = z7;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(left, Alignment.INSTANCE.getTop(), composer3, 0);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m330requiredSizeInqDBjuR0$default);
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    boolean changedInstance = composer3.changedInstance(offsetProvider3);
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m1351isSpecifiedk4lQ0M(OffsetProvider.this.mo474provideF1C5BW0()));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(companion2, (Function0) rememberedValue2, z8, composer3, 6);
                                    composer3.endNode();
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-836867312);
                                    Modifier modifier3 = modifier2;
                                    boolean changedInstance2 = composer3.changedInstance(offsetProvider2);
                                    final OffsetProvider offsetProvider4 = offsetProvider2;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m1351isSpecifiedk4lQ0M(OffsetProvider.this.mo474provideF1C5BW0()));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier3, (Function0) rememberedValue3, z7, composer3, 0);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, i8 | 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j6 = j7;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    AndroidSelectionHandles_androidKt.m621SelectionHandlepzduO1o(OffsetProvider.this, z5, resolvedTextDirection, z6, j6, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    public static final void SelectionHandleIcon(final Modifier modifier, final Function0<Boolean> function0, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(2111672474);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i6, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:122)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m333sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z5), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandleIcon$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(Modifier.this, function0, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f5) {
        int ceil = ((int) Math.ceil(f5)) * 2;
        HandleImageCache handleImageCache = HandleImageCache.INSTANCE;
        ImageBitmap imageBitmap = handleImageCache.getImageBitmap();
        Canvas canvas = handleImageCache.getCanvas();
        CanvasDrawScope canvasDrawScope = handleImageCache.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m1544ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.INSTANCE.m1538getAlpha8_sVssgQ(), false, null, 24, null);
            handleImageCache.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            handleImageCache.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            handleImageCache.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size(imageBitmap2.getWidth(), imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m1681setSizeuvyYCjk(Size);
        canvas2.save();
        DrawScope.m1698drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m1496getBlack0d7_KjU(), 0L, canvasDrawScope2.mo1703getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m1432getClear0nO6VwU(), 58, null);
        DrawScope.m1698drawRectnJ9OG0$default(canvasDrawScope2, ColorKt.Color(4278190080L), Offset.INSTANCE.m1349getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f5, f5), 0.0f, null, null, 0, 120, null);
        DrawScope.m1690drawCircleVaOC9Bg$default(canvasDrawScope2, ColorKt.Color(4278190080L), f5, OffsetKt.Offset(f5, f5), 0.0f, null, null, 0, 120, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas3);
        drawParams3.m1681setSizeuvyYCjk(size);
        return imageBitmap2;
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, final Function0<Boolean> function0, final boolean z5) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i5) {
                composer.startReplaceGroup(-196777734);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-196777734, i5, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:134)");
                }
                final long selectionHandleColor = ((SelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionHandleColor();
                boolean changed = composer.changed(selectionHandleColor) | composer.changed(function0) | composer.changed(z5);
                final Function0<Boolean> function02 = function0;
                final boolean z6 = z5;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m1377getWidthimpl(cacheDrawScope.m1261getSizeNHjbRc()) / 2.0f);
                            final ColorFilter m1503tintxETnrds$default = ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, selectionHandleColor, 0, 2, null);
                            final Function0<Boolean> function03 = function02;
                            final boolean z7 = z6;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                    invoke2(contentDrawScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ContentDrawScope contentDrawScope) {
                                    contentDrawScope.drawContent();
                                    if (function03.invoke().booleanValue()) {
                                        if (z7) {
                                            ImageBitmap imageBitmap = createHandleImage;
                                            ColorFilter colorFilter = m1503tintxETnrds$default;
                                            long mo1702getCenterF1C5BW0 = contentDrawScope.mo1702getCenterF1C5BW0();
                                            DrawContext drawContext = contentDrawScope.getDrawContext();
                                            long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
                                            drawContext.getCanvas().save();
                                            try {
                                                drawContext.getTransform().mo1688scale0AR0LA0(-1.0f, 1.0f, mo1702getCenterF1C5BW0);
                                                DrawScope.m1692drawImagegbVJVH8$default(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                                return;
                                            } finally {
                                                drawContext.getCanvas().restore();
                                                drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                                            }
                                        }
                                        DrawScope.m1692drawImagegbVJVH8$default(contentDrawScope, createHandleImage, 0L, 0.0f, null, m1503tintxETnrds$default, 0, 46, null);
                                    }
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Modifier drawWithCache = DrawModifierKt.drawWithCache(modifier2, (Function1) rememberedValue);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return drawWithCache;
            }
        }, 1, null);
    }
}
