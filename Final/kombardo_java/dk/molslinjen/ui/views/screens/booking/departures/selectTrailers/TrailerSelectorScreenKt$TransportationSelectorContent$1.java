package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TrailerSelectorScreenKt$TransportationSelectorContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<DepartureDirection, Boolean, Unit> $onChangedForDirection;
    final /* synthetic */ TrailerSelectorViewModel.TrailerSelectedState $outboundTrailerState;
    final /* synthetic */ TrailerSelectorViewModel.TrailerSelectedState $returnTrailerState;
    final /* synthetic */ Function1<TrailerProduct, Unit> $trailerSelected;
    final /* synthetic */ TrailerSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TrailerSelectorScreenKt$TransportationSelectorContent$1(TrailerSelectorViewModel.ViewState viewState, TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState, TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2, Function1<? super TrailerProduct, Unit> function1, Function2<? super DepartureDirection, ? super Boolean, Unit> function2) {
        this.$viewState = viewState;
        this.$outboundTrailerState = trailerSelectedState;
        this.$returnTrailerState = trailerSelectedState2;
        this.$trailerSelected = function1;
        this.$onChangedForDirection = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(final TrailerSelectorViewModel.ViewState viewState, final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState, final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2, final Function1 function1, final Function2 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        for (final TrailerProduct trailerProduct : viewState.getTrailers()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1338961990, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreenKt$TransportationSelectorContent$1$1$2$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    TrailerProduct selectedTrailer;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1338961990, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TransportationSelectorContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrailerSelectorScreen.kt:104)");
                    }
                    DividerKt.m843Divider9IZ8Weo(null, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), composer, 432, 1);
                    boolean z5 = TrailerSelectorViewModel.ViewState.this.getIsAddingReturnFromBookingSummary() && trailerSelectedState.getSelectedTrailer() != null;
                    TrailerProduct selectedTrailer2 = trailerSelectedState.getSelectedTrailer();
                    String str = null;
                    boolean areEqual = Intrinsics.areEqual(selectedTrailer2 != null ? selectedTrailer2.getId() : null, trailerProduct.getId());
                    TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState3 = trailerSelectedState2;
                    if (trailerSelectedState3 != null && (selectedTrailer = trailerSelectedState3.getSelectedTrailer()) != null) {
                        str = selectedTrailer.getId();
                    }
                    TrailerRowViewKt.TrailerRowView(trailerProduct, areEqual, Intrinsics.areEqual(str, trailerProduct.getId()), TrailerSelectorViewModel.ViewState.this.getIsAddingReturnFromBookingSummary(), z5, TrailerSelectorViewModel.ViewState.this.getBookingType(), function1, function2, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TrailerSelectorScreenKt.INSTANCE.m3460getLambda1$app_kombardoProd(), 3, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v25 ??, still in use, count: 1, list:
          (r2v25 ?? I:java.lang.Object) from 0x02a2: INVOKE (r35v0 ?? I:androidx.compose.runtime.Composer), (r2v25 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:89)
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
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v25 ??, still in use, count: 1, list:
          (r2v25 ?? I:java.lang.Object) from 0x02a2: INVOKE (r35v0 ?? I:androidx.compose.runtime.Composer), (r2v25 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:89)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r35v0 ??
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
