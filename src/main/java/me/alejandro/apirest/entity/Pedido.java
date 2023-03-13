package me.alejandro.apirest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@Column
	private int id;
	@Column
	private double cantidad;
	@Column
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name="id_cliente")
	@JsonManagedReference
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_comercial")
    @JsonManagedReference
    private Comercial comercial;

    public Pedido() {
    	
    }
	public Pedido(int id, double cantidad, Date fecha, Cliente cliente, Comercial comercial) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.cliente = cliente;
		this.comercial = comercial;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Comercial getComercial() {
		return comercial;
	}
	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

}
