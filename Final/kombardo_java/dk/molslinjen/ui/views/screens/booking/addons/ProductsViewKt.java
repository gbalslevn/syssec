package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a¡\u0001\u0010\u0019\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001c\u001a\u00020\u0013*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010 \u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b \u0010!\u001a/\u0010\"\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "productGroups", "Landroidx/compose/ui/text/AnnotatedString;", Constants.IntentExtra.PushTitle, "onWhiteBackground", BuildConfig.FLAVOR, "emptyDescription", "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "unavailableProducts", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "unavailableSeatReservationPrice", BuildConfig.FLAVOR, "emptyIcon", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, "onQuantityChanged", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Lkotlin/Function0;", "selectSeatingSection", "ProductsView", "(Landroidx/compose/foundation/layout/ColumnScope;ZLjava/util/List;Landroidx/compose/ui/text/AnnotatedString;ZLjava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ILkotlin/jvm/functions/Function2;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "productGroup", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/product/ProductGroup;ZLkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "HeaderView", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;I)V", "EmptyState", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/ui/text/AnnotatedString;Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProductsViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmptyState(final ColumnScope columnScope, final AnnotatedString annotatedString, final String str, final int i5, Composer composer, final int i6) {
        int i7;
        int i8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(796968991);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 2048 : 1024;
        }
        int i9 = i7;
        if ((i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(796968991, i9, -1, "dk.molslinjen.ui.views.screens.booking.addons.EmptyState (ProductsView.kt:155)");
            }
            startRestartGroup.startReplaceGroup(1370844258);
            if (annotatedString == null) {
                i8 = i9;
                composer2 = startRestartGroup;
            } else {
                i8 = i9;
                composer2 = startRestartGroup;
                TextKt.m941TextIbK3jfQ(annotatedString, PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(32), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getH2Bold(), composer2, ((i9 >> 3) & 14) | 48, 12582912, 131068);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier weight$default = ColumnScope.weight$default(columnScope, companion, 1.0f, false, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            startRestartGroup = composer2;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(32), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 9) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(64)), null, null, 0.0f, null, startRestartGroup, 384, 120);
            TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, ((i8 >> 6) & 14) | 432, 1572864, 65016);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.V
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyState$lambda$7;
                    EmptyState$lambda$7 = ProductsViewKt.EmptyState$lambda$7(ColumnScope.this, annotatedString, str, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyState$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyState$lambda$7(ColumnScope columnScope, AnnotatedString annotatedString, String str, int i5, int i6, Composer composer, int i7) {
        EmptyState(columnScope, annotatedString, str, i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderView(final AnnotatedString annotatedString, final TextStyle textStyle, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-331581605);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331581605, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.HeaderView (ProductsView.kt:144)");
            }
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null);
            startRestartGroup.startReplaceGroup(1150456096);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.T
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HeaderView$lambda$2$lambda$1;
                        HeaderView$lambda$2$lambda$1 = ProductsViewKt.HeaderView$lambda$2$lambda$1((SemanticsPropertyReceiver) obj);
                        return HeaderView$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TextKt.m941TextIbK3jfQ(annotatedString, SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, false, (Function1) rememberedValue, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, textStyle, composer2, i6 & 14, (i6 << 18) & 29360128, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.U
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderView$lambda$3;
                    HeaderView$lambda$3 = ProductsViewKt.HeaderView$lambda$3(AnnotatedString.this, textStyle, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderView$lambda$2$lambda$1(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderView$lambda$3(AnnotatedString annotatedString, TextStyle textStyle, int i5, Composer composer, int i6) {
        HeaderView(annotatedString, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProductsView(final ColumnScope columnScope, final boolean z5, final List<ProductGroup> list, final AnnotatedString annotatedString, boolean z6, final String emptyDescription, final List<UnavailableProduct> unavailableProducts, PriceWithCurrency priceWithCurrency, final int i5, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, LazyListState lazyListState, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        PriceWithCurrency priceWithCurrency2;
        int i12;
        int i13;
        int i14;
        boolean z7;
        LazyListState lazyListState2;
        boolean z8;
        Function2<? super Composer, ? super Integer, Unit> function22;
        PriceWithCurrency priceWithCurrency3;
        int i15;
        LazyListState lazyListState3;
        Composer composer2;
        final boolean z9;
        final PriceWithCurrency priceWithCurrency4;
        final LazyListState lazyListState4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i16;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(emptyDescription, "emptyDescription");
        Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(827131330);
        if ((Integer.MIN_VALUE & i8) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        if ((i8 & 1) != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i8 & 2) != 0) {
            i9 |= 384;
        } else if ((i6 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i8 & 4) != 0) {
            i9 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i9 |= startRestartGroup.changed(annotatedString) ? 2048 : 1024;
            i10 = i8 & 8;
            if (i10 == 0) {
                i9 |= 24576;
            } else if ((i6 & 24576) == 0) {
                i9 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                if ((i8 & 16) != 0) {
                    i9 |= 196608;
                } else if ((i6 & 196608) == 0) {
                    i9 |= startRestartGroup.changed(emptyDescription) ? 131072 : 65536;
                }
                if ((i8 & 32) != 0) {
                    i9 |= 1572864;
                } else if ((i6 & 1572864) == 0) {
                    i9 |= startRestartGroup.changedInstance(unavailableProducts) ? 1048576 : 524288;
                }
                i11 = i8 & 64;
                if (i11 != 0) {
                    i9 |= 12582912;
                    priceWithCurrency2 = priceWithCurrency;
                } else {
                    priceWithCurrency2 = priceWithCurrency;
                    if ((i6 & 12582912) == 0) {
                        i9 |= startRestartGroup.changedInstance(priceWithCurrency2) ? 8388608 : 4194304;
                    }
                }
                if ((i8 & 128) != 0) {
                    i9 |= 100663296;
                } else if ((i6 & 100663296) == 0) {
                    i9 |= startRestartGroup.changed(i5) ? 67108864 : 33554432;
                    if ((i8 & 256) == 0) {
                        i9 |= 805306368;
                    } else if ((i6 & 805306368) == 0) {
                        i9 |= startRestartGroup.changedInstance(onQuantityChanged) ? 536870912 : 268435456;
                    }
                    i12 = i9;
                    if ((i7 & 6) != 0) {
                        if ((i8 & 512) == 0 && startRestartGroup.changed(lazyListState)) {
                            i16 = 4;
                            i13 = i7 | i16;
                        }
                        i16 = 2;
                        i13 = i7 | i16;
                    } else {
                        i13 = i7;
                    }
                    i14 = i8 & 1024;
                    if (i14 == 0) {
                        i13 |= 48;
                    } else if ((i7 & 48) == 0) {
                        i13 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
                    }
                    if ((i12 & 306783379) != 306783378 && (i13 & 19) == 18 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        z9 = z6;
                        lazyListState4 = lazyListState;
                        function23 = function2;
                        priceWithCurrency4 = priceWithCurrency2;
                        composer2 = startRestartGroup;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            boolean z10 = i10 == 0 ? false : z6;
                            if (i11 != 0) {
                                priceWithCurrency2 = null;
                            }
                            if ((i8 & 512) == 0) {
                                z7 = z10;
                                lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                i13 &= -15;
                            } else {
                                z7 = z10;
                                lazyListState2 = lazyListState;
                            }
                            if (i14 == 0) {
                                z8 = z7;
                                function22 = null;
                            } else {
                                z8 = z7;
                                function22 = function2;
                            }
                            priceWithCurrency3 = priceWithCurrency2;
                            i15 = i13;
                            lazyListState3 = lazyListState2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i8 & 512) != 0) {
                                i13 &= -15;
                            }
                            z8 = z6;
                            function22 = function2;
                            priceWithCurrency3 = priceWithCurrency2;
                            i15 = i13;
                            lazyListState3 = lazyListState;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(827131330, i12, i15, "dk.molslinjen.ui.views.screens.booking.addons.ProductsView (ProductsView.kt:57)");
                        }
                        composer2 = startRestartGroup;
                        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-997341706, true, new ProductsViewKt$ProductsView$1(list, function22, priceWithCurrency3, columnScope, annotatedString, emptyDescription, i5, lazyListState3, unavailableProducts, onQuantityChanged, z8), composer2, 54), composer2, ((i12 << 3) & 896) | 1572864, 59);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z9 = z8;
                        priceWithCurrency4 = priceWithCurrency3;
                        lazyListState4 = lazyListState3;
                        function23 = function22;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: D2.W
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ProductsView$lambda$0;
                                ProductsView$lambda$0 = ProductsViewKt.ProductsView$lambda$0(ColumnScope.this, z5, list, annotatedString, z9, emptyDescription, unavailableProducts, priceWithCurrency4, i5, onQuantityChanged, lazyListState4, function23, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                                return ProductsView$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i8 & 256) == 0) {
                }
                i12 = i9;
                if ((i7 & 6) != 0) {
                }
                i14 = i8 & 1024;
                if (i14 == 0) {
                }
                if ((i12 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i10 == 0) {
                }
                if (i11 != 0) {
                }
                if ((i8 & 512) == 0) {
                }
                if (i14 == 0) {
                }
                priceWithCurrency3 = priceWithCurrency2;
                i15 = i13;
                lazyListState3 = lazyListState2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-997341706, true, new ProductsViewKt$ProductsView$1(list, function22, priceWithCurrency3, columnScope, annotatedString, emptyDescription, i5, lazyListState3, unavailableProducts, onQuantityChanged, z8), composer2, 54), composer2, ((i12 << 3) & 896) | 1572864, 59);
                if (ComposerKt.isTraceInProgress()) {
                }
                z9 = z8;
                priceWithCurrency4 = priceWithCurrency3;
                lazyListState4 = lazyListState3;
                function23 = function22;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i8 & 16) != 0) {
            }
            if ((i8 & 32) != 0) {
            }
            i11 = i8 & 64;
            if (i11 != 0) {
            }
            if ((i8 & 128) != 0) {
            }
            if ((i8 & 256) == 0) {
            }
            i12 = i9;
            if ((i7 & 6) != 0) {
            }
            i14 = i8 & 1024;
            if (i14 == 0) {
            }
            if ((i12 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i10 == 0) {
            }
            if (i11 != 0) {
            }
            if ((i8 & 512) == 0) {
            }
            if (i14 == 0) {
            }
            priceWithCurrency3 = priceWithCurrency2;
            i15 = i13;
            lazyListState3 = lazyListState2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-997341706, true, new ProductsViewKt$ProductsView$1(list, function22, priceWithCurrency3, columnScope, annotatedString, emptyDescription, i5, lazyListState3, unavailableProducts, onQuantityChanged, z8), composer2, 54), composer2, ((i12 << 3) & 896) | 1572864, 59);
            if (ComposerKt.isTraceInProgress()) {
            }
            z9 = z8;
            priceWithCurrency4 = priceWithCurrency3;
            lazyListState4 = lazyListState3;
            function23 = function22;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i10 = i8 & 8;
        if (i10 == 0) {
        }
        if ((i8 & 16) != 0) {
        }
        if ((i8 & 32) != 0) {
        }
        i11 = i8 & 64;
        if (i11 != 0) {
        }
        if ((i8 & 128) != 0) {
        }
        if ((i8 & 256) == 0) {
        }
        i12 = i9;
        if ((i7 & 6) != 0) {
        }
        i14 = i8 & 1024;
        if (i14 == 0) {
        }
        if ((i12 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if (i11 != 0) {
        }
        if ((i8 & 512) == 0) {
        }
        if (i14 == 0) {
        }
        priceWithCurrency3 = priceWithCurrency2;
        i15 = i13;
        lazyListState3 = lazyListState2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-997341706, true, new ProductsViewKt$ProductsView$1(list, function22, priceWithCurrency3, columnScope, annotatedString, emptyDescription, i5, lazyListState3, unavailableProducts, onQuantityChanged, z8), composer2, 54), composer2, ((i12 << 3) & 896) | 1572864, 59);
        if (ComposerKt.isTraceInProgress()) {
        }
        z9 = z8;
        priceWithCurrency4 = priceWithCurrency3;
        lazyListState4 = lazyListState3;
        function23 = function22;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductsView$lambda$0(ColumnScope columnScope, boolean z5, List list, AnnotatedString annotatedString, boolean z6, String str, List list2, PriceWithCurrency priceWithCurrency, int i5, Function2 function2, LazyListState lazyListState, Function2 function22, int i6, int i7, int i8, Composer composer, int i9) {
        ProductsView(columnScope, z5, list, annotatedString, z6, str, list2, priceWithCurrency, i5, function2, lazyListState, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void productGroup(LazyListScope lazyListScope, final ProductGroup productGroup, final boolean z5, final Function2<? super Product, ? super Integer, Unit> function2) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-650917669, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt$productGroup$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-650917669, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.productGroup.<anonymous> (ProductsView.kt:126)");
                }
                ProductsViewKt.HeaderView(new AnnotatedString(ProductGroup.this.getName(), null, null, 6, null), TypographyKt.getParagraphSmallBold(), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        for (final Product product : productGroup.getProducts()) {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1304379901, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt$productGroup$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1304379901, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.productGroup.<anonymous> (ProductsView.kt:134)");
                    }
                    AddonViewKt.AddonView(Product.this, z5, function2, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void productGroup$default(LazyListScope lazyListScope, ProductGroup productGroup, boolean z5, Function2 function2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        productGroup(lazyListScope, productGroup, z5, function2);
    }
}
