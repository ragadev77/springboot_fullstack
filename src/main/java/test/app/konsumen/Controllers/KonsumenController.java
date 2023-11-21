package test.app.konsumen.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import test.app.konsumen.Models.Konsumen;

import test.app.konsumen.Services.*;

@RestController
@RequestMapping("/konsumen")
public class KonsumenController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

    @Autowired
    private KonsumenService konsumenService;

    @GetMapping("/dbstatus")
    public ResponseEntity<String> checkHealth() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return ResponseEntity.ok("Database connection successful.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Database connection failed. || " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<Konsumen> getKonsumens() {
        return konsumenService.getAllKonsumens();
    }

    @GetMapping("/{id}")
    public Konsumen getKonsumen(@PathVariable int id) {
        return konsumenService.getKonsumenById(id);
    }

    @PostMapping(value="/add", consumes="application/json")
    public Konsumen createKonsumen(@RequestBody Konsumen Konsumen) {
        return konsumenService.createKonsumen(Konsumen);
    }

    @PutMapping("/update/{id}")
    public Konsumen updateKonsumen(@PathVariable int id, @RequestBody Konsumen Konsumen) {
        return konsumenService.updateKonsumen(id, Konsumen);
    }

    @DeleteMapping("/del/{id}")
    public void deleteKonsumen(@PathVariable int id) {
        konsumenService.deleteKonsumen(id);
    }
}
