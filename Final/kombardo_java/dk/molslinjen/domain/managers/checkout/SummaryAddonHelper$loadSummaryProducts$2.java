package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.api.services.booking.response.SummaryProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.domain.extensions.domain.SplitTestExtensionsKt;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SummaryAddonHelper$loadSummaryProducts$2", f = "SummaryAddonHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SummaryAddonHelper$loadSummaryProducts$2 extends SuspendLambda implements Function2<SummaryProductsResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SummaryAddonHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryAddonHelper$loadSummaryProducts$2(SummaryAddonHelper summaryAddonHelper, Continuation<? super SummaryAddonHelper$loadSummaryProducts$2> continuation) {
        super(2, continuation);
        this.this$0 = summaryAddonHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SummaryAddonHelper$loadSummaryProducts$2 summaryAddonHelper$loadSummaryProducts$2 = new SummaryAddonHelper$loadSummaryProducts$2(this.this$0, continuation);
        summaryAddonHelper$loadSummaryProducts$2.L$0 = obj;
        return summaryAddonHelper$loadSummaryProducts$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SummaryProductsResponseDTO summaryProductsResponseDTO, Continuation<? super Unit> continuation) {
        return ((SummaryAddonHelper$loadSummaryProducts$2) create(summaryProductsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<? extends Product> emptyList;
        List<? extends Product> emptyList2;
        SummaryAddonHelper.SummaryAddonState value;
        ISplitTestManager iSplitTestManager;
        IStringsProvider iStringsProvider;
        ISplitTestManager iSplitTestManager2;
        IStringsProvider iStringsProvider2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SummaryProductsResponseDTO summaryProductsResponseDTO = (SummaryProductsResponseDTO) this.L$0;
        List<ProductResponseDTO> outboundProducts = summaryProductsResponseDTO.getOutboundProducts();
        if (outboundProducts != null) {
            List<ProductResponseDTO> list = outboundProducts;
            SummaryAddonHelper summaryAddonHelper = this.this$0;
            emptyList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Product invoke = Product.INSTANCE.invoke((ProductResponseDTO) it.next());
                iSplitTestManager2 = summaryAddonHelper.splitTestManager;
                iStringsProvider2 = summaryAddonHelper.stringProvider;
                emptyList.add(SplitTestExtensionsKt.applySplitTestChanges(invoke, iSplitTestManager2, iStringsProvider2));
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        List<ProductResponseDTO> returnProducts = summaryProductsResponseDTO.getReturnProducts();
        if (returnProducts != null) {
            List<ProductResponseDTO> list2 = returnProducts;
            SummaryAddonHelper summaryAddonHelper2 = this.this$0;
            emptyList2 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                Product invoke2 = Product.INSTANCE.invoke((ProductResponseDTO) it2.next());
                iSplitTestManager = summaryAddonHelper2.splitTestManager;
                iStringsProvider = summaryAddonHelper2.stringProvider;
                emptyList2.add(SplitTestExtensionsKt.applySplitTestChanges(invoke2, iSplitTestManager, iStringsProvider));
            }
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        MutableStateFlow<SummaryAddonHelper.SummaryAddonState> summaryAddonState = this.this$0.getSummaryAddonState();
        do {
            value = summaryAddonState.getValue();
        } while (!summaryAddonState.compareAndSet(value, value.copy(emptyList, emptyList2)));
        return Unit.INSTANCE;
    }
}
