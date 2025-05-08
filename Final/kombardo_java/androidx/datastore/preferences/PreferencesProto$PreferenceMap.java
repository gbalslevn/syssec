package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class PreferencesProto$PreferenceMap extends GeneratedMessageLite<PreferencesProto$PreferenceMap, Builder> implements MessageLiteOrBuilder {
    private static final PreferencesProto$PreferenceMap DEFAULT_INSTANCE;
    private static volatile Parser<PreferencesProto$PreferenceMap> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.emptyMapField();

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PreferencesProto$PreferenceMap, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(PreferencesProto$1 preferencesProto$1) {
            this();
        }

        public Builder putPreferences(String str, PreferencesProto$Value preferencesProto$Value) {
            str.getClass();
            preferencesProto$Value.getClass();
            copyOnWrite();
            ((PreferencesProto$PreferenceMap) this.instance).getMutablePreferencesMap().put(str, preferencesProto$Value);
            return this;
        }

        private Builder() {
            super(PreferencesProto$PreferenceMap.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    private static final class PreferencesDefaultEntryHolder {
        static final MapEntryLite<String, PreferencesProto$Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, BuildConfig.FLAVOR, WireFormat.FieldType.MESSAGE, PreferencesProto$Value.getDefaultInstance());
    }

    static {
        PreferencesProto$PreferenceMap preferencesProto$PreferenceMap = new PreferencesProto$PreferenceMap();
        DEFAULT_INSTANCE = preferencesProto$PreferenceMap;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$PreferenceMap.class, preferencesProto$PreferenceMap);
    }

    private PreferencesProto$PreferenceMap() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, PreferencesProto$Value> getMutablePreferencesMap() {
        return internalGetMutablePreferences();
    }

    private MapFieldLite<String, PreferencesProto$Value> internalGetMutablePreferences() {
        if (!this.preferences_.isMutable()) {
            this.preferences_ = this.preferences_.mutableCopy();
        }
        return this.preferences_;
    }

    private MapFieldLite<String, PreferencesProto$Value> internalGetPreferences() {
        return this.preferences_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PreferencesProto$PreferenceMap parseFrom(InputStream inputStream) {
        return (PreferencesProto$PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        PreferencesProto$1 preferencesProto$1 = null;
        switch (PreferencesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PreferencesProto$PreferenceMap();
            case 2:
                return new Builder(preferencesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PreferencesProto$PreferenceMap> parser = PARSER;
                if (parser == null) {
                    synchronized (PreferencesProto$PreferenceMap.class) {
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

    public Map<String, PreferencesProto$Value> getPreferencesMap() {
        return Collections.unmodifiableMap(internalGetPreferences());
    }
}
