package net.acesinc.afco.model.special.signal;

/*
 * OPEN and ARCHIVED are set to be removed and should no longer be used.  Currently they are here for backwards compatibility,
 * otherwise the REST service throws a 500
 */
public enum SpecialSignalStatus {
    DELETED,
    @Deprecated
    OPEN,
    @Deprecated
    ARCHIVED
}
