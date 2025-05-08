package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListScreenKt$shopImage$1 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ SaleOnBoardTimeSlot $firstAvailableTimeSlot;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ SaleOnBoardStore $store;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardFoodListScreenKt$shopImage$1(SaleOnBoardStore saleOnBoardStore, SaleOnBoardTimeSlot saleOnBoardTimeSlot, boolean z5) {
        this.$store = saleOnBoardStore;
        this.$firstAvailableTimeSlot = saleOnBoardTimeSlot;
        this.$isLoading = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
        BoxScopeInstance boxScopeInstance;
        boolean z5;
        Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
        if ((i6 & 129) == 128 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(680615142, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.shopImage.<anonymous> (SaleOnBoardFoodListScreen.kt:284)");
        }
        SaleOnBoardStore saleOnBoardStore = this.$store;
        SaleOnBoardTimeSlot saleOnBoardTimeSlot = this.$firstAvailableTimeSlot;
        boolean z6 = this.$isLoading;
        Modifier.Companion companion = Modifier.INSTANCE;
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ImageKt.Image(PainterResources_androidKt.painterResource(2131165440, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3276getTagOrange0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(239)), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, composer, 24960, 104);
        composer.startReplaceGroup(-748343246);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue == companion4.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-748341204);
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            boxScopeInstance = boxScopeInstance2;
            z5 = z6;
        } else {
            Modifier align = boxScopeInstance2.align(SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(60), 7, null), Dp.m2599constructorimpl(100)), companion2.getCenter());
            String iconUrl = saleOnBoardStore.getIconUrl();
            composer.startReplaceGroup(-748329753);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = SaleOnBoardFoodListScreenKt$shopImage$1.invoke$lambda$3$lambda$2$lambda$1(MutableState.this, (AsyncImagePainter.State.Error) obj);
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            boxScopeInstance = boxScopeInstance2;
            z5 = z6;
            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(iconUrl, null, null, null, null, null, (Function1) rememberedValue2, null, 0, composer, 1572864, 446), saleOnBoardStore.getStoreName(), align, null, null, 0.0f, null, composer, 0, 120);
        }
        composer.endReplaceGroup();
        SaleOnBoardFoodListScreenKt.NextAvailableTimeSlotView(boxScopeInstance, saleOnBoardTimeSlot, z5, composer, 6);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
