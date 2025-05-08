package coil.content;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0015\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\" \u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\f\u001a\u00020\u0003*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00020\r*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0018\u0010\u0012\u001a\u00020\u0000*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroid/graphics/Bitmap$Config;", "toSoftware", "(Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap$Config;", BuildConfig.FLAVOR, "getBytesPerPixel", "(Landroid/graphics/Bitmap$Config;)I", "getBytesPerPixel$annotations", "(Landroid/graphics/Bitmap$Config;)V", "bytesPerPixel", "Landroid/graphics/Bitmap;", "getAllocationByteCountCompat", "(Landroid/graphics/Bitmap;)I", "allocationByteCountCompat", BuildConfig.FLAVOR, "isHardware", "(Landroid/graphics/Bitmap$Config;)Z", "getSafeConfig", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;", "safeConfig", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Bitmaps, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Bitmaps {
    public static final int getAllocationByteCountCompat(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                return getBytesPerPixel(bitmap.getConfig()) * bitmap.getWidth() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
    }

    public static final int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        return config == Bitmap.Config.RGBA_F16 ? 8 : 4;
    }

    public static final Bitmap.Config getSafeConfig(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static final boolean isHardware(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }

    public static final Bitmap.Config toSoftware(Bitmap.Config config) {
        return (config == null || isHardware(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
