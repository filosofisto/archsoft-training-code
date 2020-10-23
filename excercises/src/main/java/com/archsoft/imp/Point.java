package com.archsoft.imp;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 a) Quantos construtores a sua classe possui?
 Resposta: 1 único construtor, veja classe Point.

 b) Qual a superclasse do classe Ponto?
 Resposta: A classe java.lang.Object

 c) A sua classe possui uma representação como String? Qual?
 Resposta: Sim, veja o método toString definido na classe Point;

 d) Sobrescreva o método equals(Object) para definir o que seria igualdade semântica entre duas instâncias de Ponto.
 Resposta: Veja implementaçãod o método na classe Point

 e) Acrescente a capacidade de clonagem na classe Ponto.
 Resposta: Veja implementação do método clone da classe Point

 f) Acrescente um método com a seguinte assinatura: public float distancia(Ponto). Este método deverá retornar a distância entre o ponto que está executando o método distancia e o ponto passado como parâmetro
 Resposta: Veja método distanceOf(Point) da classe Point

 g) Modele uma classe que represente um ponto geométrico tridimensional como uma especialização da classe Ponto
 Resposta: Veja classe Point3D;

 h) Modele uma classe que represente um ponto Colorido
 Resposta: Veja classe CustomPoint

 i) Como controlar a quantidade de instâncias da classe Point?
 Resposta:
 I)   Se a quantidade for limitada a uma única instancia, podemos reimplementar a classe como um singleton design pattern, preferencialmente com um único item enumerado.
 II)  Se a quantidade for limitada a um número fixo maior que um (ou mesmo dinânico), pode-se calcular o total de
 instâncias criadas centralizando a contagem das instâncias no construtor da classe. Se a quantidade for ultrapassada uma
 exceção pode ser lançada.
 III) Outra alternativa é encapsular o construtor da classe tornando-o visível apenas a partir de classe que implemente
 o design pattern Factory. Neste cenário somente a Factory teria acesso ao construtor de Point o que permitiria ela
 gerenciar o total de instâncias criadas.
 IV)  Outra alternativa seria a própria classe Point atuar como uma Factory segundo o item III)

 */


public class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public final double getX() {
		return this.x;
	}

	public final double getY() {
		return this.y;
	}

	//Este método foi colocado por exigência do exercício. Na prática eu não definiria estes métodos para os fins dessa classe
	public void setX(double x) {
		this.x = x;
	}

	//Este método foi colocado por exigência do exercício. Na prática eu não definiria estes métodos para os fins dessa classe
	public void setY(double y) {
		this.y = y;
	}

	public double distanceOf(Point p) {
		if (p == null)
			throw new NullPointerException("Unable to use null point for distanceOf method");
		return sqrt(pow((x - p.x), 2) + pow((y - p.y), 2));
	}

	@Override
	public Object clone() {
		return new Point(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}


final class Point3D extends Point {
	private double z;

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	public final double getZ() {
		return z;
	}

	//Este método foi colocado por exigência do exercício. Na prática eu não definiria este método para os fins dessa classe
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double distanceOf(Point p) {
		if (this == p)
			return 0;
		if (getClass() != p.getClass())
			throw new IllegalArgumentException("Method must be a Point3D instance class");
		Point3D o = (Point3D)p;
		return sqrt(pow((getX() - o.getX()), 2) + pow((getY() - o.getY()), 2) + pow((z - o.z), 2));
	}

	@Override
	public Object clone() {
		return new Point3D(getX(), getY(), z);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + z + ")";
	}

}


final class Color {
	private int red, green, blue;

	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}

	@Override
	public Object clone() {
		return new Color(red, green, blue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + green;
		result = prime * result + red;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (blue != other.blue)
			return false;
		if (green != other.green)
			return false;
		if (red != other.red)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + red + "," + green + "," + blue + "]";
	}
}

final class CustomPoint extends Point {

	private Color color;

	public CustomPoint(double x, double y, Color color) {
		super(x, y);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public Object clone() {
		return new CustomPoint(getX(), getY(), color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomPoint other = (CustomPoint) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

}


