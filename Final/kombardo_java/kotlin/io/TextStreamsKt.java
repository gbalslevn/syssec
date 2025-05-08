package kotlin.io;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljava/io/Reader;", BuildConfig.FLAVOR, "readText", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/io/Writer;", "out", BuildConfig.FLAVOR, "bufferSize", BuildConfig.FLAVOR, "copyTo", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TextStreamsKt {
    public static final long copyTo(Reader reader, Writer out, int i5) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i5];
        int read = reader.read(cArr);
        long j5 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j5 += read;
            read = reader.read(cArr);
        }
        return j5;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return copyTo(reader, writer, i5);
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
