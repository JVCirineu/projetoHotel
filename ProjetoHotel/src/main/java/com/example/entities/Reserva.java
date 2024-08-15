package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
	
	private String dataCheckin;
	
	private String horaCheckin;
	
	private String dataCheckout;
	
	private String horaCheckout;
	
	@ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
	
	@ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;
}
