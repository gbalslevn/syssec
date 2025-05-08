package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.presentation.ProductInputType;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.screens.booking.addons.AddonViewKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a;\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/Product;", "product", BuildConfig.FLAVOR, "showBorder", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "AddonView", "(Ldk/molslinjen/domain/model/booking/product/Product;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AddonViewWithoutContainer", "(Ldk/molslinjen/domain/model/booking/product/Product;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AddonViewKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProductInputType.values().length];
            try {
                iArr[ProductInputType.Checkbox.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductInputType.Radio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductInputType.Numeric.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProductType.values().length];
            try {
                iArr2[ProductType.Catering.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProductType.Bunk.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void AddonView(final Product product, boolean z5, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(-174466634);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = 2 & i6;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((4 & i6) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onQuantityChanged) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                z5 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-174466634, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.AddonView (AddonView.kt:26)");
            }
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(z5 ? BorderKt.m108borderxT4_qwU(Modifier.INSTANCE, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()) : ModifierExtensionsKt.defaultShadow$default(Modifier.INSTANCE, null, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, closeKeyboardOnClickOutside);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            AddonViewWithoutContainer(product, onQuantityChanged, startRestartGroup, (i7 & 14) | ((i7 >> 3) & 112));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final boolean z6 = z5;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonView$lambda$1;
                    AddonView$lambda$1 = AddonViewKt.AddonView$lambda$1(Product.this, z6, onQuantityChanged, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonView$lambda$1(Product product, boolean z5, Function2 function2, int i5, int i6, Composer composer, int i7) {
        AddonView(product, z5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void AddonViewWithoutContainer(final Product product, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(780723513);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onQuantityChanged) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(780723513, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.AddonViewWithoutContainer (AddonView.kt:45)");
            }
            if (product instanceof IQuantityProduct) {
                IQuantityProduct iQuantityProduct = (IQuantityProduct) product;
                int i7 = WhenMappings.$EnumSwitchMapping$1[iQuantityProduct.getProductType().ordinal()];
                if (i7 == 1) {
                    startRestartGroup.startReplaceGroup(521612328);
                    FoodProductViewKt.FoodProductView(iQuantityProduct, onQuantityChanged, startRestartGroup, i6 & 112);
                    startRestartGroup.endReplaceGroup();
                } else if (i7 != 2) {
                    startRestartGroup.startReplaceGroup(-1009738524);
                    int i8 = WhenMappings.$EnumSwitchMapping$0[iQuantityProduct.getPresentation().getInputType().ordinal()];
                    if (i8 == 1) {
                        startRestartGroup.startReplaceGroup(521620235);
                        BooleanProductViewKt.BooleanProductView(iQuantityProduct, onQuantityChanged, startRestartGroup, i6 & 112);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        if (i8 == 2) {
                            startRestartGroup.startReplaceGroup(-1009550881);
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2() { // from class: D2.a
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit AddonViewWithoutContainer$lambda$2;
                                        AddonViewWithoutContainer$lambda$2 = AddonViewKt.AddonViewWithoutContainer$lambda$2(Product.this, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return AddonViewWithoutContainer$lambda$2;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i8 != 3) {
                            startRestartGroup.startReplaceGroup(521617662);
                            startRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        startRestartGroup.startReplaceGroup(521625580);
                        QuantityProductViewKt.QuantityProductView(iQuantityProduct, onQuantityChanged, startRestartGroup, i6 & 112);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(521614760);
                    BunkProductViewKt.BunkProductView(iQuantityProduct, onQuantityChanged, startRestartGroup, i6 & 112);
                    startRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonViewWithoutContainer$lambda$3;
                    AddonViewWithoutContainer$lambda$3 = AddonViewKt.AddonViewWithoutContainer$lambda$3(Product.this, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonViewWithoutContainer$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonViewWithoutContainer$lambda$2(Product product, Function2 function2, int i5, Composer composer, int i6) {
        AddonViewWithoutContainer(product, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonViewWithoutContainer$lambda$3(Product product, Function2 function2, int i5, Composer composer, int i6) {
        AddonViewWithoutContainer(product, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
