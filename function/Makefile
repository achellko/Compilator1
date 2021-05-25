
ANTLR=../antlr-4.2.2-complete.jar

all: generate compile test

generate:
	java -jar '/home/sexy/Downloads/antlr-4.9.2-complete.jar' -o output Demo.g4

compile:
	javac -cp '/home/sexy/Downloads/antlr-4.9.2-complete.jar':output:. Main.java

test:
	java -cp javac -cp '/home/sexy/Downloads/antlr-4.9.2-complete.jar':output:. Main test.x > test.ll
	lli test.ll

parsetree: generate
	java -cp $(ANTLR):output:. org.antlr.v4.runtime.misc.TestRig Demo prog -gui test.x

clean:
	rm test.ll
	rm *.class
	rm -rf output

