package dk.molslinjen.domain.model.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\nH&J:\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\f\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00062\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\nH&JB\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00062\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\n2\u0006\u0010\u000f\u001a\u0002H\u0004H¦@¢\u0006\u0002\u0010\u0010J9\u0010\u0011\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00062\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\nH&¢\u0006\u0002\u0010\u0012J:\u0010\u0013\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00062\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\nH¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/model/settings/ISettings;", BuildConfig.FLAVOR, "get", "Lkotlinx/coroutines/flow/StateFlow;", "ValueType", "KeyType", "SerializerType", "scope", "Lkotlinx/coroutines/CoroutineScope;", "property", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", "getFlow", "Lkotlinx/coroutines/flow/Flow;", "update", BuildConfig.FLAVOR, "newValue", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestValueFor", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;)Ljava/lang/Object;", "reset", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISettings {
    Object clear(Continuation<? super Unit> continuation);

    <KeyType, ValueType, SerializerType> StateFlow<ValueType> get(CoroutineScope scope, SettingsProperty<KeyType, ValueType, SerializerType> property);

    <KeyType, ValueType, SerializerType> Flow<ValueType> getFlow(SettingsProperty<KeyType, ValueType, SerializerType> property);

    <KeyType, ValueType, SerializerType> ValueType latestValueFor(SettingsProperty<KeyType, ValueType, SerializerType> property);

    <KeyType, ValueType, SerializerType> Object reset(SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, Continuation<? super Unit> continuation);

    <KeyType, ValueType, SerializerType> Object update(SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, ValueType valuetype, Continuation<? super Unit> continuation);
}
