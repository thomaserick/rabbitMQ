package com.tef.librabbitmq.dto;

import java.io.Serializable;

public class EstoqueDTO implements Serializable
{

	private String codigoProduto;
	private double quantidade;

	public String getCodigoProduto()
	{
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto)
	{
		this.codigoProduto = codigoProduto;
	}

	public double getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(double quantidade)
	{
		this.quantidade = quantidade;
	}
}
