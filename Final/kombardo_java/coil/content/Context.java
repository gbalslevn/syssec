package coil.content;

import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\b\b\u0001\u0010\u0002\u001a\u00020\u00012\f\u0010\b\u001a\b\u0018\u00010\u0007R\u00020\u0006H\u0000¢\u0006\u0004\b\u0004\u0010\t\u001a%\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000e\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroid/content/Context;", BuildConfig.FLAVOR, "resId", "Landroid/graphics/drawable/Drawable;", "getDrawableCompat", "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", "Landroid/content/res/Resources$Theme;", "theme", "(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;", "resources", "getXmlDrawableCompat", "(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "(Landroid/content/Context;)Landroidx/lifecycle/Lifecycle;", BuildConfig.FLAVOR, "permission", BuildConfig.FLAVOR, "isPermissionGranted", "(Landroid/content/Context;Ljava/lang/String;)Z", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Contexts, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public abstract class Context {
    public static final Drawable getDrawableCompat(android.content.Context context, int i5) {
        Drawable drawable = AppCompatResources.getDrawable(context, i5);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i5).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Lifecycle getLifecycle(android.content.Context context) {
        Object obj;
        while (!(obj instanceof LifecycleOwner)) {
            if (!(obj instanceof ContextWrapper)) {
                return null;
            }
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return ((LifecycleOwner) obj).getLifecycle();
    }

    public static final Drawable getXmlDrawableCompat(android.content.Context context, Resources resources, int i5) {
        XmlResourceParser xml = resources.getXml(i5);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            return getDrawableCompat(resources, i5, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }

    public static final boolean isPermissionGranted(android.content.Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static final Drawable getDrawableCompat(Resources resources, int i5, Resources.Theme theme) {
        Drawable drawable = ResourcesCompat.getDrawable(resources, i5, theme);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i5).toString());
    }
}
