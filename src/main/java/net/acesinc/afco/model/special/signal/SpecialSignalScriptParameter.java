package net.acesinc.afco.model.special.signal;

/**
 * ENUM for all possible placeholder parameter names for Special Signal scripts
 * that can be used in the afco-rest-service application.yml "specialSignal.scripts.parameters"
 * property. For all puppet managed environments, the property is defined in the site.pp
 * $nmpg_specialsignals_scripts_script*_parameters variables.
 */
public enum SpecialSignalScriptParameter {
    BANDWIDTH,
    BASEOUTPUTFILENAME,
    FILERETURNEDFROMSCRIPTA,
    FORMATFIELDFROMSRI,
    KEYSPEEDFROMSRI,
    SAMPLERATEFROMSRI,
    SIGIDITYPE,
    SPECIALSIGSFILE
}
