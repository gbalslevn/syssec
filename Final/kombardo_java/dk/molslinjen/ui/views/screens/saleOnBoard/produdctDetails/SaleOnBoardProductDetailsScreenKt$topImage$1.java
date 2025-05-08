package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardProductDetailsScreenKt$topImage$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $imageLoadingFailed;
    final /* synthetic */ SaleOnBoardProduct $product;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$topImage$1(MutableState<Boolean> mutableState, SaleOnBoardProduct saleOnBoardProduct) {
        this.$imageLoadingFailed = mutableState;
        this.$product = saleOnBoardProduct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

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
            ComposerKt.traceEventStart(-210997124, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.topImage.<anonymous> (SaleOnBoardProductDetailsScreen.kt:247)");
        }
        if (!this.$imageLoadingFailed.getValue().booleanValue()) {
            composer.startReplaceGroup(893910410);
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(224)), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null);
            String squareImageUrl = this.$product.getSquareImageUrl();
            composer.startReplaceGroup(444487370);
            boolean changed = composer.changed(this.$imageLoadingFailed);
            final MutableState<Boolean> mutableState = this.$imageLoadingFailed;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SaleOnBoardProductDetailsScreenKt$topImage$1.invoke$lambda$1$lambda$0(MutableState.this, (AsyncImagePainter.State.Error) obj);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue, null, 0, composer, 0, 446), Accessibility.INSTANCE.getSkip(), m104backgroundbw27NRU$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, composer, 24960, 104);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(894446865);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, composer, 6), Accessibility.INSTANCE.getSkip(), BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(224)), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null), null, null, 0.0f, null, composer, 384, 120);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
