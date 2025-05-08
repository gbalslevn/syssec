package com.kizitonwose.calendar.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lcom/kizitonwose/calendar/compose/ItemPlacementInfo;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/kizitonwose/calendar/compose/ItemCoordinates;", "itemCoordinates", BuildConfig.FLAVOR, "onItemPlaced", "(Lcom/kizitonwose/calendar/compose/ItemCoordinates;)V", "Lcom/kizitonwose/calendar/compose/ItemCoordinates;", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ItemPlacementInfo {
    private ItemCoordinates itemCoordinates;

    public final void onItemPlaced(ItemCoordinates itemCoordinates) {
        Intrinsics.checkNotNullParameter(itemCoordinates, "itemCoordinates");
        this.itemCoordinates = itemCoordinates;
    }
}
