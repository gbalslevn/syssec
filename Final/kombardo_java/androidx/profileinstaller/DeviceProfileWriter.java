package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.appcompat.R$styleable;
import androidx.profileinstaller.DeviceProfileWriter;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;
    private boolean mDeviceSupportsAotProfile = false;
    private final byte[] mDesiredVersion = desiredVersion();

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream openStreamFromAssets;
        try {
            openStreamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
        } catch (FileNotFoundException e5) {
            this.mDiagnostics.onResultReceived(9, e5);
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
        } catch (IllegalStateException e7) {
            this.mProfile = null;
            this.mDiagnostics.onResultReceived(8, e7);
        }
        if (openStreamFromAssets == null) {
            if (openStreamFromAssets != null) {
                openStreamFromAssets.close();
            }
            return null;
        }
        try {
            this.mProfile = ProfileTranscoder.readMeta(openStreamFromAssets, ProfileTranscoder.readHeader(openStreamFromAssets, ProfileTranscoder.MAGIC_PROFM), bArr, dexProfileDataArr);
            openStreamFromAssets.close();
            return this;
        } catch (Throwable th) {
            try {
                openStreamFromAssets.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] desiredVersion() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 31) {
            return ProfileVersion.V015_S;
        }
        switch (i5) {
            case 26:
                return ProfileVersion.V005_O;
            case 27:
                return ProfileVersion.V009_O_MR1;
            case 28:
            case R$styleable.Toolbar_titleTextColor /* 29 */:
            case 30:
                return ProfileVersion.V010_P;
            default:
                return null;
        }
    }

    private InputStream getProfileInputStream(AssetManager assetManager) {
        try {
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        } catch (FileNotFoundException e5) {
            this.mDiagnostics.onResultReceived(6, e5);
            return null;
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$result$0(int i5, Object obj) {
        this.mDiagnostics.onResultReceived(i5, obj);
    }

    private InputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived(5, null);
            }
            return null;
        }
    }

    private DexProfileData[] readProfileInternal(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        DexProfileData[] readProfile = ProfileTranscoder.readProfile(inputStream, ProfileTranscoder.readHeader(inputStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
                        try {
                            inputStream.close();
                            return readProfile;
                        } catch (IOException e5) {
                            this.mDiagnostics.onResultReceived(7, e5);
                            return readProfile;
                        }
                    } catch (IOException e6) {
                        this.mDiagnostics.onResultReceived(7, e6);
                        return null;
                    }
                } catch (IllegalStateException e7) {
                    this.mDiagnostics.onResultReceived(8, e7);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e8) {
                this.mDiagnostics.onResultReceived(7, e8);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                this.mDiagnostics.onResultReceived(7, e9);
            }
            throw th;
        }
    }

    private static boolean requiresMetadata() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private void result(final int i5, final Object obj) {
        this.mExecutor.execute(new Runnable() { // from class: L.a
            @Override // java.lang.Runnable
            public final void run() {
                DeviceProfileWriter.this.lambda$result$0(i5, obj);
            }
        });
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.mCurProfile.exists()) {
            try {
                if (!this.mCurProfile.createNewFile()) {
                    result(4, null);
                    return false;
                }
            } catch (IOException unused) {
                result(4, null);
                return false;
            }
        } else if (!this.mCurProfile.canWrite()) {
            result(4, null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    public DeviceProfileWriter read() {
        DeviceProfileWriter addMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
        if (profileInputStream != null) {
            this.mProfile = readProfileInternal(profileInputStream);
        }
        DexProfileData[] dexProfileDataArr = this.mProfile;
        return (dexProfileDataArr == null || !requiresMetadata() || (addMetadata = addMetadata(dexProfileDataArr, this.mDesiredVersion)) == null) ? this : addMetadata;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (dexProfileDataArr != null && bArr != null) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ProfileTranscoder.writeHeader(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e5) {
                this.mDiagnostics.onResultReceived(7, e5);
            } catch (IllegalStateException e6) {
                this.mDiagnostics.onResultReceived(8, e6);
            }
            if (!ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                this.mDiagnostics.onResultReceived(5, null);
                this.mProfile = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.mProfile = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean write() {
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock tryLock = channel.tryLock();
                            try {
                                Encoding.writeAll(byteArrayInputStream, fileOutputStream, tryLock);
                                result(1, null);
                                if (tryLock != null) {
                                    tryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (FileNotFoundException e5) {
                result(6, e5);
                return false;
            } catch (IOException e6) {
                result(7, e6);
                return false;
            }
        } finally {
            this.mTranscodedProfile = null;
            this.mProfile = null;
        }
    }
}
