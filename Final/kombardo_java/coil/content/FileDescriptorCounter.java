package coil.content;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/util/FileDescriptorCounter;", BuildConfig.FLAVOR, "()V", "FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES", BuildConfig.FLAVOR, "FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS", "FILE_DESCRIPTOR_LIMIT", "TAG", BuildConfig.FLAVOR, "decodesSinceLastFileDescriptorCheck", "fileDescriptorList", "Ljava/io/File;", "hasAvailableFileDescriptors", BuildConfig.FLAVOR, "lastFileDescriptorCheckTimestamp", BuildConfig.FLAVOR, "checkFileDescriptors", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FileDescriptorCounter {
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS = 30000;
    private static final int FILE_DESCRIPTOR_LIMIT = 800;
    private static final String TAG = "FileDescriptorCounter";
    public static final FileDescriptorCounter INSTANCE = new FileDescriptorCounter();
    private static final File fileDescriptorList = new File("/proc/self/fd");
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES = 30;
    private static int decodesSinceLastFileDescriptorCheck = FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES;
    private static long lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
    private static boolean hasAvailableFileDescriptors = true;

    private FileDescriptorCounter() {
    }

    private final boolean checkFileDescriptors() {
        int i5 = decodesSinceLastFileDescriptorCheck;
        decodesSinceLastFileDescriptorCheck = i5 + 1;
        return i5 >= FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES || SystemClock.uptimeMillis() > lastFileDescriptorCheckTimestamp + ((long) FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS);
    }

    public final synchronized boolean hasAvailableFileDescriptors(Logger logger) {
        try {
            if (checkFileDescriptors()) {
                decodesSinceLastFileDescriptorCheck = 0;
                lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
                String[] list = fileDescriptorList.list();
                if (list == null) {
                    list = new String[0];
                }
                int length = list.length;
                boolean z5 = length < FILE_DESCRIPTOR_LIMIT;
                hasAvailableFileDescriptors = z5;
                if (!z5 && logger != null && logger.getLevel() <= 5) {
                    logger.log(TAG, 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return hasAvailableFileDescriptors;
    }
}
