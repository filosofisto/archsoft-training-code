echo "Generate header files from Java Class"
cd target/classes
del com_archsoft_TextCase.h
javah -jni com.archsoft.TextCase
type com_archsoft_TextCase.h
#mv com_archsoft_TextCase.h ../../../stat/com_archsoft_TextCase.h
cd ..
cd ..
echo "Header gerado com sucesso"

