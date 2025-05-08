package androidx.compose.runtime;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/RelativeGroupPath;", "Landroidx/compose/runtime/SourceInformationGroupPath;", "parent", BuildConfig.FLAVOR, "index", "<init>", "(Landroidx/compose/runtime/SourceInformationGroupPath;I)V", "Landroidx/compose/runtime/SourceInformationGroupPath;", "getParent", "()Landroidx/compose/runtime/SourceInformationGroupPath;", "I", "getIndex", "()I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class RelativeGroupPath extends SourceInformationGroupPath {
    private final int index;
    private final SourceInformationGroupPath parent;

    public RelativeGroupPath(SourceInformationGroupPath sourceInformationGroupPath, int i5) {
        super(null);
        this.parent = sourceInformationGroupPath;
        this.index = i5;
    }
}
