package dk.molslinjen.ui.views.global.topbar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.navigation.NavController;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonConfiguration;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012²\u0006\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "buttonConfig", "Landroidx/navigation/NavController;", "navController", BuildConfig.FLAVOR, "TopBarButton", "(Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/Dp;", "cornerRadius", BuildConfig.FLAVOR, "arrowEndOffsetPx", "arrowSize", "Landroidx/compose/ui/graphics/Shape;", "popupShape-gGCzmOo", "(FFFLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "popupShape", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerCoordinates", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TopBarButtonKt {
    public static final void TopBarButton(final TopBarButtonConfiguration buttonConfig, final NavController navController, Composer composer, final int i5) {
        int i6;
        Function0 function0;
        Boolean bool;
        State collectAsState;
        final Function2<Composer, Integer, Unit> popupContent;
        Intrinsics.checkNotNullParameter(buttonConfig, "buttonConfig");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer startRestartGroup = composer.startRestartGroup(137901480);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(buttonConfig) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(137901480, i6, -1, "dk.molslinjen.ui.views.global.topbar.TopBarButton (TopBarButton.kt:31)");
            }
            startRestartGroup.startReplaceGroup(667010984);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1253227101);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: V1.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TopBarButton$lambda$11$lambda$4$lambda$3;
                        TopBarButton$lambda$11$lambda$4$lambda$3 = TopBarButtonKt.TopBarButton$lambda$11$lambda$4$lambda$3(MutableState.this, (LayoutCoordinates) obj);
                        return TopBarButton$lambda$11$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue2);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            if (buttonConfig instanceof TopBarButtonConfiguration.Custom) {
                startRestartGroup.startReplaceGroup(1729987853);
                ((TopBarButtonConfiguration.Custom) buttonConfig).getContent().invoke(navController, startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
                startRestartGroup.endReplaceGroup();
            } else {
                if (!(buttonConfig instanceof TopBarButtonConfiguration.Basic)) {
                    startRestartGroup.startReplaceGroup(1729985395);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(1729991767);
                TopBarButtonConfiguration.Basic basic = (TopBarButtonConfiguration.Basic) buttonConfig;
                int iconRes = basic.getIconRes();
                Integer contentDescriptionRes = basic.getContentDescriptionRes();
                final Function1<NavController, Unit> action = basic.getAction();
                startRestartGroup.startReplaceGroup(1729997980);
                if (action == null) {
                    function0 = null;
                } else {
                    startRestartGroup.startReplaceGroup(-395817207);
                    boolean changed = startRestartGroup.changed(action) | startRestartGroup.changedInstance(navController);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: V1.h
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit TopBarButton$lambda$11$lambda$8$lambda$7$lambda$6$lambda$5;
                                TopBarButton$lambda$11$lambda$8$lambda$7$lambda$6$lambda$5 = TopBarButtonKt.TopBarButton$lambda$11$lambda$8$lambda$7$lambda$6$lambda$5(Function1.this, navController);
                                return TopBarButton$lambda$11$lambda$8$lambda$7$lambda$6$lambda$5;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    function0 = (Function0) rememberedValue3;
                }
                startRestartGroup.endReplaceGroup();
                TopBarButtonBasicKt.TopBarButtonBasic(iconRes, contentDescriptionRes, function0, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            StateFlow<Boolean> showPopupState = buttonConfig.getShowPopupState();
            startRestartGroup.startReplaceGroup(-1253206270);
            if (showPopupState == null) {
                collectAsState = null;
                bool = null;
            } else {
                bool = null;
                collectAsState = SnapshotStateKt.collectAsState(showPopupState, null, startRestartGroup, 0, 1);
            }
            startRestartGroup.endReplaceGroup();
            Boolean bool2 = collectAsState != null ? (Boolean) collectAsState.getValue() : bool;
            startRestartGroup.startReplaceGroup(-1253204121);
            if (Intrinsics.areEqual(bool2, Boolean.TRUE) && (popupContent = buttonConfig.getPopupContent()) != null) {
                final LayoutCoordinates TopBarButton$lambda$1 = TopBarButton$lambda$1(mutableState);
                startRestartGroup.startReplaceGroup(-1253200456);
                if (TopBarButton$lambda$1 != null) {
                    AndroidPopup_androidKt.m2715PopupK5zGePQ(companion3.getTopEnd(), IntOffsetKt.IntOffset(0, IntSize.m2660getHeightimpl(TopBarButton$lambda$1.mo1948getSizeYbymL2g()) + ((int) ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(12), startRestartGroup, 6))), null, null, ComposableLambdaKt.rememberComposableLambda(762215672, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.topbar.TopBarButtonKt$TopBarButton$1$3$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            Shape m3383popupShapegGCzmOo;
                            if ((i7 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(762215672, i7, -1, "dk.molslinjen.ui.views.global.topbar.TopBarButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TopBarButton.kt:65)");
                            }
                            Modifier.Companion companion5 = Modifier.INSTANCE;
                            long m3274getTagBlue0d7_KjU = AppColor.INSTANCE.m3274getTagBlue0d7_KjU();
                            m3383popupShapegGCzmOo = TopBarButtonKt.m3383popupShapegGCzmOo(Dp.m2599constructorimpl(8), IntSize.m2661getWidthimpl(LayoutCoordinates.this.mo1948getSizeYbymL2g()) / 2.0f, Dp.m2599constructorimpl(6), composer2, 390);
                            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(companion5, m3274getTagBlue0d7_KjU, m3383popupShapegGCzmOo);
                            Function2<Composer, Integer, Unit> function2 = popupContent;
                            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU);
                            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor3 = companion6.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy3, companion6.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion6.getSetCompositeKeyHash();
                            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion6.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            function2.invoke(composer2, 0);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 24582, 12);
                }
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBarButton$lambda$12;
                    TopBarButton$lambda$12 = TopBarButtonKt.TopBarButton$lambda$12(TopBarButtonConfiguration.this, navController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBarButton$lambda$12;
                }
            });
        }
    }

    private static final LayoutCoordinates TopBarButton$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarButton$lambda$11$lambda$4$lambda$3(MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        mutableState.setValue(coordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarButton$lambda$11$lambda$8$lambda$7$lambda$6$lambda$5(Function1 function1, NavController navController) {
        function1.invoke(navController);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarButton$lambda$12(TopBarButtonConfiguration topBarButtonConfiguration, NavController navController, int i5, Composer composer, int i6) {
        TopBarButton(topBarButtonConfiguration, navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: popupShape-gGCzmOo, reason: not valid java name */
    public static final Shape m3383popupShapegGCzmOo(float f5, final float f6, float f7, Composer composer, int i5) {
        composer.startReplaceGroup(1469177561);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1469177561, i5, -1, "dk.molslinjen.ui.views.global.topbar.popupShape (TopBarButton.kt:86)");
        }
        final float m3250dpToPx8Feqmps = ComposeExtensionsKt.m3250dpToPx8Feqmps(f5, composer, i5 & 14);
        final float m3250dpToPx8Feqmps2 = ComposeExtensionsKt.m3250dpToPx8Feqmps(f7, composer, (i5 >> 6) & 14);
        composer.startReplaceGroup(40950964);
        boolean changed = ((((i5 & 112) ^ 48) > 32 && composer.changed(f6)) || (i5 & 48) == 32) | composer.changed(m3250dpToPx8Feqmps2) | composer.changed(m3250dpToPx8Feqmps);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function3() { // from class: V1.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit popupShape_gGCzmOo$lambda$14$lambda$13;
                    popupShape_gGCzmOo$lambda$14$lambda$13 = TopBarButtonKt.popupShape_gGCzmOo$lambda$14$lambda$13(f6, m3250dpToPx8Feqmps2, m3250dpToPx8Feqmps, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    return popupShape_gGCzmOo$lambda$14$lambda$13;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        GenericShape genericShape = new GenericShape((Function3) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return genericShape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit popupShape_gGCzmOo$lambda$14$lambda$13(float f5, float f6, float f7, Path GenericShape, Size size, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(GenericShape, "$this$GenericShape");
        Intrinsics.checkNotNullParameter(layoutDirection, "<unused var>");
        float m1377getWidthimpl = (Size.m1377getWidthimpl(size.getPackedValue()) - f5) - f6;
        GenericShape.lineTo(m1377getWidthimpl, 0.0f);
        GenericShape.lineTo(m1377getWidthimpl + f6, -f6);
        GenericShape.lineTo(m1377getWidthimpl + (2 * f6), 0.0f);
        Path.addRoundRect$default(GenericShape, RoundRectKt.m1369RoundRectsniSvfs(new Rect(0.0f, 0.0f, Size.m1377getWidthimpl(size.getPackedValue()), Size.m1375getHeightimpl(size.getPackedValue())), CornerRadiusKt.CornerRadius$default(f7, 0.0f, 2, null)), null, 2, null);
        GenericShape.close();
        return Unit.INSTANCE;
    }
}
