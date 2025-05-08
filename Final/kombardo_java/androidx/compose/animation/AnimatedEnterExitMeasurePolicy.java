package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u000f\u001a\u00020\f*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u0012*\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0017\u001a\u00020\u0012*\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u0018\u001a\u00020\u0012*\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J)\u0010\u0019\u001a\u00020\u0012*\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "scope", "<init>", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "Landroidx/compose/ui/layout/MeasureScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", BuildConfig.FLAVOR, "hasLookaheadOccurred", "Z", "getHasLookaheadOccurred", "()Z", "setHasLookaheadOccurred", "(Z)V", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private boolean hasLookaheadOccurred;
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        this.scope = animatedVisibilityScopeImpl;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).maxIntrinsicHeight(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).maxIntrinsicWidth(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).maxIntrinsicWidth(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v24 */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        Object obj;
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(list.get(i5).mo1946measureBRTryo0(j5));
        }
        Placeable placeable = null;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    Object obj2 = arrayList.get(i6);
                    int width2 = ((Placeable) obj2).getWidth();
                    if (width < width2) {
                        obj = obj2;
                        width = width2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj;
        int width3 = placeable2 != null ? placeable2.getWidth() : 0;
        if (!arrayList.isEmpty()) {
            ?? r12 = arrayList.get(0);
            int height = ((Placeable) r12).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex2) {
                int i7 = 1;
                boolean z5 = r12;
                while (true) {
                    Object obj3 = arrayList.get(i7);
                    int height2 = ((Placeable) obj3).getHeight();
                    r12 = z5;
                    if (height < height2) {
                        r12 = obj3;
                        height = height2;
                    }
                    if (i7 == lastIndex2) {
                        break;
                    }
                    i7++;
                    z5 = r12;
                }
            }
            placeable = r12;
        }
        Placeable placeable3 = placeable;
        int height3 = placeable3 != null ? placeable3.getHeight() : 0;
        if (measureScope.isLookingAhead()) {
            this.hasLookaheadOccurred = true;
            this.scope.getTargetSize$animation_release().setValue(IntSize.m2656boximpl(IntSizeKt.IntSize(width3, height3)));
        } else if (!this.hasLookaheadOccurred) {
            this.scope.getTargetSize$animation_release().setValue(IntSize.m2656boximpl(IntSizeKt.IntSize(width3, height3)));
        }
        return MeasureScope.layout$default(measureScope, width3, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<Placeable> list2 = arrayList;
                int size2 = list2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    Placeable.PlacementScope.place$default(placementScope, list2.get(i8), 0, 0, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).minIntrinsicHeight(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).minIntrinsicWidth(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).minIntrinsicWidth(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }
}
