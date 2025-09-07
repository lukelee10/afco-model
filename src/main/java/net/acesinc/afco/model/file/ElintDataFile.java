/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.file;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jeremytaylor
 */
@Document(collection = "dataFile")
public class ElintDataFile extends DataFile {}
