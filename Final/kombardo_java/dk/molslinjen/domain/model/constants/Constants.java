package dk.molslinjen.domain.model.constants;

import dk.molslinjen.core.Environment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalUnit;
import uniffi.molslinjen_shared.AgillicClientId;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants;", BuildConfig.FLAVOR, "<init>", "()V", "Data", "Agillic", "GrowthBook", "Permissions", "SettingKeys", "Keys", "IntentExtra", "Defaults", "FirebaseCustomKeys", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$Agillic;", BuildConfig.FLAVOR, "<init>", "()V", "BaseUrl", BuildConfig.FLAVOR, "Key", "getKey", "()Ljava/lang/String;", "Secret", "getSecret", "ClientAppId", "Luniffi/molslinjen_shared/AgillicClientId;", "getClientAppId", "()Luniffi/molslinjen_shared/AgillicClientId;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Agillic {
        public static final String BaseUrl = "https://api-eu1.agillic.net";
        private static final AgillicClientId ClientAppId;
        public static final Agillic INSTANCE = new Agillic();
        private static final String Key;
        private static final String Secret;

        static {
            Environment environment = Environment.Prod;
            Key = (environment.isCurrent() || Environment.ProdTest.isCurrent()) ? "dIQc9Emu7QBy" : "hiKIAnKQuiAU";
            Secret = (environment.isCurrent() || Environment.ProdTest.isCurrent()) ? "hjMv9tsGSoVKrex9" : "ZjHkyLRadUh9gYmN";
            Environment.Companion companion = Environment.INSTANCE;
            ClientAppId = (companion.isKombardo() && (environment.isCurrent() || Environment.ProdTest.isCurrent())) ? new AgillicClientId("dk.molslinjen.kombardo") : (companion.isKombardo() && (Environment.Test.isCurrent() || Environment.Dev.isCurrent())) ? new AgillicClientId("dk.molslinjen.kombardo.v2.test") : (companion.isMolslinjen() && (environment.isCurrent() || Environment.ProdTest.isCurrent())) ? new AgillicClientId("com.molslinien.Mols-Linien3") : (companion.isMolslinjen() && (Environment.Test.isCurrent() || Environment.Dev.isCurrent())) ? new AgillicClientId("com.molslinien.Mols-Linien3.v2.test") : new AgillicClientId("stage.molslinjen");
        }

        private Agillic() {
        }

        public final AgillicClientId getClientAppId() {
            return ClientAppId;
        }

        public final String getKey() {
            return Key;
        }

        public final String getSecret() {
            return Secret;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$Data;", BuildConfig.FLAVOR, "<init>", "()V", "DeparturesExpirationTime", "Lorg/threeten/bp/Duration;", "getDeparturesExpirationTime", "()Lorg/threeten/bp/Duration;", "PaymentMinExpirationTime", "getPaymentMinExpirationTime", "EsbjergHarborId", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Data {
        private static final Duration DeparturesExpirationTime;
        public static final String EsbjergHarborId = "ESBJERG";
        public static final Data INSTANCE = new Data();
        private static final Duration PaymentMinExpirationTime;

        static {
            Duration ofMinutes = Duration.ofMinutes(10L);
            Intrinsics.checkNotNullExpressionValue(ofMinutes, "ofMinutes(...)");
            DeparturesExpirationTime = ofMinutes;
            Duration ofMinutes2 = Duration.ofMinutes(5L);
            Intrinsics.checkNotNullExpressionValue(ofMinutes2, "ofMinutes(...)");
            PaymentMinExpirationTime = ofMinutes2;
        }

        private Data() {
        }

        public final Duration getDeparturesExpirationTime() {
            return DeparturesExpirationTime;
        }

        public final Duration getPaymentMinExpirationTime() {
            return PaymentMinExpirationTime;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$Defaults;", BuildConfig.FLAVOR, "<init>", "()V", "DefaultNationality", "Ljava/util/Locale;", "getDefaultNationality", "()Ljava/util/Locale;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Defaults {
        public static final Defaults INSTANCE = new Defaults();
        private static final Locale DefaultNationality = new Locale("da", "DK");

        private Defaults() {
        }

        public final Locale getDefaultNationality() {
            return DefaultNationality;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$FirebaseCustomKeys;", BuildConfig.FLAVOR, "<init>", "()V", "HasProfile", BuildConfig.FLAVOR, "UserEmail", "DalvikHeapSizeMB", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class FirebaseCustomKeys {
        public static final String DalvikHeapSizeMB = "dalvikHeapSizeMB";
        public static final String HasProfile = "hasProfile";
        public static final FirebaseCustomKeys INSTANCE = new FirebaseCustomKeys();
        public static final String UserEmail = "userEmail";

        private FirebaseCustomKeys() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$GrowthBook;", BuildConfig.FLAVOR, "<init>", "()V", "ApiKey", BuildConfig.FLAVOR, "getApiKey", "()Ljava/lang/String;", "HostUrl", "getHostUrl", "EncryptionKey", "getEncryptionKey", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class GrowthBook {
        private static final String ApiKey;
        private static final String EncryptionKey;
        private static final String HostUrl;
        public static final GrowthBook INSTANCE = new GrowthBook();

        static {
            Environment environment = Environment.Prod;
            ApiKey = (environment.isCurrent() || Environment.ProdTest.isCurrent()) ? "sdk-aBwL3lpQ6gJXAh5" : "sdk-iWqTmYOEwkcMNcBz";
            HostUrl = "https://cdn.growthbook.io/";
            EncryptionKey = (environment.isCurrent() || Environment.ProdTest.isCurrent()) ? "sAtFeLYbt3Hvw0jMAOkSvQ==" : "4mhj/FZiENS5SwdZDqH7JQ==";
        }

        private GrowthBook() {
        }

        public final String getApiKey() {
            return ApiKey;
        }

        public final String getEncryptionKey() {
            return EncryptionKey;
        }

        public final String getHostUrl() {
            return HostUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$IntentExtra;", BuildConfig.FLAVOR, "<init>", "()V", IntentExtra.NavigateToKnownRoute, BuildConfig.FLAVOR, "ReportId", "PushTitle", "PushBody", "PushTagKey", "PushTagValue", "AgillicReportId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IntentExtra {
        public static final String AgillicReportId = "agillic_report_id";
        public static final IntentExtra INSTANCE = new IntentExtra();
        public static final String NavigateToKnownRoute = "NavigateToKnownRoute";
        public static final String PushBody = "body";
        public static final String PushTagKey = "tagKey";
        public static final String PushTagValue = "tagValue";
        public static final String PushTitle = "title";
        public static final String ReportId = "reportId";

        private IntentExtra() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$Keys;", BuildConfig.FLAVOR, "<init>", "()V", "AdjustApiKey", BuildConfig.FLAVOR, "getAdjustApiKey", "()Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Keys {
        private static final String AdjustApiKey;
        public static final Keys INSTANCE = new Keys();

        static {
            AdjustApiKey = Environment.INSTANCE.isMolslinjen() ? "qtskjpzuoydc" : "afs6vzg5cav4";
        }

        private Keys() {
        }

        public final String getAdjustApiKey() {
            return AdjustApiKey;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$Permissions;", BuildConfig.FLAVOR, "<init>", "()V", "maxResponseCheckupTimePermanentlyDeclined", "Lorg/threeten/bp/LocalTime;", "getMaxResponseCheckupTimePermanentlyDeclined", "()Lorg/threeten/bp/LocalTime;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Permissions {
        public static final Permissions INSTANCE = new Permissions();

        private Permissions() {
        }

        public final LocalTime getMaxResponseCheckupTimePermanentlyDeclined() {
            LocalTime minus = LocalTime.now().minus(500L, (TemporalUnit) ChronoUnit.MILLIS);
            Intrinsics.checkNotNullExpressionValue(minus, "minus(...)");
            return minus;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys;", BuildConfig.FLAVOR, "<init>", "()V", SettingKeys.CurrentDataVersion, BuildConfig.FLAVOR, SettingKeys.AuthToken, SettingKeys.DeparturesSessionKey, SettingKeys.ActiveCompanyId, "Departures", "Checkout", "Onboarding", "Dev", "Notifications", "User", "ForceUpdate", "Tracking", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SettingKeys {
        public static final String ActiveCompanyId = "ActiveCompanyId";
        public static final String AuthToken = "AuthToken";
        public static final String CurrentDataVersion = "CurrentDataVersion";
        public static final String DeparturesSessionKey = "DeparturesSessionKey";
        public static final SettingKeys INSTANCE = new SettingKeys();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Checkout;", BuildConfig.FLAVOR, "<init>", "()V", Checkout.LastSelectedVehicleId, BuildConfig.FLAVOR, Checkout.SelectedCurrency, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Checkout {
            public static final Checkout INSTANCE = new Checkout();
            public static final String LastSelectedVehicleId = "LastSelectedVehicleId";
            public static final String SelectedCurrency = "SelectedCurrency";

            private Checkout() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Departures;", BuildConfig.FLAVOR, "<init>", "()V", Departures.CurrentSite, BuildConfig.FLAVOR, Departures.CurrentRoute, Departures.CurrentTransportation, Departures.CurrentTransportationInfo, Departures.CurrentDirection, Departures.CurrentPassengerInfo, Departures.PurchaseCountPerCityId, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Departures {
            public static final String CurrentDirection = "CurrentDirection";
            public static final String CurrentPassengerInfo = "CurrentPassengerInfo";
            public static final String CurrentRoute = "CurrentRoute";
            public static final String CurrentSite = "CurrentSite";
            public static final String CurrentTransportation = "CurrentTransportation";
            public static final String CurrentTransportationInfo = "CurrentTransportationInfo";
            public static final Departures INSTANCE = new Departures();
            public static final String PurchaseCountPerCityId = "PurchaseCountPerCityId";

            private Departures() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Dev;", BuildConfig.FLAVOR, "<init>", "()V", Dev.ShowDeveloperMenu, BuildConfig.FLAVOR, Dev.ApiEnvironmentOverride, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Dev {
            public static final String ApiEnvironmentOverride = "ApiEnvironmentOverride";
            public static final Dev INSTANCE = new Dev();
            public static final String ShowDeveloperMenu = "ShowDeveloperMenu";

            private Dev() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$ForceUpdate;", BuildConfig.FLAVOR, "<init>", "()V", ForceUpdate.MinAppVersionCode, BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class ForceUpdate {
            public static final ForceUpdate INSTANCE = new ForceUpdate();
            public static final String MinAppVersionCode = "MinAppVersionCode";

            private ForceUpdate() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Notifications;", BuildConfig.FLAVOR, "<init>", "()V", Notifications.FirebasePushToken, BuildConfig.FLAVOR, Notifications.AllowedPushNotifications, Notifications.MarketingNotificationsEnabled, Notifications.MarketingNotificationsPermissionIsAwaitingEmail, Notifications.DeviceId, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Notifications {
            public static final String AllowedPushNotifications = "AllowedPushNotifications";
            public static final String DeviceId = "DeviceId";
            public static final String FirebasePushToken = "FirebasePushToken";
            public static final Notifications INSTANCE = new Notifications();
            public static final String MarketingNotificationsEnabled = "MarketingNotificationsEnabled";
            public static final String MarketingNotificationsPermissionIsAwaitingEmail = "MarketingNotificationsPermissionIsAwaitingEmail";

            private Notifications() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Onboarding;", BuildConfig.FLAVOR, "<init>", "()V", Onboarding.SelectRouteCompleted, BuildConfig.FLAVOR, "OnboardingNotificationsCompleted", Onboarding.OnboardingMarketingNotificationsCompleted, "OnboardingLocationCompleted", "OnboardingLoginCompleted", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Onboarding {
            public static final Onboarding INSTANCE = new Onboarding();
            public static final String OnboardingLocationCompleted = "ShowOnboardingLocation";
            public static final String OnboardingLoginCompleted = "ShowOnboardingLogin";
            public static final String OnboardingMarketingNotificationsCompleted = "OnboardingMarketingNotificationsCompleted";
            public static final String OnboardingNotificationsCompleted = "ShowOnboardingNotifications";
            public static final String SelectRouteCompleted = "SelectRouteCompleted";

            private Onboarding() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$Tracking;", BuildConfig.FLAVOR, "<init>", "()V", Tracking.HasPurchasedAnything, BuildConfig.FLAVOR, Tracking.AppOpenedCount, Tracking.TicketsPurchasedCount, Tracking.MultiRideCardPurchasedCount, Tracking.SaleOnBoardPurchasedCount, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Tracking {
            public static final String AppOpenedCount = "AppOpenedCount";
            public static final String HasPurchasedAnything = "HasPurchasedAnything";
            public static final Tracking INSTANCE = new Tracking();
            public static final String MultiRideCardPurchasedCount = "MultiRideCardPurchasedCount";
            public static final String SaleOnBoardPurchasedCount = "SaleOnBoardPurchasedCount";
            public static final String TicketsPurchasedCount = "TicketsPurchasedCount";

            private Tracking() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/constants/Constants$SettingKeys$User;", BuildConfig.FLAVOR, "<init>", "()V", User.PendingAccountActivation, BuildConfig.FLAVOR, "CurrentActiveCompanyId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class User {
            public static final String CurrentActiveCompanyId = "UserActiveCompanyId";
            public static final User INSTANCE = new User();
            public static final String PendingAccountActivation = "PendingAccountActivation";

            private User() {
            }
        }

        private SettingKeys() {
        }
    }

    private Constants() {
    }
}
