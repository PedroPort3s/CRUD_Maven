package entity;

public class Categoria
{
	private int _id_Categoria;
	
	public int getid_Categoria()
	{
		return this._id_Categoria;
	}
	
	public void setid_Categoria(int value)
	{
		this._id_Categoria = value;
	}

	private String _nome;
	public String getnome()
	{
		return this._nome;
	}
	public void setnome(String value)
	{
		this._nome = value;
	}

	private float _taxaDepreciacao;
	public float gettaxaDepreciacao()
	{
		return this._taxaDepreciacao;
	}
	public void settaxaDepreciacao(float value)
	{
		this._taxaDepreciacao = value;
	}

	private int _prazoDepreciacao;
	public int getprazoDepreciacao()
	{
		return this._prazoDepreciacao;
	}
	public void setprazoDepreciacao(int value)
	{
		this._prazoDepreciacao = value;
	}

	private float _percValorResidual;
	public float getpercValorResidual()
	{
		return this._percValorResidual;
	}
	public void setpercValorResidual(float value)
	{
		this._percValorResidual = value;
	}


	public Categoria(int id_Categoria_,String nome_,float taxaDepreciacao_,int prazoDepreciacao_,float percValorResidual_)
	{
		this._id_Categoria = id_Categoria_;
		this._nome = nome_;
		this._taxaDepreciacao = taxaDepreciacao_;
		this._prazoDepreciacao = prazoDepreciacao_;
		this._percValorResidual = percValorResidual_;
	}
}
