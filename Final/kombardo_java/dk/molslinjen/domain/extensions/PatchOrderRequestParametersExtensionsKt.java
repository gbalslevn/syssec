package dk.molslinjen.domain.extensions;

import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import dk.molslinjen.domain.model.account.CreditCardType;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ak\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002¨\u0006\u0014"}, d2 = {"invoke", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$Companion;", "name", BuildConfig.FLAVOR, "phone", "phoneNumberCode", "email", "notificationMethod", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "timetableId", "storeNumber", "timeSlotId", BuildConfig.FLAVOR, "lineItems", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "transactionId", "creditCardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PatchOrderRequestParametersExtensionsKt {
    public static final PatchOrderRequestParameters invoke(PatchOrderRequestParameters.Companion companion, String name, String phone, String phoneNumberCode, String email, NotificationType notificationMethod, String timetableId, String storeNumber, int i5, List<SaleOnBoardLineItem> lineItems, String transactionId, CreditCardType creditCardType) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(phoneNumberCode, "phoneNumberCode");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(notificationMethod, "notificationMethod");
        Intrinsics.checkNotNullParameter(timetableId, "timetableId");
        Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(creditCardType, "creditCardType");
        ArrayList arrayList = new ArrayList();
        for (SaleOnBoardLineItem saleOnBoardLineItem : lineItems) {
            arrayList.add(new PatchOrderRequestParameters.LineItemRequestParameters(saleOnBoardLineItem.getProduct().getItemNumber(), saleOnBoardLineItem.getProduct().getName(), saleOnBoardLineItem.getUnitPrice().getValue(), saleOnBoardLineItem.getQuantity()));
            for (Iterator it = saleOnBoardLineItem.getAddOns().iterator(); it.hasNext(); it = it) {
                SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption = (SaleOnBoardProductAddOnOption) it.next();
                arrayList.add(new PatchOrderRequestParameters.AddOnRequestParameters(saleOnBoardProductAddOnOption.getItemNumber(), saleOnBoardProductAddOnOption.getName(), saleOnBoardProductAddOnOption.getPrice().getValue(), saleOnBoardLineItem.getQuantity(), true));
            }
            SaleOnBoardVariant variant = saleOnBoardLineItem.getVariant();
            if (variant != null) {
                arrayList.add(new PatchOrderRequestParameters.VariantRequestParameters(variant.getName()));
            }
        }
        return new PatchOrderRequestParameters(name, phoneNumberCode + phone, email, notificationMethod.toDTO(), timetableId, storeNumber, i5, arrayList, transactionId, creditCardType.toPaymentMethodRequestParameters(), (String) null, 1024, (DefaultConstructorMarker) null);
    }
}
