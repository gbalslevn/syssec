package dk.molslinjen.ui.views.global.bottombar;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isVisible", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;", "buttons", "<init>", "(ZLjava/util/List;)V", "copy", "(ZLjava/util/List;)Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BottomBarConfiguration {
    private final List<BottomBarButtonConfiguration> buttons;
    private final boolean isVisible;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final BottomBarConfiguration Hidden = new BottomBarConfiguration(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Hidden", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "getHidden", "()Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BottomBarConfiguration getHidden() {
            return BottomBarConfiguration.Hidden;
        }

        private Companion() {
        }
    }

    public BottomBarConfiguration(boolean z5, List<BottomBarButtonConfiguration> list) {
        this.isVisible = z5;
        this.buttons = list;
    }

    public final BottomBarConfiguration copy(boolean isVisible, List<BottomBarButtonConfiguration> buttons) {
        return new BottomBarConfiguration(isVisible, buttons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomBarConfiguration)) {
            return false;
        }
        BottomBarConfiguration bottomBarConfiguration = (BottomBarConfiguration) other;
        return this.isVisible == bottomBarConfiguration.isVisible && Intrinsics.areEqual(this.buttons, bottomBarConfiguration.buttons);
    }

    public final List<BottomBarButtonConfiguration> getButtons() {
        return this.buttons;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isVisible) * 31;
        List<BottomBarButtonConfiguration> list = this.buttons;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public String toString() {
        return "BottomBarConfiguration(isVisible=" + this.isVisible + ", buttons=" + this.buttons + ")";
    }

    public /* synthetic */ BottomBarConfiguration(boolean z5, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? null : list);
    }
}
