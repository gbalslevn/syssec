package dk.molslinjen.domain.analytics;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/analytics/IAdjustTracker;", BuildConfig.FLAVOR, "setup", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "registerLifecycleCallbacks", "Lkotlin/Function1;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "firstOpen", "purchase", "revenue", BuildConfig.FLAVOR, "currency", BuildConfig.FLAVOR, "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAdjustTracker {
    void firstOpen();

    Object purchase(int i5, String str, Continuation<? super Unit> continuation);

    void setup(Context context, Function1<? super Application.ActivityLifecycleCallbacks, Unit> registerLifecycleCallbacks);
}
