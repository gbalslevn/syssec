package androidx.compose.ui.contentcapture;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager;", BuildConfig.FLAVOR, "Companion", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContentCaptureManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R0\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048G@GX\u0087\u000e¢\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "<set-?>", "isEnabled", "Z", "()Z", "setEnabled", "(Z)V", "isEnabled$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean isEnabled = true;

        private Companion() {
        }

        public final boolean isEnabled() {
            return isEnabled;
        }
    }
}
