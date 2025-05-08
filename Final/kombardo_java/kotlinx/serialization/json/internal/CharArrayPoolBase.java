package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0004J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPoolBase;", BuildConfig.FLAVOR, "()V", "arrays", "Lkotlin/collections/ArrayDeque;", BuildConfig.FLAVOR, "charsTotal", BuildConfig.FLAVOR, "releaseImpl", BuildConfig.FLAVOR, "array", "take", "size", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CharArrayPoolBase {
    private final ArrayDeque<char[]> arrays = new ArrayDeque<>();
    private int charsTotal;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void releaseImpl(char[] array) {
        int i5;
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            try {
                int length = this.charsTotal + array.length;
                i5 = ArrayPoolsKt.MAX_CHARS_IN_POOL;
                if (length < i5) {
                    this.charsTotal += array.length;
                    this.arrays.addLast(array);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final char[] take(int size) {
        char[] removeLastOrNull;
        synchronized (this) {
            removeLastOrNull = this.arrays.removeLastOrNull();
            if (removeLastOrNull != null) {
                this.charsTotal -= removeLastOrNull.length;
            } else {
                removeLastOrNull = null;
            }
        }
        return removeLastOrNull == null ? new char[size] : removeLastOrNull;
    }
}
