package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.api.services.account.creditcard.request.RegisterCreditCardRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.request.MergeAccountAssetsRequestParameters;
import dk.molslinjen.api.services.account.request.MergeTicketsRequestParameter;
import dk.molslinjen.api.services.account.vehicle.request.RegisterVehicleRequestParameter;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¨\u0006\u0004"}, d2 = {"toRequestParameters", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AssetsMergeTypeExtensionsKt {
    public static final MergeAccountAssetsRequestParameters toRequestParameters(List<? extends AssetsMergeType<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AssetsMergeType assetsMergeType = (AssetsMergeType) it.next();
            if (assetsMergeType instanceof AssetsMergeType.CreditCardsAssets) {
                List<CreditCard> items = ((AssetsMergeType.CreditCardsAssets) assetsMergeType).getItems();
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                for (CreditCard creditCard : items) {
                    arrayList6.add(new RegisterCreditCardRequestParameter(creditCard.getMaskedNumber(), creditCard.getCardType().toDTO(), creditCard.getExpirationMonth(), creditCard.getExpirationYear(), creditCard.getCreditCardToken()));
                }
                arrayList.addAll(arrayList6);
            } else if (assetsMergeType instanceof AssetsMergeType.PassengersAssets) {
                List<UserPassenger> items2 = ((AssetsMergeType.PassengersAssets) assetsMergeType).getItems();
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
                for (UserPassenger userPassenger : items2) {
                    arrayList7.add(new RegisterPassengerRequestParameter(userPassenger.getFirstName(), userPassenger.getLastName(), userPassenger.getGender().toDTO(), userPassenger.getBirthdate(), userPassenger.getNationality()));
                }
                arrayList2.addAll(arrayList7);
            } else if (assetsMergeType instanceof AssetsMergeType.VehiclesAssets) {
                List<UserVehicle> items3 = ((AssetsMergeType.VehiclesAssets) assetsMergeType).getItems();
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items3, 10));
                for (UserVehicle userVehicle : items3) {
                    arrayList8.add(new RegisterVehicleRequestParameter(userVehicle.getName(), userVehicle.getLicensePlate()));
                }
                arrayList3.addAll(arrayList8);
            } else if (assetsMergeType instanceof AssetsMergeType.Tickets) {
                List<BookingHeader> items4 = ((AssetsMergeType.Tickets) assetsMergeType).getItems();
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items4, 10));
                for (BookingHeader bookingHeader : items4) {
                    arrayList9.add(new MergeTicketsRequestParameter(bookingHeader.getReservationId(), bookingHeader.getPhone()));
                }
                arrayList4.addAll(arrayList9);
            } else {
                if (!(assetsMergeType instanceof AssetsMergeType.MultiRide)) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList5.addAll(((AssetsMergeType.MultiRide) assetsMergeType).getItems());
            }
        }
        return new MergeAccountAssetsRequestParameters(arrayList5, arrayList3, arrayList2, arrayList, arrayList4);
    }
}
