package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/NestedVectorStack;", "T", BuildConfig.FLAVOR, "()V", "currentIndexes", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "vectors", BuildConfig.FLAVOR, "Landroidx/compose/runtime/collection/MutableVector;", "[Landroidx/compose/runtime/collection/MutableVector;", "isNotEmpty", BuildConfig.FLAVOR, "pop", "()Ljava/lang/Object;", Constants.PUSH, BuildConfig.FLAVOR, "vector", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedVectorStack<T> {
    private int size;
    private int[] currentIndexes = new int[16];
    private MutableVector<T>[] vectors = new MutableVector[16];

    public final boolean isNotEmpty() {
        int i5 = this.size;
        return i5 > 0 && this.currentIndexes[i5 - 1] >= 0;
    }

    public final T pop() {
        int i5 = this.size;
        if (i5 <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()");
        }
        int i6 = i5 - 1;
        int i7 = this.currentIndexes[i6];
        MutableVector<T> mutableVector = this.vectors[i6];
        Intrinsics.checkNotNull(mutableVector);
        if (i7 > 0) {
            this.currentIndexes[i6] = r3[i6] - 1;
        } else if (i7 == 0) {
            this.vectors[i6] = null;
            this.size--;
        }
        return mutableVector.getContent()[i7];
    }

    public final void push(MutableVector<T> vector) {
        if (vector.isEmpty()) {
            return;
        }
        int i5 = this.size;
        int[] iArr = this.currentIndexes;
        if (i5 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.currentIndexes = copyOf;
            MutableVector<T>[] mutableVectorArr = this.vectors;
            Object[] copyOf2 = Arrays.copyOf(mutableVectorArr, mutableVectorArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.vectors = (MutableVector[]) copyOf2;
        }
        this.currentIndexes[i5] = vector.getSize() - 1;
        this.vectors[i5] = vector;
        this.size++;
    }
}
