package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes3.dex */
final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 < jArr2.length) {
            int i6 = i5 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i5], zoneOffsetArr2[i5], zoneOffsetArr2[i6]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            i5 = i6;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        return zoneOffsetTransition.isGap() ? localDateTime.isBefore(dateTimeBefore) ? zoneOffsetTransition.getOffsetBefore() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition : zoneOffsetTransition.getOffsetAfter() : !localDateTime.isBefore(dateTimeBefore) ? zoneOffsetTransition.getOffsetAfter() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition.getOffsetBefore() : zoneOffsetTransition;
    }

    private ZoneOffsetTransition[] findTransitionArray(int i5) {
        Integer valueOf = Integer.valueOf(i5);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i6 = 0; i6 < zoneOffsetTransitionRuleArr.length; i6++) {
            zoneOffsetTransitionArr2[i6] = zoneOffsetTransitionRuleArr[i6].createTransition(i5);
        }
        if (i5 < LAST_CACHED_YEAR) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int findYear(long j5, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j5 + zoneOffset.getTotalSeconds(), 86400L)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        int i5 = 0;
        if (this.lastRules.length > 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            if (localDateTimeArr.length == 0 || localDateTime.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
                int length = findTransitionArray.length;
                Object obj = null;
                while (i5 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i5];
                    Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                    if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                        return findOffsetInfo;
                    }
                    i5++;
                    obj = findOffsetInfo;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            Object[] objArr = this.savingsLocalTransitions;
            if (binarySearch < objArr.length - 1) {
                int i6 = binarySearch + 1;
                if (objArr[binarySearch].equals(objArr[i6])) {
                    binarySearch = i6;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.wallOffsets[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
        LocalDateTime localDateTime2 = localDateTimeArr2[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr2[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int i7 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i7];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i7 + 1];
        return zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StandardZoneRules readExternal(DataInput dataInput) {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            jArr[i5] = Ser.readEpochSec(dataInput);
        }
        int i6 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            zoneOffsetArr[i7] = Ser.readOffset(dataInput);
        }
        int readInt2 = dataInput.readInt();
        long[] jArr2 = new long[readInt2];
        for (int i8 = 0; i8 < readInt2; i8++) {
            jArr2[i8] = Ser.readEpochSec(dataInput);
        }
        int i9 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            zoneOffsetArr2[i10] = Ser.readOffset(dataInput);
        }
        int readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        for (int i11 = 0; i11 < readByte; i11++) {
            zoneOffsetTransitionRuleArr[i11] = ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) && Arrays.equals(this.lastRules, standardZoneRules.lastRules);
        }
        if (!(obj instanceof ZoneRules.Fixed)) {
            return false;
        }
        if (isFixedOffset()) {
            Instant instant = Instant.EPOCH;
            if (getOffset(instant).equals(((ZoneRules.Fixed) obj).getOffset(instant))) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(Instant instant) {
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (jArr.length == 0 || epochSecond > jArr[jArr.length - 1]) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, this.wallOffsets[r7.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i5 = 0; i5 < findTransitionArray.length; i5++) {
                    zoneOffsetTransition = findTransitionArray[i5];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.standardOffsets[binarySearch + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        return offsetInfo instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) offsetInfo).getValidOffsets() : Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0 && this.lastRules.length == 0 && this.wallOffsets[0].equals(this.standardOffsets[0]);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StandardZoneRules[currentStandardOffset=");
        sb.append(this.standardOffsets[r1.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long j5 : this.standardTransitions) {
            Ser.writeEpochSec(j5, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.standardOffsets) {
            Ser.writeOffset(zoneOffset, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long j6 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(j6, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.wallOffsets) {
            Ser.writeOffset(zoneOffset2, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule zoneOffsetTransitionRule : this.lastRules) {
            zoneOffsetTransitionRule.writeExternal(dataOutput);
        }
    }
}
