package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\u001aA\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u001a\u0010\u0011\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u001a\u0010\u0017\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u001a\u0010\u0019\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 ²\u0006\u000e\u0010\u001c\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001d\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001e\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", BuildConfig.FLAVOR, "badge", "Landroidx/compose/ui/Modifier;", "modifier", "content", "BadgedBox", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "Landroidx/compose/ui/unit/Dp;", "BadgeWithContentHorizontalPadding", "F", "getBadgeWithContentHorizontalPadding", "()F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "BadgeOffset", "getBadgeOffset", BuildConfig.FLAVOR, "layoutAbsoluteLeft", "layoutAbsoluteTop", "greatGrandParentAbsoluteRight", "greatGrandParentAbsoluteTop", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BadgeKt {
    private static final float BadgeWithContentHorizontalPadding = Dp.m2599constructorimpl(4);
    private static final float BadgeWithContentHorizontalOffset = Dp.m2599constructorimpl(12);
    private static final float BadgeWithContentVerticalOffset = Dp.m2599constructorimpl(14);
    private static final float BadgeOffset = Dp.m2599constructorimpl(6);

    /* JADX WARN: Removed duplicated region for block: B:32:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b2  */
    /* renamed from: Badge-eopBjH0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m775BadgeeopBjH0(Modifier modifier, long j5, long j6, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        long j7;
        long j8;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier3;
        Shape value;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1298144073);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            j7 = j5;
            i7 |= ((i6 & 2) == 0 && startRestartGroup.changed(j7)) ? 32 : 16;
        } else {
            j7 = j5;
        }
        if ((i5 & 384) == 0) {
            j8 = j6;
            i7 |= ((i6 & 4) == 0 && startRestartGroup.changed(j8)) ? 256 : 128;
        } else {
            j8 = j6;
        }
        int i9 = i6 & 8;
        if (i9 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function32 = function3;
            i7 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
            if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i6 & 2) != 0) {
                        j7 = BadgeDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i7 &= -113;
                    }
                    if ((i6 & 4) != 0) {
                        j8 = ColorSchemeKt.m827contentColorForek8zF_U(j7, startRestartGroup, (i7 >> 3) & 14);
                        i7 &= -897;
                    }
                    if (i9 != 0) {
                        function32 = null;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 2) != 0) {
                        i7 &= -113;
                    }
                    if ((i6 & 4) != 0) {
                        i7 &= -897;
                    }
                    modifier3 = modifier2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1298144073, i7, -1, "androidx.compose.material3.Badge (Badge.kt:183)");
                }
                BadgeTokens badgeTokens = BadgeTokens.INSTANCE;
                float m1003getLargeSizeD9Ej5fM = function32 == null ? badgeTokens.m1003getLargeSizeD9Ej5fM() : badgeTokens.m1004getSizeD9Ej5fM();
                if (function32 == null) {
                    startRestartGroup.startReplaceGroup(-1271801170);
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1271743789);
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                }
                Modifier then = BackgroundKt.m103backgroundbw27NRU(SizeKt.m323defaultMinSizeVpY3zN4(modifier3, m1003getLargeSizeD9Ej5fM, m1003getLargeSizeD9Ej5fM), j7, value).then(function32 == null ? PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null) : Modifier.INSTANCE);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 54);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-1705294841);
                if (function32 != null) {
                    ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j8, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(719214594, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$1$1
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
                            if ((i10 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(719214594, i10, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:212)");
                            }
                            function32.invoke(rowScopeInstance, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, ((i7 >> 6) & 14) | 384);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            final long j9 = j8;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                final long j10 = j7;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$2
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
                        BadgeKt.m775BadgeeopBjH0(Modifier.this, j10, j9, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        function32 = function3;
        if ((i7 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 2) != 0) {
        }
        if ((i6 & 4) != 0) {
        }
        if (i9 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        BadgeTokens badgeTokens2 = BadgeTokens.INSTANCE;
        if (function32 == null) {
        }
        if (function32 == null) {
        }
        Modifier then2 = BackgroundKt.m103backgroundbw27NRU(SizeKt.m323defaultMinSizeVpY3zN4(modifier3, m1003getLargeSizeD9Ej5fM, m1003getLargeSizeD9Ej5fM), j7, value).then(function32 == null ? PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null) : Modifier.INSTANCE);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 54);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
        final RowScope rowScopeInstance2 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-1705294841);
        if (function32 != null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j92 = j8;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function332 = function32;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Modifier modifier3;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        Object rememberedValue5;
        Object rememberedValue6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1404022535);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(function32) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1404022535, i7, -1, "androidx.compose.material3.BadgedBox (Badge.kt:72)");
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableFloatState mutableFloatState2 = (MutableFloatState) rememberedValue2;
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.POSITIVE_INFINITY);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableFloatState mutableFloatState3 = (MutableFloatState) rememberedValue3;
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NEGATIVE_INFINITY);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                final MutableFloatState mutableFloatState4 = (MutableFloatState) rememberedValue4;
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            LayoutCoordinates parentLayoutCoordinates;
                            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
                            MutableFloatState.this.setFloatValue(boundsInWindow.getLeft());
                            mutableFloatState2.setFloatValue(boundsInWindow.getTop());
                            LayoutCoordinates parentLayoutCoordinates2 = layoutCoordinates.getParentLayoutCoordinates();
                            LayoutCoordinates parentCoordinates = (parentLayoutCoordinates2 == null || (parentLayoutCoordinates = parentLayoutCoordinates2.getParentLayoutCoordinates()) == null) ? null : parentLayoutCoordinates.getParentCoordinates();
                            if (parentCoordinates != null) {
                                MutableFloatState mutableFloatState5 = mutableFloatState3;
                                MutableFloatState mutableFloatState6 = mutableFloatState4;
                                Rect boundsInWindow2 = LayoutCoordinatesKt.boundsInWindow(parentCoordinates);
                                mutableFloatState5.setFloatValue(boundsInWindow2.getRight());
                                mutableFloatState6.setFloatValue(boundsInWindow2.getTop());
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier3, (Function1) rememberedValue5);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new MeasurePolicy() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$3$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* renamed from: measure-3p2s80s */
                        public final MeasureResult mo19measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                            int size = list.size();
                            for (int i9 = 0; i9 < size; i9++) {
                                Measurable measurable = list.get(i9);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "badge")) {
                                    final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 11, null));
                                    int size2 = list.size();
                                    for (int i10 = 0; i10 < size2; i10++) {
                                        Measurable measurable2 = list.get(i10);
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "anchor")) {
                                            final Placeable mo1946measureBRTryo02 = measurable2.mo1946measureBRTryo0(j5);
                                            int i11 = mo1946measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                                            int i12 = mo1946measureBRTryo02.get(AlignmentLineKt.getLastBaseline());
                                            int width = mo1946measureBRTryo02.getWidth();
                                            int height = mo1946measureBRTryo02.getHeight();
                                            Map<AlignmentLine, Integer> mapOf = MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(i11)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(i12)));
                                            final MutableFloatState mutableFloatState5 = MutableFloatState.this;
                                            final MutableFloatState mutableFloatState6 = mutableFloatState;
                                            final MutableFloatState mutableFloatState7 = mutableFloatState3;
                                            final MutableFloatState mutableFloatState8 = mutableFloatState4;
                                            return measureScope.layout(width, height, mapOf, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$3$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    float floatValue;
                                                    float floatValue2;
                                                    float floatValue3;
                                                    float floatValue4;
                                                    boolean z5 = Placeable.this.getWidth() > measureScope.mo206roundToPx0680j_4(BadgeTokens.INSTANCE.m1004getSizeD9Ej5fM());
                                                    float badgeWithContentHorizontalOffset = z5 ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
                                                    float badgeWithContentVerticalOffset = z5 ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo02, 0, 0, 0.0f, 4, null);
                                                    int width2 = mo1946measureBRTryo02.getWidth() - measureScope.mo206roundToPx0680j_4(badgeWithContentHorizontalOffset);
                                                    int mo206roundToPx0680j_4 = (-Placeable.this.getHeight()) + measureScope.mo206roundToPx0680j_4(badgeWithContentVerticalOffset);
                                                    floatValue = mutableFloatState5.getFloatValue();
                                                    floatValue2 = mutableFloatState6.getFloatValue();
                                                    floatValue3 = mutableFloatState7.getFloatValue();
                                                    float width3 = floatValue3 - ((floatValue2 + width2) + Placeable.this.getWidth());
                                                    floatValue4 = mutableFloatState8.getFloatValue();
                                                    float f5 = (floatValue + mo206roundToPx0680j_4) - floatValue4;
                                                    if (width3 < 0.0f) {
                                                        width2 += MathKt.roundToInt(width3);
                                                    }
                                                    int i13 = width2;
                                                    if (f5 < 0.0f) {
                                                        mo206roundToPx0680j_4 -= MathKt.roundToInt(f5);
                                                    }
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, i13, mo206roundToPx0680j_4, 0.0f, 4, null);
                                                }
                                            });
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue6;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier layoutId = LayoutIdKt.layoutId(companion3, "anchor");
                Alignment.Companion companion4 = Alignment.INSTANCE;
                int i9 = ((i7 << 3) & 7168) | 54;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function32.invoke(boxScopeInstance, startRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
                startRestartGroup.endNode();
                Modifier layoutId2 = LayoutIdKt.layoutId(companion3, "badge");
                int i10 = ((i7 << 9) & 7168) | 6;
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor3);
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
                function3.invoke(boxScopeInstance, startRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$4
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
                        BadgeKt.BadgedBox(function3, modifier4, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i6 & 4) == 0) {
        }
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableFloatState mutableFloatState5 = (MutableFloatState) rememberedValue;
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        final MutableFloatState mutableFloatState22 = (MutableFloatState) rememberedValue2;
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        final MutableFloatState mutableFloatState32 = (MutableFloatState) rememberedValue3;
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        final MutableFloatState mutableFloatState42 = (MutableFloatState) rememberedValue4;
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
        }
        Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier3, (Function1) rememberedValue5);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
        }
        MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue6;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, measurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion22.getSetModifier());
        Modifier.Companion companion32 = Modifier.INSTANCE;
        Modifier layoutId3 = LayoutIdKt.layoutId(companion32, "anchor");
        Alignment.Companion companion42 = Alignment.INSTANCE;
        int i92 = ((i7 << 3) & 7168) | 54;
        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getCenter(), false);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId3);
        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy3, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion22.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        function32.invoke(boxScopeInstance2, startRestartGroup, Integer.valueOf(((i92 >> 6) & 112) | 6));
        startRestartGroup.endNode();
        Modifier layoutId22 = LayoutIdKt.layoutId(companion32, "badge");
        int i102 = ((i7 << 9) & 7168) | 6;
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getTopStart(), false);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId22);
        Function0<ComposeUiNode> constructor32 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion22.getSetModifier());
        function3.invoke(boxScopeInstance2, startRestartGroup, Integer.valueOf(((i102 >> 6) & 112) | 6));
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }
}
