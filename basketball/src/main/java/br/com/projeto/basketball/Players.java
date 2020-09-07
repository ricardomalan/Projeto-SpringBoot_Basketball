package br.com.projeto.basketball;

public abstract class Players {

    private String nameTeam;
    private String namePlayer;
    private String position;
    private Integer powerShoot;

    public Players(String nameTeam, String namePlayer, String position, Integer powerShoot) {
        this.nameTeam = nameTeam;
        this.namePlayer = namePlayer;
        this.position = position;
        this.powerShoot = powerShoot;
    }

    public abstract Double calculateRealShoot();

    public String getNameTeam() {
        return nameTeam;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public String getPosition() {
        return position;
    }

    public Integer getPowerShoot() {
        return powerShoot;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPowerShoot(Integer powerShoot) {
        this.powerShoot = powerShoot;
    }

    @Override
    public String toString() {
        return "\nPlayers" +
                "\nNome do time: " + nameTeam + '\'' +
                "\nNome do jogador: " + namePlayer + '\'' +
                "\nPosição: " + position + '\'' +
                "\nPower Shoot: " + powerShoot;
    }
}
