package me.alejandro.apirest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comercial")
public class Comercial {
	@Id
	@Column
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private double comision;
	
	@OneToMany(mappedBy="comercial")
	private List<Pedido> pedidos;

	public Comercial(int id, String nombre, String apellido1, String apellido2, double comision, List<Pedido> pedido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.comision = comision;
		this.pedidos = pedido;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public List<Pedido> getPedido() {
		return pedidos;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedidos = pedido;
	}

	@Override
	public String toString() {
		return "Comercial [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", comision=" + comision + ", pedido=" + pedidos + "]";
	}
}
