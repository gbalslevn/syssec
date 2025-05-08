package com.kizitonwose.calendar.compose;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/kizitonwose/calendar/compose/ItemCoordinates;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/LayoutCoordinates;", "itemRootCoordinates", "firstDayCoordinates", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getItemRootCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getFirstDayCoordinates", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ItemCoordinates {
    private final LayoutCoordinates firstDayCoordinates;
    private final LayoutCoordinates itemRootCoordinates;

    public ItemCoordinates(LayoutCoordinates itemRootCoordinates, LayoutCoordinates firstDayCoordinates) {
        Intrinsics.checkNotNullParameter(itemRootCoordinates, "itemRootCoordinates");
        Intrinsics.checkNotNullParameter(firstDayCoordinates, "firstDayCoordinates");
        this.itemRootCoordinates = itemRootCoordinates;
        this.firstDayCoordinates = firstDayCoordinates;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemCoordinates)) {
            return false;
        }
        ItemCoordinates itemCoordinates = (ItemCoordinates) other;
        return Intrinsics.areEqual(this.itemRootCoordinates, itemCoordinates.itemRootCoordinates) && Intrinsics.areEqual(this.firstDayCoordinates, itemCoordinates.firstDayCoordinates);
    }

    public int hashCode() {
        return (this.itemRootCoordinates.hashCode() * 31) + this.firstDayCoordinates.hashCode();
    }

    public String toString() {
        return "ItemCoordinates(itemRootCoordinates=" + this.itemRootCoordinates + ", firstDayCoordinates=" + this.firstDayCoordinates + ")";
    }
}
