package dk.molslinjen.ui.views.reusable.barcode;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", BuildConfig.FLAVOR, "Lcom/google/zxing/BarcodeFormat;", "barcodeFormat", "<init>", "(Ljava/lang/String;ILcom/google/zxing/BarcodeFormat;)V", "Lcom/google/zxing/common/BitMatrix;", "Landroid/graphics/Bitmap;", "toBitmap", "(Lcom/google/zxing/common/BitMatrix;)Landroid/graphics/Bitmap;", BuildConfig.FLAVOR, "width", "height", BuildConfig.FLAVOR, "value", "Landroidx/compose/ui/graphics/ImageBitmap;", "getImageBitmap$app_kombardoProd", "(IILjava/lang/String;)Landroidx/compose/ui/graphics/ImageBitmap;", "getImageBitmap", "Lcom/google/zxing/BarcodeFormat;", "EAN_8", "UPC_E", "EAN_13", "UPC_A", "QR_CODE", "CODE_39", "CODE_93", "CODE_128", "ITF", "PDF_417", "CODABAR", "DATA_MATRIX", "AZTEC", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BarcodeViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BarcodeViewType[] $VALUES;
    private final BarcodeFormat barcodeFormat;
    public static final BarcodeViewType EAN_8 = new BarcodeViewType("EAN_8", 0, BarcodeFormat.EAN_8);
    public static final BarcodeViewType UPC_E = new BarcodeViewType("UPC_E", 1, BarcodeFormat.UPC_E);
    public static final BarcodeViewType EAN_13 = new BarcodeViewType("EAN_13", 2, BarcodeFormat.EAN_13);
    public static final BarcodeViewType UPC_A = new BarcodeViewType("UPC_A", 3, BarcodeFormat.UPC_A);
    public static final BarcodeViewType QR_CODE = new BarcodeViewType("QR_CODE", 4, BarcodeFormat.QR_CODE);
    public static final BarcodeViewType CODE_39 = new BarcodeViewType("CODE_39", 5, BarcodeFormat.CODE_39);
    public static final BarcodeViewType CODE_93 = new BarcodeViewType("CODE_93", 6, BarcodeFormat.CODE_93);
    public static final BarcodeViewType CODE_128 = new BarcodeViewType("CODE_128", 7, BarcodeFormat.CODE_128);
    public static final BarcodeViewType ITF = new BarcodeViewType("ITF", 8, BarcodeFormat.ITF);
    public static final BarcodeViewType PDF_417 = new BarcodeViewType("PDF_417", 9, BarcodeFormat.PDF_417);
    public static final BarcodeViewType CODABAR = new BarcodeViewType("CODABAR", 10, BarcodeFormat.CODABAR);
    public static final BarcodeViewType DATA_MATRIX = new BarcodeViewType("DATA_MATRIX", 11, BarcodeFormat.DATA_MATRIX);
    public static final BarcodeViewType AZTEC = new BarcodeViewType("AZTEC", 12, BarcodeFormat.AZTEC);

    private static final /* synthetic */ BarcodeViewType[] $values() {
        return new BarcodeViewType[]{EAN_8, UPC_E, EAN_13, UPC_A, QR_CODE, CODE_39, CODE_93, CODE_128, ITF, PDF_417, CODABAR, DATA_MATRIX, AZTEC};
    }

    static {
        BarcodeViewType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BarcodeViewType(String str, int i5, BarcodeFormat barcodeFormat) {
        this.barcodeFormat = barcodeFormat;
    }

    private final Bitmap toBitmap(BitMatrix bitMatrix) {
        Bitmap createBitmap = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        int[] iArr = new int[createBitmap.getWidth() * createBitmap.getHeight()];
        int height = createBitmap.getHeight();
        for (int i5 = 0; i5 < height; i5++) {
            int width = createBitmap.getWidth() * i5;
            int width2 = createBitmap.getWidth();
            for (int i6 = 0; i6 < width2; i6++) {
                iArr[width + i6] = bitMatrix.get(i6, i5) ? -16777216 : 0;
            }
        }
        createBitmap.setPixels(iArr, 0, createBitmap.getWidth(), 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        return createBitmap;
    }

    public static BarcodeViewType valueOf(String str) {
        return (BarcodeViewType) Enum.valueOf(BarcodeViewType.class, str);
    }

    public static BarcodeViewType[] values() {
        return (BarcodeViewType[]) $VALUES.clone();
    }

    public final ImageBitmap getImageBitmap$app_kombardoProd(int width, int height, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        BitMatrix encode = new MultiFormatWriter().encode(value, this.barcodeFormat, width, height);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        return AndroidImageBitmap_androidKt.asImageBitmap(toBitmap(encode));
    }
}
