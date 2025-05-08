package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class ActivityState implements Serializable, Cloneable {
    private static final int ORDER_ID_MAXCOUNT = 10;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;
    private transient ILogger logger = AdjustFactory.getLogger();
    public String uuid = Util.createUuid();
    public boolean enabled = true;
    public boolean isGdprForgotten = false;
    public boolean isThirdPartySharingDisabled = false;
    public boolean isThirdPartySharingDisabledForCoppa = false;
    public boolean askingAttribution = false;
    public int eventCount = 0;
    public int sessionCount = 0;
    public int subsessionCount = -1;
    public long sessionLength = -1;
    public long timeSpent = -1;
    public long lastActivity = -1;
    public long lastInterval = -1;
    public boolean updatePackages = false;
    public LinkedList<String> orderIds = null;
    public String pushToken = null;
    public String adid = null;
    public long clickTime = 0;
    public long installBegin = 0;
    public String installReferrer = null;
    public Boolean googlePlayInstant = null;
    public long clickTimeServer = 0;
    public long installBeginServer = 0;
    public String installVersion = null;
    public long clickTimeHuawei = 0;
    public long installBeginHuawei = 0;
    public String installReferrerHuawei = null;
    public String installReferrerHuaweiAppGallery = null;
    public long clickTimeXiaomi = 0;
    public long installBeginXiaomi = 0;
    public String installReferrerXiaomi = null;
    public long clickTimeServerXiaomi = 0;
    public long installBeginServerXiaomi = 0;
    public String installVersionXiaomi = null;
    public long clickTimeSamsung = 0;
    public long installBeginSamsung = 0;
    public String installReferrerSamsung = null;
    public long clickTimeVivo = 0;
    public long installBeginVivo = 0;
    public String installReferrerVivo = null;
    public String installVersionVivo = null;

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("uuid", String.class);
        Class cls = Boolean.TYPE;
        ObjectStreamField objectStreamField2 = new ObjectStreamField("enabled", cls);
        ObjectStreamField objectStreamField3 = new ObjectStreamField("isGdprForgotten", cls);
        ObjectStreamField objectStreamField4 = new ObjectStreamField("isThirdPartySharingDisabled", cls);
        ObjectStreamField objectStreamField5 = new ObjectStreamField("askingAttribution", cls);
        Class cls2 = Integer.TYPE;
        ObjectStreamField objectStreamField6 = new ObjectStreamField("eventCount", cls2);
        ObjectStreamField objectStreamField7 = new ObjectStreamField("sessionCount", cls2);
        ObjectStreamField objectStreamField8 = new ObjectStreamField("subsessionCount", cls2);
        Class cls3 = Long.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, objectStreamField2, objectStreamField3, objectStreamField4, objectStreamField5, objectStreamField6, objectStreamField7, objectStreamField8, new ObjectStreamField("sessionLength", cls3), new ObjectStreamField("timeSpent", cls3), new ObjectStreamField("lastActivity", cls3), new ObjectStreamField("lastInterval", cls3), new ObjectStreamField("updatePackages", cls), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", String.class), new ObjectStreamField("adid", String.class), new ObjectStreamField("clickTime", cls3), new ObjectStreamField("installBegin", cls3), new ObjectStreamField("installReferrer", String.class), new ObjectStreamField("googlePlayInstant", Boolean.class), new ObjectStreamField("clickTimeServer", cls3), new ObjectStreamField("installBeginServer", cls3), new ObjectStreamField("installVersion", String.class), new ObjectStreamField("clickTimeHuawei", cls3), new ObjectStreamField("installBeginHuawei", cls3), new ObjectStreamField("installReferrerHuawei", String.class), new ObjectStreamField("installReferrerHuaweiAppGallery", String.class), new ObjectStreamField("isThirdPartySharingDisabledForCoppa", cls), new ObjectStreamField("clickTimeXiaomi", cls3), new ObjectStreamField("installBeginXiaomi", cls3), new ObjectStreamField("installReferrerXiaomi", String.class), new ObjectStreamField("clickTimeServerXiaomi", cls3), new ObjectStreamField("installBeginServerXiaomi", cls3), new ObjectStreamField("installVersionXiaomi", String.class), new ObjectStreamField("clickTimeSamsung", cls3), new ObjectStreamField("installBeginSamsung", cls3), new ObjectStreamField("installReferrerSamsung", String.class), new ObjectStreamField("clickTimeVivo", cls3), new ObjectStreamField("installBeginVivo", cls3), new ObjectStreamField("installReferrerVivo", String.class), new ObjectStreamField("installVersionVivo", String.class)};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.eventCount = Util.readIntField(readFields, "eventCount", 0);
        this.sessionCount = Util.readIntField(readFields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(readFields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(readFields, "sessionLength", -1L);
        this.timeSpent = Util.readLongField(readFields, "timeSpent", -1L);
        this.lastActivity = Util.readLongField(readFields, "lastActivity", -1L);
        this.lastInterval = Util.readLongField(readFields, "lastInterval", -1L);
        this.uuid = Util.readStringField(readFields, "uuid", null);
        this.enabled = Util.readBooleanField(readFields, "enabled", true);
        this.isGdprForgotten = Util.readBooleanField(readFields, "isGdprForgotten", false);
        this.isThirdPartySharingDisabled = Util.readBooleanField(readFields, "isThirdPartySharingDisabled", false);
        this.isThirdPartySharingDisabledForCoppa = Util.readBooleanField(readFields, "isThirdPartySharingDisabledForCoppa", false);
        this.askingAttribution = Util.readBooleanField(readFields, "askingAttribution", false);
        this.updatePackages = Util.readBooleanField(readFields, "updatePackages", false);
        this.orderIds = (LinkedList) Util.readObjectField(readFields, "orderIds", null);
        this.pushToken = Util.readStringField(readFields, "pushToken", null);
        this.adid = Util.readStringField(readFields, "adid", null);
        this.clickTime = Util.readLongField(readFields, "clickTime", -1L);
        this.installBegin = Util.readLongField(readFields, "installBegin", -1L);
        this.installReferrer = Util.readStringField(readFields, "installReferrer", null);
        this.googlePlayInstant = (Boolean) Util.readObjectField(readFields, "googlePlayInstant", null);
        this.clickTimeServer = Util.readLongField(readFields, "clickTimeServer", -1L);
        this.installBeginServer = Util.readLongField(readFields, "installBeginServer", -1L);
        this.installVersion = Util.readStringField(readFields, "installVersion", null);
        this.clickTimeHuawei = Util.readLongField(readFields, "clickTimeHuawei", -1L);
        this.installBeginHuawei = Util.readLongField(readFields, "installBeginHuawei", -1L);
        this.installReferrerHuawei = Util.readStringField(readFields, "installReferrerHuawei", null);
        this.installReferrerHuaweiAppGallery = Util.readStringField(readFields, "installReferrerHuaweiAppGallery", null);
        this.clickTimeXiaomi = Util.readLongField(readFields, "clickTimeXiaomi", -1L);
        this.installBeginXiaomi = Util.readLongField(readFields, "installBeginXiaomi", -1L);
        this.installReferrerXiaomi = Util.readStringField(readFields, "installReferrerXiaomi", null);
        this.clickTimeServerXiaomi = Util.readLongField(readFields, "clickTimeServerXiaomi", -1L);
        this.installBeginServerXiaomi = Util.readLongField(readFields, "installBeginServerXiaomi", -1L);
        this.installVersionXiaomi = Util.readStringField(readFields, "installVersionXiaomi", null);
        this.clickTimeSamsung = Util.readLongField(readFields, "clickTimeSamsung", -1L);
        this.installBeginSamsung = Util.readLongField(readFields, "installBeginSamsung", -1L);
        this.installReferrerSamsung = Util.readStringField(readFields, "installReferrerSamsung", null);
        this.clickTimeVivo = Util.readLongField(readFields, "clickTimeVivo", -1L);
        this.installBeginVivo = Util.readLongField(readFields, "installBeginVivo", -1L);
        this.installReferrerVivo = Util.readStringField(readFields, "installReferrerVivo", null);
        this.installVersionVivo = Util.readStringField(readFields, "installVersionVivo", null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
    }

    private static String stamp(long j5) {
        Calendar.getInstance().setTimeInMillis(j5);
        return Util.formatString("%02d:%02d:%02d", 11, 12, 13);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public void addOrderId(String str) {
        if (this.orderIds == null) {
            this.orderIds = new LinkedList<>();
        }
        if (this.orderIds.size() >= 10) {
            this.orderIds.removeLast();
        }
        this.orderIds.addFirst(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityState activityState = (ActivityState) obj;
        return Util.equalString(this.uuid, activityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(activityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(activityState.isGdprForgotten)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled), Boolean.valueOf(activityState.isThirdPartySharingDisabled)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Boolean.valueOf(activityState.isThirdPartySharingDisabledForCoppa)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(activityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(activityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(activityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(activityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(activityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(activityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(activityState.lastInterval)) && Util.equalBoolean(Boolean.valueOf(this.updatePackages), Boolean.valueOf(activityState.updatePackages)) && Util.equalObject(this.orderIds, activityState.orderIds) && Util.equalString(this.pushToken, activityState.pushToken) && Util.equalString(this.adid, activityState.adid) && Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(activityState.clickTime)) && Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(activityState.installBegin)) && Util.equalString(this.installReferrer, activityState.installReferrer) && Util.equalBoolean(this.googlePlayInstant, activityState.googlePlayInstant) && Util.equalLong(Long.valueOf(this.clickTimeServer), Long.valueOf(activityState.clickTimeServer)) && Util.equalLong(Long.valueOf(this.installBeginServer), Long.valueOf(activityState.installBeginServer)) && Util.equalString(this.installVersion, activityState.installVersion) && Util.equalLong(Long.valueOf(this.clickTimeHuawei), Long.valueOf(activityState.clickTimeHuawei)) && Util.equalLong(Long.valueOf(this.installBeginHuawei), Long.valueOf(activityState.installBeginHuawei)) && Util.equalString(this.installReferrerHuawei, activityState.installReferrerHuawei) && Util.equalString(this.installReferrerHuaweiAppGallery, activityState.installReferrerHuaweiAppGallery) && Util.equalLong(Long.valueOf(this.clickTimeXiaomi), Long.valueOf(activityState.clickTimeXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginXiaomi), Long.valueOf(activityState.installBeginXiaomi)) && Util.equalString(this.installReferrerXiaomi, activityState.installReferrerXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeServerXiaomi), Long.valueOf(activityState.clickTimeServerXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginServerXiaomi), Long.valueOf(activityState.installBeginServerXiaomi)) && Util.equalString(this.installVersionXiaomi, activityState.installVersionXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeSamsung), Long.valueOf(activityState.clickTimeSamsung)) && Util.equalLong(Long.valueOf(this.installBeginSamsung), Long.valueOf(activityState.installBeginSamsung)) && Util.equalString(this.installReferrerSamsung, activityState.installReferrerSamsung) && Util.equalLong(Long.valueOf(this.clickTimeVivo), Long.valueOf(activityState.clickTimeVivo)) && Util.equalLong(Long.valueOf(this.installBeginVivo), Long.valueOf(activityState.installBeginVivo)) && Util.equalString(this.installReferrerVivo, activityState.installReferrerVivo) && Util.equalString(this.installVersionVivo, activityState.installVersionVivo);
    }

    public boolean findOrderId(String str) {
        LinkedList<String> linkedList = this.orderIds;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public int hashCode() {
        return Util.hashString(this.installVersionVivo, Util.hashString(this.installReferrerVivo, Util.hashLong(Long.valueOf(this.installBeginVivo), Util.hashLong(Long.valueOf(this.clickTimeVivo), Util.hashString(this.installReferrerSamsung, Util.hashLong(Long.valueOf(this.installBeginSamsung), Util.hashLong(Long.valueOf(this.clickTimeSamsung), Util.hashString(this.installVersionXiaomi, Util.hashLong(Long.valueOf(this.installBeginServerXiaomi), Util.hashLong(Long.valueOf(this.clickTimeServerXiaomi), Util.hashString(this.installReferrerXiaomi, Util.hashLong(Long.valueOf(this.installBeginXiaomi), Util.hashLong(Long.valueOf(this.clickTimeXiaomi), Util.hashString(this.installReferrerHuaweiAppGallery, Util.hashString(this.installReferrerHuawei, Util.hashLong(Long.valueOf(this.installBeginHuawei), Util.hashLong(Long.valueOf(this.clickTimeHuawei), Util.hashString(this.installVersion, Util.hashLong(Long.valueOf(this.installBeginServer), Util.hashLong(Long.valueOf(this.clickTimeServer), Util.hashBoolean(this.googlePlayInstant, Util.hashString(this.installReferrer, Util.hashLong(Long.valueOf(this.installBegin), Util.hashLong(Long.valueOf(this.clickTime), Util.hashString(this.adid, Util.hashString(this.pushToken, Util.hashObject(this.orderIds, Util.hashBoolean(Boolean.valueOf(this.updatePackages), Util.hashLong(Long.valueOf(this.lastInterval), Util.hashLong(Long.valueOf(this.timeSpent), Util.hashLong(Long.valueOf(this.sessionLength), (((((Util.hashBoolean(Boolean.valueOf(this.askingAttribution), Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled), Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten), Util.hashBoolean(Boolean.valueOf(this.enabled), Util.hashString(this.uuid, 17)))))) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount)))))))))))))))))))))))))))))));
    }

    public void resetSessionAttributes(long j5) {
        this.subsessionCount = 1;
        this.sessionLength = 0L;
        this.timeSpent = 0L;
        this.lastActivity = j5;
        this.lastInterval = -1L;
    }

    public String toString() {
        return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(this.sessionLength / 1000.0d), Double.valueOf(this.timeSpent / 1000.0d), stamp(this.lastActivity), this.uuid);
    }
}
