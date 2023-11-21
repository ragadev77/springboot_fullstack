package test.app.konsumen.Models;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "Konsumen")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Konsumen {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nama;
	private String alamat;
	private String kota;
	private String provinsi;
	private LocalDateTime tgl_registrasi;
	private String status;	
}
