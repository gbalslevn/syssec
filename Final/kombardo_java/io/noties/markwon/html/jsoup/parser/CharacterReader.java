package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.UncheckedIOException;
import io.noties.markwon.html.jsoup.helper.Validate;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public final class CharacterReader {
    private static final int maxStringCacheLen = 12;
    private static final int readAheadLimit = 3072;
    private int bufLength;
    private int bufMark;
    private int bufPos;
    private int bufSplitPoint;
    private final char[] charBuf;
    private final Reader reader;
    private int readerPos;
    private final String[] stringCache;

    public CharacterReader(Reader reader, int i5) {
        this.stringCache = new String[128];
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.reader = reader;
        this.charBuf = new char[4096];
        bufferUp();
    }

    private void bufferUp() {
        int i5 = this.bufPos;
        if (i5 < this.bufSplitPoint) {
            return;
        }
        try {
            this.reader.skip(i5);
            this.reader.mark(4096);
            int read = this.reader.read(this.charBuf);
            this.reader.reset();
            if (read != -1) {
                this.bufLength = read;
                this.readerPos += this.bufPos;
                this.bufPos = 0;
                this.bufMark = 0;
                if (read > readAheadLimit) {
                    read = readAheadLimit;
                }
                this.bufSplitPoint = read;
            }
        } catch (IOException e5) {
            throw new UncheckedIOException(e5);
        }
    }

    private static String cacheString(char[] cArr, String[] strArr, int i5, int i6) {
        if (i6 > 12) {
            return new String(cArr, i5, i6);
        }
        if (i6 < 1) {
            return BuildConfig.FLAVOR;
        }
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i7 < i6) {
            i9 = (i9 * 31) + cArr[i8];
            i7++;
            i8++;
        }
        int length = i9 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i5, i6);
            strArr[length] = str2;
            return str2;
        }
        if (rangeEquals(cArr, i5, i6, str)) {
            return str;
        }
        String str3 = new String(cArr, i5, i6);
        strArr[length] = str3;
        return str3;
    }

    private boolean isEmptyNoBufferUp() {
        return this.bufPos >= this.bufLength;
    }

    static boolean rangeEquals(char[] cArr, int i5, int i6, String str) {
        if (i6 != str.length()) {
            return false;
        }
        int i7 = 0;
        while (true) {
            int i8 = i6 - 1;
            if (i6 == 0) {
                return true;
            }
            int i9 = i5 + 1;
            int i10 = i7 + 1;
            if (cArr[i5] != str.charAt(i7)) {
                return false;
            }
            i5 = i9;
            i6 = i8;
            i7 = i10;
        }
    }

    public void advance() {
        this.bufPos++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char consume() {
        bufferUp();
        char c5 = isEmptyNoBufferUp() ? (char) 65535 : this.charBuf[this.bufPos];
        this.bufPos++;
        return c5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return cacheString(r6.charBuf, r6.stringCache, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String consumeData() {
        char c5;
        bufferUp();
        int i5 = this.bufPos;
        int i6 = this.bufLength;
        char[] cArr = this.charBuf;
        while (true) {
            int i7 = this.bufPos;
            if (i7 >= i6 || (c5 = cArr[i7]) == '&' || c5 == '<' || c5 == 0) {
                break;
            }
            this.bufPos = i7 + 1;
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeDigitSequence() {
        int i5;
        char c5;
        bufferUp();
        int i6 = this.bufPos;
        while (true) {
            i5 = this.bufPos;
            if (i5 >= this.bufLength || (c5 = this.charBuf[i5]) < '0' || c5 > '9') {
                break;
            }
            this.bufPos = i5 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i6, i5 - i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeHexSequence() {
        int i5;
        char c5;
        bufferUp();
        int i6 = this.bufPos;
        while (true) {
            i5 = this.bufPos;
            if (i5 >= this.bufLength || (((c5 = this.charBuf[i5]) < '0' || c5 > '9') && ((c5 < 'A' || c5 > 'F') && (c5 < 'a' || c5 > 'f')))) {
                break;
            }
            this.bufPos = i5 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i6, i5 - i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeLetterSequence() {
        char c5;
        bufferUp();
        int i5 = this.bufPos;
        while (true) {
            int i6 = this.bufPos;
            if (i6 >= this.bufLength || (((c5 = this.charBuf[i6]) < 'A' || c5 > 'Z') && ((c5 < 'a' || c5 > 'z') && !Character.isLetter(c5)))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i5, this.bufPos - i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeLetterThenDigitSequence() {
        char c5;
        bufferUp();
        int i5 = this.bufPos;
        while (true) {
            int i6 = this.bufPos;
            if (i6 >= this.bufLength || (((c5 = this.charBuf[i6]) < 'A' || c5 > 'Z') && ((c5 < 'a' || c5 > 'z') && !Character.isLetter(c5)))) {
                break;
            }
            this.bufPos++;
        }
        while (!isEmptyNoBufferUp()) {
            char[] cArr = this.charBuf;
            int i7 = this.bufPos;
            char c6 = cArr[i7];
            if (c6 < '0' || c6 > '9') {
                break;
            }
            this.bufPos = i7 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i5, this.bufPos - i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return cacheString(r6.charBuf, r6.stringCache, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String consumeTagName() {
        char c5;
        bufferUp();
        int i5 = this.bufPos;
        int i6 = this.bufLength;
        char[] cArr = this.charBuf;
        while (true) {
            int i7 = this.bufPos;
            if (i7 >= i6 || (c5 = cArr[i7]) == '\t' || c5 == '\n' || c5 == '\r' || c5 == '\f' || c5 == ' ' || c5 == '/' || c5 == '>' || c5 == 0) {
                break;
            }
            this.bufPos = i7 + 1;
        }
        return BuildConfig.FLAVOR;
    }

    public String consumeTo(char c5) {
        int nextIndexOf = nextIndexOf(c5);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    public String consumeToAny(char... cArr) {
        bufferUp();
        int i5 = this.bufPos;
        int i6 = this.bufLength;
        char[] cArr2 = this.charBuf;
        loop0: while (this.bufPos < i6) {
            for (char c5 : cArr) {
                if (cArr2[this.bufPos] == c5) {
                    break loop0;
                }
            }
            this.bufPos++;
        }
        int i7 = this.bufPos;
        return i7 > i5 ? cacheString(this.charBuf, this.stringCache, i5, i7 - i5) : BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeToAnySorted(char... cArr) {
        bufferUp();
        int i5 = this.bufPos;
        int i6 = this.bufLength;
        char[] cArr2 = this.charBuf;
        while (true) {
            int i7 = this.bufPos;
            if (i7 >= i6 || Arrays.binarySearch(cArr, cArr2[i7]) >= 0) {
                break;
            }
            this.bufPos++;
        }
        int i8 = this.bufPos;
        return i8 > i5 ? cacheString(this.charBuf, this.stringCache, i5, i8 - i5) : BuildConfig.FLAVOR;
    }

    String consumeToEnd() {
        bufferUp();
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i5 = this.bufPos;
        String cacheString = cacheString(cArr, strArr, i5, this.bufLength - i5);
        this.bufPos = this.bufLength;
        return cacheString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean containsIgnoreCase(String str) {
        Locale locale = Locale.ENGLISH;
        return nextIndexOf(str.toLowerCase(locale)) > -1 || nextIndexOf(str.toUpperCase(locale)) > -1;
    }

    public char current() {
        bufferUp();
        if (isEmptyNoBufferUp()) {
            return (char) 65535;
        }
        return this.charBuf[this.bufPos];
    }

    public boolean isEmpty() {
        bufferUp();
        return this.bufPos >= this.bufLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mark() {
        this.bufMark = this.bufPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchConsume(String str) {
        bufferUp();
        if (!matches(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchConsumeIgnoreCase(String str) {
        if (!matchesIgnoreCase(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matches(char c5) {
        return !isEmpty() && this.charBuf[this.bufPos] == c5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        bufferUp();
        char c5 = this.charBuf[this.bufPos];
        for (char c6 : cArr) {
            if (c6 == c5) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesAnySorted(char[] cArr) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(cArr, this.charBuf[this.bufPos]) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesDigit() {
        char c5;
        return !isEmpty() && (c5 = this.charBuf[this.bufPos]) >= '0' && c5 <= '9';
    }

    boolean matchesIgnoreCase(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (Character.toUpperCase(str.charAt(i5)) != Character.toUpperCase(this.charBuf[this.bufPos + i5])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c5 = this.charBuf[this.bufPos];
        return (c5 >= 'A' && c5 <= 'Z') || (c5 >= 'a' && c5 <= 'z') || Character.isLetter(c5);
    }

    int nextIndexOf(char c5) {
        bufferUp();
        for (int i5 = this.bufPos; i5 < this.bufLength; i5++) {
            if (c5 == this.charBuf[i5]) {
                return i5 - this.bufPos;
            }
        }
        return -1;
    }

    public int pos() {
        return this.readerPos + this.bufPos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rewindToMark() {
        this.bufPos = this.bufMark;
    }

    public String toString() {
        char[] cArr = this.charBuf;
        int i5 = this.bufPos;
        return new String(cArr, i5, this.bufLength - i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unconsume() {
        this.bufPos--;
    }

    boolean matches(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (str.charAt(i5) != this.charBuf[this.bufPos + i5]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String consumeTo(String str) {
        int nextIndexOf = nextIndexOf(str);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r2 = r1 + 1;
        r4 = (r9.length() + r2) - 1;
        r5 = r8.bufLength;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 >= r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r4 > r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r5 >= r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r9.charAt(r3) != r8.charBuf[r5]) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r5 = r5 + 1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 != r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return r1 - r8.bufPos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        if (r0 != r8.charBuf[r1]) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 >= r8.bufLength) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 == r8.charBuf[r1]) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int nextIndexOf(CharSequence charSequence) {
        bufferUp();
        char charAt = charSequence.charAt(0);
        int i5 = this.bufPos;
        while (i5 < this.bufLength) {
            int i6 = 1;
        }
        return -1;
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }
}
