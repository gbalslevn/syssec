package dk.molslinjen.core.snackbar;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B/\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0001\u0003\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarStyle;", BuildConfig.FLAVOR, "containerColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "leftIcon", BuildConfig.FLAVOR, "iconsTint", "<init>", "(JJLjava/lang/Integer;J)V", "getContainerColor-0d7_KjU", "()J", "J", "getTextColor-0d7_KjU", "getLeftIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconsTint-0d7_KjU", "Default", "Information", "Error", "Ldk/molslinjen/core/snackbar/SnackbarStyle$Default;", "Ldk/molslinjen/core/snackbar/SnackbarStyle$Error;", "Ldk/molslinjen/core/snackbar/SnackbarStyle$Information;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SnackbarStyle {
    private final long containerColor;
    private final long iconsTint;
    private final Integer leftIcon;
    private final long textColor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarStyle$Default;", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "leftIcon", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/Integer;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Default extends SnackbarStyle {
        public /* synthetic */ Default(Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : num);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Default(Integer num) {
            super(r0.m3274getTagBlue0d7_KjU(), r0.m3253getBrandBlack10d7_KjU(), num, r0.m3253getBrandBlack10d7_KjU(), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarStyle$Error;", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Error extends SnackbarStyle {
        public static final Error INSTANCE = new Error();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Error() {
            super(r0.m3272getSignalRed0d7_KjU(), r0.m3281getWhite0d7_KjU(), Integer.valueOf(R.drawable.icon_alert_warning), r0.m3281getWhite0d7_KjU(), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarStyle$Information;", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Information extends SnackbarStyle {
        public static final Information INSTANCE = new Information();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Information() {
            super(r0.m3264getGrey10d7_KjU(), r0.m3281getWhite0d7_KjU(), Integer.valueOf(R.drawable.icon_alert_warning), r0.m3268getGrey50d7_KjU(), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    public /* synthetic */ SnackbarStyle(long j5, long j6, Integer num, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, num, j7);
    }

    /* renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* renamed from: getIconsTint-0d7_KjU, reason: not valid java name and from getter */
    public final long getIconsTint() {
        return this.iconsTint;
    }

    public final Integer getLeftIcon() {
        return this.leftIcon;
    }

    /* renamed from: getTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextColor() {
        return this.textColor;
    }

    private SnackbarStyle(long j5, long j6, Integer num, long j7) {
        this.containerColor = j5;
        this.textColor = j6;
        this.leftIcon = num;
        this.iconsTint = j7;
    }
}
