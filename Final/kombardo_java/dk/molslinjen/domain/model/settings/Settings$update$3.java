package dk.molslinjen.domain.model.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.json.Json;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.model.settings.Settings$update$3", f = "Settings.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class Settings$update$3 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    final /* synthetic */ ValueType $newValue;
    final /* synthetic */ SettingsProperty<KeyType, ValueType, SerializerType> $property;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Settings this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Settings$update$3(ValueType valuetype, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, Settings settings, Continuation<? super Settings$update$3> continuation) {
        super(2, continuation);
        this.$newValue = valuetype;
        this.$property = settingsProperty;
        this.this$0 = settings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Settings$update$3 settings$update$3 = new Settings$update$3(this.$newValue, this.$property, this.this$0, continuation);
        settings$update$3.L$0 = obj;
        return settings$update$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((Settings$update$3) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Json json;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
        if (this.$newValue == 0) {
            mutablePreferences.remove(this.$property.getKey());
        } else {
            if (this.$property.getOptionalSerializer() != null) {
                json = this.this$0.jsonSerializer;
                obj2 = json.encodeToString(this.$property.getOptionalSerializer(), this.$newValue);
            } else {
                obj2 = this.$newValue;
            }
            mutablePreferences.set(this.$property.getKey(), obj2);
        }
        return Unit.INSTANCE;
    }
}
