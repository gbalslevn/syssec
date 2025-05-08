package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/Owner;", "requireOwner", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/Owner;", BuildConfig.FLAVOR, "DebugChanges", "Z", "Landroidx/compose/ui/unit/Density;", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LayoutNodeKt {
    private static final boolean DebugChanges = false;
    private static final Density DefaultDensity = DensityKt.Density$default(1.0f, 0.0f, 2, null);

    public static final /* synthetic */ Density access$getDefaultDensity$p() {
        return DefaultDensity;
    }

    public static final Owner requireOwner(LayoutNode layoutNode) {
        Owner owner = layoutNode.getOwner();
        if (owner != null) {
            return owner;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("LayoutNode should be attached to an owner");
        throw new KotlinNothingValueException();
    }
}
