package br.com.projeto.basketball;

public class CurrentTeam extends Players {

    public CurrentTeam(String nameTeam, String namePlayer, String position, Integer powerShoot) {
        super(nameTeam, namePlayer, position, powerShoot);
    }

    @Override
    public Double calculateRealShoot() {
        return getPowerShoot() * 1.20;
    }

}
