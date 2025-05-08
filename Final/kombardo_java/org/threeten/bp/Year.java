package org.threeten.bp;

import com.adjust.sdk.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final TemporalQuery<Year> FROM = new TemporalQuery<Year>() { // from class: org.threeten.bp.Year.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Year queryFrom(TemporalAccessor temporalAccessor) {
            return Year.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.Year$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.YEAR_OF_ERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Year(int i5) {
        this.year = i5;
    }

    public static Year from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Year) {
            return (Year) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static boolean isLeap(long j5) {
        return (3 & j5) == 0 && (j5 % 100 != 0 || j5 % 400 == 0);
    }

    public static Year of(int i5) {
        ChronoField.YEAR.checkValidValue(i5);
        return new Year(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Year readExternal(DataInput dataInput) {
        return of(dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.YEAR, this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.year == ((Year) obj).year;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i5 == 1) {
            int i6 = this.year;
            if (i6 < 1) {
                i6 = 1 - i6;
            }
            return i6;
        }
        if (i5 == 2) {
            return this.year;
        }
        if (i5 == 3) {
            return this.year < 1 ? 0 : 1;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int hashCode() {
        return this.year;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    public Year plusYears(long j5) {
        return j5 == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(this.year + j5));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.YEARS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, this.year <= 0 ? 1000000000L : 999999999L);
        }
        return super.range(temporalField);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Year from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long j5 = from.year - this.year;
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
        if (i5 == 1) {
            return j5;
        }
        if (i5 == 2) {
            return j5 / 10;
        }
        if (i5 == 3) {
            return j5 / 100;
        }
        if (i5 == 4) {
            return j5 / 1000;
        }
        if (i5 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return from.getLong(chronoField) - getLong(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
    }

    @Override // java.lang.Comparable
    public int compareTo(Year year) {
        return this.year - year.year;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(long j5, TemporalUnit temporalUnit) {
        return j5 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j5, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long j5, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
            if (i5 == 1) {
                return plusYears(j5);
            }
            if (i5 == 2) {
                return plusYears(Jdk8Methods.safeMultiply(j5, 10));
            }
            if (i5 == 3) {
                return plusYears(Jdk8Methods.safeMultiply(j5, 100));
            }
            if (i5 == 4) {
                return plusYears(Jdk8Methods.safeMultiply(j5, Constants.ONE_SECOND));
            }
            if (i5 == 5) {
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j5));
            }
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (Year) temporalUnit.addTo(this, j5);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalAdjuster temporalAdjuster) {
        return (Year) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField temporalField, long j5) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j5);
            int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i5 == 1) {
                if (this.year < 1) {
                    j5 = 1 - j5;
                }
                return of((int) j5);
            }
            if (i5 == 2) {
                return of((int) j5);
            }
            if (i5 == 3) {
                return getLong(ChronoField.ERA) == j5 ? this : of(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (Year) temporalField.adjustInto(this, j5);
    }
}
