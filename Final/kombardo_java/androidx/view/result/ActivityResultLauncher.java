package androidx.view.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H'¢\u0006\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Landroidx/activity/result/ActivityResultLauncher;", "I", BuildConfig.FLAVOR, "<init>", "()V", "input", BuildConfig.FLAVOR, "launch", "(Ljava/lang/Object;)V", "Landroidx/core/app/ActivityOptionsCompat;", "options", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    public void launch(I input) {
        launch(input, null);
    }

    public abstract void launch(I input, ActivityOptionsCompat options);

    public abstract void unregister();
}
