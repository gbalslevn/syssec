package dk.molslinjen.ui.views.reusable.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "isLoading", "enabled", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "<init>", "(Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Z", "()Z", "getEnabled", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SimpleButtonData {
    private final boolean enabled;
    private final boolean isLoading;
    private final Function0<Unit> onClick;
    private final String text;

    public SimpleButtonData(String text, boolean z5, boolean z6, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.text = text;
        this.isLoading = z5;
        this.enabled = z6;
        this.onClick = onClick;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleButtonData)) {
            return false;
        }
        SimpleButtonData simpleButtonData = (SimpleButtonData) other;
        return Intrinsics.areEqual(this.text, simpleButtonData.text) && this.isLoading == simpleButtonData.isLoading && this.enabled == simpleButtonData.enabled && Intrinsics.areEqual(this.onClick, simpleButtonData.onClick);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.onClick.hashCode();
    }

    /* renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "SimpleButtonData(text=" + this.text + ", isLoading=" + this.isLoading + ", enabled=" + this.enabled + ", onClick=" + this.onClick + ")";
    }

    public /* synthetic */ SimpleButtonData(String str, boolean z5, boolean z6, Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? true : z6, function0);
    }
}
