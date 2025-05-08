package dk.molslinjen.domain.managers.notification;

import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;
import uniffi.molslinjen_shared.AgillicClientId;
import uniffi.molslinjen_shared.AgillicHandlerInterface;
import uniffi.molslinjen_shared.AgillicInstallationId;
import uniffi.molslinjen_shared.AgillicReportId;
import uniffi.molslinjen_shared.Consent;
import uniffi.molslinjen_shared.FeedbackStatus;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000f\u0010\u000eJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0014\u0010\u000eJ\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/managers/notification/MarketingNotificationManager;", "Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "Luniffi/molslinjen_shared/AgillicHandlerInterface;", "agillicHandler", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/domain/model/settings/ISettings;", "settings", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "notificationManager", "<init>", "(Luniffi/molslinjen_shared/AgillicHandlerInterface;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/managers/notification/INotificationManager;)V", BuildConfig.FLAVOR, "awaitEmailSet", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRegistrationOnTokenSet", BuildConfig.FLAVOR, "getEmail", "()Ljava/lang/String;", "register", "withdrawConsent", "Luniffi/molslinjen_shared/AgillicReportId;", Constants.IntentExtra.ReportId, "trackOpenedNotification", "(Luniffi/molslinjen_shared/AgillicReportId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Luniffi/molslinjen_shared/AgillicHandlerInterface;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/domain/model/settings/ISettings;", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/threeten/bp/LocalDateTime;", "getNowPlusOneYear", "()Lorg/threeten/bp/LocalDateTime;", "nowPlusOneYear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MarketingNotificationManager implements IMarketingNotificationManager {
    private final AgillicHandlerInterface agillicHandler;
    private final INotificationManager notificationManager;
    private final CoroutineScope scope;
    private final ISettings settings;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.notification.MarketingNotificationManager$1", f = "MarketingNotificationManager.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.notification.MarketingNotificationManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                MarketingNotificationManager marketingNotificationManager = MarketingNotificationManager.this;
                this.label = 1;
                if (marketingNotificationManager.awaitEmailSet(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.notification.MarketingNotificationManager$2", f = "MarketingNotificationManager.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.notification.MarketingNotificationManager$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                MarketingNotificationManager marketingNotificationManager = MarketingNotificationManager.this;
                this.label = 1;
                if (marketingNotificationManager.updateRegistrationOnTokenSet(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MarketingNotificationManager(AgillicHandlerInterface agillicHandler, IUserManager userManager, ISettings settings, INotificationManager notificationManager) {
        Intrinsics.checkNotNullParameter(agillicHandler, "agillicHandler");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        this.agillicHandler = agillicHandler;
        this.userManager = userManager;
        this.settings = settings;
        this.notificationManager = notificationManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.scope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitEmailSet(Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(this.userManager.getCurrentUserState(), new MarketingNotificationManager$awaitEmailSet$2(this, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    private final String getEmail() {
        UserContactDetails contactDetails;
        UserInfo details = this.userManager.getCurrentUserState().getValue().getUser().getDetails();
        if (details == null || (contactDetails = details.getContactDetails()) == null) {
            return null;
        }
        return contactDetails.getEmail();
    }

    private final LocalDateTime getNowPlusOneYear() {
        LocalDateTime plusYears = LocalDateTime.now().plusYears(1L);
        Intrinsics.checkNotNullExpressionValue(plusYears, "plusYears(...)");
        return plusYears;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateRegistrationOnTokenSet(Continuation<? super Unit> continuation) {
        MarketingNotificationManager$updateRegistrationOnTokenSet$1 marketingNotificationManager$updateRegistrationOnTokenSet$1;
        int i5;
        MarketingNotificationManager marketingNotificationManager;
        if (continuation instanceof MarketingNotificationManager$updateRegistrationOnTokenSet$1) {
            marketingNotificationManager$updateRegistrationOnTokenSet$1 = (MarketingNotificationManager$updateRegistrationOnTokenSet$1) continuation;
            int i6 = marketingNotificationManager$updateRegistrationOnTokenSet$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                marketingNotificationManager$updateRegistrationOnTokenSet$1.label = i6 - Integer.MIN_VALUE;
                Object obj = marketingNotificationManager$updateRegistrationOnTokenSet$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = marketingNotificationManager$updateRegistrationOnTokenSet$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    INotificationManager iNotificationManager = this.notificationManager;
                    marketingNotificationManager$updateRegistrationOnTokenSet$1.L$0 = this;
                    marketingNotificationManager$updateRegistrationOnTokenSet$1.label = 1;
                    if (iNotificationManager.awaitNonNullToken(marketingNotificationManager$updateRegistrationOnTokenSet$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketingNotificationManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    marketingNotificationManager = (MarketingNotificationManager) marketingNotificationManager$updateRegistrationOnTokenSet$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) marketingNotificationManager.settings.latestValueFor(SettingsProperty.Notifications.MarketingNotificationsEnabled.INSTANCE)).booleanValue()) {
                    return Unit.INSTANCE;
                }
                marketingNotificationManager$updateRegistrationOnTokenSet$1.L$0 = null;
                marketingNotificationManager$updateRegistrationOnTokenSet$1.label = 2;
                if (marketingNotificationManager.register(marketingNotificationManager$updateRegistrationOnTokenSet$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        marketingNotificationManager$updateRegistrationOnTokenSet$1 = new MarketingNotificationManager$updateRegistrationOnTokenSet$1(this, continuation);
        Object obj2 = marketingNotificationManager$updateRegistrationOnTokenSet$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = marketingNotificationManager$updateRegistrationOnTokenSet$1.label;
        if (i5 != 0) {
        }
        if (((Boolean) marketingNotificationManager.settings.latestValueFor(SettingsProperty.Notifications.MarketingNotificationsEnabled.INSTANCE)).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // dk.molslinjen.domain.managers.notification.IMarketingNotificationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object register(Continuation<? super Unit> continuation) {
        MarketingNotificationManager$register$1 marketingNotificationManager$register$1;
        int i5;
        MarketingNotificationManager marketingNotificationManager;
        String email;
        MarketingNotificationManager marketingNotificationManager2;
        String str;
        String str2;
        MarketingNotificationManager marketingNotificationManager3;
        AgillicHandlerInterface agillicHandlerInterface;
        AgillicInstallationId agillicInstallationId;
        AgillicClientId clientAppId;
        List<Consent> listOf;
        ISettings iSettings;
        SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail marketingNotificationsPermissionIsAwaitingEmail;
        Boolean boxBoolean;
        if (continuation instanceof MarketingNotificationManager$register$1) {
            marketingNotificationManager$register$1 = (MarketingNotificationManager$register$1) continuation;
            int i6 = marketingNotificationManager$register$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                marketingNotificationManager$register$1.label = i6 - Integer.MIN_VALUE;
                Object obj = marketingNotificationManager$register$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = marketingNotificationManager$register$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISettings iSettings2 = this.settings;
                    SettingsProperty.Notifications.MarketingNotificationsEnabled marketingNotificationsEnabled = SettingsProperty.Notifications.MarketingNotificationsEnabled.INSTANCE;
                    Boolean boxBoolean2 = Boxing.boxBoolean(true);
                    marketingNotificationManager$register$1.L$0 = this;
                    marketingNotificationManager$register$1.label = 1;
                    if (iSettings2.update(marketingNotificationsEnabled, boxBoolean2, marketingNotificationManager$register$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketingNotificationManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            marketingNotificationManager3 = (MarketingNotificationManager) marketingNotificationManager$register$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception e5) {
                                e = e5;
                                Logger.INSTANCE.logError(e);
                                iSettings = marketingNotificationManager3.settings;
                                marketingNotificationsPermissionIsAwaitingEmail = SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE;
                                boxBoolean = Boxing.boxBoolean(false);
                                marketingNotificationManager$register$1.L$0 = null;
                                marketingNotificationManager$register$1.L$1 = null;
                                marketingNotificationManager$register$1.label = 5;
                                if (iSettings.update(marketingNotificationsPermissionIsAwaitingEmail, boxBoolean, marketingNotificationManager$register$1) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            iSettings = marketingNotificationManager3.settings;
                            marketingNotificationsPermissionIsAwaitingEmail = SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE;
                            boxBoolean = Boxing.boxBoolean(false);
                            marketingNotificationManager$register$1.L$0 = null;
                            marketingNotificationManager$register$1.L$1 = null;
                            marketingNotificationManager$register$1.label = 5;
                            if (iSettings.update(marketingNotificationsPermissionIsAwaitingEmail, boxBoolean, marketingNotificationManager$register$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        String str3 = (String) marketingNotificationManager$register$1.L$1;
                        MarketingNotificationManager marketingNotificationManager4 = (MarketingNotificationManager) marketingNotificationManager$register$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        marketingNotificationManager2 = marketingNotificationManager4;
                        str = str3;
                        str2 = (String) obj;
                        Logger.log$default(Logger.INSTANCE, "Registering for marketing notifications with email: " + str + " and token: " + str2, "MarketingNotificationPush", 0, 4, null);
                        String str4 = (String) marketingNotificationManager2.settings.latestValueFor(SettingsProperty.Notifications.DeviceId.INSTANCE);
                        try {
                            agillicHandlerInterface = marketingNotificationManager2.agillicHandler;
                            agillicInstallationId = new AgillicInstallationId(str4);
                            clientAppId = Constants.Agillic.INSTANCE.getClientAppId();
                            listOf = CollectionsKt.listOf(new Consent(marketingNotificationManager2.getNowPlusOneYear()));
                            marketingNotificationManager$register$1.L$0 = marketingNotificationManager2;
                            marketingNotificationManager$register$1.L$1 = null;
                            marketingNotificationManager$register$1.label = 4;
                        } catch (Exception e6) {
                            e = e6;
                            marketingNotificationManager3 = marketingNotificationManager2;
                            Logger.INSTANCE.logError(e);
                            iSettings = marketingNotificationManager3.settings;
                            marketingNotificationsPermissionIsAwaitingEmail = SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE;
                            boxBoolean = Boxing.boxBoolean(false);
                            marketingNotificationManager$register$1.L$0 = null;
                            marketingNotificationManager$register$1.L$1 = null;
                            marketingNotificationManager$register$1.label = 5;
                            if (iSettings.update(marketingNotificationsPermissionIsAwaitingEmail, boxBoolean, marketingNotificationManager$register$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (agillicHandlerInterface.register(str, agillicInstallationId, clientAppId, str2, listOf, marketingNotificationManager$register$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        marketingNotificationManager3 = marketingNotificationManager2;
                        iSettings = marketingNotificationManager3.settings;
                        marketingNotificationsPermissionIsAwaitingEmail = SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE;
                        boxBoolean = Boxing.boxBoolean(false);
                        marketingNotificationManager$register$1.L$0 = null;
                        marketingNotificationManager$register$1.L$1 = null;
                        marketingNotificationManager$register$1.label = 5;
                        if (iSettings.update(marketingNotificationsPermissionIsAwaitingEmail, boxBoolean, marketingNotificationManager$register$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    marketingNotificationManager = (MarketingNotificationManager) marketingNotificationManager$register$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                email = marketingNotificationManager.getEmail();
                if (email != null) {
                    ISettings iSettings3 = marketingNotificationManager.settings;
                    SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail marketingNotificationsPermissionIsAwaitingEmail2 = SettingsProperty.Notifications.MarketingNotificationsPermissionIsAwaitingEmail.INSTANCE;
                    Boolean boxBoolean3 = Boxing.boxBoolean(true);
                    marketingNotificationManager$register$1.L$0 = null;
                    marketingNotificationManager$register$1.label = 2;
                    if (iSettings3.update(marketingNotificationsPermissionIsAwaitingEmail2, boxBoolean3, marketingNotificationManager$register$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                INotificationManager iNotificationManager = marketingNotificationManager.notificationManager;
                marketingNotificationManager$register$1.L$0 = marketingNotificationManager;
                marketingNotificationManager$register$1.L$1 = email;
                marketingNotificationManager$register$1.label = 3;
                Object awaitNonNullToken = iNotificationManager.awaitNonNullToken(marketingNotificationManager$register$1);
                if (awaitNonNullToken == coroutine_suspended) {
                    return coroutine_suspended;
                }
                marketingNotificationManager2 = marketingNotificationManager;
                str = email;
                obj = awaitNonNullToken;
                str2 = (String) obj;
                Logger.log$default(Logger.INSTANCE, "Registering for marketing notifications with email: " + str + " and token: " + str2, "MarketingNotificationPush", 0, 4, null);
                String str42 = (String) marketingNotificationManager2.settings.latestValueFor(SettingsProperty.Notifications.DeviceId.INSTANCE);
                agillicHandlerInterface = marketingNotificationManager2.agillicHandler;
                agillicInstallationId = new AgillicInstallationId(str42);
                clientAppId = Constants.Agillic.INSTANCE.getClientAppId();
                listOf = CollectionsKt.listOf(new Consent(marketingNotificationManager2.getNowPlusOneYear()));
                marketingNotificationManager$register$1.L$0 = marketingNotificationManager2;
                marketingNotificationManager$register$1.L$1 = null;
                marketingNotificationManager$register$1.label = 4;
                if (agillicHandlerInterface.register(str, agillicInstallationId, clientAppId, str2, listOf, marketingNotificationManager$register$1) != coroutine_suspended) {
                }
            }
        }
        marketingNotificationManager$register$1 = new MarketingNotificationManager$register$1(this, continuation);
        Object obj2 = marketingNotificationManager$register$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = marketingNotificationManager$register$1.label;
        if (i5 != 0) {
        }
        email = marketingNotificationManager.getEmail();
        if (email != null) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|(1:(1:11)(2:15|16))(3:17|18|(2:20|21)(2:22|(1:24)))|12|13))|27|6|7|8|(0)(0)|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002b, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        dk.molslinjen.core.log.Logger.INSTANCE.logError(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    @Override // dk.molslinjen.domain.managers.notification.IMarketingNotificationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object trackOpenedNotification(AgillicReportId agillicReportId, Continuation<? super Unit> continuation) {
        MarketingNotificationManager$trackOpenedNotification$1 marketingNotificationManager$trackOpenedNotification$1;
        int i5;
        if (continuation instanceof MarketingNotificationManager$trackOpenedNotification$1) {
            marketingNotificationManager$trackOpenedNotification$1 = (MarketingNotificationManager$trackOpenedNotification$1) continuation;
            int i6 = marketingNotificationManager$trackOpenedNotification$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                marketingNotificationManager$trackOpenedNotification$1.label = i6 - Integer.MIN_VALUE;
                MarketingNotificationManager$trackOpenedNotification$1 marketingNotificationManager$trackOpenedNotification$12 = marketingNotificationManager$trackOpenedNotification$1;
                Object obj = marketingNotificationManager$trackOpenedNotification$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = marketingNotificationManager$trackOpenedNotification$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Logger.log$default(Logger.INSTANCE, "Tracking opened notification with reportId: " + agillicReportId, "MarketingNotificationPush", 0, 4, null);
                    AgillicHandlerInterface agillicHandlerInterface = this.agillicHandler;
                    String email = getEmail();
                    if (email == null) {
                        return Unit.INSTANCE;
                    }
                    AgillicClientId clientAppId = Constants.Agillic.INSTANCE.getClientAppId();
                    FeedbackStatus feedbackStatus = FeedbackStatus.OPENED;
                    marketingNotificationManager$trackOpenedNotification$12.label = 1;
                    if (agillicHandlerInterface.feedback(email, clientAppId, agillicReportId, feedbackStatus, marketingNotificationManager$trackOpenedNotification$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        marketingNotificationManager$trackOpenedNotification$1 = new MarketingNotificationManager$trackOpenedNotification$1(this, continuation);
        MarketingNotificationManager$trackOpenedNotification$1 marketingNotificationManager$trackOpenedNotification$122 = marketingNotificationManager$trackOpenedNotification$1;
        Object obj2 = marketingNotificationManager$trackOpenedNotification$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = marketingNotificationManager$trackOpenedNotification$122.label;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(1:17))(2:26|(1:28)(1:29))|18|19|(2:21|22)(4:23|(1:25)|12|13)))|32|6|7|(0)(0)|18|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002c, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        dk.molslinjen.core.log.Logger.INSTANCE.logError(r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:11:0x0028, B:19:0x0062, B:21:0x006a, B:23:0x006d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: Exception -> 0x002c, TRY_LEAVE, TryCatch #0 {Exception -> 0x002c, blocks: (B:11:0x0028, B:19:0x0062, B:21:0x006a, B:23:0x006d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // dk.molslinjen.domain.managers.notification.IMarketingNotificationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object withdrawConsent(Continuation<? super Unit> continuation) {
        MarketingNotificationManager$withdrawConsent$1 marketingNotificationManager$withdrawConsent$1;
        int i5;
        MarketingNotificationManager marketingNotificationManager;
        String email;
        if (continuation instanceof MarketingNotificationManager$withdrawConsent$1) {
            marketingNotificationManager$withdrawConsent$1 = (MarketingNotificationManager$withdrawConsent$1) continuation;
            int i6 = marketingNotificationManager$withdrawConsent$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                marketingNotificationManager$withdrawConsent$1.label = i6 - Integer.MIN_VALUE;
                Object obj = marketingNotificationManager$withdrawConsent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = marketingNotificationManager$withdrawConsent$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISettings iSettings = this.settings;
                    SettingsProperty.Notifications.MarketingNotificationsEnabled marketingNotificationsEnabled = SettingsProperty.Notifications.MarketingNotificationsEnabled.INSTANCE;
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    marketingNotificationManager$withdrawConsent$1.L$0 = this;
                    marketingNotificationManager$withdrawConsent$1.label = 1;
                    if (iSettings.update(marketingNotificationsEnabled, boxBoolean, marketingNotificationManager$withdrawConsent$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketingNotificationManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    marketingNotificationManager = (MarketingNotificationManager) marketingNotificationManager$withdrawConsent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Logger.log$default(Logger.INSTANCE, "Withdrawing consent for marketing notifications", "MarketingNotificationPush", 0, 4, null);
                AgillicHandlerInterface agillicHandlerInterface = marketingNotificationManager.agillicHandler;
                email = marketingNotificationManager.getEmail();
                if (email != null) {
                    return Unit.INSTANCE;
                }
                AgillicClientId clientAppId = Constants.Agillic.INSTANCE.getClientAppId();
                marketingNotificationManager$withdrawConsent$1.L$0 = null;
                marketingNotificationManager$withdrawConsent$1.label = 2;
                if (agillicHandlerInterface.withdrawConsent(email, clientAppId, marketingNotificationManager$withdrawConsent$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        marketingNotificationManager$withdrawConsent$1 = new MarketingNotificationManager$withdrawConsent$1(this, continuation);
        Object obj2 = marketingNotificationManager$withdrawConsent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = marketingNotificationManager$withdrawConsent$1.label;
        if (i5 != 0) {
        }
        Logger.log$default(Logger.INSTANCE, "Withdrawing consent for marketing notifications", "MarketingNotificationPush", 0, 4, null);
        AgillicHandlerInterface agillicHandlerInterface2 = marketingNotificationManager.agillicHandler;
        email = marketingNotificationManager.getEmail();
        if (email != null) {
        }
    }
}
