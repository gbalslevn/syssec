package com.kizitonwose.calendar.compose;

import java.io.Serializable;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/kizitonwose/calendar/compose/VisibleItemState;", "Ljava/io/Serializable;", "firstVisibleItemIndex", BuildConfig.FLAVOR, "firstVisibleItemScrollOffset", "<init>", "(II)V", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VisibleItemState implements Serializable {
    private final int firstVisibleItemIndex;
    private final int firstVisibleItemScrollOffset;

    public VisibleItemState(int i5, int i6) {
        this.firstVisibleItemIndex = i5;
        this.firstVisibleItemScrollOffset = i6;
    }

    public final int getFirstVisibleItemIndex() {
        return this.firstVisibleItemIndex;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }
}
