package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", BuildConfig.FLAVOR, "height", "Landroidx/compose/ui/unit/Dp;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "<init>", "(Ljava/lang/String;IFLandroidx/compose/ui/text/TextStyle;)V", "getHeight-D9Ej5fM", "()F", "F", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "Small", "Regular", "Large", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ButtonConfig {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ButtonConfig[] $VALUES;
    private final float height;
    private final TextStyle textStyle;
    public static final ButtonConfig Small = new ButtonConfig("Small", 0, Dp.m2599constructorimpl(35), TypographyKt.getSubBold());
    public static final ButtonConfig Regular = new ButtonConfig("Regular", 1, Dp.m2599constructorimpl(41), TypographyKt.getParagraphSmallBold());
    public static final ButtonConfig Large = new ButtonConfig("Large", 2, Dp.m2599constructorimpl(51), TypographyKt.getH3Bold());

    private static final /* synthetic */ ButtonConfig[] $values() {
        return new ButtonConfig[]{Small, Regular, Large};
    }

    static {
        ButtonConfig[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ButtonConfig(String str, int i5, float f5, TextStyle textStyle) {
        this.height = f5;
        this.textStyle = textStyle;
    }

    public static ButtonConfig valueOf(String str) {
        return (ButtonConfig) Enum.valueOf(ButtonConfig.class, str);
    }

    public static ButtonConfig[] values() {
        return (ButtonConfig[]) $VALUES.clone();
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getHeight() {
        return this.height;
    }

    public final TextStyle getTextStyle() {
        return this.textStyle;
    }
}
