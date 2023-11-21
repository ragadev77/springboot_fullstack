package test.app.konsumen.Services;

import test.app.konsumen.Repositories.*;
import test.app.konsumen.Models.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class KonsumenService {

    @Autowired
    private KonsumenRepository konsumenRepository;

    public List<Konsumen> getAllKonsumens() {
        return konsumenRepository.findAll();
    }

    public Konsumen getKonsumenById(int id) {
        return konsumenRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Konsumen createKonsumen(Konsumen konsumen) {
        return konsumenRepository.save(konsumen);
    }

    public Konsumen updateKonsumen(int id, Konsumen konsumen) {
        Konsumen existingkonsumen = konsumenRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingkonsumen.setNama(konsumen.getNama());
        existingkonsumen.setAlamat(konsumen.getAlamat());
        existingkonsumen.setKota(konsumen.getKota());
        existingkonsumen.setProvinsi(konsumen.getProvinsi());
        existingkonsumen.setTgl_registrasi(konsumen.getTgl_registrasi());
        existingkonsumen.setStatus(konsumen.getStatus());
        return konsumenRepository.save(existingkonsumen);
    }

    public void deleteKonsumen(int id) {
        konsumenRepository.deleteById(id);
    }
}
