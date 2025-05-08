package com.google.firebase.encoders.proto;

import com.adjust.sdk.Constants;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private OutputStream output;
    private final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    private static final FieldDescriptor MAP_KEY_DESC = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
    private static final FieldDescriptor MAP_VALUE_DESC = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
    private static final ObjectEncoder<Map.Entry<Object, Object>> DEFAULT_MAP_ENCODER = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, (ObjectEncoderContext) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    private static ByteBuffer allocateBuffer(int i5) {
        return ByteBuffer.allocate(i5).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long determineSize(ObjectEncoder<T> objectEncoder, T t5) {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(t5, this);
                this.output = outputStream;
                long length = lengthCountingOutputStream.getLength();
                lengthCountingOutputStream.close();
                return length;
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private <T> ProtobufDataEncoderContext doEncode(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t5, boolean z5) {
        long determineSize = determineSize(objectEncoder, t5);
        if (z5 && determineSize == 0) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
        writeVarInt64(determineSize);
        objectEncoder.encode(t5, this);
        return this;
    }

    private static Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Map.Entry entry, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(MAP_KEY_DESC, entry.getKey());
        objectEncoderContext.add(MAP_VALUE_DESC, entry.getValue());
    }

    private void writeVarInt32(int i5) {
        while ((i5 & (-128)) != 0) {
            this.output.write((i5 & 127) | 128);
            i5 >>>= 7;
        }
        this.output.write(i5 & 127);
    }

    private void writeVarInt64(long j5) {
        while (((-128) & j5) != 0) {
            this.output.write((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        this.output.write(((int) j5) & 127);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext encode(Object obj) {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(fieldDescriptor, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z5) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z5 && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                doEncode((ObjectEncoder<FieldDescriptor>) DEFAULT_MAP_ENCODER, fieldDescriptor, (FieldDescriptor) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return add(fieldDescriptor, ((Double) obj).doubleValue(), z5);
        }
        if (obj instanceof Float) {
            return add(fieldDescriptor, ((Float) obj).floatValue(), z5);
        }
        if (obj instanceof Number) {
            return add(fieldDescriptor, ((Number) obj).longValue(), z5);
        }
        if (obj instanceof Boolean) {
            return add(fieldDescriptor, ((Boolean) obj).booleanValue(), z5);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z5 && bArr.length == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt32(bArr.length);
            this.output.write(bArr);
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            return doEncode((ObjectEncoder<FieldDescriptor>) objectEncoder, fieldDescriptor, (FieldDescriptor) obj, z5);
        }
        ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            return doEncode((ValueEncoder<FieldDescriptor>) valueEncoder, fieldDescriptor, (FieldDescriptor) obj, z5);
        }
        if (obj instanceof ProtoEnum) {
            return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
        }
        if (obj instanceof Enum) {
            return add(fieldDescriptor, ((Enum) obj).ordinal());
        }
        return doEncode((ObjectEncoder<FieldDescriptor>) this.fallbackEncoder, fieldDescriptor, (FieldDescriptor) obj, z5);
    }

    private <T> ProtobufDataEncoderContext doEncode(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t5, boolean z5) {
        this.valueEncoderContext.resetContext(fieldDescriptor, z5);
        valueEncoder.encode(t5, this.valueEncoderContext);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d5) {
        return add(fieldDescriptor, d5, true);
    }

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d5, boolean z5) {
        if (z5 && d5 == 0.0d) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
        this.output.write(allocateBuffer(8).putDouble(d5).array());
        return this;
    }

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f5, boolean z5) {
        if (z5 && f5 == 0.0f) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
        this.output.write(allocateBuffer(4).putFloat(f5).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i5) {
        return add(fieldDescriptor, i5, true);
    }

    ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i5, boolean z5) {
        if (z5 && i5 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i6 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i6 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32(i5);
        } else if (i6 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32((i5 << 1) ^ (i5 >> 31));
        } else if (i6 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 5);
            this.output.write(allocateBuffer(4).putInt(i5).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j5) {
        return add(fieldDescriptor, j5, true);
    }

    ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j5, boolean z5) {
        if (z5 && j5 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i5 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i5 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64(j5);
        } else if (i5 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64((j5 >> 63) ^ (j5 << 1));
        } else if (i5 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 1);
            this.output.write(allocateBuffer(8).putLong(j5).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z5) {
        return add(fieldDescriptor, z5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z5, boolean z6) {
        return add(fieldDescriptor, z5 ? 1 : 0, z6);
    }
}
