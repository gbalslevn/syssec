package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fBa\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "type", BuildConfig.FLAVOR, "minLinesToShowCollapse", "minCrossAxisSizeToShowCollapse", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "seeMoreGetter", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowRowOverflow extends FlowLayoutOverflow {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FlowRowOverflow Visible = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, 0, null, null, 30, null);
    private static final FlowRowOverflow Clip = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, 0, 0, null, null, 30, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "Clip", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "getClip", "()Landroidx/compose/foundation/layout/FlowRowOverflow;", "getClip$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FlowRowOverflow getClip() {
            return FlowRowOverflow.Clip;
        }

        private Companion() {
        }
    }

    /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i5, int i6, Function1 function1, Function1 function12, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, (i7 & 2) != 0 ? 0 : i5, (i7 & 4) != 0 ? 0 : i6, (i7 & 8) != 0 ? null : function1, (i7 & 16) != 0 ? null : function12);
    }

    private FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i5, int i6, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        super(overflowType, i5, i6, function1, function12, null);
    }
}
