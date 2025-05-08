package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon;", BuildConfig.FLAVOR, "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PointerIcon {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/input/pointer/PointerIcon;", "Default", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getDefault", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "Crosshair", "getCrosshair", "Text", "getText", "Hand", "getHand", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();
        private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();
        private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();
        private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

        private Companion() {
        }

        public final PointerIcon getDefault() {
            return Default;
        }

        public final PointerIcon getHand() {
            return Hand;
        }
    }
}
