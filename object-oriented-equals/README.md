# Object Oriented Equals
## Objetivo
- Entender o contrato que a implementacao do metodo equals deve respeitar.
- Contrato Equals
  - Consistencia: x.equals(y) => x.hashCode() == y.hashCode()
  - Consistencia Interna: Os campos utilizados para implementar o metodo equals devem ser utilizados tambem para implementar o medoto hashCode
  - Colisoes: x.hashCode() == y.hashCode() => x.equals(y) || !x.equals(y) (objetos diferentes podem ter o hashCode igual - Colisoes)
- Se sobrescrever o metodo equals entao sobrescreva tambem o metodo hashCode
- Caracteristica de uma implementacao de equals
  - Reflexiva: x.equals(x) => true
  - Simetrica: x.equals(y) => y.equals(x)
  - Transitiva: x.equals(y) && y.equals(z) => x.equals(z)
  - Nao randomico: nao deve ter comportamento randomico