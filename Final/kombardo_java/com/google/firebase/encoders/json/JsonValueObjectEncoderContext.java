package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    private final ObjectEncoder<Object> fallbackEncoder;
    private final boolean ignoreNullValues;
    private final JsonWriter jsonWriter;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    private JsonValueObjectEncoderContext childContext = null;
    private boolean active = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext(Writer writer, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z5) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
        this.ignoreNullValues = z5;
    }

    private boolean cannotBeInline(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private JsonValueObjectEncoderContext internalAdd(String str, Object obj) {
        maybeUnNest();
        this.jsonWriter.name(str);
        if (obj != null) {
            return add(obj, false);
        }
        this.jsonWriter.nullValue();
        return this;
    }

    private JsonValueObjectEncoderContext internalAddIgnoreNullValues(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(obj, false);
    }

    private void maybeUnNest() {
        if (!this.active) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
        if (jsonValueObjectEncoderContext != null) {
            jsonValueObjectEncoderContext.maybeUnNest();
            this.childContext.active = false;
            this.childContext = null;
            this.jsonWriter.endObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        maybeUnNest();
        this.jsonWriter.flush();
    }

    JsonValueObjectEncoderContext doEncode(ObjectEncoder<Object> objectEncoder, Object obj, boolean z5) {
        if (!z5) {
            this.jsonWriter.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z5) {
            this.jsonWriter.endObject();
        }
        return this;
    }

    public JsonValueObjectEncoderContext add(String str, Object obj) {
        if (this.ignoreNullValues) {
            return internalAddIgnoreNullValues(str, obj);
        }
        return internalAdd(str, obj);
    }

    public JsonValueObjectEncoderContext add(String str, double d5) {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(d5);
    }

    public JsonValueObjectEncoderContext add(String str, int i5) {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(i5);
    }

    public JsonValueObjectEncoderContext add(String str, long j5) {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(j5);
    }

    public JsonValueObjectEncoderContext add(String str, boolean z5) {
        maybeUnNest();
        this.jsonWriter.name(str);
        return add(z5);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(fieldDescriptor.getName(), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d5) {
        return add(fieldDescriptor.getName(), d5);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i5) {
        return add(fieldDescriptor.getName(), i5);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j5) {
        return add(fieldDescriptor.getName(), j5);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z5) {
        return add(fieldDescriptor.getName(), z5);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public JsonValueObjectEncoderContext add(String str) {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    public JsonValueObjectEncoderContext add(double d5) {
        maybeUnNest();
        this.jsonWriter.value(d5);
        return this;
    }

    public JsonValueObjectEncoderContext add(int i5) {
        maybeUnNest();
        this.jsonWriter.value(i5);
        return this;
    }

    public JsonValueObjectEncoderContext add(long j5) {
        maybeUnNest();
        this.jsonWriter.value(j5);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public JsonValueObjectEncoderContext add(boolean z5) {
        maybeUnNest();
        this.jsonWriter.value(z5);
        return this;
    }

    public JsonValueObjectEncoderContext add(byte[] bArr) {
        maybeUnNest();
        if (bArr == null) {
            this.jsonWriter.nullValue();
        } else {
            this.jsonWriter.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext add(Object obj, boolean z5) {
        if (z5 && cannotBeInline(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.jsonWriter.value((Number) obj);
            return this;
        }
        int i5 = 0;
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return add((byte[]) obj);
            }
            this.jsonWriter.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i5 < length) {
                    this.jsonWriter.value(r6[i5]);
                    i5++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i5 < length2) {
                    add(jArr[i5]);
                    i5++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i5 < length3) {
                    this.jsonWriter.value(dArr[i5]);
                    i5++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i5 < length4) {
                    this.jsonWriter.value(zArr[i5]);
                    i5++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    add((Object) number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    add(obj2, false);
                }
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            this.jsonWriter.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(it.next(), false);
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Map) {
            this.jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e5) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e5);
                }
            }
            this.jsonWriter.endObject();
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            return doEncode(objectEncoder, obj, z5);
        }
        ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            valueEncoder.encode(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            if (obj instanceof NumberedEnum) {
                add(((NumberedEnum) obj).getNumber());
            } else {
                add(((Enum) obj).name());
            }
            return this;
        }
        return doEncode(this.fallbackEncoder, obj, z5);
    }
}
