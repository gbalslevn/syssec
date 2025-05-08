package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\"#\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "NoInspectorInfo", "Lkotlin/jvm/functions/Function1;", "getNoInspectorInfo", "()Lkotlin/jvm/functions/Function1;", BuildConfig.FLAVOR, "isDebugInspectorInfoEnabled", "Z", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InspectableValueKt {
    private static final Function1<InspectorInfo, Unit> NoInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InspectorInfo inspectorInfo) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
            android.support.v4.media.session.a.a(inspectorInfo);
            invoke2((InspectorInfo) null);
            return Unit.INSTANCE;
        }
    };
    private static boolean isDebugInspectorInfoEnabled;

    public static final Function1<InspectorInfo, Unit> getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }
}
