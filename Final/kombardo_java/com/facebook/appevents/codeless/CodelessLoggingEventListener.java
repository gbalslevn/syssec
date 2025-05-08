package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sdk.growthbook.utils.Constants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\fH\u0007J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener;", BuildConfig.FLAVOR, "()V", "getOnClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "getOnItemClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView;", "logEvent", BuildConfig.FLAVOR, "logEvent$facebook_core_release", "updateParameters", "parameters", "Landroid/os/Bundle;", "updateParameters$facebook_core_release", "AutoLoggingOnClickListener", "AutoLoggingOnItemClickListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CodelessLoggingEventListener {
    public static final CodelessLoggingEventListener INSTANCE = new CodelessLoggingEventListener();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "Landroid/view/View$OnClickListener;", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Landroid/view/View;", "rootView", "hostView", "<init>", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "view", BuildConfig.FLAVOR, "onClick", "(Landroid/view/View;)V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "existingOnClickListener", "Landroid/view/View$OnClickListener;", BuildConfig.FLAVOR, "supportCodelessLogging", "Z", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AutoLoggingOnClickListener implements View.OnClickListener {
        private View.OnClickListener existingOnClickListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnClickListener(EventBinding mapping, View rootView, View hostView) {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            this.mapping = mapping;
            this.hostView = new WeakReference<>(hostView);
            this.rootView = new WeakReference<>(rootView);
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(hostView);
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(view, "view");
                    View.OnClickListener onClickListener = this.existingOnClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    View view2 = this.rootView.get();
                    View view3 = this.hostView.get();
                    if (view2 == null || view3 == null) {
                        return;
                    }
                    CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                    CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, view3);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ5\u0010\u0011\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R \u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Landroid/view/View;", "rootView", "Landroid/widget/AdapterView;", "hostView", "<init>", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/widget/AdapterView;)V", "parent", "view", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "existingOnItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", BuildConfig.FLAVOR, "supportCodelessLogging", "Z", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        private WeakReference<AdapterView<?>> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnItemClickListener(EventBinding mapping, View rootView, AdapterView<?> hostView) {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            this.mapping = mapping;
            this.hostView = new WeakReference<>(hostView);
            this.rootView = new WeakReference<>(rootView);
            this.existingOnItemClickListener = hostView.getOnItemClickListener();
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intrinsics.checkNotNullParameter(view, "view");
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(parent, view, position, id);
            }
            View view2 = this.rootView.get();
            AdapterView<?> adapterView = this.hostView.get();
            if (view2 == null || adapterView == null) {
                return;
            }
            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
            CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, adapterView);
        }
    }

    private CodelessLoggingEventListener() {
    }

    public static final AutoLoggingOnClickListener getOnClickListener(EventBinding mapping, View rootView, View hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            return new AutoLoggingOnClickListener(mapping, rootView, hostView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    public static final AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding mapping, View rootView, AdapterView<?> hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            return new AutoLoggingOnItemClickListener(mapping, rootView, hostView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    public static final void logEvent$facebook_core_release(EventBinding mapping, View rootView, View hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            final String eventName = mapping.getEventName();
            final Bundle parameters = CodelessMatcher.INSTANCE.getParameters(mapping, rootView, hostView);
            INSTANCE.updateParameters$facebook_core_release(parameters);
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: h0.a
                @Override // java.lang.Runnable
                public final void run() {
                    CodelessLoggingEventListener.m2818logEvent$lambda0(eventName, parameters);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: logEvent$lambda-0, reason: not valid java name */
    public static final void m2818logEvent$lambda0(String eventName, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "$eventName");
            Intrinsics.checkNotNullParameter(parameters, "$parameters");
            AppEventsLogger.INSTANCE.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    public final void updateParameters$facebook_core_release(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            String string = parameters.getString("_valueToSum");
            if (string != null) {
                parameters.putDouble("_valueToSum", AppEventUtility.normalizePrice(string));
            }
            parameters.putString("_is_fb_codeless", "1");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
