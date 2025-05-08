package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Ser implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object read(DataInput dataInput) {
        return readInternal(dataInput.readByte(), dataInput);
    }

    private static Object readInternal(byte b5, DataInput dataInput) {
        if (b5 == 64) {
            return MonthDay.readExternal(dataInput);
        }
        switch (b5) {
            case 1:
                return Duration.readExternal(dataInput);
            case 2:
                return Instant.readExternal(dataInput);
            case 3:
                return LocalDate.readExternal(dataInput);
            case 4:
                return LocalDateTime.readExternal(dataInput);
            case 5:
                return LocalTime.readExternal(dataInput);
            case 6:
                return ZonedDateTime.readExternal(dataInput);
            case 7:
                return ZoneRegion.readExternal(dataInput);
            case 8:
                return ZoneOffset.readExternal(dataInput);
            default:
                switch (b5) {
                    case 66:
                        return OffsetTime.readExternal(dataInput);
                    case 67:
                        return Year.readExternal(dataInput);
                    case 68:
                        return YearMonth.readExternal(dataInput);
                    case 69:
                        return OffsetDateTime.readExternal(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.object;
    }

    static void writeInternal(byte b5, Object obj, DataOutput dataOutput) {
        dataOutput.writeByte(b5);
        if (b5 == 64) {
            ((MonthDay) obj).writeExternal(dataOutput);
            return;
        }
        switch (b5) {
            case 1:
                ((Duration) obj).writeExternal(dataOutput);
                return;
            case 2:
                ((Instant) obj).writeExternal(dataOutput);
                return;
            case 3:
                ((LocalDate) obj).writeExternal(dataOutput);
                return;
            case 4:
                ((LocalDateTime) obj).writeExternal(dataOutput);
                return;
            case 5:
                ((LocalTime) obj).writeExternal(dataOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).writeExternal(dataOutput);
                return;
            case 7:
                ((ZoneRegion) obj).writeExternal(dataOutput);
                return;
            case 8:
                ((ZoneOffset) obj).writeExternal(dataOutput);
                return;
            default:
                switch (b5) {
                    case 66:
                        ((OffsetTime) obj).writeExternal(dataOutput);
                        return;
                    case 67:
                        ((Year) obj).writeExternal(dataOutput);
                        return;
                    case 68:
                        ((YearMonth) obj).writeExternal(dataOutput);
                        return;
                    case 69:
                        ((OffsetDateTime) obj).writeExternal(dataOutput);
                        return;
                    default:
                        throw new InvalidClassException("Unknown serialized type");
                }
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        writeInternal(this.type, this.object, objectOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ser(byte b5, Object obj) {
        this.type = b5;
        this.object = obj;
    }
}
