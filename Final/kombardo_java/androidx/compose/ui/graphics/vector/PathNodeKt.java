package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b#\u001a;\u0010\n\u001a\u00020\t*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\r\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011\"\u0014\u0010\u0016\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011\"\u0014\u0010\u0017\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011\"\u0014\u0010\u0018\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011\"\u0014\u0010\u001a\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011\"\u0014\u0010\u001b\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011\"\u0014\u0010\u001c\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011\"\u0014\u0010\u001d\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011\"\u0014\u0010\u001e\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011\"\u0014\u0010\u001f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011\"\u0014\u0010 \u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0011\"\u0014\u0010!\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0011\"\u0014\u0010\"\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0011\"\u0014\u0010#\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0011\"\u0014\u0010$\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0011\"\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010'\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&\"\u0014\u0010(\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&\"\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010&\"\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010&\"\u0014\u0010+\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010&\"\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010&\"\u0014\u0010-\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010&\"\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010&¨\u0006/"}, d2 = {BuildConfig.FLAVOR, "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodes", BuildConfig.FLAVOR, "args", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "addPathNodes", "(CLjava/util/ArrayList;[FI)V", BuildConfig.FLAVOR, "pathMoveNodeFromArgs", "(Ljava/util/List;[FI)V", "pathRelativeMoveNodeFromArgs", "RelativeCloseKey", "C", "CloseKey", "RelativeMoveToKey", "MoveToKey", "RelativeLineToKey", "LineToKey", "RelativeHorizontalToKey", "HorizontalToKey", "RelativeVerticalToKey", "VerticalToKey", "RelativeCurveToKey", "CurveToKey", "RelativeReflectiveCurveToKey", "ReflectiveCurveToKey", "RelativeQuadToKey", "QuadToKey", "RelativeReflectiveQuadToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "ArcToKey", "NUM_MOVE_TO_ARGS", "I", "NUM_LINE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "NUM_CURVE_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_ARC_TO_ARGS", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char c5, ArrayList<PathNode> arrayList, float[] fArr, int i5) {
        if (c5 == 'z' || c5 == 'Z') {
            arrayList.add(PathNode.Close.INSTANCE);
            return;
        }
        if (c5 == 'm') {
            pathRelativeMoveNodeFromArgs(arrayList, fArr, i5);
            return;
        }
        if (c5 == 'M') {
            pathMoveNodeFromArgs(arrayList, fArr, i5);
            return;
        }
        int i6 = 0;
        if (c5 == 'l') {
            int i7 = i5 - 2;
            while (i6 <= i7) {
                arrayList.add(new PathNode.RelativeLineTo(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'L') {
            int i8 = i5 - 2;
            while (i6 <= i8) {
                arrayList.add(new PathNode.LineTo(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'h') {
            int i9 = i5 - 1;
            while (i6 <= i9) {
                arrayList.add(new PathNode.RelativeHorizontalTo(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'H') {
            int i10 = i5 - 1;
            while (i6 <= i10) {
                arrayList.add(new PathNode.HorizontalTo(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'v') {
            int i11 = i5 - 1;
            while (i6 <= i11) {
                arrayList.add(new PathNode.RelativeVerticalTo(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'V') {
            int i12 = i5 - 1;
            while (i6 <= i12) {
                arrayList.add(new PathNode.VerticalTo(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'c') {
            int i13 = i5 - 6;
            while (i6 <= i13) {
                arrayList.add(new PathNode.RelativeCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                i6 += 6;
            }
            return;
        }
        if (c5 == 'C') {
            int i14 = i5 - 6;
            while (i6 <= i14) {
                arrayList.add(new PathNode.CurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                i6 += 6;
            }
            return;
        }
        if (c5 == 's') {
            int i15 = i5 - 4;
            while (i6 <= i15) {
                arrayList.add(new PathNode.RelativeReflectiveCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'S') {
            int i16 = i5 - 4;
            while (i6 <= i16) {
                arrayList.add(new PathNode.ReflectiveCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'q') {
            int i17 = i5 - 4;
            while (i6 <= i17) {
                arrayList.add(new PathNode.RelativeQuadTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'Q') {
            int i18 = i5 - 4;
            while (i6 <= i18) {
                arrayList.add(new PathNode.QuadTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 't') {
            int i19 = i5 - 2;
            while (i6 <= i19) {
                arrayList.add(new PathNode.RelativeReflectiveQuadTo(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'T') {
            int i20 = i5 - 2;
            while (i6 <= i20) {
                arrayList.add(new PathNode.ReflectiveQuadTo(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'a') {
            int i21 = i5 - 7;
            for (int i22 = 0; i22 <= i21; i22 += 7) {
                arrayList.add(new PathNode.RelativeArcTo(fArr[i22], fArr[i22 + 1], fArr[i22 + 2], Float.compare(fArr[i22 + 3], 0.0f) != 0, Float.compare(fArr[i22 + 4], 0.0f) != 0, fArr[i22 + 5], fArr[i22 + 6]));
            }
            return;
        }
        if (c5 != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c5);
        }
        int i23 = i5 - 7;
        for (int i24 = 0; i24 <= i23; i24 += 7) {
            arrayList.add(new PathNode.ArcTo(fArr[i24], fArr[i24 + 1], fArr[i24 + 2], Float.compare(fArr[i24 + 3], 0.0f) != 0, Float.compare(fArr[i24 + 4], 0.0f) != 0, fArr[i24 + 5], fArr[i24 + 6]));
        }
    }

    private static final void pathMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i5) {
        int i6 = i5 - 2;
        if (i6 >= 0) {
            list.add(new PathNode.MoveTo(fArr[0], fArr[1]));
            for (int i7 = 2; i7 <= i6; i7 += 2) {
                list.add(new PathNode.LineTo(fArr[i7], fArr[i7 + 1]));
            }
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i5) {
        int i6 = i5 - 2;
        if (i6 >= 0) {
            list.add(new PathNode.RelativeMoveTo(fArr[0], fArr[1]));
            for (int i7 = 2; i7 <= i6; i7 += 2) {
                list.add(new PathNode.RelativeLineTo(fArr[i7], fArr[i7 + 1]));
            }
        }
    }
}
