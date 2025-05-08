package dk.molslinjen.core.migration.oldApp;

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
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "date", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalTime;", "time", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILdk/molslinjen/core/migration/oldApp/OldAppLocalDate;Ldk/molslinjen/core/migration/oldApp/OldAppLocalTime;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lorg/threeten/bp/LocalDateTime;", "toLocalDateTime", "()Lorg/threeten/bp/LocalDateTime;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "getDate", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalTime;", "getTime", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalTime;", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldAppLocalDateTime {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OldAppLocalDate date;
    private final OldAppLocalTime time;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldAppLocalDateTime> serializer() {
            return OldAppLocalDateTime$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldAppLocalDateTime(int i5, OldAppLocalDate oldAppLocalDate, OldAppLocalTime oldAppLocalTime, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, OldAppLocalDateTime$$serializer.INSTANCE.getDescriptor());
        }
        this.date = oldAppLocalDate;
        this.time = oldAppLocalTime;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppLocalDateTime self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, OldAppLocalDate$$serializer.INSTANCE, self.date);
        output.encodeSerializableElement(serialDesc, 1, OldAppLocalTime$$serializer.INSTANCE, self.time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldAppLocalDateTime)) {
            return false;
        }
        OldAppLocalDateTime oldAppLocalDateTime = (OldAppLocalDateTime) other;
        return Intrinsics.areEqual(this.date, oldAppLocalDateTime.date) && Intrinsics.areEqual(this.time, oldAppLocalDateTime.time);
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.time.hashCode();
    }

    public final LocalDateTime toLocalDateTime() {
        LocalDateTime of = LocalDateTime.of(this.date.toLocalDate(), this.time.toLocalTime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public String toString() {
        return "OldAppLocalDateTime(date=" + this.date + ", time=" + this.time + ")";
    }
}
