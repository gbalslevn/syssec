package dk.molslinjen.ui.views.reusable.input.checkbox;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001am\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "isChecked", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCheckChange", "Lkotlin/Function0;", "onClickDisabled", "enabled", "Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlSize;", "size", "Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlStyle;", "style", "showError", "SelectionControl", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlSize;Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlStyle;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SelectionControlKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectionControlStyle.values().length];
            try {
                iArr[SelectionControlStyle.RadioButton.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectionControlStyle.Checkbox.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectionControl(Modifier modifier, final boolean z5, final Function1<? super Boolean, Unit> onCheckChange, Function0<Unit> function0, boolean z6, SelectionControlSize selectionControlSize, final SelectionControlStyle style, boolean z7, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        final Function0<Unit> function02;
        int i8;
        int i9;
        int i10;
        final boolean z8;
        int i11;
        RoundedCornerShape circleShape;
        boolean z9;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Function0<Unit> function03;
        final Modifier modifier3;
        final boolean z10;
        final SelectionControlSize selectionControlSize2;
        final boolean z11;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onCheckChange, "onCheckChange");
        Intrinsics.checkNotNullParameter(style, "style");
        Composer startRestartGroup = composer.startRestartGroup(-331245000);
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((4 & i6) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onCheckChange) ? 256 : 128;
        }
        int i13 = i6 & 8;
        if (i13 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            i8 = 16 & i6;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                i9 = 32 & i6;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changed(selectionControlSize) ? 131072 : 65536;
                }
                if ((i6 & 64) != 0) {
                    i7 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i7 |= startRestartGroup.changed(style) ? 1048576 : 524288;
                }
                i10 = 128 & i6;
                if (i10 != 0) {
                    i7 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i7 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                }
                if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        function02 = null;
                    }
                    z8 = i8 != 0 ? true : z6;
                    SelectionControlSize selectionControlSize3 = i9 != 0 ? SelectionControlSize.Regular : selectionControlSize;
                    boolean z12 = i10 != 0 ? false : z7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331245000, i7, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControl (SelectionControl.kt:41)");
                    }
                    long m3268getGrey50d7_KjU = !z8 ? AppColor.INSTANCE.m3268getGrey50d7_KjU() : z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU();
                    long m3272getSignalRed0d7_KjU = z12 ? AppColor.INSTANCE.m3272getSignalRed0d7_KjU() : !z8 ? AppColor.INSTANCE.m3267getGrey40d7_KjU() : z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                    i11 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
                    if (i11 == 1) {
                        circleShape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        if (i11 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        circleShape = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(5));
                    }
                    boolean z13 = (z8 && function02 == null) ? false : true;
                    Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(ClipKt.clip(modifier2, circleShape), selectionControlSize3.getValue());
                    Role m2163boximpl = Role.m2163boximpl(Role.INSTANCE.m2171getCheckboxo7Vup1c());
                    Modifier modifier4 = modifier2;
                    startRestartGroup.startReplaceGroup(1591077432);
                    z9 = ((57344 & i7) == 16384) | ((i7 & 896) == 256) | ((i7 & 7168) == 2048);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: d2.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SelectionControl$lambda$1$lambda$0;
                                SelectionControl$lambda$1$lambda$0 = SelectionControlKt.SelectionControl$lambda$1$lambda$0(z8, onCheckChange, function02, ((Boolean) obj).booleanValue());
                                return SelectionControl$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ToggleableKt.m454toggleableXHw0xAI(m331size3ABfNKs, z5, z13, m2163boximpl, (Function1) rememberedValue), Dp.m2599constructorimpl(1), m3272getSignalRed0d7_KjU, circleShape), m3268getGrey50d7_KjU, null, 2, null);
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    boolean z14 = z8;
                    Function0<Unit> function04 = function02;
                    AnimatedVisibilityKt.AnimatedVisibility(z5, null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), null, ComposableSingletons$SelectionControlKt.INSTANCE.m3415getLambda1$app_kombardoProd(), startRestartGroup, ((i7 >> 3) & 14) | 200064, 18);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function03 = function04;
                    modifier3 = modifier4;
                    z10 = z14;
                    selectionControlSize2 = selectionControlSize3;
                    z11 = z12;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    z10 = z6;
                    selectionControlSize2 = selectionControlSize;
                    function03 = function02;
                    modifier3 = modifier2;
                    z11 = z7;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: d2.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SelectionControl$lambda$3;
                            SelectionControl$lambda$3 = SelectionControlKt.SelectionControl$lambda$3(Modifier.this, z5, onCheckChange, function03, z10, selectionControlSize2, style, z11, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return SelectionControl$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            i9 = 32 & i6;
            if (i9 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            i10 = 128 & i6;
            if (i10 != 0) {
            }
            if ((i7 & 4793491) == 4793490) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            long m3268getGrey50d7_KjU2 = !z8 ? AppColor.INSTANCE.m3268getGrey50d7_KjU() : z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU();
            if (z12) {
            }
            i11 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
            if (i11 == 1) {
            }
            if (z8) {
            }
            Modifier m331size3ABfNKs2 = SizeKt.m331size3ABfNKs(ClipKt.clip(modifier2, circleShape), selectionControlSize3.getValue());
            Role m2163boximpl2 = Role.m2163boximpl(Role.INSTANCE.m2171getCheckboxo7Vup1c());
            Modifier modifier42 = modifier2;
            startRestartGroup.startReplaceGroup(1591077432);
            z9 = ((57344 & i7) == 16384) | ((i7 & 896) == 256) | ((i7 & 7168) == 2048);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            rememberedValue = new Function1() { // from class: d2.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit SelectionControl$lambda$1$lambda$0;
                    SelectionControl$lambda$1$lambda$0 = SelectionControlKt.SelectionControl$lambda$1$lambda$0(z8, onCheckChange, function02, ((Boolean) obj).booleanValue());
                    return SelectionControl$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ToggleableKt.m454toggleableXHw0xAI(m331size3ABfNKs2, z5, z13, m2163boximpl2, (Function1) rememberedValue), Dp.m2599constructorimpl(1), m3272getSignalRed0d7_KjU, circleShape), m3268getGrey50d7_KjU2, null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            boolean z142 = z8;
            Function0<Unit> function042 = function02;
            AnimatedVisibilityKt.AnimatedVisibility(z5, null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), null, ComposableSingletons$SelectionControlKt.INSTANCE.m3415getLambda1$app_kombardoProd(), startRestartGroup, ((i7 >> 3) & 14) | 200064, 18);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function042;
            modifier3 = modifier42;
            z10 = z142;
            selectionControlSize2 = selectionControlSize3;
            z11 = z12;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i8 = 16 & i6;
        if (i8 == 0) {
        }
        i9 = 32 & i6;
        if (i9 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        i10 = 128 & i6;
        if (i10 != 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        long m3268getGrey50d7_KjU22 = !z8 ? AppColor.INSTANCE.m3268getGrey50d7_KjU() : z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU();
        if (z12) {
        }
        i11 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i11 == 1) {
        }
        if (z8) {
        }
        Modifier m331size3ABfNKs22 = SizeKt.m331size3ABfNKs(ClipKt.clip(modifier2, circleShape), selectionControlSize3.getValue());
        Role m2163boximpl22 = Role.m2163boximpl(Role.INSTANCE.m2171getCheckboxo7Vup1c());
        Modifier modifier422 = modifier2;
        startRestartGroup.startReplaceGroup(1591077432);
        z9 = ((57344 & i7) == 16384) | ((i7 & 896) == 256) | ((i7 & 7168) == 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z9) {
        }
        rememberedValue = new Function1() { // from class: d2.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SelectionControl$lambda$1$lambda$0;
                SelectionControl$lambda$1$lambda$0 = SelectionControlKt.SelectionControl$lambda$1$lambda$0(z8, onCheckChange, function02, ((Boolean) obj).booleanValue());
                return SelectionControl$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ToggleableKt.m454toggleableXHw0xAI(m331size3ABfNKs22, z5, z13, m2163boximpl22, (Function1) rememberedValue), Dp.m2599constructorimpl(1), m3272getSignalRed0d7_KjU, circleShape), m3268getGrey50d7_KjU22, null, 2, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default22);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        boolean z1422 = z8;
        Function0<Unit> function0422 = function02;
        AnimatedVisibilityKt.AnimatedVisibility(z5, null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), null, ComposableSingletons$SelectionControlKt.INSTANCE.m3415getLambda1$app_kombardoProd(), startRestartGroup, ((i7 >> 3) & 14) | 200064, 18);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function0422;
        modifier3 = modifier422;
        z10 = z1422;
        selectionControlSize2 = selectionControlSize3;
        z11 = z12;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionControl$lambda$1$lambda$0(boolean z5, Function1 function1, Function0 function0, boolean z6) {
        if (z5) {
            function1.invoke(Boolean.valueOf(z6));
        } else if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionControl$lambda$3(Modifier modifier, boolean z5, Function1 function1, Function0 function0, boolean z6, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z7, int i5, int i6, Composer composer, int i7) {
        SelectionControl(modifier, z5, function1, function0, z6, selectionControlSize, selectionControlStyle, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
