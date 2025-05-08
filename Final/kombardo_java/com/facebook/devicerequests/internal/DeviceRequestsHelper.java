package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR4\u0010\u001e\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u001c0\u001bj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u001c`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/facebook/devicerequests/internal/DeviceRequestsHelper;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "deviceInfo", "getDeviceInfo", "(Ljava/util/Map;)Ljava/lang/String;", "userCode", BuildConfig.FLAVOR, "startAdvertisementService", "(Ljava/lang/String;)Z", "isAvailable", "()Z", "url", "Landroid/graphics/Bitmap;", "generateQRCode", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", BuildConfig.FLAVOR, "cleanUpAdvertisementService", "(Ljava/lang/String;)V", "startAdvertisementServiceImpl", "cleanUpAdvertisementServiceImpl", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Landroid/net/nsd/NsdManager$RegistrationListener;", "Lkotlin/collections/HashMap;", "deviceRequestsListeners", "Ljava/util/HashMap;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceRequestsHelper {
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    private static final HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    private DeviceRequestsHelper() {
    }

    public static final void cleanUpAdvertisementService(String userCode) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return;
        }
        try {
            INSTANCE.cleanUpAdvertisementServiceImpl(userCode);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
        }
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String userCode) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(userCode);
            if (registrationListener != null) {
                Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
                }
                try {
                    ((NsdManager) systemService).unregisterService(registrationListener);
                } catch (IllegalArgumentException e5) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, e5);
                }
                deviceRequestsListeners.remove(userCode);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final Bitmap generateQRCode(String url) {
        int height;
        int width;
        int[] iArr;
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 2);
            try {
                BitMatrix encode = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                height = encode.getHeight();
                width = encode.getWidth();
                iArr = new int[height * width];
                if (height > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        int i7 = i5 * width;
                        if (width > 0) {
                            int i8 = 0;
                            while (true) {
                                int i9 = i8 + 1;
                                iArr[i7 + i8] = encode.get(i8, i5) ? -16777216 : -1;
                                if (i9 >= width) {
                                    break;
                                }
                                i8 = i9;
                            }
                        }
                        if (i6 >= height) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (WriterException unused) {
            }
            try {
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return createBitmap;
            } catch (WriterException unused2) {
                bitmap = createBitmap;
                return bitmap;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return null;
        }
    }

    public static final String getDeviceInfo(Map<String, String> deviceInfo) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return null;
        }
        if (deviceInfo == null) {
            try {
                deviceInfo = new HashMap<>();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
                return null;
            }
        }
        String DEVICE = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
        deviceInfo.put("device", DEVICE);
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        deviceInfo.put("model", MODEL);
        String jSONObject = new JSONObject(deviceInfo).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return jSONObject;
    }

    public static final boolean isAvailable() {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery != null) {
                return appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return false;
        }
    }

    public static final boolean startAdvertisementService(String userCode) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return false;
        }
        try {
            if (isAvailable()) {
                return INSTANCE.startAdvertisementServiceImpl(userCode);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceRequestsHelper.class);
            return false;
        }
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(final String userCode) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            HashMap<String, NsdManager.RegistrationListener> hashMap = deviceRequestsListeners;
            if (hashMap.containsKey(userCode)) {
                return true;
            }
            final String str = "fbsdk_" + Intrinsics.stringPlus("android-", StringsKt.replace$default(FacebookSdk.getSdkVersion(), '.', '|', false, 4, (Object) null)) + '_' + ((Object) userCode);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType("_fb._tcp.");
            nsdServiceInfo.setServiceName(str);
            nsdServiceInfo.setPort(80);
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
            }
            NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.devicerequests.internal.DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1
                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(userCode);
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
                    Intrinsics.checkNotNullParameter(NsdServiceInfo, "NsdServiceInfo");
                    if (Intrinsics.areEqual(str, NsdServiceInfo.getServiceName())) {
                        return;
                    }
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(userCode);
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceUnregistered(NsdServiceInfo serviceInfo) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                }
            };
            hashMap.put(userCode, registrationListener);
            ((NsdManager) systemService).registerService(nsdServiceInfo, 1, registrationListener);
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
