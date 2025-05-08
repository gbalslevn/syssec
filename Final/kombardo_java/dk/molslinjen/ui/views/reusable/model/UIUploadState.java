package dk.molslinjen.ui.views.reusable.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Idle", "Loading", "Success", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UIUploadState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UIUploadState[] $VALUES;
    public static final UIUploadState Idle = new UIUploadState("Idle", 0);
    public static final UIUploadState Loading = new UIUploadState("Loading", 1);
    public static final UIUploadState Success = new UIUploadState("Success", 2);

    private static final /* synthetic */ UIUploadState[] $values() {
        return new UIUploadState[]{Idle, Loading, Success};
    }

    static {
        UIUploadState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private UIUploadState(String str, int i5) {
    }

    public static UIUploadState valueOf(String str) {
        return (UIUploadState) Enum.valueOf(UIUploadState.class, str);
    }

    public static UIUploadState[] values() {
        return (UIUploadState[]) $VALUES.clone();
    }
}
