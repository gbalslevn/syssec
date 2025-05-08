package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.conscrypt.BuildConfig;
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
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    private static final int MINUTES_PER_HOUR = 60;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 2357656521762053153L;
    private final transient String id;
    private final int totalSeconds;
    public static final TemporalQuery<ZoneOffset> FROM = new TemporalQuery<ZoneOffset>() { // from class: org.threeten.bp.ZoneOffset.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            return ZoneOffset.from(temporalAccessor);
        }
    };
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);

    private ZoneOffset(int i5) {
        this.totalSeconds = i5;
        this.id = buildId(i5);
    }

    private static String buildId(int i5) {
        if (i5 == 0) {
            return "Z";
        }
        int abs = Math.abs(i5);
        StringBuilder sb = new StringBuilder();
        int i6 = abs / SECONDS_PER_HOUR;
        int i7 = (abs / 60) % 60;
        sb.append(i5 < 0 ? "-" : "+");
        sb.append(i6 < 10 ? "0" : BuildConfig.FLAVOR);
        sb.append(i6);
        sb.append(i7 < 10 ? ":0" : ":");
        sb.append(i7);
        int i8 = abs % 60;
        if (i8 != 0) {
            sb.append(i8 < 10 ? ":0" : ":");
            sb.append(i8);
        }
        return sb.toString();
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ZoneOffset of(String str) {
        int parseNumber;
        int i5;
        int i6;
        char charAt;
        Jdk8Methods.requireNonNull(str, "offsetId");
        ZoneOffset zoneOffset = ID_CACHE.get(str);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                parseNumber = parseNumber(str, 1, false);
                i5 = parseNumber(str, 3, false);
            } else {
                if (length != 6) {
                    if (length == 7) {
                        parseNumber = parseNumber(str, 1, false);
                        i5 = parseNumber(str, 3, false);
                        i6 = parseNumber(str, 5, false);
                    } else {
                        if (length != 9) {
                            throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: " + str);
                        }
                        parseNumber = parseNumber(str, 1, false);
                        i5 = parseNumber(str, 4, true);
                        i6 = parseNumber(str, 7, true);
                    }
                    charAt = str.charAt(0);
                    if (charAt != '+' || charAt == '-') {
                        return charAt == '-' ? ofHoursMinutesSeconds(-parseNumber, -i5, -i6) : ofHoursMinutesSeconds(parseNumber, i5, i6);
                    }
                    throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: " + str);
                }
                parseNumber = parseNumber(str, 1, false);
                i5 = parseNumber(str, 4, true);
            }
            i6 = 0;
            charAt = str.charAt(0);
            if (charAt != '+') {
            }
            if (charAt == '-') {
            }
        }
        parseNumber = parseNumber(str, 1, false);
        i5 = 0;
        i6 = 0;
        charAt = str.charAt(0);
        if (charAt != '+') {
        }
        if (charAt == '-') {
        }
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i5, int i6, int i7) {
        validate(i5, i6, i7);
        return ofTotalSeconds(totalSeconds(i5, i6, i7));
    }

    public static ZoneOffset ofTotalSeconds(int i5) {
        if (Math.abs(i5) > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i5 % 900 != 0) {
            return new ZoneOffset(i5);
        }
        Integer valueOf = Integer.valueOf(i5);
        ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
        ZoneOffset zoneOffset = concurrentMap.get(valueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i5));
        ZoneOffset zoneOffset2 = concurrentMap.get(valueOf);
        ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
        return zoneOffset2;
    }

    private static int parseNumber(CharSequence charSequence, int i5, boolean z5) {
        if (z5 && charSequence.charAt(i5 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char charAt = charSequence.charAt(i5);
        char charAt2 = charSequence.charAt(i5 + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return ((charAt - '0') * 10) + (charAt2 - '0');
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readExternal(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int totalSeconds(int i5, int i6, int i7) {
        return (i5 * SECONDS_PER_HOUR) + (i6 * 60) + i7;
    }

    private static void validate(int i5, int i6, int i7) {
        if (i5 < -18 || i5 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i5 + " is not in the range -18 to 18");
        }
        if (i5 > 0) {
            if (i6 < 0 || i7 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i5 < 0) {
            if (i6 > 0 || i7 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i6 > 0 && i7 < 0) || (i6 < 0 && i7 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i6) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i6) + " is not in the range 0 to 59");
        }
        if (Math.abs(i7) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i7) + " is not in the range 0 to 59");
        }
        if (Math.abs(i5) == 18) {
            if (Math.abs(i6) > 0 || Math.abs(i7) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new DateTimeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.precision() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        int i5 = this.totalSeconds;
        int i6 = i5 % 900 == 0 ? i5 / 900 : 127;
        dataOutput.writeByte(i6);
        if (i6 == 127) {
            dataOutput.writeInt(i5);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }
}
