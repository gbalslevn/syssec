package dk.molslinjen.core.providers;

import android.content.Context;
import dk.molslinjen.domain.providers.IStringsProvider;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/core/providers/StringsProvider;", "Ldk/molslinjen/domain/providers/IStringsProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "selectSeatNotEnoughSeatsSelected", BuildConfig.FLAVOR, "getSelectSeatNotEnoughSeatsSelected", "()Ljava/lang/String;", "ticketsMismatchAppTarget", "invalidTicketsCount", BuildConfig.FLAVOR, "validationLicensePlateExists", "getValidationLicensePlateExists", "splitTestRampsAlternativeName", "getSplitTestRampsAlternativeName", "splitTestRampsAlternativeDescription", "getSplitTestRampsAlternativeDescription", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StringsProvider implements IStringsProvider {
    private final Context context;

    public StringsProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // dk.molslinjen.domain.providers.IStringsProvider
    public String getSelectSeatNotEnoughSeatsSelected() {
        String string = this.context.getString(R.string.selectSeat_snackbar_notEnoughSeatsSelected);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // dk.molslinjen.domain.providers.IStringsProvider
    public String getSplitTestRampsAlternativeDescription() {
        String string = this.context.getString(R.string.splittest_rampsAlternativeText_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // dk.molslinjen.domain.providers.IStringsProvider
    public String getSplitTestRampsAlternativeName() {
        String string = this.context.getString(R.string.splittest_rampsAlternativeText_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // dk.molslinjen.domain.providers.IStringsProvider
    public String getValidationLicensePlateExists() {
        String string = this.context.getString(R.string.validation_licensePlateExists);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // dk.molslinjen.domain.providers.IStringsProvider
    public String ticketsMismatchAppTarget(int invalidTicketsCount) {
        String quantityString = this.context.getResources().getQuantityString(R.plurals.tickets_mismatchAppTarget, invalidTicketsCount);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }
}
