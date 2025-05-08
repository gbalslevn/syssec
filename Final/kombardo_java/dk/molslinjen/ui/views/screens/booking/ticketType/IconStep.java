package dk.molslinjen.ui.views.screens.booking.ticketType;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0006\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001b\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/IconStep;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/Step;", BuildConfig.FLAVOR, "icon", "text", BuildConfig.FLAVOR, "isFerry", "busChangeOnFerry", BuildConfig.FLAVOR, "busChangeText", "<init>", "(ILjava/lang/Integer;ZZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "I", "getIcon", "Ljava/lang/Integer;", "getText", "()Ljava/lang/Integer;", "Z", "()Z", "getBusChangeOnFerry", "Ljava/lang/String;", "getBusChangeText", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class IconStep implements Step {
    private final boolean busChangeOnFerry;
    private final String busChangeText;
    private final int icon;
    private final boolean isFerry;
    private final Integer text;

    public IconStep(int i5, Integer num, boolean z5, boolean z6, String str) {
        this.icon = i5;
        this.text = num;
        this.isFerry = z5;
        this.busChangeOnFerry = z6;
        this.busChangeText = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconStep)) {
            return false;
        }
        IconStep iconStep = (IconStep) other;
        return this.icon == iconStep.icon && Intrinsics.areEqual(this.text, iconStep.text) && this.isFerry == iconStep.isFerry && this.busChangeOnFerry == iconStep.busChangeOnFerry && Intrinsics.areEqual(this.busChangeText, iconStep.busChangeText);
    }

    public final boolean getBusChangeOnFerry() {
        return this.busChangeOnFerry;
    }

    public final String getBusChangeText() {
        return this.busChangeText;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final Integer getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.icon) * 31;
        Integer num = this.text;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isFerry)) * 31) + Boolean.hashCode(this.busChangeOnFerry)) * 31;
        String str = this.busChangeText;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* renamed from: isFerry, reason: from getter */
    public final boolean getIsFerry() {
        return this.isFerry;
    }

    public String toString() {
        return "IconStep(icon=" + this.icon + ", text=" + this.text + ", isFerry=" + this.isFerry + ", busChangeOnFerry=" + this.busChangeOnFerry + ", busChangeText=" + this.busChangeText + ")";
    }

    public /* synthetic */ IconStep(int i5, Integer num, boolean z5, boolean z6, String str, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? false : z5, (i6 & 8) != 0 ? false : z6, (i6 & 16) != 0 ? null : str);
    }
}
