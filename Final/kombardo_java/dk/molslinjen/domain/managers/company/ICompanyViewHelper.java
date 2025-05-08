package dk.molslinjen.domain.managers.company;

import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", BuildConfig.FLAVOR, "showCompanyPopupState", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "getShowCompanyPopupState", "()Lkotlinx/coroutines/flow/StateFlow;", "showCompanyPopup", BuildConfig.FLAVOR, "hideCompanyPopup", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICompanyViewHelper {
    StateFlow<Boolean> getShowCompanyPopupState();

    void hideCompanyPopup();

    void showCompanyPopup();
}
