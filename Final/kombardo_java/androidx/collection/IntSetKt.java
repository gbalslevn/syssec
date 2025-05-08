package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/collection/MutableIntSet;", "mutableIntSetOf", "()Landroidx/collection/MutableIntSet;", "EmptyIntSet", "Landroidx/collection/MutableIntSet;", BuildConfig.FLAVOR, "EmptyIntArray", "[I", "getEmptyIntArray", "()[I", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }
}
