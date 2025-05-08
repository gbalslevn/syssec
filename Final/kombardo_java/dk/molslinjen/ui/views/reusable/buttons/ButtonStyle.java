package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material3.RippleConfiguration;
import androidx.compose.ui.graphics.Color;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\f\r\u000e\u000fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", BuildConfig.FLAVOR, "colors", "Ldk/molslinjen/ui/views/reusable/buttons/BaseButtonColors;", "ripple", "Landroidx/compose/material3/RippleConfiguration;", "<init>", "(Ldk/molslinjen/ui/views/reusable/buttons/BaseButtonColors;Landroidx/compose/material3/RippleConfiguration;)V", "getColors", "()Ldk/molslinjen/ui/views/reusable/buttons/BaseButtonColors;", "getRipple", "()Landroidx/compose/material3/RippleConfiguration;", "Primary", "Secondary", "Tertiary", "Destructive", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Destructive;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Primary;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Secondary;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Tertiary;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ButtonStyle {
    private final BaseButtonColors colors;
    private final RippleConfiguration ripple;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Destructive;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Destructive extends ButtonStyle {
        public static final Destructive INSTANCE = new Destructive();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Destructive() {
            super(new BaseButtonColors(r0.m3272getSignalRed0d7_KjU(), r0.m3281getWhite0d7_KjU(), r0.m3268getGrey50d7_KjU(), r0.m3266getGrey30d7_KjU(), null), new RippleConfiguration(Color.INSTANCE.m1498getDarkGray0d7_KjU(), new RippleAlpha(0.2f, 0.2f, 0.2f, 0.2f), null), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Primary;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Primary extends ButtonStyle {
        public static final Primary INSTANCE = new Primary();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Primary() {
            super(new BaseButtonColors(r0.m3262getContrastGreen10d7_KjU(), r0.m3253getBrandBlack10d7_KjU(), r0.m3268getGrey50d7_KjU(), r0.m3266getGrey30d7_KjU(), null), new RippleConfiguration(Color.INSTANCE.m1498getDarkGray0d7_KjU(), new RippleAlpha(0.1f, 0.1f, 0.1f, 0.1f), null), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Secondary;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", "background", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Secondary extends ButtonStyle {
        public /* synthetic */ Secondary(long j5, DefaultConstructorMarker defaultConstructorMarker) {
            this(j5);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Secondary(long j5) {
            super(new BaseButtonColors(j5, r11.m3253getBrandBlack10d7_KjU(), j5, r11.m3266getGrey30d7_KjU(), null), new RippleConfiguration(r11.m3267getGrey40d7_KjU(), new RippleAlpha(0.1f, 0.1f, 0.1f, 0.1f), null), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle$Tertiary;", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Tertiary extends ButtonStyle {
        public static final Tertiary INSTANCE = new Tertiary();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Tertiary() {
            super(new BaseButtonColors(r12.m3268getGrey50d7_KjU(), r12.m3255getBrandBlue10d7_KjU(), 0L, 0L, 12, null), new RippleConfiguration(r12.m3266getGrey30d7_KjU(), new RippleAlpha(0.3f, 0.3f, 0.3f, 0.3f), null), null);
            AppColor appColor = AppColor.INSTANCE;
        }
    }

    public /* synthetic */ ButtonStyle(BaseButtonColors baseButtonColors, RippleConfiguration rippleConfiguration, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseButtonColors, rippleConfiguration);
    }

    public final BaseButtonColors getColors() {
        return this.colors;
    }

    public final RippleConfiguration getRipple() {
        return this.ripple;
    }

    private ButtonStyle(BaseButtonColors baseButtonColors, RippleConfiguration rippleConfiguration) {
        this.colors = baseButtonColors;
        this.ripple = rippleConfiguration;
    }
}
