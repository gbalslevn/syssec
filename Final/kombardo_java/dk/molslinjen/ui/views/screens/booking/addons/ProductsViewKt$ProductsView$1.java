package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductsViewKt$ProductsView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $emptyDescription;
    final /* synthetic */ int $emptyIcon;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function2<Product, Integer, Unit> $onQuantityChanged;
    final /* synthetic */ boolean $onWhiteBackground;
    final /* synthetic */ List<ProductGroup> $productGroups;
    final /* synthetic */ Function2<Composer, Integer, Unit> $selectSeatingSection;
    final /* synthetic */ ColumnScope $this_ProductsView;
    final /* synthetic */ AnnotatedString $title;
    final /* synthetic */ List<UnavailableProduct> $unavailableProducts;
    final /* synthetic */ PriceWithCurrency $unavailableSeatReservationPrice;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductsViewKt$ProductsView$1(List<ProductGroup> list, Function2<? super Composer, ? super Integer, Unit> function2, PriceWithCurrency priceWithCurrency, ColumnScope columnScope, AnnotatedString annotatedString, String str, int i5, LazyListState lazyListState, List<UnavailableProduct> list2, Function2<? super Product, ? super Integer, Unit> function22, boolean z5) {
        this.$productGroups = list;
        this.$selectSeatingSection = function2;
        this.$unavailableSeatReservationPrice = priceWithCurrency;
        this.$this_ProductsView = columnScope;
        this.$title = annotatedString;
        this.$emptyDescription = str;
        this.$emptyIcon = i5;
        this.$lazyListState = lazyListState;
        this.$unavailableProducts = list2;
        this.$onQuantityChanged = function22;
        this.$onWhiteBackground = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(final AnnotatedString annotatedString, final List list, final PriceWithCurrency priceWithCurrency, ProductGroup productGroup, final Function2 function2, List list2, boolean z5, Function2 function22, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (annotatedString != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-905848695, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt$ProductsView$1$1$1$1
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
                        ComposerKt.traceEventStart(-905848695, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductsView.kt:83)");
                    }
                    ProductsViewKt.HeaderView(AnnotatedString.this, TypographyKt.getH2Bold(), composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        if (!list.isEmpty() || priceWithCurrency != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1544594176, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt$ProductsView$1$1$1$2
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
                        ComposerKt.traceEventStart(1544594176, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductsView.kt:91)");
                    }
                    UnavailableProductsViewKt.UnavailableProductsView(StringResources_androidKt.stringResource(R.string.editFlow_unavailable_addons, composer, 6), list, priceWithCurrency, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        if (productGroup != null) {
            ProductsViewKt.productGroup$default(LazyColumn, productGroup, false, function22, 2, null);
        }
        if (function2 != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(681236171, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt$ProductsView$1$1$1$4$1
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
                        ComposerKt.traceEventStart(681236171, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductsView.kt:108)");
                    }
                    function2.invoke(composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ProductsViewKt.productGroup(LazyColumn, (ProductGroup) it.next(), z5, function22);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v15 ??, still in use, count: 1, list:
          (r3v15 ?? I:java.lang.Object) from 0x0140: INVOKE (r21v0 ?? I:androidx.compose.runtime.Composer), (r3v15 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:36)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public final void invoke(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v15 ??, still in use, count: 1, list:
          (r3v15 ?? I:java.lang.Object) from 0x0140: INVOKE (r21v0 ?? I:androidx.compose.runtime.Composer), (r3v15 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:36)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r21v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
}
