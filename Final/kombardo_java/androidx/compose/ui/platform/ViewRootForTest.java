package androidx.compose.ui.platform;

import androidx.compose.ui.node.RootForTest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/node/RootForTest;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ViewRootForTest extends RootForTest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R6\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\b\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/ViewRootForTest$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/ViewRootForTest;", BuildConfig.FLAVOR, "onViewCreatedCallback", "Lkotlin/jvm/functions/Function1;", "getOnViewCreatedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnViewCreatedCallback", "(Lkotlin/jvm/functions/Function1;)V", "getOnViewCreatedCallback$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static Function1<? super ViewRootForTest, Unit> onViewCreatedCallback;

        private Companion() {
        }

        public final Function1<ViewRootForTest, Unit> getOnViewCreatedCallback() {
            return onViewCreatedCallback;
        }
    }
}
