package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R+\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\nR$\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/TopAppBarState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialHeightOffsetLimit", "initialHeightOffset", "initialContentOffset", "<init>", "(FFF)V", "<set-?>", "heightOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "heightOffsetLimit", "contentOffset$delegate", "getContentOffset", "setContentOffset", "contentOffset", "Landroidx/compose/runtime/MutableFloatState;", "_heightOffset", "newOffset", "getHeightOffset", "setHeightOffset", "heightOffset", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TopAppBarState {
    private static final Saver<TopAppBarState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, TopAppBarState, List<? extends Float>>() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Float> invoke(SaverScope saverScope, TopAppBarState topAppBarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(topAppBarState.getHeightOffsetLimit()), Float.valueOf(topAppBarState.getHeightOffset()), Float.valueOf(topAppBarState.getContentOffset())});
        }
    }, new Function1<List<? extends Float>, TopAppBarState>() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TopAppBarState invoke(List<? extends Float> list) {
            return invoke2((List<Float>) list);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TopAppBarState invoke2(List<Float> list) {
            return new TopAppBarState(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue());
        }
    });
    private MutableFloatState _heightOffset;

    /* renamed from: contentOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState contentOffset;

    /* renamed from: heightOffsetLimit$delegate, reason: from kotlin metadata */
    private final MutableFloatState heightOffsetLimit;

    public TopAppBarState(float f5, float f6, float f7) {
        this.heightOffsetLimit = PrimitiveSnapshotStateKt.mutableFloatStateOf(f5);
        this.contentOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f7);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f6);
    }

    public final float getContentOffset() {
        return this.contentOffset.getFloatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public final float getHeightOffsetLimit() {
        return this.heightOffsetLimit.getFloatValue();
    }
}
