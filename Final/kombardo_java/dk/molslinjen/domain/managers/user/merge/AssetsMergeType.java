package dk.molslinjen.domain.managers.user.merge;

import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005\t\n\u000b\f\rB\u0017\b\u0004\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "T", BuildConfig.FLAVOR, "items", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "PassengersAssets", "VehiclesAssets", "CreditCardsAssets", "Tickets", "MultiRide", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$CreditCardsAssets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$MultiRide;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$PassengersAssets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$Tickets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$VehiclesAssets;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AssetsMergeType<T> {
    private final List<T> items;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$CreditCardsAssets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "creditCards", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CreditCardsAssets extends AssetsMergeType<CreditCard> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreditCardsAssets(List<CreditCard> creditCards) {
            super(creditCards, null);
            Intrinsics.checkNotNullParameter(creditCards, "creditCards");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$MultiRide;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", BuildConfig.FLAVOR, "multiRideCardIds", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MultiRide extends AssetsMergeType<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiRide(List<String> multiRideCardIds) {
            super(multiRideCardIds, null);
            Intrinsics.checkNotNullParameter(multiRideCardIds, "multiRideCardIds");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$PassengersAssets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "Ldk/molslinjen/domain/model/account/UserPassenger;", "passengers", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PassengersAssets extends AssetsMergeType<UserPassenger> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PassengersAssets(List<UserPassenger> passengers) {
            super(passengers, null);
            Intrinsics.checkNotNullParameter(passengers, "passengers");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$Tickets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "tickets", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Tickets extends AssetsMergeType<BookingHeader> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tickets(List<BookingHeader> tickets) {
            super(tickets, null);
            Intrinsics.checkNotNullParameter(tickets, "tickets");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$VehiclesAssets;", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicles", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class VehiclesAssets extends AssetsMergeType<UserVehicle> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VehiclesAssets(List<UserVehicle> vehicles) {
            super(vehicles, null);
            Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        }
    }

    public /* synthetic */ AssetsMergeType(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public final List<T> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AssetsMergeType(List<? extends T> list) {
        this.items = list;
    }
}
