package dk.molslinjen.ui.views.reusable.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/NumberSelectorTextFocusedState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", "Lorg/threeten/bp/LocalTime;", "focused", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;)V", BuildConfig.FLAVOR, "hasNotHappenedJustNow", "()Z", "copy", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;)Ldk/molslinjen/ui/views/reusable/input/NumberSelectorTextFocusedState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Lorg/threeten/bp/LocalTime;", "getFocused", "()Lorg/threeten/bp/LocalTime;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NumberSelectorTextFocusedState {
    private final LocalTime focused;
    private final String text;

    public NumberSelectorTextFocusedState(String text, LocalTime focused) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(focused, "focused");
        this.text = text;
        this.focused = focused;
    }

    public static /* synthetic */ NumberSelectorTextFocusedState copy$default(NumberSelectorTextFocusedState numberSelectorTextFocusedState, String str, LocalTime localTime, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = numberSelectorTextFocusedState.text;
        }
        if ((i5 & 2) != 0) {
            localTime = numberSelectorTextFocusedState.focused;
        }
        return numberSelectorTextFocusedState.copy(str, localTime);
    }

    public final NumberSelectorTextFocusedState copy(String text, LocalTime focused) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(focused, "focused");
        return new NumberSelectorTextFocusedState(text, focused);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumberSelectorTextFocusedState)) {
            return false;
        }
        NumberSelectorTextFocusedState numberSelectorTextFocusedState = (NumberSelectorTextFocusedState) other;
        return Intrinsics.areEqual(this.text, numberSelectorTextFocusedState.text) && Intrinsics.areEqual(this.focused, numberSelectorTextFocusedState.focused);
    }

    public final String getText() {
        return this.text;
    }

    public final boolean hasNotHappenedJustNow() {
        return this.focused.isBefore(LocalTime.now().minusNanos(200000000L));
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.focused.hashCode();
    }

    public String toString() {
        return "NumberSelectorTextFocusedState(text=" + this.text + ", focused=" + this.focused + ")";
    }

    public /* synthetic */ NumberSelectorTextFocusedState(String str, LocalTime localTime, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? LocalTime.now() : localTime);
    }
}
