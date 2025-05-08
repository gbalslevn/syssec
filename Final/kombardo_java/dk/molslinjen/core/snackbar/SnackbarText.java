package dk.molslinjen.core.snackbar;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarText;", BuildConfig.FLAVOR, "<init>", "()V", "getString", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "StringText", "ResourceText", "ResourceTextWithResourcePlaceholders", "PluralResourceText", "Ldk/molslinjen/core/snackbar/SnackbarText$PluralResourceText;", "Ldk/molslinjen/core/snackbar/SnackbarText$ResourceText;", "Ldk/molslinjen/core/snackbar/SnackbarText$ResourceTextWithResourcePlaceholders;", "Ldk/molslinjen/core/snackbar/SnackbarText$StringText;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SnackbarText {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarText$PluralResourceText;", "Ldk/molslinjen/core/snackbar/SnackbarText;", BuildConfig.FLAVOR, "messageRes", "I", "getMessageRes", "()I", "quantity", "getQuantity", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "placeholders", "Ljava/util/List;", "getPlaceholders", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PluralResourceText extends SnackbarText {
        public abstract int getMessageRes();

        public abstract List<String> getPlaceholders();

        public abstract int getQuantity();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarText$ResourceText;", "Ldk/molslinjen/core/snackbar/SnackbarText;", "messageRes", BuildConfig.FLAVOR, "<init>", "(I)V", "getMessageRes", "()I", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ResourceText extends SnackbarText {
        private final int messageRes;

        public ResourceText(int i5) {
            super(null);
            this.messageRes = i5;
        }

        public final int getMessageRes() {
            return this.messageRes;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarText$ResourceTextWithResourcePlaceholders;", "Ldk/molslinjen/core/snackbar/SnackbarText;", "mainRes", BuildConfig.FLAVOR, "placeholders", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(ILjava/util/List;)V", "getMainRes", "()I", "getPlaceholders", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ResourceTextWithResourcePlaceholders extends SnackbarText {
        private final int mainRes;
        private final List<Object> placeholders;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceTextWithResourcePlaceholders(int i5, List<? extends Object> placeholders) {
            super(null);
            Intrinsics.checkNotNullParameter(placeholders, "placeholders");
            this.mainRes = i5;
            this.placeholders = placeholders;
        }

        public final int getMainRes() {
            return this.mainRes;
        }

        public final List<Object> getPlaceholders() {
            return this.placeholders;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/snackbar/SnackbarText$StringText;", "Ldk/molslinjen/core/snackbar/SnackbarText;", "text", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class StringText extends SnackbarText {
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringText(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    public /* synthetic */ SnackbarText(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this instanceof StringText) {
            return ((StringText) this).getText();
        }
        if (this instanceof ResourceText) {
            String string = context.getString(((ResourceText) this).getMessageRes());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (!(this instanceof ResourceTextWithResourcePlaceholders)) {
            if (!(this instanceof PluralResourceText)) {
                throw new NoWhenBranchMatchedException();
            }
            Resources resources = context.getResources();
            PluralResourceText pluralResourceText = (PluralResourceText) this;
            int messageRes = pluralResourceText.getMessageRes();
            int quantity = pluralResourceText.getQuantity();
            String[] strArr = (String[]) pluralResourceText.getPlaceholders().toArray(new String[0]);
            String quantityString = resources.getQuantityString(messageRes, quantity, Arrays.copyOf(strArr, strArr.length));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            return quantityString;
        }
        ResourceTextWithResourcePlaceholders resourceTextWithResourcePlaceholders = (ResourceTextWithResourcePlaceholders) this;
        int mainRes = resourceTextWithResourcePlaceholders.getMainRes();
        List<Object> placeholders = resourceTextWithResourcePlaceholders.getPlaceholders();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(placeholders, 10));
        for (Object obj : placeholders) {
            if (obj instanceof Integer) {
                obj = context.getString(((Number) obj).intValue());
                Intrinsics.checkNotNullExpressionValue(obj, "getString(...)");
            }
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        String string2 = context.getString(mainRes, Arrays.copyOf(array, array.length));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private SnackbarText() {
    }
}
