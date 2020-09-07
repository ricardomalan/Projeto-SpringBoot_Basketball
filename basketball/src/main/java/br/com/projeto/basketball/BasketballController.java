package br.com.projeto.basketball;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basketball")
public class BasketballController {

    private List<Players> allPlayers;
    private List<Players> allTimeTeam = new ArrayList<Players>();
    private List<Players> currentTeam = new ArrayList<Players>();

    public BasketballController() {
        allPlayers = new ArrayList<Players>();
        allPlayers.add(new AllTimeTeam("Lakers", "Magic Johnson", "PG", 92));
        allPlayers.add(new CurrentTeam("Warriors", "Stephen Curry", "PG", 96));
    }

    @GetMapping
    public ResponseEntity showAllPlayers() {
        if (allPlayers.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(allPlayers);
    }

    @GetMapping("/alltimeteam")
    public ResponseEntity showAllTimeTeam() {
        for (Players players : allPlayers) {
            if (players instanceof AllTimeTeam) {
                allTimeTeam.add(players);
            }
        }
        if (allTimeTeam.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allTimeTeam);
    }

    @GetMapping("/alltimeteam/{id}")
    public ResponseEntity showPlayerAllTimeTeam(@PathVariable int id) {
        for (Players players : allPlayers) {
            if (players instanceof AllTimeTeam) {
                allTimeTeam.add(players);
            }
        }
        if (allTimeTeam.size() >= id) {
            return ResponseEntity.ok(allTimeTeam.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/currentteam")
    public ResponseEntity showCurrentTeam() {
        for (Players players : allPlayers) {
            if (players instanceof CurrentTeam) {
                currentTeam.add(players);
            }
        }
        if (currentTeam.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(currentTeam);
    }

    @GetMapping("/currentteam/{id}")
    public ResponseEntity showPlayerCurrentTeam(@PathVariable int id) {
        for (Players players : allPlayers) {
            if (players instanceof CurrentTeam) {
                currentTeam.add(players);
            }
        }
        if (currentTeam.size() >= id) {
            return ResponseEntity.ok(currentTeam.get(id-1));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/alltimeteam")
    public ResponseEntity createAllTimePlayer(@RequestBody AllTimeTeam newAlltimePlayer) {
        allPlayers.add(newAlltimePlayer);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/currentteam")
    public ResponseEntity createCurrentPlayer(@RequestBody CurrentTeam newCurrentPlayer) {
        allPlayers.add(newCurrentPlayer);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlayer(@PathVariable int id) {
        if (id > 0) {
            if (allPlayers.size() >= id) {
                allPlayers.remove(--id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
