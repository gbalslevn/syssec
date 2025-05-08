package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdjustAttribution implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("trackerToken", String.class), new ObjectStreamField("trackerName", String.class), new ObjectStreamField("network", String.class), new ObjectStreamField("campaign", String.class), new ObjectStreamField("adgroup", String.class), new ObjectStreamField("creative", String.class), new ObjectStreamField("clickLabel", String.class), new ObjectStreamField("adid", String.class), new ObjectStreamField("costType", String.class), new ObjectStreamField("costAmount", Double.class), new ObjectStreamField("costCurrency", String.class), new ObjectStreamField("fbInstallReferrer", String.class)};
    private static final long serialVersionUID = 1;
    public String adgroup;
    public String adid;
    public String campaign;
    public String clickLabel;
    public Double costAmount;
    public String costCurrency;
    public String costType;
    public String creative;
    public String fbInstallReferrer;
    public String network;
    public String trackerName;
    public String trackerToken;

    public static AdjustAttribution fromJson(JSONObject jSONObject, String str, String str2) {
        String optString;
        if (jSONObject == null) {
            return null;
        }
        AdjustAttribution adjustAttribution = new AdjustAttribution();
        if ("unity".equals(str2)) {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.trackerName = jSONObject.optString("tracker_name", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.network = jSONObject.optString("network", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.campaign = jSONObject.optString("campaign", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.adgroup = jSONObject.optString("adgroup", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.creative = jSONObject.optString("creative", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.clickLabel = jSONObject.optString("click_label", org.conscrypt.BuildConfig.FLAVOR);
            if (str == null) {
                str = org.conscrypt.BuildConfig.FLAVOR;
            }
            adjustAttribution.adid = str;
            adjustAttribution.costType = jSONObject.optString("cost_type", org.conscrypt.BuildConfig.FLAVOR);
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount", 0.0d));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency", org.conscrypt.BuildConfig.FLAVOR);
            optString = jSONObject.optString("fb_install_referrer", org.conscrypt.BuildConfig.FLAVOR);
        } else {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name");
            adjustAttribution.network = jSONObject.optString("network");
            adjustAttribution.campaign = jSONObject.optString("campaign");
            adjustAttribution.adgroup = jSONObject.optString("adgroup");
            adjustAttribution.creative = jSONObject.optString("creative");
            adjustAttribution.clickLabel = jSONObject.optString("click_label");
            adjustAttribution.adid = str;
            adjustAttribution.costType = jSONObject.optString("cost_type");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount"));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency");
            optString = jSONObject.optString("fb_install_referrer");
        }
        adjustAttribution.fbInstallReferrer = optString;
        return adjustAttribution;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdjustAttribution adjustAttribution = (AdjustAttribution) obj;
        return Util.equalString(this.trackerToken, adjustAttribution.trackerToken) && Util.equalString(this.trackerName, adjustAttribution.trackerName) && Util.equalString(this.network, adjustAttribution.network) && Util.equalString(this.campaign, adjustAttribution.campaign) && Util.equalString(this.adgroup, adjustAttribution.adgroup) && Util.equalString(this.creative, adjustAttribution.creative) && Util.equalString(this.clickLabel, adjustAttribution.clickLabel) && Util.equalString(this.adid, adjustAttribution.adid) && Util.equalString(this.costType, adjustAttribution.costType) && Util.equalsDouble(this.costAmount, adjustAttribution.costAmount) && Util.equalString(this.costCurrency, adjustAttribution.costCurrency) && Util.equalString(this.fbInstallReferrer, adjustAttribution.fbInstallReferrer);
    }

    public int hashCode() {
        return Util.hashString(this.fbInstallReferrer, Util.hashString(this.costCurrency, Util.hashDouble(this.costAmount, Util.hashString(this.costType, Util.hashString(this.adid, Util.hashString(this.clickLabel, Util.hashString(this.creative, Util.hashString(this.adgroup, Util.hashString(this.campaign, Util.hashString(this.network, Util.hashString(this.trackerName, Util.hashString(this.trackerToken, 17))))))))))));
    }

    public String toString() {
        return Util.formatString("tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s adid:%s ct:%s ca:%.2f cc:%s fir:%s", this.trackerToken, this.trackerName, this.network, this.campaign, this.adgroup, this.creative, this.clickLabel, this.adid, this.costType, this.costAmount, this.costCurrency, this.fbInstallReferrer);
    }
}
