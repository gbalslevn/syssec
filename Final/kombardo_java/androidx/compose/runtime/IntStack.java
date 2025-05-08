package androidx.compose.runtime;

import com.adjust.sdk.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0003J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/IntStack;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, Constants.PUSH, "(I)V", "pop", "()I", "default", "peekOr", "(I)I", "peek", "peek2", "index", BuildConfig.FLAVOR, "isEmpty", "()Z", "clear", "indexOf", BuildConfig.FLAVOR, "slots", "[I", "tos", "I", "getSize", "size", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntStack {
    private int[] slots = new int[10];
    private int tos;

    public final void clear() {
        this.tos = 0;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getTos() {
        return this.tos;
    }

    public final int indexOf(int value) {
        int i5 = this.tos;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.slots[i6] == value) {
                return i6;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.tos == 0;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peek2() {
        return this.slots[this.tos - 2];
    }

    public final int peekOr(int r22) {
        return this.tos > 0 ? peek() : r22;
    }

    public final int pop() {
        int[] iArr = this.slots;
        int i5 = this.tos - 1;
        this.tos = i5;
        return iArr[i5];
    }

    public final void push(int value) {
        int i5 = this.tos;
        int[] iArr = this.slots;
        if (i5 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.slots = copyOf;
        }
        int[] iArr2 = this.slots;
        int i6 = this.tos;
        this.tos = i6 + 1;
        iArr2[i6] = value;
    }

    public final int peek(int index) {
        return this.slots[index];
    }
}
