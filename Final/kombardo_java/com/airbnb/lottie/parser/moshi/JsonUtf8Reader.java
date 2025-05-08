package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Buffer buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final BufferedSource source;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    private static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
    private static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBufferField();
        pushScope(6);
    }

    private void checkLenient() {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() {
        int[] iArr = this.scopes;
        int i5 = this.stackSize;
        int i6 = iArr[i5 - 1];
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
        } else if (i6 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i6 == 3 || i6 == 5) {
                iArr[i5 - 1] = 4;
                if (i6 == 5) {
                    int nextNonWhitespace2 = nextNonWhitespace(true);
                    this.buffer.readByte();
                    if (nextNonWhitespace2 != 44) {
                        if (nextNonWhitespace2 != 59) {
                            if (nextNonWhitespace2 != 125) {
                                throw syntaxError("Unterminated object");
                            }
                            this.peeked = 2;
                            return 2;
                        }
                        checkLenient();
                    }
                }
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 == 34) {
                    this.buffer.readByte();
                    this.peeked = 13;
                    return 13;
                }
                if (nextNonWhitespace3 == 39) {
                    this.buffer.readByte();
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (nextNonWhitespace3 != 125) {
                    checkLenient();
                    if (!isLiteral((char) nextNonWhitespace3)) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 14;
                    return 14;
                }
                if (i6 == 5) {
                    throw syntaxError("Expected name");
                }
                this.buffer.readByte();
                this.peeked = 2;
                return 2;
            }
            if (i6 == 4) {
                iArr[i5 - 1] = 5;
                int nextNonWhitespace4 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace4 != 58) {
                    if (nextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.source.request(1L) && this.buffer.getByte(0L) == 62) {
                        this.buffer.readByte();
                    }
                }
            } else if (i6 == 6) {
                iArr[i5 - 1] = 7;
            } else if (i6 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 18;
                    return 18;
                }
                checkLenient();
            } else if (i6 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        }
        if (nextNonWhitespace5 == 39) {
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        }
        if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
            if (nextNonWhitespace5 == 91) {
                this.buffer.readByte();
                this.peeked = 3;
                return 3;
            }
            if (nextNonWhitespace5 != 93) {
                if (nextNonWhitespace5 == 123) {
                    this.buffer.readByte();
                    this.peeked = 1;
                    return 1;
                }
                int peekKeyword = peekKeyword();
                if (peekKeyword != 0) {
                    return peekKeyword;
                }
                int peekNumber = peekNumber();
                if (peekNumber != 0) {
                    return peekNumber;
                }
                if (!isLiteral(this.buffer.getByte(0L))) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.peeked = 10;
                return 10;
            }
            if (i6 == 1) {
                this.buffer.readByte();
                this.peeked = 4;
                return 4;
            }
        }
        if (i6 != 1 && i6 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.peeked = 7;
        return 7;
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (str.equals(options.strings[i5])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i5;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i5) {
        if (i5 == 9 || i5 == 10 || i5 == 12 || i5 == 13 || i5 == 32) {
            return false;
        }
        if (i5 != 35) {
            if (i5 == 44) {
                return false;
            }
            if (i5 != 47 && i5 != 61) {
                if (i5 == 123 || i5 == 125 || i5 == 58) {
                    return false;
                }
                if (i5 != 59) {
                    switch (i5) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.buffer.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.source.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        checkLenient();
        r3 = r6.buffer.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (skipToEndOfBlockComment() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int nextNonWhitespace(boolean z5) {
        while (true) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (!this.source.request(i6)) {
                    if (z5) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b5 = this.buffer.getByte(i5);
                if (b5 != 10 && b5 != 32 && b5 != 13 && b5 != 9) {
                    break;
                }
                i5 = i6;
            }
        }
    }

    private String nextQuotedValue(ByteString byteString) {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.getByte(indexOfElement) != 92) {
                if (sb == null) {
                    String readUtf8 = this.buffer.readUtf8(indexOfElement);
                    this.buffer.readByte();
                    return readUtf8;
                }
                sb.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.buffer.readUtf8(indexOfElement));
            this.buffer.readByte();
            sb.append(readEscapeCharacter());
        }
    }

    private String nextUnquotedValue() {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        return indexOfElement != -1 ? this.buffer.readUtf8(indexOfElement) : this.buffer.readUtf8();
    }

    private int peekKeyword() {
        String str;
        String str2;
        int i5;
        byte b5 = this.buffer.getByte(0L);
        if (b5 == 116 || b5 == 84) {
            str = "true";
            str2 = "TRUE";
            i5 = 5;
        } else if (b5 == 102 || b5 == 70) {
            str = "false";
            str2 = "FALSE";
            i5 = 6;
        } else {
            if (b5 != 110 && b5 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i5 = 7;
        }
        int length = str.length();
        int i6 = 1;
        while (i6 < length) {
            int i7 = i6 + 1;
            if (!this.source.request(i7)) {
                return 0;
            }
            byte b6 = this.buffer.getByte(i6);
            if (b6 != str.charAt(i6) && b6 != str2.charAt(i6)) {
                return 0;
            }
            i6 = i7;
        }
        if (this.source.request(length + 1) && isLiteral(this.buffer.getByte(length))) {
            return 0;
        }
        this.buffer.skip(length);
        this.peeked = i5;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (isLiteral(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.peekedLong = r8;
        r16.buffer.skip(r5);
        r16.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.peekedNumberLength = r5;
        r16.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() {
        char c5;
        boolean z5 = true;
        long j5 = 0;
        int i5 = 0;
        char c6 = 0;
        boolean z6 = false;
        boolean z7 = true;
        while (true) {
            int i6 = i5 + 1;
            if (!this.source.request(i6)) {
                break;
            }
            byte b5 = this.buffer.getByte(i5);
            if (b5 != 43) {
                if (b5 == 69 || b5 == 101) {
                    if (c6 != 2 && c6 != 4) {
                        return 0;
                    }
                    c6 = 5;
                } else if (b5 == 45) {
                    c5 = 6;
                    if (c6 == 0) {
                        c6 = 1;
                        z6 = true;
                    } else if (c6 != 5) {
                        return 0;
                    }
                } else if (b5 != 46) {
                    if (b5 < 48 || b5 > 57) {
                        break;
                    }
                    if (c6 == z5 || c6 == 0) {
                        j5 = -(b5 - 48);
                        c6 = 2;
                    } else if (c6 == 2) {
                        if (j5 == 0) {
                            return 0;
                        }
                        long j6 = (10 * j5) - (b5 - 48);
                        z7 &= j5 > MIN_INCOMPLETE_INTEGER || (j5 == MIN_INCOMPLETE_INTEGER && j6 < j5);
                        j5 = j6;
                    } else if (c6 == 3) {
                        c6 = 4;
                    } else if (c6 == 5 || c6 == 6) {
                        c6 = 7;
                    }
                } else {
                    if (c6 != 2) {
                        return 0;
                    }
                    c6 = 3;
                }
                i5 = i6;
                z5 = true;
            } else {
                c5 = 6;
                if (c6 != 5) {
                    return 0;
                }
            }
            c6 = c5;
            i5 = i6;
            z5 = true;
        }
    }

    private char readEscapeCharacter() {
        int i5;
        if (!this.source.request(1L)) {
            throw syntaxError("Unterminated escape sequence");
        }
        byte readByte = this.buffer.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (this.lenient) {
                return (char) readByte;
            }
            throw syntaxError("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.source.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            byte b5 = this.buffer.getByte(i6);
            char c6 = (char) (c5 << 4);
            if (b5 >= 48 && b5 <= 57) {
                i5 = b5 - 48;
            } else if (b5 >= 97 && b5 <= 102) {
                i5 = b5 - 87;
            } else {
                if (b5 < 65 || b5 > 70) {
                    throw syntaxError("\\u" + this.buffer.readUtf8(4L));
                }
                i5 = b5 - 55;
            }
            c5 = (char) (c6 + i5);
        }
        this.buffer.skip(4L);
        return c5;
    }

    private void skipQuotedValue(ByteString byteString) {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.getByte(indexOfElement) != 92) {
                this.buffer.skip(indexOfElement + 1);
                return;
            } else {
                this.buffer.skip(indexOfElement + 1);
                readEscapeCharacter();
            }
        }
    }

    private boolean skipToEndOfBlockComment() {
        long indexOf = this.source.indexOf(CLOSING_BLOCK_COMMENT);
        boolean z5 = indexOf != -1;
        Buffer buffer = this.buffer;
        buffer.skip(z5 ? indexOf + r1.size() : buffer.getSize());
        return z5;
    }

    private void skipToEndOfLine() {
        long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer = this.buffer;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.getSize());
    }

    private void skipUnquotedValue() {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer.getSize();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 1) {
            pushScope(3);
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
        }
        int i6 = this.stackSize;
        this.stackSize = i6 - 1;
        int[] iArr = this.pathIndices;
        int i7 = i6 - 2;
        iArr[i7] = iArr[i7] + 1;
        this.peeked = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
        }
        int i6 = this.stackSize;
        int i7 = i6 - 1;
        this.stackSize = i7;
        this.pathNames[i7] = null;
        int[] iArr = this.pathIndices;
        int i8 = i6 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.peeked = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        return (i5 == 2 || i5 == 4 || i5 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        }
        if (i5 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr2[i7] = iArr2[i7] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.peekedLong;
        }
        if (i5 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i5 == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i5 == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i5 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i5 != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (this.lenient || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i7 = this.stackSize - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 16) {
            long j5 = this.peekedLong;
            int i6 = (int) j5;
            if (j5 == i6) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i7 = this.stackSize - 1;
                iArr[i7] = iArr[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (i5 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i5 == 9 || i5 == 8) {
            String nextQuotedValue = i5 == 9 ? nextQuotedValue(DOUBLE_QUOTE_OR_SLASH) : nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(nextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i5 != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int i9 = (int) parseDouble;
            if (i9 == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr3[i10] = iArr3[i10] + 1;
                return i9;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() {
        String str;
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 14) {
            str = nextUnquotedValue();
        } else if (i5 == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i5 == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else {
            if (i5 != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            str = this.peekedString;
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() {
        String readUtf8;
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 10) {
            readUtf8 = nextUnquotedValue();
        } else if (i5 == 9) {
            readUtf8 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i5 == 8) {
            readUtf8 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i5 == 11) {
            readUtf8 = this.peekedString;
            this.peekedString = null;
        } else if (i5 == 16) {
            readUtf8 = Long.toString(this.peekedLong);
        } else {
            if (i5 != 17) {
                throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
            }
            readUtf8 = this.buffer.readUtf8(this.peekedNumberLength);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr[i6] = iArr[i6] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        switch (i5) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.Options options) {
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 < 12 || i5 > 15) {
            return -1;
        }
        if (i5 == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[select];
            return select;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() {
        if (this.failOnUnknown) {
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
        int i5 = this.peeked;
        if (i5 == 0) {
            i5 = doPeek();
        }
        if (i5 == 14) {
            skipUnquotedValue();
        } else if (i5 == 13) {
            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i5 == 12) {
            skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i5 != 15) {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() {
        if (this.failOnUnknown) {
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
        int i5 = 0;
        do {
            int i6 = this.peeked;
            if (i6 == 0) {
                i6 = doPeek();
            }
            if (i6 == 3) {
                pushScope(1);
            } else if (i6 == 1) {
                pushScope(3);
            } else {
                if (i6 == 4) {
                    i5--;
                    if (i5 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.stackSize--;
                } else if (i6 == 2) {
                    i5--;
                    if (i5 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.stackSize--;
                } else if (i6 == 14 || i6 == 10) {
                    skipUnquotedValue();
                } else if (i6 == 9 || i6 == 13) {
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else if (i6 == 8 || i6 == 12) {
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                } else if (i6 == 17) {
                    this.buffer.skip(this.peekedNumberLength);
                } else if (i6 == 18) {
                    throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                }
                this.peeked = 0;
            }
            i5++;
            this.peeked = 0;
        } while (i5 != 0);
        int[] iArr = this.pathIndices;
        int i7 = this.stackSize;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.pathNames[i7 - 1] = "null";
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }
}
