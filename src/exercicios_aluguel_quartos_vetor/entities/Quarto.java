package exercicios_aluguel_quartos_vetor.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Quarto {
	
	private String name;
	private Integer numQuarto;
	private Integer quantQuartosVazio;	
	private Double valorDiaria;
	private Double valorTotal;
	private Date dataEntrada;
	private Date dataSaida;
	private Integer quantDias;
	private static Integer quantQuartos = 20;
	public  Quarto[] vect = new Quarto[quantQuartos];	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
	public Quarto() {
	}
	
	public Quarto(String name, Integer numQuarto, Date dataEntrada, Integer quantDias) {
		super();
		this.name = name;
		this.numQuarto = numQuarto;
		this.valorDiaria = valorQuarto(numQuarto);
		this.dataEntrada = dataEntrada;
		this.quantDias = quantDias;
		this.setDataSaida(diaSaida(quantDias));
		this.valorTotal = valorTotal();
	}
	
	public double valorTotal() {
		double valorTotal;
		
		valorTotal = this.quantDias * this.valorDiaria;
		
		return valorTotal;
	}
	
	public Date diaSaida(Integer quantDias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDataEntrada());
		cal.add(Calendar.DAY_OF_YEAR, quantDias);
		
		setDataSaida(cal.getTime());
		
		return getDataSaida();
		
	}
	
	public boolean quantQuartosVazios() {
		
		for(int i = 1; i <= quantQuartos;i++) {
			if(vect[i] == null) {return true;}
		}
		return false;
	}
	
	public String valorPorQuartoVazio() {
		setQuantQuartosVazio(0);
		String valorPorQuarto = "";
		for(int i = 1;i < quantQuartos;i++) {
			if(vect[i] == null) {
				valorPorQuarto += String.format("\nQuarto %d - Valor %.2f", i,valorQuarto(i));
				setQuantQuartosVazio(getQuantQuartosVazio()+1);
			}
		}
		
		if(valorPorQuarto.equals("")) {
			valorPorQuarto = "Não há vagas";
		}
		return "Valor Por Quarto Vazio:\n"+valorPorQuarto;
	}
	
	private Double valorQuarto(int numQuarto) {
		Double valor;
		
		if(numQuarto <3) {
			valor = 2.9;
		}else if(numQuarto == 4) {
			valor = 150.90;
		}else if(numQuarto <8) {
			valor = 9.0;
		}else {
			valor = 1.0;
		}
		
		return valor;
	}
	
	public String mostraQuartosVazio() {
		String a = "Quartos Vazios: ";
		for(int y = 1; y < quantQuartos;y++) {
			if(vect[y] == null) {
				 a += String.format(" %s, ", y);
			}
		}
		a = a.substring(0, a.lastIndexOf(","));
		return a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public int getQuantQuartos() {
		return quantQuartos;
	}

	public void setQuantQuartos(int quantQuartos) {
		Quarto.quantQuartos = quantQuartos;
	}

	public Integer getQuantQuartosVazio() {
		return quantQuartosVazio;
	}

	public void setQuantQuartosVazio(Integer quantQuartosVazio) {
		this.quantQuartosVazio = quantQuartosVazio;
	}

	public Integer getQuantDias() {
		return quantDias;
	}

	public void setQuantDias(Integer quantDias) {
		this.quantDias = quantDias;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}


	@Override
	public String toString() {
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return "Quarto [name=" + name + ", numQuarto=" + numQuarto + ", valorDiaria= R$ " + String.format("%.2f", valorDiaria) + ", DateEntrada="+ sdf.format(dataEntrada) +", DataSaida=" +sdf.format(dataSaida)+ ", quantiDias=" +quantDias+ ", valorTotal= R$," +String.format("%.2f", valorTotal)+ "]";
	}
}
