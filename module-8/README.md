# Instructions

## Flutter Installation

Installation (Windows): https://flutter.dev/docs/get-started/install/windows

Running Flutter Docker

    flutter doctor

If it does not find Android Studio execute:

    flutter config --android-studio-dir="<android studio folder>"

## Dart

https://dartpad.dartlang.org

Copy & Past below code to dartpad

    addNumbers(a, b) {
    return a + b;
    }

    int addNumberI(int a, int b) {
    return a + b;
    }

    double addNumbersD(double a, double b) {
    return a + b;
    }

    num addNumbersN(num a, num b) {
    return a + b;
    }

    class Person {
    String name = '';
    int age = 0;
    
    @override
    String toString() {
        return '$name - $age';
    }
    }

    void main() {
    print('Hello!');
    print("Hello!"); // Single and double cote is equals (no difference)
    
    var sum = addNumberI(1, 3);
    print(sum);
    
    // error
    // sum = addNumbersD(1.5, 2.9);

    double sumD = addNumbersD(1.5, 2.9);
    print(sumD);
    
    Person x = new Person();
    Person p = Person();
    p.name = 'Hanna';
    p.age = 18;
    
    print(p);
    
    
    //   print(addNumbers(1, 3));  
    //   print(addNumbersD(1, 3.4));
    //   print(addNumbersN(1, 3.4));
    }

## Projects

- first_from_console
- first_flutter_app
- first_material
- first_scaffold
- i_am_rich
- personal_card | personal_card2
- dicee