package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.sun.jna.Function;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public class ExifInterface {
    static final Charset ASCII;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final ExifTag[] EXIF_POINTER_TAGS;
    static final ExifTag[][] EXIF_TAGS;
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    private static final byte MARKER_COM = -2;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    private static final Pattern NON_ZERO_TIME_PATTERN;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    private static final short RW2_SIGNATURE = 85;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    private static final ExifTag TAG_RAF_IMAGE_SIZE;
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final HashMap<Integer, Integer> sExifPointerTagMap;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;
    private static final String TAG = "ExifInterface";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte MARKER_SOI = -40;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, 42};
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] IFD_FORMAT_NAMES = {BuildConfig.FLAVOR, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private ByteOrder mByteOrder;
        final DataInputStream mDataInputStream;
        int mPosition;
        private byte[] mSkipBuffer;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

        ByteOrderedDataInputStream(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public void mark(int i5) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int position() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int read() {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.mPosition++;
            int read = this.mDataInputStream.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i5, int i6) {
            this.mPosition += i6;
            this.mDataInputStream.readFully(bArr, i5, i6);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.mPosition += 4;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.mPosition += 8;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            int read5 = this.mDataInputStream.read();
            int read6 = this.mDataInputStream.read();
            int read7 = this.mDataInputStream.read();
            int read8 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == BIG_ENDIAN) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i5) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int i5) {
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i5 - i6;
                int skip = (int) this.mDataInputStream.skip(i7);
                if (skip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[ExifInterface.SKIP_BUFFER_SIZE];
                    }
                    skip = this.mDataInputStream.read(this.mSkipBuffer, 0, Math.min(ExifInterface.SKIP_BUFFER_SIZE, i7));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i5 + " bytes.");
                    }
                }
                i6 += skip;
            }
            this.mPosition += i6;
        }

        ByteOrderedDataInputStream(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            int read = this.mDataInputStream.read(bArr, i5, i6);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExifAttribute {
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i5, int i6, byte[] bArr) {
            this(i5, i6, -1L, bArr);
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j5 : jArr) {
                wrap.putInt((int) j5);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i5 : iArr) {
                wrap.putShort((short) i5);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (value instanceof String) {
                return Double.parseDouble((String) value);
            }
            if (value instanceof long[]) {
                if (((long[]) value).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                if (((int[]) value).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) value;
            if (rationalArr.length == 1) {
                return rationalArr[0].calculate();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (value instanceof String) {
                return Integer.parseInt((String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i5 < jArr.length) {
                    sb.append(jArr[i5]);
                    i5++;
                    if (i5 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i5 < iArr.length) {
                    sb.append(iArr[i5]);
                    i5++;
                    if (i5 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i5 < dArr.length) {
                    sb.append(dArr[i5]);
                    i5++;
                    if (i5 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(value instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) value;
            while (i5 < rationalArr.length) {
                sb.append(rationalArr[i5].numerator);
                sb.append('/');
                sb.append(rationalArr[i5].denominator);
                i5++;
                if (i5 != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:166:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:169:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Object getValue(ByteOrder byteOrder) {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            InputStream inputStream;
            byte b5;
            byte b6;
            int i5 = 0;
            InputStream inputStream2 = null;
            try {
                try {
                    byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                    try {
                        byteOrderedDataInputStream.setByteOrder(byteOrder);
                        switch (this.format) {
                            case 1:
                            case 6:
                                byte[] bArr = this.bytes;
                                if (bArr.length != 1 || (b5 = bArr[0]) < 0 || b5 > 1) {
                                    String str = new String(bArr, ExifInterface.ASCII);
                                    try {
                                        byteOrderedDataInputStream.close();
                                    } catch (IOException e5) {
                                        Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e5);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b5 + 48)});
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e6) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e6);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                    int i6 = 0;
                                    while (true) {
                                        byte[] bArr2 = ExifInterface.EXIF_ASCII_PREFIX;
                                        if (i6 >= bArr2.length) {
                                            i5 = bArr2.length;
                                        } else if (this.bytes[i6] == bArr2[i6]) {
                                            i6++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (i5 < this.numberOfComponents && (b6 = this.bytes[i5]) != 0) {
                                    if (b6 >= 32) {
                                        sb.append((char) b6);
                                    } else {
                                        sb.append('?');
                                    }
                                    i5++;
                                }
                                String sb2 = sb.toString();
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e7) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e7);
                                }
                                return sb2;
                            case 3:
                                int[] iArr = new int[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    iArr[i5] = byteOrderedDataInputStream.readUnsignedShort();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e8) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e8);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    jArr[i5] = byteOrderedDataInputStream.readUnsignedInt();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e9) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e9);
                                }
                                return jArr;
                            case 5:
                                Rational[] rationalArr = new Rational[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    rationalArr[i5] = new Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e10) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e10);
                                }
                                return rationalArr;
                            case 8:
                                int[] iArr2 = new int[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    iArr2[i5] = byteOrderedDataInputStream.readShort();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e11) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e11);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    iArr3[i5] = byteOrderedDataInputStream.readInt();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e12) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e12);
                                }
                                return iArr3;
                            case 10:
                                Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    rationalArr2[i5] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e13) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e13);
                                }
                                return rationalArr2;
                            case 11:
                                double[] dArr = new double[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    dArr[i5] = byteOrderedDataInputStream.readFloat();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e14) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e14);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.numberOfComponents];
                                while (i5 < this.numberOfComponents) {
                                    dArr2[i5] = byteOrderedDataInputStream.readDouble();
                                    i5++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e15) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e15);
                                }
                                return dArr2;
                            default:
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e16) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e16);
                                }
                                return null;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        Log.w(ExifInterface.TAG, "IOException occurred during reading a value", e);
                        if (byteOrderedDataInputStream != null) {
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e18) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e18);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e19) {
                            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e19);
                        }
                    }
                    throw th;
                }
            } catch (IOException e20) {
                e = e20;
                byteOrderedDataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        ExifAttribute(int i5, int i6, long j5, byte[] bArr) {
            this.format = i5;
            this.numberOfComponents = i6;
            this.bytesOffset = j5;
            this.bytes = bArr;
        }

        public static ExifAttribute createULong(long j5, ByteOrder byteOrder) {
            return createULong(new long[]{j5}, byteOrder);
        }

        public static ExifAttribute createUShort(int i5, ByteOrder byteOrder) {
            return createUShort(new int[]{i5}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(long j5, long j6) {
            if (j6 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j5;
                this.denominator = j6;
            }
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", Function.USE_VARARGS, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", Function.USE_VARARGS, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
        ExifTag[] exifTagArr6 = {new ExifTag("ThumbnailImage", 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("AspectFrame", 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        sExifTagMapsForReading = new HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr10.length];
        sTagSetForCompatibility = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        sExifPointerTagMap = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i5 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i5 >= exifTagArr11.length) {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].number), 8);
                NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            sExifTagMapsForReading[i5] = new HashMap<>();
            sExifTagMapsForWriting[i5] = new HashMap<>();
            for (ExifTag exifTag : exifTagArr11[i5]) {
                sExifTagMapsForReading[i5].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i5].put(exifTag.name, exifTag);
            }
            i5++;
        }
    }

    public ExifInterface(InputStream inputStream) {
        this(inputStream, 0);
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null && getAttribute("DateTime") == null) {
            this.mAttributes[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            this.mAttributes[1].put("LightSource", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    private ExifAttribute getExifAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (DEBUG) {
                Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            ExifAttribute exifAttribute = this.mAttributes[i5].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    private void getHeifAttributes(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                ExifInterfaceUtils.Api23Impl.setDataSource(mediaMetadataRetriever, new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                    long mPosition;

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }

                    @Override // android.media.MediaDataSource
                    public long getSize() {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public int readAt(long j5, byte[] bArr, int i5, int i6) {
                        if (i6 == 0) {
                            return 0;
                        }
                        if (j5 < 0) {
                            return -1;
                        }
                        try {
                            long j6 = this.mPosition;
                            if (j6 != j5) {
                                if (j6 >= 0 && j5 >= j6 + seekableByteOrderedDataInputStream.available()) {
                                    return -1;
                                }
                                seekableByteOrderedDataInputStream.seek(j5);
                                this.mPosition = j5;
                            }
                            if (i6 > seekableByteOrderedDataInputStream.available()) {
                                i6 = seekableByteOrderedDataInputStream.available();
                            }
                            int read = seekableByteOrderedDataInputStream.read(bArr, i5, i6);
                            if (read >= 0) {
                                this.mPosition += read;
                                return read;
                            }
                        } catch (IOException unused) {
                        }
                        this.mPosition = -1L;
                        return -1;
                    }
                });
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (str != null) {
                    this.mAttributes[0].put("ImageWidth", ExifAttribute.createUShort(Integer.parseInt(str), this.mExifByteOrder));
                }
                if (str2 != null) {
                    this.mAttributes[0].put("ImageLength", ExifAttribute.createUShort(Integer.parseInt(str2), this.mExifByteOrder));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    this.mAttributes[0].put("Orientation", ExifAttribute.createUShort(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.mExifByteOrder));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.seek(parseInt2);
                    byte[] bArr = new byte[6];
                    if (seekableByteOrderedDataInputStream.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i5 = parseInt2 + 6;
                    int i6 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    if (seekableByteOrderedDataInputStream.read(bArr2) != i6) {
                        throw new IOException("Can't read exif");
                    }
                    this.mOffsetToExifData = i5;
                    readExifSegment(bArr2, 0);
                }
                if (DEBUG) {
                    Log.d(TAG, "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0191, code lost:
    
        r22.setByteOrder(r21.mExifByteOrder);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b A[LOOP:0: B:9:0x0037->B:33:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i5, int i6) {
        String str;
        if (DEBUG) {
            Log.d(TAG, "getJpegAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte readByte = byteOrderedDataInputStream.readByte();
        byte b5 = -1;
        if (readByte != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        if (byteOrderedDataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i7 = 2;
        while (true) {
            byte readByte2 = byteOrderedDataInputStream.readByte();
            if (readByte2 != b5) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            byte readByte3 = byteOrderedDataInputStream.readByte();
            boolean z5 = DEBUG;
            if (z5) {
                Log.d(TAG, "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255));
            }
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                int i8 = readUnsignedShort - 2;
                int i9 = i7 + 4;
                if (z5) {
                    Log.d(TAG, "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + readUnsignedShort + ")");
                }
                if (i8 < 0) {
                    throw new IOException("Invalid length");
                }
                if (readByte3 == -31) {
                    byte[] bArr = new byte[i8];
                    byteOrderedDataInputStream.readFully(bArr);
                    int i10 = i9 + i8;
                    byte[] bArr2 = IDENTIFIER_EXIF_APP1;
                    if (ExifInterfaceUtils.startsWith(bArr, bArr2)) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr2.length, i8);
                        this.mOffsetToExifData = i5 + i9 + bArr2.length;
                        readExifSegment(copyOfRange, i6);
                        setThumbnailData(new ByteOrderedDataInputStream(copyOfRange));
                    } else {
                        byte[] bArr3 = IDENTIFIER_XMP_APP1;
                        if (ExifInterfaceUtils.startsWith(bArr, bArr3)) {
                            int length = i9 + bArr3.length;
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr3.length, i8);
                            if (getAttribute("Xmp") == null) {
                                str = "Invalid length";
                                this.mAttributes[0].put("Xmp", new ExifAttribute(1, copyOfRange2.length, length, copyOfRange2));
                                this.mXmpIsFromSeparateMarker = true;
                                i9 = i10;
                            }
                        }
                    }
                    str = "Invalid length";
                    i9 = i10;
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                        default:
                            switch (readByte3) {
                                case -59:
                                case -58:
                                case -57:
                                    break;
                                default:
                                    switch (readByte3) {
                                        case -55:
                                        case -54:
                                        case -53:
                                            break;
                                        default:
                                            switch (readByte3) {
                                            }
                                            if (i8 < 0) {
                                                throw new IOException(str);
                                            }
                                            byteOrderedDataInputStream.skipFully(i8);
                                            i7 = i9 + i8;
                                            b5 = -1;
                                            break;
                                    }
                            }
                    }
                    byteOrderedDataInputStream.skipFully(1);
                    this.mAttributes[i6].put(i6 != 4 ? "ImageLength" : "ThumbnailImageLength", ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                    this.mAttributes[i6].put(i6 != 4 ? "ImageWidth" : "ThumbnailImageWidth", ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                    i8 = readUnsignedShort - 7;
                    str = "Invalid length";
                    if (i8 < 0) {
                    }
                } else {
                    byte[] bArr4 = new byte[i8];
                    if (byteOrderedDataInputStream.read(bArr4) != i8) {
                        throw new IOException("Invalid exif");
                    }
                    if (getAttribute("UserComment") == null) {
                        this.mAttributes[1].put("UserComment", ExifAttribute.createString(new String(bArr4, ASCII)));
                    }
                    str = "Invalid length";
                }
                i8 = 0;
                if (i8 < 0) {
                }
            }
        }
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(SIGNATURE_CHECK_SIZE);
        byte[] bArr = new byte[SIGNATURE_CHECK_SIZE];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) {
        int i5;
        int i6;
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = this.mAttributes[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.mAttributes[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.mAttributes[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i7 = iArr[2];
                int i8 = iArr[0];
                if (i7 <= i8 || (i5 = iArr[3]) <= (i6 = iArr[1])) {
                    return;
                }
                int i9 = (i7 - i8) + 1;
                int i10 = (i5 - i6) + 1;
                if (i9 < i10) {
                    int i11 = i9 + i10;
                    i10 = i11 - i10;
                    i9 = i11 - i10;
                }
                ExifAttribute createUShort = ExifAttribute.createUShort(i9, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(i10, this.mExifByteOrder);
                this.mAttributes[0].put("ImageWidth", createUShort);
                this.mAttributes[0].put("ImageLength", createUShort2);
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        if (DEBUG) {
            Log.d(TAG, "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i5 = length + 8;
                if (i5 == 16 && !Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                    byte[] bArr3 = new byte[readInt];
                    if (byteOrderedDataInputStream.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.mOffsetToExifData = i5;
                        readExifSegment(bArr3, 0);
                        validateImages();
                        setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i6 = readInt + 4;
                byteOrderedDataInputStream.skipFully(i6);
                length = i5 + i6;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        boolean z5 = DEBUG;
        if (z5) {
            Log.d(TAG, "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(RAF_OFFSET_TO_JPEG_IMAGE_OFFSET);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i5 = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        int i7 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i6];
        byteOrderedDataInputStream.skipFully(i5 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i5, 5);
        byteOrderedDataInputStream.skipFully(i7 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z5) {
            Log.d(TAG, "numberOfDirectoryEntry: " + readInt);
        }
        for (int i8 = 0; i8 < readInt; i8++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", createUShort);
                this.mAttributes[0].put("ImageWidth", createUShort2);
                if (DEBUG) {
                    Log.d(TAG, "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(readUnsignedShort2);
        }
    }

    private void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) {
        ExifAttribute exifAttribute;
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType != 8 || (exifAttribute = this.mAttributes[1].get("MakerNote")) == null) {
            return;
        }
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
        seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
        seekableByteOrderedDataInputStream2.skipFully(6);
        readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = this.mAttributes[9].get("ColorSpace");
        if (exifAttribute2 != null) {
            this.mAttributes[1].put("ColorSpace", exifAttribute2);
        }
    }

    private void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) {
        if (DEBUG) {
            Log.d(TAG, "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get("ISO");
        ExifAttribute exifAttribute3 = this.mAttributes[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        this.mAttributes[1].put("PhotographicSensitivity", exifAttribute2);
    }

    private void getStandaloneAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        seekableByteOrderedDataInputStream.skipFully(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        if (DEBUG) {
            Log.d(TAG, "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = byteOrderedDataInputStream.readInt();
                int i5 = length + 8;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (byteOrderedDataInputStream.read(bArr3) == readInt2) {
                        this.mOffsetToExifData = i5;
                        readExifSegment(bArr3, 0);
                        setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i5 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.skipFully(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        if (intValue > 0 && intValue2 > 0) {
            this.mHasThumbnail = true;
            if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                byte[] bArr = new byte[intValue2];
                byteOrderedDataInputStream.skip(intValue);
                byteOrderedDataInputStream.read(bArr);
                this.mThumbnailBytes = bArr;
            }
            this.mThumbnailOffset = intValue;
            this.mThumbnailLength = intValue2;
        }
        if (DEBUG) {
            Log.d(TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2);
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("StripByteCounts");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] convertToLongArray = ExifInterfaceUtils.convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
        long[] convertToLongArray2 = ExifInterfaceUtils.convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
        if (convertToLongArray == null || convertToLongArray.length == 0) {
            Log.w(TAG, "stripOffsets should not be null or have zero length.");
            return;
        }
        if (convertToLongArray2 == null || convertToLongArray2.length == 0) {
            Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (convertToLongArray.length != convertToLongArray2.length) {
            Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j5 = 0;
        for (long j6 : convertToLongArray2) {
            j5 += j6;
        }
        int i5 = (int) j5;
        byte[] bArr = new byte[i5];
        this.mAreThumbnailStripsConsecutive = true;
        this.mHasThumbnailStrips = true;
        this.mHasThumbnail = true;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < convertToLongArray.length; i8++) {
            int i9 = (int) convertToLongArray[i8];
            int i10 = (int) convertToLongArray2[i8];
            if (i8 < convertToLongArray.length - 1 && i9 + i10 != convertToLongArray[i8 + 1]) {
                this.mAreThumbnailStripsConsecutive = false;
            }
            int i11 = i9 - i6;
            if (i11 < 0) {
                Log.d(TAG, "Invalid strip offset value");
                return;
            }
            long j7 = i11;
            if (byteOrderedDataInputStream.skip(j7) != j7) {
                Log.d(TAG, "Failed to skip " + i11 + " bytes.");
                return;
            }
            int i12 = i6 + i11;
            byte[] bArr2 = new byte[i10];
            if (byteOrderedDataInputStream.read(bArr2) != i10) {
                Log.d(TAG, "Failed to read " + i10 + " bytes.");
                return;
            }
            i6 = i12 + i10;
            System.arraycopy(bArr2, 0, bArr, i7, i10);
            i7 += i10;
        }
        this.mThumbnailBytes = bArr;
        if (this.mAreThumbnailStripsConsecutive) {
            this.mThumbnailOffset = (int) convertToLongArray[0];
            this.mThumbnailLength = i5;
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i5 >= bArr3.length) {
                return true;
            }
            if (bArr2[i5] != bArr3[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean isHeifFormat(byte[] bArr) {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        long j5;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = byteOrderedDataInputStream.readInt();
            bArr2 = new byte[4];
            byteOrderedDataInputStream.read(bArr2);
        } catch (Exception e6) {
            e = e6;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (DEBUG) {
                Log.d(TAG, "Exception parsing HEIF file type box.", e);
            }
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
            byteOrderedDataInputStream.close();
            return false;
        }
        if (readInt == 1) {
            readInt = byteOrderedDataInputStream.readLong();
            j5 = 16;
            if (readInt < 16) {
                byteOrderedDataInputStream.close();
                return false;
            }
        } else {
            j5 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j6 = readInt - j5;
        if (j6 < 8) {
            byteOrderedDataInputStream.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z5 = false;
        boolean z6 = false;
        for (long j7 = 0; j7 < j6 / 4; j7++) {
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (j7 != 1) {
                if (Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                    z5 = true;
                } else if (Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                    z6 = true;
                }
                if (z5 && z6) {
                    byteOrderedDataInputStream.close();
                    return true;
                }
            }
        }
        byteOrderedDataInputStream.close();
        return false;
    }

    private static boolean isJpegFormat(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean isOrfFormat(byte[] bArr) {
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                short readShort = byteOrderedDataInputStream2.readShort();
                boolean z5 = readShort == 20306 || readShort == 21330;
                byteOrderedDataInputStream2.close();
                return z5;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean isPngFormat(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean isRafFormat(byte[] bArr) {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i5 = 0; i5 < bytes.length; i5++) {
            if (bArr[i5] != bytes[i5]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) {
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                boolean z5 = byteOrderedDataInputStream2.readShort() == 85;
                byteOrderedDataInputStream2.close();
                return z5;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!DEBUG) {
                return false;
            }
            Log.d(TAG, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) {
        ExifAttribute exifAttribute;
        int intValue;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "Unsupported data type value");
        return false;
    }

    private boolean isThumbnail(HashMap hashMap) {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= MAX_THUMBNAIL_SIZE && exifAttribute2.getIntValue(this.mExifByteOrder) <= MAX_THUMBNAIL_SIZE;
    }

    private boolean isWebpFormat(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i5 >= bArr2.length) {
                int i6 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i6 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i6 + 4] != bArr3[i6]) {
                        return false;
                    }
                    i6++;
                }
            } else {
                if (bArr[i5] != bArr2[i5]) {
                    return false;
                }
                i5++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:8:0x001e, B:10:0x0022, B:11:0x0030, B:13:0x0038, B:15:0x0041, B:16:0x0061, B:23:0x0045, B:25:0x004b, B:28:0x0052, B:31:0x005a, B:32:0x005e, B:33:0x006b, B:35:0x0075, B:38:0x007d, B:41:0x0085, B:44:0x008d, B:53:0x009b, B:55:0x009f), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadAttributes(InputStream inputStream) {
        boolean z5;
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            try {
                try {
                    this.mAttributes[i5] = new HashMap<>();
                } catch (Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                z5 = DEBUG;
                if (z5) {
                    Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (!z5) {
                    return;
                }
                printAttributes();
            } catch (UnsupportedOperationException e6) {
                e = e6;
                z5 = DEBUG;
                if (z5) {
                }
                addDefaultValuesForCompatibility();
                if (!z5) {
                }
                printAttributes();
            }
        }
        if (!this.mIsExifDataOnly) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, SIGNATURE_CHECK_SIZE);
            this.mMimeType = getMimeType(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (shouldSupportSeek(this.mMimeType)) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
            if (this.mIsExifDataOnly) {
                getStandaloneAttributes(seekableByteOrderedDataInputStream);
            } else {
                int i6 = this.mMimeType;
                if (i6 == 12) {
                    getHeifAttributes(seekableByteOrderedDataInputStream);
                } else if (i6 == 7) {
                    getOrfAttributes(seekableByteOrderedDataInputStream);
                } else if (i6 == 10) {
                    getRw2Attributes(seekableByteOrderedDataInputStream);
                } else {
                    getRawAttributes(seekableByteOrderedDataInputStream);
                }
            }
            seekableByteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(seekableByteOrderedDataInputStream);
        } else {
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
            int i7 = this.mMimeType;
            if (i7 == 4) {
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
            } else if (i7 == 13) {
                getPngAttributes(byteOrderedDataInputStream);
            } else if (i7 == 9) {
                getRafAttributes(byteOrderedDataInputStream);
            } else if (i7 == 14) {
                getWebpAttributes(byteOrderedDataInputStream);
            }
        }
        addDefaultValuesForCompatibility();
        if (!DEBUG) {
            return;
        }
        printAttributes();
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i5 = this.mMimeType;
        if (i5 != 7 && i5 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i6 = readInt - 8;
        if (i6 > 0) {
            byteOrderedDataInputStream.skipFully(i6);
        }
    }

    private void printAttributes() {
        for (int i5 = 0; i5 < this.mAttributes.length; i5++) {
            Log.d(TAG, "The size of tag group[" + i5 + "]: " + this.mAttributes[i5].size());
            for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[i5].entrySet()) {
                ExifAttribute value = entry.getValue();
                Log.d(TAG, "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void readExifSegment(byte[] bArr, int i5) {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readImageFileDirectory(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i5) {
        short s5;
        short s6;
        ExifTag exifTag;
        long j5;
        boolean z5;
        long j6;
        int i6;
        ExifTag exifTag2;
        int readUnsignedShort;
        long j7;
        int i7 = i5;
        this.mAttributesOffsets.add(Integer.valueOf(seekableByteOrderedDataInputStream.mPosition));
        short readShort = seekableByteOrderedDataInputStream.readShort();
        if (DEBUG) {
            Log.d(TAG, "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if (readShort <= 0) {
            return;
        }
        short s7 = 0;
        while (s7 < readShort) {
            int readUnsignedShort2 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort3 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int readInt = seekableByteOrderedDataInputStream.readInt();
            long position = seekableByteOrderedDataInputStream.position() + 4;
            ExifTag exifTag3 = sExifTagMapsForReading[i7].get(Integer.valueOf(readUnsignedShort2));
            boolean z6 = DEBUG;
            if (z6) {
                s5 = readShort;
                s6 = s7;
                Log.d(TAG, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i5), Integer.valueOf(readUnsignedShort2), exifTag3 != null ? exifTag3.name : null, Integer.valueOf(readUnsignedShort3), Integer.valueOf(readInt)));
            } else {
                s5 = readShort;
                s6 = s7;
            }
            if (exifTag3 != null) {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                        if (exifTag3.isFormatCompatible(readUnsignedShort3)) {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = exifTag3.primaryFormat;
                            }
                            exifTag = exifTag3;
                            j5 = r6[readUnsignedShort3] * readInt;
                            if (j5 < 0 || j5 > 2147483647L) {
                                if (z6) {
                                    Log.d(TAG, "Skip the tag entry since the number of components is invalid: " + readInt);
                                }
                                z5 = false;
                                if (z5) {
                                    seekableByteOrderedDataInputStream.seek(position);
                                } else {
                                    if (j5 > 4) {
                                        int readInt2 = seekableByteOrderedDataInputStream.readInt();
                                        if (z6) {
                                            Log.d(TAG, "seek to data offset: " + readInt2);
                                        }
                                        if (this.mMimeType == 7) {
                                            exifTag2 = exifTag;
                                            j6 = position;
                                            if ("MakerNote".equals(exifTag2.name)) {
                                                this.mOrfMakerNoteOffset = readInt2;
                                            } else if (i7 == 6 && "ThumbnailImage".equals(exifTag2.name)) {
                                                this.mOrfThumbnailOffset = readInt2;
                                                this.mOrfThumbnailLength = readInt;
                                                ExifAttribute createUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                                ExifAttribute createULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                                i6 = readInt;
                                                ExifAttribute createULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                                this.mAttributes[4].put("Compression", createUShort);
                                                this.mAttributes[4].put("JPEGInterchangeFormat", createULong);
                                                this.mAttributes[4].put("JPEGInterchangeFormatLength", createULong2);
                                            }
                                            i6 = readInt;
                                        } else {
                                            j6 = position;
                                            i6 = readInt;
                                            exifTag2 = exifTag;
                                        }
                                        seekableByteOrderedDataInputStream.seek(readInt2);
                                    } else {
                                        j6 = position;
                                        i6 = readInt;
                                        exifTag2 = exifTag;
                                    }
                                    Integer num = sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort2));
                                    if (z6) {
                                        Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j5);
                                    }
                                    if (num != null) {
                                        if (readUnsignedShort3 != 3) {
                                            if (readUnsignedShort3 == 4) {
                                                j7 = seekableByteOrderedDataInputStream.readUnsignedInt();
                                            } else if (readUnsignedShort3 == 8) {
                                                readUnsignedShort = seekableByteOrderedDataInputStream.readShort();
                                            } else if (readUnsignedShort3 == 9 || readUnsignedShort3 == 13) {
                                                readUnsignedShort = seekableByteOrderedDataInputStream.readInt();
                                            } else {
                                                j7 = -1;
                                            }
                                            if (z6) {
                                                Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(j7), exifTag2.name));
                                            }
                                            if (j7 <= 0) {
                                                if (!this.mAttributesOffsets.contains(Integer.valueOf((int) j7))) {
                                                    seekableByteOrderedDataInputStream.seek(j7);
                                                    readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                                                } else if (z6) {
                                                    Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j7 + ")");
                                                }
                                            } else if (z6) {
                                                Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + j7);
                                            }
                                            seekableByteOrderedDataInputStream.seek(j6);
                                        } else {
                                            readUnsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                                        }
                                        j7 = readUnsignedShort;
                                        if (z6) {
                                        }
                                        if (j7 <= 0) {
                                        }
                                        seekableByteOrderedDataInputStream.seek(j6);
                                    } else {
                                        long j8 = j6;
                                        int position2 = seekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                                        byte[] bArr = new byte[(int) j5];
                                        seekableByteOrderedDataInputStream.readFully(bArr);
                                        ExifAttribute exifAttribute = new ExifAttribute(readUnsignedShort3, i6, position2, bArr);
                                        this.mAttributes[i5].put(exifTag2.name, exifAttribute);
                                        if ("DNGVersion".equals(exifTag2.name)) {
                                            this.mMimeType = 3;
                                        }
                                        if ((("Make".equals(exifTag2.name) || "Model".equals(exifTag2.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || ("Compression".equals(exifTag2.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                            this.mMimeType = 8;
                                        }
                                        if (seekableByteOrderedDataInputStream.position() != j8) {
                                            seekableByteOrderedDataInputStream.seek(j8);
                                        }
                                    }
                                }
                                s7 = (short) (s6 + 1);
                                i7 = i5;
                                readShort = s5;
                            } else {
                                z5 = true;
                                if (z5) {
                                }
                                s7 = (short) (s6 + 1);
                                i7 = i5;
                                readShort = s5;
                            }
                        } else if (z6) {
                            Log.d(TAG, "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[readUnsignedShort3] + ") is unexpected for tag: " + exifTag3.name);
                        }
                    }
                }
                exifTag = exifTag3;
                if (z6) {
                    Log.d(TAG, "Skip the tag entry since data format is invalid: " + readUnsignedShort3);
                }
                j5 = 0;
                z5 = false;
                if (z5) {
                }
                s7 = (short) (s6 + 1);
                i7 = i5;
                readShort = s5;
            } else if (z6) {
                Log.d(TAG, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
            }
            exifTag = exifTag3;
            j5 = 0;
            z5 = false;
            if (z5) {
            }
            s7 = (short) (s6 + 1);
            i7 = i5;
            readShort = s5;
        }
        int readInt3 = seekableByteOrderedDataInputStream.readInt();
        boolean z7 = DEBUG;
        if (z7) {
            Log.d(TAG, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
        }
        long j9 = readInt3;
        if (j9 <= 0) {
            if (z7) {
                Log.d(TAG, "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
                return;
            }
            return;
        }
        if (this.mAttributesOffsets.contains(Integer.valueOf(readInt3))) {
            if (z7) {
                Log.d(TAG, "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                return;
            }
            return;
        }
        seekableByteOrderedDataInputStream.seek(j9);
        if (this.mAttributes[4].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 4);
        } else if (this.mAttributes[5].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 5);
        }
    }

    private void replaceInvalidTags(int i5, String str, String str2) {
        if (this.mAttributes[i5].isEmpty() || this.mAttributes[i5].get(str) == null) {
            return;
        }
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[i5];
        hashMap.put(str2, hashMap.get(str));
        this.mAttributes[i5].remove(str);
    }

    private void retrieveJpegImageSize(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i5) {
        ExifAttribute exifAttribute = this.mAttributes[i5].get("ImageLength");
        ExifAttribute exifAttribute2 = this.mAttributes[i5].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i5].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute4 = this.mAttributes[i5].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 == null || exifAttribute4 == null) {
                return;
            }
            int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
            seekableByteOrderedDataInputStream.seek(intValue);
            byte[] bArr = new byte[intValue2];
            seekableByteOrderedDataInputStream.read(bArr);
            getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i5);
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get("Compression");
        if (exifAttribute == null) {
            this.mThumbnailCompression = 6;
            handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        if (isSupportedDataType(hashMap)) {
            handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
        }
    }

    private static boolean shouldSupportSeek(int i5) {
        return (i5 == 4 || i5 == 9 || i5 == 13 || i5 == 14) ? false : true;
    }

    private void swapBasedOnImageSize(int i5, int i6) {
        if (this.mAttributes[i5].isEmpty() || this.mAttributes[i6].isEmpty()) {
            if (DEBUG) {
                Log.d(TAG, "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifAttribute exifAttribute = this.mAttributes[i5].get("ImageLength");
        ExifAttribute exifAttribute2 = this.mAttributes[i5].get("ImageWidth");
        ExifAttribute exifAttribute3 = this.mAttributes[i6].get("ImageLength");
        ExifAttribute exifAttribute4 = this.mAttributes[i6].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (DEBUG) {
                Log.d(TAG, "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifAttribute3 == null || exifAttribute4 == null) {
            if (DEBUG) {
                Log.d(TAG, "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
        HashMap<String, ExifAttribute> hashMap = hashMapArr[i5];
        hashMapArr[i5] = hashMapArr[i6];
        hashMapArr[i6] = hashMap;
    }

    private void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i5) {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        ExifAttribute exifAttribute = this.mAttributes[i5].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = this.mAttributes[i5].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = this.mAttributes[i5].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = this.mAttributes[i5].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = this.mAttributes[i5].get("SensorRightBorder");
        if (exifAttribute == null) {
            if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                retrieveJpegImageSize(seekableByteOrderedDataInputStream, i5);
                return;
            }
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            this.mAttributes[i5].put("ImageLength", createUShort3);
            this.mAttributes[i5].put("ImageWidth", createUShort4);
            return;
        }
        if (exifAttribute.format == 5) {
            Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
            if (rationalArr == null || rationalArr.length != 2) {
                Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                return;
            }
            createUShort = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
            createUShort2 = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
        } else {
            int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
            if (iArr == null || iArr.length != 2) {
                Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            createUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
            createUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
        }
        this.mAttributes[i5].put("ImageWidth", createUShort);
        this.mAttributes[i5].put("ImageLength", createUShort2);
    }

    private void validateImages() {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(0, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(0, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(5, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(5, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(5, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(4, "Orientation", "ThumbnailOrientation");
        replaceInvalidTags(4, "ImageLength", "ThumbnailImageLength");
        replaceInvalidTags(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public String getAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals("GPSTimeStamp")) {
                int i5 = exifAttribute.format;
                if (i5 != 5 && i5 != 10) {
                    Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                Rational rational = rationalArr[0];
                Integer valueOf = Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator)));
                Rational rational2 = rationalArr[1];
                Integer valueOf2 = Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator)));
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator))));
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int getAttributeInt(String str, int i5) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i5;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public int getRotationDegrees() {
        switch (getAttributeInt("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt("Orientation", 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        public void seek(long j5) {
            int i5 = this.mPosition;
            if (i5 > j5) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j5 -= i5;
            }
            skipFully((int) j5);
        }

        SeekableByteOrderedDataInputStream(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.mDataInputStream.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public ExifInterface(InputStream inputStream, int i5) {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i5 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
                if (!isExifDataOnly(bufferedInputStream)) {
                    Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i5, int i6) {
            this.name = str;
            this.number = i5;
            this.primaryFormat = i6;
            this.secondaryFormat = -1;
        }

        boolean isFormatCompatible(int i5) {
            int i6;
            int i7 = this.primaryFormat;
            if (i7 == 7 || i5 == 7 || i7 == i5 || (i6 = this.secondaryFormat) == i5) {
                return true;
            }
            if ((i7 == 4 || i6 == 4) && i5 == 3) {
                return true;
            }
            if ((i7 == 9 || i6 == 9) && i5 == 8) {
                return true;
            }
            return (i7 == 12 || i6 == 12) && i5 == 11;
        }

        ExifTag(String str, int i5, int i6, int i7) {
            this.name = str;
            this.number = i5;
            this.primaryFormat = i6;
            this.secondaryFormat = i7;
        }
    }
}
