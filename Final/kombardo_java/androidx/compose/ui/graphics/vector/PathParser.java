package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\n\u0010\u000bR*\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "pathData", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodes", "pathStringToNodes", "(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/ArrayList;", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "nodeData", "[F", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PathParser {
    private float[] nodeData = new float[64];
    private ArrayList<PathNode> nodes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList pathStringToNodes$default(PathParser pathParser, String str, ArrayList arrayList, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            arrayList = new ArrayList();
        }
        return pathParser.pathStringToNodes(str, arrayList);
    }

    public final ArrayList<PathNode> pathStringToNodes(String pathData, ArrayList<PathNode> nodes) {
        int i5;
        char charAt;
        int i6;
        int length = pathData.length();
        int i7 = 0;
        while (i7 < length && Intrinsics.compare((int) pathData.charAt(i7), 32) <= 0) {
            i7++;
        }
        while (length > i7 && Intrinsics.compare((int) pathData.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i8 = 0;
        while (i7 < length) {
            while (true) {
                i5 = i7 + 1;
                charAt = pathData.charAt(i7);
                int i9 = charAt | ' ';
                if ((i9 - 97) * (i9 - 122) <= 0 && i9 != 101) {
                    break;
                }
                if (i5 >= length) {
                    charAt = 0;
                    break;
                }
                i7 = i5;
            }
            if (charAt != 0) {
                if ((charAt | ' ') != 122) {
                    i8 = 0;
                    while (true) {
                        if (i5 >= length || Intrinsics.compare((int) pathData.charAt(i5), 32) > 0) {
                            long nextFloat = FastFloatParserKt.nextFloat(pathData, i5, length);
                            i6 = (int) (nextFloat >>> 32);
                            float intBitsToFloat = Float.intBitsToFloat((int) (nextFloat & 4294967295L));
                            if (!Float.isNaN(intBitsToFloat)) {
                                float[] fArr = this.nodeData;
                                int i10 = i8 + 1;
                                fArr[i8] = intBitsToFloat;
                                if (i10 >= fArr.length) {
                                    float[] fArr2 = new float[i10 * 2];
                                    this.nodeData = fArr2;
                                    ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i8 = i10;
                            }
                            while (i6 < length && pathData.charAt(i6) == ',') {
                                i6++;
                            }
                            if (i6 >= length || Float.isNaN(intBitsToFloat)) {
                                break;
                            }
                            i5 = i6;
                        } else {
                            i5++;
                        }
                    }
                    i5 = i6;
                }
                PathNodeKt.addPathNodes(charAt, nodes, this.nodeData, i8);
            }
            i7 = i5;
        }
        return nodes;
    }
}
