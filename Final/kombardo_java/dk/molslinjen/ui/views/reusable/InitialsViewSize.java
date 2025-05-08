package dk.molslinjen.ui.views.reusable;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/ui/views/reusable/InitialsViewSize;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Small", "Medium", "Large", "size", "Landroidx/compose/ui/unit/Dp;", "getSize-D9Ej5fM", "()F", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InitialsViewSize {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InitialsViewSize[] $VALUES;
    public static final InitialsViewSize Small = new InitialsViewSize("Small", 0);
    public static final InitialsViewSize Medium = new InitialsViewSize("Medium", 1);
    public static final InitialsViewSize Large = new InitialsViewSize("Large", 2);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitialsViewSize.values().length];
            try {
                iArr[InitialsViewSize.Small.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitialsViewSize.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitialsViewSize.Large.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ InitialsViewSize[] $values() {
        return new InitialsViewSize[]{Small, Medium, Large};
    }

    static {
        InitialsViewSize[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private InitialsViewSize(String str, int i5) {
    }

    public static InitialsViewSize valueOf(String str) {
        return (InitialsViewSize) Enum.valueOf(InitialsViewSize.class, str);
    }

    public static InitialsViewSize[] values() {
        return (InitialsViewSize[]) $VALUES.clone();
    }

    /* renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m3390getSizeD9Ej5fM() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return Dp.m2599constructorimpl(32);
        }
        if (i5 == 2) {
            return Dp.m2599constructorimpl(56);
        }
        if (i5 == 3) {
            return Dp.m2599constructorimpl(80);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final TextStyle getTextStyle() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return TypographyKt.getParagraphSmallBold();
        }
        if (i5 == 2 || i5 == 3) {
            return TypographyKt.getH2Bold();
        }
        throw new NoWhenBranchMatchedException();
    }
}
