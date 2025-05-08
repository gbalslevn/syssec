package dk.molslinjen.ui.views.global.topbar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", BuildConfig.FLAVOR, "<init>", "()V", "Back", "None", "Custom", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton$Back;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton$Custom;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton$None;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavigationButton {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/NavigationButton$Back;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Back extends NavigationButton {
        public static final Back INSTANCE = new Back();

        private Back() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/NavigationButton$Custom;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "configuration", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "<init>", "(Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;)V", "getConfiguration", "()Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Custom extends NavigationButton {
        private final TopBarButtonConfiguration configuration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(TopBarButtonConfiguration configuration) {
            super(null);
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.configuration = configuration;
        }

        public final TopBarButtonConfiguration getConfiguration() {
            return this.configuration;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/NavigationButton$None;", "Ldk/molslinjen/ui/views/global/topbar/NavigationButton;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class None extends NavigationButton {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    public /* synthetic */ NavigationButton(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NavigationButton() {
    }
}
