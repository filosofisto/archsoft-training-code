# TypeScript

## Importante
- ng install -g typescript [Instalar TypeScript]
- tsc compile-error.ts [Compilar arquivo compile-error.ts]
- npm install -g tsun [Instalar REPL - Read Eval Print Loop]

## tsun
Alguns comandos para inserir no tsun:
- var fullname: string = 'Socrates';
- var age: number = 36;
- var married: boolean = true;
- var jobs: Array<string> = ['IBM', 'Microsoft', 'Google'];
- var jobs: string[] = ['IBM', 'Microsoft', 'Google'];
- enum Role {Employee, Manager, Admin}; //primeiro item tem valor 0, mas eh possivel definir outro valor
- enum Role {Employee = 3, Manager, Admin};
- var role: Role = Role.Employee;
- enum Role {Employee = 3, Manager = 5, Admin = 7};
- var something: any = 'as string';
- something = 1;
- something = [1,2,3];