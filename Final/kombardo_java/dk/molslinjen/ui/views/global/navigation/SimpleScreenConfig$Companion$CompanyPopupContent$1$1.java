package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.runtime.MutableState;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import dk.molslinjen.domain.managers.company.ICompanyViewHelper;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig$Companion$CompanyPopupContent$1$1", f = "SimpleScreenConfig.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleScreenConfig$Companion$CompanyPopupContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $closePopupCounter$delegate;
    final /* synthetic */ ICompanyViewHelper $companyViewHelper;
    final /* synthetic */ boolean $showCompanyPopup;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleScreenConfig$Companion$CompanyPopupContent$1$1(boolean z5, ICompanyViewHelper iCompanyViewHelper, MutableState<Integer> mutableState, Continuation<? super SimpleScreenConfig$Companion$CompanyPopupContent$1$1> continuation) {
        super(2, continuation);
        this.$showCompanyPopup = z5;
        this.$companyViewHelper = iCompanyViewHelper;
        this.$closePopupCounter$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleScreenConfig$Companion$CompanyPopupContent$1$1(this.$showCompanyPopup, this.$companyViewHelper, this.$closePopupCounter$delegate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0038 -> B:5:0x003b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int CompanyPopupContent$lambda$1;
        int CompanyPopupContent$lambda$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$showCompanyPopup) {
                return Unit.INSTANCE;
            }
            CompanyPopupContent$lambda$1 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$1(this.$closePopupCounter$delegate);
            if (CompanyPopupContent$lambda$1 < 5) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CompanyPopupContent$lambda$12 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$1(this.$closePopupCounter$delegate);
            SimpleScreenConfig.Companion.CompanyPopupContent$lambda$2(this.$closePopupCounter$delegate, CompanyPopupContent$lambda$12 + 1);
            CompanyPopupContent$lambda$1 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$1(this.$closePopupCounter$delegate);
            if (CompanyPopupContent$lambda$1 < 5) {
                Duration.Companion companion = Duration.INSTANCE;
                long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
                this.label = 1;
                if (DelayKt.m3760delayVtjQ1oo(duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                CompanyPopupContent$lambda$12 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$1(this.$closePopupCounter$delegate);
                SimpleScreenConfig.Companion.CompanyPopupContent$lambda$2(this.$closePopupCounter$delegate, CompanyPopupContent$lambda$12 + 1);
                CompanyPopupContent$lambda$1 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$1(this.$closePopupCounter$delegate);
                if (CompanyPopupContent$lambda$1 < 5) {
                    this.$companyViewHelper.hideCompanyPopup();
                    return Unit.INSTANCE;
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleScreenConfig$Companion$CompanyPopupContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
