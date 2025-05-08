package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", BuildConfig.FLAVOR, "charges", BuildConfig.FLAVOR, "remainingDuration", "Lorg/threeten/bp/Duration;", "<init>", "(ILorg/threeten/bp/Duration;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILorg/threeten/bp/Duration;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCharges", "()I", "getRemainingDuration$annotations", "()V", "daysLeft", "getDaysLeft", "expiryDate", "Lorg/threeten/bp/LocalDate;", "getExpiryDate", "()Lorg/threeten/bp/LocalDate;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideChargesExpiry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRideChargesExpiry mock;
    private final int charges;
    private final Duration remainingDuration;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideChargesExpiry getMock() {
            return MultiRideChargesExpiry.mock;
        }

        public final KSerializer<MultiRideChargesExpiry> serializer() {
            return MultiRideChargesExpiry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Duration ofDays = Duration.ofDays(80L);
        Intrinsics.checkNotNullExpressionValue(ofDays, "ofDays(...)");
        mock = new MultiRideChargesExpiry(10, ofDays);
    }

    public /* synthetic */ MultiRideChargesExpiry(int i5, int i6, Duration duration, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, MultiRideChargesExpiry$$serializer.INSTANCE.getDescriptor());
        }
        this.charges = i6;
        this.remainingDuration = duration;
    }

    /* renamed from: component2, reason: from getter */
    private final Duration getRemainingDuration() {
        return this.remainingDuration;
    }

    public static /* synthetic */ MultiRideChargesExpiry copy$default(MultiRideChargesExpiry multiRideChargesExpiry, int i5, Duration duration, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = multiRideChargesExpiry.charges;
        }
        if ((i6 & 2) != 0) {
            duration = multiRideChargesExpiry.remainingDuration;
        }
        return multiRideChargesExpiry.copy(i5, duration);
    }

    @Serializable(with = DurationSerializer.class)
    private static /* synthetic */ void getRemainingDuration$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(MultiRideChargesExpiry self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.charges);
        output.encodeSerializableElement(serialDesc, 1, DurationSerializer.INSTANCE, self.remainingDuration);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCharges() {
        return this.charges;
    }

    public final MultiRideChargesExpiry copy(int charges, Duration remainingDuration) {
        Intrinsics.checkNotNullParameter(remainingDuration, "remainingDuration");
        return new MultiRideChargesExpiry(charges, remainingDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideChargesExpiry)) {
            return false;
        }
        MultiRideChargesExpiry multiRideChargesExpiry = (MultiRideChargesExpiry) other;
        return this.charges == multiRideChargesExpiry.charges && Intrinsics.areEqual(this.remainingDuration, multiRideChargesExpiry.remainingDuration);
    }

    public final int getCharges() {
        return this.charges;
    }

    public final int getDaysLeft() {
        return (int) this.remainingDuration.toDays();
    }

    public final LocalDate getExpiryDate() {
        LocalDate localDate = LocalDateTime.now().plus(this.remainingDuration).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return localDate;
    }

    public int hashCode() {
        return (Integer.hashCode(this.charges) * 31) + this.remainingDuration.hashCode();
    }

    public String toString() {
        return "MultiRideChargesExpiry(charges=" + this.charges + ", remainingDuration=" + this.remainingDuration + ")";
    }

    public MultiRideChargesExpiry(int i5, Duration remainingDuration) {
        Intrinsics.checkNotNullParameter(remainingDuration, "remainingDuration");
        this.charges = i5;
        this.remainingDuration = remainingDuration;
    }
}
