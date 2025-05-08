package kotlin.reflect.jvm.internal.impl.resolve;

import androidx.appcompat.R$styleable;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes3.dex */
public class OverridingUtil {
    public static final OverridingUtil DEFAULT;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result;

        static {
            int[] iArr = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final String debugMessage;
        private final Result overridable;

        /* loaded from: classes3.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String format;
            String str = (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? 3 : 2];
            if (i5 != 1 && i5 != 2) {
                if (i5 == 3) {
                    objArr[0] = "success";
                } else if (i5 != 4) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                }
                switch (i5) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                        break;
                    case 5:
                        objArr[1] = "getResult";
                        break;
                    case 6:
                        objArr[1] = "getDebugMessage";
                        break;
                    default:
                        objArr[1] = "success";
                        break;
                }
                if (i5 != 1) {
                    objArr[2] = "incompatible";
                } else if (i5 == 2) {
                    objArr[2] = "conflict";
                } else if (i5 == 3 || i5 == 4) {
                    objArr[2] = "<init>";
                }
                format = String.format(str, objArr);
                if (i5 == 1 && i5 != 2 && i5 != 3 && i5 != 4) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "debugMessage";
            switch (i5) {
            }
            if (i5 != 1) {
            }
            format = String.format(str, objArr);
            if (i5 == 1) {
            }
            throw new IllegalArgumentException(format);
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            if (str == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = result;
            this.debugMessage = str;
        }

        public static OverrideCompatibilityInfo conflict(String str) {
            if (str == null) {
                $$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public static OverrideCompatibilityInfo incompatible(String str) {
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }

        public String toString() {
            return this.overridable + ": " + this.debugMessage;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x0265. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x0268. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:95:0x026b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0277 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str;
        int i6;
        Object[] objArr;
        if (i5 != 11 && i5 != 12 && i5 != 16 && i5 != 21 && i5 != 93 && i5 != 96 && i5 != 101 && i5 != 42 && i5 != 43) {
            switch (i5) {
                default:
                    switch (i5) {
                        default:
                            switch (i5) {
                                default:
                                    switch (i5) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                case 25:
                case 26:
                case 27:
                    break;
            }
            if (i5 != 11 && i5 != 12 && i5 != 16 && i5 != 21 && i5 != 93 && i5 != 96 && i5 != 101 && i5 != 42 && i5 != 43) {
                switch (i5) {
                    default:
                        switch (i5) {
                            default:
                                switch (i5) {
                                    default:
                                        switch (i5) {
                                            case 88:
                                            case 89:
                                            case 90:
                                                break;
                                            default:
                                                i6 = 3;
                                                break;
                                        }
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                        i6 = 2;
                                        break;
                                }
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                                break;
                        }
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                        break;
                }
                objArr = new Object[i6];
                switch (i5) {
                    case 1:
                    case 7:
                        objArr[0] = "kotlinTypePreparator";
                        break;
                    case 2:
                        objArr[0] = "customSubtype";
                        break;
                    case 3:
                    case 6:
                    default:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    case 4:
                        objArr[0] = "equalityAxioms";
                        break;
                    case 5:
                        objArr[0] = "axioms";
                        break;
                    case 8:
                    case 9:
                        objArr[0] = "candidateSet";
                        break;
                    case 10:
                        objArr[0] = "transformFirst";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 42:
                    case 43:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 88:
                    case 89:
                    case 90:
                    case 93:
                    case 96:
                    case 101:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                        break;
                    case 13:
                        objArr[0] = "f";
                        break;
                    case 14:
                        objArr[0] = "g";
                        break;
                    case 15:
                    case 17:
                        objArr[0] = "descriptor";
                        break;
                    case 18:
                        objArr[0] = "result";
                        break;
                    case 19:
                    case 22:
                    case 28:
                    case 38:
                        objArr[0] = "superDescriptor";
                        break;
                    case 20:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 39:
                        objArr[0] = "subDescriptor";
                        break;
                    case 40:
                        objArr[0] = "firstParameters";
                        break;
                    case 41:
                        objArr[0] = "secondParameters";
                        break;
                    case 44:
                        objArr[0] = "typeInSuper";
                        break;
                    case 45:
                        objArr[0] = "typeInSub";
                        break;
                    case 46:
                    case 49:
                    case 75:
                        objArr[0] = "typeCheckerState";
                        break;
                    case 47:
                        objArr[0] = "superTypeParameter";
                        break;
                    case 48:
                        objArr[0] = "subTypeParameter";
                        break;
                    case 50:
                        objArr[0] = "name";
                        break;
                    case 51:
                        objArr[0] = "membersFromSupertypes";
                        break;
                    case 52:
                        objArr[0] = "membersFromCurrent";
                        break;
                    case 53:
                    case 59:
                    case 62:
                    case 84:
                    case 87:
                    case 94:
                        objArr[0] = "current";
                        break;
                    case 54:
                    case 60:
                    case Function.THROW_LAST_ERROR /* 64 */:
                    case 85:
                    case 104:
                        objArr[0] = "strategy";
                        break;
                    case 55:
                        objArr[0] = "overriding";
                        break;
                    case 56:
                        objArr[0] = "fromSuper";
                        break;
                    case 57:
                        objArr[0] = "fromCurrent";
                        break;
                    case 58:
                        objArr[0] = "descriptorsFromSuper";
                        break;
                    case 61:
                    case Function.ALT_CONVENTION /* 63 */:
                        objArr[0] = "notOverridden";
                        break;
                    case 65:
                    case 67:
                    case 71:
                        objArr[0] = "a";
                        break;
                    case 66:
                    case 68:
                    case 73:
                        objArr[0] = "b";
                        break;
                    case 69:
                        objArr[0] = "candidate";
                        break;
                    case 70:
                    case 86:
                    case 91:
                    case 107:
                        objArr[0] = "descriptors";
                        break;
                    case 72:
                        objArr[0] = "aReturnType";
                        break;
                    case 74:
                        objArr[0] = "bReturnType";
                        break;
                    case 76:
                    case 83:
                        objArr[0] = "overridables";
                        break;
                    case 77:
                    case 99:
                        objArr[0] = "descriptorByHandle";
                        break;
                    case 92:
                        objArr[0] = "classModality";
                        break;
                    case 95:
                        objArr[0] = "toFilter";
                        break;
                    case 97:
                    case 102:
                        objArr[0] = "overrider";
                        break;
                    case 98:
                    case 103:
                        objArr[0] = "extractFrom";
                        break;
                    case 100:
                        objArr[0] = "onConflict";
                        break;
                    case 105:
                    case 106:
                        objArr[0] = "memberDescriptor";
                        break;
                }
                if (i5 != 11 || i5 == 12) {
                    objArr[1] = "filterOverrides";
                } else if (i5 != 16) {
                    if (i5 != 21) {
                        if (i5 == 93) {
                            objArr[1] = "getMinimalModality";
                        } else if (i5 == 96) {
                            objArr[1] = "filterVisibleFakeOverrides";
                        } else if (i5 == 101) {
                            objArr[1] = "extractMembersOverridableInBothWays";
                        } else if (i5 != 42 && i5 != 43) {
                            switch (i5) {
                                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                case 25:
                                case 26:
                                case 27:
                                    break;
                                default:
                                    switch (i5) {
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                            objArr[1] = "isOverridableByWithoutExternalConditions";
                                            break;
                                        default:
                                            switch (i5) {
                                                case 78:
                                                case 79:
                                                case 80:
                                                case 81:
                                                case 82:
                                                    objArr[1] = "selectMostSpecificMember";
                                                    break;
                                                default:
                                                    switch (i5) {
                                                        case 88:
                                                        case 89:
                                                        case 90:
                                                            objArr[1] = "determineModalityForFakeOverride";
                                                            break;
                                                        default:
                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            objArr[1] = "createTypeCheckerState";
                        }
                    }
                    objArr[1] = "isOverridableBy";
                } else {
                    objArr[1] = "getOverriddenDeclarations";
                }
                switch (i5) {
                    case 1:
                    case 2:
                        objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "create";
                        break;
                    case 5:
                    case 6:
                    case 7:
                        objArr[2] = "<init>";
                        break;
                    case 8:
                        objArr[2] = "filterOutOverridden";
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "filterOverrides";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 42:
                    case 43:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 88:
                    case 89:
                    case 90:
                    case 93:
                    case 96:
                    case 101:
                        break;
                    case 13:
                    case 14:
                        objArr[2] = "overrides";
                        break;
                    case 15:
                        objArr[2] = "getOverriddenDeclarations";
                        break;
                    case 17:
                    case 18:
                        objArr[2] = "collectOverriddenDeclarations";
                        break;
                    case 19:
                    case 20:
                    case 22:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        objArr[2] = "isOverridableBy";
                        break;
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                        objArr[2] = "isOverridableByWithoutExternalConditions";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "getBasicOverridabilityProblem";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "createTypeCheckerState";
                        break;
                    case 44:
                    case 45:
                    case 46:
                        objArr[2] = "areTypesEquivalent";
                        break;
                    case 47:
                    case 48:
                    case 49:
                        objArr[2] = "areTypeParametersEquivalent";
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                        objArr[2] = "generateOverridesInFunctionGroup";
                        break;
                    case 55:
                    case 56:
                        objArr[2] = "isVisibleForOverride";
                        break;
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                        objArr[2] = "extractAndBindOverridesForMember";
                        break;
                    case 61:
                        objArr[2] = "allHasSameContainingDeclaration";
                        break;
                    case 62:
                    case Function.ALT_CONVENTION /* 63 */:
                    case Function.THROW_LAST_ERROR /* 64 */:
                        objArr[2] = "createAndBindFakeOverrides";
                        break;
                    case 65:
                    case 66:
                        objArr[2] = "isMoreSpecific";
                        break;
                    case 67:
                    case 68:
                        objArr[2] = "isVisibilityMoreSpecific";
                        break;
                    case 69:
                    case 70:
                        objArr[2] = "isMoreSpecificThenAllOf";
                        break;
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                        objArr[2] = "isReturnTypeMoreSpecific";
                        break;
                    case 76:
                    case 77:
                        objArr[2] = "selectMostSpecificMember";
                        break;
                    case 83:
                    case 84:
                    case 85:
                        objArr[2] = "createAndBindFakeOverride";
                        break;
                    case 86:
                    case 87:
                        objArr[2] = "determineModalityForFakeOverride";
                        break;
                    case 91:
                    case 92:
                        objArr[2] = "getMinimalModality";
                        break;
                    case 94:
                    case 95:
                        objArr[2] = "filterVisibleFakeOverrides";
                        break;
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 102:
                    case 103:
                    case 104:
                        objArr[2] = "extractMembersOverridableInBothWays";
                        break;
                    case 105:
                        objArr[2] = "resolveUnknownVisibilityForMember";
                        break;
                    case 106:
                        objArr[2] = "computeVisibilityToInherit";
                        break;
                    case 107:
                        objArr[2] = "findMaxVisibility";
                        break;
                    default:
                        objArr[2] = "createWithTypeRefiner";
                        break;
                }
                String format = String.format(str, objArr);
                if (i5 != 11 && i5 != 12 && i5 != 16 && i5 != 21 && i5 != 93 && i5 != 96 && i5 != 101 && i5 != 42 && i5 != 43) {
                    switch (i5) {
                        default:
                            switch (i5) {
                                default:
                                    switch (i5) {
                                        default:
                                            switch (i5) {
                                                case 88:
                                                case 89:
                                                case 90:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 78:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                            throw new IllegalStateException(format);
                                    }
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                    break;
                            }
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        case 25:
                        case 26:
                        case 27:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i6 = 2;
            objArr = new Object[i6];
            switch (i5) {
            }
            if (i5 != 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i5) {
            }
            String format2 = String.format(str, objArr);
            if (i5 != 11) {
                switch (i5) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i5 != 11) {
            switch (i5) {
            }
            objArr = new Object[i6];
            switch (i5) {
            }
            if (i5 != 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i5) {
            }
            String format22 = String.format(str, objArr);
            if (i5 != 11) {
            }
            throw new IllegalStateException(format22);
        }
        i6 = 2;
        objArr = new Object[i6];
        switch (i5) {
        }
        if (i5 != 11) {
        }
        objArr[1] = "filterOverrides";
        switch (i5) {
        }
        String format222 = String.format(str, objArr);
        if (i5 != 11) {
        }
        throw new IllegalStateException(format222);
    }

    static {
        KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality = new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
            private static /* synthetic */ void $$$reportNull$$$0(int i5) {
                Object[] objArr = new Object[3];
                if (i5 != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2);
            }
        };
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = typeConstructorEquality;
        DEFAULT = new OverridingUtil(typeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, KotlinTypeRefiner kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, Function2<KotlinType, KotlinType, Boolean> function2) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        if (kotlinTypePreparator == null) {
            $$$reportNull$$$0(7);
        }
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = function2;
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = collection.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == DeclarationDescriptor.this);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, TypeCheckerState typeCheckerState) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(47);
        }
        if (typeParameterDescriptor2 == null) {
            $$$reportNull$$$0(48);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(49);
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        ArrayList arrayList = new ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (KotlinType kotlinType : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (areTypesEquivalent(kotlinType, (KotlinType) listIterator.next(), typeCheckerState)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean areTypesEquivalent(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckerState typeCheckerState) {
        if (kotlinType == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(45);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(46);
        }
        if (KotlinTypeKt.isError(kotlinType) && KotlinTypeKt.isError(kotlinType2)) {
            return true;
        }
        return AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if ((callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null)) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (set == null) {
            $$$reportNull$$$0(18);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            collectOverriddenDeclarations(it.next(), set);
        }
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    private static DescriptorVisibility computeVisibilityToInherit(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(106);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        DescriptorVisibility findMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (findMaxVisibility == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return findMaxVisibility.normalize();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            if (callableMemberDescriptor2.getModality() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(findMaxVisibility)) {
                return null;
            }
        }
        return findMaxVisibility;
    }

    public static OverridingUtil create(KotlinTypeRefiner kotlinTypeRefiner, KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(3);
        }
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(4);
        }
        return new OverridingUtil(typeConstructorEquality, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (collection == null) {
            $$$reportNull$$$0(83);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(84);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(85);
        }
        Collection<CallableMemberDescriptor> filterVisibleFakeOverrides = filterVisibleFakeOverrides(classDescriptor, collection);
        boolean isEmpty = filterVisibleFakeOverrides.isEmpty();
        if (!isEmpty) {
            collection = filterVisibleFakeOverrides;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) selectMostSpecificMember(collection, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
            @Override // kotlin.jvm.functions.Function1
            public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).copy(classDescriptor, determineModalityForFakeOverride(collection, classDescriptor), isEmpty ? DescriptorVisibilities.INVISIBLE_FAKE : DescriptorVisibilities.INHERITED, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        overridingStrategy.setOverriddenDescriptors(copy, collection);
        overridingStrategy.addFakeOverride(copy);
    }

    private static void createAndBindFakeOverrides(ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection, OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(62);
        }
        if (collection == null) {
            $$$reportNull$$$0(63);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(64);
        }
        if (allHasSameContainingDeclaration(collection)) {
            Iterator<CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                createAndBindFakeOverride(Collections.singleton(it.next()), classDescriptor, overridingStrategy);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(linkedList), linkedList, overridingStrategy), classDescriptor, overridingStrategy);
            }
        }
    }

    private TypeCheckerState createTypeCheckerState(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(40);
        }
        if (list2 == null) {
            $$$reportNull$$$0(41);
        }
        if (list.isEmpty()) {
            TypeCheckerState newTypeCheckerState = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
            if (newTypeCheckerState == null) {
                $$$reportNull$$$0(42);
            }
            return newTypeCheckerState;
        }
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < list.size(); i5++) {
            hashMap.put(list.get(i5).getTypeConstructor(), list2.get(i5).getTypeConstructor());
        }
        TypeCheckerState newTypeCheckerState2 = new OverridingUtilTypeSystemContext(hashMap, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (newTypeCheckerState2 == null) {
            $$$reportNull$$$0(43);
        }
        return newTypeCheckerState2;
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(0);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor) {
        if (collection == null) {
            $$$reportNull$$$0(86);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(87);
        }
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i5 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[callableMemberDescriptor.getModality().ordinal()];
            if (i5 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    $$$reportNull$$$0(88);
                }
                return modality;
            }
            if (i5 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            }
            if (i5 == 3) {
                z6 = true;
            } else if (i5 == 4) {
                z7 = true;
            }
        }
        if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
            z5 = true;
        }
        if (z6 && !z7) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                $$$reportNull$$$0(89);
            }
            return modality2;
        }
        if (!z6 && z7) {
            Modality modality3 = z5 ? classDescriptor.getModality() : Modality.ABSTRACT;
            if (modality3 == null) {
                $$$reportNull$$$0(90);
            }
            return modality3;
        }
        HashSet hashSet = new HashSet();
        Iterator<CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(getOverriddenDeclarations(it.next()));
        }
        return getMinimalModality(filterOutOverridden(hashSet), z5, classDescriptor.getModality());
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(57);
        }
        if (collection == null) {
            $$$reportNull$$$0(58);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(59);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        SmartSet create = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
            boolean isVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2, false);
            int i5 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[result.ordinal()];
            if (i5 == 1) {
                if (isVisibleForOverride) {
                    create.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i5 == 2) {
                if (isVisibleForOverride) {
                    overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, create);
        return arrayList;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h5, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h5 == null) {
            $$$reportNull$$$0(97);
        }
        if (collection == null) {
            $$$reportNull$$$0(98);
        }
        if (function1 == null) {
            $$$reportNull$$$0(99);
        }
        if (function12 == null) {
            $$$reportNull$$$0(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h5);
        CallableDescriptor invoke = function1.invoke(h5);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h5 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(invoke, invoke2);
                if (bothWaysOverridability == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> set) {
        if (set == null) {
            $$$reportNull$$$0(8);
        }
        return filterOverrides(set, !set.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(set.iterator().next())), null, new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.2
            /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
            @Override // kotlin.jvm.functions.Function2
            public Pair invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                return new Pair(callableDescriptor, callableDescriptor2);
            }
        });
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z5, Function0<?> function0, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            $$$reportNull$$$0(9);
        }
        if (function2 == null) {
            $$$reportNull$$$0(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(obj, (Object) it.next());
                CallableDescriptor component1 = invoke.component1();
                CallableDescriptor component2 = invoke.component2();
                if (!overrides(component1, component2, z5, true)) {
                    if (overrides(component2, component1, z5, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(94);
        }
        if (collection == null) {
            $$$reportNull$$$0(95);
        }
        List filter = CollectionsKt.filter(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.5
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z5 = false;
                if (!DescriptorVisibilities.isPrivate(callableMemberDescriptor.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, ClassDescriptor.this, false)) {
                    z5 = true;
                }
                return Boolean.valueOf(z5);
            }
        });
        if (filter == null) {
            $$$reportNull$$$0(96);
        }
        return filter;
    }

    public static DescriptorVisibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        DescriptorVisibility descriptorVisibility;
        if (collection == null) {
            $$$reportNull$$$0(107);
        }
        if (collection.isEmpty()) {
            return DescriptorVisibilities.DEFAULT_VISIBILITY;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            descriptorVisibility = null;
            while (it.hasNext()) {
                DescriptorVisibility visibility = it.next().getVisibility();
                if (descriptorVisibility != null) {
                    Integer compare = DescriptorVisibilities.compare(visibility, descriptorVisibility);
                    if (compare == null) {
                        break;
                    }
                    if (compare.intValue() > 0) {
                    }
                }
                descriptorVisibility = visibility;
            }
        }
        if (descriptorVisibility == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer compare2 = DescriptorVisibilities.compare(descriptorVisibility, it2.next().getVisibility());
            if (compare2 == null || compare2.intValue() < 0) {
                return null;
            }
        }
        return descriptorVisibility;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z5;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(38);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(39);
        }
        boolean z6 = callableDescriptor instanceof FunctionDescriptor;
        if ((z6 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z5 = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!z6 && !z5) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        OverrideCompatibilityInfo checkReceiverAndParameterCount = checkReceiverAndParameterCount(callableDescriptor, callableDescriptor2);
        if (checkReceiverAndParameterCount != null) {
            return checkReceiverAndParameterCount;
        }
        return null;
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = DEFAULT;
        OverrideCompatibilityInfo.Result result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        OverrideCompatibilityInfo.Result result3 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result == result3 && result2 == result3) {
            return result3;
        }
        OverrideCompatibilityInfo.Result result4 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (result == result4 || result2 == result4) ? result4 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> collection, boolean z5, Modality modality) {
        if (collection == null) {
            $$$reportNull$$$0(91);
        }
        if (modality == null) {
            $$$reportNull$$$0(92);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality modality3 = (z5 && callableMemberDescriptor.getModality() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.getModality();
            if (modality3.compareTo(modality2) < 0) {
                modality2 = modality3;
            }
        }
        if (modality2 == null) {
            $$$reportNull$$$0(93);
        }
        return modality2;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        collectOverriddenDeclarations(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor propertyAccessorDescriptor, PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor == null || propertyAccessorDescriptor2 == null) {
            return true;
        }
        return isVisibilityMoreSpecific(propertyAccessorDescriptor, propertyAccessorDescriptor2);
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(65);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(66);
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        TypeCheckerState createTypeCheckerState = DEFAULT.createTypeCheckerState(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeCheckerState);
        }
        if (!(callableDescriptor instanceof PropertyDescriptor)) {
            throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
        if (isAccessorMoreSpecific(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
            return (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) ? AbstractTypeChecker.INSTANCE.equalTypes(createTypeCheckerState, returnType.unwrap(), returnType2.unwrap()) : (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeCheckerState);
        }
        return false;
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor callableDescriptor, Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(69);
        }
        if (collection == null) {
            $$$reportNull$$$0(70);
        }
        Iterator<CallableDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            if (!isMoreSpecific(callableDescriptor, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2, TypeCheckerState typeCheckerState) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(71);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(72);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(73);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(74);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(75);
        }
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(67);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            $$$reportNull$$$0(68);
        }
        Integer compare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return compare == null || compare.intValue() >= 0;
    }

    public static boolean isVisibleForOverride(MemberDescriptor memberDescriptor, MemberDescriptor memberDescriptor2, boolean z5) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(55);
        }
        if (memberDescriptor2 == null) {
            $$$reportNull$$$0(56);
        }
        return !DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor, z5);
    }

    public static <D extends CallableDescriptor> boolean overrides(D d5, D d6, boolean z5, boolean z6) {
        if (d5 == null) {
            $$$reportNull$$$0(13);
        }
        if (d6 == null) {
            $$$reportNull$$$0(14);
        }
        if (!d5.equals(d6) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d5.getOriginal(), d6.getOriginal(), z5, z6)) {
            return true;
        }
        CallableDescriptor original = d6.getOriginal();
        Iterator it = DescriptorUtils.getAllOverriddenDescriptors(d5).iterator();
        while (it.hasNext()) {
            if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, (CallableDescriptor) it.next(), z5, z6)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        DescriptorVisibility descriptorVisibility;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(105);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == DescriptorVisibilities.INHERITED) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != DescriptorVisibilities.INHERITED) {
            return;
        }
        DescriptorVisibility computeVisibilityToInherit = computeVisibilityToInherit(callableMemberDescriptor);
        if (computeVisibilityToInherit == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            descriptorVisibility = DescriptorVisibilities.PUBLIC;
        } else {
            descriptorVisibility = computeVisibilityToInherit;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            Iterator<PropertyAccessorDescriptor> it = ((PropertyDescriptor) callableMemberDescriptor).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), computeVisibilityToInherit == null ? null : function1);
            }
            return;
        }
        if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            return;
        }
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
        propertyAccessorDescriptorImpl.setVisibility(descriptorVisibility);
        if (descriptorVisibility != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
            propertyAccessorDescriptorImpl.setDefault(false);
        }
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        H h5;
        if (collection == null) {
            $$$reportNull$$$0(76);
        }
        if (function1 == null) {
            $$$reportNull$$$0(77);
        }
        if (collection.size() == 1) {
            H h6 = (H) CollectionsKt.first(collection);
            if (h6 == null) {
                $$$reportNull$$$0(78);
            }
            return h6;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = CollectionsKt.map(collection, function1);
        H h7 = (H) CollectionsKt.first(collection);
        CallableDescriptor invoke = function1.invoke(h7);
        for (H h8 : collection) {
            CallableDescriptor invoke2 = function1.invoke(h8);
            if (isMoreSpecificThenAllOf(invoke2, map)) {
                arrayList.add(h8);
            }
            if (isMoreSpecific(invoke2, invoke) && !isMoreSpecific(invoke, invoke2)) {
                h7 = h8;
            }
        }
        if (arrayList.isEmpty()) {
            if (h7 == null) {
                $$$reportNull$$$0(79);
            }
            return h7;
        }
        if (arrayList.size() == 1) {
            H h9 = (H) CollectionsKt.first((Iterable) arrayList);
            if (h9 == null) {
                $$$reportNull$$$0(80);
            }
            return h9;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                h5 = null;
                break;
            }
            h5 = (H) it.next();
            if (!FlexibleTypesKt.isFlexible(function1.invoke(h5).getReturnType())) {
                break;
            }
        }
        if (h5 != null) {
            return h5;
        }
        H h10 = (H) CollectionsKt.first((Iterable) arrayList);
        if (h10 == null) {
            $$$reportNull$$$0(82);
        }
        return h10;
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (name == null) {
            $$$reportNull$$$0(50);
        }
        if (collection == null) {
            $$$reportNull$$$0(51);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(52);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(53);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(extractAndBindOverridesForMember(it.next(), collection, classDescriptor, overridingStrategy));
        }
        createAndBindFakeOverrides(classDescriptor, linkedHashSet, overridingStrategy);
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(20);
        }
        OverrideCompatibilityInfo isOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (isOverridableBy == null) {
            $$$reportNull$$$0(21);
        }
        return isOverridableBy;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z5) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(28);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(29);
        }
        OverrideCompatibilityInfo basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<KotlinType> compiledValueParameters = compiledValueParameters(callableDescriptor);
        List<KotlinType> compiledValueParameters2 = compiledValueParameters(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i5 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i5 < compiledValueParameters.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(compiledValueParameters.get(i5), compiledValueParameters2.get(i5))) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (incompatible == null) {
                        $$$reportNull$$$0(31);
                    }
                    return incompatible;
                }
                i5++;
            }
            OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (conflict == null) {
                $$$reportNull$$$0(32);
            }
            return conflict;
        }
        TypeCheckerState createTypeCheckerState = createTypeCheckerState(typeParameters, typeParameters2);
        for (int i6 = 0; i6 < typeParameters.size(); i6++) {
            if (!areTypeParametersEquivalent(typeParameters.get(i6), typeParameters2.get(i6), createTypeCheckerState)) {
                OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (incompatible2 == null) {
                    $$$reportNull$$$0(33);
                }
                return incompatible2;
            }
        }
        while (i5 < compiledValueParameters.size()) {
            if (!areTypesEquivalent(compiledValueParameters.get(i5), compiledValueParameters2.get(i5), createTypeCheckerState)) {
                OverrideCompatibilityInfo incompatible3 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (incompatible3 == null) {
                    $$$reportNull$$$0(34);
                }
                return incompatible3;
            }
            i5++;
        }
        if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (conflict2 == null) {
                $$$reportNull$$$0(35);
            }
            return conflict2;
        }
        if (z5) {
            KotlinType returnType = callableDescriptor.getReturnType();
            KotlinType returnType2 = callableDescriptor2.getReturnType();
            if (returnType != null && returnType2 != null && ((!KotlinTypeKt.isError(returnType2) || !KotlinTypeKt.isError(returnType)) && !AbstractTypeChecker.INSTANCE.isSubtypeOf(createTypeCheckerState, returnType2.unwrap(), returnType.unwrap()))) {
                OverrideCompatibilityInfo conflict3 = OverrideCompatibilityInfo.conflict("Return type mismatch");
                if (conflict3 == null) {
                    $$$reportNull$$$0(36);
                }
                return conflict3;
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(37);
        }
        return success;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z5) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(22);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(23);
        }
        OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z5);
        boolean z6 = isOverridableByWithoutExternalConditions.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z6 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i5 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i5 == 1) {
                    z6 = true;
                } else if (i5 == 2) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                    if (incompatible == null) {
                        $$$reportNull$$$0(24);
                    }
                    return incompatible;
                }
            }
        }
        if (!z6) {
            return isOverridableByWithoutExternalConditions;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i6 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i6 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i6 == 2) {
                    OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                    if (incompatible2 == null) {
                        $$$reportNull$$$0(26);
                    }
                    return incompatible2;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(27);
        }
        return success;
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor callableMemberDescriptor, Queue<CallableMemberDescriptor> queue, final OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(102);
        }
        if (queue == null) {
            $$$reportNull$$$0(103);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(104);
        }
        return extractMembersOverridableInBothWays(callableMemberDescriptor, queue, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
            @Override // kotlin.jvm.functions.Function1
            public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                return callableMemberDescriptor2;
            }
        }, new Function1<CallableMemberDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.7
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                OverridingStrategy.this.inheritanceConflict(callableMemberDescriptor, callableMemberDescriptor2);
                return Unit.INSTANCE;
            }
        });
    }
}
