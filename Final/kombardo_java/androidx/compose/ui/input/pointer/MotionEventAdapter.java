package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ/\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\u00020%8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u0003\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/view/MotionEvent;", "motionEvent", BuildConfig.FLAVOR, "addFreshIds", "(Landroid/view/MotionEvent;)V", "removeStaleIds", BuildConfig.FLAVOR, "pointerId", BuildConfig.FLAVOR, "hasPointerId", "(Landroid/view/MotionEvent;I)Z", "motionEventPointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "getComposePointerId-_I2yYro", "(I)J", "getComposePointerId", "clearOnDeviceChange", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "positionCalculator", "index", "pressed", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "createPointerInputEventData", "(Landroidx/compose/ui/input/pointer/PositionCalculator;Landroid/view/MotionEvent;IZ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "convertToPointerInputEvent$ui_release", "(Landroid/view/MotionEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;)Landroidx/compose/ui/input/pointer/PointerInputEvent;", "convertToPointerInputEvent", "endStream", "(I)V", BuildConfig.FLAVOR, "nextId", "J", "Landroid/util/SparseLongArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "Landroid/util/SparseBooleanArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", BuildConfig.FLAVOR, "pointers", "Ljava/util/List;", "previousToolType", "I", "previousSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MotionEventAdapter {
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousToolType = -1;
    private int previousSource = -1;

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j5 = this.nextId;
                this.nextId = 1 + j5;
                sparseLongArray.put(pointerId, j5);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j6 = this.nextId;
            this.nextId = 1 + j6;
            sparseLongArray2.put(pointerId2, j6);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        long j5;
        long mo1913localToScreenMKHz9U;
        long m1850toRawOffsetdBAh8RU;
        long mo1914screenToLocalMKHz9U;
        int historySize;
        int i5;
        long m1849getComposePointerId_I2yYro = m1849getComposePointerId_I2yYro(motionEvent.getPointerId(index));
        float pressure = motionEvent.getPressure(index);
        long Offset = OffsetKt.Offset(motionEvent.getX(index), motionEvent.getY(index));
        long m1331copydBAh8RU$default = Offset.m1331copydBAh8RU$default(Offset, 0.0f, 0.0f, 3, null);
        if (index == 0) {
            m1850toRawOffsetdBAh8RU = OffsetKt.Offset(motionEvent.getRawX(), motionEvent.getRawY());
            mo1914screenToLocalMKHz9U = positionCalculator.mo1914screenToLocalMKHz9U(m1850toRawOffsetdBAh8RU);
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                j5 = Offset;
                mo1913localToScreenMKHz9U = positionCalculator.mo1913localToScreenMKHz9U(Offset);
                int toolType = motionEvent.getToolType(index);
                int m1911getUnknownT8wyACA = toolType == 0 ? toolType != 1 ? toolType != 2 ? toolType != 3 ? toolType != 4 ? PointerType.INSTANCE.m1911getUnknownT8wyACA() : PointerType.INSTANCE.m1907getEraserT8wyACA() : PointerType.INSTANCE.m1908getMouseT8wyACA() : PointerType.INSTANCE.m1909getStylusT8wyACA() : PointerType.INSTANCE.m1910getTouchT8wyACA() : PointerType.INSTANCE.m1911getUnknownT8wyACA();
                ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
                historySize = motionEvent.getHistorySize();
                for (i5 = 0; i5 < historySize; i5++) {
                    float historicalX = motionEvent.getHistoricalX(index, i5);
                    float historicalY = motionEvent.getHistoricalY(index, i5);
                    if (!Float.isInfinite(historicalX) && !Float.isNaN(historicalX) && !Float.isInfinite(historicalY) && !Float.isNaN(historicalY)) {
                        long Offset2 = OffsetKt.Offset(historicalX, historicalY);
                        arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i5), Offset2, Offset2, null));
                    }
                }
                return new PointerInputEventData(m1849getComposePointerId_I2yYro, motionEvent.getEventTime(), mo1913localToScreenMKHz9U, j5, pressed, pressure, m1911getUnknownT8wyACA, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList, motionEvent.getActionMasked() != 8 ? OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f) : Offset.INSTANCE.m1349getZeroF1C5BW0(), m1331copydBAh8RU$default, null);
            }
            m1850toRawOffsetdBAh8RU = MotionEventHelper.INSTANCE.m1850toRawOffsetdBAh8RU(motionEvent, index);
            mo1914screenToLocalMKHz9U = positionCalculator.mo1914screenToLocalMKHz9U(m1850toRawOffsetdBAh8RU);
        }
        mo1913localToScreenMKHz9U = m1850toRawOffsetdBAh8RU;
        j5 = mo1914screenToLocalMKHz9U;
        int toolType2 = motionEvent.getToolType(index);
        int m1911getUnknownT8wyACA2 = toolType2 == 0 ? toolType2 != 1 ? toolType2 != 2 ? toolType2 != 3 ? toolType2 != 4 ? PointerType.INSTANCE.m1911getUnknownT8wyACA() : PointerType.INSTANCE.m1907getEraserT8wyACA() : PointerType.INSTANCE.m1908getMouseT8wyACA() : PointerType.INSTANCE.m1909getStylusT8wyACA() : PointerType.INSTANCE.m1910getTouchT8wyACA() : PointerType.INSTANCE.m1911getUnknownT8wyACA();
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        while (i5 < historySize) {
        }
        return new PointerInputEventData(m1849getComposePointerId_I2yYro, motionEvent.getEventTime(), mo1913localToScreenMKHz9U, j5, pressed, pressure, m1911getUnknownT8wyACA2, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList2, motionEvent.getActionMasked() != 8 ? OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f) : Offset.INSTANCE.m1349getZeroF1C5BW0(), m1331copydBAh8RU$default, null);
    }

    /* renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m1849getComposePointerId_I2yYro(int motionEventPointerId) {
        long j5;
        int indexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (indexOfKey >= 0) {
            j5 = this.motionEventToComposePointerIdMap.valueAt(indexOfKey);
        } else {
            j5 = this.nextId;
            this.nextId = 1 + j5;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, j5);
        }
        return PointerId.m1870constructorimpl(j5);
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i5) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (motionEvent.getPointerId(i6) == i5) {
                return true;
            }
        }
        return false;
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int keyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, keyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(keyAt);
                }
            }
        }
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z5 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z6 = actionMasked == 8;
        if (z5) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i5 = 0;
        while (i5 < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i5, (z5 || i5 == actionIndex || (z6 && motionEvent.getButtonState() == 0)) ? false : true));
            i5++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }
}
