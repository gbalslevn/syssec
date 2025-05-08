package uniffi.molslinjen_shared;

import com.sun.jna.Library;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b+\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u0005H&J\b\u0010\u001a\u001a\u00020\u0005H&J\b\u0010\u001b\u001a\u00020\u0005H&J\b\u0010\u001c\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u0005H&J\b\u0010\u001f\u001a\u00020\u0005H&J\b\u0010 \u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0005H&J\b\u0010#\u001a\u00020\u0005H&J\b\u0010$\u001a\u00020\u0005H&J\b\u0010%\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0005H&J\b\u0010'\u001a\u00020\u0005H&J\b\u0010(\u001a\u00020\u0005H&J\b\u0010)\u001a\u00020\u0005H&J\b\u0010*\u001a\u00020\u0005H&J\b\u0010+\u001a\u00020\u0005H&J\b\u0010,\u001a\u00020\u0005H&J\b\u0010-\u001a\u00020\u0005H&J\b\u0010.\u001a\u00020\u0005H&J\b\u0010/\u001a\u00020\u0005H&¨\u00060"}, d2 = {"Luniffi/molslinjen_shared/IntegrityCheckingUniffiLib;", "Lcom/sun/jna/Library;", "ffi_molslinjen_shared_uniffi_contract_version", BuildConfig.FLAVOR, "uniffi_molslinjen_shared_checksum_constructor_agillichandler_new", BuildConfig.FLAVOR, "uniffi_molslinjen_shared_checksum_constructor_amountwrapper_new", "uniffi_molslinjen_shared_checksum_constructor_departurelowpricehandler_new", "uniffi_molslinjen_shared_checksum_constructor_selectseatinghandler_new", "uniffi_molslinjen_shared_checksum_constructor_selectseatinghelper_new", "uniffi_molslinjen_shared_checksum_func_constants_api_set_agillic_base_url", "uniffi_molslinjen_shared_checksum_func_constants_api_set_molslinjen_base_url", "uniffi_molslinjen_shared_checksum_func_ffi_configuration_manager", "uniffi_molslinjen_shared_checksum_func_ffi_initialize_api_authentication_bridge", "uniffi_molslinjen_shared_checksum_func_ffi_initialize_configuration", "uniffi_molslinjen_shared_checksum_func_ffi_initialize_request_parameters_bridge", "uniffi_molslinjen_shared_checksum_func_ffi_set_global_proxy_usage", "uniffi_molslinjen_shared_checksum_func_mock_amount", "uniffi_molslinjen_shared_checksum_func_mock_ferry_seat", "uniffi_molslinjen_shared_checksum_func_mock_ferry_seating_section", "uniffi_molslinjen_shared_checksum_func_set_rust_logger", "uniffi_molslinjen_shared_checksum_method_agillichandler_feedback", "uniffi_molslinjen_shared_checksum_method_agillichandler_give_consent", "uniffi_molslinjen_shared_checksum_method_agillichandler_register", "uniffi_molslinjen_shared_checksum_method_agillichandler_unregister", "uniffi_molslinjen_shared_checksum_method_agillichandler_withdraw_consent", "uniffi_molslinjen_shared_checksum_method_amountwrapper_add_charge", "uniffi_molslinjen_shared_checksum_method_amountwrapper_adding", "uniffi_molslinjen_shared_checksum_method_amountwrapper_charge_count", "uniffi_molslinjen_shared_checksum_method_amountwrapper_currency", "uniffi_molslinjen_shared_checksum_method_amountwrapper_ensure_above", "uniffi_molslinjen_shared_checksum_method_amountwrapper_monetary_amount", "uniffi_molslinjen_shared_checksum_method_amountwrapper_multiplied_by", "uniffi_molslinjen_shared_checksum_method_amountwrapper_negation", "uniffi_molslinjen_shared_checksum_method_amountwrapper_remove_charges", "uniffi_molslinjen_shared_checksum_method_apiauthenticationbridge_current_agillic_authentication", "uniffi_molslinjen_shared_checksum_method_departurelowpricehandler_get_lowest_prices", "uniffi_molslinjen_shared_checksum_method_requestparametersbridge_language", "uniffi_molslinjen_shared_checksum_method_rustloggertrait_log", "uniffi_molslinjen_shared_checksum_method_selectseatinghandler_get_floor_plan", "uniffi_molslinjen_shared_checksum_method_selectseatinghandler_reserve_seats", "uniffi_molslinjen_shared_checksum_method_selectseatinghandler_un_reserve_seats", "uniffi_molslinjen_shared_checksum_method_selectseatinghandler_update_reserved_seats", "uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat", "uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat_group", "uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_section", "uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_details", "uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_overview", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IntegrityCheckingUniffiLib extends Library {
    int ffi_molslinjen_shared_uniffi_contract_version();

    short uniffi_molslinjen_shared_checksum_constructor_agillichandler_new();

    short uniffi_molslinjen_shared_checksum_constructor_amountwrapper_new();

    short uniffi_molslinjen_shared_checksum_constructor_departurelowpricehandler_new();

    short uniffi_molslinjen_shared_checksum_constructor_selectseatinghandler_new();

    short uniffi_molslinjen_shared_checksum_constructor_selectseatinghelper_new();

    short uniffi_molslinjen_shared_checksum_func_constants_api_set_agillic_base_url();

    short uniffi_molslinjen_shared_checksum_func_constants_api_set_molslinjen_base_url();

    short uniffi_molslinjen_shared_checksum_func_ffi_configuration_manager();

    short uniffi_molslinjen_shared_checksum_func_ffi_initialize_api_authentication_bridge();

    short uniffi_molslinjen_shared_checksum_func_ffi_initialize_configuration();

    short uniffi_molslinjen_shared_checksum_func_ffi_initialize_request_parameters_bridge();

    short uniffi_molslinjen_shared_checksum_func_ffi_set_global_proxy_usage();

    short uniffi_molslinjen_shared_checksum_func_mock_amount();

    short uniffi_molslinjen_shared_checksum_func_mock_ferry_seat();

    short uniffi_molslinjen_shared_checksum_func_mock_ferry_seating_section();

    short uniffi_molslinjen_shared_checksum_func_set_rust_logger();

    short uniffi_molslinjen_shared_checksum_method_agillichandler_feedback();

    short uniffi_molslinjen_shared_checksum_method_agillichandler_give_consent();

    short uniffi_molslinjen_shared_checksum_method_agillichandler_register();

    short uniffi_molslinjen_shared_checksum_method_agillichandler_unregister();

    short uniffi_molslinjen_shared_checksum_method_agillichandler_withdraw_consent();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_add_charge();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_adding();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_charge_count();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_currency();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_ensure_above();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_monetary_amount();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_multiplied_by();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_negation();

    short uniffi_molslinjen_shared_checksum_method_amountwrapper_remove_charges();

    short uniffi_molslinjen_shared_checksum_method_apiauthenticationbridge_current_agillic_authentication();

    short uniffi_molslinjen_shared_checksum_method_departurelowpricehandler_get_lowest_prices();

    short uniffi_molslinjen_shared_checksum_method_requestparametersbridge_language();

    short uniffi_molslinjen_shared_checksum_method_rustloggertrait_log();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghandler_get_floor_plan();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghandler_reserve_seats();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghandler_un_reserve_seats();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghandler_update_reserved_seats();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_seat_group();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghelper_find_section();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_details();

    short uniffi_molslinjen_shared_checksum_method_selectseatinghelper_to_overview();
}
