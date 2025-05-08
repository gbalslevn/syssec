package dk.molslinjen.core.navigation;

import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/core/navigation/ICheckoutNavigator;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/Direction;", "startCheckout", "()Lcom/ramcosta/composedestinations/spec/Direction;", "Ldk/molslinjen/domain/model/booking/TicketSection;", "currentSection", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "currentDepartureDirection", "nextStep", "(Ldk/molslinjen/domain/model/booking/TicketSection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, "sections", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICheckoutNavigator {
    Direction nextStep(TicketSection currentSection, BookingType bookingType, DepartureDirection currentDepartureDirection);

    List<TicketSection> sections();

    Direction startCheckout();
}
