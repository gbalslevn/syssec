package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState;", BuildConfig.FLAVOR, "initialStatus", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;)V", "<set-?>", "status", "getStatus", "()Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "setStatus", "status$delegate", "Landroidx/compose/runtime/MutableState;", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Status", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuState {

    /* renamed from: status$delegate, reason: from kotlin metadata */
    private final MutableState status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", BuildConfig.FLAVOR, "()V", "Closed", "Open", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class Status {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "()V", "toString", BuildConfig.FLAVOR, "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Closed extends Status {
            public static final Closed INSTANCE = new Closed();

            private Closed() {
                super(null);
            }

            public String toString() {
                return "Closed";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "offset", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOffset-F1C5BW0", "()J", "J", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Open extends Status {
            private final long offset;

            public /* synthetic */ Open(long j5, DefaultConstructorMarker defaultConstructorMarker) {
                this(j5);
            }

            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if (other instanceof Open) {
                    return Offset.m1334equalsimpl0(this.offset, ((Open) other).offset);
                }
                return false;
            }

            /* renamed from: getOffset-F1C5BW0, reason: not valid java name and from getter */
            public final long getOffset() {
                return this.offset;
            }

            public int hashCode() {
                return Offset.m1339hashCodeimpl(this.offset);
            }

            public String toString() {
                return "Open(offset=" + ((Object) Offset.m1344toStringimpl(this.offset)) + ')';
            }

            private Open(long j5) {
                super(null);
                this.offset = j5;
                if (!OffsetKt.m1351isSpecifiedk4lQ0M(j5)) {
                    throw new IllegalStateException("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
                }
            }
        }

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Status() {
        }
    }

    public ContextMenuState(Status status) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(status, null, 2, null);
        this.status = mutableStateOf$default;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ContextMenuState) {
            return Intrinsics.areEqual(((ContextMenuState) other).getStatus(), getStatus());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Status getStatus() {
        return (Status) this.status.getValue();
    }

    public int hashCode() {
        return getStatus().hashCode();
    }

    public final void setStatus(Status status) {
        this.status.setValue(status);
    }

    public String toString() {
        return "ContextMenuState(status=" + getStatus() + ')';
    }

    public /* synthetic */ ContextMenuState(Status status, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? Status.Closed.INSTANCE : status);
    }
}
