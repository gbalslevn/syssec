package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;

/* loaded from: classes3.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    private static final int SECS_PER_DAY = 86400;
    private static final long serialVersionUID = 6889046316657758795L;
    private final int adjustDays;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition;

        static {
            int[] iArr = new int[TimeDefinition.values().length];
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = iArr;
            try {
                iArr[TimeDefinition.UTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[TimeDefinition.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            int i5 = AnonymousClass1.$SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[ordinal()];
            return i5 != 1 ? i5 != 2 ? localDateTime : localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()) : localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    ZoneOffsetTransitionRule(Month month, int i5, DayOfWeek dayOfWeek, LocalTime localTime, int i6, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month;
        this.dom = (byte) i5;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.adjustDays = i6;
        this.timeDefinition = timeDefinition;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    private void appendZeroPad(StringBuilder sb, long j5) {
        if (j5 < 10) {
            sb.append(0);
        }
        sb.append(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffsetTransitionRule readExternal(DataInput dataInput) {
        int readInt = dataInput.readInt();
        Month of = Month.of(readInt >>> 28);
        int i5 = ((264241152 & readInt) >>> 22) - 32;
        int i6 = (3670016 & readInt) >>> 19;
        DayOfWeek of2 = i6 == 0 ? null : DayOfWeek.of(i6);
        int i7 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i8 = (readInt & 4080) >>> 4;
        int i9 = (readInt & 12) >>> 2;
        int i10 = readInt & 3;
        int readInt2 = i7 == 31 ? dataInput.readInt() : i7 * 3600;
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i8 == 255 ? dataInput.readInt() : (i8 - 128) * 900);
        ZoneOffset ofTotalSeconds2 = ZoneOffset.ofTotalSeconds(i9 == 3 ? dataInput.readInt() : ofTotalSeconds.getTotalSeconds() + (i9 * 1800));
        ZoneOffset ofTotalSeconds3 = ZoneOffset.ofTotalSeconds(i10 == 3 ? dataInput.readInt() : ofTotalSeconds.getTotalSeconds() + (i10 * 1800));
        if (i5 < -28 || i5 > 31 || i5 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new ZoneOffsetTransitionRule(of, i5, of2, LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(readInt2, SECS_PER_DAY)), Jdk8Methods.floorDiv(readInt2, SECS_PER_DAY), timeDefinition, ofTotalSeconds, ofTotalSeconds2, ofTotalSeconds3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition createTransition(int i5) {
        LocalDate of;
        byte b5 = this.dom;
        if (b5 < 0) {
            Month month = this.month;
            of = LocalDate.of(i5, month, month.length(IsoChronology.INSTANCE.isLeapYear(i5)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                of = of.with(TemporalAdjusters.previousOrSame(dayOfWeek));
            }
        } else {
            of = LocalDate.of(i5, this.month, b5);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                of = of.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
            }
        }
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(of.plusDays(this.adjustDays), this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.adjustDays == zoneOffsetTransitionRule.adjustDays && this.time.equals(zoneOffsetTransitionRule.time) && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter);
    }

    public int hashCode() {
        int secondOfDay = ((this.time.toSecondOfDay() + this.adjustDays) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        return ((((secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionRule[");
        sb.append(this.offsetBefore.compareTo(this.offsetAfter) > 0 ? "Gap " : "Overlap ");
        sb.append(this.offsetBefore);
        sb.append(" to ");
        sb.append(this.offsetAfter);
        sb.append(", ");
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek != null) {
            byte b5 = this.dom;
            if (b5 == -1) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day of ");
                sb.append(this.month.name());
            } else if (b5 < 0) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.dom) - 1);
                sb.append(" of ");
                sb.append(this.month.name());
            } else {
                sb.append(dayOfWeek.name());
                sb.append(" on or after ");
                sb.append(this.month.name());
                sb.append(' ');
                sb.append((int) this.dom);
            }
        } else {
            sb.append(this.month.name());
            sb.append(' ');
            sb.append((int) this.dom);
        }
        sb.append(" at ");
        if (this.adjustDays == 0) {
            sb.append(this.time);
        } else {
            appendZeroPad(sb, Jdk8Methods.floorDiv((this.time.toSecondOfDay() / 60) + (this.adjustDays * 1440), 60L));
            sb.append(':');
            appendZeroPad(sb, Jdk8Methods.floorMod(r3, 60));
        }
        sb.append(" ");
        sb.append(this.timeDefinition);
        sb.append(", standard offset ");
        sb.append(this.standardOffset);
        sb.append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        int secondOfDay = this.time.toSecondOfDay() + (this.adjustDays * SECS_PER_DAY);
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        int hour = (secondOfDay % 3600 != 0 || secondOfDay > SECS_PER_DAY) ? 31 : secondOfDay == SECS_PER_DAY ? 24 : this.time.getHour();
        int i5 = totalSeconds % 900 == 0 ? (totalSeconds / 900) + 128 : 255;
        int i6 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i7 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.dow;
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (hour << 14) + (this.timeDefinition.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (hour == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i5 == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }
}
