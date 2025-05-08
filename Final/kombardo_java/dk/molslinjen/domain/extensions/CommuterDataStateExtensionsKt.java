package dk.molslinjen.domain.extensions;

import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0006"}, d2 = {"getAgreements", BuildConfig.FLAVOR, "T", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "hasData", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommuterDataStateExtensionsKt {
    public static final <T> List<T> getAgreements(CommuterDataState<? extends T> commuterDataState) {
        Intrinsics.checkNotNullParameter(commuterDataState, "<this>");
        if (commuterDataState instanceof CommuterDataState.Data) {
            return ((CommuterDataState.Data) commuterDataState).getAgreements();
        }
        if (commuterDataState instanceof CommuterDataState.Error) {
            List<T> existingData = ((CommuterDataState.Error) commuterDataState).getExistingData();
            return existingData == null ? CollectionsKt.emptyList() : existingData;
        }
        if (Intrinsics.areEqual(commuterDataState, CommuterDataState.Undetermined.INSTANCE)) {
            return CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> boolean hasData(CommuterDataState<? extends T> commuterDataState) {
        Intrinsics.checkNotNullParameter(commuterDataState, "<this>");
        if (commuterDataState instanceof CommuterDataState.Data) {
            if (((CommuterDataState.Data) commuterDataState).getAgreements().isEmpty()) {
                return false;
            }
        } else {
            if (!(commuterDataState instanceof CommuterDataState.Error)) {
                if (Intrinsics.areEqual(commuterDataState, CommuterDataState.Undetermined.INSTANCE)) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (((CommuterDataState.Error) commuterDataState).getExistingData() == null || !(!r3.isEmpty())) {
                return false;
            }
        }
        return true;
    }
}
