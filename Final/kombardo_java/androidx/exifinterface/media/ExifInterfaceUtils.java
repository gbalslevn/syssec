package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
abstract class ExifInterfaceUtils {
    private static final String TAG = "ExifInterfaceUtils";

    /* loaded from: classes.dex */
    static class Api21Impl {
        static void close(FileDescriptor fileDescriptor) {
            Os.close(fileDescriptor);
        }

        static FileDescriptor dup(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static long lseek(FileDescriptor fileDescriptor, long j5, int i5) {
            return Os.lseek(fileDescriptor, j5, i5);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b5 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b5)));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] convertToLongArray(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            jArr[i5] = iArr[i5];
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }
}
