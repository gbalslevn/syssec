package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SensorDataManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u0010\u0010\b\u001a\u0004\u0018\u00010\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "validityBannerHorizontalPadded", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "validity", BuildConfig.FLAVOR, "BarcodeValidityView", "(ZLdk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;Landroidx/compose/runtime/Composer;II)V", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SensorDataManager$SensorData;", "data", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BarcodeValidityViewKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BarcodeValidity.values().length];
            try {
                iArr[BarcodeValidity.Valid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BarcodeValidity.Expired.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void BarcodeValidityView(boolean z5, final BarcodeValidity validity, Composer composer, final int i5, final int i6) {
        final boolean z6;
        int i7;
        long m3274getTagBlue0d7_KjU;
        Composer composer2;
        final String stringResource;
        int i8;
        float f5;
        Composer composer3;
        Intrinsics.checkNotNullParameter(validity, "validity");
        Composer startRestartGroup = composer.startRestartGroup(-1129424834);
        int i9 = i6 & 1;
        if (i9 != 0) {
            i7 = i5 | 6;
            z6 = z5;
        } else if ((i5 & 6) == 0) {
            z6 = z5;
            i7 = (startRestartGroup.changed(z6) ? 4 : 2) | i5;
        } else {
            z6 = z5;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(validity) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            boolean z7 = i9 != 0 ? false : z6;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129424834, i7, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityView (BarcodeValidityView.kt:40)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1224592393);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1224589151);
            boolean changedInstance = startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: o4.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult BarcodeValidityView$lambda$5$lambda$4;
                        BarcodeValidityView$lambda$5$lambda$4 = BarcodeValidityViewKt.BarcodeValidityView$lambda$5$lambda$4(context, coroutineScope, mutableState, (DisposableEffectScope) obj);
                        return BarcodeValidityView$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            SensorDataManager.SensorData BarcodeValidityView$lambda$1 = BarcodeValidityView$lambda$1(mutableState);
            int i10 = 2;
            Object obj = null;
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(OffsetKt.m295offsetVpY3zN4$default(companion2, Dp.m2599constructorimpl((BarcodeValidityView$lambda$1 != null ? Dp.m2599constructorimpl(BarcodeValidityView$lambda$1.getRoll()) : Dp.m2599constructorimpl(0)) * 25), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f6)), companion3.getTop(), startRestartGroup, 6);
            boolean z8 = false;
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
            startRestartGroup.startReplaceGroup(-1785640702);
            int i11 = 0;
            int i12 = 16;
            while (i11 < i12) {
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_validity_logo, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f6)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                i11++;
                i10 = 2;
                startRestartGroup = startRestartGroup;
                i12 = 16;
                f6 = f6;
                obj = null;
                z8 = false;
            }
            int i13 = i10;
            Composer composer4 = startRestartGroup;
            composer4.endReplaceGroup();
            composer4.endNode();
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i14 = iArr[validity.ordinal()];
            if (i14 == 1) {
                m3274getTagBlue0d7_KjU = AppColor.INSTANCE.m3274getTagBlue0d7_KjU();
            } else {
                if (i14 != i13) {
                    throw new NoWhenBranchMatchedException();
                }
                m3274getTagBlue0d7_KjU = AppColor.INSTANCE.m3275getTagGrey0d7_KjU();
            }
            long j5 = m3274getTagBlue0d7_KjU;
            int i15 = iArr[validity.ordinal()];
            if (i15 == 1) {
                composer2 = composer4;
                composer2.startReplaceGroup(-1949869913);
                stringResource = StringResources_androidKt.stringResource(R.string.barcode_ticketValid, composer2, 6);
                composer2.endReplaceGroup();
            } else {
                if (i15 != i13) {
                    composer4.startReplaceGroup(-1949871517);
                    composer4.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2 = composer4;
                composer2.startReplaceGroup(-1949867063);
                stringResource = StringResources_androidKt.stringResource(R.string.barcode_ticketExpired, composer2, 6);
                composer2.endReplaceGroup();
            }
            Modifier.Companion companion5 = Modifier.INSTANCE;
            if (z7) {
                i8 = 32;
                f5 = 32;
            } else {
                i8 = 32;
                f5 = 0;
            }
            composer3 = composer2;
            HighlightedTextKt.m3387HighlightedTextRuGn9fw(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m313paddingVpY3zN4$default(companion5, Dp.m2599constructorimpl(f5), 0.0f, i13, null), 0.0f, 1, null), Dp.m2599constructorimpl(i8)), false, j5, Color.m1481boximpl(ColorExtensionsKt.m3249withAlphaDxMtmZc(j5, 0.2f)), z7 ? ThemeShapesKt.getThemeShapes().getMedium() : CornerBasedShape.copy$default(ThemeShapesKt.getThemeShapes().getMedium(), CornerSizeKt.CornerSize(0.0f), CornerSizeKt.CornerSize(0.0f), null, null, 12, null), ComposableLambdaKt.rememberComposableLambda(374476152, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt$BarcodeValidityView$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                    invoke(composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i16) {
                    if ((i16 & 3) == 2 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(374476152, i16, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityView.<anonymous>.<anonymous> (BarcodeValidityView.kt:108)");
                    }
                    TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer5, 0, 1572864, 65022);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 196608, 2);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z7;
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit BarcodeValidityView$lambda$8;
                    BarcodeValidityView$lambda$8 = BarcodeValidityViewKt.BarcodeValidityView$lambda$8(z6, validity, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                    return BarcodeValidityView$lambda$8;
                }
            });
        }
    }

    private static final SensorDataManager.SensorData BarcodeValidityView$lambda$1(MutableState<SensorDataManager.SensorData> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BarcodeValidityView$lambda$5$lambda$4(Context context, CoroutineScope coroutineScope, MutableState mutableState, DisposableEffectScope DisposableEffect) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final SensorDataManager sensorDataManager = new SensorDataManager(context);
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1(sensorDataManager, mutableState, null), 3, null);
        return new DisposableEffectResult() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt$BarcodeValidityView$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                SensorDataManager.this.cancel();
                Job.DefaultImpls.cancel$default(launch$default, null, 1, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeValidityView$lambda$8(boolean z5, BarcodeValidity barcodeValidity, int i5, int i6, Composer composer, int i7) {
        BarcodeValidityView(z5, barcodeValidity, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
