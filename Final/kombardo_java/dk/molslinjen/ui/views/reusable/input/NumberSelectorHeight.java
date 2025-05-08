package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/NumberSelectorHeight;", BuildConfig.FLAVOR, "value", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Ljava/lang/String;IF)V", "getValue-D9Ej5fM", "()F", "F", "Small", "Large", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumberSelectorHeight {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NumberSelectorHeight[] $VALUES;
    private final float value;
    public static final NumberSelectorHeight Small = new NumberSelectorHeight("Small", 0, Dp.m2599constructorimpl(44));
    public static final NumberSelectorHeight Large = new NumberSelectorHeight("Large", 1, Dp.m2599constructorimpl(72));

    private static final /* synthetic */ NumberSelectorHeight[] $values() {
        return new NumberSelectorHeight[]{Small, Large};
    }

    static {
        NumberSelectorHeight[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private NumberSelectorHeight(String str, int i5, float f5) {
        this.value = f5;
    }

    public static NumberSelectorHeight valueOf(String str) {
        return (NumberSelectorHeight) Enum.valueOf(NumberSelectorHeight.class, str);
    }

    public static NumberSelectorHeight[] values() {
        return (NumberSelectorHeight[]) $VALUES.clone();
    }

    /* renamed from: getValue-D9Ej5fM, reason: not valid java name and from getter */
    public final float getValue() {
        return this.value;
    }
}
