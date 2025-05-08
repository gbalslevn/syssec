package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes3.dex */
public abstract class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    /* renamed from: org.threeten.bp.temporal.IsoFields$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Field implements TemporalField {
        DAY_OF_QUARTER { // from class: org.threeten.bp.temporal.IsoFields.Field.1
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r5, long j5) {
                long from = getFrom(r5);
                range().checkValidValue(j5, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return (R) r5.with(chronoField, r5.getLong(chronoField) + (j5 - from));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j5 = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                if (j5 == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                return j5 == 2 ? ValueRange.of(1L, 91L) : (j5 == 3 || j5 == 4) ? ValueRange.of(1L, 92L) : range();
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate plusDays;
                ChronoField chronoField = ChronoField.YEAR;
                Long l5 = map.get(chronoField);
                TemporalField temporalField = Field.QUARTER_OF_YEAR;
                Long l6 = map.get(temporalField);
                if (l5 == null || l6 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l5.longValue());
                long longValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    plusDays = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(l6.longValue(), 1L), 3)).plusDays(Jdk8Methods.safeSubtract(longValue, 1L));
                } else {
                    int checkValidIntValue2 = temporalField.range().checkValidIntValue(l6.longValue(), temporalField);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i5 = 91;
                        if (checkValidIntValue2 == 1) {
                            if (!IsoChronology.INSTANCE.isLeapYear(checkValidIntValue)) {
                                i5 = 90;
                            }
                        } else if (checkValidIntValue2 != 2) {
                            i5 = 92;
                        }
                        ValueRange.of(1L, i5).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    plusDays = LocalDate.of(checkValidIntValue, ((checkValidIntValue2 - 1) * 3) + 1, 1).plusDays(longValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(temporalField);
                return plusDays;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.2
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r5, long j5) {
                long from = getFrom(r5);
                range().checkValidValue(j5, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return (R) r5.with(chronoField, r5.getLong(chronoField) + ((j5 - from) * 3));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.3
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r5, long j5) {
                range().checkValidValue(j5, this);
                return (R) r5.plus(Jdk8Methods.safeSubtract(j5, getFrom(r5)), ChronoUnit.WEEKS);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeek(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeekRange(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                TemporalField temporalField;
                LocalDate with;
                long j5;
                TemporalField temporalField2 = Field.WEEK_BASED_YEAR;
                Long l5 = map.get(temporalField2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l6 = map.get(chronoField);
                if (l5 == null || l6 == null) {
                    return null;
                }
                int checkValidIntValue = temporalField2.range().checkValidIntValue(l5.longValue(), temporalField2);
                long longValue = map.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long longValue2 = l6.longValue();
                    if (longValue2 > 7) {
                        long j6 = longValue2 - 1;
                        j5 = j6 / 7;
                        longValue2 = (j6 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j5 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    } else {
                        j5 = 0;
                    }
                    temporalField = temporalField2;
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).plusWeeks(j5).with((TemporalField) chronoField, longValue2);
                } else {
                    temporalField = temporalField2;
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l6.longValue());
                    if (resolverStyle == ResolverStyle.STRICT) {
                        Field.getWeekRange(LocalDate.of(checkValidIntValue, 1, 4)).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).with((TemporalField) chronoField, checkValidIntValue2);
                }
                map.remove(this);
                map.remove(temporalField);
                map.remove(chronoField);
                return with;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.4
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r5, long j5) {
                if (!isSupportedBy(r5)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j5, Field.WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from(r5);
                int i5 = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r5.with(LocalDate.of(checkValidIntValue, 1, 4).plusDays((i5 - r6.get(r0)) + ((week - 1) * 7)));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return ChronoField.YEAR.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };

        private static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i5 = (3 - ordinal) + dayOfYear;
            int i6 = i5 - ((i5 / 7) * 7);
            int i7 = i6 - 3;
            if (i7 < -3) {
                i7 = i6 + 4;
            }
            if (dayOfYear < i7) {
                return (int) getWeekRange(localDate.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int i8 = ((dayOfYear - i7) / 7) + 1;
            if (i8 != 53 || i7 == -3 || (i7 == -2 && localDate.isLeapYear())) {
                return i8;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isIso(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }

        /* synthetic */ Field(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i5) {
            LocalDate of = LocalDate.of(i5, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() == DayOfWeek.WEDNESDAY && of.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }
    }

    /* loaded from: classes3.dex */
    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r5, long j5) {
            int i5 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i5 == 1) {
                return (R) r5.with(IsoFields.WEEK_BASED_YEAR, Jdk8Methods.safeAdd(r5.get(r0), j5));
            }
            if (i5 == 2) {
                return (R) r5.plus(j5 / 256, ChronoUnit.YEARS).plus((j5 % 256) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public long between(Temporal temporal, Temporal temporal2) {
            int i5 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i5 == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return Jdk8Methods.safeSubtract(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            }
            if (i5 == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }
}
