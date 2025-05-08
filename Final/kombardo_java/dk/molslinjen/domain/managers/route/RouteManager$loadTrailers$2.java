package dk.molslinjen.domain.managers.route;

import dk.molslinjen.api.services.booking.response.TrailersResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductTrailerResponseDTO;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "it", "Ldk/molslinjen/api/services/booking/response/TrailersResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$loadTrailers$2", f = "RouteManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class RouteManager$loadTrailers$2 extends SuspendLambda implements Function2<TrailersResponseDTO, Continuation<? super List<? extends TrailerProduct>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteManager$loadTrailers$2(Continuation<? super RouteManager$loadTrailers$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RouteManager$loadTrailers$2 routeManager$loadTrailers$2 = new RouteManager$loadTrailers$2(continuation);
        routeManager$loadTrailers$2.L$0 = obj;
        return routeManager$loadTrailers$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TrailersResponseDTO trailersResponseDTO, Continuation<? super List<TrailerProduct>> continuation) {
        return ((RouteManager$loadTrailers$2) create(trailersResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<ProductTrailerResponseDTO> trailers = ((TrailersResponseDTO) this.L$0).getTrailers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(trailers, 10));
        Iterator<T> it = trailers.iterator();
        while (it.hasNext()) {
            arrayList.add(new TrailerProduct((ProductTrailerResponseDTO) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TrailersResponseDTO trailersResponseDTO, Continuation<? super List<? extends TrailerProduct>> continuation) {
        return invoke2(trailersResponseDTO, (Continuation<? super List<TrailerProduct>>) continuation);
    }
}
