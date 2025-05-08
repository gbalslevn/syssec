package uniffi.molslinjen_shared;

import dk.molslinjen.domain.model.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J?\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Luniffi/molslinjen_shared/AgillicHandlerInterface;", BuildConfig.FLAVOR, "feedback", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "clientAppId", "Luniffi/molslinjen_shared/AgillicClientId;", Constants.IntentExtra.ReportId, "Luniffi/molslinjen_shared/AgillicReportId;", "feedbackStatus", "Luniffi/molslinjen_shared/FeedbackStatus;", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Luniffi/molslinjen_shared/AgillicReportId;Luniffi/molslinjen_shared/FeedbackStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "giveConsent", "validUntil", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Lorg/threeten/bp/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "appInstallationId", "Luniffi/molslinjen_shared/AgillicInstallationId;", "pushNotificationToken", "consent", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/Consent;", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicInstallationId;Luniffi/molslinjen_shared/AgillicClientId;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregister", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicInstallationId;Luniffi/molslinjen_shared/AgillicClientId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withdrawConsent", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AgillicHandlerInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/AgillicHandlerInterface$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    Object feedback(String str, AgillicClientId agillicClientId, AgillicReportId agillicReportId, FeedbackStatus feedbackStatus, Continuation<? super Unit> continuation);

    Object giveConsent(String str, AgillicClientId agillicClientId, LocalDateTime localDateTime, Continuation<? super Unit> continuation);

    Object register(String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, String str2, List<Consent> list, Continuation<? super Unit> continuation);

    Object unregister(String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, Continuation<? super Unit> continuation);

    Object withdrawConsent(String str, AgillicClientId agillicClientId, Continuation<? super Unit> continuation);
}
