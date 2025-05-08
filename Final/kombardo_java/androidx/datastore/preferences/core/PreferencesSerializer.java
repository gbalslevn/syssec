package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto$PreferenceMap;
import androidx.datastore.preferences.PreferencesProto$StringSet;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/datastore/preferences/core/PreferencesSerializer;", "Landroidx/datastore/core/okio/OkioSerializer;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "()V", BuildConfig.FLAVOR, "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "getValueProto", "(Ljava/lang/Object;)Landroidx/datastore/preferences/PreferencesProto$Value;", BuildConfig.FLAVOR, "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", BuildConfig.FLAVOR, "addProtoEntryToPreferences", "(Ljava/lang/String;Landroidx/datastore/preferences/PreferencesProto$Value;Landroidx/datastore/preferences/core/MutablePreferences;)V", "Lokio/BufferedSource;", "source", "readFrom", "(Lokio/BufferedSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Lokio/BufferedSink;", "sink", "writeTo", "(Landroidx/datastore/preferences/core/Preferences;Lokio/BufferedSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultValue", "()Landroidx/datastore/preferences/core/Preferences;", "defaultValue", "datastore-preferences-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreferencesSerializer implements OkioSerializer<Preferences> {
    public static final PreferencesSerializer INSTANCE = new PreferencesSerializer();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            try {
                iArr[PreferencesProto$Value.ValueCase.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreferencesSerializer() {
    }

    private final void addProtoEntryToPreferences(String name, PreferencesProto$Value value, MutablePreferences mutablePreferences) {
        PreferencesProto$Value.ValueCase valueCase = value.getValueCase();
        switch (valueCase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[valueCase.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                mutablePreferences.set(PreferencesKeys.booleanKey(name), Boolean.valueOf(value.getBoolean()));
                return;
            case 2:
                mutablePreferences.set(PreferencesKeys.floatKey(name), Float.valueOf(value.getFloat()));
                return;
            case 3:
                mutablePreferences.set(PreferencesKeys.doubleKey(name), Double.valueOf(value.getDouble()));
                return;
            case 4:
                mutablePreferences.set(PreferencesKeys.intKey(name), Integer.valueOf(value.getInteger()));
                return;
            case 5:
                mutablePreferences.set(PreferencesKeys.longKey(name), Long.valueOf(value.getLong()));
                return;
            case 6:
                Preferences.Key<String> stringKey = PreferencesKeys.stringKey(name);
                String string = value.getString();
                Intrinsics.checkNotNullExpressionValue(string, "value.string");
                mutablePreferences.set(stringKey, string);
                return;
            case 7:
                Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(name);
                List<String> stringsList = value.getStringSet().getStringsList();
                Intrinsics.checkNotNullExpressionValue(stringsList, "value.stringSet.stringsList");
                mutablePreferences.set(stringSetKey, CollectionsKt.toSet(stringsList));
                return;
            case 8:
                Preferences.Key<byte[]> byteArrayKey = PreferencesKeys.byteArrayKey(name);
                byte[] byteArray = value.getBytes().toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "value.bytes.toByteArray()");
                mutablePreferences.set(byteArrayKey, byteArray);
                return;
            case 9:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final PreferencesProto$Value getValueProto(Object value) {
        if (value instanceof Boolean) {
            PreferencesProto$Value build = PreferencesProto$Value.newBuilder().setBoolean(((Boolean) value).booleanValue()).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setBoolean(value).build()");
            return build;
        }
        if (value instanceof Float) {
            PreferencesProto$Value build2 = PreferencesProto$Value.newBuilder().setFloat(((Number) value).floatValue()).build();
            Intrinsics.checkNotNullExpressionValue(build2, "newBuilder().setFloat(value).build()");
            return build2;
        }
        if (value instanceof Double) {
            PreferencesProto$Value build3 = PreferencesProto$Value.newBuilder().setDouble(((Number) value).doubleValue()).build();
            Intrinsics.checkNotNullExpressionValue(build3, "newBuilder().setDouble(value).build()");
            return build3;
        }
        if (value instanceof Integer) {
            PreferencesProto$Value build4 = PreferencesProto$Value.newBuilder().setInteger(((Number) value).intValue()).build();
            Intrinsics.checkNotNullExpressionValue(build4, "newBuilder().setInteger(value).build()");
            return build4;
        }
        if (value instanceof Long) {
            PreferencesProto$Value build5 = PreferencesProto$Value.newBuilder().setLong(((Number) value).longValue()).build();
            Intrinsics.checkNotNullExpressionValue(build5, "newBuilder().setLong(value).build()");
            return build5;
        }
        if (value instanceof String) {
            PreferencesProto$Value build6 = PreferencesProto$Value.newBuilder().setString((String) value).build();
            Intrinsics.checkNotNullExpressionValue(build6, "newBuilder().setString(value).build()");
            return build6;
        }
        if (value instanceof Set) {
            PreferencesProto$Value.Builder newBuilder = PreferencesProto$Value.newBuilder();
            PreferencesProto$StringSet.Builder newBuilder2 = PreferencesProto$StringSet.newBuilder();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            PreferencesProto$Value build7 = newBuilder.setStringSet(newBuilder2.addAllStrings((Set) value)).build();
            Intrinsics.checkNotNullExpressionValue(build7, "newBuilder().setStringSe…                ).build()");
            return build7;
        }
        if (value instanceof byte[]) {
            PreferencesProto$Value build8 = PreferencesProto$Value.newBuilder().setBytes(ByteString.copyFrom((byte[]) value)).build();
            Intrinsics.checkNotNullExpressionValue(build8, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return build8;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + value.getClass().getName());
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(BufferedSource bufferedSource, Continuation<? super Preferences> continuation) {
        PreferencesProto$PreferenceMap readFrom = PreferencesMapCompat.INSTANCE.readFrom(bufferedSource.inputStream());
        MutablePreferences createMutable = PreferencesFactory.createMutable(new Preferences.Pair[0]);
        Map<String, PreferencesProto$Value> preferencesMap = readFrom.getPreferencesMap();
        Intrinsics.checkNotNullExpressionValue(preferencesMap, "preferencesProto.preferencesMap");
        for (Map.Entry<String, PreferencesProto$Value> entry : preferencesMap.entrySet()) {
            String name = entry.getKey();
            PreferencesProto$Value value = entry.getValue();
            PreferencesSerializer preferencesSerializer = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            preferencesSerializer.addProtoEntryToPreferences(name, value, createMutable);
        }
        return createMutable.toPreferences();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public /* bridge */ /* synthetic */ Object writeTo(Preferences preferences, BufferedSink bufferedSink, Continuation continuation) {
        return writeTo2(preferences, bufferedSink, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.okio.OkioSerializer
    public Preferences getDefaultValue() {
        return PreferencesFactory.createEmpty();
    }

    /* renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(Preferences preferences, BufferedSink bufferedSink, Continuation<? super Unit> continuation) {
        Map<Preferences.Key<?>, Object> asMap = preferences.asMap();
        PreferencesProto$PreferenceMap.Builder newBuilder = PreferencesProto$PreferenceMap.newBuilder();
        for (Map.Entry<Preferences.Key<?>, Object> entry : asMap.entrySet()) {
            newBuilder.putPreferences(entry.getKey().getName(), getValueProto(entry.getValue()));
        }
        newBuilder.build().writeTo(bufferedSink.outputStream());
        return Unit.INSTANCE;
    }
}
