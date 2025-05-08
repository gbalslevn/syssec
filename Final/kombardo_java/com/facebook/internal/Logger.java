package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0010J)\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0013\"\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/facebook/internal/Logger;", BuildConfig.FLAVOR, "Lcom/facebook/LoggingBehavior;", "behavior", BuildConfig.FLAVOR, "tag", "<init>", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V", BuildConfig.FLAVOR, "shouldLog", "()Z", BuildConfig.FLAVOR, "log", "()V", "string", "logString", "(Ljava/lang/String;)V", "append", "format", BuildConfig.FLAVOR, "args", "(Ljava/lang/String;[Ljava/lang/Object;)V", "key", "value", "appendKeyValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/facebook/LoggingBehavior;", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "contents", "Ljava/lang/StringBuilder;", BuildConfig.FLAVOR, "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority;
    private final String tag;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0018J/\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/facebook/internal/Logger$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "string", "replaceStrings", "(Ljava/lang/String;)Ljava/lang/String;", "original", "replace", BuildConfig.FLAVOR, "registerStringToReplace", "(Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "registerAccessToken", "(Ljava/lang/String;)V", "Lcom/facebook/LoggingBehavior;", "behavior", "tag", "log", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V", "format", BuildConfig.FLAVOR, "args", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", BuildConfig.FLAVOR, "priority", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V", "LOG_TAG_BASE", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "stringsToReplace", "Ljava/util/HashMap;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final synchronized String replaceStrings(String string) {
            String str;
            str = string;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                str = StringsKt.replace$default(str, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
            }
            return str;
        }

        public final void log(LoggingBehavior behavior, String tag, String string) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(string, "string");
            log(behavior, 3, tag, string);
        }

        public final synchronized void registerAccessToken(String accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }

        public final synchronized void registerStringToReplace(String original, String replace) {
            Intrinsics.checkNotNullParameter(original, "original");
            Intrinsics.checkNotNullParameter(replace, "replace");
            Logger.stringsToReplace.put(original, replace);
        }

        private Companion() {
        }

        public final void log(LoggingBehavior behavior, String tag, String format, Object... args) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                log(behavior, 3, tag, format2);
            }
        }

        public final void log(LoggingBehavior behavior, int priority, String tag, String string) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(string, "string");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                String replaceStrings = replaceStrings(string);
                if (!StringsKt.startsWith$default(tag, "FacebookSDK.", false, 2, (Object) null)) {
                    tag = Intrinsics.stringPlus("FacebookSDK.", tag);
                }
                Log.println(priority, tag, replaceStrings);
                if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(LoggingBehavior behavior, String tag) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.priority = 3;
        this.behavior = behavior;
        this.tag = Intrinsics.stringPlus("FacebookSDK.", Validate.notNullOrEmpty(tag, "tag"));
        this.contents = new StringBuilder();
    }

    private final boolean shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (shouldLog()) {
            this.contents.append(string);
        }
    }

    public final void appendKeyValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        append("  %s:\t%s\n", key, value);
    }

    public final void log() {
        String sb = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "contents.toString()");
        logString(sb);
        this.contents = new StringBuilder();
    }

    public final void logString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        INSTANCE.log(this.behavior, this.priority, this.tag, string);
    }

    public final void append(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            sb.append(format2);
        }
    }
}
