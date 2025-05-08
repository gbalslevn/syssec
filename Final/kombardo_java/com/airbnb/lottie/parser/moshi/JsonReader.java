package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    boolean failOnUnknown;
    boolean lenient;
    int stackSize;
    int[] scopes = new int[32];
    String[] pathNames = new String[32];
    int[] pathIndices = new int[32];

    /* loaded from: classes.dex */
    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    JsonReader.string(buffer, strArr[i5]);
                    buffer.readByte();
                    byteStringArr[i5] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e5) {
                throw new AssertionError(e5);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i5 = 0; i5 <= 31; i5++) {
            REPLACEMENT_CHARS[i5] = String.format("\\u%04x", Integer.valueOf(i5));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void string(BufferedSink bufferedSink, String str) {
        int i5;
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = str.charAt(i5);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i5 = str2 == null ? i5 + 1 : 0;
                if (i6 < i5) {
                    bufferedSink.writeUtf8(str, i6, i5);
                }
                bufferedSink.writeUtf8(str2);
                i6 = i5 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i6 < i5) {
                }
                bufferedSink.writeUtf8(str2);
                i6 = i5 + 1;
            }
        }
        if (i6 < length) {
            bufferedSink.writeUtf8(str, i6, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void beginArray();

    public abstract void beginObject();

    public abstract void endArray();

    public abstract void endObject();

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext();

    public abstract boolean nextBoolean();

    public abstract double nextDouble();

    public abstract int nextInt();

    public abstract String nextName();

    public abstract String nextString();

    public abstract Token peek();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushScope(int i5) {
        int i6 = this.stackSize;
        int[] iArr = this.scopes;
        if (i6 == iArr.length) {
            if (i6 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.scopes;
        int i7 = this.stackSize;
        this.stackSize = i7 + 1;
        iArr3[i7] = i5;
    }

    public abstract int selectName(Options options);

    public abstract void skipName();

    public abstract void skipValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException syntaxError(String str) {
        throw new JsonEncodingException(str + " at path " + getPath());
    }
}
