package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.presentation.ProductInputType;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.addons.MultipleAddonsViewKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aG\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0012\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\t0\u0010H\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {BuildConfig.FLAVOR, "isBothDirections", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "outboundProducts", "returnProducts", "Lkotlin/Function3;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "MultipleAddonsView", "(ZLjava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "sourceDirection", "product", "matchingOppositeProduct", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "buildBooleanProductView", "HandleBidirectionalProducts", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/product/Product;Ldk/molslinjen/domain/model/booking/product/Product;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultipleAddonsViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final void HandleBidirectionalProducts(final DepartureDirection departureDirection, final Product product, final Product product2, final Function4<? super IQuantityProduct, ? super IQuantityProduct, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1930986356);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(departureDirection) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(product) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(product2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1930986356, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.HandleBidirectionalProducts (MultipleAddonsView.kt:82)");
            }
            if (product instanceof IQuantityProduct) {
                IQuantityProduct iQuantityProduct = (IQuantityProduct) product;
                ProductType productType = iQuantityProduct.getProductType();
                if (productType == ProductType.Catering) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Not supported summary product type: " + iQuantityProduct.getProductType()));
                } else if (productType == ProductType.Bunk) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Not supported summary product type: " + iQuantityProduct.getProductType()));
                } else {
                    ProductInputType inputType = iQuantityProduct.getPresentation().getInputType();
                    if (inputType == ProductInputType.Checkbox) {
                        IQuantityProduct iQuantityProduct2 = departureDirection == DepartureDirection.Outbound ? iQuantityProduct : product2 instanceof IQuantityProduct ? (IQuantityProduct) product2 : null;
                        if (departureDirection != DepartureDirection.Return) {
                            iQuantityProduct = product2 instanceof IQuantityProduct ? (IQuantityProduct) product2 : null;
                        }
                        function4.invoke(iQuantityProduct2, iQuantityProduct, startRestartGroup, Integer.valueOf((i6 >> 3) & 896));
                    } else {
                        if (inputType == ProductInputType.Radio) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2() { // from class: D2.J
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit HandleBidirectionalProducts$lambda$6;
                                        HandleBidirectionalProducts$lambda$6 = MultipleAddonsViewKt.HandleBidirectionalProducts$lambda$6(DepartureDirection.this, product, product2, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return HandleBidirectionalProducts$lambda$6;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (inputType != ProductInputType.Numeric) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Logger.INSTANCE.logCritical(new CriticalLog("Not supported summary product type: " + iQuantityProduct.getProductType()));
                    }
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.K
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HandleBidirectionalProducts$lambda$7;
                    HandleBidirectionalProducts$lambda$7 = MultipleAddonsViewKt.HandleBidirectionalProducts$lambda$7(DepartureDirection.this, product, product2, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HandleBidirectionalProducts$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleBidirectionalProducts$lambda$6(DepartureDirection departureDirection, Product product, Product product2, Function4 function4, int i5, Composer composer, int i6) {
        HandleBidirectionalProducts(departureDirection, product, product2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleBidirectionalProducts$lambda$7(DepartureDirection departureDirection, Product product, Product product2, Function4 function4, int i5, Composer composer, int i6) {
        HandleBidirectionalProducts(departureDirection, product, product2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultipleAddonsView(final boolean z5, final List<? extends Product> outboundProducts, final List<? extends Product> returnProducts, final Function3<? super DepartureDirection, ? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        List<? extends Product> list;
        Object obj;
        int i6;
        Product product;
        int i7;
        final Product product2;
        boolean z6;
        Object obj2;
        Intrinsics.checkNotNullParameter(outboundProducts, "outboundProducts");
        Intrinsics.checkNotNullParameter(returnProducts, "returnProducts");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(350164552);
        int i8 = (i5 & 6) == 0 ? (startRestartGroup.changed(z5) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(outboundProducts) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(returnProducts) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(onQuantityChanged) ? 2048 : 1024;
        }
        int i9 = i8;
        if ((i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(350164552, i9, -1, "dk.molslinjen.ui.views.screens.booking.addons.MultipleAddonsView (MultipleAddonsView.kt:26)");
            }
            if (outboundProducts.isEmpty() && returnProducts.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: D2.L
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Unit MultipleAddonsView$lambda$0;
                            MultipleAddonsView$lambda$0 = MultipleAddonsViewKt.MultipleAddonsView$lambda$0(z5, outboundProducts, returnProducts, onQuantityChanged, i5, (Composer) obj3, ((Integer) obj4).intValue());
                            return MultipleAddonsView$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Object obj3 = null;
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(ModifierExtensionsKt.defaultShadow$default(Modifier.INSTANCE, null, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            DepartureDirection departureDirection = DepartureDirection.Outbound;
            if (z5 && outboundProducts.isEmpty()) {
                departureDirection = DepartureDirection.Return;
                list = returnProducts;
            } else {
                list = outboundProducts;
            }
            startRestartGroup.startReplaceGroup(1911042914);
            int i10 = 0;
            for (Product product3 : list) {
                int i11 = i10 + 1;
                startRestartGroup.startReplaceGroup(1911043948);
                if (i10 > 0) {
                    obj = obj3;
                    i6 = i9;
                    product = product3;
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, obj3), 0L, 0.0f, null, startRestartGroup, 6, 14);
                } else {
                    obj = obj3;
                    i6 = i9;
                    product = product3;
                }
                startRestartGroup.endReplaceGroup();
                if (z5) {
                    startRestartGroup.startReplaceGroup(-887026986);
                    Iterator<T> it = returnProducts.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (Intrinsics.areEqual(((Product) obj2).getId(), product.getId())) {
                                break;
                            }
                        } else {
                            obj2 = obj;
                            break;
                        }
                    }
                    HandleBidirectionalProducts(departureDirection, product, (Product) obj2, ComposableLambdaKt.rememberComposableLambda(1372750990, true, new Function4<IQuantityProduct, IQuantityProduct, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.MultipleAddonsViewKt$MultipleAddonsView$2$1
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(IQuantityProduct iQuantityProduct, IQuantityProduct iQuantityProduct2, Composer composer2, Integer num) {
                            invoke(iQuantityProduct, iQuantityProduct2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(IQuantityProduct iQuantityProduct, IQuantityProduct iQuantityProduct2, Composer composer2, int i12) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(500441610, i12, -1, "dk.molslinjen.ui.views.screens.booking.addons.MultipleAddonsView.<anonymous>.<anonymous> (MultipleAddonsView.kt:57)");
                            }
                            BidirectionalBooleanProductViewKt.BidirectionalBooleanProductView(iQuantityProduct, iQuantityProduct2, onQuantityChanged, composer2, i12 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 3072);
                    startRestartGroup.endReplaceGroup();
                    i7 = i6;
                } else {
                    startRestartGroup.startReplaceGroup(-886331842);
                    startRestartGroup.startReplaceGroup(1911075112);
                    i7 = i6;
                    if ((i7 & 7168) == 2048) {
                        product2 = product;
                        z6 = true;
                    } else {
                        product2 = product;
                        z6 = false;
                    }
                    boolean changedInstance = startRestartGroup.changedInstance(product2) | z6;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function2() { // from class: D2.M
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                Unit MultipleAddonsView$lambda$4$lambda$3$lambda$2;
                                MultipleAddonsView$lambda$4$lambda$3$lambda$2 = MultipleAddonsViewKt.MultipleAddonsView$lambda$4$lambda$3$lambda$2(Function3.this, product2, (Product) obj4, ((Integer) obj5).intValue());
                                return MultipleAddonsView$lambda$4$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    AddonViewKt.AddonViewWithoutContainer(product2, (Function2) rememberedValue, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                i9 = i7;
                i10 = i11;
                obj3 = obj;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.N
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    Unit MultipleAddonsView$lambda$5;
                    MultipleAddonsView$lambda$5 = MultipleAddonsViewKt.MultipleAddonsView$lambda$5(z5, outboundProducts, returnProducts, onQuantityChanged, i5, (Composer) obj4, ((Integer) obj5).intValue());
                    return MultipleAddonsView$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultipleAddonsView$lambda$0(boolean z5, List list, List list2, Function3 function3, int i5, Composer composer, int i6) {
        MultipleAddonsView(z5, list, list2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultipleAddonsView$lambda$4$lambda$3$lambda$2(Function3 function3, Product product, Product product2, int i5) {
        Intrinsics.checkNotNullParameter(product2, "<unused var>");
        function3.invoke(DepartureDirection.Outbound, product, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultipleAddonsView$lambda$5(boolean z5, List list, List list2, Function3 function3, int i5, Composer composer, int i6) {
        MultipleAddonsView(z5, list, list2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
