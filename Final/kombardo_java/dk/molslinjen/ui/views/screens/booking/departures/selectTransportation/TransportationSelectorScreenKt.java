package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationCategory;
import dk.molslinjen.extensions.DoubleExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aA\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aG\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0010H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0018\u001a\u00020\n*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a7\u0010\u001a\u001a\u00020\n*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a=\u0010\u001f\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0010H\u0003¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0003¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010+\u001a\u00020)2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010-\u001a\u00020)2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b-\u0010,¨\u0006."}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CargoDetailsScreenDestination;", BuildConfig.FLAVOR, "cargoResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "resultNavigator", BuildConfig.FLAVOR, "TransportationSelectorScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;", "viewState", "showTicketCategories", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/config/Transportation;", "transportationSelected", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "transportationCategorySelected", "TransportationSelectorContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "transportationHeader", "(Landroidx/compose/foundation/lazy/LazyListScope;Z)V", "transportationItems", "(Landroidx/compose/foundation/lazy/LazyListScope;ZLdk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "transportationCategories", "selectedTransportationCategory", "TransportationCategorySelector", "(Ljava/util/List;Ldk/molslinjen/domain/model/config/TransportationCategory;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "transportation", "isSelected", "TransportationRow", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/config/Transportation;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "max", BuildConfig.FLAVOR, "unit", "formatMaxSpecification", "(DLjava/lang/String;)Ljava/lang/String;", "formatMaxSpecificationContentDescription", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransportationSelectorScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x021c, code lost:
    
        if (r10 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TransportationCategorySelector(final List<TransportationCategory> list, final TransportationCategory transportationCategory, final Function1<? super TransportationCategory, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Iterator it;
        final TransportationCategory transportationCategory2;
        int i7;
        float m2599constructorimpl;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1045600182);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(transportationCategory) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i8 = i6;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1045600182, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationCategorySelector (TransportationSelectorScreen.kt:235)");
            }
            if (transportationCategory == null || list == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: R2.r
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit TransportationCategorySelector$lambda$7;
                            TransportationCategorySelector$lambda$7 = TransportationSelectorScreenKt.TransportationCategorySelector$lambda$7(list, transportationCategory, function1, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            return TransportationCategorySelector$lambda$7;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            int i9 = i8;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.transportation_category_headline, startRestartGroup, 6), null, AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 384, 1572864, 65530);
            float f5 = 8;
            Composer composer3 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer3, 6);
            composer3.startReplaceGroup(177575758);
            Iterator it2 = list.iterator();
            int i10 = 0;
            Composer composer4 = composer3;
            while (it2.hasNext()) {
                int i11 = i10 + 1;
                TransportationCategory transportationCategory3 = (TransportationCategory) it2.next();
                boolean z5 = i10 == 0;
                boolean z6 = i10 == list.size() - 1;
                composer4.startReplaceGroup(177580698);
                if (z5) {
                    it = it2;
                    transportationCategory2 = transportationCategory3;
                } else {
                    it = it2;
                    transportationCategory2 = transportationCategory3;
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer4, 0, 15);
                }
                composer4.endReplaceGroup();
                boolean areEqual = Intrinsics.areEqual(transportationCategory, transportationCategory2);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (z5) {
                    m2599constructorimpl = Dp.m2599constructorimpl(f5);
                    i7 = 0;
                } else {
                    i7 = 0;
                    m2599constructorimpl = Dp.m2599constructorimpl(0);
                }
                Modifier clip = ClipKt.clip(fillMaxWidth$default, RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(m2599constructorimpl, z5 ? Dp.m2599constructorimpl(f5) : Dp.m2599constructorimpl(i7), z6 ? Dp.m2599constructorimpl(f5) : Dp.m2599constructorimpl(i7), z6 ? Dp.m2599constructorimpl(f5) : Dp.m2599constructorimpl(i7)));
                AppColor appColor = AppColor.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(clip, areEqual ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
                Role m2163boximpl = Role.m2163boximpl(Role.INSTANCE.m2174getRadioButtono7Vup1c());
                composer4.startReplaceGroup(177609127);
                int i12 = i9;
                int i13 = (composer4.changedInstance(transportationCategory2) ? 1 : 0) | ((i12 & 896) == 256 ? 1 : i7);
                Object rememberedValue = composer4.rememberedValue();
                if (i13 == 0) {
                    obj = rememberedValue;
                }
                Function1 function12 = new Function1() { // from class: R2.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit TransportationCategorySelector$lambda$10$lambda$9$lambda$8;
                        TransportationCategorySelector$lambda$10$lambda$9$lambda$8 = TransportationSelectorScreenKt.TransportationCategorySelector$lambda$10$lambda$9$lambda$8(Function1.this, transportationCategory2, ((Boolean) obj2).booleanValue());
                        return TransportationCategorySelector$lambda$10$lambda$9$lambda$8;
                    }
                };
                composer4.updateRememberedValue(function12);
                obj = function12;
                composer4.endReplaceGroup();
                Composer composer5 = composer4;
                TextKt.m940Text4IGK_g(transportationCategory2.getName(), PaddingKt.m312paddingVpY3zN4(ToggleableKt.m455toggleableXHw0xAI$default(m104backgroundbw27NRU$default, areEqual, false, m2163boximpl, (Function1) obj, 2, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(12)), areEqual ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer5, 0, 1572864, 65016);
                it2 = it;
                i9 = i12;
                composer4 = composer5;
                i10 = i11;
                f5 = f5;
            }
            composer2 = composer4;
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: R2.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TransportationCategorySelector$lambda$11;
                    TransportationCategorySelector$lambda$11 = TransportationSelectorScreenKt.TransportationCategorySelector$lambda$11(list, transportationCategory, function1, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return TransportationCategorySelector$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationCategorySelector$lambda$10$lambda$9$lambda$8(Function1 function1, TransportationCategory transportationCategory, boolean z5) {
        function1.invoke(transportationCategory);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationCategorySelector$lambda$11(List list, TransportationCategory transportationCategory, Function1 function1, int i5, Composer composer, int i6) {
        TransportationCategorySelector(list, transportationCategory, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationCategorySelector$lambda$7(List list, TransportationCategory transportationCategory, Function1 function1, int i5, Composer composer, int i6) {
        TransportationCategorySelector(list, transportationCategory, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TransportationRow(final Modifier modifier, final Transportation transportation, final boolean z5, final Function1<? super Transportation, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-416471556);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(transportation) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-416471556, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationRow (TransportationSelectorScreen.kt:287)");
            }
            Role m2163boximpl = Role.m2163boximpl(Role.INSTANCE.m2171getCheckboxo7Vup1c());
            startRestartGroup.startReplaceGroup(1646540395);
            int i7 = i6 & 7168;
            boolean changedInstance = (i7 == 2048) | startRestartGroup.changedInstance(transportation);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: R2.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit TransportationRow$lambda$13$lambda$12;
                        TransportationRow$lambda$13$lambda$12 = TransportationSelectorScreenKt.TransportationRow$lambda$13$lambda$12(Function1.this, transportation, ((Boolean) obj2).booleanValue());
                        return TransportationRow$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ToggleableKt.m454toggleableXHw0xAI(modifier, z5, true, m2163boximpl, (Function1) rememberedValue), 0.0f, Dp.m2599constructorimpl(16), 1, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f5 = 24;
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-415710153);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: R2.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit TransportationRow$lambda$30$lambda$15$lambda$14;
                        TransportationRow$lambda$30$lambda$15$lambda$14 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$15$lambda$14((SemanticsPropertyReceiver) obj2);
                        return TransportationRow$lambda$30$lambda$15$lambda$14;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(fillMaxHeight$default, (Function1) rememberedValue2);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            startRestartGroup.startReplaceGroup(-575638139);
            boolean changedInstance2 = (i7 == 2048) | startRestartGroup.changedInstance(transportation);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: R2.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit TransportationRow$lambda$30$lambda$21$lambda$17$lambda$16;
                        TransportationRow$lambda$30$lambda$21$lambda$17$lambda$16 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$21$lambda$17$lambda$16(Function1.this, transportation, ((Boolean) obj2).booleanValue());
                        return TransportationRow$lambda$30$lambda$21$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            SelectionControlKt.SelectionControl(null, z5, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.RadioButton, false, startRestartGroup, ((i6 >> 3) & 112) | 1572864, 185);
            composer2.startReplaceGroup(-575633219);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == companion4.getEmpty()) {
                obj = null;
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(rememberedValue4);
            } else {
                obj = null;
            }
            final MutableState mutableState = (MutableState) rememberedValue4;
            composer2.endReplaceGroup();
            String m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(transportation.getImageUrl(), null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), composer2, 3456, 2);
            composer2.startReplaceGroup(-575627876);
            if (m3193buildImageUrlC8IHX40 != null && !((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.startReplaceGroup(-575621774);
                Object rememberedValue5 = composer2.rememberedValue();
                if (rememberedValue5 == companion4.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: R2.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit TransportationRow$lambda$30$lambda$21$lambda$20$lambda$19;
                            TransportationRow$lambda$30$lambda$21$lambda$20$lambda$19 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$21$lambda$20$lambda$19(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return TransportationRow$lambda$30$lambda$21$lambda$20$lambda$19;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue5, null, 0, composer2, 1572864, 446), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(14), 0.0f, 10, null), Dp.m2599constructorimpl(f5)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597440, 40);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion3, 2.0f, false, 2, null), 0.0f, 1, obj);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion.getStart(), composer2, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxHeight$default2);
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String nameWithoutPossibleCategory = transportation.getNameWithoutPossibleCategory();
            TextStyle paragraph = TypographyKt.getParagraph();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(nameWithoutPossibleCategory, null, appColor.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraph, composer2, 384, 1572864, 65530);
            composer2.startReplaceGroup(-575592899);
            if (!transportation.isWalking()) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composer2, 0);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion2.getSetModifier());
                final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_meters, composer2, 6);
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                composer2.startReplaceGroup(-1224613589);
                boolean changedInstance3 = composer2.changedInstance(transportation) | composer2.changed(stringResource);
                Object rememberedValue6 = composer2.rememberedValue();
                if (changedInstance3 || rememberedValue6 == companion4.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: R2.x
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22;
                            TransportationRow$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22(Transportation.this, stringResource, (SemanticsPropertyReceiver) obj2);
                            return TransportationRow$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(formatMaxSpecification(transportation.getMaxHeight(), StringResources_androidKt.stringResource(R.string.common_unit_meters, composer2, 6)), SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue6, 1, obj), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                composer2.startReplaceGroup(-1224595669);
                boolean changedInstance4 = composer2.changedInstance(transportation) | composer2.changed(stringResource);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changedInstance4 || rememberedValue7 == companion4.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: R2.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24;
                            TransportationRow$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(Transportation.this, stringResource, (SemanticsPropertyReceiver) obj2);
                            return TransportationRow$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(formatMaxSpecification(transportation.getMaxLength(), StringResources_androidKt.stringResource(R.string.common_unit_meters, composer2, 6)), SemanticsModifierKt.semantics$default(weight$default2, false, (Function1) rememberedValue7, 1, obj), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
                final String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_tons, composer2, 6);
                Modifier weight$default3 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                composer2.startReplaceGroup(-1224574455);
                boolean changedInstance5 = composer2.changedInstance(transportation) | composer2.changed(stringResource2);
                Object rememberedValue8 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue8 == companion4.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: R2.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26;
                            TransportationRow$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26 = TransportationSelectorScreenKt.TransportationRow$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(Transportation.this, stringResource2, (SemanticsPropertyReceiver) obj2);
                            return TransportationRow$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(formatMaxSpecification(transportation.getMaxWeight(), StringResources_androidKt.stringResource(R.string.common_unit_ton, composer2, 6)), SemanticsModifierKt.semantics$default(weight$default3, false, (Function1) rememberedValue8, 1, obj), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
                composer2.endNode();
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.A
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TransportationRow$lambda$31;
                    TransportationRow$lambda$31 = TransportationSelectorScreenKt.TransportationRow$lambda$31(Modifier.this, transportation, z5, function1, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return TransportationRow$lambda$31;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$13$lambda$12(Function1 function1, Transportation transportation, boolean z5) {
        function1.invoke(transportation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$15$lambda$14(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$21$lambda$17$lambda$16(Function1 function1, Transportation transportation, boolean z5) {
        function1.invoke(transportation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$21$lambda$20$lambda$19(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22(Transportation transportation, String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, formatMaxSpecificationContentDescription(transportation.getMaxHeight(), str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(Transportation transportation, String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, formatMaxSpecificationContentDescription(transportation.getMaxLength(), str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(Transportation transportation, String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, formatMaxSpecificationContentDescription(transportation.getMaxWeight(), str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationRow$lambda$31(Modifier modifier, Transportation transportation, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        TransportationRow(modifier, transportation, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TransportationSelectorContent(final TransportationSelectorViewModel.ViewState viewState, final boolean z5, final Function1<? super Transportation, Unit> function1, final Function1<? super TransportationCategory, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1382821180);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1382821180, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorContent (TransportationSelectorScreen.kt:121)");
            }
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(z5 ? 16 : 0), 0.0f, Dp.m2599constructorimpl(z5 ? 16 : 0), 0.0f, 10, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(m315paddingqDBjuR0$default, z5 ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceGroup(-1299390628);
            boolean changedInstance = ((i6 & 896) == 256) | ((i6 & 112) == 32) | startRestartGroup.changedInstance(viewState) | ((i6 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: R2.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TransportationSelectorContent$lambda$5$lambda$4;
                        TransportationSelectorContent$lambda$5$lambda$4 = TransportationSelectorScreenKt.TransportationSelectorContent$lambda$5$lambda$4(z5, viewState, function1, function12, (LazyListScope) obj);
                        return TransportationSelectorContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, null, false, null, null, null, false, (Function1) rememberedValue, startRestartGroup, 0, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportationSelectorContent$lambda$6;
                    TransportationSelectorContent$lambda$6 = TransportationSelectorScreenKt.TransportationSelectorContent$lambda$6(TransportationSelectorViewModel.ViewState.this, z5, function1, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportationSelectorContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorContent$lambda$5$lambda$4(boolean z5, final TransportationSelectorViewModel.ViewState viewState, Function1 function1, final Function1 function12, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (z5) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1814914571, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreenKt$TransportationSelectorContent$1$1$1
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
                        ComposerKt.traceEventStart(-1814914571, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorContent.<anonymous>.<anonymous>.<anonymous> (TransportationSelectorScreen.kt:132)");
                    }
                    TransportationSelectorScreenKt.TransportationCategorySelector(TransportationSelectorViewModel.ViewState.this.getTransportationCategories(), TransportationSelectorViewModel.ViewState.this.getSelectedTransportationCategory(), function12, composer, 0);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(32)), composer, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TransportationSelectorScreenKt.INSTANCE.m3461getLambda1$app_kombardoProd(), 3, null);
        }
        transportationHeader(LazyColumn, z5);
        transportationItems(LazyColumn, z5, viewState, function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorContent$lambda$6(TransportationSelectorViewModel.ViewState viewState, boolean z5, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        TransportationSelectorContent(viewState, z5, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TransportationSelectorScreen(final TransportationSelectorViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CargoDetailsScreenDestination, Boolean> cargoResultRecipient, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(cargoResultRecipient, "cargoResultRecipient");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(-1824164341);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(cargoResultRecipient) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1824164341, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreen (TransportationSelectorScreen.kt:64)");
            }
            startRestartGroup.startReplaceGroup(-1410128436);
            boolean z5 = (i7 & 7168) == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: R2.B
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TransportationSelectorScreen$lambda$1$lambda$0;
                        TransportationSelectorScreen$lambda$1$lambda$0 = TransportationSelectorScreenKt.TransportationSelectorScreen$lambda$1$lambda$0(ResultBackNavigator.this, ((Boolean) obj).booleanValue());
                        return TransportationSelectorScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(cargoResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i7 >> 6) & 14, 1);
            final TransportationSelectorViewModel.ViewState viewState = (TransportationSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            List<TransportationCategory> transportationCategories = viewState.getTransportationCategories();
            boolean z6 = (transportationCategories != null ? transportationCategories.size() : 0) > 1;
            AppColor appColor = AppColor.INSTANCE;
            long m3269getGrey60d7_KjU = z6 ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU();
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, m3269getGrey60d7_KjU, null, 2, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.transportation_headline, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1410112961);
            boolean z7 = (i7 & 112) == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new TransportationSelectorScreenKt$TransportationSelectorScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            final boolean z8 = z6;
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m104backgroundbw27NRU$default, 0.0f, stringResource, null, m3269getGrey60d7_KjU, null, (Function0) rememberedValue2, null, ComposableLambdaKt.rememberComposableLambda(-2102994291, true, new TransportationSelectorScreenKt$TransportationSelectorScreen$3(viewState, m3269getGrey60d7_KjU, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(477993182, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreenKt$TransportationSelectorScreen$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(477993182, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreen.<anonymous> (TransportationSelectorScreen.kt:106)");
                    }
                    TransportationSelectorViewModel.ViewState viewState2 = TransportationSelectorViewModel.ViewState.this;
                    boolean z9 = z8;
                    TransportationSelectorViewModel transportationSelectorViewModel = viewModel;
                    composer3.startReplaceGroup(-263093144);
                    boolean changedInstance = composer3.changedInstance(transportationSelectorViewModel);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new TransportationSelectorScreenKt$TransportationSelectorScreen$4$1$1(transportationSelectorViewModel);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceGroup();
                    Function1 function1 = (Function1) ((KFunction) rememberedValue3);
                    TransportationSelectorViewModel transportationSelectorViewModel2 = viewModel;
                    composer3.startReplaceGroup(-263090576);
                    boolean changedInstance2 = composer3.changedInstance(transportationSelectorViewModel2);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new TransportationSelectorScreenKt$TransportationSelectorScreen$4$2$1(transportationSelectorViewModel2);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    TransportationSelectorScreenKt.TransportationSelectorContent(viewState2, z9, function1, (Function1) ((KFunction) rememberedValue4), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 905969664, 170);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.C
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportationSelectorScreen$lambda$3;
                    TransportationSelectorScreen$lambda$3 = TransportationSelectorScreenKt.TransportationSelectorScreen$lambda$3(TransportationSelectorViewModel.this, navigator, cargoResultRecipient, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportationSelectorScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorScreen$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator, boolean z5) {
        resultBackNavigator.navigateBack(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorScreen$lambda$3(TransportationSelectorViewModel transportationSelectorViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        TransportationSelectorScreen(transportationSelectorViewModel, destinationsNavigator, resultRecipient, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final String formatMaxSpecification(double d5, String str) {
        if (d5 == 0.0d) {
            return "-";
        }
        return DoubleExtensionsKt.format(d5, 2) + str;
    }

    private static final String formatMaxSpecificationContentDescription(double d5, String str) {
        if (d5 == 0.0d) {
            return BuildConfig.FLAVOR;
        }
        return DoubleExtensionsKt.format(d5, 2) + " " + str;
    }

    private static final void transportationHeader(LazyListScope lazyListScope, final boolean z5) {
        LazyListScope.stickyHeader$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1212601071, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreenKt$transportationHeader$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope stickyHeader, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(stickyHeader, "$this$stickyHeader");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1212601071, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.transportationHeader.<anonymous> (TransportationSelectorScreen.kt:160)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion, z5 ? AppColor.INSTANCE.m3280getTransparent0d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Horizontal start = arrangement.getStart();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion, 2.0f, false, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(6), 7, null);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                String stringResource = StringResources_androidKt.stringResource(R.string.common_maxHeight, composer, 6);
                TextStyle subSmall = TypographyKt.getSubSmall();
                AppColor appColor = AppColor.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, weight$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, subSmall, composer, 384, 1572864, 65528);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_maxLength, composer, 6), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer, 384, 1572864, 65528);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_transportation_maxWeight, composer, 6), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer, 384, 1572864, 65528);
                composer.endNode();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }

    private static final void transportationItems(LazyListScope lazyListScope, final boolean z5, TransportationSelectorViewModel.ViewState viewState, Function1<? super Transportation, Unit> function1) {
        Iterator<T> it = viewState.getTransportations().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(842997623, true, new TransportationSelectorScreenKt$transportationItems$1(i5 == 0, z5, i5 == viewState.getTransportations().size() - 1, (Transportation) it.next(), viewState, function1)), 3, null);
            i5 = i6;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1611716598, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreenKt$transportationItems$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i7) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i7 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1611716598, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.transportationItems.<anonymous> (TransportationSelectorScreen.kt:224)");
                }
                if (!z5) {
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
