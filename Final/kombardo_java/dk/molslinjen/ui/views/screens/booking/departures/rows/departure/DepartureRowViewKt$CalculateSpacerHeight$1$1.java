package dk.molslinjen.ui.views.screens.booking.departures.rows.departure;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowViewKt$CalculateSpacerHeight$1$1", f = "DepartureRowView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DepartureRowViewKt$CalculateSpacerHeight$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Rect $cheapestTicketTypeBannerBounds;
    final /* synthetic */ Rect $departureTextBounds;
    final /* synthetic */ Rect $detailsContainerBounds;
    final /* synthetic */ Rect $fewTicketsBannerBounds;
    final /* synthetic */ Rect $priceBoxBounds;
    final /* synthetic */ boolean $showCheapestTicketTypeBanner;
    final /* synthetic */ boolean $showFewTicketLeftBanner;
    final /* synthetic */ MutableState<Float> $spacerHeight;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureRowViewKt$CalculateSpacerHeight$1$1(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z5, boolean z6, MutableState<Float> mutableState, Continuation<? super DepartureRowViewKt$CalculateSpacerHeight$1$1> continuation) {
        super(2, continuation);
        this.$departureTextBounds = rect;
        this.$detailsContainerBounds = rect2;
        this.$priceBoxBounds = rect3;
        this.$fewTicketsBannerBounds = rect4;
        this.$cheapestTicketTypeBannerBounds = rect5;
        this.$showFewTicketLeftBanner = z5;
        this.$showCheapestTicketTypeBanner = z6;
        this.$spacerHeight = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DepartureRowViewKt$CalculateSpacerHeight$1$1(this.$departureTextBounds, this.$detailsContainerBounds, this.$priceBoxBounds, this.$fewTicketsBannerBounds, this.$cheapestTicketTypeBannerBounds, this.$showFewTicketLeftBanner, this.$showCheapestTicketTypeBanner, this.$spacerHeight, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Rect rect = this.$departureTextBounds;
        float bottom = rect != null ? rect.getBottom() : 0.0f;
        Rect rect2 = this.$detailsContainerBounds;
        float bottom2 = rect2 != null ? rect2.getBottom() : 0.0f;
        Rect rect3 = this.$departureTextBounds;
        float right = rect3 != null ? rect3.getRight() : 0.0f;
        Rect rect4 = this.$priceBoxBounds;
        float bottom3 = rect4 != null ? rect4.getBottom() : 0.0f;
        Rect rect5 = this.$fewTicketsBannerBounds;
        float top = rect5 != null ? rect5.getTop() : 0.0f;
        Rect rect6 = this.$fewTicketsBannerBounds;
        float left = rect6 != null ? rect6.getLeft() : 0.0f;
        Rect rect7 = this.$fewTicketsBannerBounds;
        float height = rect7 != null ? rect7.getHeight() : 0.0f;
        Rect rect8 = this.$cheapestTicketTypeBannerBounds;
        float top2 = rect8 != null ? rect8.getTop() : 0.0f;
        boolean z5 = this.$showFewTicketLeftBanner;
        if (z5) {
            if (right >= left) {
                f5 = bottom;
            }
            f5 = bottom3;
        } else {
            if (!this.$showCheapestTicketTypeBanner) {
                f5 = 0.0f;
            }
            f5 = bottom3;
        }
        if (z5) {
            Rect rect9 = this.$departureTextBounds;
            Rect.Companion companion = Rect.INSTANCE;
            if (!Intrinsics.areEqual(rect9, companion.getZero()) && !Intrinsics.areEqual(this.$fewTicketsBannerBounds, companion.getZero()) && bottom3 != 0.0f) {
                if (right >= left) {
                    bottom = top < bottom3 ? Math.max(bottom, bottom2) : Math.max(bottom3, Math.max(bottom, bottom2));
                }
            }
            bottom = 0.0f;
        } else {
            if (this.$showCheapestTicketTypeBanner) {
                Rect rect10 = this.$departureTextBounds;
                Rect.Companion companion2 = Rect.INSTANCE;
                if (!Intrinsics.areEqual(rect10, companion2.getZero()) && !Intrinsics.areEqual(this.$cheapestTicketTypeBannerBounds, companion2.getZero()) && bottom3 != 0.0f) {
                    bottom = top2 < bottom3 ? Math.max(bottom, bottom2) : Math.max(bottom3, Math.max(bottom, bottom2));
                }
            }
            bottom = 0.0f;
        }
        if (f5 != 0.0f && bottom != 0.0f) {
            this.$spacerHeight.setValue(Boxing.boxFloat((f5 - bottom) + height));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DepartureRowViewKt$CalculateSpacerHeight$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
