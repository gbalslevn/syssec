package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.conscrypt.BuildConfig;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public static final TemporalQuery<MonthDay> FROM = new TemporalQuery<MonthDay>() { // from class: org.threeten.bp.MonthDay.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public MonthDay queryFrom(TemporalAccessor temporalAccessor) {
            return MonthDay.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.MonthDay$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MonthDay(int i5, int i6) {
        this.month = i5;
        this.day = i6;
    }

    public static MonthDay from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.MONTH_OF_YEAR), temporalAccessor.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static MonthDay of(Month month, int i5) {
        Jdk8Methods.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i5);
        if (i5 <= month.maxLength()) {
            return new MonthDay(month.getValue(), i5);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i5 + " is not valid for month " + month.name());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MonthDay readExternal(DataInput dataInput) {
        return of(dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (!Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        Temporal with = temporal.with(ChronoField.MONTH_OF_YEAR, this.month);
        ChronoField chronoField = ChronoField.DAY_OF_MONTH;
        return with.with(chronoField, Math.min(with.range(chronoField).getMaximum(), this.day));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.month == monthDay.month && this.day == monthDay.day;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i5;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i6 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i6 == 1) {
            i5 = this.day;
        } else {
            if (i6 != 2) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i5 = this.month;
        }
        return i5;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.chronology() ? (R) IsoChronology.INSTANCE : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? temporalField.range() : temporalField == ChronoField.DAY_OF_MONTH ? ValueRange.of(1L, getMonth().minLength(), getMonth().maxLength()) : super.range(temporalField);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.month < 10 ? "0" : BuildConfig.FLAVOR);
        sb.append(this.month);
        sb.append(this.day < 10 ? "-0" : "-");
        sb.append(this.day);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    @Override // java.lang.Comparable
    public int compareTo(MonthDay monthDay) {
        int i5 = this.month - monthDay.month;
        return i5 == 0 ? this.day - monthDay.day : i5;
    }

    public static MonthDay of(int i5, int i6) {
        return of(Month.of(i5), i6);
    }
}
