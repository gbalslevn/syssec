package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardLineItemViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aI\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", "Lkotlin/Function1;", BuildConfig.FLAVOR, "edit", BuildConfig.FLAVOR, "remove", BuildConfig.FLAVOR, "editable", "SaleOnBoardLineItemView", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardLineItemViewKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0450  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SaleOnBoardLineItemView(final SaleOnBoardLineItem lineItem, final Function1<? super SaleOnBoardLineItem, Unit> edit, final Function1<? super String, Unit> remove, boolean z5, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z6;
        int i8;
        final String stringResource;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        boolean changedInstance;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        boolean z7;
        int i9;
        float f5;
        Modifier.Companion companion2;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        int currentCompositeKeyHash4;
        Composer m1226constructorimpl4;
        boolean changedInstance2;
        Object rememberedValue4;
        int currentCompositeKeyHash5;
        Composer m1226constructorimpl5;
        boolean changedInstance3;
        Object rememberedValue5;
        int currentCompositeKeyHash6;
        Composer m1226constructorimpl6;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
        Intrinsics.checkNotNullParameter(edit, "edit");
        Intrinsics.checkNotNullParameter(remove, "remove");
        Composer startRestartGroup = composer.startRestartGroup(1292919888);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(lineItem) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(edit) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(remove) ? 256 : 128;
        }
        int i10 = i6 & 8;
        if (i10 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
            i8 = i7;
            if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                if (i10 != 0) {
                    z6 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1292919888, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardLineItemView (SaleOnBoardLineItemView.kt:55)");
                }
                startRestartGroup.startReplaceGroup(1782658029);
                stringResource = !z6 ? StringResources_androidKt.stringResource(R.string.accessibilityLabel_edit, startRestartGroup, 6) : Accessibility.INSTANCE.getSkip();
                startRestartGroup.endReplaceGroup();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                AppColor appColor = AppColor.INSTANCE;
                float f6 = 16;
                Modifier height = IntrinsicKt.height(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f6)), IntrinsicSize.Max);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Horizontal start = arrangement.getStart();
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion4.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-68271912);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                float f7 = 86;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m333sizeVpY3zN4(companion3, Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7)), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()), appColor.m3268getGrey50d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceGroup(-68263274);
                changedInstance = ((i8 & 112) != 32) | startRestartGroup.changedInstance(lineItem);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: f4.x
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2;
                            SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2(Function1.this, lineItem, (Modifier) obj);
                            return SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier applyIf = ModifierExtensionsKt.applyIf(m104backgroundbw27NRU$default, z6, (Function1) rememberedValue2);
                startRestartGroup.startReplaceGroup(-68260945);
                changed = startRestartGroup.changed(stringResource);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: f4.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5;
                            SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5(stringResource, (SemanticsPropertyReceiver) obj);
                            return SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(applyIf, (Function1) rememberedValue3);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    startRestartGroup.startReplaceGroup(900443397);
                    Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null);
                    String squareImageUrl = lineItem.getProduct().getSquareImageUrl();
                    startRestartGroup.startReplaceGroup(-109492788);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function1() { // from class: f4.z
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SaleOnBoardLineItemView$lambda$20$lambda$9$lambda$8$lambda$7;
                                SaleOnBoardLineItemView$lambda$20$lambda$9$lambda$8$lambda$7 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$9$lambda$8$lambda$7(MutableState.this, (AsyncImagePainter.State.Error) obj);
                                return SaleOnBoardLineItemView$lambda$20$lambda$9$lambda$8$lambda$7;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    f5 = f6;
                    z7 = z6;
                    i9 = i8;
                    ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue6, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), fillMaxHeight$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24960, 104);
                    startRestartGroup.endReplaceGroup();
                    companion2 = companion3;
                } else {
                    z7 = z6;
                    i9 = i8;
                    f5 = f6;
                    startRestartGroup.startReplaceGroup(900957842);
                    companion2 = companion3;
                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion3, Dp.m2599constructorimpl(f7)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.startReplaceGroup(-109474558);
                if (!z7) {
                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_edit_circle_white, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), boxScopeInstance.align(ClipKt.clip(SizeKt.m331size3ABfNKs(PaddingKt.m311padding3ABfNKs(companion2, Dp.m2599constructorimpl(4)), Dp.m2599constructorimpl(20)), RoundedCornerShapeKt.getCircleShape()), companion4.getTopStart()), null, null, 0.0f, null, startRestartGroup, 0, 120);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default2);
                Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor3);
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor4);
                }
                m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion5.getSetModifier());
                String str = lineItem.getQuantity() + "x ";
                TextStyle paragraphSmallBold = TypographyKt.getParagraphSmallBold();
                startRestartGroup.startReplaceGroup(1889011081);
                changedInstance2 = startRestartGroup.changedInstance(lineItem);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: f4.A
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10;
                            SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10(SaleOnBoardLineItem.this, (SemanticsPropertyReceiver) obj);
                            return SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                TextKt.m940Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue4, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphSmallBold, startRestartGroup, 0, 1572864, 65532);
                TextKt.m940Text4IGK_g(lineItem.getProduct().getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
                startRestartGroup.endNode();
                String description = lineItem.description();
                String takeFirstSentence = description == null ? StringExtensionsKt.takeFirstSentence(description) : null;
                startRestartGroup.startReplaceGroup(-109442115);
                String stringResource2 = takeFirstSentence != null ? StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_noAddons, startRestartGroup, 6) : takeFirstSentence;
                startRestartGroup.endReplaceGroup();
                TextKt.m940Text4IGK_g(stringResource2, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65530);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
                final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                final PriceWithCurrency priceWithCurrency = lineItem.totalPrice();
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor5 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor5);
                }
                m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy3, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion5.getSetModifier());
                startRestartGroup.startReplaceGroup(1889034090);
                changedInstance3 = startRestartGroup.changedInstance(priceWithCurrency) | startRestartGroup.changedInstance(context);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: f4.B
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13;
                            SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13(PriceWithCurrency.this, context, (SemanticsPropertyReceiver) obj);
                            return SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) rememberedValue5);
                MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2);
                Function0<ComposeUiNode> constructor6 = companion5.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor6);
                }
                m1226constructorimpl6 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl6, rowMeasurePolicy4, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion5.getSetModifier());
                PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency, rowScopeInstance.alignByBaseline(companion2), PriceViewType.PriceOnly, false, TypographyKt.getParagraph(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
                PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion2), Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(1889057212);
                if (!z7) {
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
                    Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_trash_circle, startRestartGroup, 6);
                    String stringResource3 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, startRestartGroup, 6);
                    Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(32)), RoundedCornerShapeKt.getCircleShape());
                    startRestartGroup.startReplaceGroup(1889071307);
                    boolean changedInstance4 = startRestartGroup.changedInstance(lineItem) | ((i9 & 896) == 256);
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: f4.C
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16;
                                SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(Function1.this, lineItem);
                                return SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceGroup();
                    ImageKt.Image(painterResource, stringResource3, ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue7, 7, null), null, null, 0.0f, null, startRestartGroup, 0, 120);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final boolean z8 = z6;
                endRestartGroup.updateScope(new Function2() { // from class: f4.D
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SaleOnBoardLineItemView$lambda$21;
                        SaleOnBoardLineItemView$lambda$21 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$21(SaleOnBoardLineItem.this, edit, remove, z8, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return SaleOnBoardLineItemView$lambda$21;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        i8 = i7;
        if ((i8 & 1171) == 1170) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(1782658029);
        if (!z6) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier.Companion companion32 = Modifier.INSTANCE;
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion32, 0.0f, 1, null);
        AppColor appColor2 = AppColor.INSTANCE;
        float f62 = 16;
        Modifier height2 = IntrinsicKt.height(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(fillMaxWidth$default2, appColor2.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f62)), IntrinsicSize.Max);
        Arrangement arrangement2 = Arrangement.INSTANCE;
        Arrangement.Horizontal start2 = arrangement2.getStart();
        Alignment.Companion companion42 = Alignment.INSTANCE;
        MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(start2, companion42.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, height2);
        ComposeUiNode.Companion companion52 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor7 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy5, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap7, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash7);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier7, companion52.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-68271912);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        float f72 = 86;
        Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m333sizeVpY3zN4(companion32, Dp.m2599constructorimpl(f72), Dp.m2599constructorimpl(f72)), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()), appColor2.m3268getGrey50d7_KjU(), null, 2, null);
        startRestartGroup.startReplaceGroup(-68263274);
        changedInstance = ((i8 & 112) != 32) | startRestartGroup.changedInstance(lineItem);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new Function1() { // from class: f4.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Modifier SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2;
                SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2(Function1.this, lineItem, (Modifier) obj);
                return SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        Modifier applyIf2 = ModifierExtensionsKt.applyIf(m104backgroundbw27NRU$default2, z6, (Function1) rememberedValue2);
        startRestartGroup.startReplaceGroup(-68260945);
        changed = startRestartGroup.changed(stringResource);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new Function1() { // from class: f4.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5;
                SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5(stringResource, (SemanticsPropertyReceiver) obj);
                return SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics3 = SemanticsModifierKt.clearAndSetSemantics(applyIf2, (Function1) rememberedValue3);
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getCenter(), false);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics3);
        Function0<ComposeUiNode> constructor22 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion52.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        if (((Boolean) mutableState.getValue()).booleanValue()) {
        }
        startRestartGroup.startReplaceGroup(-109474558);
        if (!z7) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        Modifier fillMaxHeight$default22 = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion42.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default22);
        Function0<ComposeUiNode> constructor32 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion52.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion42.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
        Function0<ComposeUiNode> constructor42 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy22, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap42, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl4.getInserting()) {
        }
        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier42, companion52.getSetModifier());
        String str2 = lineItem.getQuantity() + "x ";
        TextStyle paragraphSmallBold2 = TypographyKt.getParagraphSmallBold();
        startRestartGroup.startReplaceGroup(1889011081);
        changedInstance2 = startRestartGroup.changedInstance(lineItem);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue4 = new Function1() { // from class: f4.A
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10;
                SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10(SaleOnBoardLineItem.this, (SemanticsPropertyReceiver) obj);
                return SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        TextKt.m940Text4IGK_g(str2, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue4, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphSmallBold2, startRestartGroup, 0, 1572864, 65532);
        TextKt.m940Text4IGK_g(lineItem.getProduct().getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
        startRestartGroup.endNode();
        String description2 = lineItem.description();
        if (description2 == null) {
        }
        startRestartGroup.startReplaceGroup(-109442115);
        if (takeFirstSentence != null) {
        }
        startRestartGroup.endReplaceGroup();
        TextKt.m940Text4IGK_g(stringResource2, null, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65530);
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
        final Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        final PriceWithCurrency priceWithCurrency2 = lineItem.totalPrice();
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null);
        MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion42.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier52 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
        Function0<ComposeUiNode> constructor52 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy32, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap52, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash52 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl5.getInserting()) {
        }
        m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
        m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash52);
        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier52, companion52.getSetModifier());
        startRestartGroup.startReplaceGroup(1889034090);
        changedInstance3 = startRestartGroup.changedInstance(priceWithCurrency2) | startRestartGroup.changedInstance(context2);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue5 = new Function1() { // from class: f4.B
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13;
                SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13(PriceWithCurrency.this, context2, (SemanticsPropertyReceiver) obj);
                return SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics22 = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) rememberedValue5);
        MeasurePolicy rowMeasurePolicy42 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion42.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap62 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier62 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics22);
        Function0<ComposeUiNode> constructor62 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl6 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl6, rowMeasurePolicy42, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap62, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash62 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl6.getInserting()) {
        }
        m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
        m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash62);
        Updater.m1227setimpl(m1226constructorimpl6, materializeModifier62, companion52.getSetModifier());
        PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency2, rowScopeInstance2.alignByBaseline(companion2), PriceViewType.PriceOnly, false, TypographyKt.getParagraph(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
        PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency2, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance2.alignByBaseline(companion2), Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
        startRestartGroup.endNode();
        startRestartGroup.startReplaceGroup(1889057212);
        if (!z7) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z7;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$12$lambda$11$lambda$10(SaleOnBoardLineItem saleOnBoardLineItem, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, String.valueOf(saleOnBoardLineItem.getQuantity()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$14$lambda$13(PriceWithCurrency priceWithCurrency, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(priceWithCurrency, context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(Function1 function1, SaleOnBoardLineItem saleOnBoardLineItem) {
        function1.invoke(saleOnBoardLineItem.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2(final Function1 function1, final SaleOnBoardLineItem saleOnBoardLineItem, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.m122clickableXHw0xAI$default(applyIf, false, null, null, new Function0() { // from class: f4.E
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2$lambda$1;
                SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2$lambda$1 = SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2$lambda$1(Function1.this, saleOnBoardLineItem);
                return SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2$lambda$1;
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$3$lambda$2$lambda$1(Function1 function1, SaleOnBoardLineItem saleOnBoardLineItem) {
        function1.invoke(saleOnBoardLineItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$6$lambda$5(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$20$lambda$9$lambda$8$lambda$7(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardLineItemView$lambda$21(SaleOnBoardLineItem saleOnBoardLineItem, Function1 function1, Function1 function12, boolean z5, int i5, int i6, Composer composer, int i7) {
        SaleOnBoardLineItemView(saleOnBoardLineItem, function1, function12, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
