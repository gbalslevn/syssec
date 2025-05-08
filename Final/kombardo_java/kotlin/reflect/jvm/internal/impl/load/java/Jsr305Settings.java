package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel globalLevel, ReportLevel reportLevel, Map<FqName, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        Intrinsics.checkNotNullParameter(globalLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = globalLevel;
        this.migrationLevel = reportLevel;
        this.userDefinedLevelForSpecificAnnotation = userDefinedLevelForSpecificAnnotation;
        this.description$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$$Lambda$0
            private final Jsr305Settings arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String[] description_delegate$lambda$3;
                description_delegate$lambda$3 = Jsr305Settings.description_delegate$lambda$3(this.arg$0);
                return description_delegate$lambda$3;
            }
        });
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        this.isDisabled = globalLevel == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] description_delegate$lambda$3(Jsr305Settings jsr305Settings) {
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(jsr305Settings.globalLevel.getDescription());
        ReportLevel reportLevel = jsr305Settings.migrationLevel;
        if (reportLevel != null) {
            createListBuilder.add("under-migration:" + reportLevel.getDescription());
        }
        for (Map.Entry<FqName, ReportLevel> entry : jsr305Settings.userDefinedLevelForSpecificAnnotation.entrySet()) {
            createListBuilder.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        return (String[]) CollectionsKt.build(createListBuilder).toArray(new String[0]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jsr305Settings)) {
            return false;
        }
        Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
        return this.globalLevel == jsr305Settings.globalLevel && this.migrationLevel == jsr305Settings.migrationLevel && Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, jsr305Settings.userDefinedLevelForSpecificAnnotation);
    }

    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public int hashCode() {
        int hashCode = this.globalLevel.hashCode() * 31;
        ReportLevel reportLevel = this.migrationLevel;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i5 & 2) != 0 ? null : reportLevel2, (i5 & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
