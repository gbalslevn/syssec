package dk.molslinjen.domain.model.settings;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0016J:\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\r0\u0015\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0016JB\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u00132\u0006\u0010\u0018\u001a\u0002H\rH\u0096@¢\u0006\u0002\u0010\u0019J:\u0010\u001a\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u001bJ9\u0010\u001c\u001a\u0002H\r\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0016¢\u0006\u0002\u0010\u001dJL\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u0002H\r0\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0002JD\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\u0015\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0002J=\u0010\u000b\u001a\u0002H\r\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f*\u00020\b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0002¢\u0006\u0002\u0010 JC\u0010!\u001a\u0002H\r\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0002¢\u0006\u0002\u0010\"JL\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f0\u00132\u0006\u0010\u0018\u001a\u0002H\rH\u0082@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010%R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ldk/molslinjen/domain/model/settings/Settings;", "Ldk/molslinjen/domain/model/settings/ISettings;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "jsonSerializer", "Lkotlinx/serialization/json/Json;", "get", "Lkotlinx/coroutines/flow/StateFlow;", "ValueType", "KeyType", "SerializerType", "scope", "Lkotlinx/coroutines/CoroutineScope;", "property", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", "getFlow", "Lkotlinx/coroutines/flow/Flow;", "update", BuildConfig.FLAVOR, "newValue", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestValueFor", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;)Ljava/lang/Object;", "asStateFlow", "default", "(Landroidx/datastore/preferences/core/Preferences;Ldk/molslinjen/domain/model/settings/SettingsProperty;)Ljava/lang/Object;", "getBlocking", "(Landroidx/datastore/core/DataStore;Ldk/molslinjen/domain/model/settings/SettingsProperty;)Ljava/lang/Object;", "(Landroidx/datastore/core/DataStore;Ldk/molslinjen/domain/model/settings/SettingsProperty;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Settings implements ISettings {
    private final DataStore<Preferences> dataStore;
    private final Json jsonSerializer;

    public Settings(Context context) {
        DataStore<Preferences> dataStore;
        Intrinsics.checkNotNullParameter(context, "context");
        dataStore = SettingsKt.getDataStore(context);
        this.dataStore = dataStore;
        this.jsonSerializer = JsonKt.Json$default(null, new Function1() { // from class: dk.molslinjen.domain.model.settings.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit jsonSerializer$lambda$0;
                jsonSerializer$lambda$0 = Settings.jsonSerializer$lambda$0((JsonBuilder) obj);
                return jsonSerializer$lambda$0;
            }
        }, 1, null);
    }

    private final <KeyType, ValueType, SerializerType> StateFlow<ValueType> asStateFlow(Flow<? extends ValueType> flow, CoroutineScope coroutineScope, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty) {
        return FlowKt.stateIn(flow, coroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), settingsProperty.getDefaultValue());
    }

    private final <KeyType, ValueType, SerializerType> ValueType getBlocking(DataStore<Preferences> dataStore, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty) {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new Settings$getBlocking$1(this, dataStore, settingsProperty, null), 1, null);
        return (ValueType) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonSerializer$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public Object clear(Continuation<? super Unit> continuation) {
        Object edit = PreferencesKt.edit(this.dataStore, new Settings$clear$2(null), continuation);
        return edit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? edit : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public <KeyType, ValueType, SerializerType> StateFlow<ValueType> get(CoroutineScope scope, SettingsProperty<KeyType, ValueType, SerializerType> property) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(property, "property");
        return asStateFlow(get(this.dataStore, property), scope, property);
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public <KeyType, ValueType, SerializerType> Flow<ValueType> getFlow(SettingsProperty<KeyType, ValueType, SerializerType> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return FlowKt.distinctUntilChanged(get(this.dataStore, property));
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public <KeyType, ValueType, SerializerType> ValueType latestValueFor(SettingsProperty<KeyType, ValueType, SerializerType> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (ValueType) getBlocking(this.dataStore, property);
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public <KeyType, ValueType, SerializerType> Object reset(SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, Continuation<? super Unit> continuation) {
        Object update = update(this.dataStore, settingsProperty, settingsProperty.getDefaultValue(), continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.model.settings.ISettings
    public <KeyType, ValueType, SerializerType> Object update(SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, ValueType valuetype, Continuation<? super Unit> continuation) {
        Object update = update(this.dataStore, settingsProperty, valuetype, continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    private final <KeyType, ValueType, SerializerType> Flow<ValueType> get(DataStore<Preferences> dataStore, final SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty) {
        final Flow<Preferences> data = dataStore.getData();
        return new Flow<ValueType>() { // from class: dk.molslinjen.domain.model.settings.Settings$get$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.domain.model.settings.Settings$get$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ SettingsProperty $property$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Settings this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.domain.model.settings.Settings$get$$inlined$map$1$2", f = "Settings.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.domain.model.settings.Settings$get$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Settings settings, SettingsProperty settingsProperty) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = settings;
                    this.$property$inlined = settingsProperty;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    Object obj2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj3 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj3);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                obj2 = this.this$0.get((Preferences) obj, (SettingsProperty<KeyType, Object, SerializerType>) this.$property$inlined);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj3);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj32 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, settingsProperty), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <KeyType, ValueType, SerializerType> Object update(DataStore<Preferences> dataStore, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, ValueType valuetype, Continuation<? super Unit> continuation) {
        Object edit = PreferencesKt.edit(dataStore, new Settings$update$3(valuetype, settingsProperty, this, null), continuation);
        return edit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? edit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <KeyType, ValueType, SerializerType> ValueType get(Preferences preferences, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty) {
        ValueType valuetype = (ValueType) preferences.get(settingsProperty.getKey());
        if (settingsProperty.getOptionalSerializer() == null || valuetype == 0) {
            return valuetype == 0 ? settingsProperty.getDefaultValue() : valuetype;
        }
        return (ValueType) this.jsonSerializer.decodeFromString(settingsProperty.getOptionalSerializer(), (String) valuetype);
    }
}
