package dk.molslinjen.domain.providers;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\t\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/providers/IStringsProvider;", BuildConfig.FLAVOR, "selectSeatNotEnoughSeatsSelected", BuildConfig.FLAVOR, "getSelectSeatNotEnoughSeatsSelected", "()Ljava/lang/String;", "ticketsMismatchAppTarget", "invalidTicketsCount", BuildConfig.FLAVOR, "validationLicensePlateExists", "getValidationLicensePlateExists", "splitTestRampsAlternativeName", "getSplitTestRampsAlternativeName", "splitTestRampsAlternativeDescription", "getSplitTestRampsAlternativeDescription", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IStringsProvider {
    String getSelectSeatNotEnoughSeatsSelected();

    String getSplitTestRampsAlternativeDescription();

    String getSplitTestRampsAlternativeName();

    String getValidationLicensePlateExists();

    String ticketsMismatchAppTarget(int invalidTicketsCount);
}
