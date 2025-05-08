package dk.molslinjen.domain.model.settings;

import androidx.datastore.preferences.core.Preferences;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004:\f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB1\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u001d\u001f !\"#$%&'()*+,-./0123456789:;¨\u0006<"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty;", "KeyType", "DefaultValue", "SerializerType", BuildConfig.FLAVOR, "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "defaultValue", "optionalSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)V", "getKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOptionalSerializer", "()Lkotlinx/serialization/KSerializer;", Constants.SettingKeys.CurrentDataVersion, Constants.SettingKeys.AuthToken, Constants.SettingKeys.ActiveCompanyId, Constants.SettingKeys.DeparturesSessionKey, "Dev", "Departures", "Checkout", "Onboarding", "Notifications", "ForceUpdate", "Tracking", "User", "Ldk/molslinjen/domain/model/settings/SettingsProperty$ActiveCompanyId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$AuthToken;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Checkout$LastSelectedVehicleId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Checkout$SelectedCurrency;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$CurrentDataVersion;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentDirection;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentPassengerInfo;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentRouteId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentSite;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentTransportationId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentTransportationInfo;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$DeparturesSessionKey;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev$ApiEnvironmentOverride;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev$ShowDeveloperMenu;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$ForceUpdate$MinAppVersionCode;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$AllowedPushNotifications;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$DeviceId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$FirebasePushToken;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$MarketingNotificationsEnabled;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$MarketingNotificationsPermissionIsAwaitingEmail;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$AppOpenedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$HasPurchasedAnything;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$MultiRideCardPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$PurchaseCountPerCityId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$SaleOnBoardPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$TicketsPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$User$ActiveCompanyId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$User$PendingAccountActivation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SettingsProperty<KeyType, DefaultValue, SerializerType> {
    private final DefaultValue defaultValue;
    private final Preferences.Key<KeyType> key;
    private final KSerializer<SerializerType> optionalSerializer;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$ActiveCompanyId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ActiveCompanyId extends SettingsProperty<String, String, Unit> {
        public static final ActiveCompanyId INSTANCE = new ActiveCompanyId();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private ActiveCompanyId() {
            super(r2, null, null, 4, null);
            Preferences.Key stringKey;
            stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.ActiveCompanyId);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$AuthToken;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class AuthToken extends SettingsProperty<String, String, Unit> {
        public static final AuthToken INSTANCE = new AuthToken();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private AuthToken() {
            super(r2, null, null, 4, null);
            Preferences.Key stringKey;
            stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.AuthToken);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Checkout;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.Checkout.LastSelectedVehicleId, Constants.SettingKeys.Checkout.SelectedCurrency, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Checkout {
        public static final Checkout INSTANCE = new Checkout();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Checkout$LastSelectedVehicleId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class LastSelectedVehicleId extends SettingsProperty<String, String, Unit> {
            public static final LastSelectedVehicleId INSTANCE = new LastSelectedVehicleId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private LastSelectedVehicleId() {
                super(r2, null, null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Checkout.LastSelectedVehicleId);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Checkout$SelectedCurrency;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class SelectedCurrency extends SettingsProperty<String, CurrencyType, CurrencyType> {
            public static final SelectedCurrency INSTANCE = new SelectedCurrency();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private SelectedCurrency() {
                super(r0, CurrencyType.DKK, CurrencyType.INSTANCE.serializer(), null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Checkout.SelectedCurrency);
            }
        }

        private Checkout() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$CurrentDataVersion;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CurrentDataVersion extends SettingsProperty<Integer, Integer, Unit> {
        public static final CurrentDataVersion INSTANCE = new CurrentDataVersion();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private CurrentDataVersion() {
            super(r2, 0, null, 4, null);
            Preferences.Key intKey;
            intKey = ISettingsKt.toIntKey(Constants.SettingKeys.CurrentDataVersion);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.Departures.CurrentSite, "CurrentRouteId", "CurrentTransportationId", Constants.SettingKeys.Departures.CurrentTransportationInfo, Constants.SettingKeys.Departures.CurrentDirection, Constants.SettingKeys.Departures.CurrentPassengerInfo, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Departures {
        public static final Departures INSTANCE = new Departures();

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentDirection;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentDirection extends SettingsProperty<String, RouteDirection, RouteDirection> {
            public static final CurrentDirection INSTANCE = new CurrentDirection();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentDirection() {
                super(r0, RouteDirection.Outbound, RouteDirection.INSTANCE.serializer(), null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentDirection);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentPassengerInfo;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentPassengerInfo extends SettingsProperty<String, PassengerInfo, PassengerInfo> {
            public static final CurrentPassengerInfo INSTANCE = new CurrentPassengerInfo();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentPassengerInfo() {
                super(r0, new PassengerInfo(1, 0, 0), PassengerInfo.INSTANCE.serializer(), null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentPassengerInfo);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentRouteId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentRouteId extends SettingsProperty<String, String, String> {
            public static final CurrentRouteId INSTANCE = new CurrentRouteId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentRouteId() {
                super(r2, null, null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentRoute);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentSite;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/model/config/Site;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentSite extends SettingsProperty<String, Site, Site> {
            public static final CurrentSite INSTANCE = new CurrentSite();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentSite() {
                super(r0, Environment.INSTANCE.isMolslinjen() ? Site.Mols : Site.Kombardo, Site.INSTANCE.serializer(), null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentSite);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentTransportationId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentTransportationId extends SettingsProperty<String, String, Unit> {
            public static final CurrentTransportationId INSTANCE = new CurrentTransportationId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentTransportationId() {
                super(r2, null, null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentTransportation);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Departures$CurrentTransportationInfo;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class CurrentTransportationInfo extends SettingsProperty<String, TransportationCargoInfo, TransportationCargoInfo> {
            public static final CurrentTransportationInfo INSTANCE = new CurrentTransportationInfo();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private CurrentTransportationInfo() {
                super(r0, r2, TransportationCargoInfo.INSTANCE.serializer(), r2);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.CurrentTransportationInfo);
                DefaultConstructorMarker defaultConstructorMarker = null;
            }
        }

        private Departures() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$DeparturesSessionKey;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DeparturesSessionKey extends SettingsProperty<String, String, Unit> {
        public static final DeparturesSessionKey INSTANCE = new DeparturesSessionKey();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private DeparturesSessionKey() {
            super(r2, null, null, 4, null);
            Preferences.Key stringKey;
            stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.DeparturesSessionKey);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.Dev.ApiEnvironmentOverride, Constants.SettingKeys.Dev.ShowDeveloperMenu, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Dev {
        public static final Dev INSTANCE = new Dev();

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev$ApiEnvironmentOverride;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/core/ApiEnvironment;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class ApiEnvironmentOverride extends SettingsProperty<String, ApiEnvironment, ApiEnvironment> {
            public static final ApiEnvironmentOverride INSTANCE = new ApiEnvironmentOverride();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private ApiEnvironmentOverride() {
                super(r0, r2, ApiEnvironment.INSTANCE.serializer(), r2);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Dev.ApiEnvironmentOverride);
                DefaultConstructorMarker defaultConstructorMarker = null;
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ApiEnvironmentOverride);
            }

            public int hashCode() {
                return -2083027940;
            }

            public String toString() {
                return Constants.SettingKeys.Dev.ApiEnvironmentOverride;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev$ShowDeveloperMenu;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class ShowDeveloperMenu extends SettingsProperty<Boolean, Boolean, Unit> {
            public static final ShowDeveloperMenu INSTANCE = new ShowDeveloperMenu();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private ShowDeveloperMenu() {
                super(r2, Boolean.FALSE, null, 4, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Dev.ShowDeveloperMenu);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof ShowDeveloperMenu);
            }

            public int hashCode() {
                return 1089646677;
            }

            public String toString() {
                return Constants.SettingKeys.Dev.ShowDeveloperMenu;
            }
        }

        private Dev() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$ForceUpdate;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.ForceUpdate.MinAppVersionCode, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ForceUpdate {
        public static final ForceUpdate INSTANCE = new ForceUpdate();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$ForceUpdate$MinAppVersionCode;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class MinAppVersionCode extends SettingsProperty<Integer, Integer, Unit> {
            public static final MinAppVersionCode INSTANCE = new MinAppVersionCode();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private MinAppVersionCode() {
                super(r2, 0, null, 4, null);
                Preferences.Key intKey;
                intKey = ISettingsKt.toIntKey(Constants.SettingKeys.ForceUpdate.MinAppVersionCode);
            }
        }

        private ForceUpdate() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.Notifications.AllowedPushNotifications, Constants.SettingKeys.Notifications.FirebasePushToken, Constants.SettingKeys.Notifications.MarketingNotificationsEnabled, Constants.SettingKeys.Notifications.MarketingNotificationsPermissionIsAwaitingEmail, Constants.SettingKeys.Notifications.DeviceId, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Notifications {
        public static final Notifications INSTANCE = new Notifications();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$AllowedPushNotifications;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class AllowedPushNotifications extends SettingsProperty<Boolean, Boolean, Unit> {
            public static final AllowedPushNotifications INSTANCE = new AllowedPushNotifications();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private AllowedPushNotifications() {
                super(r2, Boolean.TRUE, null, 4, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Notifications.AllowedPushNotifications);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$DeviceId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class DeviceId extends SettingsProperty<String, String, Unit> {
            public static final DeviceId INSTANCE = new DeviceId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private DeviceId() {
                super(r2, UUID.randomUUID().toString(), null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Notifications.DeviceId);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof DeviceId);
            }

            public int hashCode() {
                return 528414453;
            }

            public String toString() {
                return Constants.SettingKeys.Notifications.DeviceId;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$FirebasePushToken;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class FirebasePushToken extends SettingsProperty<String, String, Unit> {
            public static final FirebasePushToken INSTANCE = new FirebasePushToken();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private FirebasePushToken() {
                super(r2, null, null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Notifications.FirebasePushToken);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$MarketingNotificationsEnabled;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class MarketingNotificationsEnabled extends SettingsProperty<Boolean, Boolean, Unit> {
            public static final MarketingNotificationsEnabled INSTANCE = new MarketingNotificationsEnabled();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private MarketingNotificationsEnabled() {
                super(r2, Boolean.FALSE, null, 4, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Notifications.MarketingNotificationsEnabled);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Notifications$MarketingNotificationsPermissionIsAwaitingEmail;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class MarketingNotificationsPermissionIsAwaitingEmail extends SettingsProperty<Boolean, Boolean, Unit> {
            public static final MarketingNotificationsPermissionIsAwaitingEmail INSTANCE = new MarketingNotificationsPermissionIsAwaitingEmail();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private MarketingNotificationsPermissionIsAwaitingEmail() {
                super(r2, Boolean.FALSE, null, 4, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Notifications.MarketingNotificationsPermissionIsAwaitingEmail);
            }
        }

        private Notifications() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\t\n\u000b\f\rB\u001f\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "defaultValue", "<init>", "(Landroidx/datastore/preferences/core/Preferences$Key;Z)V", Constants.SettingKeys.Onboarding.SelectRouteCompleted, "OnboardingNotificationsCompleted", "OnboardingLocationCompleted", Constants.SettingKeys.Onboarding.OnboardingMarketingNotificationsCompleted, "OnboardingLoginCompleted", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingLocationCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingLoginCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingMarketingNotificationsCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingNotificationsCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$SelectRouteCompleted;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Onboarding extends SettingsProperty<Boolean, Boolean, Unit> {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingLocationCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class OnboardingLocationCompleted extends Onboarding {
            public static final OnboardingLocationCompleted INSTANCE = new OnboardingLocationCompleted();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private OnboardingLocationCompleted() {
                super(r0, false, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Onboarding.OnboardingLocationCompleted);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingLoginCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class OnboardingLoginCompleted extends Onboarding {
            public static final OnboardingLoginCompleted INSTANCE = new OnboardingLoginCompleted();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private OnboardingLoginCompleted() {
                super(r0, false, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Onboarding.OnboardingLoginCompleted);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingMarketingNotificationsCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class OnboardingMarketingNotificationsCompleted extends Onboarding {
            public static final OnboardingMarketingNotificationsCompleted INSTANCE = new OnboardingMarketingNotificationsCompleted();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private OnboardingMarketingNotificationsCompleted() {
                super(r0, false, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Onboarding.OnboardingMarketingNotificationsCompleted);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$OnboardingNotificationsCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class OnboardingNotificationsCompleted extends Onboarding {
            public static final OnboardingNotificationsCompleted INSTANCE = new OnboardingNotificationsCompleted();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private OnboardingNotificationsCompleted() {
                super(r0, false, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Onboarding.OnboardingNotificationsCompleted);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding$SelectRouteCompleted;", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class SelectRouteCompleted extends Onboarding {
            public static final SelectRouteCompleted INSTANCE = new SelectRouteCompleted();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private SelectRouteCompleted() {
                super(r0, false, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Onboarding.SelectRouteCompleted);
            }
        }

        public /* synthetic */ Onboarding(Preferences.Key key, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(key, z5);
        }

        private Onboarding(Preferences.Key<Boolean> key, boolean z5) {
            super(key, Boolean.valueOf(z5), null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.Tracking.HasPurchasedAnything, Constants.SettingKeys.Tracking.AppOpenedCount, Constants.SettingKeys.Tracking.TicketsPurchasedCount, Constants.SettingKeys.Tracking.MultiRideCardPurchasedCount, Constants.SettingKeys.Tracking.SaleOnBoardPurchasedCount, Constants.SettingKeys.Departures.PurchaseCountPerCityId, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Tracking {
        public static final Tracking INSTANCE = new Tracking();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$AppOpenedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class AppOpenedCount extends SettingsProperty<Integer, Integer, Unit> {
            public static final AppOpenedCount INSTANCE = new AppOpenedCount();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private AppOpenedCount() {
                super(r2, 0, null, 4, null);
                Preferences.Key intKey;
                intKey = ISettingsKt.toIntKey(Constants.SettingKeys.Tracking.AppOpenedCount);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$HasPurchasedAnything;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class HasPurchasedAnything extends SettingsProperty<Boolean, Boolean, Unit> {
            public static final HasPurchasedAnything INSTANCE = new HasPurchasedAnything();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private HasPurchasedAnything() {
                super(r2, Boolean.FALSE, null, 4, null);
                Preferences.Key booleanKey;
                booleanKey = ISettingsKt.toBooleanKey(Constants.SettingKeys.Tracking.HasPurchasedAnything);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$MultiRideCardPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class MultiRideCardPurchasedCount extends SettingsProperty<Integer, Integer, Unit> {
            public static final MultiRideCardPurchasedCount INSTANCE = new MultiRideCardPurchasedCount();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private MultiRideCardPurchasedCount() {
                super(r2, 0, null, 4, null);
                Preferences.Key intKey;
                intKey = ISettingsKt.toIntKey(Constants.SettingKeys.Tracking.MultiRideCardPurchasedCount);
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u000020\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$PurchaseCountPerCityId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class PurchaseCountPerCityId extends SettingsProperty<String, Map<String, ? extends Integer>, Map<String, ? extends Integer>> {
            public static final PurchaseCountPerCityId INSTANCE = new PurchaseCountPerCityId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private PurchaseCountPerCityId() {
                super(r0, MapsKt.emptyMap(), BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)), null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.Departures.PurchaseCountPerCityId);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$SaleOnBoardPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class SaleOnBoardPurchasedCount extends SettingsProperty<Integer, Integer, Unit> {
            public static final SaleOnBoardPurchasedCount INSTANCE = new SaleOnBoardPurchasedCount();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private SaleOnBoardPurchasedCount() {
                super(r2, 0, null, 4, null);
                Preferences.Key intKey;
                intKey = ISettingsKt.toIntKey(Constants.SettingKeys.Tracking.SaleOnBoardPurchasedCount);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$Tracking$TicketsPurchasedCount;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class TicketsPurchasedCount extends SettingsProperty<Integer, Integer, Unit> {
            public static final TicketsPurchasedCount INSTANCE = new TicketsPurchasedCount();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private TicketsPurchasedCount() {
                super(r2, 0, null, 4, null);
                Preferences.Key intKey;
                intKey = ISettingsKt.toIntKey(Constants.SettingKeys.Tracking.TicketsPurchasedCount);
            }
        }

        private Tracking() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$User;", BuildConfig.FLAVOR, "<init>", "()V", Constants.SettingKeys.ActiveCompanyId, Constants.SettingKeys.User.PendingAccountActivation, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class User {
        public static final User INSTANCE = new User();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$User$ActiveCompanyId;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class ActiveCompanyId extends SettingsProperty<String, String, Unit> {
            public static final ActiveCompanyId INSTANCE = new ActiveCompanyId();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private ActiveCompanyId() {
                super(r2, null, null, 4, null);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.User.CurrentActiveCompanyId);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/settings/SettingsProperty$User$PendingAccountActivation;", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/settings/JsonData;", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class PendingAccountActivation extends SettingsProperty<String, IUserManager.ActivationInfo, IUserManager.ActivationInfo> {
            public static final PendingAccountActivation INSTANCE = new PendingAccountActivation();

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private PendingAccountActivation() {
                super(r0, r2, IUserManager.ActivationInfo.INSTANCE.serializer(), r2);
                Preferences.Key stringKey;
                stringKey = ISettingsKt.toStringKey(Constants.SettingKeys.User.PendingAccountActivation);
                DefaultConstructorMarker defaultConstructorMarker = null;
            }
        }

        private User() {
        }
    }

    public /* synthetic */ SettingsProperty(Preferences.Key key, Object obj, KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(key, obj, kSerializer);
    }

    public final DefaultValue getDefaultValue() {
        return this.defaultValue;
    }

    public final Preferences.Key<KeyType> getKey() {
        return this.key;
    }

    public final KSerializer<SerializerType> getOptionalSerializer() {
        return this.optionalSerializer;
    }

    private SettingsProperty(Preferences.Key<KeyType> key, DefaultValue defaultvalue, KSerializer<SerializerType> kSerializer) {
        this.key = key;
        this.defaultValue = defaultvalue;
        this.optionalSerializer = kSerializer;
    }

    public /* synthetic */ SettingsProperty(Preferences.Key key, Object obj, KSerializer kSerializer, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(key, obj, (i5 & 4) != 0 ? null : kSerializer, null);
    }
}
