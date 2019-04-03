package com.spirit.force.gestion_des_depenses_revenus;

public class Utilisateur {
    //private int id;
    private  String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String pays;
    private  String devise;

    public Utilisateur() {
    }

    public Utilisateur( String nom, String prenom, String email, String mdp, String pays, String devise) {
       // this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.pays = pays;
        this.devise = devise;
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getPays() {
        return pays;
    }

    public String getDevise() {
        return devise;
    }

    public void setNom(String nom) {
        this.nom= nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
}
