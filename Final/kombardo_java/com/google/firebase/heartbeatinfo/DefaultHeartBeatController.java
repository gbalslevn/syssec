package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfoStorage;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<HeartBeatInfoStorage> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    private DefaultHeartBeatController(final Context context, final String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this((Provider<HeartBeatInfoStorage>) new Provider() { // from class: Q0.b
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                HeartBeatInfoStorage lambda$new$2;
                lambda$new$2 = DefaultHeartBeatController.lambda$new$2(context, str);
                return lambda$new$2;
            }
        }, set, executor, provider, context);
    }

    public static Component<DefaultHeartBeatController> component() {
        final Qualified qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.setOf(HeartBeatConsumer.class)).add(Dependency.requiredProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.required((Qualified<?>) qualified)).factory(new ComponentFactory() { // from class: Q0.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                DefaultHeartBeatController lambda$component$3;
                lambda$component$3 = DefaultHeartBeatController.lambda$component$3(Qualified.this, componentContainer);
                return lambda$component$3;
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController lambda$component$3(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), (Set<HeartBeatConsumer>) componentContainer.setOf(HeartBeatConsumer.class), (Provider<UserAgentPublisher>) componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get(qualified));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getHeartBeatsHeader$1() {
        String byteArrayOutputStream;
        synchronized (this) {
            try {
                HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
                List<HeartBeatResult> allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
                heartBeatInfoStorage.deleteAllHeartBeats();
                JSONArray jSONArray = new JSONArray();
                for (int i5 = 0; i5 < allHeartBeats.size(); i5++) {
                    HeartBeatResult heartBeatResult = allHeartBeats.get(i5);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.getUserAgent());
                    jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes(Constants.ENCODING));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString(Constants.ENCODING);
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HeartBeatInfoStorage lambda$new$2(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$registerHeartBeat$0() {
        synchronized (this) {
            this.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        if (!heartBeatInfoStorage.shouldSendGlobalHeartBeat(currentTimeMillis)) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        heartBeatInfoStorage.postHeartBeatCleanUp();
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task<String> getHeartBeatsHeader() {
        return !UserManagerCompat.isUserUnlocked(this.applicationContext) ? Tasks.forResult(BuildConfig.FLAVOR) : Tasks.call(this.backgroundExecutor, new Callable() { // from class: Q0.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String lambda$getHeartBeatsHeader$1;
                lambda$getHeartBeatsHeader$1 = DefaultHeartBeatController.this.lambda$getHeartBeatsHeader$1();
                return lambda$getHeartBeatsHeader$1;
            }
        });
    }

    public Task<Void> registerHeartBeat() {
        if (this.consumers.size() > 0 && UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            return Tasks.call(this.backgroundExecutor, new Callable() { // from class: Q0.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void lambda$registerHeartBeat$0;
                    lambda$registerHeartBeat$0 = DefaultHeartBeatController.this.lambda$registerHeartBeat$0();
                    return lambda$registerHeartBeat$0;
                }
            });
        }
        return Tasks.forResult(null);
    }

    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider2;
        this.applicationContext = context;
    }
}
