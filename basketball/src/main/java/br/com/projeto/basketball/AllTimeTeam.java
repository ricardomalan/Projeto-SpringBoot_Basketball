package br.com.projeto.basketball;

public class AllTimeTeam extends Players {

    private final int EXPERIENCE; //Esse atributo é por serem mais velhos e terem jogado mais jogos

    public AllTimeTeam(String nameTeam, String namePlayer, String position, Integer powerShoot) {
        super(nameTeam, namePlayer, position, powerShoot);
        this.EXPERIENCE = 10;
    }

    @Override
    public Double calculateRealShoot() {
        return (getPowerShoot() + EXPERIENCE) * 1.20;
    }

}
