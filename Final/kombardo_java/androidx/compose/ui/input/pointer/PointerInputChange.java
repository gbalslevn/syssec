package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014Bw\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJz\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0086\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b,\u0010+R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b-\u0010+R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b4\u0010+R\u001d\u0010\r\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b5\u0010+R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b6\u00100R\u001d\u0010\u0011\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u00107\u001a\u0004\b8\u00109R\u001d\u0010\u0012\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b:\u0010+R$\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u0010<\u0012\u0004\b=\u0010\u001cR(\u0010\u0018\u001a\u00020\u00068\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010@R*\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020A8\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u0012\u0004\bG\u0010\u001c\u001a\u0004\bE\u0010FR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u001c\u001a\u0004\bH\u0010IR\u0017\u0010K\u001a\u00020\b8F¢\u0006\f\u0012\u0004\bL\u0010\u001c\u001a\u0004\bK\u00100\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerId;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "uptimeMillis", "Landroidx/compose/ui/geometry/Offset;", "position", BuildConfig.FLAVOR, "pressed", BuildConfig.FLAVOR, "pressure", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "Landroidx/compose/ui/input/pointer/PointerType;", "type", "scrollDelta", "<init>", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/HistoricalChange;", "historical", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "consume", "()V", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "J", "getId-J3iCeTQ", "()J", "getUptimeMillis", "getPosition-F1C5BW0", "Z", "getPressed", "()Z", "F", "getPressure", "()F", "getPreviousUptimeMillis", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "I", "getType-T8wyACA", "()I", "getScrollDelta-F1C5BW0", "_historical", "Ljava/util/List;", "get_historical$annotations", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "Landroidx/compose/ui/input/pointer/ConsumedData;", "<set-?>", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getConsumed$annotations", "getHistorical", "()Ljava/util/List;", "getHistorical$annotations", "isConsumed", "isConsumed$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputChange {
    private List<HistoricalChange> _historical;
    private ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j5, long j6, long j7, boolean z5, float f5, long j8, long j9, boolean z6, boolean z7, int i5, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, z5, f5, j8, j9, z6, z7, i5, j10);
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    /* renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m1877copyOHpmEuE(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        return m1878copywbzehF4(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, type, historical, scrollDelta);
    }

    /* renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m1878copywbzehF4(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, historical, scrollDelta, this.originalEventPosition, null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPreviousPosition() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m1874toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m1344toStringimpl(this.position)) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m1344toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.m1906toStringimpl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m1344toStringimpl(this.scrollDelta)) + ')';
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j7, boolean z5, float f5, long j8, long j9, boolean z6, boolean z7, int i5, List list, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, z5, f5, j8, j9, z6, z7, i5, (List<HistoricalChange>) list, j10, j11);
    }

    private PointerInputChange(long j5, long j6, long j7, boolean z5, float f5, long j8, long j9, boolean z6, boolean z7, int i5, long j10) {
        this.id = j5;
        this.uptimeMillis = j6;
        this.position = j7;
        this.pressed = z5;
        this.pressure = f5;
        this.previousUptimeMillis = j8;
        this.previousPosition = j9;
        this.previousPressed = z6;
        this.type = i5;
        this.scrollDelta = j10;
        this.originalEventPosition = Offset.INSTANCE.m1349getZeroF1C5BW0();
        this.consumed = new ConsumedData(z7, z7);
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j7, boolean z5, float f5, long j8, long j9, boolean z6, boolean z7, int i5, long j10, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, z5, f5, j8, j9, z6, z7, (i6 & 512) != 0 ? PointerType.INSTANCE.m1910getTouchT8wyACA() : i5, (i6 & 1024) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j10, null);
    }

    private PointerInputChange(long j5, long j6, long j7, boolean z5, float f5, long j8, long j9, boolean z6, boolean z7, int i5, List<HistoricalChange> list, long j10, long j11) {
        this(j5, j6, j7, z5, f5, j8, j9, z6, z7, i5, j10, null);
        this._historical = list;
        this.originalEventPosition = j11;
    }
}
