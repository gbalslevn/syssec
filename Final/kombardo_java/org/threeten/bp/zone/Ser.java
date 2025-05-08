package org.threeten.bp.zone;

import com.sun.jna.Function;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Ser implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ser(byte b5, Object obj) {
        this.type = b5;
        this.object = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object read(DataInput dataInput) {
        return readInternal(dataInput.readByte(), dataInput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long readEpochSec(DataInput dataInput) {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    private static Object readInternal(byte b5, DataInput dataInput) {
        if (b5 == 1) {
            return StandardZoneRules.readExternal(dataInput);
        }
        if (b5 == 2) {
            return ZoneOffsetTransition.readExternal(dataInput);
        }
        if (b5 == 3) {
            return ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readOffset(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeEpochSec(long j5, DataOutput dataOutput) {
        if (j5 < -4575744000L || j5 >= 10413792000L || j5 % 900 != 0) {
            dataOutput.writeByte(Function.USE_VARARGS);
            dataOutput.writeLong(j5);
        } else {
            int i5 = (int) ((j5 + 4575744000L) / 900);
            dataOutput.writeByte((i5 >>> 16) & Function.USE_VARARGS);
            dataOutput.writeByte((i5 >>> 8) & Function.USE_VARARGS);
            dataOutput.writeByte(i5 & Function.USE_VARARGS);
        }
    }

    private static void writeInternal(byte b5, Object obj, DataOutput dataOutput) {
        dataOutput.writeByte(b5);
        if (b5 == 1) {
            ((StandardZoneRules) obj).writeExternal(dataOutput);
        } else if (b5 == 2) {
            ((ZoneOffsetTransition) obj).writeExternal(dataOutput);
        } else {
            if (b5 != 3) {
                throw new InvalidClassException("Unknown serialized type");
            }
            ((ZoneOffsetTransitionRule) obj).writeExternal(dataOutput);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeOffset(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i5 = totalSeconds % 900 == 0 ? totalSeconds / 900 : 127;
        dataOutput.writeByte(i5);
        if (i5 == 127) {
            dataOutput.writeInt(totalSeconds);
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
}
