package dk.molslinjen.ui.views.screens.booking.ticketType;

import dk.molslinjen.domain.model.config.Harbor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u0007\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\b\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\t\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/HarborStep;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/Step;", "Ldk/molslinjen/domain/model/config/Harbor;", "harbor", "Lorg/threeten/bp/LocalTime;", "time", BuildConfig.FLAVOR, "isNextStepFerry", "isPreviousStepNotFerry", "isLast", "<init>", "(Ldk/molslinjen/domain/model/config/Harbor;Lorg/threeten/bp/LocalTime;ZZZ)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Harbor;", "getHarbor", "()Ldk/molslinjen/domain/model/config/Harbor;", "Lorg/threeten/bp/LocalTime;", "getTime", "()Lorg/threeten/bp/LocalTime;", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HarborStep implements Step {
    private final Harbor harbor;
    private final boolean isLast;
    private final boolean isNextStepFerry;
    private final boolean isPreviousStepNotFerry;
    private final LocalTime time;

    public HarborStep(Harbor harbor, LocalTime time, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(harbor, "harbor");
        Intrinsics.checkNotNullParameter(time, "time");
        this.harbor = harbor;
        this.time = time;
        this.isNextStepFerry = z5;
        this.isPreviousStepNotFerry = z6;
        this.isLast = z7;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HarborStep)) {
            return false;
        }
        HarborStep harborStep = (HarborStep) other;
        return Intrinsics.areEqual(this.harbor, harborStep.harbor) && Intrinsics.areEqual(this.time, harborStep.time) && this.isNextStepFerry == harborStep.isNextStepFerry && this.isPreviousStepNotFerry == harborStep.isPreviousStepNotFerry && this.isLast == harborStep.isLast;
    }

    public final Harbor getHarbor() {
        return this.harbor;
    }

    public final LocalTime getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((this.harbor.hashCode() * 31) + this.time.hashCode()) * 31) + Boolean.hashCode(this.isNextStepFerry)) * 31) + Boolean.hashCode(this.isPreviousStepNotFerry)) * 31) + Boolean.hashCode(this.isLast);
    }

    /* renamed from: isLast, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    /* renamed from: isNextStepFerry, reason: from getter */
    public final boolean getIsNextStepFerry() {
        return this.isNextStepFerry;
    }

    /* renamed from: isPreviousStepNotFerry, reason: from getter */
    public final boolean getIsPreviousStepNotFerry() {
        return this.isPreviousStepNotFerry;
    }

    public String toString() {
        return "HarborStep(harbor=" + this.harbor + ", time=" + this.time + ", isNextStepFerry=" + this.isNextStepFerry + ", isPreviousStepNotFerry=" + this.isPreviousStepNotFerry + ", isLast=" + this.isLast + ")";
    }

    public /* synthetic */ HarborStep(Harbor harbor, LocalTime localTime, boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(harbor, localTime, (i5 & 4) != 0 ? false : z5, (i5 & 8) != 0 ? false : z6, (i5 & 16) != 0 ? false : z7);
    }
}
