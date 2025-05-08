package dk.molslinjen.ui.views.global.topbar;

import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.views.global.topbar.NavigationButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isVisible", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "navigationButton", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonType;", "buttons", "<init>", "(ZLjava/lang/Integer;Ldk/molslinjen/ui/views/global/topbar/NavigationButton;Ljava/util/List;)V", "copy", "(ZLjava/lang/Integer;Ldk/molslinjen/ui/views/global/topbar/NavigationButton;Ljava/util/List;)Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/Integer;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "getNavigationButton", "()Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TopBarConfiguration {
    private final List<TopBarButtonType> buttons;
    private final boolean isVisible;
    private final NavigationButton navigationButton;
    private final Integer title;

    /* JADX WARN: Multi-variable type inference failed */
    public TopBarConfiguration(boolean z5, Integer num, NavigationButton navigationButton, List<? extends TopBarButtonType> buttons) {
        Intrinsics.checkNotNullParameter(navigationButton, "navigationButton");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        this.isVisible = z5;
        this.title = num;
        this.navigationButton = navigationButton;
        this.buttons = buttons;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopBarConfiguration copy$default(TopBarConfiguration topBarConfiguration, boolean z5, Integer num, NavigationButton navigationButton, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = topBarConfiguration.isVisible;
        }
        if ((i5 & 2) != 0) {
            num = topBarConfiguration.title;
        }
        if ((i5 & 4) != 0) {
            navigationButton = topBarConfiguration.navigationButton;
        }
        if ((i5 & 8) != 0) {
            list = topBarConfiguration.buttons;
        }
        return topBarConfiguration.copy(z5, num, navigationButton, list);
    }

    public final TopBarConfiguration copy(boolean isVisible, Integer title, NavigationButton navigationButton, List<? extends TopBarButtonType> buttons) {
        Intrinsics.checkNotNullParameter(navigationButton, "navigationButton");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        return new TopBarConfiguration(isVisible, title, navigationButton, buttons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopBarConfiguration)) {
            return false;
        }
        TopBarConfiguration topBarConfiguration = (TopBarConfiguration) other;
        return this.isVisible == topBarConfiguration.isVisible && Intrinsics.areEqual(this.title, topBarConfiguration.title) && Intrinsics.areEqual(this.navigationButton, topBarConfiguration.navigationButton) && Intrinsics.areEqual(this.buttons, topBarConfiguration.buttons);
    }

    public final List<TopBarButtonType> getButtons() {
        return this.buttons;
    }

    public final NavigationButton getNavigationButton() {
        return this.navigationButton;
    }

    public final Integer getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isVisible) * 31;
        Integer num = this.title;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.navigationButton.hashCode()) * 31) + this.buttons.hashCode();
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public String toString() {
        return "TopBarConfiguration(isVisible=" + this.isVisible + ", title=" + this.title + ", navigationButton=" + this.navigationButton + ", buttons=" + this.buttons + ")";
    }

    public /* synthetic */ TopBarConfiguration(boolean z5, Integer num, NavigationButton navigationButton, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : num, (i5 & 4) != 0 ? NavigationButton.None.INSTANCE : navigationButton, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
