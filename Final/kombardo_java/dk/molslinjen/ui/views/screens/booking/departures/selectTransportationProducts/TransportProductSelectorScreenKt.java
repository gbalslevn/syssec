package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.extensions.PriceWithCurrencyExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.BikeProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.QuantityProduct;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001aI\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\fH\u0003¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "TransportProductSelectorScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;", "outboundState", "returnState", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "changeQuantity", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onChangedSameForBothDirections", "TransportProductSelectorContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "transportProductsState", "departureDirection", "enabled", "TransportProductSection", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransportProductSelectorScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TransportProductSection(final TransportProductSelectorViewModel.TransportProductsState transportProductsState, final DepartureDirection departureDirection, boolean z5, final Function3<? super Integer, ? super Product, ? super DepartureDirection, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        int i10;
        int i11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-950851207);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(transportProductsState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = 32;
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(departureDirection) ? 32 : 16;
        }
        int i13 = i6 & 4;
        if (i13 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 256 : 128;
            int i14 = 2048;
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i8 = i7;
            if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                z7 = i13 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-950851207, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSection (TransportProductSelectorScreen.kt:137)");
                }
                for (final Product product : transportProductsState.getProducts()) {
                    if (product instanceof QuantityProduct) {
                        startRestartGroup.startReplaceGroup(-1673694451);
                        QuantityProduct quantityProduct = (QuantityProduct) product;
                        int quantity = quantityProduct.getQuantity();
                        int minFirstStep = quantityProduct.getMinFirstStep();
                        int maxQuantity = quantityProduct.getMaxQuantity();
                        String name = quantityProduct.getName();
                        startRestartGroup.startReplaceGroup(638754609);
                        int i15 = i8 & 7168;
                        int i16 = i8 & 112;
                        boolean changedInstance = (i15 == i14) | startRestartGroup.changedInstance(product) | (i16 == i12);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1() { // from class: S2.j
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit TransportProductSection$lambda$5$lambda$4;
                                    TransportProductSection$lambda$5$lambda$4 = TransportProductSelectorScreenKt.TransportProductSection$lambda$5$lambda$4(Function3.this, product, departureDirection, ((Integer) obj).intValue());
                                    return TransportProductSection$lambda$5$lambda$4;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        Function1 function1 = (Function1) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(638758929);
                        boolean changedInstance2 = (i15 == i14) | startRestartGroup.changedInstance(product) | (i16 == i12);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: S2.k
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit TransportProductSection$lambda$7$lambda$6;
                                    TransportProductSection$lambda$7$lambda$6 = TransportProductSelectorScreenKt.TransportProductSection$lambda$7$lambda$6(Function3.this, product, departureDirection, ((Integer) obj).intValue());
                                    return TransportProductSection$lambda$7$lambda$6;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        NumberSelectorKt.NumberSelector(null, quantity, minFirstStep, 0, maxQuantity, null, name, null, function1, (Function1) rememberedValue2, null, true, false, z7, false, startRestartGroup, 0, ((i8 << 3) & 7168) | 48, 21673);
                        startRestartGroup.endReplaceGroup();
                        i9 = i8;
                        i10 = 32;
                        i11 = 2048;
                    } else {
                        int i17 = i8;
                        if (product instanceof BikeProduct) {
                            startRestartGroup.startReplaceGroup(-1673054859);
                            BikeProduct bikeProduct = (BikeProduct) product;
                            int quantity2 = bikeProduct.getQuantity();
                            PriceWithCurrency nullIfZero = PriceWithCurrencyExtensionsKt.nullIfZero(bikeProduct.getPrice());
                            int minFirstStep2 = bikeProduct.getMinFirstStep();
                            int maxQuantity2 = bikeProduct.getMaxQuantity();
                            String name2 = bikeProduct.getName();
                            startRestartGroup.startReplaceGroup(638776977);
                            int i18 = i17 & 7168;
                            int i19 = i17 & 112;
                            boolean changedInstance3 = (i18 == 2048) | startRestartGroup.changedInstance(product) | (i19 == 32);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: S2.l
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit TransportProductSection$lambda$9$lambda$8;
                                        TransportProductSection$lambda$9$lambda$8 = TransportProductSelectorScreenKt.TransportProductSection$lambda$9$lambda$8(Function3.this, product, departureDirection, ((Integer) obj).intValue());
                                        return TransportProductSection$lambda$9$lambda$8;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            Function1 function12 = (Function1) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(638781297);
                            boolean changedInstance4 = (i19 == 32) | (i18 == 2048) | startRestartGroup.changedInstance(product);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: S2.m
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit TransportProductSection$lambda$11$lambda$10;
                                        TransportProductSection$lambda$11$lambda$10 = TransportProductSelectorScreenKt.TransportProductSection$lambda$11$lambda$10(Function3.this, product, departureDirection, ((Integer) obj).intValue());
                                        return TransportProductSection$lambda$11$lambda$10;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceGroup();
                            i10 = 32;
                            i11 = 2048;
                            i9 = i17;
                            NumberSelectorKt.NumberSelector(null, quantity2, minFirstStep2, 0, maxQuantity2, null, name2, nullIfZero, function12, (Function1) rememberedValue4, null, true, false, z7, false, startRestartGroup, 0, ((i17 << 3) & 7168) | 48, 21545);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            i9 = i17;
                            i10 = 32;
                            i11 = 2048;
                            startRestartGroup.startReplaceGroup(-1672391986);
                            startRestartGroup.endReplaceGroup();
                        }
                    }
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
                    i12 = i10;
                    i14 = i11;
                    i8 = i9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final boolean z8 = z7;
                endRestartGroup.updateScope(new Function2() { // from class: S2.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TransportProductSection$lambda$12;
                        TransportProductSection$lambda$12 = TransportProductSelectorScreenKt.TransportProductSection$lambda$12(TransportProductSelectorViewModel.TransportProductsState.this, departureDirection, z8, function3, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return TransportProductSection$lambda$12;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        int i142 = 2048;
        if ((i6 & 8) == 0) {
        }
        i8 = i7;
        if ((i8 & 1171) == 1170) {
        }
        if (i13 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        while (r0.hasNext()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSection$lambda$11$lambda$10(Function3 function3, Product product, DepartureDirection departureDirection, int i5) {
        function3.invoke(Integer.valueOf(i5), product, departureDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSection$lambda$12(TransportProductSelectorViewModel.TransportProductsState transportProductsState, DepartureDirection departureDirection, boolean z5, Function3 function3, int i5, int i6, Composer composer, int i7) {
        TransportProductSection(transportProductsState, departureDirection, z5, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSection$lambda$5$lambda$4(Function3 function3, Product product, DepartureDirection departureDirection, int i5) {
        function3.invoke(Integer.valueOf(i5), product, departureDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSection$lambda$7$lambda$6(Function3 function3, Product product, DepartureDirection departureDirection, int i5) {
        function3.invoke(Integer.valueOf(i5), product, departureDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSection$lambda$9$lambda$8(Function3 function3, Product product, DepartureDirection departureDirection, int i5) {
        function3.invoke(Integer.valueOf(i5), product, departureDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TransportProductSelectorContent(final TransportProductSelectorViewModel.ViewState viewState, final TransportProductSelectorViewModel.TransportProductsState transportProductsState, final TransportProductSelectorViewModel.TransportProductsState transportProductsState2, final Function3<? super Integer, ? super Product, ? super DepartureDirection, Unit> function3, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5) {
        int i6;
        BookingType bookingType;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(642518042);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(transportProductsState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(transportProductsState2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(642518042, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorContent (TransportProductSelectorScreen.kt:85)");
            }
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(ScrollKt.verticalScroll$default(companion, rememberScrollState, false, null, false, 14, null), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1880722405);
            BookingType bookingType2 = viewState.getBookingType();
            BookingType bookingType3 = BookingType.TwoWay;
            if (bookingType2 == bookingType3) {
                SwitchRowKt.SwitchRow(null, StringResources_androidKt.stringResource(R.string.transportProducts_sameCountOutAndReturn, startRestartGroup, 6), viewState.getSameForBothDirections(), function1, startRestartGroup, (i6 >> 3) & 7168, 1);
                i7 = 16;
                bookingType = bookingType3;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(viewState.getSameForBothDirections() ? R.string.departures_return_outAndReturn : R.string.departures_return_outbound, startRestartGroup, 0), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
            } else {
                bookingType = bookingType3;
                i7 = 16;
            }
            startRestartGroup.endReplaceGroup();
            int i8 = i6 & 7168;
            TransportProductSection(transportProductsState, DepartureDirection.Outbound, !viewState.getIsAddingReturnFromBookingSummary(), function3, startRestartGroup, ((i6 >> 3) & 14) | 48 | i8, 0);
            startRestartGroup.startReplaceGroup(-1880689539);
            if (!viewState.getSameForBothDirections() && viewState.getBookingType() == bookingType) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(i7), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
                TransportProductSection(transportProductsState2, DepartureDirection.Return, false, function3, startRestartGroup, ((i6 >> 6) & 14) | 48 | i8, 4);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportProductSelectorContent$lambda$3;
                    TransportProductSelectorContent$lambda$3 = TransportProductSelectorScreenKt.TransportProductSelectorContent$lambda$3(TransportProductSelectorViewModel.ViewState.this, transportProductsState, transportProductsState2, function3, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportProductSelectorContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSelectorContent$lambda$3(TransportProductSelectorViewModel.ViewState viewState, TransportProductSelectorViewModel.TransportProductsState transportProductsState, TransportProductSelectorViewModel.TransportProductsState transportProductsState2, Function3 function3, Function1 function1, int i5, Composer composer, int i6) {
        TransportProductSelectorContent(viewState, transportProductsState, transportProductsState2, function3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TransportProductSelectorScreen(final TransportProductSelectorViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(469830852);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(469830852, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorScreen (TransportProductSelectorScreen.kt:41)");
            }
            final TransportProductSelectorViewModel.ViewState viewState = (TransportProductSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final TransportProductSelectorViewModel.TransportProductsState transportProductsState = (TransportProductSelectorViewModel.TransportProductsState) SnapshotStateKt.collectAsState(viewModel.getOutboundProductsState(), null, startRestartGroup, 0, 1).getValue();
            final TransportProductSelectorViewModel.TransportProductsState transportProductsState2 = (TransportProductSelectorViewModel.TransportProductsState) SnapshotStateKt.collectAsState(viewModel.getReturnProductsState(), null, startRestartGroup, 0, 1).getValue();
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            String stringResource = StringResources_androidKt.stringResource(Feature.BikeOrStroller.isEnabled() ? R.string.transportProducts_addBikeOrStroller_headline : R.string.transportProducts_addBikeOrScooter_headline, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1178696853);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TransportProductSelectorScreenKt$TransportProductSelectorScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(2008071878, true, new TransportProductSelectorScreenKt$TransportProductSelectorScreen$2(viewState, transportProductsState, transportProductsState2, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(826216407, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorScreenKt$TransportProductSelectorScreen$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(826216407, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorScreen.<anonymous> (TransportProductSelectorScreen.kt:68)");
                    }
                    TransportProductSelectorViewModel.ViewState viewState2 = TransportProductSelectorViewModel.ViewState.this;
                    TransportProductSelectorViewModel.TransportProductsState transportProductsState3 = transportProductsState;
                    TransportProductSelectorViewModel.TransportProductsState transportProductsState4 = transportProductsState2;
                    TransportProductSelectorViewModel transportProductSelectorViewModel = viewModel;
                    composer3.startReplaceGroup(195966646);
                    boolean changedInstance = composer3.changedInstance(transportProductSelectorViewModel);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new TransportProductSelectorScreenKt$TransportProductSelectorScreen$3$1$1(transportProductSelectorViewModel);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceGroup();
                    Function3 function3 = (Function3) ((KFunction) rememberedValue2);
                    TransportProductSelectorViewModel transportProductSelectorViewModel2 = viewModel;
                    composer3.startReplaceGroup(195968966);
                    boolean changedInstance2 = composer3.changedInstance(transportProductSelectorViewModel2);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new TransportProductSelectorScreenKt$TransportProductSelectorScreen$3$2$1(transportProductSelectorViewModel2);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceGroup();
                    TransportProductSelectorScreenKt.TransportProductSelectorContent(viewState2, transportProductsState3, transportProductsState4, function3, (Function1) ((KFunction) rememberedValue3), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 905969664, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S2.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportProductSelectorScreen$lambda$1;
                    TransportProductSelectorScreen$lambda$1 = TransportProductSelectorScreenKt.TransportProductSelectorScreen$lambda$1(TransportProductSelectorViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportProductSelectorScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportProductSelectorScreen$lambda$1(TransportProductSelectorViewModel transportProductSelectorViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        TransportProductSelectorScreen(transportProductSelectorViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
