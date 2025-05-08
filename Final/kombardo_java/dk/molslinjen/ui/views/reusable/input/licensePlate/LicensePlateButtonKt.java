package dk.molslinjen.ui.views.reusable.input.licensePlate;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u001a;\u0010\t\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\r\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicle", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "showEditIcon", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "LicensePlateButton", "(Ldk/molslinjen/domain/model/account/UserVehicle;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VehicleSelectedView", "(Ldk/molslinjen/domain/model/account/UserVehicle;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "VehicleNotSelectedView", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LicensePlateButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LicensePlateButton(final UserVehicle userVehicle, Modifier modifier, boolean z5, final Function0<Unit> onClick, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z6;
        boolean z7;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1417467248);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(userVehicle) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                if ((i6 & 8) != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changedInstance(onClick) ? 2048 : 1024;
                }
                if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i8 != 0) {
                        z6 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1417467248, i7, -1, "dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateButton (LicensePlateButton.kt:41)");
                    }
                    float m2599constructorimpl = Dp.m2599constructorimpl(userVehicle == null ? 45 : 60);
                    Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(modifier2, m2599constructorimpl);
                    AppColor appColor = AppColor.INSTANCE;
                    Modifier clip = ClipKt.clip(BackgroundKt.m104backgroundbw27NRU$default(m325height3ABfNKs, appColor.m3281getWhite0d7_KjU(), null, 2, null), ThemeShapesKt.getThemeShapes().getMedium());
                    startRestartGroup.startReplaceGroup(1703693796);
                    z7 = (i7 & 7168) == 2048;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: f2.a
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit LicensePlateButton$lambda$1$lambda$0;
                                LicensePlateButton$lambda$1$lambda$0 = LicensePlateButtonKt.LicensePlateButton$lambda$1$lambda$0(Function0.this);
                                return LicensePlateButton$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(1), appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU);
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
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    LicensePlateIndicatorViewKt.m3418LicensePlateIndicatorViewrCkNIVA(Dp.m2597boximpl(m2599constructorimpl), startRestartGroup, 0);
                    if (userVehicle != null) {
                        startRestartGroup.startReplaceGroup(-1105413250);
                        int i10 = i7 >> 3;
                        VehicleSelectedView(userVehicle, z6, onClick, startRestartGroup, (i7 & 14) | (i10 & 112) | (i10 & 896));
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1105300100);
                        VehicleNotSelectedView(startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                final Modifier modifier3 = modifier2;
                final boolean z8 = z6;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: f2.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LicensePlateButton$lambda$3;
                            LicensePlateButton$lambda$3 = LicensePlateButtonKt.LicensePlateButton$lambda$3(UserVehicle.this, modifier3, z8, onClick, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return LicensePlateButton$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            z6 = z5;
            if ((i6 & 8) != 0) {
            }
            if ((i7 & 1171) == 1170) {
            }
            if (i9 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            float m2599constructorimpl2 = Dp.m2599constructorimpl(userVehicle == null ? 45 : 60);
            Modifier m325height3ABfNKs2 = SizeKt.m325height3ABfNKs(modifier2, m2599constructorimpl2);
            AppColor appColor2 = AppColor.INSTANCE;
            Modifier clip2 = ClipKt.clip(BackgroundKt.m104backgroundbw27NRU$default(m325height3ABfNKs2, appColor2.m3281getWhite0d7_KjU(), null, 2, null), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(1703693796);
            if ((i7 & 7168) == 2048) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue = new Function0() { // from class: f2.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit LicensePlateButton$lambda$1$lambda$0;
                    LicensePlateButton$lambda$1$lambda$0 = LicensePlateButtonKt.LicensePlateButton$lambda$1$lambda$0(Function0.this);
                    return LicensePlateButton$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier m108borderxT4_qwU2 = BorderKt.m108borderxT4_qwU(ClickableKt.m122clickableXHw0xAI$default(clip2, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(1), appColor2.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU2);
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
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            LicensePlateIndicatorViewKt.m3418LicensePlateIndicatorViewrCkNIVA(Dp.m2597boximpl(m2599constructorimpl2), startRestartGroup, 0);
            if (userVehicle != null) {
            }
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Modifier modifier32 = modifier2;
            final boolean z82 = z6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        if ((i6 & 8) != 0) {
        }
        if ((i7 & 1171) == 1170) {
        }
        if (i9 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float m2599constructorimpl22 = Dp.m2599constructorimpl(userVehicle == null ? 45 : 60);
        Modifier m325height3ABfNKs22 = SizeKt.m325height3ABfNKs(modifier2, m2599constructorimpl22);
        AppColor appColor22 = AppColor.INSTANCE;
        Modifier clip22 = ClipKt.clip(BackgroundKt.m104backgroundbw27NRU$default(m325height3ABfNKs22, appColor22.m3281getWhite0d7_KjU(), null, 2, null), ThemeShapesKt.getThemeShapes().getMedium());
        startRestartGroup.startReplaceGroup(1703693796);
        if ((i7 & 7168) == 2048) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z7) {
        }
        rememberedValue = new Function0() { // from class: f2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit LicensePlateButton$lambda$1$lambda$0;
                LicensePlateButton$lambda$1$lambda$0 = LicensePlateButtonKt.LicensePlateButton$lambda$1$lambda$0(Function0.this);
                return LicensePlateButton$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier m108borderxT4_qwU22 = BorderKt.m108borderxT4_qwU(ClickableKt.m122clickableXHw0xAI$default(clip22, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(1), appColor22.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU22);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy22, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        LicensePlateIndicatorViewKt.m3418LicensePlateIndicatorViewrCkNIVA(Dp.m2597boximpl(m2599constructorimpl22), startRestartGroup, 0);
        if (userVehicle != null) {
        }
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Modifier modifier322 = modifier2;
        final boolean z822 = z6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateButton$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateButton$lambda$3(UserVehicle userVehicle, Modifier modifier, boolean z5, Function0 function0, int i5, int i6, Composer composer, int i7) {
        LicensePlateButton(userVehicle, modifier, z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void VehicleNotSelectedView(Composer composer, final int i5) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1140734202);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1140734202, i5, -1, "dk.molslinjen.ui.views.reusable.input.licensePlate.VehicleNotSelectedView (LicensePlateButton.kt:95)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            startRestartGroup.startReplaceGroup(-1910503975);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: f2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VehicleNotSelectedView$lambda$8$lambda$7;
                        VehicleNotSelectedView$lambda$8$lambda$7 = LicensePlateButtonKt.VehicleNotSelectedView$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                        return VehicleNotSelectedView$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics = SemanticsModifierKt.semantics(m313paddingVpY3zN4$default, true, (Function1) rememberedValue);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 80.0f, false, 2, null), startRestartGroup, 0);
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_plus_circled, startRestartGroup, 6);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, appColor.m3255getBrandBlue10d7_KjU(), startRestartGroup, 3456, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_addVehicle, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), appColor.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 432, 1572864, 65528);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 112.0f, false, 2, null), composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VehicleNotSelectedView$lambda$10;
                    VehicleNotSelectedView$lambda$10 = LicensePlateButtonKt.VehicleNotSelectedView$lambda$10(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return VehicleNotSelectedView$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleNotSelectedView$lambda$10(int i5, Composer composer, int i6) {
        VehicleNotSelectedView(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleNotSelectedView$lambda$8$lambda$7(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    public static final void VehicleSelectedView(final UserVehicle vehicle, final boolean z5, final Function0<Unit> onClick, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-793424370);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(vehicle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-793424370, i6, -1, "dk.molslinjen.ui.views.reusable.input.licensePlate.VehicleSelectedView (LicensePlateButton.kt:65)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(vehicle.getDisplayName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(vehicle.getLicensePlate(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-2035651045);
            if (z5) {
                composer2 = startRestartGroup;
                CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), R.drawable.icon_edit, onClick, 0.0f, 0.0f, 0L, AppColor.INSTANCE.m3267getGrey40d7_KjU(), 0L, null, composer2, (i6 & 896) | 1572918, 440);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VehicleSelectedView$lambda$6;
                    VehicleSelectedView$lambda$6 = LicensePlateButtonKt.VehicleSelectedView$lambda$6(UserVehicle.this, z5, onClick, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return VehicleSelectedView$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectedView$lambda$6(UserVehicle userVehicle, boolean z5, Function0 function0, int i5, Composer composer, int i6) {
        VehicleSelectedView(userVehicle, z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
