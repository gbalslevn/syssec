package androidx.compose.ui.semantics;

import android.support.v4.media.session.a;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\nR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0019\u0010\nR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\nR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\nR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\nR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b#\u0010\nR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\b\u001a\u0004\b%\u0010\nR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b'\u0010\nR \u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b*\u0010\nR \u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b-\u0010\nR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\nR\u001d\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00048\u0006¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b3\u0010\nR\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002010\u00048\u0006¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u0010\nR\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b6\u0010\b\u001a\u0004\b7\u0010\nR\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b8\u0010\b\u001a\u0004\b9\u0010\nR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b<\u0010\nR\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\b\u001a\u0004\b>\u0010\nR#\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00050\u00048\u0006¢\u0006\f\n\u0004\b@\u0010\b\u001a\u0004\bA\u0010\nR\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u00048\u0006¢\u0006\f\n\u0004\bB\u0010\b\u001a\u0004\bC\u0010\nR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0006¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bE\u0010\nR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020?0\u00048\u0006¢\u0006\f\n\u0004\bF\u0010\b\u001a\u0004\bG\u0010\nR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\b\u001a\u0004\bJ\u0010\nR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u00048\u0006¢\u0006\f\n\u0004\bL\u0010\b\u001a\u0004\bM\u0010\nR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0006¢\u0006\f\n\u0004\bN\u0010\b\u001a\u0004\bO\u0010\nR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u00048\u0006¢\u0006\f\n\u0004\bQ\u0010\b\u001a\u0004\bR\u0010\nR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\bS\u0010\b\u001a\u0004\bT\u0010\nR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\bU\u0010\b\u001a\u0004\bV\u0010\nR)\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020X0W0\u00048\u0006¢\u0006\f\n\u0004\bY\u0010\b\u001a\u0004\bZ\u0010\nR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0006¢\u0006\f\n\u0004\b[\u0010\b\u001a\u0004\b\\\u0010\nR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020X0\u00048\u0006¢\u0006\f\n\u0004\b]\u0010\b\u001a\u0004\b^\u0010\n¨\u0006_"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsProperties;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "ContentDescription", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getContentDescription", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "StateDescription", "getStateDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "ProgressBarRangeInfo", "getProgressBarRangeInfo", "PaneTitle", "getPaneTitle", BuildConfig.FLAVOR, "SelectableGroup", "getSelectableGroup", "Landroidx/compose/ui/semantics/CollectionInfo;", "CollectionInfo", "getCollectionInfo", "CollectionItemInfo", "getCollectionItemInfo", "Heading", "getHeading", "Disabled", "getDisabled", "Landroidx/compose/ui/semantics/LiveRegionMode;", "LiveRegion", "getLiveRegion", BuildConfig.FLAVOR, "Focused", "getFocused", "IsTraversalGroup", "getIsTraversalGroup", "InvisibleToUser", "getInvisibleToUser", "Landroidx/compose/ui/autofill/ContentType;", "ContentType", "getContentType$ui_release", "Landroidx/compose/ui/autofill/ContentDataType;", "ContentDataType", "getContentDataType$ui_release", BuildConfig.FLAVOR, "TraversalIndex", "getTraversalIndex", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "HorizontalScrollAxisRange", "getHorizontalScrollAxisRange", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "IsPopup", "getIsPopup", "IsDialog", "getIsDialog", "Landroidx/compose/ui/semantics/Role;", "Role", "getRole", "TestTag", "getTestTag", "Landroidx/compose/ui/text/AnnotatedString;", "Text", "getText", "TextSubstitution", "getTextSubstitution", "IsShowingTextSubstitution", "getIsShowingTextSubstitution", "EditableText", "getEditableText", "Landroidx/compose/ui/text/TextRange;", "TextSelectionRange", "getTextSelectionRange", "Landroidx/compose/ui/text/input/ImeAction;", "ImeAction", "getImeAction", "Selected", "getSelected", "Landroidx/compose/ui/state/ToggleableState;", "ToggleableState", "getToggleableState", "Password", "getPassword", "Error", "getError", "Lkotlin/Function1;", BuildConfig.FLAVOR, "IndexForKey", "getIndexForKey", "IsEditable", "getIsEditable", "MaxTextLength", "getMaxTextLength", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsProperties {
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();
    private static final SemanticsPropertyKey<List<String>> ContentDescription = SemanticsPropertiesKt.AccessibilityKey("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
            return invoke2((List<String>) list, (List<String>) list2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<String> invoke2(List<String> list, List<String> list2) {
            List<String> mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });
    private static final SemanticsPropertyKey<String> StateDescription = SemanticsPropertiesKt.AccessibilityKey("StateDescription");
    private static final SemanticsPropertyKey<ProgressBarRangeInfo> ProgressBarRangeInfo = SemanticsPropertiesKt.AccessibilityKey("ProgressBarRangeInfo");
    private static final SemanticsPropertyKey<String> PaneTitle = SemanticsPropertiesKt.AccessibilityKey("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });
    private static final SemanticsPropertyKey<Unit> SelectableGroup = SemanticsPropertiesKt.AccessibilityKey("SelectableGroup");
    private static final SemanticsPropertyKey<CollectionInfo> CollectionInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionInfo");
    private static final SemanticsPropertyKey<Object> CollectionItemInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionItemInfo");
    private static final SemanticsPropertyKey<Unit> Heading = SemanticsPropertiesKt.AccessibilityKey("Heading");
    private static final SemanticsPropertyKey<Unit> Disabled = SemanticsPropertiesKt.AccessibilityKey("Disabled");
    private static final SemanticsPropertyKey<LiveRegionMode> LiveRegion = SemanticsPropertiesKt.AccessibilityKey("LiveRegion");
    private static final SemanticsPropertyKey<Boolean> Focused = SemanticsPropertiesKt.AccessibilityKey("Focused");
    private static final SemanticsPropertyKey<Boolean> IsTraversalGroup = SemanticsPropertiesKt.AccessibilityKey("IsTraversalGroup");
    private static final SemanticsPropertyKey<Unit> InvisibleToUser = new SemanticsPropertyKey<>("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });
    private static final SemanticsPropertyKey<ContentType> ContentType = new SemanticsPropertyKey<>("ContentType", new Function2<ContentType, ContentType, ContentType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // kotlin.jvm.functions.Function2
        public final ContentType invoke(ContentType contentType, ContentType contentType2) {
            return contentType;
        }
    });
    private static final SemanticsPropertyKey<ContentDataType> ContentDataType = new SemanticsPropertyKey<>("ContentDataType", new Function2<ContentDataType, ContentDataType, ContentDataType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ContentDataType invoke(ContentDataType contentDataType, ContentDataType contentDataType2) {
            a.a(contentDataType);
            a.a(contentDataType2);
            throw null;
        }
    });
    private static final SemanticsPropertyKey<Float> TraversalIndex = SemanticsPropertiesKt.AccessibilityKey("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        public final Float invoke(Float f5, float f6) {
            return f5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Float invoke(Float f5, Float f6) {
            return invoke(f5, f6.floatValue());
        }
    });
    private static final SemanticsPropertyKey<ScrollAxisRange> HorizontalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("HorizontalScrollAxisRange");
    private static final SemanticsPropertyKey<ScrollAxisRange> VerticalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("VerticalScrollAxisRange");
    private static final SemanticsPropertyKey<Unit> IsPopup = SemanticsPropertiesKt.AccessibilityKey("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });
    private static final SemanticsPropertyKey<Unit> IsDialog = SemanticsPropertiesKt.AccessibilityKey("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });
    private static final SemanticsPropertyKey<Role> Role = SemanticsPropertiesKt.AccessibilityKey("Role", new Function2<Role, Role, Role>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Role invoke(Role role, Role role2) {
            return m2180invokeqtAw6s(role, role2.getValue());
        }

        /* renamed from: invoke-qtA-w6s, reason: not valid java name */
        public final Role m2180invokeqtAw6s(Role role, int i5) {
            return role;
        }
    });
    private static final SemanticsPropertyKey<String> TestTag = new SemanticsPropertyKey<>("TestTag", false, new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            return str;
        }
    });
    private static final SemanticsPropertyKey<List<AnnotatedString>> Text = SemanticsPropertiesKt.AccessibilityKey("Text", new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends AnnotatedString> invoke(List<? extends AnnotatedString> list, List<? extends AnnotatedString> list2) {
            return invoke2((List<AnnotatedString>) list, (List<AnnotatedString>) list2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<AnnotatedString> invoke2(List<AnnotatedString> list, List<AnnotatedString> list2) {
            List<AnnotatedString> mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });
    private static final SemanticsPropertyKey<AnnotatedString> TextSubstitution = new SemanticsPropertyKey<>("TextSubstitution", null, 2, null);
    private static final SemanticsPropertyKey<Boolean> IsShowingTextSubstitution = new SemanticsPropertyKey<>("IsShowingTextSubstitution", null, 2, null);
    private static final SemanticsPropertyKey<AnnotatedString> EditableText = SemanticsPropertiesKt.AccessibilityKey("EditableText");
    private static final SemanticsPropertyKey<TextRange> TextSelectionRange = SemanticsPropertiesKt.AccessibilityKey("TextSelectionRange");
    private static final SemanticsPropertyKey<ImeAction> ImeAction = SemanticsPropertiesKt.AccessibilityKey("ImeAction");
    private static final SemanticsPropertyKey<Boolean> Selected = SemanticsPropertiesKt.AccessibilityKey("Selected");
    private static final SemanticsPropertyKey<ToggleableState> ToggleableState = SemanticsPropertiesKt.AccessibilityKey("ToggleableState");
    private static final SemanticsPropertyKey<Unit> Password = SemanticsPropertiesKt.AccessibilityKey("Password");
    private static final SemanticsPropertyKey<String> Error = SemanticsPropertiesKt.AccessibilityKey("Error");
    private static final SemanticsPropertyKey<Function1<Object, Integer>> IndexForKey = new SemanticsPropertyKey<>("IndexForKey", null, 2, null);
    private static final SemanticsPropertyKey<Boolean> IsEditable = new SemanticsPropertyKey<>("IsEditable", null, 2, null);
    private static final SemanticsPropertyKey<Integer> MaxTextLength = new SemanticsPropertyKey<>("MaxTextLength", null, 2, null);
    public static final int $stable = 8;

    private SemanticsProperties() {
    }

    public final SemanticsPropertyKey<CollectionInfo> getCollectionInfo() {
        return CollectionInfo;
    }

    public final SemanticsPropertyKey<Object> getCollectionItemInfo() {
        return CollectionItemInfo;
    }

    public final SemanticsPropertyKey<ContentDataType> getContentDataType$ui_release() {
        return ContentDataType;
    }

    public final SemanticsPropertyKey<List<String>> getContentDescription() {
        return ContentDescription;
    }

    public final SemanticsPropertyKey<ContentType> getContentType$ui_release() {
        return ContentType;
    }

    public final SemanticsPropertyKey<Unit> getDisabled() {
        return Disabled;
    }

    public final SemanticsPropertyKey<AnnotatedString> getEditableText() {
        return EditableText;
    }

    public final SemanticsPropertyKey<String> getError() {
        return Error;
    }

    public final SemanticsPropertyKey<Boolean> getFocused() {
        return Focused;
    }

    public final SemanticsPropertyKey<Unit> getHeading() {
        return Heading;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getHorizontalScrollAxisRange() {
        return HorizontalScrollAxisRange;
    }

    public final SemanticsPropertyKey<ImeAction> getImeAction() {
        return ImeAction;
    }

    public final SemanticsPropertyKey<Function1<Object, Integer>> getIndexForKey() {
        return IndexForKey;
    }

    public final SemanticsPropertyKey<Unit> getInvisibleToUser() {
        return InvisibleToUser;
    }

    public final SemanticsPropertyKey<Unit> getIsDialog() {
        return IsDialog;
    }

    public final SemanticsPropertyKey<Boolean> getIsEditable() {
        return IsEditable;
    }

    public final SemanticsPropertyKey<Unit> getIsPopup() {
        return IsPopup;
    }

    public final SemanticsPropertyKey<Boolean> getIsShowingTextSubstitution() {
        return IsShowingTextSubstitution;
    }

    public final SemanticsPropertyKey<Boolean> getIsTraversalGroup() {
        return IsTraversalGroup;
    }

    public final SemanticsPropertyKey<LiveRegionMode> getLiveRegion() {
        return LiveRegion;
    }

    public final SemanticsPropertyKey<Integer> getMaxTextLength() {
        return MaxTextLength;
    }

    public final SemanticsPropertyKey<String> getPaneTitle() {
        return PaneTitle;
    }

    public final SemanticsPropertyKey<Unit> getPassword() {
        return Password;
    }

    public final SemanticsPropertyKey<ProgressBarRangeInfo> getProgressBarRangeInfo() {
        return ProgressBarRangeInfo;
    }

    public final SemanticsPropertyKey<Role> getRole() {
        return Role;
    }

    public final SemanticsPropertyKey<Unit> getSelectableGroup() {
        return SelectableGroup;
    }

    public final SemanticsPropertyKey<Boolean> getSelected() {
        return Selected;
    }

    public final SemanticsPropertyKey<String> getStateDescription() {
        return StateDescription;
    }

    public final SemanticsPropertyKey<String> getTestTag() {
        return TestTag;
    }

    public final SemanticsPropertyKey<List<AnnotatedString>> getText() {
        return Text;
    }

    public final SemanticsPropertyKey<TextRange> getTextSelectionRange() {
        return TextSelectionRange;
    }

    public final SemanticsPropertyKey<AnnotatedString> getTextSubstitution() {
        return TextSubstitution;
    }

    public final SemanticsPropertyKey<ToggleableState> getToggleableState() {
        return ToggleableState;
    }

    public final SemanticsPropertyKey<Float> getTraversalIndex() {
        return TraversalIndex;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getVerticalScrollAxisRange() {
        return VerticalScrollAxisRange;
    }
}
