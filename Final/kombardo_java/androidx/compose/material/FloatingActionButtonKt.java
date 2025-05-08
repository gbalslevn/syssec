package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001al\u0010\u0011\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a~\u0010\u0016\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColor", "Landroidx/compose/material/FloatingActionButtonElevation;", "elevation", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "text", "icon", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "ExtendedFloatingActionButton", "Landroidx/compose/ui/unit/Dp;", "FabSize", "F", "ExtendedFabSize", "ExtendedFabIconPadding", "ExtendedFabTextPadding", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FloatingActionButtonKt {
    private static final float FabSize = Dp.m2599constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m2599constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m2599constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m2599constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0175  */
    /* renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m705ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j5, long j6, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i10;
        long j7;
        long j8;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        long j9;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        long j10;
        final Modifier modifier3;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final long j11;
        final long j12;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1555720195);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function23 = function22;
                    i7 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                        if ((196608 & i5) == 0) {
                            if ((i6 & 32) == 0 && startRestartGroup.changed(shape)) {
                                i13 = 131072;
                                i7 |= i13;
                            }
                            i13 = 65536;
                            i7 |= i13;
                        }
                        if ((1572864 & i5) == 0) {
                            if ((i6 & 64) == 0) {
                                j7 = j5;
                                if (startRestartGroup.changed(j7)) {
                                    i12 = 1048576;
                                    i7 |= i12;
                                }
                            } else {
                                j7 = j5;
                            }
                            i12 = 524288;
                            i7 |= i12;
                        } else {
                            j7 = j5;
                        }
                        if ((i5 & 12582912) == 0) {
                            j8 = j6;
                            i7 |= ((i6 & 128) == 0 && startRestartGroup.changed(j8)) ? 8388608 : 4194304;
                        } else {
                            j8 = j6;
                        }
                        if ((100663296 & i5) == 0) {
                            if ((i6 & 256) == 0 && startRestartGroup.changed(floatingActionButtonElevation)) {
                                i11 = 67108864;
                                i7 |= i11;
                            }
                            i11 = 33554432;
                            i7 |= i11;
                        }
                        if ((i7 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i8 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i9 != 0) {
                                    function23 = null;
                                }
                                mutableInteractionSource2 = i10 == 0 ? mutableInteractionSource : null;
                                if ((i6 & 32) != 0) {
                                    shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i7 &= -458753;
                                } else {
                                    shape2 = shape;
                                }
                                if ((i6 & 64) != 0) {
                                    j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m669getSecondary0d7_KjU();
                                    i7 &= -3670017;
                                }
                                if ((i6 & 128) != 0) {
                                    j9 = ColorsKt.m673contentColorForek8zF_U(j7, startRestartGroup, (i7 >> 18) & 14);
                                    i7 &= -29360129;
                                } else {
                                    j9 = j8;
                                }
                                if ((i6 & 256) != 0) {
                                    floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m702elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                    i7 &= -234881025;
                                } else {
                                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                                }
                                j10 = j9;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i6 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                if ((i6 & 256) != 0) {
                                    i7 &= -234881025;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                shape2 = shape;
                                floatingActionButtonElevation2 = floatingActionButtonElevation;
                                j10 = j8;
                            }
                            long j13 = j7;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1555720195, i7, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:156)");
                            }
                            float f5 = ExtendedFabSize;
                            int i14 = ((i7 >> 3) & 14) | 12582912;
                            int i15 = i7 >> 6;
                            m706FloatingActionButtonbogVsAg(function0, SizeKt.m335sizeInqDBjuR0$default(modifier2, f5, f5, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape2, j13, j10, floatingActionButtonElevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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

                                public final void invoke(Composer composer2, int i16) {
                                    float f6;
                                    float f7;
                                    if ((i16 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1418981691, i16, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                                    }
                                    float f8 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f6 = FloatingActionButtonKt.ExtendedFabTextPadding;
                                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, f8, 0.0f, f6, 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function25 = function23;
                                    Function2<Composer, Integer, Unit> function26 = function2;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    if (function25 != null) {
                                        composer2.startReplaceGroup(-565171246);
                                        function25.invoke(composer2, 0);
                                        f7 = FloatingActionButtonKt.ExtendedFabIconPadding;
                                        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, f7), composer2, 6);
                                        composer2.endReplaceGroup();
                                    } else {
                                        composer2.startReplaceGroup(-565074185);
                                        composer2.endReplaceGroup();
                                    }
                                    function26.invoke(composer2, 0);
                                    composer2.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, i14 | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            function24 = function23;
                            j11 = j13;
                            j12 = j10;
                            shape3 = shape2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function24 = function23;
                            j12 = j8;
                            j11 = j7;
                            shape3 = shape;
                            floatingActionButtonElevation3 = floatingActionButtonElevation;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

                                public final void invoke(Composer composer2, int i16) {
                                    FloatingActionButtonKt.m705ExtendedFloatingActionButtonwqdebIU(function2, function0, modifier3, function24, mutableInteractionSource3, shape3, j11, j12, floatingActionButtonElevation3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((196608 & i5) == 0) {
                    }
                    if ((1572864 & i5) == 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    if ((100663296 & i5) == 0) {
                    }
                    if ((i7 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if ((i6 & 256) != 0) {
                    }
                    j10 = j9;
                    long j132 = j7;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f52 = ExtendedFabSize;
                    int i142 = ((i7 >> 3) & 14) | 12582912;
                    int i152 = i7 >> 6;
                    m706FloatingActionButtonbogVsAg(function0, SizeKt.m335sizeInqDBjuR0$default(modifier2, f52, f52, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape2, j132, j10, floatingActionButtonElevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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

                        public final void invoke(Composer composer2, int i16) {
                            float f6;
                            float f7;
                            if ((i16 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1418981691, i16, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                            }
                            float f8 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            f6 = FloatingActionButtonKt.ExtendedFabTextPadding;
                            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, f8, 0.0f, f6, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function25 = function23;
                            Function2<Composer, Integer, Unit> function26 = function2;
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            if (function25 != null) {
                                composer2.startReplaceGroup(-565171246);
                                function25.invoke(composer2, 0);
                                f7 = FloatingActionButtonKt.ExtendedFabIconPadding;
                                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, f7), composer2, 6);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(-565074185);
                                composer2.endReplaceGroup();
                            }
                            function26.invoke(composer2, 0);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, i142 | (i152 & 896) | (i152 & 7168) | (57344 & i152) | (458752 & i152) | (i152 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                    function24 = function23;
                    j11 = j132;
                    j12 = j10;
                    shape3 = shape2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                if ((196608 & i5) == 0) {
                }
                if ((1572864 & i5) == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if ((100663296 & i5) == 0) {
                }
                if ((i7 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 == 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if ((i6 & 256) != 0) {
                }
                j10 = j9;
                long j1322 = j7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f522 = ExtendedFabSize;
                int i1422 = ((i7 >> 3) & 14) | 12582912;
                int i1522 = i7 >> 6;
                m706FloatingActionButtonbogVsAg(function0, SizeKt.m335sizeInqDBjuR0$default(modifier2, f522, f522, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape2, j1322, j10, floatingActionButtonElevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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

                    public final void invoke(Composer composer2, int i16) {
                        float f6;
                        float f7;
                        if ((i16 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, i16, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                        }
                        float f8 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f6 = FloatingActionButtonKt.ExtendedFabTextPadding;
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, f8, 0.0f, f6, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        Function2<Composer, Integer, Unit> function26 = function2;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        if (function25 != null) {
                            composer2.startReplaceGroup(-565171246);
                            function25.invoke(composer2, 0);
                            f7 = FloatingActionButtonKt.ExtendedFabIconPadding;
                            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, f7), composer2, 6);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-565074185);
                            composer2.endReplaceGroup();
                        }
                        function26.invoke(composer2, 0);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, i1422 | (i1522 & 896) | (i1522 & 7168) | (57344 & i1522) | (458752 & i1522) | (i1522 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                function24 = function23;
                j11 = j1322;
                j12 = j10;
                shape3 = shape2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function23 = function22;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            if ((196608 & i5) == 0) {
            }
            if ((1572864 & i5) == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if ((100663296 & i5) == 0) {
            }
            if ((i7 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 == 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((i6 & 256) != 0) {
            }
            j10 = j9;
            long j13222 = j7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f5222 = ExtendedFabSize;
            int i14222 = ((i7 >> 3) & 14) | 12582912;
            int i15222 = i7 >> 6;
            m706FloatingActionButtonbogVsAg(function0, SizeKt.m335sizeInqDBjuR0$default(modifier2, f5222, f5222, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape2, j13222, j10, floatingActionButtonElevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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

                public final void invoke(Composer composer2, int i16) {
                    float f6;
                    float f7;
                    if ((i16 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1418981691, i16, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                    }
                    float f8 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    f6 = FloatingActionButtonKt.ExtendedFabTextPadding;
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, f8, 0.0f, f6, 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function25 = function23;
                    Function2<Composer, Integer, Unit> function26 = function2;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (function25 != null) {
                        composer2.startReplaceGroup(-565171246);
                        function25.invoke(composer2, 0);
                        f7 = FloatingActionButtonKt.ExtendedFabIconPadding;
                        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, f7), composer2, 6);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-565074185);
                        composer2.endReplaceGroup();
                    }
                    function26.invoke(composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, i14222 | (i15222 & 896) | (i15222 & 7168) | (57344 & i15222) | (458752 & i15222) | (i15222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            floatingActionButtonElevation3 = floatingActionButtonElevation2;
            function24 = function23;
            j11 = j13222;
            j12 = j10;
            shape3 = shape2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function23 = function22;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        if ((196608 & i5) == 0) {
        }
        if ((1572864 & i5) == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if ((100663296 & i5) == 0) {
        }
        if ((i7 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((i6 & 256) != 0) {
        }
        j10 = j9;
        long j132222 = j7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        float f52222 = ExtendedFabSize;
        int i142222 = ((i7 >> 3) & 14) | 12582912;
        int i152222 = i7 >> 6;
        m706FloatingActionButtonbogVsAg(function0, SizeKt.m335sizeInqDBjuR0$default(modifier2, f52222, f52222, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape2, j132222, j10, floatingActionButtonElevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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

            public final void invoke(Composer composer2, int i16) {
                float f6;
                float f7;
                if ((i16 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1418981691, i16, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                }
                float f8 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                Modifier.Companion companion = Modifier.INSTANCE;
                f6 = FloatingActionButtonKt.ExtendedFabTextPadding;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, f8, 0.0f, f6, 0.0f, 10, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Function2<Composer, Integer, Unit> function25 = function23;
                Function2<Composer, Integer, Unit> function26 = function2;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (function25 != null) {
                    composer2.startReplaceGroup(-565171246);
                    function25.invoke(composer2, 0);
                    f7 = FloatingActionButtonKt.ExtendedFabIconPadding;
                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, f7), composer2, 6);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-565074185);
                    composer2.endReplaceGroup();
                }
                function26.invoke(composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, i142222 | (i152222 & 896) | (i152222 & 7168) | (57344 & i152222) | (458752 & i152222) | (i152222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        floatingActionButtonElevation3 = floatingActionButtonElevation2;
        function24 = function23;
        j11 = j132222;
        j12 = j10;
        shape3 = shape2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016d  */
    /* renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m706FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j5, long j6, FloatingActionButtonElevation floatingActionButtonElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        long j7;
        final long j8;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        long j9;
        long j10;
        int i9;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        final long j11;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier3;
        final long j12;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1028985328);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0 && startRestartGroup.changed(shape)) {
                        i11 = 2048;
                        i7 |= i11;
                    }
                    i11 = 1024;
                    i7 |= i11;
                }
                if ((i5 & 24576) == 0) {
                    j7 = j5;
                    i7 |= ((i6 & 16) == 0 && startRestartGroup.changed(j7)) ? 16384 : 8192;
                } else {
                    j7 = j5;
                }
                if ((196608 & i5) == 0) {
                    j8 = j6;
                    i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(j8)) ? 131072 : 65536;
                } else {
                    j8 = j6;
                }
                if ((1572864 & i5) == 0) {
                    if ((i6 & 64) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                            i10 = 1048576;
                            i7 |= i10;
                        }
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i10 = 524288;
                    i7 |= i10;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i6 & 128) != 0) {
                    i7 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i7 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((4793491 & i7) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        mutableInteractionSource2 = i8 != 0 ? null : mutableInteractionSource;
                        if ((i6 & 8) != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i7 &= -7169;
                        } else {
                            shape2 = shape;
                        }
                        if ((i6 & 16) != 0) {
                            j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m669getSecondary0d7_KjU();
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            j9 = ColorsKt.m673contentColorForek8zF_U(j7, startRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        } else {
                            j9 = j8;
                        }
                        if ((i6 & 64) != 0) {
                            j10 = j7;
                            i9 = i7 & (-3670017);
                            floatingActionButtonElevation3 = FloatingActionButtonDefaults.INSTANCE.m702elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                        } else {
                            j10 = j7;
                            i9 = i7;
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        }
                        j11 = j9;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        if ((i6 & 16) != 0) {
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            i7 &= -458753;
                        }
                        if ((i6 & 64) != 0) {
                            i7 &= -3670017;
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        shape2 = shape;
                        j10 = j7;
                        i9 = i7;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        j11 = j8;
                    }
                    long j13 = j10;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1028985328, i9, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
                    }
                    if (mutableInteractionSource2 == null) {
                        startRestartGroup.startReplaceGroup(-1991754265);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(628485872);
                        startRestartGroup.endReplaceGroup();
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                    FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevation3;
                    SurfaceKt.m737SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                        }
                    }, 1, null), false, shape2, j13, j11, null, floatingActionButtonElevation3.elevation(mutableInteractionSource3, startRestartGroup, (i9 >> 15) & 112).getValue().getValue(), mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer2, int i13) {
                            if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1972871863, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:100)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1488getAlphaimpl(j11)));
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i14) {
                                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1867794295, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:101)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i15) {
                                            float f5;
                                            float f6;
                                            if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1567914264, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:102)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f5 = FloatingActionButtonKt.FabSize;
                                            f6 = FloatingActionButtonKt.FabSize;
                                            Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(companion, f5, f6);
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function24 = function23;
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, m323defaultMinSizeVpY3zN4);
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            function24.invoke(composer4, 0);
                                            composer4.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i9 & 14) | 805306368 | (i9 & 7168) | (57344 & i9) | (458752 & i9), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource5;
                    modifier3 = modifier2;
                    j12 = j13;
                    j8 = j11;
                    floatingActionButtonElevation2 = floatingActionButtonElevation4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    mutableInteractionSource4 = mutableInteractionSource;
                    shape2 = shape;
                    modifier3 = modifier2;
                    j12 = j7;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                        public final void invoke(Composer composer2, int i13) {
                            FloatingActionButtonKt.m706FloatingActionButtonbogVsAg(function0, modifier3, mutableInteractionSource4, shape2, j12, j8, floatingActionButtonElevation2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            if ((i5 & 3072) == 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) == 0) {
            }
            if ((1572864 & i5) == 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            j11 = j9;
            long j132 = j10;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (mutableInteractionSource2 == null) {
            }
            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
            FloatingActionButtonElevation floatingActionButtonElevation42 = floatingActionButtonElevation3;
            SurfaceKt.m737SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                }
            }, 1, null), false, shape2, j132, j11, null, floatingActionButtonElevation3.elevation(mutableInteractionSource3, startRestartGroup, (i9 >> 15) & 112).getValue().getValue(), mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                public final void invoke(Composer composer2, int i13) {
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1972871863, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:100)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1488getAlphaimpl(j11)));
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1867794295, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:101)");
                            }
                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i15) {
                                    float f5;
                                    float f6;
                                    if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1567914264, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:102)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f5 = FloatingActionButtonKt.FabSize;
                                    f6 = FloatingActionButtonKt.FabSize;
                                    Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(companion, f5, f6);
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function24 = function23;
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, m323defaultMinSizeVpY3zN4);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    if (composer4.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    function24.invoke(composer4, 0);
                                    composer4.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i9 & 14) | 805306368 | (i9 & 7168) | (57344 & i9) | (458752 & i9), 68);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource52;
            modifier3 = modifier2;
            j12 = j132;
            j8 = j11;
            floatingActionButtonElevation2 = floatingActionButtonElevation42;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) == 0) {
        }
        if ((1572864 & i5) == 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        j11 = j9;
        long j1322 = j10;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (mutableInteractionSource2 == null) {
        }
        MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource2;
        FloatingActionButtonElevation floatingActionButtonElevation422 = floatingActionButtonElevation3;
        SurfaceKt.m737SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
            }
        }, 1, null), false, shape2, j1322, j11, null, floatingActionButtonElevation3.elevation(mutableInteractionSource3, startRestartGroup, (i9 >> 15) & 112).getValue().getValue(), mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

            public final void invoke(Composer composer2, int i13) {
                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1972871863, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:100)");
                }
                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1488getAlphaimpl(j11)));
                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i14) {
                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1867794295, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:101)");
                        }
                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton();
                        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i15) {
                                float f5;
                                float f6;
                                if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1567914264, i15, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:102)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                f5 = FloatingActionButtonKt.FabSize;
                                f6 = FloatingActionButtonKt.FabSize;
                                Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(companion, f5, f6);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function24 = function23;
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, m323defaultMinSizeVpY3zN4);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                function24.invoke(composer4, 0);
                                composer4.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i9 & 14) | 805306368 | (i9 & 7168) | (57344 & i9) | (458752 & i9), 68);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource522;
        modifier3 = modifier2;
        j12 = j1322;
        j8 = j11;
        floatingActionButtonElevation2 = floatingActionButtonElevation422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
