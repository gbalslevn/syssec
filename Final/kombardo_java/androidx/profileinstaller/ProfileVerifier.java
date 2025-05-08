package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final String TAG = "ProfileVerifier";
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();
    private static final Object SYNC_OBJ = new Object();
    private static CompilationStatus sCompilationStatus = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: classes.dex */
    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int i5, int i6, long j5, long j6) {
            this.mSchema = i5;
            this.mResultCode = i6;
            this.mPackageLastUpdateTime = j5;
            this.mInstalledCurrentProfileSize = j6;
        }

        static Cache readFromFile(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) obj;
            return this.mResultCode == cache.mResultCode && this.mPackageLastUpdateTime == cache.mPackageLastUpdateTime && this.mSchema == cache.mSchema && this.mInstalledCurrentProfileSize == cache.mInstalledCurrentProfileSize;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        void writeOnFile(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CompilationStatus {
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        CompilationStatus(int i5, boolean z5, boolean z6, boolean z7) {
            this.mResultCode = i5;
            this.mHasCurrentProfile = z6;
            this.mHasReferenceProfile = z5;
            this.mHasEmbeddedProfile = z7;
        }
    }

    private static long getPackageLastUpdateTime(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int i5, boolean z5, boolean z6, boolean z7) {
        CompilationStatus compilationStatus = new CompilationStatus(i5, z5, z6, z7);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:89)(1:27)|28|(1:88)(1:32)|33|34|35|(2:74|75)(1:37)|38|(8:45|(1:49)|(1:56)|57|(2:64|65)|61|62|63)|(1:71)(1:(1:73))|(1:49)|(3:51|54|56)|57|(1:59)|64|65|61|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
    
        r5 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cb, code lost:
    
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CompilationStatus writeProfileVerification(Context context, boolean z5) {
        boolean z6;
        Cache readFromFile;
        Cache cache;
        int i5;
        CompilationStatus compilationStatus;
        if (!z5 && (compilationStatus = sCompilationStatus) != null) {
            return compilationStatus;
        }
        synchronized (SYNC_OBJ) {
            if (!z5) {
                CompilationStatus compilationStatus2 = sCompilationStatus;
                if (compilationStatus2 != null) {
                    return compilationStatus2;
                }
            }
            int i6 = 0;
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd("dexopt/baseline.prof");
                try {
                    z6 = openFd.getLength() > 0;
                    openFd.close();
                } finally {
                }
            } catch (IOException unused) {
                z6 = false;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28 && i7 != 30) {
                File file = new File(new File(REF_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                long length = file.length();
                boolean z7 = file.exists() && length > 0;
                File file2 = new File(new File(CUR_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                long length2 = file2.length();
                boolean z8 = file2.exists() && length2 > 0;
                try {
                    long packageLastUpdateTime = getPackageLastUpdateTime(context);
                    File file3 = new File(context.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);
                    if (file3.exists()) {
                        try {
                            readFromFile = Cache.readFromFile(file3);
                        } catch (IOException unused2) {
                            return setCompilationStatus(131072, z7, z8, z6);
                        }
                    } else {
                        readFromFile = null;
                    }
                    if (readFromFile != null && readFromFile.mPackageLastUpdateTime == packageLastUpdateTime && (i5 = readFromFile.mResultCode) != 2) {
                        i6 = i5;
                        if (z5 && z8 && i6 != 1) {
                            i6 = 2;
                        }
                        if (readFromFile != null && readFromFile.mResultCode == 2 && i6 == 1 && length < readFromFile.mInstalledCurrentProfileSize) {
                            i6 = 3;
                        }
                        cache = new Cache(1, i6, packageLastUpdateTime, length2);
                        if (readFromFile != null || !readFromFile.equals(cache)) {
                            cache.writeOnFile(file3);
                        }
                        return setCompilationStatus(i6, z7, z8, z6);
                    }
                    if (z7) {
                        i6 = 1;
                    } else if (z8) {
                        i6 = 2;
                    }
                    if (z5) {
                        i6 = 2;
                    }
                    if (readFromFile != null) {
                        i6 = 3;
                    }
                    cache = new Cache(1, i6, packageLastUpdateTime, length2);
                    if (readFromFile != null) {
                    }
                    cache.writeOnFile(file3);
                    return setCompilationStatus(i6, z7, z8, z6);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return setCompilationStatus(65536, z7, z8, z6);
                }
            }
            return setCompilationStatus(262144, false, false, z6);
        }
    }
}
