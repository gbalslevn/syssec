package dk.molslinjen.ui.views.reusable.input.dropdown;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "T", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "displayValue", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDisplayValue", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DropdownItem<T> {
    private final String displayValue;
    private final T value;

    public DropdownItem(String displayValue, T t5) {
        Intrinsics.checkNotNullParameter(displayValue, "displayValue");
        this.displayValue = displayValue;
        this.value = t5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownItem)) {
            return false;
        }
        DropdownItem dropdownItem = (DropdownItem) other;
        return Intrinsics.areEqual(this.displayValue, dropdownItem.displayValue) && Intrinsics.areEqual(this.value, dropdownItem.value);
    }

    public final String getDisplayValue() {
        return this.displayValue;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.displayValue.hashCode() * 31;
        T t5 = this.value;
        return hashCode + (t5 == null ? 0 : t5.hashCode());
    }

    public String toString() {
        return "DropdownItem(displayValue=" + this.displayValue + ", value=" + this.value + ")";
    }
}
