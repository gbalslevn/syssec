package dk.molslinjen.ui.views.screens.profile.currencies;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.checkout.ICurrencyManager;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel$selectCurrency$1", f = "CurrenciesViewModel.kt", l = {38, 39}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CurrenciesViewModel$selectCurrency$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CurrencyType $currencyType;
    int label;
    final /* synthetic */ CurrenciesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrenciesViewModel$selectCurrency$1(CurrenciesViewModel currenciesViewModel, CurrencyType currencyType, Context context, Continuation<? super CurrenciesViewModel$selectCurrency$1> continuation) {
        super(2, continuation);
        this.this$0 = currenciesViewModel;
        this.$currencyType = currencyType;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CurrenciesViewModel$selectCurrency$1(this.this$0, this.$currencyType, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            ICurrencyManager iCurrencyManager = this.this$0.currencyManager;
            CurrencyType currencyType = this.$currencyType;
            this.label = 1;
            if (iCurrencyManager.selectCurrency(currencyType, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        SnackbarEvent.Default r12 = new SnackbarEvent.Default(new SnackbarText.ResourceTextWithResourcePlaceholders(R.string.currencies_selected, CollectionsKt.listOf(PriceFormatExtensionsKt.formatted(this.$currencyType, this.$context))), null, false, SnackbarDuration.Short, null, 22, null);
        this.label = 2;
        if (iSnackbarService.publishEvent(r12, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CurrenciesViewModel$selectCurrency$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
