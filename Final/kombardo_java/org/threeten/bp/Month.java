package org.threeten.bp;

import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes3.dex */
public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static final TemporalQuery<Month> FROM = new TemporalQuery<Month>() { // from class: org.threeten.bp.Month.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Month queryFrom(TemporalAccessor temporalAccessor) {
            return Month.from(temporalAccessor);
        }
    };
    private static final Month[] ENUMS = values();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.Month$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$Month;

        static {
            int[] iArr = new int[Month.values().length];
            $SwitchMap$org$threeten$bp$Month = iArr;
            try {
                iArr[Month.FEBRUARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.APRIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.JUNE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.SEPTEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.NOVEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.JANUARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.MARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.MAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.JULY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.AUGUST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.OCTOBER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$Month[Month.DECEMBER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Month from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Month) {
            return (Month) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException e5) {
            throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e5);
        }
    }

    public static Month of(int i5) {
        if (i5 >= 1 && i5 <= 12) {
            return ENUMS[i5 - 1];
        }
        throw new DateTimeException("Invalid value for MonthOfYear: " + i5);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.MONTH_OF_YEAR, getValue());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public int firstDayOfYear(boolean z5) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z5 ? 1 : 0) + 91;
            case 3:
                return (z5 ? 1 : 0) + 152;
            case 4:
                return (z5 ? 1 : 0) + 244;
            case 5:
                return (z5 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z5 ? 1 : 0) + 60;
            case 8:
                return (z5 ? 1 : 0) + 121;
            case 9:
                return (z5 ? 1 : 0) + 182;
            case 10:
                return (z5 ? 1 : 0) + 213;
            case 11:
                return (z5 ? 1 : 0) + 274;
            default:
                return (z5 ? 1 : 0) + 335;
        }
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? getValue() : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR : temporalField != null && temporalField.isSupportedBy(this);
    }

    public int length(boolean z5) {
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        return i5 != 1 ? (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31 : z5 ? 29 : 28;
    }

    public int maxLength() {
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        if (i5 != 1) {
            return (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31;
        }
        return 29;
    }

    public int minLength() {
        int i5 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        if (i5 != 1) {
            return (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31;
        }
        return 28;
    }

    public Month plus(long j5) {
        return ENUMS[(ordinal() + (((int) (j5 % 12)) + 12)) % 12];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
