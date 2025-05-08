package android.adservices.customaudience;

import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public abstract class CustomAudience {

    /* loaded from: classes.dex */
    public static class Builder {
        public CustomAudience build() {
            throw new RuntimeException("Stub!");
        }

        public Builder setAds(List<AdData> list) {
            throw new RuntimeException("Stub!");
        }

        public Builder setBiddingLogicUri(Uri uri) {
            throw new RuntimeException("Stub!");
        }

        public Builder setBuyer(AdTechIdentifier adTechIdentifier) {
            throw new RuntimeException("Stub!");
        }

        public Builder setDailyUpdateUri(Uri uri) {
            throw new RuntimeException("Stub!");
        }

        public Builder setName(String str) {
            throw new RuntimeException("Stub!");
        }

        public Builder setTrustedBiddingData(TrustedBiddingData trustedBiddingData) {
            throw new RuntimeException("Stub!");
        }

        public Builder setUserBiddingSignals(AdSelectionSignals adSelectionSignals) {
            throw new RuntimeException("Stub!");
        }
    }
}
