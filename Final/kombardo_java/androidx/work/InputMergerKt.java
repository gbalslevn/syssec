package androidx.work;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", BuildConfig.FLAVOR, "fromClassName", "Landroidx/work/InputMerger;", "className", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InputMergerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("InputMerger");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"InputMerger\")");
        TAG = tagWithPrefix;
    }

    public static final InputMerger fromClassName(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Object newInstance = Class.forName(className).getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (InputMerger) newInstance;
        } catch (Exception e5) {
            Logger.get().error(TAG, "Trouble instantiating " + className, e5);
            return null;
        }
    }
}
