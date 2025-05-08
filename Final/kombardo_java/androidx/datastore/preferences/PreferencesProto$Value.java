package androidx.datastore.preferences;

import androidx.datastore.preferences.PreferencesProto$StringSet;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, Builder> implements MessageLiteOrBuilder {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile Parser<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PreferencesProto$Value, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(PreferencesProto$1 preferencesProto$1) {
            this();
        }

        public Builder setBoolean(boolean z5) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setBoolean(z5);
            return this;
        }

        public Builder setBytes(ByteString byteString) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setBytes(byteString);
            return this;
        }

        public Builder setDouble(double d5) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setDouble(d5);
            return this;
        }

        public Builder setFloat(float f5) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setFloat(f5);
            return this;
        }

        public Builder setInteger(int i5) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setInteger(i5);
            return this;
        }

        public Builder setLong(long j5) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setLong(j5);
            return this;
        }

        public Builder setString(String str) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setString(str);
            return this;
        }

        public Builder setStringSet(PreferencesProto$StringSet.Builder builder) {
            copyOnWrite();
            ((PreferencesProto$Value) this.instance).setStringSet(builder.build());
            return this;
        }

        private Builder() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public enum ValueCase {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        BYTES(8),
        VALUE_NOT_SET(0);

        private final int value;

        ValueCase(int i5) {
            this.value = i5;
        }

        public static ValueCase forNumber(int i5) {
            switch (i5) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                case 8:
                    return BYTES;
                default:
                    return null;
            }
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$Value.class, preferencesProto$Value);
    }

    private PreferencesProto$Value() {
    }

    public static PreferencesProto$Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBoolean(boolean z5) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytes(ByteString byteString) {
        byteString.getClass();
        this.valueCase_ = 8;
        this.value_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDouble(double d5) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFloat(float f5) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInteger(int i5) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLong(long j5) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setString(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringSet(PreferencesProto$StringSet preferencesProto$StringSet) {
        preferencesProto$StringSet.getClass();
        this.value_ = preferencesProto$StringSet;
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        PreferencesProto$1 preferencesProto$1 = null;
        switch (PreferencesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PreferencesProto$Value();
            case 2:
                return new Builder(preferencesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", PreferencesProto$StringSet.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PreferencesProto$Value> parser = PARSER;
                if (parser == null) {
                    synchronized (PreferencesProto$Value.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } finally {
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public boolean getBoolean() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public ByteString getBytes() {
        return this.valueCase_ == 8 ? (ByteString) this.value_ : ByteString.EMPTY;
    }

    public double getDouble() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float getFloat() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int getInteger() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long getLong() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String getString() {
        return this.valueCase_ == 5 ? (String) this.value_ : BuildConfig.FLAVOR;
    }

    public PreferencesProto$StringSet getStringSet() {
        return this.valueCase_ == 6 ? (PreferencesProto$StringSet) this.value_ : PreferencesProto$StringSet.getDefaultInstance();
    }

    public ValueCase getValueCase() {
        return ValueCase.forNumber(this.valueCase_);
    }
}
