package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0080\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\"R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b$\u0010\"R\u001d\u0010\b\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b%\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010\u000e\u001a\u00020\r8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b-\u0010\u001cR\u0017\u0010\u000f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b.\u0010(R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u00101R\u001d\u0010\u0013\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b2\u0010\"R\u001d\u0010\u0014\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b3\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerId;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "uptime", "Landroidx/compose/ui/geometry/Offset;", "positionOnScreen", "position", BuildConfig.FLAVOR, "down", BuildConfig.FLAVOR, "pressure", "Landroidx/compose/ui/input/pointer/PointerType;", "type", "activeHover", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/HistoricalChange;", "historical", "scrollDelta", "originalEventPosition", "<init>", "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getId-J3iCeTQ", "()J", "getUptime", "getPositionOnScreen-F1C5BW0", "getPosition-F1C5BW0", "Z", "getDown", "()Z", "F", "getPressure", "()F", "I", "getType-T8wyACA", "getActiveHover", "Ljava/util/List;", "getHistorical", "()Ljava/util/List;", "getScrollDelta-F1C5BW0", "getOriginalEventPosition-F1C5BW0", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PointerInputEventData {
    private final boolean activeHover;
    private final boolean down;
    private final List<HistoricalChange> historical;
    private final long id;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j5, long j6, long j7, long j8, boolean z5, float f5, int i5, boolean z6, List list, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, z5, f5, i5, z6, list, j9, j10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) other;
        return PointerId.m1872equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m1334equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m1334equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && PointerType.m1904equalsimpl0(this.type, pointerInputEventData.type) && this.activeHover == pointerInputEventData.activeHover && Intrinsics.areEqual(this.historical, pointerInputEventData.historical) && Offset.m1334equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta) && Offset.m1334equalsimpl0(this.originalEventPosition, pointerInputEventData.originalEventPosition);
    }

    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name and from getter */
    public final long getPositionOnScreen() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    public int hashCode() {
        return (((((((((((((((((((PointerId.m1873hashCodeimpl(this.id) * 31) + Long.hashCode(this.uptime)) * 31) + Offset.m1339hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m1339hashCodeimpl(this.position)) * 31) + Boolean.hashCode(this.down)) * 31) + Float.hashCode(this.pressure)) * 31) + PointerType.m1905hashCodeimpl(this.type)) * 31) + Boolean.hashCode(this.activeHover)) * 31) + this.historical.hashCode()) * 31) + Offset.m1339hashCodeimpl(this.scrollDelta)) * 31) + Offset.m1339hashCodeimpl(this.originalEventPosition);
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) PointerId.m1874toStringimpl(this.id)) + ", uptime=" + this.uptime + ", positionOnScreen=" + ((Object) Offset.m1344toStringimpl(this.positionOnScreen)) + ", position=" + ((Object) Offset.m1344toStringimpl(this.position)) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + ((Object) PointerType.m1906toStringimpl(this.type)) + ", activeHover=" + this.activeHover + ", historical=" + this.historical + ", scrollDelta=" + ((Object) Offset.m1344toStringimpl(this.scrollDelta)) + ", originalEventPosition=" + ((Object) Offset.m1344toStringimpl(this.originalEventPosition)) + ')';
    }

    private PointerInputEventData(long j5, long j6, long j7, long j8, boolean z5, float f5, int i5, boolean z6, List<HistoricalChange> list, long j9, long j10) {
        this.id = j5;
        this.uptime = j6;
        this.positionOnScreen = j7;
        this.position = j8;
        this.down = z5;
        this.pressure = f5;
        this.type = i5;
        this.activeHover = z6;
        this.historical = list;
        this.scrollDelta = j9;
        this.originalEventPosition = j10;
    }
}
