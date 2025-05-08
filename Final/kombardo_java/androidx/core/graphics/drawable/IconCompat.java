package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        static int getResId(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getResId(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e5) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e5);
                return 0;
            } catch (NoSuchMethodException e6) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e6);
                return 0;
            } catch (InvocationTargetException e7) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e7);
                return 0;
            }
        }

        static String getResPackage(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getResPackage(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e5) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e7);
                return null;
            }
        }

        static int getType(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getType(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e5) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e5);
                return -1;
            } catch (NoSuchMethodException e6) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e6);
                return -1;
            } catch (InvocationTargetException e7) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e7);
                return -1;
            }
        }

        static Uri getUri(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getUri(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e5) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e7);
                return null;
            }
        }

        static Icon toIcon(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.mType) {
                case -1:
                    return (Icon) iconCompat.mObj1;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.getResPackage(), iconCompat.mInt1);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.mObj1, iconCompat.mInt1, iconCompat.mInt2);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.mObj1);
                    break;
                case 5:
                    createWithBitmap = Api26Impl.createWithAdaptiveBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= IconCompat.AMBIENT_SHADOW_ALPHA) {
                        createWithBitmap = Api30Impl.createWithAdaptiveBitmapContentUri(iconCompat.getUri());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.getUri());
                        }
                        InputStream uriInputStream = iconCompat.getUriInputStream(context);
                        if (uriInputStream == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.getUri());
                        }
                        createWithBitmap = Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream(uriInputStream));
                        break;
                    }
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.mTintMode;
            if (mode != IconCompat.DEFAULT_TINT_MODE) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        static Icon createWithAdaptiveBitmap(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        static int getResId(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String getResPackage(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int getType(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri getUri(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z5) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f5 = min;
        float f6 = 0.5f * f5;
        float f7 = ICON_DIAMETER_FACTOR * f6;
        if (z5) {
            float f8 = BLUR_FACTOR * f5;
            paint.setColor(0);
            paint.setShadowLayer(f8, 0.0f, f5 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.setShadowLayer(f8, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f6, f6, f7, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        ObjectsCompat.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithResource(Resources resources, String str, int i5) {
        ObjectsCompat.requireNonNull(str);
        if (i5 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.mInt1 = i5;
        if (resources != null) {
            try {
                iconCompat.mObj1 = resources.getResourceName(i5);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.mObj1 = str;
        }
        iconCompat.mString1 = str;
        return iconCompat;
    }

    private static String typeToString(int i5) {
        switch (i5) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap getBitmap() {
        int i5 = this.mType;
        if (i5 == -1) {
            Object obj = this.mObj1;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i5 == 1) {
            return (Bitmap) this.mObj1;
        }
        if (i5 == 5) {
            return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        int i5 = this.mType;
        if (i5 == -1) {
            return Api23Impl.getResId(this.mObj1);
        }
        if (i5 == 2) {
            return this.mInt1;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        int i5 = this.mType;
        if (i5 == -1) {
            return Api23Impl.getResPackage(this.mObj1);
        }
        if (i5 == 2) {
            String str = this.mString1;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.mObj1).split(":", -1)[0] : this.mString1;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int i5 = this.mType;
        return i5 == -1 ? Api23Impl.getType(this.mObj1) : i5;
    }

    public Uri getUri() {
        int i5 = this.mType;
        if (i5 == -1) {
            return Api23Impl.getUri(this.mObj1);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.mObj1);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream getUriInputStream(Context context) {
        Uri uri = getUri();
        String scheme = uri.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception e5) {
                Log.w(TAG, "Unable to load image from URI: " + uri, e5);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.mObj1));
        } catch (FileNotFoundException e6) {
            Log.w(TAG, "Unable to load image from path: " + uri, e6);
            return null;
        }
    }

    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                Parcelable parcelable = this.mParcelable;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.mObj1 = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.mParcelable;
                if (parcelable2 != null) {
                    this.mObj1 = parcelable2;
                    return;
                }
                byte[] bArr = this.mData;
                this.mObj1 = bArr;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.mData, Charset.forName("UTF-16"));
                this.mObj1 = str;
                if (this.mType == 2 && this.mString1 == null) {
                    this.mString1 = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.mObj1 = this.mData;
                return;
        }
    }

    public void onPreParceling(boolean z5) {
        this.mTintModeStr = this.mTintMode.name();
        switch (this.mType) {
            case -1:
                if (z5) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.mParcelable = (Parcelable) this.mObj1;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z5) {
                    this.mParcelable = (Parcelable) this.mObj1;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.mObj1;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.mData = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.mData = (byte[]) this.mObj1;
                return;
            case 4:
            case 6:
                this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    public String toString() {
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.mObj1).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.mString1);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(getResId())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb.append(" off=");
                    sb.append(this.mInt2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb.append(" tint=");
            sb.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb.append(" mode=");
            sb.append(this.mTintMode);
        }
        sb.append(")");
        return sb.toString();
    }

    public Icon toIcon(Context context) {
        return Api23Impl.toIcon(this, context);
    }

    IconCompat(int i5) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i5;
    }
}
