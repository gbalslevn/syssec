package com.kizitonwose.calendar.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/kizitonwose/calendar/compose/ContentHeightMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Wrap", "Fill", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContentHeightMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ContentHeightMode[] $VALUES;
    public static final ContentHeightMode Wrap = new ContentHeightMode("Wrap", 0);
    public static final ContentHeightMode Fill = new ContentHeightMode("Fill", 1);

    private static final /* synthetic */ ContentHeightMode[] $values() {
        return new ContentHeightMode[]{Wrap, Fill};
    }

    static {
        ContentHeightMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ContentHeightMode(String str, int i5) {
    }

    public static ContentHeightMode valueOf(String str) {
        return (ContentHeightMode) Enum.valueOf(ContentHeightMode.class, str);
    }

    public static ContentHeightMode[] values() {
        return (ContentHeightMode[]) $VALUES.clone();
    }
}
