package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureDirectionTabsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001aE\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u0013\u001a\u00020\b*\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0016\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\rH\u0003¢\u0006\u0004\b\u0016\u0010\u0017\"\u0018\u0010\u000e\u001a\u00020\r*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selectedDepartureDirection", BuildConfig.FLAVOR, "outboundDepartureSelected", "returnDepartureSelected", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onDirectionDirectionChanged", "DepartureDirectionTabs", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "isSelected", "departureSelected", "Lkotlin/Function0;", "onClick", "DirectionScopeTab", "(Landroidx/compose/foundation/layout/RowScope;IZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "icon", "IconView", "(ILandroidx/compose/runtime/Composer;I)V", "getTitle", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;)I", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureDirectionTabsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void DepartureDirectionTabs(Modifier modifier, final DepartureDirection selectedDepartureDirection, final boolean z5, final boolean z6, final Function1<? super DepartureDirection, Unit> onDirectionDirectionChanged, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z7;
        boolean z8;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(selectedDepartureDirection, "selectedDepartureDirection");
        Intrinsics.checkNotNullParameter(onDirectionDirectionChanged, "onDirectionDirectionChanged");
        Composer startRestartGroup = composer.startRestartGroup(-1880719318);
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
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(selectedDepartureDirection) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
            z7 = z5;
        } else {
            z7 = z5;
            if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(z7) ? 256 : 128;
            }
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
            z8 = z6;
        } else {
            z8 = z6;
            if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changed(z8) ? 2048 : 1024;
            }
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(onDirectionDirectionChanged) ? 16384 : 8192;
        }
        int i9 = i7;
        if ((i9 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1880719318, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.DepartureDirectionTabs (DepartureDirectionTabs.kt:40)");
            }
            startRestartGroup.startReplaceGroup(-427258057);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = CollectionsKt.listOf((Object[]) new DepartureDirection[]{DepartureDirection.Outbound, DepartureDirection.Return});
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            List list = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1732746559);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final DepartureDirection departureDirection = (DepartureDirection) it.next();
                int title = getTitle(departureDirection);
                boolean z9 = departureDirection == selectedDepartureDirection;
                boolean z10 = departureDirection == DepartureDirection.Outbound ? z7 : z8;
                startRestartGroup.startReplaceGroup(830321531);
                Iterator it2 = it;
                boolean changed = ((57344 & i9) == 16384) | startRestartGroup.changed(departureDirection);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: J2.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DepartureDirectionTabs$lambda$4$lambda$3$lambda$2$lambda$1;
                            DepartureDirectionTabs$lambda$4$lambda$3$lambda$2$lambda$1 = DepartureDirectionTabsKt.DepartureDirectionTabs$lambda$4$lambda$3$lambda$2$lambda$1(Function1.this, departureDirection);
                            return DepartureDirectionTabs$lambda$4$lambda$3$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                DirectionScopeTab(rowScopeInstance, title, z9, z10, (Function0) rememberedValue2, startRestartGroup, 6);
                it = it2;
                i9 = i9;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: J2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureDirectionTabs$lambda$5;
                    DepartureDirectionTabs$lambda$5 = DepartureDirectionTabsKt.DepartureDirectionTabs$lambda$5(Modifier.this, selectedDepartureDirection, z5, z6, onDirectionDirectionChanged, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureDirectionTabs$lambda$5;
                }
            });
        }
    }

    public static final Unit DepartureDirectionTabs$lambda$4$lambda$3$lambda$2$lambda$1(Function1 function1, DepartureDirection departureDirection) {
        function1.invoke(departureDirection);
        return Unit.INSTANCE;
    }

    public static final Unit DepartureDirectionTabs$lambda$5(Modifier modifier, DepartureDirection departureDirection, boolean z5, boolean z6, Function1 function1, int i5, int i6, Composer composer, int i7) {
        DepartureDirectionTabs(modifier, departureDirection, z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void DirectionScopeTab(final RowScope rowScope, final int i5, final boolean z5, final boolean z6, final Function0<Unit> function0, Composer composer, final int i6) {
        int i7;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-299152741);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299152741, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.DirectionScopeTab (DepartureDirectionTabs.kt:71)");
            }
            startRestartGroup.startReplaceGroup(-635593332);
            if (z5) {
                float f5 = 0;
                modifier = BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), null, null, CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), 3, null));
            } else {
                modifier = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            Modifier weight$default = RowScope.weight$default(rowScope, PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(SizeKt.m324defaultMinSizeVpY3zN4$default(modifier, 0.0f, Dp.m2599constructorimpl(28), 1, null), false, null, null, function0, 7, null), 0.0f, Dp.m2599constructorimpl(12), 1, null), 1.0f, false, 2, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
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
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-1611947743);
            if (z6) {
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(20)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(i5, startRestartGroup, (i7 >> 3) & 14);
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, z5 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65018);
            startRestartGroup.startReplaceGroup(-1611937472);
            if (z6) {
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(4)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z6, (Modifier) null, EnterExitTransitionKt.fadeIn$default(new TweenSpec(500, 0, EasingKt.getFastOutSlowInEasing()), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(new TweenSpec(500, 0, EasingKt.getFastOutSlowInEasing()), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1268721887, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DepartureDirectionTabsKt$DirectionScopeTab$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i8) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1268721887, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.DirectionScopeTab.<anonymous>.<anonymous> (DepartureDirectionTabs.kt:110)");
                    }
                    CrossfadeKt.Crossfade(Boolean.valueOf(z5), (Modifier) null, new TweenSpec(500, 0, EasingKt.getFastOutSlowInEasing()), (String) null, ComposableSingletons$DepartureDirectionTabsKt.INSTANCE.m3456getLambda1$app_kombardoProd(), composer2, 24576, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 1572870 | ((i7 >> 6) & 112), 18);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DirectionScopeTab$lambda$7;
                    DirectionScopeTab$lambda$7 = DepartureDirectionTabsKt.DirectionScopeTab$lambda$7(RowScope.this, i5, z5, z6, function0, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return DirectionScopeTab$lambda$7;
                }
            });
        }
    }

    public static final Unit DirectionScopeTab$lambda$7(RowScope rowScope, int i5, boolean z5, boolean z6, Function0 function0, int i6, Composer composer, int i7) {
        DirectionScopeTab(rowScope, i5, z5, z6, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final void IconView(final int i5, Composer composer, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-105572983);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i7 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-105572983, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.IconView (DepartureDirectionTabs.kt:126)");
            }
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, i7 & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IconView$lambda$8;
                    IconView$lambda$8 = DepartureDirectionTabsKt.IconView$lambda$8(i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return IconView$lambda$8;
                }
            });
        }
    }

    public static final Unit IconView$lambda$8(int i5, int i6, Composer composer, int i7) {
        IconView(i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$IconView(int i5, Composer composer, int i6) {
        IconView(i5, composer, i6);
    }

    private static final int getTitle(DepartureDirection departureDirection) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            return R.string.departures_tab_outbound;
        }
        if (i5 == 2) {
            return R.string.departures_tab_returning;
        }
        throw new NoWhenBranchMatchedException();
    }
}
