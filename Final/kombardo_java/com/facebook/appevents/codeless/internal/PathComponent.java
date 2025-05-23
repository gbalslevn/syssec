package com.facebook.appevents.codeless.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent;", BuildConfig.FLAVOR, "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "className", BuildConfig.FLAVOR, "getClassName", "()Ljava/lang/String;", PathComponent.PATH_DESCRIPTION_KEY, "getDescription", PathComponent.PATH_HINT_KEY, "getHint", "id", BuildConfig.FLAVOR, "getId", "()I", PathComponent.PATH_INDEX_KEY, "getIndex", "matchBitmask", "getMatchBitmask", PathComponent.PATH_TAG_KEY, "getTag", PathComponent.PATH_TEXT_KEY, "getText", "Companion", "MatchBitmaskType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PathComponent {
    private static final String PATH_CLASS_NAME_KEY = "class_name";
    private static final String PATH_DESCRIPTION_KEY = "description";
    private static final String PATH_HINT_KEY = "hint";
    private static final String PATH_ID_KEY = "id";
    private static final String PATH_INDEX_KEY = "index";
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    private static final String PATH_TAG_KEY = "tag";
    private static final String PATH_TEXT_KEY = "text";
    private final String className;
    private final String description;
    private final String hint;
    private final int id;
    private final int index;
    private final int matchBitmask;
    private final String tag;
    private final String text;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$MatchBitmaskType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;II)V", "getValue", "()I", "ID", "TEXT", "TAG", "DESCRIPTION", "HINT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int value;

        MatchBitmaskType(int i5) {
            this.value = i5;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MatchBitmaskType[] valuesCustom() {
            MatchBitmaskType[] valuesCustom = values();
            return (MatchBitmaskType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PathComponent(JSONObject component) {
        Intrinsics.checkNotNullParameter(component, "component");
        String string = component.getString(PATH_CLASS_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = component.optInt(PATH_INDEX_KEY, -1);
        this.id = component.optInt("id");
        String optString = component.optString(PATH_TEXT_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "component.optString(PATH_TEXT_KEY)");
        this.text = optString;
        String optString2 = component.optString(PATH_TAG_KEY);
        Intrinsics.checkNotNullExpressionValue(optString2, "component.optString(PATH_TAG_KEY)");
        this.tag = optString2;
        String optString3 = component.optString(PATH_DESCRIPTION_KEY);
        Intrinsics.checkNotNullExpressionValue(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = optString3;
        String optString4 = component.optString(PATH_HINT_KEY);
        Intrinsics.checkNotNullExpressionValue(optString4, "component.optString(PATH_HINT_KEY)");
        this.hint = optString4;
        this.matchBitmask = component.optInt(PATH_MATCH_BITMASK_KEY);
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getText() {
        return this.text;
    }
}
