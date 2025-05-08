package dk.molslinjen.domain.managers.notification;

import dk.molslinjen.api.services.notifications.INotificationService;
import dk.molslinjen.api.services.notifications.request.PushTagParameters;
import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import dk.molslinjen.domain.model.push.PushMessage;
import dk.molslinjen.domain.model.push.PushTag;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR*\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/managers/notification/NotificationManager;", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "Ldk/molslinjen/api/services/notifications/INotificationService;", "notificationService", "<init>", "(Ldk/molslinjen/api/services/notifications/INotificationService;)V", BuildConfig.FLAVOR, "fcmToken", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/push/PushTag;", "tags", BuildConfig.FLAVOR, "createOrUpdateSubscription", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/model/push/PushMessage;", "pushMessage", "addPushMessageToShowInDialog", "(Ldk/molslinjen/domain/model/push/PushMessage;)V", "markPushMessageAsShownInDialog", "token", "setToken", "(Ljava/lang/String;)V", "awaitNonNullToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/api/services/notifications/INotificationService;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "pushMessageReadyToShownInDialog", "getPushMessageReadyToShownInDialog", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setPushMessageReadyToShownInDialog", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationManager implements INotificationManager {
    private MutableStateFlow<String> fcmToken;
    private final INotificationService notificationService;
    private MutableStateFlow<PushMessage> pushMessageReadyToShownInDialog;

    public NotificationManager(INotificationService notificationService) {
        Intrinsics.checkNotNullParameter(notificationService, "notificationService");
        this.notificationService = notificationService;
        this.fcmToken = StateFlowKt.MutableStateFlow(null);
        this.pushMessageReadyToShownInDialog = StateFlowKt.MutableStateFlow(null);
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public void addPushMessageToShowInDialog(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        MutableStateFlow<PushMessage> pushMessageReadyToShownInDialog = getPushMessageReadyToShownInDialog();
        do {
        } while (!pushMessageReadyToShownInDialog.compareAndSet(pushMessageReadyToShownInDialog.getValue(), pushMessage));
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public Object awaitNonNullToken(Continuation<? super String> continuation) {
        return FlowKt.first(FlowKt.filterNotNull(this.fcmToken), continuation);
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public Object createOrUpdateSubscription(String str, List<PushTag> list, Continuation<? super Unit> continuation) {
        INotificationService iNotificationService = this.notificationService;
        List<PushTag> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PushTag pushTag : list2) {
            arrayList.add(new PushTagParameters(pushTag.getType(), pushTag.getValue()));
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        Object createOrUpdateSubscription = iNotificationService.createOrUpdateSubscription(str, arrayList, LocaleExtensionsKt.defaultLanguageString(locale), continuation);
        return createOrUpdateSubscription == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? createOrUpdateSubscription : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public void markPushMessageAsShownInDialog(PushMessage pushMessage) {
        PushMessage value;
        PushMessage pushMessage2;
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        MutableStateFlow<PushMessage> pushMessageReadyToShownInDialog = getPushMessageReadyToShownInDialog();
        do {
            value = pushMessageReadyToShownInDialog.getValue();
            pushMessage2 = value;
            if (Intrinsics.areEqual(pushMessage2, pushMessage)) {
                pushMessage2 = null;
            }
        } while (!pushMessageReadyToShownInDialog.compareAndSet(value, pushMessage2));
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public void setToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        MutableStateFlow<String> mutableStateFlow = this.fcmToken;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), token));
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public Object unsubscribe(String str, Continuation<? super Unit> continuation) {
        Object unsubscribe = this.notificationService.unsubscribe(str, continuation);
        return unsubscribe == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? unsubscribe : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.notification.INotificationManager
    public MutableStateFlow<PushMessage> getPushMessageReadyToShownInDialog() {
        return this.pushMessageReadyToShownInDialog;
    }
}
