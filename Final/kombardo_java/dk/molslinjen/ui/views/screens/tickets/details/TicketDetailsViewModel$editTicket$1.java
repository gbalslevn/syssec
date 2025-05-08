package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$editTicket$1", f = "TicketDetailsViewModel.kt", l = {223, 227}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel$editTicket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $startEdit;
    Object L$0;
    int label;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$editTicket$1(TicketDetailsViewModel ticketDetailsViewModel, Context context, Function0<Unit> function0, Continuation<? super TicketDetailsViewModel$editTicket$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketDetailsViewModel;
        this.$context = context;
        this.$startEdit = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailsViewModel$editTicket$1(this.this$0, this.$context, this.$startEdit, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Booking booking;
        IConfigurationManager iConfigurationManager;
        List<CurrencyType> enabledCurrencies;
        IEditManager iEditManager;
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            booking = this.this$0.getViewState().getValue().getBooking();
            if (booking == null) {
                return Unit.INSTANCE;
            }
            iConfigurationManager = this.this$0.configurationManager;
            Site site = booking.getSite();
            this.L$0 = booking;
            this.label = 1;
            obj = iConfigurationManager.getActiveConfiguration(site, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            booking = (Booking) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
        if (localizedSiteConfiguration == null || (enabledCurrencies = localizedSiteConfiguration.getEnabledCurrencies()) == null) {
            return Unit.INSTANCE;
        }
        if (enabledCurrencies.contains(booking.getOrderTotal().getPrice().getCurrencyType())) {
            iEditManager = this.this$0.editManager;
            iEditManager.startEdit(booking);
            this.$startEdit.invoke();
            return Unit.INSTANCE;
        }
        String formatted = PriceFormatExtensionsKt.formatted(booking.getOrderTotal().getPrice().getCurrencyType(), this.$context);
        iSnackbarService = this.this$0.snackbarService;
        String string = this.$context.getString(R.string.ticketDetails_unsupportedCurrency, formatted);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SnackbarEvent.Information information = new SnackbarEvent.Information(new SnackbarText.StringText(string), null, false, 6, null);
        this.L$0 = null;
        this.label = 2;
        if (iSnackbarService.publishEvent(information, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketDetailsViewModel$editTicket$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
