package warriors.engine;

public abstract class LocalHero implements warriors.contracts.Hero {
    protected String nom;
    protected String image;
    protected int niveauVie;
    protected int niveauAttaque;
    protected Arme arme;
    protected Sort sort;
    protected int id;

    public LocalHero() {
    }

    public LocalHero(String nomWarrior, String imageWarrior, int niveauVieWarrior, int niveauAttaqueWarrior, int identifiant) {
        id = identifiant;
        nom = nomWarrior;
        image = imageWarrior;
        niveauVie = niveauVieWarrior;
        niveauAttaque = niveauAttaqueWarrior;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String getName() {
        return nom;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public int getLife() {
        return niveauVie;
    }

    public void setNiveauVie(int niveauVie) {
        this.niveauVie = niveauVie;
    }

    public void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }

    @Override
    public int getAttackLevel() {
        return niveauAttaque;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vous etes " + nom + " voici vos caracteristiques : niveau d'attaque : " + niveauAttaque + " votre niveau de vie : " + niveauVie;
    }

    public void deleteArme() {
        if (this.arme != null) {
            niveauAttaque = niveauAttaque - arme.getPointsAttaque();
        }
    }

    public void deleteSort() {
        if (this.sort != null) {
            niveauAttaque = niveauAttaque - sort.getPointsAttaque();
        }
    }

    public abstract int getMaxLife();

    public abstract int getMaxAttack();

}
