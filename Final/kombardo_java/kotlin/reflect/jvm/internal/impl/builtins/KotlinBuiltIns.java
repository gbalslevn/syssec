package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.appcompat.R$styleable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class KotlinBuiltIns {
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private ModuleDescriptorImpl builtInsModule;
    private NotNullLazyValue<ModuleDescriptorImpl> postponedBuiltInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final StorageManager storageManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            Object[] objArr = new Object[3];
            if (i5 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i5 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private Primitives(Map<PrimitiveType, SimpleType> map, Map<KotlinType, SimpleType> map2, Map<SimpleType, SimpleType> map3) {
            if (map == null) {
                $$$reportNull$$$0(0);
            }
            if (map2 == null) {
                $$$reportNull$$$0(1);
            }
            if (map3 == null) {
                $$$reportNull$$$0(2);
            }
            this.primitiveTypeToArrayKotlinType = map;
            this.primitiveKotlinTypeToKotlinArrayType = map2;
            this.kotlinArrayTypeToPrimitiveKotlinType = map3;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:142:0x041f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:143:0x0422. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:144:0x0425. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x040f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0431 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0369  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str;
        int i6;
        if (i5 != 11 && i5 != 13 && i5 != 15 && i5 != 69 && i5 != 74 && i5 != 81 && i5 != 84 && i5 != 86 && i5 != 87) {
            switch (i5) {
                default:
                    switch (i5) {
                        default:
                            switch (i5) {
                                default:
                                    switch (i5) {
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case Function.ALT_CONVENTION /* 63 */:
                                        case Function.THROW_LAST_ERROR /* 64 */:
                                        case 65:
                                        case 66:
                                        case 67:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case R$styleable.Toolbar_titleTextColor /* 29 */:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            break;
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
            }
            if (i5 != 11 && i5 != 13 && i5 != 15 && i5 != 69 && i5 != 74 && i5 != 81 && i5 != 84 && i5 != 86 && i5 != 87) {
                switch (i5) {
                    default:
                        switch (i5) {
                            default:
                                switch (i5) {
                                    default:
                                        switch (i5) {
                                            case 55:
                                            case 56:
                                            case 57:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                            case 62:
                                            case Function.ALT_CONVENTION /* 63 */:
                                            case Function.THROW_LAST_ERROR /* 64 */:
                                            case 65:
                                            case 66:
                                            case 67:
                                                break;
                                            default:
                                                i6 = 3;
                                                break;
                                        }
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                        i6 = 2;
                                        break;
                                }
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case R$styleable.Toolbar_titleTextColor /* 29 */:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                                break;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                }
                Object[] objArr = new Object[i6];
                switch (i5) {
                    case 1:
                    case 72:
                        objArr[0] = "module";
                        break;
                    case 2:
                        objArr[0] = "computation";
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 11:
                    case 13:
                    case 15:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case Function.ALT_CONVENTION /* 63 */:
                    case Function.THROW_LAST_ERROR /* 64 */:
                    case 65:
                    case 66:
                    case 67:
                    case 69:
                    case 74:
                    case 81:
                    case 84:
                    case 86:
                    case 87:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                        break;
                    case 9:
                    case 10:
                    case 76:
                    case 77:
                    case 89:
                    case 96:
                    case 103:
                    case 107:
                    case 108:
                    case 143:
                    case 146:
                    case 147:
                    case 149:
                    case 157:
                    case 158:
                    case 159:
                    case 160:
                        objArr[0] = "descriptor";
                        break;
                    case 12:
                    case 98:
                    case 100:
                    case 102:
                    case 104:
                    case 106:
                    case 135:
                        objArr[0] = "fqName";
                        break;
                    case 14:
                        objArr[0] = "simpleName";
                        break;
                    case 16:
                    case 17:
                    case 54:
                    case 88:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 97:
                    case 99:
                    case 105:
                    case 109:
                    case 110:
                    case 111:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case R$styleable.AppCompatTheme_windowActionBar /* 117 */:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case ModuleDescriptor.MODULE_VERSION /* 136 */:
                    case 137:
                    case 138:
                    case 139:
                    case 140:
                    case 141:
                    case 142:
                    case 144:
                    case 145:
                    case 148:
                    case 150:
                    case 151:
                    case 152:
                    case 153:
                    case 154:
                    case 155:
                    case 156:
                    case 162:
                        objArr[0] = "type";
                        break;
                    case 47:
                        objArr[0] = "classSimpleName";
                        break;
                    case 68:
                    case 70:
                        objArr[0] = "arrayType";
                        break;
                    case 71:
                        objArr[0] = "notNullArrayType";
                        break;
                    case 73:
                        objArr[0] = "primitiveType";
                        break;
                    case 75:
                        objArr[0] = "kotlinType";
                        break;
                    case 78:
                    case 82:
                        objArr[0] = "projectionType";
                        break;
                    case 79:
                    case 83:
                    case 85:
                        objArr[0] = "argument";
                        break;
                    case 80:
                        objArr[0] = "annotations";
                        break;
                    case 101:
                        objArr[0] = "typeConstructor";
                        break;
                    case 112:
                        objArr[0] = "classDescriptor";
                        break;
                    case 161:
                        objArr[0] = "declarationDescriptor";
                        break;
                    default:
                        objArr[0] = "storageManager";
                        break;
                }
                if (i5 != 11) {
                    objArr[1] = "getBuiltInsPackageScope";
                } else if (i5 == 13) {
                    objArr[1] = "getBuiltInClassByFqName";
                } else if (i5 == 15) {
                    objArr[1] = "getBuiltInClassByName";
                } else if (i5 == 69) {
                    objArr[1] = "getArrayElementType";
                } else if (i5 == 74) {
                    objArr[1] = "getPrimitiveArrayKotlinType";
                } else if (i5 == 81 || i5 == 84) {
                    objArr[1] = "getArrayType";
                } else if (i5 == 86) {
                    objArr[1] = "getEnumType";
                } else if (i5 != 87) {
                    switch (i5) {
                        case 3:
                            objArr[1] = "getAdditionalClassPartsProvider";
                            break;
                        case 4:
                            objArr[1] = "getPlatformDependentDeclarationFilter";
                            break;
                        case 5:
                            objArr[1] = "getClassDescriptorFactories";
                            break;
                        case 6:
                            objArr[1] = "getStorageManager";
                            break;
                        case 7:
                            objArr[1] = "getBuiltInsModule";
                            break;
                        case 8:
                            objArr[1] = "getBuiltInPackagesImportedByDefault";
                            break;
                        default:
                            switch (i5) {
                                case 18:
                                    objArr[1] = "getSuspendFunction";
                                    break;
                                case 19:
                                    objArr[1] = "getKFunction";
                                    break;
                                case 20:
                                    objArr[1] = "getKSuspendFunction";
                                    break;
                                case 21:
                                    objArr[1] = "getKClass";
                                    break;
                                case 22:
                                    objArr[1] = "getKType";
                                    break;
                                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                    objArr[1] = "getKCallable";
                                    break;
                                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                    objArr[1] = "getKProperty";
                                    break;
                                case 25:
                                    objArr[1] = "getKProperty0";
                                    break;
                                case 26:
                                    objArr[1] = "getKProperty1";
                                    break;
                                case 27:
                                    objArr[1] = "getKProperty2";
                                    break;
                                case 28:
                                    objArr[1] = "getKMutableProperty0";
                                    break;
                                case R$styleable.Toolbar_titleTextColor /* 29 */:
                                    objArr[1] = "getKMutableProperty1";
                                    break;
                                case 30:
                                    objArr[1] = "getKMutableProperty2";
                                    break;
                                case 31:
                                    objArr[1] = "getIterator";
                                    break;
                                case 32:
                                    objArr[1] = "getIterable";
                                    break;
                                case 33:
                                    objArr[1] = "getMutableIterable";
                                    break;
                                case 34:
                                    objArr[1] = "getMutableIterator";
                                    break;
                                case 35:
                                    objArr[1] = "getCollection";
                                    break;
                                case 36:
                                    objArr[1] = "getMutableCollection";
                                    break;
                                case 37:
                                    objArr[1] = "getList";
                                    break;
                                case 38:
                                    objArr[1] = "getMutableList";
                                    break;
                                case 39:
                                    objArr[1] = "getSet";
                                    break;
                                case 40:
                                    objArr[1] = "getMutableSet";
                                    break;
                                case 41:
                                    objArr[1] = "getMap";
                                    break;
                                case 42:
                                    objArr[1] = "getMutableMap";
                                    break;
                                case 43:
                                    objArr[1] = "getMapEntry";
                                    break;
                                case 44:
                                    objArr[1] = "getMutableMapEntry";
                                    break;
                                case 45:
                                    objArr[1] = "getListIterator";
                                    break;
                                case 46:
                                    objArr[1] = "getMutableListIterator";
                                    break;
                                default:
                                    switch (i5) {
                                        case 48:
                                            objArr[1] = "getBuiltInTypeByClassName";
                                            break;
                                        case 49:
                                            objArr[1] = "getNothingType";
                                            break;
                                        case 50:
                                            objArr[1] = "getNullableNothingType";
                                            break;
                                        case 51:
                                            objArr[1] = "getAnyType";
                                            break;
                                        case 52:
                                            objArr[1] = "getNullableAnyType";
                                            break;
                                        case 53:
                                            objArr[1] = "getDefaultBound";
                                            break;
                                        default:
                                            switch (i5) {
                                                case 55:
                                                    objArr[1] = "getPrimitiveKotlinType";
                                                    break;
                                                case 56:
                                                    objArr[1] = "getNumberType";
                                                    break;
                                                case 57:
                                                    objArr[1] = "getByteType";
                                                    break;
                                                case 58:
                                                    objArr[1] = "getShortType";
                                                    break;
                                                case 59:
                                                    objArr[1] = "getIntType";
                                                    break;
                                                case 60:
                                                    objArr[1] = "getLongType";
                                                    break;
                                                case 61:
                                                    objArr[1] = "getFloatType";
                                                    break;
                                                case 62:
                                                    objArr[1] = "getDoubleType";
                                                    break;
                                                case Function.ALT_CONVENTION /* 63 */:
                                                    objArr[1] = "getCharType";
                                                    break;
                                                case Function.THROW_LAST_ERROR /* 64 */:
                                                    objArr[1] = "getBooleanType";
                                                    break;
                                                case 65:
                                                    objArr[1] = "getUnitType";
                                                    break;
                                                case 66:
                                                    objArr[1] = "getStringType";
                                                    break;
                                                case 67:
                                                    objArr[1] = "getIterableType";
                                                    break;
                                                default:
                                                    objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    objArr[1] = "getAnnotationType";
                }
                switch (i5) {
                    case 1:
                        objArr[2] = "setBuiltInsModule";
                        break;
                    case 2:
                        objArr[2] = "setPostponedBuiltinsModuleComputation";
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 11:
                    case 13:
                    case 15:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case Function.ALT_CONVENTION /* 63 */:
                    case Function.THROW_LAST_ERROR /* 64 */:
                    case 65:
                    case 66:
                    case 67:
                    case 69:
                    case 74:
                    case 81:
                    case 84:
                    case 86:
                    case 87:
                        break;
                    case 9:
                        objArr[2] = "isBuiltIn";
                        break;
                    case 10:
                        objArr[2] = "isUnderKotlinPackage";
                        break;
                    case 12:
                        objArr[2] = "getBuiltInClassByFqName";
                        break;
                    case 14:
                        objArr[2] = "getBuiltInClassByName";
                        break;
                    case 16:
                        objArr[2] = "getPrimitiveClassDescriptor";
                        break;
                    case 17:
                        objArr[2] = "getPrimitiveArrayClassDescriptor";
                        break;
                    case 47:
                        objArr[2] = "getBuiltInTypeByClassName";
                        break;
                    case 54:
                        objArr[2] = "getPrimitiveKotlinType";
                        break;
                    case 68:
                        objArr[2] = "getArrayElementType";
                        break;
                    case 70:
                        objArr[2] = "getArrayElementTypeOrNull";
                        break;
                    case 71:
                    case 72:
                        objArr[2] = "getElementTypeForUnsignedArray";
                        break;
                    case 73:
                        objArr[2] = "getPrimitiveArrayKotlinType";
                        break;
                    case 75:
                        objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                        break;
                    case 76:
                    case 93:
                        objArr[2] = "getPrimitiveType";
                        break;
                    case 77:
                        objArr[2] = "getPrimitiveArrayType";
                        break;
                    case 78:
                    case 79:
                    case 80:
                    case 82:
                    case 83:
                        objArr[2] = "getArrayType";
                        break;
                    case 85:
                        objArr[2] = "getEnumType";
                        break;
                    case 88:
                        objArr[2] = "isArray";
                        break;
                    case 89:
                    case 90:
                        objArr[2] = "isArrayOrPrimitiveArray";
                        break;
                    case 91:
                        objArr[2] = "isPrimitiveArray";
                        break;
                    case 92:
                        objArr[2] = "getPrimitiveArrayElementType";
                        break;
                    case 94:
                        objArr[2] = "isPrimitiveType";
                        break;
                    case 95:
                        objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                        break;
                    case 96:
                        objArr[2] = "isPrimitiveClass";
                        break;
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                        objArr[2] = "isConstructedFromGivenClass";
                        break;
                    case 101:
                    case 102:
                        objArr[2] = "isTypeConstructorForGivenClass";
                        break;
                    case 103:
                    case 104:
                        objArr[2] = "classFqNameEquals";
                        break;
                    case 105:
                    case 106:
                        objArr[2] = "isNotNullConstructedFromGivenClass";
                        break;
                    case 107:
                        objArr[2] = "isSpecialClassWithNoSupertypes";
                        break;
                    case 108:
                    case 109:
                        objArr[2] = "isAny";
                        break;
                    case 110:
                    case 112:
                        objArr[2] = "isBoolean";
                        break;
                    case 111:
                        objArr[2] = "isBooleanOrNullableBoolean";
                        break;
                    case 113:
                        objArr[2] = "isNumber";
                        break;
                    case 114:
                        objArr[2] = "isChar";
                        break;
                    case 115:
                        objArr[2] = "isCharOrNullableChar";
                        break;
                    case 116:
                        objArr[2] = "isInt";
                        break;
                    case R$styleable.AppCompatTheme_windowActionBar /* 117 */:
                        objArr[2] = "isByte";
                        break;
                    case 118:
                        objArr[2] = "isLong";
                        break;
                    case 119:
                        objArr[2] = "isLongOrNullableLong";
                        break;
                    case 120:
                        objArr[2] = "isShort";
                        break;
                    case 121:
                        objArr[2] = "isFloat";
                        break;
                    case 122:
                        objArr[2] = "isFloatOrNullableFloat";
                        break;
                    case 123:
                        objArr[2] = "isDouble";
                        break;
                    case 124:
                        objArr[2] = "isUByte";
                        break;
                    case 125:
                        objArr[2] = "isUShort";
                        break;
                    case 126:
                        objArr[2] = "isUInt";
                        break;
                    case 127:
                        objArr[2] = "isULong";
                        break;
                    case 128:
                        objArr[2] = "isUByteArray";
                        break;
                    case 129:
                        objArr[2] = "isUShortArray";
                        break;
                    case 130:
                        objArr[2] = "isUIntArray";
                        break;
                    case 131:
                        objArr[2] = "isULongArray";
                        break;
                    case 132:
                        objArr[2] = "isUnsignedArrayType";
                        break;
                    case 133:
                        objArr[2] = "isDoubleOrNullableDouble";
                        break;
                    case 134:
                    case 135:
                        objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                        break;
                    case ModuleDescriptor.MODULE_VERSION /* 136 */:
                        objArr[2] = "isNothing";
                        break;
                    case 137:
                        objArr[2] = "isNullableNothing";
                        break;
                    case 138:
                        objArr[2] = "isNothingOrNullableNothing";
                        break;
                    case 139:
                        objArr[2] = "isAnyOrNullableAny";
                        break;
                    case 140:
                        objArr[2] = "isNullableAny";
                        break;
                    case 141:
                        objArr[2] = "isDefaultBound";
                        break;
                    case 142:
                        objArr[2] = "isUnit";
                        break;
                    case 143:
                        objArr[2] = "mayReturnNonUnitValue";
                        break;
                    case 144:
                        objArr[2] = "isUnitOrNullableUnit";
                        break;
                    case 145:
                        objArr[2] = "isBooleanOrSubtype";
                        break;
                    case 146:
                        objArr[2] = "isMemberOfAny";
                        break;
                    case 147:
                    case 148:
                        objArr[2] = "isEnum";
                        break;
                    case 149:
                    case 150:
                        objArr[2] = "isComparable";
                        break;
                    case 151:
                        objArr[2] = "isCollectionOrNullableCollection";
                        break;
                    case 152:
                        objArr[2] = "isListOrNullableList";
                        break;
                    case 153:
                        objArr[2] = "isSetOrNullableSet";
                        break;
                    case 154:
                        objArr[2] = "isMapOrNullableMap";
                        break;
                    case 155:
                        objArr[2] = "isIterableOrNullableIterable";
                        break;
                    case 156:
                        objArr[2] = "isThrowableOrNullableThrowable";
                        break;
                    case 157:
                        objArr[2] = "isThrowable";
                        break;
                    case 158:
                        objArr[2] = "isKClass";
                        break;
                    case 159:
                        objArr[2] = "isNonPrimitiveArray";
                        break;
                    case 160:
                        objArr[2] = "isCloneable";
                        break;
                    case 161:
                        objArr[2] = "isDeprecated";
                        break;
                    case 162:
                        objArr[2] = "isNotNullOrNullableFunctionSupertype";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (i5 != 11 && i5 != 13 && i5 != 15 && i5 != 69 && i5 != 74 && i5 != 81 && i5 != 84 && i5 != 86 && i5 != 87) {
                    switch (i5) {
                        default:
                            switch (i5) {
                                default:
                                    switch (i5) {
                                        default:
                                            switch (i5) {
                                                case 55:
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                case 62:
                                                case Function.ALT_CONVENTION /* 63 */:
                                                case Function.THROW_LAST_ERROR /* 64 */:
                                                case 65:
                                                case 66:
                                                case 67:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                            throw new IllegalStateException(format);
                                    }
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case R$styleable.Toolbar_titleTextColor /* 29 */:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                case 46:
                                    break;
                            }
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i6 = 2;
            Object[] objArr2 = new Object[i6];
            switch (i5) {
            }
            if (i5 != 11) {
            }
            switch (i5) {
            }
            String format2 = String.format(str, objArr2);
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
            Object[] objArr22 = new Object[i6];
            switch (i5) {
            }
            if (i5 != 11) {
            }
            switch (i5) {
            }
            String format22 = String.format(str, objArr22);
            if (i5 != 11) {
            }
            throw new IllegalStateException(format22);
        }
        i6 = 2;
        Object[] objArr222 = new Object[i6];
        switch (i5) {
        }
        if (i5 != 11) {
        }
        switch (i5) {
        }
        String format222 = String.format(str, objArr222);
        if (i5 != 11) {
        }
        throw new IllegalStateException(format222);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KotlinBuiltIns(StorageManager storageManager) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        this.storageManager = storageManager;
        this.builtInPackagesImportedByDefault = storageManager.createLazyValue(new Function0<Collection<PackageViewDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.1
            @Override // kotlin.jvm.functions.Function0
            public Collection<PackageViewDescriptor> invoke() {
                return Arrays.asList(KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.getBuiltInsModule().getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
            }
        });
        this.primitives = storageManager.createLazyValue(new Function0<Primitives>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.2
            @Override // kotlin.jvm.functions.Function0
            public Primitives invoke() {
                EnumMap enumMap = new EnumMap(PrimitiveType.class);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (PrimitiveType primitiveType : PrimitiveType.values()) {
                    SimpleType builtInTypeByClassName = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getTypeName().asString());
                    SimpleType builtInTypeByClassName2 = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getArrayTypeName().asString());
                    enumMap.put((EnumMap) primitiveType, (PrimitiveType) builtInTypeByClassName2);
                    hashMap.put(builtInTypeByClassName, builtInTypeByClassName2);
                    hashMap2.put(builtInTypeByClassName2, builtInTypeByClassName);
                }
                return new Primitives(enumMap, hashMap, hashMap2);
            }
        });
        this.builtInClassesByName = storageManager.createMemoizedFunction(new Function1<Name, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.3
            @Override // kotlin.jvm.functions.Function1
            public ClassDescriptor invoke(Name name) {
                ClassifierDescriptor mo3720getContributedClassifier = KotlinBuiltIns.this.getBuiltInsPackageScope().mo3720getContributedClassifier(name, NoLookupLocation.FROM_BUILTINS);
                if (mo3720getContributedClassifier != null) {
                    if (mo3720getContributedClassifier instanceof ClassDescriptor) {
                        return (ClassDescriptor) mo3720getContributedClassifier;
                    }
                    throw new AssertionError("Must be a class descriptor " + name + ", but was " + mo3720getContributedClassifier);
                }
                throw new AssertionError("Built-in class " + StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name) + " is not found");
            }
        });
    }

    private static boolean classFqNameEquals(ClassifierDescriptor classifierDescriptor, FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(103);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(104);
        }
        return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(DescriptorUtils.getFqName(classifierDescriptor));
    }

    private ClassDescriptor getBuiltInClassByName(String str) {
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        ClassDescriptor invoke = this.builtInClassesByName.invoke(Name.identifier(str));
        if (invoke == null) {
            $$$reportNull$$$0(15);
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SimpleType getBuiltInTypeByClassName(String str) {
        if (str == null) {
            $$$reportNull$$$0(47);
        }
        SimpleType defaultType = getBuiltInClassByName(str).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(48);
        }
        return defaultType;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        ClassId classId;
        ClassId unsignedClassIdByArrayClassId;
        ClassDescriptor findClassAcrossModuleDependencies;
        if (kotlinType == null) {
            $$$reportNull$$$0(71);
        }
        if (moduleDescriptor == null) {
            $$$reportNull$$$0(72);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor == null) {
            return null;
        }
        UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
        if (!unsignedTypes.isShortNameOfUnsignedArray(mo3718getDeclarationDescriptor.getName()) || (classId = DescriptorUtilsKt.getClassId(mo3718getDeclarationDescriptor)) == null || (unsignedClassIdByArrayClassId = unsignedTypes.getUnsignedClassIdByArrayClassId(classId)) == null || (findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, unsignedClassIdByArrayClassId)) == null) {
            return null;
        }
        return findClassAcrossModuleDependencies.getDefaultType();
    }

    public static PrimitiveType getPrimitiveArrayElementType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(92);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor == null) {
            return null;
        }
        return getPrimitiveArrayType(mo3718getDeclarationDescriptor);
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(77);
        }
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(16);
        }
        return getBuiltInClassByName(primitiveType.getTypeName().asString());
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(76);
        }
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static boolean isAny(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(108);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.any);
    }

    public static boolean isAnyOrNullableAny(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(139);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.any);
    }

    public static boolean isArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(88);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(89);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.array) || getPrimitiveArrayType(classDescriptor) != null;
    }

    public static boolean isBoolean(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(110);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._boolean);
    }

    public static boolean isBuiltIn(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        return DescriptorUtils.getParentOfType(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
    }

    private static boolean isConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(97);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(98);
        }
        return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(134);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(135);
        }
        return isConstructedFromGivenClass(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
    }

    public static boolean isDefaultBound(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(141);
        }
        return isNullableAny(kotlinType);
    }

    public static boolean isDeprecated(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(161);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated)) {
            return true;
        }
        if (!(declarationDescriptor instanceof PropertyDescriptor)) {
            return false;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
        boolean isVar = propertyDescriptor.isVar();
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        if (getter != null && isDeprecated(getter)) {
            if (!isVar) {
                return true;
            }
            if (setter != null && isDeprecated(setter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKClass(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(158);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.kClass);
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(105);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(106);
        }
        return !kotlinType.isMarkedNullable() && isConstructedFromGivenClass(kotlinType, fqNameUnsafe);
    }

    public static boolean isNothing(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(ModuleDescriptor.MODULE_VERSION);
        }
        return isNothingOrNullableNothing(kotlinType) && !TypeUtils.isNullableType(kotlinType);
    }

    public static boolean isNothingOrNullableNothing(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(138);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.nothing);
    }

    public static boolean isNullableAny(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(140);
        }
        return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
    }

    public static boolean isPrimitiveArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(91);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        return (mo3718getDeclarationDescriptor == null || getPrimitiveArrayType(mo3718getDeclarationDescriptor) == null) ? false : true;
    }

    public static boolean isPrimitiveClass(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(96);
        }
        return getPrimitiveType(classDescriptor) != null;
    }

    public static boolean isPrimitiveType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(94);
        }
        return !kotlinType.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(kotlinType);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(95);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        return (mo3718getDeclarationDescriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) mo3718getDeclarationDescriptor);
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(107);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.any) || classFqNameEquals(classDescriptor, StandardNames.FqNames.nothing);
    }

    public static boolean isString(KotlinType kotlinType) {
        return kotlinType != null && isNotNullConstructedFromGivenClass(kotlinType, StandardNames.FqNames.string);
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor typeConstructor, FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(101);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(102);
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = typeConstructor.mo3718getDeclarationDescriptor();
        return (mo3718getDeclarationDescriptor instanceof ClassDescriptor) && classFqNameEquals(mo3718getDeclarationDescriptor, fqNameUnsafe);
    }

    public static boolean isUByteArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(128);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(130);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(131);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(129);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(10);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isUnit(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(142);
        }
        return isNotNullConstructedFromGivenClass(kotlinType, StandardNames.FqNames.unit);
    }

    public static boolean isUnsignedArrayType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(132);
        }
        return isUByteArray(kotlinType) || isUShortArray(kotlinType) || isUIntArray(kotlinType) || isULongArray(kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createBuiltInsModule(boolean z5) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = moduleDescriptorImpl;
        moduleDescriptorImpl.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), z5));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.builtInsModule;
        moduleDescriptorImpl2.setDependencies(moduleDescriptorImpl2);
    }

    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            $$$reportNull$$$0(3);
        }
        return none;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public SimpleType getAnyType() {
        SimpleType defaultType = getAny().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(51);
        }
        return defaultType;
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public KotlinType getArrayElementType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(68);
        }
        KotlinType arrayElementTypeOrNull = getArrayElementTypeOrNull(kotlinType);
        if (arrayElementTypeOrNull != null) {
            return arrayElementTypeOrNull;
        }
        throw new IllegalStateException("not array: " + kotlinType);
    }

    public KotlinType getArrayElementTypeOrNull(KotlinType kotlinType) {
        KotlinType elementTypeForUnsignedArray;
        if (kotlinType == null) {
            $$$reportNull$$$0(70);
        }
        if (isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                return null;
            }
            return kotlinType.getArguments().get(0).getType();
        }
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        SimpleType simpleType = this.primitives.invoke().kotlinArrayTypeToPrimitiveKotlinType.get(makeNotNullable);
        if (simpleType != null) {
            return simpleType;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor containingModuleOrNull = DescriptorUtils.getContainingModuleOrNull(makeNotNullable);
        if (containingModuleOrNull == null || (elementTypeForUnsignedArray = getElementTypeForUnsignedArray(makeNotNullable, containingModuleOrNull)) == null) {
            return null;
        }
        return elementTypeForUnsignedArray;
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType, Annotations annotations) {
        if (variance == null) {
            $$$reportNull$$$0(78);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(79);
        }
        if (annotations == null) {
            $$$reportNull$$$0(80);
        }
        SimpleType simpleNotNullType = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), getArray(), Collections.singletonList(new TypeProjectionImpl(variance, kotlinType)));
        if (simpleNotNullType == null) {
            $$$reportNull$$$0(81);
        }
        return simpleNotNullType;
    }

    public SimpleType getBooleanType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(64);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(12);
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), fqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName == null) {
            $$$reportNull$$$0(13);
        }
        return resolveClassByFqName;
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule == null) {
            this.builtInsModule = this.postponedBuiltInsModule.invoke();
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(7);
        }
        return moduleDescriptorImpl;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope = getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            $$$reportNull$$$0(11);
        }
        return memberScope;
    }

    public SimpleType getByteType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(57);
        }
        return primitiveKotlinType;
    }

    public SimpleType getCharType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(63);
        }
        return primitiveKotlinType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (singletonList == null) {
            $$$reportNull$$$0(5);
        }
        return singletonList;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(35);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public SimpleType getDefaultBound() {
        SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType == null) {
            $$$reportNull$$$0(53);
        }
        return nullableAnyType;
    }

    public SimpleType getDoubleType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(62);
        }
        return primitiveKotlinType;
    }

    public SimpleType getFloatType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(61);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getFunction(int i5) {
        return getBuiltInClassByName(StandardNames.getFunctionName(i5));
    }

    public SimpleType getIntType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(21);
        }
        return builtInClassByFqName;
    }

    public SimpleType getLongType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(60);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    public SimpleType getNothingType() {
        SimpleType defaultType = getNothing().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(49);
        }
        return defaultType;
    }

    public SimpleType getNullableAnyType() {
        SimpleType makeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(52);
        }
        return makeNullableAsSpecified;
    }

    public SimpleType getNullableNothingType() {
        SimpleType makeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(50);
        }
        return makeNullableAsSpecified;
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public SimpleType getNumberType() {
        SimpleType defaultType = getNumber().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(56);
        }
        return defaultType;
    }

    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            $$$reportNull$$$0(4);
        }
        return noPlatformDependent;
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(73);
        }
        SimpleType simpleType = this.primitives.invoke().primitiveTypeToArrayKotlinType.get(primitiveType);
        if (simpleType == null) {
            $$$reportNull$$$0(74);
        }
        return simpleType;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(54);
        }
        SimpleType defaultType = getPrimitiveClassDescriptor(primitiveType).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(55);
        }
        return defaultType;
    }

    public SimpleType getShortType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(58);
        }
        return primitiveKotlinType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        return storageManager;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public SimpleType getStringType() {
        SimpleType defaultType = getString().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(66);
        }
        return defaultType;
    }

    public ClassDescriptor getSuspendFunction(int i5) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(i5))));
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(18);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public SimpleType getUnitType() {
        SimpleType defaultType = getUnit().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(65);
        }
        return defaultType;
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(1);
        }
        this.storageManager.compute(new Function0<Void>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.4
            @Override // kotlin.jvm.functions.Function0
            public Void invoke() {
                if (KotlinBuiltIns.this.builtInsModule == null) {
                    KotlinBuiltIns.this.builtInsModule = moduleDescriptorImpl;
                    return null;
                }
                throw new AssertionError("Built-ins module is already set: " + KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + moduleDescriptorImpl + ")");
            }
        });
    }

    public static boolean isArrayOrPrimitiveArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(90);
        }
        return isArray(kotlinType) || isPrimitiveArray(kotlinType);
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(82);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(83);
        }
        SimpleType arrayType = getArrayType(variance, kotlinType, Annotations.Companion.getEMPTY());
        if (arrayType == null) {
            $$$reportNull$$$0(84);
        }
        return arrayType;
    }
}
