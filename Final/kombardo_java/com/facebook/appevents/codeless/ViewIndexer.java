package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer;", BuildConfig.FLAVOR, "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityReference", "Ljava/lang/ref/WeakReference;", "indexingTimer", "Ljava/util/Timer;", "previousDigest", BuildConfig.FLAVOR, "uiThreadHandler", "Landroid/os/Handler;", "processRequest", BuildConfig.FLAVOR, "request", "Lcom/facebook/GraphRequest;", "currentDigest", "schedule", "sendToServer", ViewIndexer.TREE_PARAM, "unschedule", "Companion", "ScreenshotTaker", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG;
    private static final String TREE_PARAM = "tree";
    private static ViewIndexer instance;
    private final WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest;
    private final Handler uiThreadHandler;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "appIndex", "Lcom/facebook/AccessToken;", "accessToken", "appId", "requestType", "Lcom/facebook/GraphRequest;", "buildAppIndexingRequest", "(Ljava/lang/String;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/GraphRequest;", "APP_VERSION_PARAM", "Ljava/lang/String;", "PLATFORM_PARAM", "REQUEST_TYPE", "SUCCESS", "TAG", "TREE_PARAM", "Lcom/facebook/appevents/codeless/ViewIndexer;", "instance", "Lcom/facebook/appevents/codeless/ViewIndexer;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildAppIndexingRequest$lambda-0, reason: not valid java name */
        public static final void m2824buildAppIndexingRequest$lambda0(GraphResponse it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$getTAG$cp(), "App index sent to FB!");
        }

        public final GraphRequest buildAppIndexingRequest(String appIndex, AccessToken accessToken, String appId, String requestType) {
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            if (appIndex == null) {
                return null;
            }
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{appId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(accessToken, format, null, null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(ViewIndexer.TREE_PARAM, appIndex);
            parameters.putString(ViewIndexer.APP_VERSION_PARAM, AppEventUtility.getAppVersion());
            parameters.putString(ViewIndexer.PLATFORM_PARAM, "android");
            parameters.putString(ViewIndexer.REQUEST_TYPE, requestType);
            if (Intrinsics.areEqual(requestType, "app_indexing")) {
                parameters.putString("device_session_id", CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback(new GraphRequest.Callback() { // from class: h0.g
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    ViewIndexer.Companion.m2824buildAppIndexingRequest$lambda0(graphResponse);
                }
            });
            return newPostRequest;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$ScreenshotTaker;", "Ljava/util/concurrent/Callable;", BuildConfig.FLAVOR, "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "Ljava/lang/ref/WeakReference;", "call", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ScreenshotTaker implements Callable<String> {
        private final WeakReference<View> rootView;

        public ScreenshotTaker(View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = new WeakReference<>(rootView);
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            View view = this.rootView.get();
            if (view != null && view.getWidth() != 0 && view.getHeight() != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
                return encodeToString;
            }
            return BuildConfig.FLAVOR;
        }
    }

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = BuildConfig.FLAVOR;
        }
        TAG = canonicalName;
    }

    public ViewIndexer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference<>(activity);
        this.previousDigest = null;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        instance = this;
    }

    public static final /* synthetic */ WeakReference access$getActivityReference$p(ViewIndexer viewIndexer) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return viewIndexer.activityReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ Handler access$getUiThreadHandler$p(ViewIndexer viewIndexer) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return viewIndexer.uiThreadHandler;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$sendToServer(ViewIndexer viewIndexer, String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            viewIndexer.sendToServer(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: schedule$lambda-0, reason: not valid java name */
    public static final void m2822schedule$lambda0(ViewIndexer this$0, TimerTask indexingTask) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(indexingTask, "$indexingTask");
            try {
                Timer timer = this$0.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this$0.previousDigest = null;
                Timer timer2 = new Timer();
                timer2.scheduleAtFixedRate(indexingTask, 0L, 1000L);
                this$0.indexingTimer = timer2;
            } catch (Exception e5) {
                Log.e(TAG, "Error scheduling indexing job", e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    private final void sendToServer(final String tree) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: h0.f
                @Override // java.lang.Runnable
                public final void run() {
                    ViewIndexer.m2823sendToServer$lambda1(tree, this);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendToServer$lambda-1, reason: not valid java name */
    public static final void m2823sendToServer$lambda1(String tree, ViewIndexer this$0) {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(tree, "$tree");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String md5hash = Utility.md5hash(tree);
            AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
            if (md5hash == null || !Intrinsics.areEqual(md5hash, this$0.previousDigest)) {
                this$0.processRequest(INSTANCE.buildAppIndexingRequest(tree, currentAccessToken, FacebookSdk.getApplicationId(), "app_indexing"), md5hash);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewIndexer.class);
        }
    }

    public final void processRequest(GraphRequest request, String currentDigest) {
        if (CrashShieldHandler.isObjectCrashing(this) || request == null) {
            return;
        }
        try {
            GraphResponse executeAndWait = request.executeAndWait();
            try {
                JSONObject graphObject = executeAndWait.getGraphObject();
                if (graphObject == null) {
                    Log.e(TAG, Intrinsics.stringPlus("Error sending UI component tree to Facebook: ", executeAndWait.getError()));
                    return;
                }
                if (Intrinsics.areEqual("true", graphObject.optString(SUCCESS))) {
                    Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                    this.previousDigest = currentDigest;
                }
                if (graphObject.has("is_app_indexing_enabled")) {
                    CodelessManager.updateAppIndexing$facebook_core_release(graphObject.getBoolean("is_app_indexing_enabled"));
                }
            } catch (JSONException e5) {
                Log.e(TAG, "Error decoding server response.", e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void schedule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final TimerTask timerTask = new TimerTask() { // from class: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        Activity activity = (Activity) ViewIndexer.access$getActivityReference$p(ViewIndexer.this).get();
                        View rootView = AppEventUtility.getRootView(activity);
                        if (activity != null && rootView != null) {
                            String simpleName = activity.getClass().getSimpleName();
                            if (CodelessManager.getIsAppIndexingEnabled$facebook_core_release()) {
                                if (InternalSettings.isUnityApp()) {
                                    UnityReflection.captureViewHierarchy();
                                    return;
                                }
                                FutureTask futureTask = new FutureTask(new ViewIndexer.ScreenshotTaker(rootView));
                                ViewIndexer.access$getUiThreadHandler$p(ViewIndexer.this).post(futureTask);
                                String str = BuildConfig.FLAVOR;
                                try {
                                    str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                                } catch (Exception e5) {
                                    Log.e(ViewIndexer.access$getTAG$cp(), "Failed to take screenshot.", e5);
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("screenname", simpleName);
                                    jSONObject.put("screenshot", str);
                                    JSONArray jSONArray = new JSONArray();
                                    jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                                    jSONObject.put("view", jSONArray);
                                } catch (JSONException unused) {
                                    Log.e(ViewIndexer.access$getTAG$cp(), "Failed to create JSONObject");
                                }
                                String jSONObject2 = jSONObject.toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject2, "viewTree.toString()");
                                ViewIndexer.access$sendToServer(ViewIndexer.this, jSONObject2);
                            }
                        }
                    } catch (Exception e6) {
                        Log.e(ViewIndexer.access$getTAG$cp(), "UI Component tree indexing failure!", e6);
                    }
                }
            };
            try {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: h0.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewIndexer.m2822schedule$lambda0(ViewIndexer.this, timerTask);
                    }
                });
            } catch (RejectedExecutionException e5) {
                Log.e(TAG, "Error scheduling indexing job", e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void unschedule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.activityReference.get() == null) {
                return;
            }
            try {
                Timer timer = this.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this.indexingTimer = null;
            } catch (Exception e5) {
                Log.e(TAG, "Error unscheduling indexing job", e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
