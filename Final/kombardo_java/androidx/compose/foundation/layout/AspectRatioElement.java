package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AspectRatioNode;", BuildConfig.FLAVOR, "aspectRatio", BuildConfig.FLAVOR, "matchHeightConstraintsFirst", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "<init>", "(FZLkotlin/jvm/functions/Function1;)V", "create", "()Landroidx/compose/foundation/layout/AspectRatioNode;", "node", "update", "(Landroidx/compose/foundation/layout/AspectRatioNode;)V", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "F", "getAspectRatio", "()F", "Z", "getMatchHeightConstraintsFirst", "()Z", "Lkotlin/jvm/functions/Function1;", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioElement extends ModifierNodeElement<AspectRatioNode> {
    private final float aspectRatio;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final boolean matchHeightConstraintsFirst;

    /* JADX WARN: Multi-variable type inference failed */
    public AspectRatioElement(float f5, boolean z5, Function1<? super InspectorInfo, Unit> function1) {
        this.aspectRatio = f5;
        this.matchHeightConstraintsFirst = z5;
        this.inspectorInfo = function1;
        if (f5 > 0.0f) {
            return;
        }
        throw new IllegalArgumentException(("aspectRatio " + f5 + " must be > 0").toString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AspectRatioElement aspectRatioElement = other instanceof AspectRatioElement ? (AspectRatioElement) other : null;
        if (aspectRatioElement == null) {
            return false;
        }
        return this.aspectRatio == aspectRatioElement.aspectRatio && this.matchHeightConstraintsFirst == ((AspectRatioElement) other).matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.hashCode(this.aspectRatio) * 31) + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public AspectRatioNode getNode() {
        return new AspectRatioNode(this.aspectRatio, this.matchHeightConstraintsFirst);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(AspectRatioNode node) {
        node.setAspectRatio(this.aspectRatio);
        node.setMatchHeightConstraintsFirst(this.matchHeightConstraintsFirst);
    }
}
