package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariants;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.VariantsSectionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aY\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"variantsSection", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/LazyListScope;", "variants", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", "selectedVariant", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "enabled", BuildConfig.FLAVOR, "selectVariant", "Lkotlin/Function1;", "horizontalCellCount", BuildConfig.FLAVOR, "horizontalSpacing", "horizontalPadding", "Landroidx/compose/ui/unit/Dp;", "variantsSection-QMuTD5c", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;ZLkotlin/jvm/functions/Function1;IIF)V", "VariantCell", "variant", "isSelected", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;ZLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class VariantsSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void VariantCell(final SaleOnBoardVariant saleOnBoardVariant, final boolean z5, final Function1<? super SaleOnBoardVariant, Unit> function1, final boolean z6, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        float f5;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(641381366);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardVariant) ? 4 : 2) | i5;
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
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(641381366, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.VariantCell (VariantsSection.kt:84)");
            }
            startRestartGroup.startReplaceGroup(-55458445);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier height = IntrinsicKt.height(SizeKt.m336width3ABfNKs(ClipKt.clip(companion3, ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(98)), IntrinsicSize.Min);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            float m2599constructorimpl = Dp.m2599constructorimpl(1);
            AppColor appColor = AppColor.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(BorderKt.m108borderxT4_qwU(companion3, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(727607082);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(saleOnBoardVariant);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: j4.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit VariantCell$lambda$8$lambda$3$lambda$2;
                        VariantCell$lambda$8$lambda$3$lambda$2 = VariantsSectionKt.VariantCell$lambda$8$lambda$3$lambda$2(Function1.this, saleOnBoardVariant);
                        return VariantCell$lambda$8$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion3, z6, null, null, (Function0) rememberedValue2, 6, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
            Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String imageUrl = saleOnBoardVariant.getImageUrl();
            if (imageUrl == null || ((Boolean) mutableState.getValue()).booleanValue()) {
                companion = companion3;
                f5 = 0.0f;
                startRestartGroup.startReplaceGroup(1586120538);
                obj = null;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(70)), appColor.m3268getGrey50d7_KjU(), null, 2, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1585539753);
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m2599constructorimpl(70)), appColor.m3268getGrey50d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceGroup(1575177158);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion2.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: j4.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit VariantCell$lambda$8$lambda$6$lambda$5$lambda$4;
                            VariantCell$lambda$8$lambda$6$lambda$5$lambda$4 = VariantsSectionKt.VariantCell$lambda$8$lambda$6$lambda$5$lambda$4(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return VariantCell$lambda$8$lambda$6$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                companion = companion3;
                f5 = 0.0f;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(imageUrl, null, null, null, null, null, (Function1) rememberedValue3, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), m104backgroundbw27NRU$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24960, 104);
                startRestartGroup.endReplaceGroup();
                obj = null;
            }
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            Modifier.Companion companion6 = companion;
            float f6 = 8;
            TextKt.m940Text4IGK_g(saleOnBoardVariant.getName(), PaddingKt.m314paddingqDBjuR0(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion6, f5, 1, obj), Dp.m2599constructorimpl(62)), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(16)), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65020);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(727655616);
            if (z5) {
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(BorderKt.m108borderxT4_qwU(companion6, Dp.m2599constructorimpl(2), appColor.m3255getBrandBlue10d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, obj);
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
                Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion5.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion5.getSetModifier());
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: j4.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit VariantCell$lambda$9;
                    VariantCell$lambda$9 = VariantsSectionKt.VariantCell$lambda$9(SaleOnBoardVariant.this, z5, function1, z6, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return VariantCell$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VariantCell$lambda$8$lambda$3$lambda$2(Function1 function1, SaleOnBoardVariant saleOnBoardVariant) {
        function1.invoke(saleOnBoardVariant);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VariantCell$lambda$8$lambda$6$lambda$5$lambda$4(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VariantCell$lambda$9(SaleOnBoardVariant saleOnBoardVariant, boolean z5, Function1 function1, boolean z6, int i5, Composer composer, int i6) {
        VariantCell(saleOnBoardVariant, z5, function1, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: variantsSection-QMuTD5c, reason: not valid java name */
    public static final void m3536variantsSectionQMuTD5c(LazyListScope variantsSection, final SaleOnBoardVariants saleOnBoardVariants, final SaleOnBoardVariant saleOnBoardVariant, final boolean z5, final Function1<? super SaleOnBoardVariant, Unit> selectVariant, final int i5, final int i6, final float f5) {
        Intrinsics.checkNotNullParameter(variantsSection, "$this$variantsSection");
        Intrinsics.checkNotNullParameter(selectVariant, "selectVariant");
        if (saleOnBoardVariants == null) {
            return;
        }
        LazyListScope.item$default(variantsSection, null, null, ComposableLambdaKt.composableLambdaInstance(1952646553, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.VariantsSectionKt$variantsSection$1
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
                    ComposerKt.traceEventStart(1952646553, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.variantsSection.<anonymous> (VariantsSection.kt:43)");
                }
                float f6 = 24;
                TextKt.m940Text4IGK_g(SaleOnBoardVariants.this.getTitle(), PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 48, 1572864, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(variantsSection, null, null, ComposableLambdaKt.composableLambdaInstance(-1691089136, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.VariantsSectionKt$variantsSection$2
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
                    ComposerKt.traceEventStart(-1691089136, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.variantsSection.<anonymous> (VariantsSection.kt:52)");
                }
                int ceil = (int) Math.ceil(SaleOnBoardVariants.this.getVariants().size() / i5);
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, f5, 0.0f, 2, null);
                int i8 = i5;
                int i9 = i6;
                SaleOnBoardVariants saleOnBoardVariants2 = SaleOnBoardVariants.this;
                SaleOnBoardVariant saleOnBoardVariant2 = saleOnBoardVariant;
                Function1<SaleOnBoardVariant, Unit> function1 = selectVariant;
                boolean z6 = z5;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer.startReplaceGroup(-1700222122);
                for (int i10 = 0; i10 < ceil; i10++) {
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer.startReplaceGroup(777700514);
                    int i11 = 0;
                    while (true) {
                        if (i11 < i8) {
                            composer.startReplaceGroup(777701950);
                            if (i11 > 0) {
                                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(Modifier.INSTANCE, ComposeExtensionsKt.pxToDp(i9, composer, 0)), composer, 0);
                            }
                            composer.endReplaceGroup();
                            SaleOnBoardVariant saleOnBoardVariant3 = (SaleOnBoardVariant) CollectionsKt.getOrNull(saleOnBoardVariants2.getVariants(), (i10 * i8) + i11);
                            composer.startReplaceGroup(777710035);
                            if (saleOnBoardVariant3 == null) {
                                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
                                composer.endReplaceGroup();
                                break;
                            } else {
                                composer.endReplaceGroup();
                                VariantsSectionKt.VariantCell(saleOnBoardVariant3, Intrinsics.areEqual(saleOnBoardVariant3, saleOnBoardVariant2), function1, z6, composer, 0);
                                i11++;
                            }
                        }
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                }
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
