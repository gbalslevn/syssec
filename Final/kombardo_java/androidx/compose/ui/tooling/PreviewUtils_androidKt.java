package androidx.compose.ui.tooling;

import android.support.v4.media.session.a;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a5\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0014\u0010\u0005\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "Ljava/lang/Class;", BuildConfig.FLAVOR, "asPreviewProviderClass", "(Ljava/lang/String;)Ljava/lang/Class;", "parameterProviderClass", BuildConfig.FLAVOR, "parameterProviderIndex", BuildConfig.FLAVOR, "getPreviewProviderParameters", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PreviewUtils_androidKt {
    public static final Class<Object> asPreviewProviderClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e5) {
            PreviewLogger.INSTANCE.logError$ui_tooling_release("Unable to find PreviewProvider '" + str + '\'', e5);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0019, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object[] getPreviewProviderParameters(Class<Object> cls, int i5) {
        int i6 = 0;
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            boolean z5 = false;
            Constructor<?> constructor = null;
            while (true) {
                if (i6 < length) {
                    Constructor<?> constructor2 = constructors[i6];
                    if (constructor2.getParameterTypes().length == 0) {
                        if (z5) {
                            break;
                        }
                        z5 = true;
                        constructor = constructor2;
                    }
                    i6++;
                } else if (!z5) {
                }
            }
            if (constructor == null) {
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            }
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(null);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            a.a(newInstance);
            if (i5 < 0) {
                throw null;
            }
            throw null;
        } catch (KotlinReflectionNotSupportedError unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }
}
