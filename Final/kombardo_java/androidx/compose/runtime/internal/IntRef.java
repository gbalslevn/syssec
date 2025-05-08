package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/internal/IntRef;", BuildConfig.FLAVOR, "element", BuildConfig.FLAVOR, "(I)V", "getElement", "()I", "setElement", "toString", BuildConfig.FLAVOR, "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntRef {
    private int element;

    public IntRef(int i5) {
        this.element = i5;
    }

    public final int getElement() {
        return this.element;
    }

    public final void setElement(int i5) {
        this.element = i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntRef(element = ");
        sb.append(this.element);
        sb.append(")@");
        String num = Integer.toString(hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    public /* synthetic */ IntRef(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }
}
