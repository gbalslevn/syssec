package com.sdk.growthbook.sandbox;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sdk/growthbook/sandbox/CachingAndroid;", "Lcom/sdk/growthbook/sandbox/CachingLayer;", "()V", "json", "Lkotlinx/serialization/json/Json;", "getContent", "Lkotlinx/serialization/json/JsonElement;", "fileName", BuildConfig.FLAVOR, "getTargetFile", "Ljava/io/File;", "saveContent", BuildConfig.FLAVOR, "content", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CachingAndroid implements CachingLayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static File filesDir;
    private final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sdk.growthbook.sandbox.CachingAndroid$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setPrettyPrint(true);
            Json.setLenient(true);
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/sdk/growthbook/sandbox/CachingAndroid$Companion;", BuildConfig.FLAVOR, "()V", "filesDir", "Ljava/io/File;", "getFilesDir$GrowthBook_release", "()Ljava/io/File;", "setFilesDir$GrowthBook_release", "(Ljava/io/File;)V", "consumeContext", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void consumeContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            setFilesDir$GrowthBook_release(context.getFilesDir());
        }

        public final File getFilesDir$GrowthBook_release() {
            return CachingAndroid.filesDir;
        }

        public final void setFilesDir$GrowthBook_release(File file) {
            CachingAndroid.filesDir = file;
        }

        private Companion() {
        }
    }

    @Override // com.sdk.growthbook.sandbox.CachingLayer
    public JsonElement getContent(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File targetFile = getTargetFile(fileName);
        if (targetFile == null || !targetFile.exists()) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), Charsets.UTF_8), 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return (JsonElement) this.json.decodeFromString(JsonElement.INSTANCE.serializer(), readText);
        } finally {
        }
    }

    public final File getTargetFile(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir, "GrowthBook-KMM");
        file.mkdirs();
        if (StringsKt.endsWith(fileName, ".txt", true)) {
            fileName = StringsKt.removeSuffix(fileName, ".txt");
        }
        return new File(file, fileName + ".txt");
    }

    @Override // com.sdk.growthbook.sandbox.CachingLayer
    public void saveContent(String fileName, JsonElement content) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        File targetFile = getTargetFile(fileName);
        if (targetFile != null) {
            if (targetFile.exists()) {
                targetFile.delete();
            }
            targetFile.createNewFile();
            FilesKt.appendText$default(targetFile, this.json.encodeToString(JsonElement.INSTANCE.serializer(), content), null, 2, null);
        }
    }
}
