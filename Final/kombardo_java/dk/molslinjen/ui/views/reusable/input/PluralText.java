package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/PluralText;", BuildConfig.FLAVOR, "<init>", "()V", "getText", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Resource", "Texts", "Ldk/molslinjen/ui/views/reusable/input/PluralText$Resource;", "Ldk/molslinjen/ui/views/reusable/input/PluralText$Texts;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PluralText {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/PluralText$Resource;", "Ldk/molslinjen/ui/views/reusable/input/PluralText;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getId", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Resource extends PluralText {
        private final int id;

        public Resource(int i5) {
            super(null);
            this.id = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Resource) && this.id == ((Resource) other).id;
        }

        public final int getId() {
            return this.id;
        }

        public int hashCode() {
            return Integer.hashCode(this.id);
        }

        public String toString() {
            return "Resource(id=" + this.id + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/PluralText$Texts;", "Ldk/molslinjen/ui/views/reusable/input/PluralText;", BuildConfig.FLAVOR, "singular", "plural", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSingular", "getPlural", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Texts extends PluralText {
        private final String plural;
        private final String singular;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Texts(String singular, String plural) {
            super(null);
            Intrinsics.checkNotNullParameter(singular, "singular");
            Intrinsics.checkNotNullParameter(plural, "plural");
            this.singular = singular;
            this.plural = plural;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Texts)) {
                return false;
            }
            Texts texts = (Texts) other;
            return Intrinsics.areEqual(this.singular, texts.singular) && Intrinsics.areEqual(this.plural, texts.plural);
        }

        public final String getPlural() {
            return this.plural;
        }

        public final String getSingular() {
            return this.singular;
        }

        public int hashCode() {
            return (this.singular.hashCode() * 31) + this.plural.hashCode();
        }

        public String toString() {
            return "Texts(singular=" + this.singular + ", plural=" + this.plural + ")";
        }
    }

    public /* synthetic */ PluralText(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getText(int i5, Composer composer, int i6) {
        String singular;
        composer.startReplaceGroup(-2138355784);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2138355784, i6, -1, "dk.molslinjen.ui.views.reusable.input.PluralText.getText (PluralText.kt:13)");
        }
        if (this instanceof Resource) {
            singular = StringResources_androidKt.pluralStringResource(((Resource) this).getId(), i5, composer, (i6 << 3) & 112);
        } else {
            if (!(this instanceof Texts)) {
                throw new NoWhenBranchMatchedException();
            }
            singular = i5 == 1 ? ((Texts) this).getSingular() : ((Texts) this).getPlural();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return singular;
    }

    private PluralText() {
    }
}
