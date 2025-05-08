package dk.molslinjen.core.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.localstorage.bookings.IBookingsRepository;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.push.PushTag;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.ui.views.global.navigation.MainActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ldk/molslinjen/core/push/PushHandler;", "Ldk/molslinjen/core/push/IPushHandler;", "notificationManager", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "bookingsRepository", "Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;", "context", "Landroid/content/Context;", "<init>", "(Ldk/molslinjen/domain/managers/notification/INotificationManager;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;Landroid/content/Context;)V", "weakApplicationContext", "Ljava/lang/ref/WeakReference;", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "setup", BuildConfig.FLAVOR, "listenForChangesToPushSubscriptions", "listenForPushPermissionChanges", "isPushEnabled", BuildConfig.FLAVOR, "setPushEnabled", "allowNotifications", "openedNotification", "intent", "Landroid/content/Intent;", "setToken", "token", BuildConfig.FLAVOR, "updatePushSubscriptions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToDestination", "destination", "Lcom/ramcosta/composedestinations/spec/Direction;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushHandler implements IPushHandler {
    private final IBookingsRepository bookingsRepository;
    private final Context context;
    private final CoroutineScope localScope;
    private final INotificationManager notificationManager;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final ISettings settings;
    private final ITicketsManager ticketsManager;
    private WeakReference<Context> weakApplicationContext;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushType.values().length];
            try {
                iArr[PushType.Ticket.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PushType.Departure.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PushType.SaleOnBoard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PushHandler(INotificationManager notificationManager, ISettings settings, ISaleOnBoardManager saleOnBoardManager, ITicketsManager ticketsManager, IBookingsRepository bookingsRepository, Context context) {
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(bookingsRepository, "bookingsRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        this.notificationManager = notificationManager;
        this.settings = settings;
        this.saleOnBoardManager = saleOnBoardManager;
        this.ticketsManager = ticketsManager;
        this.bookingsRepository = bookingsRepository;
        this.context = context;
        this.localScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    private final void listenForChangesToPushSubscriptions() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$listenForChangesToPushSubscriptions$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$listenForChangesToPushSubscriptions$2(this, null), 3, null);
    }

    private final void listenForPushPermissionChanges() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$listenForPushPermissionChanges$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToDestination(Direction destination, Context context) {
        Intent putExtra = new Intent("android.intent.action.VIEW", Uri.parse(destination.getRoute()), context, MainActivity.class).putExtra(Constants.IntentExtra.NavigateToKnownRoute, destination.getRoute());
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        putExtra.addFlags(268435456);
        context.startActivity(putExtra);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public boolean isPushEnabled() {
        return Build.VERSION.SDK_INT >= 33 ? this.context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0 : ((Boolean) this.settings.latestValueFor(SettingsProperty.Notifications.AllowedPushNotifications.INSTANCE)).booleanValue();
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void openedNotification(Intent intent) {
        WeakReference<Context> weakReference;
        Context context;
        PushType invoke;
        String stringExtra = intent != null ? intent.getStringExtra(Constants.IntentExtra.PushTagKey) : null;
        String stringExtra2 = intent != null ? intent.getStringExtra(Constants.IntentExtra.PushTagValue) : null;
        Logger.log$default(Logger.INSTANCE, "Opened push with tagKey: " + stringExtra + " and tagValue: " + stringExtra2, null, 0, 6, null);
        if (stringExtra == null || (weakReference = this.weakApplicationContext) == null || (context = weakReference.get()) == null || (invoke = PushType.INSTANCE.invoke(stringExtra)) == null) {
            return;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[invoke.ordinal()];
        if (i5 == 1) {
            BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$openedNotification$1(this, stringExtra2, context, null), 3, null);
            return;
        }
        if (i5 != 2) {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            SaleOnBoardOrderDetailsScreenDestination saleOnBoardOrderDetailsScreenDestination = SaleOnBoardOrderDetailsScreenDestination.INSTANCE;
            if (stringExtra2 == null) {
                return;
            }
            navigateToDestination(saleOnBoardOrderDetailsScreenDestination.invoke(stringExtra2), context);
        }
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setPushEnabled(boolean allowNotifications) {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$setPushEnabled$1(this, allowNotifications, null), 3, null);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$setToken$1(this, token, null), 3, null);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.weakApplicationContext = new WeakReference<>(context.getApplicationContext());
        Logger.log$default(Logger.INSTANCE, "Setup push", null, 0, 6, null);
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PushHandler$setup$1(this, null), 3, null);
        listenForPushPermissionChanges();
        listenForChangesToPushSubscriptions();
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public Object updatePushSubscriptions(Continuation<? super Unit> continuation) {
        Object latestValueFor = this.settings.latestValueFor(SettingsProperty.Notifications.FirebasePushToken.INSTANCE);
        if (latestValueFor == null) {
            return Unit.INSTANCE;
        }
        String str = (String) latestValueFor;
        if (!isPushEnabled()) {
            Object unsubscribe = this.notificationManager.unsubscribe(str, continuation);
            return unsubscribe == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? unsubscribe : Unit.INSTANCE;
        }
        List<BookingHeader> bookings = this.ticketsManager.getTicketsState().getValue().getBookings();
        ArrayList<BookingHeader> arrayList = new ArrayList();
        for (Object obj : bookings) {
            if (((BookingHeader) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (BookingHeader bookingHeader : arrayList) {
            CollectionsKt.addAll(arrayList2, CollectionsKt.listOf((Object[]) new PushTag[]{new PushTag(PushType.Departure.getPushTagKey(), bookingHeader.getDepartureId()), new PushTag(PushType.Ticket.getPushTagKey(), bookingHeader.getReservationId())}));
        }
        List<PushTag> mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        List<SaleOnBoardOrder> orders = this.saleOnBoardManager.getSaleOnBoardState().getValue().getOrders();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : orders) {
            if (((SaleOnBoardOrder) obj2).isActive()) {
                arrayList3.add(obj2);
            }
        }
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            mutableList.add(new PushTag(PushType.SaleOnBoard.getPushTagKey(), ((SaleOnBoardOrder) it.next()).getOrderNumber()));
        }
        Object createOrUpdateSubscription = this.notificationManager.createOrUpdateSubscription(str, mutableList, continuation);
        return createOrUpdateSubscription == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? createOrUpdateSubscription : Unit.INSTANCE;
    }
}
