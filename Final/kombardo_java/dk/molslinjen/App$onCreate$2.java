package dk.molslinjen;

import android.app.Application;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class App$onCreate$2 extends FunctionReferenceImpl implements Function1<Application.ActivityLifecycleCallbacks, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public App$onCreate$2(Object obj) {
        super(1, obj, App.class, "registerActivityLifecycleCallbacks", "registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        invoke2(activityLifecycleCallbacks);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        ((App) this.receiver).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
