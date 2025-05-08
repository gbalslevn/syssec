package dk.molslinjen.domain.model.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/config/TransportationSelectionModel;", BuildConfig.FLAVOR, "transportations", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Transportation;", "transportationCategories", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getTransportations", "()Ljava/util/List;", "getTransportationCategories", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TransportationSelectionModel {
    private final List<TransportationCategory> transportationCategories;
    private final List<Transportation> transportations;

    /* JADX WARN: Multi-variable type inference failed */
    public TransportationSelectionModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportationSelectionModel copy$default(TransportationSelectionModel transportationSelectionModel, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = transportationSelectionModel.transportations;
        }
        if ((i5 & 2) != 0) {
            list2 = transportationSelectionModel.transportationCategories;
        }
        return transportationSelectionModel.copy(list, list2);
    }

    public final List<Transportation> component1() {
        return this.transportations;
    }

    public final List<TransportationCategory> component2() {
        return this.transportationCategories;
    }

    public final TransportationSelectionModel copy(List<Transportation> transportations, List<TransportationCategory> transportationCategories) {
        return new TransportationSelectionModel(transportations, transportationCategories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportationSelectionModel)) {
            return false;
        }
        TransportationSelectionModel transportationSelectionModel = (TransportationSelectionModel) other;
        return Intrinsics.areEqual(this.transportations, transportationSelectionModel.transportations) && Intrinsics.areEqual(this.transportationCategories, transportationSelectionModel.transportationCategories);
    }

    public final List<TransportationCategory> getTransportationCategories() {
        return this.transportationCategories;
    }

    public final List<Transportation> getTransportations() {
        return this.transportations;
    }

    public int hashCode() {
        List<Transportation> list = this.transportations;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<TransportationCategory> list2 = this.transportationCategories;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "TransportationSelectionModel(transportations=" + this.transportations + ", transportationCategories=" + this.transportationCategories + ")";
    }

    public TransportationSelectionModel(List<Transportation> list, List<TransportationCategory> list2) {
        this.transportations = list;
        this.transportationCategories = list2;
    }

    public /* synthetic */ TransportationSelectionModel(List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : list, (i5 & 2) != 0 ? null : list2);
    }
}
