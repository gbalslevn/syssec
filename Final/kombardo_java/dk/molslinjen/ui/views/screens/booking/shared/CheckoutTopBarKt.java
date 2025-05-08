package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.TicketSectionExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutTopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aA\u0010\t\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketSection;", "sections", "activeSection", BuildConfig.FLAVOR, "showClickableVariant", "Lkotlin/Function1;", BuildConfig.FLAVOR, "navigateBackToSection", "CheckoutTopBar", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/TicketSection;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutTopBarKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static final void CheckoutTopBar(final List<? extends TicketSection> sections, final TicketSection activeSection, final boolean z5, final Function1<? super TicketSection, Unit> navigateBackToSection, Composer composer, final int i5) {
        Composer composer2;
        int i6;
        TicketSection ticketSection;
        int i7;
        ?? r12;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(activeSection, "activeSection");
        Intrinsics.checkNotNullParameter(navigateBackToSection, "navigateBackToSection");
        Composer startRestartGroup = composer.startRestartGroup(-287363713);
        int i8 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(sections) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(activeSection) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(navigateBackToSection) ? 2048 : 1024;
        }
        int i9 = i8;
        if ((i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287363713, i9, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutTopBar (CheckoutTopBar.kt:43)");
            }
            startRestartGroup.startReplaceGroup(1017344401);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(1017348025);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Rect.INSTANCE.getZero(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState3 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1017349873);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion2, appColor.m3259getBrandDarkBlue10d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceGroup(1017354865);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: a3.K
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutTopBar$lambda$4$lambda$3;
                        CheckoutTopBar$lambda$4$lambda$3 = CheckoutTopBarKt.CheckoutTopBar$lambda$4$lambda$3(MutableState.this, (LayoutCoordinates) obj);
                        return CheckoutTopBar$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m104backgroundbw27NRU$default, (Function1) rememberedValue4);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i10 = i9;
            MutableState mutableState5 = mutableState3;
            int i11 = 6;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3268getGrey50d7_KjU(), 0.2f), Dp.m2599constructorimpl((float) 0.5d), null, startRestartGroup, 384, 9);
            Modifier horizontalScroll$default = ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), rememberScrollState, true, null, false, 12, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion3.getCenterVertically(), startRestartGroup, 54);
            boolean z6 = false;
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, horizontalScroll$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int indexOf = sections.indexOf(activeSection);
            startRestartGroup.startReplaceGroup(1820162262);
            int i12 = 0;
            for (Object obj : sections) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TicketSection ticketSection2 = (TicketSection) obj;
                startRestartGroup.startReplaceGroup(1820162628);
                if (i12 > 0) {
                    i6 = i12;
                    ticketSection = ticketSection2;
                    i7 = indexOf;
                    r12 = z6;
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrow, startRestartGroup, i11), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), ColorKt.Color(4291679710L), startRestartGroup, 3456, 0);
                } else {
                    i6 = i12;
                    ticketSection = ticketSection2;
                    i7 = indexOf;
                    r12 = z6;
                }
                startRestartGroup.endReplaceGroup();
                Modifier.Companion companion5 = Modifier.INSTANCE;
                int i14 = i7;
                boolean z7 = (!z5 || i6 >= i14) ? r12 : true;
                startRestartGroup.startReplaceGroup(1011308358);
                int i15 = i10;
                final TicketSection ticketSection3 = ticketSection;
                boolean changed = ((i15 & 7168) == 2048 ? true : r12) | startRestartGroup.changed(ticketSection3);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: a3.L
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$6$lambda$5;
                            CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$6$lambda$5 = CheckoutTopBarKt.CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$6$lambda$5(Function1.this, ticketSection3);
                            return CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion5, z7, null, null, (Function0) rememberedValue5, 6, null);
                float f5 = 8;
                float m2599constructorimpl = Dp.m2599constructorimpl(f5);
                if (z5) {
                    f5 = 12;
                }
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(m122clickableXHw0xAI$default, m2599constructorimpl, Dp.m2599constructorimpl(f5));
                boolean z8 = ticketSection3 == activeSection ? true : r12;
                startRestartGroup.startReplaceGroup(1011316620);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    mutableState = mutableState5;
                    rememberedValue6 = new Function1() { // from class: a3.M
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Modifier CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8;
                            CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8 = CheckoutTopBarKt.CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8(MutableState.this, mutableState4, (Modifier) obj2);
                            return CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                } else {
                    mutableState = mutableState5;
                }
                startRestartGroup.endReplaceGroup();
                Composer composer3 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(TicketSectionExtensionsKt.getTitle(ticketSection3), startRestartGroup, r12), ModifierExtensionsKt.applyIf(m312paddingVpY3zN4, z8, (Function1) rememberedValue6), ticketSection3 == activeSection ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3268getGrey50d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, z5 ? ticketSection3 == activeSection ? r42.m2295copyp1EtxEg((r48 & 1) != 0 ? r42.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r42.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r42.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r42.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r42.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r42.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r42.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r42.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r42.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r42.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r42.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r42.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r42.spanStyle.getTextDecoration() : TextDecoration.INSTANCE.getUnderline(), (r48 & 8192) != 0 ? r42.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r42.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r42.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r42.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r42.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r42.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r42.platformStyle : null, (r48 & 1048576) != 0 ? r42.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r42.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r42.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSubBold().paragraphStyle.getTextMotion() : null) : TypographyKt.getSub() : ticketSection3 == activeSection ? TypographyKt.getSubSmallBold() : TypographyKt.getSubSmall(), composer3, 0, 3072, 57336);
                startRestartGroup = composer3;
                mutableState5 = mutableState;
                i10 = i15;
                i12 = i13;
                indexOf = i14;
                i11 = 6;
                z6 = false;
            }
            Composer composer4 = startRestartGroup;
            int i16 = i10;
            MutableState mutableState6 = mutableState5;
            composer4.endReplaceGroup();
            composer2 = composer4;
            composer2.startReplaceGroup(1820213674);
            boolean changed2 = composer2.changed(rememberScrollState);
            Object rememberedValue7 = composer2.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new CheckoutTopBarKt$CheckoutTopBar$2$1$2$1(mutableState6, mutableState2, rememberScrollState, null);
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(activeSection, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, (i16 >> 3) & 14);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.N
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit CheckoutTopBar$lambda$14;
                    CheckoutTopBar$lambda$14 = CheckoutTopBarKt.CheckoutTopBar$lambda$14(sections, activeSection, z5, navigateBackToSection, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return CheckoutTopBar$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$6$lambda$5(Function1 function1, TicketSection ticketSection) {
        function1.invoke(ticketSection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8(final MutableState mutableState, final MutableState mutableState2, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return OnGloballyPositionedModifierKt.onGloballyPositioned(applyIf, new Function1() { // from class: a3.J
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7;
                CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7 = CheckoutTopBarKt.CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, mutableState2, (LayoutCoordinates) obj);
                return CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutTopBar$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7(MutableState mutableState, MutableState mutableState2, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(LayoutCoordinatesKt.boundsInParent(it));
        LayoutCoordinates parentCoordinates = it.getParentCoordinates();
        mutableState2.setValue(Integer.valueOf(parentCoordinates != null ? IntSize.m2661getWidthimpl(parentCoordinates.mo1948getSizeYbymL2g()) : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutTopBar$lambda$14(List list, TicketSection ticketSection, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        CheckoutTopBar(list, ticketSection, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutTopBar$lambda$4$lambda$3(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }
}
