package com.facebook.appevents.ml;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002?@B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ;\u0010#\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007¢\u0006\u0004\b#\u0010$J'\u0010(\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0017H\u0002¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0017H\u0002¢\u0006\u0004\b*\u0010)R\"\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00100R\u0014\u00104\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00100R\u0014\u00106\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00100R\u0014\u00107\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00100R\u0014\u00108\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00100R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020!098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020!098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "timestamp", BuildConfig.FLAVOR, "isValidTimestamp", "(J)Z", "Lorg/json/JSONObject;", ModelManager.CACHE_KEY_MODELS, "addModels", "(Lorg/json/JSONObject;)V", "jsonObject", "parseRawJsonObject", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "fetchModels", "()Lorg/json/JSONObject;", "enableMTML", "Lorg/json/JSONArray;", "jsonArray", BuildConfig.FLAVOR, "parseJsonArray", "(Lorg/json/JSONArray;)[F", "Lcom/facebook/appevents/ml/ModelManager$Task;", "task", "Ljava/io/File;", "getRuleFile", "(Lcom/facebook/appevents/ml/ModelManager$Task;)Ljava/io/File;", BuildConfig.FLAVOR, "denses", BuildConfig.FLAVOR, "texts", "predict", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "Lcom/facebook/appevents/ml/MTensor;", "res", ModelManager.THRESHOLD_KEY, "processSuggestedEventResult", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processIntegrityDetectionResult", BuildConfig.FLAVOR, "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "taskHandlers", "Ljava/util/Map;", "MODEL_ASSERT_STORE", "Ljava/lang/String;", "CACHE_KEY_MODELS", "MTML_USE_CASE", "USE_CASE_KEY", "VERSION_ID_KEY", "ASSET_URI_KEY", "RULES_URI_KEY", "THRESHOLD_KEY", "CACHE_KEY_REQUEST_TIMESTAMP", BuildConfig.FLAVOR, "MTML_SUGGESTED_EVENTS_PREDICTION", "Ljava/util/List;", "MTML_INTEGRITY_DETECT_PREDICTION", "isLocaleEnglish", "()Z", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    public static final ModelManager INSTANCE = new ModelManager();
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt.listOf((Object[]) new String[]{"other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout"});
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt.listOf((Object[]) new String[]{"none", "address", "health"});

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "toKey", BuildConfig.FLAVOR, "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Task.valuesCustom().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Task[] valuesCustom() {
            Task[] valuesCustom = values();
            return (Task[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final String toKey() {
            int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i5 == 1) {
                return "integrity_detect";
            }
            if (i5 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toUseCase() {
            int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i5 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i5 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00101¨\u00063"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "useCase", "assetUri", "ruleUri", BuildConfig.FLAVOR, "versionId", BuildConfig.FLAVOR, ModelManager.THRESHOLD_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "Ljava/lang/Runnable;", "onPostExecute", "setOnPostExecute", "(Ljava/lang/Runnable;)Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "Ljava/lang/String;", "getUseCase", "()Ljava/lang/String;", "setUseCase", "(Ljava/lang/String;)V", "getAssetUri", "setAssetUri", "getRuleUri", "setRuleUri", "I", "getVersionId", "()I", "setVersionId", "(I)V", "[F", "getThresholds", "()[F", "setThresholds", "([F)V", "Ljava/io/File;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "Lcom/facebook/appevents/ml/Model;", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "Ljava/lang/Runnable;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TaskHandler {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String assetUri;
        private Model model;
        private Runnable onPostExecute;
        private File ruleFile;
        private String ruleUri;
        private float[] thresholds;
        private String useCase;
        private int versionId;

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "useCase", BuildConfig.FLAVOR, "versionId", BuildConfig.FLAVOR, "deleteOldFiles", "(Ljava/lang/String;I)V", "uri", "name", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "onComplete", "download", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "Lorg/json/JSONObject;", "json", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "build", "(Lorg/json/JSONObject;)Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "master", BuildConfig.FLAVOR, "slaves", "execute", "(Lcom/facebook/appevents/ml/ModelManager$TaskHandler;Ljava/util/List;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final void deleteOldFiles(String useCase, int versionId) {
                File[] listFiles;
                File mlDir = Utils.getMlDir();
                if (mlDir == null || (listFiles = mlDir.listFiles()) == null || listFiles.length == 0) {
                    return;
                }
                String str = useCase + '_' + versionId;
                int length = listFiles.length;
                int i5 = 0;
                while (i5 < length) {
                    File file = listFiles[i5];
                    i5++;
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    if (StringsKt.startsWith$default(name, useCase, false, 2, (Object) null) && !StringsKt.startsWith$default(name, str, false, 2, (Object) null)) {
                        file.delete();
                    }
                }
            }

            private final void download(String uri, String name, FileDownloadTask.Callback onComplete) {
                File file = new File(Utils.getMlDir(), name);
                if (uri == null || file.exists()) {
                    onComplete.onComplete(file);
                } else {
                    new FileDownloadTask(uri, file, onComplete).execute(new String[0]);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1, reason: not valid java name */
            public static final void m2844execute$lambda1(List slaves, File file) {
                Intrinsics.checkNotNullParameter(slaves, "$slaves");
                Intrinsics.checkNotNullParameter(file, "file");
                final Model build = Model.INSTANCE.build(file);
                if (build != null) {
                    Iterator it = slaves.iterator();
                    while (it.hasNext()) {
                        final TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.INSTANCE.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new FileDownloadTask.Callback() { // from class: l0.e
                            @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                            public final void onComplete(File file2) {
                                ModelManager.TaskHandler.Companion.m2845execute$lambda1$lambda0(ModelManager.TaskHandler.this, build, file2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0, reason: not valid java name */
            public static final void m2845execute$lambda1$lambda0(TaskHandler slave, Model model, File file) {
                Intrinsics.checkNotNullParameter(slave, "$slave");
                Intrinsics.checkNotNullParameter(file, "file");
                slave.setModel(model);
                slave.setRuleFile(file);
                Runnable runnable = slave.onPostExecute;
                if (runnable == null) {
                    return;
                }
                runnable.run();
            }

            public final TaskHandler build(JSONObject json) {
                String useCase;
                String assetUri;
                String optString;
                int i5;
                float[] access$parseJsonArray;
                if (json != null) {
                    try {
                        useCase = json.getString(ModelManager.USE_CASE_KEY);
                        assetUri = json.getString(ModelManager.ASSET_URI_KEY);
                        optString = json.optString(ModelManager.RULES_URI_KEY, null);
                        i5 = json.getInt(ModelManager.VERSION_ID_KEY);
                        access$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, json.getJSONArray(ModelManager.THRESHOLD_KEY));
                        Intrinsics.checkNotNullExpressionValue(useCase, "useCase");
                        Intrinsics.checkNotNullExpressionValue(assetUri, "assetUri");
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return new TaskHandler(useCase, assetUri, optString, i5, access$parseJsonArray);
            }

            public final void execute(TaskHandler master, final List<TaskHandler> slaves) {
                Intrinsics.checkNotNullParameter(master, "master");
                Intrinsics.checkNotNullParameter(slaves, "slaves");
                deleteOldFiles(master.getUseCase(), master.getVersionId());
                download(master.getAssetUri(), master.getUseCase() + '_' + master.getVersionId(), new FileDownloadTask.Callback() { // from class: l0.d
                    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                    public final void onComplete(File file) {
                        ModelManager.TaskHandler.Companion.m2844execute$lambda1(slaves, file);
                    }
                });
            }

            private Companion() {
            }
        }

        public TaskHandler(String useCase, String assetUri, String str, int i5, float[] fArr) {
            Intrinsics.checkNotNullParameter(useCase, "useCase");
            Intrinsics.checkNotNullParameter(assetUri, "assetUri");
            this.useCase = useCase;
            this.assetUri = assetUri;
            this.ruleUri = str;
            this.versionId = i5;
            this.thresholds = fArr;
        }

        public final String getAssetUri() {
            return this.assetUri;
        }

        public final Model getModel() {
            return this.model;
        }

        public final File getRuleFile() {
            return this.ruleFile;
        }

        public final String getRuleUri() {
            return this.ruleUri;
        }

        public final float[] getThresholds() {
            return this.thresholds;
        }

        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setModel(Model model) {
            this.model = model;
        }

        public final TaskHandler setOnPostExecute(Runnable onPostExecute) {
            this.onPostExecute = onPostExecute;
            return this;
        }

        public final void setRuleFile(File file) {
            this.ruleFile = file;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.valuesCustom().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            return modelManager.parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final void addModels(JSONObject models) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Iterator<String> keys = models.keys();
            while (keys.hasNext()) {
                try {
                    TaskHandler build = TaskHandler.INSTANCE.build(models.getJSONObject(keys.next()));
                    if (build != null) {
                        taskHandlers.put(build.getUseCase(), build);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new Runnable() { // from class: l0.a
                @Override // java.lang.Runnable
                public final void run() {
                    ModelManager.m2841enable$lambda0();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: all -> 0x002c, Exception -> 0x007d, TryCatch #2 {Exception -> 0x007d, all -> 0x002c, blocks: (B:6:0x000d, B:8:0x001f, B:11:0x0026, B:12:0x0033, B:14:0x0043, B:16:0x0049, B:18:0x0071, B:21:0x0051, B:24:0x005a, B:25:0x002e), top: B:5:0x000d }] */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2841enable$lambda0() {
        JSONObject jSONObject;
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(MODEL_ASSERT_STORE, 0);
            String string = sharedPreferences.getString(CACHE_KEY_MODELS, null);
            if (string != null && string.length() != 0) {
                jSONObject = new JSONObject(string);
                long j5 = sharedPreferences.getLong(CACHE_KEY_REQUEST_TIMESTAMP, 0L);
                FeatureManager featureManager = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.ModelRequest) || jSONObject.length() == 0 || !INSTANCE.isValidTimestamp(j5)) {
                    jSONObject = INSTANCE.fetchModels();
                    if (jSONObject != null) {
                        return;
                    } else {
                        sharedPreferences.edit().putString(CACHE_KEY_MODELS, jSONObject.toString()).putLong(CACHE_KEY_REQUEST_TIMESTAMP, System.currentTimeMillis()).apply();
                    }
                }
                ModelManager modelManager = INSTANCE;
                modelManager.addModels(jSONObject);
                modelManager.enableMTML();
                return;
            }
            jSONObject = new JSONObject();
            long j52 = sharedPreferences.getLong(CACHE_KEY_REQUEST_TIMESTAMP, 0L);
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.ModelRequest)) {
            }
            jSONObject = INSTANCE.fetchModels();
            if (jSONObject != null) {
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private final void enableMTML() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int i5 = 0;
            for (Map.Entry<String, TaskHandler> entry : taskHandlers.entrySet()) {
                String key = entry.getKey();
                TaskHandler value = entry.getValue();
                if (Intrinsics.areEqual(key, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    String assetUri = value.getAssetUri();
                    int max = Math.max(i5, value.getVersionId());
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: l0.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m2842enableMTML$lambda1();
                            }
                        }));
                    }
                    str = assetUri;
                    i5 = max;
                }
                if (Intrinsics.areEqual(key, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    str = value.getAssetUri();
                    i5 = Math.max(i5, value.getVersionId());
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: l0.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m2843enableMTML$lambda2();
                            }
                        }));
                    }
                }
            }
            if (str == null || i5 <= 0 || arrayList.isEmpty()) {
                return;
            }
            TaskHandler.INSTANCE.execute(new TaskHandler(MTML_USE_CASE, str, null, i5, null), arrayList);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1, reason: not valid java name */
    public static final void m2842enableMTML$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            SuggestedEventsManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2, reason: not valid java name */
    public static final void m2843enableMTML$lambda2() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            IntegrityManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", strArr));
            GraphRequest newGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(null, "app/model_asset", null);
            newGraphPathRequest.setParameters(bundle);
            JSONObject graphObject = newGraphPathRequest.executeAndWait().getGraphObject();
            if (graphObject == null) {
                return null;
            }
            return parseRawJsonObject(graphObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final File getRuleFile(Task task) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.getRuleFile();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                String language = resourceLocale.getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "locale.language");
                if (!StringsKt.contains$default((CharSequence) language, (CharSequence) "en", false, 2, (Object) null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isValidTimestamp(long timestamp) {
        if (CrashShieldHandler.isObjectCrashing(this) || timestamp == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - timestamp < 259200000;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] parseJsonArray(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(this) || jsonArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jsonArray.length()];
            int length = jsonArray.length();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    try {
                        String string = jsonArray.getString(i5);
                        Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                        fArr[i5] = Float.parseFloat(string);
                    } catch (JSONException unused) {
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final JSONObject parseRawJsonObject(JSONObject jsonObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = jsonObject.getJSONArray("data");
                int length = jSONArray.length();
                if (length <= 0) {
                    return jSONObject;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(VERSION_ID_KEY, jSONObject2.getString(VERSION_ID_KEY));
                    jSONObject3.put(USE_CASE_KEY, jSONObject2.getString(USE_CASE_KEY));
                    jSONObject3.put(THRESHOLD_KEY, jSONObject2.getJSONArray(THRESHOLD_KEY));
                    jSONObject3.put(ASSET_URI_KEY, jSONObject2.getString(ASSET_URI_KEY));
                    if (jSONObject2.has(RULES_URI_KEY)) {
                        jSONObject3.put(RULES_URI_KEY, jSONObject2.getString(RULES_URI_KEY));
                    }
                    jSONObject.put(jSONObject2.getString(USE_CASE_KEY), jSONObject3);
                    if (i6 >= length) {
                        return jSONObject;
                    }
                    i5 = i6;
                }
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final String[] predict(Task task, float[][] denses, String[] texts) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(denses, "denses");
            Intrinsics.checkNotNullParameter(texts, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            Model model = taskHandler == null ? null : taskHandler.getModel();
            if (model == null) {
                return null;
            }
            float[] thresholds = taskHandler.getThresholds();
            int length = texts.length;
            int length2 = denses[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    System.arraycopy(denses[i5], 0, mTensor.getData(), i5 * length2, length2);
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            MTensor predictOnMTML = model.predictOnMTML(mTensor, texts, task.toKey());
            if (predictOnMTML != null && thresholds != null && predictOnMTML.getData().length != 0 && thresholds.length != 0) {
                int i7 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
                if (i7 == 1) {
                    return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
                }
                if (i7 == 2) {
                    return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
                }
                throw new NoWhenBranchMatchedException();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final String[] processIntegrityDetectionResult(MTensor res, float[] thresholds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = res.getShape(0);
            int shape2 = res.getShape(1);
            float[] data = res.getData();
            if (shape2 != thresholds.length) {
                return null;
            }
            IntRange until = RangesKt.until(0, shape);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String str = "none";
                int length = thresholds.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    int i7 = i6 + 1;
                    if (data[(nextInt * shape2) + i6] >= thresholds[i5]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i6);
                    }
                    i5++;
                    i6 = i7;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final String[] processSuggestedEventResult(MTensor res, float[] thresholds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = res.getShape(0);
            int shape2 = res.getShape(1);
            float[] data = res.getData();
            if (shape2 != thresholds.length) {
                return null;
            }
            IntRange until = RangesKt.until(0, shape);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String str = "other";
                int length = thresholds.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    int i7 = i6 + 1;
                    if (data[(nextInt * shape2) + i6] >= thresholds[i5]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i6);
                    }
                    i5++;
                    i6 = i7;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
