package model.logic;

import java.util.Date;

public class Comparendo {
	private int id;
	private Date fecha;
	private String medioDete;
	private String claseDeVehiculo;
	private String tipoDeServicio;
	private String codigoInfraccion;
	private String descripcionInfraccion;
	private String localidad;
	private double longitud;
	private double latitud;
	
	public Comparendo(int id, Date fecha, String medioDete, String claseDeVehiculo, String tipoDeServicio, String codigoInfraccion,
			String descripcionInfraccion, String localidad, double longitud, double latitud) {
		this.id = id;
		this.fecha = fecha;
		this.medioDete = medioDete;
		this.claseDeVehiculo = claseDeVehiculo;
		this.tipoDeServicio = tipoDeServicio;
		this.codigoInfraccion = codigoInfraccion;
		this.descripcionInfraccion = descripcionInfraccion;
		this.localidad = localidad;
		this.longitud = longitud;
		this.latitud = latitud;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getClaseDeVehiculo() {
		return claseDeVehiculo;
	}
	public void setClaseDeVehiculo(String claseDeVehiculo) {
		this.claseDeVehiculo = claseDeVehiculo;
	}
	public String getTipoDeServicio() {
		return tipoDeServicio;
	}
	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}
	public String getCodigoInfraccion() {
		return codigoInfraccion;
	}
	public void setCodigoInfraccion(String codigoInfraccion) {
		this.codigoInfraccion = codigoInfraccion;
	}
	public String getDescripcionInfraccion() {
		return descripcionInfraccion;
	}
	public void setDescripcionInfraccion(String descripcionInfraccion) {
		this.descripcionInfraccion = descripcionInfraccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMedioDete() {
		return medioDete;
	}

	public void setMedioDete(String medioDete) {
		this.medioDete = medioDete;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public String toString() {
		return "(" + codigoInfraccion + ") (" + id + ") (" + fecha + ") (" + claseDeVehiculo + ") (" + tipoDeServicio + ") (" + localidad + ")";
	}

}
