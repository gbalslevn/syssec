package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b\u0001\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160*8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/facebook/appevents/SessionEventsState;", BuildConfig.FLAVOR, "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", BuildConfig.FLAVOR, "anonymousAppDeviceGUID", "<init>", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "Lcom/facebook/GraphRequest;", "request", "Landroid/content/Context;", "applicationContext", BuildConfig.FLAVOR, "numSkipped", "Lorg/json/JSONArray;", "events", "operationalParameters", BuildConfig.FLAVOR, "limitEventUsage", BuildConfig.FLAVOR, "populateRequest", "(Lcom/facebook/GraphRequest;Landroid/content/Context;ILorg/json/JSONArray;Lorg/json/JSONArray;Z)V", "Lcom/facebook/appevents/AppEvent;", "event", "addEvent", "(Lcom/facebook/appevents/AppEvent;)V", "moveToAccumulated", "clearInFlightAndStats", "(Z)V", "includeImplicitEvents", "(Lcom/facebook/GraphRequest;Landroid/content/Context;ZZ)I", "Lcom/facebook/internal/AttributionIdentifiers;", "Ljava/lang/String;", BuildConfig.FLAVOR, "accumulatedEvents", "Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "I", "getAccumulatedEventCount", "()I", "accumulatedEventCount", BuildConfig.FLAVOR, "getEventsToPersist", "()Ljava/util/List;", "eventsToPersist", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SessionEventsState {
    private List<AppEvent> accumulatedEvents;
    private final String anonymousAppDeviceGUID;
    private final AttributionIdentifiers attributionIdentifiers;
    private final List<AppEvent> inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;
    private static final String TAG = SessionEventsState.class.getSimpleName();
    private static final int MAX_ACCUMULATED_LOG_EVENTS = Constants.ONE_SECOND;

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID) {
        Intrinsics.checkNotNullParameter(attributionIdentifiers, "attributionIdentifiers");
        Intrinsics.checkNotNullParameter(anonymousAppDeviceGUID, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = anonymousAppDeviceGUID;
        this.accumulatedEvents = new ArrayList();
        this.inFlightEvents = new ArrayList();
    }

    public final synchronized void addEvent(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= MAX_ACCUMULATED_LOG_EVENTS) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(event);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean moveToAccumulated) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (moveToAccumulated) {
            try {
                this.accumulatedEvents.addAll(this.inFlightEvents);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public final synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<AppEvent> list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int populateRequest(GraphRequest request, Context applicationContext, boolean includeImplicitEvents, boolean limitEventUsage) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            synchronized (this) {
                try {
                    int i5 = this.numSkippedEventsDueToFullBuffer;
                    EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                    EventDeactivationManager.processEvents(this.accumulatedEvents);
                    this.inFlightEvents.addAll(this.accumulatedEvents);
                    this.accumulatedEvents.clear();
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    for (AppEvent appEvent : this.inFlightEvents) {
                        if (appEvent.isChecksumValid()) {
                            if (!includeImplicitEvents && appEvent.isImplicit()) {
                            }
                            jSONArray.put(appEvent.getJsonObject());
                            jSONArray2.put(appEvent.getOperationalJsonObject());
                        } else {
                            Utility utility = Utility.INSTANCE;
                            Utility.logd(TAG, Intrinsics.stringPlus("Event with invalid checksum: ", appEvent));
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return 0;
                    }
                    Unit unit = Unit.INSTANCE;
                    populateRequest(request, applicationContext, i5, jSONArray, jSONArray2, limitEventUsage);
                    return jSONArray.length();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    private final void populateRequest(GraphRequest request, Context applicationContext, int numSkipped, JSONArray events, JSONArray operationalParameters, boolean limitEventUsage) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, limitEventUsage, applicationContext);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", numSkipped);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            request.setGraphObject(jSONObject);
            Bundle parameters = request.getParameters();
            String jSONArray = events.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "events.toString()");
            parameters.putString("custom_events", jSONArray);
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib5To7)) {
                parameters.putString("operational_parameters", operationalParameters.toString());
            }
            request.setTag(jSONArray);
            request.setParameters(parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
