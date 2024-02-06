package gof.comportamento.iterator.redeSocial;

import gof.comportamento.iterator.perfil.IPerfilIterator;

public interface IRedeSocial {
	IPerfilIterator estabeleceAmigosIterator(String perfilEmail);
    IPerfilIterator estabeleceConexaoIterator(String perfilEmail);
}