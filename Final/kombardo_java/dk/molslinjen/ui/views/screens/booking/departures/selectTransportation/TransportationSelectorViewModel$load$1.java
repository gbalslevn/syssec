package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationCategory;
import dk.molslinjen.domain.model.config.TransportationSelectionModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import java.util.Collection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel$load$1", f = "TransportationSelectorViewModel.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TransportationSelectorViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TransportationSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransportationSelectorViewModel$load$1(TransportationSelectorViewModel transportationSelectorViewModel, Continuation<? super TransportationSelectorViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = transportationSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransportationSelectorViewModel$load$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        MutableStateFlow mutableStateFlow;
        Object value;
        Transportation selectedTransportation;
        List<Transportation> transportations;
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            RouteSharedSelectedState value2 = iRouteManager.getSharedSelectedState().getValue();
            if (value2 != null) {
                iRouteManager2 = this.this$0.routeManager;
                TransportationSelectionModel transportationSelectionModel = iRouteManager2.getTransportationSelectionModel();
                List<TransportationCategory> transportationCategories = transportationSelectionModel.getTransportationCategories();
                TransportationCategory transportationCategory = null;
                if (transportationCategories != null) {
                    Iterator<T> it = transportationCategories.iterator();
                    loop0: while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        List<Transportation> transportations2 = ((TransportationCategory) next).getTransportations();
                        if (!(transportations2 instanceof Collection) || !transportations2.isEmpty()) {
                            Iterator<T> it2 = transportations2.iterator();
                            while (it2.hasNext()) {
                                if (Intrinsics.areEqual(((Transportation) it2.next()).getId(), value2.getSelectedTransportation().getId())) {
                                    transportationCategory = next;
                                    break loop0;
                                }
                            }
                        }
                    }
                    transportationCategory = transportationCategory;
                }
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    selectedTransportation = value2.getSelectedTransportation();
                    if ((transportationCategory == null || (transportations = transportationCategory.getTransportations()) == null) && (transportations = transportationSelectionModel.getTransportations()) == null) {
                        transportations = CollectionsKt.emptyList();
                    }
                } while (!mutableStateFlow.compareAndSet(value, new TransportationSelectorViewModel.ViewState(selectedTransportation, transportationCategory, transportations, transportationSelectionModel.getTransportationCategories())));
                return Unit.INSTANCE;
            }
            iSnackbarService = this.this$0.snackbarService;
            this.label = 1;
            if (iSnackbarService.publishGenericError(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransportationSelectorViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
