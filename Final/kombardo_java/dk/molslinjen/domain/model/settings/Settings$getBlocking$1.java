package dk.molslinjen.domain.model.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [ValueType] */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "ValueType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.model.settings.Settings$getBlocking$1", f = "Settings.kt", l = {88}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class Settings$getBlocking$1<ValueType> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ValueType>, Object> {
    final /* synthetic */ SettingsProperty<KeyType, ValueType, SerializerType> $property;
    final /* synthetic */ DataStore<Preferences> $this_getBlocking;
    Object L$0;
    int label;
    final /* synthetic */ Settings this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Settings$getBlocking$1(Settings settings, DataStore<Preferences> dataStore, SettingsProperty<KeyType, ValueType, SerializerType> settingsProperty, Continuation<? super Settings$getBlocking$1> continuation) {
        super(2, continuation);
        this.this$0 = settings;
        this.$this_getBlocking = dataStore;
        this.$property = settingsProperty;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Settings$getBlocking$1(this.this$0, this.$this_getBlocking, this.$property, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Settings settings;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Settings settings2 = this.this$0;
            Flow<Preferences> data = this.$this_getBlocking.getData();
            this.L$0 = settings2;
            this.label = 1;
            Object first = FlowKt.first(data, this);
            if (first == coroutine_suspended) {
                return coroutine_suspended;
            }
            settings = settings2;
            obj = first;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            settings = (Settings) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        obj2 = settings.get((Preferences) obj, this.$property);
        return obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ValueType> continuation) {
        return ((Settings$getBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
