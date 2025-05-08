package dk.molslinjen.core.location;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/core/location/GoogleMapsNavigationHandler;", BuildConfig.FLAVOR, "<init>", "()V", "startNavigation", BuildConfig.FLAVOR, "destination", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "isDriving", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GoogleMapsNavigationHandler {
    public static final GoogleMapsNavigationHandler INSTANCE = new GoogleMapsNavigationHandler();

    private GoogleMapsNavigationHandler() {
    }

    public final void startNavigation(String destination, Context context, boolean isDriving) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(Constants.SCHEME).authority("www.google.com").appendPath("maps").appendPath("dir").appendPath(BuildConfig.FLAVOR).appendQueryParameter("api", "1").appendQueryParameter("destination", destination).appendQueryParameter("travelmode", isDriving ? "driving" : "walking").build());
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        context.startActivity(intent);
    }
}
