package com.amenbank.bilan_ocr.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BilanDto extends BilanInfo {
    protected long immoInc;
    protected long ammortissementsImmoInco;
    protected long immoCorp;
    protected long ammortissementsImmoCorp;
    protected long immoFinancieres;
    protected long provImmoFinanciere;
    protected long autreActifsNonCourant;
    protected long stocks;
    protected long provStocks;
    protected long cltCompteRattache;
    protected long provClt;
    protected long autreActifsCourants;
    protected long placementsAutresActifsFinanciers;
    protected long liquidite;
    protected long capital;
    protected long reserves;
    protected long autresCapitauxPropes;
    protected long resultatReportes;
    protected long resultatExercie;
    protected long emprunts;
    protected long autresPassifsFinanciers;
    protected long provPassifsNonCourants;
    protected long fournisseurs;
    protected long autresPassifsCourants;
    protected long concours_bancaires;
    protected long revenus;
    protected long autresProduits;
    protected long productionImmobilisee;
    protected long variationStock;
    protected long achatConsomme;
    protected long achatApprov;
    protected long chargesPersonnel;
    protected long dotationsAmmort;
    protected long autresChargesExploit;
    protected long chargesFinanciere;
    protected long produitsPlacements;
    protected long autresGains;
    protected long autresPertes;
    protected long impots;
    protected long elementsExtra;
    protected long modifComptables;
}
