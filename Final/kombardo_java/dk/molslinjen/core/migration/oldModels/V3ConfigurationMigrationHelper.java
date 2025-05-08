package dk.molslinjen.core.migration.oldModels;

import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/V3ConfigurationMigrationHelper;", BuildConfig.FLAVOR, "<init>", "()V", "mapV2ToV3Configuration", "Ldk/molslinjen/domain/model/config/Configuration;", "oldConfiguration", "Ldk/molslinjen/core/migration/oldModels/OldV2Configuration;", "mapV2ToV2LocalizedSiteConfiguration", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "oldSiteConfiguration", "Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class V3ConfigurationMigrationHelper {
    private final LocalizedSiteConfiguration mapV2ToV2LocalizedSiteConfiguration(OldV2LocalizedSiteConfiguration oldSiteConfiguration) {
        List<OldV2Transportation> transportations = oldSiteConfiguration.getTransportations();
        Site site = oldSiteConfiguration.getSite();
        List<Route> routes = oldSiteConfiguration.getRoutes();
        List<OldV2Transportation> list = transportations;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((OldV2Transportation) it.next()).getAllowedRouteIds());
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (OldV2Transportation oldV2Transportation : list) {
            String id = oldV2Transportation.getId();
            String name = oldV2Transportation.getName();
            String name2 = oldV2Transportation.getName();
            String imageUrl = oldV2Transportation.getImageUrl();
            boolean isFreightPossible = oldV2Transportation.getIsFreightPossible();
            boolean isWalking = oldV2Transportation.getIsWalking();
            boolean isEarlyCheckInAllowed = oldV2Transportation.getIsEarlyCheckInAllowed();
            boolean isOnlyAvailableWithReturnTicket = oldV2Transportation.getIsOnlyAvailableWithReturnTicket();
            boolean isTura = oldV2Transportation.getIsTura();
            double maxHeight = oldV2Transportation.getMaxHeight();
            double maxLength = oldV2Transportation.getMaxLength();
            int maxPassengers = oldV2Transportation.getMaxPassengers();
            double maxWeight = oldV2Transportation.getMaxWeight();
            arrayList2.add(new Transportation(oldV2Transportation.getAllowedRouteIds(), oldV2Transportation.getAdultRequired(), oldV2Transportation.getAdultRequiredForInfants(), oldV2Transportation.getAllowLicensePlate(), imageUrl, id, isEarlyCheckInAllowed, isFreightPossible, isWalking, isOnlyAvailableWithReturnTicket, maxHeight, maxLength, maxPassengers, maxWeight, name, name2, oldV2Transportation.getPassengerEntryType(), oldV2Transportation.getPersonDataOnlyForChauffeur(), oldV2Transportation.getLicensePlateRequired(), oldV2Transportation.getTrailerAllowed(), isTura));
        }
        return new LocalizedSiteConfiguration(routes, CollectionsKt.listOf(new TransportationCategory(distinct, false, "Alle transportmidler", arrayList2)), CollectionsKt.emptyList(), oldSiteConfiguration.getHarbors(), oldSiteConfiguration.getRegions(), oldSiteConfiguration.getMultiRideTypes(), oldSiteConfiguration.getFerries(), oldSiteConfiguration.getAgeClassifications(), oldSiteConfiguration.getSiteName(), oldSiteConfiguration.getLineLogoUrl(), site, oldSiteConfiguration.getSupportInfo(), oldSiteConfiguration.getEnabledCurrencies());
    }

    public final Configuration mapV2ToV3Configuration(OldV2Configuration oldConfiguration) {
        Intrinsics.checkNotNullParameter(oldConfiguration, "oldConfiguration");
        Map<Site, OldV2SiteConfiguration> siteConfigurations = oldConfiguration.getSiteConfigurations();
        ArrayList arrayList = new ArrayList(siteConfigurations.size());
        for (Map.Entry<Site, OldV2SiteConfiguration> entry : siteConfigurations.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), new SiteConfiguration(entry.getValue().getSite(), mapV2ToV2LocalizedSiteConfiguration(entry.getValue().getDanishConfiguration()), mapV2ToV2LocalizedSiteConfiguration(entry.getValue().getEnglishConfiguration()), mapV2ToV2LocalizedSiteConfiguration(entry.getValue().getSwedishConfiguration()))));
        }
        return new Configuration((Map<Site, SiteConfiguration>) MapsKt.toMap(arrayList));
    }
}
