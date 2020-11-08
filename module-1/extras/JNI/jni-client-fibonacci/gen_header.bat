echo "Generate header files from Java Class"
cd target/classes
del com_archsoft_Fibonacci.h
javah -jni com.archsoft.Fibonacci
type com_archsoft_Fibonacci.h
#mv com_archsoft_Fibonacci.h ../../../stat/com_archsoft_Fibonacci.h
cd ..
cd ..
echo "Header gerado com sucesso"

