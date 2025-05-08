package com.kizitonwose.calendar.compose;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/kizitonwose/calendar/compose/ItemCoordinatesStore;", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lcom/kizitonwose/calendar/compose/ItemCoordinates;", BuildConfig.FLAVOR, "onItemPlaced", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "check", "()V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onItemRootPlaced", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "onFirstDayPlaced", "Lkotlin/jvm/functions/Function1;", "itemRootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "firstDayCoordinates", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ItemCoordinatesStore {
    private LayoutCoordinates firstDayCoordinates;
    private LayoutCoordinates itemRootCoordinates;
    private final Function1<ItemCoordinates, Unit> onItemPlaced;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemCoordinatesStore(Function1<? super ItemCoordinates, Unit> onItemPlaced) {
        Intrinsics.checkNotNullParameter(onItemPlaced, "onItemPlaced");
        this.onItemPlaced = onItemPlaced;
    }

    private final void check() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.itemRootCoordinates;
        if (layoutCoordinates2 == null || (layoutCoordinates = this.firstDayCoordinates) == null) {
            return;
        }
        this.onItemPlaced.invoke(new ItemCoordinates(layoutCoordinates2, layoutCoordinates));
    }

    public final void onFirstDayPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.firstDayCoordinates = coordinates;
        check();
    }

    public final void onItemRootPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.itemRootCoordinates = coordinates;
        check();
    }
}
