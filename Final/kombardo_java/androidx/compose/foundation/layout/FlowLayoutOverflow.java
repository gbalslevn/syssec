package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u001dBa\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR(\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR(\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001c\u0082\u0001\u0001\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "type", BuildConfig.FLAVOR, "minLinesToShowCollapse", "minCrossAxisSizeToShowCollapse", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "seeMoreGetter", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "createOverflowState$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "createOverflowState", "state", BuildConfig.FLAVOR, "list", "addOverflowComposables$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;)V", "addOverflowComposables", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "I", "Lkotlin/jvm/functions/Function1;", "OverflowType", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FlowLayoutOverflow {
    private final Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> collapseGetter;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private final Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> seeMoreGetter;
    private final OverflowType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "Visible", "Clip", "ExpandIndicator", "ExpandOrCollapseIndicator", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum OverflowType {
        Visible,
        Clip,
        ExpandIndicator,
        ExpandOrCollapseIndicator
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverflowType.values().length];
            try {
                iArr[OverflowType.ExpandIndicator.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OverflowType.ExpandOrCollapseIndicator.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ FlowLayoutOverflow(OverflowType overflowType, int i5, int i6, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i5, i6, function1, function12);
    }

    public final void addOverflowComposables$foundation_layout_release(FlowLayoutOverflowState state, List<Function2<Composer, Integer, Unit>> list) {
        Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> function1 = this.seeMoreGetter;
        Function2<Composer, Integer, Unit> invoke = function1 != null ? function1.invoke(state) : null;
        Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> function12 = this.collapseGetter;
        Function2<Composer, Integer, Unit> invoke2 = function12 != null ? function12.invoke(state) : null;
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i5 == 1) {
            if (invoke != null) {
                list.add(invoke);
            }
        } else {
            if (i5 != 2) {
                return;
            }
            if (invoke != null) {
                list.add(invoke);
            }
            if (invoke2 != null) {
                list.add(invoke2);
            }
        }
    }

    public final FlowLayoutOverflowState createOverflowState$foundation_layout_release() {
        return new FlowLayoutOverflowState(this.type, this.minLinesToShowCollapse, this.minCrossAxisSizeToShowCollapse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FlowLayoutOverflow(OverflowType overflowType, int i5, int i6, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        this.type = overflowType;
        this.minLinesToShowCollapse = i5;
        this.minCrossAxisSizeToShowCollapse = i6;
        this.seeMoreGetter = function1;
        this.collapseGetter = function12;
    }
}
