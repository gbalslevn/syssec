package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0007*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Ljava/io/File;", BuildConfig.FLAVOR, "deleteRecursively", "(Ljava/io/File;)Z", "relative", "resolve", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", BuildConfig.FLAVOR, "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "extension", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes2.dex */
public abstract class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        while (true) {
            boolean z5 = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z5) {
                        break;
                    }
                }
                z5 = false;
            }
            return z5;
        }
    }

    public static String getExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringAfterLast(name, '.', BuildConfig.FLAVOR);
    }

    public static final File resolve(File file, File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String file2 = file.toString();
        Intrinsics.checkNotNullExpressionValue(file2, "toString(...)");
        if (file2.length() != 0) {
            char c5 = File.separatorChar;
            if (!StringsKt.endsWith$default((CharSequence) file2, c5, false, 2, (Object) null)) {
                return new File(file2 + c5 + relative);
            }
        }
        return new File(file2 + relative);
    }

    public static File resolve(File file, String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolve(file, new File(relative));
    }
}
