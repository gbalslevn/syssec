package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.addons.RecommendedProductImageViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t²\u0006\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/Product;", "product", BuildConfig.FLAVOR, "RecommendedProductImageView", "(Ldk/molslinjen/domain/model/booking/product/Product;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "isImageLoaded", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RecommendedProductImageViewKt {
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v8 */
    public static final void RecommendedProductImageView(final Product product, Composer composer, final int i5) {
        int i6;
        int i7;
        ?? r14;
        String m3193buildImageUrlC8IHX40;
        Composer startRestartGroup = composer.startRestartGroup(-1786151598);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1786151598, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.RecommendedProductImageView (RecommendedProductImageView.kt:33)");
            }
            startRestartGroup.startReplaceGroup(-74223124);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-74220947);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Integer RecommendedProductImageView$lambda$1 = RecommendedProductImageView$lambda$1(mutableState);
            startRestartGroup.startReplaceGroup(-74217979);
            if (RecommendedProductImageView$lambda$1 == null) {
                m3193buildImageUrlC8IHX40 = null;
                i7 = i6;
                r14 = 0;
            } else {
                int intValue = RecommendedProductImageView$lambda$1.intValue();
                ImageHelper imageHelper = ImageHelper.INSTANCE;
                ProductPresentation presentation = product != null ? product.getPresentation() : null;
                ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
                i7 = i6;
                r14 = 0;
                m3193buildImageUrlC8IHX40 = imageHelper.m3193buildImageUrlC8IHX40(imageProductPresentation != null ? imageProductPresentation.getImageUrl() : null, Dp.m2597boximpl(ComposeExtensionsKt.pxToDp(intValue, startRestartGroup, 0)), Dp.m2597boximpl(Dp.m2599constructorimpl(ComposeExtensionsKt.pxToDp(intValue, startRestartGroup, 0) / 2.0f)), startRestartGroup, 3072, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 2.0f, r14, 2, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceGroup(-74203484);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: D2.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RecommendedProductImageView$lambda$8$lambda$7;
                        RecommendedProductImageView$lambda$8$lambda$7 = RecommendedProductImageViewKt.RecommendedProductImageView$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                        return RecommendedProductImageView$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m104backgroundbw27NRU$default, (Function1) rememberedValue3);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), r14);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(2143545314);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: D2.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RecommendedProductImageView$lambda$11$lambda$10$lambda$9;
                        RecommendedProductImageView$lambda$11$lambda$10$lambda$9 = RecommendedProductImageViewKt.RecommendedProductImageView$lambda$11$lambda$10$lambda$9(MutableState.this, (AsyncImagePainter.State.Success) obj);
                        return RecommendedProductImageView$lambda$11$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            int i8 = i7;
            AsyncImagePainter m2745rememberAsyncImagePainterMqRF_0 = SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, (Function1) rememberedValue4, null, null, 0, startRestartGroup, 196608, 478);
            Accessibility accessibility = Accessibility.INSTANCE;
            ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, accessibility.getSkip(), fillMaxWidth$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24960, 104);
            startRestartGroup.startReplaceGroup(2143550499);
            if (!RecommendedProductImageView$lambda$4(mutableState2)) {
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_recommended_product_placeholder, startRestartGroup, 6), accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            }
            startRestartGroup.endReplaceGroup();
            ProductTagViewKt.ProductTagView(boxScopeInstance.align(PaddingKt.m311padding3ABfNKs(companion2, Dp.m2599constructorimpl(8)), companion3.getTopStart()), product, startRestartGroup, (i8 << 3) & 112, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecommendedProductImageView$lambda$12;
                    RecommendedProductImageView$lambda$12 = RecommendedProductImageViewKt.RecommendedProductImageView$lambda$12(Product.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RecommendedProductImageView$lambda$12;
                }
            });
        }
    }

    private static final Integer RecommendedProductImageView$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendedProductImageView$lambda$11$lambda$10$lambda$9(MutableState mutableState, AsyncImagePainter.State.Success it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RecommendedProductImageView$lambda$5(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendedProductImageView$lambda$12(Product product, int i5, Composer composer, int i6) {
        RecommendedProductImageView(product, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean RecommendedProductImageView$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RecommendedProductImageView$lambda$5(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendedProductImageView$lambda$8$lambda$7(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }
}
