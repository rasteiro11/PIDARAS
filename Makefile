Compile: Liking 
	javac Aplicacao.java
Liking: Packages
	javac -d . ./entidades/*.java ./controle/*.java
Packages: 
	javac ./entidades/*.java ./controle/*.java
