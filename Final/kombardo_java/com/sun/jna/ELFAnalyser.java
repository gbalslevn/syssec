package com.sun.jna;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class ELFAnalyser {
    private static final int EF_ARM_ABI_FLOAT_HARD = 1024;
    private static final int EF_ARM_ABI_FLOAT_SOFT = 512;
    private static final int EI_CLASS_64BIT = 2;
    private static final int EI_DATA_BIG_ENDIAN = 2;
    private static final byte[] ELF_MAGIC = {Byte.MAX_VALUE, 69, 76, 70};
    private static final int E_MACHINE_ARM = 40;
    private final String filename;
    private boolean ELF = false;
    private boolean _64Bit = false;
    private boolean bigEndian = false;
    private boolean armHardFloatFlag = false;
    private boolean armSoftFloatFlag = false;
    private boolean armEabiAapcsVfp = false;
    private boolean arm = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sun.jna.ELFAnalyser$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType;

        static {
            int[] iArr = new int[ArmAeabiAttributesTag.ParameterType.values().length];
            $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType = iArr;
            try {
                iArr[ArmAeabiAttributesTag.ParameterType.UINT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[ArmAeabiAttributesTag.ParameterType.NTBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[ArmAeabiAttributesTag.ParameterType.ULEB128.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ArmAeabiAttributesTag {
        public static final ArmAeabiAttributesTag ABI_FP_16bit_format;
        public static final ArmAeabiAttributesTag ABI_FP_denormal;
        public static final ArmAeabiAttributesTag ABI_FP_exceptions;
        public static final ArmAeabiAttributesTag ABI_FP_number_model;
        public static final ArmAeabiAttributesTag ABI_FP_optimization_goals;
        public static final ArmAeabiAttributesTag ABI_FP_rounding;
        public static final ArmAeabiAttributesTag ABI_FP_user_exceptions;
        public static final ArmAeabiAttributesTag ABI_HardFP_use;
        public static final ArmAeabiAttributesTag ABI_PCS_GOT_use;
        public static final ArmAeabiAttributesTag ABI_PCS_R9_use;
        public static final ArmAeabiAttributesTag ABI_PCS_RO_data;
        public static final ArmAeabiAttributesTag ABI_PCS_RW_data;
        public static final ArmAeabiAttributesTag ABI_PCS_wchar_t;
        public static final ArmAeabiAttributesTag ABI_VFP_args;
        public static final ArmAeabiAttributesTag ABI_WMMX_args;
        public static final ArmAeabiAttributesTag ABI_align8_preserved;
        public static final ArmAeabiAttributesTag ABI_align_needed;
        public static final ArmAeabiAttributesTag ABI_enum_size;
        public static final ArmAeabiAttributesTag ABI_optimization_goals;
        public static final ArmAeabiAttributesTag ARM_ISA_use;
        public static final ArmAeabiAttributesTag Advanced_SIMD_arch;
        public static final ArmAeabiAttributesTag CPU_arch;
        public static final ArmAeabiAttributesTag CPU_arch_profile;
        public static final ArmAeabiAttributesTag CPU_name;
        public static final ArmAeabiAttributesTag CPU_raw_name;
        public static final ArmAeabiAttributesTag CPU_unaligned_access;
        public static final ArmAeabiAttributesTag DIV_use;
        public static final ArmAeabiAttributesTag FP_HP_extension;
        public static final ArmAeabiAttributesTag FP_arch;
        public static final ArmAeabiAttributesTag File;
        public static final ArmAeabiAttributesTag MPextension_use;
        public static final ArmAeabiAttributesTag MPextension_use2;
        public static final ArmAeabiAttributesTag PCS_config;
        public static final ArmAeabiAttributesTag Section;
        public static final ArmAeabiAttributesTag Symbol;
        public static final ArmAeabiAttributesTag T2EE_use;
        public static final ArmAeabiAttributesTag THUMB_ISA_use;
        public static final ArmAeabiAttributesTag Virtualization_use;
        public static final ArmAeabiAttributesTag WMMX_arch;
        public static final ArmAeabiAttributesTag also_compatible_with;
        public static final ArmAeabiAttributesTag compatibility;
        public static final ArmAeabiAttributesTag conformance;
        public static final ArmAeabiAttributesTag nodefaults;
        private final String name;
        private final ParameterType parameterType;
        private final int value;
        private static final List<ArmAeabiAttributesTag> tags = new LinkedList();
        private static final Map<Integer, ArmAeabiAttributesTag> valueMap = new HashMap();
        private static final Map<String, ArmAeabiAttributesTag> nameMap = new HashMap();

        /* loaded from: classes2.dex */
        public enum ParameterType {
            UINT32,
            NTBS,
            ULEB128
        }

        static {
            ParameterType parameterType = ParameterType.UINT32;
            File = addTag(1, "File", parameterType);
            Section = addTag(2, "Section", parameterType);
            Symbol = addTag(3, "Symbol", parameterType);
            ParameterType parameterType2 = ParameterType.NTBS;
            CPU_raw_name = addTag(4, "CPU_raw_name", parameterType2);
            CPU_name = addTag(5, "CPU_name", parameterType2);
            ParameterType parameterType3 = ParameterType.ULEB128;
            CPU_arch = addTag(6, "CPU_arch", parameterType3);
            CPU_arch_profile = addTag(7, "CPU_arch_profile", parameterType3);
            ARM_ISA_use = addTag(8, "ARM_ISA_use", parameterType3);
            THUMB_ISA_use = addTag(9, "THUMB_ISA_use", parameterType3);
            FP_arch = addTag(10, "FP_arch", parameterType3);
            WMMX_arch = addTag(11, "WMMX_arch", parameterType3);
            Advanced_SIMD_arch = addTag(12, "Advanced_SIMD_arch", parameterType3);
            PCS_config = addTag(13, "PCS_config", parameterType3);
            ABI_PCS_R9_use = addTag(14, "ABI_PCS_R9_use", parameterType3);
            ABI_PCS_RW_data = addTag(15, "ABI_PCS_RW_data", parameterType3);
            ABI_PCS_RO_data = addTag(16, "ABI_PCS_RO_data", parameterType3);
            ABI_PCS_GOT_use = addTag(17, "ABI_PCS_GOT_use", parameterType3);
            ABI_PCS_wchar_t = addTag(18, "ABI_PCS_wchar_t", parameterType3);
            ABI_FP_rounding = addTag(19, "ABI_FP_rounding", parameterType3);
            ABI_FP_denormal = addTag(20, "ABI_FP_denormal", parameterType3);
            ABI_FP_exceptions = addTag(21, "ABI_FP_exceptions", parameterType3);
            ABI_FP_user_exceptions = addTag(22, "ABI_FP_user_exceptions", parameterType3);
            ABI_FP_number_model = addTag(23, "ABI_FP_number_model", parameterType3);
            ABI_align_needed = addTag(24, "ABI_align_needed", parameterType3);
            ABI_align8_preserved = addTag(25, "ABI_align8_preserved", parameterType3);
            ABI_enum_size = addTag(26, "ABI_enum_size", parameterType3);
            ABI_HardFP_use = addTag(27, "ABI_HardFP_use", parameterType3);
            ABI_VFP_args = addTag(28, "ABI_VFP_args", parameterType3);
            ABI_WMMX_args = addTag(29, "ABI_WMMX_args", parameterType3);
            ABI_optimization_goals = addTag(30, "ABI_optimization_goals", parameterType3);
            ABI_FP_optimization_goals = addTag(31, "ABI_FP_optimization_goals", parameterType3);
            compatibility = addTag(32, "compatibility", parameterType2);
            CPU_unaligned_access = addTag(34, "CPU_unaligned_access", parameterType3);
            FP_HP_extension = addTag(36, "FP_HP_extension", parameterType3);
            ABI_FP_16bit_format = addTag(38, "ABI_FP_16bit_format", parameterType3);
            MPextension_use = addTag(42, "MPextension_use", parameterType3);
            DIV_use = addTag(44, "DIV_use", parameterType3);
            nodefaults = addTag(64, "nodefaults", parameterType3);
            also_compatible_with = addTag(65, "also_compatible_with", parameterType2);
            conformance = addTag(67, "conformance", parameterType2);
            T2EE_use = addTag(66, "T2EE_use", parameterType3);
            Virtualization_use = addTag(68, "Virtualization_use", parameterType3);
            MPextension_use2 = addTag(70, "MPextension_use", parameterType3);
        }

        public ArmAeabiAttributesTag(int i5, String str, ParameterType parameterType) {
            this.value = i5;
            this.name = str;
            this.parameterType = parameterType;
        }

        private static ArmAeabiAttributesTag addTag(int i5, String str, ParameterType parameterType) {
            ArmAeabiAttributesTag armAeabiAttributesTag = new ArmAeabiAttributesTag(i5, str, parameterType);
            Map<Integer, ArmAeabiAttributesTag> map = valueMap;
            if (!map.containsKey(Integer.valueOf(armAeabiAttributesTag.getValue()))) {
                map.put(Integer.valueOf(armAeabiAttributesTag.getValue()), armAeabiAttributesTag);
            }
            Map<String, ArmAeabiAttributesTag> map2 = nameMap;
            if (!map2.containsKey(armAeabiAttributesTag.getName())) {
                map2.put(armAeabiAttributesTag.getName(), armAeabiAttributesTag);
            }
            tags.add(armAeabiAttributesTag);
            return armAeabiAttributesTag;
        }

        public static ArmAeabiAttributesTag getByName(String str) {
            return nameMap.get(str);
        }

        public static ArmAeabiAttributesTag getByValue(int i5) {
            Map<Integer, ArmAeabiAttributesTag> map = valueMap;
            if (map.containsKey(Integer.valueOf(i5))) {
                return map.get(Integer.valueOf(i5));
            }
            return new ArmAeabiAttributesTag(i5, "Unknown " + i5, getParameterType(i5));
        }

        public static List<ArmAeabiAttributesTag> getTags() {
            return Collections.unmodifiableList(tags);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ArmAeabiAttributesTag) obj).value;
        }

        public String getName() {
            return this.name;
        }

        public ParameterType getParameterType() {
            return this.parameterType;
        }

        public int getValue() {
            return this.value;
        }

        public int hashCode() {
            return 469 + this.value;
        }

        public String toString() {
            return this.name + " (" + this.value + ")";
        }

        private static ParameterType getParameterType(int i5) {
            ArmAeabiAttributesTag byValue = getByValue(i5);
            if (byValue == null) {
                if (i5 % 2 == 0) {
                    return ParameterType.ULEB128;
                }
                return ParameterType.NTBS;
            }
            return byValue.getParameterType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ELFSectionHeaderEntry {
        private final int flags;
        private String name;
        private final int nameOffset;
        private final int offset;
        private final int size;
        private final int type;

        public ELFSectionHeaderEntry(boolean z5, ByteBuffer byteBuffer) {
            this.nameOffset = byteBuffer.getInt(0);
            this.type = byteBuffer.getInt(4);
            this.flags = (int) (z5 ? byteBuffer.getLong(8) : byteBuffer.getInt(8));
            this.offset = (int) (z5 ? byteBuffer.getLong(24) : byteBuffer.getInt(16));
            this.size = (int) (z5 ? byteBuffer.getLong(32) : byteBuffer.getInt(20));
        }

        public int getFlags() {
            return this.flags;
        }

        public String getName() {
            return this.name;
        }

        public int getNameOffset() {
            return this.nameOffset;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return "ELFSectionHeaderEntry{nameIdx=" + this.nameOffset + ", name=" + this.name + ", type=" + this.type + ", flags=" + this.flags + ", offset=" + this.offset + ", size=" + this.size + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ELFSectionHeaders {
        private final List<ELFSectionHeaderEntry> entries = new ArrayList();

        public ELFSectionHeaders(boolean z5, boolean z6, ByteBuffer byteBuffer, RandomAccessFile randomAccessFile) {
            long j5;
            short s5;
            short s6;
            short s7;
            byte b5;
            if (z5) {
                j5 = byteBuffer.getLong(ELFAnalyser.E_MACHINE_ARM);
                s5 = byteBuffer.getShort(58);
                s6 = byteBuffer.getShort(60);
                s7 = byteBuffer.getShort(62);
            } else {
                j5 = byteBuffer.getInt(32);
                s5 = byteBuffer.getShort(46);
                s6 = byteBuffer.getShort(48);
                s7 = byteBuffer.getShort(50);
            }
            ByteBuffer allocate = ByteBuffer.allocate(s6 * s5);
            allocate.order(z6 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.getChannel().read(allocate, j5);
            for (int i5 = 0; i5 < s6; i5++) {
                allocate.position(i5 * s5);
                ByteBuffer slice = allocate.slice();
                slice.order(allocate.order());
                slice.limit(s5);
                this.entries.add(new ELFSectionHeaderEntry(z5, slice));
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(this.entries.get(s7).getSize());
            allocate2.order(z6 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.getChannel().read(allocate2, r8.getOffset());
            allocate2.rewind();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(20);
            for (ELFSectionHeaderEntry eLFSectionHeaderEntry : this.entries) {
                byteArrayOutputStream.reset();
                allocate2.position(eLFSectionHeaderEntry.getNameOffset());
                while (allocate2.position() < allocate2.limit() && (b5 = allocate2.get()) != 0) {
                    byteArrayOutputStream.write(b5);
                }
                eLFSectionHeaderEntry.setName(byteArrayOutputStream.toString("ASCII"));
            }
        }

        public List<ELFSectionHeaderEntry> getEntries() {
            return this.entries;
        }
    }

    private ELFAnalyser(String str) {
        this.filename = str;
    }

    public static ELFAnalyser analyse(String str) {
        ELFAnalyser eLFAnalyser = new ELFAnalyser(str);
        eLFAnalyser.runDetection();
        return eLFAnalyser;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseAEABI(ByteBuffer byteBuffer) {
        HashMap hashMap = new HashMap();
        while (byteBuffer.position() < byteBuffer.limit()) {
            int position = byteBuffer.position();
            int intValue = readULEB128(byteBuffer).intValue();
            int i5 = byteBuffer.getInt();
            if (intValue == 1) {
                hashMap.put(Integer.valueOf(intValue), parseFileAttribute(byteBuffer));
            }
            byteBuffer.position(position + i5);
        }
        return hashMap;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseArmAttributes(ByteBuffer byteBuffer) {
        if (byteBuffer.get() != 65) {
            return Collections.EMPTY_MAP;
        }
        while (byteBuffer.position() < byteBuffer.limit()) {
            int position = byteBuffer.position();
            int i5 = byteBuffer.getInt();
            if (i5 <= 0) {
                break;
            }
            if ("aeabi".equals(readNTBS(byteBuffer, null))) {
                return parseAEABI(byteBuffer);
            }
            byteBuffer.position(position + i5);
        }
        return Collections.EMPTY_MAP;
    }

    private void parseEabiAapcsVfp(ByteBuffer byteBuffer, RandomAccessFile randomAccessFile) {
        for (ELFSectionHeaderEntry eLFSectionHeaderEntry : new ELFSectionHeaders(this._64Bit, this.bigEndian, byteBuffer, randomAccessFile).getEntries()) {
            if (".ARM.attributes".equals(eLFSectionHeaderEntry.getName())) {
                ByteBuffer allocate = ByteBuffer.allocate(eLFSectionHeaderEntry.getSize());
                allocate.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.getChannel().read(allocate, eLFSectionHeaderEntry.getOffset());
                allocate.rewind();
                Map<ArmAeabiAttributesTag, Object> map = parseArmAttributes(allocate).get(1);
                if (map != null) {
                    Object obj = map.get(ArmAeabiAttributesTag.ABI_VFP_args);
                    if ((obj instanceof Integer) && ((Integer) obj).equals(1)) {
                        this.armEabiAapcsVfp = true;
                    } else if ((obj instanceof BigInteger) && ((BigInteger) obj).intValue() == 1) {
                        this.armEabiAapcsVfp = true;
                    }
                }
            }
        }
    }

    private static Map<ArmAeabiAttributesTag, Object> parseFileAttribute(ByteBuffer byteBuffer) {
        HashMap hashMap = new HashMap();
        while (byteBuffer.position() < byteBuffer.limit()) {
            ArmAeabiAttributesTag byValue = ArmAeabiAttributesTag.getByValue(readULEB128(byteBuffer).intValue());
            int i5 = AnonymousClass1.$SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[byValue.getParameterType().ordinal()];
            if (i5 == 1) {
                hashMap.put(byValue, Integer.valueOf(byteBuffer.getInt()));
            } else if (i5 == 2) {
                hashMap.put(byValue, readNTBS(byteBuffer, null));
            } else if (i5 == 3) {
                hashMap.put(byValue, readULEB128(byteBuffer));
            }
        }
        return hashMap;
    }

    private static String readNTBS(ByteBuffer byteBuffer, Integer num) {
        if (num != null) {
            byteBuffer.position(num.intValue());
        }
        int position = byteBuffer.position();
        while (byteBuffer.get() != 0 && byteBuffer.position() <= byteBuffer.limit()) {
        }
        byte[] bArr = new byte[(byteBuffer.position() - position) - 1];
        byteBuffer.position(position);
        byteBuffer.get(bArr);
        byteBuffer.position(byteBuffer.position() + 1);
        try {
            return new String(bArr, "ASCII");
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static BigInteger readULEB128(ByteBuffer byteBuffer) {
        BigInteger bigInteger = BigInteger.ZERO;
        int i5 = 0;
        while (true) {
            byte b5 = byteBuffer.get();
            bigInteger = bigInteger.or(BigInteger.valueOf(b5 & Byte.MAX_VALUE).shiftLeft(i5));
            if ((b5 & 128) == 0) {
                return bigInteger;
            }
            i5 += 7;
        }
    }

    private void runDetection() {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.filename, "r");
        try {
            boolean z5 = true;
            if (randomAccessFile.length() > 4) {
                byte[] bArr = new byte[4];
                randomAccessFile.seek(0L);
                randomAccessFile.read(bArr);
                if (Arrays.equals(bArr, ELF_MAGIC)) {
                    this.ELF = true;
                }
            }
            if (!this.ELF) {
                try {
                    randomAccessFile.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            randomAccessFile.seek(4L);
            byte readByte = randomAccessFile.readByte();
            byte readByte2 = randomAccessFile.readByte();
            this._64Bit = readByte == 2;
            this.bigEndian = readByte2 == 2;
            randomAccessFile.seek(0L);
            ByteBuffer allocate = ByteBuffer.allocate(this._64Bit ? 64 : 52);
            randomAccessFile.getChannel().read(allocate, 0L);
            allocate.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            boolean z6 = allocate.get(18) == E_MACHINE_ARM;
            this.arm = z6;
            if (z6) {
                int i5 = allocate.getInt(this._64Bit ? 48 : 36);
                this.armHardFloatFlag = (i5 & EF_ARM_ABI_FLOAT_HARD) == EF_ARM_ABI_FLOAT_HARD;
                if ((i5 & EF_ARM_ABI_FLOAT_SOFT) != EF_ARM_ABI_FLOAT_SOFT) {
                    z5 = false;
                }
                this.armSoftFloatFlag = z5;
                parseEabiAapcsVfp(allocate, randomAccessFile);
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean is64Bit() {
        return this._64Bit;
    }

    public boolean isArm() {
        return this.arm;
    }

    public boolean isArmEabiAapcsVfp() {
        return this.armEabiAapcsVfp;
    }

    public boolean isArmHardFloat() {
        return isArmEabiAapcsVfp() || isArmHardFloatFlag();
    }

    public boolean isArmHardFloatFlag() {
        return this.armHardFloatFlag;
    }

    public boolean isArmSoftFloatFlag() {
        return this.armSoftFloatFlag;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public boolean isELF() {
        return this.ELF;
    }
}
