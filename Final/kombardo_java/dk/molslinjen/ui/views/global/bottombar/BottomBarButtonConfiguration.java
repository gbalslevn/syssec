package dk.molslinjen.ui.views.global.bottombar;

import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001a\u0010\u0010R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "destination", BuildConfig.FLAVOR, "lottieRes", "titleRes", "Lkotlinx/coroutines/flow/StateFlow;", "badge", "<init>", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;IILkotlinx/coroutines/flow/StateFlow;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "I", "getLottieRes", "getTitleRes", "Lkotlinx/coroutines/flow/StateFlow;", "getBadge", "()Lkotlinx/coroutines/flow/StateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BottomBarButtonConfiguration {
    private final StateFlow<Integer> badge;
    private final TypedDestinationSpec<?> destination;
    private final int lottieRes;
    private final int titleRes;

    public BottomBarButtonConfiguration(TypedDestinationSpec<?> destination, int i5, int i6, StateFlow<Integer> badge) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.destination = destination;
        this.lottieRes = i5;
        this.titleRes = i6;
        this.badge = badge;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomBarButtonConfiguration)) {
            return false;
        }
        BottomBarButtonConfiguration bottomBarButtonConfiguration = (BottomBarButtonConfiguration) other;
        return Intrinsics.areEqual(this.destination, bottomBarButtonConfiguration.destination) && this.lottieRes == bottomBarButtonConfiguration.lottieRes && this.titleRes == bottomBarButtonConfiguration.titleRes && Intrinsics.areEqual(this.badge, bottomBarButtonConfiguration.badge);
    }

    public final StateFlow<Integer> getBadge() {
        return this.badge;
    }

    public final TypedDestinationSpec<?> getDestination() {
        return this.destination;
    }

    public final int getLottieRes() {
        return this.lottieRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public int hashCode() {
        return (((((this.destination.hashCode() * 31) + Integer.hashCode(this.lottieRes)) * 31) + Integer.hashCode(this.titleRes)) * 31) + this.badge.hashCode();
    }

    public String toString() {
        return "BottomBarButtonConfiguration(destination=" + this.destination + ", lottieRes=" + this.lottieRes + ", titleRes=" + this.titleRes + ", badge=" + this.badge + ")";
    }

    public /* synthetic */ BottomBarButtonConfiguration(TypedDestinationSpec typedDestinationSpec, int i5, int i6, StateFlow stateFlow, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedDestinationSpec, i5, i6, (i7 & 8) != 0 ? StateFlowKt.MutableStateFlow(0) : stateFlow);
    }
}
