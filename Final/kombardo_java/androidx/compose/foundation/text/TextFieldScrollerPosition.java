package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \b\u0001\u0018\u0000 52\u00020\u0001:\u00015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R+\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010&\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010)\u001a\u00020\u00168\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u0010\b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/Orientation;", "initialOrientation", BuildConfig.FLAVOR, "initial", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "orientation", "Landroidx/compose/ui/geometry/Rect;", "cursorRect", BuildConfig.FLAVOR, "containerSize", "textFieldSize", BuildConfig.FLAVOR, "update", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/geometry/Rect;II)V", "cursorStart", "cursorEnd", "coerceOffset$foundation_release", "(FFI)V", "coerceOffset", "Landroidx/compose/ui/text/TextRange;", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "getOffsetToFollow", "<set-?>", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getOffset", "()F", "setOffset", "(F)V", "offset", "maximum$delegate", "getMaximum", "setMaximum", "maximum", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "J", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldScrollerPosition {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, TextFieldScrollerPosition, List<? extends Object>>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Object> invoke(SaverScope saverScope, TextFieldScrollerPosition textFieldScrollerPosition) {
            return CollectionsKt.listOf(Float.valueOf(textFieldScrollerPosition.getOffset()), Boolean.valueOf(textFieldScrollerPosition.getOrientation() == Orientation.Vertical));
        }
    }, new Function1<List<? extends Object>, TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldScrollerPosition invoke(List<? extends Object> list) {
            Object obj = list.get(1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            Orientation orientation = ((Boolean) obj).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
        }
    });

    /* renamed from: maximum$delegate, reason: from kotlin metadata */
    private final MutableFloatState maximum;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;

    /* renamed from: orientation$delegate, reason: from kotlin metadata */
    private final MutableState orientation;
    private Rect previousCursorRect;
    private long previousSelection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", BuildConfig.FLAVOR, "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }

        private Companion() {
        }
    }

    public TextFieldScrollerPosition(Orientation orientation, float f5) {
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f5);
        this.maximum = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.previousCursorRect = Rect.INSTANCE.getZero();
        this.previousSelection = TextRange.INSTANCE.m2290getZerod9O1mEE();
        this.orientation = SnapshotStateKt.mutableStateOf(orientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    private final void setMaximum(float f5) {
        this.maximum.setFloatValue(f5);
    }

    public final void coerceOffset$foundation_release(float cursorStart, float cursorEnd, int containerSize) {
        float offset = getOffset();
        float f5 = containerSize;
        float f6 = offset + f5;
        setOffset(getOffset() + ((cursorEnd <= f6 && (cursorStart >= offset || cursorEnd - cursorStart <= f5)) ? (cursorStart >= offset || cursorEnd - cursorStart > f5) ? 0.0f : cursorStart - offset : cursorEnd - f6));
    }

    public final float getMaximum() {
        return this.maximum.getFloatValue();
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    /* renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m544getOffsetToFollow5zctL8(long selection) {
        return TextRange.m2285getStartimpl(selection) != TextRange.m2285getStartimpl(this.previousSelection) ? TextRange.m2285getStartimpl(selection) : TextRange.m2280getEndimpl(selection) != TextRange.m2280getEndimpl(this.previousSelection) ? TextRange.m2280getEndimpl(selection) : TextRange.m2283getMinimpl(selection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Orientation getOrientation() {
        return (Orientation) this.orientation.getValue();
    }

    public final void setOffset(float f5) {
        this.offset.setFloatValue(f5);
    }

    /* renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m545setPreviousSelection5zctL8(long j5) {
        this.previousSelection = j5;
    }

    public final void update(Orientation orientation, Rect cursorRect, int containerSize, int textFieldSize) {
        float f5 = textFieldSize - containerSize;
        setMaximum(f5);
        if (cursorRect.getLeft() != this.previousCursorRect.getLeft() || cursorRect.getTop() != this.previousCursorRect.getTop()) {
            boolean z5 = orientation == Orientation.Vertical;
            coerceOffset$foundation_release(z5 ? cursorRect.getTop() : cursorRect.getLeft(), z5 ? cursorRect.getBottom() : cursorRect.getRight(), containerSize);
            this.previousCursorRect = cursorRect;
        }
        setOffset(RangesKt.coerceIn(getOffset(), 0.0f, f5));
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, (i5 & 2) != 0 ? 0.0f : f5);
    }
}
