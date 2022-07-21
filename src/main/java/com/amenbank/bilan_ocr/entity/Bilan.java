package com.amenbank.bilan_ocr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bilan")
@Data
public class Bilan {
    @Id
    @Column(name = "matricule", length = 64)
    private String matricule;

    @Column(name = "created_At", nullable = false)
    private Date createAt;

    @Column(name = "rs", nullable = false, length = 64)
    private String rs;

    @Column(name = "year", nullable = false, length = 4)
    private int year;

    // Immobilisation Incorporelles
    @Column(name = "immo_inc", nullable = false)
    private long immoInc;

    // Amortissements Immo Inco
    @Column(name = "ammortissements_immo_inco", nullable = false)
    private long ammortissementsImmoInco;

    // Immo Corporelles
    @Column(name = "immo_corp", nullable = false)
    private long immoCorp;

    // Amortissement imm corporelles
    @Column(name = "ammortissements_immo_corp", nullable = false)
    private long ammortissementsImmoCorp;

    // Immo Financières
    @Column(name = "immo_financieres", nullable = false)
    private long immoFinancieres;

    // Provisions sur Imm Financières
    @Column(name = "prov_immo_financiere", nullable = false)
    private long provImmoFinanciere;

    // Autres actifs non courant
    @Column(name = "autre_actifs_non_courant", nullable = false)
    private long autreActifsNonCourant;

    // Stocks
    @Column(name = "stocks", nullable = false)
    private long stocks;

    // Provisions sur stock
    @Column(name = "prov_stocks", nullable = false)
    private long provStocks;

    // Clients et comptes rattachés
    @Column(name = "clt_compte_rattache", nullable = false)
    private long cltCompteRattache;

    // Provisions sur les clients
    @Column(name = "prov_clt", nullable = false)
    private long provClt;

    // Autres actifs courants
    @Column(name = "autre_actifs_courants", nullable = false)
    private long autreActifsCourants;

    // Placements et autres actifs financiers
    @Column(name = "placements_autres_actifs_financiers", nullable = false)
    private long placementsAutresActifsFinanciers;

    // Liquidités
    @Column(name = "liquidite", nullable = false)
    private long liquidite;

    // Capital
    @Column(name = "capital", nullable = false)
    private long capital;

    // Réserves
    @Column(name = "reserves", nullable = false)
    private long reserves;

    // Autres capitaux propres
    @Column(name = "autres_capitaux_propes", nullable = false)
    private long autresCapitauxPropes;

    // Résultats reportés
    @Column(name = "resultat_reportes", nullable = false)
    private long resultatReportes;

    // Résultat de l'exercice
    @Column(name = "resultat_exercice", nullable = false)
    private long resultatExercie;

    // Emprunts
    @Column(name = "emprunts", nullable = false)
    private long emprunts;

    // Autres passifs financiers
    @Column(name = "autres_passifs_financiers", nullable = false)
    private long autresPassifsFinanciers;

    // Provisions sur passifs non courants
    @Column(name = "prov_passifs_non_courants", nullable = false)
    private long provPassifsNonCourants;

    // Fournisseurs
    @Column(name = "fournisseurs", nullable = false)
    private long fournisseurs;

    // Autres passifs courants
    @Column(name = "autres_passifs_courants", nullable = false)
    private long autresPassifsCourants;

    // Concours bancaires
    @Column(name = "concours_bancaires", nullable = false)
    private long concours_bancaires;

    // Revenus
    @Column(name = "revenus", nullable = false)
    private long revenus;

    // Autres produits
    @Column(name = "autres_produits", nullable = false)
    private long autresProduits;

    // Production immobilisée
    @Column(name = "production_immobilisee", nullable = false)
    private long productionImmobilisee;

    // Variation de stock
    @Column(name = "variation_stock", nullable = false)
    private long variationStock;

    // Achat consommé
    @Column(name = "achat_consomme", nullable = false)
    private long achatConsomme;

    // Achat d'approvisionnement
    @Column(name = "achat_approv", nullable = false)
    private long achatApprov;

    // Charges de personnel
    @Column(name = "charges_personnel", nullable = false)
    private long chargesPersonnel;

    // Dotations aux amortissements
    @Column(name = "dotations_ammort", nullable = false)
    private long dotationsAmmort;

    // Autres charges d'exploitation
    @Column(name = "autres_charges_exploit", nullable = false)
    private long autresChargesExploit;

    // Charges financière
    @Column(name = "charges_financiere", nullable = false)
    private long chargesFinanciere;

    // Produits des placements
    @Column(name = "produits_placements", nullable = false)
    private long produitsPlacements;

    // Autres gains
    @Column(name = "autres_gains", nullable = false)
    private long autresGains;

    // Autres pertes
    @Column(name = "autres_pertes", nullable = false)
    private long autresPertes;

    // Impôts
    @Column(name = "impots", nullable = false)
    private long impots;

    // Eléments Extra
    @Column(name = "elements_extra", nullable = false)
    private long elementsExtra;

    // Modifications comptables
    @Column(name = "modif_comptables", nullable = false)
    private long modifComptables;
}