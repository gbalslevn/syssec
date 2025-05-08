package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectedCardViewKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001aQ\u0010\n\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "outboundSelectedProducts", "returnSelectedProducts", BuildConfig.FLAVOR, "onlyShowReturn", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showTransportProductsSelector", "removeAllSelectedTransportProducts", "TransportProductSelectedCardView", "(Ljava/util/List;Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddView", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransportProductSelectedCardViewKt {
    private static final void AddView(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-118360941);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118360941, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.AddView (TransportProductSelectedCardView.kt:99)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 1, null);
            startRestartGroup.startReplaceGroup(-1257554792);
            boolean z5 = (i6 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: S2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddView$lambda$12$lambda$11;
                        AddView$lambda$12$lambda$11 = TransportProductSelectedCardViewKt.AddView$lambda$12$lambda$11(Function0.this);
                        return AddView$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m313paddingVpY3zN4$default, false, null, null, (Function0) rememberedValue, 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_plus_button, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(Feature.BikeOrStroller.isEnabled() ? R.string.transportProducts_addBikeOrStroller_headline : R.string.transportProducts_addBikeOrScooter_headline, startRestartGroup, 0), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 432, 1572864, 65528);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddView$lambda$14;
                    AddView$lambda$14 = TransportProductSelectedCardViewKt.AddView$lambda$14(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddView$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddView$lambda$12$lambda$11(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddView$lambda$14(Function0 function0, int i5, Composer composer, int i6) {
        AddView(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TransportProductSelectedCardView(final List<? extends Product> outboundSelectedProducts, final List<? extends Product> list, final boolean z5, final Function0<Unit> showTransportProductsSelector, final Function0<Unit> removeAllSelectedTransportProducts, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        boolean z6;
        Composer composer2;
        boolean z7;
        int i8;
        Composer composer3;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(outboundSelectedProducts, "outboundSelectedProducts");
        Intrinsics.checkNotNullParameter(showTransportProductsSelector, "showTransportProductsSelector");
        Intrinsics.checkNotNullParameter(removeAllSelectedTransportProducts, "removeAllSelectedTransportProducts");
        Composer startRestartGroup = composer.startRestartGroup(-507670401);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(outboundSelectedProducts) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(showTransportProductsSelector) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(removeAllSelectedTransportProducts) ? 16384 : 8192;
        }
        int i9 = i6;
        if ((i9 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-507670401, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectedCardView (TransportProductSelectedCardView.kt:35)");
            }
            if ((!z5 || (list != null && (!list.isEmpty()))) && (!outboundSelectedProducts.isEmpty() || (list != null && (!list.isEmpty())))) {
                startRestartGroup.startReplaceGroup(-1437253066);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (list == null || Intrinsics.areEqual(outboundSelectedProducts, list) || z5) {
                    companion = companion3;
                    i7 = i9;
                    z6 = true;
                    startRestartGroup.startReplaceGroup(-1757047681);
                    List<? extends Product> list2 = z5 ? list : outboundSelectedProducts;
                    if (list2 == null) {
                        list2 = CollectionsKt.emptyList();
                    }
                    List<? extends Product> list3 = list2;
                    startRestartGroup.startReplaceGroup(497515661);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: S2.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                CharSequence TransportProductSelectedCardView$lambda$9$lambda$6$lambda$5;
                                TransportProductSelectedCardView$lambda$9$lambda$6$lambda$5 = TransportProductSelectedCardViewKt.TransportProductSelectedCardView$lambda$9$lambda$6$lambda$5((Product) obj);
                                return TransportProductSelectedCardView$lambda$9$lambda$6$lambda$5;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    String joinToString$default2 = CollectionsKt.joinToString$default(list3, ", ", null, null, 0, null, (Function1) rememberedValue, 30, null);
                    Product product = (Product) CollectionsKt.firstOrNull((List) list2);
                    ProductPresentation presentation = product != null ? product.getPresentation() : null;
                    ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
                    composer2 = startRestartGroup;
                    z7 = false;
                    i8 = 6;
                    LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(Feature.BikeOrStroller.isEnabled() ? R.string.transportProducts_bikeOrStrollerSelected_headline : R.string.transportProducts_bikeOrScooterSelected_headline, startRestartGroup, 0), joinToString$default2, RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), null, imageProductPresentation != null ? imageProductPresentation.getImageUrl() : null, null, false, 0L, 0.0f, showTransportProductsSelector, composer2, (i7 << 18) & 1879048192, 488);
                    composer2.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1758459576);
                    String stringResource = StringResources_androidKt.stringResource(R.string.transportProducts_noneSelected, startRestartGroup, 6);
                    List<? extends Product> list4 = outboundSelectedProducts;
                    startRestartGroup.startReplaceGroup(497468845);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    Composer.Companion companion5 = Composer.INSTANCE;
                    if (rememberedValue2 == companion5.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: S2.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                CharSequence TransportProductSelectedCardView$lambda$9$lambda$1$lambda$0;
                                TransportProductSelectedCardView$lambda$9$lambda$1$lambda$0 = TransportProductSelectedCardViewKt.TransportProductSelectedCardView$lambda$9$lambda$1$lambda$0((Product) obj);
                                return TransportProductSelectedCardView$lambda$9$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    String nullIfEmpty = StringExtensionsKt.nullIfEmpty(CollectionsKt.joinToString$default(list4, ", ", null, null, 0, null, (Function1) rememberedValue2, 30, null));
                    if (nullIfEmpty == null) {
                        nullIfEmpty = stringResource;
                    }
                    startRestartGroup.startReplaceGroup(497473632);
                    if (list == null) {
                        joinToString$default = null;
                    } else {
                        List<? extends Product> list5 = list;
                        startRestartGroup.startReplaceGroup(497474221);
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion5.getEmpty()) {
                            rememberedValue3 = new Function1() { // from class: S2.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    CharSequence TransportProductSelectedCardView$lambda$9$lambda$3$lambda$2;
                                    TransportProductSelectedCardView$lambda$9$lambda$3$lambda$2 = TransportProductSelectedCardViewKt.TransportProductSelectedCardView$lambda$9$lambda$3$lambda$2((Product) obj);
                                    return TransportProductSelectedCardView$lambda$9$lambda$3$lambda$2;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        joinToString$default = CollectionsKt.joinToString$default(list5, ", ", null, null, 0, null, (Function1) rememberedValue3, 30, null);
                    }
                    startRestartGroup.endReplaceGroup();
                    String nullIfEmpty2 = StringExtensionsKt.nullIfEmpty(joinToString$default);
                    String str = nullIfEmpty2 == null ? stringResource : nullIfEmpty2;
                    Modifier height = IntrinsicKt.height(companion3, IntrinsicSize.Max);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, height);
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
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                    String stringResource2 = StringResources_androidKt.stringResource(R.string.departures_return_outbound, startRestartGroup, 6);
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i10 = MaterialTheme.$stable;
                    CornerBasedShape medium = materialTheme.getShapes(startRestartGroup, i10).getMedium();
                    float f5 = 0;
                    int i11 = (i9 << 18) & 1879048192;
                    companion = companion3;
                    z6 = true;
                    i7 = i9;
                    composer2 = startRestartGroup;
                    LabelCardKt.m3391LabelCardTek12BE(stringResource2, nullIfEmpty, weight$default, CornerBasedShape.copy$default(medium, null, CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), null, 9, null), null, null, false, 0L, 0.0f, showTransportProductsSelector, composer2, i11, 496);
                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                    Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                    i8 = 6;
                    LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.departures_return_return, composer2, 6), str, weight$default2, CornerBasedShape.copy$default(materialTheme.getShapes(composer2, i10).getMedium(), CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), null, null, CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), 6, null), null, null, false, 0L, 0.0f, showTransportProductsSelector, composer2, i11, 496);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                    z7 = false;
                }
                Composer composer4 = composer2;
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_minus_button, composer4, i8);
                String skip = Accessibility.INSTANCE.getSkip();
                float f6 = 16;
                Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), 4, null), Dp.m2599constructorimpl(24));
                composer4.startReplaceGroup(497550698);
                boolean z8 = (i7 & 57344) == 16384 ? z6 : z7;
                Object rememberedValue4 = composer4.rememberedValue();
                if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: S2.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TransportProductSelectedCardView$lambda$9$lambda$8$lambda$7;
                            TransportProductSelectedCardView$lambda$9$lambda$8$lambda$7 = TransportProductSelectedCardViewKt.TransportProductSelectedCardView$lambda$9$lambda$8$lambda$7(Function0.this);
                            return TransportProductSelectedCardView$lambda$9$lambda$8$lambda$7;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue4);
                }
                composer4.endReplaceGroup();
                composer3 = composer4;
                ImageKt.Image(painterResource, skip, ClickableKt.m122clickableXHw0xAI$default(m331size3ABfNKs, false, null, null, (Function0) rememberedValue4, 7, null), null, null, 0.0f, null, composer4, 0, 120);
                composer3.endNode();
                composer3.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1434314359);
                AddView(showTransportProductsSelector, startRestartGroup, (i9 >> 9) & 14);
                startRestartGroup.endReplaceGroup();
                composer3 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportProductSelectedCardView$lambda$10;
                    TransportProductSelectedCardView$lambda$10 = TransportProductSelectedCardViewKt.TransportProductSelectedCardView$lambda$10(outboundSelectedProducts, list, z5, showTransportProductsSelector, removeAllSelectedTransportProducts, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportProductSelectedCardView$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSelectedCardView$lambda$10(List list, List list2, boolean z5, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        TransportProductSelectedCardView(list, list2, z5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence TransportProductSelectedCardView$lambda$9$lambda$1$lambda$0(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int quantity = it.getQuantity();
        String lowerCase = it.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return quantity + " " + lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence TransportProductSelectedCardView$lambda$9$lambda$3$lambda$2(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int quantity = it.getQuantity();
        String lowerCase = it.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return quantity + " " + lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence TransportProductSelectedCardView$lambda$9$lambda$6$lambda$5(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int quantity = it.getQuantity();
        String lowerCase = it.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return quantity + " " + lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSelectedCardView$lambda$9$lambda$8$lambda$7(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
