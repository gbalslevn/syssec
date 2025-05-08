package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$selectDefaultVehicle$1", f = "CheckoutManager.kt", l = {742, 742}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CheckoutManager$selectDefaultVehicle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$selectDefaultVehicle$1$1", f = "CheckoutManager.kt", l = {753, 757}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.checkout.CheckoutManager$selectDefaultVehicle$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckoutManager.CheckoutState $checkoutState;
        final /* synthetic */ String $commuterLicensePlate;
        final /* synthetic */ String $lastUsedVehicleId;
        final /* synthetic */ CheckoutManager.CheckoutDirectionState $outboundDirectionState;
        Object L$0;
        int label;
        final /* synthetic */ CheckoutManager this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$selectDefaultVehicle$1$1$1", f = "CheckoutManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.checkout.CheckoutManager$selectDefaultVehicle$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00361 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserVehicle $defaultVehicle;
            int label;
            final /* synthetic */ CheckoutManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00361(CheckoutManager checkoutManager, UserVehicle userVehicle, Continuation<? super C00361> continuation) {
                super(2, continuation);
                this.this$0 = checkoutManager;
                this.$defaultVehicle = userVehicle;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00361(this.this$0, this.$defaultVehicle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.updateSelectedVehicle(this.$defaultVehicle);
                return Unit.INSTANCE;
            }

            public final Object invoke(boolean z5, Continuation<? super Unit> continuation) {
                return ((C00361) create(Boolean.valueOf(z5), continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CheckoutManager checkoutManager, String str, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutState checkoutState, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = checkoutManager;
            this.$commuterLicensePlate = str;
            this.$outboundDirectionState = checkoutDirectionState;
            this.$checkoutState = checkoutState;
            this.$lastUsedVehicleId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$commuterLicensePlate, this.$outboundDirectionState, this.$checkoutState, this.$lastUsedVehicleId, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            IUserVehiclesManager iUserVehiclesManager;
            Object obj2;
            UserVehicle userVehicle;
            UserVehicle userVehicle2;
            IUserVehiclesManager iUserVehiclesManager2;
            Object obj3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iUserVehiclesManager = this.this$0.vehiclesManager;
                List<UserVehicle> vehicles = iUserVehiclesManager.getVehiclesState().getValue().getVehicles();
                String str = this.$commuterLicensePlate;
                if (str != null) {
                    Iterator<T> it = vehicles.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it.next();
                        if (Intrinsics.areEqual(((UserVehicle) obj3).getLicensePlate(), str)) {
                            break;
                        }
                    }
                    userVehicle = (UserVehicle) obj3;
                    if (userVehicle == null) {
                        userVehicle2 = new UserVehicle(this.$commuterLicensePlate);
                        if (userVehicle2 != null) {
                            return Unit.INSTANCE;
                        }
                        iUserVehiclesManager2 = this.this$0.vehiclesManager;
                        String carId = this.$outboundDirectionState.getDepartureTicket().getCarId();
                        Site site = this.$checkoutState.getSite();
                        this.L$0 = userVehicle2;
                        this.label = 1;
                        obj = iUserVehiclesManager2.validateVehicle(userVehicle2, carId, site, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    String str2 = this.$lastUsedVehicleId;
                    Iterator<T> it2 = vehicles.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((UserVehicle) obj2).getId(), str2)) {
                            break;
                        }
                    }
                    userVehicle = (UserVehicle) obj2;
                }
                userVehicle2 = userVehicle;
                if (userVehicle2 != null) {
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                userVehicle2 = (UserVehicle) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            C00361 c00361 = new C00361(this.this$0, userVehicle2, null);
            this.L$0 = null;
            this.label = 2;
            if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, c00361, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutManager$selectDefaultVehicle$1(CheckoutManager checkoutManager, Continuation<? super CheckoutManager$selectDefaultVehicle$1> continuation) {
        super(2, continuation);
        this.this$0 = checkoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckoutManager$selectDefaultVehicle$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CheckoutManager.CheckoutState value;
        CheckoutManager.CheckoutDirectionState value2;
        ISettings iSettings;
        IUserVehiclesManager iUserVehiclesManager;
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            value = this.this$0.getCheckoutState().getValue();
            if (value != null && (value2 = this.this$0.getOutboundDirectionState().getValue()) != null) {
                CommuterBookingData commuterBookingData = value.getCommuterBookingData();
                String licensePlate = commuterBookingData != null ? commuterBookingData.getLicensePlate() : null;
                iSettings = this.this$0.settings;
                String str3 = (String) iSettings.latestValueFor(SettingsProperty.Checkout.LastSelectedVehicleId.INSTANCE);
                if ((str3 == null && licensePlate == null) || value.getTransportation().isWalking()) {
                    return Unit.INSTANCE;
                }
                iUserVehiclesManager = this.this$0.vehiclesManager;
                this.L$0 = value;
                this.L$1 = value2;
                this.L$2 = licensePlate;
                this.L$3 = str3;
                this.label = 1;
                Object loadVehicles = iUserVehiclesManager.loadVehicles(this);
                if (loadVehicles == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = licensePlate;
                str2 = str3;
                obj = loadVehicles;
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        String str4 = (String) this.L$3;
        String str5 = (String) this.L$2;
        value2 = (CheckoutManager.CheckoutDirectionState) this.L$1;
        value = (CheckoutManager.CheckoutState) this.L$0;
        ResultKt.throwOnFailure(obj);
        str2 = str4;
        str = str5;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, str, value2, value, str2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckoutManager$selectDefaultVehicle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
