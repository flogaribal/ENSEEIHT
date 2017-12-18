EGGJAR=./eggc-5.4.3.jar
JDIR=/usr/bin

JAVAC=$(JDIR)/javac $(JOPTS)
JAVA=$(JDIR)/java
JAR=$(JDIR)/jar
JAVADOC=$(JDIR)/javadoc


FILENAME=tests/test46
#################

all : legg compile doc exec

doc :
	mkdir doc && \
	cd doc && \
	$(JAVADOC) ../fr/n7/stl/block/ast/*.java ../fr/n7/stl/block/ast/impl/*.java \
	../fr/n7/stl/tam/ast/*.java ../fr/n7/stl/tam/ast/impl/*.java \
	../fr/n7/stl/util/*.java

legg : 
	$(JAVA) -jar $(EGGJAR) Bloc.egg

compile :
	cd egg && \
	$(JAVAC) -classpath ../$(EGGJAR):../.:. *.java&& \
	cd .. && \
	$(JAVAC) -classpath $(EGGJAR):. Main.java

exec :
	#$(JAVA) -classpath $(EGGJAR):. Main test.txt
	$(JAVA) -classpath $(EGGJAR):. Main ./$(FILENAME).bloc

clean :
	-rm Main.class
	-rm -rf egg
	-rm -rf doc
	-rm -rf fr/n7/stl/block/ast/*.class fr/n7/stl/block/ast/impl/*.class
	-rm -rf fr/n7/stl/tam/ast/*.class fr/n7/stl/tam/ast/impl/*.class
	-rm -rf fr/n7/stl/util/*.class

tam :
	cd TAM && \
	java -jar aspartam.jar  ./exemples/$(FILENAME).tam && \
	java -jar tammachine.jar ./exemples/$(FILENAME).tamo
