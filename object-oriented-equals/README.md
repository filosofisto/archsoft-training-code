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
## Tarefas
- Copie as classes implementadas no projeto object-oriented-1
- Implemente na classe funcionario o metodo calcBeneficio que deve rerornar o salario acrescido de 15% 
- Sobrescreva o metodo equals definindo uma semantica de igualdade entre duas instancias de Pessoa
- Sobrescreva o metodo equals definindo uma semantica de igualdade entre duas instancias de Funcionario
- Acrescente o conceito de Gerente, que eh um Funcionario com uma ajuda de custo
- Como voce implementaria o calcBeneficio para Gerente?
- Crie testes unitarios para verificar suas implementacoes 