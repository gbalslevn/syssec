package dk.molslinjen.core.version;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/core/version/AppVersionProvider;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "versionName", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "getVersionName", "()Ljava/lang/String;", "Ljava/lang/String;", "versionCode", BuildConfig.FLAVOR, "getVersionCode", "()I", "androidVersion", "getAndroidVersion", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppVersionProvider {
    private final String androidVersion;
    private final int versionCode;
    private final String versionName;

    public AppVersionProvider(Context context) {
        int i5;
        long longVersionCode;
        Intrinsics.checkNotNullParameter(context, "context");
        this.versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        if (Build.VERSION.SDK_INT >= 28) {
            longVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
            i5 = (int) longVersionCode;
        } else {
            i5 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        this.versionCode = i5;
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        this.androidVersion = RELEASE;
    }

    public final String getAndroidVersion() {
        return this.androidVersion;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }
}
