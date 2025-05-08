package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,BY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0013\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020\u0013H\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b!\u0010\u001cR\u0019\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", BuildConfig.FLAVOR, "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", BuildConfig.FLAVOR, "genId", BuildConfig.FLAVOR, "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoMirror", "()Z", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getGenId$ui_release", "()I", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "other", "hashCode", "Builder", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageVector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int imageVectorCount;
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final int genId;
    private final String name;
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001MBO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0000¢\u0006\u0004\b%\u0010&J¤\u0001\u0010:\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\r\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u001a\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010?R\u001a\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010?R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010?R\u001a\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000b\u0010@R\u001a\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010AR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010BR$\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u00150Cj\b\u0012\u0004\u0012\u00020\u0015`D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010BR\u0014\u0010L\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "Landroidx/compose/ui/unit/Dp;", "defaultWidth", "defaultHeight", BuildConfig.FLAVOR, "viewportWidth", "viewportHeight", "Landroidx/compose/ui/graphics/Color;", "tintColor", "Landroidx/compose/ui/graphics/BlendMode;", "tintBlendMode", BuildConfig.FLAVOR, "autoMirror", "<init>", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "ensureNotConsumed", "()V", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "asVectorGroup", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;)Landroidx/compose/ui/graphics/vector/VectorGroup;", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "addGroup", "(Ljava/lang/String;FFFFFFFLjava/util/List;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "clearGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "pathData", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "Landroidx/compose/ui/graphics/Brush;", "fill", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "addPath", "Landroidx/compose/ui/graphics/vector/ImageVector;", "build", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Ljava/lang/String;", "F", "J", "I", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "nodes", "Ljava/util/ArrayList;", "root", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "isConsumed", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "currentGroup", "GroupParams", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList<GroupParams> nodes;
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        public /* synthetic */ Builder(String str, float f5, float f6, float f7, float f8, long j5, int i5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f5, f6, f7, f8, j5, i5, z5);
        }

        private final VectorGroup asVectorGroup(GroupParams groupParams) {
            return new VectorGroup(groupParams.getName(), groupParams.getRotate(), groupParams.getPivotX(), groupParams.getPivotY(), groupParams.getScaleX(), groupParams.getScaleY(), groupParams.getTranslationX(), groupParams.getTranslationY(), groupParams.getClipPathData(), groupParams.getChildren());
        }

        private final void ensureNotConsumed() {
            if (this.isConsumed) {
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final GroupParams getCurrentGroup() {
            Object peek;
            peek = ImageVectorKt.peek(this.nodes);
            return (GroupParams) peek;
        }

        public final Builder addGroup(String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData) {
            ensureNotConsumed();
            ImageVectorKt.push(this.nodes, new GroupParams(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData, null, 512, null));
            return this;
        }

        /* renamed from: addPath-oIyEayM, reason: not valid java name */
        public final Builder m1758addPathoIyEayM(List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(new VectorPath(name, pathData, pathFillType, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, trimPathStart, trimPathEnd, trimPathOffset, null));
            return this;
        }

        public final ImageVector build() {
            ensureNotConsumed();
            while (this.nodes.size() > 1) {
                clearGroup();
            }
            ImageVector imageVector = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, 0, 512, null);
            this.isConsumed = true;
            return imageVector;
        }

        public final Builder clearGroup() {
            Object pop;
            ensureNotConsumed();
            pop = ImageVectorKt.pop(this.nodes);
            getCurrentGroup().getChildren().add(asVectorGroup((GroupParams) pop));
            return this;
        }

        private Builder(String str, float f5, float f6, float f7, float f8, long j5, int i5, boolean z5) {
            this.name = str;
            this.defaultWidth = f5;
            this.defaultHeight = f6;
            this.viewportWidth = f7;
            this.viewportHeight = f8;
            this.tintColor = j5;
            this.tintBlendMode = i5;
            this.autoMirror = z5;
            ArrayList<GroupParams> arrayList = new ArrayList<>();
            this.nodes = arrayList;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.root = groupParams;
            ImageVectorKt.push(arrayList, groupParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b!\b\u0002\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.¨\u00061"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/vector/VectorNode;", "children", "<init>", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "F", "getRotate", "()F", "setRotate", "(F)V", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "Ljava/util/List;", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "getChildren", "setChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class GroupParams {
            private List<VectorNode> children;
            private List<? extends PathNode> clipPathData;
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams(String str, float f5, float f6, float f7, float f8, float f9, float f10, float f11, List<? extends PathNode> list, List<VectorNode> list2) {
                this.name = str;
                this.rotate = f5;
                this.pivotX = f6;
                this.pivotY = f7;
                this.scaleX = f8;
                this.scaleY = f9;
                this.translationX = f10;
                this.translationY = f11;
                this.clipPathData = list;
                this.children = list2;
            }

            public final List<VectorNode> getChildren() {
                return this.children;
            }

            public final List<PathNode> getClipPathData() {
                return this.clipPathData;
            }

            public final String getName() {
                return this.name;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public /* synthetic */ GroupParams(String str, float f5, float f6, float f7, float f8, float f9, float f10, float f11, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? 0.0f : f5, (i5 & 4) != 0 ? 0.0f : f6, (i5 & 8) != 0 ? 0.0f : f7, (i5 & 16) != 0 ? 1.0f : f8, (i5 & 32) == 0 ? f9 : 1.0f, (i5 & 64) != 0 ? 0.0f : f10, (i5 & 128) == 0 ? f11 : 0.0f, (i5 & 256) != 0 ? VectorKt.getEmptyPath() : list, (i5 & 512) != 0 ? new ArrayList() : list2);
            }
        }

        public /* synthetic */ Builder(String str, float f5, float f6, float f7, float f8, long j5, int i5, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? BuildConfig.FLAVOR : str, f5, f6, f7, f8, (i6 & 32) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5, (i6 & 64) != 0 ? BlendMode.INSTANCE.m1457getSrcIn0nO6VwU() : i5, (i6 & 128) != 0 ? false : z5, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", BuildConfig.FLAVOR, "()V", "imageVectorCount", BuildConfig.FLAVOR, "generateImageVectorId", "generateImageVectorId$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int generateImageVectorId$ui_release() {
            int i5;
            synchronized (this) {
                i5 = ImageVector.imageVectorCount;
                ImageVector.imageVectorCount = i5 + 1;
            }
            return i5;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImageVector(String str, float f5, float f6, float f7, float f8, VectorGroup vectorGroup, long j5, int i5, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f5, f6, f7, f8, vectorGroup, j5, i5, z5, i6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) other;
        return Intrinsics.areEqual(this.name, imageVector.name) && Dp.m2601equalsimpl0(this.defaultWidth, imageVector.defaultWidth) && Dp.m2601equalsimpl0(this.defaultHeight, imageVector.defaultHeight) && this.viewportWidth == imageVector.viewportWidth && this.viewportHeight == imageVector.viewportHeight && Intrinsics.areEqual(this.root, imageVector.root) && Color.m1487equalsimpl0(this.tintColor, imageVector.tintColor) && BlendMode.m1429equalsimpl0(this.tintBlendMode, imageVector.tintBlendMode) && this.autoMirror == imageVector.autoMirror;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* renamed from: getDefaultHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultHeight() {
        return this.defaultHeight;
    }

    /* renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultWidth() {
        return this.defaultWidth;
    }

    /* renamed from: getGenId$ui_release, reason: from getter */
    public final int getGenId() {
        return this.genId;
    }

    public final String getName() {
        return this.name;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    /* renamed from: getTintBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getTintBlendMode() {
        return this.tintBlendMode;
    }

    /* renamed from: getTintColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintColor() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return (((((((((((((((this.name.hashCode() * 31) + Dp.m2602hashCodeimpl(this.defaultWidth)) * 31) + Dp.m2602hashCodeimpl(this.defaultHeight)) * 31) + Float.hashCode(this.viewportWidth)) * 31) + Float.hashCode(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m1493hashCodeimpl(this.tintColor)) * 31) + BlendMode.m1430hashCodeimpl(this.tintBlendMode)) * 31) + Boolean.hashCode(this.autoMirror);
    }

    private ImageVector(String str, float f5, float f6, float f7, float f8, VectorGroup vectorGroup, long j5, int i5, boolean z5, int i6) {
        this.name = str;
        this.defaultWidth = f5;
        this.defaultHeight = f6;
        this.viewportWidth = f7;
        this.viewportHeight = f8;
        this.root = vectorGroup;
        this.tintColor = j5;
        this.tintBlendMode = i5;
        this.autoMirror = z5;
        this.genId = i6;
    }

    public /* synthetic */ ImageVector(String str, float f5, float f6, float f7, float f8, VectorGroup vectorGroup, long j5, int i5, boolean z5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f5, f6, f7, f8, vectorGroup, j5, i5, z5, (i7 & 512) != 0 ? INSTANCE.generateImageVectorId$ui_release() : i6, null);
    }
}
