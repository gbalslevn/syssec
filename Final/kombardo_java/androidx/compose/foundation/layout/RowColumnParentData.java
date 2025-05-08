package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnParentData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "fill", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/FlowLayoutData;", "flowLayoutData", "<init>", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;Landroidx/compose/foundation/layout/FlowLayoutData;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getWeight", "()F", "setWeight", "(F)V", "Z", "getFill", "()Z", "setFill", "(Z)V", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "Landroidx/compose/foundation/layout/FlowLayoutData;", "getFlowLayoutData", "()Landroidx/compose/foundation/layout/FlowLayoutData;", "setFlowLayoutData", "(Landroidx/compose/foundation/layout/FlowLayoutData;)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RowColumnParentData {
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private FlowLayoutData flowLayoutData;
    private float weight;

    public RowColumnParentData(float f5, boolean z5, CrossAxisAlignment crossAxisAlignment, FlowLayoutData flowLayoutData) {
        this.weight = f5;
        this.fill = z5;
        this.crossAxisAlignment = crossAxisAlignment;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) other;
        return Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment) && Intrinsics.areEqual((Object) null, (Object) null);
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final FlowLayoutData getFlowLayoutData() {
        return null;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hashCode = ((Float.hashCode(this.weight) * 31) + Boolean.hashCode(this.fill)) * 31;
        CrossAxisAlignment crossAxisAlignment = this.crossAxisAlignment;
        return (hashCode + (crossAxisAlignment == null ? 0 : crossAxisAlignment.hashCode())) * 31;
    }

    public final void setCrossAxisAlignment(CrossAxisAlignment crossAxisAlignment) {
        this.crossAxisAlignment = crossAxisAlignment;
    }

    public final void setFill(boolean z5) {
        this.fill = z5;
    }

    public final void setWeight(float f5) {
        this.weight = f5;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=" + ((Object) null) + ')';
    }

    public /* synthetic */ RowColumnParentData(float f5, boolean z5, CrossAxisAlignment crossAxisAlignment, FlowLayoutData flowLayoutData, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0.0f : f5, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? null : crossAxisAlignment, (i5 & 8) != 0 ? null : flowLayoutData);
    }
}
