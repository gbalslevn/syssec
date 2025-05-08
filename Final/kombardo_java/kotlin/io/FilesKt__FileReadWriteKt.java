package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\u000b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\r*\u00020\u0001H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ljava/io/File;", "Ljava/nio/charset/Charset;", "charset", BuildConfig.FLAVOR, "readText", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/lang/String;", "text", BuildConfig.FLAVOR, "appendText", "(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "Ljava/io/OutputStream;", "writeTextImpl", "(Ljava/io/OutputStream;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "Ljava/nio/charset/CharsetEncoder;", "kotlin.jvm.PlatformType", "newReplaceEncoder", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/CharsetEncoder;", BuildConfig.FLAVOR, "chunkSize", "encoder", "Ljava/nio/ByteBuffer;", "byteBufferForEncoding", "(ILjava/nio/charset/CharsetEncoder;)Ljava/nio/ByteBuffer;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes2.dex */
public abstract class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static final void appendText(File file, String text, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            writeTextImpl(fileOutputStream, text, charset);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void appendText$default(File file, String str, Charset charset, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        appendText(file, str, charset);
    }

    public static final ByteBuffer byteBufferForEncoding(int i5, CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        ByteBuffer allocate = ByteBuffer.allocate(i5 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(...)");
        return allocate;
    }

    public static final CharsetEncoder newReplaceEncoder(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    public static String readText(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String readText = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static final void writeTextImpl(OutputStream outputStream, String text, Charset charset) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder newReplaceEncoder = newReplaceEncoder(charset);
        CharBuffer allocate = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(newReplaceEncoder);
        ByteBuffer byteBufferForEncoding = byteBufferForEncoding(8192, newReplaceEncoder);
        int i5 = 0;
        int i6 = 0;
        while (i5 < text.length()) {
            int min = Math.min(8192 - i6, text.length() - i5);
            int i7 = i5 + min;
            char[] array = allocate.array();
            Intrinsics.checkNotNullExpressionValue(array, "array(...)");
            text.getChars(i5, i7, array, i6);
            allocate.limit(min + i6);
            i6 = 1;
            if (!newReplaceEncoder.encode(allocate, byteBufferForEncoding, i7 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(byteBufferForEncoding.array(), 0, byteBufferForEncoding.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i6 = 0;
            }
            allocate.clear();
            byteBufferForEncoding.clear();
            i5 = i7;
        }
    }
}
