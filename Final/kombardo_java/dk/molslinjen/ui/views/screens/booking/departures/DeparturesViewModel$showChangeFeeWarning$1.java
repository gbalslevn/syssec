package dk.molslinjen.ui.views.screens.booking.departures;

import android.content.Context;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$showChangeFeeWarning$1", f = "DeparturesViewModel.kt", l = {200}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$showChangeFeeWarning$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DepartureTicket $departureTicket;
    int label;
    final /* synthetic */ DeparturesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesViewModel$showChangeFeeWarning$1(DepartureTicket departureTicket, Context context, DeparturesViewModel departuresViewModel, Continuation<? super DeparturesViewModel$showChangeFeeWarning$1> continuation) {
        super(2, continuation);
        this.$departureTicket = departureTicket;
        this.$context = context;
        this.this$0 = departuresViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesViewModel$showChangeFeeWarning$1(this.$departureTicket, this.$context, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BookingTicket ticket;
        String ticketTypeName;
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PriceWithCurrency changeFee = this.$departureTicket.getChangeFee();
            if (changeFee.getValue() == 0) {
                return Unit.INSTANCE;
            }
            String currencyFormatted = PriceFormatExtensionsKt.getCurrencyFormatted(changeFee, this.$context);
            Context context = this.$context;
            String str = PriceWithCurrency.formattedValue$default(changeFee, false, 1, null) + " " + currencyFormatted;
            Booking booking = this.this$0.getEditState().getValue().getBooking();
            if (booking == null || (ticket = booking.getTicket()) == null || (ticketTypeName = ticket.getTicketTypeName()) == null) {
                return Unit.INSTANCE;
            }
            String string = context.getString(R.string.departures_edit_feeWarning, str, ticketTypeName);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            iSnackbarService = this.this$0.snackbarService;
            SnackbarEvent.Information information = new SnackbarEvent.Information(new SnackbarText.StringText(string), null, false, 6, null);
            this.label = 1;
            if (iSnackbarService.publishEvent(information, this) == coroutine_suspended) {
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
        return ((DeparturesViewModel$showChangeFeeWarning$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
