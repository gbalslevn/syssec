package com.facebook.appevents.ml;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ml/Utils;", BuildConfig.FLAVOR, "()V", "DIR_NAME", BuildConfig.FLAVOR, "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", BuildConfig.FLAVOR, "Lcom/facebook/appevents/ml/MTensor;", "file", "vectorize", BuildConfig.FLAVOR, "texts", "maxLen", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Utils {
    private static final String DIR_NAME = "facebook_ml/";
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public static final File getMlDir() {
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utils.class);
            return null;
        }
    }

    public static final Map<String, MTensor> parseModelWeights(File file) {
        Map<String, MTensor> map;
        Map<String, MTensor> map2 = null;
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(file, "file");
        } catch (Throwable th) {
            th = th;
            map = null;
        }
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int available = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[available];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (available < 4) {
                    return null;
                }
                int i5 = 0;
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i6 = wrap.getInt();
                int i7 = i6 + 4;
                if (available < i7) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i6, Charsets.UTF_8));
                JSONArray names = jSONObject.names();
                int length = names.length();
                String[] strArr = new String[length];
                int i8 = length - 1;
                if (i8 >= 0) {
                    int i9 = 0;
                    while (true) {
                        int i10 = i9 + 1;
                        strArr[i9] = names.getString(i9);
                        if (i10 > i8) {
                            break;
                        }
                        i9 = i10;
                    }
                }
                ArraysKt.sort(strArr);
                HashMap hashMap = new HashMap();
                int i11 = 0;
                while (i11 < length) {
                    String str = strArr[i11];
                    i11++;
                    if (str != null) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        int length2 = jSONArray.length();
                        int[] iArr = new int[length2];
                        int i12 = length2 - 1;
                        int i13 = 1;
                        if (i12 >= 0) {
                            while (true) {
                                int i14 = i5 + 1;
                                try {
                                    int i15 = jSONArray.getInt(i5);
                                    iArr[i5] = i15;
                                    i13 *= i15;
                                    if (i14 > i12) {
                                        break;
                                    }
                                    i5 = i14;
                                } catch (Exception unused) {
                                    return null;
                                }
                            }
                        }
                        int i16 = i13 * 4;
                        int i17 = i7 + i16;
                        if (i17 > available) {
                            return null;
                        }
                        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i7, i16);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        MTensor mTensor = new MTensor(iArr);
                        wrap2.asFloatBuffer().get(mTensor.getData(), 0, i13);
                        hashMap.put(str, mTensor);
                        i7 = i17;
                        i5 = 0;
                        map2 = null;
                    }
                }
                return hashMap;
            } catch (Exception unused2) {
                return map2;
            }
        } catch (Throwable th2) {
            th = th2;
            map = null;
            CrashShieldHandler.handleThrowable(th, Utils.class);
            return map;
        }
    }

    public final String normalizeString(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "str");
            int length = str.length() - 1;
            int i5 = 0;
            boolean z5 = false;
            while (i5 <= length) {
                boolean z6 = Intrinsics.compare((int) str.charAt(!z5 ? i5 : length), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length--;
                } else if (z6) {
                    i5++;
                } else {
                    z5 = true;
                }
            }
            Object[] array = new Regex("\\s+").split(str.subSequence(i5, length + 1).toString(), 0).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String join = TextUtils.join(" ", (String[]) array);
            Intrinsics.checkNotNullExpressionValue(join, "join(\" \", strArray)");
            return join;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int[] vectorize(String texts, int maxLen) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(texts, "texts");
            int[] iArr = new int[maxLen];
            String normalizeString = normalizeString(texts);
            Charset forName = Charset.forName(Constants.ENCODING);
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
            if (normalizeString == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = normalizeString.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            if (maxLen > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < bytes.length) {
                        iArr[i5] = bytes[i5] & 255;
                    } else {
                        iArr[i5] = 0;
                    }
                    if (i6 >= maxLen) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return iArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
