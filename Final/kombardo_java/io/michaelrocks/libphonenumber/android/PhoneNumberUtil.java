package io.michaelrocks.libphonenumber.android;

import android.content.Context;
import io.michaelrocks.libphonenumber.android.internal.MatcherApi;
import io.michaelrocks.libphonenumber.android.internal.RegexBasedMatcher;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import io.michaelrocks.libphonenumber.android.metadata.DefaultMetadataDependenciesProvider;
import io.michaelrocks.libphonenumber.android.metadata.source.AssetsMetadataLoader;
import io.michaelrocks.libphonenumber.android.metadata.source.MetadataSource;
import io.michaelrocks.libphonenumber.android.metadata.source.MetadataSourceImpl;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final String ALPHANUM;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN;
    private static final String CC_STRING = "$CC";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final String FG_STRING = "$FG";
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
    private static final Pattern FIRST_GROUP_PATTERN;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN;
    private static final String NP_STRING = "$NP";
    static final Pattern PLUS_CHARS_PATTERN;
    private static final String RFC3966_DOMAINLABEL;
    private static final String RFC3966_DOMAINNAME;
    static final Pattern RFC3966_DOMAINNAME_PATTERN;
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_GLOBAL_NUMBER_DIGITS = "^\\+(\\p{Nd}|[\\-\\.\\(\\)]?)*\\p{Nd}(\\p{Nd}|[\\-\\.\\(\\)]?)*$";
    static final Pattern RFC3966_GLOBAL_NUMBER_DIGITS_PATTERN;
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PHONE_DIGIT = "(\\p{Nd}|[\\-\\.\\(\\)]?)";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String RFC3966_TOPLABEL;
    private static final String RFC3966_VISUAL_SEPARATOR = "[\\-\\.\\(\\)]?";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN;
    private static final Pattern SEPARATOR_PATTERN;
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX;
    private static final char STAR_SIGN = '*';
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN;
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN;
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final DefaultMetadataDependenciesProvider metadataDependenciesProvider;
    private final MetadataSource metadataSource;
    private volatile ShortNumberInfo shortNumberInfo;
    private final MatcherApi matcherApi = RegexBasedMatcher.create();
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        ALPHA_MAPPINGS = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        Character valueOf = Character.valueOf(STAR_SIGN);
        hashMap5.put(valueOf, valueOf);
        hashMap5.put('#', '#');
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : unmodifiableMap.keySet()) {
            hashMap6.put(Character.valueOf(Character.toLowerCase(ch.charValue())), ch);
            hashMap6.put(ch, ch);
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put((char) 65293, '-');
        hashMap6.put((char) 8208, '-');
        hashMap6.put((char) 8209, '-');
        hashMap6.put((char) 8210, '-');
        hashMap6.put((char) 8211, '-');
        hashMap6.put((char) 8212, '-');
        hashMap6.put((char) 8213, '-');
        hashMap6.put((char) 8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put((char) 12288, ' ');
        hashMap6.put((char) 8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashMap6);
        SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = ALPHA_MAPPINGS;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", BuildConfig.FLAVOR));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", BuildConfig.FLAVOR));
        String sb2 = sb.toString();
        VALID_ALPHA = sb2;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
        SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
        UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + sb2 + DIGITS + "]*";
        VALID_PHONE_NUMBER = str;
        String createExtnPattern = createExtnPattern(true);
        EXTN_PATTERNS_FOR_PARSING = createExtnPattern;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(false);
        RFC3966_GLOBAL_NUMBER_DIGITS_PATTERN = Pattern.compile(RFC3966_GLOBAL_NUMBER_DIGITS);
        String str2 = sb2 + DIGITS;
        ALPHANUM = str2;
        String str3 = "[" + str2 + "]+((\\-)*[" + str2 + "])*";
        RFC3966_DOMAINLABEL = str3;
        String str4 = "[" + sb2 + "]+((\\-)*[" + str2 + "])*";
        RFC3966_TOPLABEL = str4;
        String str5 = "^(" + str3 + "\\.)*" + str4 + "\\.?$";
        RFC3966_DOMAINNAME = str5;
        RFC3966_DOMAINNAME_PATTERN = Pattern.compile(str5);
        EXTN_PATTERN = Pattern.compile("(?:" + createExtnPattern + ")$", 66);
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(str + "(?:" + createExtnPattern + ")?", 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    }

    PhoneNumberUtil(MetadataSource metadataSource, DefaultMetadataDependenciesProvider defaultMetadataDependenciesProvider, Map<Integer, List<String>> map) {
        this.metadataSource = metadataSource;
        this.metadataDependenciesProvider = defaultMetadataDependenciesProvider;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && "001".equals(value.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else {
                this.supportedRegions.addAll(value);
            }
        }
        if (this.supportedRegions.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(map.get(1));
    }

    private static String createExtnPattern(boolean z5) {
        String str = (RFC3966_EXTN_PREFIX + extnDigits(20)) + "|" + ("[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)[:\\.．]?[  \\t,-]*" + extnDigits(20) + "#?") + "|" + ("[  \\t,]*(?:[xｘ#＃~～]|int|ｉｎｔ)[:\\.．]?[  \\t,-]*" + extnDigits(9) + "#?") + "|" + ("[- ]+" + extnDigits(6) + "#");
        if (!z5) {
            return str;
        }
        return str + "|" + ("[  \\t]*(?:,{2}|;)[:\\.．]?[  \\t,-]*" + extnDigits(15) + "#?") + "|" + ("[  \\t]*(?:,)+[:\\.．]?[  \\t,-]*" + extnDigits(9) + "#?");
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader != null) {
            DefaultMetadataDependenciesProvider defaultMetadataDependenciesProvider = new DefaultMetadataDependenciesProvider(metadataLoader);
            return createInstance(new MetadataSourceImpl(defaultMetadataDependenciesProvider.getPhoneNumberMetadataFileNameProvider(), metadataLoader, defaultMetadataDependenciesProvider.getMetadataParser()), defaultMetadataDependenciesProvider);
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static void ensureMetadataIsNonNull(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, String str) {
        if (phonemetadata$PhoneMetadata == null) {
            throw new MissingMetadataException(str);
        }
    }

    private static String extnDigits(int i5) {
        return "(\\p{Nd}{1," + i5 + "})";
    }

    private int getCountryCodeForValidRegion(String str) {
        Phonemetadata$PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion != null) {
            return metadataForRegion.getCountryCode();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    public int getCountryCodeForRegion(String str) {
        if (isValidRegionCode(str)) {
            return getCountryCodeForValidRegion(str);
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(") provided.");
        logger2.log(level, sb.toString());
        return 0;
    }

    Phonemetadata$PhoneMetadata getMetadataForRegion(String str) {
        if (!isValidRegionCode(str)) {
            return null;
        }
        Phonemetadata$PhoneMetadata metadataForRegion = this.metadataSource.getMetadataForRegion(str);
        ensureMetadataIsNonNull(metadataForRegion, "Missing metadata for region code " + str);
        return metadataForRegion;
    }

    public static PhoneNumberUtil createInstance(Context context) {
        if (context != null) {
            return createInstance(new AssetsMetadataLoader(context.getAssets()));
        }
        throw new IllegalArgumentException("context could not be null.");
    }

    private static PhoneNumberUtil createInstance(MetadataSource metadataSource, DefaultMetadataDependenciesProvider defaultMetadataDependenciesProvider) {
        if (metadataSource == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        if (defaultMetadataDependenciesProvider != null) {
            return new PhoneNumberUtil(metadataSource, defaultMetadataDependenciesProvider, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
        }
        throw new IllegalArgumentException("metadataDependenciesProvider could not be null.");
    }
}
