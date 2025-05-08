package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/IOldAppDataMigrator;", BuildConfig.FLAVOR, "migrate", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IOldAppDataMigrator {
    Object migrate(Context context, Continuation<? super List<String>> continuation);
}
