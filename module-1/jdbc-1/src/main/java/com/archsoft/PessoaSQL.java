package com.archsoft;

public enum PessoaSQL {

	INSERT("INSERT INTO public.pessoas(cpf,nome,idade) VALUES(?,?,?)"),
	UPDATE("UPDATE public.pessoas SET nome=?,idade=? WHERE (cpf=?)"),
	DELETE("DELETE FROM public.pessoas WHERE cpf=?"),
	READ("SELECT * FROM public.pessoas WHERE cpf=?"),
	LIST("SELECT * FROM public.pessoas ORDER BY nome");
	
	private String sql;
	
	PessoaSQL(String sql) {
		this.sql = sql;
	}
	
	public String sql() {
		return sql;
	}
}
