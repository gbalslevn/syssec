package com.adjust.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class InstallReferrerHuawei {
    private static final int COLUMN_INDEX_CLICK_TIME = 1;
    private static final int COLUMN_INDEX_INSTALL_TIME = 2;
    private static final int COLUMN_INDEX_REFERRER = 0;
    private static final int COLUMN_INDEX_TRACK_ID = 4;
    private static final String REFERRER_PROVIDER_AUTHORITY = "com.huawei.appmarket.commondata";
    private static final String REFERRER_PROVIDER_URI = "content://com.huawei.appmarket.commondata/item/5";
    private Context context;
    private final InstallReferrerReadListener referrerCallback;
    private ILogger logger = AdjustFactory.getLogger();
    private final AtomicBoolean shouldTryToRead = new AtomicBoolean(true);

    public InstallReferrerHuawei(Context context, InstallReferrerReadListener installReferrerReadListener) {
        this.context = context;
        this.referrerCallback = installReferrerReadListener;
    }

    private boolean isValidReferrerHuaweiAds(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private boolean isValidReferrerHuaweiAppGallery(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
    
        if (r8 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d0, code lost:
    
        r15.shouldTryToRead.set(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cd, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cb, code lost:
    
        if (0 == 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readReferrer() {
        if (!this.shouldTryToRead.get()) {
            this.logger.debug("Should not try to read Install referrer Huawei", new Object[0]);
            return;
        }
        if (!Util.resolveContentProvider(this.context, REFERRER_PROVIDER_AUTHORITY)) {
            return;
        }
        Uri parse = Uri.parse(REFERRER_PROVIDER_URI);
        Cursor cursor = null;
        try {
            try {
                cursor = this.context.getContentResolver().query(parse, null, null, new String[]{this.context.getPackageName()}, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    this.logger.debug("InstallReferrerHuawei fail to read referrer for package [%s] and content uri [%s]", this.context.getPackageName(), parse.toString());
                } else {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(4);
                    this.logger.debug("InstallReferrerHuawei reads index_referrer[%s] index_track_id[%s]", string, string2);
                    String string3 = cursor.getString(1);
                    String string4 = cursor.getString(2);
                    this.logger.debug("InstallReferrerHuawei reads clickTime[%s] installTime[%s]", string3, string4);
                    long parseLong = Long.parseLong(string3);
                    long parseLong2 = Long.parseLong(string4);
                    if (isValidReferrerHuaweiAds(string)) {
                        this.referrerCallback.onInstallReferrerRead(new ReferrerDetails(string, parseLong, parseLong2), Constants.REFERRER_API_HUAWEI_ADS);
                    }
                    if (isValidReferrerHuaweiAppGallery(string2)) {
                        this.referrerCallback.onInstallReferrerRead(new ReferrerDetails(string2, parseLong, parseLong2), Constants.REFERRER_API_HUAWEI_APP_GALLERY);
                    }
                }
            } catch (Exception e5) {
                this.logger.debug("InstallReferrerHuawei error [%s]", e5.getMessage());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
