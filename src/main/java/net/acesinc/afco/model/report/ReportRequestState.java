/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.report;

/**
 *
 * @author andrewserff
 */
public enum ReportRequestState {
    RECEIVED,
    SENT_TO_REPORTING_SERVICE,
    RESPONSE_RECEIVED,
    COMPLETED,
    FAILED;
}
